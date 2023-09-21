package TypeDescriptor;

/**
 * Questa classe rappresenta un descrittore di tipo per un tipo array.
 */
public class ArrayTypeDescriptor extends TypeDescriptor {
    private TypeDescriptor element;

    /**
     * Costruisce un nuovo descrittore di tipo array con l'elemento specificato.
     *
     * @param element Il tipo di elemento all'interno dell'array.
     */
    public ArrayTypeDescriptor(TypeDescriptor element) {
        this.setElement(element);
    }

    /**
     * Restituisce il tipo di elemento all'interno dell'array.
     *
     * @return Il tipo di elemento all'interno dell'array.
     */
    public TypeDescriptor getElement() {
        return element;
    }

    /**
     * Imposta il tipo di elemento all'interno dell'array.
     *
     * @param element Il tipo di elemento da impostare.
     */
    public void setElement(TypeDescriptor element) {
        this.element = element;
    }

    /**
     * Restituisce una rappresentazione testuale del descrittore di tipo array.
     *
     * @return Una stringa vuota (questo metodo dovrebbe essere implementato per fornire una rappresentazione significativa del tipo).
     */
    @Override
    public String toString() {
        return "";
    }
}
