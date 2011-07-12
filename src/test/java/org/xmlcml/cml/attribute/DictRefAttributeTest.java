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

package org.xmlcml.cml.attribute;

import junit.framework.Assert;
import nu.xom.Attribute;
import nu.xom.Element;

import org.junit.Test;

public class DictRefAttributeTest {
	@Test
	public void testGetDictRefLocalValue() {
		Element element = new Element("e");
		element.addAttribute(new Attribute(DictRefAttribute.NAME, "a:b"));
		String dictRef = DictRefAttribute.getLocalValue(element);
		Assert.assertEquals("a:b", "b", dictRef);
	}
	
	@Test
	public void testGetDictRefLocalValue1() {
		Element element = new Element("e");
		String dictRef = DictRefAttribute.getLocalValue(element);
		Assert.assertNull(dictRef);
	}
	
	@Test
	public void testGetDictRefLocalValue2() {
		Element element = new Element("e");
		element.addAttribute(new Attribute(DictRefAttribute.NAME, "b"));
		String dictRef = DictRefAttribute.getLocalValue(element);
		Assert.assertEquals("b", "b", dictRef);
	}
	
}
