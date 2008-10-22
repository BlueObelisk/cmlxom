package org.xmlcml.cml.command;

import nu.xom.Element;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.xmlcml.cml.base.CMLUtil;

public class ElementCommandTest {
	private static Logger LOG = Logger.getLogger(ElementCommandTest.class);
	static {
		LOG.setLevel(Level.DEBUG);
		
	}
	@Test
	public void testReadXMLString() {
		// parse XML for root element
		String xmlString = "<atom id='a1' xmlns='http://www.xml-cml.org/schema'/>";
		Handle atomHandle = new ElementCommand().readCML(xmlString);
		Assert.assertNotNull("handle", atomHandle);
		Element element = atomHandle.getElement();
		Assert.assertNotNull("element", element);
		String message = CMLUtil.equalsCanonically(xmlString, element, true);
		Assert.assertNull("parse", message);
		
		// parse larger tree 
		xmlString = "<cml xmlns='http://www.xml-cml.org/schema'><atom id='a1'/></cml>";
		Handle cmlHandle = new ElementCommand().readCML(xmlString);
		Assert.assertNotNull("handle", cmlHandle);
		element = cmlHandle.getElement();
		Assert.assertNotNull("element", element);
		String cmlString = "<cml xmlns='http://www.xml-cml.org/schema'><atom id='a1'/></cml>";
		message = CMLUtil.equalsCanonically(cmlString, element, true);
		Assert.assertNull("parse", message);

		// use CML namespace explicitly
		xmlString = "<cml:atom id='a1' xmlns:cml='http://www.xml-cml.org/schema'/>";
		atomHandle = new ElementCommand().readCML(xmlString);
		Assert.assertNotNull("handle", atomHandle);
		element = atomHandle.getElement();
		Assert.assertNotNull("element", element);
		message = CMLUtil.equalsCanonically(xmlString, element, true);
		Assert.assertNull("parse", message);
		
		// use CML namespace implicitly
		xmlString = "<atom id='a1' xmlns='http://www.xml-cml.org/schema'/>";
		atomHandle = new ElementCommand().readCML(xmlString);
		Assert.assertNotNull("handle", atomHandle);
		element = atomHandle.getElement();
		Assert.assertNotNull("element", element);
		message = CMLUtil.equalsCanonically(xmlString, element, true);
		Assert.assertNull("parse", message);
		
	}

	@Test
	public void testReadXMLStringString() {
		// parse XML and extract first node satisfying xpath
		Handle atomHandle = new ElementCommand().readXML(
				"<foo><atom id='a1' xmlns='http://www.xml-cml.org/schema'/></foo>", "./cml:atom");
		Assert.assertNotNull("handle", atomHandle);
		Element element = atomHandle.getElement();
		Assert.assertNotNull("element", element);
		String message = CMLUtil.equalsCanonically(
				"<atom id='a1' xmlns='http://www.xml-cml.org/schema'/>", element, true);
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

}
	