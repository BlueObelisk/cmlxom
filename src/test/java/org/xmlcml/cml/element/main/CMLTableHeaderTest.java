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

import static org.xmlcml.cml.base.CMLXOMTestUtils.assertWriteHTML;

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
