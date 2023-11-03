package parser.ASTnodes.Exp;

/**
 * Rappresenta un valore letterale (intero, booleano) nel programma.
 */
public abstract class Litteral extends Exp {
    
    /**
     * Il valore letterale rappresentato come stringa.
     */
    private String value;
    
    /**
     * Crea un nuovo oggetto `Litteral` con il valore letterale specificato e la linea in cui appare.
     *
     * @param value Il valore letterale rappresentato come stringa.
     * @param line  La linea in cui appare il valore letterale nel programma.
     */
    public Litteral(String value, int line) {
        super(line);
        this.value = value;
    }
    
    /**
     * Restituisce il valore letterale rappresentato come stringa.
     *
     * @return Il valore letterale.
     */
    public String getValue() {
        return value;
    }
    
    /**
     * Imposta il valore letterale rappresentato come stringa.
     *
     * @param value Il valore letterale da impostare.
     */
    public void setValue(String value) {
        this.value = value;
    }
    
    /**
     * Restituisce una rappresentazione testuale del valore letterale.
     *
     * @return Una stringa che rappresenta il valore letterale.
     */
    @Override
    public String toString() {
        return value;
    }
}
