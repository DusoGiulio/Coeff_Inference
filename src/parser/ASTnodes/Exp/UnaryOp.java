package parser.ASTnodes.Exp;

import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * Rappresenta un'operazione unaria, come ad esempio l'operatore di negazione.
 */
public class UnaryOp extends Exp {
    
    private TerminalNode op;
    private Exp exp;
    
    /**
     * Crea un nuovo oggetto `UnaryOp` che rappresenta un'operazione unaria.
     *
     * @param op   Il nodo terminale che rappresenta l'operatore unario.
     * @param exp  L'espressione su cui viene applicato l'operatore unario.
     * @param line La linea in cui appare l'operazione unaria nel programma.
     */
    public UnaryOp(TerminalNode op, Exp exp, int line) {
        super(line);
        this.op = op;
        this.exp = exp;
    }
    
    /**
     * Restituisce il nodo terminale che rappresenta l'operatore unario.
     *
     * @return Il nodo terminale che rappresenta l'operatore unario.
     */
    public TerminalNode getOp() {
        return op;
    }
    
    /**
     * Restituisce l'espressione su cui viene applicato l'operatore unario.
     *
     * @return L'espressione su cui viene applicato l'operatore unario.
     */
    public Exp getExp() {
        return exp;
    }
    
    /**
     * Restituisce una rappresentazione testuale dell'operazione unaria.
     *
     * @return Una stringa che rappresenta l'operazione unaria.
     */
    @Override
    public String toString() {
        return op.getText() + exp.toString();
    }
}
