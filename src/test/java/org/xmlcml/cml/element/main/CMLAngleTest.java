package org.xmlcml.cml.element.main;

import static org.xmlcml.cml.base.BaseTest.parseValidString;
import static org.xmlcml.cml.base.CMLConstants.CML_XMLNS;
import static org.xmlcml.euclid.EuclidConstants.EPS;
import static org.xmlcml.euclid.EuclidConstants.S_EMPTY;
import static org.xmlcml.euclid.test.EuclidTestBase.alwaysFail;
import static org.xmlcml.euclid.test.EuclidTestBase.neverThrow;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import nu.xom.Element;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.xmlcml.cml.element.CMLAngle;
import org.xmlcml.cml.element.CMLAtom;
import org.xmlcml.cml.element.CMLBond;
import org.xmlcml.cml.element.CMLCml;
import org.xmlcml.cml.element.CMLMolecule;
import org.xmlcml.euclid.test.StringTestBase;

/**
 * tests CMLAngle.
 * 
 * @author pm286
 * 
 */

public class CMLAngleTest {

	String s1 = S_EMPTY + "<cml " + CML_XMLNS + ">" + " <molecule id='m1'>"
			+ "  <atomArray>" + "   <atom id='a1' x3='1.0' y3='0.0' z3='0.0'/>"
			+ "   <atom id='a2' x3='0.0' y3='0.0' z3='0.0'/>"
			+ "   <atom id='a3' x3='0.0' y3='0.0' z3='2.0'/>"
			+ "  </atomArray>" + "  <bondArray>"
			+ "    <bond atomRefs2='a1 a2'/>" + "    <bond atomRefs2='a3 a2'/>"
			+ "  </bondArray>" + " </molecule>"
			+ " <angle id='aa0' atomRefs3='a1 a2 a3'/>"
			+ " <angle id='aa1' atomRefs3='a2 a1 a3'/>"
			+ " <angle id='aa2' atomRefs3='a1 a2 a4'/>" + "</cml>" + S_EMPTY;

	CMLAngle angle0;
	CMLAngle angle1;
	CMLAngle angle2;
	CMLMolecule molecule1;

