import csp.Variable;

public class CAVariable implements Variable<CADomain, Color> {

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
	
	private CADomain domain;
	private Color assignment;
	private String ID;
	
}
