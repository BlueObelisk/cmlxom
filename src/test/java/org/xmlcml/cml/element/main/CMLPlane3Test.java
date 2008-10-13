package org.xmlcml.cml.element.main;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.xmlcml.euclid.Plane3;
import org.xmlcml.euclid.Util;
import org.xmlcml.euclid.test.DoubleTestBase;
import org.xmlcml.euclid.test.Plane3Test;

/**
 * test CMLPlane3
 *
 * @author pmr
 *
 */
public class CMLPlane3Test extends GeomTestBase {

    /**
     * setup.
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        super.setUp();
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
    public static void assertEquals(String msg, CMLPlane3 test,
            CMLPlane3 expected, double epsilon) {
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
            CMLPlane3 expected, double epsilon) {
        Assert.assertNotNull("test should not be null (" + msg + S_RBRAK, test);
        Assert.assertEquals("must be of length 4", 4, test.length);
        Assert.assertNotNull("expected should not be null (" + msg + S_RBRAK,
                expected);
        DoubleTestBase.assertEquals(msg, test, expected.getArray(), epsilon);
    }

    /**
     * Test method for 'org.xmlcml.cml.element.CMLPlane3.CMLPlane3()'
     */
    @Test
    public void testCMLPlane3() {
        // CMLPlane3 pl = new CMLPlane3(); // not visible

    }

    /**
     * Test method for 'org.xmlcml.cml.element.CMLPlane3.CMLPlane3(CMLPlane3)'
     */
    @Test
    public void testCMLPlane3CMLPlane3() {
        CMLPlane3 p = new CMLPlane3(this.xomPl1002);
        CMLPlane3Test.assertEquals("copy", new double[] { 1., 0., 0., 2. }, p,
                EPS);
    }

    /**
     * Test method for 'org.xmlcml.cml.element.CMLPlane3.CMLPlane3(double[])'
     */
    @Test
    public void testCMLPlane3DoubleArray() {
        CMLPlane3 p = null;
        try {
            p = new CMLPlane3(new double[] { 1., 2., 3., 4. });
        } catch (Exception e) {
            neverThrow(e);
        }
        double x = Math.sqrt(14.);
        CMLPlane3Test.assertEquals("copy", new double[] { 1. / x, 2. / x,
                3. / x, 4 }, p, EPS);
        try {
            p = new CMLPlane3(new double[] { 1., 2., 3. });
        } catch (Exception e) {
            Assert.assertEquals(
                "bad length",
                "array size required (4) found 3",
                e.getMessage());
        }
        try {
            p = new CMLPlane3(new double[] { 0., 0., 0., 1. });
        } catch (Exception e) {
            Assert.assertEquals("bad vector",
                    "Cannot make plane with zero vector", e.getMessage());
        }
    }

    /**
     * Test method for 'org.xmlcml.cml.element.CMLPlane3.CMLPlane3(double[],
     * double)'
     */
    @Test
    public void testCMLPlane3DoubleArrayDouble() {
        double norm = Math.sqrt(14.);
        CMLPlane3 p = new CMLPlane3(new double[] { 1., 2., 3. }, 10.);
        CMLPlane3Test.assertEquals("new", new double[] { 1. / norm, 2. / norm,
                3. / norm, 10 }, p, EPS);
        try {
            p = new CMLPlane3(new double[] { 1., 2. }, 20.);
        } catch (Exception e) {
            Assert.assertEquals(
                "bad length",
                "org.xmlcml.euclid.EuclidRuntimeException: array size required (3) found 2",
                e.getMessage());
        }
    }

    /**
     * Test method for 'org.xmlcml.cml.element.CMLPlane3.CMLPlane3(CMLVector3,
     * double)'
     */
    @Test
    public void testCMLPlane3CMLVector3Double() {
        double norm = Math.sqrt(14.);
        CMLPlane3 p = null;
        try {
            p = new CMLPlane3(new CMLVector3(new double[] { 1., 2., 3. }), 10.);
        } catch (RuntimeException e) {
            Util.BUG(e);
        }
        CMLPlane3Test.assertEquals("new", new double[] { 1. / norm, 2. / norm,
                3. / norm, 10 }, p, EPS);
    }

    /**
     * Test method for 'org.xmlcml.cml.element.CMLPlane3.CMLPlane3(CMLPoint3,
     * CMLPoint3, CMLPoint3)'
     */
    @Test
    public void testCMLPlane3CMLPoint3CMLPoint3CMLPoint3() {
        double norm = Math.sqrt(3.);
        CMLPlane3 p = new CMLPlane3(xomP100, xomP010, xomP001);
        CMLPlane3Test.assertEquals("new", new double[] { 1. / norm, 1. / norm,
                1. / norm, Math.sqrt(1. / 3.) }, p, EPS);
    }

