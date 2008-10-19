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
	public void testTypes() {
		TypeNG.CHIRALITY_TYPE.validate("enantiomer");
		try {
			TypeNG.CHIRALITY_TYPE.validate("chiral");
			Assert.fail("should throw invalid argument");
		} catch (RuntimeException e) {
		}
		
		TypeNG.DATATYPE_TYPE.validate("xsd:double");
		try {
			TypeNG.DATATYPE_TYPE.validate("xsd:float");
			Assert.fail("should throw invalid argument");
		} catch (RuntimeException e) {
		}
		
		TypeNG.ELEMENTTYPE_TYPE.validate("Na");
		try {
			TypeNG.ELEMENTTYPE_TYPE.validate("Nu");
			Assert.fail("should throw invalid argument");
		} catch (RuntimeException e) {
		}
		
		TypeNG.FORMULA_TYPE.validate("C 1 H 1 O 2 -1");
		try {
			TypeNG.FORMULA_TYPE.validate("C2H4");
			Assert.fail("should throw invalid argument");
		} catch (RuntimeException e) {
		}
		
		TypeNG.INTEGER_TYPE.validate("12");
		try {
			TypeNG.INTEGER_TYPE.validate("12+");
			Assert.fail("should throw invalid argument");
		} catch (RuntimeException e) {
		}
		
		TypeNG.NAMESPACE_TYPE.validate("http://foo.com/");
		try {
			TypeNG.NAMESPACE_TYPE.validate("ftp://foo.com/");
			Assert.fail("should throw invalid argument");
		} catch (RuntimeException e) {
		}
		
		TypeNG.NONNEGATIVEREAL_TYPE.validate("0.123");
		try {
			TypeNG.NONNEGATIVEREAL_TYPE.validate("0.123(3)");
			Assert.fail("should throw invalid argument");
		} catch (RuntimeException e) {
		}
		
		TypeNG.ORDER_TYPE.validate("D");
		try {
			TypeNG.ORDER_TYPE.validate("2");
			Assert.fail("should throw invalid argument");
		} catch (RuntimeException e) {
		}
		
		TypeNG.POSITIVEINTEGER_TYPE.validate("2");
		try {
			TypeNG.POSITIVEINTEGER_TYPE.validate("0");
			Assert.fail("should throw invalid argument");
		} catch (RuntimeException e) {
		}
		
		TypeNG.REALNUMBER_TYPE.validate("1.0E-23");
		try {
			TypeNG.REALNUMBER_TYPE.validate("1.0H-23");
			Assert.fail("should throw invalid argument");
		} catch (RuntimeException e) {
		}
		
		TypeNG.QNAME_TYPE.validate("a:b");
		try {
			TypeNG.QNAME_TYPE.validate("ab");
			Assert.fail("should throw invalid argument");
		} catch (RuntimeException e) {
		}
		
		TypeNG.REF_TYPE.validate("a12");
		try {
			TypeNG.REF_TYPE.validate("12a");
			Assert.fail("should throw invalid argument");
		} catch (RuntimeException e) {
		}
		
		TypeNG.STRING_TYPE.validate("XX");
	}
}
