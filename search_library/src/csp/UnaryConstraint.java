package csp;

import java.util.LinkedList;
import java.util.List;

public abstract class UnaryConstraint<X extends Variable<?, ?>> implements Constraint<X> {
	
	public UnaryConstraint(X var) {
		this.vars = new LinkedList<>();
		vars.add(var);
	}
	
	public List<X> getConstrainedVariables() {
		return vars;
	}
	
	protected X getVar() {
		return vars.get(0);
	}
	
	protected List<X> vars;

}
