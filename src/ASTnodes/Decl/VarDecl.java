package ASTnodes.Decl;

import ASTnodes.Class.NodeId;
import TypeDescriptor.TypeDescriptor;

/**
 * Rappresenta la dichiarazione di una variabile nel programma.
 */
public class VarDecl extends Decl {

	private NodeId id;
    /**
     * Crea una nuova dichiarazione di variabile con il tipo e l'identificatore specificati.
     *
     * @param type Il tipo della variabile.
     * @param id   L'identificatore della variabile.
     * @param line La linea in cui appare la dichiarazione di variabile.
     */
    public VarDecl(TypeDescriptor type, NodeId id, int line) {
        super(type, line);
        this.id = id;
    }

    /**
     * Restituisce l'identificatore della variabile.
     *
     * @return L'identificatore della variabile.
     */
    public NodeId getId() {
        return id;
    }

    /**
     * Restituisce una rappresentazione testuale della dichiarazione di variabile.
     *
     * @return Una stringa che rappresenta la dichiarazione di variabile nel formato corretto.
     */
    @Override
    public String toString() {
        return this.getType().toString() + " " + this.getId().toString();
    }
}
