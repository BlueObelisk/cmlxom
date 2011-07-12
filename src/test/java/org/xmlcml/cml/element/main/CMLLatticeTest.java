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

import static org.xmlcml.euclid.EuclidConstants.EPS;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.xmlcml.cml.base.CMLConstants;
import org.xmlcml.cml.base.CMLXOMTestUtils;
import org.xmlcml.cml.element.CMLLattice;
import org.xmlcml.cml.element.CMLLatticeVector;
import org.xmlcml.cml.element.CMLVector3;
import org.xmlcml.euclid.test.DoubleTestBase;

/**
 * tests Lattice.
 * 
 * @author pmr
 */
public class CMLLatticeTest {

	static String lattice1S = "" + "<lattice " + CMLConstants.CML_XMLNS + ">"
			+ "  <latticeVector>10. 6. 4.</latticeVector>"
			+ "  <latticeVector>7. 11. 5.</latticeVector>"
			+ "  <latticeVector>6.8 -4. -9.</latticeVector>" + "</lattice>"
			+ "";

	static CMLLattice lattice1 = null;

	/**
	 * setup.
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		if (lattice1 == null) {
			lattice1 = (CMLLattice)CMLXOMTestUtils.parseValidString(lattice1S);
		}
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLLattice.CMLLattice(CMLLatticeVector[])'
	 */
	@Test
	public void testCMLLatticeCMLLatticeVectorArray() {
		CMLLattice lattice = new CMLLattice(new CMLLatticeVector[] {
				new CMLLatticeVector(new double[] { 1., 2., 3. }),
				new CMLLatticeVector(new double[] { 4., 5., 6. }),
				new CMLLatticeVector(new double[] { 7., 8., 9. }) });
		CMLVector3Test.assertEquals("construct", new double[] { 1., 2., 3. },
				lattice.getCMLVector3(0), EPS);
		CMLVector3Test.assertEquals("construct", new double[] { 4., 5., 6. },
				lattice.getCMLVector3(1), EPS);
		CMLVector3Test.assertEquals("construct", new double[] { 7., 8., 9. },
				lattice.getCMLVector3(2), EPS);
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLLattice.CMLLattice(CMLLatticeVector,
	 * CMLLatticeVector, CMLLatticeVector)'
	 */
	@Test
	public void testCMLLatticeCMLLatticeVectorCMLLatticeVectorCMLLatticeVector() {
		CMLLattice lattice = new CMLLattice(new CMLLatticeVector(new double[] {
				1., 2., 3. }),
				new CMLLatticeVector(new double[] { 4., 5., 6. }),
				new CMLLatticeVector(new double[] { 7., 8., 9. }));
		CMLVector3Test.assertEquals("construct", new double[] { 1., 2., 3. },
				lattice.getCMLVector3(0), EPS);
		CMLVector3Test.assertEquals("construct", new double[] { 4., 5., 6. },
				lattice.getCMLVector3(1), EPS);
		CMLVector3Test.assertEquals("construct", new double[] { 7., 8., 9. },
				lattice.getCMLVector3(2), EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLLattice.getCellParameters()'
	 */
	@Test
	public void testGetCellParameters() {
		double[] params = lattice1.getCellParameters();
		DoubleTestBase.assertEquals("params", new double[] {
				12.328828005937952, 13.96424004376894, 11.968291440301744,
				104.34229064539636, 86.89206686722031, 25.025508299339933 },
				params, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLLattice.getCMLVector3(int)'
	 */
	@Test
	public void testGetCMLVector3() {
		CMLVector3 v = lattice1.getCMLVector3(0);
		CMLVector3Test.assertEquals("cml vector",
				new double[] { 10.0, 6.0, 4.0 }, v, EPS);
		v = lattice1.getCMLVector3(1);
		CMLVector3Test.assertEquals("cml vector",
				new double[] { 7.0, 11.0, 5.0 }, v, EPS);
		v = lattice1.getCMLVector3(2);
		CMLVector3Test.assertEquals("cml vector", new double[] { 6.8, -4.0,
				-9.0 }, v, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLLattice.getVolume()'
	 */
	@Test
	public void testGetVolume() {
		double vol = lattice1.getVolume();
		Assert.assertEquals("lattice volume", -619.2, vol, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLLattice.getReducedCell()'
	 */
	@Test
	public void testGetReducedCell() {
		CMLVector3Test.assertEquals("a", new double[] { 10., 6., 4. }, lattice1
				.getCMLVector3(0), EPS);
		Assert.assertEquals("alen", 12.328828005937952, lattice1.getCMLVector3(
				0).getLength(), EPS);
		CMLVector3Test.assertEquals("b", new double[] { 7., 11., 5. }, lattice1
				.getCMLVector3(1), EPS);
		Assert.assertEquals("blen", 13.96424004376894, lattice1
				.getCMLVector3(1).getLength(), EPS);
		CMLVector3Test.assertEquals("c", new double[] { 6.8, -4., -9. },
				lattice1.getCMLVector3(2), EPS);
		Assert.assertEquals("clen", 11.968291440301744, lattice1.getCMLVector3(
				2).getLength(), EPS);
		Assert.assertEquals("vol", -619.2, lattice1.getVolume(), EPS);
		double[] params = lattice1.getCellParameters();
		DoubleTestBase.assertEquals("params", new double[] {
				12.328828005937952, 13.96424004376894, 11.968291440301744,
				104.34229064539636, 86.89206686722031, 25.025508299339933 },
				params, EPS);

		CMLLattice reducedLattice = lattice1.getReducedCell();
		CMLVector3Test.assertEquals("a", new double[] { 3.0, -5.0, -1.0 },
				reducedLattice.getCMLVector3(0), EPS);
		Assert.assertEquals("alen", 5.916079783099616, reducedLattice
				.getCMLVector3(0).getLength(), EPS);
		CMLVector3Test.assertEquals("b", new double[] { 3.8, 1.0, -8.0 },
				reducedLattice.getCMLVector3(1), EPS);
		Assert.assertEquals("blen", 8.912911982062877, reducedLattice
				.getCMLVector3(1).getLength(), EPS);
		CMLVector3Test.assertEquals("c", new double[] { 10.0, 6.0, 4.0 },
				reducedLattice.getCMLVector3(2), EPS);
		Assert.assertEquals("clen", 12.328828005937952, reducedLattice
				.getCMLVector3(2).getLength(), EPS);
		Assert.assertEquals("vol", 619.2, reducedLattice.getVolume(), EPS);
		params = reducedLattice.getCellParameters();
		DoubleTestBase.assertEquals("params", new double[] { 5.916079783099616,
				8.912911982062877, 12.328828005937952, 83.73054962879554,
				93.14372638090103, 74.15166267765416 }, params, EPS);

	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLLattice.copy()'
	 */
	@Test
	public void testCopy() {
		CMLLattice lattice = (CMLLattice) lattice1.copy();
		Assert.assertEquals("copy", 3, lattice.getLatticeVectorElements()
				.size());
		CMLLatticeVectorTest.assertEquals("copy", new double[] { 10., 6., 4. },
				lattice.getLatticeVectorElements().get(0), EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLLattice.getString()'
	 */
	@Test
	public void testGetString() {
		String s = lattice1.getString();
		String ss = "[10. 6. 4.](12.328828005937952)"
				+ "[7. 11. 5.](13.96424004376894)"
				+ "[6.8 -4. -9.](11.968291440301744)";
		Assert.assertEquals("getString", s, ss);
	}

}
