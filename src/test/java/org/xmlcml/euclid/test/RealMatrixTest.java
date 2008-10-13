package org.xmlcml.euclid.test;

import java.io.IOException;
import java.io.StringWriter;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.xmlcml.euclid.EuclidRuntimeException;
import org.xmlcml.euclid.Int2;
import org.xmlcml.euclid.IntMatrix;
import org.xmlcml.euclid.IntSet;
import org.xmlcml.euclid.Real2Array;
import org.xmlcml.euclid.RealArray;
import org.xmlcml.euclid.RealMatrix;
import org.xmlcml.euclid.RealRange;

/**
 * test RealMatrix
 *
 * @author pmr
 *
 */
public class RealMatrixTest extends MatrixTest {

    static Logger logger = Logger.getLogger(RealMatrixTest.class.getName());

    RealMatrix m0;
    RealMatrix m1;
    RealMatrix m2;

    /**
     * setup.
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        super.setUp();
        logger.setLevel(Level.WARN);
        m0 = new RealMatrix();
        m1 = new RealMatrix(3, 4);
        m2 = new RealMatrix(3, 4, new double[] { 11., 12., 13., 14., 21., 22.,
                23., 24., 31., 32., 33., 34., });
    }

    /**
     * equality test. true if both args not null and equal within epsilon and
     * rows are present and equals and columns are present and equals
     *
     * @param msg
     *            message
     * @param test
     * @param expected
     * @param epsilon
     */
    public static void assertEquals(String msg, RealMatrix test,
            RealMatrix expected, double epsilon) {
        Assert.assertNotNull("test should not be null (" + msg + S_RBRAK, test);
        Assert.assertNotNull("expected should not be null (" + msg + S_RBRAK,
                expected);
        Assert.assertNotNull("expected should have columns (" + msg + S_RBRAK,
                expected.getCols());
        Assert.assertNotNull("expected should have rows (" + msg + S_RBRAK,
                expected.getRows());
        Assert.assertNotNull("test should have columns (" + msg + S_RBRAK, test
                .getCols());
        Assert.assertNotNull("test should have rows (" + msg + S_RBRAK, test
                .getRows());
        Assert.assertEquals("rows should be equal (" + msg + S_RBRAK, test
                .getRows(), expected.getRows());
        Assert.assertEquals("columns should be equal (" + msg + S_RBRAK, test
                .getCols(), expected.getCols());
        DoubleTestBase.assertEquals(msg, test.getMatrixAsArray(), expected
                .getMatrixAsArray(), epsilon);
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
            double[] test, RealMatrix expected, double epsilon) {
        Assert.assertNotNull("test should not be null (" + msg + S_RBRAK, test);
        Assert.assertNotNull("ref should not be null (" + msg + S_RBRAK, expected);
        Assert.assertEquals("rows should be equal (" + msg + S_RBRAK, rows,
                expected.getRows());
        Assert.assertEquals("columns should be equal (" + msg + S_RBRAK, cols,
                expected.getCols());
        DoubleTestBase
                .assertEquals(msg, test, expected.getMatrixAsArray(), epsilon);
    }

    /**
     * Test method for 'org.xmlcml.euclid.RealMatrix.RealMatrix()'
     */
    @Test
    public void testRealMatrix() {
        Assert.assertEquals("empty", "()", m0.toString());
    }

    /**
     * Test method for 'org.xmlcml.euclid.RealMatrix.RealMatrix(int, int)'
     */
    @Test
    public void testRealMatrixIntInt() {
        Assert.assertEquals("int int", "{3,4}" + "\n(0.0,0.0,0.0,0.0)"
                + "\n(0.0,0.0,0.0,0.0)" + "\n(0.0,0.0,0.0,0.0)", m1.toString());
        Assert.assertEquals("int int rows", 3, m1.getRows());
        Assert.assertEquals("int int cols", 4, m1.getCols());
    }

    /**
     * Test method for 'org.xmlcml.euclid.RealMatrix.RealMatrix(int, int,
     * double[])'
     */
    @Test
    public void testRealMatrixIntIntDoubleArray() {
        Assert.assertEquals("int int double[]", "{3,4}"
                + "\n(11.0,12.0,13.0,14.0)" + "\n(21.0,22.0,23.0,24.0)"
                + "\n(31.0,32.0,33.0,34.0)", m2.toString());
        Assert.assertEquals("int int double[] rows", 3, m2.getRows());
        Assert.assertEquals("int int double[] cols", 4, m2.getCols());
    }

    /**
     * Test method for 'org.xmlcml.euclid.RealMatrix.RealMatrix(int, int,
     * double)'
     */
    @Test
    public void testRealMatrixIntIntDouble() {
        RealMatrix m = new RealMatrix(3, 4, 10.);
        Assert.assertEquals("int int double[]", "{3,4}"
                + "\n(10.0,10.0,10.0,10.0)" + "\n(10.0,10.0,10.0,10.0)"
                + "\n(10.0,10.0,10.0,10.0)", m.toString());
        Assert.assertEquals("int int double[] rows", 3, m.getRows());
        Assert.assertEquals("int int double[] cols", 4, m.getCols());
    }

