package org.xmlcml.cml.element.main;

import static org.xmlcml.cml.base.BaseTest.parseValidString;
import static org.xmlcml.cml.base.CMLConstants.CML_XMLNS;
import static org.xmlcml.euclid.EuclidConstants.EPS;
import static org.xmlcml.euclid.test.EuclidTestBase.alwaysFail;
import static org.xmlcml.euclid.test.EuclidTestBase.neverThrow;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.xmlcml.cml.element.CMLAtom;
import org.xmlcml.cml.element.CMLAtomSet;
import org.xmlcml.cml.element.CMLBond;
import org.xmlcml.cml.element.CMLCml;
import org.xmlcml.cml.element.CMLMolecule;
import org.xmlcml.cml.element.CMLTorsion;
import org.xmlcml.euclid.test.StringTestBase;

/**
 * tests torsion.
 * 
 * @author pm286
 * 
 */
public class CMLTorsionTest {

	String s1 = "" + "<cml " + CML_XMLNS + ">" + " <molecule id='m1'>"
			+ "  <atomArray>" + "   <atom id='a1' x3='1.0' y3='0.0' z3='0.0'/>"
			+ "   <atom id='a2' x3='0.0' y3='0.0' z3='0.0'/>"
			+ "   <atom id='a3' x3='0.0' y3='0.0' z3='2.0'/>"
			+ "   <atom id='a4' x3='0.0' y3='1.0' z3='2.0'/>"
			+ "   <atom id='a5' x3='-1.0' y3='1.0' z3='2.0'/>"
			+ "  </atomArray>" + "  <bondArray>"
			+ "   <bond id='b12' atomRefs2='a1 a2'/>"
			+ "   <bond id='b23' atomRefs2='a2 a3'/>"
			+ "   <bond id='b34' atomRefs2='a3 a4'/>"
			+ "   <bond id='b45' atomRefs2='a4 a5'/>" + "  </bondArray>"
			+ " </molecule>" + " <torsion id='aa0' atomRefs4='a1 a2 a3 a4'/>"
			+ " <torsion id='aa1' atomRefs4='a2 a3 a4 a5'/>"
			+ " <torsion id='nonexistent' atomRefs4='a3 a4 a5 a6'/>" + "</cml>"
			+ "";

	CMLTorsion torsion0;
	CMLTorsion torsion1;
	CMLTorsion torsion2;

	CMLMolecule molecule1;

	/**
	 * setup.
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		CMLCml cml = (CMLCml) parseValidString(s1);
		molecule1 = (CMLMolecule) cml.getChildCMLElements("molecule").get(0);
		torsion0 = (CMLTorsion) cml.getChildCMLElements("torsion").get(0);
		torsion1 = (CMLTorsion) cml.getChildCMLElements("torsion").get(1);
		torsion2 = (CMLTorsion) cml.getChildCMLElements("torsion").get(2);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLTorsion.copy()'
	 */
	@Test
	public void testCopy() {
		CMLTorsion torsion00 = (CMLTorsion) torsion0.copy();
		StringTestBase.assertEquals("atomRefs4", new String[] { "a1", "a2",
				"a3", "a4" }, torsion00.getAtomRefs4());
	}

	/**
	 * test getIdList.
	 */
	@Test
	public void testGetIdList() {
		List<String> idList = torsion0.getAtomIds();
		Assert.assertNotNull("atom ids should not be null", idList);
		Assert.assertEquals("atom ids", 4, idList.size());
		Assert.assertEquals("atom id 0", "a1", idList.get(0));
		Assert.assertEquals("atom id 1", "a2", idList.get(1));
		Assert.assertEquals("atom id 2", "a3", idList.get(2));
		Assert.assertEquals("atom id 3", "a4", idList.get(3));
		torsion0.removeAttribute("atomRefs4");
		idList = torsion0.getAtomIds();
		Assert.assertNull("atom ids should be null", idList);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLTorsion.getAtoms(CMLMolecule)'
	 */
	@Test
	public void testGetAtoms() {
		List<CMLAtom> atomRefs4 = null;
		try {
			atomRefs4 = torsion0.getAtoms(molecule1);
		} catch (RuntimeException e) {
			neverThrow(e);
		}
		Assert.assertNotNull("atomRefs4 not null", atomRefs4);
		String msg = RuntimeException.class.getName() + ": cannot find atom a6";
		try {
			atomRefs4 = torsion2.getAtoms(molecule1);
			alwaysFail(msg);
		} catch (RuntimeException e) {
			Assert.assertEquals("non existent atom ", msg, "" + e);
		}
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLTorsion.getAtoms(CMLAtomSet)'
	 */
	@Test
	public void testGetAtomsFromAtomSet() {
		CMLAtomSet atomSet = new CMLAtomSet(molecule1);
		List<CMLAtom> atomRefs4 = null;
		try {
			atomRefs4 = torsion0.getAtoms(atomSet);
		} catch (RuntimeException e) {
			neverThrow(e);
		}
		Assert.assertNotNull("atomRefs4 not null", atomRefs4);
		String msg = RuntimeException.class.getName() + ": cannot find atom a6";
		try {
			atomRefs4 = torsion2.getAtoms(molecule1);
			alwaysFail(msg);
		} catch (RuntimeException e) {
			Assert.assertEquals("non existent atom ", msg, "" + e);
		}
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLTorsion.getCalculatedTorsion(CMLMolecule)'
	 */
	@Test
	public void testGetCalculatedTorsion() {
		double t = torsion0.getCalculatedTorsion(molecule1);
		Assert.assertEquals("calculated torsion", t, 90., EPS);

	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLTorsion.atomHash(String,
	 * String, String, String)'
	 */
	@Test
	public void testAtomHash() {
		String atomHash = CMLTorsion.atomHash("a1", "a2", "a3", "a4");
		Assert
				.assertEquals("atomHash", "a4" + CMLBond.HASH_SYMB + "a3"
						+ CMLBond.HASH_SYMB + "a2" + CMLBond.HASH_SYMB + "a1",
						atomHash);
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLTorsion.getIndexedTorsions(CMLTorsion[])'
	 */
	@Test
	public void testGetIndexedTorsions() {
		List<CMLTorsion> torsions = new ArrayList<CMLTorsion>();
		torsions.add(torsion0);
		Map<String, CMLTorsion> map = CMLTorsion.getIndexedTorsions(torsions);
		Assert.assertNotNull("indexed", map);
		Assert.assertEquals("indexed", 1, map.size());
		Assert.assertEquals("indexed", torsion0, map.get("a4"
				+ CMLBond.HASH_SYMB + "a3" + CMLBond.HASH_SYMB + "a2"
				+ CMLBond.HASH_SYMB + "a1"));
	}

}
