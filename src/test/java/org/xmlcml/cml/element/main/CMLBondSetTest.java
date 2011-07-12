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

package org.xmlcml.cml.element.main;

import static org.xmlcml.euclid.EuclidConstants.S_EMPTY;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.xmlcml.cml.element.CMLAtom;
import org.xmlcml.cml.element.CMLAtomSet;
import org.xmlcml.cml.element.CMLBond;
import org.xmlcml.cml.element.CMLBondSet;
import org.xmlcml.cml.element.CMLMolecule;
import org.xmlcml.euclid.EuclidRuntimeException;
import org.xmlcml.euclid.test.StringTestBase;

/**
 * test BondSet.
 * 
 * @author pmr
 * 
 */
public class CMLBondSetTest {
	MoleculeAtomBondFixture fixture = new MoleculeAtomBondFixture();
	CMLBondSet bondSet = null;
	CMLBondSet bondSet1 = null;
	CMLBondSet bondSet2 = null;
	CMLBondSet bondSet3 = null;
	CMLBondSet bondSet4 = null;

	List<CMLBond> bonds = null;

	/**
	 * setup.
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		bondSet = new CMLBondSet(fixture.xmlMolecule);
		bonds = fixture.xmlMolecule.getBonds();
	}

	private void makeBondSet12() {
		List<CMLBond> bonds1 = fixture.xmlMolecule.getBonds();
		List<CMLBond> bonds2 = fixture.xmlMolecule.getBonds();
		bonds1.remove(1);
		bonds2.remove(2);
		bondSet1 = new CMLBondSet(bonds1);
		bondSet2 = new CMLBondSet(bonds2);
	}

	private void makeBondSet34() {
		List<CMLBond> bonds3 = fixture.xmlMolecule.getBonds();
		List<CMLBond> bonds4 = fixture.xmlMolecule.getBonds();
		bonds3.remove(0);
		bonds3.remove(1);
		bonds4.remove(3);
		bonds4.remove(2);
		bondSet3 = new CMLBondSet(bonds3);
		bondSet4 = new CMLBondSet(bonds4);
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLBondSet.CMLBondSet(CMLMolecule)'
	 */
	@Test
	public void testCMLBondSetCMLMolecule() {
		Assert.assertEquals("bondSet size ", 4, bondSet.size());
		Assert.assertEquals("bondSet content", "b1 b2 b3 b4", bondSet
				.getStringContent());
		Assert.assertEquals("bondSet content", new String[] { "b1", "b2", "b3",
				"b4" }, bondSet.getXMLContent());
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLBondSet.CMLBondSet(CMLBond[])'
	 */
	@Test
	public void testCMLBondSetCMLBondArray() {
		Assert.assertEquals("bonds size ", 4, bonds.size());
		bonds.remove(2);
		Assert.assertEquals("bonds size ", 3, bonds.size());
		CMLBondSet bondSet = new CMLBondSet((CMLBond[]) bonds
				.toArray(new CMLBond[0]));
		Assert.assertEquals("bond set size ", 3, bondSet.size());
		List<CMLBond> bonds1 = bondSet.getBonds();
		Assert.assertEquals("bonds size ", 3, bonds1.size());
		Assert.assertEquals("bond ids", "b1 b2 b4", bondSet.getStringContent());
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLBondSet.addBonds(CMLBond[])'
	 */
	@Test
	public void testAddBonds() {
		bondSet = new CMLBondSet((CMLBond[]) bonds.toArray(new CMLBond[0]));
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLBondSet.addBond(CMLBond)'
	 */
	@Test
	public void testAddBond() {
		bondSet = new CMLBondSet();
		bondSet.addBond(bonds.get(0));
		Assert.assertEquals("bond set size", 1, bondSet.size());
		Assert.assertEquals("bond set ", "b1", bondSet.getStringContent());
		bondSet.addBond(bonds.get(2));
		Assert.assertEquals("bond set size", 2, bondSet.size());
		Assert.assertEquals("bond set ", "b1 b3", bondSet.getStringContent());
		try {
			String id = bonds.get(0).getId();
			Assert.assertNotNull("id ", id);
			bondSet.addBond(bonds.get(0));
			Assert.fail("should throw duplicate bond exception");
		} catch (RuntimeException e) {
			Assert.assertEquals("duplicate bond ",
					"duplicate bond in bondSet: b1", e.getMessage());
		}
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLBondSet.addBondSet(CMLBondSet)'
	 */
	@Test
	public void testAddBondSet() {
		CMLBondSet bondSet1 = null;
		try {
			bondSet1 = bondSet.getBondsById(new String[] { "b2", "b4" });
		} catch (RuntimeException e) {
			throw new EuclidRuntimeException("should never throw " + e);
		}
		Assert.assertEquals("bondset1", 2, bondSet1.size());
		CMLBondSet bondSet2 = null;
		try {
			bondSet2 = bondSet.getBondsById(new String[] { "b3" });
		} catch (RuntimeException e) {
			throw new EuclidRuntimeException("should never throw " + e);
		}
		Assert.assertEquals("bondset2", 1, bondSet2.size());
		bondSet1.addBondSet(bondSet2);
		Assert.assertEquals("bondset2", 3, bondSet1.size());
		try {
			bondSet1.addBondSet(bondSet2);
			Assert.fail("should throw duplicate bond ");
		} catch (RuntimeException e) {
			Assert.assertEquals("duplicate bond",
					"duplicate bond in bondSet: b3", S_EMPTY + e.getMessage());
		}
		Assert.assertEquals("bondset2", 3, bondSet1.size());
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLBondSet.getBonds()'
	 */
	@Test
	public void testGetBonds() {
		Assert.assertEquals("bonds", 4, bonds.size());
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLBondSet.contains(CMLBond)'
	 */
	@Test
	public void testContains() {
		Assert.assertTrue("contains ", bondSet.contains(bonds.get(0)));
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLBondSet.size()'
	 */
	@Test
	public void testSize() {
		Assert.assertEquals("size ", 4, bondSet.size());
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLBondSet.getBondIDs()'
	 */
	@Test
	public void testGetBondIDs() {
		List<String> bondIds = bondSet.getBondIDs();
		Assert.assertEquals("bond ids ", 4, bondIds.size());
		Assert.assertEquals("bond id", "b2", bondIds.get(1));
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLBondSet.getBondsById(String[])'
	 */
	@Test
	public void testGetBondsById() {
		CMLBondSet bondSet1 = bondSet.getBondsById(new String[] { "b3", "b1" });
		Assert.assertEquals("bonds by id", 2, bondSet1.size());
		Assert
				.assertEquals("bond id", "b3", bondSet1.getBonds().get(0)
						.getId());
		Assert
				.assertEquals("bond id", "b1", bondSet1.getBonds().get(1)
						.getId());
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLBondSet.getBondById(String)'
	 */
	@Test
	public void testGetBondById() {
		CMLBond bond = bondSet.getBondById("b2");
		Assert.assertNotNull("bond by id", bond);
		Assert.assertEquals("bond by id", "b2", bond.getId());
		bond = bondSet.getBondById("b6");
		Assert.assertNull("bond by id", bond);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLBondSet.copy()'
	 */
	@Test
	public void testCopy() {
		CMLBondSet bondSet1 = (CMLBondSet) bondSet.copy();
		StringTestBase.assertEquals("copy", bondSet1.getXMLContent(), bondSet
				.getXMLContent());
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLBondSet.addBonds(CMLBond[])'
	 */
	@Test
	public void testAddBondsCMLBondArray() {
		CMLBond[] bonds = new CMLBond[2];
		bonds[0] = new CMLBond();
		bonds[0].setId("b10");
		String msg = "no atomRefs2 attribute";
		// this contaminates the bonds
		try {
			bondSet.addBonds(bonds);
			Assert.fail("should throw no atomRefs2 attribute");
		} catch (RuntimeException e) {
			Assert.assertEquals("no atomRefs2", msg, e.getMessage());
		}

		// clear bonds
		try {
			setUp();
		} catch (Exception e1) {
			Assert.fail("should never throw " + e1);
		}
		bonds[0].setAtomRefs2(new String[] { "a2", "a3" });
		bonds[1] = new CMLBond();
		bonds[1].setId("b11");
		bonds[1].setAtomRefs2(new String[] { "a2", "a4" });
		bondSet.addBonds(bonds);
		Assert.assertEquals("new bondSet", new String[] { "b1", "b2", "b3",
				"b4", "b10", "b11" }, bondSet.getXMLContent());
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLBondSet.addBonds(List<CMLBond>)'
	 */
	@Test
	public void testAddBondsListOfCMLBond() {
		List<CMLBond> bonds = new ArrayList<CMLBond>();
		CMLBond bond = new CMLBond();
		bonds.add(bond);
		bond.setId("b10");
		String msg = "no atomRefs2 attribute";

		// this contaminates the bonds
		try {
			bondSet.addBonds(bonds);
			Assert.fail("should throw no atomRefs2 attribute");
		} catch (RuntimeException e) {
			Assert.assertEquals("no atomRefs2", msg, e.getMessage());
		}

		// clear bonds
		try {
			setUp();
		} catch (Exception e1) {
			Assert.fail("should never throw " + e1);
		}
		bond.setAtomRefs2(new String[] { "a2", "a3" });
		bond = new CMLBond();
		bond.setId("b11");
		bond.setAtomRefs2(new String[] { "a2", "a4" });
		bonds.add(bond);
		try {
			bondSet.addBonds(bonds);
		} catch (RuntimeException e) {
			throw new EuclidRuntimeException("should never throw " + e);
		}
		Assert.assertEquals("new bondSet", new String[] { "b1", "b2", "b3",
				"b4", "b10", "b11" }, bondSet.getXMLContent());
	}

	/**
	 * create from bonds.
	 */
	@Test
	public final void testCMLBondSetListOfCMLBond() {
		fixture.makeMol5a();
		List<CMLBond> bondList = fixture.mol5a.getBonds();
		Assert.assertEquals("mol5a bonds", 4, bondList.size());
		CMLBondSet bondSet = null;
		bondSet = new CMLBondSet(bondList);
		Assert.assertEquals("mol5a bondSet", 4, bondSet.size());
		CMLBond bond1 = bondList.get(1);
		CMLBond bond2 = bondList.get(2);
		Assert.assertTrue("mol5a bonds", bondSet.contains(bond1));
		Assert.assertTrue("mol5a bonds", bondSet.contains(bond2));
		bondList.remove(bondList.get(2));
		Assert.assertEquals("mol5a bonds", 3, bondList.size());
		bondSet = new CMLBondSet(bondList);
		Assert.assertEquals("mol5a bondSet", 3, bondSet.size());
		Assert.assertTrue("mol5a bonds", bondSet.contains(bond1));
		Assert.assertFalse("mol5a bonds", bondSet.contains(bond2));
	}

	/**
	 * test constructor.
	 */
	@Test
	public final void testCMLBondSetCMLMoleculeStringArray() {
		CMLBondSet bondSetx = new CMLBondSet(fixture.xomMolecule, new String[] {
				"b1", "b3" });
		Assert.assertEquals("bond set b1 b3", 2, bondSetx.size());
	}

	/**
	 * test.
	 */
	@Test
	public final void testGetBond() {
		CMLBond bond = bondSet.getBond(2);
		Assert.assertNotNull("get bond", bond);
		Assert.assertEquals("get bond", "b3", bond.getId());
		bond = bondSet.getBond(4);
		Assert.assertNull("get bond", bond);

	}

	/**
	 * test.
	 */
	@Test
	public final void testGetAtomSet() {
		CMLAtomSet atomSet = bondSet.getAtomSet();
		Assert.assertNotNull("get atomSet", atomSet);
		Assert.assertEquals("get atomSet", 5, atomSet.size());
		List<CMLAtom> atoms = atomSet.getAtoms();
		Assert.assertEquals(" atomSet 1", "a1", atoms.get(0).getId());
		Assert.assertEquals(" atomSet 1", "a5", atoms.get(4).getId());
	}

	/**
	 * test.
	 */
	@Test
	public final void testHasContentEqualTo() {
		Assert.assertTrue("equality", bondSet.hasContentEqualTo(bondSet));
	}

	/**
	 * test.
	 */
	@Test
	public final void testComplement() {
		makeBondSet12();
		CMLBondSet bondSetx = bondSet1.complement(bondSet2);
		Assert.assertEquals("complement", 1, bondSetx.size());
		Assert.assertEquals("complement", "b3", bondSetx.getBonds().get(0)
				.getId());
		bondSetx = bondSet2.complement(bondSet1);
		Assert.assertEquals("complement", 1, bondSetx.size());
		Assert.assertEquals("complement", "b2", bondSetx.getBonds().get(0)
				.getId());
	}

	/**
	 * test.
	 */
	@Test
	public final void testUnion() {
		makeBondSet12();
		makeBondSet34();
		CMLBondSet bondSetx = bondSet1.union(bondSet2);
		Assert.assertEquals("union", 4, bondSetx.size());
		bondSetx = bondSet3.union(bondSet4);
		Assert.assertEquals("union", 3, bondSetx.size());
		// fragile
		Assert.assertEquals("complement", "b2", bondSetx.getBonds().get(0)
				.getId());
		Assert.assertEquals("complement", "b4", bondSetx.getBonds().get(1)
				.getId());
		Assert.assertEquals("complement", "b1", bondSetx.getBonds().get(2)
				.getId());
	}

	/**
	 * test.
	 */
	@Test
	public final void testSymmetricDifference() {
		makeBondSet12();
		makeBondSet34();
		CMLBondSet bondSetx = null;
		bondSetx = bondSet1.symmetricDifference(bondSet2);
		Assert.assertEquals("symmetricDifference", 2, bondSetx.size());
		Assert.assertEquals("complement", "b3", bondSetx.getBonds().get(0)
				.getId());
		Assert.assertEquals("complement", "b2", bondSetx.getBonds().get(1)
				.getId());
		bondSetx = bondSet3.symmetricDifference(bondSet4);
		Assert.assertEquals("symmetricDifference", 2, bondSetx.size());
		// fragile
		Assert.assertEquals("complement", "b4", bondSetx.getBonds().get(0)
				.getId());
		Assert.assertEquals("complement", "b1", bondSetx.getBonds().get(1)
				.getId());
	}

	/**
	 * test.
	 */
	@Test
	public final void testGetMolecule() {
		CMLMolecule molecule = bondSet.getMolecule();
		Assert.assertNotNull("get molecule", molecule);
		Assert.assertEquals("get molecule", fixture.xmlMolecule, molecule);
	}

	/**
	 * tests equality against list of ids. (order of elements in set is
	 * undefined)
	 * 
	 * @param message
	 * @param expectedBondIds
	 * @param bondSet
	 */
	public static void assertEquals(String message, String[] expectedBondIds,
			CMLBondSet bondSet) {
		Assert.assertEquals(message + "; unequal sizes; expected "
				+ expectedBondIds.length + ", found: " + bondSet.size(),
				expectedBondIds.length, bondSet.size());
		Set<String> expectedSet = new HashSet<String>();
		for (String es : expectedBondIds) {
			expectedSet.add(es);
		}
		Set<String> foundSet = new HashSet<String>();
		List<String> fss = bondSet.getBondIDs();
		for (String fs : fss) {
			foundSet.add(fs);
		}
		Assert.assertTrue("compare atom sets", expectedSet.equals(foundSet));
	}
}