    /**
     * Test method for 'org.xmlcml.euclid.RealMatrix.RealMatrix(RealMatrix, int,
     * int, int, int)'
     */
    @Test
    public void testRealMatrixRealMatrixIntIntIntInt() {
        RealMatrix m = new RealMatrix(m2, 1, 2, 1, 3);
        Assert.assertEquals("int int double[]", "{2,3}" + "\n(22.0,23.0,24.0)"
                + "\n(32.0,33.0,34.0)", m.toString());
        Assert.assertEquals("int int double[] rows", 2, m.getRows());
        Assert.assertEquals("int int double[] cols", 3, m.getCols());
    }

    /**
     * Test method for 'org.xmlcml.euclid.RealMatrix.RealMatrix(RealMatrix)'
     */
    @Test
    public void testRealMatrixRealMatrix() {
        RealMatrix m = new RealMatrix(m2);
        Assert.assertEquals("int int double[]", "{3,4}"
                + "\n(11.0,12.0,13.0,14.0)" + "\n(21.0,22.0,23.0,24.0)"
                + "\n(31.0,32.0,33.0,34.0)", m.toString());
        Assert.assertEquals("int int double[] rows", 3, m.getRows());
        Assert.assertEquals("int int double[] cols", 4, m.getCols());
    }

    /**
     * Test method for 'org.xmlcml.euclid.RealMatrix.RealMatrix(IntMatrix)'
     */
    @Test
    public void testRealMatrixIntMatrix() {
        IntMatrix i2 = new IntMatrix(3, 4, new int[] { 11, 12, 13, 14, 21, 22, 23,
                    24, 31, 32, 33, 34, });
        RealMatrix m = new RealMatrix(i2);
        Assert.assertEquals("int int double[]", "{3,4}"
                + "\n(11.0,12.0,13.0,14.0)" + "\n(21.0,22.0,23.0,24.0)"
                + "\n(31.0,32.0,33.0,34.0)", m.toString());
        Assert.assertEquals("int int double[] rows", 3, m.getRows());
        Assert.assertEquals("int int double[] cols", 4, m.getCols());
    }

    /**
     * Test method for 'org.xmlcml.euclid.RealMatrix.getIntMatrix()'
     */
    @Test
    public void testGetIntMatrix() {
        RealMatrix mm2 = new RealMatrix(3, 4, new double[] { 11.1, 12.1, 13.1, 14.1,
                    21.1, 22.1, 23.1, 24.1, 31.1, 32.1, 33.1, 34.1, });
        IntMatrix m = mm2.getIntMatrix();
        Assert.assertEquals("int int double[]", "{3,4}" + "\n(11,12,13,14)"
                + "\n(21,22,23,24)" + "\n(31,32,33,34)", m.toString());
        Assert.assertEquals("int int double[] rows", 3, m.getRows());
        Assert.assertEquals("int int double[] cols", 4, m.getCols());
    }

    /**
     * Test method for 'org.xmlcml.euclid.RealMatrix.RealMatrix(double[][])'
     */
    @Test
    public void testRealMatrixDoubleArrayArray() {
        RealMatrix mm2 = new RealMatrix(new double[][] {
                    new double[] { 11.1, 12.1, 13.1, 14.1 },
                    new double[] { 21.1, 22.1, 23.1, 24.1 },
                    new double[] { 31.1, 32.1, 33.1, 34.1 } });
        IntMatrix m = mm2.getIntMatrix();
        Assert.assertEquals("int int double[]", "{3,4}" + "\n(11,12,13,14)"
                + "\n(21,22,23,24)" + "\n(31,32,33,34)", m.toString());
        Assert.assertEquals("int int double[] rows", 3, m.getRows());
        Assert.assertEquals("int int double[] cols", 4, m.getCols());
    }

    /**
     * Test method for 'org.xmlcml.euclid.RealMatrix.setFormat(DecimalFormat)'
     */
    @Test
    public void testSetFormat() {
    }

    /**
     * Test method for 'org.xmlcml.euclid.RealMatrix.getFormat()'
     */
    @Test
    public void testGetFormat() {
    }

    /**
     * Test method for 'org.xmlcml.euclid.RealMatrix.getRows()'
     */
    @Test
    public void testGetRowsCols() {
        RealMatrix m = new RealMatrix(new double[][] {
                    new double[] { 11.1, 12.1, 13.1, 14.1 },
                    new double[] { 21.1, 22.1, 23.1, 24.1 },
                    new double[] { 31.1, 32.1, 33.1, 34.1 } });
        Assert.assertEquals("int int double[] rows", 3, m.getRows());
        Assert.assertEquals("int int double[] cols", 4, m.getCols());
    }

    /**
     * Test method for 'org.xmlcml.euclid.RealMatrix.getMatrix()'
     */
    @Test
    public void testGetMatrix() {
        double[][] matrix = m1.getMatrix();
        Assert.assertEquals("getMatrix", 3, matrix.length);
        Assert.assertEquals("getMatrix", 4, matrix[0].length);
    }

    /**
     * Test method for 'org.xmlcml.euclid.RealMatrix.getMatrixAsArray()'
     */
    @Test
    public void testGetMatrixAsArray() {
        double[] array = m2.getMatrixAsArray();
        DoubleTestBase.assertEquals("matrix as array", new double[] { 11.0, 12.0,
                13.0, 14.0, 21.0, 22.0, 23.0, 24.0, 31.0, 32.0, 33.0, 34.0 },
                array, EPS);
    }

    /**
     * Test method for 'org.xmlcml.euclid.RealMatrix.isEqualTo(RealMatrix)'
     */
    @Test
    public void testIsEqualTo() {
        Assert.assertTrue("isEqualTo", m2.isEqualTo(m2));
    }

