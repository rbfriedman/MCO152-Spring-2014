package friedman.force2D;


import org.junit.Assert;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import friedman.force2D.Force2D;

public class Force2DTest {
	private Force2D a;
	private Force2D b;
	private Force2D c;
	private double expectedAngle;
	private double expectedMagnitude;
	private double expectedX;
	private double expectedY;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testMethodsA() {
		a = new Force2D(3, 9);
		this.expectedMagnitude = 9.4868;
		Assert.assertEquals(expectedMagnitude, a.getMagnitude(), .005);
		this.expectedAngle = 71.565;
		Assert.assertEquals(expectedAngle, a.getAngle(), .005);
	}

	@Test
	public void testMethodsB() {
		a = new Force2D(184.85, 88.36);
		this.expectedMagnitude = 204.88;
		Assert.assertEquals(expectedMagnitude, a.getMagnitude(), .005);
		this.expectedAngle = 25.548;
		Assert.assertEquals(expectedAngle, a.getAngle(), .005);

	}

	@Test
	public void testMethodsC() {
		a = new Force2D(238, 78);
		this.expectedMagnitude = 250.46;
		Assert.assertEquals(expectedMagnitude, a.getMagnitude(), .005);
		this.expectedAngle = 18.146;
		Assert.assertEquals(expectedAngle, a.getAngle(), .005);

	}

	@Test
	public void testAddA() {
		a = new Force2D(238, 78);
		b = new Force2D(67, -55);
		c = new Force2D(-34, 200);
		Force2D d = a.add(b);

		this.expectedX = 305;
		this.expectedY = 23;
		this.expectedMagnitude = 305.87;
		Assert.assertEquals(this.expectedX, d.getX(),.00001);
		Assert.assertEquals(this.expectedY, d.getY(),.00001);
		Assert.assertEquals(expectedMagnitude, d.getMagnitude(), .005);
		this.expectedAngle = 4.3125;
		Assert.assertEquals(expectedAngle, d.getAngle(), .005);

		Force2D e = c.add(d);

	}

	@Test
	public void testAddB() {
		a = new Force2D(238, 78);
		b = new Force2D(67, -55);
		c = new Force2D(-34, 200);
		Force2D d = a.add(b);
		Force2D e = c.add(d);
		this.expectedX = 271;
		this.expectedY = 223;
		this.expectedMagnitude = 350.96;
		Assert.assertEquals(this.expectedX, e.getX(),.00001);
		Assert.assertEquals(this.expectedY, e.getY(),.00001);
		Assert.assertEquals(expectedMagnitude, e.getMagnitude(), .005);
		this.expectedAngle = 39.45;
		Assert.assertEquals(expectedAngle, e.getAngle(), .005);

	}
	
	@Test
	public void testZero(){
		a = new Force2D(33,0);
		this.expectedMagnitude = 33;
		Assert.assertEquals(expectedMagnitude, a.getMagnitude(), .005);
		this.expectedAngle = 0;
		Assert.assertEquals(expectedAngle, a.getAngle(), .005);
	}
}
