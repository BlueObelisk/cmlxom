package org.xmlcml.cml.command;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

public class TypeTest {
	private static Logger LOG = Logger.getLogger(TypeTest.class);
	static {
		LOG.setLevel(Level.DEBUG);
	}
	@Test
	public void testChiralityType() {
		TypeNG.CHIRALITY_TYPE.validate("enantiomer");
		try {
			TypeNG.CHIRALITY_TYPE.validate("chiral");
			Assert.fail("should throw invalid argument");
		} catch (RuntimeException e) {
		}
	}
	
	@Test
	public void testDataTypeType() {
		
		TypeNG.DATATYPE_TYPE.validate("xsd:double");
		try {
			TypeNG.DATATYPE_TYPE.validate("xsd:float");
			Assert.fail("should throw invalid argument");
		} catch (RuntimeException e) {
		}
		
	}
	
	@Test
	public void testElementTypeType() {
		TypeNG.ELEMENTTYPE_TYPE.validate("Na");
		try {
			TypeNG.ELEMENTTYPE_TYPE.validate("Nu");
			Assert.fail("should throw invalid argument");
		} catch (RuntimeException e) {
		}
		
	}
	
	@Test
	public void testFormulaType() {
		TypeNG.FORMULA_TYPE.validate("C 1 H 1 O 2 -1");
		try {
			TypeNG.FORMULA_TYPE.validate("C2H4");
			Assert.fail("should throw invalid argument");
		} catch (RuntimeException e) {
		}
		
	}
	
	@Test
	public void testIntegerType() {
		TypeNG.INTEGER_TYPE.validate("12");
		try {
			TypeNG.INTEGER_TYPE.validate("12+");
			Assert.fail("should throw invalid argument");
		} catch (RuntimeException e) {
		}
	}
	
	@Test
	public void testNamespaceType() {
		try {
			TypeNG.NAMESPACE_TYPE.validate("http://www.xml-cml.org/schema");
		} catch (RuntimeException e) {
			LOG.debug("threw "+e);
			Assert.fail("should not throw "+e);
		}
		try {
			TypeNG.NAMESPACE_TYPE.validate("ftp://foo.com/");
			Assert.fail("should throw invalid argument");
		} catch (RuntimeException e) {
		}
		
	}
	
	@Test
	public void testNonNegativeRealType() {
		TypeNG.NONNEGATIVEREAL_TYPE.validate("0.123");
		try {
			TypeNG.NONNEGATIVEREAL_TYPE.validate("0.123(3)");
			Assert.fail("should throw invalid argument");
		} catch (RuntimeException e) {
		}
		
	}
	
	@Test
	public void testOrderType() {
		TypeNG.ORDER_TYPE.validate("D");
		try {
			TypeNG.ORDER_TYPE.validate("2");
			Assert.fail("should throw invalid argument");
		} catch (RuntimeException e) {
		}
		
	}
	
	@Test
	public void testPositiveIntegerType() {
		TypeNG.POSITIVEINTEGER_TYPE.validate("2");
		try {
			TypeNG.POSITIVEINTEGER_TYPE.validate("0");
			Assert.fail("should throw invalid argument");
		} catch (RuntimeException e) {
		}
		
	}
	
	@Test
	public void testRealNumberType() {
		TypeNG.REALNUMBER_TYPE.validate("1.0E-23");
		try {
			TypeNG.REALNUMBER_TYPE.validate("1.0H-23");
			Assert.fail("should throw invalid argument");
		} catch (RuntimeException e) {
		}
		
	}
	
	@Test
	public void testQNameType() {
		TypeNG.QNAME_TYPE.validate("a:b");
		try {
			TypeNG.QNAME_TYPE.validate("ab");
			Assert.fail("should throw invalid argument");
		} catch (RuntimeException e) {
		}
		
	}
	
	@Test
	public void testRefType() {
		TypeNG.REF_TYPE.validate("a12");
		try {
			TypeNG.REF_TYPE.validate("12a");
			Assert.fail("should throw invalid argument");
		} catch (RuntimeException e) {
		}
		
	}
	
	@Test
	public void testStringType() {
		TypeNG.STRING_TYPE.validate("XX");
	}
	

}
