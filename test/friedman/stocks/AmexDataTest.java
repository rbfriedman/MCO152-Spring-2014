package friedman.stocks;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class AmexDataTest {
	private AmexData a;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testRun() throws Exception {

	}

	@Test
	public void testContainsA() throws Exception {
		a = new AmexData();
		// Test if it contains stocks from beginning, middle, and end of each
		// file
		Assert.assertTrue(a.contains("AIP"));
		Assert.assertTrue(a.contains("ACY"));
		Assert.assertTrue(a.contains("AFO"));
	}

	@Test
	public void testContainsB() throws Exception {
		a = new AmexData();
		// Test if it contains stocks from beginning, middle, and end of each
		// file
		Assert.assertTrue(a.contains("BOI"));
		Assert.assertTrue(a.contains("BCV"));
		Assert.assertTrue(a.contains("BFY"));
	}

	@Test
	public void testContainsC() throws Exception {
		a = new AmexData();
		// Test if it contains stocks from beginning, middle, and end of each
		// file
		Assert.assertTrue(a.contains("CXM"));
		Assert.assertTrue(a.contains("CUB"));
		Assert.assertTrue(a.contains("CXA"));
	}

	@Test
	public void testContainsD() throws Exception {
		a = new AmexData();
		// Test if it contains stocks from beginning, middle, and end of each
		// file
		Assert.assertTrue(a.contains("DSI"));
		Assert.assertTrue(a.contains("DBP"));
		Assert.assertTrue(a.contains("DSC"));
	}

	@Test
	public void testContainsE() throws Exception {
		a = new AmexData();
		// Test if it contains stocks from beginning, middle, and end of each
		// file
		Assert.assertTrue(a.contains("ERH"));
		Assert.assertTrue(a.contains("EMI"));
		Assert.assertTrue(a.contains("EKH"));
	}

	@Test
	public void testContainsFalse() throws Exception {
		a = new AmexData();
		// Test if it contains stocks
		Assert.assertFalse(a.contains("EPPH"));
		Assert.assertFalse(a.contains("EMIP"));
		Assert.assertFalse(a.contains("EKH)"));
	}

	@Test
	public void testGetPrices() throws Exception {
		a = new AmexData();
		List<DailyPrice> prices = a.getPrices("CXM");
		System.out.println(prices.toString());
		
		Assert.assertEquals(prices.size(), 1590);
		Assert.assertTrue(prices.get(5).getDate()
				.after(prices.get(7).getDate()));
		Assert.assertTrue(prices.get(9).getDate()
				.after(prices.get(45).getDate()));
	}
	@Test
	public void testGetPricesInTimePeriodReturnEmptyList() throws Exception {
		a = new AmexData();
		GregorianCalendar date = new GregorianCalendar();
		date.set(Calendar.MONTH, 1);
		date.set(Calendar.DATE, 6);
		date.set(Calendar.YEAR, 2010);
		Date aDate = date.getTime();
		Assert.assertArrayEquals(a.getPrices("CM", aDate, aDate).toArray(),new ArrayList<DailyPrice>().toArray());
	}
	@Test
	public void testGetPricesWithinShwimmerRange() throws IOException{
		a = new AmexData();
		Assert.assertEquals(2, a.getPrices("AIP","2009-12-30","2010-01-01").size());
		a.getPrices("AIP", "2009-01-02", "2009-12-31");
	Assert.assertEquals(252,a.getPrices("AIP", "2009-01-02", "2009-12-31").size());
	}
	@Test
	public void testGetPricesReturnsEmptyList() throws IOException{
		a = new AmexData();
		Assert.assertArrayEquals(a.getPrices("DS").toArray(),new ArrayList<DailyPrice>().toArray());
	}
	@Test
	public void testGetPricesInTimePeriod() throws Exception {
		a = new AmexData();
		GregorianCalendar date = new GregorianCalendar();
		date.set(Calendar.MONTH, 1);
		date.set(Calendar.DATE, 6);
		date.set(Calendar.YEAR, 2010);
		Date aDate = date.getTime();
		date.set(Calendar.DATE, 19);
		List<DailyPrice> prices = a.getPrices("CXM", date.getTime(), aDate);
		
		Assert.assertTrue(prices.get(5).getDate()
				.after(prices.get(7).getDate()));
		Assert.assertTrue(prices.get(1).getDate()
				.after(prices.get(2).getDate()));
	}

}
