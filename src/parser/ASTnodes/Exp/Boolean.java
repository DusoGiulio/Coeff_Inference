package parser.ASTnodes.Exp;

/**
 * Rappresenta un valore letterale booleano in un'espressione.
 */
public class Boolean extends Litteral {
	
	/**
     * Crea un nuovo oggetto `Boolean` con il valore specificato.
     *
     * @param Value Il valore booleano (true o false).
     * @param line  Il numero di riga nel codice sorgente in cui appare il valore booleano.
     */
	public Boolean(String Value, int line)
	{
		super(Value,line);
	}
}

