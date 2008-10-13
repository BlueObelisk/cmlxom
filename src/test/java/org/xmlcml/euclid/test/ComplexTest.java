package org.xmlcml.euclid.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.xmlcml.euclid.Angle;
import org.xmlcml.euclid.Complex;
import org.xmlcml.euclid.Polar;
import org.xmlcml.euclid.Real2;

/**
 * test Complex.
 * 
 * @author pmr
 * 
 */
public class ComplexTest {

	Complex c0;

	Complex c1;

	Complex c2;

	/**
	 * setup.
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		c0 = new Complex();
		c1 = new Complex(1, 0);
		c2 = new Complex(1, 2);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.Complex.negative()'
	 */
	@Test
	public void testNegative() {
		c2.negative();
		Assert.assertEquals("negative", -1., c2.getReal());
		Assert.assertEquals("negative", -2., c2.getImaginary());
	}

	/**
	 * Test method for 'org.xmlcml.euclid.Complex.toString()'
	 */
	@Test
	public void testToString() {
		String s = c2.toString();
		Assert.assertEquals("to string", "1.0,2.0", s);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.Complex.Complex()'
	 */
	@Test
	public void testComplex() {
		String s = c0.toString();
		Assert.assertEquals("to string", "0.0,0.0", s);
		Assert.assertEquals("empty ", 0., c0.getReal());
		Assert.assertEquals("empty", 0., c0.getImaginary());
	}

	/**
	 * Test method for 'org.xmlcml.euclid.Complex.Complex(double)'
	 */
	@Test
	public void testComplexDouble() {
		Complex c = new Complex(3.);
		Assert.assertEquals("to string", "3.0,0.0", c.toString());
	}

	/**
	 * Test method for 'org.xmlcml.euclid.Complex.Complex(double, double)'
	 */
	@Test
	public void testComplexDoubleDouble() {
		Complex c = new Complex(3., 2.);
		Assert.assertEquals("to string", "3.0,2.0", c.toString());
	}

	/**
	 * Test method for 'org.xmlcml.euclid.Complex.Complex(Real2)'
	 */
	@Test
	public void testComplexReal2() {
		Complex c = new Complex(new Real2(3., 2.));
		Assert.assertEquals("real 2", "3.0,2.0", c.toString());
	}

	/**
	 * Test method for 'org.xmlcml.euclid.Complex.Complex(double, Angle)'
	 */
	@Test
	public void testComplexDoubleAngle() {
		Angle a = new Angle(60., Angle.Units.DEGREES);
		Complex c = new Complex(1., a);
		Assert.assertEquals("length angle", 1. / 2., c.getReal(), 1.0E-08);
		Assert.assertEquals("length angle", Math.sqrt(3.) / 2., c
				.getImaginary(), 1.0E-08);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.Complex.Complex(Polar)'
	 */
	@Test
	public void testComplexPolar() {
		Polar p = new Polar(1., 2.);
		Complex c = new Complex(p);
		Assert.assertEquals("polar", 1., c.getReal(), 1.0E-08);
		Assert.assertEquals("polar", 2., c.getImaginary(), 1.0E-08);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.Complex.Complex(Complex)'
	 */
	@Test
	public void testComplexComplex() {
		Complex c = new Complex(c2);
		Assert.assertEquals("complex", 1., c.getReal(), 1.0E-08);
		Assert.assertEquals("complex", 2., c.getImaginary(), 1.0E-08);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.Complex.getReal()'
	 */
	@Test
	public void testGetReal() {
		Assert.assertEquals("real", 1., c2.getReal(), 1.0E-08);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.Complex.getImaginary()'
	 */
	@Test
	public void testGetImaginary() {
		Assert.assertEquals("imaginary", 2., c2.getImaginary(), 1.0E-08);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.Complex.multiply(Complex)'
	 */
	@Test
	public void testMultiply() {
		Complex c = c2.multiply(c2);
		Assert.assertEquals("multiply", -3., c.getReal(), 1.0E-08);
		Assert.assertEquals("multiply", 4., c.getImaginary(), 1.0E-08);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.Complex.divideBy(Complex)'
	 */
	@Test
	public void testDivideBy() {
		Complex c = c1.divideBy(c2);
		Assert.assertEquals("divide", 0.2, c.getReal(), 1.0E-08);
		Assert.assertEquals("divide", -0.4, c.getImaginary(), 1.0E-08);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.Complex.getR()'
	 */
	@Test
	public void testGetR() {
		double r = c2.getR();
		Assert.assertEquals("R", Math.sqrt(5.), r, 1.0E-08);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.Complex.getTheta()'
	 */
	@Test
	public void testGetTheta() {
		Angle a = c2.getTheta();
		Assert.assertEquals("theta", Math.atan2(2., 1.), a.getAngle(), 1.0E-08);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.Complex.getPolar()'
	 */
	@Test
	public void testGetPolar() {
		Polar p = c2.getPolar();
		Angle a = p.getTheta();
		Assert.assertEquals("R", Math.sqrt(5.), p.getR(), 1.0E-08);
		Assert.assertEquals("theta", Math.atan2(2., 1.), a.getAngle(), 1.0E-08);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.Complex.sqrt(Complex)'
	 */
	@Test
	public void testSqrt() {
		Complex c = Complex.sqrt(c2);
		Assert.assertEquals("sqrt x", 1.2720196, c.getReal(), 0.000001);
		Assert.assertEquals("sqrt y", 0.786151, c.getImaginary(), 0.000001);
	}

}
