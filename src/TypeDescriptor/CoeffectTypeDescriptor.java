package TypeDescriptor;

import Coeffect.VarCoeff;

/**
 * Questa classe rappresenta un descrittore di tipo per un coeffetto che contiene un tipo di variabile e un coefficiente.
 */
public class CoeffectTypeDescriptor extends TypeDescriptor {

    private TypeDescriptor varType;
    private VarCoeff varCoeff;

    /**
     * Costruisce un nuovo descrittore di tipo per un coeffetto con il tipo di variabile e il coefficiente specificati.
     *
     * @param varType  Il tipo di variabile associato al coeffetto.
     * @param varCoeff Il coefficiente associato al coeffetto.
     */
    public CoeffectTypeDescriptor(TypeDescriptor varType, VarCoeff varCoeff) {
        super();
        this.varType = varType;
        this.varCoeff = varCoeff;
    }

    /**
     * Restituisce il coefficiente associato al coeffetto.
     *
     * @return Il coefficiente associato al coeffetto.
     */
    public VarCoeff getVarCoeff() {
        return varCoeff;
    }

    /**
     * Restituisce il tipo di variabile associato al coeffetto.
     *
     * @return Il tipo di variabile associato al coeffetto.
     */
    public TypeDescriptor getVarType() {
        return varType;
    }

    /**
     * Restituisce una rappresentazione testuale del descrittore di tipo coeffetto.
     *
     * @return Una stringa che rappresenta il tipo di variabile del coeffetto.
     */
    @Override
    public String toString() {
        return this.varType.toString();
    }
}
