package org.xmlcml.cml.command;

import nu.xom.Element;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.xmlcml.cml.base.CMLUtil;

public class ElementCommandTest {
	private static Logger LOG = Logger.getLogger(ElementCommandTest.class);
	@Test
	public void testReadXMLString() {
		// parse XML for root element
		String xmlString = "<atom id='a1'/>";
		Handle atomHandle = new ElementCommand().readXML(xmlString);
		Assert.assertNotNull("handle", atomHandle);
		Element element = atomHandle.getElement();
		Assert.assertNotNull("element", element);
		String message = CMLUtil.equalsCanonically(xmlString, element, true);
		Assert.assertNull("parse", message);
		
		// parse larger tree 
		xmlString = "<cml><atom id='a1'/></cml>";
		Handle cmlHandle = new ElementCommand().readXML(xmlString);
		Assert.assertNotNull("handle", cmlHandle);
		element = cmlHandle.getElement();
		Assert.assertNotNull("element", element);
		String cmlString = "<cml><atom id='a1'/></cml>";
		message = CMLUtil.equalsCanonically(cmlString, element, true);
		Assert.assertNull("parse", message);

		// use CML namespace explicitly
		xmlString = "<cml:atom id='a1' xmlns:cml='http://www.xml-cml.org/schema'/>";
		atomHandle = new ElementCommand().readXML(xmlString);
		Assert.assertNotNull("handle", atomHandle);
		element = atomHandle.getElement();
		Assert.assertNotNull("element", element);
		message = CMLUtil.equalsCanonically(xmlString, element, true);
		Assert.assertNull("parse", message);
		
		// use CML namespace implicitly
		xmlString = "<atom id='a1' xmlns='http://www.xml-cml.org/schema'/>";
		atomHandle = new ElementCommand().readXML(xmlString);
		Assert.assertNotNull("handle", atomHandle);
		element = atomHandle.getElement();
		Assert.assertNotNull("element", element);
		message = CMLUtil.equalsCanonically(xmlString, element, true);
		Assert.assertNull("parse", message);
		
	}

	@Test
	public void testReadXMLStringString() {
		// parse XML and extract first node satisfying xpath
		String xmlString = "<foo><atom id='a1'/></foo>";
		Handle atomHandle = new ElementCommand().readXML(xmlString, "./atom");
		Assert.assertNotNull("handle", atomHandle);
		Element element = atomHandle.getElement();
		Assert.assertNotNull("element", element);
		String atomString = "<atom id='a1'/>";
		String message = CMLUtil.equalsCanonically(atomString, element, true);
		Assert.assertNull("parse", message);
	}

	@Test
	public void testCreateElement() {
		Handle atomHandle = new ElementCommand().createElement("atom");
		Assert.assertNotNull("handle", atomHandle);
		Element element = atomHandle.getElement();
		Assert.assertNotNull("element", element);
		String atomString = "<atom xmlns='http://www.xml-cml.org/schema'/>";
		String message = CMLUtil.equalsCanonically(atomString, element, true);
		Assert.assertNull("parse", message);
	}

