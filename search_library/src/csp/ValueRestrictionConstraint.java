package csp;

public class ValueRestrictionConstraint<X extends Variable<D, V>, D extends Domain<V>, V> extends UnaryConstraint<X> {

	public ValueRestrictionConstraint(X var, V value) {
		super(var);
		this.value = value;
	}

	public boolean isViolation() {
		return getVar().getAssignment().equals(value);
	}
	
	private V value;

}
