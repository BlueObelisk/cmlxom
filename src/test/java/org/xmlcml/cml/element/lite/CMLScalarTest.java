package org.xmlcml.cml.element.lite;

import static org.xmlcml.cml.base.CMLConstants.CML_NS;
import static org.xmlcml.cml.base.CMLConstants.CML_XMLNS;
import static org.xmlcml.cml.base.CMLConstants.SIUNIT_NS;
import static org.xmlcml.cml.base.CMLConstants.UNIT_NS;
import static org.xmlcml.cml.base.CMLConstants.U_CELSIUS;
import static org.xmlcml.cml.base.CMLConstants.U_DEGREE;
import static org.xmlcml.cml.base.CMLConstants.U_KCAL;
import static org.xmlcml.euclid.EuclidConstants.EPS;
import static org.xmlcml.euclid.EuclidConstants.S_EMPTY;
import static org.xmlcml.euclid.test.EuclidTestBase.neverThrow;

import java.io.IOException;
import java.io.StringReader;

import nu.xom.Node;
import nu.xom.ParsingException;
import nu.xom.Text;
import nu.xom.ValidityException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.xmlcml.cml.attribute.DictRefAttribute;
import org.xmlcml.cml.base.CMLBuilder;
import org.xmlcml.cml.base.CMLElement;
import org.xmlcml.cml.element.CMLCml;
import org.xmlcml.cml.element.CMLScalar;

/**
 * tests CMLScalar.
 * 
 * @author pmr
 * 
 */
public class CMLScalarTest {

	protected CMLScalar xomScalarD0 = new CMLScalar(2.1);

	protected CMLScalar xomScalarI0 = new CMLScalar((int) 2);

	protected CMLScalar xomScalarS0 = new CMLScalar("two");

	protected CMLScalar xomScalarD1 = new CMLScalar(2.3);

	protected CMLScalar xomScalarI1 = new CMLScalar((int) 3);

	protected CMLScalar xomScalarS1 = new CMLScalar("three");

	protected CMLScalar xmlScalar;

	protected CMLScalar xmlScalarD0;

	protected CMLScalar xmlScalarI0;

	protected CMLScalar xmlScalarS0;

	protected CMLScalar xmlScalarD1;

	protected CMLScalar xmlScalarI1;

	protected CMLScalar xmlScalarS1;

	CMLBuilder builder = new CMLBuilder();

	String xmlS = "<scalar " + CML_XMLNS + "/>";

	String xmlD0S = "<scalar dataType='xsd:double' " + CML_XMLNS
			+ ">2.1</scalar>";

	String xmlDNaNOK = "<scalar dataType='xsd:double' " + CML_XMLNS
			+ ">NaN</scalar>";

	String xmlI0S = "<scalar dataType='xsd:integer' " + CML_XMLNS
			+ ">2</scalar>";

	String xmlS0S = "<scalar dataType='xsd:string' " + CML_XMLNS
			+ ">two</scalar>";

	String xmlD1S = "<scalar dataType='xsd:double' " + CML_XMLNS
			+ ">2.3</scalar>";

	String xmlI1S = "<scalar dataType='xsd:integer' " + CML_XMLNS
			+ ">3</scalar>";

	String xmlS1S = "<scalar dataType='xsd:string' " + CML_XMLNS
			+ ">three</scalar>";

	String xmlBad1 = "<scalar dataType='xsd:double' " + CML_XMLNS
			+ ">three</scalar>";

	String xmlBad2 = "<scalar dataType='xsd:integer' " + CML_XMLNS
			+ ">2.1</scalar>";

	String unitsS = S_EMPTY + "<c:cml " + " id='a234234' " + "  xmlns:c='"
			+ CML_NS + "' " + "  xmlns:siUnits='" + SIUNIT_NS + "' "
			+ "  xmlns:units='" + UNIT_NS + "' " + ">"
			+ "<c:scalar id='s1' dictRef='cmlDict:angle' units='" + U_DEGREE
			+ "' " + "  dataType='xsd:double'>180</c:scalar>"
			+ "<c:scalar id='s2' dictRef='foo:bar' units='" + U_KCAL + "' "
			+ "  dataType='xsd:double'>100</c:scalar>"
			+ "<c:scalar id='s3' dictRef='foo:mpt' units='" + U_CELSIUS + "' "
			+ "  dataType='xsd:double'>100</c:scalar>" + "</c:cml>";

