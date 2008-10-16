package org.xmlcml.cml.element.main;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.xmlcml.cml.element.main.CMLTable.TableType;

/**
 * test CMLTable.
 *
 * @author pmr
 *
 */
public class CMLTableTest extends AbstractTableBase {

    
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

 }
