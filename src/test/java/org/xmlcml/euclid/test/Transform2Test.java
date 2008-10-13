package org.xmlcml.euclid.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.xmlcml.euclid.Angle;
import org.xmlcml.euclid.EuclidRuntimeException;
import org.xmlcml.euclid.Real2;
import org.xmlcml.euclid.RealSquareMatrix;
import org.xmlcml.euclid.Transform2;
import org.xmlcml.euclid.Vector2;
import org.xmlcml.euclid.Transform2.Type;

/**
 * test Transform2.
 *
 * @author pmr
 *
 */
public class Transform2Test extends EuclidTestBase {

    Transform2 t0;

    Transform2 t1;

    Transform2 t2;

    /**
     * setup.
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        super.setUp();
        t0 = new Transform2();
        t1 = new Transform2(
                new double[] { 0., 1., 0., -1., 0., 0., 0., 0., 1. });
        t2 = new Transform2(new double[] { 1., 0., 0.7, 0., -1., 0.5, 0., 0.,
                1. });
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
    public static void assertEquals(String msg, Transform2 test,
            Transform2 expected, double epsilon) {
        Assert.assertNotNull("test should not be null (" + msg + S_RBRAK, test);
        Assert.assertNotNull("expected should not be null (" + msg + S_RBRAK,
                expected);
        DoubleTestBase.assertEquals(msg, test.getMatrixAsArray(), expected
                .getMatrixAsArray(), epsilon);
    }

    /**
     * equality test. true if both args not null and equal within epsilon
     *
     * @param msg
     *            message
     * @param test
     *            16 values
     * @param expected
     * @param epsilon
     */
    public static void assertEquals(String msg, double[] test,
            Transform2 expected, double epsilon) {
        Assert.assertNotNull("test should not be null (" + msg + S_RBRAK, test);
        Assert.assertEquals("test should have 16 elements (" + msg + S_RBRAK, 9,
                test.length);
        Assert.assertNotNull("ref should not be null (" + msg + S_RBRAK, expected);
        DoubleTestBase
                .assertEquals(msg, test, expected.getMatrixAsArray(), epsilon);
    }

    /**
     * Test method for 'org.xmlcml.euclid.Transform2.Transform2()'
     */
    @Test
    public void testTransform2() {
        Assert.assertNotNull("transform2", t0);
        Transform2Test.assertEquals("transform2", new double[] { 1., 0., 0.,
                0., 1., 0., 0., 0., 1. }, t0, EPS);
        Assert.assertTrue("transform2", t0.getTransformationType() == Type.ANY);
    }

    /**
     * Test method for 'org.xmlcml.euclid.Transform2.Transform2(Vector2)'
     */
    @Test
    public void testTransform2Vector2() {
        Vector2 v = new Vector2(1., 2.);
        Transform2 t = new Transform2(v);
        Real2 vv = t.getTranslation();
        Assert.assertEquals("vector", 1., vv.getX(), EPS);
        Assert.assertEquals("vector", 2., vv.getY(), EPS);
        Assert.assertEquals("transform2", Type.ROT_TRANS.s, t
                .getTransformationType().s);
    }

    /**
     * Test method for 'org.xmlcml.euclid.Transform2.Transform2(Angle)'
     */
    @Test
    public void testTransform2Angle() {
        Transform2 ta = new Transform2(new Angle(Math.PI / 3.));
        Angle aa = ta.getAngleOfRotation();
        Assert.assertEquals("transform angle", Math.PI / 3., aa.getRadian(),
                EPS);
        ta = new Transform2(new Angle(1.));
        aa = ta.getAngleOfRotation();
        Assert.assertEquals("transform angle", 1., aa.getRadian(), EPS);
        Assert.assertEquals("transform2", Type.ROT_ORIG.s, ta
                .getTransformationType().s);
    }

    /**
     * Test method for 'org.xmlcml.euclid.Transform2.Transform2(Transform2,
     * Real2)'
     */
    @Test
    public void testTransform2Transform2Real2() {
        Transform2 ta = new Transform2(new Angle(Math.PI / 3.));
        Transform2 tb = new Transform2(ta, new Real2(3., 4.));
        // haven't checked this is right
        Real2 tr = tb.getTranslation();
        Assert.assertEquals("vector", -1.9641016151377553, tr.getX(), EPS);
        Assert.assertEquals("vector", 4.598076211353316, tr.getY(), EPS);
        Angle aa = ta.getAngleOfRotation();
        Assert.assertEquals("transform angle", Math.PI / 3., aa.getRadian(),
                EPS);
        Assert.assertEquals("transform2", Type.ROT_TRANS.s, tb
                .getTransformationType().s);
    }

