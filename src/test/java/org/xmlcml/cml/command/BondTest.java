package org.xmlcml.cml.command;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

public class BondTest {
	private static Logger LOG = Logger.getLogger(BondTest.class);
	static {
		LOG.setLevel(Level.DEBUG);
	}
	
	//
	@Test
	public void createFromXML() {
		String xmlString = "<bond id='b1' xmlns='http://www.xml-cml.org/schema'/>";
		Handle handle = null;
		try {
			handle = new ElementCommand().readCML(xmlString);
			Assert.fail("should throw invalid grandparent"); // why not??????
		} catch (RuntimeException e) {
			Assert.assertEquals("bond grandparent rule", 
					"nu.xom.ParsingException: Bond needs bondArray parent", 
					e.getCause().toString());
		}
		
		try {
			xmlString = "<molecule xmlns='http://www.xml-cml.org/schema'>" +
					"<bondArray><bond id='b1'/></bondArray>" +
					"</molecule>";
			handle = new ElementCommand().readCML(xmlString);
			handle.setAttribute("atomRefs2", "a1 a2 a3");
			Assert.fail("should throw invalid attribute");
		} catch (RuntimeException e) {
			Assert.assertEquals("atomRefs2 required", 
					"nu.xom.ParsingException: bond must have AtomRefs2 or atomRefs",
					e.getCause().toString());
		}
		try {
			xmlString = "<molecule xmlns='http://www.xml-cml.org/schema'><bondArray><bond atomRefs2='a1 a2' id='b1'/></bondArray></molecule>";
			handle = new ElementCommand().readCML(xmlString);
			Assert.fail("should throw invalid attribute");
		} catch (RuntimeException e) {
			Assert.assertEquals("atomRefs2 required", 
					"nu.xom.ParsingException: Cannot index bonds without atoms", 
					e.getCause().toString());
		}
		handle = new ElementCommand().createElement("bond");
		handle.setAttribute("atomRefs2", "a1 a2");
		
	}

}
