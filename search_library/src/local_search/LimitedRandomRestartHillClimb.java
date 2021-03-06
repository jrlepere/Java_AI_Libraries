package local_search;

import problem.Problem;
import problem.State;
import search.IResultObject;
import search.LocalSearch;

/**
 * Limited Random Restart Hill Climbing to find a goal node.
 * @author JLepere2
 * @date 02/08/2018
 */
public class LimitedRandomRestartHillClimb extends LocalSearch {

	public LimitedRandomRestartHillClimb(ObjectiveFunction fun, int maxIterations) {
		super(fun);
		this.maxIterations = maxIterations;
	}

	public IResultObject execute(Problem p) {
		for (int i = 0; i < maxIterations - 1; i++) {
			State resultState = (State) (new HillClimb(this.function)).execute(p).getObject(LocalSearchResult.GOAL_STATE);
			if (p.isGoalState(resultState)) {
				return new LocalSearchResult(resultState);
			}
		}
		return (new HillClimb(this.function)).execute(p);
	}
	
	private int maxIterations;

}
