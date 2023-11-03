package typeChecking.Attributes;

import coeffectChecking.Coeffect.CoeffectTable;
import typeChecking.SymbolTable.SymbolTable;
import typeChecking.TypeDescriptor.TypeDescriptor;

/**
 * La classe Attribute rappresenta gli attributi associati a una determinata entità, come una funzione o una variabile.
 * Questa classe tiene traccia del tipo dell'entità, dei simboli dei parametri formali e delle variabili locali, del tipo
 * di ritorno (se applicabile) e dei coefffetti associate.
 */
public class Attribute {
    private TypeDescriptor type;
    private SymbolTable formals;
    private SymbolTable local;
    private TypeDescriptor retType;
    private CoeffectTable coef;

    /**
     * Costruisce un'istanza di Attribute con il tipo specificato.
     *
     * @param type Il tipo associato a questo attributo.
     */
    public Attribute(TypeDescriptor type) {
        this.setType(type);
    }

    /**
     * Restituisce il tipo associato a questo attributo.
     *
     * @return Il tipo associato a questo attributo.
     */
    public TypeDescriptor getType() {
        return type;
    }

    /**
     * Imposta il tipo associato a questo attributo.
     *
     * @param type Il tipo da associare a questo attributo.
     */
    public void setType(TypeDescriptor type) {
        this.type = type;
    }

    /**
     * Restituisce la tabella dei simboli per i parametri formali.
     *
     * @return La tabella dei simboli per i parametri formali.
     */
    public SymbolTable getFormals() {
        return formals;
    }

    /**
     * Imposta la tabella dei simboli per i parametri formali.
     *
     * @param formals La tabella dei simboli da associare ai parametri formali.
     */
    public void setFormals(SymbolTable formals) {
        this.formals = formals;
    }

    /**
     * Restituisce la tabella dei simboli per le variabili locali.
     *
     * @return La tabella dei simboli per le variabili locali.
     */
    public SymbolTable getLocal() {
        return local;
    }

    /**
     * Imposta la tabella dei simboli per le variabili locali.
     *
     * @param local La tabella dei simboli da associare alle variabili locali.
     */
    public void setLocal(SymbolTable local) {
        this.local = local;
    }

    /**
     * Restituisce il tipo di ritorno associato a questo attributo.
     *
     * @return Il tipo di ritorno associato a questo attributo.
     */
    public TypeDescriptor getRetType() {
        return retType;
    }

    /**
     * Imposta il tipo di ritorno associato a questo attributo.
     *
     * @param retType Il tipo di ritorno da associare a questo attributo.
     */
    public void setRetType(TypeDescriptor retType) {
        this.retType = retType;
    }

    /**
     * Restituisce la tabella dei coeffetti associati a questo attributo.
     *
     * @return La tabella dei coeffetti associata a questo attributo.
     */
    public CoeffectTable getCoef() {
        return coef;
    }

    /**
     * Imposta la tabella dei coeffetti associata a questo attributo.
     *
     * @param coef La tabella dei coeffetti da associare a questo attributo.
     */
    public void setCoef(CoeffectTable coef) {
        this.coef = coef;
    }
}
