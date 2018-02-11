import java.util.List;

import csp.Variable;
import csp_search.CSPDepthSearch;
import search.IResultObject;

public class Main {

	public static void main(String[] args) {
		
		// -- INITIAL CONFIGURATION -- //
		int[][] sudokuBoard = new int[9][9];
		sudokuBoard[0] = new int[]{0,0,0,2,6,0,7,0,1};
		sudokuBoard[1] = new int[]{6,8,0,0,7,0,0,9,0};
		sudokuBoard[2] = new int[]{1,9,0,0,0,4,5,0,0};
		sudokuBoard[3] = new int[]{8,2,0,1,0,0,0,4,0};
		sudokuBoard[4] = new int[]{0,0,4,6,0,2,9,0,0};
		sudokuBoard[5] = new int[]{0,5,0,0,0,3,0,2,8};
		sudokuBoard[6] = new int[]{0,0,9,3,0,0,0,7,4};
		sudokuBoard[7] = new int[]{0,4,0,0,5,0,0,3,6};
		sudokuBoard[8] = new int[]{7,0,3,0,1,8,0,0,0};
		
		SudokuProblem p = new SudokuProblem(sudokuBoard);
		CSPDepthSearch<SudokuVariable, SudokuDomain, Integer> ds = new CSPDepthSearch<>();
		IResultObject res = ds.execute(p);
		int count = 0;
		for (Variable<SudokuDomain, Integer> v : (List<Variable<SudokuDomain, Integer>>) res.getObject("ASSIGNMENT")) {
			System.out.print(v + " ");
			count += 1;
			if (count % 9 == 0) System.out.println();
		}
	}
	
}
