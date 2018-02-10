import java.util.List;

import csp.AllDiffConstraint;

/**
 * All different constraint for Sudoku rows, cols and blocks
 * @author JLepere2
 * @date 02/10/2018
 */
public class SudokuConstraint extends AllDiffConstraint<SudokuVariable>{

	public SudokuConstraint(List<SudokuVariable> variables) {
		super(variables);
	}

}