    /**
     * Test method for 'org.xmlcml.cml.element.CMLPlane3.CMLPlane3(CMLLine3,
     * CMLPoint3)'
     */
    @Test
    public void testCMLPlane3CMLLine3CMLPoint3() {
        CMLPlane3 p = null;
        p = new CMLPlane3(xomL220011, xomP001);
        CMLPlane3Test.assertEquals("new",
                new double[] { 0.0, 0.0, -1.0, -1.0 }, p, EPS);
    }

    /**
     * Test method for 'org.xmlcml.cml.element.CMLPlane3.setArray(double[])'
     */
    @Test
    public void testSetArray() {
        try {
            xomPl1002.setArray(new double[] { 1., 2., 3., 4. });
        } catch (Exception e) {
            neverThrow(e);
        }
        double x = Math.sqrt(14.);
        CMLPlane3Test.assertEquals("new", new double[] { 1. / x, 2. / x,
                3. / x, 4. }, xomPl1002, EPS);
    }

    /**
     * Test method for 'org.xmlcml.cml.element.CMLPlane3.getArray()'
     */
    @Test
    public void testGetArray() {
        double x = Math.sqrt(1. / 3.);
        double[] array = xomPl1115.getArray();
        DoubleTestBase
                .assertEquals("get", new double[] { x, x, x, 5. }, array, EPS);

    }

    /**
     * Test method for 'org.xmlcml.cml.element.CMLPlane3.getVector()'
     */
    @Test
    public void testGetVector() {
        double x = Math.sqrt(1. / 3.);
        CMLVector3 v = xomPl1115.getVector();
        CMLVector3Test.assertEquals("get", new double[] { x, x, x }, v, EPS);
    }

    /**
     * Test method for 'org.xmlcml.cml.element.CMLPlane3.getDistance()'
     */
    @Test
    public void testGetDistance() {
        // double x = Math.sqrt(1./3.);
        double d = xomPl1115.getDistance();
        Assert.assertEquals("get", 5., d, EPS);
    }

    /**
     * Test method for 'org.xmlcml.cml.element.CMLPlane3.negative()'
     */
    @Test
    public void testNegative() {
        double x = -Math.sqrt(1. / 3.);
        xomPl1115.negative();
        CMLPlane3Test.assertEquals("get", new double[] { x, x, x, 5. },
                xomPl1115, EPS);
    }

    /**
     * Test method for 'org.xmlcml.cml.element.CMLPlane3.equals(CMLPlane3)'
     */
    @Test
    public void testEqualsCMLPlane3() {
        Assert.assertTrue("equal", xomPl1115.isEqualTo(xomPl1115));
        Assert.assertFalse("equal", xomPl1002.isEqualTo(xomPl1115));
    }

    /**
     * Test method for 'org.xmlcml.cml.element.CMLPlane3.subtract()'
     */
    @Test
    public void testSubtract() {
        double x = -Math.sqrt(1. / 3.);
        CMLPlane3 p = xomPl1115.subtract();
        CMLPlane3Test.assertEquals("subtract", new double[] { x, x, x, 5. }, p,
                EPS);
    }

    /**
     * Test method for
     * 'org.xmlcml.cml.element.CMLPlane3.getDistanceFromPoint(CMLPoint3)'
     */
    @Test
    public void testGetDistanceFromPoint() {
        Assert.assertEquals("distance", -2.,
                xomPl1002.getDistanceFromPoint(new CMLPoint3(new double[] { 0.,
                        0., 0. })), EPS);

    }

    /**
     * Test method for
     * 'org.xmlcml.cml.element.CMLPlane3.isParallelTo(CMLPlane3)'
     */
    @Test
    public void testIsParallelTo() {
        Assert.assertTrue("parallel", xomPl1115.isParallelTo(xomPl1115));
        Assert.assertFalse("parallel", xomPl1115.isParallelTo(xomPl1002));
        Assert.assertFalse("parallel", xomPl1115.isParallelTo(xomPl1115
                .subtract()));
    }

    /**
     * Test method for
     * 'org.xmlcml.cml.element.CMLPlane3.isAntiparallelTo(CMLPlane3)'
     */
    @Test
    public void testIsAntiparallelTo() {
        Assert.assertTrue("parallel", xomPl1115.isAntiparallelTo(xomPl1115
                .subtract()));
        Assert.assertFalse("parallel", xomPl1115.isAntiparallelTo(xomPl1115));
        Assert.assertFalse("parallel", xomPl1115.isAntiparallelTo(xomPl1002));
    }

    /**
     * Test method for
     * 'org.xmlcml.cml.element.CMLPlane3.containsPoint(CMLPoint3)'
     */
    @Test
    public void testContainsPoint() {
        double x = Math.sqrt(1. / 3.) * 5.;
        CMLPoint3 p = new CMLPoint3(new double[] { x, x, x });
        Assert.assertTrue("contains", xomPl1115.containsPoint(p));
    }

