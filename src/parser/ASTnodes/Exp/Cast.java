package parser.ASTnodes.Exp;

import parser.ASTnodes.Class.NodeId;

/**
 * Rappresenta un'espressione di cast nell'AST del programma.
 */
public class Cast extends Exp {

    private Exp exp;    // L'espressione da castare
    private NodeId id;  // L'identificatore del tipo di destinazione del cast

    /**
     * Crea una nuova espressione di cast con l'espressione da castare e l'identificatore del tipo di destinazione.
     *
     * @param exp   L'espressione da castare.
     * @param id    L'identificatore del tipo di destinazione del cast.
     * @param line  La linea in cui appare l'espressione di cast.
     */
    public Cast(Exp exp, NodeId id, int line) {
        super(line);
        this.exp = exp;
        this.id = id;
    }

    /**
     * Restituisce l'espressione da castare.
     *
     * @return L'espressione da castare.
     */
    public Exp getExp() {
        return exp;
    }

    /**
     * Restituisce l'identificatore del tipo di destinazione del cast.
     *
     * @return L'identificatore del tipo di destinazione del cast.
     */
    public NodeId getId() {
        return id;
    }

    /**
     * Restituisce una rappresentazione testuale dell'espressione di cast.
     *
     * @return Una stringa che rappresenta l'espressione di cast nel formato corretto.
     */
    @Override
    public String toString() {
        return "((" + this.id.toString() + ")" + this.exp.toString() + ")";
    }
}


