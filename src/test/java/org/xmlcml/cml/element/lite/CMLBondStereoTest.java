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

import org.junit.Assert;
import org.junit.Test;
import org.xmlcml.cml.base.CMLConstants;
import org.xmlcml.cml.base.CMLXOMTestUtils;
import org.xmlcml.cml.element.CMLBond;
import org.xmlcml.cml.element.CMLBondStereo;
import org.xmlcml.cml.element.CMLMolecule;

/**
 * test bondStereo.
 * 
 * @author pm286
 * 
 */
public class CMLBondStereoTest {

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLBondStereo.matchParity(CMLBondStereo,
	 * CMLMolecule)'
	 */
	@Test
	public void testMatchParity() {
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
		CMLMolecule mol = (CMLMolecule) CMLXOMTestUtils.parseValidString(s);
		CMLBond b2 = mol.getBondByAtomIds("a2", "a3");
		CMLBondStereo bs = b2.getBondStereo();
		CMLBondStereo bs1 = new CMLBondStereo();
		bs1.setAtomRefs4("a1 a2 a3 a4");
		bs1.setXMLContent("C");
		Assert.assertEquals("bs parity", 1, bs.matchParity(bs1));
		// swap atom order
		bs1.setAtomRefs4("a4 a3 a2 a1");
		Assert.assertEquals("bs parity", 1, bs.matchParity(bs1));
		// swap sterochemistry
		bs1.setXMLContent("T");
		Assert.assertEquals("bs parity", -1, bs.matchParity(bs1));
		// garble order
		bs1.setAtomRefs4("a4 a2 a3 a1");
		Assert.assertEquals("bs parity", 0, bs.matchParity(bs1));
	}

}
