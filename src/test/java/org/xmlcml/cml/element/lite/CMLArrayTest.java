package org.xmlcml.cml.element.lite;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.xmlcml.cml.attribute.DelimiterAttribute;
import org.xmlcml.cml.attribute.DelimiterAttribute.Action;
import org.xmlcml.cml.base.CC;
import org.xmlcml.cml.base.CMLBuilder;
import org.xmlcml.cml.base.CMLConstants;
import org.xmlcml.cml.base.CMLXOMTestUtils;
import org.xmlcml.cml.element.CMLArray;
import org.xmlcml.cml.element.CMLScalar;
import org.xmlcml.euclid.EC;
import org.xmlcml.euclid.Int;
import org.xmlcml.euclid.test.DoubleTestBase;
import org.xmlcml.euclid.test.StringTestBase;

/**
 * test Array
 * 
 * @author pmr
 * 
 */
public class CMLArrayTest {

	final static double EPS = 0.0000000001;

	int[] i0 = { 1, 2, 3, 4, 5 };

	int[] i1 = { 10, 20, 30, 40, 50 };

	double[] d0 = { 1., 2., 3., 4., 5. };

	double[] d1 = { 10., 20., 30., 40., 50. };

	String[] s0 = { "a", "b", "c", "d", "e" };

	String[] s1 = { "vector", "w", "x", "y", "z" };

	String slashDelim = EC.S_SLASH;

	CMLArray xomS;

	CMLArray xomI0;

	CMLArray xomI1;

	CMLArray xomD0;

	CMLArray xomD1;

	CMLArray xomS0;

	CMLArray xomS1;

	String xmlSS = "<array " + CMLConstants.CML_XMLNS + "/>";

	CMLArray xmlS;

	CMLArray xmlI0;

	CMLArray xmlI1;

	CMLArray xmlD0;

	CMLArray xmlD1;

	CMLArray xmlS0;

	CMLArray xmlS1;

	String unitsS = "<c:cml " + "id='a234234' " + "xmlns:c='" + CMLConstants.CML_NS + "' "
			+ "xmlns:siUnits='" + CC.SIUNIT_NS + "' " + "xmlns:units='" + CC.UNIT_NS
			+ "' " + ">" + "<c:array id='s1' dictRef='cmlDict:angle' units='"
			+ CC.U_DEGREE + "' " + "  dataType='xsd:double'>180 90 45 0</c:array>"
			+ "<c:array id='s2' dictRef='foo:bar' units='" + CC.U_KCAL + "' "
			+ "  dataType='xsd:double'>100 50 0 -25</c:array>"
			+ "<c:array id='s3' dictRef='foo:mpt' units='" + CC.U_CELSIUS + "' "
			+ "  dataType='xsd:double'>100 50 0 -50</c:array>" + "</c:cml>";

	/**
	 * setup.
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		try {

			xomS = new CMLArray();
			xmlS = (CMLArray)CMLXOMTestUtils.parseValidString(xmlSS);
			xomD0 = new CMLArray(d0);
			xomI0 = new CMLArray(i0);
			xomS0 = new CMLArray(s0);

			xomD1 = new CMLArray(d1, slashDelim);
			xomI1 = new CMLArray(i1, slashDelim);
			xomS1 = new CMLArray(s1, slashDelim);

			// note these are String arrays
			String xmlS0S = "<array " + CMLConstants.CML_XMLNS + ">1 2 3 4 5</array>";

			String xmlS1S = "<array delimiter='/' " + CMLConstants.CML_XMLNS
					+ ">/100/200/300/400/500/</array>";

			// while these are ints
			String xmlI0S = "<array dataType='xsd:integer' " + CMLConstants.CML_XMLNS
					+ ">1 2 3 4 5</array>";

			String xmlI1S = "<array dataType='xsd:integer' delimiter='/' "
					+ CMLConstants.CML_XMLNS + ">/10/20/30/40/50/</array>";

			String xmlD0S = "<array dataType='xsd:double' " + CMLConstants.CML_XMLNS
					+ ">1. 2. 3. 4. 5.</array>";

			String xmlD1S = "<array dataType='xsd:double' delimiter='/' "
					+ CMLConstants.CML_XMLNS + ">/10./20./30./40./50./</array>";

			xmlS0 = (CMLArray)CMLXOMTestUtils.parseValidString(xmlS0S);
			xmlS1 = (CMLArray)CMLXOMTestUtils.parseValidString(xmlS1S);
			xmlI0 = (CMLArray)CMLXOMTestUtils.parseValidString(xmlI0S);
			xmlI1 = (CMLArray)CMLXOMTestUtils.parseValidString(xmlI1S);
			xmlD0 = (CMLArray)CMLXOMTestUtils.parseValidString(xmlD0S);
			xmlD1 = (CMLArray)CMLXOMTestUtils.parseValidString(xmlD1S);

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("EXC " + e);
		}
	}

	/**
	 * equality test. true if both args not null and equal within epsilon
	 * 
	 * @param msg
	 *            message
	 * @param test
	 * @param expected
	 * @param epsilon
	 */
	public static void assertEquals(String msg, CMLArray test,
			CMLArray expected, double epsilon) {
		Assert.assertNotNull("test should not be null (" + msg + EC.S_RBRAK, test);
		Assert.assertNotNull("expected should not be null (" + msg + EC.S_RBRAK,
				expected);
		if ((test.getDataType() == null || test.getDataType()
				.equals(CC.XSD_STRING))
				&& (expected.getDataType() == null || expected.getDataType()
						.equals(CC.XSD_STRING))) {
			StringTestBase.assertEquals(msg, test.getStrings(), expected
					.getStrings());
		} else if (test.getDataType().equals(CC.XSD_DOUBLE)
				&& expected.getDataType().equals(CC.XSD_DOUBLE)) {
			DoubleTestBase.assertEquals(msg, test.getDoubles(), expected
					.getDoubles(), EPS);
		} else if (test.getDataType().equals(CC.XSD_INTEGER)
				&& expected.getDataType().equals(CC.XSD_INTEGER)) {
			String s = Int.testEquals(test.getInts(), expected.getInts());
			if (s != null) {
				Assert.fail(msg + "; " + s);
			}
		} else {
			Assert.fail("inconsistent dataTypes" + test.getDataType() + " / "
					+ expected.getDataType());
		}
	}

