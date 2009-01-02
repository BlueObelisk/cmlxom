package org.xmlcml.euclid.test;

import static org.xmlcml.euclid.EuclidConstants.EPS;
import static org.xmlcml.euclid.EuclidConstants.S_COMMA;
import static org.xmlcml.euclid.EuclidConstants.S_LBRAK;
import static org.xmlcml.euclid.EuclidConstants.S_PIPE;
import static org.xmlcml.euclid.EuclidConstants.S_RBRAK;
import static org.xmlcml.euclid.EuclidConstants.S_SPACE;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.xmlcml.euclid.Real2;
import org.xmlcml.euclid.Real2Array;
import org.xmlcml.euclid.Real2Range;
import org.xmlcml.euclid.RealArray;
import org.xmlcml.euclid.RealRange;

/**
 * test Real2Array
 * 
 * @author pmr
 * 
 */
public class Real2ArrayTest {

	Real2Array ra0;

	Real2Array ra1;

	/**
	 * setup.
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		ra0 = new Real2Array();
		ra1 = new Real2Array(new RealArray(new double[] { 1, 2, 3, 4, 5, 6 }),
				new RealArray(new double[] { 11, 12, 13, 14, 15, 16 }));
	}

	/**
	 * Test method for 'org.xmlcml.euclid.Real2Array.Real2Array()'
	 */
	@Test
	public void testReal2Array() {
		Assert.assertEquals("empty", "()", ra0.toString());
	}

	/**
	 * Test method for 'org.xmlcml.euclid.Real2Array.getRange2()'
	 */
	@Test
	public void testGetRange2() {
		Real2Range real2Range = ra1.getRange2();
		Assert.assertTrue("range2", real2Range.isEqualTo(new Real2Range(
				new RealRange(1, 6), new RealRange(11, 16))));
	}

	/**
	 * Test method for 'org.xmlcml.euclid.Real2Array.Real2Array(RealArray,
	 * RealArray)'
	 */
	@Test
	public void testReal2ArrayRealArrayRealArray() {
		Assert.assertEquals("realArrays", S_LBRAK + "(1.0,11.0)" + "(2.0,12.0)"
				+ "(3.0,13.0)" + "(4.0,14.0)" + "(5.0,15.0)" + "(6.0,16.0)"
				+ S_RBRAK, ra1.toString());
	}

	/**
	 * Test method for 'org.xmlcml.euclid.Real2Array.getXArray()'
	 */
	@Test
	public void testGetXArray() {
		RealArray xarr = ra1.getXArray();
		Assert.assertTrue("getXArray", xarr.isEqualTo(new RealArray(
				new double[] { 1., 2., 3., 4., 5., 6. })));
	}

	/**
	 * Test method for 'org.xmlcml.euclid.Real2Array.getYArray()'
	 */
	@Test
	public void testGetYArray() {
		RealArray yarr = ra1.getYArray();
		Assert.assertTrue("getYArray", yarr.isEqualTo(new RealArray(
				new double[] { 11., 12., 13., 14., 15., 16. })));
	}

	/**
	 * Test method for 'org.xmlcml.euclid.Real2Array.size()'
	 */
	@Test
	public void testSize() {
		Assert.assertEquals("size", 6, ra1.size());
	}

	@Test
	public void testCreateFromPairs() {
		String s = "1,2 3,4 5,6 7,8";
		Real2Array real2Array = Real2Array.createFromPairs(s, S_COMMA+S_PIPE+S_SPACE);
		Assert.assertEquals("size", 4, real2Array.size());
		RealArray xarr = real2Array.getXArray();
		Assert.assertTrue("getXArray", xarr.isEqualTo(new RealArray(
				new double[] { 1., 3., 5., 7. })));
		RealArray yarr = real2Array.getYArray();
		Assert.assertTrue("getYArray", yarr.isEqualTo(new RealArray(
				new double[] { 2., 4., 6., 8. })));
	}

	/**
	 * Test method for 'org.xmlcml.euclid.Real2Array.elementAt(int)'
	 */
	@Test
	public void testElementAt() {
		Real2 real2 = ra1.elementAt(4);
		Assert.assertEquals("elementAt", 5., real2.getX(), EPS);
		Assert.assertEquals("elementAt", 15., real2.getY(), EPS);
	}

}
