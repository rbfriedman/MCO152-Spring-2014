package friedman.tictactoe;

import junit.framework.Assert;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TicTacToeBoardTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testA() {
		TicTacToeBoard board = new TicTacToeBoard();
		Location[] locations = { new Location(0,1), new Location(1,1), new Location(2,1)};
		board.setSquare(locations[0], Symbol.X);
		board.setSquare(locations[1], Symbol.O);
		board.setSquare(locations[2], Symbol.X);
		Assert.assertNotNull(locations[0]);
		Assert.assertNotNull(locations[1]);
		Assert.assertNotNull(locations[2]);
		
		Assert.assertNull(board.getSquare(new Location(2,2)));
		Assert.assertFalse(board.isFull());
		
		Assert.assertEquals(board.getSquare(locations[0]), Symbol.X);
		Assert.assertEquals(board.getSquare(locations[1]), Symbol.O);
		Assert.assertEquals(board.getSquare(locations[2]), Symbol.X);
		board.reset();
		
		for(Location l: locations){
			Assert.assertNull(board.getSquare(l));
		}
	}

	
}