	/**
	 * setup.
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		xmlScalar = (CMLScalar) builder.build(new StringReader(xmlS))
				.getRootElement();

		xmlScalarD0 = (CMLScalar) builder.build(new StringReader(xmlD0S))
				.getRootElement();
		xmlScalarI0 = (CMLScalar) builder.build(new StringReader(xmlI0S))
				.getRootElement();
		xmlScalarS0 = (CMLScalar) builder.build(new StringReader(xmlS0S))
				.getRootElement();

		xmlScalarD1 = (CMLScalar) builder.build(new StringReader(xmlD1S))
				.getRootElement();
		xmlScalarI1 = (CMLScalar) builder.build(new StringReader(xmlI1S))
				.getRootElement();
		xmlScalarS1 = (CMLScalar) builder.build(new StringReader(xmlS1S))
				.getRootElement();

	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLScalar build'
	 */
	@Test
	public void testParse() {
		try {
			builder.build(new StringReader(xmlBad1));
			Assert.fail("should throw parse exception");
		} catch (ValidityException e) {
			Assert.fail("should be valid");
		} catch (ParsingException e) {
			Assert.assertTrue(true);
		} catch (IOException e) {
			Assert.fail("should not throw IO");
		} catch (RuntimeException e) {
			// this catches the bad values
		}
		try {
			builder.build(new StringReader(xmlBad2));
			Assert.fail("should throw parse exception");
		} catch (ValidityException e) {
			Assert.fail("should be valid");
		} catch (ParsingException e) {
			Assert.assertEquals("should fail to parse",
					"bad integer content: 2.1", e.getMessage());
		} catch (IOException e) {
			Assert.fail("should not throw IO");
		} catch (RuntimeException e) {
			// this catches the bad values
		}

	}

