package csp;

public class EqualVariablesConstraint<X extends Variable<D,V>, D extends Domain<V>, V> extends BinaryConstraint<X> {

	public EqualVariablesConstraint(X var1, X var2) {
		super(var1, var2);
	}

	public boolean isViolation() {
		X var1 = getVar1();
		X var2 = getVar2();
		if (!var1.isAssigned() || !var2.isAssigned()) return false;
		return var1.getAssignment().equals(var2.getAssignment());
	}

}
