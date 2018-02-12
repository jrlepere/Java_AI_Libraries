package csp;

import java.util.LinkedList;
import java.util.List;

public abstract class BinaryConstraint<X extends Variable<?,?>> implements Constraint<X> {

	public BinaryConstraint(X var1, X var2) {
		this.vars = new LinkedList<>();
		vars.add(var1);
		vars.add(var2);
	}
	
	protected X getVar1() {
		return vars.get(0);
	}
	
	protected X getVar2() {
		return vars.get(1);
	}
	
	public List<X> getConstrainedVariables() {
		return vars;
	}
	
	protected List<X> vars;
	
}
