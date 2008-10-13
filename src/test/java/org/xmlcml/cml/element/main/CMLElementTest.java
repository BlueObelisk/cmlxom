package org.xmlcml.cml.element.main;

import static org.xmlcml.cml.base.BaseTest.assertEqualsCanonically;
import static org.xmlcml.cml.base.BaseTest.assertNotEqualsCanonically;
import static org.xmlcml.cml.base.CMLConstants.CML_NS;
import static org.xmlcml.cml.base.CMLConstants.CML_XMLNS;
import static org.xmlcml.cml.base.CMLConstants.C_E;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;

import nu.xom.Attribute;
import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Elements;
import nu.xom.ParsingException;
import nu.xom.ValidityException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.xmlcml.cml.base.CMLBuilder;
import org.xmlcml.cml.base.CMLElement;
import org.xmlcml.cml.element.lite.CMLAtom;
import org.xmlcml.cml.element.lite.CMLLabel;
import org.xmlcml.cml.element.lite.CMLMolecule;
import org.xmlcml.euclid.Util;

/**
 * test CMLElement.
 * 
 * @author pmr
 * 
 */
public class CMLElementTest {

	final static String ID = "id";
	CMLElement atom;
	CMLElement cml1;
	Element elem1;
	Element elem2;

	// default namespace
	/**
	 * main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
	}

	/**
	 * setup.
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		atom = new CMLElement(CMLAtom.TAG);
		atom.addAttribute(new Attribute("foo", "fooval"));
		CMLLabel label = new CMLLabel();
		label.setCMLValue("value1");
		atom.appendChild(label);
		atom.setProperty("foo", "fooString");
		atom.setProperty("bar", "barString");
		cml1 = new CMLElement("cml1");
		CMLElement c = new CMLElement("cml2");
		c.addAttribute(new Attribute(ID, "c1"));
		cml1.appendChild(c);
		Element noncml = new Element("noncml");
		noncml.addAttribute(new Attribute(ID, "n1"));
		cml1.appendChild(noncml);
		c = new CMLElement("cml2");
		c.addAttribute(new Attribute(ID, "c2"));
		cml1.appendChild(c);
	}

	/**
	 * basic test of XOM.* Test method for 'org.xmlcml.cml.base.Element'
	 */
	@Test
	public void testElement() {
		String test1S = "<cml/>";
		Document doc1 = null;
		try {
			doc1 = new Builder().build(new StringReader(test1S));
		} catch (ValidityException e) {
			Assert.fail("should not throw " + e);
		} catch (ParsingException e) {
			Assert.fail("should not throw " + e);
		} catch (IOException e) {
			Assert.fail("should not throw " + e);
		}
		Assert.assertNotNull("test1 ", doc1);
		Element cml = doc1.getRootElement();
		Assert.assertEquals("test1 ", "cml", cml.getLocalName());
		/*
		 * -- omit deliberate error System.err.println("deliberate error:");
		 * String test2S = "<cml>"; Document doc2 = null; try { doc2 = new
		 * Builder().build(new StringReader(test2S));
		 * Assert.fail("should throw parsing exception"); } catch
		 * (ValidityException e) { Assert.fail("should not throw "+e); } catch
		 * (ParsingException e) { Assert.assertEquals("should throw ",
		 * "XML document structures must start and end within the same entity.",
		 * e.getMessage()); } catch (IOException e) {
		 * Assert.fail("should not throw "+e); } Assert.assertNull("test2 ",
		 * doc2); System.err.println("end deliberate error:"); --
		 */
		String test3S = "<c:cml " + "xmlns:c='" + CML_NS + "' "
				+ "xmlns:foo='http://foo.org/' " + "id='a1' foo:bar='plugh'>"
				+ "<xxx c:yyy='zzz'/>" + "</c:cml>";
		Document doc3 = null;
		try {
			doc3 = new Builder().build(new StringReader(test3S));
		} catch (ValidityException e) {
			Assert.fail("should not throw " + e);
		} catch (ParsingException e) {
			Assert.fail("should not throw " + e);
		} catch (IOException e) {
			Assert.fail("should not throw " + e);
		}
		Assert.assertNotNull("test3 ", doc3);
		String test4S = "<cml " + "xmlns='" + CML_NS + "' "
				+ "xmlns:foo='http://foo.org/' " + "id='a1' foo:bar='plugh'>"
				+ "<xxx xmlns:c='" + CML_NS + "' " + " c:yyy='zzz'/>"
				+ "</cml>";
		Document doc4 = null;
		try {
			doc4 = new Builder().build(new StringReader(test4S));
		} catch (ValidityException e) {
			Assert.fail("should not throw " + e);
		} catch (ParsingException e) {
			Assert.fail("should not throw " + e);
		} catch (IOException e) {
			Assert.fail("should not throw " + e);
		}
		Assert.assertNotNull("test4 ", doc4);
	}

