package org.xmlcml.euclid.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.xmlcml.euclid.Angle;
import org.xmlcml.euclid.Real2;
import org.xmlcml.euclid.Vector2;

/**
 * tests for Vector2.
 *
 * @author pmr
 *
 */
public class Vector2Test extends EuclidTestBase {

    Vector2 v0;

    Vector2 v1;

    /**
     * setup.
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        super.setUp();
        v0 = new Vector2(new Real2(3., 4.));
        v1 = new Vector2(1., 2.);
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
    public static void assertEquals(String msg, Vector2 test, Vector2 expected,
            double epsilon) {
        Assert.assertNotNull("test should not be null (" + msg + S_RBRAK, test);
        Assert.assertNotNull("expected should not be null (" + msg + S_RBRAK,
                expected);
        DoubleTestBase.assertEquals(msg, test.getXY(), expected.getXY(), epsilon);
    }

    /**
     * Test method for 'org.xmlcml.euclid.Vector2.Vector2(Real2)'
     */
    @Test
    public void testVector2Real2() {
        Assert.assertEquals("vector2 real2", 3., v0.getX());
        Assert.assertEquals("vector2 real2", 4., v0.getY());
    }

    /**
     * Test method for 'org.xmlcml.euclid.Vector2.Vector2(double, double)'
     */
    @Test
    public void testVector2DoubleDouble() {
        Assert.assertEquals("vector2 real2", 1., v1.getX());
        Assert.assertEquals("vector2 real2", 2., v1.getY());
    }

    /**
     * Test method for 'org.xmlcml.euclid.Vector2.getAngleMadeWith(Vector2)'
     */
    @Test
    public void testGetAngleMadeWith() {
        Vector2 v1 = new Vector2(Math.sqrt(3.) / 2., 1. / 2.);
        Vector2 v2 = new Vector2(1. / 2., Math.sqrt(3.) / 2.);
        Angle a = v1.getAngleMadeWith(v2);
        Assert.assertEquals("angle", -Math.PI / 6., a.getRadian(), EPS);
        a = v2.getAngleMadeWith(v1);
        Assert.assertEquals("angle", Math.PI / 6., a.getRadian(), EPS);
    }


}
