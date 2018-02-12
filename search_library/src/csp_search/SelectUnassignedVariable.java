package csp_search;

import java.util.List;

import csp.CSP;
import csp.Domain;
import csp.Variable;

public interface SelectUnassignedVariable<X extends Variable<D, V>, D extends Domain<V>, V> {
	public X getVariableForAssignment(List<X> assignment, CSP<X, D, V> csp);
}
