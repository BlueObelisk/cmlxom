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
import java.io.StringWriter;
import java.net.URL;
import java.util.List;

import nu.xom.ParsingException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.xmlcml.cml.base.CMLBuilder;
import org.xmlcml.cml.base.CMLXOMTestUtils;
import org.xmlcml.cml.element.CMLArrayList;
import org.xmlcml.cml.element.CMLTable;
import org.xmlcml.cml.element.CMLTable.TableType;
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
public class CMLTableTest extends AbstractTableBase {

    
    protected CMLTableRowList tableRowList = null;
	CMLTableRow tableRow = null;
	protected CMLTableContent tableContent = null;
	protected CMLTableHeader tableHeader = null;
	protected CMLArrayList arrayList = null;
	protected CMLTable columnTable1 = null;
	protected CMLTable contentTable1 = null;
	protected CMLTable rowTable1 = null;

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLTable.getRows()'
	 */
    @Test
    public void testGetRows() {
        Assert.assertEquals("rows ", 3, columnTable1.getRows());
        Assert.assertEquals("rows ", 3, contentTable1.getRows());
        Assert.assertEquals("rows ", 3, rowTable1.getRows());
    }

    /**
     * Test method for 'org.xmlcml.cml.element.CMLTable.getColumns()'
     */
    @Test
    public void testGetColumns() {
        Assert.assertEquals("columns ", 2, columnTable1.getColumns());
    }

    /**
     * Test method for 'org.xmlcml.cml.element.CMLTable.writeHTML(Writer)'
     */
    @Test
    public void testWriteHTML() {
        StringWriter sw = new StringWriter();
        try {
            columnTable1.writeHTML(sw);
            sw.close();
        } catch (IOException e) {
            Assert.fail("should not throw " + e);
        }
        String ss = "<table border='1'>\n"
                + "<tr><th>d</th><th>s</th></tr>\n"
                + "<tr><td>1.0</td><td>a</td></tr>\n"
                + "<tr><td>2.0</td><td>b</td></tr>\n"
                + "<tr><td>3.0</td><td>c</td></tr>\n" + "</table>";
        ss = "<span class='table'>table</span>";
        String s = sw.toString();
        Assert.assertEquals("HTML output ", ss, s);
    }

    /**
     * Test method for 'org.xmlcml.cml.element.CMLTable.copy()'
     */
    @Test
    public void testCopy() {
        CMLTable tableX = (CMLTable) columnTable1.copy();
        Assert.assertNotNull("copy not null", tableX);
    }

    /**
     * Test method for 'org.xmlcml.cml.element.CMLTable.getColumnValuesList()'
     */
    @Test
    public void testGetColumnValuesList() {
        List<List <String>> sListList = ((CMLTable) columnTable1).getColumnValuesList();
        Assert.assertEquals("column values", 2, sListList.size());
        List<String> sList0 = sListList.get(0);
        Assert.assertEquals("col 0", new String[]{"1.0", "2.0", "3.0"},
                (String[]) sList0.toArray(new String[0]));
        List<String> sList1 = sListList.get(1);
        Assert.assertEquals("col 1", new String[]{"a", "b", "c"},
                (String[]) sList1.toArray(new String[0]));
    }

    /**
     * Test method for {@link org.xmlcml.cml.element.CMLTable#setTableType(java.lang.String)}.
     */
    @Test
    public final void testSetTableTypeString() {
        columnTable1.setTableType(TableType.COLUMN_BASED.value);
        try {
            columnTable1.setTableType(TableType.CONTENT_BASED.value);
        } catch (RuntimeException e) {
            Assert.assertEquals("set table fails", "bad table", e.getMessage());
        }
        try {
            columnTable1.setTableType(TableType.ROW_BASED.value);
        } catch (RuntimeException e) {
            Assert.assertEquals("set table fails", "bad table", e.getMessage());
        }
    }

    /**
     * Test method for {@link org.xmlcml.cml.element.CMLTable#setTableType(org.xmlcml.cml.element.CMLTable.TableType)}.
     */
    @Test
    public final void testSetTableTypeTableType() {
        columnTable1.setTableType(TableType.COLUMN_BASED);
        try {
            columnTable1.setTableType(TableType.CONTENT_BASED);
        } catch (RuntimeException e) {
            Assert.assertEquals("set table fails", "bad table", e.getMessage());
        }
        try {
            columnTable1.setTableType(TableType.ROW_BASED);
        } catch (RuntimeException e) {
            Assert.assertEquals("set table fails", "bad table", e.getMessage());
        }
    }

    /**
     * Test method for {@link org.xmlcml.cml.element.CMLTable#getTableTypeEnum()}.
     */
    @Test
    public final void testGetTableTypeEnum() {
        TableType tt = columnTable1.getTableTypeEnum();
        Assert.assertTrue("type", tt == TableType.COLUMN_BASED);
        tt = contentTable1.getTableTypeEnum();
        Assert.assertTrue("type", tt == TableType.CONTENT_BASED);
        tt = rowTable1.getTableTypeEnum();
        Assert.assertTrue("type", tt == TableType.ROW_BASED);
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
