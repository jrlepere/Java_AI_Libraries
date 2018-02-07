import local_search.LocalSearchResult;
import local_search.ObjectiveFunction;
import local_search.RandomRestartHillClimb;
import problem.Problem;
import problem.State;

public class Main {

	public static void main(String[] args) {
		
		int n = 30;
		Problem p = new NQueensProblem(n);
		RandomRestartHillClimb algo = new RandomRestartHillClimb(new ObjectiveFunction() {
			public int execute(State s) {
				int count = 0;
				int[] queenLocations = ((NQueensState) s).getQueenLocations();
				for (int row = 0; row < n; row ++) {
					int diagOffset = 1;
					for (int col = row + 1; col < n; col ++) {
						if (queenLocations[row] == queenLocations[col]) count ++;
						else if (queenLocations[row] == queenLocations[col] + diagOffset) count ++;
						else if (queenLocations[row] == queenLocations[col] - diagOffset) count ++;
						diagOffset += 1;
					}
				}
				return (-1)*count;
			}
		});
		
		NQueensState goalState = (NQueensState) algo.execute(p).getObject(LocalSearchResult.GOAL_STATE);
		System.out.println(goalState);
		System.out.println(p.isGoalState(goalState));
		
	}
	
}
