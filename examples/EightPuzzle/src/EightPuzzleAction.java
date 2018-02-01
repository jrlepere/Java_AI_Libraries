import problem.Action;
import problem.State;

public class EightPuzzleAction implements Action {

    public enum Direction {
        UP, DOWN, RIGHT, LEFT
    }

	/**
	 * Creates a MoveBlankTile Action with a direction. That is,
	 *  direction defines which way to move the blank tile (Up, Right, Down or Left).
	 * @param direction the direction to move the tile
	 */
	public EightPuzzleAction(Direction dir) {
        this.direction = dir;
	}

	public boolean canExecute(State s) {
        int blankTileLocation = ((EightPuzzleState) s).getBlankTileLocation();
        if (direction == Direction.UP) {
            if (blankTileLocation < 3) {
                return false;
            }
            return true;
        }
        if (direction == Direction.RIGHT) {
            if ((blankTileLocation + 1) % 3 == 0) {
                return false;
            }
            return true;
        }
        if (direction == Direction.DOWN) {
            if (blankTileLocation > 5) {
                return false;
            }
            return true;
        }
        if (direction == Direction.LEFT) {
            if (blankTileLocation % 3 == 0) {
                return false;
            }
            return true;
        }
        return false;
	}

    public State execute(State s) {
    	EightPuzzleState eps = (EightPuzzleState) s;
        int[] tileLocations = new int[eps.getTileLocations().length];
        System.arraycopy(eps.getTileLocations(), 0, tileLocations, 0, tileLocations.length);
        int blankTileLocation = eps.getBlankTileLocation();
        if (direction == Direction.UP) {
            if (blankTileLocation < 3) {
                return null;
            }
            return new EightPuzzleState(swap(tileLocations, blankTileLocation, blankTileLocation - 3));
        }   
        if (direction == Direction.RIGHT) {
            if ((blankTileLocation + 1) % 3 == 0) {
                return null;
            }   
            return new EightPuzzleState(swap(tileLocations, blankTileLocation, blankTileLocation + 1));
        }   
        if (direction == Direction.DOWN) {
            if (blankTileLocation > 5) {
                return null;
            }   
            return new EightPuzzleState(swap(tileLocations, blankTileLocation, blankTileLocation + 3));
        }   
        if (direction == Direction.LEFT) {
            if (blankTileLocation % 3 == 0) {
                return null;
            }   
            return new EightPuzzleState(swap(tileLocations, blankTileLocation, blankTileLocation - 1));
        }   
        return null;
}  

    /** 
     * Swaps the tiles and returns a new tile locations array.
     * @param tileLocations the original tile locations.
     * @param i index i
     * @param j index j
     * @return a new tile locations array
     */
    private int[] swap(int[] tileLocations, int i, int j) {
        int helper = tileLocations[i];
        tileLocations[i] = tileLocations[j];
        tileLocations[j] = helper;
        return tileLocations;
    }   

    public int getCost() {
            return 1;
    }   

    public String toString() {
        return direction.name();
    }   

    private Direction direction;

}
