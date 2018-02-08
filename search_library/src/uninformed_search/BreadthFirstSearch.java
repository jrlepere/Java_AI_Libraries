package uninformed_search;

import java.util.LinkedList;
import java.util.Queue;

import problem.Action;
import problem.Problem;
import problem.State;
import search.IResultObject;
import search.ISearch;
import search.Node;

/**
 * Implementation of Breadth First Search (BFS).
 * @author JLepere2
 * @date 02/08/2018
 */
public class BreadthFirstSearch implements ISearch {

	public IResultObject execute(Problem p) {
		
		Queue<Node> frontier = new LinkedList<>();
		frontier.add(new Node(p.getInitialState(), null, null));
		while (true) {
			if (frontier.isEmpty()) return null;
			Node n = frontier.remove();
			State s = n.getState();
			if (p.isGoalState(s)) return new UninformedSearchResult(n);
			for (Action a : p.getActions()) {
				if (!a.canExecute(s)) continue;
				frontier.add(new Node(a.execute(s), n, a));
			}
		}
		
	}

}
