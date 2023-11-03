package parser.ASTnodes.Exp;

/**
 * Rappresenta un accesso agli elementi di un array nell'AST del programma.
 */
public class ArrElem extends Exp {

    private Exp expEl;   // L'espressione per l'indice dell'array
    private Exp ArrExp;  // L'espressione che rappresenta l'array

    /**
     * Crea un nuovo accesso agli elementi di un array con le espressioni specificate.
     *
     * @param exp    L'espressione che rappresenta l'array.
     * @param expEl  L'espressione per l'indice dell'array.
     * @param line   La linea in cui appare l'accesso agli elementi dell'array.
     */
    public ArrElem(Exp exp, Exp expEl, int line) {
        super(line);
        this.expEl = expEl;
        this.setExp(exp);
    }

    /**
     * Restituisce l'espressione per l'indice dell'array.
     *
     * @return L'espressione per l'indice dell'array.
     */
    public Exp getExpEl() {
        return expEl;
    }

    /**
     * Restituisce l'espressione che rappresenta l'array.
     *
     * @return L'espressione che rappresenta l'array.
     */
    public Exp getExp() {
        return ArrExp;
    }

    /**
     * Imposta l'espressione che rappresenta l'array.
     *
     * @param arrExp L'espressione che rappresenta l'array.
     */
    public void setExp(Exp arrExp) {
        ArrExp = arrExp;
    }

    /**
     * Restituisce una rappresentazione testuale dell'accesso agli elementi dell'array.
     *
     * @return Una stringa che rappresenta l'accesso agli elementi dell'array nel formato corretto.
     */
    @Override
    public String toString() {
        return this.ArrExp.toString() + "[" + this.expEl + "]";
    }
}
