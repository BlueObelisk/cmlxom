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
	}

	// cannot test this easily as JUMBO has many checks on bonds
//	@Test
//	public void testAtomRefs2InSchema() {
////		ATOMREFS2 = new AttributeNG("atomRefs2", TypeNG.REF_TYPE, 2);
//		String xmlString = "<molecule xmlns='http://www.xml-cml.org/schema'><bondArray><bond atomRefs2='a1 a2' id='b1'/></bondArray></molecule>";
//		Handle handle = new ElementCommand().readXML(xmlString);
//		try {
//			handle.setAttribute("atomRefs2", "a1 a2 a3");
//			Assert.fail("should throw invalid attribute");
//		} catch (RuntimeException e) {
//		}
//	}

	@Test
	public void testAtomRefs4InSchema() {
//		ATOMREFS4 = new AttributeNG("atomRefs4", TypeNG.REF_TYPE, 4);
		String xmlString = "<bondStereo id='b1' xmlns='http://www.xml-cml.org/schema'/>";
		Handle handle = new ElementCommand().readXML(xmlString);
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
		xmlString = "<atomParity id='b1' xmlns='http://www.xml-cml.org/schema'/>";
		handle = new ElementCommand().readXML(xmlString);
		handle.setAttribute("atomRefs4", "a1 a2 a3 a4");
		message = CMLUtil.equalsCanonically(
			"<atomParity id='b1' atomRefs4='a1 a2 a3 a4' xmlns='http://www.xml-cml.org/schema'/>", handle.getElement(), true);
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
	@Test
	public void testBondRefsInSchema() {
//		BONDREFS = new AttributeNG("bondRefs", TypeNG.REF_TYPE, -1);
		String xmlString = "<peak id='p1' xmlns='http://www.xml-cml.org/schema'/>";
		Handle handle = new ElementCommand().readXML(xmlString);
		handle.setAttribute("bondRefs", "b1 b2");
		String message = CMLUtil.equalsCanonically(
			"<peak id='p1' bondRefs='b1 b2' xmlns='http://www.xml-cml.org/schema'/>", handle.getElement(), true);
		Assert.assertNull("bondRefs", message);
	}
	
	@Test
	public void testChiralityInSchema() {
//		CHIRALITY = new AttributeNG("chirality", TypeNG.CHIRALITY_TYPE);
		String xmlString = "<molecule xmlns='http://www.xml-cml.org/schema'/>";
		Handle handle = new ElementCommand().readXML(xmlString);
		handle.setAttribute("chirality", "enantiomer");
		String message = CMLUtil.equalsCanonically(
			"<molecule chirality='enantiomer' xmlns='http://www.xml-cml.org/schema'/>", handle.getElement(), true);
		Assert.assertNull("chirality", message);
		try {
			handle.setAttribute("chirality", "JUNK");
			Assert.fail("should throw invalid attribute");
		} catch (RuntimeException e) {
		}
	}
	
	@Test
	public void testConciseInSchema() {
//		CONCISE = new AttributeNG("concise", TypeNG.FORMULA_TYPE);
		String xmlString = "<formula xmlns='http://www.xml-cml.org/schema'/>";
		Handle handle = new ElementCommand().readXML(xmlString);
		handle.setAttribute("concise", "C 1 H 1 O 2 -1");
		// concise adds formalCharge and children 
		String message = CMLUtil.equalsCanonically(
			"<formula concise='C 1 H 1 O 2' formalCharge='-1' xmlns='http://www.xml-cml.org/schema'><atomArray elementType='C H O' count='1.0 1.0 2.0'/></formula>", handle.getElement(), true);
		System.out.println("M "+message);
		Assert.assertNull("concise", message);
		xmlString = "<formula xmlns='http://www.xml-cml.org/schema'/>";
		handle = new ElementCommand().readXML(xmlString);
		handle.setAttribute("concise", "C 1 H 1 O 2");
		// concise adds formalCharge
		message = CMLUtil.equalsCanonically(
			"<formula concise='C 1 H 1 O 2' xmlns='http://www.xml-cml.org/schema'><atomArray elementType='C H O' count='1.0 1.0 2.0'/></formula>", handle.getElement(), true);
		Assert.assertNull("concise", message);
		try {
			handle.setAttribute("concise", "C 1 H 1 O 2 1-");
			Assert.fail("should throw invalid attribute");
		} catch (RuntimeException e) {
		}
	}
	
	@Test
	public void testConventionInSchema() {
//		CONVENTION = new AttributeNG("convention", TypeNG.REF_TYPE);
		String xmlString = "<cml xmlns='http://www.xml-cml.org/schema'/>";
		Handle handle = new ElementCommand().readXML(xmlString);
		handle.setAttribute("convention", "CMLLite");
		String message = CMLUtil.equalsCanonically(
			"<cml convention='CMLLite' xmlns='http://www.xml-cml.org/schema'/>", handle.getElement(), true);
		Assert.assertNull("convention", message);
		xmlString = "<cml xmlns='http://www.xml-cml.org/schema'/>";
		handle = new ElementCommand().readXML(xmlString);
		handle.setAttribute("convention", "iucr:cif");
		message = CMLUtil.equalsCanonically(
			"<cml convention='iucr:cif' xmlns='http://www.xml-cml.org/schema'/>", handle.getElement(), true);
		Assert.assertNull("convention", message);
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