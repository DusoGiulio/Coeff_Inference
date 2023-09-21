
@CoeffectClass
class Ext_Nat {

	// Def. for ZeroE
	boolean leq(Ext_Nat x) {
		return true;
	}

	Ext_Nat sup(Ext_Nat x) {
		Ext_Nat result;
		if (this.leq(x))
			result = x;
		else
			result = this;
		return result;
	}

	// Def. for ZeroE
	Ext_Nat sum(Ext_Nat x) {
		return x;
	}

	// Def. for ZeroE
	Ext_Nat mult(Ext_Nat x) {
		return this;
	}

	static Ext_Nat zero() {
		return new ZeroE();
	}

	static Ext_Nat one() {
		Ext_Nat result;
		result = new SuccE().setPred(Ext_Nat.zero());
		return result;
	}
}

@CoeffectClass
class ZeroE extends Ext_Nat {

}

@CoeffectClass
class SuccE extends Ext_Nat {
	Ext_Nat pred;

	Ext_Nat setPred(Ext_Nat p) {
		pred = p;
		return this;
	}

	boolean leq(Ext_Nat x) {
		boolean result;
		if (x instanceof ZeroE)
			result = false;
		else if (x instanceof Infinity)
			result = true;
		else
			result = pred.leq(((SuccE) x).pred);
		return result;
	}

	Ext_Nat sum(Ext_Nat x) {
		Ext_Nat result;
		if (x instanceof Infinity)
			result = x;
		else
			result = new SuccE().setPred(pred.sum(x));
		return result;
	}

	Ext_Nat mult(Ext_Nat x) {
		Ext_Nat result;
		if (x instanceof ZeroE || x instanceof Infinity)
			result = x;
		else
			result = pred.mult(x).sum(x);
		return result;
	}
}

class Infinity extends Ext_Nat {

	boolean leq(Ext_Nat x) {
		return false;
	}

	Ext_Nat sum(Ext_Nat x) {
		return this;
	}

	Ext_Nat mult(Ext_Nat x) {
		return this;
	}
}