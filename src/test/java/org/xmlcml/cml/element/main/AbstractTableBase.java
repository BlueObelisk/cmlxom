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

import static org.xmlcml.cml.base.CMLXOMTestUtils.logger;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import nu.xom.ParsingException;

import org.junit.Assert;
import org.junit.Before;
import org.xmlcml.cml.base.CMLBuilder;
import org.xmlcml.cml.base.CMLConstants;
import org.xmlcml.cml.base.CMLXOMTestUtils;
import org.xmlcml.cml.element.CMLArrayList;
import org.xmlcml.cml.element.CMLTable;
import org.xmlcml.cml.element.CMLTableContent;
import org.xmlcml.cml.element.CMLTableHeader;
import org.xmlcml.cml.element.CMLTableRow;
import org.xmlcml.cml.element.CMLTableRowList;
import org.xmlcml.euclid.Util;

/**
 * test CMLTable.
 * 
 * @author pmr
 * 
 */
public class AbstractTableBase {

	String tableRowListS = CMLConstants.S_EMPTY + "<tableRowList " + CMLConstants.CML_XMLNS + ">"
			+ "  <tableRow>" + "    <tableCell>1</tableCell>"
			+ "    <tableCell>a</tableCell>" + "  </tableRow>" + "  <tableRow>"
			+ "    <tableCell>2</tableCell>" + "    <tableCell>b</tableCell>"
			+ "  </tableRow>" + "  <tableRow>" + "    <tableCell>3</tableCell>"
			+ "    <tableCell>c</tableCell>" + "  </tableRow>"
			+ "</tableRowList>";
	protected CMLTableRowList tableRowList = null;
	CMLTableRow tableRow = null;

	String tableContentS = CMLConstants.S_EMPTY + "<tableContent " + CMLConstants.CML_XMLNS + ">"
			+ "1 a\n" + "2 b\n" + "3 c" + "</tableContent>";
	protected CMLTableContent tableContent = null;

	String tableHeaderS = CMLConstants.S_EMPTY
			+ "<tableHeader "
			+ CMLConstants.CML_XMLNS
			+ ">"
			+ "  <tableHeaderCell id='th1' dictRef='c:foo' title='foo' dataType='xsd:string'/>"
			+ "  <tableHeaderCell id='th2' dictRef='c:bar' title='bar' dataType='xsd:string'/>"
			+ "</tableHeader>" + CMLConstants.S_EMPTY;
	protected CMLTableHeader tableHeader = null;

	String arrayListS = CMLConstants.S_EMPTY
			+ "<arrayList "
			+ CMLConstants.CML_XMLNS
			+ ">"
			+ "  <array id='th1' dictRef='c:foo' title='foo' size='3'>1 2 3</array>"
			+ "  <array id='th2' dictRef='c:bar' title='bar' size='3'>a b c</array>"
			+ "</arrayList>" + CMLConstants.S_EMPTY;
	protected CMLArrayList arrayList = null;

	static String COLUMN_TABLE1_XML = "org/xmlcml/cml/element/examples/misc/columnTable1.xml";
	static String CONTENT_TABLE1_XML = "org/xmlcml/cml/element/examples/misc/contentTable1.xml";
	static String ROW_TABLE1_XML = "org/xmlcml/cml/element/examples/misc/rowTable1.xml";

	protected CMLTable columnTable1 = null;
	protected CMLTable contentTable1 = null;
	protected CMLTable rowTable1 = null;

	/**
	 * setup.
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		/*
		 * <?xml version="1.0" standalone="yes"?> <table rows="3" columns="2"
		 * title="people" xmlns="http://www.xml-cml.org/schema"
		 * xsi:schemaLocation="http://www.xml-cml.org/schema ../../schema.xsd"
		 * xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" > <array
		 * id="a1" title="age" dataType="xsd:integer">3 5 7</array> <array
		 * id="a2" title="name" dataType="xsd:string">Sue Fred Sandy</array>
		 * </table>
		 */
		URL columnUrl1 = null;
		URL contentUrl1 = null;
		URL rowUrl1 = null;
		try {
			columnUrl1 = Util.getResource(COLUMN_TABLE1_XML);
			contentUrl1 = Util.getResource(CONTENT_TABLE1_XML);
			rowUrl1 = Util.getResource(ROW_TABLE1_XML);
		} catch (Exception e) {
			// Saw this once, being cautious. ~~~~jd323
			e.printStackTrace();
		}
		Assert.assertNotNull(columnUrl1);
		Assert.assertNotNull(contentUrl1);
		Assert.assertNotNull(rowUrl1);
		try {
			CMLBuilder builder = new CMLBuilder();
			columnTable1 = (CMLTable) builder.build(
					new File(columnUrl1.toURI())).getRootElement();
			contentTable1 = (CMLTable) builder.build(
					new File(contentUrl1.toURI())).getRootElement();
			rowTable1 = (CMLTable) builder.build(new File(rowUrl1.toURI()))
					.getRootElement();
		} catch (IOException e) {
			e.printStackTrace();
			Assert.fail("Should not throw IOException");
		} catch (ParsingException e) {
			e.printStackTrace();
			logger.error("Parse exception " + e.getMessage());
			Assert.fail("Should not throw ParsingException" + e.getCause());
		}
		tableContent = (CMLTableContent)CMLXOMTestUtils.parseValidString(tableContentS);
		tableHeader = (CMLTableHeader)CMLXOMTestUtils.parseValidString(tableHeaderS);
		tableRowList = (CMLTableRowList)CMLXOMTestUtils.parseValidString(tableRowListS);
		tableRow = tableRowList.getTableRowElements().get(1);
		arrayList = (CMLArrayList)CMLXOMTestUtils.parseValidString(arrayListS);
	}

}
