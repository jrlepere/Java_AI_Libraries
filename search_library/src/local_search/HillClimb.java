package local_search;

import problem.Action;
import problem.Problem;
import problem.State;
import search.LocalSearch;
import search.Node;
import search.ResultObject;

/**
 * Local search Hill Climb algorithm.
 * @author JLepere2
 * @date 02/01/2018
 */
public class HillClimb extends LocalSearch {

	public HillClimb(ObjectiveFunction function) {
		super(function);
	}
	
	public ResultObject execute(Problem p) {
		State currentState = p.getInitialState();
		while (true) {
			State bestSuccessor = null;
			for (Action action : p.getActions()) {
				if (!action.canExecute(currentState)) continue;
				State successor = action.execute(currentState);
				if (bestSuccessor == null) {
					bestSuccessor = successor;
				} else {
					if (this.function.execute(successor) > this.function.execute(bestSuccessor)) {
						bestSuccessor = successor;
					}
				}
			}
			if (bestSuccessor == null || (this.function.execute(currentState) > this.function.execute(bestSuccessor))) {
				return new ResultObject(null, new Node(currentState, null, null), null, 0);
			} else {
				currentState = bestSuccessor;
			}
		}
	}

}