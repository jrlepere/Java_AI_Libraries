package csp_search;

import csp.CSP;
import csp.Domain;
import csp.Variable;
import search.IResultObject;

/**
 * A search algorithm interface for a CSP
 * @author JLepere2
 * @date 02/10/2018
 */
public interface ICSPSearch<X extends Variable<D,V>, D extends Domain<V>, V> {

	/**
	 * Executes the search algorithm on the passed CSP Problem.
	 * @param p the CSP p
	 * @return the result of executing the search algorithm
	 */
	public IResultObject execute(CSP<X,D,V> p);
	
}
