package org.xmlcml.cml.element.main;

import static org.xmlcml.euclid.EC.EPS;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.xmlcml.cml.element.CMLArray;
import org.xmlcml.cml.element.CMLEigen;
import org.xmlcml.cml.element.CMLMatrix;
import org.xmlcml.cml.element.CMLEigen.Orientation;
import org.xmlcml.euclid.EuclidConstants;
import org.xmlcml.euclid.RealArray;
import org.xmlcml.euclid.test.DoubleTestBase;
import org.xmlcml.euclid.test.RealArrayTest;

/**
 * tests eigen.
 * 
 * @author pmr
 * 
 */
public class CMLEigenTest {

	CMLEigen eigen1;

	CMLMatrix eigenvectors1;

	CMLArray eigenvalues1;

	/**
	 * setup.
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		eigenvalues1 = new CMLArray(new double[] { -37.90004, -20.34372,
				-13.10423, -12.71709, -12.07969, -7.47084, -3.44820, -1.14406,
				-.70572, .56580 });
		eigenvectors1 = new CMLMatrix(10, 10, new double[] { -.08645, -.38651,
				-.12937, .19522, .00000, -.08646, -.86876, .08917, -.13456,
				.00000, -.30627, -.67196, .05529, -.08345, .00000, -.30626,
				.41200, .23508, -.35475, .00000, .28127, .19755, -.29019,
				.43789, .00000, .28121, .13042, .39444, -.59518, .00000,
				.21650, .00002, -.38339, -.25407, .00000, -.21652, .00000,
				-.69478, -.46042, .00000, .00000, .00000, .00000, .00000,
				.37511, .00000, .00000, .00000, .00000, .92698, .51104, .00000,
				-.38138, -.25274, .00000, -.51109, .00001, .43176, .28617,
				.00000, .00000, .00000, .00000, .00000, .92698, .00000, .00000,
				.00000, .00000, -.37511, .54076, -.58544, .02479, -.03716,
				.00000, .54056, .09466, -.13723, .20700, .00000, .43797,
				.00009, .63431, .42046, .00000, -.43824, .00001, -.16033,
				-.10623, .00000, .16535, .13159, .44787, -.67572, .00000,
				.16523, -.22256, .25987, -.39217, .00000 });
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLEigen.CMLEigen(CMLMatrix,
	 * CMLArray, Orientation)'
	 */
	@Test
	public void testCMLEigenCMLMatrixCMLArrayOrientation() {
		Orientation orient = Orientation.VALUES_COLS;
		CMLEigen eigen = new CMLEigen(eigenvectors1, eigenvalues1, orient);
		Assert.assertNotNull("eigenvalues ", eigen.getEigenvalues());
		Assert.assertNotNull("eigenvectors ", eigen.getEigenvectors());
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLEigen.getSize()'
	 */
	@Test
	public void testGetSize() {
		Orientation orient = Orientation.VALUES_COLS;
		CMLEigen eigen = new CMLEigen(eigenvectors1, eigenvalues1, orient);
		Assert.assertNotNull("eigenvalues ", eigen.getEigenvalues());
		Assert.assertNotNull("eigenvectors ", eigen.getEigenvectors());
		Assert.assertEquals("size ", 10, eigen.getSize());
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLEigen.getEigenvectors()'
	 */
	@Test
	public void testGetEigenvectors() {
		Orientation orient = Orientation.VALUES_COLS;
		CMLEigen eigen = new CMLEigen(eigenvectors1, eigenvalues1, orient);
		Assert.assertNotNull("eigenvectors ", eigen.getEigenvectors());
		Assert.assertEquals("cols", 10, eigen.getEigenvectors().getColumns());
		Assert.assertEquals("rows", 10, eigen.getEigenvectors().getRows());
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLEigen.getEigenvalues()'
	 */
	@Test
	public void testGetEigenvalues() {
		Orientation orient = Orientation.VALUES_COLS;
		CMLEigen eigen = new CMLEigen(eigenvectors1, eigenvalues1, orient);
		Assert.assertNotNull("eigenvalues ", eigen.getEigenvalues());
		Assert.assertEquals("size", 10, eigen.getEigenvalues().getSize());
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLEigen.getEigenvector(int)'
	 */
	@Test
	public void testGetEigenvector() {
		Orientation orient = Orientation.VALUES_COLS;
		CMLEigen eigen = new CMLEigen(eigenvectors1, eigenvalues1, orient);
		RealArray eigenvector = eigen.getEigenvector(1);
		double[] test = new double[] { -0.38651,
				-0.67196, 0.19755, 2.0E-5, 0.0, 0.0, 0.0, -0.58544, 9.0E-5,
				0.13159 };
		org.junit.Assert.assertNotNull("test should not be null (" + "eigenvector" + EuclidConstants.S_RBRAK, test);
		org.junit.Assert.assertNotNull("expected should not be null (" + "eigenvector" + EuclidConstants.S_RBRAK,
				eigenvector);
		org.junit.Assert.assertEquals("must be of equal length ", test.length, eigenvector
				.getArray().length);
		DoubleTestBase.assertEquals("eigenvector", test, eigenvector.getArray(), EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLEigen.copy()'
	 */
	@Test
	public void testCopy() {
		Orientation orient = Orientation.VALUES_COLS;
		CMLEigen eigen = new CMLEigen(eigenvectors1, eigenvalues1, orient);
		Assert.assertNotNull("eigenvalues ", eigen.getEigenvalues());
		Assert.assertNotNull("eigenvectors ", eigen.getEigenvectors());
		Assert.assertEquals("size ", 10, eigen.getSize());
		CMLEigen eigen1 = (CMLEigen) eigen.copy();
		Assert.assertNotNull("eigenvalues ", eigen1.getEigenvalues());
		Assert.assertNotNull("eigenvectors ", eigen1.getEigenvectors());
		Assert.assertEquals("size ", 10, eigen1.getSize());
		Assert.assertEquals("orient ", Orientation.VALUES_COLS.value, eigen1
				.getOrientation());
	}

}
