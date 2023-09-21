package Visitor;

import java.util.ArrayList;

import ASTnodes.Class.*;
import ASTnodes.Decl.*;
import Attributes.Attribute;
import Attributes.ClassAttribute;
import Coeffect.Coef;
import Exceptioin.SemanticException;
import Exceptioin.TypeCheckingException;
import SymbolTable.ClassSymbolTable;
import SymbolTable.SymbolTable;
import TypeDescriptor.*;

/**
 * Questa classe implementa un visitor per riempire le tabelle dei simboli
 * delle classi e dei metodi in un programma MiniJava prendendo in ingresso un AST.
 */
public class Fill_STC_STM  {
	
	private ClassSymbolTable ClassST;
	private ArrayList<String> extClass;
	
	/**
	 * Costruttore della classe Fill_STC_STM.
	 *
	 * @param listClass   Lista di classi AST nel programma.
	 * @throws TypeCheckingException se si verificano eccezioni durante il controllo dei tipi.
	 * @throws SemanticException   se si verificano eccezioni sintattiche.
	 */
	public Fill_STC_STM(ArrayList<NodeAST> listClass) throws TypeCheckingException, SemanticException 
	{
		this.ClassST=new ClassSymbolTable();
		this.visitProgram(listClass);
	}
	/**
	 * Restituisce la tabella dei simboli delle classi generata.
	 *
	 * @return La tabella dei simboli delle classi.
	 */
	public ClassSymbolTable getClassST() {
		return ClassST;
	}

