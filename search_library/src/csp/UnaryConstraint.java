package csp;

public abstract class UnaryConstraint<X extends Variable<?, ?>> implements Constraint {
	
	public UnaryConstraint(X var) {
		this.var = var;
	}
	
	public X getVariable() {
		return var;
	}
	
	protected X var;

}
