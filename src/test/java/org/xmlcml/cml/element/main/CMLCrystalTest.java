package org.xmlcml.cml.element.main;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.xmlcml.cml.base.CMLElements;
import org.xmlcml.cml.element.CMLCellParameter;
import org.xmlcml.cml.element.CMLCrystal;
import org.xmlcml.cml.element.CMLLattice;
import org.xmlcml.cml.element.CMLLatticeVector;
import org.xmlcml.cml.element.CMLScalar;
import org.xmlcml.cml.element.CMLSymmetry;
import org.xmlcml.cml.element.CMLVector3;
import org.xmlcml.cml.element.CMLCrystal.Centering;
import org.xmlcml.euclid.RealSquareMatrix;
import org.xmlcml.euclid.test.DoubleTestBase;
import org.xmlcml.euclid.test.RealSquareMatrixTest;
import static org.xmlcml.cml.base.CMLConstants.*;
import static org.xmlcml.cml.base.BaseTest.*;
import static org.xmlcml.euclid.EuclidConstants.*;
import static org.xmlcml.cml.element.main.AbstractTestBase.*;

/**
 * test for CMLCrystal.
 * 
 * @author pmr
 * 
 */
public class CMLCrystalTest {

	CMLCrystal crystal1;

	CMLCrystal crystal2;

	CMLCrystal crystal3;

	String crystal1S = "" + "<crystal z='4' " + CML_XMLNS + ">"
			+ "<scalar id='sc1' dictRef='cml:a' errorValue='0.001' units='"
			+ U_ANGSTROM + "'" + S_SPACE + CML_XMLNS + ">4.500</scalar>"
			+ "<scalar id='sc2' dictRef='cml:b' errorValue='0.001' units='"
			+ U_ANGSTROM + "'" + S_SPACE + CML_XMLNS + ">4.500</scalar>"
			+ "<scalar id='sc3' dictRef='cml:c' errorValue='0.001' units='"
			+ U_ANGSTROM + "'" + S_SPACE + CML_XMLNS + ">4.500</scalar>"
			+ "<scalar id='sc4' dictRef='cml:alpha' units='" + U_DEGREE + "' "
			+ CML_XMLNS + ">90</scalar>"
			+ "<scalar id='sc5' dictRef='cml:beta' units='" + U_DEGREE + "' "
			+ CML_XMLNS + ">90</scalar>"
			+ "<scalar id='sc6' dictRef='cml:gamma' units='" + U_DEGREE + "' "
			+ CML_XMLNS + ">90</scalar>"
			+ "<symmetry id='s1' spaceGroup='Fm3m' " + CML_XMLNS + "/>"
			+ "</crystal>" + "";

	String crystal2S = "" + "<crystal " + CML_XMLNS + ">"
			+ "<scalar id='sc1' dictRef='cml:a' units='" + U_ANGSTROM + "'"
			+ S_SPACE + CML_XMLNS + ">8</scalar>"
			+ "<scalar id='sc2' dictRef='cml:b' units='" + U_ANGSTROM + "'"
			+ S_SPACE + CML_XMLNS + ">9</scalar>"
			+ "<scalar id='sc3' dictRef='cml:c' units='" + U_ANGSTROM + "'"
			+ S_SPACE + CML_XMLNS + ">10</scalar>"
			+ "<scalar id='sc4' dictRef='cml:alpha' units='" + U_DEGREE + "' "
			+ CML_XMLNS + ">80</scalar>"
			+ "<scalar id='sc5' dictRef='cml:beta' units='" + U_DEGREE + "' "
			+ CML_XMLNS + ">90</scalar>"
			+ "<scalar id='sc6' dictRef='cml:gamma' units='" + U_DEGREE + "' "
			+ CML_XMLNS + ">100</scalar>" + "</crystal>" + "";

