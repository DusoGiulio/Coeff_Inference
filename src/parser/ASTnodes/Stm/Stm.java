package parser.ASTnodes.Stm;

import parser.ASTnodes.Class.NodeAST;

/**
 * La classe astratta Stm rappresenta un'istruzione nel codice sorgente.
 * Questa classe è la classe di base per tutte le istruzioni del linguaggio.
 */
public abstract class Stm extends NodeAST {
    private int line;

    /**
     * Costruisce un'istanza di Stm con la specifica linea nel codice sorgente.
     *
     * @param line Il numero di riga in cui si trova questa istruzione.
     */
    public Stm(int line) {
        super();
        this.line = line;
    }

    /**
     * Restituisce il numero di riga in cui si trova questa istruzione nel codice sorgente.
     *
     * @return Il numero di riga dell'istruzione.
     */
    public int getLine() {
        return line;
    }

    /**
     * Imposta il numero di riga in cui si trova questa istruzione nel codice sorgente.
     *
     * @param line Il numero di riga da impostare.
     */
    public void setLine(int line) {
        this.line = line;
    }
}