	/**
	 * equality test. true if both args not null and equal within epsilon
	 * 
	 * @param msg
	 *            message
	 * @param test
	 * @param expected
	 * @param epsilon
	 */
	public static void assertEquals(String msg, double[] test,
			CMLArray expected, double epsilon) {
		Assert.assertNotNull("test should not be null (" + msg + EC.S_RBRAK, test);
		Assert.assertNotNull("expected should not be null (" + msg + EC.S_RBRAK,
				expected);
		if (!expected.getDataType().equals(CC.XSD_DOUBLE)) {
			Assert.fail("expected should be double");
		}
		DoubleTestBase.assertEquals(msg, test, expected.getDoubles(), EPS);
	}

	/**
	 * equality test. true if both args not null and equal
	 * 
	 * @param msg
	 *            message
	 * @param test
	 * @param expected
	 */
	public static void assertEquals(String msg, int[] test, CMLArray expected) {
		Assert.assertNotNull("test should not be null (" + msg + EC.S_RBRAK, test);
		Assert.assertNotNull("expected should not be null (" + msg + EC.S_RBRAK,
				expected);
		if (!expected.getDataType().equals(CC.XSD_INTEGER)) {
			Assert.fail("expected should be int");
		}
		String s = Int.testEquals(test, expected.getInts());
		if (s != null) {
			Assert.fail(msg + "; " + s);
		}
	}