	String crystal3S = "" + "<crystal " + CML_XMLNS + ">"
			+ "<scalar id='sc1' dictRef='cml:a' units='" + U_ANGSTROM + "'"
			+ S_SPACE + CML_XMLNS + ">8</scalar>"
			+ "<scalar id='sc2' dictRef='cml:b' units='" + U_ANGSTROM + "'"
			+ S_SPACE + CML_XMLNS + ">9</scalar>"
			+ "<scalar id='sc3' dictRef='cml:c' units='" + U_ANGSTROM + "'"
			+ S_SPACE + CML_XMLNS + ">10</scalar>"
			+ "<scalar id='sc4' dictRef='cml:alpha' units='" + U_DEGREE + "' "
			+ CML_XMLNS + ">90</scalar>"
			+ "<scalar id='sc5' dictRef='cml:beta' units='" + U_DEGREE + "' "
			+ CML_XMLNS + ">90</scalar>"
			+ "<scalar id='sc6' dictRef='cml:gamma' units='" + U_DEGREE + "' "
			+ CML_XMLNS + ">90</scalar>" + "</crystal>" + "";

	String lattice1S = "" + "<lattice " + CML_XMLNS + ">"
			+ "<latticeVector id='l1' dictRef='cml:a' units='" + U_ANGSTROM
			+ "'" + S_SPACE + CML_XMLNS + ">8 0 0</latticeVector>"
			+ "<latticeVector id='l2' dictRef='cml:b' units='" + U_ANGSTROM
			+ "'" + S_SPACE + CML_XMLNS + ">0 9 0</latticeVector>"
			+ "<latticeVector id='l3' dictRef='cml:c' units='" + U_ANGSTROM
			+ "'" + S_SPACE + CML_XMLNS + ">0 0 10</latticeVector>"
			+ "</lattice>" + "";

	String lattice2S = "" + "<lattice " + CML_XMLNS + ">"
			+ "<latticeVector id='l1' dictRef='cml:a' units='" + U_ANGSTROM
			+ "'" + S_SPACE + CML_XMLNS + ">8 4 0</latticeVector>"
			+ "<latticeVector id='l2' dictRef='cml:b' units='" + U_ANGSTROM
			+ "'" + S_SPACE + CML_XMLNS + ">0 9 0</latticeVector>"
			+ "<latticeVector id='l3' dictRef='cml:c' units='" + U_ANGSTROM
			+ "'" + S_SPACE + CML_XMLNS + ">0 0 10</latticeVector>"
			+ "</lattice>" + "";
	CMLLattice lattice1;
	CMLLattice lattice2;
	CMLElements<CMLLatticeVector> latticeVectorList1 = null;

