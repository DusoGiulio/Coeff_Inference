package parser.ASTnodes.Class;

import java.util.ArrayList;

import parser.ASTnodes.Decl.Decl;
import parser.ASTnodes.Decl.VarDecl;
import parser.ASTnodes.Exp.Exp;
import parser.ASTnodes.Stm.Stm;
import typeChecking.TypeDescriptor.TypeDescriptor;


/**
 * Rappresenta il corpo di un metodo all'interno di una classe.
 */
public class Body extends Decl {
	private ArrayList<VarDecl> decs;
	private ArrayList<Stm> stms;
	private Exp retExp;


    /**
     * Crea un nuovo oggetto `Body` con il tipo specificato, dichiarazioni di variabili, istruzioni e un'espressione di ritorno.
     *
     * @param type   Il tipo di ritorno del corpo del metodo.
     * @param decs   Le dichiarazioni di variabili all'interno del corpo del metodo.
     * @param stms   Le istruzioni all'interno del corpo del metodo.
     * @param retExp L'espressione di ritorno del corpo del metodo.
     */
	public Body(TypeDescriptor type, ArrayList<VarDecl> decs, ArrayList<Stm> stms, Exp retExp) {
		super(type,0);
		this.decs = decs;
		this.stms = stms;
		this.retExp = retExp;
	}
	   /**
     * Restituisce le dichiarazioni di variabili all'interno del corpo del metodo.
     *
     * @return Le dichiarazioni di variabili.
     */
	public ArrayList<VarDecl> getDecs() {
		return decs;
	}

    /**
     * Restituisce le istruzioni all'interno del corpo del metodo.
     *
     * @return Le istruzioni.
     */
	public ArrayList<Stm> getStms() {
		return stms;
	}

    /**
     * Restituisce l'espressione di ritorno del corpo del metodo.
     *
     * @return L'espressione di ritorno.
     */
	public Exp getRetExp() {
		return retExp;
	}
    /**
     * Restituisce una rappresentazione testuale del corpo del metodo.
     *
     * @return Una stringa che rappresenta il corpo del metodo.
     */
	@Override
	public String toString() {
		String acc= new String();
		for(VarDecl v: this.decs) 
		{
			acc=acc.concat(v.toString()+";\n");
		}
		for(Stm s: this.stms) 
		{
			acc=acc.concat(s.toString());
		}
		acc=acc.concat("\n return "+this.retExp.toString()+";");
		return  acc;
	}

}
