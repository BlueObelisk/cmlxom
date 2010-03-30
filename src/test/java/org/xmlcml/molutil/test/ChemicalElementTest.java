package org.xmlcml.molutil.test;

import static org.xmlcml.euclid.EuclidConstants.*;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.xmlcml.euclid.test.DoubleTestBase;
import org.xmlcml.euclid.test.IntTest;
import org.xmlcml.molutil.ChemicalElement;
import org.xmlcml.molutil.ChemicalElement.AS;

/**
 * tests Chemical Element.
 * 
 * @author pmr
 * 
 */
public class ChemicalElementTest {

	/**
	 * Test method for 'org.xmlcml.molutil.ChemicalElement initialisation'
	 */
	@Test
	public void testInit() {
		Assert.assertNotNull("init", ChemicalElement.periodicTable);
		Assert.assertEquals("init", ChemicalElement.MAXELEM,
				ChemicalElement.periodicTable.length);
	}

	/**
	 * Test method for
	 * 'org.xmlcml.molutil.ChemicalElement.ChemicalElement(String, int, double)'
	 */
	@Test
	public void testChemicalElement() {
		ChemicalElement el = new ChemicalElement("Yz", 123, 299.99);
		Assert.assertNotNull("new", el);
		Assert.assertEquals("new", "Yz", el.getSymbol());
	}

	/**
	 * Test method for 'org.xmlcml.molutil.ChemicalElement.getSymbol()'
	 */
	@Test
	public void testGetSymbol() {
		ChemicalElement el = new ChemicalElement("Yz", 123, 299.99);
		Assert.assertNotNull("new", el);
		Assert.assertEquals("new", "Yz", el.getSymbol());
		el = ChemicalElement.getChemicalElement(AS.C.value);
		Assert.assertEquals("get", AS.C.value, el.getSymbol());
	}

	/**
	 * Test method for 'org.xmlcml.molutil.ChemicalElement.getAtomicNumber()'
	 */
	@Test
	public void testGetAtomicNumber() {
		ChemicalElement el = new ChemicalElement("Yz", 123, 299.99);
		Assert.assertNotNull("new", el);
		Assert.assertEquals("new", 123, el.getAtomicNumber());
		el = ChemicalElement.getChemicalElement(AS.C.value);
		Assert.assertEquals("get", 6, el.getAtomicNumber());
	}

	/**
	 * Test method for 'org.xmlcml.molutil.ChemicalElement.getAtomicWeight()'
	 */
	@Test
	public void testGetAtomicWeight() {
		ChemicalElement el = new ChemicalElement("Yz", 123, 299.99);
		Assert.assertNotNull("new", el);
		Assert.assertEquals("new", 299.99, el.getAtomicWeight(), EPS);
		el = ChemicalElement.getChemicalElement(AS.C.value);
		// FIXME
		Assert.assertEquals("get", 12.0107, el.getAtomicWeight());
	}

	/**
	 * Test method for 'org.xmlcml.molutil.ChemicalElement.getGroup()'
	 */
	@Test
	public void testGetGroup() {
		ChemicalElement el = new ChemicalElement("Yz", 123, 299.99);
		Assert.assertNotNull("new", el);
		Assert.assertEquals("new", 0, el.getGroup());
		el = ChemicalElement.getChemicalElement(AS.C.value);
		Assert.assertEquals("get", 14, el.getGroup());
	}

	/**
	 * Test method for 'org.xmlcml.molutil.ChemicalElement.getPeriod()'
	 */
	@Test
	public void testGetPeriod() {
		ChemicalElement el = new ChemicalElement("Yz", 123, 299.99);
		Assert.assertNotNull("new", el);
		Assert.assertEquals("new", 0, el.getPeriod());
		el = ChemicalElement.getChemicalElement(AS.H.value);
		Assert.assertEquals("get", 1, el.getPeriod());
		el = ChemicalElement.getChemicalElement(AS.C.value);
		Assert.assertEquals("get", 2, el.getPeriod());

	}

	/**
	 * Test method for
	 * 'org.xmlcml.molutil.ChemicalElement.getElectronicGroundState()'
	 */
	@Test
	public void testGetElectronicGroundState() {
		ChemicalElement el = new ChemicalElement("Yz", 123, 299.99);
		Assert.assertNotNull("new", el);
		Assert.assertNull("new", el.getElectronicGroundState());
		el = ChemicalElement.getChemicalElement(AS.C.value);
		Assert.assertEquals("get", "[He].2s2.2p2", el
				.getElectronicGroundState());

	}

