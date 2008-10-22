package org.xmlcml.cml.command;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

public class FormulaTest {
	private static Logger LOG = Logger.getLogger(FormulaTest.class);
	static {
		LOG.setLevel(Level.DEBUG);
	}
	@Test
	public void testFormulaAssertions() {
//		"@count or not(ancestor::cml:formula)",
//		"not(@count) or (floor(@count) = number(@count))",
		// ok
		Handle handle = new ElementCommand().readCML(
				"<formula count='2' xmlns='http://www.xml-cml.org/schema'/>");
		handle.elementNG.validateAssertions(handle.getElement());
		// non-integer count
		// "not(@count) or (floor(@count) = number(@count))",
		handle = new ElementCommand().readCML(
			"<formula count='2.1' xmlns='http://www.xml-cml.org/schema'/>");
		TestUtils.testInvalidAssertions(handle, 
				"fails assertion: not(@count) or (floor(@count) = number(@count))");
		// valid if no ancestor and no count
		//		"@count or not(ancestor::cml:formula)",
		handle = new ElementCommand().readCML(
			"<formula xmlns='http://www.xml-cml.org/schema'/>");
		handle.elementNG.validateAssertions(handle.getElement());
		
		// valid for ancestor formula 
		// "@count or not(ancestor::cml:formula)",
		handle = new ElementCommand().readCML(
			"<formula xmlns='http://www.xml-cml.org/schema'><formula/></formula>");
		handle.elementNG.validateAssertions(handle.getElement());
		// invalid for child formula without count
		// "@count or not(ancestor::cml:formula)",
		handle = new ElementCommand().readXML(
			"<formula id='f1' xmlns='http://www.xml-cml.org/schema'><formula id='f2'/></formula>", "./cml:formula");
		TestUtils.testInvalidAssertions(handle, 
				"fails assertion: @count or not(ancestor::cml:formula)");
		// valid for child formula with count
		// "@count or not(ancestor::cml:formula)",
		handle = new ElementCommand().readXML(
			"<formula id='f1' xmlns='http://www.xml-cml.org/schema'><formula count='2' id='f2'/></formula>", "./cml:formula");
		handle.elementNG.validateAssertions(handle.getElement());
	}

	@Test
	public void testFormulaReports() {
		// "not(@concise)",
		// ok
		String xml = "<formula concise='C 1 H 2 Cl 2' xmlns='http://www.xml-cml.org/schema'/>";
		Handle handle = new ElementCommand().readCML(xml);
		handle.elementNG.validateReports(handle.getElement());
		// concise missing
		// "not(@concise)",
		xml = "<formula xmlns='http://www.xml-cml.org/schema'/>";
		handle = new ElementCommand().readCML(xml);
		try {
			handle.elementNG.validateReports(handle.getElement());
			Assert.fail("should fail assertion");
		} catch (RuntimeException e) {
		}
	}}
