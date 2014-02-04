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
	public synchronized void setUp() throws Exception {
		daa1 = new StringArraySTAttribute(new CMLAttribute("foo"), "abc def");
	}

	@Test
	public void testArrayFromString(){
		StringArraySTAttribute test = new StringArraySTAttribute("Test");
		String[] array=test.arrayFromString("test foo bar");
		Assert.assertEquals(3, array.length);
		Assert.assertEquals("bar", array[2]);
	}
	
	@Test
	public void testStringFromArray(){
		StringArraySTAttribute test = new StringArraySTAttribute("Test");
		String[] array=test.arrayFromString("test foo bar");
		Assert.assertEquals("test foo bar",test.stringFromArray(array));
	}
	
	/**
	 * Test method for
	 * 'org.xmlcml.cml.base.StringArraySTAttribute.getCMLValue()'
	 */
	@Test
	public void testGetCMLValue() {
		Assert.assertNotNull("get CMLValue", daa1.getCMLValue());
		String[] dd = (String[]) daa1.getCMLValue();
		Assert.assertEquals("get CMLValue", new String[] { "abc", "def" }, dd);
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.base.StringArraySTAttribute.setCMLValue(String)'
	 */
	@Test
	public void testSetCMLValueString() {
		daa1.setCMLValue("1 2 3 4");
		String[] dd = (String[]) daa1.getCMLValue();
		Assert.assertEquals("get CMLValue", new String[] { "1", "2","3","4" }, dd);
		daa1.setCMLValue(new String[]{"foo","bar"});
		Assert.assertEquals(new String[]{"foo","bar"}, (String[])daa1.getCMLValue());
		
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
