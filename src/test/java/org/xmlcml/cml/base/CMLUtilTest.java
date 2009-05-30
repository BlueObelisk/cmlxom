package org.xmlcml.cml.base;

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

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.xmlcml.cml.element.CMLCml;
import org.xmlcml.euclid.EC;

/**
 * test CMLUtil.
 * 
 * @author pm286
 * 
 */
public class CMLUtilTest {
	@SuppressWarnings("unused")
	private static Logger LOG = Logger.getLogger(CMLUtilTest.class);
	static {
		LOG.setLevel(Level.DEBUG);
	}

	/**
	 * Test method for 'org.xmlcml.cml.base.CMLUtil.checkPrefixedName(String)'
	 */
	@Test
	public final void testCheckPrefixedName() {
		CMLUtil.checkPrefixedName("foo:name");
		try {
			CMLUtil.checkPrefixedName("name");
			Assert.fail("unprefixed name");
		} catch (Exception e) {
			Assert.assertEquals("unprefixed", "Unprefixed name (name)", e.getMessage());
		}
	}

	/**
	 * Test method for 'org.xmlcml.cml.base.CMLUtil.getXMLResource(String)'
	 */
	@Test
	public final void testGetXMLResource() {
		String filename = TstBase.BASE_RESOURCE +CMLConstants.U_S + "cml0.xml";
		Document doc = null;
		try {
			doc = CMLUtil.getXMLResource(filename);
		} catch (Exception e) {
			Assert.fail("BUG "+e);
		}
		Assert.assertNotNull("doc not null", doc);
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
		Assert.assertEquals("count", 5, childNodes.size());
		Assert.assertEquals("class", Text.class, childNodes.get(0).getClass());
		Assert.assertEquals("value", "abc", childNodes.get(0).getValue());
		Assert.assertEquals("class", Element.class, childNodes.get(1).getClass());
		Assert.assertEquals("class", "bar", ((Element) childNodes.get(1))
				.getLocalName());
		Assert.assertEquals("value", "", childNodes.get(1).getValue());
		Assert.assertEquals("class", Text.class, childNodes.get(2).getClass());
		Assert.assertEquals("value", "def", childNodes.get(2).getValue());
		Assert.assertEquals("class", Element.class, childNodes.get(3).getClass());
		Assert.assertEquals("class", "bar1", ((Element) childNodes.get(3))
				.getLocalName());
		Assert.assertEquals("value", "ghi", childNodes.get(3).getValue());
		Assert.assertEquals("class", Text.class, childNodes.get(4).getClass());
		Assert.assertEquals("value", "jkl", childNodes.get(4).getValue());
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

		// parseXML does not generate CML
		s = "<cml:cml xmlns:cml='http://www.xml-cml.org/schema'><bar/></cml:cml>";
		root = CMLUtil.parseXML(s);
		Assert.assertEquals("class", Element.class, root.getClass());
	}

