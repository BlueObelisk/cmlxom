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

package org.xmlcml.cml.testutils;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.xmlcml.cml.base.CMLBuilder;
import org.xmlcml.cml.base.CMLConstants;
import org.xmlcml.cml.base.CMLUtil;
import org.xmlcml.cml.element.CMLArray;
import org.xmlcml.cml.element.CMLAtomSet;
import org.xmlcml.cml.element.CMLBondSet;
import org.xmlcml.cml.element.CMLCellParameter;
import org.xmlcml.cml.element.CMLFormula;
import org.xmlcml.cml.element.CMLLatticeVector;
import org.xmlcml.cml.element.CMLLine3;
import org.xmlcml.cml.element.CMLMatrix;
import org.xmlcml.cml.element.CMLMolecule;
import org.xmlcml.cml.element.CMLPlane3;
import org.xmlcml.cml.element.CMLPoint3;
import org.xmlcml.cml.element.CMLTransform3;
import org.xmlcml.cml.element.CMLVector3;
import org.xmlcml.euclid.Point3;
import org.xmlcml.euclid.Vector3;

public class CMLAssert {
	private static final Logger LOG = Logger.getLogger(CMLAssert.class);

	/**
	 * tests equality against list of ids. (order of elements in set is
	 * undefined)
	 * 
	 * @param message
	 * @param expectedAtomIds
	 * @param atomSet
	 */
	public static void assertEquals(String message, String[] expectedAtomIds,
			CMLAtomSet atomSet) {
		Assert.assertEquals(message + "; unequal sizes; expected "
				+ expectedAtomIds.length + ", found: " + atomSet.size(),
				expectedAtomIds.length, atomSet.size());
		Set<String> expectedSet = new HashSet<String>();
		for (String es : expectedAtomIds) {
			expectedSet.add(es);
		}
		Set<String> foundSet = new HashSet<String>();
		String[] fss = atomSet.getAtomIDs();
		for (String fs : fss) {
			foundSet.add(fs);
		}
		Assert.assertTrue("compare atom sets", expectedSet.equals(foundSet));
	}

	/**
	 * resource
	 */
	public final static String TOOLS_RESOURCE = "org" + CMLConstants.U_S + "xmlcml" + CMLConstants.U_S
			+ "cml" + CMLConstants.U_S + "tools";
	/**
	 * examples
	 */
	public final static String TOOLS_EXAMPLES = TOOLS_RESOURCE + CMLConstants.U_S
			+ "examples";

	/**
	 * crystal examples
	 */
	public final static String CRYSTAL_EXAMPLES = TOOLS_EXAMPLES + CMLConstants.U_S
			+ "cryst";

