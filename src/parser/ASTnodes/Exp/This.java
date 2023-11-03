package parser.ASTnodes.Exp;

/**
 * Rappresenta l'espressione `this` che fa riferimento all'istanza corrente di una classe.
 */
public class This extends Exp {
    
    /**
     * Crea un nuovo oggetto `This` che rappresenta l'espressione `this`.
     *
     * @param line La linea in cui appare l'espressione `this` nel programma.
     */
    public This(int line) {
        super(line);
    }
    
    /**
     * Restituisce una rappresentazione testuale dell'espressione `this`.
     *
     * @return Una stringa che rappresenta l'espressione `this`.
     */
    @Override
    public String toString() {
        return "this";
    }
}
