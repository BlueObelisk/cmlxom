/**
 * 
 */
package org.xmlcml.cml.element.lite;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.xmlcml.cml.element.CMLAtom;
import org.xmlcml.cml.element.CMLBond;
import org.xmlcml.cml.element.CMLBondArray;
import org.xmlcml.cml.element.CMLMolecule;
import org.xmlcml.cml.element.main.MoleculeAtomBondFixture;

/**
 * @author pm286
 * 
 */
public class CMLBondArrayTest {
	MoleculeAtomBondFixture fixture = new MoleculeAtomBondFixture();
	CMLMolecule moleculex;
	CMLBondArray bondArrayx;
	CMLAtom atom0x;
	CMLAtom atom1x;
	CMLAtom atom2x;
	CMLBond bond01x;
	CMLBond bond12x;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		makeMola();
	}

	void makeMola() {
		moleculex = CMLMolecule.createMoleculeWithId("m1");
		atom0x = new CMLAtom("a0");
		moleculex.addAtom(atom0x);
		atom1x = new CMLAtom("a1");
		moleculex.addAtom(atom1x);
		bond01x = new CMLBond("b01", atom0x, atom1x);
		moleculex.appendChild(bond01x);
		bondArrayx = moleculex.getBondArray();
		atom2x = new CMLAtom("a2");
		moleculex.addAtom(atom2x);
		bond12x = new CMLBond("b12", atom1x, atom2x);
		bondArrayx.addBond(bond12x);
	}

	/**
	 * Test method for {@link org.xmlcml.cml.element.CMLBondArray#detach()}
	 * .
	 */
	@Test
	public final void testDetach() {
		CMLMolecule xomMolecule = fixture.xomMolecule;
		CMLBondArray bondArray = xomMolecule.getBondArray();
		Assert.assertNotNull("get bondarray", bondArray);
		List<CMLBond> bondList = xomMolecule.getBonds();
		Assert.assertEquals("bond count before detach", 5, bondList.size());
		Assert.assertEquals("bond count before detach", 5, bondArray.getBondElements()
				.size());
		CMLBond b1 = xomMolecule.getBondById("b1");
		Assert.assertNotNull("get bond", b1);
		Assert.assertEquals("get bond", "b1", b1.getId());

		bondArray.detach();
		Assert.assertEquals("bond count after detach", 5, bondArray.getBondElements()
				.size());
		bondList = xomMolecule.getBonds();
		Assert.assertEquals("bond count after detach", 0, bondList.size());
		b1 = xomMolecule.getBondById("b1");
		Assert.assertNull("get bond", b1);
	}

	/**
	 * Test method for
	 * {@link org.xmlcml.cml.element.CMLBondArray#CMLBondArray()}.
	 */
	@Test
	public final void testCMLBondArray() {
		CMLBondArray bondArray = new CMLBondArray();
		Assert.assertNotNull("get bondarray", bondArray);
		CMLMolecule xMolecule = CMLMolecule.createMoleculeWithId("m1");
		CMLAtom atom0 = new CMLAtom("a0");
		xMolecule.addAtom(atom0);
		CMLAtom atom1 = new CMLAtom("a1");
		xMolecule.addAtom(atom1);
		CMLAtom atom2 = new CMLAtom("a2");
		xMolecule.addAtom(atom2);
		List<CMLBond> bondList = bondArray.getBonds();
		Assert.assertEquals("bond count ", 0, bondList.size());
		CMLBond bond01 = new CMLBond("b01", atom0, atom1);
		// adding bond will fail, as no parent molecule
		try {
			bondArray.addBond(bond01);
			Assert.fail("cannot add bonds unless they belong to molecule");
		} catch (RuntimeException e) {
			Assert.assertEquals("expected fail", "bondArray parent must be molecule",
					e.getMessage());
		}
		xMolecule.addBondArray(bondArray);

		bondArray.addBond(bond01);
		CMLBond bond12 = new CMLBond("b12", atom1, atom2);
		bondArray.addBond(bond12);
		Assert.assertEquals("bond count ", 2, bondArray.size());
		CMLBond bx = xMolecule.getBondById("b12");
		Assert.assertNotNull("get bond not null", bx);
		Assert.assertEquals("get bond", "b12", bx.getId());

		bondArray.detach();
		Assert.assertEquals("bond count after detach", 2, bondArray.getBondElements()
				.size());
		bondList = xMolecule.getBonds();
		Assert.assertEquals("bond count after detach", 0, bondList.size());
		bx = xMolecule.getBondById("b1");
		Assert.assertNull("get bond", bx);
	}

	/**
	 * Test method for
	 * {@link org.xmlcml.cml.element.CMLBondArray#appendChild(org.xmlcml.cml.element.CMLBond)}
	 * .
	 */
	@Test
	public final void testAppendChildCMLBond() {
		CMLMolecule molecule = CMLMolecule.createMoleculeWithId("m1");
		CMLBondArray bondArray = new CMLBondArray();
		Assert.assertNotNull("get bondarray", bondArray);
		Assert.assertNull("mol bondarray", molecule.getBondArray());
		CMLAtom atom0 = new CMLAtom("a0");
		molecule.addAtom(atom0);
		CMLAtom atom1 = new CMLAtom("a1");
		molecule.addAtom(atom1);
		CMLBond bond01 = new CMLBond("b01", atom0, atom1);
		molecule.appendChild(bond01);
		CMLBond bondx = molecule.getBonds().get(0);
		Assert.assertNotNull("bond01", bondx);
		// test size
		// bondArray not yet added
		Assert.assertEquals("size", 0, bondArray.size());
		bondArray = molecule.getBondArray();
		Assert.assertEquals("size", 1, bondArray.size());
		CMLAtom atom2 = new CMLAtom("a2");
		molecule.addAtom(atom2);
		CMLBond bond12 = new CMLBond("b12", atom1, atom2);
		bondArray.addBond(bond12);
		Assert.assertEquals("size", 2, bondArray.size());
	}

	/** test insertBond(). */
	@Test
	public final void testInsertBond() {
		makeMola();
		// test insertBond
		CMLAtom atom3x = new CMLAtom("a3");
		moleculex.addAtom(atom3x);
		CMLBond bond34x = new CMLBond("b23", atom2x, atom3x);
		bondArrayx.insertBond(bond34x, 1);
		Assert.assertEquals("size", 3, bondArrayx.size());
		CMLBond bondx = moleculex.getBonds().get(1);
		Assert.assertEquals("insertBond ", "b23", bondx.getId());
	}

	/**
	 * Test method for
	 * {@link org.xmlcml.cml.element.CMLBondArray#indexBonds()}.
	 */
	@Test
	public final void testIndexBonds() {
		makeMola();
		// not easy to test this as it is kept uptodate
		// just make sure there is no error
		bondArrayx.indexBonds();
	}

	/**
	 * Test method for
	 * {@link org.xmlcml.cml.element.CMLBondArray#removeChild(CMLBond)}.
	 */
	@Test
	public final void testRemoveChild() {
		makeMola();
		Assert.assertEquals("size", 2, bondArrayx.size());
		bondArrayx.removeChild(bond01x);
		Assert.assertEquals("size", 1, bondArrayx.size());
		CMLBond bondx = moleculex.getBonds().get(0);
		Assert.assertEquals("removeChild ", "b12", bondx.getId());
	}

	/**
	 * Test method for
	 * {@link org.xmlcml.cml.element.CMLBondArray#removeBond(CMLBond)}.
	 */
	@Test
	public final void testRemoveBond() {
		makeMola();
		bondArrayx.removeBond(bondArrayx.getBonds().get(0));
		Assert.assertEquals("size", 1, bondArrayx.size());

	}

	/**
	 * Test method for
	 * {@link org.xmlcml.cml.element.CMLBondArray#getBondMap()}.
	 */
	@Test
	public final void testGetBondMap() {
		makeMola();
		Map<String, CMLBond> bondMap = bondArrayx.getBondMap();
		Assert.assertEquals("map size", 2, bondMap.size());
		Assert.assertNull("id 99", bondMap.get("foo"));
		Assert.assertEquals("id 12", "b12", bondMap.get(CMLBond.atomHash(bond12x))
				.getId());
	}

	/**
	 * Test method for
	 * {@link org.xmlcml.cml.element.CMLBondArray#getBondIdMap()}.
	 */
	@Test
	public final void testGetBondIdMap() {
		makeMola();
		Map<String, CMLBond> bondIdMap = bondArrayx.getBondIdMap();
		Assert.assertEquals("map size", 2, bondIdMap.size());
		Assert.assertNull("id 99", bondIdMap.get("foo"));
		Assert.assertEquals("id 12", "b12", bondIdMap.get("b12").getId());
	}

	/**
	 * Test method for
	 * {@link org.xmlcml.cml.element.CMLBondArray#getBonds()}.
	 */
	@Test
	public final void testGetBonds() {
		makeMola();
		List<CMLBond> bondList = bondArrayx.getBonds();
		Assert.assertEquals("map size", 2, bondList.size());
		Assert.assertEquals("id 01", "b01", bondList.get(0).getId());
		Assert.assertEquals("id 12", "b12", bondList.get(1).getId());
	}

	/**
	 * Test method for
	 * {@link org.xmlcml.cml.element.CMLBondArray#getBondByHash(java.lang.String)}
	 * .
	 */
	@Test
	public final void testGetBondByHash() {
		makeMola();
		CMLBond bondx = bondArrayx.getBondByHash(CMLBond.atomHash("a1", "a2"));
		Assert.assertEquals("id 12", "b12", bondx.getId());
		bondx = bondArrayx.getBondByHash(CMLBond.atomHash("a2", "a1"));
		Assert.assertEquals("id 12", "b12", bondx.getId());
		bondx = bondArrayx.getBondByHash(CMLBond.atomHash("a2", "a0"));
		Assert.assertNull("id 02", bondx);
	}

	/**
	 * Test method for
	 * {@link org.xmlcml.cml.element.CMLBondArray#getBondByAtomRefs2(java.lang.String[])}
	 * .
	 */
	@Test
	public final void testGetBondByAtomRefs2() {
		makeMola();
		CMLBond bondx = bondArrayx
				.getBondByAtomRefs2(new String[] { "a1", "a2" });
		Assert.assertEquals("id 12", "b12", bondx.getId());
		bondx = bondArrayx.getBondByAtomRefs2(new String[] { "a2", "a1" });
		Assert.assertEquals("id 12", "b12", bondx.getId());
		bondx = bondArrayx.getBondByAtomRefs2(new String[] { "a2", "a0" });
		Assert.assertNull("id 02", bondx);
	}

	/**
	 * Test method for
	 * {@link org.xmlcml.cml.element.CMLBondArray#getBondById(java.lang.String)}
	 * .
	 */
	@Test
	public final void testGetBondById() {
		makeMola();
		CMLBond bondx = bondArrayx.getBondById("b12");
		Assert.assertEquals("id 12", "b12", bondx.getId());
		bondx = bondArrayx.getBondById("b99");
		Assert.assertNull("id 02", bondx);
	}

}
