package csp_search;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import csp.CSP;
import csp.Domain;
import csp.Variable;

public class MinimumRemainingValues<X extends Variable<D, V>, D extends Domain<V>, V> implements SelectUnassignedVariable<X, D, V> {

	public X getVariableForAssignment(List<X> assignment, CSP<X, D, V> csp) {
		/*
		 * Quick implementaition. Can improve.
		 */
		PriorityQueue<X> pq = new PriorityQueue<>(new Comparator<X>() {
			public int compare(X o1, X o2) {
				return o1.getDomain().getValues().size() - o2.getDomain().getValues().size();
			}
		});
		for (X x : assignment) {
			if (x.isAssigned()) continue;
			pq.add(x);
		}
		if (pq.isEmpty()) return null;
		return pq.remove();
	}

}
