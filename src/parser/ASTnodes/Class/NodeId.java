package parser.ASTnodes.Class;

import typeChecking.TypeDescriptor.TypeDescriptor;


/**
 * Rappresenta un identificatore associato a un tipo in un nodo dell'AST.
 */
public class NodeId extends NodeAST {

	private String name;	
	private TypeDescriptor type;
	 /**
     * Crea un nuovo oggetto NodeId con un tipo e un nome specificati.
     *
     * @param type Il tipo associato all'identificatore.
     * @param name Il nome dell'identificatore.
     */
	public NodeId(TypeDescriptor type,String name) {
		this.setName(name);
		this.setType(type);
	}
    /**
     * Restituisce il nome dell'identificatore.
     *
     * @return Il nome dell'identificatore.
     */
	public String getName() {
		return name;
	}
    /**
     * Imposta il nome dell'identificatore.
     *
     * @param name Il nome dell'identificatore da impostare.
     */
	public void setName(String name) {
		this.name = name;
	}
    /**
     * Restituisce il tipo associato all'identificatore.
     *
     * @return Il tipo associato all'identificatore.
     */
	public TypeDescriptor getType() {
		return type;
	}
    /**
     * Imposta il tipo associato all'identificatore.
     *
     * @param type Il tipo da associare all'identificatore.
     */
	public void setType(TypeDescriptor type) {
		this.type = type;
	}
    /**
     * Restituisce una rappresentazione in stringa dell'identificatore (il suo nome).
     *
     * @return Il nome dell'identificatore in formato stringa.
     */
	@Override
	public String toString() 
	{
		return this.name;
	}

}
