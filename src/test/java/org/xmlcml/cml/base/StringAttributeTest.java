/**
 *    Copyright 2011 Peter Murray-Rust et. al.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package org.xmlcml.cml.base;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * tests for stringAttribute.
 * 
 * @author pmr
 * 
 */
public class StringAttributeTest {

	StringSTAttribute daa1;

	StringSTAttribute daa2;

	/**
	 * setup.
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		daa1 = new StringSTAttribute(new CMLAttribute("foo"), "abc");
	}

	/**
	 * Test method for 'org.xmlcml.cml.base.StringSTAttribute.getCMLValue()'
	 */
	@Test
	public void testGetCMLValue() {
		Assert.assertEquals("get CMLValue", "abc", (String) daa1.getCMLValue());
		// Assert.assertNull("get CMLValue", daa1.getCMLValue());
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.base.StringSTAttribute.setCMLValue(String)'
	 */
	@Test
	public void testSetCMLValueStringX() {
		daa1.setCMLValue("abc");
		String dd = (String) daa1.getCMLValue();
		Assert.assertEquals("get CMLValue", "abc", dd);
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.base.StringSTAttribute.StringAttribute(StringSTAttribute)
	 * '
	 */
	@Test
	public void testStringAttributeStringAttribute() {
		daa1.setCMLValue("3");
		daa2 = new StringSTAttribute(daa1);
		String dd = (String) daa2.getCMLValue();
		Assert.assertEquals("get CMLValue", "3", dd);
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.base.StringSTAttribute.setCMLValue(String[])'
	 */
	@Test
	public void testSetCMLValueString() {
		daa1.setCMLValue("5");
		Assert.assertEquals("get Value", "5", daa1.getValue());
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.base.StringSTAttribute.checkValue(String[])'
	 */
	@Test
	public void testCheckValue() {
		daa1.checkValue("5");
		Assert.assertEquals("get Value", "abc", daa1.getValue());
	}

	/**
	 * Test method for 'org.xmlcml.cml.base.StringSTAttribute.getString()'
	 */
	@Test
	public void testGetString() {
		daa1.setCMLValue("6");
		Assert.assertEquals("get Value", "6", daa1.getString());
	}

}
