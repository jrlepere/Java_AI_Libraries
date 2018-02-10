package csp;

public class EqualVariablesConstraint<X extends Variable<D,V>, D extends Domain<V>, V> extends BinaryConstraint<X> {

	public EqualVariablesConstraint(X var1, X var2) {
		super(var1, var2);
	}

	public boolean isViolation() {
		if (!var1.isAssigned() || !var2.isAssigned()) return false;
		return this.var1.getAssignment().equals(this.var2.getAssignment());
	}

}
