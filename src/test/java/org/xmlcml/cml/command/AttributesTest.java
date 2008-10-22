package org.xmlcml.cml.command;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.xmlcml.cml.base.CMLUtil;

public class AttributesTest {
	private static Logger LOG = Logger.getLogger(AttributesTest.class);
	static {
		LOG.setLevel(Level.DEBUG);
	}
	
	@Test
	public void testAtomRefsInSchema() {
//		ATOMREFS = new AttributeNG("atomRefs", TypeNG.REF_TYPE, -1);
		TestUtils.createElementAndTestValidAttribute("peak", "atomRefs", "a1 a2");
		TestUtils.createElementAndTestValidAttribute("peak", "atomRefs", "a1 a2 a3");
	}

	//
	@Test
	public void testAtomRefs2InSchema() {
//		ATOMREFS2 = new AttributeNG("atomRefs2", TypeNG.REF_TYPE, 2);
		TestUtils.createElementAndTestValidAttribute("bond", "atomRefs2", "a1 a2");
		TestUtils.createElementAndTestInvalidAttribute("bond", "atomRefs2", "a1 a2 a3", "inconsistent attribute list: (3 != 2)");
	}

	@Test
	public void testAtomRefs4InSchema() {
	}
	@Test
	public void testBondRefsInSchema() {
//		BONDREFS = new AttributeNG("bondRefs", TypeNG.REF_TYPE, -1);
		Handle handle = new ElementCommand().readCML(
				"<peak id='p1' xmlns='http://www.xml-cml.org/schema'/>");
		TestUtils.testValidAttribute(handle, "test bondRefs", "bondRefs", "b1 b2", 
				"<peak id='p1' bondRefs='b1 b2' xmlns='http://www.xml-cml.org/schema'/>");
	}
	
	@Test
	public void testChiralityInSchema() {
//		CHIRALITY = new AttributeNG("chirality", TypeNG.CHIRALITY_TYPE);
		Handle handle = new ElementCommand().readCML(
				"<molecule xmlns='http://www.xml-cml.org/schema'/>");
		TestUtils.testValidAttribute(handle, "test chirality", "chirality", "enantiomer", 
			"<molecule chirality='enantiomer' xmlns='http://www.xml-cml.org/schema'/>");
		TestUtils.testInvalidAttribute(handle, "chirality", "JUNK", "value (JUNK) does not match pattern enantiomer|racemate|unknown|other");
	}
	
	@Test
	public void testConciseInSchema() {
//		CONCISE = new AttributeNG("concise", TypeNG.FORMULA_TYPE);
		Handle handle = new ElementCommand().readCML("<formula xmlns='http://www.xml-cml.org/schema'/>");
		// concise adds formalCharge and children 
		TestUtils.testValidAttribute(handle, "test formula concise", "concise", "C 1 H 1 O 2 -1",
			"<formula concise='C 1 H 1 O 2' formalCharge='-1' xmlns='http://www.xml-cml.org/schema'><atomArray elementType='C H O' count='1.0 1.0 2.0'/></formula>");
		handle = new ElementCommand().readCML(
				"<formula xmlns='http://www.xml-cml.org/schema'/>");
		// concise adds formalCharge
		TestUtils.testValidAttribute(handle, "test formula concise", "concise", "C 1 H 1 O 2",
			"<formula concise='C 1 H 1 O 2' xmlns='http://www.xml-cml.org/schema'><atomArray elementType='C H O' count='1.0 1.0 2.0'/></formula>");
		TestUtils.testInvalidAttribute(handle, "concise", "C 1 H 1 O 2 1-", 
				"value (C 1 H 1 O 2 1-) does not match pattern \\s*([A-Z][a-z]?\\s+(([0-9]+(\\.[0-9]*)?)|(\\.[0-9]*))?\\s*)+(\\s+[\\-|+]?[0-9]+)?\\s*");
	}
	
	@Test
	public void testConventionInSchema() {
//		CONVENTION = new AttributeNG("convention", TypeNG.REF_TYPE);
		Handle handle = new ElementCommand().readCML(
				"<cml xmlns='http://www.xml-cml.org/schema'/>");
		TestUtils.testValidAttribute(handle, "test convention", "convention", "CMLLite",
			"<cml convention='CMLLite' xmlns='http://www.xml-cml.org/schema'/>");
		handle = new ElementCommand().readCML("<cml xmlns='http://www.xml-cml.org/schema'/>");
		TestUtils.testValidAttribute(handle, "test convention", "convention", "iucr:cif",
			"<cml convention='iucr:cif' xmlns='http://www.xml-cml.org/schema'/>");
	}
//		COUNT = new AttributeNG("count", TypeNG.NONNEGATIVEREAL_TYPE);
//		DATATYPE = new AttributeNG("dataType", TypeNG.DATATYPE_TYPE);
//		DICTREF = new AttributeNG("dictRef", TypeNG.REF_TYPE);
//		ELEMENTTYPE = new AttributeNG("elementType", TypeNG.ELEMENTTYPE_TYPE);
//		FORMALCHARGE = new AttributeNG("formalCharge", TypeNG.INTEGER_TYPE);
//		ID = new AttributeNG("id", TypeNG.REF_TYPE);
//		INLINE = new AttributeNG("inline", TypeNG.STRING_TYPE);
//		ISOTOPENUMBER = new AttributeNG("isotopeNumber", TypeNG.POSITIVEINTEGER_TYPE);
//		MAX = new AttributeNG("max", TypeNG.STRING_TYPE);
//		MIN = new AttributeNG("min", TypeNG.STRING_TYPE);
//		NAMESPACE = new AttributeNG("namespace", TypeNG.NAMESPACE_TYPE);
//		ORDER = new AttributeNG("order", TypeNG.ORDER_TYPE);
//		PEAKMULTIPLICITY = new AttributeNG("peakMultiplicity", TypeNG.STRING_TYPE);
//		PEAKSHAPE = new AttributeNG("peakShape", TypeNG.STRING_TYPE);
//		REF = new AttributeNG("ref", TypeNG.REF_TYPE);
//		SPINMULTIPLICITY = new AttributeNG("spinMultiplicity", TypeNG.POSITIVEINTEGER_TYPE);
//		TERM = new AttributeNG("term", TypeNG.STRING_TYPE);
//		TITLE = new AttributeNG("title", TypeNG.STRING_TYPE);
//		UNITS = new AttributeNG("units", TypeNG.REF_TYPE);
//		VERSION = new AttributeNG("version", TypeNG.STRING_TYPE);
//		X2 = new AttributeNG("x2", TypeNG.REALNUMBER_TYPE);
//		X3 = new AttributeNG("x3", TypeNG.REALNUMBER_TYPE);
//		XMAX = new AttributeNG("xMax", TypeNG.REALNUMBER_TYPE);
//		XMIN = new AttributeNG("xMin", TypeNG.REALNUMBER_TYPE);
//		XUNITS = new AttributeNG("xUnits", TypeNG.QNAME_TYPE);
//		XVALUE = new AttributeNG("xValue", TypeNG.REALNUMBER_TYPE);
//		Y2 = new AttributeNG("y2", TypeNG.REALNUMBER_TYPE);
//		Y3 = new AttributeNG("y3", TypeNG.REALNUMBER_TYPE);
//		YUNITS = new AttributeNG("yUnits", TypeNG.QNAME_TYPE);
//		YVALUE = new AttributeNG("yValue", TypeNG.REALNUMBER_TYPE);
//		Z3 = new AttributeNG("z3", TypeNG.REALNUMBER_TYPE);
	


}