	/**
	 * setup.
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		crystal1 = (CMLCrystal) parseValidString(crystal1S);
		crystal2 = (CMLCrystal) parseValidString(crystal2S);
		crystal3 = (CMLCrystal) parseValidString(crystal3S);
	}

	private void makeLattice() {

		lattice1 = (CMLLattice) parseValidString(lattice1S);
		lattice2 = (CMLLattice) parseValidString(lattice2S);
		latticeVectorList1 = lattice1.getLatticeVectorElements();
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLCrystal.CMLCrystal()'
	 */
	@Test
	@Deprecated
	public void testCMLCrystal() {
		crystal2 = new CMLCrystal();
		try {
			crystal2.getCellScalars();
			Assert.fail("should throw");
			// } catch (CMLException e) {
			// Assert.fail("should not throw "+e);
		} catch (RuntimeException e) {
		}
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLCrystal.CMLCrystal(CMLCrystal)'
	 */
	@Test
	public void testCMLCrystalCMLCrystal() {
		CMLCrystal crystal = new CMLCrystal(crystal1);
		assertEqualsCanonically("copy crystal", crystal, crystal1);
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLCrystal.getOrthogonalizationMatrix()'
	 */
	@Test
	public void testGetOrthogonalizationMatrix() {
		RealSquareMatrix matrix = crystal1.getOrthogonalizationMatrix();
		RealSquareMatrixTest.assertEquals("matrix contents ", 3, new double[] {
				4.5, 0.0, 0.0, 0.0, 4.5, 0.0, 0.0, 0.0, 4.5 }, matrix, EPS);
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLCrystal.setCellParameters(double, double,
	 * double, double, double, double)'
	 */
	@Test
	@Deprecated
	public void testSetCellParametersDoubleDoubleDoubleDoubleDoubleDouble() {
		crystal1.setCellParameters(10, 11, 12, 80, 90, 100);
		List<CMLScalar> cell = null;
		cell = crystal1.getCellScalars();
		// } catch (CMLException e) {
		// Assert.fail("should not throw "+e);
		Assert.assertNotNull("cell params should not be null", cell);
		Assert.assertNotNull("cell param a should not be null", cell.get(0));
		Assert
				.assertEquals("a dictRef", CMLCrystal.A, cell.get(0)
						.getDictRef());
		Assert.assertEquals("a", 10, cell.get(0).getDouble(), EPS);
		RealSquareMatrix matrix = crystal1.getOrthogonalizationMatrix();
		RealSquareMatrixTest.assertEquals("matrix contents ", 3, new double[] {
				9.8433, 0.0, 0.0, -1.7632, 10.8329, 0.0, 0.0, 1.9101, 12.0 },
				matrix, 0.0001);
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLCrystal.setCellParameters(double[])'
	 */
	@Test
	@Deprecated
	public void testSetCellParametersDoubleArray() {
		crystal1.setCellParameters(new double[] { 10, 11, 12, 80, 90, 100 });
		List<CMLScalar> cell = crystal1.getCellScalars();
		Assert.assertNotNull("cell params should not be null", cell);
		Assert.assertNotNull("cell param a should not be null", cell.get(0));
		Assert
				.assertEquals("a dictRef", CMLCrystal.A, cell.get(0)
						.getDictRef());
		Assert.assertEquals("a", 10, cell.get(0).getDouble(), EPS);
		RealSquareMatrix matrix = crystal1.getOrthogonalizationMatrix();
		RealSquareMatrixTest.assertEquals("matrix contents ", 3, new double[] {
				9.8433, 0.0, 0.0, -1.7632, 10.8329, 0.0, 0.0, 1.9101, 12.0 },
				matrix, 0.0001);

		crystal2 = new CMLCrystal();
		crystal2.setCellParameters(new double[] { 10, 11, 12, 80, 90, 100 });
		cell = crystal2.getCellScalars();
		Assert.assertNotNull("cell params should not be null", cell);
		Assert.assertNotNull("cell param a should not be null", cell.get(0));
		Assert
				.assertEquals("a dictRef", CMLCrystal.A, cell.get(0)
						.getDictRef());
		Assert.assertEquals("a", 10, cell.get(0).getDouble(), EPS);
		matrix = crystal1.getOrthogonalizationMatrix();
		RealSquareMatrixTest.assertEquals("matrix contents ", 3, new double[] {
				9.8433, 0.0, 0.0, -1.7632, 10.8329, 0.0, 0.0, 1.9101, 12.0 },
				matrix, 0.0001);
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLCrystal.getCellParameterValues()'
	 */
	@Test
	public void testGetCellParameterValues() {
		double[] cell = crystal1.getCellParameterValues();
		DoubleTestBase.assertEquals("cell contents ", new double[] { 4.5, 4.5,
				4.5, 90., 90, 90 }, cell, EPS);
		crystal1.setCellParameters(new double[] { 10, 11, 12, 80, 90, 100 });
		cell = crystal1.getCellParameterValues();
		DoubleTestBase.assertEquals("cell contents ", new double[] { 10, 11,
				12, 80, 90, 100 }, cell, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLCrystal.getCellScalars()'
	 */
	@Test
	public void testGetCellScalars() {
		double[] param = crystal2.getCellParameterValues();
		DoubleTestBase.assertEquals("cell params", new double[] { 8., 9., 10.,
				80., 90., 100. }, param, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLCrystal.getLattice()'
	 */
	@Test
	public void testGetLattice() {
		CMLLattice lattice = crystal2.getLattice();
		CMLLatticeVector a = lattice.getLatticeVectorElements().get(0);
		CMLLatticeVectorTest.assertEquals("a", new double[] {
				7.874653194646171, -1.4106158456677196, 0. }, a, EPS);
		CMLLatticeVector b = lattice.getLatticeVectorElements().get(1);
		CMLLatticeVectorTest.assertEquals("b", new double[] { 0,
				8.863269777109872, 1.5628335990023738 }, b, EPS);
		CMLLatticeVector c = lattice.getLatticeVectorElements().get(2);
		CMLLatticeVectorTest.assertEquals("c", new double[] { 0, 0., 10. }, c,
				EPS);

		Assert.assertEquals("length a", 8., a.getCMLVector3().getLength(), EPS);
		Assert.assertEquals("length b", 9., b.getCMLVector3().getLength(), EPS);
		Assert
				.assertEquals("length c", 10., c.getCMLVector3().getLength(),
						EPS);

		Assert.assertEquals("gamma", 80., b.getCMLVector3().getAngleMadeWith(
				c.getCMLVector3()).getDegrees(), EPS);
		Assert.assertEquals("beta", 90., c.getCMLVector3().getAngleMadeWith(
				a.getCMLVector3()).getDegrees(), EPS);
		Assert.assertEquals("gamma", 100., a.getCMLVector3().getAngleMadeWith(
				b.getCMLVector3()).getDegrees(), EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLCrystal.getCellVolume()'
	 */
	@Test
	public void testGetCellVolume() {
		double vol = crystal2.getCellVolume();
		Assert.assertEquals("volume", 697.9517566532911, vol, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLCrystal.getCellVolume1()'
	 */
	@Test
	public void testGetCellVolume1() {
		double vol = crystal2.getCellVolume1();
		Assert.assertEquals("volume", 697.9517566532911, vol, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLCrystal.getCellVolume2()'
	 */
	@Test
	public void testGetCellVolume2() {
		double vol = crystal2.getCellVolume2();
		Assert.assertEquals("volume", 697.9517566532911, vol, EPS);
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLCrystal.getReciprocalCellVolume()'
	 */
	@Test
	public void testGetReciprocalCellVolume() {
		double vol = crystal2.getReciprocalCellVolume();
		Assert.assertEquals("volume", 1. / 697.9517566532911, vol, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLCrystal.getReciprocalCell()'
	 */
	@Test
	public void testGetReciprocalCell() {
		CMLCrystal recip = crystal2.getReciprocalCell();
		double[] recipParams = recip.getCellParameterValues();
		DoubleTestBase.assertEquals("recip cell", new double[] {
				0.12698971945582077, 0.11462110273008476, 0.10159177556465662,
				100.15588943429955, 91.7816819026984, 79.84411056570045 },
				recipParams, EPS);
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLCrystal.getReciprocalLattice()'
	 */
	@Test
	public void testGetReciprocalLattice() {
		CMLLattice reciprocalLattice = crystal2.getReciprocalLattice();
		CMLVector3 a = reciprocalLattice.getCMLVector3(0);
		CMLVector3 b = reciprocalLattice.getCMLVector3(1);
		CMLVector3 c = reciprocalLattice.getCMLVector3(2);
		CMLVector3Test.assertEquals("a ", new double[] { 0.12698971945582077,
				0.0, 0.0 }, a, EPS);
		CMLVector3Test.assertEquals("b ", new double[] { 0.020210792969870637,
				0.1128251790984161, -0.0 }, b, EPS);
		CMLVector3Test.assertEquals("c ", new double[] {
				-0.0031586106315794863, -0.017632698070846504, 0.1 }, c, EPS);
	}

	/**
	 * test gets primitive cell.
	 */
	@Test
	public void testGetPrimitiveLatticeCentering() {
		double vol = crystal3.getCellVolume();
		Assert.assertEquals("full vol", 720., vol, EPS);

		CMLLattice primitiveLattice = crystal3.getPrimitiveLattice();
		CMLVector3Test.assertEquals("a", new double[] { 8.0, 0.0, 0.0 },
				primitiveLattice.getCMLVector3(0), EPS);
		CMLVector3Test.assertEquals("b", new double[] { 0.0, 9.0, 0.0 },
				primitiveLattice.getCMLVector3(1), EPS);
		CMLVector3Test.assertEquals("c", new double[] { 0.0, 0.0, 10.0 },
				primitiveLattice.getCMLVector3(2), EPS);
		// check volume
		CMLCrystal primitiveCrystal = new CMLCrystal(primitiveLattice);
		vol = primitiveCrystal.getCellVolume();
		Assert.assertEquals("prim vol", 720., vol, EPS);

		primitiveLattice = crystal3.getPrimitiveLattice(Centering.A);
		CMLVector3Test.assertEquals("a", new double[] { 8.0, 0.0, 0.0 },
				primitiveLattice.getCMLVector3(0), EPS);
		CMLVector3Test.assertEquals("b", new double[] { 0.0, 4.5, 5.0 },
				primitiveLattice.getCMLVector3(1), EPS);
		CMLVector3Test.assertEquals("c", new double[] { 0.0, 4.5, -5.0 },
				primitiveLattice.getCMLVector3(2), EPS);
		primitiveCrystal = new CMLCrystal(primitiveLattice);
		vol = primitiveCrystal.getCellVolume();
		Assert.assertEquals("prim vol", 720. / 2., vol, EPS);

		primitiveLattice = crystal3.getPrimitiveLattice(Centering.B);
		CMLVector3Test.assertEquals("a", new double[] { 4.0, 0.0, 5.0 },
				primitiveLattice.getCMLVector3(0), EPS);
		CMLVector3Test.assertEquals("b", new double[] { 0.0, 9.0, 0.0 },
				primitiveLattice.getCMLVector3(1), EPS);
		CMLVector3Test.assertEquals("c", new double[] { 4.0, 0.0, -5.0 },
				primitiveLattice.getCMLVector3(2), EPS);
		primitiveCrystal = new CMLCrystal(primitiveLattice);
		vol = primitiveCrystal.getCellVolume();
		Assert.assertEquals("prim vol", 720. / 2., vol, EPS);

		primitiveLattice = crystal3.getPrimitiveLattice(Centering.C);
		CMLVector3Test.assertEquals("a", new double[] { 4.0, 4.5, 0.0 },
				primitiveLattice.getCMLVector3(0), EPS);
		CMLVector3Test.assertEquals("b", new double[] { 4.0, -4.5, 0.0 },
				primitiveLattice.getCMLVector3(1), EPS);
		CMLVector3Test.assertEquals("c", new double[] { 0.0, 0.0, 10.0 },
				primitiveLattice.getCMLVector3(2), EPS);
		primitiveCrystal = new CMLCrystal(primitiveLattice);
		vol = primitiveCrystal.getCellVolume();
		Assert.assertEquals("prim vol", 720. / 2., vol, EPS);

		primitiveLattice = crystal3.getPrimitiveLattice(Centering.I);
		CMLVector3Test.assertEquals("a", new double[] { 8.0, 0.0, 0.0 },
				primitiveLattice.getCMLVector3(0), EPS);
		CMLVector3Test.assertEquals("b", new double[] { 4.0, 4.5, 5.0 },
				primitiveLattice.getCMLVector3(1), EPS);
		CMLVector3Test.assertEquals("c", new double[] { 4.0, 4.5, -5.0 },
				primitiveLattice.getCMLVector3(2), EPS);
		primitiveCrystal = new CMLCrystal(primitiveLattice);
		vol = primitiveCrystal.getCellVolume();
		Assert.assertEquals("prim vol", 720. / 2., vol, EPS * 10.);

		primitiveLattice = crystal3.getPrimitiveLattice(Centering.F);
		CMLVector3Test.assertEquals("a", new double[] { 0.0, 4.5, 5.0 },
				primitiveLattice.getCMLVector3(0), EPS);
		CMLVector3Test.assertEquals("b", new double[] { 4.0, 0.0, 5.0 },
				primitiveLattice.getCMLVector3(1), EPS);
		CMLVector3Test.assertEquals("c", new double[] { 4.0, 4.5, 0.0 },
				primitiveLattice.getCMLVector3(2), EPS);
		primitiveCrystal = new CMLCrystal(primitiveLattice);
		vol = primitiveCrystal.getCellVolume();
		Assert.assertEquals("prim vol", 720. / 4., vol, EPS * 10.);
	}

	/**
	 * test gets primitive cell.
	 */
	@Test
	public void testGetPrimitiveLattice() {
		double vol = crystal3.getCellVolume();
		Assert.assertEquals("full vol", 720., vol, EPS);

		CMLLattice primitiveLattice = crystal3.getPrimitiveLattice();
		CMLVector3Test.assertEquals("a", new double[] { 8.0, 0.0, 0.0 },
				primitiveLattice.getCMLVector3(0), EPS);
		CMLVector3Test.assertEquals("b", new double[] { 0.0, 9.0, 0.0 },
				primitiveLattice.getCMLVector3(1), EPS);
		CMLVector3Test.assertEquals("c", new double[] { 0.0, 0.0, 10.0 },
				primitiveLattice.getCMLVector3(2), EPS);
		// check volume
		CMLCrystal primitiveCrystal = new CMLCrystal(primitiveLattice);
		vol = primitiveCrystal.getCellVolume();
		Assert.assertEquals("prim vol", 720., vol, EPS);

		CMLSymmetry symmetry = new CMLSymmetry(CMLSymmetryTest.abm2);
		crystal3.appendChild(symmetry);
		primitiveLattice = crystal3.getPrimitiveLattice();
		CMLVector3Test.assertEquals("a", new double[] { 8.0, 0.0, 0.0 },
				primitiveLattice.getCMLVector3(0), EPS);
		CMLVector3Test.assertEquals("b", new double[] { 0.0, 4.5, 5.0 },
				primitiveLattice.getCMLVector3(1), EPS);
		CMLVector3Test.assertEquals("c", new double[] { 0.0, 4.5, -5.0 },
				primitiveLattice.getCMLVector3(2), EPS);
		primitiveCrystal = new CMLCrystal(primitiveLattice);
		vol = primitiveCrystal.getCellVolume();
		Assert.assertEquals("prim vol", 720. / 2., vol, EPS);

		symmetry.detach();
		symmetry = new CMLSymmetry(CMLSymmetryTest.fdd2);
		crystal3.appendChild(symmetry);
		primitiveLattice = crystal3.getPrimitiveLattice();
		CMLVector3Test.assertEquals("a", new double[] { 0.0, 4.5, 5.0 },
				primitiveLattice.getCMLVector3(0), EPS);
		CMLVector3Test.assertEquals("b", new double[] { 4.0, 0.0, 5.0 },
				primitiveLattice.getCMLVector3(1), EPS);
		CMLVector3Test.assertEquals("c", new double[] { 4.0, 4.5, 0.0 },
				primitiveLattice.getCMLVector3(2), EPS);
		primitiveCrystal = new CMLCrystal(primitiveLattice);
		vol = primitiveCrystal.getCellVolume();
		Assert.assertEquals("prim vol", 720. / 4., vol, EPS * 10.);

	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLCrystal.CMLCrystal(CMLLattice)'
	 */
	@Test
	public void testCMLCrystalCMLLattice() {
		makeLattice();
		CMLCrystal crystal1 = new CMLCrystal(lattice1);
		List<CMLCellParameter> cellParameterList = crystal1
				.createCellParameterElements();
		Assert.assertNotNull("cell parameters", cellParameterList);
		Assert
				.assertEquals("cell parameters size", 2, cellParameterList
						.size());
		Assert.assertNotNull("cell parameters not null", cellParameterList
				.get(0));
		CMLCellParameterTest.assertEquals("cell lengths",
				CMLCellParameter.Type.LENGTH.s,
				new double[] { 8.0, 9.0, 10.0 }, cellParameterList.get(0), EPS);
		CMLCellParameterTest.assertEquals("cell angles",
				CMLCellParameter.Type.ANGLE.s, new double[] { 90., 90., 90. },
				cellParameterList.get(1), EPS);

		CMLCrystal crystal2 = new CMLCrystal(lattice2);
		cellParameterList = crystal2.createCellParameterElements();
		Assert.assertNotNull("cell parameters", cellParameterList);
		Assert
				.assertEquals("cell parameters size", 2, cellParameterList
						.size());
		Assert.assertNotNull("cell parameters not null", cellParameterList
				.get(0));
		CMLCellParameterTest.assertEquals("cell lengths",
				CMLCellParameter.Type.LENGTH.s, new double[] { Math.sqrt(80),
						9.0, 10.0 }, cellParameterList.get(0), EPS);
		CMLCellParameterTest.assertEquals("cell angles",
				CMLCellParameter.Type.ANGLE.s, new double[] { 90., 90.,
						180. / Math.PI * Math.atan(2.) }, cellParameterList
						.get(1), EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLCrystal.CMLCrystal(double[])'
	 */
	@Test
	public void testCMLCrystalDoubleArray() {
		CMLCrystal crystal = new CMLCrystal(new double[] { 8., 9., 10., 90.,
				90., 90. });
		List<CMLCellParameter> cellParameterList = crystal
				.createCellParameterElements();
		Assert.assertNotNull("cell parameters", cellParameterList);
		Assert
				.assertEquals("cell parameters size", 2, cellParameterList
						.size());
		Assert.assertNotNull("cell parameters not null", cellParameterList
				.get(0));
		CMLCellParameterTest.assertEquals("cell lengths",
				CMLCellParameter.Type.LENGTH.s,
				new double[] { 8.0, 9.0, 10.0 }, cellParameterList.get(0), EPS);
		CMLCellParameterTest.assertEquals("cell angles",
				CMLCellParameter.Type.ANGLE.s, new double[] { 90., 90., 90. },
				cellParameterList.get(1), EPS);
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLCrystal.CMLCrystal(CMLScalar[])' and
	 * 'org.xmlcml.cml.element.CMLCrystal.createCellParameterElements()' and
	 * 'org.xmlcml.cml.element.CMLCrystal.createScalar(String, double, String)'
	 * and 'org.xmlcml.cml.element.CMLCrystal.createScalar(String, double,
	 * String, double)'
	 */
	@Test
	public void testCMLCrystalCMLScalarArray() {
		CMLScalar[] scalars = new CMLScalar[6];
		scalars[0] = CMLCrystal.createScalar(CMLCrystal.A, 8.0, U_ANGSTROM,
				0.001);
		scalars[1] = CMLCrystal.createScalar(CMLCrystal.B, 9.0, U_ANGSTROM,
				0.002);
		scalars[2] = CMLCrystal.createScalar(CMLCrystal.C, 10.0, U_ANGSTROM,
				0.003);
		scalars[3] = CMLCrystal.createScalar(CMLCrystal.ALPHA, 80.0, U_DEGREE);
		scalars[4] = CMLCrystal.createScalar(CMLCrystal.BETA, 90.0, U_DEGREE);
		scalars[5] = CMLCrystal.createScalar(CMLCrystal.GAMMA, 100.0, U_DEGREE);
		CMLCrystal crystal = new CMLCrystal(scalars);
		List<CMLCellParameter> cellParameterList = crystal
				.createCellParameterElements();
		Assert.assertNotNull("cell parameters", cellParameterList);
		Assert
				.assertEquals("cell parameters size", 2, cellParameterList
						.size());
		Assert.assertNotNull("cell parameters not null", cellParameterList
				.get(0));
		CMLCellParameterTest.assertEquals("cell lengths",
				CMLCellParameter.Type.LENGTH.s,
				new double[] { 8.0, 9.0, 10.0 }, cellParameterList.get(0), EPS);
		DoubleTestBase.assertEquals("cell length errors", new double[] { 0.001,
				0.002, 0.003 }, cellParameterList.get(0).getError(), EPS);
		CMLCellParameterTest.assertEquals("cell angles",
				CMLCellParameter.Type.ANGLE.s, new double[] { 80., 90., 100. },
				cellParameterList.get(1), EPS);
	}

}
