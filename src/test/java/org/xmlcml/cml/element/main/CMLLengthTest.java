package org.xmlcml.cml.element.main;

import static org.xmlcml.euclid.EuclidConstants.EPS;
import static org.xmlcml.euclid.test.EuclidTestBase.alwaysFail;
import static org.xmlcml.euclid.test.EuclidTestBase.neverThrow;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.xmlcml.cml.base.CMLConstants;
import org.xmlcml.cml.base.CMLXOMTestUtils;
import org.xmlcml.cml.element.CMLAtom;
import org.xmlcml.cml.element.CMLBond;
import org.xmlcml.cml.element.CMLCml;
import org.xmlcml.cml.element.CMLLength;
import org.xmlcml.cml.element.CMLMolecule;
import org.xmlcml.euclid.test.StringTestBase;

/**
 * test length.
 * 
 * @author pm286
 * 
 */
public class CMLLengthTest {

	String s1 = "" + "<cml " + CMLConstants.CML_XMLNS + ">" + " <molecule id='m1'>"
			+ "  <atomArray>" + "   <atom id='a1' x3='1.0' y3='0.0' z3='0.0'/>"
			+ "   <atom id='a2' x3='0.0' y3='0.0' z3='0.0'/>"
			+ "   <atom id='a3' x3='0.0' y3='0.0' z3='2.0'/>"
			+ "  </atomArray>" + " </molecule>"
			+ " <length id='aa0' atomRefs2='a1 a2'/>"
			+ " <length id='aa1' atomRefs2='a2 a1'/>"
			+ " <length id='aa2' atomRefs2='a1 a4'/>" + "</cml>" + "";

	CMLLength length0;

	CMLLength length1;

	CMLLength length2;

	CMLMolecule molecule1;

	/**
	 * set up.
	 * 
	 * @exception Exception
	 */
	@Before
	public void setUp() throws Exception {
		CMLCml cml = (CMLCml)CMLXOMTestUtils.parseValidString(s1);
		molecule1 = (CMLMolecule) cml.getChildCMLElements("molecule").get(0);
		length0 = (CMLLength) cml.getChildCMLElements("length").get(0);
		length1 = (CMLLength) cml.getChildCMLElements("length").get(1);
		length2 = (CMLLength) cml.getChildCMLElements("length").get(2);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLLength.copy()'
	 */
	@Test
	public final void testCopy() {
		CMLLength length00 = (CMLLength) length0.copy();
		StringTestBase.assertEquals("atomRefs2", new String[] { "a1", "a2" },
				length00.getAtomRefs2());
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLLength.getAtomIds()'
	 */
	@Test
	public final void testGetAtomIds() {
		List<String> idList = length0.getAtomIds();
		Assert.assertNotNull("atom ids should not be null", idList);
		Assert.assertEquals("atom ids", 2, idList.size());
		Assert.assertEquals("atom id 0", "a1", idList.get(0));
		Assert.assertEquals("atom id 1", "a2", idList.get(1));
		length0.removeAttribute("atomRefs2");
		idList = length0.getAtomIds();
		Assert.assertNull("atom ids should be null", idList);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLLength.getAtoms2()'
	 */
	@Test
	public final void testGetAtoms() {
		List<CMLAtom> atomRefs2 = null;
		try {
			atomRefs2 = length0.getAtoms(molecule1);
		} catch (RuntimeException e) {
			neverThrow(e);
		}
		Assert.assertNotNull("atomRefs2 not null", atomRefs2);
		String msg = RuntimeException.class.getName() + ": cannot find atom a4";
		try {
			atomRefs2 = length2.getAtoms(molecule1);
			alwaysFail(msg);
		} catch (RuntimeException e) {
			Assert.assertEquals("non existent atom ", msg, "" + e);
		}
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLLength.getCalculatedLength(CMLMolecule)'
	 */
	@Test
	public final void testGetCalculatedLength() {
		double length = length0.getCalculatedLength(molecule1);
		Assert.assertEquals("length0 ", 1.0, length, EPS);
		length = length1.getCalculatedLength(molecule1);
		Assert.assertEquals("length1 ", 1.0, length, EPS);
		String msg = RuntimeException.class.getName() + ": cannot find atom a4";
		try {
			length = length2.getCalculatedLength(molecule1);
		} catch (RuntimeException e) {
			Assert.assertEquals("non existent ", msg, "" + e);
		}
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLLength.getIndexedLengths(List<CMLLength>)'
	 */
	@Test
	public final void testGetIndexedLengths() {
		List<CMLLength> lengths = new ArrayList<CMLLength>();
		lengths.add(length0);
		lengths.add(length1);
		Map<String, CMLLength> map = CMLLength.getIndexedLengths(lengths);
		Assert.assertEquals("size of map", 1, map.size());
		// retrieve by atom ids
		CMLLength length = map.get(CMLBond.atomHash("a1", "a2"));
		Assert.assertNotNull("length not null", length);
		StringTestBase.assertEquals("atomRefs2 ", new String[] { "a2", "a1" },
				length.getAtomRefs2());
		// retrieve in other order
		length = map.get(CMLBond.atomHash("a2", "a1"));
		Assert.assertNotNull("length not null", length);
		StringTestBase.assertEquals("atomRefs2 ", new String[] { "a2", "a1" },
				length.getAtomRefs2());
		// non existent
		length = map.get(CMLBond.atomHash("a4", "a2"));
		Assert.assertNull("length null", length);
	}

}
