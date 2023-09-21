

@CoeffectClass
class Nat {
	boolean leq(Nat x) {
		return true;
	}

	Nat sup(Nat x) {
		Nat result;
		if (this.leq(x))
			result = x;
		else
			result = this;
		return result;
	}

	Nat sum(Nat x) {
		return x;
	}

	Nat mult(Nat x) {
		return this;
	}

	static Nat zero() {
		return new Zero();
	}

	static Nat one() {
		Nat result;
		result = new Succ().setPred(Nat.zero());
		return result;
	}
}

@CoeffectSubClass("Nat")
class Zero extends Nat {

}


@CoeffectSubClass("Nat")
class Succ extends Nat {
	Nat pred;

	Nat setPred(Nat p) {
		pred = p;
		return this;
	}

	boolean leq(Nat x) {
		boolean result;
		if (x instanceof Zero)
			result = false;
		else
			result = pred.leq(((Succ) x).pred);
		return result;
	}

	Nat sum(Nat x) {
		Nat result;
		result = new Succ().setPred(pred.sum(x));
		return result;
	}

	Nat mult(Nat x) {
		Nat result;
		if (x instanceof Zero)
			result = x;
		else
			result = pred.mult(x).sum(x);
		return result;
	}
}

@CoeffectClass
class Triv {
	boolean leq(Triv t) {
		return true;
	}

	Triv sup(Triv t) {
		return this;
	}

	Triv sum(Triv t) {
		return this;
	}

	Triv mult(Triv t) {
		return this;
	}

	static Triv zero() {
		return new Triv();
	}

	static Triv one() {
		return new Triv();
	}
}
