package Visitor;

import java.util.ArrayList;
import java.util.ListIterator;

import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ClassInstanceCreation;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.MethodInvocation;

import ASTnodes.Class.*;
import ASTnodes.Decl.*;
import ASTnodes.Exp.*;
import ASTnodes.Exp.Boolean;
import ASTnodes.Stm.*;
import Attributes.Attribute;
import Coeffect.*;
import Exceptioin.TypeCheckingException;
import SymbolTable.ClassSymbolTable;
import TypeDescriptor.*;

/**
 * Questa classe esegue l'inferenza dei coeffetti
 */
public class CoeffInference {

	private ArrayList<NodeAST> ast;
	private ClassSymbolTable classST;
	private String ActualClass;   
	private Attribute actualMeth;  
	private  AST albero;
	private ASTParser  parser;

	/**
     * Crea un oggetto CoeffInference.
     *
     * @param ast     L'AST (Abstract Syntax Tree) da analizzare.
     * @param classST La tabella dei simboli delle classi.
     * @throws TypeCheckingException Viene lanciata se si verificano errori durante il controllo dei coeffetti.
     */
	@SuppressWarnings("deprecation")
	public CoeffInference(ArrayList<NodeAST> ast, ClassSymbolTable classST) throws TypeCheckingException {
		this.ast = ast;
		this.classST = classST;
		 albero = AST.newAST(AST.JLS16);
		 // Configura il parser AST
	    
	}

	   /**
     * Esegue l'inferenza dei coeffetti per il programma.
     *
     * @param ast L'AST (Abstract Syntax Tree) da analizzare.
     * @return La tabella dei simboli delle classi aggiornata con i coeffetti inferiti.
     * @throws TypeCheckingException Viene lanciata se si verificano errori durante il controllo dei coeffetti.
     */
	public ClassSymbolTable visitProgram(ArrayList<NodeAST> ast) throws TypeCheckingException {
		for (NodeAST klass : ast) {
			if (klass instanceof ClassDecl) {
				ClassDecl c = (ClassDecl) klass;
				if (((ClassTypeDescriptor) c.getType()).isCoeff() == Coef.NOTCOEF) {
					this.visitClass(c);
				}
			}
			if(klass instanceof MainClass) 
			{
				//System.out.println("\n\tANALISI MAIN\t\n");
				MainClass c= (MainClass) klass;
				this.visitMainClass(c);
			}
		}
		return this.getClassST();
	}
    
	private void visitMainClass(MainClass c) {
		this.classST.lookup(c.getIdClass().getName()).getST().lookup(c.getIdClass()).setCoef(this.visitExp(c.getExp()));
	}

	private void visitClass(ClassDecl c) throws TypeCheckingException {
		this.ActualClass = c.getIdClass().getName();
		for (MethDecl met : c.getMets()) {
			this.actualMeth = this.classST.lookup(c.getIdClass().getName()).getST().lookup(met.getId());
			//Inserisco all'interno degli attributi del metodo la coeffect table corrispondente
			this.classST.lookup(c.getIdClass().getName()).getST().lookup(met.getId()).setCoef(this.visitBody(met.getBody()).CTGlobal);
		}

	}

	private PairCT visitBody(Body body) {
		// setto alla coeffectTable della classe corrente e del metodo corrente l
		// coeffectTable di ritorno dalla visita del return	
		CoeffectTable CT=this.visitExp(body.getRetExp());
		PairCT PCT= new PairCT(CT.duplicate(),CT.duplicate());
		// visito ogni statement dall'ultimo al primo
		ListIterator<Stm> listiter= body.getStms().listIterator(body.getStms().size());
		while (listiter.hasPrevious()) {
				
				PCT=this.visitStm( listiter.previous(), PCT);
		}
		return PCT;
	}