	/**
	 * Test method for 'org.xmlcml.molutil.ChemicalElement.setIsotopes(int[],
	 * double[])'
	 */
	@Test
	public void testSetIsotopes() {
		ChemicalElement el = new ChemicalElement("Yz", 123, 299.99);
		Assert.assertNotNull("iso", el);
		int[] iso = el.getIsotopeMasses();
		Assert.assertNull("iso", iso);
		int[] masses = { 11, 12, 13, 14 };
		double[] abundances = { 0.0001, 98.9, 1.01, 0.0001 };
		el.setIsotopes(masses, abundances);
		iso = el.getIsotopeMasses();
		Assert.assertNotNull("iso", iso);
		Assert.assertEquals("iso", 4, iso.length);
		IntTest.assertEquals("iso", new int[] { 11, 12, 13, 14 }, iso);
		double[] dd = el.getIsotopeAbundances();
		Assert.assertNotNull("iso", dd);
		Assert.assertEquals("iso", 4, dd.length);
		DoubleTestBase.assertEquals("iso", new double[] { 0.0001, 98.9, 1.01,
				0.0001 }, dd, EPS);
		masses = new int[] { 1, 2, 3 };
		abundances = new double[] { .2, .3, .5 };
		el.setIsotopes(masses, abundances);
		iso = el.getIsotopeMasses();
		Assert.assertNotNull("iso", iso);
		Assert.assertEquals("iso", 3, iso.length);
		IntTest.assertEquals("iso", new int[] { 1, 2, 3 }, iso);
		dd = el.getIsotopeAbundances();
		Assert.assertNotNull("iso", dd);
		Assert.assertEquals("iso", 3, dd.length);
		DoubleTestBase
				.assertEquals("iso", new double[] { .2, .3, .5 }, dd, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.molutil.ChemicalElement.getIsotopeMasses()'
	 */
	@Test
	public void testGetIsotopeMasses() {
		ChemicalElement el = new ChemicalElement("Yz", 123, 299.99);
		Assert.assertNotNull("iso", el);
		int[] iso = el.getIsotopeMasses();
		Assert.assertNull("iso", iso);
		el = ChemicalElement.getChemicalElement(AS.C.value);
		iso = el.getIsotopeMasses();
		Assert.assertNotNull("iso", iso);
		Assert.assertEquals("iso", 2, iso.length);
		IntTest.assertEquals("iso", new int[] { 12, 13 }, iso);
	}

	/**
	 * Test method for
	 * 'org.xmlcml.molutil.ChemicalElement.getIsotopeAbundances()'
	 */
	@Test
	public void testGetIsotopeAbundances() {
		ChemicalElement el = new ChemicalElement("Yz", 123, 299.99);
		Assert.assertNotNull("iso", el);
		double[] iso = el.getIsotopeAbundances();
		Assert.assertNull("iso", iso);
		el = ChemicalElement.getChemicalElement(AS.C.value);
		iso = el.getIsotopeAbundances();
		Assert.assertNotNull("iso", iso);
		Assert.assertEquals("iso", 2, iso.length);
		DoubleTestBase.assertEquals("iso", new double[] { 98.93, 1.07 }, iso,
				EPS);
	}
	
	@Test
	public void getIsotopePreciseMassesNotSet() {
		ChemicalElement el = new ChemicalElement("Yz", 123, 299.99);
		Assert.assertNotNull("iso", el);
		double[] iso = el.getIsotopePreciseMasses();
		Assert.assertNull("iso", iso);
	}
		
	@Test
	public void getIsotopePreciseMassesCarbon() {
		ChemicalElement el = ChemicalElement.getChemicalElement(AS.C.value);
		double [] iso = el.getIsotopePreciseMasses();
		Assert.assertNotNull("iso", iso);
		Assert.assertEquals("iso", 2, iso.length);
		DoubleTestBase.assertEquals("iso", new double[] { 12.000000, 13.003354 }, iso, EPS);
	}
	
	@Test
	public void getIsotopePreciseMassesHydrogen() {
		ChemicalElement el = ChemicalElement.getChemicalElement(AS.H.value);
		double [] iso = el.getIsotopePreciseMasses();
		Assert.assertNotNull("iso", iso);
		Assert.assertEquals("iso", 2, iso.length);
		DoubleTestBase.assertEquals("iso", new double[] { 1.007825032, 2.014101778 }, iso, EPS);
	}
	
	@Test
	public void getIsotopePreciseMassesNotSpecified() {
		//will need to be changed to a different element if the precise masses for
		//Uranium are ever added to elementdata.xml
		ChemicalElement el = ChemicalElement.getChemicalElement("U");
		double [] iso = el.getIsotopePreciseMasses();
		Assert.assertEquals(3, iso.length);
		for (double d : iso) {
			Assert.assertTrue(Double.isNaN(d));
		}
	}

	/**
	 * Test method for 'org.xmlcml.molutil.ChemicalElement.getMainIsotope()'
	 */
	@Test
	public void testGetMainIsotope() {
		ChemicalElement el = ChemicalElement.getChemicalElement(AS.C.value);
		int iso = el.getMainIsotope();
		Assert.assertEquals("iso", 12, iso);
	}

	/**
	 * Test method for
	 * 'org.xmlcml.molutil.ChemicalElement.setCovalentRadius(double)'
	 */
	@Test
	public void testSetCovalentRadius() {
		ChemicalElement el = new ChemicalElement("Yz", 123, 299.99);
		Assert.assertNotNull("iso", el);
		Assert.assertEquals("covrad", 1.4, el.getCovalentRadius(), EPS);
		el.setCovalentRadius(1.8);
		Assert.assertEquals("covrad", 1.8, el.getCovalentRadius(), EPS);

	}

	/**
	 * Test method for 'org.xmlcml.molutil.ChemicalElement.getCovalentRadius()'
	 */
	@Test
	public void testGetCovalentRadius() {
		ChemicalElement el = new ChemicalElement("Yz", 123, 299.99);
		Assert.assertNotNull("covrad", el);
		Assert.assertEquals("covrad", 1.4, el.getCovalentRadius(), EPS);
		el = ChemicalElement.getChemicalElement(AS.C.value);
		Assert.assertEquals("covrad", 0.77, el.getCovalentRadius());

	}

	/**
	 * Test method for
	 * 'org.xmlcml.molutil.ChemicalElement.setAtomicRadius(double)'
	 */
	@Test
	public void testSetAtomicRadius() {
		ChemicalElement el = new ChemicalElement("Yz", 123, 299.99);
		Assert.assertNotNull("iso", el);
		Assert.assertEquals("covrad", 1.6, el.getAtomicRadius(), EPS);
		el.setAtomicRadius(1.2);
		Assert.assertEquals("covrad", 1.2, el.getAtomicRadius(), EPS);
	}

	/**
	 * Test method for 'org.xmlcml.molutil.ChemicalElement.getAtomicRadius()'
	 */
	@Test
	public void testGetAtomicRadius() {
		ChemicalElement el = ChemicalElement.getChemicalElement(AS.C.value);
		double en = el.getVDWRadius();
		Assert.assertEquals("get", 1.7, en, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.molutil.ChemicalElement.setVDWRadius(double)'
	 */
	@Test
	public void testSetVDWRadius() {
		ChemicalElement el = new ChemicalElement("Yz", 123, 299.99);
		Assert.assertNotNull("iso", el);
		Assert.assertEquals("covrad", 2.0, el.getVDWRadius(), EPS);
		el.setVDWRadius(1.2);
		Assert.assertEquals("covrad", 1.2, el.getVDWRadius(), EPS);
	}

	/**
	 * Test method for 'org.xmlcml.molutil.ChemicalElement.getVDWRadius()'
	 */
	@Test
	public void testGetVDWRadius() {
		ChemicalElement el = ChemicalElement.getChemicalElement(AS.C.value);
		double en = el.getVDWRadius();
		Assert.assertEquals("get", 1.7, en, EPS);
	}

	/**
	 * Test method for
	 * 'org.xmlcml.molutil.ChemicalElement.setElectronegativity(double)'
	 */
	@Test
	public void testSetElectronegativity() {
		ChemicalElement el = new ChemicalElement("Yz", 123, 299.99);
		Assert.assertNotNull("iso", el);
		Assert.assertEquals("covrad", 0.0, el.getElectronegativity(), EPS);
		el.setElectronegativity(2.3);
		Assert.assertEquals("covrad", 2.3, el.getElectronegativity(), EPS);
	}

	/**
	 * Test method for
	 * 'org.xmlcml.molutil.ChemicalElement.getElectronegativity()'
	 */
	@Test
	public void testGetElectronegativity() {
		ChemicalElement el = ChemicalElement.getChemicalElement(AS.C.value);
		double en = el.getElectronegativity();
		Assert.assertEquals("get", 2.55, en, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.molutil.ChemicalElement.setColor(Color)'
	 */
	@Test
	public void testSetColor() {
		ChemicalElement el = new ChemicalElement("Yz", 123, 299.99);
		Assert.assertNotNull("col", el);
		Color col = el.getColor();
		Assert.assertNull("col", col);
		el.setColor(Color.red);
		Assert.assertEquals("col", true, Color.red.equals(el.getColor()));

	}

	/**
	 * Test method for 'org.xmlcml.molutil.ChemicalElement.getColor()'
	 */
	@Test
	public void testGetColor() {
		ChemicalElement el = ChemicalElement.getChemicalElement(AS.C.value);
		Color col = el.getColor();
		Assert.assertEquals("get", true, col.equals(new Color(128, 128, 128)));
	}

	/**
	 * Test method for 'org.xmlcml.molutil.ChemicalElement.getColorString()'
	 */
	@Test
	public void testGetColorString() {
		ChemicalElement el = ChemicalElement.getChemicalElement(AS.C.value);
		Assert.assertEquals("get", "#808080", el.getColorString());
	}

	/**
	 * Test method for
	 * 'org.xmlcml.molutil.ChemicalElement.getValenceElectrons()'
	 */
	@Test
	public void testGetValenceElectrons() {
		ChemicalElement el = ChemicalElement.getChemicalElement(AS.C.value);
		Assert.assertEquals("get", 4, el.getValenceElectrons());
	}

	/**
	 * Test method for 'org.xmlcml.molutil.ChemicalElement.toString()'
	 */
	@Test
	public void testToString() {
		ChemicalElement el = ChemicalElement.getChemicalElement(AS.C.value);
		Assert.assertEquals("get", "C: 12.0107", el.toString());
	}

	/**
	 * Test method for
	 * 'org.xmlcml.molutil.ChemicalElement.getChemicalElement(String)'
	 */
	@Test
	public void testGetChemicalElement() {
		ChemicalElement el = ChemicalElement.getChemicalElement(AS.C.value);
		Assert.assertEquals("get", AS.C.value, el.getSymbol());
		el = ChemicalElement.getChemicalElement("CA");
		Assert.assertNull("get", el);
		el = ChemicalElement.getChemicalElement("Dummy");
		Assert.assertNotNull("get", el);
		Assert.assertEquals("get", "Dummy", el.getSymbol());
	}

	/**
	 * Test method for 'org.xmlcml.molutil.ChemicalElement.getElement(int)'
	 */
	@Test
	public void testGetElement() {
		ChemicalElement el = ChemicalElement.getElement(6);
		Assert.assertEquals("get", AS.C.value, el.getSymbol());
		el = ChemicalElement.getElement(0);
		Assert.assertNull("elem", el);
		el = ChemicalElement.getElement(1000);
		Assert.assertNull("elem", el);
		el = ChemicalElement.getElement(ChemicalElement.MAXELEM);
		Assert.assertNull("elem", el);
	}

	/**
	 * Test method for
	 * 'org.xmlcml.molutil.ChemicalElement.getBondingRadiusTolerance()'
	 */
	@Test
	public void testGetSetBondingRadiusTolerance() {
		double rad = ChemicalElement.getBondingRadiusTolerance();
		Assert.assertEquals("default tolerance", 0.2, rad, EPS);
		ChemicalElement.setBondingRadiusTolerance(0.3);
		rad = ChemicalElement.getBondingRadiusTolerance();
		Assert.assertEquals("default tolerance", 0.3, rad, EPS);
	}

	/**
	 * tests grabChemicalElement(String s).
	 * 
	 */
	@Test
	public void testGrabChemicalElementString() {
		ChemicalElement elem = ChemicalElement.grabChemicalElement("He");
		Assert.assertNotNull("helium", elem);
		Assert.assertEquals("helium 2", 2, elem.getAtomicNumber());

		elem = ChemicalElement.grabChemicalElement("Qxz");
		Assert.assertNull("qxz", elem);

		elem = ChemicalElement.grabChemicalElement(AS.H.value);
		Assert.assertNotNull("hydrogen", elem);
		Assert.assertEquals(AS.H.value, 1, elem.getAtomicNumber());

		elem = ChemicalElement.grabChemicalElement("Hx");
		Assert.assertNotNull("hydrogen", elem);
		Assert.assertEquals("Hx", 1, elem.getAtomicNumber());

		elem = ChemicalElement.grabChemicalElement("z");
		Assert.assertNull("z", elem);

		elem = ChemicalElement.grabChemicalElement(S_EMPTY);
		Assert.assertNull("empty", elem);

		String s = "HeCClNBr";
		List<ChemicalElement> elemList = new ArrayList<ChemicalElement>();
		while (s.length() > 0) {
			elem = ChemicalElement.grabChemicalElement(s);
			Assert.assertNotNull("concat:" + s, elem);
			s = s.substring(elem.getSymbol().length());
			elemList.add(elem);
		}
		Assert.assertEquals("elements ", 5, elemList.size());
		Assert.assertEquals("elem 0", 2, elemList.get(0).getAtomicNumber());
		Assert.assertEquals("elem 1", 6, elemList.get(1).getAtomicNumber());
		Assert.assertEquals("elem 2", 17, elemList.get(2).getAtomicNumber());
		Assert.assertEquals("elem 3", 7, elemList.get(3).getAtomicNumber());
		Assert.assertEquals("elem 4", 35, elemList.get(4).getAtomicNumber());
	}

}
