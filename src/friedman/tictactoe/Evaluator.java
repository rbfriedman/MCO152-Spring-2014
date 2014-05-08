package friedman.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class Evaluator {
	private TicTacToeBoard board;
	private Symbol winner;
	private List<Location> winningSquares;

	public Evaluator(TicTacToeBoard board) {
		this.board = board;
		this.winningSquares = null;
		this.winner = null;

	}

	public boolean evaluateForSymbol(Symbol symbol) {
		boolean winnerUndeclared = true;
		int i = 0;

		while (i < 3 && winnerUndeclared) {
			if (symbol.equals(this.board.getSquare(new Location(i, 0)))
					&& symbol.equals(board.getSquare(new Location(i, 1)))
					&& symbol.equals(board.getSquare(new Location(i, 2)))) {
				winnerUndeclared = false;
				this.winner = this.board.getSquare(new Location(i, 0));
				this.winningSquares =  new ArrayList<Location>();
				this.winningSquares.add(new Location(i, 0));
				this.winningSquares.add(new Location(i, 1));
				this.winningSquares.add(new Location(i, 2));
			}
			i++;
		}
		i = 0;
		while (i < 3 && winnerUndeclared) {
			if (symbol.equals(this.board.getSquare(new Location(0, i)))
					&& symbol.equals(board.getSquare(new Location(1, i)))
					&& symbol.equals(board.getSquare(new Location(2, i)))) {
				winnerUndeclared = false;
				this.winner = symbol;
				this.winningSquares =  new ArrayList<Location>();
				this.winningSquares.add(new Location(0, i));
				this.winningSquares.add(new Location(1, i));
				this.winningSquares.add(new Location(2, i));
			}
			i++;
		}

		if (winnerUndeclared) {
			if (symbol.equals(this.board.getSquare(new Location(0, 0)))
					&& symbol.equals(board.getSquare(new Location(1, 1)))
					&& symbol.equals(board.getSquare(new Location(2, 2)))) {
				winnerUndeclared = false;
				this.winner = symbol;
				this.winningSquares =  new ArrayList<Location>();
				this.winningSquares.add(new Location(0, 0));
				this.winningSquares.add(new Location(1, 1));
				this.winningSquares.add(new Location(2, 2));
			}
			if (winnerUndeclared) {
				if (symbol.equals(this.board.getSquare(new Location(0, 2)))
						&& symbol.equals(board.getSquare(new Location(1, 1)))
						&& symbol.equals(board.getSquare(new Location(2, 0))))  {
					winnerUndeclared = false;
					this.winner = symbol;
					this.winningSquares =  new ArrayList<Location>();
					this.winningSquares.add(new Location(0, 2));
					this.winningSquares.add(new Location(1, 1));
					this.winningSquares.add(new Location(2, 0));
				}
			}
		}
		return winnerUndeclared;
	}

	public void evaluate() {

		evaluateForSymbol(Symbol.X);
		evaluateForSymbol(Symbol.O);	

	}

	public Symbol getWinner() {
		return this.winner;
	}

	public List<Location> getWinningSquares() {
		return this.winningSquares;
	}

	public Symbol getSquare(Location location) {
		return board.getSquare(location);
	}
	
	public boolean isFull(){
		return board.isFull();
	}

}
