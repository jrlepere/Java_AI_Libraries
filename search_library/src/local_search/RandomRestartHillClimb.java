package local_search;

import problem.Problem;
import problem.State;
import search.LocalSearch;
import search.Node;
import search.ResultObject;

/**
 * Random Restart Hill Climbing to find a goal node. Essentially just restarts the problem. It is assumed that the initial node generated from the Problem class is random.
 * @author JLepere2
 * @date 02/01/2018
 */
public class RandomRestartHillClimb extends LocalSearch {

	public RandomRestartHillClimb(ObjectiveFunction fun) {
		super(fun);
	}

	public ResultObject execute(Problem p) {
		while (true) {
			State resultState = (new HillClimb(this.function)).execute(p).getGoalState();
			if (p.isGoalState(resultState)) {
				return new ResultObject(null, new Node(resultState, null, null), null, 0);
			}
		}
	}

}
