package typeChecking.Exceptioin;

/**
 * Eccezione personalizzata per gli errori di tipo durante il controllo del tipo.
 */
public class TypeCheckingException extends Exception {

    private static final long serialVersionUID = 1L;

    /**
     * Crea una nuova eccezione di tipo con un messaggio personalizzato che indica la riga dell'errore.
     * 
     * @param line Il numero di riga in cui si è verificato l'errore.
     */
    public TypeCheckingException(int line) {
        super("Errore di tipo alla riga -> " + line); // Imposta il messaggio di errore personalizzato
    }

    /**
     * Crea una nuova eccezione di tipo con un messaggio personalizzato che indica la riga e il tipo di errore.
     * 
     * @param line Il numero di riga in cui si è verificato l'errore.
     * @param type Il tipo di errore specifico 
     */
    public TypeCheckingException(int line, int type) {
        super("Errore dichiarazione coeffetti alla riga -> " + line); // Imposta il messaggio di errore personalizzato
    }
}

