package Main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.ArrayList;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import ANTLR4.miniJavaLexer;
import ANTLR4.miniJavaParser;
import ANTLR4.miniJavaParser.ProgramContext;
import ASTnodes.Class.NodeAST;
import Exceptioin.SemanticException;
import Exceptioin.TypeCheckingException;
import ResultGenerator.Compile_Execute;
import ResultGenerator.SurceCodeComposer;
import Visitor.ASTGenerator;
import Visitor.CoeffInference;
import Visitor.CoeffDefinitioinCheck;
import Visitor.Fill_STC_STM;
import Visitor.TypeChecking;


/**
 * Classe principale per l'esecuzione del compilatore MiniJava.
 */
public class MainMiniJava {
    
    /**
     * Metodo principale per l'esecuzione del compilatore MiniJava.
     * 
     * @param args Gli argomenti della riga di comando (non utilizzati).
     * @throws IOException In caso di errori di input/output.
     */
	public static void main(String[] args) throws IOException{
        
        System.out.println("Senza concatenazione di stringhe");		//creo un char stream, posso inserire sia un file di testo che una stringa	
		FileInputStream inputStream=null;
		String sep= FileSystems.getDefault().getSeparator();
		String file="CoefInference1.txt";
		String indirizzoCompleto="src"+sep+"TestText"+sep+file;
		try {
			inputStream = new FileInputStream(indirizzoCompleto);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//creo uno scanner utilizzando il lexer generato automaticamente da ANTLR4
		miniJavaLexer lexer = new miniJavaLexer(new  ANTLRInputStream(inputStream ));
		//creo una sequenza di token usando lo scanner
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		tokens.fill();
		//Creo un parser usando il parser di ANTLR immettendo la sequenza dei token
		miniJavaParser parser = new miniJavaParser(tokens);
		// creo un albero di parsing partendo dal nodo prog che è il nodo di partenza della grammatica
		System.out.println("\tINIZIO PARSING\n//////////////////////////////////////");
		ProgramContext p= parser.program();
		if(parser.getNumberOfSyntaxErrors()==0)
		{
			System.out.println("\tPARSING PASSATO\n");
			//istanzio un nuovo visitor
			try 
			{
			ASTGenerator visitor= new ASTGenerator();
			//eseguo la visita sull'albero
			ArrayList<NodeAST> AST=visitor.visitProgram(p);
			try 
			{
				Fill_STC_STM firstvisit = new Fill_STC_STM(AST);
				try 
				{
					System.out.println("\tINIZIO TYPE CHECKING\n//////////////////////////////////////");
					 new TypeChecking(AST, firstvisit.getClassST());
					System.out.println("\tTYPE CHECKING PASSATO\n");
					System.out.println("\tINIZIO INFERENZA COEFFETTI\n//////////////////////////////////////");
					new CoeffDefinitioinCheck(AST);
					CoeffInference secondVisit=new CoeffInference(AST,firstvisit.getClassST());
					secondVisit.visitProgram(AST);
					System.out.println("\tFINE INFERENZA COEFFETTI\n");					
			        String nomeCartella = "src"+sep+"ResultGenerator"; 
			        String nomeFile = "CoeffectResult.java";
			        String percorsoCompleto = nomeCartella + sep + nomeFile;
			        SurceCodeComposer codiceSorgente=new SurceCodeComposer(AST,secondVisit.getClassST(),indirizzoCompleto);
			        System.out.println("ESEGUO "+nomeFile+" nella cartella "+nomeCartella+"\n");	
			        new Compile_Execute(codiceSorgente.getCodiceSorgente(),percorsoCompleto,sep);
			
				} catch (TypeCheckingException  | SemanticException e) 
				{
					System.err.println(e.getMessage());
					System.err.println("//////////////////////////////////////\n\tTYPE CHECKING FALLITO");
				}
			} catch (TypeCheckingException e1) {
				System.err.println(e1.getMessage());
			} catch (SemanticException e1) {
				System.err.println(e1.getMessage());
			}
			}catch(NullPointerException e) 
			{	
				System.err.println("//////////////////////////////////////\n\tERRORE SEMANTICO");
				System.err.println(e.getMessage());
			}
		}
		else 
		{
    	System.err.println("//////////////////////////////////////\n\tPARSING FALLITO");
		}
		
	}
}