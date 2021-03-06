
import problem.State;

public class EightPuzzleState implements State {

    /**
     * Creates a State object with the passed tile locations.
     * @param theTileLocations the tile locations in the form:
     *    x0 x1 x2
     *    x3 x4 x5   = [x0,x1,x2,x3,x4,x5,x6,x7,x8]
     *    x6 x7 x8
     */
    public EightPuzzleState(int[] theTileLocations) {
        this.tileLocations = theTileLocations;
        for (int i = 0; i < this.tileLocations.length; i ++) {
            if (this.tileLocations[i] == 0) {
                    this.blankIndex = i;
            }
        }
    }

    /**
     * Gets the tile locations for this state.
     * @return the tile locations.
     */
    public int[] getTileLocations() {
        return tileLocations;
    }
	
    /** 
     * Gets the location of the blank tile.
     * @return the location of the blank tile.
     */
    public int getBlankTileLocation() {
        return blankIndex;
    }   

    public boolean equals(Object o) {
        int[] otherStateTileLocations = ((EightPuzzleState) o).getTileLocations();
        for (int i = 0; i < this.tileLocations.length; i ++) {
            if (this.tileLocations[i] != otherStateTileLocations[i]) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < this.tileLocations.length; i ++) {
            s += tileLocations[i];
        }
        return s;
    }

    private int[] tileLocations;
    private int blankIndex;
}
