package uninformed_search;

import problem.Problem;
import search.IResultObject;
import search.ISearch;

/**
 * Implementation of Iterative Deepening Search
 * @author JLepere2
 * @date 02/08/2018
 */
public class IterativeDeepeningSearch implements ISearch {
	
	public IResultObject execute(Problem p) {
		
		int l = 0;
		while (true) {
			IResultObject res = (new DepthLimitedSearch(l)).execute(p);
			if (res != null) return res;
			l ++;
		}
		
	}

}
