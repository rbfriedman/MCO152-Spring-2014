package friedman.checkers;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * This implementation of a game of Checkers should match
 * http://simple.wikipedia.org/wiki/Checkers
 * 
 * How to play Checkers: https://www.youtube.com/watch?v=SuQY1_fCVsA
 */
public class CheckerBoard {

	public static final int WIDTH = 8;
	public static final int HEIGHT = 8;
	private final Piece[][] board;

	public CheckerBoard() {
		this.board = new Piece[HEIGHT][WIDTH];
	}

	public Piece getPiece(final int x, final int y) {
		return board[y][x];
	}

	public void setPiece(final int x, final int y, final Piece piece) {
		board[y][x] = piece;
	}

	public void removePiece(final int x, final int y) {
		setPiece(x, y, null);
	}

	/**
	 * Returns true if the x,y coordinate is within the 8x8 board, otherwise
	 * false -DONE
	 */
	public boolean isOnBoard(final int x, final int y) {

		return x < WIDTH && x >= 0 && y < HEIGHT && y >= 0 ? true : false;

	}

	/**
	 * Returns true if the square is null, otherwise false - DONE
	 */
	public boolean isEmptySquare(final int x, final int y) {
		return getPiece(x, y) == null;
	}

	/**
	 * Removes all pieces from the board - DONE
	 */
	public void clear() {
		for (int row = 0; row < WIDTH; row++) {
			for (int column = 0; column < HEIGHT; column++) {
				removePiece(row, column);
			}
		}
	}

	/**
	 * Sets the board to a starting configuration - DONE
	 */
	public void resetNewGame() {
		final int EVEN = 0;
		final int ODD = 1;
		int evenOrOddPosition = ODD;
		Piece currentPiece = Piece.WHITE_MAN;
		for (int row = 0; row < WIDTH; row++) {
			if (row == 3) {
				row = 5;
				currentPiece = Piece.RED_MAN;
			}
			for (int column = 0; column < HEIGHT; column++) {
				if (column % 2 == evenOrOddPosition) {
					setPiece(row, column, currentPiece);
				}
			}
			if (evenOrOddPosition == EVEN) {
				evenOrOddPosition = ODD;
			} else {
				evenOrOddPosition = EVEN;
			}
		}
	}

	@Override
	/**
	 * Returns a String representation of the board. Each row of the board should be on it's own line.
	 * A dash "-" represents an empty square. Pieces should be displayed using the .toString() method
	 * of the piece class. - DONE
	 */
	public String toString() {
		StringBuilder checkerBoard = new StringBuilder();
		Piece piece = null;
		for (int row = 0; row < WIDTH; row++) {
			for (int column = 0; column < HEIGHT; column++) {
				piece = getPiece(row, column);
				if (piece == null) {
					checkerBoard.append("-");
				} else {
					checkerBoard.append(piece.toString());
				}

			}
			checkerBoard.append("\n");
		}

		return checkerBoard.toString();
	}

	/**
	 * Do the Move, removing the piece from x1, y1 and setting the piece in x2,
	 * y2. If the piece is now on their "King's Row", then promote the piece
	 * should be promoted to a King - DONE
	 */
	public void execute(final Move move) {
		Piece movedPiece = getPiece(move.getX1(), move.getY1());
		removePiece(move.getX1(), move.getY1());
		if (move.getX2() == HEIGHT - 1 || move.getX2() == 0) {
			movedPiece = movedPiece.equals(Piece.RED_MAN) ? Piece.RED_KING
					: Piece.WHITE_KING;
		}
		setPiece(move.getX2(), move.getY2(), movedPiece);
	}

	/**
	 * Do the Jump, removing the piece from x1, y1 and setting the piece in x2,
	 * y2. Remove the piece from captureX, captureY as well. If the piece is now
	 * on their "King's Row", then promote the piece should be promoted to a
	 * King - DONE
	 */
	public void execute(final Jump jump) {
		Piece execPiece = getPiece(jump.getX1(), jump.getY1());
		removePiece(jump.getX1(), jump.getY1());
		removePiece(jump.getCaptureX(), jump.getCaptureY());
		if (jump.getX2() == HEIGHT - 1 || jump.getX2() == 0) {
			execPiece = execPiece.equals(Piece.RED_MAN) ? Piece.RED_KING
					: Piece.WHITE_KING;
		}
		setPiece(jump.getX2(), jump.getY2(), execPiece);
	}

