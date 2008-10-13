package org.xmlcml.euclid.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.xmlcml.euclid.Angle;
import org.xmlcml.euclid.Complex;
import org.xmlcml.euclid.Polar;
import org.xmlcml.euclid.Real2;

/**
 * test Polar.
 *
 * @author pmr
 *
 */
public class PolarTest extends EuclidTestBase {

    Polar p0;

    Polar p1;

    Polar p2;

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
        p0 = new Polar();
        p1 = new Polar(1, 2);
        p2 = new Polar(10, new Angle(Math.PI / 3));
    }

    /**
     * Test method for 'org.xmlcml.euclid.Polar.Polar()'
     */
    @Test
    public void testPolar() {
        Assert.assertEquals("polar", 0.0, p0.getTheta().getRadian(), EPS);
        Assert.assertEquals("polar", 0.0, p0.getR(), EPS);
    }

    /**
     * Test method for 'org.xmlcml.euclid.Polar.Polar(double, double)'
     */
    @Test
    public void testPolarDoubleDouble() {
        Assert.assertEquals("polar", Math.atan(2. / 1.), p1.getTheta()
                .getRadian(), EPS);
        Assert.assertEquals("polar", Math.sqrt(5.), p1.getR(), EPS);
        Assert.assertEquals("polar", 1., p1.getX(), EPS);
        Assert.assertEquals("polar", 2., p1.getY(), EPS);
    }

    /**
     * Test method for 'org.xmlcml.euclid.Polar.Polar(double, Angle)'
     */
    @Test
    public void testPolarDoubleAngle() {
        Assert.assertEquals("polar", Math.PI / 3., p2.getTheta().getRadian(),
                EPS);
        Assert.assertEquals("polar", 10., p2.getR(), EPS);
    }

    /**
     * Test method for 'org.xmlcml.euclid.Polar.Polar(Complex)'
     */
    @Test
    public void testPolarComplex() {
        Polar c = new Polar(new Complex(1., 2.));
        Assert.assertEquals("polar", Math.atan(2. / 1.), c.getTheta()
                .getRadian(), EPS);
        Assert.assertEquals("polar", Math.sqrt(5.), c.getR(), EPS);
    }

    /**
     * Test method for 'org.xmlcml.euclid.Polar.Polar(Polar)'
     */
    @Test
    public void testPolarPolar() {
        Polar p = new Polar(p1);
        Assert.assertEquals("polar", Math.atan(2. / 1.), p.getTheta()
                .getRadian(), EPS);
        Assert.assertEquals("polar", Math.sqrt(5.), p.getR(), EPS);
    }

    /**
     * Test method for 'org.xmlcml.euclid.Polar.getR()'
     */
    @Test
    public void testGetR() {
        Assert.assertEquals("polar", Math.sqrt(5.), p1.getR(), EPS);
    }

    /**
     * Test method for 'org.xmlcml.euclid.Polar.getTheta()'
     */
    @Test
    public void testGetTheta() {
        Assert.assertEquals("polar", Math.atan(2. / 1.), p1.getTheta()
                .getRadian(), EPS);
    }

    /**
     * Test method for 'org.xmlcml.euclid.Polar.plus(Polar)'
     */
    @Test
    public void testPlus() {
        Polar pa = new Polar(10., 20.);
        Assert.assertEquals("polar", 10., pa.getX(), EPS);
        Assert.assertEquals("polar", 20., pa.getY(), EPS);
        Polar pb = new Polar(30., 40.);
        Assert.assertEquals("polar", 30., pb.getX(), EPS);
        Assert.assertEquals("polar", 40., pb.getY(), EPS);
        Polar pc = pa.plus(pb);
        Assert.assertEquals("polar", 40., pc.getX(), EPS);
        Assert.assertEquals("polar", 60., pc.getY(), EPS);
    }

    /**
     * Test method for 'org.xmlcml.euclid.Polar.subtract(Polar)'
     */
    @Test
    public void testSubtractPolar() {
        Polar pa = new Polar(10., 20.);
        Polar pb = new Polar(30., 50.);
        Polar pc = pa.subtract(pb);
        Assert.assertEquals("polar", -20., pc.getX(), EPS);
        Assert.assertEquals("polar", -30., pc.getY(), EPS);
    }

    /**
     * Test method for 'org.xmlcml.euclid.Polar.subtract()'
     */
    @Test
    public void testSubtract() {
        Polar pa = new Polar(10., 20.);
        pa.subtract();
        Assert.assertEquals("polar", -10., pa.getX(), EPS);
        Assert.assertEquals("polar", -20., pa.getY(), EPS);
    }

    /**
     * Test method for 'org.xmlcml.euclid.Polar.multiplyBy(Polar)'
     */
    @Test
    public void testMultiplyByPolar() {
        Polar pa = new Polar(10., new Angle(Math.PI / 4.));
        Polar pb = new Polar(20., new Angle(Math.PI / 3.));
        Polar pc = pa.multiplyBy(pb);
        Assert.assertEquals("polar", 200., pc.getR(), 1.0E-08);
        Assert.assertEquals("polar", Math.PI / 4. + Math.PI / 3., pc.getTheta()
                .getRadian(), 1.0E-08);
    }

    /**
     * Test method for 'org.xmlcml.euclid.Polar.multiplyBy(double)'
     */
    @Test
    public void testMultiplyByDouble() {
        Polar pa = new Polar(10., 20.);
        Polar pb = pa.multiplyBy(3.);
        Assert.assertEquals("polar", 30., pb.getX(), 1.0E-08);
        Assert.assertEquals("polar", 60., pb.getY(), 1.0E-08);
    }

    /**
     * Test method for 'org.xmlcml.euclid.Polar.divideBy(Polar)'
     */
    @Test
    public void testDivideBy() {
        Polar pa = new Polar(10., new Angle(Math.PI / 4.));
        Polar pb = new Polar(20., new Angle(Math.PI / 3.));
        Polar pc = pa.divideBy(pb);
        Assert.assertEquals("polar", 0.5, pc.getR(), 1.0E-08);
        Assert.assertEquals("polar", Math.PI / 4. - Math.PI / 3., pc.getTheta()
                .getRadian(), 1.0E-08);
    }

    /**
     * Test method for 'org.xmlcml.euclid.Polar.isEqualTo(Polar)'
     */
    @Test
    public void testIsEqualTo() {
        Assert.assertTrue("isEqualTo", p1.isEqualTo(p1));
        Assert.assertFalse("isEqualTo", p1.isEqualTo(p2));
    }

    /**
     * Test method for 'org.xmlcml.euclid.Polar.getX()'
     */
    @Test
    public void testGetX() {
        Polar pb = new Polar(20., new Angle(Math.PI / 3.));
        Assert.assertEquals("polar", 20 * Math.cos(Math.PI / 3.), pb.getX(),
                1.0E-08);
    }

    /**
     * Test method for 'org.xmlcml.euclid.Polar.getY()'
     */
    @Test
    public void testGetY() {
        Polar pb = new Polar(20., new Angle(Math.PI / 3.));
        Assert.assertEquals("polar", 20 * Math.sin(Math.PI / 3.), pb.getY(),
                1.0E-08);
    }

    /**
     * Test method for 'org.xmlcml.euclid.Polar.getXY()'
     */
    @Test
    public void testGetXY() {
        Polar pb = new Polar(20., new Angle(Math.PI / 3.));
        Real2 r = pb.getXY();
        Assert.assertEquals("polar", 20 * Math.cos(Math.PI / 3.), r.getX(),
                1.0E-08);
        Assert.assertEquals("polar", 20 * Math.sin(Math.PI / 3.), r.getY(),
                1.0E-08);
    }


}
