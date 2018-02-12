import csp.Variable;

/**
 * A Variable for the Coloring Australia problem
 * @author JLepere2
 * @date 02/10/2018
 */
public class CAVariable implements Variable<CADomain, Color>, Comparable<CAVariable> {

	public CAVariable(String ID) {
		this.domain = new CADomain();
		this.assignment = null;
		this.ID = ID;
	}
	
	public CADomain getDomain() {
		return domain;
	}
	
	public void assign(Color v) {
		this.assignment = v;
	}

	public Color getAssignment() {
		return assignment;
	}
	
	public boolean isAssigned() {
		return this.assignment != null;
	}
	
	public String toString() {
		return ID + " - " + this.assignment.name();
	}
	
	public int compareTo(CAVariable o) {
		return this.ID.compareTo(o.ID);
	}
	
	private CADomain domain;
	private Color assignment;
	private String ID;
	
}
