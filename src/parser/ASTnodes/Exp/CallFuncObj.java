package parser.ASTnodes.Exp;

import java.util.ArrayList;

import parser.ASTnodes.Class.NodeId;

/**
 * Rappresenta una chiamata di metodo su un oggetto nell'AST del programma.
 */
public class CallFuncObj extends Exp {

    private Exp lexp;                 // L'espressione sinistra
    private ArrayList<Exp> rexp;      // Lista di espressioni degli argomenti
    private NodeId id;                // L'identificatore del metodo

    /**
     * Crea una nuova chiamata di metodo su un oggetto con l'identificatore del metodo, l'espressione sinistra e
     * la lista di espressioni degli argomenti.
     *
     * @param id    L'identificatore del metodo.
     * @param lexp  L'espressione sinistra (oggetto).
     * @param rexp  La lista di espressioni degli argomenti.
     * @param line  La linea in cui appare la chiamata di metodo.
     */
    public CallFuncObj(NodeId id, Exp lexp, ArrayList<Exp> rexp, int line) {
        super(line);
        this.id = id;
        this.lexp = lexp;
        this.rexp = rexp;
    }

    /**
     * Restituisce l'espressione sinistra (oggetto).
     *
     * @return L'espressione sinistra.
     */
    public Exp getLexp() {
        return lexp;
    }

    /**
     * Imposta l'espressione sinistra (oggetto).
     *
     * @param lexp L'espressione sinistra da impostare.
     */
    public void setLexp(Exp lexp) {
        this.lexp = lexp;
    }

    /**
     * Restituisce la lista di espressioni degli argomenti.
     *
     * @return La lista di espressioni degli argomenti.
     */
    public ArrayList<Exp> getRexp() {
        return rexp;
    }

    /**
     * Imposta la lista di espressioni degli argomenti.
     *
     * @param rexp La lista di espressioni degli argomenti da impostare.
     */
    public void setRexp(ArrayList<Exp> rexp) {
        this.rexp = rexp;
    }

    /**
     * Restituisce l'identificatore del metodo.
     *
     * @return L'identificatore del metodo.
     */
    public NodeId getId() {
        return id;
    }

    /**
     * Imposta l'identificatore del metodo.
     *
     * @param id L'identificatore del metodo da impostare.
     */
    public void setId(NodeId id) {
        this.id = id;
    }

    /**
     * Restituisce una rappresentazione testuale della chiamata di metodo su un oggetto.
     *
     * @return Una stringa che rappresenta la chiamata di metodo su un oggetto nel formato corretto.
     */
    @Override
    public String toString() {
        return lexp.toString() + "." + id.getName() + "(" + this.rexpString() + ")";
    }

    private String rexpString() {
        StringBuilder s = new StringBuilder();
        for (Exp exp : this.rexp) {
            if (this.rexp.indexOf(exp) == this.rexp.size() - 1) {
                s.append(exp.toString());
            } else {
                s.append(exp.toString()).append(", ");
            }
        }
        return s.toString();
    }
}
