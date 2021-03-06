import java.util.Arrays;

import problem.State;

/**
 * A State for the Eight Queens problem
 * @author JLepere2
 * @date 02/05/2018
 */
public class EightQueensState implements State {

	public EightQueensState(int[] queenLocations) {
		this.queenLocations = queenLocations;
	}
	
	public int[] getQueenLocations() {
		return queenLocations;
	}
	
	public boolean equals(Object o) {
		return this.queenLocations.equals(((EightQueensState) o).queenLocations); 
	}
	
	public String toString() {
		return Arrays.toString(queenLocations);
	}
	
	private int[] queenLocations;
	
}
