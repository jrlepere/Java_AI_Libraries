package search;
import problem.Action;
import problem.State;

/**
 * A Node object for search
 * @author JLepere2
 * @date 02/01/2018
 */
public class Node {

	/**
	 * Creates a Node for the problem.
	 * @param theState the state
	 * @param theParent the parent
	 * @param theAction the action
	 */
	public Node(State theState, Node theParent, Action theAction) {
		this.state = theState;
		this.parent = theParent;
		this.action = theAction;
		this.depth = 0;
		this.cost = 0;
		if (theParent != null) {
			this.depth = theParent.depth + 1;
			this.cost = theParent.cost + theAction.getCost();
		}
	}
	
	/**
	 * Gets the State of the Node.
	 * @return the state of the node
	 */
	public State getState() {
		return this.state;
	}
	
	/**
	 * Gets the parent Node.
	 * @return the parent node
	 */
	public Node getParent() {
		return this.parent;
	}
	
	/**
	 * Gets the Action executed on the parent to get this Node.
	 * @return the action
	 */
	public Action getAction() {
		return this.action;
	}
	
	/**
	 * Gets the depth of the Node.
	 * @return the depth of the Node
	 */
	public int getDepth() {
		return this.depth;
	}
	
	/**
	 * Gets the cost of the Node.
	 * @return the cost of the Node
	 */
	public int getCost() {
		return this.cost;
	}
	
	public boolean equals(Object other) {
		return state.equals(((Node) other).state);
	}
	
	private State state;
	private Node parent;
	private Action action;
	private int depth;
	private int cost;
	
}
