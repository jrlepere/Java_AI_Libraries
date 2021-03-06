package search;
import java.util.LinkedList;
import java.util.List;

import problem.Action;

/**
 * An abstract search class to implement the search function to get a list of actions from initial node to goal node
 * @author JLepere2
 * @date 02/01/2018
 */
public abstract class PathSearch implements ISearch {

	/**
	 * Searches up from the found goal node for a list of actions to solve the problem.
	 * @param gaol the goal Node
	 * @return a list of actions
	 */
	public List<Action> search(Node goal) {
		List<Action> searchSequence = new LinkedList<>();
		Node n = goal;
		while (n.getAction() != null) {
			searchSequence.add(0, n.getAction());
			n = n.getParent();
		}
		return searchSequence;
	}
	
}
