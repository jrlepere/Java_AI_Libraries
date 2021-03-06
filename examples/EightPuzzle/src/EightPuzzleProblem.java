import java.util.LinkedList;
import java.util.List;

import problem.Action;
import problem.Problem;
import problem.State;

public class EightPuzzleProblem implements Problem {
	
	public State getInitialState() {
		return new EightPuzzleState(new int[]{2,5,8,6,0,3,1,7,4});
	}
	
	public List<Action> getActions() {
        List<Action> actions = new LinkedList<>();
        actions.add(new EightPuzzleAction(EightPuzzleAction.Direction.UP));
        actions.add(new EightPuzzleAction(EightPuzzleAction.Direction.DOWN));
        actions.add(new EightPuzzleAction(EightPuzzleAction.Direction.RIGHT));
        actions.add(new EightPuzzleAction(EightPuzzleAction.Direction.LEFT));
        return actions;
	}

	public boolean isGoalState(State s) {
		int[] goal = {0,1,2,3,4,5,6,7,8};
        int[] tileLocations = ((EightPuzzleState) s).getTileLocations();
        for (int i = 0; i < goal.length; i ++) {
                if (tileLocations[i] != goal[i]) {
                        return false;
                }
        }
        return true;
	}

}
