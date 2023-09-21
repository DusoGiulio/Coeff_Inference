package Exceptioin;

/**
 * Eccezione personalizzata per gli errori sintattici.
 */
public class SemanticException extends Exception {

    private static final long serialVersionUID = 1L;

    /**
     * Crea una nuova eccezione semantics con un messaggio personalizzato che indica la riga dell'errore.
     * 
     * @param line Il numero di riga in cui si è verificato l'errore sintattico.
     */
    public SemanticException(int line) {
        super("Errore semantico alla riga -> " + line); // Imposta il messaggio di errore personalizzato
    }
}