    /**
     * Test method for 'org.xmlcml.euclid.RealMatrix.plus(RealMatrix)'
     */
    @Test
    public void testPlus() {
        RealMatrix m = m2.plus(m2);
        RealMatrixTest.assertEquals("matrix as array", 3, 4, new double[] {
                22.0, 24.0, 26.0, 28.0, 42.0, 44.0, 46.0, 48.0, 62.0, 64.0,
                66.0, 68.0 }, m, EPS);
    }

    /**
     * Test method for 'org.xmlcml.euclid.RealMatrix.subtract(RealMatrix)'
     */
    @Test
    public void testSubtract() {
        RealMatrix m = new RealMatrix(new double[][] {
                    new double[] { 11.1, 12.1, 13.1, 14.1 },
                    new double[] { 21.1, 22.1, 23.1, 24.1 },
                    new double[] { 31.1, 32.1, 33.1, 34.1 } });
        RealMatrix mm = m2.subtract(m);
        RealMatrixTest.assertEquals("matrix as array", 3, 4, new double[] {
                -0.1, -0.1, -0.1, -0.1, -0.1, -0.1, -0.1, -0.1, -0.1, -0.1,
                -0.1, -0.1, }, mm, EPS);
    }

    /**
     * Test method for 'org.xmlcml.euclid.RealMatrix.negative()'
     */
    @Test
    public void testNegative() {
        m2.negative();
        RealMatrixTest.assertEquals("matrix as array", 3, 4, new double[] {
                -11.0, -12.0, -13.0, -14.0, -21.0, -22.0, -23.0, -24.0, -31.0,
                -32.0, -33.0, -34.0 }, m2, EPS);
    }

    /**
     * Test method for 'org.xmlcml.euclid.RealMatrix.multiply(RealMatrix)'
     */
    @Test
    public void testMultiplyRealMatrix() {
        RealMatrix m = new RealMatrix(new double[][] { new double[] { 10, 20, 30 },
                    new double[] { 40, 50, 60 }, });
        RealMatrix mm = m.multiply(m2);
        RealMatrixTest.assertEquals("matrix as array", 2, 4,
                new double[] { 1460.0, 1520.0, 1580.0, 1640.0, 3350.0, 3500.0,
                        3650.0, 3800.0, }, mm, EPS);
    }

    /**
     * Test method for 'org.xmlcml.euclid.RealMatrix.multiplyBy(double)'
     */
    @Test
    public void testMultiplyBy() {
        m2.multiplyBy(10.);
        RealMatrixTest.assertEquals("matrix as array", 3, 4, new double[] {
                110.0, 120.0, 130.0, 140.0, 210.0, 220.0, 230.0, 240.0, 310.0,
                320.0, 330.0, 340.0, }, m2, EPS);
    }

    /**
     * Test method for 'org.xmlcml.euclid.RealMatrix.multiplyEquals(RealMatrix)'
     */
    @Test
    public void testMultiplyEquals() {
        RealMatrix m = new RealMatrix(new double[][] { new double[] { 10, 20, 30 },
                    new double[] { 40, 50, 60 }, });
        try {
            m2.multiplyEquals(m);
            alwaysFail("non-conformable matrices");
        } catch (EuclidRuntimeException e) {
            Assert.assertEquals("multiplyEquals", "unequal matrices (4, 2)", e
                    .getMessage());
        }
        m.multiplyEquals(m2);
        RealMatrixTest.assertEquals("matrix as array", 2, 4,
                new double[] { 1460.0, 1520.0, 1580.0, 1640.0, 3350.0, 3500.0,
                        3650.0, 3800.0, }, m, EPS);
    }

    /**
     * Test method for 'org.xmlcml.euclid.RealMatrix.multiply(RealArray)'
     */
    @Test
    public void testMultiplyRealArray() {
        RealArray ra = new RealArray(new double[] { 1., 2., 3., 4. });
        RealArray raa = m2.multiply(ra);
        RealArrayTest.assertEquals("array",
                new double[] { 130.0, 230.0, 330.0 }, raa, EPS);
    }

    /**
     * Test method for
     * 'org.xmlcml.euclid.RealMatrix.columnwiseDivide(RealArray)'
     */
    @Test
    public void testColumnwiseDivide() {
        RealArray ra = new RealArray(new double[] { 1., 2., 3., 4. });
        m2.columnwiseDivide(ra);
        RealMatrixTest.assertEquals("array", 3, 4, new double[] { 11.0, 6.0,
                4.333333, 3.5, 21.0, 11.0, 7.66666666, 6.0, 31.0, 16.0, 11.0,
                8.5, }, m2, 0.00001);
    }

    /**
     * Test method for 'org.xmlcml.euclid.RealMatrix.elementAt(int, int)'
     */
    @Test
    public void testElementAtIntInt() {
        Assert.assertEquals("elementAt ", 32.0, m2.elementAt(2, 1), EPS);
        try {
            m2.elementAt(5, 5);
        } catch (EuclidRuntimeException e) {
            Assert.assertEquals("elementAt", "Bad value of row: 5/3", e
                    .getMessage());
        }
    }

    /**
     * Test method for 'org.xmlcml.euclid.RealMatrix.elementAt(Int2)'
     */
    @Test
    public void testElementAtInt2() {
        Assert.assertEquals("elementAt ", 32.0, m2
                .elementAt(new Int2(2, 1)), EPS);
        try {
            m2.elementAt(new Int2(5, 5));
        } catch (EuclidRuntimeException e) {
            Assert.assertEquals("elementAt", "Bad value of row: 5/3", e
                    .getMessage());
        }
    }

