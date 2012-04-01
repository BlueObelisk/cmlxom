/**
 *    Copyright 2011 Peter Murray-Rust et. al.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package org.xmlcml.cml.base;


import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;

import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.ParsingException;
import nu.xom.ValidityException;

import org.junit.Assert;
import org.junit.Test;

import org.xmlcml.euclid.Util;

/**
 * fundamental parsing (not necessarily involved derived classses.
 * 
 * @author pmr
 * 
 */
public class ElementTest {
	final static String noSchema = "noSchema.xml";

	final static String cml0 = "cml0.xml";

	/**
	 * parse withoout validation.
	 * 
	 * @exception Exception
	 *                problem
	 * 
	 */
	@Test
	public void testParseNoValidate0() throws Exception {
		xomNoValidate(cml0);
		xomNoValidate(noSchema);
	}

	private void xomNoValidate(String file) throws IOException,
			ValidityException, ParsingException {
		Document doc = null;
//		Util.println("  === xom Parse, no validation: " + file + " ====");
		InputStream in = null;

		in = Util.getInputStreamFromResource(CMLXOMTestUtils.BASE_RESOURCE +CMLConstants.U_S + file);
		doc = new Builder().build(in);
		Assert.assertNotNull("document ", doc);
	}

	/**
	 * parse without schema.
	 */
	@Test
	public void testParseXomNoSchema1() {
		InputStream in = null;
		Document doc = null;
		try {
			in = Util.getInputStreamFromResource(CMLXOMTestUtils.BASE_RESOURCE +CMLConstants.U_S + noSchema);
			doc = new Builder().build(in);
			Assert.assertNotNull("document", doc);
		} catch (Exception e) {
			Assert.fail("BUG"+e);
		}
	}

	/**
	 * test namespace scope. This is a know difficulty and this explores the XOM
	 * approach.
	 * 
	 */
	@Test
	public void testNamespaceScope() {
		String s = "<a xmlns:ns='http://foo'><b foo='ns:bar'/></a>";
		Document doc = null;
		try {
			doc = new Builder().build(new StringReader(s));
		} catch (Exception e) {
		}
		Element a = doc.getRootElement();
		Element b = a.getFirstChildElement("b");
		int nsCount = b.getNamespaceDeclarationCount();
		for (int i = 0; i < nsCount; i++) {
			// Util.output("NSPREFIX"+i+"
			// ["+b.getNamespacePrefix(i)+S_RSQUARE);
			// Util.output("NSURI"+i+"
			// ["+b.getNamespaceURI(b.getNamespacePrefix(i))+S_RSQUARE);
		}
		// Util.output("NS: "+b.getNamespaceURI("ns"));
	}

	/**
	 * test removeWhitespaceNodes(Element element).
	 */
	@Test
	public void testRemoveWhitespaceNodesElement() {
		String element0S = "" + "<foo>" + "  <bar>"
				+ "    <plugh>  <br/>  </plugh>" + "  </bar>" + "</foo>" + "";
		Element element0 = CMLXOMTestUtils.parseValidString(element0S);
		String element1S = "<foo><bar><plugh><br/></plugh></bar></foo>";
		Element element1 = CMLXOMTestUtils.parseValidString(element1S);
		CMLXOMTestUtils.assertNotEqualsCanonically("before whitespace", element0,
				element1);
		CMLUtil.removeWhitespaceNodes(element0);
		CMLXOMTestUtils.assertEqualsCanonically("before whitespace ", element0,
				element1);
	}
	
	/**
	 * construct element
	 */
	@Test
	public void testNewCMLElement() {
		CMLElement element = new CMLElement();
		Assert.assertTrue(element instanceof CMLElement);
	}

	/**
	 * construct with correct name but not subclassed class
	 * to be avoided
	 */
	@Test
	public void testNewCMLElementName() {
		CMLElement element = new CMLElement("atom");
		Assert.assertTrue(element instanceof CMLElement);
		Assert.assertEquals("org.xmlcml.cml.base.CMLElement", element.getClass().getName());
	}

	/**
	 * construct element
	 */
	@Test
	public void testNewCMLElementParse() {
		String cmlString = "" +
				"<cml:element xmlns:cml='http://www.xml-cml.org/schema'/>" +
				"";
		CMLElement element = CMLUtil.parseCML(cmlString);
		Assert.assertTrue(element instanceof CMLElement);
	}

	/**
	 * construct element
	 */
	@Test
	public void testNewCMLElementRef() {
		String cmlString = "" +
				"<cml:cml xmlns:cml=\"http://www.xml-cml.org/schema\">" +
				"<cml:element ref=\"a1\"/>" +
				"<cml:atom id=\"a1\" elementType=\"H\"/>" +
				"</cml:cml>" +
				"";
		CMLElement top = CMLUtil.parseCML(cmlString);
		Assert.assertTrue(top instanceof org.xmlcml.cml.element.CMLCml);
		CMLElement element = (CMLElement) top.getChildElements().get(0);
		Assert.assertTrue(element instanceof CMLElement);
		CMLElement atom = (CMLElement) top.getChildElements().get(1);
		Assert.assertTrue(atom instanceof org.xmlcml.cml.element.CMLAtom);
		CMLElement element1 = element.dereferenceRef();
		Assert.assertNotNull(element1);
		Assert.assertTrue(element1 instanceof org.xmlcml.cml.element.CMLAtom);
		// XML should be unchanged but isn't yet
//		Assert.assertEquals("xml", cmlString, top.toXML());
	}
		/**
	<cml xmlns="http://www.xml-cml.org/schema" xmlns:cml="http://www.xml-cml.org/schema">
	  <element xmlns="" ref="a1" />
	  <atom id="a1" elementType="H" />
	</cml>
		 */
		
