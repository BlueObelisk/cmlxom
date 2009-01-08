/**
 * 
 */
package org.xmlcml.cml.element.main;

import static org.xmlcml.cml.base.TstBase.assertWriteHTML;

import org.junit.Assert;
import org.junit.Test;
import org.xmlcml.cml.base.CMLConstants;

/**
 * @author pm286
 * 
 */
public class CMLTableHeaderTest extends AbstractTableBase {

	/**
	 * Test method for
	 * {@link org.xmlcml.cml.element.CMLTableHeader#writeHTML(java.io.Writer)}.
	 */
	@Test
	public final void testWriteHTML() {
		String expected = CMLConstants.S_EMPTY
				+ "\n<tr><th class='c:foo'>foo</th><th class='c:bar'>bar</th></tr>";
		assertWriteHTML(tableHeader, expected);
	}

	/**
	 * Test method for
	 * {@link org.xmlcml.cml.element.CMLTableHeader#getColumnCount()}.
	 */
	@Test
	public final void testGetColumnCount() {
		Assert.assertEquals("count", 2, tableHeader.getColumnCount());
	}

}
