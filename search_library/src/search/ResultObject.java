package search;
import java.util.List;

import problem.Action;
import problem.State;

/**
 * An object to be returned from executing a search algorithm.
 * @author JLepere2
 * @date 02/01/2018
 */
public class ResultObject {

	/**
	 * Creates a ResultObject
	 * @param initialNode the initial node
	 * @param goalNode the goal node
	 * @param actionSequence a list of actions to get from the goal node to the initial node
	 * @param numNodesGenerated the number of nodes generated
	 */
	public ResultObject(Node initialNode, Node goalNode, List<Action> actionSequence, int numNodesGenerated) {
		this.init = initialNode;
		this.goal = goalNode;
		this.actions = actionSequence;
		this.nodesGenerated = numNodesGenerated;
	}
	
	/**
	 * Gets the initial state
	 * @return the initial state
	 */
	public State getInitialState() {
		return init.getState();
	}
	
	/**
	 * Gets the goal state
	 * @return the goal state
	 */
	public State getGoalState() {
		return goal.getState();
	}
	
	/**
	 * Gets the list of actions to get from the initial state to the goal state.
	 * @return
	 */
	public List<Action> getActionSequence() {
		return actions;
	}
	
	/**
	 * Gets the total cost of the path from initial state to goal state
	 * @return the total cost of the path 
	 */
	public int getTotalCost() {
		return goal.getCost();
	}
	
	/**
	 * Gets the total depth of the path from initial state to goal state
	 * @return the total depth of the path
	 */
	public int getTotalDepth() {
		return goal.getDepth();
	}
	
	/**
	 * Gets the number of nodes generated
	 * @return the number of nodes generated
	 */
	public int getNumberNodesGenerated() {
		return nodesGenerated;
	}
	
	private Node init;
	private Node goal;
	private List<Action> actions;
	private int nodesGenerated;
	
}