	/**
	 * Test method for 'org.xmlcml.cml.base.CMLElement.CMLElement(String)'
	 */
	@Test
	public void testCMLElementString() {
		// at this stage we do not care whether the name is in the schema
		CMLElement element = new CMLElement("atom");
		Assert.assertNotNull("constructor", element);
		Assert.assertEquals("default attribute count", 0, element
				.getAttributeCount());
		Assert.assertEquals("namespace", "", element.getNamespacePrefix());
		Assert.assertEquals("namespace", "atom", element.getLocalName());
		Assert.assertEquals("namespace", CML_NS, element.getNamespaceURI());
		// explicit prefix
		element = new CMLElement(CMLAtom.NS);
		Assert.assertNotNull("constructor", element);
		Assert.assertEquals("default attribute count", 0, element
				.getAttributeCount());
		Assert.assertEquals("namespace", "cml", element.getNamespacePrefix());
		Assert.assertEquals("namespace", "atom", element.getLocalName());
		// non-CML element
		element = new CMLElement("foo");
		Assert.assertNotNull("constructor", element);
		Assert.assertEquals("default attribute count", 0, element
				.getAttributeCount());
		Assert.assertEquals("namespace", "", element.getNamespacePrefix());
		// non-CML element
		element = new CMLElement(C_E + "foo");
		Assert.assertNotNull("constructor", element);
		Assert.assertEquals("default attribute count", 0, element
				.getAttributeCount());
		Assert.assertEquals("namespace", "cml", element.getNamespacePrefix());
	}

	/**
	 * Test method for 'org.xmlcml.cml.base.CMLElement.CMLElement(CMLElement)'
	 */
	@Test
	public void testCMLElementCMLElement() {
		Element label = atom.getChildElements().get(0);
		CMLElement atom1 = new CMLElement(atom);
		// detach to test the deep copy
		label.detach();
		// remove property to test deep copy
		atom.setProperty("foo", null);
		Assert.assertEquals("copy constructor", 0, atom.getChildCount());
		Assert.assertNotNull("copy constructor", atom1);
		Assert.assertEquals("copy constructor", "", atom1.getNamespacePrefix());
		Assert
				.assertEquals("copy constructor", CML_NS, atom1
						.getNamespaceURI());
		Assert.assertEquals("copy constructor", 1, atom1.getChildCount());
		// MUST remember the namespace!
		Element child = atom1.getFirstChildElement("label", CML_NS);
		Assert.assertNotNull("child", child);
		Assert.assertEquals("copy child", CMLLabel.class, child.getClass());
		label = (CMLLabel) child;
		Assert
				.assertEquals("child", "value1", label
						.getAttributeValue("value"));
		Assert.assertEquals("property", 2, atom1.getPropertyNames().size());
		Assert.assertEquals("property", "fooString", atom1.getProperty("foo"));
		Assert.assertEquals("property", "barString", atom1.getProperty("bar"));
	}

	/**
	 * Test method for 'org.xmlcml.cml.base.CMLElement.copy()'
	 */
	@Test
	public void testCopy() {
		CMLElement elem = (CMLElement) atom.copy();
		Assert.assertEquals("copy", 0, elem.compareTo(atom));
	}

	/**
	 * Test method for 'org.xmlcml.cml.base.CMLElement.compareTo(CMLElement)'
	 */
	@Test
	public void testCompareTo() {
		CMLElement elem = (CMLElement) atom.copy();
		Assert.assertEquals("copy", 0, elem.compareTo(atom));
	}

	/**
	 * Test method for 'org.xmlcml.cml.base.CMLElement.removeAttribute(String)'
	 */
	@Test
	public void testRemoveAttributeString() {
		String value = atom.getAttributeValue("foo");
		Assert.assertEquals("att", "fooval", value);
		atom.removeAttribute("foo");
		value = atom.getAttributeValue("foo");
		Assert.assertNull("att", value);
	}

