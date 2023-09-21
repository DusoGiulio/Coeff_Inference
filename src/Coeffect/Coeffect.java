package Coeffect;

/**
 * La classe Coeffect rappresenta un coeffetto che può essere utilizzato
 * per rappresentare il co-effetto associato a variabili di tipo co-effetto.
 * La classe fornisce metodi per effettuare operazioni tra coeffetti.
 */
public class Coeffect {

    private String coefExpr;
    private String coefClass;

    /**
     * Crea un nuovo coeffetto con l'espressione e la classe specificate.
     * 
     * @param coefExpr  L'espressione associata al coeffetto.
     * @param coefClass La classe di coeffetto (ad esempio, "Nat" o "Triv").
     */
    public Coeffect(String coefExpr, String coefClass) {
        this.coefExpr = coefExpr;
        this.coefClass = coefClass;
    }

    /**
     * Restituisce l'espressione associata al coeffetto.
     * 
     * @return L'espressione associata al coeffetto.
     */
    public String getCoefExpr() {
        return this.coefExpr;
    }

    /**
     * Imposta l'espressione associata al coeffetto.
     * 
     * @param coefExpr La nuova espressione da associare al coeffetto.
     */
    public void setCoefExpr(String coefExpr) {
        this.coefExpr = coefExpr;
    }

    /**
     * Restituisce la classe di coeffetto associata.
     * 
     * @return La classe di coeffetto (ad esempio, "Nat" o "Triv").
     */
    public String getCoefClass() {
        return this.coefClass;
    }

    /**
     * Imposta la classe di coeffetto associata.
     * 
     * @param coefClass La nuova classe di coeffetto da associare.
     */
    public void setCoefClass(String coefClass) {
        this.coefClass = coefClass;
    }

    /**
     * Esegue l'operazione di "sup" tra questo coeffetto e un altro coeffetto.
     * 
     * @return Il risultato dell'operazione "sup".
     */
    public Coeffect supOne() {
        if (this.coefClass.equals("Nat")) {
            return this.op(new Coeffect("Nat.one()", "Nat"), "sup");
        } else {
            return this.op(new Coeffect("Nat.one()", "Nat"), "sup");
        }
    }

    /**
     * Esegue un'operazione tra questo coeffetto e un altro coeffetto specificato.
     * 
     * @param coef L'altro coeffetto con cui effettuare l'operazione.
     * @param op   L'operazione da eseguire (ad esempio, "sup", "mult", ecc.).
     * @return Il risultato dell'operazione specificata tra i coeffetti.
     */
    public Coeffect op(Coeffect coef, String op) {
        if (this.coefClass.equals(coef.coefClass)) {
            return sameClass(op, coef);
        } else if (this.coefClass.equals("Nat") && !coef.coefClass.equals("Nat")) {
            return thisNatClass(op, coef);
        } else if (!this.coefClass.equals("Nat") && coef.coefClass.equals("Nat")) {
            return otherNatClass(op, coef);
        } else {
            return noNatClass(op, coef);
        }
    }

    private Coeffect sameClass(String op, Coeffect other) {
        return new Coeffect(this.coefExpr + "." + op + "(" + other.coefExpr + ")", other.coefClass);
    }

    private Coeffect thisNatClass(String op, Coeffect other) {
        String exp = "(" + other.coefClass + ".fromNat(" + this.coefExpr + "))." + op + "(" + other.coefExpr + ")";
        return new Coeffect(exp, other.coefClass);
    }

    private Coeffect otherNatClass(String op, Coeffect other) {
        String exp = this.coefExpr + "." + op + "(" + this.coefClass + ".fromNat(" + other.coefExpr + "))";
        return new Coeffect(exp, this.coefClass);
    }

    private Coeffect noNatClass(String op, Coeffect other) {
        return new Coeffect("new Triv()", "Triv");
    }
    
    /**
     * Duplica il coeffetto corrente.
     * 
     * @return Una copia del coeffetto corrente.
     */
    public Coeffect duplicate() {
        return new Coeffect(this.coefExpr, this.coefClass);
    }


    /**
     * Restituisce la rappresentazione testuale del coeffetto.
     * 
     * @return La rappresentazione testuale del coeffetto.
     */
    @Override
    public String toString() {
        return "(" + this.coefExpr + ")";
    }
}
