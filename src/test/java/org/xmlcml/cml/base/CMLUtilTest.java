package org.xmlcml.cml.base;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.xmlcml.cml.base.CMLConstants.CML_NS;
import static org.xmlcml.euclid.EuclidConstants.S_EMPTY;
import static org.xmlcml.euclid.EuclidConstants.U_S;
import static org.xmlcml.euclid.test.EuclidTestBase.alwaysFail;
import static org.xmlcml.euclid.test.EuclidTestBase.neverThrow;

import java.io.StringReader;
import java.text.ParseException;
import java.util.List;

import nu.xom.Attribute;
import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Elements;
import nu.xom.Node;
import nu.xom.Text;
import nu.xom.XPathContext;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

/**
 * test CMLUtil.
 * 
 * @author pm286
 * 
 */
public class CMLUtilTest {
	private static Logger LOG = Logger.getLogger(CMLUtilTest.class);

	/**
	 * Test method for 'org.xmlcml.cml.base.CMLUtil.checkPrefixedName(String)'
	 */
	@Test
	public final void testCheckPrefixedName() {
		CMLUtil.checkPrefixedName("foo:name");
		try {
			CMLUtil.checkPrefixedName("name");
			alwaysFail("unprefixed name");
		} catch (Exception e) {
			assertEquals("unprefixed", "Unprefixed name (name)", e.getMessage());
		}
	}

	/**
	 * Test method for 'org.xmlcml.cml.base.CMLUtil.getXMLResource(String)'
	 */
	@Test
	public final void testGetXMLResource() {
		String filename = TstBase.BASE_RESOURCE + U_S + "cml0.xml";
		Document doc = null;
		try {
			doc = CMLUtil.getXMLResource(filename);
		} catch (Exception e) {
			neverThrow(e);
		}
		assertNotNull("doc not null", doc);
	}

	/**
	 * Test method for
	 * {@link org.xmlcml.cml.base.CMLUtil#getChildNodes(nu.xom.Element)}.
	 */
	@Test
	public final void testGetChildNodes() {
		String s = "<foo>abc<bar/>def<bar1>ghi</bar1>jkl</foo>";
		Element root = CMLUtil.parseXML(s);
		List<Node> childNodes = CMLUtil.getChildNodes(root);
		assertEquals("count", 5, childNodes.size());
		assertEquals("class", Text.class, childNodes.get(0).getClass());
		assertEquals("value", "abc", childNodes.get(0).getValue());
		assertEquals("class", Element.class, childNodes.get(1).getClass());
		assertEquals("class", "bar", ((Element) childNodes.get(1))
				.getLocalName());
		assertEquals("value", "", childNodes.get(1).getValue());
		assertEquals("class", Text.class, childNodes.get(2).getClass());
		assertEquals("value", "def", childNodes.get(2).getValue());
		assertEquals("class", Element.class, childNodes.get(3).getClass());
		assertEquals("class", "bar1", ((Element) childNodes.get(3))
				.getLocalName());
		assertEquals("value", "ghi", childNodes.get(3).getValue());
		assertEquals("class", Text.class, childNodes.get(4).getClass());
		assertEquals("value", "jkl", childNodes.get(4).getValue());
	}

	/**
	 * Test method for {@link org.xmlcml.cml.base.CMLUtil#parseXML(String)}.
	 */
	@Test
	public final void testparseXMLString() {
		String s = "<foo>abc<bar/>def<bar1>ghi</bar1>jkl</foo>";
		Element root = CMLUtil.parseXML(s);
		Element root1 = new Element("foo");
		root1.appendChild(new Text("abc"));
		Element bar = new Element("bar");
		root1.appendChild(bar);
		root1.appendChild(new Text("def"));
		Element bar1 = new Element("bar1");
		bar1.appendChild(new Text("ghi"));
		root1.appendChild(bar1);
		root1.appendChild(new Text("jkl"));
		TstBase.assertEqualsCanonically("parseXML", root1, root);

	}

