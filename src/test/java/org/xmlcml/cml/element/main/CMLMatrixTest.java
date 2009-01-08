package org.xmlcml.cml.element.main;

import static org.xmlcml.cml.base.CMLConstants.SIUNIT_NS;
import static org.xmlcml.cml.base.CMLConstants.UNIT_NS;
import static org.xmlcml.cml.base.CMLConstants.U_CELSIUS;
import static org.xmlcml.cml.base.CMLConstants.U_DEGREE;
import static org.xmlcml.cml.base.CMLConstants.U_KCAL;
import static org.xmlcml.cml.base.CMLConstants.XSD_DOUBLE;
import static org.xmlcml.cml.base.CMLConstants.XSD_INTEGER;
import static org.xmlcml.cml.base.TstBase.parseValidString;
import static org.xmlcml.euclid.EC.EPS;
import static org.xmlcml.euclid.EC.S_RBRAK;
import static org.xmlcml.euclid.test.EuclidTestBase.neverThrow;

import java.util.ArrayList;
import java.util.List;

import nu.xom.Elements;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.xmlcml.cml.base.CMLConstants;
import org.xmlcml.cml.element.CMLCml;
import org.xmlcml.cml.element.CMLMatrix;
import org.xmlcml.euclid.EuclidRuntimeException;
import org.xmlcml.euclid.IntMatrix;
import org.xmlcml.euclid.RealMatrix;
import org.xmlcml.euclid.test.DoubleTestBase;
import org.xmlcml.euclid.test.IntMatrixTest;
import org.xmlcml.euclid.test.IntTest;
import org.xmlcml.euclid.test.RealMatrixTest;

/**
 * test matrix.
 * 
 * @author pmr
 * 
 */
public class CMLMatrixTest {

	String unitsS = "<c:cml " + "id='a234234' " + "xmlns:c='" + CMLConstants.CML_NS + "' "
			+ "xmlns:siUnits='" + SIUNIT_NS + "' " + "xmlns:units='" + UNIT_NS
			+ "' " + ">" + "<c:matrix id='s1' dictRef='cmlDict:angle' units='"
			+ U_DEGREE + "' " + "  dataType='xsd:double' rows='2' columns='2'>"
			+ "    180 90 " + "    45 0</c:matrix>"
			+ "<c:matrix id='s2' dictRef='foo:bar' units='" + U_KCAL + "' "
			+ "  dataType='xsd:double' rows='2' columns='2'>" + "    100 50 "
			+ "    0 -25</c:matrix>"
			+ "<c:matrix id='s3' dictRef='foo:mpt' units='" + U_CELSIUS + "' "
			+ "  dataType='xsd:double' rows='2' columns='2'>" + "    100 50"
			+ "     0 -50</c:matrix>" + "</c:cml>";

	CMLCml cml = null;

	List<CMLMatrix> matrixList = new ArrayList<CMLMatrix>();

	/**
	 * setup.
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {

		if (cml == null) {
			cml = (CMLCml) parseValidString(unitsS);
			Elements matrixElements = cml.getChildCMLElements(CMLMatrix.TAG);
			Assert.assertEquals("matrix element count", 3, matrixElements
					.size());
			for (int i = 0; i < matrixElements.size(); i++) {
				matrixList.add((CMLMatrix) matrixElements.get(i));
			}
		}
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
	public static void assertEquals(String msg, CMLMatrix test,
			CMLMatrix expected, double epsilon) {
		Assert.assertNotNull("test should not be null (" + msg + S_RBRAK, test);
		Assert.assertNotNull("expected should not be null (" + msg + S_RBRAK,
				expected);
		if (test.getEuclidRealMatrix() != null) {
			RealMatrixTest.assertEquals(msg, test.getEuclidRealMatrix(),
					expected.getEuclidRealMatrix(), epsilon);
		} else if (test.getEuclidIntMatrix() != null) {
			IntMatrixTest.assertEquals(msg, test.getEuclidIntMatrix(), expected
					.getEuclidIntMatrix());
		} else {
			Assert.fail("both matrices must be either real or int" + test);
		}
	}

	/**
	 * equality test. true if both args not null and equal within epsilon
	 * 
	 * @param msg
	 *            message
	 * @param rows
	 * @param cols
	 * @param test
	 * @param expected
	 * @param epsilon
	 */
	public static void assertEquals(String msg, int rows, int cols,
			double[] test, CMLMatrix expected, double epsilon) {
		Assert.assertNotNull("test should not be null (" + msg + S_RBRAK, test);
		Assert.assertNotNull("expected should not be null (" + msg + S_RBRAK,
				expected);
		Assert.assertEquals("rows ", rows, expected.getRows());
		Assert.assertEquals("columns ", cols, expected.getColumns());
		RealMatrixTest.assertEquals(msg, rows, cols, test, expected
				.getEuclidRealMatrix(), epsilon);
	}

