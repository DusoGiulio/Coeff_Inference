
package ASTnodes.Exp;

/**
 * Rappresenta un'operazione di ottenimento della lunghezza di un array nel programma.
 */
public class Length extends Exp {
    
    /**
     * L'espressione che rappresenta l'array di cui si vuole ottenere la lunghezza.
     */
    private Exp exp;
    
    /**
     * Crea un nuovo oggetto `Length` con l'espressione specificata e la linea in cui appare.
     *
     * @param exp  L'espressione che rappresenta l'array di cui si vuole ottenere la lunghezza.
     * @param line La linea in cui appare l'operazione nel programma.
     */
    public Length(Exp exp, int line) {
        super(line);
        this.exp = exp;
    }
    
    /**
     * Restituisce l'espressione che rappresenta l'array di cui si vuole ottenere la lunghezza.
     *
     * @return L'espressione.
     */
    public Exp getExp() {
        return exp;
    }
    
    /**
     * Restituisce una rappresentazione testuale dell'operazione di ottenimento della lunghezza.
     *
     * @return Una stringa che rappresenta l'operazione.
     */
    @Override
    public String toString() {
        return exp.toString() + ".length";
    }
}

