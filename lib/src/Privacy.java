


@CoeffectClass
class Privacy {
	public Privacy sup(Privacy x) {
		Privacy result;
		if (this.leq(x))
			result = x;
		else
			result = this;
		return result;
	}

	public boolean leq(Privacy x) {
		return true;
	}

	public Privacy sum(Privacy x) {
		return this.sup(x);
	}

	public Privacy mult(Privacy x) {
		return this;
	}

	public static Privacy zero() {
		return new Irrelevant();
	}

	public static Privacy one() {
		return new Private();
	}
}

@CoeffectSubClass("Privacy")
class Irrelevant extends Privacy {

}

@CoeffectSubClass("Privacy")
class Private extends Privacy {
	public boolean leq(Privacy x) {
		return !(x instanceof Irrelevant);
	}

	public Privacy mult(Privacy x) {
		return this.sup(x);
	}
}

@CoeffectSubClass("Privacy")
class Public extends Privacy {
	public boolean leq(Privacy x) {
		return (x instanceof Public);
	}

	public Privacy mult(Privacy x) {
		return this.sup(x);
	}
}