package coeffectChecking.Coeffect;

import java.util.ArrayList;
/**
 * La classe CoeffectTable rappresenta una tabella di coeffetti, che associa identificatori a coeffetti.
 * È utilizzata per gestire il coeffetto nelle operazioni tra coeffetti.
 */
public class CoeffectTable {
	private ArrayList<Element> coeffectTable;
	/**
     * Crea una nuova tabella di coeffetti inizializzata vuota.
     */
	public CoeffectTable() 
	{
		this.coeffectTable=new ArrayList<Element>();
	}
	 /**
     * Restituisce la lista di elementi della tabella di coeffetti.
     * 
     * @return La lista di elementi della tabella di coeffetti.
     */
	public ArrayList<Element> getCoeffectTable() {
		return this.coeffectTable;
	}

    /**
     * Imposta la lista di elementi della tabella di coeffetti.
     * 
     * @param coeffectTable La nuova lista di elementi della tabella di coeffetti.
     */
	public void setCoeffectTable(ArrayList<Element>coeffectTable) {
		this.coeffectTable = coeffectTable;
	}
    /**
     * Aggiunge un elemento (identificatore e coeffetto associato) alla tabella di coeffetti.
     * 
     * @param id   L'identificatore da aggiungere.
     * @param coef Il coeffetto associato all'identificatore.
     */
	public void addElement(String id, Coeffect coef) 
	{
		this.coeffectTable.add(new Element(id, coef));
	}
    /**
     * Trova un coeffetto associato a un determinato identificatore nella tabella di coeffetti.
     * 
     * @param id L'identificatore da cercare.
     * @return Il coeffetto associato all'identificatore o null se l'identificatore non è presente nella tabella.
     */
	public	Coeffect findElement(String id) 
	{
		for(Element el: this.coeffectTable) 
		{
			if(el.id.equals(id)) 
			{
				return el.coef;
			}
		}
		return null;
	}
	
	private CoeffectTable action(CoeffectTable cft, String op) 
	{
		CoeffectTable retTab= new CoeffectTable();

		for(Element el: this.coeffectTable) 
		{
			for(Element elem: cft.getCoeffectTable()) 
			{
				if(elem.id.equals(el.id)) {
					elem.coef=this.findElement(el.id).op(cft.findElement(elem.id),op);
					if(retTab.findElement(elem.id)!=null) 
					{
						retTab.findElement(elem.id).setCoefExpr(elem.coef.getCoefExpr());
						retTab.findElement(elem.id).setCoefClass(elem.coef.getCoefClass());
					}else
					{
						retTab.getCoeffectTable().add(elem);
					}
				}else 
				{
					if(retTab.findElement(el.id)==null) 
					{
						retTab.getCoeffectTable().add(el);
					}
					if(retTab.findElement(elem.id)==null) 
					{
						retTab.getCoeffectTable().add(elem);
					}
				}
				
			}
		}
		if(this.coeffectTable.size()==0 && cft.coeffectTable.size()!=0 ) 
		{
			retTab.coeffectTable.addAll(cft.coeffectTable);
		}
		if(cft.coeffectTable.size()==0 && this.coeffectTable.size()!=0) 
		{
			retTab.coeffectTable.addAll(this.coeffectTable);
		}
		return retTab;
	}
	 /**
     * Esegue l'operazione di somma tra due tabelle di coeffetti.
     * 
     * @param cft La seconda tabella di coeffetti da sommare.
     * @return Una nuova tabella di coeffetti risultante dalla somma.
     */
	public CoeffectTable sum(CoeffectTable cft) 
	{
		return this.action(cft, "sum");
	}
	   /**
     * Esegue l'operazione di incremento tra due tabelle di coeffetti.
     * 
     * @param cft La seconda tabella di coeffetti con cui calcolare l'incremento.
     * @return Una nuova tabella di coeffetti risultante dall'incremento.
     */
	public CoeffectTable sup(CoeffectTable cft) 
	{
		return this.action(cft, "sup");
	}
    /**
     * Esegue l'operazione di moltiplicazione tra tutti i coeffetti della tabella e un coeffetto dato.
     * 
     * @param cf Il coeffetto con cui eseguire la moltiplicazione.
     * @return Una nuova tabella di coeffetti risultante dalla moltiplicazione.
     */
	public CoeffectTable mult(Coeffect cf) 
	{
		CoeffectTable retTab= new CoeffectTable();
		for(Element el: this.coeffectTable) 
		{
			Coeffect coef=cf.op(el.coef,"mult");
			el.coef.setCoefExpr(coef.getCoefExpr());
			el.coef.setCoefClass(coef.getCoefClass());
			retTab.getCoeffectTable().add(el);
		}
		return retTab;
	}
    /**
     * Esegue l'operazione di minore o uguale tra tutti i coeffetti della tabella e un coeffetto dato.
     * 
     * @param cf Il coeffetto con cui eseguire l'operazione di minore o uguale.
     * @return Una nuova tab di coeffetti risultante dal'operazione di minore o uguale.
     */
	public CoeffectTable leq(Coeffect cf) 
	{
		CoeffectTable retTab= new CoeffectTable();
		for(Element el: this.coeffectTable) 
		{
			Coeffect coef=cf.op(el.coef,"leq");
			el.coef.setCoefExpr(coef.getCoefExpr());
			el.coef.setCoefClass(coef.getCoefClass());
			retTab.getCoeffectTable().add(el);
		}
		return retTab;
	}
	
	@Override
	public String toString() 
	{
		return this.getCoeffectTable().toString();
	}
	
	
	

	 /**
     * Classe interna che rappresenta un elemento nella tabella di coeffetti.
     */
	public static class Element 
	{
		public String id;
		public Coeffect coef;
		/**
         * Crea un nuovo elemento con un identificatore e un coeffetto associato.
         * 
         * @param id   L'identificatore dell'elemento.
         * @param coef Il coeffetto associato all'elemento.
         */
		public Element(String id, Coeffect coef) {
			this.id=id;
			this.coef=coef;
		}
		 /**
         * Restituisce una rappresentazione testuale dell'elemento nella forma "[identificatore: coeffetto]".
         * 
         * @return La rappresentazione testuale dell'elemento.
         */
		@Override
		public String toString() 
		{
			return "["+this.id+":"+coef.toString()+"]";
		}
	}


	public void removeId(String id) {
	    Element elementToRemove = null;
	    for (Element el : this.coeffectTable) {
	        if (el.id.equals(id)) {
	            elementToRemove = el;
	            break;
	        }
	    }
	    
	    if (elementToRemove != null) {
	        this.coeffectTable.remove(elementToRemove);
	    }
		
	}
	
	public CoeffectTable duplicate() {
	    CoeffectTable duplicatedTable = new CoeffectTable();
	    
	    for (Element el : this.coeffectTable) {
	        Element duplicatedElement = new Element(el.id, new Coeffect(el.coef.getCoefExpr(), el.coef.getCoefClass()));
	        duplicatedTable.getCoeffectTable().add(duplicatedElement);
	    }
	    
	    return duplicatedTable;
	}


}
