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
import static org.xmlcml.euclid.EuclidConstants.S_COMMA;
import static org.xmlcml.euclid.EuclidConstants.S_EMPTY;
import static org.xmlcml.euclid.EuclidConstants.S_SPACE;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author pm286
 * 
 */
public class CMLTableRowTest extends AbstractTableBase {

	/**
	 * Test method for
	 * {@link org.xmlcml.cml.element.CMLTableRow#writeHTML(java.io.Writer)}.
	 */
	@Test
	public final void testWriteHTML() {
		String tableRowS = "\n<tr><td>2</td><td>b</td></tr>";
		assertWriteHTML(tableRow, tableRowS);
	}

	/**
	 * Test method for
	 * {@link org.xmlcml.cml.element.CMLTableRow#getDelimitedString(java.lang.String)}
	 * .
	 */
	@Test
	public final void testGetDelimitedString() {
		String tableRowS = tableRow.getDelimitedString(S_COMMA);
		Assert.assertEquals("comma", "2,b", tableRowS);
		tableRowS = tableRow.getDelimitedString(S_SPACE);
		Assert.assertEquals("comma", "2 b", tableRowS);
		tableRowS = tableRow.getDelimitedString(S_EMPTY);
		Assert.assertEquals("comma", "2 b", tableRowS);
		tableRowS = tableRow.getDelimitedString(null);
		Assert.assertEquals("comma", "2 b", tableRowS);
	}

}
