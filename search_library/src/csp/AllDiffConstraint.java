package csp;

import java.util.List;

/**
 * All different constraint
 * @author JLepere2
 * @date 02/10/2018
 */
public class AllDiffConstraint<X extends Variable<?,?>> extends NaryConstraint<X> {

	public AllDiffConstraint(List<X> vars) {
		super(vars);
		this.vars = vars;
	}
	
	public boolean isViolation() {
		for (X x : vars) {
			if (x.getAssignment() == null) continue;
			for (X y : vars) {
				if (y.getAssignment() == null) continue;
				if (x.equals(y)) continue;
				if (x.getAssignment().equals(y.getAssignment())) return true;
			}
		}
		return false;
	}
	
	private List<X> vars;

}