    /**
     * Test method for
     * 'org.xmlcml.cml.element.CMLPlane3.getClosestPointTo(CMLPoint3)'
     */
    @Test
    public void testGetClosestPointTo() {
        double x = Math.sqrt(1. / 3.) * 5.;
        CMLPoint3 pp = new CMLPoint3(new double[] { x, x, x });
        CMLPoint3 zz = xomPl1115.getClosestPointTo(pp);
        Assert.assertEquals("closest", 0.0, pp.getDistanceFromPoint(zz), EPS);
        CMLPoint3 ppp = new CMLPoint3(new double[] { 2 * x, 2 * x, 2 * x });
        zz = xomPl1115.getClosestPointTo(ppp);
        double xx = 5. * Math.sqrt(1. / 3.);
        CMLPoint3Test.assertEquals("closest", new double[] { xx, xx, xx }, zz,
                .000000001);
        Assert.assertEquals("closest", 5., ppp.getDistanceFromPoint(zz),
                .000000001);
    }

    /**
     * Test method for
     * 'org.xmlcml.cml.element.CMLPlane3.getIntersectionWith(CMLLine3)'
     */
    @Test
    public void testGetIntersectionWithCMLLine3() {
        CMLPoint3 p = xomPl1115.getIntersectionWith(xomL220011);
        Assert.assertTrue("intersection", p.isOnLine(xomL220011));
        Assert.assertTrue("intersection", p.isOnPlane(xomPl1115));
    }

    /**
     * Test method for
     * 'org.xmlcml.cml.element.CMLPlane3.getIntersectionWith(CMLPlane3)'
     */
    @Test
    public void testGetIntersectionWithCMLPlane3() {
        CMLLine3 l = xomPl1115.getIntersectionWith(xomPl1002);
        CMLPoint3 p = new CMLPoint3(l.getPoint3());
        Assert.assertTrue("intersection", p.isOnPlane(xomPl1115));
        Assert.assertTrue("intersection", p.isOnPlane(xomPl1002));

    }

    /**
     * Test method for
     * 'org.xmlcml.cml.element.CMLPlane3.getIntersectionWith(CMLPlane3,
     * CMLPlane3)'
     */
    @Test
    public void testGetIntersectionWithCMLPlane3CMLPlane3() {
        CMLPoint3 p = xomPl1115.getIntersectionWith(xomPl1002, xomPl0100);
        // these seem to work!
        Assert.assertTrue("intersection", p.isOnPlane(xomPl1002));
        Assert.assertTrue("intersection", p.isOnPlane(xomPl1115));
        Assert.assertTrue("intersection", p.isOnPlane(xomPl0100));

    }

    /**
     * Test method for
     * 'org.xmlcml.cml.element.CMLPlane3.getAngleMadeWith(CMLPlane3)'
     */
    @Test
    public void testGetAngleMadeWith() {
        double a = xomPl1115.getAngleMadeWith(xomPl0100);
        double x = Math.acos(1. / Math.sqrt(3.));
        Assert.assertEquals("angle", x, a, EPS);
    }

    /**
     * Test method for 'org.xmlcml.cml.element.CMLPlane3.copy()'
     */
    @Test
    public void testCopy() {
        CMLPlane3 p = new CMLPlane3(new CMLVector3(1., 2., 3.), 4.);
        CMLPlane3 pp = new CMLPlane3(p);
        CMLPlane3Test.assertEquals("copy", pp, p, EPS);
    }

    /**
     * Test method for 'org.xmlcml.cml.element.CMLPlane3.CMLPlane3(Plane3)'
     */
    @Test
    public void testCMLPlane3Plane3() {
        CMLPlane3 p = new CMLPlane3(new CMLVector3(1., 2., 3.), 4.);
        CMLPlane3 pp = new CMLPlane3(new Plane3(1., 2., 3., 4.));
        CMLPlane3Test.assertEquals("constructor", pp, p, EPS);
    }

    /**
     * Test method for 'org.xmlcml.cml.element.CMLPlane3.getEuclidPlane3()'
     */
    @Test
    public void testGetEuclidPlane3() {
        CMLPlane3 p = new CMLPlane3(new CMLVector3(1., 2., 3.), 4.);
        Plane3 pp = p.getEuclidPlane3();
        double d = Math.sqrt(14.);
        Plane3Test.assertEquals(
                "getEuclidPlane", new double[]{1./d, 2./d, 3./d, 4.}, pp, EPS);
    }

    /**
     * Test method for 'org.xmlcml.cml.element.CMLPlane3.isEqualTo(CMLPlane3)'
     */
    @Test
    public void testIsEqualTo() {
        CMLPlane3 p = new CMLPlane3(new CMLVector3(1., 2., 3.), 4.);
        CMLPlane3 pp = new CMLPlane3(p);
        Assert.assertTrue("isEqual", p.isEqualTo(pp));
    }

 }
