package parser.ASTnodes.Decl;

import parser.ASTnodes.Class.NodeAST;
import typeChecking.TypeDescriptor.TypeDescriptor;

/**
 * Rappresenta una dichiarazione astratta nel programma.
 */
public abstract class Decl extends NodeAST {
    private TypeDescriptor type;
    private int line;

    /**
     * Crea una nuova dichiarazione con il tipo e il numero di linea specificati.
     *
     * @param type Il tipo della dichiarazione.
     * @param line Il numero di linea in cui appare la dichiarazione.
     */
    public Decl(TypeDescriptor type, int line) {
        this.setType(type);
        this.line = line;
    }

    /**
     * Restituisce il tipo della dichiarazione.
     *
     * @return Il tipo della dichiarazione.
     */
    public TypeDescriptor getType() {
        return type;
    }

    /**
     * Imposta il tipo della dichiarazione.
     *
     * @param type Il tipo della dichiarazione da impostare.
     */
    public void setType(TypeDescriptor type) {
        this.type = type;
    }

    /**
     * Restituisce il numero di linea in cui appare la dichiarazione.
     *
     * @return Il numero di linea della dichiarazione.
     */
    public int getLine() {
        return line;
    }

    /**
     * Imposta il numero di linea della dichiarazione.
     *
     * @param line Il numero di linea della dichiarazione da impostare.
     */
    public void setLine(int line) {
        this.line = line;
    }
}
