package csp_search;

import java.util.List;
import java.util.TreeMap;

import csp.Variable;
import search.AResultObject;

public class CSPResultObject<X extends Variable<?,?>> extends AResultObject {

	public CSPResultObject(List<X> assignment) {
		super(createMap(assignment));
	}
	
	private static <X> TreeMap<String, Object> createMap(List<X> assignment) {
		TreeMap<String,Object> map = new TreeMap<>();
		map.put(ASSIGNMENT, assignment);
		return map;
	}
	
	public static final String ASSIGNMENT = "ASSIGNMENT";


}
