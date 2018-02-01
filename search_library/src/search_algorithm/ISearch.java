package search_algorithm;
import java.util.List;

import problem.Action;
import problem.Problem;

/**
 * A search algorithm interface
 * @author JLepere2
 * @date 02/01/2018
 */
public interface ISearch {
	
	/**
	 * Searches up from the found goal node for a list of actions to solve the problem.
	 * @param gaol the goal Node
	 * @return a list of actions
	 */
	public List<Action> search(Node goal);
	
	/**
	 * Executes the search algorithm on the passed Problem.
	 * @param p the Problem p
	 * @return the result of executing the search algorithm
	 */
	public ResultObject execute(Problem p);
	
}
