import java.util.List;

import csp.Variable;
import csp_search.CSPBacktrackingSearch;
import csp_search.ICSPSearch;
import csp_search.MostConstrainedValues;
import search.IResultObject;

public class Main {

	public static void main(String[] args) {
		
		// -- INITIAL CONFIGURATION -- //
		int[][] sudokuBoard = new int[9][9];
		sudokuBoard[0] = new int[]{8,0,0,0,0,0,0,0,1};
		sudokuBoard[1] = new int[]{0,5,0,4,0,3,0,9,0};
		sudokuBoard[2] = new int[]{0,0,4,0,9,0,5,0,0};
		sudokuBoard[3] = new int[]{0,8,0,7,0,9,0,2,0};
		sudokuBoard[4] = new int[]{0,0,9,0,0,0,1,0,0};
		sudokuBoard[5] = new int[]{0,1,0,3,0,8,0,6,0};
		sudokuBoard[6] = new int[]{0,0,5,0,4,0,9,0,0};
		sudokuBoard[7] = new int[]{0,7,0,9,0,2,0,3,0};
		sudokuBoard[8] = new int[]{9,0,0,0,0,0,0,0,6};
		
		// -- Finds Sudoku Solution -- //
		SudokuProblem p = new SudokuProblem(sudokuBoard);
		//ICSPSearch<SudokuVariable, SudokuDomain, Integer> s = new CSPBacktrackingSearch<>(new FirstUnassigned<>());
		//ICSPSearch<SudokuVariable, SudokuDomain, Integer> s = new CSPBacktrackingSearch<>(new MinimumRemainingValues<>());
		ICSPSearch<SudokuVariable, SudokuDomain, Integer> s = new CSPBacktrackingSearch<>(new MostConstrainedValues<>());
		IResultObject res = s.execute(p);
		
		// -- Print Solution -- //
		int count = 0;
		for (Variable<SudokuDomain, Integer> v : (List<Variable<SudokuDomain, Integer>>) res.getObject("ASSIGNMENT")) {
			System.out.print(v + " ");
			count += 1;
			if (count % 9 == 0) System.out.println();
		}
	}
	
}
