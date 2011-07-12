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
import org.xmlcml.euclid.EC;

/**
 * tests for intAttribute.
 * 
 * @author pmr
 * 
 */
public class IntAttributeTest {

	IntSTAttribute daa1;

	IntSTAttribute daa2;

	/**
	 * setup.
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		daa1 = new IntSTAttribute(new CMLAttribute("foo"), " 1   ");

	}

	/**
	 * Test method for 'org.xmlcml.cml.base.IntSTAttribute.getCMLValue()'
	 */
	@Test
	public void testGetCMLValue() {
		Assert.assertEquals("get CMLValue", 1, daa1.getCMLValue());
		// Assert.assertNull("get CMLValue", daa1.getCMLValue());
	}

	/**
	 * Test method for 'org.xmlcml.cml.base.IntSTAttribute.setCMLValue(String)'
	 */
	@Test
	public void testSetCMLValueString() {
		daa1.setCMLValue("3");
		Integer dd = (Integer) daa1.getCMLValue();
		Assert.assertEquals("get CMLValue", 3, dd.intValue(), EC.EPS);
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.base.IntSTAttribute.IntAttribute(IntSTAttribute)'
	 */
	@Test
	public void testIntAttributeIntAttribute() {
		daa1.setCMLValue("3");
		daa2 = new IntSTAttribute(daa1);
		Integer dd = (Integer) daa2.getCMLValue();
		Assert.assertEquals("get CMLValue", 3, dd.intValue(), EC.EPS);
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.base.IntSTAttribute.setCMLValue(double[])'
	 */
	@Test
	public void testSetCMLValueInt() {
		daa1.setCMLValue(5);
		Assert.assertEquals("get Value", "5", daa1.getValue());
	}

	/**
	 * Test method for 'org.xmlcml.cml.base.IntSTAttribute.checkValue(double[])'
	 */
	@Test
	public void testCheckValue() {
		daa1.checkValue(5);
	}

	/**
	 * Test method for 'org.xmlcml.cml.base.IntSTAttribute.getInt()'
	 */
	@Test
	public void testGetInt() {
		daa1.setCMLValue(7);
		Assert.assertEquals("get Value", 7, daa1.getInt());
	}

}
