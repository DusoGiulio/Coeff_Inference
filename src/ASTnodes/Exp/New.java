package ASTnodes.Exp;

import ASTnodes.Class.NodeId;

/**
 * Rappresenta una nuova istanza di una classe nel programma.
 */
public class New extends Exp {
    
    /**
     * Il tipo della classe da istanziare.
     */
    private NodeId id;
    
    /**
     * L'espressione utilizzata per inizializzare la nuova istanza (può essere `null`).
     */
    private Exp exp;
    
    /**
     * Crea un nuovo oggetto `New` per istanziare una classe con il tipo specificato e, se presente, l'espressione di inizializzazione.
     *
     * @param id   Il tipo della classe da istanziare.
     * @param exp  L'espressione utilizzata per inizializzare la nuova istanza (può essere `null`).
     * @param line La linea in cui appare la creazione della nuova istanza nel programma.
     */
    public New(NodeId id, Exp exp, int line) {
        super(line);
        this.id = id;
        this.exp = exp;
    }
    
    /**
     * Restituisce l'espressione utilizzata per inizializzare la nuova istanza.
     *
     * @return L'espressione di inizializzazione (può essere `null`).
     */
    public Exp getExp() {
        return exp;
    }
    
    /**
     * Restituisce il tipo della classe da istanziare.
     *
     * @return Il tipo della classe da istanziare.
     */
    public NodeId getId() {
        return id;
    }
    
    /**
     * Imposta il tipo della classe da istanziare.
     *
     * @param id Il tipo della classe da impostare.
     */
    public void setId(NodeId id) {
        this.id = id;
    }
    
    /**
     * Restituisce una rappresentazione testuale della creazione di una nuova istanza di classe.
     *
     * @return Una stringa che rappresenta la creazione di una nuova istanza di classe.
     */
    @Override
    public String toString() {
        if (exp != null) {
            return "new " + id.getName() + "(" + exp.toString() + ")";
        } else {
            return "new " + id.getName() + "()";
        }
    }
}

