package org.xmlcml.euclid.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.xmlcml.euclid.Real2;
import org.xmlcml.euclid.Real2Range;
import org.xmlcml.euclid.RealRange;

/**
 * test Real2Range.
 *
 * @author pmr
 *
 */
public class Real2RangeTest extends EuclidTestBase {

    Real2Range i2r0;

    Real2Range i2r1;

    Real2Range i2r2;

    /**
     * setup.
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        super.setUp();
        i2r0 = new Real2Range();
        i2r1 = new Real2Range(new RealRange(1.0, 2.0), new RealRange(1.0, 2.0));
        i2r2 = new Real2Range(new RealRange(1.0, 2.0), new RealRange(3.0, 4.0));
    }

    /**
     * Test method for 'org.xmlcml.euclid.Real2Range.Real2Range()'
     */
    @Test
    public void testReal2Range() {
        Assert.assertEquals("empty", "(NULL,NULL)", i2r0.toString());
    }

    /**
     * Test method for 'org.xmlcml.euclid.Real2Range.Real2Range(RealRange,
     * RealRange)'
     */
    @Test
    public void testReal2RangeRealRangeRealRange() {
        Assert.assertEquals("real range", "((1.0,2.0),(3.0,4.0))", i2r2
                .toString());
    }

    /**
     * Test method for 'org.xmlcml.euclid.Real2Range.Real2Range(Real2Range)'
     */
    @Test
    public void testReal2RangeReal2Range() {
        Real2Range ii = new Real2Range(i2r2);
        Assert.assertEquals("empty", "((1.0,2.0),(3.0,4.0))", ii.toString());
    }

    /**
     * Test method for 'org.xmlcml.euclid.Real2Range.isValid()'
     */
    @Test
    public void testIsValid() {
        Assert.assertTrue("valid", i2r2.isValid());
        Assert.assertFalse("invalid", i2r0.isValid());
    }

    /**
     * Test method for 'org.xmlcml.euclid.Real2Range.isEqualTo(Real2Range)'
     */
    @Test
    public void testIsEqualTo() {
        Assert.assertTrue("isEqual", i2r2.isEqualTo(i2r2));
        Assert.assertFalse("isEqual", i2r2.isEqualTo(i2r1));
        Assert.assertFalse("isEqual", i2r0.isEqualTo(i2r0));
    }

    /**
     * Test method for 'org.xmlcml.euclid.Real2Range.plus(Real2Range)'
     */
    @Test
    public void testPlus() {
        Real2Range ix = new Real2Range(new RealRange(1.0, 4.0), new RealRange(
                11.0, 14.0));
        Real2Range iy = new Real2Range(new RealRange(2.0, 5.0), new RealRange(
                12.0, 15.0));
        Real2Range ii = ix.plus(iy);
        Assert.assertEquals("plus", "((1.0,5.0),(11.0,15.0))", ii.toString());
        iy = new Real2Range(new RealRange(2.0, 3.0), new RealRange(12.0, 13.0));
        ii = ix.plus(iy);
        Assert.assertEquals("plus", "((1.0,4.0),(11.0,14.0))", ii.toString());
        iy = new Real2Range(new RealRange(0.0, 8.0), new RealRange(10.0, 18.0));
        ii = ix.plus(iy);
        Assert.assertEquals("plus", "((0.0,8.0),(10.0,18.0))", ii.toString());
    }

    /**
     * Test method for
     * 'org.xmlcml.euclid.Real2Range.doubleersectionWith(Real2Range)'
     */
    @Test
    public void testIntersectionWith() {
        Real2Range ix = new Real2Range(new RealRange(1.0, 4.0), new RealRange(
                11.0, 14.0));
        Real2Range iy = new Real2Range(new RealRange(2.0, 5.0), new RealRange(
                12.0, 15.0));
        Real2Range ii = ix.intersectionWith(iy);
        Assert.assertEquals("plus", "((2.0,4.0),(12.0,14.0))", ii.toString());
        iy = new Real2Range(new RealRange(2.0, 3.0), new RealRange(12.0, 13.0));
        ii = ix.intersectionWith(iy);
        Assert.assertEquals("plus", "((2.0,3.0),(12.0,13.0))", ii.toString());
        iy = new Real2Range(new RealRange(0.0, 8.0), new RealRange(10.0, 18.0));
        ii = ix.intersectionWith(iy);
        Assert.assertEquals("plus", "((1.0,4.0),(11.0,14.0))", ii.toString());
    }

    /**
     * Test method for 'org.xmlcml.euclid.Real2Range.getXRange()'
     */
    @Test
    public void testGetXRange() {
        Assert.assertNull("getXRange", i2r0.getXRange());
        Assert.assertEquals("getXRange", "(1.0,2.0)", i2r2.getXRange()
                .toString());
    }

    /**
     * Test method for 'org.xmlcml.euclid.Real2Range.getYRange()'
     */
    @Test
    public void testGetYRange() {
        Assert.assertNull("getXRange", i2r0.getYRange());
        Assert.assertEquals("getXRange", "(3.0,4.0)", i2r2.getYRange()
                .toString());
    }

    /**
     * Test method for 'org.xmlcml.euclid.Real2Range.includes(Real2)'
     */
    @Test
    public void testIncludesReal2() {
        Real2Range ix = new Real2Range(new RealRange(1.0, 4.0), new RealRange(
                11.0, 14.0));
        Assert.assertTrue("include", ix.includes(new Real2(2.0, 12.0)));
        Assert.assertTrue("include", ix.includes(new Real2(1.0, 11.0)));
        Assert.assertTrue("include", ix.includes(new Real2(4.0, 14.0)));
        Assert.assertFalse("include", ix.includes(new Real2(1.0, 15.0)));
    }

    /**
     * Test method for 'org.xmlcml.euclid.Real2Range.includes(Real2Range)'
     */
    @Test
    public void testIncludesReal2Range() {
        Real2Range ix = new Real2Range(new RealRange(1.0, 4.0), new RealRange(
                11.0, 14.0));
        Assert.assertTrue("include", ix.includes(new Real2Range(new RealRange(
                2.0, 3.0), new RealRange(12.0, 13.0))));
        Assert.assertTrue("include", ix.includes(new Real2Range(new RealRange(
                1.0, 4.0), new RealRange(11.0, 14.0))));
        Assert.assertFalse("include", ix.includes(new Real2Range(new RealRange(
                0.0, 4.0), new RealRange(10.0, 14.0))));
        Assert.assertFalse("include", ix.includes(new Real2Range(new RealRange(
                2.0, 5.0), new RealRange(12.0, 15.0))));
    }

    /**
     * Test method for 'org.xmlcml.euclid.Real2Range.add(Real2)'
     */
    @Test
    public void testAdd() {
        Real2Range ii = new Real2Range(new RealRange(1.0, 4.0), new RealRange(
                11.0, 14.0));
        Assert.assertEquals("plus", "((1.0,4.0),(11.0,14.0))", ii.toString());
        Real2 i2 = new Real2(2.0, 12.0);
        ii.add(i2);
        Assert.assertEquals("plus", "((1.0,4.0),(11.0,14.0))", ii.toString());
        i2 = new Real2(0.0, 15.0);
        ii.add(i2);
        Assert.assertEquals("plus", "((0.0,4.0),(11.0,15.0))", ii.toString());
        i2 = new Real2(8.0, 7.0);
        ii.add(i2);
        Assert.assertEquals("plus", "((0.0,8.0),(7.0,15.0))", ii.toString());
    }


}
