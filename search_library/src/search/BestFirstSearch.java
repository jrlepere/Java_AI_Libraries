package search;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.function.Predicate;

import informed_search.InformedSearchResult;
import problem.Action;
import problem.Problem;
import problem.State;

/**
 * BestFirstSearch implementation
 * @author JLepere2
 * @date 02/01/2018
 */
public abstract class BestFirstSearch implements ISearch {

	public BestFirstSearch(IPriority p) {
		this.priorityFunction = p;
	}
	
	public IResultObject execute(Problem p) {
		
		// --- INITIALIZATION --- //
		Node iNode = new Node(p.getInitialState(), null, null);
		PNode pNode = new PNode(iNode,this.priorityFunction.getPriority(iNode));
		
		// --- FRONTIER --- //
		PriorityQueue<PNode> frontier = new PriorityQueue<PNode>(new Comparator<PNode>() {
			public int compare(PNode o1, PNode o2) {
				return o1.compareTo(o2);
			}
		});
		frontier.add(pNode);
		
		// --- EXPLORED --- //
		List<State> explored = new ArrayList<State>();
		
		// --- LOOP --- //
		while (true) {
			
			// --- EMPTY FRONTIER TEST --- //
			if (frontier.isEmpty()) {
				return null;
			}
			
			pNode = frontier.remove();
			
			// --- GOAL TEST --- //
			if (p.isGoalState(pNode.node.getState())) {
				return new InformedSearchResult(pNode.node);
			}
			
			explored.add(pNode.node.getState());
			
			// --- ADD NEW STATES TO THE FRONTIER --- //
			for (Action action : p.getActions()) {
				if (!action.canExecute(pNode.node.getState())) continue;
				State newState = action.execute(pNode.node.getState());
				Node newChild = new Node(newState, pNode.node, action);
				PNode pChild = new PNode(newChild,this.priorityFunction.getPriority(newChild));
				if (!explored.contains(newState) && !frontier.contains(pChild)) {
					frontier.add(pChild);
				} else {
					boolean removed = frontier.removeIf(new Predicate<PNode>() {
						public boolean test(PNode t) {
							if (t.equals(pChild) && (t.priority >= pChild.priority)) {
								return true;
							}
							return false;
						}
					});
					if (removed) {
						frontier.add(pChild);
					}
				}
			}
		}
	}
	
	/**
	 * An internal node class to sort in the frontier by priority.
	 * @author JLepere2
	 * @date 02/01/2018
	 */
	private class PNode implements Comparable<PNode> {
		
		/**
		 * Creates a PNode.
		 * @param n the internal node
		 * @param priority the priority
		 */
		public PNode(Node n, int priority) {
			this.node = n;
			this.priority = priority;
		}
		
		public int compareTo(PNode o) {
			return this.priority - o.priority;
		}
		
		public boolean equals(Object o) {
			return this.node == ((PNode) o).node;
		}
		
		private Node node;
		private int priority;
		
	}
	
	private IPriority priorityFunction;
	
}
