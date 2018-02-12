package csp_search;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import csp.CSP;
import csp.Constraint;
import csp.Domain;
import csp.Variable;

public class MostConstrainedValues<X extends Variable<D, V>, D extends Domain<V>, V> implements SelectUnassignedVariable<X, D, V> {

	public X getVariableForAssignment(List<X> assignment, CSP<X, D, V> csp) {
		Map<X, Integer> map = new TreeMap<>();
		for (Constraint<X> c : csp.getConstraints()) {
			for (X x : c.getConstrainedVariables()) {
				if (!map.containsKey(x)) map.put(x, 1);
				else map.put(x, map.get(x) + 1);
			}
		}
		for (X x : assignment) {
			if (x.isAssigned()) map.remove(x);
			else if (!map.containsKey(x)) map.put(x, 0);
		}
		X mostConstrainedX = null;
		Integer constraintsOnX = 0;
		for (X x : map.keySet()) {
			if (mostConstrainedX == null) {
				mostConstrainedX = x;
				constraintsOnX = map.get(mostConstrainedX);
			} else {
				if (map.get(x) > constraintsOnX) {
					mostConstrainedX = x;
					constraintsOnX = map.get(mostConstrainedX);
				}
			}
		}
		return mostConstrainedX;
	}

}
