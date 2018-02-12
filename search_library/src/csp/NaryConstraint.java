package csp;

import java.util.List;

public abstract class NaryConstraint<X extends Variable<?, ?>> implements Constraint<X> {

	public NaryConstraint(List<X> vars) {
		this.vars = vars;
	}

	public List<X> getConstrainedVariables() {
		return vars;
	}
	
	private List<X> vars;

}
