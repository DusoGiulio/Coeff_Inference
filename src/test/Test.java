package test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.ArrayList;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ClassInstanceCreation;
import org.eclipse.jdt.core.dom.MethodInvocation;

import typeChecking.Exceptioin.*;
import coeffectChecking.CoeffDefinitioinCheck;
import coeffectChecking.Coeffect.*;
import parser.ASTGenerator;
import parser.ANTLR4.miniJavaLexer;
import parser.ANTLR4.miniJavaParser;
import parser.ANTLR4.miniJavaParser.ProgramContext;
import parser.ASTnodes.Class.NodeAST;
import typeChecking.Fill_STC_STM;
import typeChecking.TypeChecking;

class Test {
	
	@SuppressWarnings("deprecation")
	private  AST albero=  AST.newAST(AST.JLS16);

	//somma fra due classi uguali
	@org.junit.jupiter.api.Test
	void Coeffect_sum1() {
		Coeffect cf=new Coeffect( this.createMethInv("Nat", "One"),"Nat"); 
		Coeffect cf1=new Coeffect( this.createMethInv("Nat", "One"),"Nat");
		cf=cf.op(cf1, "sum");
		assertEquals( "Nat.One().sum(Nat.One())",cf.getCoefExpr().toString());	
	}
	//somma fra una classe nat e una non nat
	@org.junit.jupiter.api.Test
	void Coeffect_sum2() {
		Coeffect cf=new Coeffect( this.createMethInv("Nat", "One"),"Nat"); 
		Coeffect cf1=new Coeffect( this.createMethInv("Nat", "One"),"Nat");
		Coeffect cf2=new Coeffect( this.createNewClass("Omega"),"Omega");
		cf=cf1.op(cf2, "sum");
		assertEquals("new Omega().fromNat(Nat.One()).sum(new Omega())",cf.getCoefExpr().toString());
	}
	//somma fra una classe nat e una non nat
	@org.junit.jupiter.api.Test
	void Coeffect_sum3() {
		Coeffect cf=new Coeffect( this.createMethInv("Nat", "One"),"Nat"); 
		Coeffect cf1=new Coeffect( this.createMethInv("Nat", "One"),"Nat");
		Coeffect cf2=new Coeffect( this.createNewClass("Omega"),"Omega");
		cf=cf2.op(cf1, "sum");
		assertEquals("new Omega().sum(new Omega().fromNat(Nat.One()))",cf.getCoefExpr().toString());
	}
	//somma fra una classe non nat e una non nat
	@org.junit.jupiter.api.Test
	void Coeffect_sum4() {
		Coeffect cf=new Coeffect( this.createMethInv("Nat", "One"),"Nat");
		Coeffect cf2=new Coeffect( this.createNewClass("Omega"),"Omega");
		Coeffect cf3=new Coeffect( this.createMethInv("Affinity", "One"),"Affinity");
		cf=cf2.op(cf3, "sum");
		assertEquals( "new Triv()",cf.getCoefExpr().toString());	
	}	
	
	
	
	//moltiplico fra due classi uguali
		@org.junit.jupiter.api.Test
		void Coeffect_mult1() {
			Coeffect cf=new Coeffect( this.createMethInv("Nat", "One"),"Nat"); 
			Coeffect cf1=new Coeffect( this.createMethInv("Nat", "Zero"),"Nat");
			cf=cf.op(cf1, "mult");
			assertEquals(cf.getCoefExpr().toString(), "Nat.One().mult(Nat.Zero())");
		}
		//moltiplico fra una classe nat e una non nat
		@org.junit.jupiter.api.Test
		void Coeffect_mult2() {
			Coeffect cf=new Coeffect( this.createMethInv("Nat", "One"),"Nat"); 
			Coeffect cf1=new Coeffect( this.createMethInv("Nat", "Zero"),"Nat");
			Coeffect cf2=new Coeffect( this.createNewClass("Omega"),"Omega");
			cf=cf1.op(cf2, "mult");
			assertEquals("new Omega().fromNat(Nat.Zero()).mult(new Omega())",cf.getCoefExpr().toString());
		}
		//moltiplico fra una classe nat e una non nat
		@org.junit.jupiter.api.Test
		void Coeffect_mult3() {
			Coeffect cf=new Coeffect( this.createMethInv("Nat", "One"),"Nat"); 
			Coeffect cf1=new Coeffect( this.createMethInv("Nat", "Zero"),"Nat");
			Coeffect cf2=new Coeffect( this.createNewClass("Omega"),"Omega");
			cf=cf2.op(cf1, "mult");
			assertEquals("new Omega().mult(new Omega().fromNat(Nat.Zero()))",cf.getCoefExpr().toString());
		}
		//moltiplico fra una classe non nat e una non nat
		@org.junit.jupiter.api.Test
		void Coeffect_mult4() {
			Coeffect cf=new Coeffect( this.createMethInv("Nat", "One"),"Nat"); 
			Coeffect cf2=new Coeffect( this.createNewClass("Omega"),"Omega");
			Coeffect cf3=new Coeffect( this.createMethInv("Affinity", "One"),"Affinity");
			cf=cf2.op(cf3, "mult");
			assertEquals( "new Triv()",cf.getCoefExpr().toString());
		}
		
		
		