    /**
     * Test method for 'org.xmlcml.euclid.Transform2.Transform2(Vector2,
     * Vector2)'
     */
    @Test
    public void testTransform2Vector2Vector2() {
        Transform2 ta = new Transform2(new Vector2(1., 2.), new Vector2(3., 4.));
        Transform2Test.assertEquals("transform2",
                new double[] { 0.9838699100999074, 0.17888543819998318, 0.0,
                        -0.17888543819998318, 0.9838699100999074, 0.0, 0.0,
                        0.0, 1.0, }, ta, EPS);
        Assert.assertEquals("transform2", Type.ROT_ORIG.s, ta
                .getTransformationType().s);
    }

    /**
     * Test method for 'org.xmlcml.euclid.Transform2.Transform2(Real2, Real2)'
     */
    @Test
    public void testTransform2Real2Real2() {
        Transform2 ta = null;
        ta = new Transform2(new Real2(1., 2.), new Real2(3., 4.));
        Transform2Test.assertEquals("transform2", new double[] { 1.0, 2.0, 0.0,
                3.0, 4.0, 0.0, 0.0, 0.0, 1.0, }, ta, EPS);
        Assert.assertEquals("transform2", Type.ROT_ORIG.s, ta
                .getTransformationType().s);
    }

    /**
     * Test method for 'org.xmlcml.euclid.Transform2.Transform2(double[])'
     */
    @Test
    public void testTransform2DoubleArray() {
        Transform2 ta = new Transform2(new double[] { 1., 0., 1., 0., -1., 2., 0., 0.,
                    1. });
        Transform2Test.assertEquals("transform2", new double[] { 1., 0., 1.,
                0., -1., 2., 0., 0., 1. }, ta, EPS);
        Assert.assertEquals("transform2", Type.ROT_ORIG.s, ta
                .getTransformationType().s);
    }

    /**
     * Test method for 'org.xmlcml.euclid.Transform2.Transform2(Transform2)'
     */
    @Test
    public void testTransform2Transform2() {
        Transform2 t = new Transform2(t1);
        Assert.assertTrue("transform", t.isEqualTo(t1));
    }

    /**
     * Test method for
     * 'org.xmlcml.euclid.Transform2.Transform2(RealSquareMatrix)'
     */
    @Test
    public void testTransform2RealSquareMatrix() {
        RealSquareMatrix rsm = new RealSquareMatrix(3, new double[] { 1., 0., 2., 0., 1.,
                    3., 0., 0., 1. });
        Transform2 t = new Transform2(rsm);
        DoubleTestBase.assertEquals("rsm", new double[] { 1., 0., 2., 0., 1., 3.,
                0., 0., 1. }, t.getMatrixAsArray(), EPS);
        Assert.assertEquals("transform2", Type.NULL.s, t
                .getTransformationType().s);
    }

    /**
     * Test method for
     * 'org.xmlcml.euclid.Transform2.Transform2(RealSquareMatrix, Vector2)'
     */
    @Test
    public void testTransform2RealSquareMatrixVector2() {
        RealSquareMatrix rsm = new RealSquareMatrix(2, new double[] { 1., 0., 0., 1., });
        Transform2 t = new Transform2(rsm, new Vector2(2., 3.));
        Transform2Test.assertEquals("rsm", new double[] { 1., 0., 2., 0., 1.,
                3., 0., 0., 1. }, t, EPS);
        Assert.assertEquals("transform2", Type.NULL.s, t
                .getTransformationType().s);
            rsm = new RealSquareMatrix(3, new double[] { 1., 0., 2., 0., 1.,
                    3., 0., 0., 1. });
        try {
            t = new Transform2(rsm, new Vector2(2., 3.));
            alwaysFail("must have 2*2 rotation matrix");
        } catch (EuclidRuntimeException e) {
            Assert.assertEquals("matrix vector",
                    "must have 2*2 rotation matrix", e.getMessage());
        }
    }

