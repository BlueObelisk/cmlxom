package org.xmlcml.cml.element.main;

import static org.xmlcml.cml.base.BaseTest.assertEqualsCanonically;
import static org.xmlcml.cml.base.BaseTest.parseValidString;
import static org.xmlcml.cml.base.CMLConstants.CML_XMLNS;
import static org.xmlcml.euclid.EuclidConstants.S_EMPTY;

import java.util.ArrayList;
import java.util.List;

import nu.xom.Elements;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.xmlcml.cml.base.CMLElements;
import org.xmlcml.cml.element.CMLAtom;
import org.xmlcml.cml.element.CMLBond;
import org.xmlcml.cml.element.CMLLink;
import org.xmlcml.cml.element.CMLMap;
import org.xmlcml.cml.element.CMLPeak;
import org.xmlcml.cml.element.CMLMap.Direction;
import org.xmlcml.euclid.Util;
import org.xmlcml.euclid.test.StringTestBase;

/**
 * test CMLMap.
 * 
 * @author pmr
 * 
 */
public class CMLMapTest {
	CMLMap xomMap1;
	CMLMap xmlMap1;
	String xmlMap1S = "<map id='m1' fromType='cml:atom' toType='cml:atom'"
			+ " " + CML_XMLNS + ">" + "  <link from='a1' to='a11'/>"
			+ "  <link from='a2' to='a12'/>" + "  <link from='a3' to='a13'/>"
			+ "</map>" + "";
	CMLMap xmlMap2;
	String xmlMap2S = "<map id='m1' fromType='cml:atom' toType='cml:atom'"
			+ " " + CML_XMLNS + ">" + "  <link from='a4' to='a14'/>"
			+ "  <link from='a5' to='a15'/>" + "  <link from='a6' to='a16'/>"
			+ "</map>" + S_EMPTY;