    /**
     * Test method for 'org.xmlcml.euclid.RealMatrix.setElementAt(int, int,
     * double)'
     */
    @Test
    public void testSetElementAt() {
        m2.setElementAt(1, 2, 15.);
        RealMatrixTest.assertEquals("matrix as array", 3, 4, new double[] {
                11.0, 12.0, 13.0, 14.0, 21.0, 22.0, 15.0, 24.0, 31.0, 32.0,
                33.0, 34.0, }, m2, EPS);
    }

    /**
     * Test method for 'org.xmlcml.euclid.RealMatrix.largestElement()'
     */
    @Test
    public void testLargestElement() {
        double d = m2.largestElement();
        Assert.assertEquals("largestElement", 34., d, EPS);
    }

    /**
     * Test method for 'org.xmlcml.euclid.RealMatrix.indexOfLargestElement()'
     */
    @Test
    public void testIndexOfLargestElement() {
        Int2 ii = m2.indexOfLargestElement();
        Assert.assertEquals("indexOfLargestElement", 2, ii.getX());
        Assert.assertEquals("indexOfLargestElement", 3, ii.getY());
    }

    /**
     * Test method for
     * 'org.xmlcml.euclid.RealMatrix.largestElementInColumn(int)'
     */
    @Test
    public void testLargestElementInColumn() {
        double d = m2.largestElementInColumn(1);
        Assert.assertEquals("largestElement", 32., d, EPS);
    }

    /**
     * Test method for
     * 'org.xmlcml.euclid.RealMatrix.indexOfLargestElementInColumn(int)'
     */
    @Test
    public void testIndexOfLargestElementInColumn() {
        int i = m2.indexOfLargestElementInColumn(1);
        Assert.assertEquals("largestElement", 2, i);
    }

    /**
     * Test method for 'org.xmlcml.euclid.RealMatrix.largestElementInRow(int)'
     */
    @Test
    public void testLargestElementInRow() {
        double d = m2.largestElementInRow(1);
        Assert.assertEquals("largestElement", 24., d, EPS);
    }

    /**
     * Test method for
     * 'org.xmlcml.euclid.RealMatrix.indexOfLargestElementInRow(int)'
     */
    @Test
    public void testIndexOfLargestElementInRow() {
        int i = m2.indexOfLargestElementInRow(1);
        Assert.assertEquals("largestElement", 3, i);
    }

    /**
     * Test method for 'org.xmlcml.euclid.RealMatrix.smallestElement()'
     */
    @Test
    public void testSmallestElement() {
        double d = m2.smallestElement();
        Assert.assertEquals("smallestElement", 11., d, EPS);
    }

    /**
     * Test method for 'org.xmlcml.euclid.RealMatrix.indexOfSmallestElement()'
     */
    @Test
    public void testIndexOfSmallestElement() {
        Int2 ii = m2.indexOfSmallestElement();
        Assert.assertEquals("indexOfSmallestElement", 0, ii.getX());
        Assert.assertEquals("indexOfSmallestElement", 0, ii.getY());
    }

    /**
     * Test method for
     * 'org.xmlcml.euclid.RealMatrix.smallestElementInColumn(int)'
     */
    @Test
    public void testSmallestElementInColumn() {
        double d =  m2.smallestElementInColumn(1);
        Assert.assertEquals("smallestElement", 12., d, EPS);
    }

    /**
     * Test method for
     * 'org.xmlcml.euclid.RealMatrix.indexOfSmallestElementInColumn(int)'
     */
    @Test
    public void testIndexOfSmallestElementInColumn() {
        int i = m2.indexOfSmallestElementInColumn(1);
        Assert.assertEquals("largestElement", 0, i);
    }

    /**
     * Test method for 'org.xmlcml.euclid.RealMatrix.smallestElementInRow(int)'
     */
    @Test
    public void testSmallestElementInRow() {
        double d = m2.smallestElementInRow(1);
        Assert.assertEquals("smallestElement", 21., d, EPS);
    }

    /**
     * Test method for
     * 'org.xmlcml.euclid.RealMatrix.indexOfSmallestElementInRow(int)'
     */
    @Test
    public void testIndexOfSmallestElementInRow() {
        int i = m2.indexOfSmallestElementInRow(1);
        Assert.assertEquals("largestElement", 0, i);
    }

    /**
     * Test method for 'org.xmlcml.euclid.RealMatrix.isOrthogonal()'
     */
    @Test
    public void testIsOrthogonal() {
        Assert.assertFalse("orthogonal", m2.isOrthogonal());
        RealMatrix m = new RealMatrix(2, 2, new double[] { 1., 0., 0., 1. });
            Assert.assertTrue("orthogonal", m.isOrthogonal());
            m = new RealMatrix(2, 2, new double[] { Math.cos(Math.PI / 3.),
                    Math.sin(Math.PI / 3.), -Math.sin(Math.PI / 3.),
                    Math.cos(Math.PI / 3.) });
        Assert.assertTrue("orthogonal", m.isOrthogonal());
    }

    /**
     * Test method for 'org.xmlcml.euclid.RealMatrix.euclideanRowLength(int)'
     */
    @Test
    public void testEuclideanRowLength() {
        double d = m2.euclideanRowLength(1);
        Assert.assertEquals("euclidean row length", 45.05552130427524, d, EPS);
    }

