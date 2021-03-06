package csp;

import java.util.List;

public interface Constraint<X extends Variable<?, ?>> {
	
	public boolean isViolation();
	public List<X> getConstrainedVariables();
	
}
