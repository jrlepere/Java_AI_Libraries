package csp_search;

import java.util.List;

import csp.CSP;
import csp.Domain;
import csp.Variable;

public class FirstUnassigned<X extends Variable<D, V>, D extends Domain<V>, V> implements SelectUnassignedVariable<X, D, V> {

	public X getVariableForAssignment(List<X> assignment, CSP<X, D, V> csp) {
		for (X x : assignment) {
			if (!x.isAssigned()) return x;
		}
		return null;
	}

}
