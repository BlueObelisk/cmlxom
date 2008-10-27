package org.xmlcml.cml.command;

import static org.xmlcml.cml.base.CMLConstants.CML_XPATH;

import java.util.List;

import nu.xom.Element;
import nu.xom.Nodes;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.xmlcml.cml.base.CMLUtil;
import org.xmlcml.cml.schema.ElementSpecification;

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
			TestUtils.validateAssertions(element);
		} catch (NullPointerException npe) {
			Assert.fail("should not fail npe assertion "+npe.getMessage().toString()+" / "+npe.getCause().toString());
		} catch (RuntimeException e) {
			String mess = (e.getMessage() == null) ? null : e.getMessage().toString();
			String cause = (e.getCause() == null) ? null : e.getCause().toString();
			Assert.fail("should not fail assertion "+mess+" / "+cause);
		}
	}
	/**
	 * @param handle
	 */
	static void testValidAssertions(Handle handle) {
		testValidAssertions(handle.getElement());
	}

	/**
	 * @param element
	 * @param message
	 */
	static void testInvalidAssertions(Element element, String message) {
		try {
			TestUtils.validateAssertions(element);
			Assert.fail("should fail assertion");
		} catch (RuntimeException e) {
			Assert.assertEquals("failed assertion", message, e.getMessage().toString());
		}
	}

	/**
	 * @param handle
	 */
	static void testInvalidAssertions(Handle handle, String message) {
		testInvalidAssertions(handle.getElement(), message);
	}

	/**
	 * @param element
	 */
	public static void testInvalidContent(Element element) {
		try {
			TestUtils.validateContentModel(element);
			Assert.fail("should fail on invalid content");
		} catch (RuntimeException e) {
			
		}
	}

	/**
	 * @param atomHandle
	 */
	public static void testInvalidContent(Handle handle) {
		TestUtils.testInvalidContent(handle.getElement());
	}
	/**
	 * @param element
	 */
	public static void testValidContent(Element element) {
		TestUtils.validateContentModel(element);
	}

	/**
	 * @param handle
	 */
	public static void testValidContent(Handle handle) {
		TestUtils.testValidContent(handle.getElement());
	}

	/**
	 * @param element
	 * @param assertion
	 * @throws RuntimeException if fails assertion
	 */
	public static void validateAssertion(Element element, String assertion)
			throws RuntimeException {
		String query = ".["+assertion+"]";
		Nodes nodes = null;
		try {
			nodes = element.query(query, CML_XPATH);
		} catch (Exception e) {
			throw new RuntimeException("cannot execute xpath: ", e);
		}
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
	
	public static ElementSpecification getElementNG(Element element) {
		return ElementSpecification.ELEMENTMAP.get(element.getLocalName());
	}
	
	
	public static void validateAssertions(Element element) {
		List<String> assertionList = getElementNG(element).getAssertionList();
		for (String assertion : assertionList) {
			LOG.debug("ASS "+assertion);
			TestUtils.validateAssertion(element, assertion);
		}
	}

	public static void validateReports(Element element) {
		List<String> reportList = getElementNG(element).getReportList();
		for (String report : reportList) {
			TestUtils.validateReport(element, report);
		}
	}

	public static void validateContentModel(Element element) {
		List<String> contentModelList = getElementNG(element).getContentModelList();
		for (String model : contentModelList) {
			TestUtils.validateAssertion(element, model);
		}
	}

	/**
	 * @param handle
	 * @return
	 */
	static Element getGrandchild(Handle handle) {
		Element atom = (Element) ((Element)handle.getElement().getChild(0)).getChild(0);
		return atom;
	}
}