    /**
     * Test method for 'org.xmlcml.euclid.RealMatrix.euclideanRowLengths()'
     */
    @Test
    public void testEuclideanRowLengths() {
        RealArray ra = m2.euclideanRowLengths();
        RealArrayTest.assertEquals("euclidean row lengths", new double[] {
                25.099800796022265, 45.05552130427524, 65.0384501660364 }, ra,
                EPS);
    }

    /**
     * Test method for 'org.xmlcml.euclid.RealMatrix.euclideanColumnLength(int)'
     */
    @Test
    public void testEuclideanColumnLength() {
        double d = m2.euclideanColumnLength(1);
        Assert.assertEquals("euclidean row length", 40.64480286580315, d, EPS);
    }

    /**
     * Test method for 'org.xmlcml.euclid.RealMatrix.euclideanColumnLengths()'
     */
    @Test
    public void testEuclideanColumnLengths() {
        RealArray ra = m2.euclideanColumnLengths();
        RealArrayTest.assertEquals("euclidean column lengths", new double[] {
                39.02563260217571, 40.64480286580315, 42.2729227756965,
                43.9089968002003 }, ra, EPS);
    }

    /**
     * Test method for 'org.xmlcml.euclid.RealMatrix.extractColumnData(int)'
     */
    @Test
    public void testExtractColumnData() {
        RealArray ra = m2.extractColumnData(1);
        RealArrayTest.assertEquals("euclidean column lengths", new double[] {
                12., 22., 32. }, ra, EPS);
    }

    /**
     * Test method for 'org.xmlcml.euclid.RealMatrix.extractRowData(int)'
     */
    @Test
    public void testExtractRowData() {
        RealArray ra = m2.extractRowData(1);
        RealArrayTest.assertEquals("euclidean column lengths", new double[] {
                21., 22., 23., 24. }, ra, EPS);
    }

    /**
     * Test method for 'org.xmlcml.euclid.RealMatrix.clearMatrix()'
     */
    @Test
    public void testClearMatrix() {
        m2.clearMatrix();
        RealMatrixTest.assertEquals("matrix as array", 3, 4, new double[] { 0.,
                0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., }, m2, EPS);
    }

    /**
     * Test method for 'org.xmlcml.euclid.RealMatrix.setAllElements(double)'
     */
    @Test
    public void testSetAllElements() {
        m2.setAllElements(23.);
        RealMatrixTest.assertEquals("matrix as array", 3, 4, new double[] {
                23., 23., 23., 23., 23., 23., 23., 23., 23., 23., 23., 23., },
                m2, EPS);
    }

    /**
     * Test method for 'org.xmlcml.euclid.RealMatrix.normaliseByRows()'
     */
    @Test
    public void testNormaliseByRows() {
        m2.normaliseByRows();
        RealMatrixTest.assertEquals("matrix as array", 3, 4, new double[] {
                0.4382504900892777, 0.4780914437337575, 0.5179323973782373,
                0.5577733510227171, 0.46609159969939906, 0.4882864377803228,
                0.5104812758612466, 0.5326761139421703, 0.47664112414825727,
                0.49201664428207204, 0.5073921644158867, 0.5227676845497016, },
                m2, EPS);
    }

    /**
     * Test method for 'org.xmlcml.euclid.RealMatrix.normaliseByColumns()'
     */
    @Test
    public void testNormaliseByColumns() {
        m2.normaliseByColumns();
        RealMatrixTest.assertEquals("matrix as array", 3, 4, new double[] {
                0.2818660266736263, 0.29524069878307374, 0.30752545947624765,
                0.31884126307199384, 0.5381078691041957, 0.5412746144356352,
                0.5440835052272074, 0.5465850224091323, 0.7943497115347651,
                0.7873085300881967, 0.7806415509781671, 0.7743287817462708, },
                m2, EPS);
    }

    /**
     * Test method for 'org.xmlcml.euclid.RealMatrix.getTranspose()'
     */
    @Test
    public void testGetTranspose() {
        RealMatrix m = m2.getTranspose();
        RealMatrixTest.assertEquals("transpose", 4, 3, new double[] { 11.0,
                21.0, 31.0, 12.0, 22.0, 32.0, 13.0, 23.0, 33.0, 14.0, 24.0,
                34.0, }, m, EPS);
    }

    /**
     * Test method for 'org.xmlcml.euclid.RealMatrix.isSquare()'
     */
    @Test
    public void testIsSquare() {
        Assert.assertFalse("isSquare", m2.isSquare());
        Assert.assertTrue("isSquare", new RealMatrix(2, 2, new double[] {
                    11., 12., 21., 22. }).isSquare());
    }

    /**
     * Test method for 'org.xmlcml.euclid.RealMatrix.deleteColumn(int)'
     */
    @Test
    public void testDeleteColumn() {
        m2.deleteColumn(1);
        RealMatrixTest.assertEquals("matrix as array", 3, 3, new double[] {
                11.0, 13.0, 14.0, 21.0, 23.0, 24.0, 31.0, 33.0, 34.0, }, m2,
                EPS);
    }

    /**
     * Test method for 'org.xmlcml.euclid.RealMatrix.deleteColumns(int, int)'
     */
    @Test
    public void testDeleteColumns() {
        m2.deleteColumns(1, 2);
        RealMatrixTest.assertEquals("matrix as array", 3, 2, new double[] {
                11.0, 14.0, 21.0, 24.0, 31.0, 34.0, }, m2, EPS);
    }

