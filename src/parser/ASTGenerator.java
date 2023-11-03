package parser;

import java.util.ArrayList;

import coeffectChecking.Coeffect.Coef;
import coeffectChecking.Coeffect.VarCoeff;
import parser.ANTLR4.miniJavaBaseVisitor;
import parser.ANTLR4.miniJavaParser.*;
import parser.ASTnodes.Class.*;
import parser.ASTnodes.Decl.*;
import parser.ASTnodes.Exp.*;
import parser.ASTnodes.Exp.Boolean;
import parser.ASTnodes.Stm.*;
import typeChecking.TypeDescriptor.*;

/**
 * Questa classe rappresenta un generatore di Abstract Syntax Tree (AST) per un linguaggio MiniJava.
 * Estende la classe `miniJavaBaseVisitor  per implementare le operazioni di visita necessarie 
 * per trasformare l'albero di parsing in un AST
 */

public class ASTGenerator extends miniJavaBaseVisitor<Object>{

	private ArrayList<NodeAST> AST;
	private boolean actualAbstract;
	private int numberOfError;
	/**
	 * Costruttore che inizializza un nuovo generatore di AST
	 */
	public ASTGenerator() 
	{
		this.setAST(new ArrayList<NodeAST>());
		this.setNumberOfError(0);
	}
	/**
	 * Ottieni l'albero sintattico
	 * @return ArrayListNodeAST che contiene l'albero sintattico
	 */
	public ArrayList<NodeAST> getAST() {
		return AST;
	}
	/**
	 * Imposta l'albero sintattico 
	 * @param aST albero sintattico in input
	 */
	public void setAST(ArrayList<NodeAST> aST) {
		AST = aST;
	}
	/**
	 * Override del metodo visitProgram ereditato dalla classe miniJavaBaseVisitor
	 * @param ctx è il primo nodo dell'albero di parsing generato da ANTLR4 
	 * @return ArrayListNodeAST che contiene l'albero sintattico
	 */
    @Override
    public ArrayList<NodeAST> visitProgram(ProgramContext ctx) {
    	//aggiungo ad AST la classe MAIN
    	this.getAST().add(this.visitMainClass(ctx.mainClass()));
    	//aggiungo tutte le classi del programma all'AST
        for (ClassDeclContext c : ctx.classDecl()) {
        	this.getAST().add(this.visitClassDecl(c));
        }
        return this.getAST();
	}  
    /**
	 * Override del metodo visitMainClass ereditato dalla classe miniJavaBaseVisitor
	 * @param ctx è il  nodo dell'albero di parsing generato da ANTLR4 che rappresenta la classe Main
	 * @return MainClass che è una specializzazione di NodeAST
	 */
    @Override
	public MainClass visitMainClass(MainClassContext ctx) {
    	//Prendo il nome che identifica la classe
		String mainIdtxt=ctx.IDENTIFIER(0).getText();
		//Instanzio un nuovo tipo di  mainClass pcon una nuova symboltable 
		//e i nomi della classe ereditata e ol tipo della classe ereditata pari a null
		ClassTypeDescriptor mainType= new ClassTypeDescriptor( mainIdtxt);
		//Prendo il nodo exp contenuto all'interno della classe main
		Exp exp= this.visitExp(ctx.exp());
		//creo un nuovo node id che identificherà il nome della classe e il suo tipo
		NodeId mainId= new NodeId(mainType,mainIdtxt);
		//ritorno un nodo mainclass
		return new MainClass(mainType,mainId,exp, ctx.IDENTIFIER(0).getSymbol().getLine());
	}
    /**
	 * Override del metodo visitMainClass ereditato dalla classe miniJavaBaseVisitor
	 * @param ctx è il  nodo dell'albero di parsing generato da ANTLR4 che rappresenta la classe Main
	 * @return MainClass che è una specializzazione di NodeAST
	 */
	@Override
	public ClassDecl visitClassDecl(ClassDeclContext ctx) {
		this.setActualAbstract(false);	
		String extendTxtClass= null;
		NodeId extendId=null;
		ClassTypeDescriptor extendTypeClass =null;
		if(ctx.IDENTIFIER(1)!=null) 
		{
			extendTxtClass=ctx.IDENTIFIER(1).getText();
			extendTypeClass= new ClassTypeDescriptor (extendTxtClass );
			extendId= new NodeId(extendTypeClass,extendTxtClass);
		}
		String classTxt = ctx.IDENTIFIER(0).getText();
		ClassTypeDescriptor ClassType= new ClassTypeDescriptor(classTxt);
		if(ctx.coefClass()!=null) 
		{
			ClassType.setCoeff(this.visitCoefClass(ctx.coefClass()));
		}
		if(ctx.ABSTRACT()!=null) 
		{
			ClassType.setIsAbstract(true);
			this.setActualAbstract(true);
		}
		NodeId classId=new NodeId(ClassType,classTxt);
		ArrayList<FieldDecl> listField =new ArrayList<FieldDecl>();
		for(FieldDeclContext var: ctx.fieldDecl()) 
		{
			listField.add(this.visitFieldDecl(var));
		}

		ArrayList<MethDecl> listMets =new ArrayList<MethDecl>();
		for(MethodDeclContext met: ctx.methodDecl()) 
		{
			MethDecl m =this.visitMethodDecl(met);
			if(m!=null) {
				if(this.getActualAbstract()==false && (((MethTypeDescriptor)m.getType()).isAbstract())==true) 
				{
					System.err.println("Errore sintattico nella classe "+ classTxt + " "+"alla linea "+m.getLine() + ", presenza di un metodo abstract in una classe non abstract ");
					this.setNumberOfError(this.getNumberOfError()+1);
					return null;
				}
				listMets.add(m);
			}
		}

		return new ClassDecl(ClassType,classId,extendId,listField,listMets,ctx.IDENTIFIER(0).getSymbol().getLine());
	}
	/**
	 * Override del metodo visitFieldDecl ereditato dalla classe miniJavaBaseVisitor
	 * @param ctx è il  nodo dell'albero di parsing generato da ANTLR4 che rappresenta una dichiarazione di un campo nella classe
	 * @return FieldDecl che è una specializzazione di NodeAST
	 */
	@Override
	public FieldDecl visitFieldDecl (FieldDeclContext ctx) {
		//---------------------------------------------------------------------------------------------//
		//prendo il nome della variabile
		String name = ctx.IDENTIFIER().getText();
		//prendo il typo della variabile
		TypeDescriptor type= this.visitType(ctx.type());
		//creo il nodo che identifica la variabile
		NodeId varId= new NodeId(type, name);
		//ritorno il nododell'AST vardecl
		return new FieldDecl(type,varId,ctx.IDENTIFIER().getSymbol().getLine());
		//---
	}
	
	
	/**
	 * Override del metodo visitFieldDecl ereditato dalla classe miniJavaBaseVisitor
	 * @param ctx è il  nodo dell'albero di parsing generato da ANTLR4 che rappresenta una dichiarazione di un campo nella classe
	 * @return FieldDecl che è una specializzazione di NodeAST
	 */
	@Override
	public VarDecl visitVarDecl(VarDeclContext ctx) {
		//---------------------------------------------------------------------------------------------//
		//prendo il nome della variabile
		String name = ctx.IDENTIFIER().getText();
		//prendo il typo della variabile
		TypeDescriptor type= this.visitTypeCoeff(ctx.typeCoeff());
		//creo il nodo che identifica la variabile
		NodeId varId= new NodeId(type, name);
		//ritorno il nododell'AST vardecl
		return new VarDecl(type,varId,ctx.IDENTIFIER().getSymbol().getLine());
		//---------------------------------------------------------------------------------------------//
	}
	
