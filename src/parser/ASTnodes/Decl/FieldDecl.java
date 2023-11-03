package parser.ASTnodes.Decl;

import parser.ASTnodes.Class.NodeId;
import typeChecking.TypeDescriptor.TypeDescriptor;

/**
 * Rappresenta una dichiarazione di campo (variabile) all'interno di una classe.
 */
public class FieldDecl extends Decl {
    private NodeId id;

    /**
     * Crea una nuova dichiarazione di campo con il tipo, l'ID e il numero di linea specificati.
     *
     * @param type Il tipo del campo.
     * @param id   L'identificatore (nome) del campo.
     * @param line Il numero di linea in cui appare la dichiarazione.
     */
    public FieldDecl(TypeDescriptor type, NodeId id, int line) {
        super(type, line); // Definisce il tipo di variabile associato all'ID
        this.id = id; // Contiene la stringa associata al nodo e il suo descrittore di tipo
    }

    /**
     * Restituisce l'identificatore (nome) del campo.
     *
     * @return L'identificatore del campo.
     */
    public NodeId getId() {
        return id;
    }

    /**
     * Restituisce una rappresentazione testuale della dichiarazione di campo.
     *
     * @return Una stringa che rappresenta la dichiarazione di campo nel formato "tipo ID".
     */
    @Override
    public String toString() {
        return this.getType().toString() + " " + this.getId().toString();
    }
}
