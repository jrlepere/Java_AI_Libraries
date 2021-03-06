package local_search;

import java.util.Comparator;
import java.util.PriorityQueue;

import problem.Action;
import problem.Problem;
import problem.State;
import search.IResultObject;
import search.LocalSearch;

/**
 * Implementation for the LocalBeamSearch algorithm
 * @author JLepere2
 * @date 02/07/2018
 */
public class LocalBeamSearch extends LocalSearch {

	/**
	 * Creates a LocalBeamSearch object for executing the algorithm.
	 * @param fun the objective function
	 * @param k the number of nodes to keep memory
	 */
	public LocalBeamSearch(ObjectiveFunction fun, int k) {
		super(fun);
		this.k = k;
	}
	
	public IResultObject execute(Problem p) {
		
		// -- PQueue Comparator -- //
		Comparator<State> comp = new Comparator<State>() {
			public int compare(State o1, State o2) {
				return function.execute(o2) - function.execute(o1);
			}
		};
		
		// -- Initialize -- //
		PriorityQueue<State> states = new PriorityQueue<>(comp);
		int statesTotalEvaluation = 0;    // Counter for the sum of the evaluation scores
		for (int i = 0; i < k; i ++) {
			State s = p.getInitialState();
			statesTotalEvaluation += function.execute(s);
			states.add(s);
		}
		
		// -- Loop -- //
		while (true) {
			
			// -- Generate All Successors -- //
			PriorityQueue<State> successors = new PriorityQueue<>(comp);
			for (State s : states) {
				for (Action a : p.getActions()) {
					if (!a.canExecute(s)) continue;
					successors.add(a.execute(s));
				}
			}
			
			// -- Remove K Best Successors -- //
			PriorityQueue<State> newStates = new PriorityQueue<>(comp);
			int newStatesTotalEvaluation = 0;
			for (int i = 0; i < k; i ++) {
				State nS = successors.remove();
				newStatesTotalEvaluation += function.execute(nS);
				newStates.add(nS);
			}

			/*
			 * If no improvement were made, return the best state.
			 * Else, perform the loop again with the newly selected k best successor states.
			 */
			if (newStatesTotalEvaluation < statesTotalEvaluation) {
				return new LocalSearchResult(states.remove());
			} else {
				states = newStates;
				statesTotalEvaluation = newStatesTotalEvaluation;
			}
		}
	}
	
	private int k;

}
