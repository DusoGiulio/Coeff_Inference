package ASTnodes.Exp;

import ASTnodes.Class.NodeId;

/**
 * Rappresenta un'operazione di controllo di tipo "instanceof" nel programma.
 */
public class Instanceof extends Exp {
    
    /**
     * L'espressione su cui viene effettuato il controllo di tipo "instanceof".
     */
    private Exp exp;
    
    /**
     * Il tipo (identificatore) da confrontare con l'espressione.
     */
    private NodeId id;
    
    /**
     * Crea un nuovo oggetto `Instanceof` con l'espressione e il tipo specificati e la linea in cui appare.
     *
     * @param id   Il tipo (identificatore) da confrontare con l'espressione.
     * @param exp  L'espressione su cui viene effettuato il controllo di tipo "instanceof".
     * @param line La linea in cui appare l'operazione nel programma.
     */
    public Instanceof(NodeId id, Exp exp, int line) {
        super(line);
        this.id = id;
        this.exp = exp;
    }
    
    /**
     * Restituisce l'espressione su cui viene effettuato il controllo di tipo "instanceof".
     *
     * @return L'espressione.
     */
    public Exp getExp() {
        return exp;
    }
    
    /**
     * Restituisce il tipo (identificatore) da confrontare con l'espressione.
     *
     * @return Il tipo (identificatore).
     */
    public NodeId getId() {
        return id;
    }
    
    /**
     * Imposta il tipo (identificatore) da confrontare con l'espressione.
     *
     * @param id Il nuovo tipo (identificatore).
     */
    public void setId(NodeId id) {
        this.id = id;
    }
    
    /**
     * Restituisce una rappresentazione testuale dell'operazione "instanceof".
     *
     * @return Una stringa che rappresenta l'operazione "instanceof".
     */
    @Override
    public String toString() {
        return "(" + exp.toString() + " instanceof " + id.toString() + ")";
    }
}

