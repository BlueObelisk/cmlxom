package org.xmlcml.cml.command;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.xmlcml.cml.schema.TypeSpecification;

public class TypeTest {
	private static Logger LOG = Logger.getLogger(TypeTest.class);
	static {
		LOG.setLevel(Level.DEBUG);
	}
	@Test
	public void testChiralityType() {
		TypeSpecification.CHIRALITY_TYPE.validate("enantiomer");
		try {
			TypeSpecification.CHIRALITY_TYPE.validate("chiral");
			Assert.fail("should throw invalid argument");
		} catch (RuntimeException e) {
		}
	}
	
	@Test
	public void testDataTypeType() {
		
		TypeSpecification.DATATYPE_TYPE.validate("xsd:double");
		try {
			TypeSpecification.DATATYPE_TYPE.validate("xsd:float");
			Assert.fail("should throw invalid argument");
		} catch (RuntimeException e) {
		}
		
	}
	
	@Test
	public void testElementTypeType() {
		TypeSpecification.ELEMENTTYPE_TYPE.validate("Na");
		try {
			TypeSpecification.ELEMENTTYPE_TYPE.validate("Nu");
			Assert.fail("should throw invalid argument");
		} catch (RuntimeException e) {
		}
		
	}
	
	@Test
	public void testFormulaType() {
		TypeSpecification.FORMULA_TYPE.validate("C 1 H 1 O 2 -1");
		try {
			TypeSpecification.FORMULA_TYPE.validate("C2H4");
			Assert.fail("should throw invalid argument");
		} catch (RuntimeException e) {
		}
		
	}
	
	@Test
	public void testIntegerType() {
		TypeSpecification.INTEGER_TYPE.validate("12");
		try {
			TypeSpecification.INTEGER_TYPE.validate("12+");
			Assert.fail("should throw invalid argument");
		} catch (RuntimeException e) {
		}
	}
	
	@Test
	public void testNamespaceType() {
		try {
			TypeSpecification.NAMESPACE_TYPE.validate("http://www.xml-cml.org/schema");
		} catch (RuntimeException e) {
			LOG.debug("threw "+e);
			Assert.fail("should not throw "+e);
		}
		try {
			TypeSpecification.NAMESPACE_TYPE.validate("ftp://foo.com/");
			Assert.fail("should throw invalid argument");
		} catch (RuntimeException e) {
		}
		
	}
	
	@Test
	public void testNonNegativeRealType() {
		TypeSpecification.NONNEGATIVEREAL_TYPE.validate("0.123");
		try {
			TypeSpecification.NONNEGATIVEREAL_TYPE.validate("0.123(3)");
			Assert.fail("should throw invalid argument");
		} catch (RuntimeException e) {
		}
		
	}
	
	@Test
	public void testOrderType() {
		TypeSpecification.ORDER_TYPE.validate("D");
		try {
			TypeSpecification.ORDER_TYPE.validate("2");
			Assert.fail("should throw invalid argument");
		} catch (RuntimeException e) {
		}
		
	}
	
	@Test
	public void testPositiveIntegerType() {
		TypeSpecification.POSITIVEINTEGER_TYPE.validate("2");
		try {
			TypeSpecification.POSITIVEINTEGER_TYPE.validate("0");
			Assert.fail("should throw invalid argument");
		} catch (RuntimeException e) {
		}
		
	}
	
	@Test
	public void testRealNumberType() {
		TypeSpecification.REALNUMBER_TYPE.validate("1.0E-23");
		try {
			TypeSpecification.REALNUMBER_TYPE.validate("1.0H-23");
			Assert.fail("should throw invalid argument");
		} catch (RuntimeException e) {
		}
		
	}
	
	@Test
	public void testQNameType() {
		TypeSpecification.QNAME_TYPE.validate("a:b");
		try {
			TypeSpecification.QNAME_TYPE.validate("ab");
			Assert.fail("should throw invalid argument");
		} catch (RuntimeException e) {
		}
		
	}
	
	@Test
	public void testRefType() {
		TypeSpecification.REF_TYPE.validate("a12");
		try {
			TypeSpecification.REF_TYPE.validate("12a");
			Assert.fail("should throw invalid argument");
		} catch (RuntimeException e) {
		}
		
	}
	
	@Test
	public void testStringType() {
		TypeSpecification.STRING_TYPE.validate("XX");
	}
	

}