    /**
     * Test method for 'org.xmlcml.euclid.RealMatrix.deleteRow(int)'
     */
    @Test
    public void testDeleteRow() {
        m2.deleteRow(1);
        RealMatrixTest.assertEquals("matrix as array", 2, 4, new double[] {
                11.0, 12.0, 13.0, 14.0, 31.0, 32.0, 33.0, 34.0, }, m2, EPS);
    }

    /**
     * Test method for 'org.xmlcml.euclid.RealMatrix.deleteRows(int, int)'
     */
    @Test
    public void testDeleteRows() {
        // FIXME does not work for high = nrows
        m2.deleteRows(1, 1);
        RealMatrixTest.assertEquals("matrix as array", 2, 4, new double[] {
                11.0, 12., 13., 14.0, 31.0, 32., 33., 34.0, }, m2, EPS);
    }

    /**
     * Test method for 'org.xmlcml.euclid.RealMatrix.replaceColumnData(int,
     * RealArray)'
     */
    @Test
    public void testReplaceColumnDataIntRealArray() {
        m2.replaceColumnData(1, new RealArray(
                    new double[] { 19., 29., 39. }));
        RealMatrixTest.assertEquals("matrix as array", 3, 4, new double[] {
                11.0, 19., 13., 14.0, 21.0, 29., 23., 24.0, 31.0, 39., 33.,
                34.0, }, m2, EPS);
    }

    /**
     * Test method for 'org.xmlcml.euclid.RealMatrix.replaceColumnData(int,
     * double[])'
     */
    @Test
    public void testReplaceColumnDataIntDoubleArray() {
        m2.replaceColumnData(1, new double[] { 19., 29., 39. });
        RealMatrixTest.assertEquals("matrix as array", 3, 4, new double[] {
                11.0, 19., 13., 14.0, 21.0, 29., 23., 24.0, 31.0, 39., 33.,
                34.0, }, m2, EPS);
    }

    /**
     * Test method for 'org.xmlcml.euclid.RealMatrix.replaceColumnData(int,
     * RealMatrix)'
     */
    @Test
    public void testReplaceColumnDataIntRealMatrix() {
        RealMatrix m = new RealMatrix(3, 2, new double[] { 72., 73., 82., 83., 92.,
                    93. });
            logger.info("\n--OK replace-- 1 " + m + "\n----");
            m2.replaceColumnData(1, m);
            RealMatrix expect = new RealMatrix(3, 4, new double[] { 11.0, 72.0, 73.0,
                    14.0, 21.0, 82.0, 83.0, 24.0, 31.0, 92.0, 93.0, 34.0, });
        RealMatrixTest.assertEquals("matrix as array", m2, expect, EPS);
    }

    /**
     * Test method for 'org.xmlcml.euclid.RealMatrix.insertColumns(int, int)'
     */
    @Test
    public void testInsertColumns() {
        // inserts 3 empty columns
        m2.makeSpaceForNewColumns(1, 3);
        RealMatrix expect = new RealMatrix(3, 7, new double[] { 11.0, 0.0, 0.0, 0.0,
                    12.0, 13.0, 14.0, 21.0, 0.0, 0.0, 0.0, 22.0, 23.0, 24.0,
                    31.0, 0.0, 0.0, 0.0, 32.0, 33.0, 34.0, });
        RealMatrixTest.assertEquals("matrix as array", m2, expect, EPS);
    }

    /**
     * Test method for 'org.xmlcml.euclid.RealMatrix.insertColumnData(int,
     * RealArray)'
     */
    @Test
    public void testInsertColumnDataIntRealArray() {
        // inserts a column
        m2.insertColumnData(1,
                    new RealArray(new double[] { 91., 92., 93. }));
        RealMatrix expect = new RealMatrix(3, 5, new double[] { 11.0, 12.0, 91.0,
                    13.0, 14.0, 21.0, 22.0, 92.0, 23.0, 24.0, 31.0, 32.0, 93.0,
                    33.0, 34.0, });
        RealMatrixTest.assertEquals("matrix as array", m2, expect, EPS);
    }

    /**
     * Test method for 'org.xmlcml.euclid.RealMatrix.insertColumnData(int,
     * RealMatrix)'
     */
    @Test
    public void testInsertColumnDataIntRealMatrix() {
        logger.info("+++insertColumnData>>>");
        RealMatrix insert = new RealMatrix(3, 2, new double[] { 72., 73., 82., 83.,
                    92., 93., });
            m2.insertColumnData(1, insert);
        RealMatrix expect = new RealMatrix(3, 6, new double[] { 11.0, 12.0, 72.0,
                    73.0, 13.0, 14.0, 21.0, 22.0, 82.0, 83.0, 23.0, 24.0, 31.0,
                    32.0, 92.0, 93.0, 33.0, 34.0, });
        RealMatrixTest.assertEquals("matrix as array", m2, expect, EPS);
    }

    /**
     * Test method for 'org.xmlcml.euclid.RealMatrix.insertRows(int, int)'
     */
    @Test
    public void testInsertRows() {
        m2.insertRows(1, 2);
        RealMatrixTest.assertEquals("matrix as array", 5, 4, new double[] {
                11.0, 12.0, 13.0, 14.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
                21.0, 22.0, 23.0, 24.0, 31.0, 32.0, 33.0, 34.0, }, m2, EPS);
    }

