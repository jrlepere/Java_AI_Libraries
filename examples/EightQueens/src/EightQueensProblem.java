import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import problem.Action;
import problem.Problem;
import problem.State;

/**
 * A project class for the Eight Queens problem
 * @author JLepere2
 * @date 02/05/2018
 */
public class EightQueensProblem implements Problem {

	public State getInitialState() {
		return new EightQueensState(new int[]{
				gen.nextInt(8),
				gen.nextInt(8),
				gen.nextInt(8),
				gen.nextInt(8),
				gen.nextInt(8),
				gen.nextInt(8),
				gen.nextInt(8),
				gen.nextInt(8)
				}
		);
	}

	@Override
	public List<Action> getActions() {
		List<Action> actions = new LinkedList<>();
		for (int r = 0; r < 8; r ++) {
			for (int c = 0; c < 8; c ++) {
				actions.add(new EightQueensAction(r,c));
			}
		}
		return actions;
	}

	public boolean isGoalState(State s) {
		int[] queenLocations = ((EightQueensState) s).getQueenLocations();
		for (int row = 0; row < 8; row ++) {
			int diagOffset = 1;
			for (int col = row + 1; col < 8; col ++) {
				if (queenLocations[row] == queenLocations[col]) return false;
				else if (queenLocations[row] == queenLocations[col] + diagOffset) return false;
				else if (queenLocations[row] == queenLocations[col] - diagOffset) return false;
				diagOffset += 1;
			}
		}
		return true;
	}
	
	Random gen = new Random();

}
