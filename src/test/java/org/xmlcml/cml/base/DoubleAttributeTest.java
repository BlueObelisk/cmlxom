package org.xmlcml.cml.base;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.xmlcml.euclid.EC;

/**
 * tests for doubleAttribute.
 * 
 * @author pmr
 * 
 */
public class DoubleAttributeTest {

	DoubleSTAttribute daa1;

	DoubleSTAttribute daa2;

	/**
	 * setup.
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		daa1 = new DoubleSTAttribute(new CMLAttribute("foo"), " 1.2   ");

	}

	/**
	 * Test method for 'org.xmlcml.cml.base.DoubleSTAttribute.getCMLValue()'
	 */
	@Test
	public void testGetCMLValue() {
		Assert.assertEquals("get CMLValue", "1.2", (String) daa1.getCMLValue());
		// Assert.assertNull("get CMLValue", daa1.getCMLValue());
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.base.DoubleSTAttribute.setCMLValue(String)'
	 */
	@Test
	public void testSetCMLValueString() {
		daa1.setCMLValue("3.4");
		String dd = (String) daa1.getCMLValue();
		Assert.assertEquals("get CMLValue", "3.4", dd);

	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.base.DoubleSTAttribute.DoubleAttribute(DoubleSTAttribute)
	 * '
	 */
	@Test
	public void testDoubleAttributeDoubleAttribute() {
		daa1.setCMLValue("3.4");
		daa2 = new DoubleSTAttribute(daa1);
		String dd = (String) daa2.getCMLValue();
		Assert.assertEquals("get CMLValue", "3.4", dd);

	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.base.DoubleSTAttribute.setCMLValue(double[])'
	 */
	@Test
	public void testSetCMLValueDouble() {
		daa1.setCMLValue(5.6);
		Assert.assertEquals("get Value", "5.6", daa1.getValue());
	}

	@Test
	public void testSetCMLValueToSpecialValue() {
		daa1.setCMLValue("NaN");
		Assert.assertEquals("NaN", daa1.getValue());
		Assert.assertEquals(Double.NaN, daa1.getDouble());
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.base.DoubleSTAttribute.checkValue(double[])'
	 */
	@Test
	public void testCheckValue() {
		daa1.checkValue(5.6);
		Assert.assertEquals("get Value", "1.2", daa1.getValue());
	}

	/**
	 * Test method for 'org.xmlcml.cml.base.DoubleSTAttribute.getDouble()'
	 */
	@Test
	public void testGetDouble() {
		daa1.setCMLValue(7.8);
		Assert.assertEquals("get Value", 7.8, daa1.getDouble(), EC.EPS);
	}

}
