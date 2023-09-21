package SymbolTable;

import java.util.Hashtable;
import Attributes.ClassAttribute;

/**
 * Questa classe rappresenta una tabella dei simboli per le classi.
 * Contiene un insieme di attributi di classe indicizzati per nome.
 */
public class ClassSymbolTable {
    private Hashtable<String, ClassAttribute> SymbolTable;

    /**
     * Costruisce una nuova tabella dei simboli per le classi.
     */
    public ClassSymbolTable() {
        this.SymbolTable = new Hashtable<String, ClassAttribute>();
    }

    /**
     * Inserisce un attributo di classe nella tabella dei simboli.
     *
     * @param name Il nome dell'attributo di classe da inserire.
     * @param attr L'attributo di classe da inserire nella tabella.
     */
    public void enter(String name, ClassAttribute attr) {
        this.SymbolTable.put(name, attr);
    }

    /**
     * Cerca un attributo di classe nella tabella dei simboli.
     *
     * @param name Il nome dell'attributo di classe da cercare.
     * @return L'attributo di classe associato al nome specificato o null se non trovato.
     */
    public ClassAttribute lookup(String name) {
        return this.SymbolTable.get(name);
    }

    /**
     * Restituisce la tabella dei simboli completa contenente tutti gli attributi di classe.
     *
     * @return La tabella dei simboli contenente tutti gli attributi di classe.
     */
    public Hashtable<String, ClassAttribute> ST() {
        return this.SymbolTable;
    }
}

