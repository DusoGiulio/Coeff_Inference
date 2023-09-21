
class Pair {
	A fst;
	A snd;

	@Coeffect("Affinity.one") Pair setFields(@Coeffect("Affinity.one")Pair this, @Coeffect("Affinity.one")A myFst, @Coeffect("Affinity.one")A mySnd) {
		fst = myFst;
		snd = mySnd;
		return this;
	}

}

class A {
	
	
	@CoeffectResThis(coefRes="Affinity.one",coefThis="Affinity.zero") A drop1(@Coeffect("Affinity.zero")A c) {
		return new A();
	}

	
	@Coeffect(value="Affinity.one")A drop(@Coeffect("Affinity.zero")A this) {
		return new A();
	}

	@Coeffect("Affinity.one")A identity(@Coeffect("Affinity.one")A this) {
		return this;
	}

	@Coeffect("Affinity.one")Pair duplicate(@Coeffect("new Omega()")A this) {
		@Coeffect("Affinity.one") Pair p;
		p = new Pair();
		return p.setFields(this, this);
	}
	
	
	@Coeffect("new Omega()") A metCall(@Coeffect("Affinity.one") A this) {
		@Coeffect("new Omega()") A a1;
		@Coeffect("Affinity.one") A a2;
		a1 = new A();
		a2 = new A();
		a1.duplicate().fst.duplicate(); // a4 2 volte  (a3 2 volta a1 4 volte)
		a2.drop().identity();
		return a1;
	}
}
