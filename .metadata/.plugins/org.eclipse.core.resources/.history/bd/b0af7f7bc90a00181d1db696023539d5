package local_search;

import problem.Action;
import problem.Problem;
import problem.State;
import search.LocalSearch;
import search.Node;
import search.ResultObject;

/**
 * First Choice Hill Climbing where the first successor is chosen such that the choice is positive relative to the current state.
 * @author JLepere2
 * @date 02/01/2018
 */
public class FirstChoiceHillClimb extends LocalSearch {

	public FirstChoiceHillClimb(ObjectiveFunction fun) {
		super(fun);
	}

	public ResultObject execute(Problem p) {
		State currentState = p.getInitialState();
		while (true) {
			boolean found = false;;
			for (Action action : p.getActions()) {
				if (!action.canExecute(currentState)) continue;
				State successor = action.execute(currentState);
				if (this.function.execute(successor) > this.function.execute(currentState)) {
					found = true;
					currentState = successor;
					break;
				}
			}
			if (!found) {
				return new ResultObject(null, new Node(currentState, null, null), null, 0);
			}
		}
	}

}