	/**
	 * Aggiunge le classi e i metodi alla tabella dei simboli globale.
	 *
	 * @param listClass Lista di classi AST nel programma.
	 * @throws TypeCheckingException se si verificano eccezioni durante il controllo dei tipi.
	 * @throws SemanticException   se si verificano eccezioni sintattiche.
	 */
	private void visitProgram(ArrayList<NodeAST> listClass) throws TypeCheckingException, SemanticException 
	{
		NodeId id=null;
		//per ogni classe la aggiungo alla Symboltable globale
		for(NodeAST klass :  listClass) 
		{
			if(klass instanceof ClassDecl) 
			{
				ClassDecl c= (ClassDecl) klass;
				//prenod il NodeId della classe
				id= c.getIdClass();
				//prendo l'attributo della classe passandogli la symboltable della classe e il nome della classe ereditata e aggiungo alla symboltable
				//il nome della classe e i suoi attributi
				if(this.getClassST().lookup(id.getName())==null) 
				{
					if(c.getIdextends()!=null) 
					{
						ClassAttribute attr= new ClassAttribute(new SymbolTable(), c.getIdextends().getName());
						if(((ClassTypeDescriptor)c.getType()).isCoeff()!=Coef.NOTCOEF) 
						{
							attr.setIsCoeff(((ClassTypeDescriptor)c.getType()).isCoeff());
						}
						this.getClassST().enter(id.getName(), attr);
					}
					else 
					{
						ClassAttribute attr= new ClassAttribute(new SymbolTable(), null);
						if(((ClassTypeDescriptor)c.getType()).isCoeff()!=Coef.NOTCOEF) 
						{
							attr.setIsCoeff(((ClassTypeDescriptor)c.getType()).isCoeff());
						}
						this.getClassST().enter(id.getName(), attr);
					}
					//faccio partire una visita nella classe
					this.visitClassDecl(c);	
				}
				else 
				{
					System.err.println("La classe <"+id.getName()+"> è stata dichiarata più volte");
					throw new SemanticException(c.getLine());
				}
			}
			else if(klass instanceof MainClass)
			{
				MainClass c= (MainClass) klass;
				id= c.getIdClass();
				SymbolTable st= new SymbolTable();
				ClassAttribute attr= new ClassAttribute(st, id.getName());
				this.getClassST().enter(id.getName(), attr);
			}
		}
		/*Per ogni classe k controllo se ne estende un'alta se la classe p estesa esiste allora 
		 * aggiungerò alla symbolTable della classe k metodi e variabile della classe p*/
		for(NodeAST klass :  listClass) 
		{
			this.extClass= new ArrayList<String>();
			this.extClass.clear();
			if(klass instanceof ClassDecl) 
			{
				ClassDecl c= (ClassDecl) klass;
				//se la classe non è ancora stata visitata
				if(!this.getClassST().lookup(c.getIdClass().getName()).isVisited())
				{//se il nodo ast contiene una classe in extend
					if(c.getIdextends()!=null) 
					{//se la classe esiste nella symboltable delle classi
						if(this.getClassST().lookup(c.getIdextends().getName())!=null) 
						{//invoco la funzione che sarà ricorsiva passandogli il nome della classe e riempio this.extClass con le classi che estende la classe attuale
							this.visitExtendClass(c.getIdextends().getName(), c);															
							//per ogni classe in extClass Agggiungo partendo dall'ultima classe aggiunta la sua symboltable alla precedente
							int i= this.extClass.size()-1;
							//Segno le classi estese dalla classe
							(this.getClassST().lookup(c.getIdClass().getName())).setListofextclass(this.extClass);
							boolean flag = false;
							while(i>=0) 
							{//prendo la symboltable della stringa iesima
								SymbolTable extSymTab=this.getClassST().lookup(this.extClass.get(i)).getST();
								if(i>0) 
								{//verifico che le due symbol table siano diverse 
										for(NodeId Id: this.getClassST().lookup(this.extClass.get(i-1)).getST().getSymbolTable().keySet()) 
										{
											if(Id.getType().getClass()!=MethTypeDescriptor.class) 
											{
												if(this.SSCheckExist(new FieldDecl(Id.getType(),Id,0), extSymTab, null)) 
												{
													System.err.println("La variabile <"+Id.getName()+"> è già presente nella classe < "+ this.extClass.get(i-1) + "> quindi non può essere estesa");
													flag=true;
													throw new SemanticException(c.getLine());
												}
											}
											else 
											{
												if(this.SSCheckExist(new FieldDecl(Id.getType(),Id,0), extSymTab,(this.getClassST().lookup(this.extClass.get(i-1)).getST()))) 
												{
													System.err.println("Il Metodo <"+Id.getName()+"> è già presente nella classe < "+ this.extClass.get(i-1) + "> quindi non può essere estesa");
													flag=true;
													throw new SemanticException(c.getLine());
												}
											}
										}
										if(!flag) 
										{
											//aggiorno nella symboltable dellaclasse i+1esima la symboltable della classe iesima estesa
											for(NodeId nid: extSymTab.getSymbolTable().keySet()) 
											{
												this.getClassST().lookup(c.getIdClass().getName()).getST().enter(nid, extSymTab.lookup(nid));
											}
											for(NodeId nid: this.getClassST().lookup(c.getIdClass().getName()).getST().getSymbolTable().keySet()) 
											{
												this.getClassST().lookup(c.getIdClass().getName()).getST().enter(nid, this.getClassST().lookup(c.getIdClass().getName()).getST().lookup(nid));
											}
										}else 
										{
											System.err.println("Non è stato possibile estendere le classi a causa di nomi di variabili o metodi uguali");
											throw new SemanticException(c.getLine());
										}
								}
								else 
								{ 
										for(NodeId Id: this.getClassST().lookup(c.getIdClass().getName()).getST().getSymbolTable().keySet()) 
										{
											if(Id.getType().getClass()!=MethTypeDescriptor.class) 
											{
												if(this.SSCheckExist(new FieldDecl(Id.getType(),Id,0), extSymTab, null)) 
												{
													System.err.println("La variabile <"+Id.getName()+"> è già presente nella classe < "+ c.getIdClass().getName() + "> quindi non può essere estesa");
													flag=true;
													throw new SemanticException(c.getLine());
												}
											}
											else 
											{
												if(this.SSCheckExist(new FieldDecl(Id.getType(),Id,0), extSymTab,(this.getClassST().lookup(c.getIdClass().getName()).getST()))) 
												{
													System.err.println("Il Metodo <"+Id.getName()+"> è già presente nella classe < "+ c.getIdClass().getName() + "> quindi non può essere estesa");
													flag=true;
													throw new SemanticException(c.getLine());
												}
											}
										}
										if(!flag) 
										{
											for(NodeId nid: extSymTab.getSymbolTable().keySet()) 
											{
												this.getClassST().lookup(c.getIdClass().getName()).getST().enter(nid, extSymTab.lookup(nid));
											}
											for(NodeId nid: this.getClassST().lookup(c.getIdClass().getName()).getST().getSymbolTable().keySet()) 
											{
												this.getClassST().lookup(c.getIdClass().getName()).getST().enter(nid, this.getClassST().lookup(c.getIdClass().getName()).getST().lookup(nid));
											}
										}else 
										{
											System.err.println("Non è stato possibile estendere le classi a causa di nomi di variabili o metodi uguali");
											throw new SemanticException(c.getLine());
										}
								}i--;}}}}}}}
	
	
	