	/**
	 * Test method for 'org.xmlcml.cml.base.CMLElement.setProperty(String,
	 * Object)'
	 */
	@Test
	public void testGetSetProperty() {
		CMLAtom atom = new CMLAtom();
		atom.setProperty("foo", "fooString");
		atom.setProperty("bar", "barString");
		List<String> names = atom.getPropertyNames();
		Assert.assertEquals("property", 2, names.size());
		Assert.assertEquals("property", "fooString", atom.getProperty("foo"));
		Assert.assertEquals("property", "barString", atom.getProperty("bar"));
		atom.setProperty("foo", "fooPlugh");
		names = atom.getPropertyNames();
		Assert.assertEquals("property", 2, names.size());
		Assert.assertEquals("property", "fooPlugh", atom.getProperty("foo"));
		Assert.assertEquals("property", "barString", atom.getProperty("bar"));
		atom.setProperty("foo", null);
		names = atom.getPropertyNames();
		Assert.assertEquals("property", 1, names.size());
		Assert.assertNull("property", atom.getProperty("foo"));
		Assert.assertEquals("property", "barString", atom.getProperty("bar"));
		atom.setProperty("foo", "fooXyzzy");
		names = atom.getPropertyNames();
		Assert.assertEquals("property", 2, names.size());
		Assert.assertEquals("property", "fooXyzzy", atom.getProperty("foo"));
		Assert.assertEquals("property", "barString", atom.getProperty("bar"));
	}

