package search_algorithm;

import problem.State;

/**
 * An interface for implementation of the heuristic function.
 * @author JLepere2
 * @date 02/01/2018
 */
public interface IHeuristic {
	int execute(State s);
}