	@Test
	public void testNaNParse() throws ValidityException, ParsingException,
			IOException {
		CMLScalar cs = (CMLScalar) builder.build(new StringReader(xmlDNaNOK))
				.getRootElement();
		Assert.assertEquals(Double.NaN, cs.getDouble());
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLScalar.getDataType()'
	 */
	@Test
	public void testGetDataType() {
		Assert.assertEquals("data type", CMLElement.XSD_STRING, xomScalarS0
				.getDataType());
		Assert.assertEquals("data type", CMLElement.XSD_DOUBLE, xomScalarD0
				.getDataType());
		Assert.assertEquals("data type", CMLElement.XSD_INTEGER, xomScalarI0
				.getDataType());

		Assert.assertEquals("data type", CMLElement.XSD_STRING, xmlScalarS0
				.getDataType());
		Assert.assertEquals("data type", CMLElement.XSD_DOUBLE, xmlScalarD0
				.getDataType());
		Assert.assertEquals("data type", CMLElement.XSD_INTEGER, xmlScalarI0
				.getDataType());

	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLScalar.setDataType(String)'
	 */
	@Test
	public void testSetDataType() {
		try {
			xomScalarS0.setDataType(CMLElement.XSD_DOUBLE);
			Assert.fail("should throw CMLRuntime");
		} catch (RuntimeException e) {
			Assert.assertEquals("cannot set dataType",
					"Must not reset dataType; use SetValue(...)", e
							.getMessage());
		}

	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLScalar.CMLScalar()'
	 */
	@Test
	public void testCMLScalar() {
		CMLScalar copy = new CMLScalar();
		Assert.assertNotNull("new CMLScalar", copy);
		Assert.assertEquals("data type", CMLElement.XSD_STRING, copy
				.getDataType());
		Assert.assertEquals("value", S_EMPTY, copy.getString());
		Assert.assertEquals("value", S_EMPTY, copy.getXMLContent());
		int nchild = copy.getChildCount();
		Assert.assertEquals("should be no text child", 0, nchild);

	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLScalar.CMLScalar(CMLScalar)'
	 */
	@Test
	public void testCMLScalarCMLScalar() {
		CMLScalar copy = new CMLScalar(xomScalarD0);
		Assert.assertNotNull("new CMLScalar", copy);
		Assert.assertEquals("data type", copy.getDataType(), xomScalarD0
				.getDataType());
		Assert.assertEquals("value", copy.getDouble(), xomScalarD0.getDouble(),
				EPS);
		int nchild = copy.getChildCount();
		Assert.assertEquals("should be a text child", 1, nchild);
		Node child = copy.getChild(0);
		Assert.assertTrue("text node", child instanceof Text);
		Assert.assertEquals("text value", "2.1", child.getValue());

	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLScalar.CMLScalar(String)'
	 */
	@Test
	public void testCMLScalarString() {
		CMLScalar s = new CMLScalar("foo");
		Assert.assertNotNull("new CMLScalar", s);
		Assert
				.assertEquals("data type", CMLElement.XSD_STRING, s
						.getDataType());
		Assert.assertEquals("value", "foo", s.getString());
		int nchild = s.getChildCount();
		Assert.assertEquals("should be a text child", 1, nchild);
		Node child = s.getChild(0);
		Assert.assertTrue("text node", child instanceof Text);
		Assert.assertEquals("text value", "foo", child.getValue());

	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLScalar.CMLScalar(double)'
	 */
	@Test
	public void testCMLScalarDouble() {
		CMLScalar s = new CMLScalar(3.4);
		Assert.assertNotNull("new CMLScalar", s);
		Assert
				.assertEquals("data type", CMLElement.XSD_DOUBLE, s
						.getDataType());
		Assert.assertEquals("value", 3.4, s.getDouble(), EPS);
		int nchild = s.getChildCount();
		Assert.assertEquals("should be a text child", 1, nchild);
		Node child = s.getChild(0);
		Assert.assertTrue("text node", child instanceof Text);
		Assert.assertEquals("text value", "3.4", child.getValue());

	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLScalar.CMLScalar(int)'
	 */
	@Test
	public void testCMLScalarInt() {
		CMLScalar s = new CMLScalar(98);
		Assert.assertNotNull("new CMLScalar", s);
		Assert.assertEquals("data type", CMLElement.XSD_INTEGER, s
				.getDataType());
		Assert.assertEquals("value", 98, s.getInt());

	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLScalar.getString()'
	 */
	@Test
	public void testGetString() {
		CMLScalar s = new CMLScalar("foo");
		Assert.assertNotNull("new CMLScalar", s);
		Assert
				.assertEquals("data type", CMLElement.XSD_STRING, s
						.getDataType());
		Assert.assertEquals("value", "foo", s.getString());
		CMLScalar d = new CMLScalar(2.1);
		Assert
				.assertEquals("data type", CMLElement.XSD_DOUBLE, d
						.getDataType());
		Assert.assertNull("value", d.getString());
		Assert.assertEquals("value", 2.1, d.getDouble(), EPS);

		Assert.assertNull("double", xmlScalarD0.getString());
		Assert.assertNull("integer", xmlScalarI0.getString());
		Assert.assertEquals("string", "two", xmlScalarS0.getString());

	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLScalar.getDouble()'
	 */
	@Test
	public void testGetDouble() {
		CMLScalar d = new CMLScalar(2.1);
		Assert
				.assertEquals("data type", CMLElement.XSD_DOUBLE, d
						.getDataType());
		Assert.assertEquals("value", 2.1, d.getDouble(), EPS);
		CMLScalar s = new CMLScalar("foo");
		Assert.assertNotNull("new CMLScalar", s);
		Assert
				.assertEquals("data type", CMLElement.XSD_STRING, s
						.getDataType());
		Assert.assertTrue("value", Double.isNaN(s.getDouble()));

		Assert.assertEquals("integer", Double.NaN, xmlScalarI0.getDouble());
		Assert.assertEquals("string", Double.NaN, xmlScalarS0.getDouble());
		Assert.assertEquals("double", 2.1, xmlScalarD0.getDouble());
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLScalar.getInt()'
	 */
	@Test
	public void testGetInt() {
		CMLScalar i = new CMLScalar((int) 2);
		Assert.assertEquals("data type", CMLElement.XSD_INTEGER, i
				.getDataType());
		Assert.assertEquals("value", 2, i.getInt());
		CMLScalar s = new CMLScalar("foo");
		Assert.assertNotNull("new CMLScalar", s);
		Assert
				.assertEquals("data type", CMLElement.XSD_STRING, s
						.getDataType());
		try {
			s.getInt();
			Assert.fail("should throw CMLRuntime");
		} catch (RuntimeException e) {
			Assert.assertEquals("ok", "ok");
		}

		try {
			xmlScalarD0.getInt();
			Assert.fail("should throw runtime");
		} catch (RuntimeException e) {
			Assert.assertEquals("not integer",
					"wrong dataType for int xsd:double", e.getMessage());
		}
		try {
			xmlScalarS0.getInt();
			Assert.fail("should throw runtime");
		} catch (RuntimeException e) {
			Assert.assertEquals("not integer",
					"wrong dataType for int xsd:string", e.getMessage());
		}
		Assert.assertEquals("integer", 2, xmlScalarI0.getInt());
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLScalar.setValue(String)'
	 */
	@Test
	public void testSetValueString() {
		CMLScalar s = new CMLScalar("foo");
		Assert.assertNotNull("new CMLScalar", s);
		Assert
				.assertEquals("data type", CMLElement.XSD_STRING, s
						.getDataType());
		Assert.assertEquals("value", "foo", s.getString());
		int nchild = s.getChildCount();
		Assert.assertEquals("should be a text child", 1, nchild);
		Node child = s.getChild(0);
		Assert.assertTrue("text node", child instanceof Text);
		Assert.assertEquals("text value", "foo", child.getValue());

		s.setValue("bar");
		Assert
				.assertEquals("data type", CMLElement.XSD_STRING, s
						.getDataType());
		Assert.assertEquals("value", "bar", s.getString());
		nchild = s.getChildCount();
		Assert.assertEquals("should be a text child", 1, nchild);
		child = s.getChild(0);
		Assert.assertTrue("text node", child instanceof Text);
		Assert.assertEquals("text value", "bar", child.getValue());

		s.setValue(1.2);
		Assert
				.assertEquals("data type", CMLElement.XSD_DOUBLE, s
						.getDataType());
		Assert.assertEquals("value", 1.2, s.getDouble(), EPS);
		Assert.assertNull("value", s.getString());
		nchild = s.getChildCount();
		Assert.assertEquals("should be a text child", 1, nchild);
		child = s.getChild(0);
		Assert.assertTrue("text node", child instanceof Text);
		Assert.assertEquals("text value", "1.2", child.getValue());

		s.setValue("plugh");
		Assert
				.assertEquals("data type", CMLElement.XSD_STRING, s
						.getDataType());
		Assert.assertEquals("value", "plugh", s.getString());
		nchild = s.getChildCount();
		Assert.assertEquals("should be a text child", 1, nchild);
		child = s.getChild(0);
		Assert.assertTrue("text node", child instanceof Text);
		Assert.assertEquals("text value", "plugh", child.getValue());
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLScalar.setValue(double)'
	 */
	@Test
	public void testSetValueDouble() {
		CMLScalar s = new CMLScalar(2.3);
		Assert.assertNotNull("new CMLScalar", s);
		Assert
				.assertEquals("data type", CMLElement.XSD_DOUBLE, s
						.getDataType());
		Assert.assertNull("value", s.getString());
		Assert.assertEquals("value", 2.3, s.getDouble(), EPS);
		s.setValue(4.5);
		Assert
				.assertEquals("data type", CMLElement.XSD_DOUBLE, s
						.getDataType());
		Assert.assertEquals("value", 4.5, s.getDouble(), EPS);
		s.setValue(1.2);
		s.setValue("plugh");
		Assert
				.assertEquals("data type", CMLElement.XSD_STRING, s
						.getDataType());
		Assert.assertEquals("value", "plugh", s.getString());
		Assert.assertTrue("value", Double.isNaN(s.getDouble()));
		s.setValue(6.2);
		Assert
				.assertEquals("data type", CMLElement.XSD_DOUBLE, s
						.getDataType());
		Assert.assertEquals("value", 6.2, s.getDouble(), EPS);

	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLScalar.setValue(int)'
	 */
	@Test
	public void testSetValueInt() {
		CMLScalar s = new CMLScalar((int) 2);
		Assert.assertNotNull("new CMLScalar", s);
		Assert.assertEquals("data type", CMLElement.XSD_INTEGER, s
				.getDataType());
		Assert.assertNull("value", s.getString());
		Assert.assertEquals("value", 2, s.getInt());
		s.setValue((int) 4);
		Assert.assertEquals("data type", CMLElement.XSD_INTEGER, s
				.getDataType());
		Assert.assertEquals("value", 4, s.getInt());
		s.setValue("plugh");
		Assert
				.assertEquals("data type", CMLElement.XSD_STRING, s
						.getDataType());
		Assert.assertEquals("value", "plugh", s.getString());
		try {
			s.getInt();
			Assert.fail("should throw CMLRuntime");
		} catch (RuntimeException e) {
			;
		}
		s.setValue(6);
		Assert.assertEquals("data type", CMLElement.XSD_INTEGER, s
				.getDataType());
		Assert.assertEquals("value", 6, s.getInt());

	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLScalar.subtract(CMLScalar)'
	 */
	@Test
	public void testSubtract() {
		CMLScalar s1 = new CMLScalar((int) 7);
		Assert.assertNotNull("new CMLScalar", s1);
		Assert.assertEquals("data type", CMLElement.XSD_INTEGER, s1
				.getDataType());
		Assert.assertEquals("value", 7, s1.getInt());
		CMLScalar s2 = new CMLScalar((int) 4);
		Assert.assertNotNull("new CMLScalar", s2);
		Assert.assertEquals("data type", CMLElement.XSD_INTEGER, s2
				.getDataType());
		Assert.assertEquals("value", 4, s2.getInt());
		CMLScalar s3 = s1.subtract(s2);
		Assert.assertNotNull("new CMLScalar", s3);
		Assert.assertEquals("data type", CMLElement.XSD_INTEGER, s3
				.getDataType());
		Assert.assertEquals("value", 3, s3.getInt());
		Assert.assertNotNull("new CMLScalar", s1);
		Assert.assertEquals("data type", CMLElement.XSD_INTEGER, s1
				.getDataType());
		Assert.assertEquals("value", 7, s1.getInt());
		Assert.assertNotNull("new CMLScalar", s2);
		Assert.assertEquals("data type", CMLElement.XSD_INTEGER, s2
				.getDataType());
		Assert.assertEquals("value", 4, s2.getInt());

		CMLScalar s4 = new CMLScalar(3.2);
		Assert.assertNotNull("new CMLScalar", s4);
		Assert.assertEquals("data type", CMLElement.XSD_DOUBLE, s4
				.getDataType());
		Assert.assertEquals("value", 3.2, s4.getDouble());
		try {
			s3 = s1.subtract(s4);
			Assert.fail("should throw CMLexception ");
		} catch (Exception e) {
			Assert
					.assertEquals(
							"throws CMLException ",
							"Unsuitable dataTypes for numeric operations / xsd:integer/xsd:double",
							e.getMessage());
		}

		CMLScalar s11 = new CMLScalar(7.5);
		Assert.assertNotNull("new CMLScalar", s11);
		Assert.assertEquals("data type", CMLElement.XSD_DOUBLE, s11
				.getDataType());
		Assert.assertEquals("value", 7.5, s11.getDouble(), EPS);
		CMLScalar s12 = new CMLScalar(4.4);
		Assert.assertNotNull("new CMLScalar", s12);
		Assert.assertEquals("data type", CMLElement.XSD_DOUBLE, s12
				.getDataType());
		Assert.assertEquals("value", 4.4, s12.getDouble());
		CMLScalar s13 = s11.subtract(s12);
		Assert.assertNotNull("old CMLScalar", s11);
		Assert.assertEquals("data type", CMLElement.XSD_DOUBLE, s11
				.getDataType());
		Assert.assertEquals("value", 7.5, s11.getDouble(), EPS);
		Assert.assertNotNull("new CMLScalar", s12);
		Assert.assertEquals("data type", CMLElement.XSD_DOUBLE, s12
				.getDataType());
		Assert.assertEquals("value", 4.4, s12.getDouble(), EPS);
		Assert.assertNotNull("new CMLScalar", s13);
		Assert.assertEquals("data type", CMLElement.XSD_DOUBLE, s13
				.getDataType());
		Assert.assertEquals("value", 3.1, s13.getDouble(), EPS);
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLScalar.subtractEquals(CMLScalar)'
	 */
	@Test
	public void testSubtractEquals() {
		CMLScalar s1 = new CMLScalar((int) 7);
		Assert.assertNotNull("new CMLScalar", s1);
		Assert.assertEquals("data type", CMLElement.XSD_INTEGER, s1
				.getDataType());
		Assert.assertEquals("value", 7, s1.getInt());
		CMLScalar s2 = new CMLScalar((int) 4);
		Assert.assertNotNull("new CMLScalar", s2);
		Assert.assertEquals("data type", CMLElement.XSD_INTEGER, s2
				.getDataType());
		Assert.assertEquals("value", 4, s2.getInt());
		s1.subtractEquals(s2);
		Assert.assertNotNull("old CMLScalar", s1);
		Assert.assertEquals("data type", CMLElement.XSD_INTEGER, s1
				.getDataType());
		Assert.assertEquals("value", 3, s1.getInt());
		Assert.assertNotNull("new CMLScalar", s2);
		Assert.assertEquals("data type", CMLElement.XSD_INTEGER, s2
				.getDataType());
		Assert.assertEquals("value", 4, s2.getInt());

		CMLScalar s4 = new CMLScalar(3.2);
		Assert.assertNotNull("new CMLScalar", s4);
		Assert.assertEquals("data type", CMLElement.XSD_DOUBLE, s4
				.getDataType());
		Assert.assertEquals("value", 3.2, s4.getDouble());
		try {
			s1.subtract(s4);
			Assert.fail("should throw CMLexception ");
		} catch (Exception e) {
			Assert
					.assertEquals(
							"throws CMLException ",
							"Unsuitable dataTypes for numeric operations / xsd:integer/xsd:double",
							e.getMessage());
		}

		CMLScalar s11 = new CMLScalar(7.5);
		Assert.assertNotNull("new CMLScalar", s11);
		Assert.assertEquals("data type", CMLElement.XSD_DOUBLE, s11
				.getDataType());
		Assert.assertEquals("value", 7.5, s11.getDouble(), EPS);
		CMLScalar s12 = new CMLScalar(4.4);
		Assert.assertNotNull("new CMLScalar", s12);
		Assert.assertEquals("data type", CMLElement.XSD_DOUBLE, s12
				.getDataType());
		Assert.assertEquals("value", 4.4, s12.getDouble());
		s11.subtractEquals(s12);
		Assert.assertNotNull("old CMLScalar", s11);
		Assert.assertEquals("data type", CMLElement.XSD_DOUBLE, s11
				.getDataType());
		Assert.assertEquals("value", 3.1, s11.getDouble(), EPS);
		Assert.assertNotNull("new CMLScalar", s12);
		Assert.assertEquals("data type", CMLElement.XSD_DOUBLE, s12
				.getDataType());
		Assert.assertEquals("value", 4.4, s12.getDouble(), EPS);

	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLScalar.plus(CMLScalar)'
	 */
	@Test
	public void testPlus() {
		CMLScalar s1 = new CMLScalar((int) 7);
		Assert.assertNotNull("new CMLScalar", s1);
		Assert.assertEquals("data type", CMLElement.XSD_INTEGER, s1
				.getDataType());
		Assert.assertEquals("value", 7, s1.getInt());
		CMLScalar s2 = new CMLScalar((int) 4);
		Assert.assertNotNull("new CMLScalar", s2);
		Assert.assertEquals("data type", CMLElement.XSD_INTEGER, s2
				.getDataType());
		Assert.assertEquals("value", 4, s2.getInt());
		CMLScalar s3 = s1.plus(s2);
		Assert.assertNotNull("new CMLScalar", s3);
		Assert.assertEquals("data type", CMLElement.XSD_INTEGER, s3
				.getDataType());
		Assert.assertEquals("value", 11, s3.getInt());
		Assert.assertNotNull("new CMLScalar", s1);
		Assert.assertEquals("data type", CMLElement.XSD_INTEGER, s1
				.getDataType());
		Assert.assertEquals("value", 7, s1.getInt());
		Assert.assertNotNull("new CMLScalar", s2);
		Assert.assertEquals("data type", CMLElement.XSD_INTEGER, s2
				.getDataType());
		Assert.assertEquals("value", 4, s2.getInt());

		CMLScalar s4 = new CMLScalar(3.2);
		Assert.assertNotNull("new CMLScalar", s4);
		Assert.assertEquals("data type", CMLElement.XSD_DOUBLE, s4
				.getDataType());
		Assert.assertEquals("value", 3.2, s4.getDouble());
		try {
			s3 = s1.subtract(s4);
			Assert.fail("should throw CMLexception ");
		} catch (Exception e) {
			Assert
					.assertEquals(
							"throws CMLException ",
							"Unsuitable dataTypes for numeric operations / xsd:integer/xsd:double",
							e.getMessage());
		}

		CMLScalar s11 = new CMLScalar(7.5);
		Assert.assertNotNull("new CMLScalar", s11);
		Assert.assertEquals("data type", CMLElement.XSD_DOUBLE, s11
				.getDataType());
		Assert.assertEquals("value", 7.5, s11.getDouble(), EPS);
		CMLScalar s12 = new CMLScalar(4.4);
		Assert.assertNotNull("new CMLScalar", s12);
		Assert.assertEquals("data type", CMLElement.XSD_DOUBLE, s12
				.getDataType());
		Assert.assertEquals("value", 4.4, s12.getDouble());
		CMLScalar s13 = s11.plus(s12);
		Assert.assertNotNull("old CMLScalar", s11);
		Assert.assertEquals("data type", CMLElement.XSD_DOUBLE, s11
				.getDataType());
		Assert.assertEquals("value", 7.5, s11.getDouble(), EPS);
		Assert.assertNotNull("new CMLScalar", s12);
		Assert.assertEquals("data type", CMLElement.XSD_DOUBLE, s12
				.getDataType());
		Assert.assertEquals("value", 4.4, s12.getDouble(), EPS);
		Assert.assertNotNull("new CMLScalar", s13);
		Assert.assertEquals("data type", CMLElement.XSD_DOUBLE, s13
				.getDataType());
		Assert.assertEquals("value", 11.9, s13.getDouble(), EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLScalar.plusEquals(CMLScalar)'
	 */
	@Test
	public void testPlusEquals() {
		CMLScalar s1 = new CMLScalar((int) 7);
		Assert.assertNotNull("new CMLScalar", s1);
		Assert.assertEquals("data type", CMLElement.XSD_INTEGER, s1
				.getDataType());
		Assert.assertEquals("value", 7, s1.getInt());
		CMLScalar s2 = new CMLScalar((int) 4);
		Assert.assertNotNull("new CMLScalar", s2);
		Assert.assertEquals("data type", CMLElement.XSD_INTEGER, s2
				.getDataType());
		Assert.assertEquals("value", 4, s2.getInt());
		s1.plusEquals(s2);
		Assert.assertNotNull("old CMLScalar", s1);
		Assert.assertEquals("data type", CMLElement.XSD_INTEGER, s1
				.getDataType());
		Assert.assertEquals("value", 11, s1.getInt());
		Assert.assertNotNull("new CMLScalar", s2);
		Assert.assertEquals("data type", CMLElement.XSD_INTEGER, s2
				.getDataType());
		Assert.assertEquals("value", 4, s2.getInt());

		CMLScalar s4 = new CMLScalar(3.2);
		Assert.assertNotNull("new CMLScalar", s4);
		Assert.assertEquals("data type", CMLElement.XSD_DOUBLE, s4
				.getDataType());
		Assert.assertEquals("value", 3.2, s4.getDouble());
		try {
			s1.subtract(s4);
			Assert.fail("should throw CMLexception ");
		} catch (Exception e) {
			Assert
					.assertEquals(
							"throws CMLException ",
							"Unsuitable dataTypes for numeric operations / xsd:integer/xsd:double",
							e.getMessage());
		}

		CMLScalar s11 = new CMLScalar(7.5);
		Assert.assertNotNull("new CMLScalar", s11);
		Assert.assertEquals("data type", CMLElement.XSD_DOUBLE, s11
				.getDataType());
		Assert.assertEquals("value", 7.5, s11.getDouble(), EPS);
		CMLScalar s12 = new CMLScalar(4.4);
		Assert.assertNotNull("new CMLScalar", s12);
		Assert.assertEquals("data type", CMLElement.XSD_DOUBLE, s12
				.getDataType());
		Assert.assertEquals("value", 4.4, s12.getDouble());
		s11.plusEquals(s12);
		Assert.assertNotNull("old CMLScalar", s11);
		Assert.assertEquals("data type", CMLElement.XSD_DOUBLE, s11
				.getDataType());
		Assert.assertEquals("value", 11.9, s11.getDouble(), EPS);
		Assert.assertNotNull("new CMLScalar", s12);
		Assert.assertEquals("data type", CMLElement.XSD_DOUBLE, s12
				.getDataType());
		Assert.assertEquals("value", 4.4, s12.getDouble(), EPS);

	}

	// /**
	// * test units.
	// *
	// */
	// @Test
	// public void testGetUnits() {
	// CMLCml cml = (CMLCml) parseValidString(unitsS);
	//
	// // scalars
	// List<CMLElement> scalars = cml.getElements(".//" + CMLScalar.NS);
	// Assert.assertEquals("scalar count", 3, scalars.size());
	// CMLScalar scalar = (CMLScalar) scalars.get(0);
	// UnitsAttribute unitsAttribute = (UnitsAttribute) scalar
	// .getUnitsAttribute();
	// Assert.assertNotNull("units attribute not null", unitsAttribute);
	// CMLUnit unit = unitsUnitListMap.getUnit(unitsAttribute);
	// Assert.assertNotNull("unit not null", unit);
	// Assert.assertEquals("unit ", "deg", unit.getId());
	// }

	// /**
	// * test conversion to SI.
	// *
	// */
	// @Test
	// public void testConvertToSI() {
	// CMLCml cml = null;
	// try {
	// cml = (CMLCml) new CMLBuilder().build(new StringReader(unitsS))
	// .getRootElement();
	// } catch (Exception e) {
	// e.printStackTrace();
	// Assert.fail("should not throw " + e);
	// }
	//
	// // scalars
	// List<CMLElement> scalars = cml.getElements(".//" + CMLScalar.NS);
	// Assert.assertEquals("scalar count", 3, scalars.size());
	// CMLScalar scalar0 = (CMLScalar) scalars.get(0);
	// Assert.assertEquals("scalar0", 180., scalar0.getDouble(), EPS);
	// Assert.assertEquals("scalar0", U_DEGREE, scalar0.getUnits());
	// scalar0.convertToSI(unitsUnitListMap);
	// Assert.assertEquals("scalar0", Math.PI, scalar0.getDouble(), .000001);
	// Assert.assertEquals("scalar0", CML_SIUNITS + S_COLON + "radian",
	// scalar0.getUnits());
	//
	// CMLScalar scalar1 = (CMLScalar) scalars.get(1);
	// Assert.assertEquals("scalar1", 100, scalar1.getDouble(), EPS);
	// Assert.assertEquals("scalar1", U_KCAL, scalar1.getUnits());
	// scalar1.convertToSI(unitsUnitListMap);
	// Assert.assertEquals("scalar1", 4.184E+05, scalar1.getDouble(), 1);
	// Assert.assertEquals("scalar1", CML_SIUNITS + S_COLON + "joule", scalar1
	// .getUnits());
	//
	// CMLScalar scalar2 = (CMLScalar) scalars.get(2);
	// Assert.assertEquals("scalar2", 100, scalar2.getDouble(), EPS);
	// Assert.assertEquals("scalar2", U_CELSIUS, scalar2.getUnits());
	// scalar2.convertToSI(unitsUnitListMap);
	// Assert.assertEquals("scalar2", 373.15, scalar2.getDouble(), EPS);
	// Assert.assertEquals("scalar2", CML_SIUNITS + S_COLON + "k", scalar2
	// .getUnits());
	// }

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLScalar.copy()'
	 */
	@Test
	public void testCopy() {
		CMLScalar ss = (CMLScalar) xomScalarD0.copy();
		Assert.assertEquals("copy", ss.getDouble(), xomScalarD0.getDouble(),
				EPS);
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLScalar.getDictRefFromElementOrParent()'
	 */
	@Test
	public void testGetDictRefFromElementOrParent() {
		CMLCml cml = null;
		try {
			cml = (CMLCml) new CMLBuilder().parseString(unitsS);
		} catch (Exception e) {
			neverThrow(e);
		}
		CMLScalar scalar = (CMLScalar) cml.getChildCMLElements("scalar").get(0);
		DictRefAttribute dictRef = scalar.getDictRefFromElementOrParent();
		Assert.assertNotNull("dictRef not null", dictRef);
		Assert.assertEquals("dictRef", "cmlDict:angle", dictRef.getCMLValue());
	}

	// /**
	// * Test method for
	// * 'org.xmlcml.cml.element.CMLScalar.getUnit(NamespaceToUnitListMap)'
	// */
	// @Test
	// public void testGetUnit() {
	// CMLCml cml = null;
	// try {
	// cml = (CMLCml) new CMLBuilder().parseString(unitsS);
	// } catch (Exception e) {
	// neverThrow(e);
	// }
	// CMLScalar scalar = (CMLScalar) cml.getChildCMLElements("scalar").get(0);
	// CMLUnit unit = scalar.getUnit(unitsUnitListMap);
	// Assert.assertNotNull("unit not null", unit);
	// }

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLScalar.setUnits(String,
	 * String)'
	 */
	@Test
	public void testSetUnitsStringString() {
		xmlScalarD0.setUnits("units", "g", UNIT_NS);
		Assert.assertEquals("set units", "units:g", xmlScalarD0.getUnits());
		Assert.assertEquals("set units", UNIT_NS, xmlScalarD0
				.getNamespaceURIForPrefix("units"));
	}

}
