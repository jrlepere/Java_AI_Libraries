import java.util.LinkedList;
import java.util.List;

import csp.Domain;

/**
 * A domain for Sudoku variables (1-9 Integers)
 * @author JLepere2
 * @date 02/10/2018
 */
public class SudokuDomain implements Domain<Integer>{

	public SudokuDomain() {
		digits = new LinkedList<>();
		digits.add(1);
		digits.add(2);
		digits.add(3);
		digits.add(4);
		digits.add(5);
		digits.add(6);
		digits.add(7);
		digits.add(8);
		digits.add(9);
	}
	
	public List<Integer> getValues() {
		return digits;
	}
	
	private List<Integer> digits;

}
