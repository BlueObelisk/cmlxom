package org.xmlcml.euclid.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.xmlcml.euclid.EuclidRuntimeException;
import org.xmlcml.euclid.IntArray;
import org.xmlcml.euclid.IntRange;
import org.xmlcml.euclid.IntSet;
import org.xmlcml.euclid.ArrayBase.Trim;

/**
 * test IntArray
 *
 * @author pmr
 *
 */
public class IntArrayTest extends EuclidTestBase {

    IntArray a0;

    IntArray a1;

    /**
     * setup.
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        super.setUp();
        a0 = new IntArray();
        a1 = new IntArray(new int[] { 1, 2, 4, 6 });
    }

    /**
     * equality test. true if both args not null and equal
     *
     * @param msg
     *            message
     * @param test
     * @param expected
     */
    public static void assertEquals(String msg, IntArray test, IntArray expected) {
        Assert.assertNotNull("test should not be null (" + msg + S_RBRAK, test);
        Assert.assertNotNull("expected should not be null (" + msg + S_RBRAK,
                expected);
        IntTest.assertEquals(msg, test.getArray(), expected.getArray());
    }

    /**
     * equality test. true if both args not null and equal
     *
     * @param msg
     *            message
     * @param test
     * @param expected
     */
    public static void assertEquals(String msg, int[] test, IntArray expected) {
        Assert.assertNotNull("test should not be null (" + msg + S_RBRAK, test);
        Assert.assertNotNull("expected should not be null (" + msg + S_RBRAK,
                expected);
        Assert.assertEquals("must be of equal length ", test.length, expected
                .getArray().length);
        IntTest.assertEquals(msg, test, expected.getArray());
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntArray.IntArray()'
     */
    @Test
    public void testIntArray() {
        Assert.assertEquals("empty", 0, a0.size());
        Assert.assertEquals("empty", "()", a0.toString());
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntArray.IntArray(int)'
     */
    @Test
    public void testIntArrayInt() {
        IntArray r = new IntArray(4);
        Assert.assertEquals("r", 4, r.size());
        IntArrayTest.assertEquals("r", new int[] { 0, 0, 0, 0 }, r);
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntArray.IntArray(int, int, int)'
     */
    @Test
    public void testIntArrayIntDoubleDouble() {
        IntArray r = new IntArray(4, 1, 2);
        Assert.assertEquals("r", 4, r.size());
        IntArrayTest.assertEquals("r", new int[] { 1, 3, 5, 7 }, r);
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntArray.IntArray(int, int)'
     */
    @Test
    public void testIntArrayIntDouble() {
        IntArray r = new IntArray(4, 2);
        Assert.assertEquals("r", 4, r.size());
        IntArrayTest.assertEquals("r", new int[] { 2, 2, 2, 2 }, r);
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntArray.IntArray(int, int[])'
     */
    @Test
    public void testIntArrayIntDoubleArray() {
        int[] d = { 1, 2, 3, 4 };
        IntArray r = new IntArray(3, d);
        Assert.assertEquals("r", 3, r.size());
        IntArrayTest.assertEquals("r", new int[] { 1, 2, 3 }, r);
        try {
            r = new IntArray(5, d);
            alwaysFail("Array size too small");
        } catch (EuclidRuntimeException e) {
            Assert.assertEquals("int[]", "Array would overflow", 
            		e.getMessage());
        }
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntArray.IntArray(int[])'
     */
    @Test
    public void testIntArrayDoubleArray() {
        int[] d = { 1, 2, 3, 4 };
        IntArray r = new IntArray(d);
        Assert.assertEquals("r", 4, r.size());
        IntArrayTest.assertEquals("r", new int[] { 1, 2, 3, 4 }, r);
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntArray.IntArray(IntArray, int, int)'
     */
    @Test
    public void testIntArrayIntArrayIntInt() {
        IntArray r = new IntArray(a1, 1, 2);
        Assert.assertEquals("r", 2, r.size());
        IntArrayTest.assertEquals("r", new int[] { 2, 4 }, r);
        try {
            r = new IntArray(a1, 0, 5);
        } catch (EuclidRuntimeException e) {
            Assert.assertEquals("int array", "index out of range: 0/5", e
                    .getMessage());
        }
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntArray.IntArray(IntArray, IntArray)'
     */
    @Test
    public void testIntArrayIntArrayIntArray() {
        IntArray r = new IntArray(a1, new IntArray(new int[] { 3, 1, 2 }));
        Assert.assertEquals("r", 3, r.size());
        IntArrayTest.assertEquals("r", new int[] { 6, 2, 4 }, r);
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntArray.IntArray(IntArray)'
     */
    @Test
    public void testIntArrayIntArray() {
        IntArray r = new IntArray(a1);
        Assert.assertEquals("r", 4, r.size());
        IntArrayTest.assertEquals("r", new int[] { 1, 2, 4, 6 }, r);
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntArray.IntArray(String[])'
     */
    @Test
    public void testIntArrayStringArray() {
        IntArray r = new IntArray(new String[] { "1", "2", "4", "6" });
        IntArrayTest.assertEquals("string array", a1, r);
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntArray.IntArray(String)'
     */
    @Test
    public void testIntArrayString() {
        IntArray r = new IntArray("1 2 4 6");
        IntArrayTest.assertEquals("string array", a1, r);
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntArray.elementAt(int)'
     */
    @Test
    public void testElementAt() {
        Assert.assertEquals("element at", 4, a1.elementAt(2));
        try {
            Assert.assertEquals("element at", 4, a1.elementAt(5));
            alwaysFail("ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException e) {
            Assert.assertEquals("ArrayIndexOutOfBoundsException", "5", e
                    .getMessage());
        }
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntArray.size()'
     */
    @Test
    public void testSize() {
        Assert.assertEquals("size", 0, a0.size());
        Assert.assertEquals("size", 4, a1.size());
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntArray.getArray()'
     */
    @Test
    public void testGetArray() {
        IntTest.assertEquals("array", new int[] {}, a0.getArray());
        IntTest.assertEquals("array", new int[] { 1, 2, 4, 6 }, a1.getArray());
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntArray.clearArray()'
     */
    @Test
    public void testClearArray() {
        a1.clearArray();
        IntArrayTest.assertEquals("clear", new int[] { 0, 0, 0, 0 }, a1);
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntArray.getReverseArray()'
     */
    @Test
    public void testGetReverseArray() {
        int[] d = a1.getReverseArray();
        IntTest.assertEquals("clear", new int[] { 6, 4, 2, 1 }, d);
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntArray.isEqualTo(IntArray)'
     */
    @Test
    public void testIsEqualTo() {
        IntArray a = new IntArray("1 2 4 6");
        Assert.assertTrue("isEqualTo", a1.isEqualTo(a));
        a = new IntArray("1 2 4");
        Assert.assertFalse("isEqualTo", a1.isEqualTo(a));
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntArray.equals(IntArray, int)'
     */
    @Test
    public void testEqualsIntArrayDouble() {
        IntArray a = new IntArray("1 2 4 6");
        Assert.assertTrue("isEqualTo", a1.equals(a));
        a = new IntArray("1 2 4 7");
        Assert.assertFalse("isEqualTo", a1.equals(a));
        a = new IntArray("1 2 4");
        Assert.assertFalse("isEqualTo", a1.equals(a));
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntArray.plus(IntArray)'
     */
    @Test
    public void testPlus() {
        IntArray a2 = a1.plus(new IntArray("10 20 30 40"));
        IntArrayTest.assertEquals("plus", new int[] { 11, 22, 34, 46 }, a2);
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntArray.subtract(IntArray)'
     */
    @Test
    public void testSubtract() {
        IntArray a2 = a1.subtract(new IntArray("10 20 30 40"));
        IntArrayTest.assertEquals("subtract", new int[] { -9, -18, -26, -34 },
                a2);
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntArray.subtractEquals(IntArray)'
     */
    @Test
    public void testSubtractEquals() {
        IntArray ia = new IntArray("10 20 30 40");
        a1.subtractEquals(ia);
        IntArrayTest.assertEquals("subtract", new int[] { -9, -18, -26, -34 },
                a1);
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntArray.negative()'
     */
    @Test
    public void testNegative() {
        a1.negative();
        IntArrayTest.assertEquals("negative", new int[] { -1, -2, -4, -6 }, a1);
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntArray.multiplyBy(int)'
     */
    @Test
    public void testMultiplyBy() {
        IntArray a = a1.multiplyBy(2);
        IntArrayTest.assertEquals("multiplyBy", new int[] { 2, 4, 8, 12 }, a);
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntArray.setElementAt(int, int)'
     */
    @Test
    public void testSetElementAt() {
        a1.setElementAt(2, 10);
        IntArrayTest.assertEquals("setElement", new int[] { 1, 2, 10, 6 }, a1);
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntArray.getSubArray(int, int)'
     */
    @Test
    public void testGetSubArray() {
        IntArray a = a1.getSubArray(2, 3);
        IntArrayTest.assertEquals("subArray", new int[] { 4, 6 }, a);
        a = a1.getSubArray(2, 2);
        IntArrayTest.assertEquals("subArray", new int[] { 4 }, a);
        a = a1.getSubArray(0, 3);
        IntArrayTest.assertEquals("subArray", new int[] { 1, 2, 4, 6 }, a);
        try {
            a = a1.getSubArray(0, 5);
            alwaysFail("ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException e) {
            Assert.assertEquals("subArray ArrayIndexOutOfBoundsException",
                    "java.lang.ArrayIndexOutOfBoundsException", S_EMPTY + e);
        }
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntArray.setElements(int, int[])'
     */
    @Test
    public void testSetElements() {
        a1.setElements(1, new int[] { 10, 20 });
        IntArrayTest.assertEquals("setElement", new int[] { 1, 10, 20, 6 }, a1);
        try {
            a1.setElements(1, new int[] { 10, 20, 30, 40 });
            alwaysFail("ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException e) {
            Assert.assertEquals("subArray ArrayIndexOutOfBoundsException",
                    "java.lang.ArrayIndexOutOfBoundsException", S_EMPTY + e);
        }
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntArray.isClear()'
     */
    @Test
    public void testIsClear() {
        Assert.assertFalse("isClear", a1.isClear());
        a1.clearArray();
        Assert.assertTrue("isClear", a1.isClear());
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntArray.setAllElements(int)'
     */
    @Test
    public void testSetAllElements() {
        a1.setAllElements(10);
        IntArrayTest.assertEquals("setElement", new int[] { 10, 10, 10, 10 },
                a1);
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntArray.sumAllElements()'
     */
    @Test
    public void testSumAllElements() {
        Assert.assertEquals("sum", 13, a1.sumAllElements());
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntArray.absSumAllElements()'
     */
    @Test
    public void testAbsSumAllElements() {
        IntArray a = new IntArray("-1 3 -11 14");
        Assert.assertEquals("sum", 5, a.sumAllElements());
        Assert.assertEquals("absSum", 29, a.absSumAllElements());
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntArray.innerProduct()'
     */
    @Test
    public void testInnerProduct() {
        Assert.assertEquals("inner", 57, a1.innerProduct());
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntArray.dotProduct(IntArray)'
     */
    @Test
    public void testDotProduct() {
        IntArray a = new IntArray("1 2 3 4");
        int d = a1.dotProduct(a);
        Assert.assertEquals("dot", 41, d);
        a = new IntArray("1 2 3");
        try {
            a1.dotProduct(a);
            alwaysFail("ArrayIndexOutOfBoundsException");
        } catch (EuclidRuntimeException e) {
            Assert.assertEquals("dot", "org.xmlcml.euclid.EuclidRuntimeException", S_EMPTY
                    + e);
        }
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntArray.cumulativeSum()'
     */
    @Test
    public void testCumulativeSum() {
        IntArray a = a1.cumulativeSum();
        IntArrayTest.assertEquals("cumulative", new int[] { 1, 3, 7, 13 }, a);
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntArray.trim(int, int)'
     */
    @Test
    public void testTrim() {
        IntArray a = new IntArray("1 2 3 4 1 3 5 1 3");
        IntArray b = a.trim(Trim.ABOVE, 2);
        int[] d = { 1, 2, 2, 2, 1, 2, 2, 1, 2 };
        IntArrayTest.assertEquals("trim", d, b);
        b = a.trim(Trim.BELOW, 2);
        int[] dd = { 2, 2, 3, 4, 2, 3, 5, 2, 3 };
        IntArrayTest.assertEquals("trim", dd, b);
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntArray.indexOfLargestElement()'
     */
    @Test
    public void testIndexOfLargestElement() {
        Assert.assertEquals("largest", 3, a1.indexOfLargestElement());
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntArray.indexOfSmallestElement()'
     */
    @Test
    public void testIndexOfSmallestElement() {
        Assert.assertEquals("smallest", 0, a1.indexOfSmallestElement());
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntArray.largestElement()'
     */
    @Test
    public void testLargestElement() {
        Assert.assertEquals("largest", 6, a1.largestElement());
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntArray.getMax()'
     */
    @Test
    public void testGetMax() {
        Assert.assertEquals("max", 6, a1.getMax());
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntArray.smallestElement()'
     */
    @Test
    public void testSmallestElement() {
        Assert.assertEquals("smallest", 1, a1.smallestElement());
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntArray.getMin()'
     */
    @Test
    public void testGetMin() {
        Assert.assertEquals("max", 1, a1.getMin());
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntArray.getRange()'
     */
    @Test
    public void testGetRange() {
        IntRange range = a1.getRange();
        Assert.assertEquals("range", 1, range.getMin());
        Assert.assertEquals("range", 6, range.getMax());
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntArray.deleteElement(int)'
     */
    @Test
    public void testDeleteElement() {
        a1.deleteElement(2);
        IntArrayTest.assertEquals("delete", new int[] { 1, 2, 6 }, a1);
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntArray.deleteElements(int, int)'
     */
    @Test
    public void testDeleteElementsIntInt() {
        IntArray a = new IntArray(a1);
        a.deleteElements(1, 2);
        IntArrayTest.assertEquals("delete", new int[] { 1, 6 }, a);
        a = new IntArray(a1);
        a.deleteElements(0, 3);
        IntArrayTest.assertEquals("delete", new int[] {}, a);
        a = new IntArray(a1);
        a.deleteElements(2, 2);
        IntArrayTest.assertEquals("delete", new int[] { 1, 2, 6 }, a);
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntArray.insertElementAt(int, int)'
     */
    @Test
    public void testInsertElementAt() {
        IntArray a = new IntArray(a1);
        a.insertElementAt(1, 30);
        IntArrayTest.assertEquals("insert", new int[] { 1, 30, 2, 4, 6 }, a);
        a.insertElementAt(0, 20);
        IntArrayTest
                .assertEquals("insert", new int[] { 20, 1, 30, 2, 4, 6 }, a);
        a.insertElementAt(6, 10);
        IntArrayTest.assertEquals("insert",
                new int[] { 20, 1, 30, 2, 4, 6, 10 }, a);
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntArray.insertArray(int, IntArray)'
     */
    @Test
    public void testInsertArray() {
        a1.insertArray(1, new IntArray("44 55"));
        IntArrayTest.assertEquals("insert", new int[] { 1, 44, 55, 2, 4, 6 },
                a1);
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntArray.addElement(int)'
     */
    @Test
    public void testAddElement() {
        a1.addElement(30);
        IntArrayTest.assertEquals("insert", new int[] { 1, 2, 4, 6, 30 }, a1);
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntArray.addArray(IntArray)'
     */
    @Test
    public void testAddArray() {
        a1.addArray(new IntArray("5 16 7"));
        IntArrayTest.assertEquals("insert", new int[] { 1, 2, 4, 6, 5, 16, 7 },
                a1);
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntArray.getReorderedArray(IntSet)'
     */
    @Test
    public void testGetReorderedArray() {
        IntSet intSet = new IntSet(new int[] { 3, 1, 0, 2 });
        IntArray a = a1.getReorderedArray(intSet);
        IntArrayTest.assertEquals("insert", new int[] { 6, 2, 1, 4 }, a);
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntArray.inRange(IntRange)'
     */
    @Test
    public void testInRange() {
        IntRange range = new IntRange(1, 5);
        IntSet intSet = a1.inRange(range);
        IntArray intArray = intSet.getIntArray();
        IntArrayTest.assertEquals("inrange", new int[] { 0, 1, 2 }, intArray);
        intSet = a1.inRange(new IntRange(-3, 7));
        IntArrayTest.assertEquals("inrange", new int[] { 0, 1, 2, 3 }, intSet
                .getIntArray());
        intSet = a1.inRange(new IntRange(5, 5));
        IntArrayTest
                .assertEquals("inrange", new int[] {}, intSet.getIntArray());
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntArray.outOfRange(IntRange)'
     */
    @Test
    public void testOutOfRange() {
        IntRange range = new IntRange(1, 5);
        IntSet intSet = a1.outOfRange(range);
        IntArray intArray = intSet.getIntArray();
        IntArrayTest.assertEquals("inrange", new int[] { 3 }, intArray);
        intSet = a1.outOfRange(new IntRange(-3, 7));
        IntArrayTest
                .assertEquals("inrange", new int[] {}, intSet.getIntArray());
        intSet = a1.outOfRange(new IntRange(4, 6));
        IntArrayTest.assertEquals("inrange", new int[] { 0, 1 }, intSet
                .getIntArray());
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntArray.getStringValues()'
     */
    @Test
    public void testGetStringValues() {
        String[] ss = a1.getStringValues();
        StringTestBase.assertEquals("string values", new String[] { "1", "2", "4",
                "6" }, ss);
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntArray.sortAscending()'
     */
    @Test
    public void testSortAscending() {
        IntArray ra = new IntArray("1 6 3 9 2 0");
        ra.sortAscending();
        IntArrayTest.assertEquals("sortAscending",
                new int[] { 0, 1, 2, 3, 6, 9 }, ra);
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntArray.sortDescending()'
     */
    @Test
    public void testSortDescending() {
        IntArray ra = new IntArray("1 6 3 9 2 0");
        ra.sortDescending();
        IntArrayTest.assertEquals("sortDescending", new int[] { 9, 6, 3, 2, 1,
                0 }, ra);
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntArray.reverse()'
     */
    @Test
    public void testReverse() {
        IntArray ra = new IntArray("1 6 3 9 2 0");
        ra.reverse();
        IntArrayTest
                .assertEquals("reverse", new int[] { 0, 2, 9, 3, 6, 1 }, ra);
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntArray.indexSortAscending()'
     */
    @Test
    public void testIndexSortAscending() {
        IntArray ra = new IntArray("1 6 3 9 2 0");
        IntSet intSet = ra.indexSortAscending();
        IntArrayTest.assertEquals("sortAscending",
                new int[] { 5, 0, 4, 2, 1, 3 }, intSet.getIntArray());
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntArray.indexSortDescending()'
     */
    @Test
    public void testIndexSortDescending() {
        IntArray ra = new IntArray("1 6 3 9 2 0");
        IntSet intSet = ra.indexSortDescending();
        IntArrayTest.assertEquals("sortDescending", new int[] { 3, 1, 2, 4, 0,
                5 }, intSet.getIntArray());
    }


}
