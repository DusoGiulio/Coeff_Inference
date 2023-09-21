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

import ANTLR4.miniJavaLexer;
import ANTLR4.miniJavaParser;
import ANTLR4.miniJavaParser.ProgramContext;
import ASTnodes.Class.NodeAST;
import Coeffect.*;
import Exceptioin.SemanticException;
import Exceptioin.TypeCheckingException;
import Visitor.ASTGenerator;
import Visitor.CoeffDefinitioinCheck;
import Visitor.Fill_STC_STM;
import Visitor.TypeChecking;

class Test {

	//Testa il metodo op, che eseguira nello stesso modo sum e sup
	@org.junit.jupiter.api.Test
	void Coeffect_sum() {
		Coeffect cf=new Coeffect( "Nat.One()","Nat"); 
		Coeffect cf1=new Coeffect( "Nat.One()","Nat");
		Coeffect cf2=new Coeffect( "new Omega()","Omega");
		Coeffect cf3=new Coeffect( "Affinity.One()","Affinity");
		//somma fra due classi uguali
		cf=cf.op(cf1, "sum");
		assertEquals( "Nat.One().sum(Nat.One())",cf.getCoefExpr());
		//somma fra una classe nat e una non nat
		cf=cf1.op(cf2, "sum");
		assertEquals("(Omega.fromNat(Nat.One())).sum(new Omega())",cf.getCoefExpr());
		//somma fra una classe nat e una non nat
		cf=cf2.op(cf1, "sum");
		assertEquals("new Omega().sum(Omega.fromNat(Nat.One()))",cf.getCoefExpr());
		//somma fra una classe non nat e una non nat
		cf=cf2.op(cf3, "sum");
		assertEquals( "new Triv()",cf.getCoefExpr());	
	}
	//Testa il metodo op, che eseguira mult
		@org.junit.jupiter.api.Test
		void Coeffect_mult() {
			Coeffect cf=new Coeffect( "Nat.One()","Nat"); 
			Coeffect cf1=new Coeffect( "Nat.Zero()","Nat");
			Coeffect cf2=new Coeffect( "new Omega()","Omega");
			Coeffect cf3=new Coeffect( "Affinity.One()","Affinity");
			//moltiplico fra due classi uguali
			cf=cf.op(cf1, "mult");
			assertEquals(cf.getCoefExpr(), "Nat.One().mult(Nat.Zero())");
			//moltiplico fra una classe nat e una non nat
			cf=cf1.op(cf2, "mult");
			assertEquals(cf.getCoefExpr(), "(Omega.fromNat(Nat.Zero())).mult(new Omega())");
			//moltiplico fra una classe nat e una non nat
			cf=cf2.op(cf1, "mult");
			assertEquals(cf.getCoefExpr(), "new Omega().mult(Omega.fromNat(Nat.Zero()))");
			//moltiplico fra una classe non nat e una non nat
			cf=cf2.op(cf3, "mult");
			assertEquals(cf.getCoefExpr(), "new Triv()");	
		}
	//Testa i metodi di findElement, addElement 
	@org.junit.jupiter.api.Test
	void CoeffectTable_find_add() {
		CoeffectTable cft= new CoeffectTable();
		cft.addElement("a",new Coeffect( "Nat.One()","Nat"));
		cft.addElement("b",new Coeffect( "Nat.One()","Nat"));
		assertEquals(cft.findElement("a").getCoefExpr(),"Nat.One()");
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
		TypeCheckingException exception = assertThrows(TypeCheckingException.class, () -> {
	     new TypeChecking(AST, firstvisit.getClassST());});
		assertEquals("Errore di tipo alla riga -> 21", exception.getMessage());
		
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
		assertEquals("Errore sintattico alla riga -> 6", exception.getMessage());
		
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

}
