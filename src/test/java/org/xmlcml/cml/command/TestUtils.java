package org.xmlcml.cml.command;

import static org.xmlcml.cml.base.CMLConstants.CML_XPATH;
import nu.xom.Element;
import nu.xom.Nodes;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.xmlcml.cml.base.CMLUtil;

public abstract class TestUtils {
	private static Logger LOG = Logger.getLogger(TestUtils.class);
	static {
		LOG.setLevel(Level.DEBUG);
	}

	public static void createElementAndTestValidAttribute(String elementName, String attName, String attValue) {
		Handle handle = new ElementCommand().createElement(elementName);
		try {
			handle.setAttribute(attName, attValue);
		} catch (Exception e) {
			Assert.fail("should never throw: "+e);
		}
	}
	
	public static void createElementAndTestInvalidAttribute(String elementName, String attName, String attValue, String message) {
		Handle handle = new ElementCommand().createElement(elementName);
		testInvalidAttribute(handle, attName, attValue, message);
	}

	public static void testInvalidAttribute(Handle handle, String attName, String attValue, String message) {
		try {
			handle.setAttribute(attName, attValue);
			Assert.fail("should throw invalid attribute");
		} catch (RuntimeException e) {
			Assert.assertEquals("failed to set attribute", message, e.getMessage().toString());
		}
	}

	/** tests setting valid attribute.
	 * 
	 * @param handle
	 * @param title of error
	 * @param attName
	 * @param attValue
	 * @param expected value of xmlString (tested canonically)
	 * @throws RuntimeException if null arguments
	 */
	public static void testValidAttribute(Handle handle, String title, String attName, String attValue, String expected) {
		if (handle == null) {
			throw new RuntimeException("null handle");
		}
		try {
			handle.setAttribute(attName, attValue);
		} catch (Exception e) {
			Assert.fail("Failed to set valid attribute: "+e);
		}
		String message = CMLUtil.equalsCanonically(expected, handle.getElement(), true);
		if (message != null) {
			Assert.fail(title+":"+message);
		}
	}

	/**
	 * @param handle
	 */
	static void testValidAssertions(Element element) {
		try {
			getElementNG(element).validateAssertions(element());
		} catch (RuntimeException e) {
			Assert.fail("should not fail assertion "+e.getMessage().toString());
		}
	}
	/**
	 * @param handle
	 */
	static void testValidAssertions(Handle handle) {
		try {
			handle.elementNG.validateAssertions(handle.getElement());
		} catch (RuntimeException e) {
			Assert.fail("should not fail assertion "+e.getMessage().toString());
		}
	}

	/**
	 * @param handle
	 */
	static void testInvalidAssertions(Handle handle, String message) {
		try {
			handle.elementNG.validateAssertions(handle.getElement());
			Assert.fail("should fail assertion");
		} catch (RuntimeException e) {
			Assert.assertEquals("failed assertion", message, e.getMessage().toString());
		}
	}

	/**
	 * @param atomHandle
	 */
	public static void testInvalidContent(Handle atomHandle) {
		try {
			atomHandle.elementNG.validateContentModel(atomHandle.getElement());
			Assert.fail("should fail on invalid content");
		} catch (RuntimeException e) {
			
		}
	}

	/**
	 * @param atomHandle
	 */
	public static void testValidContent(Handle atomHandle) {
		atomHandle.elementNG.validateContentModel(atomHandle.getElement());
	}

	/**
	 * @param element
	 * @param assertion
	 * @throws RuntimeException if fails assertion
	 */
	public static void validateAssertion(Element element, String assertion)
			throws RuntimeException {
		String query = ".["+assertion+"]";
		Nodes nodes = element.query(query, CML_XPATH);
		if (nodes.size() == 1) {
			LOG.debug("did not fail: "+assertion);
		} else {
			LOG.debug("fails (nodes="+nodes.size()+"): "+assertion);
			throw new RuntimeException("fails assertion: "+assertion);
		}
	}

	/**
	 * @param element
	 * @param report
	 * @throws RuntimeException if 
	 */
	public static void validateReport(Element element, String report)
			throws RuntimeException {
		String query = ".[not("+report+")]";
		Nodes nodes = element.query(query, CML_XPATH);
		if (nodes.size() == 1) {
			LOG.debug("did not fail: "+report);
		} else {
			LOG.debug("fails (nodes="+nodes.size()+"): "+report);
			throw new RuntimeException("fails report: "+report);
		}
	}
	
	public static ElementNG getElementNG(Element element) {
		return ElementNG.ELEMENTMAP.get(element.getLocalName());
	}
}