    /**
     * Test method for 'org.xmlcml.euclid.RealMatrix.replaceRowData(int,
     * RealArray)'
     */
    @Test
    public void testReplaceRowDataIntRealArray() {
            m2.replaceRowData(1, new RealArray(new double[] { 71.0, 72., 73.,
                    74. }));
        RealMatrixTest.assertEquals("matrix as array", 3, 4, new double[] {
                11.0, 12.0, 13.0, 14.0, 71.0, 72.0, 73.0, 74.0, 31.0, 32.0,
                33.0, 34.0, }, m2, EPS);
    }

    /**
     * Test method for 'org.xmlcml.euclid.RealMatrix.replaceRowData(int,
     * double[])'
     */
    @Test
    public void testReplaceRowDataIntDoubleArray() {
            m2.replaceRowData(1, new double[] { 71.0, 72., 73., 74. });
        RealMatrixTest.assertEquals("matrix as array", 3, 4, new double[] {
                11.0, 12.0, 13.0, 14.0, 71.0, 72.0, 73.0, 74.0, 31.0, 32.0,
                33.0, 34.0, }, m2, EPS);
    }

    /**
     * Test method for 'org.xmlcml.euclid.RealMatrix.replaceRowData(int,
     * RealMatrix)'
     */
    @Test
    public void testReplaceRowDataIntRealMatrix() {
        logger.info("+++replaceRowData>>>");
        // FIXME
        RealMatrix insert = new RealMatrix(new RealMatrix(2, 4, new double[] { 71.0,
                    72.0, 73.0, 74.0, 81.0, 82.0, 83.0, 84.0, }));
        m2.replaceRowData(0, insert);
        RealMatrix expect = new RealMatrix(3, 4, new double[] { 11.0, 12.0, 13.0,
                    14.0, 71.0, 72.0, 73.0, 74.0, 81.0, 82.0, 83.0, 84.0, });
        // rows 2 and 3 are not filled
        RealMatrixTest.assertEquals("matrix as array", m2, expect, EPS);
    }

    /**
     * Test method for 'org.xmlcml.euclid.RealMatrix.insertRowData(int,
     * RealMatrix)'
     */
    @Test
    public void testInsertRowDataIntRealMatrix() {
        // FIXME
            m2.insertRowData(1, new RealMatrix(2, 4, new double[] { 71.0, 72.,
                    73., 74., 81.0, 82., 83., 84., }));
        RealMatrix expect = new RealMatrix(5, 4, new double[] { 11.0, 12.0, 13.0,
                    14.0, 21.0, 22.0, 23.0, 24.0, 71.0, 72.0, 73.0, 74.0, 81.0,
                    82.0, 83.0, 84.0, 31.0, 32.0, 33.0, 34.0, });
        RealMatrixTest.assertEquals("matrix as array", m2, expect, EPS);
    }

    /**
     * Test method for 'org.xmlcml.euclid.RealMatrix.insertRowData(int,
     * RealArray)'
     */
    @Test
    public void testInsertRowDataIntRealArray() {
            m2.insertRowData(1, new RealArray(new double[] { 71.0, 72., 73.,
                    74., }));
        RealMatrixTest.assertEquals("matrix as array", 4, 4, new double[] {
                11.0, 12.0, 13.0, 14.0, 21.0, 22.0, 23.0, 24.0, 71.0, 72.0,
                73.0, 74.0, 31.0, 32.0, 33.0, 34.0, }, m2, EPS);
    }

    /**
     * Test method for
     * 'org.xmlcml.euclid.RealMatrix.appendColumnData(RealArray)'
     */
    @Test
    public void testAppendColumnDataRealArray() {
        m2.appendColumnData(new RealArray(new double[] { 17., 27., 37., }));
        RealMatrixTest.assertEquals("matrix as array", 3, 5, new double[] {
                11.0, 12.0, 13.0, 14.0, 17.0, 21.0, 22.0, 23.0, 24.0, 27.0,
                31.0, 32.0, 33.0, 34.0, 37.0 }, m2, EPS);
    }

    /**
     * Test method for
     * 'org.xmlcml.euclid.RealMatrix.appendColumnData(RealMatrix)'
     */
    @Test
    public void testAppendColumnDataRealMatrix() {
        // logger.info("+++appendColumnData>>>");
        RealMatrix rm = new RealMatrix(3, 2, new double[] { 17., 18., 27., 28., 37.,
                    38. });
        m2.appendColumnData(rm);
        RealMatrix expect = new RealMatrix(3, 6, new double[] { 11.0, 12.0, 13.0,
                    14.0, 17.0, 18.0, 21.0, 22.0, 23.0, 24.0, 27.0, 28.0, 31.0,
                    32.0, 33.0, 34.0, 37.0, 38.0 });
        RealMatrixTest.assertEquals("matrix as array", m2, expect, EPS);
    }

    /**
     * Test method for 'org.xmlcml.euclid.RealMatrix.appendRowData(RealArray)'
     */
    @Test
    public void testAppendRowDataRealArray() {
        RealArray ra = new RealArray(new double[] { 41., 42., 43., 44. });
        m2.appendRowData(ra);
        // fails to insert data
        RealMatrixTest.assertEquals("matrix as array", 4, 4, new double[] {
                11.0, 12.0, 13.0, 14.0, 21.0, 22.0, 23.0, 24.0, 31.0, 32.0,
                33.0, 34.0, 41.0, 42.0, 43.0, 44.0 }, m2, EPS);
    }

