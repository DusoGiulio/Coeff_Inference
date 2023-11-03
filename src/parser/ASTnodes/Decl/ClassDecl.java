package parser.ASTnodes.Decl;

import java.util.ArrayList;

import parser.ASTnodes.Class.NodeId;
import typeChecking.TypeDescriptor.TypeDescriptor;

/**
 * Rappresenta la dichiarazione di una classe nel programma.
 */
public class ClassDecl extends Decl {
    private ArrayList<FieldDecl> vars;
    private ArrayList<MethDecl> mets;
    private NodeId IdClass;
    private NodeId Idextends;

    /**
     * Crea una nuova dichiarazione di classe con il tipo, il nome della classe,
     * il nome della classe padre (se presente), le dichiarazioni dei campi e le
     * dichiarazioni dei metodi.
     *
     * @param type     Il tipo della classe.
     * @param nome     Il nome della classe.
     * @param parent   Il nome della classe padre (null se assente).
     * @param vars     Le dichiarazioni dei campi della classe.
     * @param met      Le dichiarazioni dei metodi della classe.
     * @param line     Il numero di linea in cui appare la dichiarazione di classe.
     */
    public ClassDecl(TypeDescriptor type, NodeId nome, NodeId parent, ArrayList<FieldDecl> vars, ArrayList<MethDecl> met, int line) {
        super(type, line);
        this.vars = vars;
        this.mets = met;
        this.IdClass = nome;
        this.Idextends = parent;
    }

    /**
     * Restituisce l'elenco delle dichiarazioni dei campi della classe.
     *
     * @return Una lista di oggetti FieldDecl rappresentanti le dichiarazioni dei campi.
     */
    public ArrayList<FieldDecl> getVars() {
        return vars;
    }

    /**
     * Restituisce l'elenco delle dichiarazioni dei metodi della classe.
     *
     * @return Una lista di oggetti MethDecl rappresentanti le dichiarazioni dei metodi.
     */
    public ArrayList<MethDecl> getMets() {
        return mets;
    }

    /**
     * Restituisce il nome della classe.
     *
     * @return Un oggetto NodeId rappresentante il nome della classe.
     */
    public NodeId getIdClass() {
        return IdClass;
    }

    /**
     * Restituisce il nome della classe padre (se presente).
     *
     * @return Un oggetto NodeId rappresentante il nome della classe padre o null se assente.
     */
    public NodeId getIdextends() {
        return Idextends;
    }

    /**
     * Restituisce una rappresentazione in stringa della dichiarazione di classe.
     *
     * @return Una stringa contenente la dichiarazione di classe formattata.
     */
    @Override
    public String toString() {
        String acc = new String();
        if (this.Idextends != null) {
            acc = acc.concat("\n class " + this.IdClass.toString() + " extends " + this.Idextends.toString() + " { \n");
        } else {
            acc = acc.concat("\n class " + this.IdClass.toString() + " {\n ");
        }

        for (FieldDecl f : this.vars) {
            acc = acc.concat("\n" + f.toString() + ";\n");
        }
        for (MethDecl m : this.mets) {
            acc = acc.concat("\n" + m.toString() + "\n");
        }
        acc = acc.concat("\n}");
        return acc;
    }
}

