package parser.ASTnodes.Exp;

import parser.ASTnodes.Class.NodeId;

/**
 * Rappresenta un'identificatore (variabile o nome di classe) all'interno del programma.
 */
public class Id extends Exp {

    /**
     * L'identificatore rappresentato da questa istanza.
     */
    private NodeId id;

    /**
     * Crea un nuovo oggetto Id con l'identificatore specificato e la linea in cui appare.
     *
     * @param id   L'identificatore da rappresentare.
     * @param line La linea in cui appare l'identificatore nel programma.
     */
    public Id(NodeId id, int line) {
        super(line);
        this.id = id;
    }

    /**
     * Restituisce l'identificatore rappresentato da questa istanza.
     *
     * @return L'identificatore.
     */
    public NodeId getId() {
        return id;
    }

    /**
     * Imposta l'identificatore rappresentato da questa istanza.
     *
     * @param id Il nuovo identificatore.
     */
    public void setId(NodeId id) {
        this.id = id;
    }

    /**
     * Restituisce il nome dell'identificatore.
     *
     * @return Il nome dell'identificatore.
     */
    @Override
    public String toString() {
        return id.getName();
    }
}
