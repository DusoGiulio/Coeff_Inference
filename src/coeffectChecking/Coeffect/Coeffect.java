package coeffectChecking.Coeffect;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ClassInstanceCreation;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.MethodInvocation;

/**
 * La classe Coeffect rappresenta un coeffetto che può essere utilizzato
 * per rappresentare il co-effetto associato a variabili di tipo co-effetto.
 * La classe fornisce metodi per effettuare operazioni tra coeffetti.
 */
public class Coeffect {

    private Expression coefExpr;
    private String coefClass;
    @SuppressWarnings("deprecation")
	private AST ast = AST.newAST(AST.JLS16);

    /**
     * Crea un nuovo coeffetto con l'espressione e la classe specificate.
     * 
     * @param mi  L'espressione associata al coeffetto.
     * @param coefClass La classe di coeffetto (ad esempio, "Nat" o "Triv").
     */
    public Coeffect(Expression mi, String coefClass) {
        this.coefExpr = mi;
        this.coefClass = coefClass;
    }

    /**
     * Restituisce l'espressione associata al coeffetto.
     * 
     * @return L'espressione associata al coeffetto.
     */
    public Expression getCoefExpr() {
        return this.coefExpr;
    }

    /**
     * Imposta l'espressione associata al coeffetto.
     * 
     * @param coefExpr La nuova espressione da associare al coeffetto.
     */
    public void setCoefExpr(Expression coefExpr) {
        this.coefExpr = coefExpr;
    }

    /**
     * Restituisce la classe di coeffetto associata.
     * 
     * @return La classe di coeffetto (ad esempio, "Nat" o "Triv").
     */
    public String getCoefClass() {
        return this.coefClass;
    }

    /**
     * Imposta la classe di coeffetto associata.
     * 
     * @param coefClass La nuova classe di coeffetto da associare.
     */
    public void setCoefClass(String coefClass) {
        this.coefClass = coefClass;
    }

    /**
     * Esegue l'operazione di "sup" tra questo coeffetto e un altro coeffetto.
     * 
     * @return Il risultato dell'operazione "sup".
     */
    public Coeffect supOne() {
    	
    	MethodInvocation mi= ast.newMethodInvocation();
        mi.setName(ast.newSimpleName("one"));
        mi.setExpression(ast.newSimpleName("Nat"));
    	return this.op(new Coeffect(mi, "Nat"), "sup");
    }

    /**
     * Esegue un'operazione tra questo coeffetto e un altro coeffetto specificato.
     * 
     * @param coef L'altro coeffetto con cui effettuare l'operazione.
     * @param op   L'operazione da eseguire (ad esempio, "sup", "mult", ecc.).
     * @return Il risultato dell'operazione specificata tra i coeffetti.
     */
    public Coeffect op(Coeffect coef, String op) {
    	if(op.equals("leq")) 
    	{
    		if(this.coefClass.toString().contains("Triv")) 
    		{
    			return boolLeq(op, coef, true);
    		}else if(coef.coefClass.toString().contains("Triv")) 
    		{
    			return boolLeq(op, coef, false);
    		}
    	}
        if (this.coefClass.equals(coef.coefClass)) {
            return sameClass(op, coef);
        } else if (this.coefClass.equals("Nat") && !coef.coefClass.equals("Nat")) {
            return thisNatClass(op, coef);
        } else if (!this.coefClass.equals("Nat") && coef.coefClass.equals("Nat")) {
            return otherNatClass(op, coef);
        } else {
            return noNatClass(op, coef);
        }
    }

    private Coeffect boolLeq(String op, Coeffect coef,  boolean b) {
    	
    	Expression expression = ast.newBooleanLiteral(b);
    	
		return new Coeffect(expression, coef.coefClass);
	}

	@SuppressWarnings("unchecked")
	private Coeffect sameClass(String op, Coeffect other) {
    	
    	MethodInvocation opInvocation = ast.newMethodInvocation();
        opInvocation.setName(ast.newSimpleName(op));
        opInvocation.setExpression((Expression) ASTNode.copySubtree(ast, this.coefExpr));
        opInvocation.arguments().add((Expression) ASTNode.copySubtree(ast,other.coefExpr));
        return new Coeffect(opInvocation, other.coefClass);
    }

    @SuppressWarnings("unchecked")
	private Coeffect thisNatClass(String op, Coeffect other) {
       // String exp = "(" + other.coefClass + ".fromNat(" + this.coefExpr + "))." + op + "(" + other.coefExpr + ")";
        
        MethodInvocation fromNat = ast.newMethodInvocation();
        fromNat.setName(ast.newSimpleName("fromNat"));
        fromNat.setExpression((Expression) ASTNode.copySubtree(ast,other.coefExpr));
        fromNat.arguments().add((Expression) ASTNode.copySubtree(ast, this.coefExpr));
        
        MethodInvocation opInvocation = ast.newMethodInvocation();
        opInvocation.setName(ast.newSimpleName(op));
        opInvocation.setExpression(fromNat);
        opInvocation.arguments().add((Expression) ASTNode.copySubtree(ast,other.coefExpr));
        
        return new Coeffect(opInvocation, other.coefClass);
    }

    @SuppressWarnings("unchecked")
	private Coeffect otherNatClass(String op, Coeffect other) {
       // String exp = this.coefExpr + "." + op + "(" + this.coefClass + ".fromNat(" + other.coefExpr + "))";
        
        
        
        MethodInvocation opInvocation = ast.newMethodInvocation();
        opInvocation.setName(ast.newSimpleName(op));
        opInvocation.setExpression((Expression) ASTNode.copySubtree(ast, this.coefExpr));
        
        MethodInvocation fromNat = ast.newMethodInvocation();
        fromNat.setName(ast.newSimpleName("fromNat"));
        fromNat.setExpression((Expression) ASTNode.copySubtree(ast, this.coefExpr));
        fromNat.arguments().add((Expression) ASTNode.copySubtree(ast,other.coefExpr));
        
        opInvocation.arguments().add(fromNat);
        
        return new Coeffect(opInvocation, this.coefClass);
    }

    private Coeffect noNatClass(String op, Coeffect other) {
    	
    	ClassInstanceCreation newTriv = ast.newClassInstanceCreation();
		newTriv.setType(ast.newSimpleType(ast.newSimpleName("Triv")));
        return new Coeffect(newTriv, "Triv");
    }
    
    /**
     * Duplica il coeffetto corrente.
     * 
     * @return Una copia del coeffetto corrente.
     */
    public Coeffect duplicate() {
        return new Coeffect(this.coefExpr, this.coefClass);
    }


    /**
     * Restituisce la rappresentazione testuale del coeffetto.
     * 
     * @return La rappresentazione testuale del coeffetto.
     */
    @Override
    public String toString() {
        return "(" + this.coefExpr + ")";
    }
}
