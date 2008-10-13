package org.xmlcml.euclid.test;

import static org.xmlcml.euclid.EuclidConstants.EPS;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.xmlcml.euclid.IntRange;
import org.xmlcml.euclid.RealRange;

/**
 * tests RealRange.
 * 
 * @author pmr
 * 
 */
public class RealRangeTest {

	RealRange r0;

	RealRange r1;

	RealRange r2;

	/**
	 * tests equality of ranges.
	 * 
	 * @param msg
	 *            message
	 * @param ref
	 * @param r
	 * @param epsilon
	 */
	public static void assertEquals(String msg, RealRange ref, RealRange r,
			double epsilon) {
		Assert.assertEquals(msg + " min", r.getMin(), ref.getMin(), epsilon);
		Assert.assertEquals(msg + " max", r.getMax(), ref.getMax(), epsilon);
	}

	/**
	 * setup.
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		r0 = new RealRange();
		r1 = new RealRange(1.0, 1.0);
		r2 = new RealRange(1.0, 3.0);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealRange.RealRange()'
	 */
	@Test
	public void testRealRange() {
		Assert.assertEquals("empty", "NULL", r0.toString());
	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealRange.RealRange(double, double)'
	 */
	@Test
	public void testRealRangeRealReal() {
		Assert.assertEquals("i1", "(1.0,1.0)", r1.toString());
		Assert.assertEquals("i2", "(1.0,3.0)", r2.toString());

	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealRange.RealRange(RealRange)'
	 */
	@Test
	public void testRealRangeRealRange() {
		RealRange ii = new RealRange(r2);
		Assert.assertEquals("ii", "(1.0,3.0)", ii.toString());
	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealRange.isValid()'
	 */
	@Test
	public void testIsValid() {
		Assert.assertTrue("valid", r2.isValid());
		Assert.assertFalse("invalid", r0.isValid());
	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealRange.isEqualTo(RealRange)'
	 */
	@Test
	public void testIsEqualTo() {
		Assert.assertTrue("equal", r2.isEqualTo(r2));
		Assert.assertFalse("equal", r2.isEqualTo(r0));
		Assert.assertFalse("equal", r0.isEqualTo(r0));
	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealRange.plus(RealRange)'
	 */
	@Test
	public void testPlus() {
		RealRange ix = new RealRange(1.0, 4.0);
		RealRange iy = new RealRange(2.0, 3.0);
		RealRange ii = ix.plus(iy);
		Assert.assertEquals("ii", "(1.0,4.0)", ii.toString());
		iy = new RealRange(0, 2);
		ii = ix.plus(iy);
		Assert.assertEquals("ii", "(0.0,4.0)", ii.toString());
		iy = new RealRange(2.0, 6.0);
		ii = ix.plus(iy);
		Assert.assertEquals("ii", "(1.0,6.0)", ii.toString());
		iy = new RealRange();
		ii = ix.plus(iy);
		Assert.assertEquals("ii", "(1.0,4.0)", ii.toString());
	}

	/**
	 * Test method for
	 * 'org.xmlcml.euclid.RealRange.doubleersectionWith(RealRange)'
	 */
	@Test
	public void testIntsectionWith() {
		RealRange ix = new RealRange(1.0, 4.0);
		RealRange iy = new RealRange(2.0, 3.0);
		RealRange ii = ix.intersectionWith(iy);
		Assert.assertEquals("ii", "(2.0,3.0)", ii.toString());
		iy = new RealRange(0.0, 2.0);
		ii = ix.intersectionWith(iy);
		Assert.assertEquals("ii", "(1.0,2.0)", ii.toString());
		iy = new RealRange(2.0, 6.0);
		ii = ix.intersectionWith(iy);
		Assert.assertEquals("ii", "(2.0,4.0)", ii.toString());
		iy = new RealRange();
		ii = ix.intersectionWith(iy);
		Assert.assertNull("ii", ii);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealRange.getMin()'
	 */
	@Test
	public void testGetMin() {
		Assert.assertEquals("min", 1.0, r2.getMin());
	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealRange.getMax()'
	 */
	@Test
	public void testGetMax() {
		Assert.assertEquals("max", 3.0, r2.getMax(), EPS);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealRange.getRange()'
	 */
	@Test
	public void testGetRange() {
		Assert.assertEquals("range", 2.0, r2.getRange(), EPS);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealRange.includes(RealRange)'
	 */
	@Test
	public void testIncludesRealRange() {
		Assert.assertTrue("includes", r2.includes(new RealRange(2.0, 3.0)));
		Assert.assertFalse("includes", r2.includes(new RealRange(0.0, 3.0)));
	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealRange.includes(double)'
	 */
	@Test
	public void testIncludesReal() {
		Assert.assertTrue("includes", r2.includes(1.0));
		Assert.assertFalse("includes", r2.includes(0.0));
	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealRange.contains(double)'
	 */
	@Test
	public void testContains() {
		Assert.assertTrue("contains", r2.contains(1.0));
		Assert.assertFalse("contains", r2.contains(0.0));
	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealRange.add(double)'
	 */
	@Test
	public void testAdd() {
		r2.add(2);
		Assert.assertEquals("ii", "(1.0,3.0)", r2.toString());
		r2.add(0);
		Assert.assertEquals("ii", "(0.0,3.0)", r2.toString());
		r2.add(9);
		Assert.assertEquals("ii", "(0.0,9.0)", r2.toString());
	}

	/**
	 * test getting a random variate. tests limits only
	 */
	@Test
	public void testGetRandomVariate() {
		RealRange range = new RealRange(10, 20);
		double sum = 0.0;
		for (int i = 0; i < 100; i++) {
			double d = range.getRandomVariate();
			Assert.assertTrue("limit: ", d >= 10. && d <= 20.);
			sum += d;
		}
		// System.out.println(sum);
		// crude check
		Assert.assertTrue("distribution", sum > 1400 && sum < 1600);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealRange.RealRange(IntRange)'
	 */
	@Test
	public void testRealRangeIntRange() {
		RealRange r = new RealRange(new IntRange(1, 2));
		Assert.assertEquals("int", "(1.0,2.0)", r.toString());
	}

}
