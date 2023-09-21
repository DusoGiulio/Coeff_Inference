package ASTnodes.Exp;

/**
 * Rappresenta una costante di tipo decimal nell'AST del programma.
 */
public class Decimal extends Litteral {
    
    /**
     * Crea una nuova costante di tipo decimal con il suo valore e la linea in cui appare.
     *
     * @param value Il valore della costante di tipo decimal.
     * @param line  La linea in cui appare la costante di tipo decimal.
     */
    public Decimal(String value, int line) {
        super(value, line);
    }
}
