package org.xmlcml.euclid.test;

import static org.xmlcml.euclid.EuclidConstants.EPS;
import static org.xmlcml.euclid.EuclidConstants.S_EMPTY;
import static org.xmlcml.euclid.EuclidConstants.S_RBRAK;
import static org.xmlcml.euclid.test.EuclidTestBase.getAssertFormat;
import junit.framework.Assert;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.xmlcml.euclid.IntMatrix;
import org.xmlcml.euclid.Real;
import org.xmlcml.euclid.RealMatrix;

/**
 * test Matrix stuff.
 * 
 * @author pmr
 * 
 */
public class MatrixTest {

	static Logger logger = Logger.getLogger(MatrixTest.class.getName());

	/**
	 * setup.
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		logger.setLevel(Level.WARN);
	}

	/**
	 * Assert.asserts equality of RealMatrix.
	 * 
	 * checks for non-null, then equality of length, then individual elements
	 * 
	 * @param message
	 * @param a
	 *            expected array
	 * @param b
	 *            actual array
	 * @param eps
	 *            tolerance for agreement
	 */
	public static void assertEquals(String message, RealMatrix a, RealMatrix b,
			double eps) {
		if (a == null || b == null) {
			Assert.fail(getAssertFormat(message, "double[]", "null"));
		}
		int aRows = a.getRows();
		int bRows = b.getRows();
		int aCols = a.getCols();
		int bCols = b.getCols();
		if (aRows != bRows) {
			Assert.fail(getAssertFormat(message + "; unequal rows in matrices",
					S_EMPTY + aRows, S_EMPTY + bRows));
		}
		if (aCols != bCols) {
			Assert.fail(getAssertFormat(message + "; unequal cols in matrices",
					S_EMPTY + aCols, S_EMPTY + bCols));
		}
		double[][] aMat = a.getMatrix();
		double[][] bMat = b.getMatrix();
		for (int i = 0; i < aRows; i++) {
			for (int j = 0; j < aCols; j++) {
				if (!Real.isEqual(aMat[i][j], bMat[i][j], eps)) {
					Assert.fail(getAssertFormat(message + "; unequal element ("
							+ i + ", " + j + S_RBRAK, S_EMPTY + aMat[i][j],
							S_EMPTY + bMat[i][j]));
				}
			}
		}
	}

	/**
	 * Assert.asserts equality of RealMatrix.
	 * 
	 * checks for non-null, then equality of length, then individual elements
	 * 
	 * @param message
	 * @param a
	 *            expected array
	 * @param b
	 *            actual array
	 */
	public static void assertEquals(String message, IntMatrix a, IntMatrix b) {
		if (a == null || b == null) {
			Assert.fail(getAssertFormat(message, "IntMatrix", "null"));
		}
		int aRows = a.getRows();
		int bRows = b.getRows();
		int aCols = a.getCols();
		int bCols = b.getCols();
		if (aRows != bRows) {
			Assert.fail(getAssertFormat(message + "; unequal rows in matrices",
					S_EMPTY + aRows, S_EMPTY + bRows));
		}
		if (aCols != bCols) {
			Assert.fail(getAssertFormat(message + "; unequal cols in matrices",
					S_EMPTY + aCols, S_EMPTY + bCols));
		}
		String s = IntTest.testEquals(a.getMatrix(), b.getMatrix());
		if (s != null) {
			Assert.fail(message + "; " + s);
		}
	}

	/** test */
	@Test
	public void testRealMatrix() {
		RealMatrix a = new RealMatrix(2, 3, new double[] { 11.0, 12.0, 13.0,
				21.0, 22.0, 23.0 });
		RealMatrix b = new RealMatrix(2, 3, new double[] { 11.0, 12.0, 13.0,
				21.0, 28.0, 23.0 });
		MatrixTest.assertEquals("MatrixTest", a, a, EPS);
		Assert.assertNotNull(b);
	}

	/** test */
	@Test
	public void testIntMatrix() {
		IntMatrix a = new IntMatrix(2, 3, new int[] { 11, 12, 13, 21, 22, 23 });
		IntMatrix b = new IntMatrix(2, 3, new int[] { 11, 12, 13, 21, 28, 23 });
		Assert.assertNotNull(b);
		Assert.assertEquals("MatrixTest", a, a);
	}

}
