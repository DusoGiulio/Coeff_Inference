package ASTnodes.Stm;

import ASTnodes.Exp.Exp;

/**
 * La classe SOP rappresenta un'istruzione di stampa di output nel codice sorgente.
 * Questa classe consente di stampare il valore di un'espressione su standard output.
 */
public class SOP extends Stm {
    private Exp exp;

    /**
     * Costruisce un'istanza di SOP per l'istruzione di stampa.
     *
     * @param exp   L'espressione il cui valore verrà stampato.
     * @param line  Il numero di riga in cui si trova questa istruzione di stampa.
     */
    public SOP(Exp exp, int line) {
        super(line);
        this.exp = exp;
    }

    /**
     * Restituisce l'espressione il cui valore verrà stampato.
     *
     * @return L'espressione da stampare.
     */
    public Exp getLExp() {
        return exp;
    }

    /**
     * Restituisce una rappresentazione testuale dell'istruzione di stampa.
     *
     * @return Una stringa che rappresenta l'istruzione di stampa.
     */
    @Override
    public String toString() {
        return "System.out.println(" + this.exp.toString() + ");";
    }
}
