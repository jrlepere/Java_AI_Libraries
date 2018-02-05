package informed_search;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

import problem.Action;
import problem.State;
import search.AResultObject;
import search.Node;

public class InformedSearchResult extends AResultObject {

	public InformedSearchResult(Node goalNode) {
		super(createMap(goalNode));
	}
	
	private static TreeMap<String, Object> createMap(Node goalNode) {
		TreeMap<String,Object> map = new TreeMap<>();
		Helper h = new Helper(goalNode);
		map.put(GOAL_STATE, goalNode.getState());
		map.put(INITIAL_STATE, h.init);
		map.put(ACTIONS, h.actions);
		map.put(COST, goalNode.getCost());
		map.put(DEPTH, goalNode.getDepth());
		return map;
	}
	
	private static class Helper {
		Helper(Node goalNode) {
			actions = new LinkedList<>();
			Node n = goalNode;
			while (n.getAction() != null) {
				actions.add(0, n.getAction());
				n = n.getParent();
			}
			init = n.getState();
		}
		private State init;
		private List<Action> actions;
	}
	
	public static final String INITIAL_STATE = "INITIAL_STATE";
	public static final String GOAL_STATE = "GOAL_STATE";
	public static final String ACTIONS = "ACTIONS";
	public static final String COST = "COST";
	public static final String DEPTH = "DEPTH";
	
}
