@CoeffectClass
class Affinity {

	public Affinity sup(Affinity x) {
		Affinity result;
		if (this.leq(x))
			result = x;
		else
			result = this;
		return result;
	}

	public boolean leq(Affinity x) {
		return true;
	}

	public Affinity sum(Affinity x) {
		return x;
	}

	public Affinity mult(Affinity x) {
		return this;
	}

	public static Affinity zero() {
		return new ZeroA();
	}

	public static Affinity one() {
		return new One();
	}
}

@CoeffectSubClass("Affinity")
class ZeroA extends Affinity {

}

@CoeffectSubClass("Affinity")
class One extends Affinity {
	public boolean leq(Affinity x) {
		return !(x instanceof ZeroA);
	}

	public Affinity sum(Affinity x) {
		Affinity result;
		if (x instanceof ZeroA)
			result = this;
		else
			result = new Omega();
		return result;
	}

	public Affinity mult(Affinity x) {
		return x;
	}
}

@CoeffectSubClass("Affinity")
class Omega extends Affinity {
	public boolean leq(Affinity x) {
		return (x instanceof Omega);
	}

	public Affinity sum(Affinity x) {
		return this;
	}

	public Affinity mult(Affinity x) {
		Affinity result;
		if (x instanceof ZeroA)
			result = x;
		else
			result = this;
		return result;
	}
}