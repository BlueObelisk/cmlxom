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

import static org.xmlcml.cml.base.CMLConstants.XSD_DOUBLE;
import static org.xmlcml.cml.base.CMLXOMTestUtils.assertEqualsCanonically;
import static org.xmlcml.cml.base.CMLXOMTestUtils.logger;
import static org.xmlcml.euclid.EuclidConstants.S_EMPTY;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import nu.xom.ParsingException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.xmlcml.cml.base.CMLBuilder;
import org.xmlcml.cml.base.CMLXOMTestUtils;
import org.xmlcml.cml.element.CMLArray;
import org.xmlcml.cml.element.CMLArrayList;
import org.xmlcml.cml.element.CMLList;
import org.xmlcml.cml.element.CMLScalar;
import org.xmlcml.cml.element.CMLTable;
import org.xmlcml.cml.element.CMLTableContent;
import org.xmlcml.cml.element.CMLTableHeader;
import org.xmlcml.cml.element.CMLTableHeaderCell;
import org.xmlcml.cml.element.CMLTableRow;
import org.xmlcml.cml.element.CMLTableRowList;
import org.xmlcml.cml.interfacex.HasArraySize;
import org.xmlcml.euclid.Util;

/**
 * @author pm286
 * 
 */
public class CMLArrayListTest extends AbstractTableBase {

	protected CMLTableRowList tableRowList = null;
	CMLTableRow tableRow = null;
	protected CMLTableContent tableContent = null;
	protected CMLTableHeader tableHeader = null;
	protected CMLArrayList arrayList = null;
	protected CMLTable columnTable1 = null;
	protected CMLTable contentTable1 = null;
	protected CMLTable rowTable1 = null;

	/**
	 * Test method for
	 * {@link org.xmlcml.cml.element.CMLArrayList#createTableHeader()}.
	 */
	@Test
	public final void testCreateTableHeader() {
		CMLTableHeader tableHeader1 = arrayList.createTableHeader();
		assertEqualsCanonically("table header", tableHeader1, tableHeader, true);
	}

	/**
	 * Test method for
	 * {@link org.xmlcml.cml.element.CMLArrayList#createTableHeaderCell(CMLArray)}
	 * .
	 */
	@Test
	public final void testCreateTableHeaderCellNode() {
		CMLArray array = new CMLArray();
		array.setDataType(XSD_DOUBLE);
		array.setTitle("my title");
		array.setDictRef("my:dict");
		array.append(1.2);
		array.append(3.4);
		CMLTableHeaderCell tableHeaderCell1 = arrayList
				.createTableHeaderCell(array);
		Assert.assertNotNull("tableHeader not null", tableHeaderCell1);
		String ss = "<tableHeaderCell title='my title' dictRef='my:dict'"
				+ " dataType='xsd:double' xmlns='http://www.xml-cml.org/schema'/>";
		CMLTableHeaderCell expected = (CMLTableHeaderCell)CMLXOMTestUtils.parseValidString(ss);
		assertEqualsCanonically("tableHeaderCell", expected, tableHeaderCell1,
				true);
	}

	/**
	 * Test method for
	 * {@link org.xmlcml.cml.element.CMLArrayList#createTableHeaderCell(org.xmlcml.cml.element.CMLArray)}
	 * .
	 */
	@Test
	public final void testCreateTableHeaderCellCMLArray() {
		CMLArray array = new CMLArray();
		array.setDataType(XSD_DOUBLE);
		array.setTitle("my title");
		array.setDictRef("my:dict");
		array.append(1.2);
		array.append(3.4);
		CMLTableHeaderCell tableHeaderCell1 = arrayList
				.createTableHeaderCell(array);
		Assert.assertNotNull("tableHeader not null", tableHeaderCell1);
		String ss = "<tableHeaderCell title='my title' dictRef='my:dict'"
				+ " dataType='xsd:double' xmlns='http://www.xml-cml.org/schema'/>";
		CMLTableHeaderCell expected = (CMLTableHeaderCell)CMLXOMTestUtils.parseValidString(ss);
		assertEqualsCanonically("tableHeaderCell", expected, tableHeaderCell1,
				true);
	}

	/**
	 * Test method for
	 * {@link org.xmlcml.cml.element.CMLArrayList#createTableHeaderCell(org.xmlcml.cml.element.CMLList)}
	 * .
	 */
	@Test
	public final void testCreateTableHeaderCellCMLList() {
		CMLList list = new CMLList();
		list.setTitle("my title");
		list.setDictRef("my:dict");
		list.appendChild(new CMLScalar(1.2));
		list.appendChild(new CMLScalar(3.4));
		CMLTableHeaderCell tableHeaderCell1 = arrayList
				.createTableHeaderCell(list);
		Assert.assertNotNull("tableHeader not null", tableHeaderCell1);
		String ss = "<tableHeaderCell title='my title' dictRef='my:dict'"
				+ " dataType='array' xmlns='http://www.xml-cml.org/schema'/>";
		CMLTableHeaderCell expected = (CMLTableHeaderCell)CMLXOMTestUtils.parseValidString(ss);
		assertEqualsCanonically("tableHeaderCell", expected, tableHeaderCell1,
				true);
	}

	/**
	 * Test method for {@link org.xmlcml.cml.element.CMLArrayList#getArrays()}.
	 */
	@Test
	public final void testGetListAndArrays() {
		List<HasArraySize> arrays = arrayList.getArrays();
		Assert.assertEquals("arrays", 2, arrays.size());
	}

	/**
	 * Test method for
	 * {@link org.xmlcml.cml.element.CMLArrayList#createTableContent()}.
	 */
	@Test
	public final void testCreateTableContent() {
		CMLTableContent tableContent = arrayList.createTableContent();
		String ss = "<tableContent "
				+ "xmlns='http://www.xml-cml.org/schema'>1 a 2 b 3 c</tableContent>";
		CMLTableContent expected = (CMLTableContent)CMLXOMTestUtils.parseValidString(ss);
		assertEqualsCanonically("tableContent", expected, tableContent, true);
	}

	/**
	 * Test method for
	 * {@link org.xmlcml.cml.element.CMLArrayList#getCommonDelimiter()}.
	 */
	@Test
	public final void testGetCommonDelimiter() {
		String delim = arrayList.getCommonDelimiter();
		Assert.assertEquals("slashDelim", S_EMPTY, delim);
	}

	/**
	 * setup.
	 * 
	 * @throws Exception
	 */
	@Before
	public synchronized void setUp() throws Exception {
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
