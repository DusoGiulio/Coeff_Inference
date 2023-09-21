
package ASTnodes.Stm;
import ASTnodes.Exp.Exp;

/**
 * La classe ASSIGN rappresenta un'istruzione di assegnazione.
 * Questa istruzione assegna un valore a una variabile identificata da un nome.
 */
public class ASSIGN extends Stm {
	
	private String id;
	private Exp exp;
	
	/**
	 * Il costruttore crea un'istanza di ASSIGN.
	 *
	 * @param exp L'espressione da assegnare alla variabile.
	 * @param id Il nome della variabile a cui assegnare l'espressione.
	 * @param line Il numero di riga in cui si trova l'istruzione di assegnazione.
	 */
	public ASSIGN(Exp exp, String id, int line) {
		super(line);
		this.exp = exp;
		this.id = id;
	}

	/**
	 * Restituisce l'espressione da assegnare alla variabile.
	 *
	 * @return L'espressione da assegnare.
	 */
	public Exp getLExp() {
		return exp;
	}

	/**
	 * Restituisce il nome della variabile a cui viene assegnata l'espressione.
	 *
	 * @return Il nome della variabile.
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * Restituisce una rappresentazione testuale dell'istruzione di assegnazione.
	 *
	 * @return Una stringa che rappresenta l'istruzione di assegnazione.
	 */
	@Override
	public String toString() {
		return this.id + "=" + this.getLExp().toString() + ";";
	}
}