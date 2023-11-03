package coeffectChecking.ResultGenerator;

import java.util.ArrayList;

import coeffectChecking.Coeffect.Coef;
import coeffectChecking.Coeffect.Coeffect;
import coeffectChecking.Coeffect.VarCoeff;
import coeffectChecking.Coeffect.CoeffectTable.Element;
import parser.ASTnodes.Class.NodeAST;
import parser.ASTnodes.Class.NodeId;
import parser.ASTnodes.Decl.ClassDecl;
import typeChecking.Attributes.Attribute;
import typeChecking.Attributes.ClassAttribute;
import typeChecking.SymbolTable.ClassSymbolTable;
import typeChecking.TypeDescriptor.ClassTypeDescriptor;
import typeChecking.TypeDescriptor.CoeffectTypeDescriptor;
import typeChecking.TypeDescriptor.MethTypeDescriptor;

/**
 * Classe per la composizione del codice sorgente MiniJava risultante dalla co-inferenza dei coeffetti.
 */
public class SurceCodeComposer {

    private ClassSymbolTable classST;
    private String codiceSorgente = " ";
    private String destinazioneFile;
    private ArrayList<NodeAST> ASt;
    /**
     * Costruttore della classe.
     *
     * @param ASt           L'elenco dei nodi dell'AST MiniJava.
     * @param classST       La tabella dei simboli delle classi.
     * @param indirizzoFile L'indirizzo completo del file in cui scrivere il codice sorgente.
     */
    public SurceCodeComposer(ArrayList<NodeAST> ASt, ClassSymbolTable classST, String indirizzoFile) {
        this.setDestinazioneFile(destinazioneFile);
        this.setClassST(classST);
        
        this.codiceSorgente = this.codiceSorgente.concat("package coeffectChecking.ResultGenerator;");
        this.ASt = ASt;
        for (NodeAST node : this.ASt) {
            if (node instanceof ClassDecl) {
                ClassDecl c = (ClassDecl) node;
                if (((ClassTypeDescriptor) c.getType()).isCoeff() == Coef.COEFF || ((ClassTypeDescriptor) c.getType()).isCoeff() == Coef.AUXCOEF) {
                    this.codiceSorgente = this.codiceSorgente.concat(c.toString());
                }
            }
        }
        this.codiceSorgente = this.codiceSorgente.concat("public class CoeffectResult {\n" + "\tpublic static void main(String[] args) {\n");
        this.visitClassST();
    }

    /**
     * Metodo privato per visitare la tabella dei simboli delle classi e generare il codice sorgente risultante.
     */
    private void visitClassST() {
        for (String id : this.classST.ST().keySet()) {
            // Aggiungo a codice sorgente una System.out.println del nome della classe
            if (this.classST.lookup(id).getIsCoeff() == Coef.NOTCOEF) {
                this.codiceSorgente = this.codiceSorgente.concat(this.syspl("------------------------", "------------------------"));
                this.codiceSorgente = this.codiceSorgente.concat(this.syspl(id, "Classe | "));
                this.codiceSorgente = this.codiceSorgente.concat(this.syspl("------------------------", "------------------------"));
                this.visitSTOfClass(this.classST.lookup(id));
            }
        }
        this.codiceSorgente = this.codiceSorgente.concat("\t}\n}\n");
    }

    /**
     * Metodo privato per visitare la tabella dei simboli di una classe specifica e generare il codice sorgente corrispondente.
     *
     * @param cAttr L'attributo di classe associato alla classe specifica.
     */
    private void visitSTOfClass(ClassAttribute cAttr) {
        for (NodeId id : cAttr.getST().getSymbolTable().keySet()) {
            if (cAttr.getST().lookup(id).getType() instanceof MethTypeDescriptor) {
            	if(!((MethTypeDescriptor)cAttr.getST().lookup(id).getType()).isAbstract()) {
                // Aggiungo a codice sorgente una System.out.println del nome del metodo
                this.codiceSorgente = this.codiceSorgente.concat(this.syspl(id.getName(), "\tMetodo | "));
                this.codiceSorgente = this.codiceSorgente.concat(this.syspl("----------------", "\t------------------------"));
                this.codiceSorgente = this.codiceSorgente.concat(this.syspl("", "\tVariabili | "));
                this.codiceSorgente = this.codiceSorgente.concat(this.syspl("----------------", "\t------------------------"));
                this.visitMethCoeffTable(cAttr.getST().lookup(id));
                this.codiceSorgente = this.codiceSorgente.concat(this.syspl("----------------", "\t------------------------"));
            	}
            }
        }
    }