	/**
	 * setup.
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		Element element = null;
		try {
			element = parseValidString(s1);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("EXC " + e);
			throw e;
		}
		CMLCml cml = (CMLCml) element;
		molecule1 = (CMLMolecule) cml.getChildCMLElements("molecule").get(0);
		angle0 = (CMLAngle) cml.getChildCMLElements("angle").get(0);
		angle1 = (CMLAngle) cml.getChildCMLElements("angle").get(1);
		angle2 = (CMLAngle) cml.getChildCMLElements("angle").get(2);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLAngle.copy()'
	 */
	@Test
	public final void testCopy() {
		CMLAngle angle00 = (CMLAngle) angle0.copy();
		StringTestBase.assertEquals("atomRefs3", new String[] { "a1", "a2",
				"a3" }, angle00.getAtomRefs3());
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLAngle.CMLAngle()'
	 */
	@Test
	public final void testCMLAngle() {
		CMLAngle angle00 = new CMLAngle(angle0);
		StringTestBase.assertEquals("atomRefs3", new String[] { "a1", "a2",
				"a3" }, angle00.getAtomRefs3());
	}

	/**
	 * test getIdList.
	 */
	@Test
	public void testGetIdList() {
		List<String> idList = angle0.getAtomIds();
		Assert.assertNotNull("atom ids should not be null", idList);
		Assert.assertEquals("atom ids", 3, idList.size());
		Assert.assertEquals("atom id 0", "a1", idList.get(0));
		Assert.assertEquals("atom id 1", "a2", idList.get(1));
		Assert.assertEquals("atom id 2", "a3", idList.get(2));
		angle0.removeAttribute("atomRefs3");
		idList = angle0.getAtomIds();
		Assert.assertNull("atom ids should be null", idList);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLAngle.getAtoms(CMLMolecule)'
	 */
	@Test
	public final void testGetAtoms() {
		List<CMLAtom> atomRefs3 = null;
		try {
			atomRefs3 = angle0.getAtoms(molecule1);
		} catch (RuntimeException e) {
			neverThrow(e);
		}
		Assert.assertNotNull("atomRefs3 not null", atomRefs3);
		String msg = RuntimeException.class.getName() + ": cannot find atom a4";
		try {
			atomRefs3 = angle2.getAtoms(molecule1);
			alwaysFail(msg);
		} catch (RuntimeException e) {
			// OK
		}
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLAngle.getCalculatedAngle(CMLMolecule)'
	 */
	@Test
	public final void testGetCalculatedAngle() {
		double angle = angle0.getCalculatedAngle(molecule1);
		Assert.assertEquals("angle0 ", 90.0, angle, EPS);
		angle = angle1.getCalculatedAngle(molecule1);
		Assert.assertEquals("angle1 ", 2.0, Math.tan(angle * Math.PI / 180.),
				EPS);
		try {
			angle = angle2.getCalculatedAngle(molecule1);
			Assert.fail("Should throw non-existent atom a4");
		} catch (RuntimeException e) {
			// OK
		}
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLAngle.atomHash(String, String,
	 * String)'
	 */
	@Test
	public final void testAtomHash() {
		String s = "a1" + CMLBond.HASH_SYMB + "a2" + CMLBond.HASH_SYMB + "a3";
		Assert
				.assertEquals("atom hash", s, CMLAngle.atomHash("a1", "a2",
						"a3"));
		Assert
				.assertEquals("atom hash", s, CMLAngle.atomHash("a3", "a2",
						"a1"));
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLAngle.getIndexedAngles(CMLAngle[])'
	 */
	@Test
	public final void testGetIndexedAngles() {
		List<CMLAngle> angles = new ArrayList<CMLAngle>();
		angles.add(angle0);
		angles.add(angle1);
		Map<String, CMLAngle> map = CMLAngle.getIndexedAngles(angles);
		Assert.assertEquals("size of map", 2, map.size());
		// retrieve by atom ids
		CMLAngle angle = map.get(CMLAngle.atomHash("a1", "a2", "a3"));
		Assert.assertNotNull("angle not null", angle);
		StringTestBase.assertEquals("atomRefs3 ", new String[] { "a1", "a2",
				"a3" }, angle.getAtomRefs3());
		// retrieve in other order
		angle = map.get(CMLAngle.atomHash("a3", "a2", "a1"));
		Assert.assertNotNull("angle not null", angle);
		StringTestBase.assertEquals("atomRefs3 ", new String[] { "a1", "a2",
				"a3" }, angle.getAtomRefs3());
		// non existent
		angle = map.get(CMLAngle.atomHash("a4", "a2", "a1"));
		Assert.assertNull("angle null", angle);
	}

	/**
	 * Test method for {@link org.xmlcml.cml.element.CMLAngle#getAtomIds()}.
	 */
	@Test
	public final void testGetAtomIds() {
		List<String> atomIds = angle1.getAtomIds();
		Assert.assertEquals("ids ", 3, atomIds.size());
		Assert.assertEquals("id0 ", "a2", atomIds.get(0));
		Assert.assertEquals("id1 ", "a1", atomIds.get(1));
		Assert.assertEquals("id2 ", "a3", atomIds.get(2));
	}

	/**
	 * Test method for
	 * {@link org.xmlcml.cml.element.CMLAngle#getAtoms(org.xmlcml.cml.element.CMLMolecule)}
	 * .
	 */
	@Test
	public final void testGetAtomsCMLMolecule() {
		List<CMLAtom> atoms = angle1.getAtoms(molecule1);
		Assert.assertEquals("ids ", 3, atoms.size());
		Assert.assertEquals("id0 ", "a2", atoms.get(0).getId());
		Assert.assertEquals("id1 ", "a1", atoms.get(1).getId());
		Assert.assertEquals("id2 ", "a3", atoms.get(2).getId());
	}

	/**
	 * Test method for
	 * {@link org.xmlcml.cml.element.CMLAngle#getAtoms(org.xmlcml.cml.element.CMLAtomSet)}
	 * .
	 */
	@Test
	public final void testGetAtomsCMLAtomSet() {
		List<CMLAtom> atoms = angle1.getAtoms(molecule1);
		Assert.assertEquals("ids ", 3, atoms.size());
		Assert.assertEquals("id0 ", "a2", atoms.get(0).getId());
		Assert.assertEquals("id1 ", "a1", atoms.get(1).getId());
		Assert.assertEquals("id2 ", "a3", atoms.get(2).getId());
	}

	/**
	 * Test method for
	 * {@link org.xmlcml.cml.element.CMLAngle#getCalculatedAngle(org.xmlcml.cml.element.CMLMolecule)}
	 * .
	 */
	@Test
	public final void testGetCalculatedAngleCMLMolecule() {
		double d = angle0.getCalculatedAngle(molecule1);
		Assert.assertEquals("ang0 ", 90.0, d, EPS);
		d = angle1.getCalculatedAngle(molecule1);
		Assert.assertEquals("ang1 ", 2, Math.tan(d * Math.PI / 180.), EPS);
	}

	/**
	 * Test method for
	 * {@link org.xmlcml.cml.element.CMLAngle#getCalculatedAngle(org.xmlcml.cml.element.CMLAtomSet)}
	 * .
	 */
	@Test
	public final void testGetCalculatedAngleCMLAtomSet() {
		double d = angle0.getCalculatedAngle(molecule1);
		Assert.assertEquals("ang0 ", 90.0, d, EPS);
		d = angle1.getCalculatedAngle(molecule1);
		Assert.assertEquals("ang1 ", 2, Math.tan(d * Math.PI / 180.), EPS);
	}

	/**
	 * Test method for
	 * {@link org.xmlcml.cml.element.CMLAngle#atomHash(java.lang.String, java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void testAtomHashStringStringString() {
		String s = CMLAngle.atomHash("a20", "a21", "a22");
		Assert.assertEquals("hash ", "a20" + CMLBond.HASH_SYMB + "a21"
				+ CMLBond.HASH_SYMB + "a22", s);
		s = CMLAngle.atomHash("a22", "a21", "a20");
		Assert.assertEquals("hash ", "a20" + CMLBond.HASH_SYMB + "a21"
				+ CMLBond.HASH_SYMB + "a22", s);
	}

	/**
	 * Test method for
	 * {@link org.xmlcml.cml.element.CMLAngle#getList(org.xmlcml.cml.base.CMLElements)}
	 * .
	 */
	@Test
	public final void testGetList() {
		// obsolescent method?
	}

	/**
	 * Test method for
	 * {@link org.xmlcml.cml.element.CMLAngle#setAtomRefs3(org.xmlcml.cml.element.CMLAtom, org.xmlcml.cml.element.CMLAtom, org.xmlcml.cml.element.CMLAtom)}
	 * .
	 */
	@Test
	public final void testSetAtomRefs3CMLAtomCMLAtomCMLAtom() {
		CMLAngle angle = new CMLAngle();
		List<CMLAtom> atoms = molecule1.getAtoms();
		angle.setAtomRefs3(atoms.get(1), atoms.get(2), atoms.get(0));
		StringTestBase.assertEquals("atoms", new String[] { "a2", "a3", "a1" },
				angle.getAtomRefs3());
	}

}
