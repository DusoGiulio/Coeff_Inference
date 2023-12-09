 package coeffectChecking.ResultGenerator;
 class Affinity {
 
public  Affinity sup( Affinity x ){
Affinity result;
if (this.leq(x)) {
result=x;
} else {
result=this;
}
 return result;
}

public  boolean leq( Affinity x ){

 return true;
}

public  Affinity sum( Affinity x ){

 return x;
}

public  Affinity mult( Affinity x ){

 return this;
}

public static Affinity zero(){

 return new ZeroA();
}

public static Affinity one(){

 return new One();
}

public static Affinity fromNat( Nat n ){
Affinity result;
Succ succ;
if ((n instanceof Succ)) {

succ=((Succ)n);

result=Affinity.fromNat(succ.getPred());

result=result.sum(Affinity.one());

} else {
result=Affinity.zero();
}
 return result;
}

}
 class ZeroA extends Affinity { 

}
 class One extends Affinity { 

public  boolean leq( Affinity x ){

 return !(x instanceof ZeroA);
}

public  Affinity sum( Affinity x ){
Affinity result;
if ((x instanceof ZeroA)) {
result=this;
} else {
result=new Omega();
}
 return result;
}

public  Affinity mult( Affinity x ){

 return x;
}

}
 class Omega extends Affinity { 

public  boolean leq( Affinity x ){

 return (x instanceof Omega);
}

public  Affinity sum( Affinity x ){

 return this;
}

public  Affinity mult( Affinity x ){
Affinity result;
if ((x instanceof ZeroA)) {
result=x;
} else {
result=this;
}
 return result;
}

}
 class Nat {
 
public  boolean leq( Nat x ){

 return true;
}

public  Nat sup( Nat x ){
Nat result;
if (this.leq(x)) {

result=x;

} else {

result=this;

}
 return result;
}

public  Nat sum( Nat x ){

 return x;
}

public  Nat mult( Nat x ){

 return this;
}

public static Nat zero(){

 return new Zero();
}

public static Nat one(){
Nat result;
result=new Succ().setPred(Nat.zero());
 return result;
}

public static Nat fromNat( Nat n ){

 return n;
}

}
 class Succ extends Nat { 

Nat pred;

public  Nat setPred( Nat p ){
pred=p;
 return this;
}

public  Nat getPred(){

 return pred;
}

public  boolean leq( Nat x ){
boolean result;
if ((x instanceof Zero)) {
result=false;
} else {
result=pred.leq(((Succ)x).getPred());
}
 return result;
}

public  Nat sum( Nat x ){
Nat result;
result=new Succ().setPred(pred.sum(x));
 return result;
}

public  Nat mult( Nat x ){
Nat result;
if ((x instanceof Zero)) {
result=x;
} else {
result=pred.mult(x).sum(x);
}
 return result;
}

}
 class Triv {
 
public  boolean leq( Triv t ){

 return true;
}

public  Triv sup( Triv t ){

 return this;
}

public  Triv sum( Triv t ){

 return this;
}

public  Triv mult( Triv t ){

 return this;
}

public static Triv zero(){

 return new Triv();
}

public static Triv one(){

 return new Triv();
}

public static Triv fromNat( Nat n ){

 return new Triv();
}

}
 class Zero extends Nat { 

}public class CoeffectResult {
	public static void main(String[] args) {
		System.out.println("------------------------------------------------");
		System.out.println("Classe | A");
		System.out.println("------------------------------------------------");
		System.out.println("	Metodo | drop");
		System.out.println("	----------------------------------------");
		System.out.println("	Variabili | ");
		System.out.println("	----------------------------------------");
		System.out.println("	----------------------------------------");
		System.out.println("	Metodo | setFields");
		System.out.println("	----------------------------------------");
		System.out.println("	Variabili | ");
		System.out.println("	----------------------------------------");
		System.out.println( "	mySnd |"+(true));
		System.out.println("	coeffetto variabile: "+"Affinity.one()");
		System.out.println("	coeffetto inferito: "+((new Triv().mult(new Triv().fromNat(Nat.one())))).getClass().getSimpleName());
		System.out.println("	----------------------------------------");
		System.out.println( "	this |"+(Affinity.one().fromNat(Nat.one()).leq(Affinity.one())));
		System.out.println("	coeffetto variabile: "+"Affinity.one()");
		System.out.println("	coeffetto inferito: "+((Nat.one())).getClass().getSimpleName());
		System.out.println("	----------------------------------------");
		System.out.println("	----------------------------------------");
		System.out.println("	Metodo | identity");
		System.out.println("	----------------------------------------");
		System.out.println("	Variabili | ");
		System.out.println("	----------------------------------------");
		System.out.println( "	this |"+(Affinity.one().fromNat(Nat.one()).leq(Affinity.one())));
		System.out.println("	coeffetto variabile: "+"Affinity.one()");
		System.out.println("	coeffetto inferito: "+((Nat.one())).getClass().getSimpleName());
		System.out.println("	----------------------------------------");
		System.out.println("	----------------------------------------");
		System.out.println("	Metodo | met1");
		System.out.println("	----------------------------------------");
		System.out.println("	Variabili | ");
		System.out.println("	----------------------------------------");
		System.out.println("	----------------------------------------");
		System.out.println("	Metodo | xy");
		System.out.println("	----------------------------------------");
		System.out.println("	Variabili | ");
		System.out.println("	----------------------------------------");
		System.out.println( "	y |"+(Affinity.one().fromNat(Nat.one()).leq(Affinity.one())));
		System.out.println("	coeffetto variabile: "+"Affinity.one()");
		System.out.println("	coeffetto inferito: "+((Nat.one())).getClass().getSimpleName());
		System.out.println("	----------------------------------------");
		System.out.println( "	x |"+(new Omega().fromNat(Nat.one().sum(Nat.one())).leq(new Omega())));
		System.out.println("	coeffetto variabile: "+"new Omega()");
		System.out.println("	coeffetto inferito: "+((Nat.one().sum(Nat.one()))).getClass().getSimpleName());
		System.out.println("	----------------------------------------");
		System.out.println("	----------------------------------------");
		System.out.println("	Metodo | omega");
		System.out.println("	----------------------------------------");
		System.out.println("	Variabili | ");
		System.out.println("	----------------------------------------");
		System.out.println( "	a1 |"+(new Omega().sup(new Omega().fromNat(Nat.one())).mult(new Omega().sup(new Omega().fromNat(Nat.one())).fromNat(Nat.one())).leq(new Omega())));
		System.out.println("	coeffetto variabile: "+"new Omega()");
		System.out.println("	coeffetto inferito: "+((new Omega().sup(new Omega().fromNat(Nat.one())).mult(new Omega().sup(new Omega().fromNat(Nat.one())).fromNat(Nat.one())))).getClass().getSimpleName());
		System.out.println("	----------------------------------------");
		System.out.println( "	a2 |"+(Affinity.one().fromNat(Nat.one()).leq(Affinity.one())));
		System.out.println("	coeffetto variabile: "+"Affinity.one()");
		System.out.println("	coeffetto inferito: "+((Nat.one())).getClass().getSimpleName());
		System.out.println("	----------------------------------------");
		System.out.println("	----------------------------------------");
		System.out.println("	Metodo | zero");
		System.out.println("	----------------------------------------");
		System.out.println("	Variabili | ");
		System.out.println("	----------------------------------------");
		System.out.println( "	b |"+(Nat.one().leq(Nat.one())));
		System.out.println("	coeffetto variabile: "+"Nat.one()");
		System.out.println("	coeffetto inferito: "+((Nat.one())).getClass().getSimpleName());
		System.out.println("	----------------------------------------");
		System.out.println( "	this |"+(Nat.one().leq(Nat.one())));
		System.out.println("	coeffetto variabile: "+"Nat.one()");
		System.out.println("	coeffetto inferito: "+((Nat.one())).getClass().getSimpleName());
		System.out.println("	----------------------------------------");
		System.out.println("	----------------------------------------");
		System.out.println("------------------------------------------------");
		System.out.println("Classe | abstExt");
		System.out.println("------------------------------------------------");
		System.out.println("	Metodo | prova");
		System.out.println("	----------------------------------------");
		System.out.println("	Variabili | ");
		System.out.println("	----------------------------------------");
		System.out.println( "	a |"+(Nat.one().leq(Nat.one())));
		System.out.println("	coeffetto variabile: "+"Nat.one()");
		System.out.println("	coeffetto inferito: "+((Nat.one())).getClass().getSimpleName());
		System.out.println("	----------------------------------------");
		System.out.println("	----------------------------------------");
		System.out.println("	Metodo | intero");
		System.out.println("	----------------------------------------");
		System.out.println("	Variabili | ");
		System.out.println("	----------------------------------------");
		System.out.println("	----------------------------------------");
		System.out.println("------------------------------------------------");
		System.out.println("Classe | Main");
		System.out.println("------------------------------------------------");
		System.out.println("------------------------------------------------");
		System.out.println("Classe | Pair");
		System.out.println("------------------------------------------------");
		System.out.println("	Metodo | setFields");
		System.out.println("	----------------------------------------");
		System.out.println("	Variabili | ");
		System.out.println("	----------------------------------------");
		System.out.println( "	mySnd |"+(true));
		System.out.println("	coeffetto variabile: "+"Affinity.one()");
		System.out.println("	coeffetto inferito: "+((new Triv().mult(new Triv().fromNat(Nat.one())))).getClass().getSimpleName());
		System.out.println("	----------------------------------------");
		System.out.println( "	this |"+(Affinity.one().fromNat(Nat.one()).leq(Affinity.one())));
		System.out.println("	coeffetto variabile: "+"Affinity.one()");
		System.out.println("	coeffetto inferito: "+((Nat.one())).getClass().getSimpleName());
		System.out.println("	----------------------------------------");
		System.out.println("	----------------------------------------");
		System.out.println("------------------------------------------------");
		System.out.println("Classe | astratta");
		System.out.println("------------------------------------------------");
		System.out.println("	Metodo | prova");
		System.out.println("	----------------------------------------");
		System.out.println("	Variabili | ");
		System.out.println("	----------------------------------------");
		System.out.println( "	a |"+(Nat.one().leq(Nat.one())));
		System.out.println("	coeffetto variabile: "+"Nat.one()");
		System.out.println("	coeffetto inferito: "+((Nat.one())).getClass().getSimpleName());
		System.out.println("	----------------------------------------");
		System.out.println("	----------------------------------------");
	}
}

