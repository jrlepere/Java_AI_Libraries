package uninformed_search;

import java.util.Stack;

import problem.Action;
import problem.Problem;
import problem.State;
import search.IResultObject;
import search.ISearch;
import search.Node;

/**
 * Implementation of Depth First Search (DFS).
 * @author JLepere2
 * @date 02/08/2017
 */
public class DepthFirstSearch implements ISearch {

	public IResultObject execute(Problem p) {
		
		Stack<Node> frontier = new Stack<>();
		frontier.add(new Node(p.getInitialState(), null, null));
		while (true) {
			if (frontier.isEmpty()) return null;
			Node n = frontier.pop();
			State s = n.getState();
			if (p.isGoalState(s)) return new UninformedSearchResult(n);
			for (Action a : p.getActions()) {
				if (!a.canExecute(s)) continue;
				frontier.push(new Node(a.execute(s), n, a));
			}
		}
		
	}
	
}
