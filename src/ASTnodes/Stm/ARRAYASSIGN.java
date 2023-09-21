package ASTnodes.Stm;

import ASTnodes.Exp.Exp;

/**
 * Rappresenta un'assegnazione a un elemento di un array.
 */
public class ARRAYASSIGN extends ASSIGN {
    private Exp rexp;

    /**
     * Crea un nuovo oggetto `ARRAYASSIGN` che rappresenta un'assegnazione a un elemento di un array.
     *
     * @param lexp L'espressione che rappresenta l'indice dell'array.
     * @param rexp L'espressione che rappresenta il valore da assegnare all'elemento dell'array.
     * @param id   Il nome dell'array.
     * @param line La linea in cui appare l'assegnazione nel programma.
     */
    public ARRAYASSIGN(Exp lexp, Exp rexp, String id, int line) {
        super(lexp, id, line);
        this.rexp = rexp;
    }

    /**
     * Restituisce l'espressione che rappresenta il valore da assegnare all'elemento dell'array.
     *
     * @return L'espressione che rappresenta il valore da assegnare all'elemento dell'array.
     */
    public Exp getRexp() {
        return rexp;
    }

    /**
     * Restituisce una rappresentazione testuale dell'assegnazione a un elemento di un array.
     *
     * @return Una stringa che rappresenta l'assegnazione a un elemento di un array.
     */
    @Override
    public String toString() {
        return getId().toString() + "[" + getLExp().toString() + "] = " + getRexp().toString() + ";";
    }
}