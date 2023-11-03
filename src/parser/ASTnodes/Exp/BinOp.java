package parser.ASTnodes.Exp;

import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * Rappresenta un'operazione binaria nell'AST del programma.
 */
public class BinOp extends Exp {

    private TerminalNode op;  // L'operatore binario
    private Exp lexp;         // L'espressione sinistra
    private Exp rexp;         // L'espressione destra

    /**
     * Crea una nuova operazione binaria con l'operatore specificato e le espressioni sinistra e destra.
     *
     * @param op    L'operatore binario.
     * @param lexp  L'espressione sinistra.
     * @param rexp  L'espressione destra.
     * @param line  La linea in cui appare l'operazione binaria.
     */
    public BinOp(TerminalNode op, Exp lexp, Exp rexp, int line) {
        super(line);
        this.op = op;
        this.lexp = lexp;
        this.rexp = rexp;
    }

    /**
     * Restituisce l'operatore binario.
     *
     * @return L'operatore binario.
     */
    public TerminalNode getOp() {
        return op;
    }

    /**
     * Restituisce l'espressione sinistra.
     *
     * @return L'espressione sinistra.
     */
    public Exp getLexp() {
        return lexp;
    }

    /**
     * Restituisce l'espressione destra.
     *
     * @return L'espressione destra.
     */
    public Exp getRexp() {
        return rexp;
    }

    /**
     * Restituisce una rappresentazione testuale dell'operazione binaria.
     *
     * @return Una stringa che rappresenta l'operazione binaria nel formato corretto.
     */
    @Override
    public String toString() {
        return this.lexp.toString() + op.getText() + this.rexp.toString();
    }
}