    /**
     * Metodo privato per visitare la tabella dei coeffetti di un metodo e generare il codice sorgente corrispondente.
     *
     * @param attr L'attributo di classe associato al metodo.
     */
    private void visitMethCoeffTable(Attribute attr) {
        for (Element el : attr.getCoef().getCoeffectTable()) {
            VarCoeff coeffect = this.findCoef(attr, el.id);

            Coeffect cf = new Coeffect(coeffect.fromExpToEclipseExp(), coeffect.getClassCoeff().toString());
            if (el.coef.getCoefClass().toString().contains("Triv")) {
                this.codiceSorgente = this.codiceSorgente.concat(this.sys("\"" + el.id + " |\"" + "+" + "true" + "", ""));
                this.codiceSorgente = this.codiceSorgente.concat(this.syspl("----------------", "\t------------------------"));
            } else if (cf.getClass().toString().contains("Triv")) {
                this.codiceSorgente = this.codiceSorgente.concat(this.sys("\"" + el.id + " |\"" + "+" + "false" + "", ""));
                this.codiceSorgente = this.codiceSorgente.concat(this.syspl("----------------", "\t------------------------"));
            } else {
                this.codiceSorgente = this.codiceSorgente.concat(this.sys("\""+"\t" + el.id + " |\"" + "+" + el.coef.op(cf, "leq"), " "));
                this.codiceSorgente = this.codiceSorgente.concat(this.sys("\"" + "\tcoeffetto variabile: \"" + "+" + "\"" + cf.getCoefExpr() + "\"", ""));
                this.codiceSorgente = this.codiceSorgente.concat(this.sys("\"" + "\tcoeffetto inferito: \"" + "+" + "(" + el.coef + ")" + ".getClass().getSimpleName()", ""));
                this.codiceSorgente = this.codiceSorgente.concat(this.syspl("----------------", "\t------------------------"));
            }
        }
    }

    /**
     * Metodo privato per trovare un coeffetto in un attributo di classe specifico.
     *
     * @param attr L'attributo di classe in cui cercare il coeffetto.
     * @param id   Il nome del coeffetto da cercare.
     * @return Il coeffetto trovato o null se non presente.
     */
    private VarCoeff findCoef(Attribute attr, String id) {
        for (NodeId nId : attr.getFormals().getSymbolTable().keySet()) {
            if (nId.getName().equals(id)) {
                return ((CoeffectTypeDescriptor) attr.getFormals().lookup(nId).getType()).getVarCoeff();
            }
        }
        for (NodeId nId : attr.getLocal().getSymbolTable().keySet()) {
            if (nId.getName().equals(id)) {
                return ((CoeffectTypeDescriptor) attr.getLocal().lookup(nId).getType()).getVarCoeff();
            }
        }
        return null;
    }

    /**
     * Metodo privato per generare una riga di codice sorgente System.out.println con una nuova linea.
     *
     * @param id   Il contenuto da stampare.
     * @param tipo Il tipo di stampa (es. "Metodo | ").
     * @return La stringa completa per la stampa.
     */
    private String syspl(String id, String tipo) {
        return "\t\tSystem.out.println(\"" + tipo + id + "\");\n";
    }

    /**
     * Metodo privato per generare una riga di codice sorgente System.out.println senza nuova linea.
     *
     * @param id   Il contenuto da stampare.
     * @param tipo Il tipo di stampa (es. "Metodo | ").
     * @return La stringa completa per la stampa.
     */
    private String sys(String id, String tipo) {
        return "\t\tSystem.out.println(" + tipo + id + ");\n";
    }

    /**
     * Restituisce il percorso del file di destinazione in cui verrà scritto il codice sorgente generato.
     *
     * @return Il percorso del file di destinazione.
     */
    public String getDestinazioneFile() {
        return destinazioneFile;
    }

    /**
     * Imposta il percorso del file di destinazione in cui verrà scritto il codice sorgente generato.
     *
     * @param destinazioneFile Il percorso del file di destinazione.
     */
    public void setDestinazioneFile(String destinazioneFile) {
        this.destinazioneFile = destinazioneFile;
    }

    /**
     * Restituisce la tabella dei simboli delle classi utilizzata per la generazione del codice sorgente.
     *
     * @return La tabella dei simboli delle classi.
     */
    public ClassSymbolTable getClassST() {
        return classST;
    }

    /**
     * Imposta la tabella dei simboli delle classi utilizzata per la generazione del codice sorgente.
     *
     * @param classST La tabella dei simboli delle classi.
     */
    public void setClassST(ClassSymbolTable classST) {
        this.classST = classST;
    }

    /**
     * Restituisce il codice sorgente MiniJava generato dalla co-inferenza dei coeffetti.
     *
     * @return Il codice sorgente MiniJava.
     */
    public String getCodiceSorgente() {
        return codiceSorgente;
    }

    /**
     * Imposta il codice sorgente MiniJava generato dalla co-inferenza dei coeffetti.
     *
     * @param codiceSorgente Il codice sorgente MiniJava.
     */
    public void setCodiceSorgente(String codiceSorgente) {
        this.codiceSorgente = codiceSorgente;
    }
}