	/**
	 * Override del metodo visitVarDecl ereditato dalla classe miniJavaBaseVisitor
	 * @param ctx è il  nodo dell'albero di parsing generato da ANTLR4 che rappresenta una dichiarazione di una variabile
	 * @return VarDecl che è una specializzazione di NodeAST
	 */
	@Override
	public VarDecl  visitVarDeclp(VarDeclpContext ctx) {
		//---------------------------------------------------------------------------------------------//
		//prendo il nome della variabile
		String name= ctx.IDENTIFIER().getText();
		//prendo il typo della variabile
		TypeDescriptor type= this.visitTypeCoeff(ctx.typeCoeff());
		//creo il nodo che identifica la variabile
		NodeId varId= new NodeId(type, name);
		//ritorno il nododell'AST vardecl
		return new VarDecl(type,varId,ctx.IDENTIFIER().getSymbol().getLine());
		//---------------------------------------------------------------------------------------------//
	}
	/**
	 * Override del metodo visitTypeCoeff ereditato dalla classe miniJavaBaseVisitor
	 * @param ctx è il  nodo dell'albero di parsing generato da ANTLR4 che rappresenta una dichiarazione del tipo di una variabile  e del coeffetto di una variabile
	 * @return CoeffectTypeDescriptor che è una specializzazione di TypeDescriptor
	 */
	@Override
	public  CoeffectTypeDescriptor visitTypeCoeff(TypeCoeffContext ctx) 
	{ 
		TypeDescriptor type=this.visitType(ctx.type());
		VarCoeff varCoeff=null;
		if(ctx.coeffect()!=null) 
		{
			varCoeff= this.visitCoeffect(ctx.coeffect());
		}
		return new CoeffectTypeDescriptor(type, varCoeff);
	}
	/**
	 * Override del metodo visitCoeffect ereditato dalla classe miniJavaBaseVisitor
	 * @param ctx è il  nodo dell'albero di parsing generato da ANTLR4 che rappresenta la dichiarazione del coeffetto di una variabile
	 * @return VarCoef 
	 */
	@Override
	public VarCoeff visitCoeffect(CoeffectContext ctx) 
	{
		String idClass=ctx.IDENTIFIER().getText();
		Exp expCoeff= this.visitExp(ctx.exp());
		return new VarCoeff(expCoeff, idClass);
	}
	/**
	 * Override del metodo visitMethodDecl ereditato dalla classe miniJavaBaseVisitor
	 * @param ctx è il  nodo dell'albero di parsing generato da ANTLR4 che rappresenta la dichiarazione di un metodo
	 * @return MethDecl che è una specializzazione di NodeAST
	 */
	@Override
	public MethDecl visitMethodDecl(MethodDeclContext ctx)  {
		
		//Intestazione metodo
		//---------------------------------------------------------------------------------------------//
		boolean isAbs=false;
		if(ctx.ABSTRACT()!=null) 
		{
			 isAbs= true;
		}
		Body body= new Body(null,null,null,null);
		int ret=0;
		//Prendo il nome del metodo
		String methName= ctx.IDENTIFIER(0).getText();
		//tipo del metodo
		TypeDescriptor methRetType= this.visitType(ctx.type());
		
		//inizio gestione variabili nell'intestazione del metodo
		ArrayList<VarDecl> listVar =new ArrayList<VarDecl>();
		boolean isThis= false;
		if(ctx.THIS()!=null) 
		{
			isThis=true;
			listVar.add(new VarDecl(this.visitTypeCoeff(ctx.typeCoeff()),new NodeId(this.visitTypeCoeff(ctx.typeCoeff()),ctx.THIS().getText()),ctx.THIS().getSymbol().getLine() ));
		}
		if(ctx.typeCoeff()!=null && ctx.IDENTIFIER(1)!=null) 
		{
			listVar.add(new VarDecl(this.visitTypeCoeff(ctx.typeCoeff()),new NodeId(this.visitTypeCoeff(ctx.typeCoeff()),ctx.IDENTIFIER(1).getText()),ctx.IDENTIFIER(1).getSymbol().getLine() ));
		}

		for(VarDeclpContext var: ctx.varDeclp()) 
		{
			//aggiungo var alla lista delle variabili
			listVar.add(this.visitVarDeclp(var));
		}
		//fine gestione variabili
		//---------------------------------------------------------------------------------------------//
		//Body
		if(!isAbs) 
		{
			ret=ctx.RETURN().getSymbol().getLine();
			ArrayList<VarDecl> listVarBody =new ArrayList<VarDecl>();
			for(VarDeclContext var: ctx.varDecl()) 
			{
				//aggiungo var alla lista delle variabili
				listVarBody.add(this.visitVarDecl(var));
			}
			ArrayList<Stm> stmList= new ArrayList<Stm>();
			for(StatementContext stm: ctx.statement()) 
			{
				//aggiungo stm alla lista degli stm
				stmList.add(this.visitStatement(stm));
			}
			//creo il tipo exp per il body
			Exp exp = this.visitExp(ctx.exp());
			//creo il body del metodo
			body= new Body(null,listVarBody,stmList,exp);//null perchè non conosco ancora il tipo di ritorno effettivo del metodo
		}
		
		boolean isStatic= false;
		if(ctx.STATIC()!=null) 
		{
			isStatic=true;
		}
		if(isStatic==true && isThis==true) 
		{
			System.err.println("Errore sintattico alla linea "+ ctx.IDENTIFIER(0).getSymbol().getLine()+ " " + "Utilizzo di this in un metodo statico");
			this.setNumberOfError(this.getNumberOfError()+1);
			return null;
		}
		MethTypeDescriptor methType= new MethTypeDescriptor(isStatic,isAbs);
		//Creo il nodeId del metodo
		NodeId methId= new NodeId(methType, methName);
		//riotno il nodo del metodo
		return new MethDecl(methType,listVar,methRetType,methId,body,ctx.IDENTIFIER(0).getSymbol().getLine(),ret);
		//---------------------------------------------------------------------------------------------//
	}
	/**
	 * Override del metodo visitType ereditato dalla classe miniJavaBaseVisitor
	 * @param ctx è il  nodo dell'albero di parsing generato da ANTLR4 che rappresenta la dichiarazione del tipo di una variabile
	 * @return TypeDescriptor 
	 */
	@Override
	public TypeDescriptor visitType(TypeContext ctx) {
		//---------------------------------------------------------------------------------------------//
		// In base al tipo creo e ritorno il nodo adatto
		TypeDescriptor type =new ErrorTypeDescriptor(0);
		
		if(ctx.IDENTIFIER()!=null) 
		{
			type= new IdTypeDescriptor(ctx.IDENTIFIER().getText());
		}
		else if(ctx.INT()!=null) 
		{
			type = new IntTypeDescriptor();
		}
		else if(ctx.BOOLEAN()!=null) 
		{
			type = new BoolTypeDescriptor();
		}
		if(ctx.LBRACK()!=null) 
		{
			type= new ArrayTypeDescriptor(type);
		}
		
		return type;
		//---------------------------------------------------------------------------------------------//
	}
	/**
	 * Override del metodo visitStatement ereditato dalla classe miniJavaBaseVisitor
	 * @param ctx è il  nodo dell'albero di parsing generato da ANTLR4 che rappresenta la dichiarazione di uno statement 
	 * @return Stm che è una specializzazione di NodeAST
	 */
	@Override
	public Stm visitStatement(StatementContext ctx) {
		//---------------------------------------------------------------------------------------------//
		// in base al tipo dichiaro un nodo differente di tipo stm
		Stm stm=null;
		if(ctx.LBRACE()!=null) 
		{
			ArrayList<Stm> multiStm= new ArrayList<Stm>();
			for(StatementContext s: ctx.statement()) 
			{
				multiStm.add(this.visitStatement(s));
			}
			stm=new Multi(multiStm,ctx.LBRACE().getSymbol().getLine());
		}
		else if(ctx.IF()!=null)
		{
			Exp exp = this.visitExp(ctx.exp(0));
			Stm ifstm= this.visitStatement(ctx.statement(0));
			Stm elsestm=this.visitStatement(ctx.statement(1));
			
			stm= new IF( exp, ifstm, elsestm,ctx.IF().getSymbol().getLine());
		}
		else if(ctx.WHILE()!=null) 
		{
			Exp exp = this.visitExp(ctx.exp(0));
			Stm wstm= this.visitStatement(ctx.statement(0));
			
			stm= new WHILE(exp, wstm,ctx.WHILE().getSymbol().getLine());
		}
		else if(ctx.SOP()!=null) 
		{
			Exp exp= this.visitExp(ctx.exp(0));
			
			stm= new SOP(exp,ctx.SOP().getSymbol().getLine());
		}
		else if(ctx.IDENTIFIER()!=null) 
		{
			Exp expl = this.visitExp(ctx.exp(0));
			String id= ctx.IDENTIFIER().getText();
			Exp expr=null;

			{
				if(ctx.LBRACK()!=null) 
				{
					expr = this.visitExp(ctx.exp(1));
					stm= new ARRAYASSIGN(expl,expr,id,ctx.IDENTIFIER().getSymbol().getLine());
				}else 
				{
					stm= new ASSIGN(expl,id,ctx.IDENTIFIER().getSymbol().getLine());	
				}
			}

		}
		return stm;
		//---------------------------------------------------------------------------------------------//
	}
	/**
	 * Override del metodo visitExp ereditato dalla classe miniJavaBaseVisitor
	 * @param ctx è il  nodo dell'albero di parsing generato da ANTLR4 che rappresenta la dichiarazione di un espressione 
	 * @return Exp che è una specializzazione di NodeAST
	 */
	@Override
	public Exp visitExp(ExpContext ctx) {
		//---------------------------------------------------------------------------------------------//
		// in base al tipo dichiaro un nodo differente di tipo exp
		if(ctx==null) {return null;}
		//INSTACEOF typedescriptor id a dx, exp classe sx
		if(ctx.INSTANCEOF()!=null) 
		{
			return new Instanceof(new NodeId(new IdTypeDescriptor(ctx.IDENTIFIER().getText()),ctx.IDENTIFIER().getText()),this.visitExp(ctx.exp(0)),ctx.INSTANCEOF().getSymbol().getLine());
		}
		//UNIOP
		if( !ctx.exp().isEmpty() && ctx.BANG()!=null)
		{
			if(ctx.BANG()!=null) 
			{
				return new UnaryOp(ctx.BANG(),this.visitExp(ctx.exp(0)),ctx.BANG().getSymbol().getLine());
			}
		}
		//BINOP
		else if(ctx.MUL()!= null || ctx.DIV()!= null || ctx.ADD()!= null || ctx.SUB()!= null ||   ctx.AND()!= null || ctx.OR()!= null || ctx.GT()!= null || ctx.LT()!= null ||ctx.ASSIGN()!= null  && !ctx.exp().isEmpty()) 
		{
			Exp lexp= this.visitExp(ctx.exp(0));
			Exp rexp= this.visitExp(ctx.exp(1));
			if(ctx.ADD()!=null) 
			{
				return new BinOp(ctx.ADD(),lexp,rexp,ctx.ADD().getSymbol().getLine());
			}
			if(ctx.SUB()!=null) 
			{
				return new BinOp(ctx.SUB(),lexp,rexp,ctx.SUB().getSymbol().getLine());
			}
			if(ctx.MUL()!=null) 
			{
				return new BinOp(ctx.MUL(),lexp,rexp,ctx.MUL().getSymbol().getLine());
			}
			if(ctx.AND()!=null) 
			{
				return new BinOp(ctx.AND(),lexp,rexp,ctx.AND().getSymbol().getLine());
			}
			if(ctx.OR()!=null) 
			{
				return new BinOp(ctx.OR(),lexp,rexp,ctx.OR().getSymbol().getLine());
			}
			if(ctx.GT()!=null) 
			{
				return new BinOp(ctx.GT(),lexp,rexp,ctx.GT().getSymbol().getLine());
			}
			if(ctx.LT()!=null) 
			{
				return new BinOp(ctx.LT(),lexp,rexp,ctx.LT().getSymbol().getLine());
			}
			if(ctx.ASSIGN()!=null) 
			{
				return new BinOp(ctx.ASSIGN(),lexp,rexp,ctx.ASSIGN().getSymbol().getLine());
			}
			if(ctx.DIV()!=null) 
			{
				return new BinOp(ctx.DIV(),lexp,rexp,ctx.DIV().getSymbol().getLine());
			}
		}
		//NEW
		else if( ctx.NEW()!=null ) 
		{
			if(ctx.INT()!=null) 
			{
				if(ctx.LBRACK()!=null) 
				{
					return new New(new NodeId(new ArrayTypeDescriptor(new IntTypeDescriptor()),ctx.INT().getText()),this.visitExp(ctx.exp(0)),ctx.INT().getSymbol().getLine());
				}
				return new New(new NodeId(new IntTypeDescriptor(), ctx.INT().getText()),this.visitExp(ctx.exp(0)),ctx.INT().getSymbol().getLine());
			}
			else if(ctx.BOOLEAN()!=null) 
			{
				if(ctx.LBRACK()!=null) 
				{
					return new New(new NodeId(new ArrayTypeDescriptor(new BoolTypeDescriptor()),ctx.BOOLEAN().getText()),this.visitExp(ctx.exp(0)),ctx.BOOLEAN().getSymbol().getLine());
				}
				return new New(new NodeId(new BoolTypeDescriptor(),ctx.BOOLEAN().getText()),this.visitExp(ctx.exp(0)),ctx.BOOLEAN().getSymbol().getLine());
			}
			else if(ctx.IDENTIFIER()!=null && ctx.exp().isEmpty()) 
			{
				if(ctx.LBRACK()!=null) 
				{
					return new New(new NodeId(new ArrayTypeDescriptor(new IdTypeDescriptor(ctx.IDENTIFIER().getText())), ctx.IDENTIFIER().getText()),this.visitExp(ctx.exp(0)),ctx.IDENTIFIER().getSymbol().getLine());
				}
				return new New(new NodeId(new IdTypeDescriptor(ctx.IDENTIFIER().getText()),ctx.IDENTIFIER().getText()),this.visitExp(ctx.exp(0)),ctx.IDENTIFIER().getSymbol().getLine());
			}
			else 
			{
				return new New(new NodeId(new IdTypeDescriptor(ctx.IDENTIFIER().getText()),ctx.IDENTIFIER().getText()),null,ctx.IDENTIFIER().getSymbol().getLine());
			}
		}
		//ARRELEM accede ad un elelemnto di un array
		else if(ctx.exp(1)!=null && ctx.LBRACK()!=null && ctx.NEW()==null) 
		{
			
			return new ArrElem(this.visitExp(ctx.exp(0)),this.visitExp(ctx.exp(1)),ctx.LBRACK().getSymbol().getLine());
		}
		
		//LENGHT
		else if(ctx.LENGTH()!=null) 
		{
			return new Length(this.visitExp(ctx.exp(0)),ctx.LENGTH().getSymbol().getLine());
		}
		//PAREN
		else if(ctx.exp()!=null && ctx.LPAREN()!=null && ctx.RPAREN()!=null && ctx.IDENTIFIER()==null) 
		{
			return this.visitExp(ctx.exp(0));
		}
		//CAST
		else if(ctx.exp()!=null && ctx.LPAREN()!=null && ctx.RPAREN()!=null && ctx.IDENTIFIER()!=null && ctx.DOT()==null) 
		{
			return new Cast(this.visitExp(ctx.exp(0)),new NodeId(new IdTypeDescriptor(ctx.IDENTIFIER().getText()), ctx.IDENTIFIER().getText()),ctx.IDENTIFIER().getSymbol().getLine());
		}
		//THIS
		else if(ctx.THIS()!=null) 
		{
			return new This(ctx.THIS().getSymbol().getLine());
		}
		//chiamata a funzione da oggetto exp DOT IDENTIFIER LPAREN exp* RPAREN
		else if(ctx.IDENTIFIER()!= null && ctx.DOT()!=null) 
		{
			ArrayList<Exp> list= new ArrayList<Exp>();
			Exp expr = null;
			int i=0;
			for( @SuppressWarnings("unused") ExpContext exp:ctx.exp()) 
			{
				if(i==0)
				{
					expr=this.visitExp(ctx.exp(0));
					i=1;
				}else 
				{
					list.add(this.visitExp(ctx.exp(i)));
					i++;
				}
				
			}
			return new CallFuncObj(new NodeId(new IdTypeDescriptor(ctx.IDENTIFIER().getText()),ctx.IDENTIFIER().getText()), expr,list,ctx.IDENTIFIER().getSymbol().getLine());
		}
		//IDENTIFIER
		else if(ctx.IDENTIFIER()!=null && ctx.exp()!=null && ctx.NEW()==null) 
		{
			return new Id(new NodeId(new IdTypeDescriptor(ctx.IDENTIFIER().getText()),ctx.IDENTIFIER().getText()),ctx.IDENTIFIER().getSymbol().getLine());
		}
		//DEC_BOOL
		else if(ctx.BOOL_LITERAL()!=null || ctx.DECIMAL_LITERAL()!=null) 
		{
			if(ctx.BOOL_LITERAL()!=null) 
			{
				return new Boolean(ctx.BOOL_LITERAL().getText(),ctx.BOOL_LITERAL().getSymbol().getLine());
				
			}
			else 
			{
				return new Decimal(ctx.DECIMAL_LITERAL().getText(),ctx.DECIMAL_LITERAL().getSymbol().getLine());
			}
		}
		System.err.println("Errore");
		return null;
		//---------------------------------------------------------------------------------------------//
	}
	/**
	 * Override del metodo visitStatement ereditato dalla classe miniJavaBaseVisitor
	 * @param ctx è il  nodo dell'albero di parsing generato da ANTLR4 che rappresenta il tipo di classe se coeffetto ,non coeffetto o aggiunta di un coeffetto
	 * @return  Coef una classe enumerativa
	 */
	@Override
	public Coef visitCoefClass(CoefClassContext ctx) 
	{
		if(ctx.COEFCLASS()!=null) 
		{
			return Coef.COEFF;
		}else if(ctx.COEFSUBCLASS()!=null) 
		{
			return Coef.AUXCOEF;
		}
		return Coef.NOTCOEF;
		
	}
	public boolean getActualAbstract() {
		return this.actualAbstract;
	}
	public void setActualAbstract(boolean b) {
		this.actualAbstract = b;
	}
	public int getNumberOfError() {
		return numberOfError;
	}
	public void setNumberOfError(int numberOfError) {
		this.numberOfError = numberOfError;
	}
}
