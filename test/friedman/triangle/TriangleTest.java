package friedman.triangle;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TriangleTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() {
		Triangle height3 = new Triangle(3);
		String actual = height3.toString();
		String expected = "  *\n" + " * *\n" + "*****";

		Assert.assertEquals(actual, expected);
		Assert.assertEquals(height3.getBase(), 5);

	}

	@Test
	public void test5() {
		Triangle height5 = new Triangle(5);
		String actual = height5.toString();
		String expected = "    *\n" + "   * *\n" + "  *   *\n" + " *     *\n"
				+ "*********";
		Assert.assertEquals(actual, expected);
		Assert.assertEquals(height5.getBase(), 9);

	}

	@Test
	public void test7() {
		Triangle height7 = new Triangle(7);
		String actual = height7.toString();
		String expected = "      *\n" + "     * *\n" + "    *   *\n"
				+ "   *     *\n" + "  *       *\n" + " *         *\n"
				+ "*************";
		Assert.assertEquals(actual, expected);
		Assert.assertEquals(height7.getBase(), 13);

	}

}
