package typeChecking.Attributes;

import java.util.ArrayList;

import coeffectChecking.Coeffect.Coef;
import typeChecking.SymbolTable.SymbolTable;
import typeChecking.TypeDescriptor.TypeDescriptor;

/**
 * La classe ClassAttribute rappresenta gli attributi associati a una classe, inclusa la tabella dei simboli,
 * l'eventuale estensione di classe, l'indicatore di visita, la lista delle classi estese e il coeffetto associato.
 */
public class ClassAttribute {
    private SymbolTable ST;
    private String extendClass;
    private boolean visited;
    private ArrayList<String> listofextclass;
    private Coef isCoeff;
    private TypeDescriptor type;

    /**
     * Costruisce un'istanza di ClassAttribute con la tabella dei simboli specificata e l'eventuale estensione di classe.
     *
     * @param sT          La tabella dei simboli associata a questa classe.
     * @param extendClass Il nome della classe estesa, se presente; altrimenti, null.
     */
    public ClassAttribute(SymbolTable sT, String extendClass, TypeDescriptor typeDescriptor) {
        super();
        ST = sT;
        this.extendClass = extendClass;
        this.visited = false;
        this.listofextclass = null;
        this.isCoeff = Coef.NOTCOEF;
        this.type=typeDescriptor;
    }

    /**
     * Restituisce la tabella dei simboli associata a questa classe.
     *
     * @return La tabella dei simboli associata a questa classe.
     */
    public SymbolTable getST() {
        return ST;
    }

    /**
     * Restituisce il nome della classe estesa, se presente.
     *
     * @return Il nome della classe estesa; altrimenti, null.
     */
    public String getExtendClass() {
        return extendClass;
    }

    /**
     * Verifica se questa classe è stata visitata.
     *
     * @return True se la classe è stata visitata, altrimenti false.
     */
    public boolean isVisited() {
        return visited;
    }

    /**
     * Imposta lo stato di visita di questa classe.
     *
     * @param visited True se la classe è stata visitata, altrimenti false.
     */
    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    /**
     * Restituisce la lista delle classi estese da questa classe.
     *
     * @return La lista delle classi estese.
     */
    public ArrayList<String> getListofextclass() {
        return listofextclass;
    }

    /**
     * Imposta la lista delle classi estese da questa classe.
     *
     * @param listofextclass La lista delle classi estese da questa classe.
     */
    public void setListofextclass(ArrayList<String> listofextclass) {
        this.listofextclass = listofextclass;
    }

    /**
     * Restituisce il coeffetto associato a questa classe.
     *
     * @return Il coeffetto associato a questa classe.
     */
    public Coef getIsCoeff() {
        return isCoeff;
    }

    /**
     * Imposta il coeffetto associato a questa classe.
     *
     * @param isCoeff Il coeffetto da associare a questa classe.
     */
    public void setIsCoeff(Coef isCoeff) {
        this.isCoeff = isCoeff;
    }

	public TypeDescriptor getType() {
		return type;
	}

	public void setType(TypeDescriptor type) {
		this.type = type;
	}
}

