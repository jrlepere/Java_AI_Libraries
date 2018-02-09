package csp;

public abstract class BinaryConstraint<X extends Variable<?,?>> implements Constraint {

	public BinaryConstraint(X var1, X var2) {
		this.var1 = var1;
		this.var2 = var2;
	}
	
	public X getVar1() {
		return var1;
	}
	
	public X getVar2() {
		return var2;
	}
	
	protected X var1;
	protected X var2;
	
}