	/**
	 * Test method for {@link org.xmlcml.cml.base.CMLUtil#parseCML(String)}.
	 */
	@Test
	public final void testParseCMLString() {
		String s = "<cml:cml xmlns:cml='http://www.xml-cml.org/schema'><bar/></cml:cml>";
		CMLElement root = CMLUtil.parseCML(s);
		Assert.assertEquals("class", CMLCml.class, root.getClass());
		// if applied to non-CML, throws exception
		s = "<foo>abc<bar/>def<bar1>ghi</bar1>jkl</foo>";
		try {
			root = CMLUtil.parseCML(s);
			Assert.fail("should throw ClassCastException");
		} catch (RuntimeException cce) {
		}
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
		Assert.assertEquals("nodes", 1, nodeList.size());
		nodeList = CMLUtil.getQueryNodes(root, "//bar");
		Assert.assertEquals("nodes", 1, nodeList.size());
		Assert.assertEquals("nodes", "ghi", nodeList.get(0).getValue());
		nodeList = CMLUtil.getQueryNodes(root, "//boo:bar", XPC);
		Assert.assertEquals("nodes", 1, nodeList.size());
		Assert.assertEquals("nodes", "xyz", nodeList.get(0).getValue());
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
		Assert.assertEquals("nodes", 4, nodeList.size());
		nodeList = CMLUtil.getQueryNodes(root, "/*/text()");
		Assert.assertEquals("nodes", 3, nodeList.size());
		nodeList = CMLUtil.getQueryNodes(root, "/text()");
		Assert.assertEquals("nodes", 0, nodeList.size());
		nodeList = CMLUtil.getQueryNodes(root, "/foo");
		Assert.assertEquals("nodes", 1, nodeList.size());
		nodeList = CMLUtil.getQueryNodes(root, "/foo/*");
		Assert.assertEquals("nodes", 2, nodeList.size());
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
		Assert.assertEquals("fsib", "bar", ((Element) sibNode).getLocalName());
		Node bar1 = nodeList.get(3);
		Assert.assertEquals("fsib", "bar1", ((Element) bar1).getLocalName());
		sibNode = CMLUtil.getFollowingSibling(bar1);
		Assert.assertEquals("fsib", "jkl", sibNode.getValue());
		text = nodeList.get(4);
		sibNode = CMLUtil.getFollowingSibling(text);
		Assert.assertNull("fsib", sibNode);
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
		Assert.assertNull("fsib", sibNode);
		Node bar1 = nodeList.get(3);
		Assert.assertEquals("fsib", "bar1", ((Element) bar1).getLocalName());
		sibNode = CMLUtil.getPrecedingSibling(bar1);
		Assert.assertEquals("fsib", "def", sibNode.getValue());
		text = nodeList.get(4);
		sibNode = CMLUtil.getFollowingSibling(text);
		Assert.assertEquals("fsib", "bar1", ((Element) bar1).getLocalName());
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
		Assert.assertNotNull("text", text);
		Assert.assertEquals("text", "jkl", text.getValue());
		s = "<foo><bar1><plugh/></bar1></foo>";
		root = CMLUtil.parseXML(s);
		text = CMLUtil.getLastTextDescendant(root);
		Assert.assertNull("text", text);
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
		Assert.assertNotNull("text", text);
		Assert.assertEquals("text", "abc", text.getValue());
		s = "<foo><bar1><plugh/></bar1></foo>";
		root = CMLUtil.parseXML(s);
		text = CMLUtil.getFirstTextDescendant(root);
		Assert.assertNull("text", text);
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
		Element fragment = new Element("fragment", CMLConstants.CML_NS);
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
		Assert.assertEquals("set", 3, prefixList.size());
		Assert.assertTrue("set", prefixList.contains(EC.S_EMPTY));
		Assert.assertTrue("set", prefixList.contains("g"));
		Assert.assertTrue("set", prefixList.contains("k"));
		Assert.assertFalse("set", prefixList.contains("q"));

		prefixList = CMLUtil.getPrefixes(fragment, "dictRef");
		Assert.assertEquals("set", 2, prefixList.size());
		Assert.assertFalse("set", prefixList.contains(EC.S_EMPTY));
		Assert.assertFalse("set", prefixList.contains("g"));
		Assert.assertTrue("set", prefixList.contains("k"));
		Assert.assertTrue("set", prefixList.contains("q"));
	}

