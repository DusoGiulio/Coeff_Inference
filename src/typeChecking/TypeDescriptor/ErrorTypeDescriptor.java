package typeChecking.TypeDescriptor;

/**
 * Questa classe rappresenta un descrittore di tipo per un errore di tipo durante l'analisi del codice sorgente.
 */
public class ErrorTypeDescriptor extends TypeDescriptor {

    private int line;

    /**
     * Costruisce un nuovo descrittore di tipo per un errore di tipo durante l'analisi del codice sorgente.
     *
     * @param line Il numero di linea in cui è stato rilevato l'errore di tipo.
     */
    public ErrorTypeDescriptor(int line) {
        super();
        this.line = line;
    }

    /**
     * Restituisce il numero di linea in cui è stato rilevato l'errore di tipo.
     *
     * @return Il numero di linea dell'errore di tipo.
     */
    public int getLine() {
        return line;
    }

    /**
     * Imposta il numero di linea in cui è stato rilevato l'errore di tipo.
     *
     * @param line Il numero di linea da impostare.
     */
    public void setLine(int line) {
        this.line = line;
    }
}
