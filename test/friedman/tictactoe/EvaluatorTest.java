package friedman.tictactoe;

import java.util.ArrayList;
import java.util.List;




import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import friedman.tictactoe.Evaluator;
import friedman.tictactoe.Location;
import friedman.tictactoe.Symbol;
import friedman.tictactoe.TicTacToeBoard;

public class EvaluatorTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testA() {
		TicTacToeBoard aBoard = new TicTacToeBoard();
		List<Location> winningLocations = new ArrayList<Location>();
		winningLocations.add(new Location(0,1));
		winningLocations.add(new Location(1,1));
		winningLocations.add(new Location(2,1));
		for(int i =0; i <3; i++)
			aBoard.setSquare(new Location(i,1), Symbol.X);
		aBoard.setSquare(new Location(0,0), Symbol.O);
		aBoard.setSquare(new Location(2,2), Symbol.O);
		aBoard.setSquare(new Location(2,0), Symbol.X);
		
		Evaluator evaluate = new Evaluator(aBoard);
		evaluate.evaluate();
		Assert.assertFalse(evaluate.isFull());
		Assert.assertEquals(Symbol.X, evaluate.getWinner());
		Assert.assertEquals(evaluate.getSquare(new Location(2,2)), Symbol.O);
		for(int i = 0; i <winningLocations.size();i++){
			Assert.assertTrue(evaluate.getWinningSquares().get(i).equals(winningLocations.get(i)));
		}
		
	}
	@Test
	public void testB() {
		TicTacToeBoard aBoard = new TicTacToeBoard();
		List<Location> winningLocations = new ArrayList<Location>();
		winningLocations.add(new Location(0,2));
		winningLocations.add(new Location(1,1));
		winningLocations.add(new Location(2,0));
		
		aBoard.setSquare(new Location(1,1), Symbol.X);
		aBoard.setSquare(new Location(1,2), Symbol.O);
		aBoard.setSquare(new Location(0,0), Symbol.O);
		aBoard.setSquare(new Location(2,2), Symbol.O);
		aBoard.setSquare(new Location(2,0), Symbol.X);
		aBoard.setSquare(new Location(0,2), Symbol.X);
		
		Evaluator evaluate = new Evaluator(aBoard);
		evaluate.evaluate();
		Assert.assertFalse(evaluate.isFull());
		Assert.assertEquals(Symbol.X, evaluate.getWinner());
		Assert.assertEquals(evaluate.getSquare(new Location(2,0)), Symbol.X);
		for(int i = 0; i <winningLocations.size();i++){
			Assert.assertTrue(evaluate.getWinningSquares().get(i).equals(winningLocations.get(i)));
		}
		
	}
	@Test
	public void testC() {
		TicTacToeBoard aBoard = new TicTacToeBoard();
		List<Location> winningLocations = new ArrayList<Location>();
		winningLocations.add(new Location(2,0));
		winningLocations.add(new Location(2,1));
		winningLocations.add(new Location(2,2));
		
		aBoard.setSquare(new Location(1,1), Symbol.O);
		aBoard.setSquare(new Location(1,0), Symbol.X);
		
		aBoard.setSquare(new Location(0,0), Symbol.X);
		aBoard.setSquare(new Location(0,1), Symbol.O);
		aBoard.setSquare(new Location(0,2), Symbol.X);
		aBoard.setSquare(new Location(2,0), Symbol.O);
		aBoard.setSquare(new Location(2,1), Symbol.O);
		aBoard.setSquare(new Location(2,2), Symbol.O);
		aBoard.setSquare(new Location(1,2), Symbol.O);
		
		
		Evaluator evaluate = new Evaluator(aBoard);
		evaluate.evaluate();
		Assert.assertTrue(evaluate.isFull());
		Assert.assertEquals(Symbol.O, evaluate.getWinner());
		Assert.assertEquals(evaluate.getSquare(new Location(2,0)), Symbol.O);
		Assert.assertEquals(evaluate.getSquare(new Location(1,2)), Symbol.O);
		Assert.assertEquals(evaluate.getWinningSquares().size(), winningLocations.size());
		for(int i = 0; i <winningLocations.size();i++){
			Assert.assertTrue(winningLocations.get(i).equals(evaluate.getWinningSquares().get(i)));
			
		}
		
	}
	@Test
	public void testD() {
		TicTacToeBoard aBoard = new TicTacToeBoard();
		List<Location> winningLocations = new ArrayList<Location>();
		winningLocations.add(new Location(1,0));
		winningLocations.add(new Location(1,1));
		winningLocations.add(new Location(1,2));
		
		
		aBoard.setSquare(new Location(1,0), Symbol.O);
		aBoard.setSquare(new Location(1,1), Symbol.O);
		aBoard.setSquare(new Location(1,2), Symbol.O);
		aBoard.setSquare(new Location(0,0), Symbol.X);
		aBoard.setSquare(new Location(0,1), Symbol.O);
		aBoard.setSquare(new Location(0,2), Symbol.X);
		aBoard.setSquare(new Location(2,0), Symbol.O);
		aBoard.setSquare(new Location(2,1), Symbol.X);
		aBoard.setSquare(new Location(2,2), Symbol.O);
		
		
		
		Evaluator evaluate = new Evaluator(aBoard);
		evaluate.evaluate();
		Assert.assertTrue(evaluate.isFull());
		Assert.assertEquals(Symbol.O, evaluate.getWinner());
		Assert.assertEquals(evaluate.getWinningSquares().size(), winningLocations.size());
		for(int i = 0; i <winningLocations.size();i++){
			Assert.assertTrue(winningLocations.get(i).equals(evaluate.getWinningSquares().get(i)));
			
		}
		
	}
	@Test
	public void testF() {
		TicTacToeBoard aBoard = new TicTacToeBoard();
		List<Location> winningLocations = new ArrayList<Location>();
		winningLocations.add(new Location(0,0));
		winningLocations.add(new Location(1,1));
		winningLocations.add(new Location(2,2));
		
		
		aBoard.setSquare(new Location(1,0), Symbol.O);
		aBoard.setSquare(new Location(1,1), Symbol.X);
		aBoard.setSquare(new Location(1,2), Symbol.O);
		
		aBoard.setSquare(new Location(0,1), Symbol.O);
		aBoard.setSquare(new Location(0,0), Symbol.X);
		aBoard.setSquare(new Location(0,2), Symbol.O);
		
		aBoard.setSquare(new Location(2,0), Symbol.O);
		aBoard.setSquare(new Location(2,1), Symbol.O);
		aBoard.setSquare(new Location(2,2), Symbol.X);
		
		
		
		Evaluator evaluate = new Evaluator(aBoard);
		evaluate.evaluate();
		Assert.assertTrue(evaluate.isFull());
		Assert.assertEquals(Symbol.X, evaluate.getWinner());
		Assert.assertEquals(evaluate.getWinningSquares().size(), winningLocations.size());
		for(int i = 0; i <winningLocations.size();i++){
			Assert.assertTrue(winningLocations.get(i).equals(evaluate.getWinningSquares().get(i)));
			
		}
		
	}
	@Test
	public void testG() {
		TicTacToeBoard aBoard = new TicTacToeBoard();
		List<Location> winningLocations = new ArrayList<Location>();
		winningLocations.add(new Location(0,2));
		winningLocations.add(new Location(1,1));
		winningLocations.add(new Location(2,0));
		
		
		aBoard.setSquare(new Location(1,0), Symbol.X);
		aBoard.setSquare(new Location(1,1), Symbol.O);
		aBoard.setSquare(new Location(1,2), Symbol.X);
		
		aBoard.setSquare(new Location(0,1), Symbol.X);
		aBoard.setSquare(new Location(0,0), Symbol.X);
		aBoard.setSquare(new Location(0,2), Symbol.O);
		
		aBoard.setSquare(new Location(2,0), Symbol.O);
		aBoard.setSquare(new Location(2,1), Symbol.X);
		aBoard.setSquare(new Location(2,2), Symbol.O);
		
		
		
		Evaluator evaluate = new Evaluator(aBoard);
		evaluate.evaluate();
		Assert.assertTrue(evaluate.isFull());
		Assert.assertEquals(Symbol.O, evaluate.getWinner());
		Assert.assertEquals(evaluate.getWinningSquares().size(), winningLocations.size());
		for(int i = 0; i <winningLocations.size();i++){
			Assert.assertTrue(winningLocations.get(i).equals(evaluate.getWinningSquares().get(i)));
			
		}
		
	}
	@Test
	public void testH() {
		TicTacToeBoard aBoard = new TicTacToeBoard();
		List<Location> winningLocations = new ArrayList<Location>();
		winningLocations.add(new Location(0,0));
		winningLocations.add(new Location(1,0));
		winningLocations.add(new Location(2,0));
		
		
		aBoard.setSquare(new Location(1,0), Symbol.X);
		aBoard.setSquare(new Location(1,1), Symbol.X);
		aBoard.setSquare(new Location(1,2), Symbol.O);
		
		
		aBoard.setSquare(new Location(0,0), Symbol.X);
		aBoard.setSquare(new Location(0,1), Symbol.O);
		aBoard.setSquare(new Location(0,2), Symbol.X);
		
		aBoard.setSquare(new Location(2,0), Symbol.X);
		aBoard.setSquare(new Location(2,1), Symbol.X);
		aBoard.setSquare(new Location(2,2), Symbol.O);
		
		
		
		Evaluator evaluate = new Evaluator(aBoard);
		evaluate.evaluate();
		Assert.assertTrue(evaluate.isFull());
		Assert.assertEquals(Symbol.X, evaluate.getWinner());
		Assert.assertEquals(evaluate.getWinningSquares().size(), winningLocations.size());
		for(int i = 0; i <winningLocations.size();i++){
			Assert.assertTrue(winningLocations.get(i).equals(evaluate.getWinningSquares().get(i)));
			
		}
		
	}
	@Test
	public void testI() {
		TicTacToeBoard aBoard = new TicTacToeBoard();
		List<Location> winningLocations = new ArrayList<Location>();
		winningLocations.add(new Location(0,1));
		winningLocations.add(new Location(1,1));
		winningLocations.add(new Location(2,1));
		
		
		aBoard.setSquare(new Location(1,0), Symbol.X);
		aBoard.setSquare(new Location(1,1), Symbol.O);
		aBoard.setSquare(new Location(1,2), Symbol.O);
		
		
		aBoard.setSquare(new Location(0,0), Symbol.O);
		aBoard.setSquare(new Location(0,1), Symbol.O);
		aBoard.setSquare(new Location(0,2), Symbol.X);
		
		aBoard.setSquare(new Location(2,0), Symbol.X);
		aBoard.setSquare(new Location(2,1), Symbol.O);
		aBoard.setSquare(new Location(2,2), Symbol.X);
		
		
		
		Evaluator evaluate = new Evaluator(aBoard);
		evaluate.evaluate();
		Assert.assertTrue(evaluate.isFull());
		Assert.assertEquals(Symbol.O, evaluate.getWinner());
		Assert.assertEquals(evaluate.getWinningSquares().size(), winningLocations.size());
		for(int i = 0; i <winningLocations.size();i++){
			Assert.assertTrue(winningLocations.get(i).equals(evaluate.getWinningSquares().get(i)));
			
		}
		
	}
	@Test
	public void testJ() {
		TicTacToeBoard aBoard = new TicTacToeBoard();
		List<Location> winningLocations = new ArrayList<Location>();
		winningLocations.add(new Location(0,2));
		winningLocations.add(new Location(1,2));
		winningLocations.add(new Location(2,2));
		
		
		aBoard.setSquare(new Location(1,0), Symbol.O);
		aBoard.setSquare(new Location(1,1), Symbol.O);
		aBoard.setSquare(new Location(1,2), Symbol.X);
		
		
		aBoard.setSquare(new Location(0,0), Symbol.X);
		aBoard.setSquare(new Location(0,1), Symbol.O);
		aBoard.setSquare(new Location(0,2), Symbol.X);
		
		aBoard.setSquare(new Location(2,0), Symbol.O);
		aBoard.setSquare(new Location(2,1), Symbol.X);
		aBoard.setSquare(new Location(2,2), Symbol.X);
		
		
		
		Evaluator evaluate = new Evaluator(aBoard);
		evaluate.evaluate();
		Assert.assertTrue(evaluate.isFull());
		Assert.assertEquals(Symbol.X, evaluate.getWinner());
		Assert.assertEquals(evaluate.getWinningSquares().size(), winningLocations.size());
		for(int i = 0; i <winningLocations.size();i++){
			Assert.assertTrue(winningLocations.get(i).equals(evaluate.getWinningSquares().get(i)));
			
		}
		
	}
	@Test
	public void testNoWinnerOnEmptyboard(){
		TicTacToeBoard aBoard = new TicTacToeBoard();
		List<Location> winningLocations = new ArrayList<Location>();
		Evaluator evaluate = new Evaluator(aBoard);
		evaluate.evaluate();
		Assert.assertFalse(evaluate.isFull());
		Assert.assertNull(evaluate.getWinner());
	}
	
	@Test
	public void testNoWinnerOnFullboard(){
		
	}

}
