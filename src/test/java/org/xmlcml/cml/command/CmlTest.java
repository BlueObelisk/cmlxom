package org.xmlcml.cml.command;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.xmlcml.cml.base.CMLUtil;

public class CmlTest {
	private static Logger LOG = Logger.getLogger(CmlTest.class);
	static {
		LOG.setLevel(Level.DEBUG);
	}
/**
  <pattern id="cml.checks">
    <title>CML element checks</title>
    <p><h:p>Describe what further limitations we have put on the cml element</h:p></p>
    <rule context="cml:cml">
      <assert test="@convention or ancestor::cml:cml">the eldest cml element must have @convention</assert>
      <assert test="@version or ancestor::cml:cml">the eldest cml element must have @version</assert>
      <p>
      This schematron is designed to validate CMLLite, therefore if the convention is not CMLLite we should be worried - however,
      it is possible that we want to validate more than just CMLLite (many of the restrictions placed on ordering etc make it 
      easier to use this form of CML rather than the more general form) maybe we can introduce a flag to turn on CMLLite validation
      or looser validation
      </p>
      <assert test="(@convention = 'CMLLite') or ancestor::cml:cml">'CMLLite' expected as @convention on the eldest cml element</assert>
    </rule>
  </pattern>
 */	
	
	//
	@Test
	public void createFromXML() {
		Handle handle = new ElementCommand().readCML("<cml xmlns='http://www.xml-cml.org/schema'/>");
		TestUtils.testValidAttribute(handle, "test convention", "convention", "CMLLite",
			"<cml convention='CMLLite' xmlns='http://www.xml-cml.org/schema'/>");
		TestUtils.testInvalidAttribute(handle, "atomRefs24", "a1 a2 a3", "Unknown attribute name: atomRefs24");
		TestUtils.testInvalidAttribute(handle, "atomRefs4", "a1 a2 a3 a4 a5", "atomRefs4 attribute not allowed on: cml");
	}
}