	/**
	 * Test method for
	 * {@link org.xmlcml.cml.base.CMLUtil#getQueryNodes(nu.xom.Node, java.lang.String, nu.xom.XPathContext)}
	 * .
	 */
	@Test
	public final void testGetQueryNodesNodeStringXPathContext() {
		XPathContext XPC = new XPathContext("boo", "http://boo");
		String s = "<foo>abc<boo:bar xmlns:boo='http://boo'>xyz</boo:bar>def<bar>ghi</bar>jkl</foo>";
		Element root = CMLUtil.parseXML(s);
		List<Node> nodeList = CMLUtil.getQueryNodes(root, "/foo");
		assertEquals("nodes", 1, nodeList.size());
		nodeList = CMLUtil.getQueryNodes(root, "//bar");
		assertEquals("nodes", 1, nodeList.size());
		assertEquals("nodes", "ghi", nodeList.get(0).getValue());
		nodeList = CMLUtil.getQueryNodes(root, "//boo:bar", XPC);
		assertEquals("nodes", 1, nodeList.size());
		assertEquals("nodes", "xyz", nodeList.get(0).getValue());
	}

	/**
	 * Test method for
	 * {@link org.xmlcml.cml.base.CMLUtil#getQueryNodes(nu.xom.Node, java.lang.String)}
	 * .
	 */
	@Test
	public final void testGetQueryNodesNodeString() {
		String s = "<foo>abc<bar/>def<bar1>ghi</bar1>jkl</foo>";
		Element root = CMLUtil.parseXML(s);
		List<Node> nodeList = CMLUtil.getQueryNodes(root, ".//text()");
		assertEquals("nodes", 4, nodeList.size());
		nodeList = CMLUtil.getQueryNodes(root, "/*/text()");
		assertEquals("nodes", 3, nodeList.size());
		nodeList = CMLUtil.getQueryNodes(root, "/text()");
		assertEquals("nodes", 0, nodeList.size());
		nodeList = CMLUtil.getQueryNodes(root, "/foo");
		assertEquals("nodes", 1, nodeList.size());
		nodeList = CMLUtil.getQueryNodes(root, "/foo/*");
		assertEquals("nodes", 2, nodeList.size());
	}

	/**
	 * Test method for
	 * {@link org.xmlcml.cml.base.CMLUtil#getFollowingSibling(nu.xom.Node)}.
	 */
	@Test
	public final void testGetFollowingSibling() {
		String s = "<foo>abc<bar/>def<bar1>ghi</bar1>jkl</foo>";
		Element root = CMLUtil.parseXML(s);
		List<Node> nodeList = CMLUtil.getChildNodes(root);
		Node text = nodeList.get(0);
		Node sibNode = CMLUtil.getFollowingSibling(text);
		assertEquals("fsib", "bar", ((Element) sibNode).getLocalName());
		Node bar1 = nodeList.get(3);
		assertEquals("fsib", "bar1", ((Element) bar1).getLocalName());
		sibNode = CMLUtil.getFollowingSibling(bar1);
		assertEquals("fsib", "jkl", sibNode.getValue());
		text = nodeList.get(4);
		sibNode = CMLUtil.getFollowingSibling(text);
		assertNull("fsib", sibNode);
	}

	/**
	 * Test method for
	 * {@link org.xmlcml.cml.base.CMLUtil#getPrecedingSibling(nu.xom.Node)}.
	 */
	@Test
	public final void testGetPrecedingSibling() {
		String s = "<foo>abc<bar/>def<bar1>ghi</bar1>jkl</foo>";
		Element root = CMLUtil.parseXML(s);
		List<Node> nodeList = CMLUtil.getChildNodes(root);
		Node text = nodeList.get(0);
		Node sibNode = CMLUtil.getPrecedingSibling(text);
		assertNull("fsib", sibNode);
		Node bar1 = nodeList.get(3);
		assertEquals("fsib", "bar1", ((Element) bar1).getLocalName());
		sibNode = CMLUtil.getPrecedingSibling(bar1);
		assertEquals("fsib", "def", sibNode.getValue());
		text = nodeList.get(4);
		sibNode = CMLUtil.getFollowingSibling(text);
		assertEquals("fsib", "bar1", ((Element) bar1).getLocalName());
	}

