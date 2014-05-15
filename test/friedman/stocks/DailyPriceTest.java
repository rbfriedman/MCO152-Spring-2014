package friedman.stocks;

import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class DailyPriceTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testInitialization() {
		String[] tokens = "2/8/2010".split("/");
		Date date = new GregorianCalendar(Integer.parseInt(tokens[0]),
				Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]))
				.getTime();
		new DailyPrice("AMEX", "NKO", date, 13.53, 13.53, 13.4,
				13.5, 4500, 13.5);
	}

	@Test
	public void testGetters() {
		String[] tokens = "2/4/2010".split("/");
		Date date = new GregorianCalendar(Integer.parseInt(tokens[0]),
				Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]))
				.getTime();
		DailyPrice dp = new DailyPrice("AMEX", "NKO", date, 13.44, 13.55,
				13.32, 13.55, 15800, 13.55);
		Assert.assertEquals(dp.getExchange(), "AMEX");
		Assert.assertEquals(dp.getSymbol(), "NKO");
		Assert.assertEquals(dp.getDate(), date);
		Assert.assertEquals(dp.getOpenPrice(), 13.44, .0001);
		Assert.assertEquals(dp.getHighPrice(), 13.55, .0001);
		Assert.assertEquals(dp.getLowPrice(), 13.32, .0001);
		Assert.assertEquals(dp.getClosePrice(), 13.55, .0001);
		Assert.assertEquals(dp.getVolume(), 15800);
		Assert.assertEquals(dp.getAdjustedClosePrice(), 13.55, .0001);
	}

	@Test
	public void testToString() {
		String[] tokens = "2/4/2010".split("/");
		Date date = new GregorianCalendar(Integer.parseInt(tokens[0]),
				Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]))
				.getTime();
		DailyPrice dp = new DailyPrice("AMEX", "NKO", date, 13.44, 13.55,
				13.32, 13.55, 15800, 13.55);
		Assert.assertNotNull(dp.toString());
	}

}
