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

import org.xmlcml.cml.base.CMLConstants;

/**
 * test CMLTable.
 * 
 * @author pmr
 * 
 */
public class AbstractTableBase {

	protected final static String tableRowListS = CMLConstants.S_EMPTY + "<tableRowList " + CMLConstants.CML_XMLNS + ">"
			+ "  <tableRow>" + "    <tableCell>1</tableCell>"
			+ "    <tableCell>a</tableCell>" + "  </tableRow>" + "  <tableRow>"
			+ "    <tableCell>2</tableCell>" + "    <tableCell>b</tableCell>"
			+ "  </tableRow>" + "  <tableRow>" + "    <tableCell>3</tableCell>"
			+ "    <tableCell>c</tableCell>" + "  </tableRow>"
			+ "</tableRowList>";
	protected final static String tableContentS = CMLConstants.S_EMPTY + "<tableContent " + CMLConstants.CML_XMLNS + ">"
			+ "1 a\n" + "2 b\n" + "3 c" + "</tableContent>";
	protected final static String tableHeaderS = CMLConstants.S_EMPTY
			+ "<tableHeader "
			+ CMLConstants.CML_XMLNS
			+ ">"
			+ "  <tableHeaderCell id='th1' dictRef='c:foo' title='foo' dataType='xsd:string'/>"
			+ "  <tableHeaderCell id='th2' dictRef='c:bar' title='bar' dataType='xsd:string'/>"
			+ "</tableHeader>" + CMLConstants.S_EMPTY;
	protected final static String arrayListS = CMLConstants.S_EMPTY
			+ "<arrayList "
			+ CMLConstants.CML_XMLNS
			+ ">"
			+ "  <array id='th1' dictRef='c:foo' title='foo' size='3'>1 2 3</array>"
			+ "  <array id='th2' dictRef='c:bar' title='bar' size='3'>a b c</array>"
			+ "</arrayList>" + CMLConstants.S_EMPTY;
	protected final static String COLUMN_TABLE1_XML = "org/xmlcml/cml/element/examples/misc/columnTable1.xml";
	protected final static String CONTENT_TABLE1_XML = "org/xmlcml/cml/element/examples/misc/contentTable1.xml";
	protected final static String ROW_TABLE1_XML = "org/xmlcml/cml/element/examples/misc/rowTable1.xml";

}