	public static void alwaysFail(String message) {
		Assert.fail("should always throw " + message);
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
		Assert.assertNotNull("test should not be null (" + msg + CMLConstants.S_RBRAK, test);
		Assert.assertNotNull("expected should not be null (" + msg + CMLConstants.S_RBRAK,
				expected);
		if ((test.getDataType() == null || test.getDataType()
				.equals(CMLConstants.XSD_STRING))
				&& (expected.getDataType() == null || expected.getDataType()
						.equals(CMLConstants.XSD_STRING))) {
			Assert.assertEquals(msg, test.getStrings(), expected.getStrings());
		} else if (test.getDataType().equals(CMLConstants.XSD_DOUBLE)
				&& expected.getDataType().equals(CMLConstants.XSD_DOUBLE)) {
			CMLXOMTestUtils.assertEquals(msg, test.getDoubles(), expected.getDoubles(), epsilon);
		} else if (test.getDataType().equals(CMLConstants.XSD_INTEGER)
				&& expected.getDataType().equals(CMLConstants.XSD_INTEGER)) {
			Assert.assertEquals(msg, test.getInts(), expected.getInts());
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
		Assert.assertNotNull("test should not be null (" + msg + CMLConstants.S_RBRAK, test);
		Assert.assertNotNull("expected should not be null (" + msg + CMLConstants.S_RBRAK,
				expected);
		if (!expected.getDataType().equals(CMLConstants.XSD_DOUBLE)) {
			Assert.fail("expected should be double");
		}
		CMLXOMTestUtils.assertEquals(msg, test, expected.getDoubles(), epsilon);
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
		Assert.assertNotNull("test should not be null (" + msg + CMLConstants.S_RBRAK, test);
		Assert.assertNotNull("expected should not be null (" + msg + CMLConstants.S_RBRAK,
				expected);
		if (!expected.getDataType().equals(CMLConstants.XSD_INTEGER)) {
			Assert.fail("expected should be int");
		}
		Assert.assertEquals(msg, test, expected.getInts());
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
		Assert.assertNotNull("test should not be null (" + msg + CMLConstants.S_RBRAK, test);
		Assert.assertNotNull("expected should not be null (" + msg + CMLConstants.S_RBRAK,
				expected);
		if (expected.getDataType() != null
				&& !expected.getDataType().equals(CMLConstants.XSD_STRING)) {
			Assert.fail("expected should be String");
		}
		Assert.assertEquals(msg, test, expected.getStrings());
	}

	/**
	 * asserts equality of double arrays.
	 * 
	 * checks for non-null, then equality of length, then individual elements
	 * 
	 * @param message
	 * @param formula1
	 *            expected formula
	 * @param formula2
	 *            actual formula
	 * @param eps
	 *            tolerance for agreement
	 */
	public static void assertEqualsConcise(String message, CMLFormula formula1,
			CMLFormula formula2, double eps) {
		if (formula1 == null) {
			Assert.fail(CMLXOMTestUtils.getAssertFormat(message, "formula", "null"));
		}
		if (formula2 == null) {
			Assert.fail(CMLXOMTestUtils.getAssertFormat(message, "formula", "null"));
		}
		Assert.assertEquals("equal concise", true, formula1.equals(formula2,
				eps));
	}

	/**
	 * compare two molecules. ignore whitespace nodes in either.
	 * 
	 * @param mol
	 *            to compare
	 * @param filename
	 *            containing molecule as root element
	 */
	public static void assertEqualsCanonically(CMLMolecule mol, String filename) {
		CMLMolecule mol1 = null;
		try {
			mol1 = (CMLMolecule) new CMLBuilder().build(new File(filename))
					.getRootElement();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		assertEqualsCanonically(mol, mol1);
	}

	/**
	 * compare two molecules. ignore whitespace nodes in either.
	 * 
	 * @param mol
	 *            to compare
	 * @param mol1
	 *            .mol1 other molecule
	 */
	public static void assertEqualsCanonically(CMLMolecule mol, CMLMolecule mol1) {
		mol = new CMLMolecule(mol);
		CMLUtil.removeWhitespaceNodes(mol);
		mol1 = new CMLMolecule(mol1);
		CMLUtil.removeWhitespaceNodes(mol1);
		String molS = mol.getCanonicalString();
		String mol1S = mol1.getCanonicalString();
		Assert.assertEquals("MOLECUL equality: ", molS, mol1S);
		CMLXOMTestUtils.assertEqualsCanonically("molecule equality", mol, mol1);
	}

	/**
	 * tests equality against list of ids. (order of elements in set is
	 * undefined)
	 * 
	 * @param message
	 * @param expectedBondIds
	 * @param bondSet
	 */
	public static void assertEquals(String message, String[] expectedBondIds,
			CMLBondSet bondSet) {
		Assert.assertEquals(message + "; unequal sizes; expected "
				+ expectedBondIds.length + ", found: " + bondSet.size(),
				expectedBondIds.length, bondSet.size());
		Set<String> expectedSet = new HashSet<String>();
		for (String es : expectedBondIds) {
			expectedSet.add(es);
		}
		Set<String> foundSet = new HashSet<String>();
		List<String> fss = bondSet.getBondIDs();
		for (String fs : fss) {
			foundSet.add(fs);
		}
		Assert.assertTrue("compare atom sets", expectedSet.equals(foundSet));
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
	public static void assertEquals(String msg, CMLCellParameter test,
			CMLCellParameter expected, double epsilon) {
		Assert.assertNotNull("test should not be null (" + msg + CMLConstants.S_RBRAK, test);
		Assert.assertNotNull("expected should not be null (" + msg + CMLConstants.S_RBRAK,
				expected);
		CMLXOMTestUtils.assertEquals(msg, test.getXMLContent(), expected.getXMLContent(),
				epsilon);
	}

	/**
	 * equality test. true if both args not null and equal within epsilon
	 * 
	 * @param msg
	 *            message
	 * @param type
	 *            of parameter
	 * @param test
	 * @param expected
	 * @param epsilon
	 */
	public static void assertEquals(String msg, String type, double[] test,
			CMLCellParameter expected, double epsilon) {
		Assert.assertNotNull("test should not be null (" + msg + CMLConstants.S_RBRAK, test);
		Assert.assertEquals("must be of length 3", 3, test.length);
		Assert.assertNotNull("type should not be null (" + msg + CMLConstants.S_RBRAK, type);
		Assert.assertNotNull("expected should not be null (" + msg + CMLConstants.S_RBRAK,
				expected);
		Assert.assertNotNull("expected should not have null type (" + msg
				+ CMLConstants.S_RBRAK, expected.getType());
		Assert.assertEquals("types must be equal", 3, test.length);
		CMLXOMTestUtils.assertEquals(msg, test, expected.getXMLContent(), epsilon);
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
	public static void assertEquals(String msg, CMLLatticeVector test,
			CMLLatticeVector expected, double epsilon) {
		Assert.assertNotNull("test should not be null (" + msg + CMLConstants.S_RBRAK, test);
		Assert.assertNotNull("expected should not be null (" + msg + CMLConstants.S_RBRAK,
				expected);
		CMLXOMTestUtils.assertEquals(msg, test.getXMLContent(), expected.getXMLContent(),
				epsilon);
	}

	/**
	 * equality test. true if both args not null and equal within epsilon
	 * 
	 * @param msg
	 *            message
	 * @param test
	 *            array must be of length 3
	 * @param expected
	 * @param epsilon
	 */
	public static void assertEquals(String msg, double[] test,
			CMLLatticeVector expected, double epsilon) {
		Assert.assertNotNull("test should not be null (" + msg + CMLConstants.S_RBRAK, test);
		Assert.assertEquals("must be of length 3", 3, test.length);
		Assert.assertNotNull("expected should not be null (" + msg + CMLConstants.S_RBRAK,
				expected);
		CMLXOMTestUtils.assertEquals(msg, test, expected.getXMLContent(), epsilon);
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
	public static void assertEquals(String msg, CMLLine3 test,
			CMLLine3 expected, double epsilon) {
		Assert.assertNotNull("test should not be null (" + msg + CMLConstants.S_RBRAK, test);
		Assert.assertNotNull("expected should not be null (" + msg + CMLConstants.S_RBRAK,
				expected);
		CMLXOMTestUtils.assertEquals(msg, test.getEuclidLine3(), expected.getEuclidLine3(),
				epsilon);
	}

	/**
	 * equality test. true if both args not null and equal within epsilon
	 * 
	 * @param msg
	 *            message
	 * @param testVector
	 * @param testPoint
	 * @param expected
	 * @param epsilon
	 */
	public static void assertEquals(String msg, CMLPoint3 testPoint,
			CMLVector3 testVector, CMLLine3 expected, double epsilon) {
		Assert.assertNotNull("testVector should not be null (" + msg + CMLConstants.S_RBRAK,
				testVector);
		Assert.assertNotNull("testPoint should not be null (" + msg + CMLConstants.S_RBRAK,
				testPoint);
		Assert.assertNotNull("expected should not be null (" + msg + CMLConstants.S_RBRAK,
				expected);
		CMLXOMTestUtils.assertEquals(msg, testVector.getEuclidVector3(), new Vector3(expected
				.getVector3()), epsilon);
		CMLXOMTestUtils.assertEquals(msg, testPoint.getEuclidPoint3(), new Point3(expected
				.getPoint3()), epsilon);
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
	public static void assertEquals(String msg, CMLMatrix test,
			CMLMatrix expected, double epsilon) {
		Assert.assertNotNull("test should not be null (" + msg + CMLConstants.S_RBRAK, test);
		Assert.assertNotNull("expected should not be null (" + msg + CMLConstants.S_RBRAK,
				expected);
		if (test.getEuclidRealMatrix() != null) {
			CMLXOMTestUtils.assertEquals(msg, test.getEuclidRealMatrix(), expected
					.getEuclidRealMatrix(), epsilon);
		} else if (test.getEuclidIntMatrix() != null) {
			Assert.assertEquals(msg, test.getEuclidIntMatrix(), expected
					.getEuclidIntMatrix());
		} else {
			Assert.fail("both matrices must be either real or int" + test);
		}
	}

	/**
	 * equality test. true if both args not null and equal within epsilon
	 * 
	 * @param msg
	 *            message
	 * @param rows
	 * @param cols
	 * @param test
	 * @param expected
	 * @param epsilon
	 */
	public static void assertEquals(String msg, int rows, int cols,
			double[] test, CMLMatrix expected, double epsilon) {
		Assert.assertNotNull("test should not be null (" + msg + CMLConstants.S_RBRAK, test);
		Assert.assertNotNull("expected should not be null (" + msg + CMLConstants.S_RBRAK,
				expected);
		Assert.assertEquals("rows ", rows, expected.getRows());
		Assert.assertEquals("columns ", cols, expected.getColumns());
		CMLXOMTestUtils.assertEquals(msg, rows, cols, test, expected.getEuclidRealMatrix(),
				epsilon);
	}

	/**
	 * equality test. true if both args not null and equal
	 * 
	 * @param msg
	 *            message
	 * @param rows
	 * @param cols
	 * @param test
	 * @param expected
	 */
	public static void assertEquals(String msg, int rows, int cols, int[] test,
			CMLMatrix expected) {
		Assert.assertNotNull("test should not be null (" + msg + CMLConstants.S_RBRAK, test);
		Assert.assertNotNull("expected should not be null (" + msg + CMLConstants.S_RBRAK,
				expected);
		Assert.assertEquals("rows ", rows, expected.getRows());
		Assert.assertEquals("columns ", cols, expected.getColumns());
		CMLXOMTestUtils.assertEquals(msg, rows, cols, test, expected.getEuclidIntMatrix());
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
	public static void assertEquals(String msg, CMLPlane3 test,
			CMLPlane3 expected, double epsilon) {
		Assert.assertNotNull("test should not be null (" + msg + CMLConstants.S_RBRAK, test);
		Assert.assertNotNull("expected should not be null (" + msg + CMLConstants.S_RBRAK,
				expected);
		CMLXOMTestUtils.assertEquals(msg, test.getArray(), expected.getArray(), epsilon);
	}

	/**
	 * equality test. true if both args not null and equal within epsilon
	 * 
	 * @param msg
	 *            message
	 * @param test
	 *            array must be of length 3
	 * @param expected
	 * @param epsilon
	 */
	public static void assertEquals(String msg, double[] test,
			CMLPlane3 expected, double epsilon) {
		Assert.assertNotNull("test should not be null (" + msg + CMLConstants.S_RBRAK, test);
		Assert.assertEquals("must be of length 4", 4, test.length);
		Assert.assertNotNull("expected should not be null (" + msg + CMLConstants.S_RBRAK,
				expected);
		CMLXOMTestUtils.assertEquals(msg, test, expected.getArray(), epsilon);
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
	public static void assertEquals(String msg, CMLPoint3 test,
			CMLPoint3 expected, double epsilon) {
		Assert.assertNotNull("test should not be null (" + msg + CMLConstants.S_RBRAK, test);
		Assert.assertNotNull("expected should not be null (" + msg + CMLConstants.S_RBRAK,
				expected);
		CMLXOMTestUtils.assertEquals(msg, test.getXYZ3(), expected.getXYZ3(), epsilon);
	}

	/**
	 * equality test. true if both args not null and equal within epsilon
	 * 
	 * @param msg
	 *            message
	 * @param test
	 *            array must be of length 3
	 * @param expected
	 * @param epsilon
	 */
	public static void assertEquals(String msg, double[] test,
			CMLPoint3 expected, double epsilon) {
		Assert.assertNotNull("test should not be null (" + msg + CMLConstants.S_RBRAK, test);
		Assert.assertEquals("must be of length 3", 3, test.length);
		Assert.assertNotNull("expected should not be null (" + msg + CMLConstants.S_RBRAK,
				expected);
		CMLXOMTestUtils.assertEquals(msg, test, expected.getXYZ3(), epsilon);
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
	public static void assertEquals(String msg, CMLTransform3 test,
			CMLTransform3 expected, double epsilon) {
		Assert.assertNotNull("test should not be null (" + msg + CMLConstants.S_RBRAK, test);
		Assert.assertNotNull("expected should not be null (" + msg + CMLConstants.S_RBRAK,
				expected);
		CMLXOMTestUtils.assertEquals(msg, test.getEuclidTransform3(), expected
				.getEuclidTransform3(), epsilon);
	}

	/**
	 * equality test. true if both args not null and equal within epsilon
	 * 
	 * @param msg
	 *            message
	 * @param test
	 *            array must be of length 3
	 * @param expected
	 * @param epsilon
	 */
	public static void assertEquals(String msg, double[] test,
			CMLTransform3 expected, double epsilon) {
		Assert.assertNotNull("test should not be null (" + msg + CMLConstants.S_RBRAK, test);
		Assert.assertEquals("must be of length 16", 16, test.length);
		Assert.assertNotNull("expected should not be null (" + msg + CMLConstants.S_RBRAK,
				expected);
		CMLXOMTestUtils.assertEquals(msg, test, expected.getEuclidTransform3(), epsilon);
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
	public static void assertEquals(String msg, CMLVector3 test,
			CMLVector3 expected, double epsilon) {
		Assert.assertNotNull("test should not be null (" + msg + CMLConstants.S_RBRAK, test);
		Assert.assertNotNull("expected should not be null (" + msg + CMLConstants.S_RBRAK,
				expected);
		CMLXOMTestUtils.assertEquals(msg, test.getXYZ3(), expected.getXYZ3(), epsilon);
	}

	/**
	 * equality test. true if both args not null and equal within epsilon
	 * 
	 * @param msg
	 *            message
	 * @param test
	 *            array must be of length 3
	 * @param expected
	 * @param epsilon
	 */
	public static void assertEquals(String msg, double[] test,
			CMLVector3 expected, double epsilon) {
		Assert.assertNotNull("test should not be null (" + msg + CMLConstants.S_RBRAK, test);
		Assert.assertEquals("must be of length 3", 3, test.length);
		Assert.assertNotNull("expected should not be null (" + msg + CMLConstants.S_RBRAK,
				expected);
		CMLXOMTestUtils.assertEquals(msg, test, expected.getXYZ3(), epsilon);
	}

}
