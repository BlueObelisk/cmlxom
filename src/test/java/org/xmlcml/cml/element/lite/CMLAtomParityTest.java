package org.xmlcml.cml.element.lite;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.xmlcml.cml.base.CMLConstants;
import org.xmlcml.cml.base.CMLXOMTestUtils;
import org.xmlcml.cml.element.CMLAtom;
import org.xmlcml.cml.element.CMLAtomArray;
import org.xmlcml.cml.element.CMLAtomParity;
import org.xmlcml.cml.element.CMLMolecule;

/**
 * tests CMLAtomParity.
 * 
 * @author pm286
 * 
 */
public class CMLAtomParityTest {

	String s = "" + "<molecule " + CMLConstants.CML_XMLNS + ">" + " <atomArray>"
			+ "  <atom id='a1' elementType='C'>"
			+ "   <atomParity id='ap1' atomRefs4='a2 a3 a4 a5'>1</atomParity>"
			+ "  </atom>" + "  <atom id='a2' elementType='F'/>"
			+ "  <atom id='a3' elementType='Cl'/>"
			+ "  <atom id='a4' elementType='Br'/>"
			+ "  <atom id='a5' elementType='I'/>" + " </atomArray>"
			+ "</molecule>" + "";

	CMLAtomParity parity = null;

	CMLMolecule molecule = null;

	CMLAtomArray atomArray = null;

	CMLAtom atom = null;

	CMLAtom[] ligands = null;

	/**
	 * setup.
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		molecule = (CMLMolecule)CMLXOMTestUtils.parseValidString(s);
		List<CMLAtom> atoms = molecule.getAtoms();
		atom = atoms.get(0);
		parity = atom.getAtomParityElements().get(0);
		ligands = new CMLAtom[4];
		for (int i = 0; i < 4; i++) {
			ligands[i] = atoms.get(i + 1);
		}
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLAtomParity.copy()'
	 */
	@Test
	public void testCopy() {
		CMLAtomParity parity1 = (CMLAtomParity) parity.copy();
		Assert.assertEquals("copy", new String[] { "a2", "a3", "a4", "a5" },
				parity1.getAtomRefs4());
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLAtomParity.setAtomRefs4(CMLAtom[])'
	 */
	@Test
	public void testSetAtomRefs4CMLAtomArray() {
		parity.removeAttribute("atomRefs4");
		Assert.assertNull("no parity atoms", parity.getAtomRefs4Attribute());
		parity.setAtomRefs4(ligands);
		Assert.assertEquals("parity atoms", new String[] { "a2", "a3", "a4",
				"a5" }, parity.getAtomRefs4());
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLAtomParity.rearrangeAtomRefs4(String[])'
	 */
	@Test
	public void testRearrangeAtomRefs4() {
		Assert.assertTrue("parity positive", parity.getXMLContent() > 0.1);
		parity.rearrangeAtomRefs4(new String[] { "a3", "a2", "a4", "a5" });
		Assert.assertTrue("parity negative", parity.getXMLContent() < 0.1);
		parity.rearrangeAtomRefs4(new String[] { "a3", "a4", "a5", "a2" });
		Assert.assertTrue("parity negative", parity.getXMLContent() < 0.1);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLAtomParity.getIntegerValue()'
	 */
	@Test
	public void testGetIntegerValue() {
		Assert.assertEquals("parity positive", 1, parity.getIntegerValue());
		parity.rearrangeAtomRefs4(new String[] { "a3", "a2", "a4", "a5" });
		Assert.assertEquals("parity negative", -1, parity.getIntegerValue());
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLAtomParity.getAtomRefs4(CMLMolecule)'
	 */
	@Test
	public void testGetAtomRefs4CMLMolecule() {
		CMLAtom[] atoms = parity.getAtomRefs4(molecule);
		Assert.assertEquals("get atoms", 4, atoms.length);
		Assert.assertEquals("get atom", "a2", atoms[0].getId());
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLAtomParity.isZero()'
	 */
	@Test
	public void testIsZero() {
		Assert.assertFalse("non-zero parity", parity.isZero());
		parity.setXMLContent(0.0);
		Assert.assertTrue("zero parity", parity.isZero());
	}

}
