package parser.ASTnodes.Stm;

import java.util.ArrayList;

/**
 * La classe Multi rappresenta una sequenza di istruzioni multiple.
 * Questa classe permette di raggruppare più istruzioni in un unico blocco.
 */
public class Multi extends Stm {

    private ArrayList<Stm> stms;

    /**
     * Costruisce un'istanza di Multi contenente una sequenza di istruzioni.
     *
     * @param stms  La lista di istruzioni da includere nella sequenza multipla.
     * @param line  Il numero di riga in cui si trova questa sequenza multipla.
     */
    public Multi(ArrayList<Stm> stms, int line) {
        super(line);
        this.stms = stms;
    }

    /**
     * Restituisce la lista di istruzioni contenute in questa sequenza multipla.
     *
     * @return La lista di istruzioni.
     */
    public ArrayList<Stm> getStms() {
        return stms;
    }

    /**
     * Restituisce una rappresentazione testuale della sequenza di istruzioni multiple.
     *
     * @return Una stringa che rappresenta la sequenza di istruzioni multiple.
     */
    @Override
    public String toString() {
        StringBuilder acc = new StringBuilder();
        for (Stm s : this.stms) {
            acc.append("\n").append(s.toString()).append("\n");
        }
        return acc.toString();
    }
}

