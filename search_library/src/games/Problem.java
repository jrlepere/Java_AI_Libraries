package games;

import java.util.List;

/**
 * A problem definition for a game
 * @author JLepere2
 * @date 02/14/2018
 */
public interface Problem<A extends Action<S>, S extends State> {
	
	/**
	 * Gets the initial state of the problem
	 * @return the initial state of the problem
	 */
	public S getInitialState();
	
	/**
	 * Gets a list of actions available from the given state
	 * @param s the state
	 * @return a list of actions
	 */
	public List<A> getActions(S s);
	
	/**
	 * Tests if the state is a terminal state
	 * @param s the state
	 * @return true if s is a terminal state, false otherwise
	 */
	public boolean isTerminalState(S s);
	
	/**
	 * Value for a terminal state with respect to player p
	 * @param s the terminal state
	 * @param p the player
	 * @return a utility value for terminal state s
	 */
	public int utilityFunction(S s, Player p);
	
	/**
	 * Gets the player who's turn it is at state s
	 * @param s the state
	 * @return the player
	 */
	public Player getPlayer(S s);
	
}
