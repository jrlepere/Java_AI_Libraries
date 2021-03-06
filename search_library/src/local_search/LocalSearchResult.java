package local_search;

import java.util.TreeMap;

import problem.State;
import search.AResultObject;

public class LocalSearchResult extends AResultObject {

	public LocalSearchResult(State goalState) {
		super(createMap(goalState));
	}
	
	private static TreeMap<String, Object> createMap(State goalState) {
		TreeMap<String,Object> map = new TreeMap<>();
		map.put(GOAL_STATE, goalState);
		return map;
	}
	
	public static final String GOAL_STATE = "GOAL_STATE";
	
}
