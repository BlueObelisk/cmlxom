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

import static org.xmlcml.euclid.EuclidConstants.EPS;
import static org.xmlcml.euclid.test.EuclidTestBase.getAssertFormat;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Node;
import nu.xom.ParsingException;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.xmlcml.cml.base.CMLAttribute;
import org.xmlcml.cml.base.CMLBuilder;
import org.xmlcml.cml.base.CMLConstants;
import org.xmlcml.cml.base.CMLElements;
import org.xmlcml.cml.base.CMLSerializer;
import org.xmlcml.cml.base.CMLXOMTestUtils;
import org.xmlcml.cml.base.DoubleSTAttribute;
import org.xmlcml.cml.element.CMLAtom;
import org.xmlcml.cml.element.CMLAtomArray;
import org.xmlcml.cml.element.CMLBond;
import org.xmlcml.cml.element.CMLFormula;
import org.xmlcml.cml.element.CMLMolecule;
import org.xmlcml.cml.element.CMLFormula.Sort;
import org.xmlcml.cml.element.CMLFormula.Type;
import org.xmlcml.cml.element.main.MoleculeAtomBondFixture;
import org.xmlcml.euclid.EuclidRuntimeException;
import org.xmlcml.euclid.test.DoubleTestBase;
import org.xmlcml.euclid.test.StringTestBase;
import org.xmlcml.molutil.ChemicalElement;
import org.xmlcml.molutil.ChemicalElement.AS;

/**
 * test CMLFormula.
 * 
 * @author pmr
 * 
 */
public class CMLFormulaTest {
	MoleculeAtomBondFixture fixture = new MoleculeAtomBondFixture();

	private static Logger LOG = Logger.getLogger(CMLFormulaTest.class);
	// built in xom;
	CMLFormula xomForm1 = null;
	CMLFormula xomForm2 = null;
	CMLFormula xomForm3 = null;
	CMLFormula xomForm3a = null;
	CMLFormula xomForm3b = null;

	// read into xom;
	String xmlForm1S = "<formula id='f1' concise='C 2 H 2 O 2 Br 1' "
			+ CMLConstants.CML_XMLNS + " formalCharge='-1'/>" + CMLConstants.S_EMPTY;

	Document xmlForm1Doc = null;

	CMLFormula xmlForm1 = null;
	static int count = 0;

