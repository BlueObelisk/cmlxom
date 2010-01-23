package org.xmlcml.cml.element.main;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;

import nu.xom.Document;
import nu.xom.ParsingException;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.xmlcml.cml.base.CMLBuilder;
import org.xmlcml.cml.base.CMLConstants;
import org.xmlcml.cml.base.CMLUtil;
import org.xmlcml.cml.base.CMLXOMTestUtils;
import org.xmlcml.cml.element.CMLAtom;
import org.xmlcml.cml.element.CMLBond;
import org.xmlcml.cml.element.CMLBondArray;
import org.xmlcml.cml.element.CMLCml;
import org.xmlcml.cml.element.CMLCrystal;
import org.xmlcml.cml.element.CMLMolecule;
import org.xmlcml.molutil.ChemicalElement.AS;

/**
 * provides communal resources for testing. e.g. files and moelcules subclassed
 * by atom- molecule and bond-aware
 * 
 */
public final class MoleculeAtomBondFixture {

	public MoleculeAtomBondFixture() {
		try {
			setUp();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	final static Logger logger = Logger.getLogger(MoleculeAtomBondFixture.class
			.getName());

	Document xmlDocument = null;

	// build xom
	public final int NATOM = 5;
	protected final int NBOND = 5;
	protected String[] elementTypes = { AS.C.value, AS.N.value, AS.O.value,
			AS.S.value, AS.B.value };
	protected int[] hCounts = { 2, 1, 0, 0, 1 };
	public CMLMolecule xomMolecule;
	public CMLAtom[] xomAtom;
	public CMLBond[] xomBond;

	//
	// read into xom; not a stable molecule... (CH3)[N+](S-)(O)(F)
	// 2 1 3 4 5
	protected String xmlMolS = CMLConstants.S_EMPTY + "  <molecule id='m1'  " + CMLConstants.CML_XMLNS
			+ ">" + "    <atomArray>" + "      <atom id='a1' "
			+ "        elementType='N'" + "        hydrogenCount='0'"
			+ "        formalCharge='1'" + "        spinMultiplicity='1'"
			+ "        occupancy='1.0'" + "        x2='0.' y2='0.'"
			+ "        x3='0.' y3='0.' z3='0.'"
			+ "        xFract='0.1' yFract='0.2' zFract='0.3'" + "      />"
			+ "      <atom id='a2' " + "        elementType='C'"
			+ "        hydrogenCount='3'" + "        x2='1.' y2='1.'"
			+ "        x3='1.' y3='1.' z3='1.'" + "      />"
			+ "      <atom id='a3' " + "        elementType='S'"
			+ "        hydrogenCount='0'" + "        formalCharge='-1'"
			+ "        x2='1.' y2='-1.'" + "        x3='1.' y3='-1.' z3='-1.'"
			+ "      />" + "      <atom id='a4' " + "        elementType='O'"
			+ "        x2='-1.' y2='-1.'" + "        x3='-1.' y3='-1.' z3='1.'"
			+ "      />" + "      <atom id='a5' " + "        elementType='F'"
			+ "        x2='-1.' y2='1.'" + "        x3='-1.' y3='1.' z3='-1.'"
			+ "      />" + "    </atomArray>" + "    <bondArray>"
			+ "      <bond id='b1' atomRefs2='a1 a2' order='1'/>"
			+ "      <bond id='b2' atomRefs2='a1 a3' order='S'/>"
			+ "      <bond id='b3' atomRefs2='a1 a4' order='1'/>"
			+ "      <bond id='b4' atomRefs2='a1 a5' order='1'/>"
			+ "    </bondArray>" + "  </molecule>" + "  ";

	public CMLMolecule xmlMolecule;
	public List<CMLAtom> xmlAtoms;
	public CMLAtom[] xmlAtom;
	public List<CMLBond> xmlBonds;
	protected int xmlNatoms;
	public int xmlNbonds;

	public CMLMolecule mol1 = null;
	public CMLMolecule mol2 = null;
	protected CMLMolecule mol3 = null;
	protected CMLMolecule mol4 = null;
	public CMLMolecule mol5 = null;
	public CMLMolecule mol5a = null;
	protected CMLMolecule mol6 = null;
	public CMLMolecule mol7 = null;
	public CMLMolecule mol8 = null;

	protected CMLMolecule mol9 = null;
	protected CMLMolecule mol10 = null;
	protected CMLMolecule mol11 = null;

	protected CMLCrystal crystal = null;

	protected CMLCml cmlCryst = null;
	protected CMLMolecule cmlCrystMol = null;
	protected CMLCrystal cmlCrystCryst = null;

	/**
	 * setup.
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		// build reference molecule
		xomMolecule = new CMLMolecule();
		xomMolecule.setId("xom1");
		xomAtom = new CMLAtom[NATOM];
		for (int i = 0; i < NATOM; i++) {
			xomAtom[i] = new CMLAtom();
			xomAtom[i].setId("a" + (i + 1));
			xomMolecule.getOrCreateAtomArray().appendChild(xomAtom[i]);
			xomAtom[i].setElementType(elementTypes[i]);
			xomAtom[i].setX3((double) i);
			xomAtom[i].setY3((double) (i + 1));
			xomAtom[i].setZ3((double) (i + 2));
			xomAtom[i].setX2((double) i * 10);
			xomAtom[i].setY2((double) (i * 10 + 1));
			xomAtom[i].setHydrogenCount(hCounts[i]);
		}
		xomBond = new CMLBond[NBOND];
		for (int j = 0; j < NBOND; j++) {
			// form a cycle...
			// have to set id at this stage. Pehaps we should trap it
			xomBond[j] = new CMLBond(xomAtom[j], xomAtom[(j + 1) % NATOM]);
			xomBond[j].setId("b" + (j + 1));
			CMLBondArray bondArray = xomMolecule.getOrCreateBondArray();
			bondArray.appendChild(xomBond[j]);
			xomBond[j].setOrder((j == 0) ? "2" : "1");
		}

		// read reference moelcule

		try {
			xmlDocument = new CMLBuilder().build(new StringReader(xmlMolS));
		} catch (IOException e) {
			Assert.fail("Should not throw IOException");
		} catch (ParsingException e) {
			e.printStackTrace();
			logger.error("Parse exception " + e);
			Assert.fail("Should not throw ParsingException " + e.getMessage());
		}
		xmlMolecule = (CMLMolecule) xmlDocument.getRootElement();

		xmlAtoms = xmlMolecule.getAtoms();
		xmlAtom = new CMLAtom[xmlAtoms.size()];
		for (int i = 0; i < xmlAtom.length; i++)
			xmlAtom[i] = (CMLAtom) xmlAtoms.get(i);
		xmlBonds = xmlMolecule.getBonds();

		xmlNatoms = 5;
		xmlNbonds = 4;

		Assert.assertEquals("check atoms in setup", xmlNatoms, xmlAtoms.size());
		Assert.assertEquals("check bonds in setup", xmlNbonds, xmlBonds.size());

	}

	/**
	 * test building from XML* Test method for
	 * 'org.xmlcml.cml.element.CMLMolecule.createAndAddAtom(String)'
	 */
	@Test
	public void testParse() {

		// Assert that reference molecule read correctly
		CMLMolecule molecule = (CMLMolecule) xmlDocument.getRootElement();
		Assert.assertNotNull("root should not be null", molecule);
		Assert.assertEquals("molecule id", "m1", molecule.getId());
		CMLAtom atom = (CMLAtom) molecule.getAtom(0);
		Assert.assertNotNull("atom should not be null", atom);
		Assert.assertEquals("atom id", atom.getId(), "a1");
		Assert.assertEquals("atom elementType", atom.getElementType(),
				AS.N.value);
		CMLBond bond = (CMLBond) molecule.getBonds().get(0);
		Assert.assertNotNull("bond should not be null", bond);
		Assert.assertEquals("bond atomrefs", bond.getAtomRefs2()[0], "a1");

		// test for incorrect XML
		// duplicate id
		xmlMolS = "  <molecule id='m1' " + CMLConstants.CML_XMLNS + ">" + "    <atomArray>"
				+ "      <atom id='a1' elementType='Fe'/>"
				+ "      <atom id='a1'/>" + "    </atomArray>"
				+ "    <bondArray>" + "      <bond atomRefs2='a1 a2'/>"
				+ "    </bondArray>" + "  </molecule>" + "  ";
		try {
			xmlDocument = new CMLBuilder().build(new StringReader(xmlMolS));
			Assert.fail("should trap duplicate atom id");
		} catch (IOException e) {
			Assert.fail("Should not throw IOException");
		} catch (ParsingException e) {
			Assert.assertEquals("duplicate id",
					"Index atom: duplicate atom: a1", e.getMessage());
		}

		// missing id - no longer checked here
//		xmlMolS = "  <molecule id='m1' " + CMLConstants.CML_XMLNS + ">" + "    <atomArray>"
//				+ "      <atom/>" + "    </atomArray>" + "    <bondArray>"
//				+ "      <bond atomRefs2='a1 a2'/>" + "    </bondArray>"
//				+ "  </molecule>" + "  ";
//		try {
//			xmlDocument = new CMLBuilder().build(new StringReader(xmlMolS));
//			Assert.fail("should trap missing atom id");
//		} catch (IOException e) {
//			Assert.fail("Should not throw IOException");
//		} catch (ParsingException e) {
//			Assert.assertEquals("unset id", "Atom id must not be null", e
//					.getMessage());
//		}
	}

	public void makeMol1() {
		String s = "  <molecule id='m1' " + CMLConstants.CML_XMLNS + ">" + "    <atomArray>"
				+ "      <atom id='a1' x3='1.0' y3='2.0' z3='0.0'/>"
				+ "      <atom id='a2' x3='3.0' y3='4.0' z3='0.0'/>"
				+ "      <atom id='a3' x3='2.0' y3='3.0' z3='1.0'/>"
				+ "    </atomArray>" + "  </molecule>";
		mol1 = (CMLMolecule)CMLXOMTestUtils.parseValidString(s);
	}

	public void makeMol2() {
		mol2 = (CMLMolecule)CMLXOMTestUtils.parseValidString("  <molecule id='m2' "
				+ CMLConstants.CML_XMLNS + ">" + "    <atomArray>"
				+ "      <atom id='a11' x3='1.0' y3='2.0' z3='0.0'/>"
				+ "      <atom id='a12' x3='3.0' y3='4.0' z3='0.0'/>"
				+ "      <atom id='a13' x3='2.0' y3='3.0' z3='-1.0'/>"
				+ "    </atomArray>" + "  </molecule>");
	}

	protected void makeMol3() {
		mol3 = (CMLMolecule)CMLXOMTestUtils.parseValidString("  <molecule id='m3' "
				+ CMLConstants.CML_XMLNS + ">" + "    <atomArray>"
				+ "      <atom id='a21' x3='21.0' y3='2.0' z3='0.0'/>"
				+ "      <atom id='a22' x3='23.0' y3='4.0' z3='0.0'/>"
				+ "      <atom id='a23' x3='22.0' y3='3.0' z3='1.0'/>"
				+ "    </atomArray>" + "  </molecule>");
	}

	protected void makeMol4() {
		mol4 = (CMLMolecule)CMLXOMTestUtils.parseValidString("  <molecule id='m4' "
				+ CMLConstants.CML_XMLNS
				+ ">"
				+ "    <atomArray>"
				+ "      <atom id='a1' xFract='0.1' yFract='0.2' zFract='0.0'/>"
				+ "      <atom id='a2' xFract='0.3' yFract='0.4' zFract='0.0'/>"
				+ "      <atom id='a3' xFract='0.5' yFract='0.6' zFract='0.7'/>"
				+ "    </atomArray>" + "  </molecule>");
	}

	protected void makeCrystal() {
		crystal = (CMLCrystal)CMLXOMTestUtils.parseValidString("  <crystal id='c1' "
				+ CMLConstants.CML_XMLNS + ">"
				+ "    <scalar dictRef='iucr:_cell_length_a'>9.0</scalar>"
				+ "    <scalar dictRef='iucr:_cell_length_b'>10.0</scalar>"
				+ "    <scalar dictRef='iucr:_cell_length_c'>11.0</scalar>"
				+ "    <scalar dictRef='iucr:_cell_angle_alpha'>90.0</scalar>"
				+ "    <scalar dictRef='iucr:_cell_angle_beta'>90.0</scalar>"
				+ "    <scalar dictRef='iucr:_cell_angle_gamma'>90.0</scalar>"
				+ "  </crystal>" + "  ");
	}

	public void makeMol5() {
		mol5 = (CMLMolecule)CMLXOMTestUtils.parseValidString("  <molecule id='m5' "
				+ CMLConstants.CML_XMLNS
				+ ">"
				+ "    <atomArray>"
				+ "      <atom id='a1' elementType='C' x3='0.0' y3='0.0' z3='0.0'>"
				+ "        <label value='C1'/>"
				+ "      </atom>"
				+ "      <atom id='a2' elementType='N' x3='0.0' y3='1.3' z3='0.0'/>"
				+ "      <atom id='a3' elementType='O' x3='1.0' y3='2.2' z3='0.0' formalCharge='-1'/>"
				+ "      <atom id='a4' elementType='H' x3='0.85' y3='-0.54' z3='0.5'>"
				+ "        <label value='H1a'/>"
				+ "      </atom>"
				+ "      <atom id='a5' elementType='H' x3='-0.85' y3='-0.54' z3='0.5'>"
				+ "        <label value='H1b'/>" + "      </atom>"
				+ "    </atomArray>" + "  </molecule>");
	}

	public void makeMol5a() {
		mol5a = (CMLMolecule)CMLXOMTestUtils.parseValidString("  <molecule id='m5' "
				+ CMLConstants.CML_XMLNS
				+ ">"
				+ "    <atomArray>"
				+ "      <atom id='a1' elementType='C' x3='0.0' y3='0.0' z3='0.0'/>"
				+ "      <atom id='a2' elementType='N' x3='0.0' y3='1.3' z3='0.0'/>"
				+ "      <atom id='a3' elementType='C' x3='1.2' y3='2.2' z3='0.0'/>"
				+ "      <atom id='a4' elementType='H' x3='0.95' y3='-0.54' z3='0.0'/>"
				+ "      <atom id='a5' elementType='H' x3='-0.95' y3='-0.54' z3='0.0'/>"
				+ "    </atomArray>" + "    <bondArray>"
				+ "      <bond id='a1_a2' atomRefs2='a1 a2'/>"
				+ "      <bond id='a1_a4' atomRefs2='a1 a4'/>"
				+ "      <bond id='a1_a5' atomRefs2='a1 a5'/>"
				+ "      <bond id='a2_a3' atomRefs2='a2 a3'/>"
				+ "    </bondArray>" + "  </molecule>");
	}

	public void makeMolCryst() {
		cmlCryst = (CMLCml)CMLXOMTestUtils.parseValidString("<cml id='cml1' "
				+ CMLConstants.CML_XMLNS
				+ ">"
				+ "  <crystal id='c1' >"
				+ "    <scalar dictRef='cml:a'>9.0</scalar>"
				+ "    <scalar dictRef='cml:b'>10.0</scalar>"
				+ "    <scalar dictRef='cml:c'>11.0</scalar>"
				+ "    <scalar dictRef='cml:alpha'>90.0</scalar>"
				+ "    <scalar dictRef='cml:beta'>90.0</scalar>"
				+ "    <scalar dictRef='cml:gamma'>90.0</scalar>"
				+ "  </crystal>"
				+ "  <molecule id='m5' >"
				+ "    <atomArray>"
				+ "      <atom id='a1' elementType='C' xFract='0.0' yFract='0.0' zFract='0.0'/>"
				+ "      <atom id='a2' elementType='N' xFract='0.0' yFract='0.1' zFract='0.0'/>"
				+ "      <atom id='a3' elementType='C' xFract='0.12' yFract='0.22' zFract='0.0'/>"
				+ "      <atom id='a4' elementType='H' xFract='0.2' yFract='-0.33' zFract='0.1'/>"
				+ "      <atom id='a5' elementType='H' xFract='0.25' yFract='-0.54' zFract='0.0'/>"
				+ "    </atomArray>" + "    <bondArray>"
				+ "      <bond id='a1_a2' atomRefs2='a1 a2'/>"
				+ "      <bond id='a1_a4' atomRefs2='a1 a4'/>"
				+ "      <bond id='a1_a5' atomRefs2='a1 a5'/>"
				+ "      <bond id='a2_a3' atomRefs2='a2 a3'/>"
				+ "    </bondArray>" + "  </molecule>" + "</cml>");
		cmlCrystMol = (CMLMolecule) CMLUtil.getQueryNodes(cmlCryst,
				".//" + CMLMolecule.NS, CMLConstants.CML_XPATH).get(0);
		cmlCrystCryst = (CMLCrystal) CMLUtil.getQueryNodes(cmlCryst,
				".//" + CMLCrystal.NS, CMLConstants.CML_XPATH).get(0);

	}

	protected void makeMol6() {
		mol6 = (CMLMolecule)CMLXOMTestUtils.parseValidString("  <molecule id='m6' "
				+ CMLConstants.CML_XMLNS
				+ ">"
				+ "    <atomArray>"
				+ "      <atom id='a1' elementType='C' x3='0.0' y3='0.0' z3='0.0'/>"
				+ "      <atom id='a2' elementType='N' x3='0.0' y3='1.3' z3='0.0'/>"
				+ "      <atom id='a3' elementType='C' x3='1.2' y3='2.2' z3='0.0'/>"
				+ "    </atomArray>" + "  </molecule>");
	}

	public void makeMol7() {
		mol7 = (CMLMolecule)CMLXOMTestUtils.parseValidString("  <molecule id='m7' "
				+ CMLConstants.CML_XMLNS + ">" + "    <atomArray>"
				+ "      <atom id='a1' elementType='C' x2='0.0' y2='0.0'/>"
				+ "      <atom id='a2' elementType='N' x2='0.0' y2='1.3'/>"
				+ "      <atom id='a3' elementType='C' x2='1.2' y2='2.2'/>"
				+ "    </atomArray>" + "  </molecule>");
	}

	public void makeMol8() {
		mol8 = (CMLMolecule)CMLXOMTestUtils.parseValidString("<molecule id='m8' "
				+ CMLConstants.CML_XMLNS
				+ ">"
				+ "  <molecule id='m8a'>"
				+ "    <atomArray>"
				+ "      <atom id='a1' elementType='C' x2='0.0' y2='0.0'/>"
				+ "      <atom id='a2' elementType='N' x2='0.0' y2='1.3'/>"
				+ "      <atom id='a3' elementType='C' x2='1.2' y2='2.2'/>"
				+ "    </atomArray>"
				+ "  </molecule>"
				+ "  <molecule id='m8b'>"
				+ "    <atomArray>"
				+ "      <atom id='a1' elementType='H' x3='10.0' y3='0.0' z3='0.0'/>"
				+ "      <atom id='a2' elementType='Br' x3='10.0' y3='1.3' z3='0.0'/>"
				+ "      <atom id='a33' elementType='Cl' x3='11.2' y3='2.2' z3='0.0'/>"
				+ "    </atomArray>" + "  </molecule>" + "</molecule>");
	}

	protected void makeMol9() {
		mol9 = (CMLMolecule)CMLXOMTestUtils.parseValidString("<molecule id='m9' " + CMLConstants.CML_XMLNS
				+ ">" + "  <atomArray>"
				+ "    <atom id='a1' elementType='C' x2='0.0' y2='0.0'/>"
				+ "    <atom id='a2' elementType='N' x2='0.0' y2='1.3'/>"
				+ "    <atom id='a3' elementType='C' x2='1.2' y2='2.2'/>"
				+ "  </atomArray>" + "  <bondArray>"
				+ "    <bond atomRefs2='a1 a2'/>"
				+ "    <bond atomRefs2='a2 a3'/>" + "  </bondArray>"
				+ "</molecule>");
	}

	protected void makeMol10() {
		mol10 = (CMLMolecule)CMLXOMTestUtils.parseValidString("<molecule "
				+ CMLConstants.CML_XMLNS
				+ ">"
				+ "  <atomArray>"
				+ "    <atom id='a1' elementType='N' hydrogenCount='2'/>"
				+ "    <atom id='a2' elementType='C' hydrogenCount='2'/>"
				+ "    <atom id='a3' elementType='C' hydrogenCount='0'/>"
				+ "    <atom id='a4' elementType='O' hydrogenCount='0'/>"
				+ "    <atom id='a5' elementType='O' formalCharge='-1' hydrogenCount='0'/>"
				+ "  </atomArray>" + "  <bondArray>"
				+ "    <bond atomRefs2='a1 a2' order='S'/>"
				+ "    <bond atomRefs2='a2 a3' order='S'/>"
				+ "    <bond atomRefs2='a3 a4' order='D'/>"
				+ "    <bond atomRefs2='a3 a5' order='S'/>" + "  </bondArray>"
				+ "</molecule>" + CMLConstants.S_EMPTY);
	}

	protected void makeMol11() {
		mol11 = (CMLMolecule)CMLXOMTestUtils.parseValidString("<molecule " + CMLConstants.CML_XMLNS + ">"
				+ "  <atomArray>"
				+ "    <atom id='a1' elementType='N' hydrogenCount='2'/>"
				+ "    <atom id='a2' elementType='C' hydrogenCount='1'/>"
				+ "    <atom id='a3' elementType='C' hydrogenCount='1'/>"
				+ "    <atom id='a4' elementType='O' hydrogenCount='0'/>"
				+ "    <atom id='a5' elementType='S' hydrogenCount='0'/>"
				+ "    <atom id='a6' elementType='N' hydrogenCount='0'/>"
				+ "    <atom id='a7' elementType='Cl' hydrogenCount='0'/>"
				+ "    <atom id='a8' elementType='Br' hydrogenCount='0'/>"
				+ "  </atomArray>" + "  <bondArray>"
				+ "    <bond atomRefs2='a1 a2' order='S'/>"
				+ "    <bond atomRefs2='a2 a3' order='S'/>"
				+ "    <bond atomRefs2='a2 a4' order='S'/>"
				+ "    <bond atomRefs2='a3 a4' order='S'/>"
				+ "    <bond atomRefs2='a3 a5' order='S'/>"
				+ "    <bond atomRefs2='a5 a6' order='S'/>"
				+ "    <bond atomRefs2='a6 a7' order='S'/>"
				+ "    <bond atomRefs2='a6 a8' order='S'/>" + "  </bondArray>"
				+ "</molecule>" + CMLConstants.S_EMPTY);
	}

}
