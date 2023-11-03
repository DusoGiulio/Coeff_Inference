package typeChecking.TypeDescriptor;

/**
 * Questa classe rappresenta un descrittore di tipo per un tipo identificato da un nome.
 */
public class IdTypeDescriptor extends TypeDescriptor {

    private String nomeTipo;

    /**
     * Costruisce un nuovo descrittore di tipo per un tipo identificato da un nome specificato.
     *
     * @param type Il nome del tipo identificato.
     */
    public IdTypeDescriptor(String type) {
        super();
        this.nomeTipo = type;
    }

    /**
     * Restituisce il nome del tipo identificato.
     *
     * @return Il nome del tipo identificato.
     */
    public String getNomeTipo() {
        return nomeTipo;
    }

    /**
     * Imposta il nome del tipo identificato.
     *
     * @param nomeTipo Il nome del tipo da impostare.
     */
    public void setNomeTipo(String nomeTipo) {
        this.nomeTipo = nomeTipo;
    }

    /**
     * Restituisce una rappresentazione testuale del descrittore di tipo identificato.
     *
     * @return Il nome del tipo identificato.
     */
    @Override
    public String toString() {
        return this.nomeTipo;
    }
}
