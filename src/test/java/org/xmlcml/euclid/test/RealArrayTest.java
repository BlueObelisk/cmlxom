package org.xmlcml.euclid.test;

import static org.xmlcml.euclid.EuclidConstants.EPS;
import static org.xmlcml.euclid.EuclidConstants.S_RBRAK;
import static org.xmlcml.euclid.test.EuclidTestBase.alwaysFail;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.xmlcml.euclid.EuclidRuntimeException;
import org.xmlcml.euclid.IntArray;
import org.xmlcml.euclid.IntSet;
import org.xmlcml.euclid.RealArray;
import org.xmlcml.euclid.RealRange;
import org.xmlcml.euclid.ArrayBase.Trim;
import org.xmlcml.euclid.RealArray.Filter;

/**
 * test RealArray.
 * 
 * @author pmr
 * 
 */
public class RealArrayTest {

	RealArray a0;

	RealArray a1;

	/**
	 * main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
	}

	/**
	 * setup.
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		a0 = new RealArray();
		a1 = new RealArray(new double[] { 1.0, 2.0, 4.0, 6.0 });
	}

	/**
	 * equality test. true if both args not null and equal within epsilon
	 * 
	 * @param msg
	 *            message
	 * @param test
	 * @param expected
	 * @param epsilon
	 */
	public static void assertEquals(String msg, RealArray test,
			RealArray expected, double epsilon) {
		Assert.assertNotNull("test should not be null (" + msg + S_RBRAK, test);
		Assert.assertNotNull("expected should not be null (" + msg + S_RBRAK,
				expected);
		DoubleTestBase.assertEquals(msg, test.getArray(), expected.getArray(),
				epsilon);
	}

