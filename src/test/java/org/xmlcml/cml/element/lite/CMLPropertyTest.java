package org.xmlcml.cml.element.lite;

import static org.xmlcml.cml.base.CMLConstants.XSD_DOUBLE;
import static org.xmlcml.cml.base.CMLConstants.XSD_STRING;
import static org.xmlcml.euclid.EuclidConstants.EPS;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.xmlcml.cml.base.CMLConstants;
import org.xmlcml.cml.base.CMLXOMTestUtils;
import org.xmlcml.cml.base.CMLConstants.Units;
import org.xmlcml.cml.element.CMLCml;
import org.xmlcml.cml.element.CMLProperty;
import org.xmlcml.cml.element.CMLPropertyList;
import org.xmlcml.cml.interfacex.HasDataType;

/**
 * tests property
 * 
 * @author pm286
 * 
 */
public class CMLPropertyTest {

	CMLProperty prop1;

	/**
	 * @exception Exception
	 */
	@Before
	public void setUp() throws Exception {
		String prop1S = "<property "
				+ CMLConstants.CML_XMLNS
				+ ">"
				+ "  <scalar dictRef='foo:bar' units='"+Units.GRAM+"' dataType='xsd:double'>12.3</scalar>"
				+ "</property>";
		prop1 = (CMLProperty)CMLXOMTestUtils.parseValidString(prop1S);
	}

	/** dewisott */
	@Test
	public final void testGetPropertyList() {
		String cmlS = "<cml "
				+ CMLConstants.CML_XMLNS
				+ ">"
				+ "<property>"
				+ "  <scalar dictRef='foo:bar' units='"+Units.GRAM+"' dataType='xsd:double'>12.3</scalar>"
				+ "</property>"
				+ "<property "
				+ CMLConstants.CML_XMLNS
				+ ">"
				+ "  <scalar dictRef='foo:plugh' units='"+Units.GRAM+"' dataType='xsd:double'>45.6</scalar>"
				+ "</property>"
				+ "<property "
				+ CMLConstants.CML_XMLNS
				+ ">"
				+ "  <scalar dictRef='foo:plugh' units='"+Units.GRAM+"' dataType='xsd:double'>49.6</scalar>"
				+ "</property>" + "</cml>";
		CMLCml cml = (CMLCml)CMLXOMTestUtils.parseValidString(cmlS);
		CMLPropertyList propertyList = CMLProperty.getPropertyList(cml,
				"foo:bar");
		Assert.assertEquals("propertyList", 1, propertyList
				.getPropertyElements().size());
	}

	/** dewisott */
	@Test
	public final void testGetPropertyCMLElementString() {
		String cmlS = "<cml "
				+ CMLConstants.CML_XMLNS
				+ ">"
				+ "<property>"
				+ "  <scalar dictRef='foo:bar' units='"+Units.GRAM+"' dataType='xsd:double'>12.3</scalar>"
				+ "</property>"
				+ "<property "
				+ CMLConstants.CML_XMLNS
				+ ">"
				+ "  <scalar dictRef='foo:plugh' units='"+Units.GRAM+"' dataType='xsd:double'>45.6</scalar>"
				+ "</property>"
				+ "<property "
				+ CMLConstants.CML_XMLNS
				+ ">"
				+ "  <scalar dictRef='foo:plugh' units='"+Units.GRAM+"' dataType='xsd:double'>49.6</scalar>"
				+ "</property>" + "</cml>";
		CMLCml cml = (CMLCml)CMLXOMTestUtils.parseValidString(cmlS);
		CMLProperty property = CMLProperty.getProperty(cml, "foo:bar");
		Assert.assertEquals("property", 12.3, property.getDouble(), EPS);
		property = CMLProperty.getProperty(cml, "foo:plugh");
		Assert.assertNull("property", property);
	}

	/** dewisott */
	@Test
	public final void testCanonicalize() {
		CMLProperty prop2 = new CMLProperty(prop1);
		prop2.canonicalize();
	}

	/** dewisott */
	@Test
	public final void testGetDouble() {
		double val = prop1.getDouble();
		Assert.assertEquals("double", 12.3, val, EPS);
	}

	/** dewisott */
	@Test
	public final void testGetString() {
		String cmlS = "<cml "
				+ CMLConstants.CML_XMLNS
				+ ">"
				+ "<property>"
				+ "  <scalar dictRef='foo:bar' units='"+Units.GRAM+"' dataType='xsd:double'>12.3</scalar>"
				+ "</property>" + "<property " + CMLConstants.CML_XMLNS + ">"
				+ "  <scalar dictRef='foo:plugh'>penguin</scalar>"
				+ "</property>" + "</cml>";
		CMLCml cml = (CMLCml)CMLXOMTestUtils.parseValidString(cmlS);
		CMLProperty property = CMLProperty.getProperty(cml, "foo:bar");
		String val = property.getString();
		Assert.assertNull("string", val);
		property = CMLProperty.getProperty(cml, "foo:plugh");
		val = property.getString();
		Assert.assertEquals("string", "penguin", val);
	}

