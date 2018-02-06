import java.util.Arrays;

import problem.Action;
import problem.State;

/**
 * An Action class for the Eight Queens problem
 * @author JLepere2
 *
 */
public class EightQueensAction implements Action {

	public EightQueensAction(int queenRow, int newQueenColumn) {
		this.queenRow = queenRow;
		this.newQueenColumn = newQueenColumn;
	}
	
	public boolean canExecute(State s) {
		return ((EightQueensState) s).getQueenLocations()[this.queenRow] != this.newQueenColumn;
	}

	public State execute(State s) {
		int[] newQueenLocations = Arrays.copyOf(((EightQueensState) s).getQueenLocations(), 8);
		newQueenLocations[this.queenRow] = newQueenColumn;
		return new EightQueensState(newQueenLocations);
	}

	public int getCost() {
		return 1;
	}
	
	private int queenRow;
	private int newQueenColumn;

}
