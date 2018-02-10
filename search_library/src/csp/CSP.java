package csp;

import java.util.List;

/**
 * An interface for a Constraint Satisfaction Problem
 * @author JLepere2
 * @date 02/08/2018
 */
public interface CSP<X extends Variable<D,V>, D extends Domain<V>, V> {
	
	public List<X> getVariables();
	
	public List<Constraint> getConstraints();
	
}
