package friedman.tictactoe;


public class TicTacToeBoard {
	private Symbol[][] squares;

	public TicTacToeBoard() {
		// TODO Auto-generated constructor stub
		reset();
	}

	public void reset() {
		// resets game
		this.squares = new Symbol[3][3];
		for (int i = 0; i < 3; i++) {
			for (int k = 0; k < 3; k++){
				this.squares[i][k] = null;
			}
		}

	}

	public boolean isFull() {
		for (Symbol[] i : squares) {
			for (Symbol k : i) {
				if (k == null) {
					return false;
				}
			}
		}
		return true;
	}

	public Symbol getSquare(Location location) {
		return squares[location.getX()][location.getY()];
	}

	public void setSquare(Location location, Symbol symbol) {
		squares[location.getX()][location.getY()] = symbol;

	}

}
