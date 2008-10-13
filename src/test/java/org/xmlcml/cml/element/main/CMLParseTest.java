package org.xmlcml.cml.element.main;

import java.io.IOException;
import java.io.StringReader;

import nu.xom.Element;
import nu.xom.ParsingException;
import nu.xom.ValidityException;

import org.junit.Assert;
import org.junit.Test;
import org.xmlcml.cml.base.CMLBuilder;
import org.xmlcml.cml.base.CMLElement;

/**
 * 
 * <p>
 * superclass for manage common methods for unit tests
 * </p>
 * 
 * @author Peter Murray-Rust
 * @version 5.0
 * 
 */
public class CMLParseTest {

	CMLBuilder builder = new CMLBuilder();

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLPoint3 parse'
	 */
	@Test
	public void testBasicParse() {
		String xml1S = "<foo/>";
		try {
			Element e = builder.build(new StringReader(xml1S)).getRootElement();
			Assert.assertFalse("non cml", (e instanceof CMLElement));
		} catch (ValidityException e) {
			Assert
					.fail("should not throw validity exception "
							+ e.getMessage());
		} catch (ParsingException e) {
			Assert.fail("should not throw parse exception " + e.getMessage());
		} catch (IOException e) {
			Assert.fail("should not throw IO exception " + e.getMessage());
		} catch (RuntimeException e) {
			Assert.fail("should not throw CMLRuntime exception "
					+ e.getMessage());
		}
		// parsing errors can be caught but XOM seems to print errors on syserr
		// as well
		/*
		 * -- deliberate error, but omit to avoid confusion String xml2S =
		 * "<foo1>"; try { builder.build(new StringReader(xml2S));
		 * Assert.fail("should throw parse exception "); } catch
		 * (ValidityException e) {
		 * Assert.fail("should not throw validity exception "+e.getMessage()); }
		 * catch (ParsingException e) { Assert.assertEquals("parse exception ",
		 * "XML document structures must start and end within the same entity.",
		 * e.getMessage()); } catch (IOException e) {
		 * Assert.fail("should not throw IO exception "+e.getMessage()); } catch
		 * (CMLRuntime e) {
		 * Assert.fail("should not throw CMLRuntime exception "+e.getMessage());
		 * } --
		 */
		/*
		 * -- deliberate error, but omit to avoid confusion String xml3S =
		 * "<foo a='a' a='b'/>"; try { builder.build(new
		 * StringReader(xml3S)).getRootElement();
		 * Assert.fail("should throw parse exception "); } catch
		 * (ValidityException e) {
		 * Assert.fail("should not throw validity exception "+e.getMessage()); }
		 * catch (ParsingException e) { Assert.assertEquals("parse exception ",
		 * "Attribute \"a\" was already specified for element 'foo'.",
		 * e.getMessage()); } catch (IOException e) {
		 * Assert.fail("should not throw IO exception "+e.getMessage()); } catch
		 * (CMLRuntime e) {
		 * Assert.fail("should not throw CMLRuntime exception "+e.getMessage());
		 * } --
		 */
		/*
		 * -- deliberate error, but omit to avoid confusion String xml4S =
		 * "<1foo a='a' a='b'/>"; try { builder.build(new
		 * StringReader(xml4S)).getRootElement();
		 * Assert.fail("should throw parse exception "); } catch
		 * (ValidityException e) {
		 * Assert.fail("should not throw validity exception "+e.getMessage()); }
		 * catch (ParsingException e) { Assert.assertEquals("parse exception ",
		 * "The markup in the document preceding the root element must be well-formed."
		 * , e.getMessage()); } catch (IOException e) {
		 * Assert.fail("should not throw IO exception "+e.getMessage()); } catch
		 * (CMLRuntime e) {
		 * Assert.fail("should not throw CMLRuntime exception "+e.getMessage());
		 * } --
		 */
		String xml5S = "<foo id='1' a='b'/>";
		try {
			builder.build(new StringReader(xml5S)).getRootElement();
		} catch (ValidityException e) {
			Assert
					.fail("should not throw validity exception "
							+ e.getMessage());
		} catch (ParsingException e) {
			Assert.assertEquals("parse exception ",
					"Unprefixed attribute id cannot be in default namespace 1",
					e.getMessage());
		} catch (IOException e) {
			Assert.fail("should not throw IO exception " + e.getMessage());
		} catch (RuntimeException e) {
			Assert.fail("should not throw CMLRuntime exception "
					+ e.getMessage());
		}

		String xml6S = "<foo id='a1' b='b'/>";
		try {
			builder.build(new StringReader(xml6S)).getRootElement();
		} catch (ValidityException e) {
			Assert
					.fail("should not throw validity exception "
							+ e.getMessage());
		} catch (ParsingException e) {
			Assert
					.assertEquals(
							"parse exception ",
							"Unprefixed attribute id cannot be in default namespace a1",
							e.getMessage());
		} catch (IOException e) {
			Assert.fail("should not throw IO exception " + e.getMessage());
		} catch (RuntimeException e) {
			Assert.fail("should not throw CMLRuntime exception "
					+ e.getMessage());
		}

		String xml7S = "<foox b='b'/>";
		try {
			builder.build(new StringReader(xml7S)).getRootElement();
		} catch (ValidityException e) {
			Assert
					.fail("should not throw validity exception "
							+ e.getMessage());
		} catch (ParsingException e) {
			Assert.assertEquals("parse exception ",
					"Unprefixed attribute b cannot be in default namespace b",
					e.getMessage());
		} catch (IOException e) {
			Assert.fail("should not throw IO exception " + e.getMessage());
		} catch (RuntimeException e) {
			Assert.fail("should not throw CMLRuntime exception "
					+ e.getMessage());
		}
	}

	/**
	 * run tests.
	 * 
	 * @return the suite.
	 * 
	 */
}
