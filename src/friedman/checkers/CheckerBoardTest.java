package friedman.checkers;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class CheckerBoardTest {
 
	@Test 
	/**
	 * Your code must pass this test. Do not edit this test.
	 */
	public void testToStringOnEmptyBoard() {
		final CheckerBoard board = new CheckerBoard();
		final String expected = "--------\n" + "--------\n" + "--------\n"
				+ "--------\n" + "--------\n" + "--------\n" + "--------\n"
				+ "--------\n";
		Assert.assertEquals(expected.trim(), board.toString().trim());
	}

	@Test
	/**
	 * Your code must pass this test. Do not edit this test.
	 */
	public void testToStringAfterNewGame() {
		final CheckerBoard board = new CheckerBoard();
		board.resetNewGame();
		final String expected = "-w-w-w-w\n" + "w-w-w-w-\n" + "-w-w-w-w\n"
				+ "--------\n" + "--------\n" + "r-r-r-r-\n" + "-r-r-r-r\n"
				+ "r-r-r-r-\n";
		Assert.assertEquals(expected.trim(), board.toString().trim());
	}

	@Test
	/**
	 * Test that isOnBoard() returns the correct result for different xs and ys
	 */
	public void testIsOnBoard() {
		final CheckerBoard board = new CheckerBoard();
		for (int row = 0; row < board.WIDTH; row++) {
			for (int column = 1; column < board.HEIGHT; column++) {
				Assert.assertTrue(board.isOnBoard(row, column));
			}
		}
		for (int row = 0; row < board.WIDTH; row++) {
			for (int column = board.HEIGHT; column < 10; column++) {
				Assert.assertFalse(board.isOnBoard(row, column));
			}
		}
		for (int row = board.WIDTH; row < 10; row++) {
			for (int column = 0; column < board.HEIGHT; column++) {
				Assert.assertFalse(board.isOnBoard(row, column));
			}
		}

		for (int row = board.WIDTH; row < 10; row++) {
			for (int column = board.HEIGHT; column < 10; column++) {
				Assert.assertFalse(board.isOnBoard(row, column));
			}
		}

	}

	@Test
	/**
	 * Test that isEmptySquare() returns the correct result before and after setPiece() is called
	 */
	public void testIsEmptySquare() {
		final CheckerBoard board = new CheckerBoard();
		Assert.assertTrue(board.isEmptySquare(0, 7));

	}

	@Test
	/**
	 * Given an board with pieces, test that calling clear() clears the board
	 */
	public void testClear() {
		final CheckerBoard board = new CheckerBoard();
		board.resetNewGame();
		board.clear();

		// Hard code the answers
		// Row 1
		Assert.assertNull(board.getPiece(0, 1));
		Assert.assertNull(board.getPiece(0, 3));
		Assert.assertNull(board.getPiece(0, 5));
		Assert.assertNull(board.getPiece(0, 7));
		// Row 2
		Assert.assertNull(board.getPiece(1, 0));
		Assert.assertNull(board.getPiece(1, 2));
		Assert.assertNull(board.getPiece(1, 4));
		Assert.assertNull(board.getPiece(1, 6));
		// Row 3
		Assert.assertNull(board.getPiece(2, 1));
		Assert.assertNull(board.getPiece(2, 3));
		Assert.assertNull(board.getPiece(2, 5));
		Assert.assertNull(board.getPiece(2, 7));

		// Row 5
		Assert.assertNull(board.getPiece(5, 0));
		Assert.assertNull(board.getPiece(5, 2));
		Assert.assertNull(board.getPiece(5, 4));
		Assert.assertNull(board.getPiece(5, 6));
		// Row 6
		Assert.assertNull(board.getPiece(6, 1));
		Assert.assertNull(board.getPiece(6, 3));
		Assert.assertNull(board.getPiece(6, 5));
		Assert.assertNull(board.getPiece(6, 7));
		// Row 7
		Assert.assertNull(board.getPiece(7, 0));
		Assert.assertNull(board.getPiece(7, 2));
		Assert.assertNull(board.getPiece(7, 4));
		Assert.assertNull(board.getPiece(7, 6));

	}

	@Test
	/**
	 * Test that the board is in the correct configuration after
	 * resetNewGame() is called
	 */
	public void testResetNewGame() {
		final CheckerBoard board = new CheckerBoard();
		board.resetNewGame();

		// Hard code the answers
		// Row 1
		Assert.assertEquals(board.getPiece(0, 1), Piece.WHITE_MAN);
		Assert.assertEquals(board.getPiece(0, 3), Piece.WHITE_MAN);
		Assert.assertEquals(board.getPiece(0, 5), Piece.WHITE_MAN);
		Assert.assertEquals(board.getPiece(0, 7), Piece.WHITE_MAN);
		// Row 2
		Assert.assertEquals(board.getPiece(1, 0), Piece.WHITE_MAN);
		Assert.assertEquals(board.getPiece(1, 2), Piece.WHITE_MAN);
		Assert.assertEquals(board.getPiece(1, 4), Piece.WHITE_MAN);
		Assert.assertEquals(board.getPiece(1, 6), Piece.WHITE_MAN);
		// Row 3
		Assert.assertEquals(board.getPiece(2, 1), Piece.WHITE_MAN);
		Assert.assertEquals(board.getPiece(2, 3), Piece.WHITE_MAN);
		Assert.assertEquals(board.getPiece(2, 5), Piece.WHITE_MAN);
		Assert.assertEquals(board.getPiece(2, 7), Piece.WHITE_MAN);

		// Row 5
		Assert.assertEquals(board.getPiece(5, 0), Piece.RED_MAN);
		Assert.assertEquals(board.getPiece(5, 2), Piece.RED_MAN);
		Assert.assertEquals(board.getPiece(5, 4), Piece.RED_MAN);
		Assert.assertEquals(board.getPiece(5, 6), Piece.RED_MAN);
		// Row 6
		Assert.assertEquals(board.getPiece(6, 1), Piece.RED_MAN);
		Assert.assertEquals(board.getPiece(6, 3), Piece.RED_MAN);
		Assert.assertEquals(board.getPiece(6, 5), Piece.RED_MAN);
		Assert.assertEquals(board.getPiece(6, 7), Piece.RED_MAN);
		// Row 7
		Assert.assertEquals(board.getPiece(7, 0), Piece.RED_MAN);
		Assert.assertEquals(board.getPiece(7, 2), Piece.RED_MAN);
		Assert.assertEquals(board.getPiece(7, 4), Piece.RED_MAN);
		Assert.assertEquals(board.getPiece(7, 6), Piece.RED_MAN);

	}

	@Test
	/**
	 * Test execute(Move) moves a piece from one square to the other
	 */
	public void testMove() {
		final CheckerBoard board = new CheckerBoard();
		board.setPiece(0, 1, Piece.WHITE_MAN);
		board.execute(new Move(0, 1, 1, 2));
		Assert.assertEquals(board.getPiece(1, 2), Piece.WHITE_MAN);
	}

	@Test
	/**
	 * Test execute(Move) promotes a WHITE_MAN to a WHITE_KING when moving to the 8th row
	 */
	public void testMovePromoteToWhiteKing() {
		final CheckerBoard board = new CheckerBoard();
		board.setPiece(6, 1, Piece.WHITE_MAN);
		board.execute(new Move(6, 1, 7, 2));
		Assert.assertEquals(board.getPiece(7, 2), Piece.WHITE_KING);
	}

	@Test
	/**
	 * Test execute(Move) promotes a RED_MAN to a RED_KING when moving to the 1st row
	 */
	public void testMovePromoteToRedKing() {
		final CheckerBoard board = new CheckerBoard();
		board.setPiece(1, 2, Piece.RED_MAN);
		board.execute(new Move(1, 2, 0, 3));
		Assert.assertEquals(board.getPiece(0, 3), Piece.RED_KING);
	}

	@Test
	/**
	 * Test execute(Jump) moves a piece from one square to another AND removes the piece that was jumped
	 */
	public void testJump() {
		final CheckerBoard board = new CheckerBoard();
		board.setPiece(5, 0, Piece.RED_MAN);
		board.execute(new Jump(5, 0, 4, 1, 3, 2));
		Assert.assertEquals(board.getPiece(3, 2), Piece.RED_MAN);

	}

	@Test
	/**
	 * Test execute(Jump) promotes a RED_MAN to a RED_KING when moving to the 1st row
	 */
	public void testJumpPromoteToRedKing() {
		final CheckerBoard board = new CheckerBoard();
		board.setPiece(2, 0, Piece.RED_MAN);
		board.execute(new Jump(2, 0, 1, 1, 0, 2));
		Assert.assertEquals(board.getPiece(0, 2), Piece.RED_KING);
	}

	@Test
	/**
	 * Test execute(Jump) promotes a WHITE_MAN to a WHITE_KING when moving to the 1st row
	 */
	public void testJumpPromoteToWhiteKing() {
		final CheckerBoard board = new CheckerBoard();
		board.setPiece(5, 5, Piece.WHITE_MAN);
		board.execute(new Jump(5, 5, 6, 6, 7, 7));
		Assert.assertEquals(board.getPiece(7, 7), Piece.WHITE_KING);
	}

	@Test
	/**
	 * Test that getMoves() returns the correct number of Move objects when called on an empty square
	 */
	public void testGetMovesForEmptySquare() {
		final CheckerBoard board = new CheckerBoard();
		Assert.assertArrayEquals(new Move[0], board.getMoves(3, 1).toArray());
	}

	@Test
	/**
	 * Test that getMoves() returns the correct Move objects when a RED_MAN is in the middle of an otherwise
	 * empty board
	 */
	public void testGetMovesForRedManInMiddleOfEmptyBoard() {
		final CheckerBoard board = new CheckerBoard();
		board.setPiece(4, 4, Piece.RED_MAN);
		List<Move> moves = new ArrayList<Move>();

		moves.add(new Move(4, 4, 3, 3));
		moves.add(new Move(4, 4, 5, 3));
		Assert.assertArrayEquals(board.getMoves(4, 4).toArray(),
				moves.toArray());

	}

	@Test
	/**
	 * Test that getMoves() returns the correct Move objects when a RED_KING is in the middle of an otherwise
	 * empty board
	 */
	public void testGetMovesForRedKingInMiddleOfEmptyBoard() {
		final CheckerBoard board = new CheckerBoard();
		board.setPiece(4, 4, Piece.RED_KING);
		List<Move> moves = new ArrayList<Move>();

		moves.add(new Move(4, 4, 5, 5));
		moves.add(new Move(4, 4, 3, 5));
		moves.add(new Move(4, 4, 3, 3));
		moves.add(new Move(4, 4, 5, 3));
		Assert.assertArrayEquals(board.getMoves(4, 4).toArray(),
				moves.toArray());

	}

	@Test
	/**
	 * Test that getMoves() returns the correct Move objects when a RED_MAN is in the middle of an otherwise
	 * empty board
	 */
	public void testGetMovesForWhiteManInMiddleOfEmptyBoard() {
		final CheckerBoard board = new CheckerBoard();
		board.setPiece(4, 4, Piece.WHITE_MAN);
		List<Move> moves = new ArrayList<Move>();

		moves.add(new Move(4, 4, 3, 5));
		moves.add(new Move(4, 4, 5, 5));
		Assert.assertArrayEquals(board.getMoves(4, 4).toArray(),
				moves.toArray());
	}

	@Test
	/**
	 * Test that getMoves() returns the correct Move objects when a RED_KING is in the middle of an otherwise
	 * empty board
	 */
	public void testGetMovesForWhiteKingInMiddleOfEmptyBoard() {
		final CheckerBoard board = new CheckerBoard();
		board.setPiece(4, 4, Piece.WHITE_KING);
		List<Move> moves = new ArrayList<Move>();

		moves.add(new Move(4, 4, 3, 3));
		moves.add(new Move(4, 4, 5, 3));
		moves.add(new Move(4, 4, 3, 5));
		moves.add(new Move(4, 4, 5, 5));

		Assert.assertArrayEquals(board.getMoves(4, 4).toArray(),
				moves.toArray());
	}

	@Test
	/**
	 * Test that getMoves() returns the correct Move objects when a RED_KING is surrounded in 4 directions and
	 * cannot move.
	 * This should be an empty List
	 */
	public void testGetMovesForRedKingWhenSurrounded() {
		final CheckerBoard board = new CheckerBoard();
		board.setPiece(2, 5, Piece.RED_KING);
		board.setPiece(1, 4, Piece.WHITE_MAN);
		board.setPiece(1, 6, Piece.WHITE_MAN);
		board.setPiece(3, 4, Piece.WHITE_MAN);
		board.setPiece(3, 6, Piece.WHITE_MAN);
		Assert.assertArrayEquals(new ArrayList<Move>().toArray(), board
				.getMoves(2, 5).toArray());

	}

	@Test
	/**
	 * Test that when getMoves() is called for a piece at the EDGE of the board (0,7) then the correct
	 * move is returned.
	 */
	public void testGetMovesForRedKingAt07() {
		final CheckerBoard board = new CheckerBoard();
		board.setPiece(0, 7, Piece.RED_KING);
		List<Move> moves = new ArrayList<Move>();
		moves.add(new Move(0, 7, 1, 6));
		Assert.assertArrayEquals(board.getMoves(0, 7).toArray(),
				moves.toArray());

	}

	@Test
	/**
	 * Test that when getMoves() is called for a piece at the EDGE of the board (7,0) then the correct
	 * move is returned.
	 */
	public void testGetMovesForRedKingAt70() {
		final CheckerBoard board = new CheckerBoard();
		board.setPiece(7, 0, Piece.RED_KING);
		List<Move> moves = new ArrayList<Move>();
		moves.add(new Move(7, 0, 6, 1));
		Assert.assertArrayEquals(board.getMoves(7, 0).toArray(),
				moves.toArray());
	}

	@Test
	/**
	 * Test that getJumps() returns the correct number of Jump objects when called on an empty square
	 */
	public void testGetJumpsForEmptySquare() {
		final CheckerBoard board = new CheckerBoard();
		Assert.assertArrayEquals(new ArrayList<Jump>().toArray(), board
				.getJumps(3, 4).toArray());
	}

	@Test
	/**
	 * Test that getJumps() returns the correct number of Jump objects when called on square that does not have
	 * any possible jumps
	 */
	public void testGetJumpsForRedKingInMiddleOfEmptyBoard() {
		final CheckerBoard board = new CheckerBoard();
		board.setPiece(2, 3, Piece.RED_KING);
		Assert.assertArrayEquals(new ArrayList<Jump>().toArray(), board
				.getJumps(2, 3).toArray());
	}

	@Test
	/**
	 * Test that getJumps() returns the correct Jump objects when a King can jump in 4 directions
	 */
	public void testGetJumpsForRedKingWhenSurrounded() {
		final CheckerBoard board = new CheckerBoard();
		board.setPiece(2, 3, Piece.RED_KING);
		board.setPiece(3, 4, Piece.WHITE_KING);
		board.setPiece(1, 4, Piece.WHITE_MAN);
		board.setPiece(3, 2, Piece.WHITE_MAN);
		board.setPiece(1, 2, Piece.WHITE_MAN);
		ArrayList<Jump> jumps = new ArrayList<Jump>();
		jumps.add(new Jump(2, 3, 3, 4, 4, 5));
		jumps.add(new Jump(2, 3, 1, 4, 0, 5));
		jumps.add(new Jump(2, 3, 3, 2, 4, 1));
		jumps.add(new Jump(2, 3, 1, 2, 0, 1));
		System.out.println(board.getJumps(2,3).toString());
		Assert.assertArrayEquals(jumps.toArray(), board.getJumps(2, 3)
				.toArray());

	}

	@Test
	/**
	 * Test that getJumps() returns the returns the correct Jump objects when a Piece can jump in 2 directions
	 */
	public void testGetJumpsForRedManWhenSurrounded() {
		final CheckerBoard board = new CheckerBoard();
		board.setPiece(3, 3, Piece.RED_MAN);
		board.setPiece(4, 2, Piece.WHITE_MAN);
		board.setPiece(2, 2, Piece.WHITE_MAN);
		ArrayList<Jump> jumps = new ArrayList<Jump>();
		jumps.add(new Jump(3, 3, 4, 2, 5, 1));
		jumps.add(new Jump(3, 3, 2, 2, 1, 1));
		board.setPiece(4, 2, Piece.RED_MAN);
	}

}
