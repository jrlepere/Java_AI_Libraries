package local_search;

import problem.Problem;
import problem.State;
import search.IResultObject;
import search.LocalSearch;

/**
 * Random Restart Hill Climbing to find a goal node. Essentially just restarts the problem. It is assumed that the initial node generated from the Problem class is random.
 * @author JLepere2
 * @date 02/01/2018
 */
public class RandomRestartHillClimb extends LocalSearch {

	public RandomRestartHillClimb(ObjectiveFunction fun) {
		super(fun);
	}

	public IResultObject execute(Problem p) {
		while (true) {
			State resultState = (State) (new HillClimb(this.function)).execute(p).getObject(LocalSearchResult.GOAL_STATE);
			if (p.isGoalState(resultState)) {
				return new LocalSearchResult(resultState);
			}
		}
	}

}
