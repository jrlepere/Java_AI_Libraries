import informed_search.AStar;
import informed_search.IHeuristic;
import problem.Action;
import problem.Problem;
import problem.State;
import search.ResultObject;

public class Main {

	public static void main(String[] args) {
		Problem p = new EightPuzzleProject();
		AStar aStar = new AStar(new IHeuristic() {
			public int execute(State arg0) {
                int[] tileLocations = ((EightPuzzleState) arg0).getTileLocations();
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
		
		ResultObject res = aStar.execute(p);
		System.out.println("DEPTH: " + res.getTotalDepth());
		State s = res.getInitialState();
		for (Action action : res.getActionSequence()) {
			System.out.println(s);
			s = action.execute(s);
		}
		System.out.println(s);
		
	}
	
}