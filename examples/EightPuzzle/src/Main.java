import java.util.List;

import informed_search.AStar;
import informed_search.IHeuristic;
import informed_search.InformedSearchResult;
import problem.Action;
import problem.Problem;
import problem.State;
import search.IResultObject;

public class Main {

	public static void main(String[] args) {
		Problem p = new EightPuzzleProblem();
		AStar aStar = new AStar(new IHeuristic() {
			public int execute(State s) {
                int[] tileLocations = ((EightPuzzleState) s).getTileLocations();
                int distSum = 0;
                for (int i = 0; i < tileLocations.length; i ++) {
                    if (tileLocations[i] == 0) continue;
                    int a = i;
                    int b = tileLocations[i];
                    int row_a = a / 3;
                    int row_b = b / 3;
                    int col_a = a % 3;
                    int col_b = b % 3;  
                    distSum += Math.abs(row_a - row_b) + Math.abs(col_a - col_b);
                }   
                return distSum;
			}
		});
		
		IResultObject res = aStar.execute(p);
		System.out.println("DEPTH: " + res.getObject(InformedSearchResult.DEPTH));
		State s = (State) res.getObject(InformedSearchResult.INITIAL_STATE);
		for (Action action : (List<Action>) res.getObject(InformedSearchResult.ACTIONS)) {
			System.out.println(s);
			s = action.execute(s);
		}
		System.out.println(s);
		
	}
	
}
