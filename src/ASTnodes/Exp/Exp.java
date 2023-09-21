package ASTnodes.Exp;

import ASTnodes.Class.NodeAST;

/**
 * Rappresenta un'espressione nell'Abstract Syntax Tree (AST) del programma.
 */
public abstract class Exp extends NodeAST {
    
    /**
     * La linea in cui appare questa espressione nell'origine del programma.
     */
    private int line;

    /**
     * Crea una nuova espressione con la linea in cui appare.
     *
     * @param line La linea in cui appare l'espressione nel programma.
     */
    public Exp(int line) {
        super();
        this.line = line;
    }

    /**
     * Restituisce la linea in cui appare questa espressione nel programma.
     *
     * @return La linea in cui appare l'espressione nel programma.
     */
    public int getLine() {
        return line;
    }

    /**
     * Imposta la linea in cui appare questa espressione nel programma.
     *
     * @param line La linea in cui appare l'espressione nel programma.
     */
    public void setLine(int line) {
        this.line = line;
    }
}
