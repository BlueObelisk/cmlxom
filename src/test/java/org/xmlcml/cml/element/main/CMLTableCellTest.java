/**
 * 
 */
package org.xmlcml.cml.element.main;

import static org.xmlcml.cml.base.TstBase.assertEqualsCanonically;
import static org.xmlcml.cml.base.TstBase.assertWriteHTML;
import static org.xmlcml.cml.base.TstBase.parseValidString;
import static org.xmlcml.cml.base.CMLConstants.CML_XMLNS;

import org.junit.Before;
import org.junit.Test;
import org.xmlcml.cml.base.TstBase;
import org.xmlcml.cml.base.CMLElement;
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
		TstBase.assertWriteHTML(cell, ss);
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
		String ss = "<tableCell " + CML_XMLNS + ">1.2</tableCell>";
		CMLTableCell expected = (CMLTableCell) parseValidString(ss);
		assertEqualsCanonically("cell double", expected, cell);
	}

	/**
	 * Test method for
	 * {@link org.xmlcml.cml.element.CMLTableCell#CMLTableCell(int)}.
	 */
	@Test
	public final void testCMLTableCellInt() {
		cell = new CMLTableCell(3);
		String ss = "<tableCell " + CML_XMLNS + ">3</tableCell>";
		CMLTableCell expected = (CMLTableCell) parseValidString(ss);
		assertEqualsCanonically("cell double", expected, cell);
	}

	/**
	 * Test method for
	 * {@link org.xmlcml.cml.element.CMLTableCell#CMLTableCell(nu.xom.Element)}.
	 */
	@Test
	public final void testCMLTableCellElement() {
		String molS = "<molecule "
				+ CML_XMLNS
				+ "><atomArray><atom id='a1' elementType='Cl'/></atomArray></molecule>";
		String mol1S = "<molecule><atomArray><atom id='a1' elementType='Cl'/></atomArray></molecule>";
		CMLElement mol = (CMLElement) parseValidString(molS);
		cell = new CMLTableCell(mol);
		String ss = "<tableCell " + CML_XMLNS + ">" + mol1S + "</tableCell>";
		CMLTableCell expected = (CMLTableCell) parseValidString(ss);
		assertEqualsCanonically("cell molecule", expected, cell);
	}

}
