package TypeDescriptor;

import Coeffect.Coef;

/**
 * Questa classe rappresenta un descrittore di tipo per il tipo di classe.
 */
public class ClassTypeDescriptor extends TypeDescriptor {
    private String name;
    private Coef isCoeff;

    /**
     * Costruisce un nuovo descrittore di tipo per una classe con il nome specificato.
     *
     * @param nameclass Il nome della classe.
     */
    public ClassTypeDescriptor(String nameclass) {
        this.name = nameclass;
        this.isCoeff = Coef.NOTCOEF;
    }

    /**
     * Restituisce il nome della classe.
     *
     * @return Il nome della classe.
     */
    public String getName() {
        return name;
    }

    /**
     * Restituisce il coefficiente che indica se la classe è un coeffetto.
     *
     * @return Il coefficiente che indica se la classe è un coeffetto.
     */
    public Coef isCoeff() {
        return isCoeff;
    }

    /**
     * Imposta il coefficiente che indica se la classe è un coeffetto.
     *
     * @param coefficient Il coefficiente da impostare.
     */
    public void setCoeff(Coef coefficient) {
        this.isCoeff = coefficient;
    }

    /**
     * Restituisce una rappresentazione testuale del descrittore di tipo classe.
     *
     * @return Una stringa vuota (questo metodo dovrebbe essere implementato per fornire una rappresentazione significativa del tipo).
     */
    @Override
    public String toString() {
        return "";
    }
}