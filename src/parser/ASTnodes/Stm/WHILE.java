package parser.ASTnodes.Stm;

import parser.ASTnodes.Exp.Exp;

/**
 * La classe WHILE rappresenta un'istruzione di ciclo while nel codice sorgente.
 * Questa istruzione eseguirà ricorsivamente il blocco di istruzioni all'interno del while
 * fintanto che l'espressione specificata è vera.
 */
public class WHILE extends Stm {
    private Exp exp;
    private Stm stm1;

    /**
     * Costruisce un'istanza di WHILE con l'espressione condizionale e il blocco di istruzioni specificati.
     *
     * @param exp   L'espressione condizionale che determina l'uscita o l'ingresso nel ciclo while.
     * @param stm1  Il blocco di istruzioni da eseguire all'interno del ciclo while.
     * @param line  Il numero di riga in cui si trova questa istruzione nel codice sorgente.
     */
    public WHILE(Exp exp, Stm stm1, int line) {
        super(line);
        this.exp = exp;
        this.stm1 = stm1;
    }

    /**
     * Restituisce l'espressione condizionale del ciclo while.
     *
     * @return L'espressione condizionale del ciclo while.
     */
    public Exp getExp() {
        return exp;
    }

    /**
     * Restituisce il blocco di istruzioni da eseguire all'interno del ciclo while.
     *
     * @return Il blocco di istruzioni del ciclo while.
     */
    public Stm getStm1() {
        return stm1;
    }

    /**
     * Restituisce una rappresentazione in formato stringa dell'istruzione while.
     *
     * @return Una stringa che rappresenta l'istruzione while, inclusi l'espressione condizionale
     *         e il blocco di istruzioni.
     */
    @Override
    public String toString() {
        return "while (" + exp.toString() + ") {\n" + this.stm1.toString() + "}";
    }
}