    /**
     * Test method for 'org.xmlcml.euclid.Transform2.isEqualTo(Transform2)'
     */
    @Test
    public void testIsEqualToTransform2() {
        Transform2 t = new Transform2(t1);
        Assert.assertTrue("isEqualsTo", t.isEqualTo(t1));
    }

    /**
     * Test method for 'org.xmlcml.euclid.Transform2.concatenate(Transform2)'
     */
    @Test
    public void testConcatenate() {
        Transform2 t = t1.concatenate(t2);
        Transform2Test.assertEquals("concatenate", new double[] { 0.0, -1.0,
                0.5, -1.0, 0.0, -0.7, 0.0, 0.0, 1.0, }, t, EPS);
        Assert.assertEquals("concatenate", Type.ROT_ORIG.s, t
                .getTransformationType().s);
    }

    /**
     * Test method for 'org.xmlcml.euclid.Transform2.setTransformationType(int)'
     */
    @Test
    public void testSetTransformationType() {
        Transform2 t = t1.concatenate(t2);
        t.setTransformationType(Type.ROT_TRANS);
        Assert.assertEquals("setType", Type.ROT_TRANS.s, t
                .getTransformationType().s);
    }

    /**
     * Test method for 'org.xmlcml.euclid.Transform2.checkMatrix()'
     */
    @Test
    public void testCheckMatrix() {
        // not sure this works
        Transform2 t = new Transform2(new double[] { 0., 1., 0., -1., 0., 0., 0., 0.,
                    1. });
        Assert.assertEquals("getType", Type.NULL.s,
                        t.getTransformationType().s);
            t = new Transform2(new double[] { 1., 0., 0., 0., 1., 0., 0., 0.,
                    1. });
        Assert.assertEquals("getType", Type.NULL.s,
                        t.getTransformationType().s);
            t = new Transform2(new double[] { 1., 0., 2., 0., 1., 3., 0., 0.,
                    1. });
        Assert.assertEquals("getType", Type.NULL.s,
                        t.getTransformationType().s);
    }

    /**
     * Test method for 'org.xmlcml.euclid.Transform2.getAngleOfRotation()'
     */
    @Test
    public void testGetAngleOfRotation() {
        Transform2 t = new Transform2(new double[] { 0., 1., 0., -1., 0., 0., 0., 0.,
                    1. });
        Angle a = t.getAngleOfRotation();
        Assert.assertEquals("getAngle", Math.PI / 2., a.getRadian(), EPS);
    }

    /**
     * Test method for 'org.xmlcml.euclid.Transform2.flipAboutVector(Real2)'
     */
    @Test
    public void testFlipAboutVector() {
        Transform2 t = Transform2.flipAboutVector(new Vector2(1., 1.));
        DoubleTestBase.assertEquals("flip", new double[] { 0.0, 1., 0.0, 1., 0.0,
                0.0, 0.0, 0.0, 1.0, }, t.getMatrixAsArray(), 0.0000000001);
    }

    /**
     * Test method for 'org.xmlcml.euclid.Transform2.getTranslation()'
     */
    @Test
    public void testGetTranslation() {
        Real2 v = t2.getTranslation();
        Assert.assertEquals("translation", 0.7, v.getX(), EPS);
        Assert.assertEquals("translation", 0.5, v.getY(), EPS);
    }

    /**
     * Test method for 'org.xmlcml.euclid.Transform2.getCentreOfRotation()'
     */
    /**
     * -- not yet written
     *
     * @Test public void testGetCentreOfRotation() { Transform2 t = null; try {
     *       t = new Transform2(new double[]{ 0., 1., 2., -1., 0., 3., 0., 0.,
     *       1. }); } catch (EuclidException e) { neverFail(e); } Real2 r =
     *       t.getCentreOfRotation(); Angle a = t.getAngleOfRotation();
     *       Assert.assertEquals("getAngle", Math.PI/2., a.getRadian(), EPS); } --
     */

    /**
     * Test method for 'org.xmlcml.euclid.Transform2.getRotationMatrix()'
     */
    @Test
    public void testGetRotationMatrix() {
        Transform2 t = new Transform2(new double[] { 0., 1., 2., -1., 0., 3., 0., 0.,
                    1. });
        RealSquareMatrix rsm = t.getRotationMatrix();
        DoubleTestBase.assertEquals("getRotationMatrix", new double[] { 0.0, 1.0,
                -1.0, 0.0, }, rsm.getMatrixAsArray(), EPS);
    }


}
