package org.xmlcml.cml.base;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * test for stringArrayAttribute.
 * 
 * @author pmr
 * 
 */
public class StringArrayAttributeTest {

	StringArraySTAttribute daa1;

	StringArraySTAttribute daa2;

	/**
	 * setup.
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		daa1 = new StringArraySTAttribute(new CMLAttribute("foo"), "abc def");
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.base.StringArraySTAttribute.getCMLValue()'
	 */
	@Test
	public void testGetCMLValue() {
		// Assert.assertEquals("get CMLValue", "1 3", daa1.getCMLValue());
		Assert.assertNull("get CMLValue", daa1.getCMLValue());
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.base.StringArraySTAttribute.setCMLValue(String)'
	 */
	@Test
	public void testSetCMLValueString() {
		daa1.setCMLValue("abc def");
		String[] dd = (String[]) daa1.getCMLValue();
		Assert.assertEquals("get CMLValue", new String[] { "abc", "def" }, dd);
	}

	/**
	 * Test method for'org.xmlcml.cml.base.StringArraySTAttribute.StringArrayAttribute(StringArraySTAttribute
	 * ) '
	 */
	@Test
	public void testStringArrayAttributeStringArrayAttribute() {
		daa1.setCMLValue("3  5");
		daa2 = new StringArraySTAttribute(daa1);
		String[] dd = (String[]) daa2.getCMLValue();
		Assert.assertEquals("get CMLValue", new String[] { "3", "5" }, dd);
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.base.StringArraySTAttribute.setCMLValue(String[])'
	 */
	@Test
	public void testSetCMLValueStringArray() {
		daa1.setCMLValue(new String[] { "5", "7" });
		Assert.assertEquals("get Value", "5 7", daa1.getValue());
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.base.StringArraySTAttribute.checkValue(String[])'
	 */
	@Test
	public void testCheckValue() {
		daa1.checkValue(new String[] { "5", "7" });
		Assert.assertEquals("get Value", "abc def", daa1.getValue());
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.base.StringArraySTAttribute.getStringArray()'
	 */
	@Test
	public void testGetStringArray() {
		daa1.setCMLValue(new String[] { "6", "8" });
		Assert.assertEquals("get Value", new String[] { "6", "8" }, daa1
				.getStringArray());
	}

}