	/** dewisott */
	@Test
	public final void testGetInt() {
		String cmlS = "<cml "
				+ CMLConstants.CML_XMLNS
				+ ">"
				+ "<property>"
				+ "  <scalar dictRef='foo:bar' units='"+Units.GRAM+"' dataType='xsd:double'>12.3</scalar>"
				+ "</property>"
				+ "<property>"
				+ "  <scalar dictRef='foo:plugh' dataType='xsd:integer'>12</scalar>"
				+ "</property>" + "</cml>";
		CMLCml cml = (CMLCml)CMLXOMTestUtils.parseValidString(cmlS);
		CMLProperty property = CMLProperty.getProperty(cml, "foo:bar");
		int val = property.getInt();
		Assert.assertEquals("int", Integer.MIN_VALUE, val);
		property = CMLProperty.getProperty(cml, "foo:plugh");
		val = property.getInt();
		Assert.assertEquals("int", 12, val);
	}

	/** dewisott */
	@Test
	public final void testGetStringValues() {
		String cmlS = "<cml " + CMLConstants.CML_XMLNS + ">"
				+ "<property  dictRef='foo:plugh'>"
				+ "  <array>penguin bear wombat</array>" + "</property>"
				+ "<property  dictRef='foo:bar'>"
				+ "  <scalar>penguin bear wombat</scalar>" + "</property>"
				+ "</cml>";
		CMLCml cml = (CMLCml)CMLXOMTestUtils.parseValidString(cmlS);
		CMLProperty property = CMLProperty.getProperty(cml, "foo:plugh");
		List<String> val = property.getStringValues();
		Assert.assertNotNull("strings", val);
		Assert.assertEquals("strings", 3, val.size());
		Assert.assertEquals("strings", "bear", val.get(1));
		property = CMLProperty.getProperty(cml, "foo:bar");
		Assert.assertNotNull("property not null", property);
		val = property.getStringValues();
		Assert.assertNull("strings", val);
	}

	/** dewisott */
	@Test
	public final void testGetInts() {
		String cmlS = "<cml " + CMLConstants.CML_XMLNS + ">"
				+ "<property  dictRef='foo:plugh'>"
				+ "  <array dataType='xsd:integer'>1 2 3</array>"
				+ "</property>" + "</cml>";
		CMLCml cml = (CMLCml)CMLXOMTestUtils.parseValidString(cmlS);
		CMLProperty property = CMLProperty.getProperty(cml, "foo:plugh");
		int[] val = property.getInts();
		Assert.assertNotNull("ints", val);
		Assert.assertEquals("ints", 3, val.length);
		Assert.assertEquals("ints", 2, val[1]);
	}

	/** dewisott */
	@Test
	public final void testGetDoubles() {
		String cmlS = "<cml "
				+ CMLConstants.CML_XMLNS
				+ ">"
				+ "<property  dictRef='foo:plugh'>"
				+ "  <array dataType='xsd:double' units='"+Units.GRAM+"'>1.1 2.1 3.1</array>"
				+ "</property>" + "</cml>";
		CMLCml cml = (CMLCml)CMLXOMTestUtils.parseValidString(cmlS);
		CMLProperty property = CMLProperty.getProperty(cml, "foo:plugh");
		double[] val = property.getDoubles();
		Assert.assertNotNull("doubles", val);
		Assert.assertEquals("doubles", 3, val.length);
		Assert.assertEquals("doubles", 2.1, val[1], 0.0001);
	}

	/** dewisott */
	@Test
	public final void testGetChild() {
		String cmlS = "<cml "
				+ CMLConstants.CML_XMLNS
				+ ">"
				+ "<property  dictRef='foo:plugh'>"
				+ "  <array dataType='xsd:double' units='"+Units.GRAM+"'>1.1 2.1 3.1</array>"
				+ "</property>" + "<property  dictRef='foo:bar'>"
				+ "  <molecule/>" + "</property>"
				+ "<property  dictRef='foo:xyzzy'/>" + "</cml>";
		CMLCml cml = (CMLCml)CMLXOMTestUtils.parseValidString(cmlS);
		CMLProperty property = CMLProperty.getProperty(cml, "foo:plugh");
		HasDataType child = property.getChild();
		Assert.assertNotNull("child", child);
		property = CMLProperty.getProperty(cml, "foo:bar");
		child = property.getChild();
		Assert.assertNull("child", child);
	}

	/** dewisott */
	@Test
	public final void testGetDataType() {
		String cmlS = "<cml "
				+ CMLConstants.CML_XMLNS
				+ ">"
				+ "<property  dictRef='foo:plugh'>"
				+ "  <array dataType='xsd:double' units='"+Units.GRAM+"'>1.1 2.1 3.1</array>"
				+ "</property>" + "<property  dictRef='foo:bar'>"
				+ "  <scalar/>" + "</property>"
				+ "<property  dictRef='foo:xyzzy'/>" + "</cml>";
		CMLCml cml = (CMLCml)CMLXOMTestUtils.parseValidString(cmlS);
		CMLProperty property = CMLProperty.getProperty(cml, "foo:plugh");
		String dataType = property.getDataType();
		Assert.assertEquals("datatype", XSD_DOUBLE, dataType);
		property = CMLProperty.getProperty(cml, "foo:bar");
		dataType = property.getDataType();
		Assert.assertEquals("datatype", XSD_STRING, dataType);
	}

}