	private void visitExtendClass(String extendClass, ClassDecl c) throws SemanticException 
	{	//se extendClass è contenuta nella symboltable
		if(this.getClassST().lookup(extendClass)!=null ) 
		{//se la classe non è già presente 
			if(!this.extClass.contains(extendClass)) 
			{//setto la condizione di visited a true
				this.getClassST().lookup(extendClass).setVisited(true);
				//aggiungo la classe corrente alla lista delle classi
				this.extClass.add(extendClass);
				//se la classe ne estende un'altra
				if(this.getClassST().lookup(extendClass).getExtendClass()!=null) 
				{// visito la classe che estende 
					this.visitExtendClass(this.getClassST().lookup(extendClass).getExtendClass(),c);
				}
			}
			else 
			{
				System.err.println("La classe <"+extendClass+"> si estende in modo ciclico");
				throw new SemanticException(c.getLine());
			}
		}
		else 
		{
			System.err.println("La classe <"+extendClass+"> non esiste");
			throw new SemanticException(c.getLine());
		}
	}

	/**
	 * Visita una classe dichiarata.
	 *
	 * @param ctx La classe dichiarata da visitare.
	 * @throws SemanticException se si verificano eccezioni sintattiche.
	 */
	public void visitClassDecl(ClassDecl ctx) throws SemanticException 
	{
		for(FieldDecl var :ctx.getVars()) 
		{//per ogni variabile dichiarata nella classe aggiungo alla symbol della classe contenuta nella symboltable globale la variabile
			if(!this.SSCheckExist(var, this.getClassST().lookup(ctx.getIdClass().getName()).getST(), null)) 
			{
				//Assegno nella symboltable della classe il node id dellaclasse e il suo attributo che conterrà SOLO il type descriptor  il resto dei campi sarà vuoto
				(this.getClassST().lookup(ctx.getIdClass().getName())).getST().enter(var.getId(),new Attribute(var.getType()));
			}
			else 
			{
				System.err.println("La variabile <"+var.getId().getName()+"> è già presente nella classe "+ ctx.getIdClass().getName());
				throw new SemanticException(var.getLine());
			}
		}
		//per ogni metoo
		for(MethDecl met :ctx.getMets()) 
		{//faccio partire una visita del metodo
			if(!this.SSCheckExist(new FieldDecl(met.getType(),met.getId(),0), this.getClassST().lookup(ctx.getIdClass().getName()).getST(), null)) 
			{
				//istanzio gli attributi di metodo
				Attribute method= new Attribute (met.getType());
				method.setRetType(met.getRetType());
				//seto il campo dei formals nel metodo
				method.setFormals(this.visitMethodDecl(met));
				//assegno ai metodi la symbol table aggiornata
				met.getId().setType(met.getType());
				met.setType(met.getType());
				//per ogni metodo dichiarato nella classe aggiungo alla symbol della classe contenuta nella symboltable globale il metodo
				(this.getClassST().lookup(ctx.getIdClass().getName())).getST().enter(met.getId(), method);
			}
			else 
			{
				System.err.println("Il metodo <"+met.getId().getName()+"> è già presente nella classe "+ ctx.getIdClass().getName());
				throw new SemanticException(met.getLine());
			}
		}
	}
	/**
	 * Visita un metodo dichiarato.
	 *
	 * @param ctx Il metodo dichiarato da visitare.
	 * @return La Symboltable dei formals del metodo.
	 */
	public SymbolTable visitMethodDecl(MethDecl ctx)
	{
		SymbolTable st= new SymbolTable();
		for(VarDecl var :ctx.getFormals()) 
		{//assegno alla variabile st tutte le variabile contenute nell'intestanzione del metodo
			st.enter(var.getId(), new Attribute(var.getType()));
		}
		//ritorno la symboltable dei formals del metodo
		return st;
	}
	/**
	 * Verifica se una variabile esiste, controllando se in una data classe il nome di
	 * una data variabile già esiste.
	 *
	 * @param var      La variabile da cercare.
	 * @param extendor La Symboltable da esaminare.
	 * @param extended La Symboltable estesa.
	 * @return true se la variabile esiste, false altrimenti.
	 */
	private  boolean SSCheckExist(FieldDecl var, SymbolTable extendor, SymbolTable extended) 
	{      //per ogni NodeId presente nella symboltable extendor
		for(NodeId p:extendor.getSymbolTable().keySet()) 
		{//se il nome di p e di var sono uguali
			if((var.getId().getName()).equals(p.getName()) )
					{ //se sono entrambi metodi
						if(var.getType().getClass()== MethTypeDescriptor.class && p.getType().getClass() == MethTypeDescriptor.class ) 
						{//se extended non eiste allora ci si trova all'interno della stessa classe
							if(extended == null ) 
							{
								return true;
							}
							else if(((MethTypeDescriptor)(extendor.lookup(p).getType())).isStatic() || ((MethTypeDescriptor)(extended.lookup(var.getId())).getType()).isStatic())
							{
								boolean st1=((MethTypeDescriptor)(extendor.lookup(p).getType())).isStatic() ;
								boolean st2=((MethTypeDescriptor)(extended.lookup(var.getId())).getType()).isStatic();
								if((st1 == true && st2==true) || (st1 == true && st2 == false) || (st1 == false && st2 == true) ) 
								{
									return true;
								}
							}//se ritornano lo stesso tipo
							else if(p.getType().getClass()== var.getType().getClass())
							{
								SymbolTable extendFormals= (extendor.lookup(p).getFormals());//iesima
								SymbolTable extendorFormals= (extended.lookup(var.getId()).getFormals());//i-1esima
								//se hanno la stessa dimensione
								if(extendFormals.getSymbolTable().size()== extendorFormals.getSymbolTable().size()) 
								{  
									if(extendFormals.getSymbolTable().size() == 0 ) 
									{
										return false;
									}
									ArrayList<TypeDescriptor> aar= new ArrayList<TypeDescriptor>() ;
									ArrayList<TypeDescriptor> arr=new ArrayList<TypeDescriptor>();
									//se l'ordine dei tipi è il medesimo e sono gli stessi
									for(NodeId id : extendorFormals.getSymbolTable().keySet()) 
									{
										arr.add(id.getType());
									}
									for(NodeId id : extendFormals.getSymbolTable().keySet()) 
									{
										aar.add(id.getType());
									}
									for(int i=0; i<extendFormals.getSymbolTable().size();i++) 
									{
										if(arr.get(i).getClass()!=aar.get(i).getClass()) 
										{
											return true;
										}
									}//allora va tutto bene
									return false;
								}
							}
							return true;	
						}else if(var.getType().getClass()== MethTypeDescriptor.class && p.getType().getClass() != MethTypeDescriptor.class )
						{
							return false;
							
						}else if(var.getType().getClass()!= MethTypeDescriptor.class && p.getType().getClass() == MethTypeDescriptor.class ) 
						{
							return false;
						}
						else if(var.getType().getClass()!= MethTypeDescriptor.class && p.getType().getClass() != MethTypeDescriptor.class ) 
						{
							return true;
						}
					}
		}
		return false;	
	}
}

