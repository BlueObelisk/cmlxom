package org.xmlcml.cml.element.main;

import static org.xmlcml.cml.base.BaseTest.parseValidString;
import static org.xmlcml.cml.base.CMLConstants.CML_XMLNS;
import static org.xmlcml.cml.base.CMLConstants.XSD_DOUBLE;
import static org.xmlcml.euclid.EuclidConstants.EPS;
import static org.xmlcml.euclid.test.EuclidTestBase.neverThrow;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.xmlcml.cml.base.CMLBuilder;
import org.xmlcml.cml.element.CMLArray;
import org.xmlcml.cml.element.CMLAtomicBasisFunction;
import org.xmlcml.cml.element.CMLBasisSet;
import org.xmlcml.cml.element.CMLEigen;
import org.xmlcml.cml.element.CMLMatrix;
import org.xmlcml.cml.element.CMLMolecule;
import org.xmlcml.cml.element.CMLBasisSet.Basis;
import org.xmlcml.euclid.RealArray;
import org.xmlcml.euclid.test.RealArrayTest;

/** */
public class CMLBasisSetTest {

	String basisSetS = "";

	CMLBasisSet basisSet = null;

	String moleculeS = "" + "<molecule " + CML_XMLNS + ">" + "  <atomArray>"
			+ "	 <atom elementType='H' id='a1'></atom>"
			+ "	 <atom elementType='C' id='a2'></atom>"
			+ "	 <atom elementType='H' id='a3'></atom>"
			+ "	 <atom elementType='O' id='a4'></atom>" + "  </atomArray>"
			+ "</molecule>";

	CMLMolecule molecule;

	String basisSetS2 = "<basisSet "
			+ CML_XMLNS
			+ ">"
			+ "   <atomicBasisFunction id='a1' n='1' l='0' lm='s' symbol='S' atomRef='a1'/>"
			+ "   <atomicBasisFunction id='a2' n='2' l='0' lm='s' symbol='S' atomRef='a2'/>"
			+ "   <atomicBasisFunction id='a3' n='2' l='1' lm='px' symbol='PX' atomRef='a2'/>"
			+ "   <atomicBasisFunction id='a4' n='2' l='1' lm='py' symbol='PY' atomRef='a2'/>"
			+ "   <atomicBasisFunction id='a5' n='2' l='1' lm='pz' symbol='PZ' atomRef='a2'/>"
			+ "   <atomicBasisFunction id='a6' n='1' l='0' lm='s' symbol='S' atomRef='a3'/>"
			+ "   <atomicBasisFunction id='a7' n='2' l='0' lm='s' symbol='S' atomRef='a4'/>"
			+ "   <atomicBasisFunction id='a8' n='2' l='1' lm='px' symbol='PX' atomRef='a4'/>"
			+ "   <atomicBasisFunction id='a9' n='2' l='1' lm='py' symbol='PY' atomRef='a4'/>"
			+ "   <atomicBasisFunction id='a10' n='2' l='1' lm='pz' symbol='PZ' atomRef='a4'/>"
			+ "</basisSet>";

	CMLBasisSet basisSet2;

	String coefficientS = "<eigen dictRef='mopac:eig' title='EIGENVECTORS AND EIGENVALUES' "
			+ "	orientation='columnVectors' "
			+ CML_XMLNS
			+ ">"
			+ "<array title='eigenvalues' size='10' dataType='xsd:double'>"
			+ "	-37.90004 -20.34372 -13.10423 -12.71709 -12.07969 -7.47084"
			+ "	-3.44820 -1.14406 -.70572 .56580"
			+ "</array>"
			+ "<matrix title='eigenvectors' columns='10' rows='10' dataType='xsd:double'>"
			+ "   -.08645     -.30627      .28127      .21650      .00000      .51104"
			+ "    .00000      .54076      .43797      .16535"
			+ "   -.38651     -.67196      .19755      .00002      .00000      .00000"
			+ "    .00000     -.58544      .00009      .13159"
			+ "   -.12937      .05529     -.29019     -.38339      .00000     -.38138"
			+ "    .00000      .02479      .63431      .44787"
			+ "    .19522     -.08345      .43789     -.25407      .00000     -.25274"
			+ "    .00000     -.03716      .42046     -.67572"
			+ "    .00000      .00000      .00000      .00000      .37511      .00000"
			+ "    .92698      .00000      .00000      .00000"
			+ "   -.08646     -.30626      .28121     -.21652      .00000     -.51109"
			+ "    .00000      .54056     -.43824      .16523"
			+ "   -.86876      .41200      .13042      .00000      .00000      .00001"
			+ "    .00000      .09466      .00001     -.22256"
			+ "    .08917      .23508      .39444     -.69478      .00000      .43176"
			+ "    .00000     -.13723     -.16033      .25987"
			+ "   -.13456     -.35475     -.59518     -.46042      .00000      .28617"
			+ "    .00000      .20700     -.10623     -.39217"
			+ "    .00000      .00000      .00000      .00000      .92698      .00000"
			+ "   -.37511      .00000      .00000      .00000"
			+ "</matrix>"
			+ "</eigen>";