	/**
	 * Test method for
	 * {@link org.xmlcml.cml.base.CMLUtil#getLastTextDescendant(nu.xom.Node)}.
	 */
	@Test
	public final void testGetLastTextDescendant() {
		String s = "<foo>abc<bar/>def<bar1>ghi</bar1>jkl</foo>";
		Element root = CMLUtil.parseXML(s);
		Text text = CMLUtil.getLastTextDescendant(root);
		assertNotNull("text", text);
		assertEquals("text", "jkl", text.getValue());
		s = "<foo><bar1><plugh/></bar1></foo>";
		root = CMLUtil.parseXML(s);
		text = CMLUtil.getLastTextDescendant(root);
		assertNull("text", text);
	}

	/**
	 * Test method for
	 * {@link org.xmlcml.cml.base.CMLUtil#getFirstTextDescendant(nu.xom.Node)}.
	 */
	@Test
	public final void testGetFirstTextDescendant() {
		String s = "<foo>abc<bar/>def<bar1>ghi</bar1>jkl</foo>";
		Element root = CMLUtil.parseXML(s);
		Text text = CMLUtil.getFirstTextDescendant(root);
		assertNotNull("text", text);
		assertEquals("text", "abc", text.getValue());
		s = "<foo><bar1><plugh/></bar1></foo>";
		root = CMLUtil.parseXML(s);
		text = CMLUtil.getFirstTextDescendant(root);
		assertNull("text", text);
	}

	/**
	 * Test method for
	 * {@link org.xmlcml.cml.base.CMLUtil#transferChildren(nu.xom.Element, nu.xom.Element)}
	 * .
	 */
	@Test
	public final void testTransferChildren() {
		String s = ""
				+ "<root><foo>abc<bar/>def<bar1>ghi</bar1>jkl</foo>and<plugh><qqq/>zzz</plugh></root>";
		Element root = CMLUtil.parseXML(s);
		Element foo = (Element) root.getChild(0);
		Element plugh = (Element) root.getChild(2);
		CMLUtil.transferChildren(plugh, foo);
		Element newRoot = CMLUtil.parseXML("<root>"
				+ "<foo>abc<bar/>def<bar1>ghi</bar1>jkl<qqq/>zzz</foo>"
				+ "and<plugh/></root>");
		TstBase.assertEqualsCanonically("new root", root, newRoot);
	}

	/**
	 * Test method for
	 */
	@Test
	public final void testOutput() {
		// no simple test
	}

	/**
	 * Test method for 'org.xmlcml.cml.base.CMLUtil.toArray(Elements, Object[])'
	 */
	@Test
	public final void testToArray() {
		String s = "<foo>abc<bar/>def<bar>ghi</bar>jkl</foo>";
		Element root = CMLUtil.parseXML(s);
		Elements elements = root.getChildElements();
		CMLUtil.toArray(elements, new Element[] {});
	}

