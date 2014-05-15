package friedman.circle2D;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import friedman.circle2D.Circle2D;

public class Circle2DTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testA() {
		Circle2D circleA = new Circle2D();
		Circle2D circleB = new Circle2D(30, 40, 5);
		Circle2D circleC = new Circle2D(30, 40, 7);

		Circle2D circleD = new Circle2D(35, 38, 10);

		Assert.assertTrue(circleC.contains(circleB));
		Assert.assertTrue(circleB.contains(33, 41));
		Assert.assertFalse(circleA.contains(1,1 ));

		// Assert.assertNotEquals(Math.PI*2*7, circleC.getArea(),.001);
		Assert.assertEquals(7 * 7 * Math.PI, circleC.getArea(), .001);
		Assert.assertEquals(1*1* Math.PI, circleA.getArea(), .001);

		Assert.assertTrue(circleD.overlaps(circleC));
		Assert.assertFalse(circleD.overlaps(circleA));
	}
	@Test
	public void testB() {
		Circle2D circle = new Circle2D();
		Assert.assertEquals(0, circle.getX(), 0);
		Assert.assertEquals(0, circle.getY(), 0);
		Assert.assertEquals(1, circle.getRadius(), 0);
	}
	

}
