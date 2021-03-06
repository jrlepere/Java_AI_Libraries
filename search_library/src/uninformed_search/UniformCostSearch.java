package uninformed_search;

import search.BestFirstSearch;
import search.IPriority;
import search.Node;

/**
 * Implements UniformCost search.
 * @author JLepere2
 * @date 02/01/2018
 */
public class UniformCostSearch extends BestFirstSearch {

	public UniformCostSearch() {
		super(new IPriority() {
			public int getPriority(Node n) {
				return n.getCost();
			}
		});
	}
	
}
