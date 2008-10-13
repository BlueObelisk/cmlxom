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
import org.xmlcml.euclid.IntArray;
import org.xmlcml.euclid.IntMatrix;
import org.xmlcml.euclid.IntRange;
import org.xmlcml.euclid.IntSet;

/**
 * test IntMatrix
 *
 * @author pmr
 *
 */
public class IntMatrixTest extends MatrixTest {

    final static Logger logger = Logger.getLogger(IntMatrixTest.class);

    IntMatrix m0;

    IntMatrix m1;

    IntMatrix m2;

    /**
     * setup.
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        super.setUp();
        logger.setLevel(Level.WARN);
        m0 = new IntMatrix();
        m1 = new IntMatrix(3, 4);
        m2 = new IntMatrix(3, 4, new int[] { 11, 12, 13, 14, 21, 22, 23, 24,
                31, 32, 33, 34, });
    }

    /**
     * equality test. true if both args not null and equal within epsilon and
     * rows are present and equals and columns are present and equals
     *
     * @param msg
     *            message
     * @param test
     * @param expected
     */
    public static void assertEquals(String msg, IntMatrix test,
            IntMatrix expected) {
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
        IntTest.assertEquals(msg, test.getMatrixAsArray(), expected
                .getMatrixAsArray());
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
     */
    public static void assertEquals(String msg, int rows, int cols, int[] test,
            IntMatrix expected) {
        Assert.assertNotNull("test should not be null (" + msg + S_RBRAK, test);
        Assert.assertNotNull("ref should not be null (" + msg + S_RBRAK, expected);
        Assert.assertEquals("rows should be equal (" + msg + S_RBRAK, rows,
                expected.getRows());
        Assert.assertEquals("columns should be equal (" + msg + S_RBRAK, cols,
                expected.getCols());
        IntTest.assertEquals(msg, test, expected.getMatrixAsArray());
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntMatrix.IntMatrix()'
     */
    @Test
    public void testIntMatrix() {
        Assert.assertEquals("empty", "()", m0.toString());
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntMatrix.IntMatrix(int, int)'
     */
    @Test
    public void testIntMatrixIntInt() {
        Assert.assertEquals("int int", "{3,4}" + "\n(0,0,0,0)" + "\n(0,0,0,0)"
                + "\n(0,0,0,0)", m1.toString());
        Assert.assertEquals("int int rows", 3, m1.getRows());
        Assert.assertEquals("int int cols", 4, m1.getCols());
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntMatrix.IntMatrix(int, int, int[])'
     */
    @Test
    public void testIntMatrixIntIntIntegerArray() {
        Assert.assertEquals("int int int[]", "{3,4}" + "\n(11,12,13,14)"
                + "\n(21,22,23,24)" + "\n(31,32,33,34)", m2.toString());
        Assert.assertEquals("int int int[] rows", 3, m2.getRows());
        Assert.assertEquals("int int int[] cols", 4, m2.getCols());
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntMatrix.IntMatrix(int, int, int)'
     */
    @Test
    public void testIntMatrixIntIntInteger() {
        IntMatrix m = new IntMatrix(3, 4, 10);
        Assert.assertEquals("int int int[]", "{3,4}" + "\n(10,10,10,10)"
                + "\n(10,10,10,10)" + "\n(10,10,10,10)", m.toString());
        Assert.assertEquals("int int int[] rows", 3, m.getRows());
        Assert.assertEquals("int int int[] cols", 4, m.getCols());
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntMatrix.IntMatrix(IntMatrix, int,
     * int, int, int)'
     */
    @Test
    public void testIntMatrixIntMatrixIntIntIntInt() {
        IntMatrix m = new IntMatrix(m2, 1, 2, 1, 3);
        Assert.assertEquals("int int int[]", "{2,3}" + "\n(22,23,24)"
                + "\n(32,33,34)", m.toString());
        Assert.assertEquals("int int int[] rows", 2, m.getRows());
        Assert.assertEquals("int int int[] cols", 3, m.getCols());
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntMatrix.IntMatrix(IntMatrix)'
     */
    @Test
    public void testIntMatrixIntMatrix() {
        IntMatrix m = new IntMatrix(m2);
        Assert.assertEquals("int int int[]", "{3,4}" + "\n(11,12,13,14)"
                + "\n(21,22,23,24)" + "\n(31,32,33,34)", m.toString());
        Assert.assertEquals("int int int[] rows", 3, m.getRows());
        Assert.assertEquals("int int int[] cols", 4, m.getCols());
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntMatrix.getIntMatrix()'
     */
    @Test
    public void testGetIntMatrix() {
        IntMatrix mm2 = new IntMatrix(3, 4, new int[] { 11, 12, 13, 14, 21, 22, 23,
                    24, 31, 32, 33, 34, });
        IntMatrix m = mm2.getIntMatrix();
        Assert.assertEquals("int int int[]", "{3,4}" + "\n(11,12,13,14)"
                + "\n(21,22,23,24)" + "\n(31,32,33,34)", m.toString());
        Assert.assertEquals("int int int[] rows", 3, m.getRows());
        Assert.assertEquals("int int int[] cols", 4, m.getCols());
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntMatrix.IntMatrix(int[][])'
     */
    @Test
    public void testIntMatrixIntegerArrayArray() {
        IntMatrix mm2 = new IntMatrix(
            new int[][] { new int[] { 11, 12, 13, 14 },
            new int[] { 21, 22, 23, 24 },
            new int[] { 31, 32, 33, 34 } });
        IntMatrix m = mm2.getIntMatrix();
        Assert.assertEquals("int int int[]", "{3,4}" + "\n(11,12,13,14)"
                + "\n(21,22,23,24)" + "\n(31,32,33,34)", m.toString());
        Assert.assertEquals("int int int[] rows", 3, m.getRows());
        Assert.assertEquals("int int int[] cols", 4, m.getCols());
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntMatrix.setFormat(DecimalFormat)'
     */
    @Test
    public void testSetFormat() {
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntMatrix.getFormat()'
     */
    @Test
    public void testGetFormat() {
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntMatrix.getRows()'
     */
    @Test
    public void testGetRowsCols() {
        IntMatrix m = new IntMatrix(
            new int[][] { new int[] { 11, 12, 13, 14 },
            new int[] { 21, 22, 23, 24 },
            new int[] { 31, 32, 33, 34 } });
        Assert.assertEquals("int int int[] rows", 3, m.getRows());
        Assert.assertEquals("int int int[] cols", 4, m.getCols());
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntMatrix.getMatrix()'
     */
    @Test
    public void testGetMatrix() {
        int[][] matrix = m1.getMatrix();
        Assert.assertEquals("getMatrix", 3, matrix.length);
        Assert.assertEquals("getMatrix", 4, matrix[0].length);
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntMatrix.getMatrixAsArray()'
     */
    @Test
    public void testGetMatrixAsArray() {
        int[] array = m2.getMatrixAsArray();
        IntTest.assertEquals("matrix as array", new int[] { 11, 12, 13, 14, 21,
                22, 23, 24, 31, 32, 33, 34 }, array);
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntMatrix.isEqualTo(IntMatrix)'
     */
    @Test
    public void testIsEqualTo() {
        Assert.assertTrue("isEqualTo", m2.isEqualTo(m2));
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntMatrix.plus(IntMatrix)'
     */
    @Test
    public void testPlus() {
        IntMatrix m = m2.plus(m2);
        IntMatrixTest.assertEquals("matrix as array", 3, 4, new int[] { 22, 24,
                26, 28, 42, 44, 46, 48, 62, 64, 66, 68 }, m);
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntMatrix.subtract(IntMatrix)'
     */
    @Test
    public void testSubtract() {
        IntMatrix m = new IntMatrix(
	        new int[][] { new int[] { 11, 12, 13, 14 },
            new int[] { 21, 22, 23, 24 },
            new int[] { 31, 32, 33, 34 } });
        IntMatrix mm = m2.subtract(m);
        IntMatrixTest.assertEquals("matrix as array", 3, 4, new int[] { -0, -0,
                -0, -0, -0, -0, -0, -0, -0, -0, -0, -0, }, mm);
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntMatrix.negative()'
     */
    @Test
    public void testNegative() {
        m2.negative();
        IntMatrixTest.assertEquals("matrix as array", 3, 4, new int[] { -11,
            -12, -13, -14, -21, -22, -23, -24, -31, -32, -33, -34 }, m2);
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntMatrix.multiply(IntMatrix)'
     */
    @Test
    public void testMultiplyIntMatrix() {
        IntMatrix m = new IntMatrix(new int[][] { new int[] { 10, 20, 30 },
            new int[] { 40, 50, 60 }, });
        IntMatrix mm = m.multiply(m2);
        IntMatrixTest.assertEquals("matrix as array", 2, 4, new int[] { 1460,
                1520, 1580, 1640, 3350, 3500, 3650, 3800, }, mm);
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntMatrix.multiplyBy(int)'
     */
    @Test
    public void testMultiplyBy() {
        m2.multiplyBy(10);
        IntMatrixTest.assertEquals("matrix as array", 3, 4, new int[] { 110,
                120, 130, 140, 210, 220, 230, 240, 310, 320, 330, 340, }, m2);
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntMatrix.multiplyEquals(IntMatrix)'
     */
    @Test
    public void testMultiplyEquals() {
        IntMatrix m = new IntMatrix(new int[][] { new int[] { 10, 20, 30 },
                    new int[] { 40, 50, 60 }, });
        try {
            m2.multiplyEquals(m);
            alwaysFail("non-conformable matrices");
        } catch (EuclidRuntimeException e) {
            Assert.assertEquals("multiplyEquals", "unequal matrices (4, 2)", e
                    .getMessage());
        }
        m.multiplyEquals(m2);
        IntMatrixTest.assertEquals("matrix as array", 2, 4, new int[] { 1460,
                1520, 1580, 1640, 3350, 3500, 3650, 3800, }, m);
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntMatrix.multiply(IntArray)'
     */
    @Test
    public void testMultiplyIntArray() {
        IntArray ra = new IntArray(new int[] { 1, 2, 3, 4 });
        IntArray raa = m2.multiply(ra);
        IntArrayTest.assertEquals("array", new int[] { 130, 230, 330 }, raa);
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntMatrix.columnwiseDivide(IntArray)'
     */
    @Test
    public void testColumnwiseDivide() {
        IntArray ra = new IntArray(new int[] { 1, 2, 3, 4 });
        m2.columnwiseDivide(ra);
        IntMatrixTest.assertEquals("array", 3, 4, new int[] { 11, 6, 4, 3, 21,
                11, 7, 6, 31, 16, 11, 8, }, m2);
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntMatrix.elementAt(int, int)'
     */
    @Test
    public void testElementAtIntInt() {
        Assert.assertEquals("elementAt ", 32, m2.elementAt(2, 1));
        try {
            m2.elementAt(5, 5);
        } catch (EuclidRuntimeException e) {
            Assert.assertEquals("elementAt", "Bad value of row: 5/3", e
                    .getMessage());
        }
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntMatrix.elementAt(Int2)'
     */
    @Test
    public void testElementAtInt2() {
        Assert.assertEquals("elementAt ", 32, m2.elementAt(new Int2(2, 1)));
        try {
            m2.elementAt(new Int2(5, 5));
        } catch (EuclidRuntimeException e) {
            Assert.assertEquals("elementAt", "Bad value of row: 5/3", e
                    .getMessage());
        }
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntMatrix.setElementAt(int, int, int)'
     */
    @Test
    public void testSetElementAt() {
        m2.setElementAt(1, 2, 15);
        IntMatrixTest.assertEquals("matrix as array", 3, 4, new int[] { 11, 12,
                13, 14, 21, 22, 15, 24, 31, 32, 33, 34, }, m2);
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntMatrix.largestElement()'
     */
    @Test
    public void testLargestElement() {
        int d = m2.largestElement();
        Assert.assertEquals("largestElement", 34, d);
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntMatrix.indexOfLargestElement()'
     */
    @Test
    public void testIndexOfLargestElement() {
        Int2 ii = m2.indexOfLargestElement();
        Assert.assertEquals("indexOfLargestElement", 2, ii.getX());
        Assert.assertEquals("indexOfLargestElement", 3, ii.getY());
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntMatrix.largestElementInColumn(int)'
     */
    @Test
    public void testLargestElementInColumn() {
        int d = m2.largestElementInColumn(1);
        Assert.assertEquals("largestElement", 32, d);
    }

    /**
     * Test method for
     * 'org.xmlcml.euclid.IntMatrix.indexOfLargestElementInColumn(int)'
     */
    @Test
    public void testIndexOfLargestElementInColumn() {
        int i = m2.indexOfLargestElementInColumn(1);
        Assert.assertEquals("largestElement", 2, i);
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntMatrix.largestElementInRow(int)'
     */
    @Test
    public void testLargestElementInRow() {
        int d = m2.largestElementInRow(1);
        Assert.assertEquals("largestElement", 24, d);
    }

    /**
     * Test method for
     * 'org.xmlcml.euclid.IntMatrix.indexOfLargestElementInRow(int)'
     */
    @Test
    public void testIndexOfLargestElementInRow() {
        int i = m2.indexOfLargestElementInRow(1);
        Assert.assertEquals("largestElement", 3, i);
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntMatrix.smallestElement()'
     */
    @Test
    public void testSmallestElement() {
        int d = m2.smallestElement();
        Assert.assertEquals("smallestElement", 11, d);
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntMatrix.indexOfSmallestElement()'
     */
    @Test
    public void testIndexOfSmallestElement() {
        Int2 ii = m2.indexOfSmallestElement();
        Assert.assertEquals("indexOfSmallestElement", 0, ii.getX());
        Assert.assertEquals("indexOfSmallestElement", 0, ii.getY());
    }

    /**
     * Test method for
     * 'org.xmlcml.euclid.IntMatrix.smallestElementInColumn(int)'
     */
    @Test
    public void testSmallestElementInColumn() {
        int d = m2.smallestElementInColumn(1);
        Assert.assertEquals("smallestElement", 12, d);
    }

    /**
     * Test method for
     * 'org.xmlcml.euclid.IntMatrix.indexOfSmallestElementInColumn(int)'
     */
    @Test
    public void testIndexOfSmallestElementInColumn() {
        int i = m2.indexOfSmallestElementInColumn(1);
        Assert.assertEquals("largestElement", 0, i);
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntMatrix.smallestElementInRow(int)'
     */
    @Test
    public void testSmallestElementInRow() {
        int d = m2.smallestElementInRow(1);
        Assert.assertEquals("smallestElement", 21, d);
    }

    /**
     * Test method for
     * 'org.xmlcml.euclid.IntMatrix.indexOfSmallestElementInRow(int)'
     */
    @Test
    public void testIndexOfSmallestElementInRow() {
        int i = m2.indexOfSmallestElementInRow(1);
        Assert.assertEquals("largestElement", 0, i);
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntMatrix.extractColumnData(int)'
     */
    @Test
    public void testExtractColumnData() {
        IntArray ra= m2.extractColumnData(1);
        IntArrayTest.assertEquals("euclidean column lengths", new int[] { 12,
                22, 32 }, ra);
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntMatrix.extractRowData(int)'
     */
    @Test
    public void testExtractRowData() {
        IntArray ra = m2.extractRowData(1);
        IntArrayTest.assertEquals("euclidean column lengths", new int[] { 21,
                22, 23, 24 }, ra);
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntMatrix.clearMatrix()'
     */
    @Test
    public void testClearMatrix() {
        m2.clearMatrix();
        IntMatrixTest.assertEquals("matrix as array", 3, 4, new int[] { 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, }, m2);
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntMatrix.setAllElements(int)'
     */
    @Test
    public void testSetAllElements() {
        m2.setAllElements(23);
        IntMatrixTest.assertEquals("matrix as array", 3, 4, new int[] { 23, 23,
                23, 23, 23, 23, 23, 23, 23, 23, 23, 23, }, m2);
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntMatrix.getTranspose()'
     */
    @Test
    public void testGetTranspose() {
        IntMatrix m = m2.getTranspose();
        IntMatrixTest.assertEquals("transpose", 4, 3, new int[] { 11, 21, 31,
                12, 22, 32, 13, 23, 33, 14, 24, 34, }, m);
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntMatrix.isSquare()'
     */
    @Test
    public void testIsSquare() {
        Assert.assertFalse("isSquare", m2.isSquare());
        Assert.assertTrue("isSquare", new IntMatrix(2, 2, new int[] { 11,
            12, 21, 22 }).isSquare());
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntMatrix.deleteColumn(int)'
     */
    @Test
    public void testDeleteColumn() {
        m2.deleteColumn(1);
        IntMatrixTest.assertEquals("matrix as array", 3, 3, new int[] { 11, 13,
                14, 21, 23, 24, 31, 33, 34, }, m2);
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntMatrix.deleteColumns(int, int)'
     */
    @Test
    public void testDeleteColumns() {
        m2.deleteColumns(1, 2);
        IntMatrixTest.assertEquals("matrix as array", 3, 2, new int[] { 11, 14,
                21, 24, 31, 34, }, m2);
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntMatrix.deleteRow(int)'
     */
    @Test
    public void testDeleteRow() {
        m2.deleteRow(1);
        IntMatrixTest.assertEquals("matrix as array", 2, 4, new int[] { 11, 12,
                13, 14, 31, 32, 33, 34, }, m2);
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntMatrix.deleteRows(int, int)'
     */
    @Test
    public void testDeleteRows() {
        // FIXME does not work for high = nrows
        m2.deleteRows(1, 1);
        IntMatrixTest.assertEquals("matrix as array", 2, 4, new int[] { 11, 12,
                13, 14, 31, 32, 33, 34, }, m2);
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntMatrix.replaceColumnData(int,
     * IntArray)'
     */
    @Test
    public void testReplaceColumnDataIntIntArray() {
        m2.replaceColumnData(1, new IntArray(new int[] { 19, 29, 39 }));
        IntMatrixTest.assertEquals("matrix as array", 3, 4, new int[] { 11, 19,
                13, 14, 21, 29, 23, 24, 31, 39, 33, 34, }, m2);
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntMatrix.replaceColumnData(int,
     * int[])'
     */
    @Test
    public void testReplaceColumnDataIntIntegerArray() {
        m2.replaceColumnData(1, new int[] { 19, 29, 39 });
        IntMatrixTest.assertEquals("matrix as array", 3, 4, new int[] { 11, 19,
                13, 14, 21, 29, 23, 24, 31, 39, 33, 34, }, m2);
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntMatrix.replaceColumnData(int,
     * IntMatrix)'
     */
    @Test
    public void testReplaceColumnDataIntIntMatrix() {
        IntMatrix expect = null;
        IntMatrix m = new IntMatrix(3, 2, new int[] { 72, 73, 82, 83, 92, 93 });
            m2.replaceColumnData(1, m);
            expect = new IntMatrix(3, 4, new int[] { 11, 72, 73, 14, 21, 82,
                    83, 24, 31, 92, 93, 34, });
        IntMatrixTest.assertEquals("matrix as array", m2, expect);
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntMatrix.insertColumns(int, int)'
     */
    @Test
    public void testInsertColumns() {
        // inserts 3 empty columns
        m2.makeSpaceForNewColumns(1, 3);
        IntMatrix expect = new IntMatrix(3, 7, new int[] { 11, 0, 0, 0, 12, 13, 14,
                21, 0, 0, 0, 22, 23, 24, 31, 0, 0, 0, 32, 33, 34, });
        IntMatrixTest.assertEquals("matrix as array", m2, expect);
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntMatrix.insertColumnData(int,
     * IntArray)'
     */
    @Test
    public void testInsertColumnDataIntIntArray() {
        // inserts a column
        m2.insertColumnData(1, new IntArray(new int[] { 91, 92, 93 }));
        IntMatrix expect = new IntMatrix(3, 5, new int[] { 11, 12, 91, 13, 14, 21,
                    22, 92, 23, 24, 31, 32, 93, 33, 34, });
        IntMatrixTest.assertEquals("matrix as array", m2, expect);
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntMatrix.insertColumnData(int,
     * IntMatrix)'
     */
    @Test
    public void testInsertColumnDataIntIntMatrix() {
        logger.info("+++insertColumnData>>>");
        IntMatrix insert = new IntMatrix(3, 2, new int[] { 72, 73, 82, 83, 92, 93, });
        m2.insertColumnData(1, insert);
        IntMatrix expect = new IntMatrix(3, 6, new int[] { 11, 12, 72, 73, 13, 14,
                    21, 22, 82, 83, 23, 24, 31, 32, 92, 93, 33, 34, });
        IntMatrixTest.assertEquals("matrix as array", m2, expect);
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntMatrix.insertRows(int, int)'
     */
    @Test
    public void testInsertRows() {
        m2.insertRows(1, 2);
        int[] array = m2.getMatrixAsArray();
        IntTest.assertEquals("matrix as array", new int[] { 11, 12, 13, 14, 0,
                0, 0, 0, 0, 0, 0, 0, 21, 22, 23, 24, 31, 32, 33, 34, }, array);
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntMatrix.replaceRowData(int,
     * IntArray)'
     */
    @Test
    public void testReplaceRowDataIntIntArray() {
        m2.replaceRowData(1, new IntArray(new int[] { 71, 72, 73, 74 }));
        int[] array = m2.getMatrixAsArray();
        IntTest.assertEquals("matrix as array", new int[] { 11, 12, 13, 14, 71,
                72, 73, 74, 31, 32, 33, 34, }, array);
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntMatrix.replaceRowData(int, int[])'
     */
    @Test
    public void testReplaceRowDataIntIntegerArray() {
        m2.replaceRowData(1, new int[] { 71, 72, 73, 74 });
        int[] array = m2.getMatrixAsArray();
        IntTest.assertEquals("matrix as array", new int[] { 11, 12, 13, 14, 71,
                72, 73, 74, 31, 32, 33, 34, }, array);
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntMatrix.replaceRowData(int,
     * IntMatrix)'
     */
    @Test
    public void testReplaceRowDataIntIntMatrix() {
        logger.info("+++replaceRowData>>>");
        // FIXME
        IntMatrix insert = new IntMatrix(new IntMatrix(2, 4, new int[] { 71, 72, 73,
                    74, 81, 82, 83, 84, }));
        m2.replaceRowData(0, insert);
        IntMatrix expect = new IntMatrix(3, 4, new int[] { 11, 12, 13, 14, 71, 72,
                    73, 74, 81, 82, 83, 84, });
        // rows 2 and 3 are not filled
        IntMatrixTest.assertEquals("matrix as array", m2, expect);
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntMatrix.insertRowData(int,
     * IntMatrix)'
     */
    @Test
    public void testInsertRowDataIntIntMatrix() {
        // FIXME
        m2.insertRowData(1, new IntMatrix(2, 4, new int[] { 71, 72, 73, 74,
                    81, 82, 83, 84, }));
        IntMatrix expect = new IntMatrix(5, 4, new int[] { 11, 12, 13, 14, 21, 22,
                    23, 24, 71, 72, 73, 74, 81, 82, 83, 84, 31, 32, 33, 34, });
        IntTest.assertEquals("matrix as array", expect.getMatrixAsArray(), m2
                .getMatrixAsArray());
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntMatrix.insertRowData(int,
     * IntArray)'
     */
    @Test
    public void testInsertRowDataIntIntArray() {
        IntMatrixTest.assertEquals("matrix as array", 3, 4, new int[] { 11, 12,
                13, 14, 21, 22, 23, 24, 31, 32, 33, 34, }, m2);
        m2.insertRowData(1, new IntArray(new int[] { 71, 72, 73, 74, }));
        IntMatrixTest.assertEquals("matrix as array", 4, 4, new int[] { 11, 12,
                13, 14, 21, 22, 23, 24, 71, 72, 73, 74, 31, 32, 33, 34, }, m2);
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntMatrix.appendColumnData(IntArray)'
     */
    @Test
    public void testAppendColumnDataIntArray() {
        m2.appendColumnData(new IntArray(new int[] { 17, 27, 37, }));
        int[] array = m2.getMatrixAsArray();
        IntTest.assertEquals("matrix as array", new int[] { 11, 12, 13, 14, 17,
                21, 22, 23, 24, 27, 31, 32, 33, 34, 37 }, array);
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntMatrix.appendColumnData(IntMatrix)'
     */
    @Test
    public void testAppendColumnDataIntMatrix() {
        // logger.info("+++appendColumnData>>>");
        IntMatrix rm = new IntMatrix(3, 2, new int[] { 17, 18, 27, 28, 37, 38 });
        m2.appendColumnData(rm);
        IntMatrix expect = new IntMatrix(3, 6, new int[] { 11, 12, 13, 14, 17, 18,
                21, 22, 23, 24, 27, 28, 31, 32, 33, 34, 37, 38 });
        IntMatrixTest.assertEquals("matrix as array", m2, expect);
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntMatrix.appendRowData(IntArray)'
     */
    @Test
    public void testAppendRowDataIntArray() {
        IntArray ra = new IntArray(new int[] { 41, 42, 43, 44 });
        m2.appendRowData(ra);
        // fails to insert data
        IntMatrixTest.assertEquals("matrix as array", 4, 4, new int[] { 11, 12,
                13, 14, 21, 22, 23, 24, 31, 32, 33, 34, 41, 42, 43, 44 }, m2);
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntMatrix.appendRowData(IntMatrix)'
     */
    @Test
    public void testAppendRowDataIntMatrix() {
        logger.info("+++appendRowData>>>");
        // FIXME
        IntMatrix rm = new IntMatrix(2, 4,
                    new int[] { 41, 42, 43, 44, 51, 52, 53, 54 });
        m2.appendRowData(rm);
        IntMatrix expect = new IntMatrix(5, 4, new int[] { 11, 12, 13, 14, 21, 22,
                    23, 24, 31, 32, 33, 34, 41, 42, 43, 44, 51, 52, 53, 54 });
        IntMatrixTest.assertEquals("matrix as array", m2, expect);
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntMatrix.replaceSubMatrixData(int,
     * int, IntMatrix)'
     */
    @Test
    public void testReplaceSubMatrixData() {
        IntMatrix rm = new IntMatrix(2, 2, new int[] { 71, 72, 81, 82 });
        m2.replaceSubMatrixData(1, 1, rm);
        // fails to insert data
        IntMatrixTest.assertEquals("matrix as array", 3, 4, new int[] { 71, 72,
                13, 14, 81, 82, 23, 24, 31, 32, 33, 34, }, m2);
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntMatrix.reorderColumnsBy(IntSet)'
     */
    @Test
    public void testReorderColumnsBy() {
        IntMatrix mm = m2.reorderColumnsBy(new IntSet(new int[] { 3, 1, 2, 0 }));
        // fails to insert data
        IntMatrixTest.assertEquals("matrix as array", 3, 4, new int[] { 14, 12,
                13, 11, 24, 22, 23, 21, 34, 32, 33, 31 }, mm);
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntMatrix.reorderRowsBy(IntSet)'
     */
    @Test
    public void testReorderRowsBy() {
        IntMatrix mm = m2.reorderRowsBy(new IntSet(new int[] { 1, 2, 0 }));
        // fails to insert data
        IntMatrixTest.assertEquals("matrix as array", 3, 4, new int[] { 21, 22,
                23, 24, 31, 32, 33, 34, 11, 12, 13, 14, }, mm);
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntMatrix.extractSubMatrixData(int,
     * int, int, int)'
     */
    @Test
    public void testExtractSubMatrixData() {
        IntMatrix mm = m2.extractSubMatrixData(1, 2, 2, 3);
        IntMatrixTest.assertEquals("sub matrix", 2, 2, new int[] { 23, 24, 33,
                34 }, mm);
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntMatrix.elementsInRange(IntRange)'
     */
    @Test
    public void testElementsInRange() {
        IntMatrix im = m2.elementsInRange(new IntRange(13, 31));
        IntMatrixTest.assertEquals("sub matrix", 3, 4, new int[] { 0, 0, 1, 1,
                1, 1, 1, 1, 1, 0, 0, 0 }, im);
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntMatrix.writeXML(Writer)'
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
                        "<matrix rows='3' columns='4'>11 12 13 14 21 22 23 24 31 32 33 34</matrix>",
                        w.toString());
    }


}
