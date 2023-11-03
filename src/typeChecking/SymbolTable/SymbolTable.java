package typeChecking.SymbolTable;

import java.util.Hashtable;

import parser.ASTnodes.Class.NodeId;
import typeChecking.Attributes.Attribute;

/**
 * Questa classe rappresenta una tabella dei simboli generica utilizzata per gestire attributi e identificatori.
 */
public class SymbolTable {
    private Hashtable<NodeId, Attribute> SymbolTable;

    /**
     * Costruisce una nuova tabella dei simboli.
     */
    public SymbolTable() {
        this.SymbolTable = new Hashtable<NodeId, Attribute>();
    }

    /**
     * Chiude lo scope corrente, eliminando tutti i simboli presenti nella tabella dei simboli.
     */
    public void closeScope() {
        this.SymbolTable.clear();
    }

    /**
     * Inserisce un attributo o un identificatore nella tabella dei simboli.
     *
     * @param name Il nome dell'attributo o dell'identificatore da inserire.
     * @param attr L'attributo o l'identificatore da inserire nella tabella.
     */
    public void enter(NodeId name, Attribute attr) {
        this.SymbolTable.put(name, attr);
    }

    /**
     * Cerca un attributo o un identificatore nella tabella dei simboli.
     *
     * @param name Il nome dell'attributo o dell'identificatore da cercare.
     * @return L'attributo o l'identificatore associato al nome specificato o null se non trovato.
     */
    public Attribute lookup(NodeId name) {
        return this.SymbolTable.get(name);
    }

    /**
     * Restituisce la tabella dei simboli completa contenente tutti gli attributi e identificatori.
     *
     * @return La tabella dei simboli contenente tutti gli attributi e identificatori.
     */
    public Hashtable<NodeId, Attribute> getSymbolTable() {
        return SymbolTable;
    }

    /**
     * Imposta la tabella dei simboli con una nuova tabella specificata.
     *
     * @param symbolTable La nuova tabella dei simboli da impostare.
     */
    public void setSymbolTable(Hashtable<NodeId, Attribute> symbolTable) {
        SymbolTable = symbolTable;
    }
}
