package ASTnodes.Decl;

import ASTnodes.Class.NodeId;
import ASTnodes.Exp.Exp;
import TypeDescriptor.TypeDescriptor;

/**
 * Rappresenta la dichiarazione di una classe principale (main class) nel programma.
 */
public class MainClass extends Decl {
    private NodeId idClass;
    private Exp exp;

    /**
     * Crea una nuova dichiarazione di classe principale con il tipo, il nome della classe, l'espressione e il numero di linea specificati.
     *
     * @param type    Il tipo della classe principale (di solito void).
     * @param name    Il nome della classe principale.
     * @param exp     L'espressione associata alla classe principale.
     * @param line    Il numero di linea in cui appare la dichiarazione.
     */
    public MainClass(TypeDescriptor type, NodeId name, Exp exp, int line) {
        super(type, line);
        this.idClass = name;
        this.exp = exp;
    }

    /**
     * Restituisce l'espressione associata alla classe principale.
     *
     * @return L'espressione associata alla classe principale.
     */
    public Exp getExp() {
        return exp;
    }

    /**
     * Restituisce il nome della classe principale.
     *
     * @return Il nome della classe principale.
     */
    public NodeId getIdClass() {
        return idClass;
    }

    /**
     * Restituisce una rappresentazione testuale della dichiarazione di classe principale.
     *
     * @return Una stringa che rappresenta la dichiarazione di classe principale nel formato corretto.
     */
    @Override
    public String toString() {
        return "class " + this.idClass.toString() + " public static void main(String[] args) {\n"
                + "System.out.println(" + this.exp.toString() + ");\n}";
    }
}
