package org.xmlcml.cml.command;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.xmlcml.cml.base.CMLUtil;

public class BondStereoTest {
	private static Logger LOG = Logger.getLogger(BondStereoTest.class);
	static {
		LOG.setLevel(Level.DEBUG);
	}
	
	//
	@Test
	public void createFromXML() {
//		ATOMREFS4 = new AttributeNG("atomRefs4", TypeNG.REF_TYPE, 4);
		String xmlString = "<bondStereo id='b1' xmlns='http://www.xml-cml.org/schema'/>";
		Handle handle = new ElementCommand().readCML(xmlString);
		handle.setAttribute("atomRefs4", "a1 a2 a3 a4");
		String message = CMLUtil.equalsCanonically(
			"<bondStereo id='b1' atomRefs4='a1 a2 a3 a4' xmlns='http://www.xml-cml.org/schema'/>", handle.getElement(), true);
		Assert.assertNull("atomRefs4", message);
		try {
			handle.setAttribute("atomRefs24", "a1 a2 a3");
			Assert.fail("should throw invalid attribute");
		} catch (RuntimeException e) {
		}
		try {
			handle.setAttribute("atomRefs24", "a1 a2 a3 a4 a5");
			Assert.fail("should throw invalid attribute");
		} catch (RuntimeException e) {
		}
	}

}
