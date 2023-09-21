package ASTnodes.Decl;

import java.util.ArrayList;

import ASTnodes.Class.Body;
import ASTnodes.Class.NodeId;
import TypeDescriptor.TypeDescriptor;

/**
 * Rappresenta la dichiarazione di un metodo nel programma.
 */
public class MethDecl extends Decl {

    private ArrayList<VarDecl> formals;
    private TypeDescriptor retType;
    private NodeId id;
    private Body body;
    private int lastLine;

    /**
     * Crea una nuova dichiarazione di metodo con il tipo di ritorno, la lista dei parametri formali,
     * il tipo di ritorno, il nome del metodo, il corpo del metodo e le linee di inizio e fine specificate.
     *
     * @param type     Il tipo di ritorno del metodo.
     * @param formals  La lista dei parametri formali del metodo.
     * @param retType  Il tipo di ritorno del metodo.
     * @param name     Il nome del metodo.
     * @param body     Il corpo del metodo.
     * @param line     La linea di inizio del metodo.
     * @param lastLine La linea di fine del metodo.
     */
    public MethDecl(TypeDescriptor type, ArrayList<VarDecl> formals, TypeDescriptor retType, NodeId name, Body body, int line, int lastLine) {
        super(type, line);
        this.formals = formals;
        this.retType = retType;
        this.id = name;
        this.body = body;
        this.lastLine = lastLine;
    }

    /**
     * Restituisce la lista dei parametri formali del metodo.
     *
     * @return La lista dei parametri formali del metodo.
     */
    public ArrayList<VarDecl> getFormals() {
        return formals;
    }

    /**
     * Restituisce il tipo di ritorno del metodo.
     *
     * @return Il tipo di ritorno del metodo.
     */
    public TypeDescriptor getRetType() {
        return retType;
    }

    /**
     * Restituisce il nome del metodo.
     *
     * @return Il nome del metodo.
     */
    public NodeId getId() {
        return id;
    }

    /**
     * Restituisce il corpo del metodo.
     *
     * @return Il corpo del metodo.
     */
    public Body getBody() {
        return body;
    }

    /**
     * Restituisce la linea di fine del metodo.
     *
     * @return La linea di fine del metodo.
     */
    public int getLastLine() {
        return lastLine;
    }

    /**
     * Imposta la linea di fine del metodo.
     *
     * @param lastLine La linea di fine del metodo da impostare.
     */
    public void setLastLine(int lastLine) {
        this.lastLine = lastLine;
    }

    /**
     * Restituisce una rappresentazione testuale della dichiarazione del metodo.
     *
     * @return Una stringa che rappresenta la dichiarazione del metodo nel formato corretto.
     */
    @Override
    public String toString() {
        String acc = "public " + this.getType() + " " + this.retType.toString() + " " + this.id.getName() + "(";
        for (VarDecl v : this.getFormals()) {
            if (this.getFormals().indexOf(v) == this.getFormals().size() - 1) {
                acc = acc.concat(" " + v.toString() + " ");
            } else {
                acc = acc.concat(" " + v.toString() + ",");
            }
        }

        acc = acc.concat("){\n" + this.body.toString() + "\n}");
        return acc;
    }
}

