package org.xmlcml.euclid.test;

import static org.xmlcml.euclid.EC.EPS;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.xmlcml.euclid.Angle;
import org.xmlcml.euclid.Angle.Units;

/**
 * test Angle.
 * 
 * @author pmr
 * 
 */
public class AngleTest {

	Angle zero;

	Angle pi4;

	Angle pi2;

	Angle pi;

	/**
	 * setup.
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		zero = new Angle(0.);
		pi4 = new Angle(Math.PI / 4.);
		pi2 = new Angle(Math.PI / 2.);
		pi = new Angle(Math.PI);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.Angle.Angle(double)'
	 */
	@Test
	public void testAngleDouble() {
		Assert.assertEquals("pi/4", 45., pi4.getDegrees(), EPS);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.Angle.Angle(double, AngleType)'
	 */
	@Test
	public void testAngleDoubleAngleType() {
		Angle a1 = new Angle(1., Angle.Units.DEGREES);
		Assert.assertEquals("degrees ", Math.PI / 180., a1.getRadian(), EPS);
		a1 = new Angle(1., Angle.Units.RADIANS);
		Assert.assertEquals("degrees ", 1., a1.getRadian(), EPS);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.Angle.Angle(double, double)'
	 */
	@Test
	public void testAngleDoubleDouble() {
		Angle a1 = new Angle(1., 0.);
		Assert.assertEquals("degrees ", Math.PI / 2., a1.getRadian(), EPS);
		a1 = new Angle(1., 1.);
		Assert.assertEquals("degrees ", Math.PI / 4., a1.getRadian(), EPS);
		a1 = new Angle(0., 1.);
		Assert.assertEquals("degrees ", 0., a1.getRadian(), EPS);
		a1 = new Angle(0., -1.);
		Assert.assertEquals("degrees ", Math.PI, a1.getRadian(), EPS);
		a1 = new Angle(-1., -1.);
		Assert.assertEquals("degrees ", -3 * Math.PI / 4, a1.getRadian(), EPS);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.Angle.Angle(Angle)'
	 */
	@Test
	public void testAngleAngle() {
		Angle a1 = new Angle(pi2);
		Assert.assertEquals("degrees ", Math.PI / 2., a1.getRadian(), EPS);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.Angle.plus(Angle)'
	 */
	@Test
	public void testPlus() {
		Angle a1 = pi2.plus(pi4);
		Assert.assertEquals("degrees ", 3 * Math.PI / 4., a1.getRadian(), EPS);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.Angle.subtract(Angle)'
	 */
	@Test
	public void testSubtract() {
		Angle a1 = pi.subtract(pi4);
		Assert.assertEquals("degrees ", 3 * Math.PI / 4., a1.getRadian(), EPS);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.Angle.multiplyBy(double)'
	 */
	@Test
	public void testMultiplyBy() {
		Angle a1 = pi4.multiplyBy(3.);
		Assert.assertEquals("degrees ", 3 * Math.PI / 4., a1.getRadian(), EPS);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.Angle.cos()'
	 */
	@Test
	public void testCos() {
		double c = pi4.cos();
		Assert.assertEquals("cos ", Math.sqrt(1. / 2.), c, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.Angle.sin()'
	 */
	@Test
	public void testSin() {
		double s = pi4.sin();
		Assert.assertEquals("sin ", Math.sqrt(1. / 2.), s, 1.0E-08);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.Angle.tan()'
	 */
	@Test
	public void testTan() {
		double t = pi4.tan();
		Assert.assertEquals("tan ", 1., t, 1.0E-08);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.Angle.normalise(double)'
	 */
	@Test
	public void testNormalise() {
		double a = Angle.normalise(3 * Math.PI);
		Assert.assertEquals("degrees ", Math.PI, a, EPS);

	}

	/**
	 * Test method for 'org.xmlcml.euclid.Angle.isEqualTo(double)'
	 */
	@Test
	public void testIsEqualToDouble() {
		Assert.assertTrue("is equal", pi.isEqualTo(Math.PI));
		Assert.assertFalse("is equal", pi.isEqualTo(Math.PI / 2));
	}

	/**
	 * Test method for 'org.xmlcml.euclid.Angle.greaterThan(double)'
	 */
	@Test
	public void testGreaterThanDouble() {
		Assert.assertTrue("GreaterThan", pi.greaterThan(Math.PI / 2));
		Assert.assertFalse("GreaterThan", pi2.greaterThan(Math.PI));
		Assert.assertFalse("GreaterThan", pi.greaterThan(Math.PI));
	}

	/**
	 * Test method for 'org.xmlcml.euclid.Angle.greaterThanOrEquals(double)'
	 */
	@Test
	public void testGreaterThanOrEqualsDouble() {
		Assert.assertTrue("GreaterThanOrEquals", pi
				.greaterThanOrEquals(Math.PI / 2));
		Assert.assertFalse("GreaterThanOrEquals", pi2
				.greaterThanOrEquals(Math.PI));
		Assert.assertTrue("GreaterThanOrEquals", pi
				.greaterThanOrEquals(Math.PI));
	}

	/**
	 * Test method for 'org.xmlcml.euclid.Angle.lessThan(double)'
	 */
	@Test
	public void testLessThanDouble() {
		Assert.assertFalse("LessThan", pi.lessThan(Math.PI / 2));
		Assert.assertTrue("LessThan", pi2.lessThan(Math.PI));
		Assert.assertFalse("LessThan", pi.lessThan(Math.PI));
	}

	/**
	 * Test method for 'org.xmlcml.euclid.Angle.lessThanOrEquals(double)'
	 */
	@Test
	public void testLessThanOrEqualsDouble() {
		Assert
				.assertFalse("LessThanOrEquals", pi
						.lessThanOrEquals(Math.PI / 2));
		Assert.assertTrue("LessThanOrEquals", pi2.lessThanOrEquals(Math.PI));
		Assert.assertTrue("LessThanOrEquals", pi.lessThanOrEquals(Math.PI));
	}

	/**
	 * Test method for 'org.xmlcml.euclid.Angle.isEqualTo(Angle)'
	 */
	@Test
	public void testIsEqualToAngle() {
		Assert.assertTrue("is equal", pi.isEqualTo(pi));
		Assert.assertFalse("is equal", pi.isEqualTo(pi2));
	}

	/**
	 * Test method for 'org.xmlcml.euclid.Angle.greaterThan(Angle)'
	 */
	@Test
	public void testGreaterThanAngle() {
		Assert.assertTrue("GreaterThan", pi.greaterThan(pi2));
		Assert.assertFalse("GreaterThan", pi2.greaterThan(pi));
		Assert.assertFalse("GreaterThan", pi.greaterThan(pi));
	}

	/**
	 * Test method for 'org.xmlcml.euclid.Angle.greaterThanOrEquals(Angle)'
	 */
	@Test
	public void testGreaterThanOrEqualsAngle() {
		Assert.assertTrue("GreaterThanOrEquals", pi.greaterThanOrEquals(pi2));
		Assert.assertFalse("GreaterThanOrEquals", pi2.greaterThanOrEquals(pi));
		Assert.assertTrue("GreaterThanOrEquals", pi.greaterThanOrEquals(pi));
	}

	/**
	 * Test method for 'org.xmlcml.euclid.Angle.lessThan(Angle)'
	 */
	@Test
	public void testLessThanAngle() {
		Assert.assertFalse("LessThan", pi.lessThan(pi2));
		Assert.assertTrue("LessThan", pi2.lessThan(pi));
		Assert.assertFalse("LessThan", pi.lessThan(pi));
	}

	/**
	 * Test method for 'org.xmlcml.euclid.Angle.lessThanOrEquals(Angle)'
	 */
	@Test
	public void testLessThanOrEqualsAngle() {
		Assert.assertFalse("LessThanOrEquals", pi.lessThanOrEquals(pi2));
		Assert.assertTrue("LessThanOrEquals", pi2.lessThanOrEquals(pi));
		Assert.assertTrue("LessThanOrEquals", pi.lessThanOrEquals(pi));
	}

	/**
	 * Test method for 'org.xmlcml.euclid.Angle.getAngle()'
	 */
	@Test
	public void testGetAngle() {
		double a = pi2.getAngle();
		Assert.assertEquals("get angle", Math.PI / 2, a, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.Angle.getRadian()'
	 */
	@Test
	public void testGetRadian() {
		double a = pi2.getRadian();
		Assert.assertEquals("get radian", Math.PI / 2, a, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.Angle.getDegrees()'
	 */
	@Test
	public void testGetDegrees() {
		double a = pi2.getDegrees();
		Assert.assertEquals("get degrees", 90., a, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.Angle.putDegrees(double)'
	 */
	@Test
	public void testPutDegrees() {
		pi2.putDegrees(60.);
		Assert.assertEquals("put degrees", 60., pi2.getDegrees(), 1.0E-08);
		Assert.assertEquals("put degrees", Math.PI / 3., pi2.getRadian(), EPS);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.Angle.setRange(AngleRange)'
	 */
	@Test
	public void testSetRange() {
		pi2.putDegrees(-60.);
		pi2.setRange(Angle.Range.UNSIGNED);
		Assert.assertEquals("put degrees", 300., pi2.getDegrees(), 1.0E-08);
		Assert.assertEquals("put degrees", 5. * Math.PI / 3., pi2.getRadian(),
				EPS);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.Angle.Angle(double, Units)'
	 */
	@Test
	public void testAngleDoubleUnits() {
		Angle a = new Angle(90, Units.DEGREES);
		Assert.assertEquals("degrees", 90, a.getDegrees(), EPS);
		Assert.assertEquals("radians", 90 * Math.PI / 180., a.getRadian(), EPS);
		a = new Angle(1, Units.RADIANS);
		Assert.assertEquals("degrees", 180. / Math.PI, a.getDegrees(), EPS);
		Assert.assertEquals("radians", 1., a.getRadian(), EPS);
		a = new Angle(10, Units.RADIANS);
		Assert.assertEquals("degrees", 10. * 180. / Math.PI, a.getDegrees(),
				EPS);
		Assert.assertEquals("radians", 10., a.getRadian(), EPS);
	}

}