	@Test
	public void checkDoubleParsing() throws ParseException {
		Assert.assertEquals(1.0, CMLUtil.parseFlexibleDouble("1.0"));
		Assert.assertEquals(Double.NaN, CMLUtil.parseFlexibleDouble("NaN"));
		Assert.assertEquals(Double.POSITIVE_INFINITY, CMLUtil
				.parseFlexibleDouble("INF"));
		Assert.assertEquals(Double.NEGATIVE_INFINITY, CMLUtil
				.parseFlexibleDouble("-INF"));
		Assert.assertEquals(-0.001, CMLUtil.parseFlexibleDouble("-0.001"));
		Assert.assertEquals(-0.1, CMLUtil.parseFlexibleDouble("-000.1"));
		Assert.assertEquals(1000.0, CMLUtil.parseFlexibleDouble("1.0E3"));
		Assert.assertEquals(1000.0, CMLUtil.parseFlexibleDouble("1.0e3"));
		Assert.assertEquals(10000.0, CMLUtil.parseFlexibleDouble("10.0E3"));
		Assert.assertEquals(1000.0, CMLUtil.parseFlexibleDouble("1.0E+3"));
		Assert.assertEquals(0.001, CMLUtil.parseFlexibleDouble("1.0E-3"));
		Assert.assertEquals(1000.0, CMLUtil.parseFlexibleDouble("1.0E+03"));
		try {
			CMLUtil.parseFlexibleDouble("1.0e3foobar");
			Assert.fail("Parsing 1.0e3foobar should have resulted in a ParseException being raised");
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
		LOG.trace(refString);
		// element name different
		refString = "<Atom id='a1'/>";
		message = CMLUtil.equalsCanonically(refString, xml1, true);
		Assert.assertNotNull("message should be thrown", message);
		Assert.assertEquals("element name", 
				"element names differ at /*[local-name()='Atom']/: Atom != atom", message);
		LOG.trace(refString);
		
		// element namespaces are the same
		refString = "<atom id='a1' xmlns=''/>";
		message = CMLUtil.equalsCanonically(refString, xml1, true);
		Assert.assertNull("message should not be thrown", message);
		LOG.trace(refString);
		
		// element namespaces differ
		refString = "<atom id='a1' xmlns='http://foo/'/>";
		message = CMLUtil.equalsCanonically(refString, xml1, true);
		Assert.assertNotNull("message should be thrown", message);
		LOG.trace(refString);
		
		// attribute value different
		refString = "<atom id='a2'/>";
		message = CMLUtil.equalsCanonically(refString, xml1, true);
		Assert.assertNotNull("message should be thrown", message);
		Assert.assertEquals("attribute value", 
				"normalized attribute values for (/*[local-name()='atom']/@id) a2 != a1", message);
		LOG.trace(refString);

		// attribute name different
		refString = "<atom idx='a1'/>";
		message = CMLUtil.equalsCanonically(refString, xml1, true);
		Assert.assertNotNull("message should be thrown", message);
		Assert.assertEquals("attribute value", 
				"no attribute in test (/*[local-name()='atom']/) for idx", message);
		LOG.trace(refString);

		// attribute namespace different
		refString = "<atom foo:id='a1' xmlns:foo='http://www.foo.com/'/>";
		message = CMLUtil.equalsCanonically(refString, xml1, true);
		Assert.assertNotNull("message should be thrown", message);
		LOG.trace(refString);

		// attribute count different
		refString = "<atom id='a1' idx='a1'/>";
		message = CMLUtil.equalsCanonically(refString, xml1, true);
		Assert.assertNotNull("message should be thrown", message);
		Assert.assertEquals("attribute value", 
				"unequal attribute count at /*[local-name()='atom']/ (2 != 1)", message);
		LOG.trace(refString);
		
		// content differs
		refString = "<atom id='a1'> </atom>";
		message = CMLUtil.equalsCanonically(refString, xml1, false);
		Assert.assertNotNull("message should be thrown", message);
		Assert.assertEquals("element content", 
				"unequal child node count at /*[local-name()='atom']/ (1 != 0)", message);
		LOG.trace(refString);
		
		// content differs only in whitespace
		refString = "<atom id='a1'> </atom>";
		message = CMLUtil.equalsCanonically(refString, xml1, true);
		Assert.assertNull("message should not be thrown", message);
		LOG.trace(refString);
		
		// content differs
		refString = "<atom id='a1'><!-- comment --></atom>";
		message = CMLUtil.equalsCanonically(refString, xml1, false);
		Assert.assertNotNull("message should be thrown", message);
		Assert.assertEquals("element content", 
				"unequal child node count at /*[local-name()='atom']/ (1 != 0)", message);
		LOG.trace("Q");
		LOG.trace(refString);
		
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
		LOG.trace(refString);
		
		// equal child content but whitespace
		refString = "<atom id='a1'>\n" +
				"  <atomParity id='ap1'/>\n" +
				"</atom>";
		message = CMLUtil.equalsCanonically(refString, xml1, false);
		Assert.assertNotNull("message should be thrown", message);
		Assert.assertEquals("element content", 
				"unequal child node count at /*[local-name()='atom']/ (3 != 1)", message);
		LOG.trace(refString);
		
		// equal child content and ignore whitespace
		refString = "<atom id='a1'>\n" +
				"  <atomParity id='ap1'/>\n" +
				"</atom>";
		message = CMLUtil.equalsCanonically(refString, xml1, true);
		Assert.assertNull("message should not be thrown", message);
		LOG.trace("Z");
		LOG.trace(refString);
		
		// check child attributes
		refString = "<atom id='a1'>\n" +
				"  <atomParity idap='ap1'/>\n" +
				"</atom>";
		message = CMLUtil.equalsCanonically(refString, xml1, true);
		Assert.assertNotNull("message should be thrown", message);
		Assert.assertEquals("element content", 
				"no attribute in test (/*[local-name()='atom']/node()[position()=1]) for idap", message);
		LOG.trace(refString);
	}
}