	/**
	 * Returns a list of all possible moves from the piece at (x,y). If there is
	 * no piece on that square, or the piece cannot make a legal move then
	 * return an empty list
	 */
	public List<Move> getMoves(final int x, final int y) {
		// isOn
		List<Move> moves = new ArrayList<Move>();
		if (isEmptySquare(x, y)) {
			return moves;
		} else {
			Piece currentPiece = getPiece(x, y);
			// Red Piece
			if (currentPiece.getColor().equals(Color.RED)) {
				if (currentPiece.equals(Piece.RED_KING)) {
					if (isOnBoard(x + 1, y + 1)) {
						if (isEmptySquare(x + 1, y + 1)) {

							moves.add(new Move(x, y, x + 1, y + 1));
						} else if (getPiece(x + 1, y + 1).isEnemyColor(
								Color.WHITE)
								&& isOnBoard(x + 2, y + 2)) {
							moves.add(new Move(x, y, x + 2, y + 2));
						}
					}
					if (isOnBoard(x - 1, y + 1)) {
						if (isEmptySquare(x - 1, y + 1)) {

							moves.add(new Move(x, y, x - 1, y + 1));
						} else if (getPiece(x - 1, y + 1).isEnemyColor(
								Color.WHITE)
								&& isOnBoard(x - 2, y + 2)) {
							moves.add(new Move(x, y, x - 2, y + 2));
						}
					}
				}
				if (isOnBoard(x - 1, y - 1)) {
					if (isEmptySquare(x - 1, y - 1)) {

						moves.add(new Move(x, y, x - 1, y - 1));
					} else if (getPiece(x - 1, y - 1).isEnemyColor(Color.WHITE)
							&& isOnBoard(x - 2, y - 2)) {
						moves.add(new Move(x, y, x - 2, y - 2));
					}
				}
				if (isOnBoard(x + 1, y - 1)) {
					if (isEmptySquare(x + 1, y - 1)) {

						moves.add(new Move(x, y, x + 1, y - 1));
					} else if (getPiece(x + 1, y - 1).isEnemyColor(Color.WHITE)
							&& isOnBoard(x + 2, y - 2)) {
						moves.add(new Move(x, y, x + 2, y - 2));
					}
				}
				return moves;
			}
			// White Piece
			else if (currentPiece.getColor().equals(Color.WHITE)) {
				if (currentPiece.equals(Piece.WHITE_KING)) {
					if (isOnBoard(x - 1, y - 1)) {
						if (isEmptySquare(x - 1, y - 1)) {

							moves.add(new Move(x, y, x - 1, y - 1));
						} else if (getPiece(x - 1, y - 1).isEnemyColor(
								Color.WHITE)
								&& isOnBoard(x - 2, y - 2)) {
							moves.add(new Move(x, y, x - 2, y - 2));
						}
					}
					if (isOnBoard(x + 1, y - 1)) {
						if (isEmptySquare(x + 1, y - 1)) {

							moves.add(new Move(x, y, x + 1, y - 1));
						} else if (getPiece(x + 1, y - 1).isEnemyColor(
								Color.WHITE)
								&& isOnBoard(x + 2, y - 2)) {
							moves.add(new Move(x, y, x + 2, y - 2));
						}
					}
				}
				if (isOnBoard(x - 1, y + 1)) {
					if (isEmptySquare(x - 1, y + 1)) {

						moves.add(new Move(x, y, x - 1, y + 1));
					} else if (getPiece(x - 1, y + 1).isEnemyColor(Color.WHITE)
							&& isOnBoard(x - 2, y + 2)) {
						moves.add(new Move(x, y, x - 2, y + 2));
					}
				}
				if (isOnBoard(x + 1, y + 1)) {
					if (isEmptySquare(x + 1, y + 1)) {

						moves.add(new Move(x, y, x + 1, y + 1));
					} else if (getPiece(x + 1, y + 1).isEnemyColor(Color.WHITE)
							&& isOnBoard(x + 2, y + 2)) {
						moves.add(new Move(x, y, x + 2, y + 2));
					}
				}
				return moves;
			}

			return moves;
		}

	}

