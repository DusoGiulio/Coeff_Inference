package parser.ASTnodes.Stm;

import parser.ASTnodes.Exp.Exp;
/**
 * La classe IF rappresenta un'istruzione condizionale.
 * Questa istruzione consente di eseguire un blocco di istruzioni se una condizione è vera
 * e un altro blocco di istruzioni se la condizione è falsa.
 */
public class IF extends Stm{

	private Exp exp;
	private Stm ifstm;
	private Stm elsestm;
	/**
	 * Il costruttore crea un'istanza di IF.
	 *
	 * @param exp2 L'espressione condizionale da valutare.
	 * @param stmif Il blocco di istruzioni da eseguire se la condizione è vera.
	 * @param stmelse Il blocco di istruzioni da eseguire se la condizione è falsa.
	 * @param line Il numero di riga in cui si trova l'istruzione condizionale.
	 */
	public IF(Exp exp2, Stm stmif, Stm stmelse, int line) {
		super(line);
		exp = exp2;
		this.ifstm = stmif;
		this.elsestm = stmelse;
	}

	/**
	 * Restituisce l'espressione condizionale associata all'istruzione IF.
	 *
	 * @return L'espressione condizionale.
	 */
	public Exp getExp() {
		return exp;
	}

	/**
	 * Restituisce il blocco di istruzioni da eseguire se la condizione è vera.
	 *
	 * @return Il blocco di istruzioni dell'istruzione IF.
	 */
	public Stm getIfstm() {
		return ifstm;
	}

	/**
	 * Restituisce il blocco di istruzioni da eseguire se la condizione è falsa.
	 *
	 * @return Il blocco di istruzioni dell'istruzione ELSE (opzionale).
	 */
	public Stm getElsestm() {
		return elsestm;
	}

	/**
	 * Restituisce una rappresentazione testuale dell'istruzione condizionale.
	 *
	 * @return Una stringa che rappresenta l'istruzione condizionale.
	 */
	@Override
	public String toString() {
		return "if (" + this.getExp().toString() + ") {\n" + this.ifstm.toString() + "\n} else {\n"
				+ this.getElsestm().toString() + "\n}";
	}
}

