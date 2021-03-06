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

package org.xmlcml.cml.element.lite;


import java.util.List;

import nu.xom.Node;

import org.junit.Assert;
import org.junit.Test;
import org.xmlcml.cml.attribute.IdAttribute;
import org.xmlcml.cml.base.CMLAttribute;
import org.xmlcml.cml.base.CMLConstants;
import org.xmlcml.cml.base.CMLXOMTestUtils;
import org.xmlcml.cml.base.StringSTAttribute;
import org.xmlcml.cml.base.CMLElement.CoordinateType;
import org.xmlcml.cml.element.CMLAtom;
import org.xmlcml.cml.element.CMLBond;
import org.xmlcml.cml.element.CMLBondStereo;
import org.xmlcml.cml.element.CMLMolecule;
import org.xmlcml.cml.element.main.MoleculeAtomBondFixture;
import org.xmlcml.euclid.Point3;
import org.xmlcml.molutil.ChemicalElement.AS;

/**
 * test CMLBond.
 * 
 * @author pmr
 * 
 */
public class CMLBondTest {
	MoleculeAtomBondFixture fixture = new MoleculeAtomBondFixture();

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLBond.copy()'
	 */
	@Test
	public void testCopy() {
		Node copy = ((CMLBond) fixture.xmlBonds.get(0)).copy();
		Assert.assertEquals("class should be CMLBond: ", copy.getClass(),
				CMLBond.class);
		CMLBond copyBond = (CMLBond) copy;
		Assert.assertEquals("bond is identical", copyBond
				.compareTo(((CMLBond) fixture.xmlBonds.get(0))), 0);

	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLBond.getOrder()'
	 */
	@Test
	public void testGetOrder() {
		String order = ((CMLBond) fixture.xmlBonds.get(0)).getOrder();
		Assert.assertEquals("bond order", CMLBond.SINGLE_S, order);
		// note change of "S"
		// this fails until we have sorted the filling of bonds
		try {
			order = ((CMLBond) fixture.xmlBonds.get(1)).getOrder();
			Assert.assertEquals("bond order", CMLBond.SINGLE_S, order);
		} catch (Exception e) {
			Assert.fail("should not throw exception " + e);
		}

	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLBond.CMLBond()'
	 */
	@Test
	public void testCMLBond() {
		CMLBond bond = new CMLBond();
		Assert.assertNotNull("constructor ", bond);
		Assert.assertNull("no atomRefs2 attribute", bond
				.getAtomRefs2Attribute());
		Assert.assertEquals("no children", bond.getChildCount(), 0);

	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLBond.CMLBond(CMLBond)'
	 */
	@Test
	public void testCMLBondCMLBond() {
		// copy constructor
		CMLBond xbond = fixture.xomBond[0];
		CMLBond bond = new CMLBond(xbond);
		Assert.assertNotNull("constructor ", bond);

		CMLAttribute orderAtt = bond.getOrderAttribute();
		Assert.assertTrue("order class is subclass of CMLAttribute",
				CMLAttribute.class.isAssignableFrom(orderAtt.getClass()));
		Assert.assertEquals("order class is StringSTAttribute", orderAtt
				.getClass(), StringSTAttribute.class);
		Assert.assertEquals("order value", bond.getOrder(), xbond.getOrder());
		Assert.assertEquals("bond is identical", 0, bond.compareTo(xbond));
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLBond.getMolecule()'
	 */
	@Test
	public void testGetMolecule() {
		// xml
		CMLMolecule molecule = ((CMLBond) fixture.xmlBonds.get(0))
				.getMolecule();
		Assert.assertNotNull("molecule should not be null", molecule);
		Assert.assertEquals("get molecule", fixture.xmlMolecule, molecule);
		// dom
		molecule = fixture.xomBond[0].getMolecule();
		Assert.assertNotNull("molecule should not be null", molecule);
		Assert.assertEquals("get molecule", fixture.xomMolecule, molecule);

	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLBond.getAtoms()'
	 */
	@Test
	public void testGetAtoms() {
		List<CMLAtom> atoms = fixture.xmlBonds.get(0).getAtoms();
		Assert.assertEquals("atoms ", 2, atoms.size());
		Assert.assertEquals("atom 1 id ", "a1", atoms.get(0).getId());
		Assert.assertEquals("atom 2 id ", "a2", atoms.get(1).getId());

	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLBond.appendToId(String,
	 * boolean)'
	 */
	@Test
	public void testAppendToId() {
		List<CMLBond> xmlBonds = fixture.xmlBonds;
		xmlBonds.get(0).resetId("B");
		xmlBonds.get(0).appendToId("foo", true);
		Assert.assertEquals("new id ", "Bfoo", xmlBonds.get(0).getId());
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLBond.atomHash(String, String)'
	 */
	@Test
	public void testAtomHashStringString() {
		String hash = CMLBond.atomHash("a1", "a2");
		Assert.assertEquals("bond hash", "a2" + CMLBond.HASH_SYMB + "a1", hash);
		hash = CMLBond.atomHash("a2", "a1");
		Assert.assertEquals("bond hash", "a2" + CMLBond.HASH_SYMB + "a1", hash);

	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLBond.atomHash(CMLAtom,
	 * CMLAtom)'
	 */
	@Test
	public void testAtomHashCMLAtomCMLAtom() {
		CMLAtom[] xmlAtom = fixture.xmlAtom;
		String hash = CMLBond.atomHash(xmlAtom[0], xmlAtom[1]);
		Assert.assertEquals("bond hash", "a2" + CMLBond.HASH_SYMB + "a1", hash);
		hash = CMLBond.atomHash(xmlAtom[1], xmlAtom[0]);
		Assert.assertEquals("bond hash", "a2" + CMLBond.HASH_SYMB + "a1", hash);
		fixture.makeMol5a();
		CMLAtom atom1 = fixture.mol5a.getAtomById("a1");
		Assert.assertNotNull("atom1 should not be null", atom1);
		CMLAtom atom3 = fixture.mol5a.getAtomById("a3");
		Assert.assertNotNull("atom3 should not be null", atom3);
		hash = CMLBond.atomHash(atom1, atom3);
		Assert.assertEquals("bond hash", "a3" + CMLBond.HASH_SYMB + "a1", hash);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLBond.atomHash(CMLBond)'
	 */
	@Test
	public void testAtomHashCMLBond() {
		String hash = CMLBond.atomHash(((CMLBond) fixture.xmlBonds.get(0)));
		Assert.assertEquals("bond hash", "a2" + CMLBond.HASH_SYMB + "a1", hash);
		fixture.makeMol5a();
		CMLMolecule mol5a = fixture.mol5a;
		CMLAtom atom1 = mol5a.getAtomById("a1");
		Assert.assertNotNull("atom1 should not be null", atom1);
		CMLAtom atom4 = mol5a.getAtomById("a4");
		Assert.assertNotNull("atom4 should not be null", atom4);
		hash = CMLBond.atomHash(atom1, atom4);
		Assert.assertEquals("bond hash", "a4" + CMLBond.HASH_SYMB + "a1", hash);
		CMLBond bond = mol5a.getBonds().get(1);
		hash = CMLBond.atomHash(bond);
		Assert.assertEquals("bond hash..", "a4" + CMLBond.HASH_SYMB + "a1",
				hash);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLBond.CMLBond(CMLAtom,
	 * CMLAtom)'
	 */
	@Test
	public void testCMLBondCMLAtomCMLAtom() {
		CMLBond bond = new CMLBond(fixture.xmlAtoms.get(1), fixture.xmlAtoms
				.get(2));
		bond.setId("b12");
		fixture.xmlMolecule.addBond(bond);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLBond.atomHash()'
	 */
	@Test
	public void testAtomHash() {
		CMLBond bond = fixture.xmlMolecule.getBonds().get(0);
		String s = bond.atomHash();
		Assert.assertEquals("hash", "a2" + CMLBond.HASH_SYMB + "a1", s);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLBond.getBondStereo()'
	 */
	@Test
	public void testGetSetBondStereo() {
		CMLBond bond = new CMLBond();
		Assert.assertNull("no bond stereo", bond.getBondStereo());
		CMLBondStereo bondStereo = new CMLBondStereo();
		bond.setBondStereo(bondStereo);
		Assert.assertNotNull("bond stereo", bond.getBondStereo());
		bond.setBondStereo(bondStereo);
		Assert.assertNotNull("bond stereo", bond.getBondStereo());
		Assert.assertEquals("only one child", 1, bond.getBondStereoElements()
				.size());
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLBond.clearBondStereo()'
	 */
	@Test
	public void testClearBondStereo() {
		CMLBond bond = new CMLBond();
		bond.clearBondStereo();
		Assert.assertNull("no bond stereo", bond.getBondStereo());
		CMLBondStereo bondStereo = new CMLBondStereo();
		bond.setBondStereo(bondStereo);
		Assert.assertNotNull("bond stereo", bond.getBondStereo());
		bond.clearBondStereo();
		Assert.assertNull("cleared bond stereo", bond.getBondStereo());
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLBond.areWithinBondingDistance(CMLAtom,
	 * CMLAtom, double, double)'
	 */
	@Test
	public void testAreWithinBondingDistanceCMLAtomCMLAtomDoubleDouble() {

		CMLAtom atom1 = new CMLAtom();
		atom1.setPoint3(new Point3(0.0, 0.0, 0.0), CoordinateType.CARTESIAN);
		atom1.setElementType(AS.C.value);
		CMLAtom atom2 = new CMLAtom();
		atom2.setPoint3(new Point3(0.85, 0.85, 0.85), CoordinateType.CARTESIAN);
		atom2.setElementType(AS.C.value);
		Assert.assertTrue("bonded", CMLBond.areWithinBondingDistance(atom1,
				atom2));
		// FIXME the latest change in bonding tolerance breaks this
		// ChemicalElement.setBondingRadiusTolerance(0.01);
		// Assert.assertFalse("bonded", CMLBond.areWithinBondingDistance(atom1,
		// atom2));
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLBond.areWithinBondingDistance(CMLAtom,
	 * CMLAtom)'
	 */
	@Test
	public void testAreWithinBondingDistanceCMLAtomCMLAtom() {
		CMLAtom atom1 = new CMLAtom();
		atom1.setPoint3(new Point3(0.0, 0.0, 0.0), CoordinateType.CARTESIAN);
		atom1.setElementType("Pt");
		CMLAtom atom2 = new CMLAtom();
		atom2.setPoint3(new Point3(1.3, 1.3, 1.3), CoordinateType.CARTESIAN);
		atom2.setElementType("Pt");
		Assert.assertTrue("bonded", CMLBond.areWithinBondingDistance(atom1,
				atom2));
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLBond.incrementOrder(int)'
	 */
	@Test
	public void testIncrementOrder() {
		CMLBond bond = new CMLBond();
		Assert.assertNull("order null", bond.getOrder());
		// note this forms a double bond
		bond.incrementOrder(1);
		Assert.assertEquals("order", CMLBond.DOUBLE_D, bond.getOrder());
		bond.incrementOrder(1);
		Assert.assertEquals("order", CMLBond.TRIPLE_T, bond.getOrder());
		try {
			bond.incrementOrder(1);
		} catch (RuntimeException e) {
			Assert.assertEquals("cannot increment bond order 3",
					RuntimeException.class.getName()
							+ ": Cannot increment bond order 3", "" + e);
		}
		Assert.assertEquals("order", CMLBond.UNKNOWN_ORDER, bond.getOrder());
		bond.setOrder(CMLBond.TRIPLE_T);
		Assert.assertEquals("order", CMLBond.TRIPLE_T, bond.getOrder());
		bond.incrementOrder(-1);
		Assert.assertEquals("order", CMLBond.DOUBLE_D, bond.getOrder());
		bond.incrementOrder(-1);
		Assert.assertEquals("order", CMLBond.SINGLE_S, bond.getOrder());
		try {
			bond.incrementOrder(-1);
		} catch (RuntimeException e) {
			Assert.assertEquals("cannot decrement single",
					RuntimeException.class.getName()
							+ ": Cannot decrement bond order "+CMLBond.SINGLE_S, "" + e);
		}
		Assert.assertEquals("order", CMLBond.SINGLE_S, bond.getOrder());
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLBond.getBondLength()'
	 */
	@Test
	public void testGetBondLength() {
		Assert.assertEquals("calculated length", Math.sqrt(3.),
				((CMLBond) fixture.xmlBonds.get(0))
						.getBondLength(CoordinateType.CARTESIAN), 0.00001);
	}

	private CMLBond getBond5a(int i) {
		fixture.makeMol5a();
		return fixture.mol5a.getBonds().get(i);
	}

	/**
	 * Test method for {@link org.xmlcml.cml.element.CMLBond#detach()}.
	 */
	@Test
	public final void testDetach() {
		CMLBond bond = getBond5a(0);
		bond.detach();
		Assert.assertEquals("count", 3, fixture.mol5a.getBondCount());
		Assert.assertEquals("count", 5, fixture.mol5a.getAtomCount());
	}

	/**
	 * Test method for
	 * {@link org.xmlcml.cml.element.CMLBond#setId(java.lang.String)}.
	 */
	@Test
	public final void testSetId() {
		CMLBond bond = getBond5a(0);
		try {
			bond.setId("FOO");
		} catch (RuntimeException e) {
			Assert.assertEquals("should throw", "Cannot reindex id", e
					.getMessage());
		}
		bond.removeAttribute(IdAttribute.NAME);
		try {
			bond.setId("FOO");
		} catch (RuntimeException e) {
			Assert.fail("bug");
		}
		Assert.assertEquals("getid", "FOO", bond.getId());
	}

	/**
	 * Test method for
	 * {@link org.xmlcml.cml.element.CMLBond#CMLBond(java.lang.String, org.xmlcml.cml.element.CMLAtom, org.xmlcml.cml.element.CMLAtom)}
	 * .
	 */
	@Test
	public final void testCMLBondStringCMLAtomCMLAtom() {
		fixture.makeMol5a();
		CMLMolecule mol5a = fixture.mol5a;
		CMLAtom a2 = mol5a.getAtom(1);
		CMLAtom a5 = mol5a.getAtom(4);
		CMLBond bond = new CMLBond("FOO", a2, a5);
		mol5a.addBond(bond);
		Assert.assertEquals("count", 5, mol5a.getBondCount());
		bond = mol5a.getBonds().get(4);
		Assert.assertEquals("getid", "FOO", bond.getId());
	}

	/**
	 * Test method for
	 * {@link org.xmlcml.cml.element.CMLBond#getAtomId(int)}.
	 */
	@Test
	public final void testGetAtomId() {
		CMLBond bond = getBond5a(0);
		Assert.assertEquals("getid", "a1", bond.getAtomId(0));
		Assert.assertEquals("getid", "a2", bond.getAtomId(1));
	}

	/**
	 * Test method for {@link org.xmlcml.cml.element.CMLBond#getAtom(int)}.
	 */
	@Test
	public final void testGetAtom() {
		CMLBond bond = getBond5a(0);
		Assert.assertEquals("getid", "a1", bond.getAtom(0).getId());
		Assert.assertEquals("getid", "a2", bond.getAtom(1).getId());
	}

	/**
	 * Test method for
	 * {@link org.xmlcml.cml.element.CMLBond#getOtherAtomId(java.lang.String)}
	 * .
	 */
	@Test
	public final void testGetOtherAtomId() {
		CMLBond bond = getBond5a(0);
		Assert.assertEquals("getid", "a2", bond.getOtherAtomId("a1"));
		Assert.assertEquals("getid", "a1", bond.getOtherAtomId("a2"));
	}

	/**
	 * Test method for
	 * {@link org.xmlcml.cml.element.CMLBond#getOtherAtom(org.xmlcml.cml.element.CMLAtom)}
	 * .
	 */
	@Test
	public final void testGetOtherAtom() {
		CMLBond bond = getBond5a(0);
		CMLAtom atom = fixture.mol5a.getAtom(0);
		Assert.assertEquals("getid", "a2", bond.getOtherAtom(atom).getId());
	}

	/**
	 * Test method for
	 * {@link org.xmlcml.cml.element.CMLBond#atomHash(java.lang.String[])}.
	 */
	@Test
	public final void testAtomHashStringArray() {
		Assert.assertEquals("gethash", "Y" + CMLBond.HASH_SYMB + "X", CMLBond
				.atomHash(new String[] { "X", "Y" }));
		Assert.assertEquals("gethash", "Y" + CMLBond.HASH_SYMB + "X", CMLBond
				.atomHash(new String[] { "Y", "X" }));
	}

	/**
	 * Test method for
	 * {@link org.xmlcml.cml.element.CMLBond#setCyclic(java.lang.String)}.
	 */
	@Test
	public final void testSetCyclic() {
		CMLBond bond = getBond5a(0);
		Assert.assertNull("cyclic", bond.getCyclic());
		bond.setCyclic(CMLBond.ACYCLIC);
		Assert.assertEquals("acyclic", CMLBond.ACYCLIC, bond.getCyclic());
		bond.setCyclic(CMLBond.CYCLIC);
		Assert.assertEquals("cyclic", CMLBond.CYCLIC, bond.getCyclic());
	}

	/**
	 * Test method for
	 * {@link org.xmlcml.cml.element.CMLBond#getBondStereo()}.
	 */
	@Test
	public final void testGetBondStereo() {
		CMLBond bond = getBond5a(0);
		CMLBondStereo bs = bond.getBondStereo();
		Assert.assertNull(bs);

		String s = "<molecule id='m1' " + CMLConstants.CML_XMLNS + ">" + "  <atomArray>"
				+ "    <atom id='a1' elementType='F'/>"
				+ "    <atom id='a2' elementType='C' hydrogenCount='1'/>"
				+ "    <atom id='a3' elementType='C' hydrogenCount='1'/>"
				+ "    <atom id='a4' elementType='Cl'/>" + "  </atomArray>"
				+ "  <bondArray>" + "    <bond atomRefs2='a1 a2' order='1'/>"
				+ "    <bond atomRefs2='a2 a3' order='2'>"
				+ "      <bondStereo atomRefs4='a1 a2 a3 a4'>C</bondStereo>"
				+ "    </bond>" + "    <bond atomRefs2='a3 a4' order='1'/>"
				+ "  </bondArray>" + "</molecule>";
		CMLMolecule mol = (CMLMolecule)CMLXOMTestUtils.parseValidString(s);
		CMLBond b2 = mol.getBondByAtomIds("a2", "a3");
		bs = b2.getBondStereo();
		CMLXOMTestUtils.assertEqualsCanonically(
				"bs",
				(CMLBondStereo)CMLXOMTestUtils.parseValidString("<bondStereo atomRefs4='a1 a2 a3 a4' "
						+ CMLConstants.CML_XMLNS + ">C</bondStereo>"), bs, true);
		bs = new CMLBondStereo();
		bs.setAtomRefs4("a1 a2 a3 a4");
		bs.setXMLContent(CMLBond.TRANS);
		try {
			b2.addBondStereo(bs);
		} catch (RuntimeException e) {
			Assert.fail("nothing wrong");
		}
	}

	/**
	 * Test method for
	 * {@link org.xmlcml.cml.element.CMLBond#setBondStereo(org.xmlcml.cml.element.CMLBondStereo)}
	 * .
	 */
	@Test
	public final void testSetBondStereo() {
		String s = "<molecule id='m1' " + CMLConstants.CML_XMLNS + ">" + "  <atomArray>"
				+ "    <atom id='a1' elementType='F'/>"
				+ "    <atom id='a2' elementType='C' hydrogenCount='1'/>"
				+ "    <atom id='a3' elementType='C' hydrogenCount='1'/>"
				+ "    <atom id='a4' elementType='Cl'/>" + "  </atomArray>"
				+ "  <bondArray>" + "    <bond atomRefs2='a1 a2' order='1'/>"
				+ "    <bond atomRefs2='a2 a3' order='2'>" + "    </bond>"
				+ "    <bond atomRefs2='a3 a4' order='1'/>" + "  </bondArray>"
				+ "</molecule>";
		CMLMolecule mol = (CMLMolecule)CMLXOMTestUtils.parseValidString(s);
		CMLBond b2 = mol.getBondByAtomIds("a2", "a3");
		CMLBondStereo bs = new CMLBondStereo();
		bs.setAtomRefs4("a1 a2 a3 a4");
		bs.setXMLContent(CMLBond.CIS);
		CMLXOMTestUtils.assertEqualsCanonically(
				"bs",
				(CMLBondStereo)CMLXOMTestUtils.parseValidString("<bondStereo atomRefs4='a1 a2 a3 a4' "
						+ CMLConstants.CML_XMLNS + ">C</bondStereo>"), bs, true);
		try {
			b2.setBondStereo(bs);
		} catch (RuntimeException e) {
			Assert.fail("nothing wrong");
		}

		bs = new CMLBondStereo();
		bs.setAtomRefs4("a1 a2 a3 a4");
		bs.setXMLContent(CMLBond.TRANS);
		try {
			b2.setBondStereo(bs);
		} catch (RuntimeException e) {
			Assert.fail("nothing wrong");
		}
	}

	/**
	 * Test method for
	 * {@link org.xmlcml.cml.element.CMLBond#createId(org.xmlcml.cml.element.CMLAtom, org.xmlcml.cml.element.CMLAtom)}
	 * .
	 */
	@Test
	public final void testCreateIdCMLAtomCMLAtom() {
		fixture.makeMol5a();
		CMLAtom a1 = fixture.mol5a.getAtom(0);
		CMLAtom a2 = fixture.mol5a.getAtom(2);
		Assert.assertEquals("bond?", "a1-a3", CMLBond.createId(a1, a2));
	}

	/**
	 * Test method for {@link org.xmlcml.cml.element.CMLBond#createId()}.
	 */
	@Test
	public final void testCreateId() {
		fixture.makeMol5a();
		CMLBond bond = fixture.mol5a.getBonds().get(0);
		Assert.assertEquals("bond?", "a1-a2", bond.createId());
	}

	/**
	 * Test method for {@link org.xmlcml.cml.element.CMLBond#getString()}.
	 */
	@Test
	public final void testGetString() {
		fixture.makeMol5a();
		CMLBond bond = fixture.mol5a.getBonds().get(0);
		Assert.assertEquals("bond?", "a2__a1", bond.getString());
	}

	/**
	 * Test method for
	 * {@link org.xmlcml.cml.element.CMLBond#generateAndSetId()}.
	 */
	@Test
	public final void testGenerateAndSetId() {
		fixture.makeMol5a();
		CMLBond bond = fixture.mol5a.getBonds().get(0);
		bond.removeAttribute(IdAttribute.NAME);
		bond.generateAndSetId();
		Assert.assertEquals("bond?", "a2__a1", bond.getString());
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.tools.MoleculeTool.calculateBondLength(CMLBond,
	 * CoordinateType)'
	 */
	@Test
	public void testCalculateBondLength() {
		fixture.makeMol5a();
		CMLBond bond = fixture.mol5a.getBonds().get(0);
		double d = bond.calculateBondLength(CoordinateType.CARTESIAN);
		Assert.assertEquals("length", 1.3, d, 0.0000001);
	}
}
