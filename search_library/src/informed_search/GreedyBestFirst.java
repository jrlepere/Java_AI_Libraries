package informed_search;

import search.BestFirstSearch;
import search.IPriority;
import search.Node;

/**
 * Implements GreedyBestFirst search.
 * @author JLepere2
 * @date 02/01/2018
 */
public class GreedyBestFirst extends BestFirstSearch {

	public GreedyBestFirst(IHeuristic heuristic) {
		super(new IPriority() {
			public int getPriority(Node n) {
				return heuristic.execute(n.getState());
			}
		});
	}

}