	/**
	 * equality test. true if both args not null and equal within epsilon
	 * 
	 * @param msg
	 *            message
	 * @param test
	 *            array must be of length 3
	 * @param expected
	 * @param epsilon
	 */
	public static void assertEquals(String msg, double[] test,
			RealArray expected, double epsilon) {
		Assert.assertNotNull("test should not be null (" + msg + S_RBRAK, test);
		Assert.assertNotNull("expected should not be null (" + msg + S_RBRAK,
				expected);
		Assert.assertEquals("must be of equal length ", test.length, expected
				.getArray().length);
		DoubleTestBase.assertEquals(msg, test, expected.getArray(), epsilon);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealArray.RealArray()'
	 */
	@Test
	public void testRealArray() {
		Assert.assertEquals("empty", 0, a0.size());
		Assert.assertEquals("empty", "()", a0.toString());
	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealArray.RealArray(int)'
	 */
	@Test
	public void testRealArrayInt() {
		RealArray r = new RealArray(4);
		Assert.assertEquals("r", 4, r.size());
		RealArrayTest.assertEquals("r", new double[] { 0.0, 0.0, 0.0, 0.0 }, r,
				EPS);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealArray.RealArray(int, double,
	 * double)'
	 */
	@Test
	public void testRealArrayIntDoubleDouble() {
		RealArray r = new RealArray(4, 1.0, 2.0);
		Assert.assertEquals("r", 4, r.size());
		RealArrayTest.assertEquals("r", new double[] { 1.0, 3.0, 5.0, 7.0 }, r,
				EPS);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealArray.RealArray(int, double)'
	 */
	@Test
	public void testRealArrayIntDouble() {
		RealArray r = new RealArray(4, 2.0);
		Assert.assertEquals("r", 4, r.size());
		RealArrayTest.assertEquals("r", new double[] { 2.0, 2.0, 2.0, 2.0 }, r,
				EPS);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealArray.RealArray(int, double[])'
	 */
	@Test
	public void testRealArrayIntDoubleArray() {
		double[] d = { 1.0, 2.0, 3.0, 4.0 };
		RealArray r = new RealArray(3, d);
		Assert.assertEquals("r", 3, r.size());
		RealArrayTest.assertEquals("r", new double[] { 1.0, 2.0, 3.0 }, r, EPS);
		try {
			r = new RealArray(5, d);
			alwaysFail("Array size too small");
		} catch (EuclidRuntimeException e) {
			Assert.assertEquals("double[]", "Array size too small", e
					.getMessage());
		}
	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealArray.RealArray(double[])'
	 */
	@Test
	public void testRealArrayDoubleArray() {
		double[] d = { 1.0, 2.0, 3.0, 4.0 };
		RealArray r = new RealArray(d);
		Assert.assertEquals("r", 4, r.size());
		RealArrayTest.assertEquals("r", new double[] { 1.0, 2.0, 3.0, 4.0 }, r,
				EPS);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealArray.RealArray(IntArray)'
	 */
	@Test
	public void testRealArrayIntArray() {
		IntArray i = new IntArray(new int[] { 1, 2, 3, 4 });
		RealArray r = new RealArray(i);
		Assert.assertEquals("r", 4, r.size());
		RealArrayTest.assertEquals("r", new double[] { 1.0, 2.0, 3.0, 4.0 }, r,
				EPS);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealArray.RealArray(RealArray, int,
	 * int)'
	 */
	@Test
	public void testRealArrayRealArrayIntInt() {
		RealArray r = new RealArray(a1, 1, 2);
		Assert.assertEquals("r", 2, r.size());
		RealArrayTest.assertEquals("r", new double[] { 2.0, 4.0 }, r, EPS);
		try {
			r = new RealArray(a1, 0, 5);
		} catch (EuclidRuntimeException e) {
			Assert.assertEquals("real array", "index out of range 0/5", e
					.getMessage());
		}
	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealArray.RealArray(RealArray,
	 * IntArray)'
	 */
	@Test
	public void testRealArrayRealArrayIntArray() {
		RealArray r = new RealArray(a1, new IntArray(new int[] { 3, 1, 2 }));
		Assert.assertEquals("r", 3, r.size());
		RealArrayTest.assertEquals("r", new double[] { 6.0, 2.0, 4.0 }, r, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealArray.RealArray(RealArray)'
	 */
	@Test
	public void testRealArrayRealArray() {
		RealArray r = new RealArray(a1);
		Assert.assertEquals("r", 4, r.size());
		RealArrayTest.assertEquals("r", new double[] { 1.0, 2.0, 4.0, 6.0 }, r,
				EPS);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealArray.RealArray(int, String,
	 * double)'
	 */
	@Test
	public void testRealArrayIntStringDouble() {
		RealArray r = new RealArray(3, "TRIANGLE", 2.0);
		Assert.assertEquals("r", 5, r.size());
		RealArrayTest.assertEquals("r", new double[] { 2. / 3., 4. / 3., 2.,
				4. / 3., 2. / 3. }, r, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealArray.RealArray(String[])'
	 */
	@Test
	public void testRealArrayStringArray() {
		RealArray r = new RealArray(new String[] { "1.0", "2.0", "4.0", "6.0" });
		RealArrayTest.assertEquals("string array", a1, r, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealArray.RealArray(String)'
	 */
	@Test
	public void testRealArrayString() {
		RealArray r = new RealArray("1.0 2.0 4.0 6.0");
		RealArrayTest.assertEquals("string array", a1, r, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealArray.getFilter(int, String)'
	 */
	@Test
	public void testGetFilter() {
		RealArray filter = RealArray.getFilter(3, Filter.GAUSSIAN);
		double[] f = new double[] { 0.00000780609891336, 0.00416059856172973,
				0.17996534087165197, 0.6317325089354098, 0.17996534087165197,
				0.00416059856172973, 0.00000780609891336 };
		RealArrayTest.assertEquals("filter", f, filter, 1.0E-16);
		filter = RealArray.getFilter(2, Filter.GAUSSIAN_FIRST_DERIVATIVE);
		f = new double[] { -8.307977825463781E-5, -0.19931487665039388, -0.0,
				0.19931487665039388, 8.307977825463781E-5 };
		RealArrayTest.assertEquals("filter", f, filter, 1.0E-16);
		filter = RealArray.getFilter(3, Filter.GAUSSIAN_SECOND_DERIVATIVE);
		f = new double[] { 5.338724215243003E-4, 0.119149066997191,
				0.8611247708322933, -2.0, 0.8611247708322933,
				0.119149066997191, 5.338724215243003E-4 };
		RealArrayTest.assertEquals("filter", f, filter, 1.0E-16);
	}

	/**
	 * test getSymmetricalArray()
	 */
	@Test
	public void testGetSymmetricalArray() {
		RealArray realArray = RealArray.getSymmetricalArray(10., 11, 1.0);
		Assert.assertEquals("range min", 9.0, realArray.getArray()[0], EPS);
		Assert.assertEquals("range min+1", 9.2, realArray.getArray()[1], EPS);
		Assert.assertEquals("range max", 11.0, realArray.getArray()[10], EPS);
		Assert.assertEquals("range mid", 10.0, realArray.getArray()[5], EPS);
	}

	/**
	 * test getNormalDistribution()
	 */
	@Test
	public void testGetNormalDistribution() {
		double mean = 10.;
		double halfrange = 5.0;
		int nsteps = 101;
		double sigma = 1.0;
		RealArray realArray = RealArray.getSymmetricalArray(mean, nsteps,
				halfrange);
		RealArray normalDist = realArray.getNormalDistribution(sigma);
		Assert.assertEquals("range min", 1.486e-06, normalDist.getArray()[0],
				1E-06);
		Assert.assertEquals("range mid", 0.398942, normalDist.getArray()[50],
				1E-06);
		Assert.assertEquals("range max", 1.486e-06, normalDist.getArray()[100],
				1E-06);
		RealArray cumulativeSum = normalDist.cumulativeSum();
		Assert.assertEquals("range min", 1.5e-06, cumulativeSum.getArray()[0],
				1E-06);
		Assert.assertEquals("range mid", 5.199469,
				cumulativeSum.getArray()[50], 1E-06);
		Assert.assertEquals("range max", 9.999996,
				cumulativeSum.getArray()[100], 1E-06);

		for (int i = 0; i < 100; i++) {
			/* double d = mean - halfrange + halfrange */Math.random();
			// System.out.println(d);
		}
	}

	/**
	 * test lineSearch.
	 */
	@Test
	public void testLineSearch() {
		RealArray x = new RealArray(11, 0., 1.0);
		RealArray cumulative = new RealArray(new double[] { 0., 4., 5., 20.,
				23., 26., 33., 40., 41., 44., 50. });
		double d = -1.;
		double probe = 22.;
		d = x.lineSearch(probe, cumulative);
		Assert.assertEquals("search ", 11. / 3., d, EPS);
		probe = 2.;
		d = x.lineSearch(probe, cumulative);
		Assert.assertEquals("search ", 0.5, d, EPS);
		probe = 1.;
		d = x.lineSearch(probe, cumulative);
		Assert.assertEquals("search ", 0.25, d, EPS);
		probe = 4.5;
		d = x.lineSearch(probe, cumulative);
		Assert.assertEquals("search ", 1.5, d, EPS);
		probe = 50;
		d = x.lineSearch(probe, cumulative);
		Assert.assertEquals("search ", 10., d, EPS);
		probe = 0;
		d = x.lineSearch(probe, cumulative);
		Assert.assertEquals("search ", 0., d, EPS);
	}

	/**
	 * test getRandomVariate.
	 * 
	 */
	@Test
	@SuppressWarnings("unused")
	public void testGetRandomVariate() {

		RealArray x = new RealArray(11, 20., 1.); // gives 20, 21 ...30
		RealArray freq = new RealArray(new double[] { 5., 10., 10., 1., 0., 2.,
				10., 15., 10., 3., 1. });
		RealArray cumulativeSum = new RealArray();
		for (int i = 0; i < 50; i++) {
			double random = x.getRandomVariate(freq, cumulativeSum);
			// System.out.println(cumulativeSum);
			// System.out.println(random);
		}
	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealArray.elementAt(int)'
	 */
	@Test
	public void testElementAt() {
		Assert.assertEquals("element at", 4.0, a1.elementAt(2));
		try {
			Assert.assertEquals("element at", 4.0, a1.elementAt(5));
			alwaysFail("ArrayIndexOutOfBoundsException");
		} catch (ArrayIndexOutOfBoundsException e) {
			Assert.assertEquals("ArrayIndexOutOfBoundsException", "5", e
					.getMessage());
		}
	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealArray.size()'
	 */
	@Test
	public void testSize() {
		Assert.assertEquals("size", 0, a0.size());
		Assert.assertEquals("size", 4, a1.size());
	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealArray'
	 */
	@Test
	public void testGetArray() {
		RealArrayTest.assertEquals("array", new double[] {}, a0, EPS);
		RealArrayTest.assertEquals("array", new double[] { 1., 2., 4., 6. },
				a1, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealArray.clearArray()'
	 */
	@Test
	public void testClearArray() {
		a1.clearArray();
		RealArrayTest.assertEquals("clear", new double[] { 0., 0., 0., 0. },
				a1, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealArray.getReverseArray()'
	 */
	@Test
	public void testGetReverseArray() {
		double[] d = a1.getReverseArray();
		DoubleTestBase.assertEquals("clear", new double[] { 6., 4., 2., 1. },
				d, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealArray.isEqualTo(RealArray)'
	 */
	@Test
	public void testIsEqualTo() {
		RealArray a = new RealArray("1 2 4 6");
		Assert.assertTrue("isEqualTo", a1.isEqualTo(a));
		a = new RealArray("1 2 4 6.1");
		Assert.assertFalse("isEqualTo", a1.isEqualTo(a));
		a = new RealArray("1 2 4");
		Assert.assertFalse("isEqualTo", a1.isEqualTo(a));
	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealArray.equals(RealArray, double)'
	 */
	@Test
	public void testEqualsRealArrayDouble() {
		RealArray a = new RealArray("1 2 4 6");
		Assert.assertTrue("isEqualTo", a1.equals(a, EPS));
		a = new RealArray("1 2 4 6.1");
		Assert.assertFalse("isEqualTo", a1.equals(a, EPS));
		a = new RealArray("1.00002 1.99999 4.0000007 6.0001");
		Assert.assertTrue("isEqualTo", a1.equals(a, .001));
		a = new RealArray("1 2 4");
		Assert.assertFalse("isEqualTo", a1.equals(a, EPS));
	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealArray.plus(RealArray)'
	 */
	@Test
	public void testPlus() {
		RealArray a2 = a1.plus(new RealArray("10 20 30 40"));
		RealArrayTest.assertEquals("plus", new double[] { 11.0, 22.0, 34.0,
				46.0 }, a2, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealArray.plusEquals(RealArray)'
	 */
	@Test
	public void testPlusEquals() {
		a1.plusEquals(new RealArray("10 20 30 40"));
		RealArrayTest.assertEquals("plus", new double[] { 11.0, 22.0, 34.0,
				46.0 }, a1, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealArray.subtract(RealArray)'
	 */
	@Test
	public void testSubtract() {
		RealArray a2 = a1.subtract(new RealArray("10 20 30 40"));
		RealArrayTest.assertEquals("subtract", new double[] { -9.0, -18.0,
				-26.0, -34.0 }, a2, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealArray.subtractEquals(RealArray)'
	 */
	@Test
	public void testSubtractEquals() {
		a1.subtractEquals(new RealArray("10 20 30 40"));
		RealArrayTest.assertEquals("subtract", new double[] { -9.0, -18.0,
				-26.0, -34.0 }, a1, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealArray.negative()'
	 */
	@Test
	public void testNegative() {
		a1.negative();
		RealArrayTest.assertEquals("negative", new double[] { -1, -2, -4, -6 },
				a1, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealArray.addScalar(double)'
	 */
	@Test
	public void testAddScalar() {
		RealArray a = a1.addScalar(3.3);
		RealArrayTest.assertEquals("addScalar", new double[] { 4.3, 5.3, 7.3,
				9.3 }, a, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealArray.multiplyBy(double)'
	 */
	@Test
	public void testMultiplyBy() {
		RealArray a = a1.multiplyBy(1.1);
		RealArrayTest.assertEquals("multiplyBy", new double[] { 1.1, 2.2, 4.4,
				6.6 }, a, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealArray.setElementAt(int, double)'
	 */
	@Test
	public void testSetElementAt() {
		a1.setElementAt(2, 10.);
		RealArrayTest.assertEquals("setElement",
				new double[] { 1., 2., 10., 6. }, a1, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealArray.getSubArray(int, int)'
	 */
	@Test
	public void testGetSubArray() {
		RealArray a = a1.getSubArray(2, 3);
		RealArrayTest.assertEquals("subArray", new double[] { 4., 6. }, a, EPS);
		a = a1.getSubArray(2, 2);
		RealArrayTest.assertEquals("subArray", new double[] { 4. }, a, EPS);
		a = a1.getSubArray(0, 3);
		RealArrayTest.assertEquals("subArray", new double[] { 1., 2., 4., 6. },
				a, EPS);
		try {
			a = a1.getSubArray(0, 5);
			alwaysFail("ArrayIndexOutOfBoundsException");
		} catch (ArrayIndexOutOfBoundsException e) {
			Assert.assertEquals("subArray ArrayIndexOutOfBoundsException",
					"java.lang.ArrayIndexOutOfBoundsException", "" + e);
		}
	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealArray.setElements(int, double[])'
	 */
	@Test
	public void testSetElements() {
		a1.setElements(1, new double[] { 10., 20. });
		RealArrayTest.assertEquals("setElement", new double[] { 1., 10., 20.,
				6. }, a1, EPS);
		try {
			a1.setElements(1, new double[] { 10., 20., 30., 40. });
			alwaysFail("ArrayIndexOutOfBoundsException");
		} catch (ArrayIndexOutOfBoundsException e) {
			Assert.assertEquals("subArray ArrayIndexOutOfBoundsException",
					"java.lang.ArrayIndexOutOfBoundsException: was 1 in 0-4",
					"" + e);
		}
	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealArray.isClear()'
	 */
	@Test
	public void testIsClear() {
		Assert.assertFalse("isClear", a1.isClear());
		a1.clearArray();
		Assert.assertTrue("isClear", a1.isClear());
	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealArray.setAllElements(double)'
	 */
	@Test
	public void testSetAllElements() {
		a1.setAllElements(10.);
		RealArrayTest.assertEquals("setElement", new double[] { 10., 10., 10.,
				10. }, a1, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealArray.sumAllElements()'
	 */
	@Test
	public void testSumAllElements() {
		Assert.assertEquals("sum", 13., a1.sumAllElements(), EPS);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealArray.absSumAllElements()'
	 */
	@Test
	public void testAbsSumAllElements() {
		RealArray a = new RealArray("-1 3 -11 14");
		Assert.assertEquals("sum", 5., a.sumAllElements(), EPS);
		Assert.assertEquals("absSum", 29., a.absSumAllElements(), EPS);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealArray.innerProduct()'
	 */
	@Test
	public void testInnerProduct() {
		Assert.assertEquals("inner", 57., a1.innerProduct(), EPS);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealArray.dotProduct(RealArray)'
	 */
	@Test
	public void testDotProduct() {
		RealArray a = new RealArray("1 2 3 4");
		double d = a1.dotProduct(a);
		Assert.assertEquals("dot", 41., d, EPS);
		a = new RealArray("1 2 3");
		try {
			a1.dotProduct(a);
			alwaysFail("ArrayIndexOutOfBoundsException");
		} catch (EuclidRuntimeException e) {
			Assert.assertEquals("dot",
					"org.xmlcml.euclid.EuclidRuntimeException", "" + e);
		}
	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealArray.euclideanLength()'
	 */
	@Test
	public void testEuclideanLength() {
		double d = 0.0;
		d = a1.euclideanLength();
		Assert.assertEquals("dot", Math.sqrt(57.), d, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealArray.rms()'
	 */
	@Test
	public void testRms() {
		double d = a1.rms();
		Assert.assertEquals("rms", 3.7749172176, d, 1.0E-06);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealArray.unitVector()'
	 */
	@Test
	public void testUnitVector() {
		RealArray v = a1.unitVector();
		RealArrayTest.assertEquals("unit vector", new double[] {
				0.13245323570650439, 0.26490647141300877, 0.5298129428260175,
				0.7947194142390264 }, v, 1.0E-10);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealArray.cumulativeSum()'
	 */
	@Test
	public void testCumulativeSum() {
		RealArray a = a1.cumulativeSum();
		RealArrayTest.assertEquals("cumulative",
				new double[] { 1., 3., 7., 13. }, a, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealArray.applyFilter(RealArray)'
	 */
	@Test
	public void testApplyFilter() {
		RealArray gaussian = RealArray.getFilter(3, Filter.GAUSSIAN);
		RealArray raw = new RealArray(new double[] { 1., 2., 1., 2., 1., 5.,
				7., 9., 3., 2., 3., 1., 1. });
		RealArray filtered = raw.applyFilter(gaussian);
		double[] d = { 1.2205914829606295, 1.6385548625623205,
				1.3599647160591364, 1.6525823383375386, 1.9248605506188587,
				4.644183080224947, 6.958315953393569, 7.51440140346297,
				3.916469098605179, 2.384925497509336, 2.4518253377494292,
				1.3656309904274337, 1.010208785051181 };
		RealArrayTest.assertEquals("filtered", d, filtered, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealArray.trim(int, double)'
	 */
	@Test
	public void testTrim() {
		RealArray a = new RealArray("1.1 2.1 3 4 1.2 3.2 5 1 3");
		RealArray b = a.trim(Trim.ABOVE, 2.0);
		double[] d = { 1.1, 2.0, 2.0, 2.0, 1.2, 2.0, 2.0, 1.0, 2.0 };
		RealArrayTest.assertEquals("trim", d, b, EPS);
		b = a.trim(Trim.BELOW, 2.0);
		double[] dd = { 2.0, 2.1, 3.0, 4.0, 2.0, 3.2, 5.0, 2.0, 3.0 };
		RealArrayTest.assertEquals("trim", dd, b, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealArray.indexOfLargestElement()'
	 */
	@Test
	public void testIndexOfLargestElement() {
		Assert.assertEquals("largest", 3, a1.indexOfLargestElement());
	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealArray.indexOfSmallestElement()'
	 */
	@Test
	public void testIndexOfSmallestElement() {
		Assert.assertEquals("smallest", 0, a1.indexOfSmallestElement());
	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealArray.largestElement()'
	 */
	@Test
	public void testLargestElement() {
		Assert.assertEquals("largest", 6., a1.largestElement());
	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealArray.getMax()'
	 */
	@Test
	public void testGetMax() {
		Assert.assertEquals("max", 6., a1.getMax(), EPS);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealArray.smallestElement()'
	 */
	@Test
	public void testSmallestElement() {
		Assert.assertEquals("smallest", 1., a1.smallestElement());
	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealArray.getMin()'
	 */
	@Test
	public void testGetMin() {
		Assert.assertEquals("max", 1., a1.getMin(), EPS);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealArray.getRange()'
	 */
	@Test
	public void testGetRange() {
		RealRange range = a1.getRange();
		Assert.assertEquals("range", 1., range.getMin(), EPS);
		Assert.assertEquals("range", 6., range.getMax(), EPS);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealArray.deleteElement(int)'
	 */
	@Test
	public void testDeleteElement() {
		a1.deleteElement(2);
		RealArrayTest.assertEquals("delete", new double[] { 1., 2., 6. }, a1,
				EPS);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealArray.deleteElements(int, int)'
	 */
	@Test
	public void testDeleteElementsIntInt() {
		RealArray a = new RealArray(a1);
		a.deleteElements(1, 2);
		RealArrayTest.assertEquals("delete", new double[] { 1., 6. }, a, EPS);
		a = new RealArray(a1);
		a.deleteElements(0, 3);
		RealArrayTest.assertEquals("delete", new double[] {}, a, EPS);
		a = new RealArray(a1);
		a.deleteElements(2, 2);
		RealArrayTest.assertEquals("delete", new double[] { 1., 2., 6. }, a,
				EPS);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealArray.insertElementAt(int,
	 * double)'
	 */
	@Test
	public void testInsertElementAt() {
		RealArray a = new RealArray(a1);
		a.insertElementAt(1, 30.);
		RealArrayTest.assertEquals("insert",
				new double[] { 1., 30., 2., 4., 6. }, a, EPS);
		a.insertElementAt(0, 20.);
		RealArrayTest.assertEquals("insert", new double[] { 20., 1., 30., 2.,
				4., 6. }, a, EPS);
		a.insertElementAt(6, 10.);
		RealArrayTest.assertEquals("insert", new double[] { 20., 1., 30., 2.,
				4., 6., 10. }, a, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealArray.insertArray(int, RealArray)'
	 */
	@Test
	public void testInsertArray() {
		a1.insertArray(1, new RealArray("44 55"));
		RealArrayTest.assertEquals("insert", new double[] { 1., 44., 55., 2.,
				4., 6. }, a1, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealArray.addElement(double)'
	 */
	@Test
	public void testAddElement() {
		a1.addElement(30.);
		RealArrayTest.assertEquals("insert",
				new double[] { 1., 2., 4., 6., 30. }, a1, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealArray.addArray(RealArray)'
	 */
	@Test
	public void testAddArray() {
		a1.addArray(new RealArray("5 16 7"));
		RealArrayTest.assertEquals("insert", new double[] { 1., 2., 4., 6., 5.,
				16., 7. }, a1, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealArray.getReorderedArray(IntSet)'
	 */
	@Test
	public void testGetReorderedArray() {
		IntSet intSet = new IntSet(new int[] { 3, 1, 0, 2 });
		RealArray a = null;
		a = a1.getReorderedArray(intSet);
		RealArrayTest.assertEquals("insert", new double[] { 6., 2., 1., 4. },
				a, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealArray.inRange(RealRange)'
	 */
	@Test
	public void testInRange() {
		RealRange range = new RealRange(1.3, 5.);
		IntSet intSet = a1.inRange(range);
		IntArray intArray = intSet.getIntArray();
		IntArrayTest.assertEquals("inrange", new int[] { 1, 2 }, intArray);
		intSet = a1.inRange(new RealRange(-3., 7.));
		IntArrayTest.assertEquals("inrange", new int[] { 0, 1, 2, 3 }, intSet
				.getIntArray());
		intSet = a1.inRange(new RealRange(4.5, 4.6));
		IntArrayTest
				.assertEquals("inrange", new int[] {}, intSet.getIntArray());
	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealArray.outOfRange(RealRange)'
	 */
	@Test
	public void testOutOfRange() {
		RealRange range = new RealRange(1.3, 5.);
		IntSet intSet = a1.outOfRange(range);
		IntArray intArray = intSet.getIntArray();
		IntArrayTest.assertEquals("inrange", new int[] { 0, 3 }, intArray);
		intSet = a1.outOfRange(new RealRange(-3., 7.));
		IntArrayTest
				.assertEquals("inrange", new int[] {}, intSet.getIntArray());
		intSet = a1.outOfRange(new RealRange(4.5, 4.6));
		IntArrayTest.assertEquals("inrange", new int[] { 0, 1, 2, 3 }, intSet
				.getIntArray());
	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealArray.getStringValues()'
	 */
	@Test
	public void testGetStringValues() {
		String[] ss = a1.getStringValues();
		StringTestBase.assertEquals("string values", new String[] { "1.0",
				"2.0", "4.0", "6.0" }, ss);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealArray.sortAscending()'
	 */
	@Test
	public void testSortAscending() {
		RealArray ra = new RealArray("1 6 3 9 2 0");
		ra.sortAscending();
		RealArrayTest.assertEquals("sortAscending", new double[] { 0., 1., 2.,
				3., 6., 9. }, ra, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealArray.sortDescending()'
	 */
	@Test
	public void testSortDescending() {
		RealArray ra = new RealArray("1 6 3 9 2 0");
		ra.sortDescending();
		RealArrayTest.assertEquals("sortDescending", new double[] { 9., 6., 3.,
				2., 1., 0 }, ra, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealArray.reverse()'
	 */
	@Test
	public void testReverse() {
		RealArray ra = new RealArray("1 6 3 9 2 0");
		ra.reverse();
		RealArrayTest.assertEquals("reverse", new double[] { 0., 2., 9., 3.,
				6., 1. }, ra, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealArray.indexSortAscending()'
	 */
	@Test
	public void testIndexSortAscending() {
		RealArray ra = new RealArray("1 6 3 9 2 0");
		IntSet intSet = ra.indexSortAscending();
		IntArrayTest.assertEquals("sortAscending",
				new int[] { 5, 0, 4, 2, 1, 3 }, intSet.getIntArray());
	}

	/**
	 * Test method for 'org.xmlcml.euclid.RealArray.indexSortDescending()'
	 */
	@Test
	public void testIndexSortDescending() {
		RealArray ra = new RealArray("1 6 3 9 2 0");
		IntSet intSet = ra.indexSortDescending();
		IntArrayTest.assertEquals("sortDescending", new int[] { 3, 1, 2, 4, 0,
				5 }, intSet.getIntArray());
	}

}