		/**
		 * construct element
		 */
		@Test
		public void testNewCMLElementRefCopy() {
			String cmlString = "" +
					"<cml:cml xmlns:cml=\"http://www.xml-cml.org/schema\">" +
					"<cml:element ref=\"a1\"/>" +
					"<cml:atom id=\"a1\" elementType=\"H\"/>" +
					"</cml:cml>" +
					"";
			CMLElement top = CMLUtil.parseCML(cmlString);
			CMLElement element = (CMLElement) top.getChildElements().get(0);
			CMLElement element1 = element.dereferenceRefCopyReplace();
			Assert.assertNotNull(element1);
			Assert.assertTrue(element1 instanceof org.xmlcml.cml.element.CMLAtom);
			CMLElement element2 = (CMLElement) top.getChildElements().get(0);
			Assert.assertTrue(top.getChildElements().get(0) instanceof org.xmlcml.cml.element.CMLAtom);
			
	}
		
	/**
	 * construct element
	 */
	@Test
	public void testNewCMLElementRefsCopy() {
		String cmlString = "" +
				"<cml:cml xmlns:cml=\"http://www.xml-cml.org/schema\">" +
				"<cml:element ref=\"a1\" id='r1'/>" +
				"<cml:element ref=\"a1\" id='r2'/>" +
				"<cml:element ref=\"a3\" id='r3'/>" +
				"<cml:atom id=\"a1\" elementType=\"H\"/>" +
				"<cml:atom id=\"a3\" elementType=\"H\"/>" +
				"</cml:cml>" +
				"";
		CMLElement top = CMLUtil.parseCML(cmlString);
		top.dereferenceRefsCopyReplace();
			
	}
		
	/**
	 * dereference URL
	 */
	@Test
	public void testNewCMLElementRefsCopyURL() {
		String cmlString = "" +
				"<cml:cml xmlns:cml=\"http://www.xml-cml.org/schema\">" +
				"<cml:element ref='http://wwmm.ch.cam.ac.uk/crystaleye/summary/acta/e/2008/02-00/data/bg2147/bg2147sup1_I/bg2147sup1_I.complete.cml.xml'/>" +
				"</cml:cml>" +
				"";
		CMLElement top = CMLUtil.parseCML(cmlString);
		top.dereferenceRefsCopyReplace();
		Assert.assertEquals("nodes", 361, top.query("//cml:scalar", CMLConstants.CML_XPATH).size());
	}
	
	/**
	 * dereference File - element is an untyped pointer
	 */
	@Test
	public void testNewCMLElementRefsCopyFile() {
		String cmlString = "" +
				"<cml:cml xmlns:cml=\"http://www.xml-cml.org/schema\">" +
				"<cml:element ref='src/test/resources/org/xmlcml/cml/element/examples/complex/castep2.xml'/>" +
				"</cml:cml>" +
				"";
		CMLElement top = CMLUtil.parseCML(cmlString);
		top.dereferenceRefsCopyReplace();
		Assert.assertEquals("nodes", 9, top.query("//cml:metadata", CMLConstants.CML_XPATH).size());
			
	}
	
	
	/**
	 * dereference File - cml is an untyped pointer
	 */
	@Test
	public void testNewCMLElementRefsCopyFileTyped() {
		String cmlString = "" +
				"<cml:cml xmlns:cml=\"http://www.xml-cml.org/schema\">" +
				"<cml:cml ref='src/test/resources/org/xmlcml/cml/element/examples/complex/castep2.xml'/>" +
				"</cml:cml>" +
				"";
		CMLElement top = CMLUtil.parseCML(cmlString);
		top.dereferenceRefsCopyReplace();
		Assert.assertEquals("nodes", 9, top.query("//cml:metadata", CMLConstants.CML_XPATH).size());
			
	}
	
	/**
	 * dereference File - cml is an untyped pointer
	 */
	@Test
	public void testNewCMLElementRefsCopyFileBadlyTyped() {
		String cmlString = "" +
				"<cml:cml xmlns:cml=\"http://www.xml-cml.org/schema\">" +
				"<cml:molecule ref='src/test/resources/org/xmlcml/cml/element/examples/complex/castep2.xml'/>" +
				"</cml:cml>" +
				"";
		CMLElement top = CMLUtil.parseCML(cmlString);
		top.dereferenceRefsCopyReplace();
		Assert.assertEquals("nodes", 0, top.query("//cml:metadata", CMLConstants.CML_XPATH).size());
			
	}
	
	@Test
	public void testDereferenceMoleculeBonds() {
		String ccS = "" +
			"<cml xmlns='http://www.xml-cml.org/schema' xmlns:cmlx='http://www.xml-cml.org/schema/cmlx'>" +
			"  <molecule id='water'>" +
			"    <atomArray>" +
			"      <atom id='a1' elementType='O'/>" +
			"      <atom id='a2' elementType='H'/>" +
			"      <atom id='a3' elementType='H'/>" +
			"    </atomArray>" +
			"    <bondArray>" +
			"      <bond id='a1_a2' atomRefs2='a1 a2'/>" +
			"      <bond id='a1_a3' atomRefs2='a1 a3'/>" +
			"    </bondArray>" +
			"  </molecule>" +
			"  <list id='waterBonds' ref='water'>" +
			"    <cmlx:bond/>" +
			"  </list>" +
			"</cml>";
		CMLElement cml = CMLUtil.parseCML(ccS);
		cml.dereferenceRefsCopyReplace();
		Assert.assertEquals("xxx", 2, cml.query("//cml:bond", CMLConstants.CML_XPATH).size());
//		cml.debug("mol");
	}

}
