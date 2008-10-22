package org.xmlcml.cml.command;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.xmlcml.cml.base.CMLUtil;

public class AtomParityTest {
	private static Logger LOG = Logger.getLogger(AtomParityTest.class);
	static {
		LOG.setLevel(Level.DEBUG);
	}
	
	//
	@Test
	public void createFromXML() {
		Handle handle = new ElementCommand().readCML("<atomParity id='b1' xmlns='http://www.xml-cml.org/schema'/>");
		TestUtils.testValidAttribute(handle, "test atomRefs4", "atomRefs4", "a1 a2 a3 a4",
			"<atomParity id='b1' atomRefs4='a1 a2 a3 a4' xmlns='http://www.xml-cml.org/schema'/>");
		TestUtils.testInvalidAttribute(handle, "atomRefs24", "a1 a2 a3", "Unknown attribute name: atomRefs24");
		TestUtils.testInvalidAttribute(handle, "atomRefs4", "a1 a2 a3 a4 a5", "inconsistent attribute list: (5 != 4)");
	}

}