	private PairCT visitStm(Stm stm, PairCT PCT) {

		if (stm instanceof ARRAYASSIGN) {
			String id = ((ARRAYASSIGN) stm).getId();
			CoeffectTable CT2 = this.visitExp(((ARRAYASSIGN) stm).getLExp());
			CoeffectTable CT3 = this.visitExp(((ARRAYASSIGN) stm).getRexp());
			CoeffectTable CT1 = CT2.sum(CT3);
			
			
			
			Coeffect idCoeffect= PCT.getCTCurrent().findElement(id);
			//Se nella tabella dei coeffetti è presente un coeffetto assegnato ad ID
			if(idCoeffect!=null) 
			{
				//Duolico il coeffetto di id in CTCurrent e CT1
				Coeffect idCoeffDup= idCoeffect.duplicate();
				//Creo il binomio di tabelle 
				PairCT CTsExp= new PairCT(CT1.duplicate().mult(idCoeffect),CT1.duplicate().mult(idCoeffDup) );
				//rimuovo id dalla CTCurrent
				PCT.getCTCurrent().removeId(id);
				return new PairCT(PCT.getCTGlobal().sum(CTsExp.getCTGlobal()),PCT.getCTCurrent().sum(CTsExp.getCTCurrent()));
			}else 
			{	
				//Seid è un campo della classe
				if (this.findAttr(id).getType() instanceof ErrorTypeDescriptor) {
				//Aggiungo a CT1 new Triv, Triv
				ClassInstanceCreation newTriv = albero.newClassInstanceCreation();
				newTriv.setType(albero.newSimpleType(albero.newSimpleName("Triv")));
				CT1= (CT1.mult(new Coeffect(newTriv, "Triv")));
				//duplico la tabella
				//ritorno la coppia di tabelle globali e correnti sommandogli CT1
				return new PairCT(CT1.duplicate().sum(PCT.getCTGlobal()),CT1.duplicate().sum(PCT.getCTCurrent()));
				}
				
				//Se id non è presente in getCurrent allora lo sommo sia a l globale che al current
				return new PairCT(CT1.duplicate().sum(PCT.getCTGlobal()),CT1.duplicate().sum(PCT.getCTCurrent()));
			}


		} else if (stm instanceof ASSIGN) {
			String id = ((ASSIGN) stm).getId();
			
			CoeffectTable CT1 = this.visitExp(((ASSIGN) stm).getLExp());
			
			
			Coeffect idCoeffect= PCT.getCTCurrent().findElement(id);
			
			//Se nella tabella dei coeffetti è presente un coeffetto assegnato ad ID
			if(idCoeffect!=null) 
			{
				//Duolico il coeffetto di id in CTCurrent e CT1
				Coeffect idCoeffDup= idCoeffect.duplicate();
				//Creo il binomio di tabelle 
				PairCT CTsExp= new PairCT(CT1.duplicate().mult(idCoeffect),CT1.duplicate().mult(idCoeffDup) );
				//rimuovo id dalla CTCurrent
				PCT.getCTCurrent().removeId(id);
				return new PairCT(PCT.getCTGlobal().sum(CTsExp.getCTGlobal()),PCT.getCTCurrent().sum(CTsExp.getCTCurrent()));
			}else 
			{	
				/*//Se id è un campo della classe
				if (this.findAttr(id).getType() instanceof ErrorTypeDescriptor) {
				//Aggiungo a CT1 new Triv, Triv
			    ClassInstanceCreation newTriv = albero.newClassInstanceCreation();
			    newTriv.setType(albero.newSimpleType(albero.newSimpleName("Triv")));
				CT1= (CT1.mult(new Coeffect(newTriv, "Triv")));
				//duplico la tabella
				//ritorno la coppia di tabelle globali e correnti sommandogli CT1
				return new PairCT(CT1.duplicate().sum(PCT.getCTGlobal()),CT1.duplicate().sum(PCT.getCTCurrent()));
				}*/
				
				//Se id non è presente in getCurrent allora lo sommo sia a l globale che al current
				return new PairCT(CT1.duplicate().sum(PCT.getCTGlobal()),CT1.duplicate().sum(PCT.getCTCurrent()));
			}

		} else if (stm instanceof IF) {
			CoeffectTable CT1 = this.visitExp(((IF) stm).getExp());
			PairCT PCTElse = this.visitStm(((IF) stm).getElsestm(), PCT);
			PairCT PCTIf = this.visitStm(((IF) stm).getIfstm(), PCT);
			
			PairCT stmElse= new PairCT(CT1.duplicate().sum(PCTElse.getCTGlobal()),CT1.duplicate().sum(PCTElse.getCTCurrent()));
			PairCT stmIf= new PairCT(CT1.duplicate().sum(PCTIf.getCTGlobal()),CT1.duplicate().sum(PCTIf.getCTCurrent()));
			
			return new PairCT(stmElse.CTGlobal.sup(stmIf.CTGlobal),stmElse.CTCurrent.sup(stmIf.CTCurrent) );
			

		} else if (stm instanceof SOP) {// ritorno dirrettamente la tabella verr� poi sommata nel body
			CoeffectTable ct= this.visitExp(((SOP)stm).getLExp());
			return new PairCT(ct.duplicate().sum(PCT.CTGlobal), ct.duplicate().sum(PCT.getCTCurrent()));

		} else if (stm instanceof WHILE) {

			return PCT;

		} else if (stm instanceof Multi) {

			PairCT ctAcc = PCT;
			ListIterator<Stm> listiter= ((Multi) stm).getStms().listIterator(((Multi) stm).getStms().size());
			while(listiter.hasPrevious()) {
				
				ctAcc = this.visitStm(listiter.previous(), ctAcc);
			}
			return ctAcc;
		}
		return null;
	}