	/**
	 * Test method for 'org.xmlcml.cml.base.CMLElement.getChildCMLElements()'
	 */
	@Test
	public void testGetChildCMLElements() {
		String moleculeS = null;
		CMLMolecule molecule = null;
		/*
		 * -- // this example tests atom code so is not a good test for simple
		 * children moleculeS = "<molecule " + CML_XMLNS + " title='myTitle'>" +
		 * "  <atomArray>" + "    <atom id='a1' title='atom1' x3='1.23'/>" +
		 * "  </atomArray>" + "</molecule>" + ""; CMLMolecule molecule = null;
		 * try { molecule = (CMLMolecule) new
		 * CMLBuilder().parseString(moleculeS); molecule.debug("MOL"); } catch
		 * (Exception e1) { e1.printStackTrace();
		 * Assert.assertEquals("bad names", "Unknown CML element: foo",
		 * e1.getMessage()); } CMLAtom atom = molecule.getAtom(0); String title
		 * = atom.getTitle(); Assert.assertEquals("title", "atom1", title);
		 * String id = atom.getId(); Assert.assertEquals("id", "a1", id);
		 * Attribute idAtt = atom.getIdAttribute();
		 * Assert.assertNotNull("id att not null", idAtt); Attribute idAtt1 =
		 * atom.getAttribute("id"); Assert.assertNotNull("id att not null",
		 * idAtt1);
		 * 
		 * // this example tests atom code so is not a good test for simple
		 * children moleculeS = "<molecule " + CML_XMLNS + " title='myTitle'>" +
		 * "  <atomArray>" + "    <atom id='a1' title='atom1' x3='1.23'/>" +
		 * "    <atom id='a2' title='atom2'/>" + "    <foo/>" + "  </atomArray>"
		 * + "  <blinge/>" + "  <bondArray>" + "    <bar/>" +
		 * "    <bond atomRefs2='a1 a2'/>" + "    <bar/>" + "  </bondArray>" +
		 * "</molecule>" + ""; molecule = null; try { molecule = (CMLMolecule)
		 * new CMLBuilder().parseString(moleculeS); } catch (Exception e1) {
		 * e1.printStackTrace(); Assert.assertEquals("bad names",
		 * "Unknown CML Element : foo", e1.getMessage()); } --
		 */
		moleculeS = "<molecule " + CML_XMLNS + ">" + "  <atomArray>"
				+ "    <atom id='a1'/>" + "    <atom id='a2'/>"
				+ "  </atomArray>" + "  <bondArray>"
				+ "    <bond atomRefs2='a1 a2'/>" + "  </bondArray>"
				+ "</molecule>" + "";
		try {
			molecule = (CMLMolecule) new CMLBuilder().build(
					new StringReader(moleculeS)).getRootElement();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertEquals("unknown elements ", "x", e.getMessage());
		}
		List<CMLElement> childs = molecule.getChildCMLElements();
		Assert.assertEquals("children", 2, childs.size());
		Assert.assertEquals("children", "atomArray", childs.get(0)
				.getLocalName());
		Assert.assertEquals("children", "bondArray", childs.get(1)
				.getLocalName());
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.base.CMLElement.getChildCMLElements(String)'
	 */
	@Test
	public void testGetChildCMLElementsString() {
		Elements elems = cml1.getChildCMLElements("cml2");
		Assert.assertEquals("child cml", 2, elems.size());
		Assert.assertEquals("child cml", CMLElement.class, elems.get(0)
				.getClass());
		Assert.assertEquals("child cml id", "c1", elems.get(0)
				.getAttributeValue(ID));
		Assert.assertEquals("child cml id", "c2", elems.get(1)
				.getAttributeValue(ID));
		elems = cml1.getChildCMLElements("noncml");
		Assert.assertEquals("child cml", 0, elems.size());
		elems = cml1.getChildElements("noncml");
		Assert.assertEquals("child cml", 1, elems.size());
		Assert.assertEquals("child cml id", "n1", elems.get(0)
				.getAttributeValue(ID));
		Assert
				.assertEquals("child cml", Element.class, elems.get(0)
						.getClass());
	}

	/**
	 * Test method for 'org.xmlcml.cml.base.CMLElement.getFirstCMLChild(String)'
	 */
	@Test
	public void testGetFirstCMLChild() {
		Element elem = cml1.getFirstCMLChild("cml2");
		Assert.assertEquals("child cml", CMLElement.class, elem.getClass());
		Assert.assertEquals("child cml id", "c1", elem.getAttributeValue(ID));
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.base.CMLElement.getChildCMLElement(String, int)'
	 */
	@Test
	public void testGetChildCMLElement() {
		Element elem = cml1.getChildCMLElement("cml2", 0);
		Assert.assertEquals("child cml", CMLElement.class, elem.getClass());
		Assert.assertEquals("child cml id", "c1", elem.getAttributeValue(ID));
		elem = cml1.getChildCMLElement("cml2", 1);
		Assert.assertEquals("child cml", CMLElement.class, elem.getClass());
		Assert.assertEquals("child cml id", "c2", elem.getAttributeValue(ID));
		elem = cml1.getChildCMLElement("cml2", 2);
		Assert.assertNull("child cml", elem);
	}

	/**
	 * Test method for 'org.xmlcml.cml.base.CMLElement.getCMLChildCount(String)'
	 */
	@Test
	public void testGetCMLChildCount() {
		Assert.assertEquals("child count", 2, cml1.getCMLChildCount("cml2"));
		Assert.assertEquals("child count", 0, cml1.getCMLChildCount("cmlXX"));
	}

	/**
	 * Test method for 'nu.xom.Element.getValue()'
	 */
	@Test
	public void testGetXOMStuff() {
		Assert.assertEquals("value", "", cml1.getValue());
		Assert.assertEquals("URI", "", cml1.getBaseURI());
		Assert.assertEquals("QName", "cml1", cml1.getQualifiedName());
	}

	/**
	 * Test method for 'nu.xom.Element.insertChild(String, int)'
	 */
	@Test
	public void testInsertChildStringInt() {
	}

	/**
	 * Test method for 'nu.xom.Element.appendChild(String)'
	 */
	@Test
	public void testAppendChildString() {
	}

	/**
	 * Test method for 'nu.xom.Element.removeChildren()'
	 */
	@Test
	public void testRemoveChildren() {
	}

	/**
	 * Test method for 'nu.xom.Element.addNamespaceDeclaration(String, String)'
	 */
	@Test
	public void testAddNamespaceDeclaration() {
	}

	/**
	 * Test method for 'nu.xom.Element.removeNamespaceDeclaration(String)'
	 */
	@Test
	public void testRemoveNamespaceDeclaration() {
	}

	/**
	 * Test method for 'nu.xom.Element.getNamespaceDeclarationCount()'
	 */
	@Test
	public void testGetNamespaceDeclarationCount() {
	}

	/**
	 * Test method for 'nu.xom.Element.getNamespacePrefix(int)'
	 */
	@Test
	public void testGetNamespacePrefixInt() {
	}

	/**
	 * Test method for 'BaseTest1.assertEqualsCanonically(String, Element,
	 * Element)'
	 */
	@Test
	public void testAssertEqualsCanonicallyStringElementElement() {
		elem1 = new Element("foo");
		elem1.addAttribute(new Attribute("bar", "plugh"));
		elem1.addAttribute(new Attribute("y2", "xyzzy"));
		elem2 = new Element("foo");
		elem2.addAttribute(new Attribute("y2", "xyzzy"));
		elem2.addAttribute(new Attribute("bar", "plugh"));
		assertEqualsCanonically("test canonicalization", elem1, elem2);
		String s1 = "<foo bar='plugh' y2='xyzzy'/>";
		String s2 = "<foo y2='xyzzy'   bar='plugh'  ></foo>";
		try {
			elem1 = new Builder().build(new StringReader(s1)).getRootElement();
			elem2 = new Builder().build(new StringReader(s2)).getRootElement();
		} catch (ParsingException e) {
			Util.BUG(e);
		} catch (IOException e) {
			Util.BUG(e);
		}
		assertEqualsCanonically("test canonicalization", elem1, elem2);
		s1 = "<x:foo xmlns:x='http://xx' bar='plugh' y2='xyzzy'/>";
		s2 = "<x:foo xmlns:x='http://xx' y2='xyzzy'   bar='plugh'  ></x:foo>";
		try {
			elem1 = new Builder().build(new StringReader(s1)).getRootElement();
			elem2 = new Builder().build(new StringReader(s2)).getRootElement();
		} catch (ParsingException e) {
			Util.BUG(e);
		} catch (IOException e) {
			Util.BUG(e);
		}
		assertEqualsCanonically("test canonicalization", elem1, elem2);
		s1 = "<x:foo xmlns:x='http://xx' bar='plugh' y2='xyzzy'/>";
		s2 = "<x:foo xmlns:x='http://zz' y2='xyzzy'   bar='plugh'  ></x:foo>";
		try {
			elem1 = new Builder().build(new StringReader(s1)).getRootElement();
			elem2 = new Builder().build(new StringReader(s2)).getRootElement();
		} catch (ParsingException e) {
			Util.BUG(e);
		} catch (IOException e) {
			Util.BUG(e);
		}
		assertNotEqualsCanonically("test canonicalization", elem1, elem2);
		s1 = "<x:foo xmlns:x='http://xx' bar='plugh' y2='xyzzy'/>";
		s2 = "<y:foo xmlns:y='http://xx' y2='xyzzy'   bar='plugh'  ></y:foo>";
		try {
			elem1 = new Builder().build(new StringReader(s1)).getRootElement();
			elem2 = new Builder().build(new StringReader(s2)).getRootElement();
		} catch (ParsingException e) {
			Util.BUG(e);
		} catch (IOException e) {
			Util.BUG(e);
		}
		assertNotEqualsCanonically("test canonicalization", elem1, elem2);
	}

	// FIXME this currently relies on classes in other package
	// /**
	// * test getNamespaceForPrefix.
	// */
	// @Test
	// public void testGetNamespaceForPrefix() {
	//
	// String s = "" + "<cml " + CML_XMLNS + ""
	// + "  xmlns:a='http://www.foo.org' "
	// + "  xmlns:b='http://www.bar.com'>"
	// + "    <molecule title='f.mol'/>" + "</cml>" + "";
	// Element cml = (Element) new Builder().build(new
	// StringReader(s)).getRootElement();
	// Element molecule = (Element) cml
	// .getChild(0);
	// String ns = cml.getNamespaceForPrefix("a");
	// Assert.assertEquals("namespace", "http://www.foo.org", ns);
	// ns = molecule.getNamespaceForPrefix("a");
	// Assert.assertEquals("namespace", "http://www.foo.org", ns);
	// ns = cml.getNamespaceForPrefix("b");
	// Assert.assertEquals("namespace", "http://www.bar.com", ns);
	// ns = molecule.getNamespaceForPrefix("b");
	// Assert.assertEquals("namespace", "http://www.bar.com", ns);
	// ns = cml.getNamespaceForPrefix("z");
	// Assert.assertNull("namespace", ns);
	// ns = molecule.getNamespaceForPrefix("z");
	// Assert.assertNull("namespace", ns);
	// }

}