	/**
	 * test get prefixes.
	 */
	@Test
	public void testGetPrefixes() {
		Element fragment = new Element("fragment", CML_NS);
		Element fragment1 = new Element("fragment");
		fragment.appendChild(fragment1);
		fragment1.addAttribute(new Attribute("ref", "g:mol"));
		fragment1 = new Element("fragment");
		fragment.appendChild(fragment1);
		fragment1.addAttribute(new Attribute("ref", "k:mol"));
		fragment1 = new Element("fragment");
		fragment.appendChild(fragment1);
		fragment1.addAttribute(new Attribute("dictRef", "k:x"));
		fragment1 = new Element("fragment");
		fragment.appendChild(fragment1);
		fragment1.addAttribute(new Attribute("ref", "k:xxx"));
		fragment1 = new Element("fragment");
		fragment.appendChild(fragment1);
		fragment1.addAttribute(new Attribute("dictRef", "q:xxx"));
		fragment1 = new Element("fragment");
		fragment.appendChild(fragment1);
		fragment1.addAttribute(new Attribute("ref", "xxx"));

		List<String> prefixList = CMLUtil.getPrefixes(fragment, "ref");
		assertEquals("set", 3, prefixList.size());
		assertTrue("set", prefixList.contains(S_EMPTY));
		assertTrue("set", prefixList.contains("g"));
		assertTrue("set", prefixList.contains("k"));
		assertFalse("set", prefixList.contains("q"));

		prefixList = CMLUtil.getPrefixes(fragment, "dictRef");
		assertEquals("set", 2, prefixList.size());
		assertFalse("set", prefixList.contains(S_EMPTY));
		assertFalse("set", prefixList.contains("g"));
		assertTrue("set", prefixList.contains("k"));
		assertTrue("set", prefixList.contains("q"));
	}

	@Test
	public void checkDoubleParsing() throws ParseException {
		assertEquals(1.0, CMLUtil.parseFlexibleDouble("1.0"));
		assertEquals(Double.NaN, CMLUtil.parseFlexibleDouble("NaN"));
		assertEquals(Double.POSITIVE_INFINITY, CMLUtil
				.parseFlexibleDouble("INF"));
		assertEquals(Double.NEGATIVE_INFINITY, CMLUtil
				.parseFlexibleDouble("-INF"));
		assertEquals(-0.001, CMLUtil.parseFlexibleDouble("-0.001"));
		assertEquals(-0.1, CMLUtil.parseFlexibleDouble("-000.1"));
		assertEquals(1000.0, CMLUtil.parseFlexibleDouble("1.0E3"));
		assertEquals(1000.0, CMLUtil.parseFlexibleDouble("1.0e3"));
		assertEquals(10000.0, CMLUtil.parseFlexibleDouble("10.0E3"));
		assertEquals(1000.0, CMLUtil.parseFlexibleDouble("1.0E+3"));
		assertEquals(0.001, CMLUtil.parseFlexibleDouble("1.0E-3"));
		assertEquals(1000.0, CMLUtil.parseFlexibleDouble("1.0E+03"));
		try {
			CMLUtil.parseFlexibleDouble("1.0e3foobar");
			fail("Parsing 1.0e3foobar should have resulted in a ParseException being raised");
		} catch (ParseException e) {
			// OK
			// e.printStackTrace();
			// assertTrue(true);
		}
	}
	