	private CoeffectTable visitExp(Exp exp) {
		// BINOP
		if (exp instanceof BinOp) {
			return this.visitExp(((BinOp) exp).getLexp()).sum(this.visitExp(((BinOp) exp).getLexp()));
			
		}
		// UNIOP
		else if (exp instanceof UnaryOp) {
			return this.visitExp(((UnaryOp) exp).getExp());
		}
		// BOOLEAN
		else if (exp instanceof Boolean) {
			return new CoeffectTable();
		}
		// INT
		else if (exp instanceof Decimal) {
			return new CoeffectTable();
		}
		// IDENTIFIER 
		else if (exp instanceof Id) {
			CoeffectTable ct = new CoeffectTable();
			Attribute att = this.findAttr(((Id) exp).getId().getName());
			TypeDescriptor td = att.getType();
			if (td instanceof CoeffectTypeDescriptor) {
					ct.addElement(((Id) exp).getId().getName(),new Coeffect(this.createMethInv("Nat", "one"), "Nat" ));

			} else {

				ct.addElement("this", new Coeffect(this.createMethInv("Nat", "one"), "Nat"));
			}
			return ct;
		}
		// THIS
		else if (exp instanceof This) {
			CoeffectTable ct = new CoeffectTable();		
			ct.addElement("this", new Coeffect(this.createMethInv("Nat", "one"), "Nat"));
			return ct;
		}
		// ARRAY ELEM
		else if (exp instanceof ArrElem) {
			return this.visitExp(((ArrElem) exp).getExp());
		}
		// Lenght
		else if (exp instanceof Length) {
			return this.visitExp(((Length) exp).getExp());
		}
		// CAST
		else if (exp instanceof Cast) {
			return this.visitExp(((Cast) exp).getExp());
		}
		// callfunc
		else if (exp instanceof CallFuncObj) {
			// coeffecttable dell'espressione sinistra
			CoeffectTable cfThis = this.visitExp(((CallFuncObj) exp).getLexp());
			CoeffectTable cfAcc = new CoeffectTable();
			int i=0;
			
			//Prendo i formals del metodo
			ArrayList<VarDecl> Formals= new ArrayList<VarDecl>();
			for (NodeAST klass : ast) {
				if(klass instanceof ClassDecl) {
					if(((ClassDecl)klass).getIdClass().getName().equals(((CoeffectTypeDescriptor) this.getTypeDesc((cfThis.getCoeffectTable().get(0).id))).getVarType().toString())) {
						for(MethDecl m: ((ClassDecl)klass).getMets()) {
							if(m.getId().getName().equals(((CallFuncObj) exp).getId().getName())) {
								Formals = m.getFormals();
							}
						}
					}
				}
			}
			if(Formals.get(i).getId().getName().equals("this")) 
			{
				VarCoeff cft=((CoeffectTypeDescriptor)Formals.get(i).getId().getType()).getVarCoeff();
				
				 parser = ASTParser.newParser(AST.JLS16);
			     parser.setKind(ASTParser.K_EXPRESSION);
			     parser.setBindingsRecovery(true);
			     parser.setResolveBindings(true);
			     parser.setCompilerOptions(JavaCore.getOptions());
				parser.setSource(cft.getExpCoeff().toString().toCharArray());
				Expression expr = (Expression) parser.createAST(null);
				 
				cfAcc=cfThis.mult( new Coeffect(expr,cft.getClassCoeff()).supOne());
				i++;
			}
			for(int j=i;j<((CallFuncObj) exp).getRexp().size();j++) 
			{
				CoeffectTable cf = this.visitExp(((CallFuncObj) exp).getRexp().get(j));
				VarCoeff cft=((CoeffectTypeDescriptor)Formals.get(j).getId().getType()).getVarCoeff();
				
				 parser = ASTParser.newParser(AST.JLS16);
			     parser.setKind(ASTParser.K_EXPRESSION);
			     parser.setBindingsRecovery(true);
			     parser.setResolveBindings(true);
			     parser.setCompilerOptions(JavaCore.getOptions());
				 parser.setSource(cft.getExpCoeff().toString().toCharArray());
				 Expression expr = (Expression) parser.createAST(null);
				 
				cfThis=cf.mult(new Coeffect(expr,cft.getClassCoeff()).supOne());
				cfAcc=cfAcc.sum(cfThis);
			}
			return cfAcc;
		}
		// NEW
		else if (exp instanceof New) {
			if ((((New) exp).getExp() != null)) {
				return this.visitExp(((New) exp).getExp());
			} else {
				CoeffectTable ct = new CoeffectTable();
				return ct;
			}

		}
		// INSTANCEOF
		else if (exp instanceof Instanceof) {
			return this.visitExp(((Instanceof) exp).getExp());
		}
		return null;
	}

	
	private MethodInvocation createMethInv(String func, String arg) 
	{
		MethodInvocation mi= albero.newMethodInvocation();
	     mi.setName(albero.newSimpleName(arg));
	     mi.setExpression(albero.newSimpleName(func));
	     return mi;
	}
	