	/**
	 * equality test. true if both args not null and equal
	 * 
	 * @param msg
	 *            message
	 * @param rows
	 * @param cols
	 * @param test
	 * @param expected
	 */
	public static void assertEquals(String msg, int rows, int cols, int[] test,
			CMLMatrix expected) {
		Assert.assertNotNull("test should not be null (" + msg + S_RBRAK, test);
		Assert.assertNotNull("expected should not be null (" + msg + S_RBRAK,
				expected);
		Assert.assertEquals("rows ", rows, expected.getRows());
		Assert.assertEquals("columns ", cols, expected.getColumns());
		IntMatrixTest.assertEquals(msg, rows, cols, test, expected
				.getEuclidIntMatrix());
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLMatrix.getDataType()'
	 */
	@Test
	public void testGetDataType() {
		Assert.assertEquals("get data type", XSD_DOUBLE, matrixList.get(0)
				.getDataType());
		Assert.assertEquals("get data type", XSD_DOUBLE, matrixList.get(1)
				.getDataType());
		Assert.assertEquals("get data type", XSD_DOUBLE, matrixList.get(2)
				.getDataType());
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLMatrix.getRows()'
	 */
	@Test
	public void testGetRows() {
		Assert.assertEquals("get rows", 2, matrixList.get(0).getRows());
		Assert.assertEquals("get rows", 2, matrixList.get(1).getRows());
		Assert.assertEquals("get rows", 2, matrixList.get(2).getRows());
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLMatrix.getColumns()'
	 */
	@Test
	public void testGetColumns() {
		Assert.assertEquals("get columns", 2, matrixList.get(0).getColumns());
		Assert.assertEquals("get columns", 2, matrixList.get(1).getColumns());
		Assert.assertEquals("get columns", 2, matrixList.get(2).getColumns());
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLMatrix.CMLMatrix()'
	 */
	@Test
	public void testCMLMatrix() {

	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLMatrix.CMLMatrix(CMLMatrix)'
	 */
	@Test
	public void testCMLMatrixCMLMatrix() {

	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLMatrix.CMLMatrix(double[][])'
	 */
	@Test
	public void testCMLMatrixDoubleArrayArray() {
		double[][] mat = new double[][] { new double[] { 11., 12., 13. },
				new double[] { 21., 22., 23. }, new double[] { 31., 32., 33. },
				new double[] { 41., 42., 43. }, };
		CMLMatrix testMat = null;
		try {
			testMat = new CMLMatrix(mat);
		} catch (Exception e) {
			neverThrow(e);
		}
		Assert.assertEquals("double[][] constructor", 4, testMat.getRows());
		Assert.assertEquals("double[][] constructor", 3, testMat.getColumns());
		// Assert.assertEquals("double[][] constructor", 23.,
		// testMat.getElement(2, 3), EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLMatrix.CMLMatrix(int[][])'
	 */
	@Test
	public void testCMLMatrixIntArrayArray() {
		int[][] mat = new int[][] { new int[] { 11, 12, 13 },
				new int[] { 21, 22, 23 }, new int[] { 31, 32, 33 },
				new int[] { 41, 42, 43 }, };
		CMLMatrix testMat = null;
		try {
			testMat = new CMLMatrix(mat);
		} catch (Exception e) {
			neverThrow(e);
		}
		Assert.assertEquals("int[][] constructor", 4, testMat.getRows());
		Assert.assertEquals("int[][] constructor", 3, testMat.getColumns());
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLMatrix.CMLMatrix(int, int,
	 * double[])'
	 */
	@Test
	public void testCMLMatrixIntIntDoubleArray() {
		double[] mat = new double[] { 11., 12., 13., 21., 22., 23., 31., 32.,
				33., 41., 42., 43., };
		CMLMatrix testMat = null;
		try {
			testMat = new CMLMatrix(4, 3, mat);
		} catch (Exception e) {
			neverThrow(e);
		}
		Assert.assertEquals("double[][] constructor", 4, testMat.getRows());
		Assert.assertEquals("double[][] constructor", 3, testMat.getColumns());
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLMatrix.CMLMatrix(int, int,
	 * int[])'
	 */
	@Test
	public void testCMLMatrixIntIntIntArray() {
		int[] mat = new int[] { 11, 12, 13, 21, 22, 23, 31, 32, 33, 41, 42, 43, };
		CMLMatrix testMat = null;
		try {
			testMat = new CMLMatrix(4, 3, mat);
		} catch (Exception e) {
			neverThrow(e);
		}
		Assert.assertEquals("int[][] constructor", 4, testMat.getRows());
		Assert.assertEquals("int[][] constructor", 3, testMat.getColumns());
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLMatrix.getEuclidRealMatrix()'
	 */
	@Test
	public void testGetEuclidRealMatrix() {
		RealMatrix euclMatrix = matrixList.get(0).getEuclidRealMatrix();
		Assert.assertNotNull("eucl realMatrix", euclMatrix);
		Assert.assertEquals("euclidMatrix", 2, euclMatrix.getRows());
		Assert.assertEquals("euclidMatrix", 2, euclMatrix.getCols());
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLMatrix.getEuclidIntMatrix()'
	 */
	@Test
	public void testGetEuclidIntMatrix() {
		try {
			matrixList.get(0).getEuclidIntMatrix();
			Assert.fail("int matrix should throw EuclidRuntimeException");
		} catch (EuclidRuntimeException e) {
		}
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLMatrix.setMatrix(double[][])'
	 */
	@Test
	public void testSetMatrixDoubleArrayArray() {
		CMLMatrix mat = matrixList.get(0);
		DoubleTestBase.assertEquals("set matrix double[][]", new double[] {
				180., 90., 45, 0. }, mat.getDoubleArray(), EPS);
		Assert.assertEquals("set mat", XSD_DOUBLE, mat.getDataType());
		try {
			mat.setMatrix(new double[][] { new double[] { 11., 12., 13. },
					new double[] { 21., 22., 23. },
					new double[] { 31., 32., 33. },
					new double[] { 41., 42., 43. } });
		} catch (Exception e) {
			neverThrow(e);
		}
		Assert.assertEquals("set mat", XSD_DOUBLE, mat.getDataType());
		Assert.assertEquals("set mat", 4, mat.getRows());
		Assert.assertEquals("set mat", 3, mat.getColumns());
		DoubleTestBase.assertEquals("set matrix double[][]", new double[] {
				11., 12., 13., 21., 22., 23., 31., 32., 33., 41., 42., 43. },
				mat.getDoubleArray(), EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLMatrix.setMatrix(int[][])'
	 */
	@Test
	public void testSetMatrixIntArrayArray() {
		CMLMatrix mat = matrixList.get(0);
		// deliberately set doubles and change later
		DoubleTestBase.assertEquals("set matrix int[][]", new double[] { 180.,
				90., 45, 0. }, mat.getDoubleArray(), EPS);
		Assert.assertEquals("set mat", XSD_DOUBLE, mat.getDataType());
		try {
			mat.setMatrix(new int[][] { new int[] { 11, 12, 13 },
					new int[] { 21, 22, 23 }, new int[] { 31, 32, 33 },
					new int[] { 41, 42, 43 } });
		} catch (Exception e) {
			neverThrow(e);
		}
		Assert.assertEquals("set mat", 4, mat.getRows());
		Assert.assertEquals("set mat", 3, mat.getColumns());
		IntTest.assertEquals("set matrix int[][]", new int[] { 11, 12, 13, 21,
				22, 23, 31, 32, 33, 41, 42, 43 }, mat.getIntegerArray());
		Assert.assertEquals("set mat", XSD_INTEGER, mat.getDataType());
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLMatrix.setArray(int, int,
	 * double[])'
	 */
	@Test
	public void testSetArrayIntIntDoubleArray() {
		CMLMatrix mat = matrixList.get(0);
		DoubleTestBase.assertEquals("set matrix double[][]", new double[] {
				180., 90., 45, 0. }, mat.getDoubleArray(), EPS);
		Assert.assertEquals("set mat", XSD_DOUBLE, mat.getDataType());
		try {
			mat.setArray(4, 3, new double[] { 11., 12., 13., 21., 22., 23.,
					31., 32., 33., 41., 42., 43. });
		} catch (Exception e) {
			neverThrow(e);
		}
		Assert.assertEquals("set mat", XSD_DOUBLE, mat.getDataType());
		Assert.assertEquals("set mat", 4, mat.getRows());
		Assert.assertEquals("set mat", 3, mat.getColumns());
		DoubleTestBase.assertEquals("set matrix double[][]", new double[] {
				11., 12., 13., 21., 22., 23., 31., 32., 33., 41., 42., 43. },
				mat.getDoubleArray(), EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLMatrix.setArray(int, int,
	 * int[])'
	 */
	@Test
	public void testSetArrayIntIntIntArray() {
		CMLMatrix mat = matrixList.get(0);
		DoubleTestBase.assertEquals("set matrix int, int, []", new double[] {
				180., 90., 45, 0. }, mat.getDoubleArray(), EPS);
		Assert.assertEquals("set mat", XSD_DOUBLE, mat.getDataType());
		try {
			mat.setArray(4, 3, new int[] { 11, 12, 13, 21, 22, 23, 31, 32, 33,
					41, 42, 43 });
		} catch (Exception e) {
			neverThrow(e);
		}
		Assert.assertEquals("set mat", XSD_INTEGER, mat.getDataType());
		Assert.assertEquals("set mat", 4, mat.getRows());
		Assert.assertEquals("set mat", 3, mat.getColumns());
		IntTest.assertEquals("set matrix int, int []", new int[] { 11, 12, 13,
				21, 22, 23, 31, 32, 33, 41, 42, 43 }, mat.getIntegerArray());
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLMatrix.getDoubleArray()'
	 */
	@Test
	public void testGetDoubleArray() {
		CMLMatrix mat = matrixList.get(0);
		DoubleTestBase.assertEquals("get array []", new double[] { 180., 90.,
				45, 0. }, mat.getDoubleArray(), EPS);
		Assert.assertEquals("get array", XSD_DOUBLE, mat.getDataType());
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLMatrix.getDoubleMatrix()'
	 */
	@Test
	public void testGetDoubleMatrix() {
		CMLMatrix mat = matrixList.get(0);
		double[][] doubleMatrix = mat.getDoubleMatrix();
		Assert.assertEquals("get matrix double[][]", 2, doubleMatrix.length);
		DoubleTestBase.assertEquals("get matrix double[][]", new double[] {
				180., 90. }, doubleMatrix[0], EPS);
		DoubleTestBase.assertEquals("get matrix double[][]", new double[] {
				45., 0. }, doubleMatrix[1], EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLMatrix.isSquare()'
	 */
	@Test
	public void testIsSquare() {
		CMLMatrix mat = matrixList.get(0);
		Assert.assertTrue("square", mat.isSquare());
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLMatrix.isEqualTo(CMLMatrix,
	 * double)'
	 */
	@Test
	public void testIsEqualTo() {
		CMLMatrix mat = matrixList.get(0);
		Assert.assertTrue("equals", mat.isEqualTo(mat, EPS));
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLMatrix.multiply(CMLMatrix)'
	 */
	@Test
	public void testMultiply() {
		CMLMatrix mat = matrixList.get(0);
		CMLMatrix mat1 = null;
		try {
			mat1 = mat.multiply(mat);
		} catch (Exception e) {
			neverThrow(e);
		}
		CMLMatrixTest.assertEquals("multiply", 2, 2, new double[] { 36450.,
				16200., 8100., 4050. }, mat1, EPS);
	}

	// /**
	// * Test method for
	// 'org.xmlcml.cml.element.CMLMatrix.getUnit(NamespaceToUnitListMap)'
	// */
	// @Test
	// public void testGetUnit() {
	// CMLMatrix mat = matrixList.get(0);
	// CMLUnit unit = mat.getUnit(unitsUnitListMap);
	// Assert.assertNotNull("unit", unit);
	// Assert.assertEquals("unit", "deg", unit.getId());
	// }

	// /**
	// * Test method for 'org.xmlcml.cml.element.CMLMatrix.setUnits(String,
	// * String)'
	// */
	// @Test
	// public void testSetUnitsStringString() {
	// CMLMatrix mat = matrixList.get(0);
	// CMLUnit unit = mat.getUnit(unitsUnitListMap);
	// Assert.assertNotNull("unit", unit);
	// Assert.assertEquals("unit", "deg", unit.getId());
	// mat.setUnits("siUnits", "kg", SIUNIT_NS);
	// unit = mat.getUnit(unitsUnitListMap);
	// Assert.assertNotNull("unit", unit);
	// Assert.assertEquals("unit", "kg", unit.getId());
	// }

	// /**
	// * test units.
	// *
	// */
	// @Test
	// public void testGetUnits() {
	// CMLCml cml = (CMLCml) parseValidString(unitsS);
	// 
	// // matrixs
	// List<CMLElement> matrixs = cml.getElements(".//"+CMLMatrix.NS);
	// Assert.assertEquals("matrix count", 3, matrixs.size());
	// CMLMatrix matrix = (CMLMatrix) matrixs.get(0);
	// UnitsAttribute unitsAttribute = (UnitsAttribute) matrix
	// .getUnitsAttribute();
	// Assert.assertNotNull("units attribute not null", unitsAttribute);
	// CMLUnit unit = unitsUnitListMap.getUnit(unitsAttribute);
	// Assert.assertNotNull("unit not null", unit);
	// Assert.assertEquals("unit ", "deg", unit.getId());
	// }

	// /**
	// * test conversion to SI.
	// *
	// */
	// @Test
	// public void testConvertToSI() {
	// CMLCml cml = (CMLCml) parseValidString(unitsS);
	//
	// // matrixs
	// List<CMLElement> matrixs = cml.getElements(".//"+CMLMatrix.NS);
	// Assert.assertEquals("matrix count", 3, matrixs.size());
	// testMatrix((CMLMatrix) matrixs.get(0),
	// new double[] { 180., 90, 45., 0. },
	// CMLConstants.CML_UNITS + S_COLON + "deg", new double[] { 3.1415922,
	// 1.5707961, 0.78539805, 0 }, CMLConstants.CML_SIUNITS + S_COLON
	// + "radian");
	//
	// testMatrix((CMLMatrix) matrixs.get(1), new double[] { 100., 50, 0.,
	// -25. }, CMLConstants.CML_UNITS + S_COLON + "kcal", new double[] { 418400.,
	// 209200., 0., -104600. }, CMLConstants.CML_SIUNITS + S_COLON + "joule");
	//
	// testMatrix((CMLMatrix) matrixs.get(2), new double[] { 100., 50, 0.,
	// -50. }, CMLConstants.CML_UNITS + S_COLON + "celsius", new double[] { 373.15,
	// 323.15, 273.15, 223.15 }, CMLConstants.CML_SIUNITS + S_COLON + "k");
	// }

	// private void testMatrix(CMLMatrix matrix, double[] expected0,
	// String units0, double[] expected1, String units1) {
	// DoubleTestBase.assertEquals("matrix", expected0, matrix.getDoubleArray(),
	// EPS);
	// Assert.assertEquals("matrix", units0, matrix.getUnits());
	// matrix.convertToSI(unitsUnitListMap);
	// DoubleTestBase.assertEquals("matrix", expected1, matrix.getDoubleArray(),
	// EPS * 10);
	// Assert.assertEquals("matrix", units1, matrix.getUnits());
	// }

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLMatrix.copy()'
	 */
	@Test
	public void testCopy() {
		CMLMatrix m = (CMLMatrix) matrixList.get(0).copy();
		CMLMatrixTest.assertEquals("copy", m, matrixList.get(0), EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLMatrix.getIntegerArray()'
	 */
	@Test
	public void testGetIntegerArray() {
		int[] ii = new int[] { 11, 12, 13, 21, 22, 23 };
		CMLMatrix m = new CMLMatrix(2, 3, ii);
		IntTest.assertEquals("int[]", ii, m.getIntegerArray());
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLMatrix.getIntegerMatrix()'
	 */
	@Test
	public void testGetIntegerMatrix() {
		CMLMatrix mat = new CMLMatrix(2, 3, new double[] { 1.1, 2.2, 3.3, 11.1,
				12.2, 13.3 });
		CMLMatrixTest.assertEquals("real mat", 2, 3, new double[] { 1.1, 2.2,
				3.3, 11.1, 12.2, 13.3 }, mat, EPS);
		int[][] ii = mat.getIntegerMatrix();
		Assert.assertNull("real is null", ii);

		mat = new CMLMatrix(2, 3, new int[] { 1, 2, 3, 11, 12, 13 });
		CMLMatrixTest.assertEquals("int mat", 2, 3, new int[] { 1, 2, 3, 11,
				12, 13 }, mat);
		ii = mat.getIntegerMatrix();

		IntMatrix imat = new IntMatrix(ii);
		IntMatrixTest.assertEquals("int mat", 2, 3, new int[] { 1, 2, 3, 11,
				12, 13 }, imat);
	}

}