	@Test
	public void testAttribute() {
		// set attribute
		Handle atomHandle = new ElementCommand().createElement("atom");
		atomHandle.setAttribute("id", "a1");
		String atomString = "<atom id='a1' xmlns='http://www.xml-cml.org/schema'/>";
		String message = CMLUtil.equalsCanonically(atomString, atomHandle.getElement(), true);
		Assert.assertNull("parse", message);
		// unset attribute
		atomHandle.unsetAttribute("id");
		atomString = "<atom xmlns='http://www.xml-cml.org/schema'/>";
		message = CMLUtil.equalsCanonically(atomString, atomHandle.getElement(), true);
		Assert.assertNull("parse", message);
		// reset attribute (direct change is not allowed for id in JUMBO)
		atomHandle.setAttribute("id", "a2");
		atomString = "<atom id='a2' xmlns='http://www.xml-cml.org/schema'/>";
		message = CMLUtil.equalsCanonically(atomString, atomHandle.getElement(), true);
		Assert.assertNull("parse", message);
		// now some not allowed
		// missing attribute
		try {
			atomHandle.setAttribute("dataType", "xsd:double");
			Assert.fail("should fail with forbidden attribute");
		} catch (RuntimeException e) {
		}
		// ok
		atomHandle.setAttribute("elementType", "N");
		atomString = "<atom id='a2' elementType='N' xmlns='http://www.xml-cml.org/schema'/>";
		message = CMLUtil.equalsCanonically(atomString, atomHandle.getElement(), true);
		Assert.assertNull("parse", message);
		// allowed change
		atomHandle.setAttribute("elementType", "O");
		atomString = "<atom id='a2' elementType='O' xmlns='http://www.xml-cml.org/schema'/>";
		message = CMLUtil.equalsCanonically(atomString, atomHandle.getElement(), true);
		Assert.assertNull("parse", message);
		// forbidden
		try {
			atomHandle.setAttribute("elementType", "Xy");
			Assert.fail("should fail with forbidden attribute");
		} catch (RuntimeException e) {
		}
		// ok
		atomHandle.setAttribute("formalCharge", "1");
		atomString = "<atom id='a2' formalCharge='1' elementType='O' xmlns='http://www.xml-cml.org/schema'/>";
		message = CMLUtil.equalsCanonically(atomString, atomHandle.getElement(), true);
		Assert.assertNull("parse", message);
		// forbidden
		try {
			atomHandle.setAttribute("formalCharge", "X");
			Assert.fail("should fail with forbidden attribute");
		} catch (RuntimeException e) {
		}
		// ok
		atomHandle.setAttribute("isotopeNumber", "12");
		atomString = "<atom id='a2' isotopeNumber='12' formalCharge='1' elementType='O' xmlns='http://www.xml-cml.org/schema'/>";
		message = CMLUtil.equalsCanonically(atomString, atomHandle.getElement(), true);
		Assert.assertNull("parse", message);
		// forbidden
		try {
			atomHandle.setAttribute("isotopeNumber", "-1");
			Assert.fail("should fail with forbidden attribute");
		} catch (RuntimeException e) {
		}
		// forbidden
		try {
			atomHandle.setAttribute("isotopeNumber", "Z");
			Assert.fail("should fail with forbidden attribute");
		} catch (RuntimeException e) {
		}
	}
	
	@Test
	public void testAppend() {
		Handle atomHandle = new ElementCommand().createElement("atom");
		atomHandle.setAttribute("id", "a1");
		Handle cmlHandle = new ElementCommand().createElement("cml");
		cmlHandle.setAttribute("id", "c1");
		cmlHandle.appendChild(atomHandle);
		String cmlString = "<cml id='c1' xmlns='http://www.xml-cml.org/schema'><atom id='a1'/></cml>";
		String message = CMLUtil.equalsCanonically(cmlString, cmlHandle.getElement(), true);
		Assert.assertNull("parse", message);
		//
	}
	
	@Test
	public void testAtomRefsInSchema() {
//		ATOMREFS = new AttributeNG("atomRefs", TypeNG.REF_TYPE, -1);
	}
	
	@Test
	public void testAtomRefs2InSchema() {
//		ATOMREFS2 = new AttributeNG("atomRefs2", TypeNG.REF_TYPE, 2);
		String xmlString = "<bond id='b1'/>";
		Handle handle = new ElementCommand().readXML(xmlString);
		handle.setAttribute("atomRefs2", "a1 a2");
		String message = CMLUtil.equalsCanonically(
			"<bond id='b1' atomRefs2='a1 a2'/>", handle.getElement(), true);
		Assert.assertNull("atomRefs2", message);
		try {
			handle.setAttribute("atomRefs2", "a1 a2 a2");
			Assert.fail("should throw invalid attribute");
		} catch (RuntimeException e) {
		}
	}

	@Test
	public void testAtomRefs4InSchema() {
//		ATOMREFS4 = new AttributeNG("atomRefs4", TypeNG.REF_TYPE, 4);
		String xmlString = "<bondStereo id='b1'/>";
		Handle handle = new ElementCommand().readXML(xmlString);
		handle.setAttribute("atomRefs4", "a1 a2 a3 a4");
		String message = CMLUtil.equalsCanonically(
			"<bondStereo id='b1' atomRefs4='a1 a2 a3 a4'/>", handle.getElement(), true);
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
		xmlString = "<atomParity id='b1'/>";
		handle = new ElementCommand().readXML(xmlString);
		handle.setAttribute("atomRefs4", "a1 a2 a3 a4");
		message = CMLUtil.equalsCanonically(
			"<atomParity id='b1' atomRefs4='a1 a2 a3 a4'/>", handle.getElement(), true);
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
//		BONDREFS = new AttributeNG("bondRefs", TypeNG.REF_TYPE, -1);
//		CHIRALITY = new AttributeNG("chirality", TypeNG.CHIRALITY_TYPE);
//		CONCISE = new AttributeNG("concise", TypeNG.FORMULA_TYPE);
//		CONVENTION = new AttributeNG("convention", TypeNG.REF_TYPE);
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
	