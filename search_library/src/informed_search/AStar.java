package informed_search;

import search.BestFirstSearch;
import search.IPriority;
import search.Node;

/**
 * Implements the AStar algorithm
 * @author JLepere2
 * @date 02/01/2018
 */
public class AStar extends BestFirstSearch {
	
	public AStar(IHeuristic heuristic) {
		super(new IPriority() {
			public int getPriority(Node n) {
				return n.getCost() + heuristic.execute(n.getState());
			}
		});
	}

}