	//Testa i metodi di findElement, addElement 
	@org.junit.jupiter.api.Test
	void CoeffectTable_find_add() {
		CoeffectTable cft= new CoeffectTable();
		cft.addElement("a",new Coeffect( this.createMethInv("Nat", "One"),"Nat"));
		cft.addElement("b",new Coeffect( this.createMethInv("Nat", "One"),"Nat"));
		assertEquals(cft.findElement("a").getCoefExpr().toString(),"Nat.One()");
		assertNotNull(cft.findElement("a"));
		assertNull(cft.findElement("c"));
		
	}
	//Testa  se i metodi mult,sup,sum se invocati ritornino un'altro oggetto
	@org.junit.jupiter.api.Test
	void CoeffectTable_op() {
		CoeffectTable cft0= new CoeffectTable();
		CoeffectTable cft1= new CoeffectTable();
		CoeffectTable cft2= cft0.sum(cft1);
		assertNotEquals(cft2,cft0);	
	}
	
	@org.junit.jupiter.api.Test
	void ParsingError() throws TypeCheckingException, SemanticException 
	{
		FileInputStream inputStream=null;
		String sep= FileSystems.getDefault().getSeparator();
		String file="ParsingError.txt";
		String indirizzoCompleto="src"+sep+"TestText"+sep+file;
		try 
		{
			inputStream = new FileInputStream(indirizzoCompleto);
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		CharStream input=null;
		try {
			input = new  ANTLRInputStream(inputStream );
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		miniJavaLexer lexer = new miniJavaLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		tokens.fill();
		miniJavaParser parser = new miniJavaParser(tokens);
		parser.program();
		assertEquals(parser.getNumberOfSyntaxErrors(),1);
	}
	@org.junit.jupiter.api.Test
	void TypeErrorOne() throws TypeCheckingException, SemanticException 
	{
		FileInputStream inputStream=null;
		String sep= FileSystems.getDefault().getSeparator();
		String file="TypeErrorOne.txt";
		String indirizzoCompleto="src"+sep+"TestText"+sep+file;
		try 
		{
			inputStream = new FileInputStream(indirizzoCompleto);
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		CharStream input=null;
		try {
			input = new  ANTLRInputStream(inputStream );
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		miniJavaLexer lexer = new miniJavaLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		tokens.fill();
		miniJavaParser parser = new miniJavaParser(tokens);
		ProgramContext p= parser.program();
		ASTGenerator visitor= new ASTGenerator();
		ArrayList<NodeAST> AST=visitor.visitProgram(p);
		Fill_STC_STM firstvisit;
		firstvisit = new Fill_STC_STM(AST);
		TypeCheckingException exception = assertThrows(TypeCheckingException.class, () -> {
	     new TypeChecking(AST, firstvisit.getClassST());});
		assertEquals("Errore di tipo alla riga -> 15", exception.getMessage());
	}
	
	@org.junit.jupiter.api.Test
	void TypeErrorTwo() throws TypeCheckingException, SemanticException 
	{
		FileInputStream inputStream=null;
		String sep= FileSystems.getDefault().getSeparator();
		String file="TypeErrorTwo.txt";
		String indirizzoCompleto="src"+sep+"TestText"+sep+file;
		try 
		{
			inputStream = new FileInputStream(indirizzoCompleto);
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		CharStream input=null;
		try {
			input = new  ANTLRInputStream(inputStream );
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		miniJavaLexer lexer = new miniJavaLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		tokens.fill();
		miniJavaParser parser = new miniJavaParser(tokens);
		ProgramContext p= parser.program();
		ASTGenerator visitor= new ASTGenerator();
		ArrayList<NodeAST> AST=visitor.visitProgram(p);
		Fill_STC_STM firstvisit;
		firstvisit = new Fill_STC_STM(AST);
		TypeCheckingException exception = assertThrows(TypeCheckingException.class, () -> {
	     new TypeChecking(AST, firstvisit.getClassST());});
		assertEquals("Errore di tipo alla riga -> 22", exception.getMessage());
	}
	
	@org.junit.jupiter.api.Test
	void TypeErrorThree() throws TypeCheckingException, SemanticException 
	{
		FileInputStream inputStream=null;
		String sep= FileSystems.getDefault().getSeparator();
		String file="TypeErrorThree.txt";
		String indirizzoCompleto="src"+sep+"TestText"+sep+file;
		try 
		{
			inputStream = new FileInputStream(indirizzoCompleto);
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		CharStream input=null;
		try {
			input = new  ANTLRInputStream(inputStream );
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		miniJavaLexer lexer = new miniJavaLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		tokens.fill();
		miniJavaParser parser = new miniJavaParser(tokens);
		ProgramContext p= parser.program();
		ASTGenerator visitor= new ASTGenerator();
		ArrayList<NodeAST> AST=visitor.visitProgram(p);
		Fill_STC_STM firstvisit;
		firstvisit = new Fill_STC_STM(AST);
		TypeCheckingException exception = assertThrows(TypeCheckingException.class, () -> {
	     new TypeChecking(AST, firstvisit.getClassST());});
		assertEquals("Errore di tipo alla riga -> 16", exception.getMessage());
	}
	
	@org.junit.jupiter.api.Test
	void TypeErrorFour() throws TypeCheckingException, SemanticException 
	{
		FileInputStream inputStream=null;
		String sep= FileSystems.getDefault().getSeparator();
		String file="TypeErrorFour.txt";
		String indirizzoCompleto="src"+sep+"TestText"+sep+file;
		try 
		{
			inputStream = new FileInputStream(indirizzoCompleto);
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		CharStream input=null;
		try {
			input = new  ANTLRInputStream(inputStream );
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		miniJavaLexer lexer = new miniJavaLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		tokens.fill();
		miniJavaParser parser = new miniJavaParser(tokens);
		ProgramContext p= parser.program();
		ASTGenerator visitor= new ASTGenerator();
		ArrayList<NodeAST> AST=visitor.visitProgram(p);
		Fill_STC_STM firstvisit;
		firstvisit = new Fill_STC_STM(AST);
		TypeCheckingException exception = assertThrows(TypeCheckingException.class, () -> {
	     new TypeChecking(AST, firstvisit.getClassST());});
		assertEquals("Errore di tipo alla riga -> 25", exception.getMessage());
	}
	
	@org.junit.jupiter.api.Test
	void TypeErrorFive() throws TypeCheckingException, SemanticException 
	{
		FileInputStream inputStream=null;
		String sep= FileSystems.getDefault().getSeparator();
		String file="TypeErrorFive.txt";
		String indirizzoCompleto="src"+sep+"TestText"+sep+file;
		try 
		{
			inputStream = new FileInputStream(indirizzoCompleto);
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		CharStream input=null;
		try {
			input = new  ANTLRInputStream(inputStream );
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		miniJavaLexer lexer = new miniJavaLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		tokens.fill();
		miniJavaParser parser = new miniJavaParser(tokens);
		ProgramContext p= parser.program();
		ASTGenerator visitor= new ASTGenerator();
		ArrayList<NodeAST> AST=visitor.visitProgram(p);
		Fill_STC_STM firstvisit;
		firstvisit = new Fill_STC_STM(AST);
		TypeCheckingException exception = assertThrows(TypeCheckingException.class, () -> {
	     new TypeChecking(AST, firstvisit.getClassST());});
		assertEquals("Errore di tipo alla riga -> 14", exception.getMessage());
	}
	
	
	
	@org.junit.jupiter.api.Test
	void Static_method_Error() throws TypeCheckingException, SemanticException 
	{
		FileInputStream inputStream=null;
		String sep= FileSystems.getDefault().getSeparator();
		String file="StaticMethodError.txt";
		String indirizzoCompleto="src"+sep+"TestText"+sep+file;
		try 
		{
			inputStream = new FileInputStream(indirizzoCompleto);
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		CharStream input=null;
		try {
			input = new  ANTLRInputStream(inputStream );
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		miniJavaLexer lexer = new miniJavaLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		tokens.fill();
		miniJavaParser parser = new miniJavaParser(tokens);
		ProgramContext p= parser.program();
		ASTGenerator visitor= new ASTGenerator();
		ArrayList<NodeAST> AST=visitor.visitProgram(p);
		Fill_STC_STM firstvisit;
		firstvisit = new Fill_STC_STM(AST);
		SemanticException exception = assertThrows(SemanticException.class, () -> {
	     new TypeChecking(AST, firstvisit.getClassST());});
		assertEquals("Errore semantico alla riga -> 21", exception.getMessage());
		
	}
	
	@org.junit.jupiter.api.Test
	void CiclicExtends() throws TypeCheckingException, SemanticException 
	{
		FileInputStream inputStream=null;
		String sep= FileSystems.getDefault().getSeparator();
		String file="CiclicExtends.txt";
		String indirizzoCompleto="src"+sep+"TestText"+sep+file;
		try 
		{
			inputStream = new FileInputStream(indirizzoCompleto);
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		CharStream input=null;
		try {
			input = new  ANTLRInputStream(inputStream );
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		miniJavaLexer lexer = new miniJavaLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		tokens.fill();
		miniJavaParser parser = new miniJavaParser(tokens);
		ProgramContext p= parser.program();
		ASTGenerator visitor= new ASTGenerator();
		ArrayList<NodeAST> AST=visitor.visitProgram(p);;
		SemanticException exception = assertThrows(SemanticException.class, () -> {
			new Fill_STC_STM(AST);});
		assertEquals("Errore semantico alla riga -> 6", exception.getMessage());
		
	}
	
	
	@org.junit.jupiter.api.Test
	void VariableNotDeclared() throws TypeCheckingException, SemanticException 
	{
		FileInputStream inputStream=null;
		String sep= FileSystems.getDefault().getSeparator();
		String file="VariableNotDeclared.txt";
		String indirizzoCompleto="src"+sep+"TestText"+sep+file;
		try 
		{
			inputStream = new FileInputStream(indirizzoCompleto);
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		CharStream input=null;
		try {
			input = new  ANTLRInputStream(inputStream );
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		miniJavaLexer lexer = new miniJavaLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		tokens.fill();
		miniJavaParser parser = new miniJavaParser(tokens);
		ProgramContext p= parser.program();
		ASTGenerator visitor= new ASTGenerator();
		ArrayList<NodeAST> AST=visitor.visitProgram(p);;
		Fill_STC_STM firstvisit;
		firstvisit = new Fill_STC_STM(AST);
		TypeCheckingException exception = assertThrows(TypeCheckingException.class, () -> {
	     new TypeChecking(AST, firstvisit.getClassST());});
		assertEquals("Errore di tipo alla riga -> 12", exception.getMessage());
		
	}
	
	@org.junit.jupiter.api.Test
	void MethodNotDeclared() throws TypeCheckingException, SemanticException 
	{
		FileInputStream inputStream=null;
		String sep= FileSystems.getDefault().getSeparator();
		String file="MethodNotDeclared.txt";
		String indirizzoCompleto="src"+sep+"TestText"+sep+file;
		try 
		{
			inputStream = new FileInputStream(indirizzoCompleto);
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		CharStream input=null;
		try {
			input = new  ANTLRInputStream(inputStream );
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		miniJavaLexer lexer = new miniJavaLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		tokens.fill();
		miniJavaParser parser = new miniJavaParser(tokens);
		ProgramContext p= parser.program();
		ASTGenerator visitor= new ASTGenerator();
		ArrayList<NodeAST> AST=visitor.visitProgram(p);;
		Fill_STC_STM firstvisit;
		firstvisit = new Fill_STC_STM(AST);
		TypeCheckingException exception = assertThrows(TypeCheckingException.class, () -> {
	     new TypeChecking(AST, firstvisit.getClassST());});
		assertEquals("Errore di tipo alla riga -> 13", exception.getMessage());
		
	}
	
	@org.junit.jupiter.api.Test
	void ClassNotDeclared() throws TypeCheckingException, SemanticException 
	{
		FileInputStream inputStream=null;
		String sep= FileSystems.getDefault().getSeparator();
		String file="ClassNotDeclared.txt";
		String indirizzoCompleto="src"+sep+"TestText"+sep+file;
		try 
		{
			inputStream = new FileInputStream(indirizzoCompleto);
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		CharStream input=null;
		try {
			input = new  ANTLRInputStream(inputStream );
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		miniJavaLexer lexer = new miniJavaLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		tokens.fill();
		miniJavaParser parser = new miniJavaParser(tokens);
		ProgramContext p= parser.program();
		ASTGenerator visitor= new ASTGenerator();
		ArrayList<NodeAST> AST=visitor.visitProgram(p);;
		Fill_STC_STM firstvisit;
		firstvisit = new Fill_STC_STM(AST);
		TypeCheckingException exception = assertThrows(TypeCheckingException.class, () -> {
	     new TypeChecking(AST, firstvisit.getClassST());});
		assertEquals("Errore di tipo alla riga -> 90", exception.getMessage());
		
	}
	
	@org.junit.jupiter.api.Test
	void ErrorCoeffectOne() throws TypeCheckingException, SemanticException 
	{
		FileInputStream inputStream=null;
		String sep= FileSystems.getDefault().getSeparator();
		String file="ErrorCoeffectOne.txt";
		String indirizzoCompleto="src"+sep+"TestText"+sep+file;
		try 
		{
			inputStream = new FileInputStream(indirizzoCompleto);
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		CharStream input=null;
		try {
			input = new  ANTLRInputStream(inputStream );
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		miniJavaLexer lexer = new miniJavaLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		tokens.fill();
		miniJavaParser parser = new miniJavaParser(tokens);
		ProgramContext p= parser.program();
		ASTGenerator visitor= new ASTGenerator();
		ArrayList<NodeAST> AST=visitor.visitProgram(p);;
		 Fill_STC_STM firstvisit = new Fill_STC_STM(AST);
		 new TypeChecking(AST, firstvisit.getClassST());
		TypeCheckingException exception = assertThrows(TypeCheckingException.class, () -> {
			new CoeffDefinitioinCheck(AST);;});
		assertEquals("Errore dichiarazione coeffetti alla riga -> 84", exception.getMessage());
		
	}
	
	@org.junit.jupiter.api.Test
	void ErrorCoeffectTwo() throws TypeCheckingException, SemanticException 
	{
		FileInputStream inputStream=null;
		String sep= FileSystems.getDefault().getSeparator();
		String file="ErrorCoeffectTwo.txt";
		String indirizzoCompleto="src"+sep+"TestText"+sep+file;
		try 
		{
			inputStream = new FileInputStream(indirizzoCompleto);
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		CharStream input=null;
		try {
			input = new  ANTLRInputStream(inputStream );
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		miniJavaLexer lexer = new miniJavaLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		tokens.fill();
		miniJavaParser parser = new miniJavaParser(tokens);
		ProgramContext p= parser.program();
		ASTGenerator visitor= new ASTGenerator();
		ArrayList<NodeAST> AST=visitor.visitProgram(p);
		TypeCheckingException exception = assertThrows(TypeCheckingException.class, () -> {
			new CoeffDefinitioinCheck(AST);;});
		assertEquals("Errore dichiarazione coeffetti alla riga -> 57", exception.getMessage());
		
	}
	
	private MethodInvocation createMethInv(String func, String arg) 
	{
		MethodInvocation mi= albero.newMethodInvocation();
	     mi.setName(albero.newSimpleName(arg));
	     mi.setExpression(albero.newSimpleName(func));
	     return mi;
	}
	
	private ClassInstanceCreation createNewClass(String nameClass) 
	{
		ClassInstanceCreation newTriv = albero.newClassInstanceCreation();
		newTriv.setType(albero.newSimpleType(albero.newSimpleName(nameClass)));
		return newTriv;
	}

}
