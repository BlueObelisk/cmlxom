package org.xmlcml.cml.element.main;

import static org.xmlcml.cml.base.CMLConstants.SIUNIT_NS;
import static org.xmlcml.cml.base.CMLConstants.UNIT_NS;
import static org.xmlcml.cml.base.CMLConstants.U_CELSIUS;
import static org.xmlcml.cml.base.CMLConstants.U_DEGREE;
import static org.xmlcml.cml.base.CMLConstants.U_KCAL;
import static org.xmlcml.cml.base.CMLConstants.XSD_DOUBLE;
import static org.xmlcml.cml.base.CMLConstants.XSD_INTEGER;
import static org.xmlcml.euclid.EuclidConstants.EPS;
import static org.xmlcml.euclid.EuclidConstants.S_RBRAK;

import java.util.ArrayList;
import java.util.List;

import nu.xom.Elements;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.xmlcml.cml.base.CMLConstants;
import org.xmlcml.cml.base.CMLXOMTestUtils;
import org.xmlcml.cml.element.CMLCml;
import org.xmlcml.cml.element.CMLMatrix;
import org.xmlcml.cml.element.CMLScalar;
import org.xmlcml.euclid.EC;
import org.xmlcml.euclid.EuclidRuntimeException;
import org.xmlcml.euclid.Int;
import org.xmlcml.euclid.IntMatrix;
import org.xmlcml.euclid.RealMatrix;
import org.xmlcml.euclid.test.DoubleTestBase;

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
			cml = (CMLCml)CMLXOMTestUtils.parseValidString(unitsS);
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
		RealMatrix expected1 = expected
				.getEuclidRealMatrix();
		Assert.assertNotNull("test should not be null (" + msg + EC.S_RBRAK, test);
		Assert.assertNotNull("ref should not be null (" + msg + EC.S_RBRAK,
				expected1);
		Assert.assertEquals("rows should be equal (" + msg + EC.S_RBRAK, rows,
				expected1.getRows());
		Assert.assertEquals("columns should be equal (" + msg + EC.S_RBRAK, cols,
				expected1.getCols());
		DoubleTestBase.assertEquals(msg, test, expected1.getMatrixAsArray(),
				epsilon);
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
		IntMatrix expected1 = expected
				.getEuclidIntMatrix();
		Assert.assertNotNull("test should not be null (" + msg + S_RBRAK, test);
		Assert.assertNotNull("ref should not be null (" + msg + S_RBRAK,
				expected1);
		Assert.assertEquals("rows should be equal (" + msg + S_RBRAK, rows,
				expected1.getRows());
		Assert.assertEquals("columns should be equal (" + msg + S_RBRAK, cols,
				expected1.getCols());
		String s = Int.testEquals(test, expected1.getMatrixAsArray());
		if (s != null) {
			Assert.fail(msg + "; " + s);
		}
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
			throw new EuclidRuntimeException("should never throw " + e);
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
			throw new EuclidRuntimeException("should never throw " + e);
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
			throw new EuclidRuntimeException("should never throw " + e);
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
			throw new EuclidRuntimeException("should never throw " + e);
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
			throw new EuclidRuntimeException("should never throw " + e);
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
			throw new EuclidRuntimeException("should never throw " + e);
		}
		Assert.assertEquals("set mat", 4, mat.getRows());
		Assert.assertEquals("set mat", 3, mat.getColumns());
		String s = Int.testEquals((new int[] { 11, 12, 13, 21,
						22, 23, 31, 32, 33, 41, 42, 43 }), mat.getIntegerArray());
		if (s != null) {
			Assert.fail("set matrix int[][]" + "; " + s);
		}
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
			throw new EuclidRuntimeException("should never throw " + e);
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
			throw new EuclidRuntimeException("should never throw " + e);
		}
		Assert.assertEquals("set mat", XSD_INTEGER, mat.getDataType());
		Assert.assertEquals("set mat", 4, mat.getRows());
		Assert.assertEquals("set mat", 3, mat.getColumns());
		String s = Int.testEquals((new int[] { 11, 12, 13,
						21, 22, 23, 31, 32, 33, 41, 42, 43 }), mat.getIntegerArray());
		if (s != null) {
			Assert.fail("set matrix int, int []" + "; " + s);
		}
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
			throw new EuclidRuntimeException("should never throw " + e);
		}
		CMLMatrixTest.assertEquals("multiply", 2, 2, new double[] { 36450.,
				16200., 8100., 4050. }, mat1, EPS);
	}


	/**
	 * Test method for 'org.xmlcml.cml.element.CMLMatrix.copy()'
	 */
	@Test
	public void testCopy() {
		CMLMatrix m = (CMLMatrix) matrixList.get(0).copy();
		CMLMatrix expected = matrixList.get(0);
		Assert.assertNotNull("test should not be null (" + "copy" + S_RBRAK, m);
		Assert.assertNotNull("expected should not be null (" + "copy" + S_RBRAK,
				expected);
		if (m.getEuclidRealMatrix() != null) {
			RealMatrix test = m.getEuclidRealMatrix();
			RealMatrix expected1 = expected.getEuclidRealMatrix();
			Assert.assertNotNull("test should not be null (" + "copy" + EC.S_RBRAK, test);
			Assert.assertNotNull("expected should not be null (" + "copy" + EC.S_RBRAK,
					expected1);
			Assert.assertNotNull("expected should have columns (" + "copy" + EC.S_RBRAK,
					expected1.getCols());
			Assert.assertNotNull("expected should have rows (" + "copy" + EC.S_RBRAK,
					expected1.getRows());
			Assert.assertNotNull("test should have columns (" + "copy" + EC.S_RBRAK, test
					.getCols());
			Assert.assertNotNull("test should have rows (" + "copy" + EC.S_RBRAK, test
					.getRows());
			Assert.assertEquals("rows should be equal (" + "copy" + EC.S_RBRAK, test
					.getRows(), expected1.getRows());
			Assert.assertEquals("columns should be equal (" + "copy" + EC.S_RBRAK, test
					.getCols(), expected1.getCols());
			DoubleTestBase.assertEquals("copy", test.getMatrixAsArray(), expected1
					.getMatrixAsArray(), EPS);
		} else if (m.getEuclidIntMatrix() != null) {
			IntMatrix test = m.getEuclidIntMatrix();
			IntMatrix expected1 = expected
					.getEuclidIntMatrix();
			Assert.assertNotNull("test should not be null (" + "copy" + S_RBRAK, test);
			Assert.assertNotNull("expected should not be null (" + "copy" + S_RBRAK,
					expected1);
			Assert.assertNotNull("expected should have columns (" + "copy" + S_RBRAK,
					expected1.getCols());
			Assert.assertNotNull("expected should have rows (" + "copy" + S_RBRAK,
					expected1.getRows());
			Assert.assertNotNull("test should have columns (" + "copy" + S_RBRAK, test
					.getCols());
			Assert.assertNotNull("test should have rows (" + "copy" + S_RBRAK, test
					.getRows());
			Assert.assertEquals("rows should be equal (" + "copy" + S_RBRAK, test
					.getRows(), expected1.getRows());
			Assert.assertEquals("columns should be equal (" + "copy" + S_RBRAK, test
					.getCols(), expected1.getCols());
			String s = Int.testEquals(test.getMatrixAsArray(), expected1
							.getMatrixAsArray());
			if (s != null) {
				Assert.fail("copy" + "; " + s);
			}
		} else {
			Assert.fail("both matrices must be either real or int" + m);
		}
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLMatrix.getIntegerArray()'
	 */
	@Test
	public void testGetIntegerArray() {
		int[] ii = new int[] { 11, 12, 13, 21, 22, 23 };
		CMLMatrix m = new CMLMatrix(2, 3, ii);
		String s = Int.testEquals(ii, m.getIntegerArray());
		if (s != null) {
			Assert.fail("int[]" + "; " + s);
		}
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
		int[] test = new int[] { 1, 2, 3, 11,
				12, 13 };
		Assert.assertNotNull("test should not be null (" + "int mat" + S_RBRAK, test);
		Assert.assertNotNull("ref should not be null (" + "int mat" + S_RBRAK,
				imat);
		Assert.assertEquals("rows should be equal (" + "int mat" + S_RBRAK, 2,
				imat.getRows());
		Assert.assertEquals("columns should be equal (" + "int mat" + S_RBRAK, 3,
				imat.getCols());
		String s = Int.testEquals(test, imat.getMatrixAsArray());
		if (s != null) {
			Assert.fail("int mat" + "; " + s);
		}
	}

	@Test
	public void testSerializedDelimiter() {
		CMLMatrix mat = new CMLMatrix(2, 3, 
				new double[] { 1.1, 2.2, 3.3, 11.1, 12.2, 13.3 });
		String xml = mat.toXML();
		String ref = "<matrix xmlns=\"http://www.xml-cml.org/schema\" rows=\"2\" columns=\"3\" " +
				"dataType=\"xsd:double\">1.1 2.2 3.3 11.1 12.2 13.3</matrix>";
		Assert.assertEquals("serial", ref, xml);
	}
	
	@Test
	public void testGetScalar() {
		CMLMatrix mat = new CMLMatrix(2, 3, 
				new int[] { 11, 12, 13, 21, 22, 23 });
		mat.setDictRef("foo:bar");
		CMLScalar scalar = mat.getElementAt(1,1);
		String ref="<scalar xmlns=\"http://www.xml-cml.org/schema\" dataType=\"xsd:integer\"" +
		" dictRef=\"foo:bar\">22</scalar>";
		Assert.assertEquals("getElement", ref, scalar.toXML());
		scalar = mat.getElementAt(0,2);
		ref="<scalar xmlns=\"http://www.xml-cml.org/schema\" dataType=\"xsd:integer\"" +
		" dictRef=\"foo:bar\">13</scalar>";
		Assert.assertEquals("getElement", ref, scalar.toXML());
		
	}

	@Test
	public void testGetScalar1() {
		CMLMatrix mat = new CMLMatrix(2, 3, 
				new int[] { 11, 12, 13, 21, 22, 23 });
		mat.setDictRef("foo:bar");
		CMLScalar scalar = mat.getElementAt(2,1);
		Assert.assertNull(scalar);
		scalar = mat.getElementAt(-1,1);
		Assert.assertNull(scalar);
		scalar = mat.getElementAt(1,-1);
		Assert.assertNull(scalar);
		scalar = mat.getElementAt(1,3);
		Assert.assertNull(scalar);
	}

}
