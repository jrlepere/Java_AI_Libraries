import games.Action;

public class Mark implements Action<Board> {

	public Mark(Symbol S, int row, int col) {
		this.S = S;
		this.row = row;
		this.col = col;
	}
	
	public Board execute(Board s) {
		Symbol[][] board = s.getBoard();
		Symbol[][] newBoard = new Symbol[Board.BOARD_SIZE][Board.BOARD_SIZE];
		for (int i = 0; i < Board.BOARD_SIZE; i ++) {
			for (int j = 0; j < Board.BOARD_SIZE; j ++) {
				newBoard[i][j] = board[i][j];
			}
		}
		newBoard[row][col] = S; 
		return new Board(newBoard, s.getMarkCount());
	}
	
	private Symbol S;
	private int row;
	private int col;

}
