package org.xmlcml.euclid.test;

import static org.xmlcml.euclid.EC.EPS;

import org.junit.Test;
import org.xmlcml.euclid.Real;

/**
 * test Real.
 * 
 * @author pmr
 * 
 */
public class RealTest {

	/**
	 * Test method for 'org.xmlcml.euclid.Real.zeroArray(double, double[])'
	 */
	@Test
	public void testZeroArray() {
		double[] rr = new double[5];
		Real.zeroArray(5, rr);
		DoubleTestBase.assertEquals("double[] ", new double[] { 0.0, 0.0, 0.0,
				0.0, 0.0 }, rr, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.Real.initArray(double, double[],
	 * double)'
	 */
	@Test
	public void testInitArray() {
		double[] rr = new double[5];
		Real.initArray(5, rr, 3.0);
		DoubleTestBase.assertEquals("double[] ", new double[] { 3.0, 3.0, 3.0,
				3.0, 3.0 }, rr, EPS);
	}

}