	private Attribute findAttr(String id) {
		for (NodeId nId : this.actualMeth.getFormals().getSymbolTable().keySet()) {
			if (nId.getName().equals(id)) {
				return this.actualMeth.getFormals().lookup(nId);
			}
		}
		for (NodeId nId : this.actualMeth.getLocal().getSymbolTable().keySet()) {
			if (nId.getName().equals(id)) {
				return this.actualMeth.getLocal().lookup(nId);
			}
		}
		return new Attribute(new ErrorTypeDescriptor(0));
	}
    /**
     * Restituisce la tabella dei simboli delle classi.
     *
     * @return La tabella dei simboli delle classi.
     */
	public ClassSymbolTable getClassST() {
		return classST;
	}

	private TypeDescriptor getTypeDesc(String id) {
		// se id è presente nella tabella delle classi allora ritorno il tipo della
		// classe
		for (NodeAST klass : ast) {
			if (klass instanceof ClassDecl) {
				ClassDecl c = (ClassDecl) klass;
				if (this.ActualClass.equals(c.getIdClass().getName())) {
					for (FieldDecl var : c.getVars()) {
						if (var.getId().getName().equals(id)) {
							return var.getType();
						}
					}
				}
			}
		}
		// controllo se la variabileid nella tabella del body
		for (NodeId var : this.actualMeth.getFormals().getSymbolTable().keySet()) {
			if (var.getType().getClass() != MethTypeDescriptor.class) {
				if (var.getName().equals(id)) {
					return var.getType();
				}
			}
		}
		// controllo seid presente nella tabella della classe
		for (NodeId var : this.actualMeth.getLocal().getSymbolTable().keySet()) {
			if (var.getType().getClass() != MethTypeDescriptor.class) {
				if (var.getName().equals(id)) {
					return var.getType();
				}
			}
		}

		return new ErrorTypeDescriptor(0);
	}
	
	public AST getAlbero() {
		return albero;
	}

	public void setAlbero(AST albero) {
		this.albero = albero;
	}

	private class PairCT {
		
		private CoeffectTable CTGlobal;
		private CoeffectTable CTCurrent;
		
		PairCT(CoeffectTable CTGlobal,CoeffectTable CTCurrent)
		{
			this.setCTCurrent(CTCurrent);
			this.setCTGlobal(CTGlobal);
		}

		public CoeffectTable getCTGlobal() {
			return CTGlobal;
		}

		public void setCTGlobal(CoeffectTable cTGlobal) {
			CTGlobal = cTGlobal;
		}

		public CoeffectTable getCTCurrent() {
			return CTCurrent;
		}

		public void setCTCurrent(CoeffectTable cTCurrent) {
			CTCurrent = cTCurrent;
		}
		
	}
}