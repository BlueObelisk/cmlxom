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
