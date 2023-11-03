package coeffectChecking.Coeffect;

import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.Expression;

import parser.ASTnodes.Exp.Exp;


/**
 * La classe VarCoeff rappresenta un coefficiente variabile, che associa un'espressione e una classe.
 * È utilizzata per rappresentare il co-effetto di una variabile in un contesto specifico.
 */
public class VarCoeff {
    private String classCoeff;
    private Exp expCoeff;

    /**
     * Crea un nuovo coefficiente variabile con l'espressione e la classe specificate.
     * 
     * @param exp        L'espressione associata al coefficiente variabile.
     * @param classCoeff La classe associata al coefficiente variabile.
     */
    public VarCoeff(Exp exp, String classCoeff) {
        this.expCoeff = exp;
        this.classCoeff = classCoeff;
    }

    /**
     * Restituisce la classe associata al coefficiente variabile.
     * 
     * @return La classe associata al coefficiente variabile.
     */
    public String getClassCoeff() {
        return classCoeff;
    }

    /**
     * Restituisce l'espressione associata al coefficiente variabile.
     * 
     * @return L'espressione associata al coefficiente variabile.
     */
    public Exp getExpCoeff() {
        return expCoeff;
    }

    /**
     * Restituisce una rappresentazione in formato stringa del coefficiente variabile.
     * 
     * @return Una stringa vuota (poiché la rappresentazione è specifica del contesto d'uso).
     */
    @Override
    public String toString() {
        return " ";
    }
    
    public Expression fromExpToEclipseExp() 
    {
    	ASTParser parser = ASTParser.newParser(AST.JLS16);  	 
	     parser.setKind(ASTParser.K_EXPRESSION);
	     parser.setBindingsRecovery(true);
	     parser.setResolveBindings(true);
	     parser.setCompilerOptions(JavaCore.getOptions());
		parser.setSource(this.getExpCoeff().toString().toCharArray());
		return (Expression) parser.createAST(null);
    }
}
