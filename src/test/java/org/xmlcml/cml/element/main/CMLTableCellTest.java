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

/**
 * 
 */
package org.xmlcml.cml.element.main;

import static org.xmlcml.cml.base.CMLXOMTestUtils.assertEqualsCanonically;
import static org.xmlcml.cml.base.CMLXOMTestUtils.assertWriteHTML;

import org.junit.Before;
import org.junit.Test;
import org.xmlcml.cml.base.CMLConstants;
import org.xmlcml.cml.base.CMLElement;
import org.xmlcml.cml.base.CMLXOMTestUtils;
import org.xmlcml.cml.element.CMLTableCell;

/**
 * @author pm286
 * 
 */
public class CMLTableCellTest extends AbstractTableBase {

	CMLTableCell cell = null;

	/**
	 * set up.
	 */
	@Before
	public void makeCell() {
		cell = new CMLTableCell();
	}

	/**
	 * Test method for
	 * {@link org.xmlcml.cml.element.CMLTableCell#writeHTML(java.io.Writer)}.
	 */
	@Test
	public final void testWriteHTML() {
		cell = new CMLTableCell("foo");
		String ss = "<td>foo</td>";
		CMLXOMTestUtils.assertWriteHTML(cell, ss);
		cell = new CMLTableCell(1.2);
		ss = "<td>1.2</td>";
		assertWriteHTML(cell, ss);
		cell = new CMLTableCell(3);
		ss = "<td>3</td>";
		assertWriteHTML(cell, ss);
	}

	/**
	 * Test method for
	 * {@link org.xmlcml.cml.element.CMLTableCell#CMLTableCell(java.lang.String)}
	 * .
	 */
	@Test
	public final void testCMLTableCellString() {
		cell = new CMLTableCell("foo");
	}

	/**
	 * Test method for
	 * {@link org.xmlcml.cml.element.CMLTableCell#CMLTableCell(double)}.
	 */
	@Test
	public final void testCMLTableCellDouble() {
		cell = new CMLTableCell(1.2);
		String ss = "<tableCell " + CMLConstants.CML_XMLNS + ">1.2</tableCell>";
		CMLTableCell expected = (CMLTableCell)CMLXOMTestUtils.parseValidString(ss);
		assertEqualsCanonically("cell double", expected, cell);
	}

	/**
	 * Test method for
	 * {@link org.xmlcml.cml.element.CMLTableCell#CMLTableCell(int)}.
	 */
	@Test
	public final void testCMLTableCellInt() {
		cell = new CMLTableCell(3);
		String ss = "<tableCell " + CMLConstants.CML_XMLNS + ">3</tableCell>";
		CMLTableCell expected = (CMLTableCell)CMLXOMTestUtils.parseValidString(ss);
		assertEqualsCanonically("cell double", expected, cell);
	}

	/**
	 * Test method for
	 * {@link org.xmlcml.cml.element.CMLTableCell#CMLTableCell(nu.xom.Element)}.
	 */
	@Test
	public final void testCMLTableCellElement() {
		String molS = "<molecule "
				+ CMLConstants.CML_XMLNS
				+ "><atomArray><atom id='a1' elementType='Cl'/></atomArray></molecule>";
		String mol1S = "<molecule><atomArray><atom id='a1' elementType='Cl'/></atomArray></molecule>";
		CMLElement mol = (CMLElement)CMLXOMTestUtils.parseValidString(molS);
		cell = new CMLTableCell(mol);
		String ss = "<tableCell " + CMLConstants.CML_XMLNS + ">" + mol1S + "</tableCell>";
		CMLTableCell expected = (CMLTableCell)CMLXOMTestUtils.parseValidString(ss);
		assertEqualsCanonically("cell molecule", expected, cell);
	}

}
