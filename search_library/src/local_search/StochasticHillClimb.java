package local_search;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import problem.Action;
import problem.Problem;
import problem.State;
import search.LocalSearch;
import search.Node;
import search.ResultObject;

/**
 * Stochastic Hill Climbing to find the goal node. A random successor is selected from the set of all successors resulting in a positive climb.
 * @author JLepere2
 * @date 02/01/2018
 */
public class StochasticHillClimb extends LocalSearch {

	public StochasticHillClimb(ObjectiveFunction fun) {
		super(fun);
	}

	public ResultObject execute(Problem p) {
		State currentState = p.getInitialState();
		while (true) {
			List<State> improvementStates = new ArrayList<>();
			for (Action action : p.getActions()) {
				if (!action.canExecute(currentState)) continue;
				State successor = action.execute(currentState);
				if (this.function.execute(successor) > this.function.execute(currentState)) {
					improvementStates.add(successor);
				}
			}
			if (improvementStates.size() == 0) {
				return new ResultObject(null, new Node(currentState, null, null), null, 0);
			} else {
				currentState = improvementStates.get(gen.nextInt(improvementStates.size()));
			}
		}
	}
	
	Random gen = new Random();

}
