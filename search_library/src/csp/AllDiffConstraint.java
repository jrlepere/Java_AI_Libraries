package csp;

import java.util.List;

public class AllDiffConstraint<X extends Variable<?,?>> implements Constraint {

	public AllDiffConstraint(List<X> variables) {
		this.variables = variables;
	}
	
	public boolean isViolation() {
		for (X x : variables) {
			if (x.getAssignment() == null) continue;
			for (X y : variables) {
				if (y.getAssignment() == null) continue;
				if (x.equals(y)) continue;
				if (x.getAssignment().equals(y.getAssignment())) return true;
			}
		}
		return false;
	}
	
	private List<X> variables;

}