	/**
	 * setup.
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		if (count++ > 0) {
			// throw new RuntimeException("SKIP");
		}

		// build from scratch
		xomForm1 = new CMLFormula();
		xomForm1.add(AS.H.value, 1.0);
		xomForm1.add(AS.O.value, 3.0);
		xomForm1.add(AS.N.value, 1.0);
		xomForm1.setCount(2.0);
		xomForm1.setId("xomForm1");
		// build from concise
		xomForm2 = new CMLFormula();
		xomForm2.setConcise("H 1 N 1 O 3");
		xomForm2.setId("xomForm2");

		// read reference moelcule

		try {
			xmlForm1Doc = new CMLBuilder().build(new StringReader(xmlForm1S));
		} catch (IOException e) {
			Assert.fail("Should not throw IOException");
		} catch (ParsingException e) {
			e.printStackTrace();
			LOG.error("Parse exception " + e.getMessage());
			Assert.fail("Should not throw ParsingException" + e.getCause());
		}
		xmlForm1 = (CMLFormula) xmlForm1Doc.getRootElement();
		// BUG the copy constructor adds spurious children!
		xomForm3 = new CMLFormula();
		xomForm3a = new CMLFormula();
		xomForm3a.setId("xomForm3a");
		String expectS = "<?xml version='1.0' encoding='UTF-8'?>" + (char) 13
				+ (char) 10 + "<formula id='xomForm3a'  " + CMLConstants.CML_XMLNS + "/>";
		Element expectElem =CMLXOMTestUtils.parseValidString(expectS);
		CMLXOMTestUtils.assertEqualsCanonically("formula setup", expectElem, xomForm3a);

		xomForm3a.setConcise("H 2 S 1 O 4");
		expectS = "<?xml version='1.0' encoding='UTF-8'?>" + (char) 13
				+ (char) 10 + "<formula id='xomForm3a' concise='H 2 O 4 S 1'"
				+ CMLConstants.S_SPACE + CMLConstants.CML_XMLNS + ">"
				+ "<atomArray elementType='H O S' count='2.0 4.0 1.0'/>"
				+ "</formula>";
		expectElem =CMLXOMTestUtils.parseValidString(expectS);
		CMLXOMTestUtils.assertEqualsCanonically("formula setup", expectElem, xomForm3a);
		Assert.assertEquals("xom3a child", 1, xomForm3a.getChildCount());
		CMLFormula xomForm3aCopy = new CMLFormula(xomForm3a);
//		xomForm3aCopy.debug("FORM");
		Assert.assertEquals("xom3a children", 1, xomForm3aCopy.getAtomArrayElements()
				.size());
		// should be
		expectS = "<?xml version='1.0' encoding='UTF-8'?>" + (char) 13
				+ (char) 10 + "<formula id='xomForm3aaa' concise='H 2 O 4 S 1'"
				+ CMLConstants.S_SPACE + CMLConstants.CML_XMLNS + ">"
				+ "<atomArray elementType='H O S' count='2.0 4.0 1.0'/>"
				+ "</formula>";
		// but is
		expectS = "<?xml version='1.0' encoding='UTF-8'?>" + (char) 13
				+ (char) 10 + "<formula id='xomForm3a' concise='H 2 O 4 S 1'"
				+ CMLConstants.S_SPACE + CMLConstants.CML_XMLNS + ">"
				+ "<atomArray elementType='H O S' count='2.0 4.0 1.0'/>"
				+ "</formula>";

		expectElem =CMLXOMTestUtils.parseValidString(expectS);

		CMLXOMTestUtils.assertEqualsCanonically("formula setup", expectElem, xomForm3aCopy);

		xomForm3.appendChild(xomForm3a);
		xomForm3b = new CMLFormula();
		xomForm3b.setConcise("Na 1 H 1 C 1 O 3");
		xomForm3.appendChild(xomForm3b);
	}

	/**
	 * asserts equality of double arrays.
	 * 
	 * checks for non-null, then equality of length, then individual elements
	 * 
	 * @param message
	 * @param formula1
	 *            expected formula
	 * @param formula2
	 *            actual formula
	 * @param eps
	 *            tolerance for agreement
	 */
	public static void assertEqualsConcise(String message, CMLFormula formula1,
			CMLFormula formula2, double eps) {
		if (formula1 == null) {
			Assert.fail(getAssertFormat(message, "formula", "null"));
		}
		if (formula2 == null) {
			Assert.fail(getAssertFormat(message, "formula", "null"));
		}
		Assert.assertEquals("equal concise", true, formula1.equals(formula2, eps));
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLFormula.copy()'
	 */
	@Test
	public void testCopy() {
		Node copy = xmlForm1.copy();
		Assert.assertEquals("class should be CMLform: ", copy.getClass(),
				CMLFormula.class);
		CMLFormula copyForm = (CMLFormula) copy;
		Assert.assertEquals("formula is identical", copyForm.compareTo(xmlForm1), 0);
	}

	/**
	 * test prohibition of formulaArray child.
	 * 
	 */
	@Test
	public void testNoAtomArray() {
		// read into xom;
		String xmlForm1S = "<formula id='f1' " + CMLConstants.CML_XMLNS + ">"
				+ "  <atomArray>"
				+ "    <atom id='a2' elementType='O' count='3'/>"
				+ "  </atomArray>" + "</atom>" + CMLConstants.S_EMPTY;

		try {
			new CMLBuilder().build(new StringReader(xmlForm1S));
			Assert.fail("Should throw ParsingException due to forbidden atomArray child");
		} catch (IOException e) {
			Assert.fail("Should not throw IOException");
		} catch (ParsingException e) {
			Assert.assertEquals("ok", "ok");
		}
	}

	/* public */void /* test */Serialize() {
		/*
		 * -- cannot really test this as order of output may vary CMLSerializer
		 * serializer; String s; String expect;
		 * 
		 * serializer = new CMLSerializer(); s =
		 * serializer.getXML(xomForm1).trim(); expect =
		 * "<?xml version='1.0' encoding='UTF-8'?>"+(char)13+(char)10+ "<formula
		 * concise='H 1 N 1 O 3' count='2.0' xmlns=\S_EMPTY+CML_NS+"'>" +
		 * "<atomArray elementType='H O N' count='1.0 3.0 1.0'/>" +
		 * "</formula>"; Assert.assertEquals("xom1 serializer2", expect, s);
		 * xomForm1.add(AS.H.value, 7.0);
		 * 
		 * serializer = new CMLSerializer(); s =
		 * serializer.getXML(xomForm1).trim(); expect =
		 * "<?xml version='1.0' encoding='UTF-8'?>"+(char)13+(char)10+ "<formula
		 * concise='H 8 O 3 N 1' count='2.0' xmlns=\S_EMPTY+CML_NS+"'>" +
		 * "<atomArray elementType='H O N' count='8.0 3.0 1.0'/>" +
		 * "</formula>"; expect =
		 * "<?xml version='1.0' encoding='UTF-8'?>"+(char)13+(char)10+ "<formula
		 * concise='H 8 N 1 O 3' count='2.0' xmlns=\S_EMPTY+CML_NS+"'>" +
		 * "<atomArray elementType='H N O' count='8.0 1.0 3.0'/>" +
		 * "<atomArray elementType='H O N' count='8.0 3.0 1.0'/>" +
		 * "</formula>"; Assert.assertEquals("xom1 serializer2", expect, s);
		 * 
		 * serializer = new CMLSerializer(); s =
		 * serializer.getXML(xomForm3).trim(); expect =
		 * "<?xml version='1.0' encoding='UTF-8'?>"+(char)13+(char)10+ "<formula
		 * xmlns=\S_EMPTY+CML_NS+"'>" + "<formula concise='H 2 O 4 S 1'>" +
		 * "<atomArray elementType='H O S' count='2.0 4.0 1.0'/>" + "</formula>"
		 * + "</formula>"; expect =
		 * "<?xml version='1.0' encoding='UTF-8'?>"+(char)13+(char)10+ "<formula
		 * xmlns=\S_EMPTY+CML_NS+"'>" + "<formula concise='H 2 O 4 S 1'>" +
		 * "<atomArray elementType='H O S' count='2.0 4.0 1.0'/>" +
		 * "<atomArray elementType='H O S' count='2.0 4.0 1.0'/>" + "</formula>"
		 * + "<formula concise='C 1 H 1 Na 1 O 3'>" +
		 * "<atomArray elementType='C H Na O' count='1.0 1.0 1.0 3.0'/>" +
		 * "<atomArray elementType='C H Na O' count='1.0 1.0 1.0 3.0'/>" +
		 * "</formula>" + "</formula>"; Assert.assertEquals("xom1 serializer2", expect,
		 * s); --
		 */
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLFormula.getCount()'
	 */
	@Test
	public void testGetCount() {
		double count = xomForm1.getCount();
		Assert.assertEquals("xomForm1 count", 2.0, count, 0.00001);

		count = xmlForm1.getCount();
		Assert.assertEquals("xmlForm1 count", 1.0, count, 0.00001);
	}

	/**
	 * 
	 */
	@Test
	public void testAddHydrogensIfExplicitAndPresent() {
		CMLMolecule molecule;
		CMLAtom atom;
		CMLBond bond;
		CMLAtom hatom;
		CMLFormula formula;

		molecule = new CMLMolecule();
		atom = new CMLAtom();
		atom.setId("a1");
		molecule.addAtom(atom);
		atom.setHydrogenCount(4);
		atom.setElementType("C");
		for (int i = 0; i < 4; i++) {
			hatom = new CMLAtom();
			hatom.setId("h" + (i + 1));
			hatom.setElementType("H");
			molecule.addAtom(hatom);
			bond = new CMLBond(atom, hatom);
			molecule.addBond(bond);
		}
		formula = new CMLFormula(molecule);
		Assert.assertEquals("methane - explicit and count", "C 1 H 4", formula
				.getConcise());

		// test with only hydrogen count
		molecule = new CMLMolecule();
		atom = new CMLAtom();
		atom.setId("a1");
		molecule.addAtom(atom);
		atom.setHydrogenCount(4);
		atom.setElementType("C");
		formula = new CMLFormula(molecule);
		Assert.assertEquals("methane - count", "C 1 H 4", formula.getConcise());

		// some explicit H
		molecule = new CMLMolecule();
		atom = new CMLAtom();
		atom.setId("a1");
		molecule.addAtom(atom);
		atom.setElementType("C");
		atom.setHydrogenCount(4);
		for (int i = 0; i < 2; i++) {
			hatom = new CMLAtom();
			hatom.setId("h" + (i + 1));
			hatom.setElementType("H");
			molecule.addAtom(hatom);
			bond = new CMLBond(atom, hatom);
			molecule.addBond(bond);
		}
		formula = new CMLFormula(molecule);
		Assert.assertEquals("methane - 2 explicit + count - carbon first", "C 1 H 4",
				formula.getConcise());

		// methanol
		molecule = new CMLMolecule();
		atom = new CMLAtom();
		atom.setId("a1");
		molecule.addAtom(atom);
		atom.setElementType("O");
		CMLAtom atom2 = new CMLAtom();
		atom2.setId("h1");
		molecule.addAtom(atom2);
		atom2.setElementType("H");
		bond = new CMLBond(atom, atom2);
		molecule.addBond(bond);
		atom2 = new CMLAtom();
		atom2.setId("a2");
		molecule.addAtom(atom2);
		atom2.setElementType("C");
		atom2.setHydrogenCount(3);
		bond = new CMLBond(atom, atom2);
		molecule.addBond(bond);

		formula = new CMLFormula(molecule);
		Assert.assertEquals("methanol - oxygen first - ", "C 1 H 4 O 1", formula
				.getConcise());

		molecule = new CMLMolecule();
		for (int i = 0; i < 2; i++) {
			hatom = new CMLAtom();
			hatom.setId("h" + (i + 1));
			hatom.setElementType("H");
			molecule.addAtom(hatom);
		}
		atom = new CMLAtom();
		atom.setId("a1");
		molecule.addAtom(atom);
		atom.setElementType("C");
		atom.setHydrogenCount(4);
		for (int i = 0; i < 2; i++) {
			hatom = molecule.getAtomById("h" + (i + 1));
			bond = new CMLBond(atom, hatom);
			molecule.addBond(bond);
		}
		formula = new CMLFormula(molecule);
		Assert.assertEquals("methane - 2 explicit + count - hydrogens first - ",
				"C 1 H 4", formula.getConcise());

		// no hydrogen count
		molecule = new CMLMolecule();
		atom = new CMLAtom();
		atom.setId("a1");
		molecule.addAtom(atom);
		atom.setElementType("C");
		for (int i = 0; i < 4; i++) {
			hatom = new CMLAtom();
			hatom.setId("h" + (i + 1));
			hatom.setElementType("H");
			molecule.addAtom(hatom);
			bond = new CMLBond(atom, hatom);
			molecule.addBond(bond);
		}
		formula = new CMLFormula(molecule);
		Assert.assertEquals("methane - explicit", "C 1 H 4", formula.getConcise());

		// inconsistent
		molecule = new CMLMolecule();
		atom = new CMLAtom();
		atom.setId("a1");
		molecule.addAtom(atom);
		atom.setElementType("C");
		atom.setHydrogenCount(2);
		for (int i = 0; i < 4; i++) {
			hatom = new CMLAtom();
			hatom.setId("h" + (i + 1));
			hatom.setElementType("H");
			molecule.addAtom(hatom);
			bond = new CMLBond(atom, hatom);
			molecule.addBond(bond);
		}
		formula = new CMLFormula(molecule);
		// formula.debug("BAD");
		Assert.assertEquals("methane - all H explicit but count = 2", "C 1 H 4",
				formula.getConcise());

		// methanol
		molecule = new CMLMolecule();
		atom2 = new CMLAtom();
		atom2.setId("a2");
		molecule.addAtom(atom2);
		atom2.setElementType("C");
		for (int i = 0; i < 3; i++) {
			hatom = new CMLAtom();
			hatom.setId("h" + (i + 2));
			hatom.setElementType("H");
			molecule.addAtom(hatom);
			bond = new CMLBond(atom2, hatom);
			molecule.addBond(bond);
		}
		atom = new CMLAtom();
		atom.setId("a1");
		molecule.addAtom(atom);
		atom.setElementType("O");
		bond = new CMLBond(atom, atom2);
		molecule.addBond(bond);
		atom2 = new CMLAtom();
		atom2.setId("h1");
		molecule.addAtom(atom2);
		atom2.setElementType("H");
		bond = new CMLBond(atom, atom2);
		molecule.addBond(bond);

		formula = new CMLFormula(molecule);
		Assert.assertEquals("methanol - carbon first, explicit Hs- ", "C 1 H 4 O 1",
				formula.getConcise());

		// hydrogen molecule
		molecule = new CMLMolecule();
		atom = new CMLAtom();
		atom.setId("h1");
		molecule.addAtom(atom);
		atom.setElementType("H");
		atom2 = new CMLAtom();
		atom2.setId("h2");
		molecule.addAtom(atom2);
		atom2.setElementType("H");
		bond = new CMLBond(atom, atom2);
		molecule.addBond(bond);

		formula = new CMLFormula(molecule);
		Assert.assertEquals("hydrogen molecule - ", "H 2", formula.getConcise());

		// hydrogen chloride
		molecule = new CMLMolecule();
		atom = new CMLAtom();
		atom.setId("h1");
		molecule.addAtom(atom);
		atom.setElementType("H");
		atom.setFormalCharge(1);
		atom2 = new CMLAtom();
		atom2.setId("h2");
		molecule.addAtom(atom2);
		atom2.setElementType("Cl");
		atom2.setFormalCharge(-1);
		formula = new CMLFormula(molecule);
		Assert.assertEquals("hydrogen chloride - ", "H 1 Cl 1", formula.getConcise());

	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLFormula.setCount(double)'
	 */
	@Test
	public void testSetCount() {
		double cc = xmlForm1.getCount();
		Assert.assertEquals("count", 1.0, cc, 0.0000001);
		xmlForm1.setCount(1.5);
		cc = xmlForm1.getCount();
		Assert.assertEquals("count", 1.5, cc, 0.0001);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLFormula.getFormalCharge()'
	 */
	@Test
	public void testGetFormalCharge() {
		int fc = xmlForm1.getFormalCharge();
		Assert.assertEquals("formal charge", -1, fc);
		xmlForm1.setFormalCharge(2);
		fc = xmlForm1.getFormalCharge();
		Assert.assertEquals("formal charge", 2, fc);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLFormula.setFormalCharge(int)'
	 */
	@Test
	public void testSetFormalCharge() {
		int fc = xmlForm1.getFormalCharge();
		Assert.assertEquals("formal charge", -1, fc);
		xmlForm1.setFormalCharge(-3);
		fc = xmlForm1.getFormalCharge();
		Assert.assertEquals("formal charge", -3, fc);

	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLFormula.CMLFormula()'
	 */
	@Test
	public void testCMLFormula() {
		CMLFormula formula = new CMLFormula();
		Assert.assertNotNull("constructor ", formula);
		Assert.assertNull("no id attribute", formula.getIdAttribute());
		Assert.assertEquals("no children", formula.getChildCount(), 0);

	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLFormula.CMLFormula(CMLFormula)'
	 */
	@Test
	public void testCMLFormulaCMLFormula() {
		// copy constructor
		CMLFormula xformula = xomForm1;
		CMLAttribute countAtt = xomForm1.getCountAttribute();
		Assert.assertNotNull("count attribute", countAtt);
		Assert.assertTrue("count class is subclass of CMLAttribute",
				CMLAttribute.class.isAssignableFrom(countAtt.getClass()));
		CMLFormula formula = new CMLFormula(xformula);
		Assert.assertNotNull("constructor ", formula);

		countAtt = formula.getCountAttribute();
		Assert.assertNotNull("copied count attribute", countAtt);
		Assert.assertTrue("count class is subclass of CMLAttribute",
				CMLAttribute.class.isAssignableFrom(countAtt.getClass()));
		Assert.assertEquals("count class is DoubleSTAttribute", countAtt.getClass(),
				DoubleSTAttribute.class);
		Assert.assertEquals("count value", formula.getCount(), xformula.getCount(), 0.0001);

		CMLFormula copyForm = new CMLFormula(xmlForm1);
		CMLXOMTestUtils.assertEqualsCanonically("compare Formula", copyForm, xmlForm1);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLFormula.createFormula(String)'
	 */
	@Test
	public void testCreateFormulaString() {
		String s;
		CMLFormula form = null;
		s = "H 2 O 4 S 1";
		try {
			form = CMLFormula.createFormula(s);
		} catch (RuntimeException e) {
			Assert.fail("parsing shouldn't fail for: " + s + " because:" + e);
		}
		Assert.assertEquals("formula string", "H 2 O 4 S 1", form.getConcise());
		s = "H2O4S";
		form = CMLFormula.createFormula(s);
		Assert.assertEquals("formula string", "H 2 O 4 S 1", form.getConcise());
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLFormula.createFormula(String,
	 * String)'
	 */
	@Test
	public void testCreateFormulaStringConvention() {

		// CMLFormula.createFormula("C 2 H 4", Formula.Convention.)
		CMLFormula form = null;
		try {
			form = CMLFormula.createFormula("C2H4",
					CMLFormula.Type.NOPUNCTUATION);
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw new EuclidRuntimeException("should never throw " + e);
		}
		// Assert.assertEquals("createFormula", "C 2 H 4", form.getConcise());
		try {
			form = CMLFormula.createFormula("C 2 H 4",
					CMLFormula.Type.ELEMENT_WHITESPACE_COUNT);
		} catch (RuntimeException e) {
			throw new EuclidRuntimeException("should never throw " + e);
		}
		Assert.assertEquals("createFormula", "C 2 H 4", form.getConcise());
		try {
			form = CMLFormula.createFormula("C2 H4",
					CMLFormula.Type.ELEMENT_COUNT_WHITESPACE);
		} catch (RuntimeException e) {
			throw new EuclidRuntimeException("should never throw " + e);
		}
		Assert.assertEquals("createFormula", "C 2 H 4", form.getConcise());
		Assert.assertEquals("createFormula", 1.0, form.getCount(), EPS);
		try {
			form = CMLFormula.createFormula("2(C2 H4)",
					CMLFormula.Type.MULTIPLIED_ELEMENT_COUNT_WHITESPACE);
		} catch (RuntimeException e) {
			throw new EuclidRuntimeException("should never throw " + e);
		}
		Assert.assertEquals("createFormula", "C 2 H 4", form.getConcise());
		Assert.assertEquals("createFormula", 2.0, form.getCount(), EPS);
		/*
		 * -- try { form = CMLFormula.createFormula("3(C 2 H 4) 2(H 2 O 1)",
		 * CMLFormula.Type.NESTEDBRACKETS); } catch (CMLRuntime e) {
		 * neverThrow(e); } catch (RuntimeException e) { neverThrow(e); }
		 * Assert.assertEquals("createFormula", "C 2 H 4", form.getConcise());
		 * Assert.assertEquals("createFormula", 2.0, form.getCount(), EPS); --
		 */
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLFormula.createFromString(String, String)'
	 */
	@Test
	public void testCreateFromString() {

		String moiety = "C2 H6 N +, H1 S2 O4 -";
		CMLFormula[] f = new CMLFormula[2];
		try {
			f[0] = CMLFormula.createFormula("NC2H6");
		} catch (RuntimeException e) {
			Assert.fail("should not throw " + e);
		}
		f[0].setFormalCharge(1);
		try {
			f[1] = CMLFormula.createFormula("S2O4H");
		} catch (RuntimeException e) {
			Assert.fail("should not throw " + e);
		}
		f[1].setFormalCharge(-1);

		CMLFormula fMoiety = null;
		try {
			fMoiety = CMLFormula.createFormula(moiety, Type.MOIETY);
		} catch (RuntimeException e) {
			e.printStackTrace();
			Assert.fail("should not throw " + e);
		}
		Assert.assertEquals("moiety count", 2, fMoiety.getChildCount());
		for (int i = 0; i < 2; i++) {
			CMLFormula mf = (CMLFormula) fMoiety.getChild(i);
			Assert.assertTrue("moiety " + i, f[i].equals(mf, 0.0001));
		}
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLFormula.add(String, double)'
	 */
	@Test
	public void testAdd() {
		// FIXME - sorting
		String[] elements = xomForm1.getElementTypes();
		StringTestBase.assertEquals("start xomForm1", new String[] {
				AS.H.value, AS.O.value, AS.N.value }, elements);
		double[] counts = xomForm1.getCounts();
		DoubleTestBase.assertEquals("start xomForm1", new double[] { 1.0, 3.0,
				1.0 }, counts, 0.000001);
		xomForm1.add(AS.S.value, 2.0);
		elements = xomForm1.getElementTypes();
		StringTestBase.assertEquals("add1 xomForm1", new String[] { AS.H.value,
				AS.O.value, AS.N.value, AS.S.value }, elements);
		counts = xomForm1.getCounts();
		DoubleTestBase.assertEquals("add1 xomForm1", new double[] { 1.0, 3.0,
				1.0, 2.0 }, counts, 0.000001);
		xomForm1.add(AS.H.value, 2.0);
		elements = xomForm1.getElementTypes();
		StringTestBase.assertEquals("add1 xomForm1", new String[] { AS.H.value,
				AS.O.value, AS.N.value, AS.S.value }, elements);
		counts = xomForm1.getCounts();
		DoubleTestBase.assertEquals("add1 xomForm1", new double[] { 3.0, 3.0,
				1.0, 2.0 }, counts, 0.000001);

		xomForm1.setFormalCharge(-1);
		String concise = xomForm1.getConcise();
		Assert.assertEquals("xom in sync", "H 3 N 1 O 3 S 2 -1", concise);
		int fc = xomForm1.getFormalCharge();
		Assert.assertEquals("formal charge from concise", -1, fc);
		xomForm1.setFormalCharge(1);
		concise = xomForm1.getConcise();
		Assert.assertEquals("xom in sync", "H 3 N 1 O 3 S 2 1", concise);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLFormula.getElementTypes()'
	 */
	@Test
	public void testGetElementTypes() {
		String[] el = xomForm1.getElementTypes();
		StringTestBase.assertEquals("element types", new String[] { AS.H.value,
				AS.O.value, AS.N.value }, el);

		el = xmlForm1.getElementTypes();
		StringTestBase.assertEquals("element types", new String[] { AS.C.value,
				AS.H.value, AS.Br.value, AS.O.value }, el);

	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLFormula.getElementCounts()'
	 */
	@Test
	public void testGetElementCounts() {
		// TODO check provenance od xomForm1
		double[] c = xomForm1.getCounts();
		DoubleTestBase.assertEquals("element counts",
				new double[] { 1., 3., 1. }, c, 0.00001);

		String concise = xmlForm1.getConcise();
//		Assert.assertEquals("concise", "C 2 H 2 Br 1 O 2 -1", concise);
		Assert.assertEquals("concise", "C 2 H 2 Br 1 O 2", concise);
		c = xmlForm1.getCounts();
		DoubleTestBase.assertEquals("element counts", new double[] { 2., 2.,
				1., 2. }, c, 0.00001);

	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLFormula.addFormula(CMLFormula)'
	 */
	@Test
	public void testAddFormulaCMLFormula() {
		CMLSerializer serializer = new CMLSerializer();
		String s = serializer.getXML(xomForm3a).trim();
		String expect = "<?xml version=" + CMLConstants.S_QUOT + "1.0" + CMLConstants.S_QUOT
				+ " encoding=" + CMLConstants.S_QUOT + "UTF-8" + CMLConstants.S_QUOT + "?>" + (char) 13
				+ (char) 10 + "<formula id=" + CMLConstants.S_QUOT + "xomForm3a" + CMLConstants.S_QUOT
				+ " concise=" + CMLConstants.S_QUOT + "H 2 O 4 S 1" + CMLConstants.S_QUOT + " "
				+ "xmlns=" + CMLConstants.S_QUOT + "" + CMLConstants.CML_NS + "" + CMLConstants.S_QUOT + ">"
				+ "<atomArray elementType=" + CMLConstants.S_QUOT + "H O S" + CMLConstants.S_QUOT
				+ " count=" + CMLConstants.S_QUOT + "2.0 4.0 1.0" + CMLConstants.S_QUOT + "/>"
				+ "</formula>";
		Assert.assertEquals("xom3a serializer", expect, s);
		Assert.assertEquals("child count", 1, xomForm3a.getChildCount());
		Assert.assertEquals("child count", 1, xomForm3b.getChildCount());
		Assert.assertEquals("concise", "H 2 O 4 S 1", xomForm3a.getConcise());
		Assert.assertEquals("concise", "C 1 H 1 Na 1 O 3", xomForm3b.getConcise());
		serializer = new CMLSerializer();
		s = serializer.getXML(xomForm3a).trim();
		expect = "<?xml version=" + CMLConstants.S_QUOT + "1.0" + CMLConstants.S_QUOT + " encoding="
				+ CMLConstants.S_QUOT + "UTF-8" + CMLConstants.S_QUOT + "?>" + (char) 13 + (char) 10
				+ "<formula id=" + CMLConstants.S_QUOT + "xomForm3a" + CMLConstants.S_QUOT + " concise="
				+ CMLConstants.S_QUOT + "H 2 O 4 S 1" + CMLConstants.S_QUOT + " " + "xmlns=" + CMLConstants.S_QUOT
				+ "" + CMLConstants.CML_NS + "" + CMLConstants.S_QUOT + ">" + "<atomArray elementType="
				+ CMLConstants.S_QUOT + "H O S" + CMLConstants.S_QUOT + " count=" + CMLConstants.S_QUOT
				+ "2.0 4.0 1.0" + CMLConstants.S_QUOT + "/>" + "</formula>";
		Assert.assertEquals("xom3a serializer", expect, s);
		// now add the formula
		xomForm3a.addFormula(xomForm3b);
		Assert.assertEquals("child count", 2, xomForm3a.getChildCount());
		CMLElements<CMLFormula> childFormula = xomForm3a.getFormulaElements();
		Assert.assertEquals("formula child count", 2, childFormula.size());
		Assert.assertEquals("formula 0 concise", "H 2 O 4 S 1", childFormula.get(0)
				.getConcise());
		Assert.assertEquals("formula 1 concise", "C 1 H 1 Na 1 O 3", childFormula.get(
				1).getConcise());
		serializer = new CMLSerializer();
		s = serializer.getXML(xomForm3a).trim();
		expect = "<?xml version=" + CMLConstants.S_QUOT + "1.0" + CMLConstants.S_QUOT + " encoding="
				+ CMLConstants.S_QUOT + "UTF-8" + CMLConstants.S_QUOT + "?>" + (char) 13 + (char) 10
				+ "<formula id=" + CMLConstants.S_QUOT + "xomForm3a" + CMLConstants.S_QUOT + " "
				+ "xmlns=" + CMLConstants.S_QUOT + "" + CMLConstants.CML_NS + "" + CMLConstants.S_QUOT + ">"
				+ "<formula id=" + CMLConstants.S_QUOT + "xomForm3a" + CMLConstants.S_QUOT + " concise="
				+ CMLConstants.S_QUOT + "H 2 O 4 S 1" + CMLConstants.S_QUOT + ">"
				+ "<atomArray elementType=" + CMLConstants.S_QUOT + "H O S" + CMLConstants.S_QUOT
				+ " count=" + CMLConstants.S_QUOT + "2.0 4.0 1.0" + CMLConstants.S_QUOT + "/>"
				+ "</formula>" + "<formula concise=" + CMLConstants.S_QUOT
				+ "C 1 H 1 Na 1 O 3" + CMLConstants.S_QUOT + ">" + "<atomArray elementType="
				+ CMLConstants.S_QUOT + "C H Na O" + CMLConstants.S_QUOT + " count=" + CMLConstants.S_QUOT
				+ "1.0 1.0 1.0 3.0" + CMLConstants.S_QUOT + "/>" + "</formula>"
				+ "</formula>";
		Assert.assertEquals("xom3a serializer", expect, s);

		// appended formula should be unaltered
		Assert.assertEquals("child count", 1, xomForm3b.getChildCount());
		Assert.assertEquals("concise", "C 1 H 1 Na 1 O 3", xomForm3b.getConcise());
		Assert.assertNull("concise", xomForm3a.getConcise());
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLFormula.getAggregateFormula()'
	 */
	@Test
	public void testGetAggregateFormula() {
		CMLFormula f = xmlForm1.getAggregateFormula();
		Assert.assertEquals("aggregate formula count", 1.0, f.getCount(), 0.0001);
		Assert.assertEquals("form3 children", 2, xomForm3.getChildCount());
		f = xomForm3.getAggregateFormula();

	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLFormula.aggregateFormula(CMLFormula)'
	 */
	@Test
	public void testAggregateFormula() {
		CMLFormula formula1 = null;
		try {
			formula1 = CMLFormula.createFormula("H 1 S 1 O 3",
					CMLFormula.Type.ELEMENT_WHITESPACE_COUNT);
		} catch (RuntimeException e) {
			Assert.fail("should not throw " + e);
		}
		formula1.setCount(3);
		formula1.setFormalCharge(-1);
		Assert.assertEquals("formula1 concise ", "H 1 O 3 S 1 -1", formula1
				.getConcise());
		Assert.assertEquals("formula1 charge ", -1, formula1.getFormalCharge());
		Assert.assertEquals("formula1 count ", 3, formula1.getCount(), EPS);

		CMLFormula formula2 = null;
		try {
			formula2 = CMLFormula.createFormula("Mg 1 O 6 H 12",
					CMLFormula.Type.ELEMENT_WHITESPACE_COUNT);
		} catch (RuntimeException e) {
			Assert.fail("should not throw " + e);
		}
		formula2.setFormalCharge(2);
		Assert.assertEquals("formula2 concise ", "H 12 Mg 1 O 6 2", formula2
				.getConcise());
		Assert.assertEquals("formula2 charge ", 2, formula2.getFormalCharge());
		Assert.assertEquals("formula2 count ", 1, formula2.getCount(), EPS);

		CMLFormula formula3 = formula1.createAggregatedFormula(formula2);
		Assert.assertEquals("formula3 concise ", "H 15 Mg 1 O 15 S 3 -1", formula3
				.getConcise());
		Assert.assertEquals("formula3 charge ", -1, formula3.getFormalCharge());
		Assert.assertEquals("formula3 count ", 1, formula3.getCount(), EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLFormula.divideBy(CMLFormula)'
	 */
	@Test
	public void testDivideBy() {

		CMLFormula fTop = null;
		try {
			fTop = CMLFormula.createFormula("NC2H6");
		} catch (RuntimeException e) {
			e.printStackTrace();
			Assert.fail("should not throw " + e);
		}
		fTop.setFormalCharge(1);
		CMLFormula fBot = null;
		try {
			fBot = CMLFormula.createFormula("N2C4H12");
		} catch (RuntimeException e) {
			Assert.fail("should not throw " + e);
		}
		fBot.setFormalCharge(2);
		double d = fTop.divideBy(fBot, 0.0001);
		Assert.assertEquals("divide top by bottom", 0.5, d, 0.0001);
		d = fBot.divideBy(fTop, 0.0001);
		Assert.assertEquals("divide top by bottom", 2.0, d, 0.0001);
		try {
			fBot = CMLFormula.createFormula("N2C4.1H12");
		} catch (RuntimeException e) {
			Assert.fail("should not throw " + e);
		}
		d = fBot.divideBy(fTop, 0.0001);
		Assert.assertTrue("cannot divide top by bottom", Double.isNaN(d));

		try {
			fTop = CMLFormula.createFormula("Al10.0O20.Si1.0000Sr3.");
		} catch (RuntimeException e) {
			Assert.fail("should not throw " + e);
		}
		try {
			fBot = CMLFormula.createFormula("Al2.5O5.Si0.25Sr0.75");
		} catch (RuntimeException e) {
			Assert.fail("should not throw " + e);
		}
		d = fBot.divideBy(fTop, 0.0001);
		Assert.assertEquals("divide top by bottom", 0.25, d, 0.0001);
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLFormula.getCalculatedMolecularMass()'
	 */
	@Test
	public void testGetCalculatedMolecularMass() {
		double m = xomForm1.getCalculatedMolecularMass();
		Assert.assertEquals("xomForm1 mw", 126.02568, m, 0.00001);

	}

	/**
	 * Get formatted formula. @ param convention
	 * 
	 * <pre>
	 *      NOPUNCTUATION			&quot;C2H4Cl2&quot; (default)
	 *      ELEMENT_COUNT_WHITESPACE	&quot;C2 H4 Cl2&quot;
	 *      ELEMENT_WHITESPACE_COUNT	&quot;C 2 H 4 Cl 2&quot;
	 *      NESTEDBRACKETS			&quot;(Na2)(SO4).10(H2O)&quot;
	 * </pre>
	 * 
	 * @ param sort
	 * 
	 * <pre>
	 *      ALPHABETIC_ELEMENTS		&quot;Br C Cl H&quot;
	 *      CHFIRST			=	&quot;C H Br Cl&quot;; (default)
	 * </pre>
	 * 
	 * @ param omitCount1 omit elements count if 1 (default false) @ return
	 * String the formatted formula
	 */
	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLFormula.getFormattedString(String, String,
	 * boolean)'
	 * 
	 */
	@Test
	public void testGetFormattedStringStringStringBoolean() {
		String s = xmlForm1.getFormattedString(Type.NOPUNCTUATION,
				Sort.CHFIRST, true);
		Assert.assertEquals("no punct, chfirst, omit1", "C2H2BrO2-", s);
		s = xmlForm1
				.getFormattedString(Type.NOPUNCTUATION, Sort.CHFIRST, false);
		Assert.assertEquals("no punct, chfirst, omit1", "C2H2Br1O2-", s);
		s = xmlForm1.getFormattedString(Type.ELEMENT_COUNT_WHITESPACE,
				Sort.CHFIRST, true);
		Assert.assertEquals("no punct, chfirst, omit1", "C2 H2 Br O2 -", s);
		s = xmlForm1.getFormattedString(Type.ELEMENT_COUNT_WHITESPACE,
				Sort.CHFIRST, false);
		Assert.assertEquals("no punct, chfirst, omit1", "C2 H2 Br1 O2 -", s);
		s = xmlForm1.getFormattedString(Type.ELEMENT_WHITESPACE_COUNT,
				Sort.CHFIRST, true);
		Assert.assertEquals("no punct, chfirst, omit1", "C 2 H 2 Br O 2 -", s);
		s = xmlForm1.getFormattedString(Type.ELEMENT_WHITESPACE_COUNT,
				Sort.CHFIRST, false);
		Assert.assertEquals("no punct, chfirst, omit1", "C 2 H 2 Br 1 O 2 -", s);
		s = xmlForm1.getFormattedString(Type.NOPUNCTUATION,
				Sort.ALPHABETIC_ELEMENTS, true);
		Assert.assertEquals("no punct, ALPHABETIC_ELEMENTS, omit1", "BrC2H2O2-", s);
		s = xmlForm1.getFormattedString(Type.NOPUNCTUATION,
				Sort.ALPHABETIC_ELEMENTS, false);
		Assert.assertEquals("no punct, ALPHABETIC_ELEMENTS, omit1", "Br1C2H2O2-", s);
		s = xmlForm1.getFormattedString(Type.ELEMENT_COUNT_WHITESPACE,
				Sort.ALPHABETIC_ELEMENTS, true);
		Assert.assertEquals("no punct, ALPHABETIC_ELEMENTS, omit1", "Br C2 H2 O2 -", s);
		s = xmlForm1.getFormattedString(Type.ELEMENT_COUNT_WHITESPACE,
				Sort.ALPHABETIC_ELEMENTS, false);
		Assert.assertEquals("no punct, ALPHABETIC_ELEMENTS, omit1", "Br1 C2 H2 O2 -",
				s);
		s = xmlForm1.getFormattedString(Type.ELEMENT_WHITESPACE_COUNT,
				Sort.ALPHABETIC_ELEMENTS, true);
		Assert.assertEquals("no punct, ALPHABETIC_ELEMENTS, omit1",
				"Br C 2 H 2 O 2 -", s);
		s = xmlForm1.getFormattedString(Type.ELEMENT_WHITESPACE_COUNT,
				Sort.ALPHABETIC_ELEMENTS, false);
		Assert.assertEquals("no punct, ALPHABETIC_ELEMENTS, omit1",
				"Br 1 C 2 H 2 O 2 -", s);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLFormula.getFormattedString()'
	 */
	@Test
	public void testGetFormattedString() {
		String s = xomForm1.getFormattedString();
		Assert.assertEquals("xomForm1 string", "HNO3", s);

		s = xomForm2.getFormattedString();
		Assert.assertEquals("xomForm2 string", "HNO3", s);

		s = xomForm3.getFormattedString();
		Assert.assertEquals("xomForm3 string", "H3O7SCNa", s);

		s = xmlForm1.getFormattedString();
		Assert.assertEquals("xmlForm1 string", "C2H2BrO2-", s);

	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLFormula.getCalculatedMass(List, RealArray)'
	 */
	@Test
	public void testGetCalculatedMass() {
		CMLFormula f1 = null;
		try {
			f1 = CMLFormula.createFormula("C 2 H 3 Cl 1");
		} catch (RuntimeException e) {
			Assert.fail("should not throw " + e);
		}
		double d = f1.getCalculatedMolecularMass();
		Assert.assertEquals("Calculated mass ", 62.49822, d, 0.00000001);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLFormula.equalsFormula(Object)'
	 */
	@Test
	public void testEqualsFormula() {
		CMLFormula f1 = null;
		try {
			f1 = CMLFormula.createFormula("C 2 H 3 Cl 1");
		} catch (RuntimeException e) {
			Assert.fail("should not throw " + e);
		}
		CMLFormula f2 = null;
		try {
			f2 = CMLFormula.createFormula("C 2 H 3 Cl 1");
		} catch (RuntimeException e) {
			Assert.fail("should not throw " + e);
		}
		boolean ff = f1.equals(f2, 0.0001);
		Assert.assertTrue("equal formulae", ff);

	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLFormula.getDifference(CMLFormula)'
	 */
	@Test
	public void testGetDifference() {
		CMLFormula formula1 = null;
		try {
			formula1 = CMLFormula.createFormula("H 1 S 1 O 3",
					CMLFormula.Type.ELEMENT_WHITESPACE_COUNT);
		} catch (RuntimeException e) {
			Assert.fail("should not throw " + e);
		}
		formula1.setCount(3);
		formula1.setFormalCharge(-1);
		Assert.assertEquals("formula1 concise ", "H 1 O 3 S 1 -1", formula1
				.getConcise());
		Assert.assertEquals("formula1 charge ", -1, formula1.getFormalCharge());
		Assert.assertEquals("formula1 count ", 3, formula1.getCount(), EPS);

		CMLFormula formula2 = null;
		try {
			formula2 = CMLFormula.createFormula("Mg 1 O 6 H 12",
					CMLFormula.Type.ELEMENT_WHITESPACE_COUNT);
		} catch (RuntimeException e) {
			Assert.fail("should not throw " + e);
		}
		formula2.setFormalCharge(2);
		Assert.assertEquals("formula2 concise ", "H 12 Mg 1 O 6 2", formula2
				.getConcise());
		Assert.assertEquals("formula2 charge ", 2, formula2.getFormalCharge());
		Assert.assertEquals("formula2 count ", 1, formula2.getCount(), EPS);

		CMLFormula formulaDiff = formula1.getDifference(formula2);
		CMLFormula expectedDiff = CMLFormula.createFormula(
				"H -9.0 Mg -1.0 O 3.0 S 3.0 -5", true);
		assertEqualsConcise("difference ", expectedDiff, formulaDiff, 0.00001);
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLFormula.equalsAggregate(CMLFormula)'
	 * 
	 * @exception Exception
	 */
	@Test
	public void testEqualsAggregate() throws Exception {
		CMLFormula form1 = (CMLFormula)CMLXOMTestUtils.parseValidString("<formula "
				+ CMLConstants.CML_XMLNS + " concise='C 2 H 4'/>");
		CMLFormula form2 = (CMLFormula)CMLXOMTestUtils.parseValidString("<formula "
				+ CMLConstants.CML_XMLNS + " concise='C 2 H 4 O 1'/>");
		boolean equals = form1.equalsAggregate(form1);
		Assert.assertTrue("equality", equals);
		equals = form1.equalsAggregate(form2);
		Assert.assertFalse("equality", equals);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLFormula.toFormulaString()'
	 */
	@Test
	public void testToFormulaString() {
		CMLFormula f1 = null;
		try {
			f1 = CMLFormula.createFormula("C 2 H 3 Cl 1");
		} catch (RuntimeException e) {
			Assert.fail("should not throw " + e);
		}
		String formulaString = f1.toFormulaString();
		Assert.assertEquals("formula string", "count: 1.0; charge: 0: C(2.0)H(3.0)Cl",
				formulaString);
	}

	/** test */
	@Test
	public void testMultiplyBy() {
		CMLFormula f1 = null;
		try {
			f1 = CMLFormula.createFormula("C 1 H 1.5 Cl 0.5");
		} catch (RuntimeException e) {
			Assert.fail("should not throw " + e);
		}
		f1.multiplyBy(2.0);
		String f1S = f1.getConcise();
		Assert.assertEquals("multiplied formula ", "C 2 H 3 Cl 1", f1S);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLFormula.writeHTML(Writer)'
	 * 
	 * @exception Exception
	 */
	@Test
	public void testWriteHTML() throws Exception {
		StringWriter w = new StringWriter();
		xomForm1.writeHTML(w);
		String html = w.toString();
		w.close();
		Assert.assertEquals("html", "<span class='formula'>HO<sub>3</sub>N</span>",
				html);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLFormula.setConcise(String)'
	 */
	@Test
	public void testSetConcise() {
		Assert.assertEquals("concise", "H 1 O 3 N 1", xomForm1.getConcise());
		try {
			xomForm1.setConcise("H 2 O 1");
			Assert.fail("should throw 'Cannot reset concise if atomArray is present'");
		} catch (RuntimeException e) {
			Assert.assertEquals("cannot reset concise",
					"Cannot reset concise if atomArray is present", e
							.getMessage());
		}
		Assert.assertEquals("concise", "H 1 O 3 N 1", xomForm1.getConcise());
		CMLFormula form = new CMLFormula();
		form.setConcise("H 1 O 3 N 1");
		Assert.assertEquals("concise", "H 1 N 1 O 3", form.getConcise());
		try {
			form.setConcise("H 2 O 1");
			Assert.fail("should throw 'Cannot reset concise if atomArray is present'");
		} catch (RuntimeException e) {
			Assert.assertEquals("cannot reset concise",
					"Cannot reset concise if atomArray is present", e
							.getMessage());
		}
		Assert.assertEquals("concise", "H 1 N 1 O 3", form.getConcise());
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLFormula.CMLFormula(CMLMolecule)'
	 */
	@Test
	public void testCMLFormulaCMLMolecule() {
		CMLFormula form = new CMLFormula(fixture.xmlMolecule);
		Assert.assertEquals("concise", "C 1 H 3 F 1 N 1 O 1 S 1", form.getConcise());
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLFormula.normalize()'
	 * 
	 * @exception Exception
	 */
	@Test
	public void testNormalize() throws Exception {
		CMLFormula form1 = (CMLFormula)CMLXOMTestUtils.parseValidString("<formula "
				+ CMLConstants.CML_XMLNS + " concise='C 2 H 4'/>");
		form1.normalize();
		Assert.assertEquals("concise", "C 2 H 4", form1.getConcise());
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLFormula.generateConcise(CMLAtomArray, int)'
	 * 
	 * @exception Exception
	 */
	@Test
	public void testGenerateConcise() throws Exception {
		CMLAtomArray atomArray = new CMLAtomArray();
		// atomArray.setElementType(new String[]{AS.C.value, AS.H.value,
		// AS.O.value});
		// atomArray.setCount(new double[]{1, 4, 2});
		atomArray.setElementTypeAndCount(new String[] { AS.C.value, AS.H.value,
				AS.O.value }, new double[] { 1, 4, 2 });
		String concise = atomArray.generateConcise(-2);
		Assert.assertEquals("concise", "C 1 H 4 O 2 -2", concise);
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLFormula.removeChargeFromConcise(String)'
	 * 
	 * @exception Exception
	 */
	@Test
	public void testRemoveChargeFromConcise() throws Exception {
		String concise = CMLFormula.removeChargeFromConcise("C 2 H 4 O 2 -2");
		Assert.assertEquals("concise", "C 2 H 4 O 2", concise);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLFormula.getConciseNoCharge()'
	 * 
	 * @exception Exception
	 */
	@Test
	public void testGetConciseNoCharge() throws Exception {
		CMLFormula form1 = (CMLFormula)CMLXOMTestUtils.parseValidString("<formula "
				+ CMLConstants.CML_XMLNS + " concise='C 2 H 4 O 2 -2'/>");
		Assert.assertEquals("concise", "C 2 H 4 O 2", form1.getConciseNoCharge());
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLFormula.createFormula(String,
	 * Type)'
	 * 
	 * @exception Exception
	 */
	@Test
	public void testCreateFormulaStringType() throws Exception {
		CMLFormula form = CMLFormula.createFormula("C 2 H 4 O 2");
		Assert.assertEquals("concise", "C 2 H 4 O 2", form.getConcise());
		form = CMLFormula.createFormula("C 2 H 4 O 2 -1");
		Assert.assertEquals("concise", "C 2 H 4 O 2 -1", form.getConcise());
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLFormula.getCounts()'
	 * 
	 * @exception Exception
	 */
	@Test
	public void testGetCounts() throws Exception {
		CMLFormula form = CMLFormula.createFormula("C 2 H 4 O 2");
		DoubleTestBase.assertEquals("concise", new double[] { 2, 4, 2 }, form
				.getCounts(), EPS);
		form = CMLFormula.createFormula("C 2 H 4 O 2 -1");
		DoubleTestBase.assertEquals("concise", new double[] { 2, 4, 2 }, form
				.getCounts(), EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLFormula.getTotalAtomCount()'
	 * 
	 * @exception Exception
	 */
	@Test
	public void testGetTotalAtomCount() throws Exception{
		CMLFormula form1 = CMLFormula.createFormula("C2H10");
		Assert.assertEquals(form1.getTotalAtomCount(), 12.0, 0.0001);
		
		CMLFormula form2 = CMLFormula.createFormula("C2H10");
		CMLFormula diff = form1.getDifference((form2));
		Assert.assertEquals(0.0, diff.getTotalAtomCount(), 0.0001);
		
	}
	
	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLFormula.createAggregatedFormula(CMLFormula)'
	 * 
	 * @exception Exception
	 */
	@Test
	public void testCreateAggregatedFormula() throws Exception {
		CMLFormula form1 = (CMLFormula)CMLXOMTestUtils.parseValidString("<formula "
				+ CMLConstants.CML_XMLNS + " concise='C 2 H 4 O 2 -2'/>");
		CMLFormula form2 = (CMLFormula)CMLXOMTestUtils.parseValidString("<formula "
				+ CMLConstants.CML_XMLNS + " concise='C 3 H 3 Cl 3 1'/>");
		CMLFormula form3 = form1.createAggregatedFormula(form2);
		Assert.assertEquals("concise", "C 5 H 7 Cl 3 O 2 -1", form3.getConcise());
		CMLFormula form4 = (CMLFormula)CMLXOMTestUtils.parseValidString("<formula "
				+ CMLConstants.CML_XMLNS + " concise='C 3 H 3 Cl 3 -1' count='2'/>");
		form3 = form1.createAggregatedFormula(form4);
		Assert.assertEquals("concise", "C 8 H 10 Cl 6 O 2 -4", form3.getConcise());
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLFormula.getFormattedString(Type, Sort,
	 * boolean)'
	 * 
	 * @exception Exception
	 */
	@Test
	public void testGetFormattedStringTypeSortBoolean() throws Exception {
		CMLFormula form1 = (CMLFormula)CMLXOMTestUtils.parseValidString("<formula "
				+ CMLConstants.CML_XMLNS + " concise='C 1 H 4 O 2 Br 1 -2'/>");
		boolean omit1 = true;
		Sort sort = Sort.ALPHABETIC_ELEMENTS;
		String formS = form1.getFormattedString(Type.ELEMENT_COUNT_WHITESPACE,
				sort, omit1);
		Assert.assertEquals("formatted", "Br C H4 O2 --", formS);
		omit1 = false;
		formS = form1.getFormattedString(Type.ELEMENT_COUNT_WHITESPACE, sort,
				omit1);
		Assert.assertEquals("formatted", "Br1 C1 H4 O2 --", formS);
		sort = Sort.CHFIRST;
		omit1 = false;
		formS = form1.getFormattedString(Type.ELEMENT_COUNT_WHITESPACE, sort,
				omit1);
		Assert.assertEquals("formatted", "C1 H4 Br1 O2 --", formS);
		omit1 = true;
		formS = form1.getFormattedString(Type.ELEMENT_COUNT_WHITESPACE, sort,
				omit1);
		Assert.assertEquals("formatted", "C H4 Br O2 --", formS);
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLFormula.getFormalChargeString()'
	 * 
	 * @exception Exception
	 */
	@Test
	public void testGetFormalChargeString() throws Exception {
		CMLFormula form1 = (CMLFormula)CMLXOMTestUtils.parseValidString("<formula "
				+ CMLConstants.CML_XMLNS + " concise='C 1 H 4 O 2 Br 1 -2'/>");
		String formS = form1.getFormalChargeString();
		Assert.assertEquals("formatted", "--", formS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLFormula.equals(CMLFormula,
	 * double)'
	 * 
	 * @exception Exception
	 */
	@Test
	public void testEqualsCMLFormulaDouble() throws Exception {
		CMLFormula form1 = (CMLFormula)CMLXOMTestUtils.parseValidString("<formula "
				+ CMLConstants.CML_XMLNS + " concise='C 1 H 4 O 2 Br 1 -2'/>");
		CMLFormula form2 = (CMLFormula)CMLXOMTestUtils.parseValidString("<formula "
				+ CMLConstants.CML_XMLNS + " concise='C 1.001 H 3.99 O 2 Br 1 -2'/>");
		Assert.assertFalse("equals", form1.equals(form2, 0.001));
		Assert.assertTrue("equals", form1.equals(form2, 0.011));
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLFormula.equalsConcise(CMLFormula, double)'
	 * 
	 * @exception Exception
	 */
	@Test
	public void testEqualsConcise() throws Exception {
		CMLFormula form1 = (CMLFormula)CMLXOMTestUtils.parseValidString("<formula "
				+ CMLConstants.CML_XMLNS + " concise='C 1 H 4 O 2 Br 1 -2'/>");
		CMLFormula form2 = (CMLFormula)CMLXOMTestUtils.parseValidString("<formula "
				+ CMLConstants.CML_XMLNS + " concise='C 1.001 H 3.99 O 2 Br 1 -2'/>");
		Assert.assertTrue("equals", form1.equals(form1));
		Assert.assertFalse("equals", form1.equals(form2));
	}

	/**
	 * checks that finishMakingElement does not throw exception
	 */
	@Test
	public void testReadFormula() {
		String s = ""+
		"<?xml version='1.0' encoding='ISO-8859-1'?>"+
		"<cml:molecule convention='PoLyInfo' id='M2333382' xmlns:cml='http://www.xml-cml.org/schema'>"+
		"    <cml:formula inline='C34H34N2O2'/>"+
		"    <cml:formula inline='C1(C2)C(c4ccc(Oc6ccc(N)cc6)cc4)(c5ccc(Oc7ccc(N)cc7)cc5)C(C3)CC2CC3C1' convention='SMILES'/>"+
		"</cml:molecule>";
		try {
			new CMLBuilder().build(new StringReader(s));
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Should not fail parse"+e.getMessage());
		}
	}
	
	
	@Test
	public void testNullCreateFromMoleculeFactory(){
		CMLMolecule mol = null;
		CMLFormula form = CMLFormula.createFormula(mol);
		Assert.assertNull(form);
	}
	@Test
	public void testEmptyCreateFromMoleculeFactory(){
		CMLMolecule mol = new CMLMolecule();
		CMLFormula form = CMLFormula.createFormula(mol);
		Assert.assertNotNull(form);
		Assert.assertEquals(0.0, form.getTotalAtomCount(), 0.0001);
	}
	@Test
	public void testCreateFromMoleculeFactory(){
		CMLMolecule mol = new CMLMolecule();
		mol.addAtom(new CMLAtom("a1", ChemicalElement.AS.C));
		CMLFormula form = CMLFormula.createFormula(mol);
		Assert.assertNotNull(form);
		Assert.assertEquals(1.0, form.getTotalAtomCount(), 0.0001);
	}
	
	@Test
	public void test2LetterElements() {
		CMLFormula formula = CMLFormula.createFormula("H 6 O 2 Cl 2 R 4");
		String formulaS = formula.getConcise();
		Assert.assertEquals("2LetterTest", "H 6 Cl 2 O 2 R 4", formulaS);
	}
	
	@Test
	public void test2LetterElements1() {
		CMLFormula formula = CMLFormula.createFormula("H 6 Xe 1 O 2 Cl 2 R 4 B 3 Sn 4");
		String formulaS = formula.getConcise();
		Assert.assertEquals("2LetterTest", "H 6 B 3 Cl 2 O 2 R 4 Sn 4 Xe 1", formulaS);
	}
	
	@Test
	public void testConciseCharge() {
		CMLFormula formula = new CMLFormula();
		formula.setConcise("H 4 O 2 C 3 -1");
//		formula.debug();
		String expectedFormulaS = "<formula formalCharge='-1' concise='C 3 H 4 O 2 -1' xmlns='http://www.xml-cml.org/schema'>" +
				"<atomArray elementType='C H O' count='3.0 4.0 2.0'/>" +
				"</formula>";
		CMLXOMTestUtils.assertEqualsCanonically("concise", CMLXOMTestUtils.parseValidString(expectedFormulaS), formula, true);
		String formulaS = formula.getConcise();
		Assert.assertEquals("negative", "C 3 H 4 O 2 -1", formulaS);
	}
	
	@Test
	public void testNegativeElements() {
		CMLFormula formula = new CMLFormula();
		formula.setConcise("H 4 O -2 C 3");
		Assert.assertFalse("negative", formula.isAllowNegativeCounts());
		String formulaS = formula.getConcise();
		Assert.assertEquals("negative", "C 3 H 4 O -2", formulaS);
	}
	
	@Test
	public void testNegativeElements1() {
		CMLFormula formula = new CMLFormula();
		formula.setConcise("H 4 O -2 C 3 -3");
//		formula.debug();
		String formulaS = formula.getConcise();
		Assert.assertEquals("negative", "C 3 H 4 O -2 -3", formulaS);
	}
	
	@Test
	public void testCreateConcise() {
		CMLFormula formula = CMLFormula.createFormula("H 4 O 2 C 3", Type.CONCISE);
		String formulaS = formula.getConcise();
		Assert.assertEquals("Concise", "C 3 H 4 O 2", formulaS);
	}
	
}
