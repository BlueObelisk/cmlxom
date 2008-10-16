/**
 * 
 */
package org.xmlcml.cml.element.main;

import static org.xmlcml.cml.base.BaseTest.assertEqualsCanonically;
import static org.xmlcml.cml.base.BaseTest.parseValidString;
import static org.xmlcml.cml.base.CMLConstants.XSD_DOUBLE;
import static org.xmlcml.euclid.EuclidConstants.S_EMPTY;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.xmlcml.cml.element.lite.CMLArray;
import org.xmlcml.cml.element.lite.CMLScalar;
import org.xmlcml.cml.interfacex.HasArraySize;

/**
 * @author pm286
 * 
 */
public class CMLArrayListTest extends AbstractTableBase {

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
		CMLTableHeaderCell expected = (CMLTableHeaderCell) parseValidString(ss);
		assertEqualsCanonically("tableHeaderCell", expected, tableHeaderCell1,
				true);
	}

	/**
	 * Test method for
	 * {@link org.xmlcml.cml.element.CMLArrayList#createTableHeaderCell(org.xmlcml.cml.element.lite.CMLArray)}
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
		CMLTableHeaderCell expected = (CMLTableHeaderCell) parseValidString(ss);
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
		CMLTableHeaderCell expected = (CMLTableHeaderCell) parseValidString(ss);
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
		CMLTableContent expected = (CMLTableContent) parseValidString(ss);
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

}