	CMLEigen coefficients = null;

	/** */
	/**
	 * setup.
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		molecule = (CMLMolecule) parseValidString(moleculeS);
		basisSet = new CMLBasisSet();
		basisSet2 = (CMLBasisSet) parseValidString(basisSetS2);
	}

	/**
	 * * Test method for
	 * 'org.xmlcml.cml.element.CMLBasisSet.CMLBasisSet(CMLBasisSet)'
	 */
	@Test
	public void testCMLBasisSetCMLBasisSet() {
		CMLBasisSet basisSet1 = new CMLBasisSet(basisSet);
		Assert.assertNotNull("copy", basisSet1);
	}

	/**
	 * * Test method for 'org.xmlcml.cml.element.CMLBasisSet.getABFsByL(int)'
	 */
	@Test
	public void testGetABFsByL() {
		List<CMLAtomicBasisFunction> abfList = basisSet2.getABFsByL(1);
		Assert.assertEquals("getByL", 6, abfList.size());
		Assert.assertEquals("getByL", "a4", abfList.get(1).getId());
		abfList = basisSet2.getABFsByL(0);
		Assert.assertEquals("getByL", 4, abfList.size());
		Assert.assertEquals("getByL", "a7", abfList.get(3).getId());
		abfList = basisSet2.getABFsByL(2);
		Assert.assertEquals("getByL", 0, abfList.size());
	}

