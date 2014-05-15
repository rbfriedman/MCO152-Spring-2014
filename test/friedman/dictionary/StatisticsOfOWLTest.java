package friedman.dictionary;

import java.io.FileNotFoundException;




import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import friedman.dictionary.StatisticsOfOWL;

public class StatisticsOfOWLTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testCountChar() throws FileNotFoundException {
		StatisticsOfOWL stat = new StatisticsOfOWL();
		int sum =0;
		for(Object v:stat.getletterStatisticsMap().values()){
			sum+=(Integer) v;
		}
		Assert.assertEquals((Integer)stat.getCharCount(), (Integer)sum);
	}
	

}