	/**
	 * equality test. true if both args not null and equal
	 * 
	 * @param msg
	 *            message
	 * @param test
	 * @param expected
	 */
	public static void assertEquals(String msg, String[] test, CMLArray expected) {
		Assert.assertNotNull("test should not be null (" + msg + EC.S_RBRAK, test);
		Assert.assertNotNull("expected should not be null (" + msg + EC.S_RBRAK,
				expected);
		if (expected.getDataType() != null
				&& !expected.getDataType().equals(CC.XSD_STRING)) {
			Assert.fail("expected should be String");
		}
		StringTestBase.assertEquals(msg, test, expected.getStrings());
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLArray.finishMakingElement()'
	 * 
	 * @exception Exception
	 */
	@Test
	public void testCatchErrors() throws Exception {

		CMLArray a = null;
		try {
			String xmlBad1 = "<array dataType='xsd:double' delimiter='/' "
					+ CMLConstants.CML_XMLNS + ">/a/b/</array>";
			a = (CMLArray) new CMLBuilder().parseString(xmlBad1);
			Assert.fail("bad 1 should not parse; type was wrong");
		} catch (RuntimeException e) {
			Assert.assertTrue(true);
		}
		try {
			String xmlBad2 = "<array size='2' delimiter='/' " + CMLConstants.CML_XMLNS
					+ ">a b c</array>";
			a = (CMLArray) new CMLBuilder().parseString(xmlBad2);
			Assert.fail("bad 2 should not parse - inconsistent size");
		} catch (RuntimeException e) {
			Assert.assertTrue(true);
		}
		try {
			String xmlBad3 = "<array size='3' dataType='xsd:double'  "
					+ CMLConstants.CML_XMLNS + ">1 2 c</array>";
			a = (CMLArray) new CMLBuilder().parseString(xmlBad3);
			Assert.fail("bad 3 should not parse");
		} catch (RuntimeException e) {
			Assert.assertTrue(true);
		}
		try {
			String xmlBad4 = "<array size='3' dataType='xsd:integer'  "
					+ CMLConstants.CML_XMLNS + ">1 2 c</array>";
			a = (CMLArray) new CMLBuilder().parseString(xmlBad4);
			Assert.fail("bad 4 should not parse");
		} catch (RuntimeException e) {
			Assert.assertTrue(true);
		}
		try {
			String xmlBad5 = "<array " + CMLConstants.CML_XMLNS + ">a b c d</array>";
			a = (CMLArray) new CMLBuilder().parseString(xmlBad5);
			Assert.assertEquals("whitespace delimiter", EC.S_EMPTY, a
					.getDelimiter());
			Assert.assertEquals("token length", 4, a.getStrings().length);
			Assert.assertEquals("token 0", "c", a.getStrings()[2]);
		} catch (RuntimeException e) {
			Assert.assertTrue(true);
		}
		try {
			String xmlBad6 = "<array size='2' " + CMLConstants.CML_XMLNS + ">a b c</array>";
			a = (CMLArray) new CMLBuilder().parseString(xmlBad6);
			Assert.fail("bad 6 should not parse - inconsistent size");
		} catch (RuntimeException e) {
			Assert.assertTrue(true);
		}
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLArray.getDataType()'
	 */
	@Test
	public void testGetDataType() {
		Assert.assertEquals("dataType", CC.XSD_STRING, xomS.getDataType());
		Assert.assertEquals("dataType", CC.XSD_STRING, xomS0.getDataType());
		Assert.assertEquals("dataType", CC.XSD_INTEGER, xomI0.getDataType());
		Assert.assertEquals("dataType", CC.XSD_DOUBLE, xomD0.getDataType());

		Assert.assertEquals("dataType", CC.XSD_STRING, xmlS.getDataType());
		Assert.assertEquals("dataType", CC.XSD_STRING, xmlS0.getDataType());
		Assert.assertEquals("dataType", CC.XSD_STRING, xmlS1.getDataType());
		Assert.assertEquals("dataType", CC.XSD_INTEGER, xmlI0.getDataType());
		Assert.assertEquals("dataType", CC.XSD_INTEGER, xmlI1.getDataType());
		Assert.assertEquals("dataType", CC.XSD_DOUBLE, xmlD0.getDataType());
		Assert.assertEquals("dataType", CC.XSD_DOUBLE, xmlD1.getDataType());

	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLArray.setDataType(String)'
	 */
	@Test
	public void testSetDataType() {
		try {
			xomS.setDataType(CC.XSD_DOUBLE);
		} catch (RuntimeException e) {
			Assert.fail("should not throw CMLRuntime");
		}
		Assert.assertEquals("set data type", CC.XSD_DOUBLE, xomS.getDataType());
		try {
			xomS.setDataType(CC.XSD_DOUBLE);
			Assert.fail("should throw CMLRuntime");
		} catch (RuntimeException e) {
			Assert.assertEquals("ok", "ok");
		}
		try {
			xomS0.setDataType(CC.XSD_DOUBLE);
			Assert.fail("should throw CMLRuntime");
		} catch (RuntimeException e) {
			Assert.assertEquals("ok", "ok");
		}
		try {
			xomD0.setDataType(CC.XSD_DOUBLE);
			Assert.fail("should throw CMLRuntime");
		} catch (RuntimeException e) {
			Assert.assertEquals("ok", "ok");
		}
		try {
			xomI0.setDataType(CC.XSD_DOUBLE);
			Assert.fail("should throw CMLRuntime");
		} catch (RuntimeException e) {
			Assert.assertEquals("ok", "ok");
		}
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLArray.getDelimiter()'
	 */
	@Test
	public void testGetDelimiterSplitterConcat() {

		CMLArray arrayS = new CMLArray();
		DelimiterAttribute delimiterAttribute = (DelimiterAttribute) arrayS
				.getDelimiterAttribute();
		// delimiter attribute is now null by default
		Assert.assertNull("default", delimiterAttribute);
//		Assert.assertEquals("default", EC.S_EMPTY, delimiterAttribute.getValue());
//		Assert.assertEquals("default", EC.S_WHITEREGEX, delimiterAttribute
//				.getSplitter());
//		Assert.assertEquals("default", EC.S_SPACE, delimiterAttribute.getConcat());
//
//		Assert.assertEquals("default", EC.S_EMPTY, arrayS.getDelimiter());

		arrayS.setDelimiter(EC.S_COMMA);
		delimiterAttribute = (DelimiterAttribute) arrayS
				.getDelimiterAttribute();
		Assert.assertNotNull("default", delimiterAttribute);
		Assert.assertEquals("default", EC.S_COMMA, delimiterAttribute.getValue());
		Assert.assertEquals("default", EC.S_COMMA, delimiterAttribute
				.getSplitter());
		Assert.assertEquals("default", EC.S_COMMA, delimiterAttribute.getConcat());

		Assert.assertEquals("default", EC.S_COMMA, arrayS.getDelimiter());

	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLArray.getSize()'
	 */
	@Test
	public void testGetSize() {
		Assert.assertEquals("size", 0, xomS.getSize());

		Assert.assertEquals("size", 5, xomS0.getSize());
		Assert.assertEquals("double", 5, xomD0.getSize());
		Assert.assertEquals("int", 5, xomI0.getSize());

		Assert.assertEquals("size", 5, xomS1.getSize());
		Assert.assertEquals("double", 5, xomD1.getSize());
		Assert.assertEquals("int", 5, xomI1.getSize());

		Assert.assertEquals("size", 0, xmlS.getSize());

		Assert.assertEquals("size", 5, xmlS0.getSize());
		Assert.assertEquals("double", 5, xmlD0.getSize());
		Assert.assertEquals("int", 5, xmlI0.getSize());

		Assert.assertEquals("size", 5, xmlS1.getSize());
		Assert.assertEquals("double", 5, xmlD1.getSize());
		Assert.assertEquals("int", 5, xmlI1.getSize());

	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLArray.CMLArray()'
	 */
	@Test
	public void testCMLArray() {

		CMLArray array0 = new CMLArray();
		Assert.assertEquals("size", 0, array0.getSize());
		Assert.assertEquals("delimiter", EC.S_EMPTY, array0.getDelimiter());
		Assert.assertEquals("dataType", CC.XSD_STRING, array0.getDataType());

		Assert.assertEquals("size", 0, xomS.getSize());
		Assert.assertEquals("delimiter", EC.S_EMPTY, xomS.getDelimiter());
		Assert.assertEquals("dataType", CC.XSD_STRING, xomS.getDataType());
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLArray.CMLArray(CMLArray)'
	 */
	@Test
	public void testCMLArrayCMLArray() {

		CMLArray s2 = new CMLArray(xomS0);
		Assert.assertNull("delimiter", s2.getDelimiterAttribute());
//		Assert.assertEquals("delimiter", EC.S_EMPTY, s2.getDelimiter());
		Assert.assertEquals("size", 5, s2.getSize());
		Assert.assertEquals("dataType", CC.XSD_STRING, s2.getDataType());
		String[] ss = s2.getStrings();
		Assert.assertEquals("element", "a", ss[0]);
		Assert.assertEquals("element", "e", ss[4]);

		s2 = new CMLArray(xomD0);
		Assert.assertNull("delimiter", s2.getDelimiterAttribute());
//		Assert.assertEquals("delimiter", EC.S_EMPTY, s2.getDelimiter());
		Assert.assertEquals("size", 5, s2.getSize());
		Assert.assertEquals("dataType", CC.XSD_DOUBLE, s2.getDataType());
		double[] dd = null;
		try {
			dd = s2.getDoubles();
		} catch (RuntimeException e) {
			Assert.fail("should parse doubles OK");
		}
		Assert.assertEquals("element", 1., dd[0], EPS);
		Assert.assertEquals("element", 5., dd[4], EPS);

		s2 = new CMLArray(xomI0);
		Assert.assertNull("delimiter", s2.getDelimiterAttribute());
//		Assert.assertEquals("delimiter", EC.S_EMPTY, s2.getDelimiter());
		Assert.assertEquals("size", 5, s2.getSize());
		Assert.assertEquals("dataType", CC.XSD_INTEGER, s2.getDataType());
		int[] ii = null;
		try {
			ii = s2.getInts();
		} catch (RuntimeException e) {
			Assert.fail("should parse doubles OK");
		}
		Assert.assertEquals("element", 1, ii[0]);
		Assert.assertEquals("element", 5, ii[4]);

		s2 = new CMLArray(xmlI0);
		Assert.assertNull("delimiter", s2.getDelimiterAttribute());
//		Assert.assertEquals("delimiter", EC.S_EMPTY, s2.getDelimiter());
		Assert.assertEquals("size", 5, s2.getSize());
		Assert.assertEquals("dataType", CC.XSD_INTEGER, s2.getDataType());
		ii = null;
		try {
			ii = s2.getInts();
		} catch (RuntimeException e) {
			Assert.fail("should parse doubles OK");
		}
		Assert.assertEquals("element", 1, ii[0]);
		Assert.assertEquals("element", 5, ii[4]);

		s2 = new CMLArray(xmlD1);
		Assert.assertNotNull("delimiter", s2.getDelimiterAttribute());
		Assert.assertEquals("delimiter", EC.S_SLASH, s2.getDelimiter());
		Assert.assertEquals("size", 5, s2.getSize());
		Assert.assertEquals("dataType", CC.XSD_DOUBLE, s2.getDataType());
		dd = null;
		try {
			dd = s2.getDoubles();
		} catch (RuntimeException e) {
			Assert.fail("should parse doubles OK");
		}
		Assert.assertEquals("element", 10., dd[0], EPS);
		Assert.assertEquals("element", 50., dd[4], EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLArray.CMLArray(String[])'
	 */
	@Test
	public void testCMLArrayStringArray() {
		CMLArray arrayS = new CMLArray(new String[] { "a", "b", "c" });
		Assert.assertEquals("data type", CC.XSD_STRING, arrayS.getDataType());
		Assert.assertEquals("size", 3, arrayS.getSize());
		Assert.assertEquals("content", "a b c", arrayS.getXMLContent());
		Assert.assertEquals("delimiter", EC.S_EMPTY, arrayS.getDelimiter());

		Assert.assertEquals("delimiter", EC.S_EMPTY, xomS0.getDelimiter());
		String[] ss = xomS0.getStrings();
		Assert.assertEquals("length", 5, ss.length);
		Assert.assertEquals("array0", "a", ss[0]);
		Assert.assertEquals("array4", "e", ss[4]);

		Assert.assertEquals("data type", CC.XSD_STRING, xomS0.getDataType());
		Assert.assertEquals("size", 5, xomS0.getSize());
		Assert.assertEquals("content", "a b c d e", xomS0.getXMLContent());
		Assert.assertEquals("delimiter", EC.S_EMPTY, xomS0.getDelimiter());
		ss = xomS0.getStrings();
		Assert.assertEquals("length", 5, ss.length);
		Assert.assertEquals("array0", "a", ss[0]);
		Assert.assertEquals("array4", "e", ss[4]);
	}

	/**
	 * test ensureDelimiter
	 */
	@Test
	public void testEnsureDelimiterAttribute() {
		CMLArray array = new CMLArray();
		array.ensureDelimiterAttribute(Action.PRESERVE);
		DelimiterAttribute delimiterAttribute = (DelimiterAttribute) array
				.getDelimiterAttribute();
		Assert.assertNotNull("delimiter", delimiterAttribute);
		Assert.assertEquals("delimiter", EC.S_SPACE, delimiterAttribute
				.getConcat());
		Assert.assertEquals("delimiter", EC.S_WHITEREGEX, delimiterAttribute
				.getSplitter());
		Assert
				.assertEquals("delimiter", EC.S_EMPTY, delimiterAttribute
						.getValue());
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLArray.CMLArray(String[],
	 * String)'
	 */
	@Test
	public void testCMLArrayStringArrayString() {
		Assert.assertEquals("data type", CC.XSD_STRING, xomS1.getDataType());
		Assert.assertEquals("size", 5, xomS1.getSize());
		Assert.assertEquals("content", "/vector/w/x/y/z/", xomS1
				.getXMLContent());
		Assert.assertEquals("delimiter", EC.S_SLASH, xomS1.getDelimiter());
		Assert.assertNotNull("delimiter", xomS1.getDelimiterAttribute());
		String[] ss = xomS1.getStrings();
		Assert.assertEquals("length", 5, ss.length);
		Assert.assertEquals("array0", "vector", ss[0]);
		Assert.assertEquals("array4", "z", ss[4]);

	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLArray.CMLArray(double[])'
	 */
	@Test
	public void testCMLArrayDoubleArray() {

		double[] dd = new double[] { 10.0, 20.0, 30.0, 40.0, 50.0 };
		CMLArray arrayD = new CMLArray(dd);
		Assert.assertEquals("data type", CC.XSD_DOUBLE, arrayD.getDataType());
		Assert.assertEquals("size", 5, arrayD.getSize());
		Assert.assertEquals("content", "10.0 20.0 30.0 40.0 50.0", arrayD
				.getXMLContent());
		Assert.assertEquals("delimiter", EC.S_EMPTY, arrayD.getDelimiter());

		Assert.assertEquals("data type", CC.XSD_DOUBLE, xomD0.getDataType());
		Assert.assertEquals("size", 5, xomD0.getSize());
		Assert.assertEquals("content", "1.0 2.0 3.0 4.0 5.0", xomD0
				.getXMLContent());
		Assert.assertEquals("delimiter", EC.S_EMPTY, xomD0.getDelimiter());
		double[] ss = null;
		try {
			ss = xomD0.getDoubles();
		} catch (RuntimeException e) {
			Assert.fail("doubles should parse OK");
		}
		Assert.assertEquals("length", 5, ss.length);
		Assert.assertEquals("array0", 1.0, ss[0], EPS);
		Assert.assertEquals("array4", 5.0, ss[4], EPS);

	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLArray.CMLArray(double[],
	 * Strinig)'
	 */
	@Test
	public void testCMLArrayDoubleArrayString() {

		double[] dd = new double[] { 10.0, 20.0, 30.0, 40.0, 50.0 };
		CMLArray arrayD = new CMLArray(dd, EC.S_SLASH);
		// DelimiterAttribute delimiterAttribute = (DelimiterAttribute)
		// arrayD.getDelimiterAttribute();
		Assert.assertEquals("data type", CC.XSD_DOUBLE, arrayD.getDataType());
		Assert.assertEquals("size", 5, arrayD.getSize());
		Assert.assertEquals("content", "/10.0/20.0/30.0/40.0/50.0/", arrayD
				.getXMLContent());
		Assert.assertEquals("delimiter", EC.S_SLASH, arrayD.getDelimiter());
		Assert.assertNotNull("delimiter", arrayD.getDelimiterAttribute());
		double[] ss = null;
		try {
			ss = xomD1.getDoubles();
		} catch (RuntimeException e) {
			Assert.fail("doubles should parse OK");
		}
		Assert.assertEquals("length", 5, ss.length);
		Assert.assertEquals("array0", 10.0, ss[0], EPS);
		Assert.assertEquals("array4", 50.0, ss[4], EPS);

	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLArray.CMLArray(int[])'
	 */
	@Test
	public void testCMLArrayIntArray() {

		Assert.assertEquals("data type", CC.XSD_INTEGER, xomI0.getDataType());
		Assert.assertEquals("size", 5, xomI0.getSize());
		Assert.assertEquals("content", "1 2 3 4 5", xomI0.getXMLContent());
		Assert.assertEquals("delimiter", EC.S_EMPTY, xomI0.getDelimiter());
		int[] ss = null;
		try {
			ss = xomI0.getInts();
		} catch (RuntimeException e) {
			Assert.fail("ints should parse OK");
		}
		Assert.assertEquals("length", 5, ss.length);
		Assert.assertEquals("array0", 1, ss[0]);
		Assert.assertEquals("array4", 5, ss[4]);

	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLArray.CMLArray(int[], String)'
	 */
	@Test
	public void testCMLArrayIntArrayString() {
		Assert.assertEquals("data type", CC.XSD_INTEGER, xomI1.getDataType());
		Assert.assertEquals("size", 5, xomI1.getSize());
		Assert.assertEquals("content", "/10/20/30/40/50/", xomI1
				.getXMLContent());
		Assert.assertEquals("delimiter", EC.S_SLASH, xomI1.getDelimiter());
		Assert.assertNotNull("delimiter", xomI1.getDelimiterAttribute());
		int[] ss = null;
		try {
			ss = xomI0.getInts();
		} catch (RuntimeException e) {
			Assert.fail("ints should parse OK");
		}
		Assert.assertEquals("length", 5, ss.length);
		Assert.assertEquals("array0", 1, ss[0]);
		Assert.assertEquals("array4", 5, ss[4]);

	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLArray.getStrings()'
	 */
	@Test
	public void testGetStrings() {
		String[] ss = xomS.getStrings();
		Assert.assertNotNull("empty content", ss);
		Assert.assertEquals("empty content", 0, ss.length);

		ss = xomS0.getStrings();
		Assert.assertNotNull("content", ss);
		Assert.assertEquals("content", 5, ss.length);
		Assert.assertEquals("array0", "a", ss[0]);
		Assert.assertEquals("array4", "e", ss[4]);

		ss = xomS1.getStrings();
		Assert.assertNotNull("content", ss);
		Assert.assertEquals("content", 5, ss.length);
		Assert.assertEquals("array0", "vector", ss[0]);
		Assert.assertEquals("array4", "z", ss[4]);

		ss = xomD0.getStrings();
		Assert.assertNull("content", ss);

		ss = xomD1.getStrings();
		Assert.assertNull("content", ss);

		ss = xomI0.getStrings();
		Assert.assertNull("content", ss);

		ss = xomI1.getStrings();
		Assert.assertNull("content", ss);

		ss = xmlS.getStrings();
		Assert.assertNotNull("empty content", ss);
		Assert.assertEquals("empty content", 0, ss.length);

		ss = xmlS0.getStrings();
		Assert.assertNotNull("content", ss);
		Assert.assertEquals("content", 5, ss.length);
		Assert.assertEquals("array0", "1", ss[0]);
		Assert.assertEquals("array4", "5", ss[4]);

		ss = xmlS1.getStrings();
		Assert.assertNotNull("content", ss);
		Assert.assertEquals("content", 5, ss.length);
		Assert.assertEquals("array0", "100", ss[0]);
		Assert.assertEquals("array4", "500", ss[4]);

		ss = xmlD0.getStrings();
		Assert.assertNull("content", ss);

		ss = xmlD1.getStrings();
		Assert.assertNull("content", ss);

		ss = xmlI0.getStrings();
		Assert.assertNull("content", ss);

		ss = xmlI1.getStrings();
		Assert.assertNull("content", ss);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLArray.getDoubles()'
	 */
	@Test
	public void testGetDoubles() {
		try {
			double[] ss = xomS.getDoubles();
			Assert.assertNull("empty content", ss);

			ss = xomD0.getDoubles();
			Assert.assertNotNull("content", ss);
			Assert.assertEquals("content", 5, ss.length);
			Assert.assertEquals("array0", 1.0, ss[0], EPS);
			Assert.assertEquals("array4", 5.0, ss[4], EPS);

			ss = xomD1.getDoubles();
			Assert.assertNotNull("content", ss);
			Assert.assertEquals("content", 5, ss.length);
			Assert.assertEquals("array0", 10., ss[0], EPS);
			Assert.assertEquals("array4", 50., ss[4], EPS);

			ss = xomS0.getDoubles();
			Assert.assertNull("content", ss);

			ss = xomS1.getDoubles();
			Assert.assertNull("content", ss);

			ss = xomI0.getDoubles();
			Assert.assertNull("content", ss);

			ss = xomI1.getDoubles();
			Assert.assertNull("content", ss);

			ss = xmlS.getDoubles();
			Assert.assertNull("empty content", ss);

			ss = xmlD0.getDoubles();
			Assert.assertNotNull("content", ss);
			Assert.assertEquals("content", 5, ss.length);
			Assert.assertEquals("array0", 1.0, ss[0], EPS);
			Assert.assertEquals("array4", 5.0, ss[4], EPS);

			ss = xmlD1.getDoubles();
			Assert.assertNotNull("content", ss);
			Assert.assertEquals("content", 5, ss.length);
			Assert.assertEquals("array0", 10., ss[0], EPS);
			Assert.assertEquals("array4", 50., ss[4], EPS);

			ss = xmlS0.getDoubles();
			Assert.assertNull("content", ss);

			ss = xmlS1.getDoubles();
			Assert.assertNull("content", ss);

			ss = xmlI0.getDoubles();
			Assert.assertNull("content", ss);

			ss = xmlI1.getDoubles();
			Assert.assertNull("content", ss);
		} catch (RuntimeException e) {
			Assert.fail("should not throw double parsing error");
		}
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLArray.getInts()'
	 */
	@Test
	public void testGetInts() {
		try {
			int[] ss = xomS.getInts();
			Assert.assertNull("empty content", ss);

			ss = xomI0.getInts();
			Assert.assertNotNull("content", ss);
			Assert.assertEquals("content", 5, ss.length);
			Assert.assertEquals("array0", 1, ss[0]);
			Assert.assertEquals("array4", 5, ss[4]);

			ss = xomI1.getInts();
			Assert.assertNotNull("content", ss);
			Assert.assertEquals("content", 5, ss.length);
			Assert.assertEquals("array0", 10, ss[0], EPS);
			Assert.assertEquals("array4", 50, ss[4], EPS);

			ss = xomS0.getInts();
			Assert.assertNull("content", ss);

			ss = xomS1.getInts();
			Assert.assertNull("content", ss);

			ss = xomD0.getInts();
			Assert.assertNull("content", ss);

			ss = xomD1.getInts();
			Assert.assertNull("content", ss);

			ss = xmlS.getInts();
			Assert.assertNull("empty content", ss);

			ss = xmlI0.getInts();
			Assert.assertNotNull("content", ss);
			Assert.assertEquals("content", 5, ss.length);
			Assert.assertEquals("array0", 1, ss[0]);
			Assert.assertEquals("array4", 5, ss[4]);

			ss = xmlI1.getInts();
			Assert.assertNotNull("content", ss);
			Assert.assertEquals("content", 5, ss.length);
			Assert.assertEquals("array0", 10, ss[0]);
			Assert.assertEquals("array4", 50, ss[4]);

			ss = xmlS0.getInts();
			Assert.assertNull("content", ss);

			ss = xmlS1.getInts();
			Assert.assertNull("content", ss);

			ss = xmlD0.getInts();
			Assert.assertNull("content", ss);

			ss = xmlD1.getInts();
			Assert.assertNull("content", ss);
		} catch (RuntimeException e) {
			Assert.fail("should not throw double parsing error");
		}

	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLArray.setArray(String[])'
	 */
	@Test
	public void testSetArrayStringArray() {
		Assert.assertEquals("empty", 0, xomS.getStrings().length);
		try {
			xomS.setArray(s0);
		} catch (RuntimeException e) {
			Assert.fail("should not throw Exception " + e.getMessage());
		}
		Assert.assertEquals("empty", 5, xomS.getStrings().length);
		try {
			String[] bad = { "a", "b c", "d" };
			xomS.setArray(bad);
			Assert.fail("should throw Exception as string has whitespace");
		} catch (RuntimeException e) {
			Assert.assertEquals("should throw Exception ",
					"cannot delimit {b c} with { }", e.getMessage());
		}
		Assert.assertEquals("empty", 5, xomS.getStrings().length);

	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLArray.setArray(double[])'
	 */
	@Test
	public void testSetArrayDoubleArray() {
		try {
			Assert.assertEquals("double", 5, xomD0.getDoubles().length);

			xomS.setArray(d0);
			Assert.assertEquals("d", 5, xomS.getDoubles().length);
			Assert.assertEquals("d", 1.0, xomS.getDoubles()[0]);
			Assert.assertEquals("d", 5.0, xomS.getDoubles()[4]);
			xomS.setArray(d1);
			Assert.assertEquals("d", 5, xomS.getDoubles().length);
			Assert.assertEquals("d", 10.0, xomS.getDoubles()[0]);
			Assert.assertEquals("d", 50.0, xomS.getDoubles()[4]);
		} catch (RuntimeException e) {
			Assert.fail("should not throw parse exception");
		}

	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLArray.setArray(int[])'
	 */
	@Test
	public void testSetArrayIntArray() {
		try {
			Assert.assertEquals("int", 5, xomI0.getInts().length);

			xomS.setArray(i0);
			Assert.assertEquals("d elim", EC.S_EMPTY, xomS.getDelimiter());
			Assert.assertEquals("d type", CC.XSD_INTEGER, xomS.getDataType());
			Assert.assertEquals("d type", CC.XSD_INTEGER, xomS.getDataType());
			Assert.assertEquals("d XML", "1 2 3 4 5", xomS.getXMLContent());
			Assert.assertEquals("d", 5, xomS.getInts().length);
			Assert.assertEquals("d", 1, xomS.getInts()[0]);
			Assert.assertEquals("d", 5, xomS.getInts()[4]);
			Assert.assertNotNull(i1);
			Assert.assertEquals("i1 ", 5, i1.length);
			xomS.setArray(i1);
			Assert.assertNotNull("xomS i1 ", xomS);
			Assert.assertEquals("d delim", EC.S_EMPTY, xomS.getDelimiter());
			Assert.assertEquals("d type", CC.XSD_INTEGER, xomS.getDataType());
			Assert
					.assertEquals("d XML", "10 20 30 40 50", xomS
							.getXMLContent());
			Assert.assertEquals("d", 5, xomS.getInts().length);
			Assert.assertEquals("d", 10, xomS.getInts()[0]);
			Assert.assertEquals("d", 50, xomS.getInts()[4]);
		} catch (RuntimeException e) {
			Assert.fail("should not throw parse exception");
		}

	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLArray.checkNumericConformability(CMLArray)'
	 */
	@Test
	public void testCheckNumericConformability() {
		try {
			xomD0.checkNumericConformability(xomD1);
		} catch (Exception e) {
			Assert.fail("conformability should not throw " + e.getMessage());
		}
		try {
			xomI0.checkNumericConformability(xomI1);
		} catch (Exception e) {
			Assert.fail("conformability should not throw " + e.getMessage());
		}
		try {
			xomD0.checkNumericConformability(xomS0);
			Assert.fail("conformability should throw exception");
		} catch (Exception e) {
		}
		try {
			xomD0.checkNumericConformability(xomI0);
			Assert.fail("conformability should throw exception");
		} catch (Exception e) {
		}
		try {
			xomI0.checkNumericConformability(xomD0);
			Assert.fail("conformability should throw exception");
		} catch (Exception e) {
		}
		try {
			xomI0.checkNumericConformability(xomS0);
			Assert.fail("conformability should throw exception");
		} catch (Exception e) {
		}
		try {
			xomS0.checkNumericConformability(xomS1);
			Assert.fail("conformability should throw exception");
		} catch (Exception e) {
		}
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLArray.subtract(CMLArray)'
	 */
	@Test
	public void testSubtract() {
		CMLArray d3 = null;
		try {
			d3 = xomD1.subtract(xomD0);
		} catch (Exception e) {
			Assert.fail("subtract should not throw " + e.getMessage());
		}
		Assert.assertNotNull("subtract", d3);
		Assert.assertEquals("subtract", 5, d3.getSize());
		try {
			Assert.assertEquals("subtract", -9., d3.getDoubles()[0]);
		} catch (RuntimeException e) {
			Assert.fail("subtract should not throw " + e.getMessage());
		}

		d3 = null;
		try {
			d3 = xmlD1.subtract(xmlD0);
		} catch (Exception e) {
			Assert.fail("subtract should not throw " + e.getMessage());
		}
		Assert.assertNotNull("subtract", d3);
		Assert.assertEquals("subtract", 5, d3.getSize());
		try {
			Assert.assertEquals("subtract", -9., d3.getDoubles()[0]);
		} catch (RuntimeException e) {
			Assert.fail("subtract should not throw " + e.getMessage());
		}

	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLArray.plus(CMLArray)'
	 */
	@Test
	public void testPlus() {
		CMLArray d3 = null;
		try {
			d3 = xomD1.plus(xomD0);
		} catch (Exception e) {
			Assert.fail("subtract should not throw " + e.getMessage());
		}
		Assert.assertNotNull("plus", d3);
		Assert.assertEquals("plus", 5, d3.getSize());
		try {
			Assert.assertEquals("plus", 11., d3.getDoubles()[0]);
		} catch (RuntimeException e) {
			Assert.fail("plus should not throw " + e.getMessage());
		}

	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLArray.append(String)'
	 */
	@Test
	public void testAppendString() {

		String[] ss = new String[] { "a", "b", "c", "d", "e" };
		CMLArray arrayS = new CMLArray(ss);
		StringTestBase.assertEquals("append", ss, arrayS.getStrings());
		Assert.assertEquals("append", "a b c d e", arrayS.getXMLContent());
		arrayS.append("f");
		Assert.assertEquals("append", "a b c d e f", arrayS.getXMLContent());

		arrayS = new CMLArray(ss, EC.S_SLASH);
		StringTestBase.assertEquals("append", ss, arrayS.getStrings());
		Assert.assertEquals("append", "/a/b/c/d/e/", arrayS.getXMLContent());
		arrayS.append("f");
		Assert.assertEquals("append", "/a/b/c/d/e/f/", arrayS.getXMLContent());

	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLArray.append(double)'
	 */
	@Test
	public void testAppendDouble() {
		xomD0.append(6.);
		Assert.assertEquals("append", "1.0 2.0 3.0 4.0 5.0 6.0", xomD0
				.getXMLContent());
		Assert.assertEquals("append", 6, xomD0.getSize());
		try {
			xomD0.append("f");
			Assert.fail("append should not throw ");
		} catch (RuntimeException e) {
			Assert.assertEquals("cannot add string to double",
					"Cannot add string (f) to array of: xsd:double", e
							.getMessage());
		}
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLArray.append(int)'
	 */
	@Test
	public void testAppendInt() {
		xomI0.append(6);
		Assert.assertEquals("append", "1 2 3 4 5 6", xomI0.getXMLContent());
		Assert.assertEquals("append", 6, xomI0.getSize());
		try {
			xomI0.append("f");
			Assert.fail("append should not throw ");
		} catch (RuntimeException e) {
			Assert.assertEquals("cannot add string to int",
					"Cannot add string (f) to array of: xsd:integer", e
							.getMessage());
		}
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLArray.copy()'
	 */
	@Test
	public void testCopy() {
		CMLArray array = new CMLArray(new double[] { 1., 2. });
		CMLArray array1 = (CMLArray) array.copy();
		Assert.assertEquals("copy", CC.XSD_DOUBLE, array1.getDataType());
		CMLArrayTest.assertEquals("copy", new double[] { 1., 2. }, array1, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLArray.setDelimiter(String)'
	 */
	@Test
	public void testSetDelimiter() {
		CMLArray array = new CMLArray();
		array.setDataType(CC.XSD_DOUBLE);
		array.setDelimiter(EC.S_SLASH);
		DelimiterAttribute da = (DelimiterAttribute) array
				.getDelimiterAttribute();
		Assert.assertNotNull("delimiter", da);
		array.setXMLContent("1./2.");
		double[] dd = array.getDoubles();
		Assert.assertNotNull("dd null", dd);
		DoubleTestBase.assertEquals("double delimiter",
				new double[] { 1., 2. }, dd, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLArray.getStringValues()'
	 */
	@Test
	public void testGetStringValues() {
		CMLArray array = new CMLArray(new String[] { "a", "b" });
		StringTestBase.assertEquals("strings", new String[] { "a", "b" },
				(String[]) array.getStringValues().toArray(new String[0]));
		array = new CMLArray(new int[] { 1, 2 });
		StringTestBase.assertEquals("ints", new String[] { "1", "2" },
				(String[]) array.getStringValues().toArray(new String[0]));
		array = new CMLArray(new double[] { 1, 2 });
		StringTestBase.assertEquals("ints", new String[] { "1.0", "2.0" },
				(String[]) array.getStringValues().toArray(new String[0]));
	}
	
	@Test
	public void testAppend() {
		CMLArray array = new CMLArray(new String[] { "a", "b" });
		CMLArray array1 = new CMLArray(new String[] { "c", "d", "e" });
		array.append(array1);
		CMLArray arrayRef = new CMLArray(new String[] {"a", "b", "c", "d", "e" });
		CMLArrayTest.assertEquals("append", array, arrayRef, 0.000001);
	}

	@Test
	public void testAppendDelimiter() {
		CMLArray array = new CMLArray(new String[] { "a", "b" }, "|");
		CMLArray array1 = new CMLArray(new String[] { "c", "d", "e" }, "|");
		array.append(array1);
		CMLArray arrayRef = new CMLArray(new String[] {"a", "b", "c", "d", "e" }, "|");
		CMLArrayTest.assertEquals("append", array, arrayRef, 0.000001);
	}

	@Test
	public void testAppendDoubleArray() {
		CMLArray array = new CMLArray(new double[] { 1.1, 2.2 });
		CMLArray array1 = new CMLArray(new double[] { 3.3, 4.4, 5.5});
		array.append(array1);
		CMLArray arrayRef = new CMLArray(new double[]{1.1, 2.2, 3.3, 4.4, 5.5 });
		CMLArrayTest.assertEquals("append", array, arrayRef, 0.000001);
	}

	@Test
	public void testAppendIntArray() {
		CMLArray array = new CMLArray(new int[] { 1, 2 });
		CMLArray array1 = new CMLArray(new int[] { 3, 4, 5});
		array.append(array1);
		CMLArray arrayRef = new CMLArray(new int[]{1, 2, 3, 4, 5 });
		CMLArrayTest.assertEquals("append", array, arrayRef, 0.000001);
	}

	@Test
	public void testAppendMixedArray() {
		CMLArray array = new CMLArray(new String[] { "a", "b" });
		CMLArray array1 = new CMLArray(new int[] { 3, 4, 5});
		try {
			array.append(array1);
			Assert.fail("should throw incompatibility");
		} catch (Exception e) {
		}
	}


	@Test
	/** need to remove this delimiter attribute*/
	public void testSerializeWithEmptyDelimiter() {
		CMLArray array = new CMLArray(new int[] { 1, 2 });
		String arrayXML = array.toXML();
		String ref="<array xmlns=\"http://www.xml-cml.org/schema\" dataType=\"xsd:integer\"" +
				" size=\"2\">1 2</array>";
		Assert.assertEquals("serialize", ref, arrayXML);
	}
	
	@Test
	/** need to remove this delimiter attribute*/
	public void testSerializeWithEmptyDelimiter1() {
		CMLArray array = new CMLArray(new int[] { 1, 2 });
		String arrayXML = array.toXML();
		String ref="<array xmlns=\"http://www.xml-cml.org/schema\" dataType=\"xsd:integer\"" +
				" size=\"2\">1 2</array>";
		Assert.assertEquals("serialize", ref, arrayXML);
	}
	
	@Test
	/** need to remove this delimiter attribute*/
	public void testSerializeWithEmptyDelimiter2() {
		CMLArray array = new CMLArray(new int[] { 1, 2 });
		Assert.assertNull(array.getDelimiterAttribute());
		String arrayXML = array.toXML();
		String ref="<array xmlns=\"http://www.xml-cml.org/schema\" dataType=\"xsd:integer\"" +
				" size=\"2\">1 2</array>";
		array.append(3);
		arrayXML = array.toXML();
		ref="<array xmlns=\"http://www.xml-cml.org/schema\" dataType=\"xsd:integer\"" +
				" size=\"3\">1 2 3</array>";
		Assert.assertEquals("serialize", ref, arrayXML);
	}

	@Test
	public void testGetScalar() {
		CMLArray array = new CMLArray(new int[] { 1, 2 });
		array.setDictRef("foo:bar");
		CMLScalar scalar = array.getElementAt(1);
		String ref="<scalar xmlns=\"http://www.xml-cml.org/schema\" dataType=\"xsd:integer\"" +
		" dictRef=\"foo:bar\">2</scalar>";
		Assert.assertEquals("getElement", ref, scalar.toXML());
		
	}

	@Test
	public void testGetScalar1() {
		CMLArray array = new CMLArray(new int[] { 1, 2 });
		array.setDictRef("foo:bar");
		CMLScalar scalar = array.getElementAt(-1);
		Assert.assertNull(scalar);
		scalar = array.getElementAt(2);
		Assert.assertNull(scalar);
		
	}


}
