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
import org.xmlcml.cml.element.CMLAtomArray;
import org.xmlcml.cml.element.CMLMolecule;
import org.xmlcml.cml.element.main.MoleculeAtomBondFixture;

/**
 * @author pm286
 * 
 */
public class CMLAtomArrayTest {

	MoleculeAtomBondFixture fixture = new MoleculeAtomBondFixture();

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		fixture.setUp();
	}

	/**
	 * Test method for {@link org.xmlcml.cml.element.CMLAtomArray#detach()}
	 * .
	 */
	@Test
	public final void testDetach() {
		CMLAtomArray atomArray = fixture.xomMolecule.getAtomArray();
		Assert.assertNotNull("get atomarray", atomArray);
		List<CMLAtom> atomList = fixture.xomMolecule.getAtoms();
		Assert.assertEquals("atom count before detach", 5, atomList.size());
		Assert.assertEquals("atom count before detach", 5, atomArray.getAtomElements()
				.size());
		CMLAtom a1 = fixture.xomMolecule.getAtomById("a1");
		Assert.assertNotNull("get atom", a1);
		Assert.assertEquals("get atom", "a1", a1.getId());

		atomArray.detach();
		Assert.assertEquals("atom count after detach", 5, atomArray.getAtomElements()
				.size());
		atomList = fixture.xomMolecule.getAtoms();
		Assert.assertEquals("atom count after detach", 0, atomList.size());
		// FIXME System.err.println("NOT YET WORKING - PMR");
		a1 = fixture.xomMolecule.getAtomById("a1");
		Assert.assertNull("get atom", a1);
	}

	/**
	 * Test method for
	 * {@link org.xmlcml.cml.element.CMLAtomArray#CMLAtomArray()}.
	 */
	@Test
	public final void testCMLAtomArray() {
		CMLAtomArray atomArray = new CMLAtomArray();
		CMLAtom atom = new CMLAtom("a1");
		// this seems to be allowed
		atomArray.addAtom(atom);
		Assert.assertEquals("atom count ", 1, atomArray.getAtomElements().size());
		CMLMolecule mol = new CMLMolecule();
		List<CMLAtom> atomList = mol.getAtoms();
		Assert.assertEquals("atom count before add", 0, atomList.size());
		// not sure whether this should be allowed but it works
		mol.appendChild(atomArray);
		atomList = mol.getAtoms();
		Assert.assertEquals("atom count after add", 1, atomList.size());

		CMLMolecule molx = new CMLMolecule();
		molx.addAtomArray(new CMLAtomArray());
		atomArray = molx.getAtomArray();
		atomArray.setAtomID(new String[] { "a1", "a2", "a3" });
		Assert.assertEquals("atom count ", 3, atomArray.getAtomElements().size());
		atomArray.setX2(new double[] { 10, 20, 30 });
		Assert.assertEquals("atom 1 x2", 20.0, atomArray.getAtomElements().get(1)
				.getX2(), 0.00001);
		atomArray.setY2(new double[] { 40, 50, 60 });
		Assert.assertEquals("atom 2 y2", 60.0, atomArray.getAtomElements().get(2)
				.getY2(), 0.00001);
		atomArray.setX3(new double[] { 1.1, 1.2, 1.3 });
		Assert.assertEquals("atom 0 x3", 1.1, atomArray.getAtomElements().get(0)
				.getX3(), 0.00001);
		atomArray.setY3(new double[] { 1.4, 1.5, 1.6 });
		Assert.assertEquals("atom 1 y3", 1.5, atomArray.getAtomElements().get(1)
				.getY3(), 0.00001);
		atomArray.setZ3(new double[] { 1.7, 1.8, 1.9 });
		Assert.assertEquals("atom 1 z3", 1.9, atomArray.getAtomElements().get(2)
				.getZ3(), 0.00001);
		atomArray.setXFract(new double[] { 0.1, 0.2, 0.3 });
		Assert.assertEquals("atom 1 xFract", 0.1, atomArray.getAtomElements().get(0)
				.getXFract(), 0.00001);
		atomArray.setYFract(new double[] { 0.4, 0.5, 0.6 });
		Assert.assertEquals("atom 1 yFract", 0.5, atomArray.getAtomElements().get(1)
				.getYFract(), 0.00001);
		atomArray.setZFract(new double[] { 0.7, 0.8, 0.9 });
		Assert.assertEquals("atom 1 zFract", 0.9, atomArray.getAtomElements().get(2)
				.getZFract(), 0.00001);
		atomArray.setHydrogenCount(new String[] { "1", "2", "3" });
		Assert.assertEquals("atom 1 hcount", 2, atomArray.getAtomElements().get(1)
				.getHydrogenCount());
		atomArray.setOccupancy(new String[] { "0.11", "0.22", "0.33" });
		Assert.assertEquals("atom 1 occ", .22, atomArray.getAtomElements().get(1)
				.getOccupancy(), 0.0001);
		try {
			atomArray.setOccupancy(new String[] { "0.11", "0.22" });
		} catch (RuntimeException e) {
			Assert.assertEquals("reported error ",
					"inconsistent atom count (3) and occupancy (2)", e
							.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link org.xmlcml.cml.element.CMLAtomArray#appendChild(org.xmlcml.cml.element.CMLAtom)}
	 * .
	 */
	@Test
	public final void testAppendChildCMLAtom() {
		CMLAtomArray atomArray = new CMLAtomArray();
		CMLAtom atom = new CMLAtom("a1");
		// this seems to be allowed
		atomArray.appendChild(atom);
		Assert.assertEquals("atom count ", 1, atomArray.getAtomElements().size());
	}

	/**
	 * Test method for {@link org.xmlcml.cml.element.CMLAtomArray#size()}.
	 */
	@Test
	public final void testSize() {
		CMLAtomArray atomArray = new CMLAtomArray();
		Assert.assertEquals("atom count ", 0, atomArray.size());
		CMLAtom atom = new CMLAtom("a1");
		// this seems to be allowed
		atomArray.appendChild(atom);
		Assert.assertEquals("atom count ", 1, atomArray.size());
		atomArray.removeChild(atom);
		Assert.assertEquals("atom count ", 0, atomArray.size());
	}

	/**
	 * Test method for
	 * {@link org.xmlcml.cml.element.CMLAtomArray#addAtom(org.xmlcml.cml.element.CMLAtom)}
	 * .
	 */
	@Test
	public final void testAddAtomCMLAtom() {
		CMLAtomArray atomArray = new CMLAtomArray();
		Assert.assertEquals("atom count ", 0, atomArray.size());
		CMLAtom atom = new CMLAtom("a1");
		// this seems to be allowed
		atomArray.addAtom(atom);
	}

	/**
	 * Test method for
	 * {@link org.xmlcml.cml.element.CMLAtomArray#insertAtom(org.xmlcml.cml.element.CMLAtom, int)}
	 * .
	 */
	@Test
	public final void testInsertAtom() {
		CMLAtomArray atomArray = new CMLAtomArray();
		Assert.assertEquals("atom count ", 0, atomArray.size());
		CMLAtom atom = new CMLAtom("a1");
		atomArray.addAtom(atom);
		atom = new CMLAtom("a2");
		atomArray.addAtom(atom);
		atom = new CMLAtom("a3");
		atomArray.addAtom(atom);
		Assert.assertEquals("atom 2", "a2", atomArray.getAtomElements().get(1).getId());
		atom = new CMLAtom("a2a");
		atomArray.insertAtom(atom, 1);
		Assert.assertEquals("atom 2", "a2a", atomArray.getAtomElements().get(1)
				.getId());
		Assert.assertEquals("atom 2", "a2", atomArray.getAtomElements().get(2).getId());
		atom = new CMLAtom("a1a");
		atomArray.insertAtom(atom, 0);
		Assert.assertEquals("atom 2", "a1a", atomArray.getAtomElements().get(0)
				.getId());
		Assert.assertEquals("atom 2", "a1", atomArray.getAtomElements().get(1).getId());
		Assert.assertEquals("atom count ", 5, atomArray.size());
	}

	/**
	 * Test method for
	 * {@link org.xmlcml.cml.element.CMLAtomArray#removeChild(org.xmlcml.cml.element.CMLAtom)}
	 * .
	 */
	@Test
	public final void testRemoveChildCMLAtom() {
		CMLAtomArray atomArray = new CMLAtomArray();
		Assert.assertEquals("atom count ", 0, atomArray.size());
		CMLAtom atom = new CMLAtom("a1");
		atomArray.addAtom(atom);
		atom = new CMLAtom("a2");
		atomArray.addAtom(atom);
		CMLAtom atom2 = atom;
		atom = new CMLAtom("a3");
		atomArray.addAtom(atom);
		Assert.assertEquals("atom 2", "a2", atomArray.getAtomElements().get(1).getId());
		Assert.assertEquals("atom count ", 3, atomArray.size());
		CMLAtom atomR = atomArray.removeChild(atom2);
		Assert.assertEquals("removed atom", atom2, atomR);
		Assert.assertEquals("atom count ", 2, atomArray.size());
		Assert.assertEquals("atom 2", "a3", atomArray.getAtomElements().get(1).getId());
	}

	/**
	 * Test method for
	 * {@link org.xmlcml.cml.element.CMLAtomArray#removeAtom(org.xmlcml.cml.element.CMLAtom)}
	 * .
	 */
	@Test
	public final void testRemoveAtom() {
		CMLAtomArray atomArray = new CMLAtomArray();
		Assert.assertEquals("atom count ", 0, atomArray.size());
		CMLAtom atom = new CMLAtom("a1");
		atomArray.addAtom(atom);
		atom = new CMLAtom("a2");
		atomArray.addAtom(atom);
		CMLAtom atom2 = atom;
		atom = new CMLAtom("a3");
		atomArray.addAtom(atom);
		Assert.assertEquals("atom 2", "a2", atomArray.getAtomElements().get(1).getId());
		Assert.assertEquals("atom count ", 3, atomArray.size());
		CMLAtom atomR = atomArray.removeAtom(atom2);
		Assert.assertEquals("removed atom", atom2, atomR);
		Assert.assertEquals("atom count ", 2, atomArray.size());
		Assert.assertEquals("atom 2", "a3", atomArray.getAtomElements().get(1).getId());
	}

	/**
	 * Test method for
	 * {@link org.xmlcml.cml.element.CMLAtomArray#getMolecule()}.
	 */
	@Test
	public final void testGetMolecule() {
		CMLAtomArray atomArray = new CMLAtomArray();
		Assert.assertEquals("atom count ", 0, atomArray.size());
		CMLAtom atom = new CMLAtom("a1");
		atomArray.addAtom(atom);
		Assert.assertNull("no molecule", atom.getMolecule());
		CMLMolecule mol = CMLMolecule.createMoleculeWithId("m1");
		mol.addAtomArray(atomArray);
		CMLMolecule mol1 = atom.getMolecule();
		Assert.assertNotNull("molecule", mol1);
		Assert.assertEquals("mol id", "m1", mol1.getId());
	}

	/**
	 * Test method for
	 * {@link org.xmlcml.cml.element.CMLAtomArray#getAtomMap()}.
	 */
	@Test
	public final void testGetAtomMap() {
		CMLAtomArray atomArray = new CMLAtomArray();
		Assert.assertEquals("atom count ", 0, atomArray.size());
		CMLAtom atom1 = new CMLAtom("a1");
		atomArray.addAtom(atom1);
		CMLAtom atom2 = new CMLAtom("a2");
		atomArray.addAtom(atom2);
		CMLAtom atom3 = new CMLAtom("a3");
		atomArray.addAtom(atom3);
		Map<String, CMLAtom> map = atomArray.getAtomMap();
		CMLAtom atomx = map.get("a1");
		Assert.assertNotNull("atom 1", atomx);
		Assert.assertEquals("atom 1", "a1", atomx.getId());
		atomx = map.get("a4");
		Assert.assertNull("atom 4", atomx);
		CMLAtom atom4 = new CMLAtom("a4");
		atomArray.addAtom(atom4);
		atomx = map.get("a4");
		Assert.assertNotNull("atom 4", atomx);
		Assert.assertEquals("atom 4", "a4", atomx.getId());
	}

	/**
	 * Test method for
	 * {@link org.xmlcml.cml.element.CMLAtomArray#getAtoms()}.
	 */
	@Test
	public final void testGetAtoms() {
		CMLAtomArray atomArray = new CMLAtomArray();
		Assert.assertEquals("atom count ", 0, atomArray.size());
		CMLAtom atom1 = new CMLAtom("a1");
		atomArray.addAtom(atom1);
		CMLAtom atom2 = new CMLAtom("a2");
		atomArray.addAtom(atom2);
		CMLAtom atom3 = new CMLAtom("a3");
		atomArray.addAtom(atom3);
		List<CMLAtom> atomList = atomArray.getAtoms();
		Assert.assertEquals("atoms", 3, atomList.size());
		Assert.assertEquals("atom 3", "a3", atomList.get(2).getId());
	}

	/**
	 * Test method for
	 * {@link org.xmlcml.cml.element.CMLAtomArray#getAtomById(java.lang.String)}
	 * .
	 */
	@Test
	public final void testGetAtomById() {
		CMLAtomArray atomArray = new CMLAtomArray();
		Assert.assertEquals("atom count ", 0, atomArray.size());
		CMLAtom atom1 = new CMLAtom("a1");
		atomArray.addAtom(atom1);
		CMLAtom atom2 = new CMLAtom("a2");
		atomArray.addAtom(atom2);
		CMLAtom atom3 = new CMLAtom("a3");
		atomArray.addAtom(atom3);
		CMLAtom atomx = atomArray.getAtomById("a2");
		Assert.assertEquals("atom 2", "a2", atomx.getId());
		atomx = atomArray.getAtomById("a4");
		Assert.assertNull("atom 4", atomx);
		CMLAtom atom4 = new CMLAtom("a4");
		atomArray.addAtom(atom4);
		atomx = atomArray.getAtomById("a4");
		Assert.assertNotNull("atom 4", atomx);
		Assert.assertEquals("atom 4", "a4", atomx.getId());
	}

}