    /**
     * Test method for 'org.xmlcml.euclid.RealMatrix.appendRowData(RealMatrix)'
     */
    @Test
    public void testAppendRowDataRealMatrix() {
        logger.info("+++appendRowData>>>");
        // FIXME
        RealMatrix rm = new RealMatrix(2, 4, new double[] { 41., 42., 43., 44., 51.,
                    52., 53., 54. });
        m2.appendRowData(rm);
        RealMatrix expect = new RealMatrix(5, 4, new double[] { 11.0, 12.0, 13.0,
            14.0, 21.0, 22.0, 23.0, 24.0, 31.0, 32.0, 33.0, 34.0, 41.0,
            42.0, 43.0, 44.0, 51.0, 52.0, 53.0, 54.0 });
        RealMatrixTest.assertEquals("matrix as array", m2, expect, EPS);
    }

    /**
     * Test method for 'org.xmlcml.euclid.RealMatrix.replaceSubMatrixData(int,
     * int, RealMatrix)'
     */
    @Test
    public void testReplaceSubMatrixData() {
        RealMatrix rm = new RealMatrix(2, 2, new double[] { 71., 72., 81., 82. });
        m2.replaceSubMatrixData(1, 1, rm);
        // fails to insert data
        RealMatrixTest.assertEquals("matrix as array", 3, 4, new double[] {
                71.0, 72.0, 13.0, 14.0, 81.0, 82.0, 23.0, 24.0, 31.0, 32.0,
                33.0, 34.0, }, m2, EPS);
    }

    /**
     * Test method for 'org.xmlcml.euclid.RealMatrix.reorderColumnsBy(IntSet)'
     */
    @Test
    public void testReorderColumnsBy() {
        RealMatrix mm = m2.reorderColumnsBy(new IntSet(new int[] { 3, 1, 2, 0 }));
        // fails to insert data
        RealMatrixTest.assertEquals("matrix as array", 3, 4, new double[] {
                14.0, 12.0, 13.0, 11.0, 24.0, 22.0, 23.0, 21.0, 34.0, 32.0,
                33.0, 31.0 }, mm, EPS);
    }

    /**
     * Test method for 'org.xmlcml.euclid.RealMatrix.reorderRowsBy(IntSet)'
     */
    @Test
    public void testReorderRowsBy() {
        RealMatrix mm = m2.reorderRowsBy(new IntSet(new int[] { 1, 2, 0 }));
        // fails to insert data
        RealMatrixTest.assertEquals("matrix as array", 3, 4, new double[] {
                21.0, 22.0, 23.0, 24.0, 31.0, 32.0, 33.0, 34.0, 11.0, 12.0,
                13.0, 14.0, }, mm, EPS);
    }

    /**
     * Test method for 'org.xmlcml.euclid.RealMatrix.extractSubMatrixData(int,
     * int, int, int)'
     */
    @Test
    public void testExtractSubMatrixData() {
        RealMatrix mm = m2.extractSubMatrixData(1, 2, 2, 3);
        RealMatrixTest.assertEquals("sub matrix", 2, 2, new double[] { 23.0,
                24.0, 33.0, 34.0 }, mm, EPS);
    }

    /**
     * Test method for 'org.xmlcml.euclid.RealMatrix.extractColumns(int, int)'
     */
    @Test
    public void testExtractColumns() {
        Real2Array mm = m2.extractColumns(1, 3);
        RealArrayTest.assertEquals("extract columns", new double[] { 12.0,
                22.0, 32.0 }, mm.getXArray(), EPS);
        RealArrayTest.assertEquals("extract columns", new double[] { 14.0,
                24.0, 34.0 }, mm.getYArray(), EPS);
    }

    /**
     * Test method for 'org.xmlcml.euclid.RealMatrix.extractRows(int, int)'
     */
    @Test
    public void testExtractRows() {
        Real2Array mm = m2.extractRows(2, 0);
        RealArrayTest.assertEquals("extract rows", new double[] { 31.0, 32.0,
                33.0, 34.0 }, mm.getXArray(), EPS);
        RealArrayTest.assertEquals("extract rows", new double[] { 11.0, 12.0,
                13.0, 14.0 }, mm.getYArray(), EPS);
    }

    /**
     * Test method for 'org.xmlcml.euclid.RealMatrix.elementsInRange(RealRange)'
     */
    @Test
    public void testElementsInRange() {
        IntMatrix im = m2.elementsInRange(new RealRange(13.1, 31.1));
        IntTest.assertEquals("sub matrix", new int[] { 0, 0, 0, 1, 1, 1, 1, 1,
                1, 0, 0, 0 }, im.getMatrixAsArray());
    }

    /**
     * Test method for 'org.xmlcml.euclid.RealMatrix.writeXML(Writer)'
     */
    @Test
    public void testWriteXML() {
        StringWriter w = new StringWriter();
        try {
            m2.writeXML(w);
            w.close();
        } catch (IOException e) {
            neverThrow(e);
        }
        Assert
                .assertEquals(
                        "writeXML",
                        "<matrix rows='3' columns='4'>11.0 12.0 13.0 14.0 21.0 22.0 23.0 24.0 31.0 32.0 33.0 34.0</matrix>",
                        w.toString());
    }


}
