import csp.Variable;

/**
 * A Variable for Sudoku.
 * @author JLepere2
 * @date 02/10/2018
 */
public class SudokuVariable implements Variable<SudokuDomain, Integer>, Comparable<SudokuVariable> {

	public SudokuVariable(String uniqueID) {
		this.domain = new SudokuDomain();
		this.assignment = null;
		this.uniqueID = uniqueID;
	}
	
	public SudokuDomain getDomain() {
		return domain;
	}

	public void assign(Integer v) {
		this.assignment = v;
	}
	
	public boolean isAssigned() {
		return this.assignment != null;
	}

	public Integer getAssignment() {
		return assignment;
	}
	
	public String toString() {
		return assignment.toString();
	}

	public int compareTo(SudokuVariable o) {
		return this.uniqueID.compareTo(o.uniqueID);
	}
	
	private SudokuDomain domain;
	private Integer assignment;
	private String uniqueID;
	
}