	/**
	 * Returns a list of all possible jumps from the piece at (x,y). If there is
	 * no piece on that square, or the piece cannot make a legal jump then
	 * return an empty list
	 */
	public List<Jump> getJumps(final int x, final int y) {
		ArrayList<Jump> jumps = new ArrayList<Jump>();
		if (!isOnBoard(x, y) || isEmptySquare(x, y)) {
			return jumps;
		} else {
			Piece currentPiece = getPiece(x, y);
			if (currentPiece.getColor().equals(Color.WHITE)) {
				if (currentPiece.isKing()) {
					if (isOnBoard(x - 2, y - 2) && isEmptySquare(x - 2, y - 2)
							&& !isEmptySquare(x - 1, y - 1)
							&& getPiece(x - 1, y - 1).isEnemyColor(Color.WHITE)) {
						jumps.add(new Jump(x, y, x - 1, y - 1, x - 2, y - 2));
					}
					if (isOnBoard(x + 2, y - 2) && isEmptySquare(x + 2, y - 2)
							&& !isEmptySquare(x + 1, y - 1)
							&& getPiece(x + 1, y - 1).isEnemyColor(Color.WHITE)) {
						jumps.add(new Jump(x, y, x + 1, y - 1, x + 2, y - 2));
					}

				}
				if (isOnBoard(x - 2, y + 2) && isEmptySquare(x - 2, y + 2)
						&& !isEmptySquare(x - 1, y + 1)
						&& getPiece(x - 1, y + 1).isEnemyColor(Color.WHITE)) {
					jumps.add(new Jump(x, y, x - 1, y + 1, x - 2, y + 2));
				}
				if (isOnBoard(x + 2, y + 2) && isEmptySquare(x + 2, y + 2)
						&& !isEmptySquare(x + 1, y + 1)
						&& getPiece(x + 1, y + 1).isEnemyColor(Color.WHITE)) {
					jumps.add(new Jump(x, y, x + 1, y + 1, x + 2, y + 2));
				}
				return jumps;
			} else {// Condition that square in empty has been checked
					// must be a red piece
				if (currentPiece.isKing()) {
					if (isOnBoard(x + 2, y + 2) && isEmptySquare(x + 2, y + 2)
							&& !isEmptySquare(x + 1, y + 1)
							&& getPiece(x + 1, y + 1).isEnemyColor(Color.RED)) {
						jumps.add(new Jump(x, y, x + 1, y + 1, x + 2, y + 2));
					}
					if (isOnBoard(x - 2, y + 2) && isEmptySquare(x - 2, y + 2)
							&& !isEmptySquare(x - 1, y + 1)
							&& getPiece(x - 1, y + 1).isEnemyColor(Color.RED)) {
						jumps.add(new Jump(x, y, x - 1, y + 1, x - 2, y + 2));
					}
				}
				if (isOnBoard(x + 2, y - 2) && isEmptySquare(x + 2, y - 2)
						&& !isEmptySquare(x + 1, y - 1)
						&& getPiece(x + 1, y - 1).isEnemyColor(Color.RED)) {
					jumps.add(new Jump(x, y, x + 1, y - 1, x + 2, y - 2));
				}
				if (isOnBoard(x - 2, y - 2) && isEmptySquare(x - 2, y - 2)
						&& !isEmptySquare(x - 1, y - 1)
						&& getPiece(x - 1, y - 1).isEnemyColor(Color.RED)) {
					jumps.add(new Jump(x, y, x - 1, y - 1, x - 2, y - 2));
				}

				return jumps;
			}

		}
	}

}