	/**
	 * * Test method for 'org.xmlcml.cml.element.CMLBasisSet.getABFsByN(int)'
	 */
	@Test
	public void testGetABFsByN() {
		List<CMLAtomicBasisFunction> abfList = basisSet2.getABFsByN(1);
		Assert.assertEquals("getByN", 2, abfList.size());
		Assert.assertEquals("getByN", "a6", abfList.get(1).getId());
		abfList = basisSet2.getABFsByN(2);
		Assert.assertEquals("getByN", 8, abfList.size());
		Assert.assertEquals("getByN", "a3", abfList.get(1).getId());
		abfList = basisSet2.getABFsByN(0);
		Assert.assertEquals("getByN", 0, abfList.size());
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLBasisSet.getABFsByLM(String)'
	 */
	@Test
	public void testGetABFsByLM() {
		List<CMLAtomicBasisFunction> abfList = basisSet2.getABFsByLM("s");
		Assert.assertEquals("getByLM", 4, abfList.size());
		Assert.assertEquals("getByLM", "a2", abfList.get(1).getId());
		abfList = basisSet2.getABFsByLM("px");
		Assert.assertEquals("getByLM", 2, abfList.size());
		Assert.assertEquals("getByLM", "a8", abfList.get(1).getId());
		abfList = basisSet2.getABFsByLM("z");
		Assert.assertEquals("getByLM", 0, abfList.size());
	}

	/**
	 * * Test method for
	 * 'org.xmlcml.cml.element.CMLBasisSet.getABFsBySymbol(String)'
	 */
	@Test
	public void testGetABFsBySymbol() {
		List<CMLAtomicBasisFunction> abfList = basisSet2.getABFsBySymbol("S");
		Assert.assertEquals("getBySymbol", 4, abfList.size());
		Assert.assertEquals("getBySymbol", "a2", abfList.get(1).getId());
		abfList = basisSet2.getABFsBySymbol("PX");
		Assert.assertEquals("getBySymbol", 2, abfList.size());
		Assert.assertEquals("getBySymbol", "a8", abfList.get(1).getId());
		abfList = basisSet2.getABFsBySymbol("s");
		Assert.assertEquals("getBySymbol", 0, abfList.size());
	}

	/**
	 * * Test method for
	 * 'org.xmlcml.cml.element.CMLBasisSet.setAtomicOrbitalCoefficients(CMLEigen
	 * ) '
	 */
	@Test
	public void testSetMolecularOrbitalCoefficients() {
		setCoefficients();
		CMLArray values = coefficients.getArrayElements().get(0);
		Assert.assertNotNull("values", values);
		Assert.assertEquals("values type", XSD_DOUBLE, values.getDataType());
		double[] vv = values.getDoubles();
		Assert.assertEquals("values size", 10, vv.length);
		CMLMatrix vectors = coefficients.getMatrixElements().get(0);
		Assert.assertNotNull("vectors", vectors);
		Assert.assertEquals("vectors type", XSD_DOUBLE, vectors.getDataType());
		double[][] mm = vectors.getDoubleMatrix();
		Assert.assertNotNull("double matrix not null", mm);
		Assert.assertEquals("vectors size", 10, mm.length);
		Assert.assertEquals("vectors size", 10, mm[0].length);
	}

	private void setCoefficients() {
		try {
			coefficients = (CMLEigen) new CMLBuilder()
					.parseString(coefficientS);
		} catch (Exception e) {
			neverThrow(e);
		}
		basisSet2.setMolecularOrbitalCoefficients(coefficients);
	}

	/**
	 * * Test method for 'org.xmlcml.cml.element.CMLBasisSet.CMLBasisSet(Basis,
	 * CMLMolecule)'
	 */
	@Test
	public void testBasisSetBasisCMLMolecule() {
		CMLBasisSet basisSet = new CMLBasisSet(Basis.MINIMAL, molecule);
		Assert.assertNotNull("basisSet not null", basisSet);
	}

	/**
	 * * Test method for
	 * 'org.xmlcml.cml.element.CMLBasisSet.getElectronCount(Basis)'
	 */
	@Test
	public void testGetElectronCount() {
		basisSet2.setBasis(Basis.MINIMAL);
		basisSet2.setMolecule(molecule);
		int nElectrons = basisSet2.getElectronCount();
		Assert.assertEquals("electron", 12, nElectrons);

		molecule.setFormalCharge(-1);
		basisSet2.setMolecule(molecule);
		nElectrons = basisSet2.getElectronCount();
		Assert.assertEquals("electron", 13, nElectrons);
	}

	/**
	 * testFindHOMO()
	 */
	@Test
	public void testFindHOMO() {
		basisSet2.setBasis(Basis.MINIMAL);
		basisSet2.setMolecule(molecule);
		int nElectrons = basisSet2.getElectronCount();
		Assert.assertEquals("electrons", 12, nElectrons);
		int homo = nElectrons / 2 - 1;
		Assert.assertEquals("orbitals", 5, homo);
		setCoefficients();
		RealArray homoVector = null;
		try {
			homoVector = coefficients.getEigenvector(homo);
		} catch (RuntimeException e) {
			neverThrow(e);
		}
		RealArrayTest.assertEquals("homo vector", new double[] { 0.51104, 0.0,
				-0.38138, -0.25274, 0.0, -0.51109, 1.0E-5, 0.43176, 0.28617,
				0.0 }, homoVector, EPS);
	}

	/**
	 * tests getString()
	 * 
	 */
	@Test
	public void testGetString() {
		basisSet2.setBasis(Basis.MINIMAL);
		basisSet2.setMolecule(molecule);
		Assert.assertEquals("basis set string", "basis: MINIMAL\n"
				+ "1s(S)(a1)\n" + "2s(S)(a2)\n" + "2px(PX)(a3)\n"
				+ "2py(PY)(a4)\n" + "2pz(PZ)(a5)\n" + "1s(S)(a6)\n"
				+ "2s(S)(a7)\n" + "2px(PX)(a8)\n" + "2py(PY)(a9)\n"
				+ "2pz(PZ)(a10)", basisSet2.getString());
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLBasisSet.CMLBasisSet(Basis,
	 * CMLMolecule)'
	 */
	@Test
	public void testCMLBasisSetBasisCMLMolecule() {
		// doesn't need testing as only sets variables
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLBasisSet.getABFsByM(int)'
	 */
	@Test
	public void testGetABFsByM() {
		// don't think this is working
		List<CMLAtomicBasisFunction> abfList = basisSet2.getABFsByM(1);
		Assert.assertEquals("getByM", 0, abfList.size());
		// Assert.assertEquals("getByM", "a2", abfList.get(1).getId());
		abfList = basisSet2.getABFsByM(0);
		Assert.assertEquals("getByM", 0, abfList.size());
		// Assert.assertEquals("getByM", "a8", abfList.get(1).getId());
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLBasisSet.setBasis(Basis)'
	 */
	@Test
	public void testSetBasis() {
		// doesn't need testing as only sets variables
	}

}
