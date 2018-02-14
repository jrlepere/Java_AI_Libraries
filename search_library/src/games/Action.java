package games;

/**
 * An action for a game.
 * @author JLepere2
 * @date 02/14/2018
 */
public interface Action<S extends State> {
	/**
	 * Executes the action on the state.
	 * @param s the state
	 * @return the resulting state from executing the action
	 */
	public S execute(S s);
}