	@Test
	public void testEqualsCanonicallyStringElementBoolean() {
		String xml1S = "<atom id='a1'/>";
		Element xml1 = null;
		try {
			xml1 = new Builder().build(new StringReader(xml1S)).getRootElement();
		} catch (Exception e) {
			throw new RuntimeException("parse fail", e);
		}
		String message = null;
		String refString = xml1S;
		// equality
		message = CMLUtil.equalsCanonically(refString, xml1, true);
		
		// element name different
		refString = "<Atom id='a1'/>";
		message = CMLUtil.equalsCanonically(refString, xml1, true);
		Assert.assertNotNull("message should be thrown", message);
		Assert.assertEquals("element name", 
				"element names differ at /*[local-name()='Atom']/: Atom != atom", message);
		
		// element namespaces are the same
		refString = "<atom id='a1' xmlns=''/>";
		message = CMLUtil.equalsCanonically(refString, xml1, true);
		Assert.assertNull("message should not be thrown", message);
		
		// element namespaces differ
		refString = "<atom id='a1' xmlns='http://foo/'/>";
		message = CMLUtil.equalsCanonically(refString, xml1, true);
		Assert.assertNotNull("message should be thrown", message);
		Assert.assertEquals("element namespace", 
				"element namespaces differ at /*[local-name()='atom']/: http://foo/ != ", message);
		
		// attribute value different
		refString = "<atom id='a2'/>";
		message = CMLUtil.equalsCanonically(refString, xml1, true);
		Assert.assertNotNull("message should be thrown", message);
		Assert.assertEquals("attribute value", 
				"normalized attribute values for (/*[local-name()='atom']/@id) a2 != a1", message);

		// attribute name different
		refString = "<atom idx='a1'/>";
		message = CMLUtil.equalsCanonically(refString, xml1, true);
		Assert.assertNotNull("message should be thrown", message);
		Assert.assertEquals("attribute value", 
				"no attribute in test (/*[local-name()='atom']/) for idx", message);

		// attribute namespace different
		refString = "<atom foo:id='a1' xmlns:foo='http://www.foo.com/'/>";
		message = CMLUtil.equalsCanonically(refString, xml1, true);
		Assert.assertNotNull("message should be thrown", message);
		Assert.assertEquals("attribute value", 
				"no attribute in test (/*[local-name()='atom']/) for id[http://www.foo.com/]", message);

		// attribute count different
		refString = "<atom id='a1' idx='a1'/>";
		message = CMLUtil.equalsCanonically(refString, xml1, true);
		Assert.assertNotNull("message should be thrown", message);
		Assert.assertEquals("attribute value", 
				"unequal attribute count at /*[local-name()='atom']/ (2 != 1)", message);
		
		// content differs
		refString = "<atom id='a1'> </atom>";
		message = CMLUtil.equalsCanonically(refString, xml1, false);
		Assert.assertNotNull("message should be thrown", message);
		Assert.assertEquals("element content", 
				"unequal child node count at /*[local-name()='atom']/ (1 != 0)", message);
		
		// content differs only in whitespace
		refString = "<atom id='a1'> </atom>";
		message = CMLUtil.equalsCanonically(refString, xml1, true);
		Assert.assertNull("message should not be thrown", message);
		
		// content differs
		refString = "<atom id='a1'><!-- comment --></atom>";
		message = CMLUtil.equalsCanonically(refString, xml1, false);
		Assert.assertNotNull("message should be thrown", message);
		Assert.assertEquals("element content", 
				"unequal child node count at /*[local-name()='atom']/ (1 != 0)", message);
		
		// equal child content
		xml1S = "<atom id='a1'><atomParity id='ap1'/></atom>";
		try {
			xml1 = new Builder().build(new StringReader(xml1S)).getRootElement();
		} catch (Exception e) {
			throw new RuntimeException("parse fail", e);
		}
		refString = xml1S;
		message = CMLUtil.equalsCanonically(refString, xml1, false);
		Assert.assertNull("message should not be thrown", message);
		
		// equal child content but whitespace
		refString = "<atom id='a1'>\n" +
				"  <atomParity id='ap1'/>\n" +
				"</atom>";
		message = CMLUtil.equalsCanonically(refString, xml1, false);
		Assert.assertNotNull("message should be thrown", message);
		Assert.assertEquals("element content", 
				"unequal child node count at /*[local-name()='atom']/ (3 != 1)", message);
		
		// equal child content and ignore whitespace
		refString = "<atom id='a1'>\n" +
				"  <atomParity id='ap1'/>\n" +
				"</atom>";
		message = CMLUtil.equalsCanonically(refString, xml1, true);
		Assert.assertNull("message should not be thrown", message);
		
		// check child attributes
		refString = "<atom id='a1'>\n" +
				"  <atomParity idap='ap1'/>\n" +
				"</atom>";
		message = CMLUtil.equalsCanonically(refString, xml1, true);
		Assert.assertNotNull("message should be thrown", message);
		Assert.assertEquals("element content", 
				"no attribute in test (/*[local-name()='atom']/node()[position()=1]) for idap", message);
	}
}
