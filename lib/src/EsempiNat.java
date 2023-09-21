class PairN {
	ANat fst;
	ANat snd;

	@Coeffect("Nat.one") PairN setFields(@Coeffect("Nat.one")PairN this, @Coeffect("Nat.one")ANat myFst, @Coeffect("Nat.one")ANat mySnd) {
		fst = myFst;
		snd = mySnd;
		return this;
	}

}

class ANat {
	@Coeffect("Nat.one")ANat drop(@Coeffect("Nat.zero")ANat this) {
		return new ANat();
	}

	@Coeffect("Nat.one")ANat identity(@Coeffect("Nat.one")ANat this) {
		return this;
	}

	@Coeffect("Nat.one")PairN duplicate(@Coeffect("new Succ().setPred(Nat.one)")ANat this) {
		@Coeffect("Nat.one") PairN p;
		p = new PairN();
		return p.setFields(this, this);
	}
	
	
	@Coeffect("Nat.one") ANat metCall(@Coeffect("Nat.one") ANat this) {
		@Coeffect("new Succ().setPred(new Succ().setPred(new Succ().setPred(Nat.one)))")ANat a1;  // a1 e' usato a rank 4
		@Coeffect("Nat.one") ANat a2;  // a2 e' a rank  1
		a1 = new ANat();
		a2 = new ANat();
		a1.duplicate().fst.duplicate();
		a2.drop().identity();
		return a1;
	}
}