package org.xmlcml.cml.base;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.xmlcml.euclid.Int;

/**
 * tests for intAttribute.
 * 
 * @author pmr
 * 
 */
public class IntArrayAttributeTest {

	IntArraySTAttribute daa1;

	IntArraySTAttribute daa2;

	/**
	 * setup.
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		daa1 = new IntArraySTAttribute(new CMLAttribute("foo"), " 1   3  ");
	}

	/**
	 * Test method for 'org.xmlcml.cml.base.IntArraySTAttribute.getCMLValue()'
	 */
	@Test
	public void testGetCMLValue() {
		// Assert.assertEquals("get CMLValue", "1 3", daa1.getCMLValue());
		Assert.assertNull("get CMLValue", daa1.getCMLValue());
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.base.IntArraySTAttribute.setCMLValue(String)'
	 */
	@Test
	public void testSetCMLValueString() {
		daa1.setCMLValue("3   5");
		int[] dd = (int[]) daa1.getCMLValue();
		String s = Int.testEquals((new int[] { 3, 5 }), dd);
		if (s != null) {
			Assert.fail("get CMLValue" + "; " + s);
		}

	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.base.IntArraySTAttribute.IntArrayAttribute(IntArraySTAttribut
	 * e ) '
	 */
	@Test
	public void testIntArrayAttributeIntArrayAttribute() {
		daa1.setCMLValue("3  5");
		daa2 = new IntArraySTAttribute(daa1);
		int[] dd = (int[]) daa2.getCMLValue();
		String s = Int.testEquals((new int[] { 3, 5 }), dd);
		if (s != null) {
			Assert.fail("get CMLValue" + "; " + s);
		}

	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.base.IntArraySTAttribute.setCMLValue(int[])'
	 */
	@Test
	public void testSetCMLValueIntArray() {
		daa1.setCMLValue(new int[] { 5, 7 });
		Assert.assertEquals("get Value", "5 7", daa1.getValue());
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.base.IntArraySTAttribute.checkValue(int[])'
	 */
	@Test
	public void testCheckValue() {
		daa1.checkValue(new int[] { 5, 7 });
		Assert.assertEquals("get Value", "1 3", daa1.getValue());
	}

	/**
	 * Test method for 'org.xmlcml.cml.base.IntArraySTAttribute.split(String,
	 * String)'
	 */
	@Test
	public void testSplit() {
		int[] dd = IntArraySTAttribute.split("1 3 5", CMLConstants.S_SPACE);
		Assert.assertEquals("split", 3, dd.length);
		String s = Int.testEquals((new int[] { 1, 3, 5 }), dd);
		if (s != null) {
			Assert.fail("split" + "; " + s);
		}
		dd = IntArraySTAttribute.split("7 3 5", null);
		Assert.assertEquals("split", 3, dd.length);
		s = Int.testEquals((new int[] { 7, 3, 5 }), dd);
		if (s != null) {
			Assert.fail("split" + "; " + s);
		}
	}

	/**
	 * Test method for 'org.xmlcml.cml.base.IntArraySTAttribute.getIntArray()'
	 */
	@Test
	public void testGetIntArray() {
		daa1.setCMLValue(new int[] { 5, 7 });
		String s = Int.testEquals((new int[] { 5, 7 }), daa1
						.getIntArray());
		if (s != null) {
			Assert.fail("get Value" + "; " + s);
		}
	}

}
