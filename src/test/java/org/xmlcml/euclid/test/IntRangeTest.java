package org.xmlcml.euclid.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.xmlcml.euclid.IntRange;

/**
 * test IntRange
 *
 * @author pmr
 *
 */
public class IntRangeTest extends EuclidTestBase {

    IntRange i0;

    IntRange i1;

    IntRange i2;

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
        super.setUp();
        i0 = new IntRange();
        i1 = new IntRange(1, 1);
        i2 = new IntRange(1, 3);
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntRange.IntRange()'
     */
    @Test
    public void testIntRange() {
        Assert.assertEquals("empty", "NULL", i0.toString());
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntRange.IntRange(int, int)'
     */
    @Test
    public void testIntRangeIntInt() {
        Assert.assertEquals("i1", "(1,1)", i1.toString());
        Assert.assertEquals("i2", "(1,3)", i2.toString());

    }

    /**
     * Test method for 'org.xmlcml.euclid.IntRange.IntRange(IntRange)'
     */
    @Test
    public void testIntRangeIntRange() {
        IntRange ii = new IntRange(i2);
        Assert.assertEquals("ii", "(1,3)", ii.toString());
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntRange.isValid()'
     */
    @Test
    public void testIsValid() {
        Assert.assertTrue("valid", i2.isValid());
        Assert.assertFalse("invalid", i0.isValid());
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntRange.isEqualTo(IntRange)'
     */
    @Test
    public void testIsEqualTo() {
        Assert.assertTrue("equal", i2.isEqualTo(i2));
        Assert.assertFalse("equal", i2.isEqualTo(i0));
        Assert.assertFalse("equal", i0.isEqualTo(i0));
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntRange.plus(IntRange)'
     */
    @Test
    public void testPlus() {
        IntRange ix = new IntRange(1, 4);
        IntRange iy = new IntRange(2, 3);
        IntRange ii = ix.plus(iy);
        Assert.assertEquals("ii", "(1,4)", ii.toString());
        iy = new IntRange(0, 2);
        ii = ix.plus(iy);
        Assert.assertEquals("ii", "(0,4)", ii.toString());
        iy = new IntRange(2, 6);
        ii = ix.plus(iy);
        Assert.assertEquals("ii", "(1,6)", ii.toString());
        iy = new IntRange();
        ii = ix.plus(iy);
        Assert.assertEquals("ii", "(1,4)", ii.toString());
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntRange.intersectionWith(IntRange)'
     */
    @Test
    public void testIntersectionWith() {
        IntRange ix = new IntRange(1, 4);
        IntRange iy = new IntRange(2, 3);
        IntRange ii = ix.intersectionWith(iy);
        Assert.assertEquals("ii", "(2,3)", ii.toString());
        iy = new IntRange(0, 2);
        ii = ix.intersectionWith(iy);
        Assert.assertEquals("ii", "(1,2)", ii.toString());
        iy = new IntRange(2, 6);
        ii = ix.intersectionWith(iy);
        Assert.assertEquals("ii", "(2,4)", ii.toString());
        iy = new IntRange();
        ii = ix.intersectionWith(iy);
        Assert.assertEquals("ii", "NULL", ii.toString());
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntRange.getMin()'
     */
    @Test
    public void testGetMin() {
        Assert.assertEquals("min", 1, i2.getMin());
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntRange.getMax()'
     */
    @Test
    public void testGetMax() {
        Assert.assertEquals("max", 3, i2.getMax());
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntRange.getRange()'
     */
    @Test
    public void testGetRange() {
        Assert.assertEquals("range", 2, i2.getRange());
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntRange.includes(IntRange)'
     */
    @Test
    public void testIncludesIntRange() {
        Assert.assertTrue("includes", i2.includes(new IntRange(2, 3)));
        Assert.assertFalse("includes", i2.includes(new IntRange(0, 3)));
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntRange.includes(int)'
     */
    @Test
    public void testIncludesInt() {
        Assert.assertTrue("includes", i2.includes(1));
        Assert.assertFalse("includes", i2.includes(0));
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntRange.contains(int)'
     */
    @Test
    public void testContains() {
        Assert.assertTrue("contains", i2.contains(1));
        Assert.assertFalse("contains", i2.contains(0));
    }

    /**
     * Test method for 'org.xmlcml.euclid.IntRange.add(int)'
     */
    @Test
    public void testAdd() {
        i2.add(2);
        Assert.assertEquals("ii", "(1,3)", i2.toString());
        i2.add(0);
        Assert.assertEquals("ii", "(0,3)", i2.toString());
        i2.add(9);
        Assert.assertEquals("ii", "(0,9)", i2.toString());
    }


}