	/**
	 * setup.
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		xmlMap1 = (CMLMap) parseValidString(xmlMap1S);
		xmlMap2 = (CMLMap) parseValidString(xmlMap2S);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLMap.copy()'
	 */
	@Test
	public void testCopy() {
		CMLMap copyMap = (CMLMap) xmlMap1.copy();
		Assert.assertEquals("copy", 0, copyMap.compareTo(xmlMap1));
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLMap.CMLMap()'
	 */
	@Test
	public void testCMLMap() {
		xomMap1 = new CMLMap();
		Assert.assertNotNull("map", xomMap1);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLMap.CMLMap(CMLMap)'
	 */
	@Test
	public void testCMLMapCMLMap() {
		CMLMap copyMap = new CMLMap(xmlMap1);
		Assert.assertEquals("copy", 0, copyMap.compareTo(xmlMap1));
		Assert.assertEquals("copy", -1, copyMap.compareTo(xmlMap2));
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLMap.makeElementInContext(Element)'
	 */
	@Test
	public void testMakeElementInContext() {
		Assert.assertNotNull("constructor", xmlMap1);
		Assert.assertEquals("constructor", "m1", xmlMap1.getId());
		Elements links = xmlMap1.getChildCMLElements(CMLLink.TAG);
		Assert.assertEquals("constructor", 3, links.size());
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLMap.getReverseToFrom(String)'
	 */
	@Test
	public void testGetReverseToFrom() {
		CMLMap.Direction reverse = CMLMap.getReverseToFrom(CMLMap.Direction.TO);
		Assert.assertEquals("to", true, reverse.equals(CMLMap.Direction.FROM));
		reverse = CMLMap.getReverseToFrom(CMLMap.Direction.FROM);
		Assert.assertEquals("from", true, reverse.equals(CMLMap.Direction.TO));
		reverse = CMLMap.getReverseToFrom(CMLMap.Direction.EITHER);
		Assert.assertNull("either", reverse);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLMap.addLink(CMLLink)'
	 */
	@Test
	public void testAddLinkCMLLink() {
		CMLElements<CMLLink> links = xmlMap1.getLinkElements();
		Assert.assertEquals("links", 3, links.size());
		CMLLink link = new CMLLink();
		link.setTo("a4");
		link.setFrom("a14");
		xmlMap1.addLink(link);
		links = xmlMap1.getLinkElements();
		Assert.assertEquals("links", 4, links.size());
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLMap.addUniqueLink(CMLLink,
	 * String)'
	 */
	@Test
	public void testAddUniqueLink() {
		CMLElements<CMLLink> links = xmlMap1.getLinkElements();
		Assert.assertEquals("links", 3, links.size());
		CMLLink link = new CMLLink();
		link.setTo("a4");
		link.setFrom("a14");
		xmlMap1.addUniqueLink(link, CMLMap.Direction.EITHER);
		links = xmlMap1.getLinkElements();
		Assert.assertEquals("links", 4, links.size());
		// dont add if currently exists
		link = new CMLLink();
		link.setTo("a4");
		link.setFrom("a15");
		xmlMap1.addUniqueLink(link, CMLMap.Direction.NEITHER);
		links = xmlMap1.getLinkElements();
		Assert.assertEquals("links", 4, links.size());
		link = new CMLLink();
		link.setTo("a4");
		link.setFrom("a15");
		xmlMap1.addUniqueLink(link, CMLMap.Direction.BOTH);
		links = xmlMap1.getLinkElements();
		Assert.assertEquals("links", 5, links.size());
		link = new CMLLink();
		link.setTo("a4");
		link.setFrom("a15");
		xmlMap1.addUniqueLink(link, CMLMap.Direction.EITHER);
		links = xmlMap1.getLinkElements();
		Assert.assertEquals("links", 5, links.size());
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLMap.addMap(CMLMap)'
	 */
	@Test
	public void testAddMap() {
		Assert.assertEquals("add map1", 3, xmlMap1.getLinkElements().size());
		xmlMap1.addMap(xmlMap2);
		Assert.assertEquals("add map1", 6, xmlMap1.getLinkElements().size());
		Assert.assertEquals("add map2", 3, xmlMap2.getLinkElements().size());
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLMap.removeLink(CMLLink)'
	 */
	@Test
	public void testRemoveLink() {
		CMLLink link;
		Assert.assertEquals("remove link", 3, xmlMap1.getLinkElements().size());
		link = xmlMap1.getLink("a2", CMLMap.Direction.FROM);
		Assert.assertNotNull("get link", link);
		Assert.assertEquals("get link", "a12", link.getTo());
		Assert.assertEquals("get link", "a2", link.getFrom());
		xmlMap1.removeLink(link);
		Assert.assertEquals("remove link", 2, xmlMap1.getLinkElements().size());
		link = xmlMap1.getLink("a2", CMLMap.Direction.FROM);
		Assert.assertNull("get link", link);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLMap.getToRefs()'
	 */
	@Test
	public void testGetToFromRefs() {
		List<String> toRefs = xmlMap1.getToRefs();
		Assert.assertNotNull("toRefs", toRefs);
		Assert.assertEquals("toRefs", 3, toRefs.size());
		StringTestBase.assertEquals("toRefs", new String[] { "a11", "a12",
				"a13" }, toRefs.toArray(new String[0]));
		List<String> fromRefs = xmlMap1.getFromRefs();
		Assert.assertNotNull("fromRefs", fromRefs);
		Assert.assertEquals("fromRefs", 3, fromRefs.size());
		StringTestBase.assertEquals("fromRefs",
				new String[] { "a1", "a2", "a3" }, fromRefs
						.toArray(new String[0]));
		xmlMap1.mergeMap(xmlMap2, Direction.NEITHER);
		toRefs = xmlMap1.getToRefs();
		StringTestBase.assertEquals("toRefs", new String[] { "a11", "a12",
				"a13", "a14", "a15", "a16" }, toRefs.toArray(new String[0]));
		fromRefs = xmlMap1.getFromRefs();
		StringTestBase.assertEquals("fromRefs", new String[] { "a1", "a2",
				"a3", "a4", "a5", "a6" }, fromRefs.toArray(new String[0]));
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLMap.getToRef(String)'
	 */
	@Test
	public void testGetToFromRef() {
		String toRef;
		String fromRef;
		toRef = xmlMap1.getToRef("a1");
		Assert.assertNotNull("toRef", toRef);
		Assert.assertEquals("toRef", "a11", toRef);
		toRef = xmlMap1.getToRef("a4");
		Assert.assertNull("toRef", toRef);
		fromRef = xmlMap1.getFromRef("a11");
		Assert.assertNotNull("fromRef", fromRef);
		Assert.assertEquals("fromRef", "a1", fromRef);
		fromRef = xmlMap1.getFromRef("a14");
		Assert.assertNull("fromRef", fromRef);
		xmlMap1.mergeMap(xmlMap2, Direction.NEITHER);
		toRef = xmlMap1.getToRef("a4");
		Assert.assertNotNull("toRef", toRef);
		Assert.assertEquals("toRef", "a14", toRef);
		fromRef = xmlMap1.getFromRef("a14");
		Assert.assertNotNull("fromRef", fromRef);
		Assert.assertEquals("fromRef", "a4", fromRef);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLMap.getToRefs(List<String>)'
	 */
	@Test
	public void testGetToFromRefsStringList() {
		String[] toS = new String[] { "a13", "a11", "a14" };
		String[] fromS = new String[] { "a3", "a1", "a4" };
		List<String> toIds = Util.createList(toS);
		List<String> fromIds = Util.createList(fromS);
		List<String> toRefs;
		List<String> fromRefs;
		toRefs = xmlMap1.getToRefs(fromIds);
		Assert.assertNotNull("toRefs", toRefs);
		Assert.assertEquals("toRefs", 3, toRefs.size());
		StringTestBase.assertEquals("toRefs",
				new String[] { "a13", "a11", null }, toRefs
						.toArray(new String[0]));
		fromRefs = xmlMap1.getFromRefs(toIds);
		Assert.assertNotNull("fromRefs", fromRefs);
		Assert.assertEquals("fromRefs", 3, fromRefs.size());
		StringTestBase.assertEquals("fromRefs",
				new String[] { "a3", "a1", null }, fromRefs
						.toArray(new String[0]));
		xmlMap1.mergeMap(xmlMap2, Direction.NEITHER);
		toRefs = xmlMap1.getToRefs(fromIds);
		Assert.assertNotNull("toRefs", toRefs);
		Assert.assertEquals("toRefs", 3, toRefs.size());
		StringTestBase.assertEquals("toRefs", new String[] { "a13", "a11",
				"a14" }, toRefs.toArray(new String[0]));
		fromRefs = xmlMap1.getFromRefs(toIds);
		Assert.assertNotNull("fromRefs", fromRefs);
		Assert.assertEquals("fromRefs", 3, fromRefs.size());
		StringTestBase.assertEquals("fromRefs",
				new String[] { "a3", "a1", "a4" }, fromRefs
						.toArray(new String[0]));
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLMap.getRefs(String)'
	 */
	@Test
	public void testGetRefsString() {
		List<String> toRefs = xmlMap1.getRefs(Direction.TO);
		Assert.assertNotNull("toRefs", toRefs);
		Assert.assertEquals("toRefs", 3, toRefs.size());
		StringTestBase.assertEquals("toRefs", new String[] { "a11", "a12",
				"a13" }, toRefs.toArray(new String[0]));
		List<String> fromRefs = xmlMap1.getRefs(Direction.FROM);
		Assert.assertNotNull("fromRefs", fromRefs);
		Assert.assertEquals("fromRefs", 3, fromRefs.size());
		StringTestBase.assertEquals("fromRefs",
				new String[] { "a1", "a2", "a3" }, fromRefs
						.toArray(new String[0]));
		xmlMap1.mergeMap(xmlMap2, Direction.NEITHER);
		toRefs = xmlMap1.getRefs(Direction.TO);
		Assert.assertEquals("toRefs", new String[] { "a11", "a12", "a13",
				"a14", "a15", "a16" }, toRefs.toArray(new String[0]));
		fromRefs = xmlMap1.getRefs(Direction.FROM);
		Assert.assertEquals("fromRefs", new String[] { "a1", "a2", "a3", "a4",
				"a5", "a6" }, fromRefs.toArray(new String[0]));
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLMap.getRefs(String[], String)'
	 */
	@Test
	public void testGetRefsStringArrayString() {
		String[] toS = new String[] { "a13", "a11", "a14" };
		String[] fromS = new String[] { "a3", "a1", "a4" };
		List<String> toIds = Util.createList(toS);
		List<String> fromIds = Util.createList(fromS);
		List<String> toRefs;
		List<String> fromRefs;
		toRefs = xmlMap1.getRefs(fromIds, Direction.TO);
		Assert.assertNotNull("toRefs", toRefs);
		Assert.assertEquals("toRefs", 3, toRefs.size());
		StringTestBase.assertEquals("toRefs",
				new String[] { "a13", "a11", null }, toRefs
						.toArray(new String[0]));
		fromRefs = xmlMap1.getRefs(toIds, Direction.FROM);
		Assert.assertNotNull("fromRefs", fromRefs);
		Assert.assertEquals("fromRefs", 3, fromRefs.size());
		StringTestBase.assertEquals("fromRefs",
				new String[] { "a3", "a1", null }, fromRefs
						.toArray(new String[0]));
		xmlMap1.mergeMap(xmlMap2, Direction.NEITHER);
		toRefs = xmlMap1.getRefs(fromIds, Direction.TO);
		Assert.assertNotNull("toRefs", toRefs);
		Assert.assertEquals("toRefs", 3, toRefs.size());
		StringTestBase.assertEquals("toRefs", new String[] { "a13", "a11",
				"a14" }, toRefs.toArray(new String[0]));
		fromRefs = xmlMap1.getRefs(toIds, Direction.FROM);
		Assert.assertNotNull("fromRefs", fromRefs);
		Assert.assertEquals("fromRefs", 3, fromRefs.size());
		StringTestBase.assertEquals("fromRefs",
				new String[] { "a3", "a1", "a4" }, fromRefs
						.toArray(new String[0]));
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLMap.getRef(String, Direction)'
	 */
	@Test
	public void testGetRef() {
		String ref;
		ref = xmlMap1.getRef("a12", CMLMap.Direction.TO);
		Assert.assertNotNull("get ref", ref);
		Assert.assertEquals("get ref", "a2", ref);
		ref = xmlMap1.getRef("a2", CMLMap.Direction.FROM);
		Assert.assertNotNull("get ref", ref);
		Assert.assertEquals("get ref", "a12", ref);
		ref = xmlMap1.getRef("a2", CMLMap.Direction.TO);
		Assert.assertNull("get ref", ref);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLMap.getLink(String,
	 * Direction)'
	 */
	@Test
	public void testGetLink() {
		CMLLink link;
		link = xmlMap1.getLink("a12", CMLMap.Direction.TO);
		Assert.assertNotNull("get link", link);
		Assert.assertEquals("get link", "a12", link.getTo());
		Assert.assertEquals("get link", "a2", link.getFrom());
		link = xmlMap1.getLink("a2", CMLMap.Direction.FROM);
		Assert.assertNotNull("get link", link);
		Assert.assertEquals("get link", "a12", link.getTo());
		Assert.assertEquals("get link", "a2", link.getFrom());
		link = xmlMap1.getLink("a2", CMLMap.Direction.TO);
		Assert.assertNull("get link", link);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLMap.getFromToLink(String,
	 * String)'
	 */
	@Test
	public void testGetFromToLink() {
		CMLLink link;
		link = xmlMap1.getFromToLink("a2", "a12");
		Assert.assertNotNull("get link", link);
		link = xmlMap1.getFromToLink("a12", "a2");
		Assert.assertNull("get link", link);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLMap.mergeMap(CMLMap, String)'
	 */
	@Test
	public void testMergeMap() {
		xmlMap1.mergeMap(xmlMap2, CMLMap.Direction.NEITHER);
		Assert.assertNotNull("merge", xmlMap1);
		Assert.assertEquals("merge", 6, xmlMap1.getLinkElements().size());
		Assert.assertEquals("merge", 3, xmlMap2.getLinkElements().size());
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLMap.setLinkFromContext(String)'
	 */
	@Test
	public void testSetLinkToFromContext() {
		String fromContext = "mol1";
		String toContext = "mol2";
		Assert.assertNull("context", xmlMap1.getToContext());
		Assert.assertNull("context", xmlMap1.getFromContext());
		for (CMLLink link : xmlMap1.getLinkElements()) {
			Assert.assertNull("link", link.getFromContext());
			Assert.assertNull("link", link.getToContext());
		}
		xmlMap1.setLinkFromContext(fromContext);
		xmlMap1.setLinkToContext(toContext);
		for (CMLLink link : xmlMap1.getLinkElements()) {
			Assert.assertEquals("link", fromContext, link.getFromContext());
			Assert.assertEquals("link", toContext, link.getToContext());
		}
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLMap.setLinkFromType(String)'
	 */
	@Test
	public void testSetLinkToFromType() {
		Assert.assertEquals("type", CMLAtom.NS, xmlMap1.getToType());
		Assert.assertEquals("type", CMLAtom.NS, xmlMap1.getFromType());
		String toType = CMLPeak.NS;
		String fromType = CMLBond.NS;
		for (CMLLink link : xmlMap1.getLinkElements()) {
			Assert.assertNull("link", link.getFromType());
			Assert.assertNull("link", link.getToType());
		}
		xmlMap1.setLinkToType(toType);
		xmlMap1.setLinkFromType(fromType);
		Assert.assertEquals("type", CMLAtom.NS, xmlMap1.getToType());
		Assert.assertEquals("type", CMLAtom.NS, xmlMap1.getFromType());
		for (CMLLink link : xmlMap1.getLinkElements()) {
			Assert.assertEquals("type", fromType, link.getFromType());
			Assert.assertEquals("type", toType, link.getToType());
		}
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLMap.annotateLinks(String,
	 * String, String, String)'
	 */
	@Test
	public void testAnnotateLinks() {
		String toType = CMLPeak.NS;
		String fromType = CMLBond.NS;
		String fromContext = "mol1";
		String toContext = "mol2";
		for (CMLLink link : xmlMap1.getLinkElements()) {
			Assert.assertNull("link", link.getFromType());
			Assert.assertNull("link", link.getToType());
			Assert.assertNull("link", link.getFromContext());
			Assert.assertNull("link", link.getToContext());
		}
		xmlMap1.annotateLinks(fromType, fromContext, toType, toContext);
		for (CMLLink link : xmlMap1.getLinkElements()) {
			Assert.assertEquals("type", fromType, link.getFromType());
			Assert.assertEquals("type", toType, link.getToType());
			Assert.assertEquals("link", "mol1", link.getFromContext());
			Assert.assertEquals("link", "mol2", link.getToContext());
		}
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLMap.getToRefs()'
	 */
	@Test
	public void testGetToRefs() {
		List<String> toRefList = xmlMap1.getToRefs();
		StringTestBase.assertEquals("toRefs", new String[] { "a11", "a12",
				"a13" }, (String[]) toRefList.toArray(new String[0]));
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLMap.getFromRefs()'
	 */
	@Test
	public void testGetFromRefs() {
		List<String> fromRefList = xmlMap1.getFromRefs();
		StringTestBase.assertEquals("fromRefs",
				new String[] { "a1", "a2", "a3" }, (String[]) fromRefList
						.toArray(new String[0]));
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLMap.getToRef(String)'
	 */
	@Test
	public void testGetToRef() {
		String toRef = xmlMap1.getToRef("a1");
		Assert.assertEquals("toRef", "a11", toRef);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLMap.getFromRef(String)'
	 */
	@Test
	public void testGetFromRef() {
		String fromRef = xmlMap1.getFromRef("a11");
		Assert.assertEquals("fromRef", "a1", fromRef);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLMap.getToRefs(List<String>)'
	 */
	@Test
	public void testGetToRefsListOfString() {
		List<String> fromList = new ArrayList<String>();
		fromList.add("a2");
		fromList.add("a3");
		fromList.add("a1");
		List<String> toRef = xmlMap1.getToRefs(fromList);
		StringTestBase.assertEquals("toRef",
				new String[] { "a12", "a13", "a11" }, (String[]) toRef
						.toArray(new String[0]));
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLMap.getFromRefs(List<String>)'
	 */
	@Test
	public void testGetFromRefsListOfString() {
		List<String> toList = new ArrayList<String>();
		toList.add("a12");
		toList.add("a13");
		toList.add("a11");
		List<String> fromRef = xmlMap1.getFromRefs(toList);
		StringTestBase.assertEquals("toRef", new String[] { "a2", "a3", "a1" },
				(String[]) fromRef.toArray(new String[0]));
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLMap.getRefs(Direction)'
	 */
	@Test
	public void testGetRefsDirection() {
		List<String> ref = xmlMap1.getRefs(Direction.EITHER);
		StringTestBase.assertEquals("ref", new String[] { "a1", "a2", "a3" },
				(String[]) ref.toArray(new String[0]));
		ref = xmlMap1.getRefs(Direction.BOTH);
		StringTestBase.assertEquals("ref", new String[] { "a1", "a2", "a3" },
				(String[]) ref.toArray(new String[0]));
		ref = xmlMap1.getRefs(Direction.NEITHER);
		StringTestBase.assertEquals("ref", new String[] { "a1", "a2", "a3" },
				(String[]) ref.toArray(new String[0]));
		ref = xmlMap1.getRefs(Direction.FROM);
		StringTestBase.assertEquals("ref", new String[] { "a1", "a2", "a3" },
				(String[]) ref.toArray(new String[0]));
		ref = xmlMap1.getRefs(Direction.TO);
		StringTestBase.assertEquals("ref",
				new String[] { "a11", "a12", "a13" }, (String[]) ref
						.toArray(new String[0]));
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLMap.getRefs(List<String>,
	 * Direction)'
	 */
	@Test
	public void testGetRefsListOfStringDirection() {

		List<String> list = new ArrayList<String>();
		list.add("a12");
		list.add("a3");
		list.add("a11");
		List<String> ref = xmlMap1.getRefs(list, Direction.EITHER);
		StringTestBase.assertEquals("ref", new String[] { null, "a13", null },
				(String[]) ref.toArray(new String[0]));
		ref = xmlMap1.getRefs(list, Direction.BOTH);
		StringTestBase.assertEquals("ref", new String[] { null, "a13", null },
				(String[]) ref.toArray(new String[0]));
		ref = xmlMap1.getRefs(list, Direction.NEITHER);
		StringTestBase.assertEquals("ref", new String[] { null, "a13", null },
				(String[]) ref.toArray(new String[0]));
		ref = xmlMap1.getRefs(list, Direction.FROM);
		StringTestBase.assertEquals("ref", new String[] { "a2", null, "a1" },
				(String[]) ref.toArray(new String[0]));
		ref = xmlMap1.getRefs(list, Direction.TO);
		StringTestBase.assertEquals("ref", new String[] { null, "a13", null },
				(String[]) ref.toArray(new String[0]));
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLMap.setLinkFromContext(String)'
	 */
	@Test
	public void testSetLinkFromContext() {
		xmlMap1.setLinkFromContext("foo");
		String ss = "<map id='m1' fromType='cml:atom' toType='cml:atom' "
				+ "xmlns='http://www.xml-cml.org/schema'>"
				+ "  <link from='a1' to='a11' fromContext='foo'/>"
				+ "  <link from='a2' to='a12' fromContext='foo'/>"
				+ "  <link from='a3' to='a13' fromContext='foo'/>" + "</map>";
		CMLMap expected = (CMLMap) parseValidString(ss);
		assertEqualsCanonically("set from", expected, xmlMap1);

	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLMap.setLinkToContext(String)'
	 */
	@Test
	public void testSetLinkToContext() {
		xmlMap1.setLinkToContext("foo");
		String ss = "<map id='m1' fromType='cml:atom' toType='cml:atom' "
				+ "xmlns='http://www.xml-cml.org/schema'>"
				+ "  <link from='a1' to='a11' toContext='foo'/>"
				+ "  <link from='a2' to='a12' toContext='foo'/>"
				+ "  <link from='a3' to='a13' toContext='foo'/>" + "</map>";
		CMLMap expected = (CMLMap) parseValidString(ss);
		assertEqualsCanonically("set to", expected, xmlMap1);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLMap.setLinkFromType(String)'
	 */
	@Test
	public void testSetLinkFromType() {
		xmlMap1.setLinkFromType("foo");
		String ss = "<map id='m1' fromType='cml:atom' toType='cml:atom' "
				+ "xmlns='http://www.xml-cml.org/schema'>"
				+ "  <link from='a1' to='a11' fromType='foo'/>"
				+ "  <link from='a2' to='a12' fromType='foo'/>"
				+ "  <link from='a3' to='a13' fromType='foo'/>" + "</map>";
		CMLMap expected = (CMLMap) parseValidString(ss);
		assertEqualsCanonically("set fromType", expected, xmlMap1);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLMap.setLinkToType(String)'
	 */
	@Test
	public void testSetLinkToType() {
		xmlMap1.setLinkToType("foo");
		String ss = "<map id='m1' fromType='cml:atom' toType='cml:atom' "
				+ "xmlns='http://www.xml-cml.org/schema'>"
				+ "  <link from='a1' to='a11' toType='foo'/>"
				+ "  <link from='a2' to='a12' toType='foo'/>"
				+ "  <link from='a3' to='a13' toType='foo'/>" + "</map>";
		CMLMap expected = (CMLMap) parseValidString(ss);
		assertEqualsCanonically("set fromType", expected, xmlMap1);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLMap.getElementLinks(String)'
	 */
	@Test
	public void testGetElementLinks() {
		List<CMLLink> links = xmlMap1.getElementLinks("foo");
		Assert.assertEquals("links", 0, links.size());
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLMap.getType(CMLLink,
	 * Direction)'
	 */
	@Test
	public void testGetType() {
		CMLLink link = xmlMap1.getLinkElements().get(0);
		String type = CMLMap.getType(link, Direction.TO);
		Assert.assertEquals("link type", CMLAtom.NS, type);
	}
}
