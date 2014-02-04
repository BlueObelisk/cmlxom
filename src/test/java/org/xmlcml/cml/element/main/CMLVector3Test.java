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

import static org.xmlcml.euclid.EuclidConstants.EPS;

import java.io.StringReader;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.xmlcml.cml.base.CMLBuilder;
import org.xmlcml.cml.base.CMLConstants;
import org.xmlcml.cml.element.CMLLine3;
import org.xmlcml.cml.element.CMLPlane3;
import org.xmlcml.cml.element.CMLPoint3;
import org.xmlcml.cml.element.CMLTransform3;
import org.xmlcml.cml.element.CMLVector3;
import org.xmlcml.euclid.Angle;
import org.xmlcml.euclid.EuclidConstants;
import org.xmlcml.euclid.EuclidRuntimeException;
import org.xmlcml.euclid.Vector3;
import org.xmlcml.euclid.test.DoubleTestBase;

/**
 * tests Vector3.
 * 
 * @author pmr
 * 
 */
public class CMLVector3Test extends GeomTestBase {

	CMLPoint3 xomP;
	CMLPlane3 xomPl;
	CMLLine3 xomL;
	CMLVector3 xomV;
	CMLPoint3 xomP111;
	CMLPoint3 xomP100;
	CMLPoint3 xomP010;
	CMLPoint3 xomP001;
	CMLPoint3 xomP123;
	CMLPlane3 xomPl0100;
	CMLPlane3 xomPl1002;
	CMLPlane3 xomPl1115;
	CMLPlane3 xomPl1005;
	CMLLine3 xomL555111;
	CMLVector3 xomV000;
	CMLVector3 xomV100;
	CMLVector3 xomV010;
	CMLVector3 xomV001;
	CMLVector3 xomV111;
	CMLVector3 xomV123;
	CMLVector3 xomV321;
	CMLLine3 xomL220011;
	CMLTransform3 xomT1;
	String xmlP111S;
	String xmlP100S;
	String xmlP010S;
	String xmlP001S;
	String xmlP123S;
	CMLPoint3 xmlP111;
	CMLPoint3 xmlP100;
	CMLPoint3 xmlP010;
	CMLPoint3 xmlP001;
	CMLPoint3 xmlP123;

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
		DoubleTestBase.assertEquals(msg, test.getXYZ3(), expected.getXYZ3(),
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
			CMLVector3 expected, double epsilon) {
		Assert.assertNotNull("test should not be null (" + msg + CMLConstants.S_RBRAK, test);
		Assert.assertEquals("must be of length 3", 3, test.length);
		Assert.assertNotNull("expected should not be null (" + msg + CMLConstants.S_RBRAK,
				expected);
		DoubleTestBase.assertEquals(msg, test, expected.getXYZ3(), epsilon);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLVector3.CMLVector3()'
	 */
	@Test
	public void testCMLVector3() {
		// new CMLVector3(); // deliberately not public
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLVector3.CMLVector3(CMLVector3)'
	 */
	@Test
	public void testCMLVector3CMLVector3() {
		CMLVector3 v = new CMLVector3(xomV123);
		CMLVector3Test
				.assertEquals("copy", new double[] { 1., 2., 3. }, v, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLVector3.CMLVector3(double[])'
	 */
	@Test
	public void testCMLVector3DoubleArray() {
		double[] dd = { 3., 2., 4. };
		CMLVector3 v = new CMLVector3(dd);
		CMLVector3Test.assertEquals("copy", dd, v, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLVector3.CMLVector3(CMLPoint3)'
	 */
	@Test
	public void testCMLVector3CMLPoint3() {
		CMLVector3 v = new CMLVector3(xomP123);
		CMLVector3Test.assertEquals("from point", new double[] { 1., 2., 3. },
				v, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLVector3.setXYZ3(double[])'
	 */
	@Test
	public void testSetXYZ3() {
		xomV100.setXYZ3(new double[] { 3., 2., 4. });
		CMLVector3Test.assertEquals("set", new double[] { 3., 2., 4. },
				xomV100, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLVector3.getXYZ3()'
	 */
	@Test
	public void testGetXYZ3() {
		CMLVector3Test.assertEquals("copy", new double[] { 1., 2., 3. },
				xomV123, EPS);
		xomV123.setXYZ3(new double[] { 4., 5., 6. });
		CMLVector3Test.assertEquals("copy", new double[] { 4., 5., 6. },
				xomV123, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLVector3.equals(CMLVector3)'
	 */
	@Test
	public void testEqualsCMLVector3() {
		CMLVector3 v1 = new CMLVector3(new double[] { 4., 5., 6. });
		CMLVector3 v2 = new CMLVector3(new double[] { 4., 5., 6. });
		Assert.assertTrue("equals", v1.isEqualTo(v2));
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLVector3.getLength()'
	 */
	@Test
	public void testGetLength() {
		Assert.assertEquals("length", Math.sqrt(14.), xomV123.getLength(), EPS);
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLVector3.getCrossProduct(CMLVector3)'
	 */
	@Test
	public void testGetCrossProduct() {
		CMLVector3 x = xomV100.getCrossProduct(xomV010);
		CMLVector3Test.assertEquals("cross", new double[] { 0., 0., 1. }, x,
				EPS);
		Assert.assertTrue("cross", xomV001.isEqualTo(x));
		CMLVector3Test.assertEquals("cross", new double[] { 1., 0., 0. },
				xomV100, EPS);
		CMLVector3Test.assertEquals("cross", new double[] { 0., 1., 0. },
				xomV010, EPS);
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLVector3.longerThan(CMLVector3)'
	 */
	@Test
	public void testLongerThan() {
		Assert.assertEquals("longer", true, xomV123.longerThan(xomV100));
		Assert.assertEquals("longer", true, !xomV100.longerThan(xomV100));
		Assert.assertEquals("longer", true, !xomV100.longerThan(xomV123));
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLVector3.multiplyBy(double)'
	 */
	@Test
	public void testMultiplyBy() {
		CMLVector3 v = xomV123.multiplyBy(2.);
		CMLVector3Test.assertEquals("multiply", new double[] { 2., 4., 6. }, v,
				EPS);
		CMLVector3Test.assertEquals("multiply", new double[] { 1., 2., 3. },
				xomV123, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLVector3.plus(CMLVector3)'
	 */
	@Test
	public void testPlus() {
		CMLVector3 v = xomV100.plus(xomV010);
		CMLVector3Test.assertEquals("subtract", new double[] { 1., 0., 0. },
				xomV100, EPS);
		CMLVector3Test.assertEquals("subtract", new double[] { 1., 1., 0. }, v,
				EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLVector3.subtract(CMLVector3)'
	 */
	@Test
	public void testSubtract() {
		CMLVector3 v = xomV100.subtract(xomV010);
		CMLVector3Test.assertEquals("subtract", new double[] { 1., 0., 0. },
				xomV100, EPS);
		CMLVector3Test.assertEquals("subtract", new double[] { 1., -1., 0. },
				v, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLVector3.elementAt(int)'
	 */
	@Test
	public void testElementAt() {
		double d = xomV123.elementAt(0);
		Assert.assertEquals("element", 1., d, EPS);
		d = xomV123.elementAt(1);
		Assert.assertEquals("element", 2., d, EPS);
		d = xomV123.elementAt(2);
		Assert.assertEquals("element", 3., d, EPS);
		try {
			xomV123.elementAt(-1);
		} catch (EuclidRuntimeException e) {
			Assert.assertEquals("set", "index (-1)out of range: 0/2", e
					.getMessage());
		}
		try {
			xomV123.elementAt(3);
		} catch (EuclidRuntimeException e) {
			Assert.assertEquals("set", "index (3)out of range: 0/2", e
					.getMessage());
		}
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLVector3Test.setElementAt(int,
	 * double)'
	 */
	@Test
	public void testSetElementAt() {

		CMLVector3Test.assertEquals("set", new double[] { 1., 2., 3. },
				xomV123, EPS);
		xomV123.setElementAt(0, 11.);
		CMLVector3Test.assertEquals("set", new double[] { 11., 2., 3. },
				xomV123, EPS);
		xomV123.setElementAt(1, 12.);
		CMLVector3Test.assertEquals("set", new double[] { 11., 12., 3. },
				xomV123, EPS);
		xomV123.setElementAt(2, 13.);
		CMLVector3Test.assertEquals("set", new double[] { 11., 12., 13. },
				xomV123, EPS);
		try {
			xomV123.setElementAt(-1, 20.);
		} catch (EuclidRuntimeException e) {
			Assert.assertEquals("set", "index (-1)out of range: 0/2", e
					.getMessage());
		}
		try {
			xomV123.setElementAt(3, 20.);
		} catch (EuclidRuntimeException e) {
			Assert.assertEquals("set", "index (3)out of range: 0/2", e
					.getMessage());
		}
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLVector3.isZero()'
	 */
	@Test
	public void testIsZero() {
		Assert.assertEquals("zero", true, !xomV123.isZero());
		Assert.assertEquals("zero", true, xomV000.isZero());
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLVector3.transform(CMLTransform3)'
	 */
	@Test
	public void testTransform() {
		CMLVector3 v = new CMLVector3(new double[] { 1., 2., 3. });
		CMLTransform3 t = new CMLTransform3(new double[] { 0., 0., 1., 10.,
				-1., 0., 0., 99., 0, 1, 0., -10., 0, 0, 0., 1. });
		// note that the translation is not applied to the vector
		CMLVector3 vv = v.transform(t);
		CMLVector3Test.assertEquals("transformed vector", new double[] { 3.,
				-1., 2., }, vv, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLVector3.normalize()'
	 */
	@Test
	public void testNormalize() {
		CMLVector3 v = xomV123.normalize();
		double x = Math.sqrt(14.);
		CMLVector3Test.assertEquals("normalize", new double[] { 1. / x, 2. / x,
				3. / x }, xomV123, EPS);
		CMLVector3Test.assertEquals("normalize", new double[] { 1. / x, 2. / x,
				3. / x }, v, EPS);
		try {
			xomV000.normalize();
		} catch (RuntimeException e) {
			Assert.assertEquals("normalize", "Cannot normalize zero vector", e
					.getMessage());
		}
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLVector3.dot(CMLVector3)'
	 */
	@Test
	public void testDot() {
		double d = xomV123.dot(xomV321);
		Assert.assertEquals("dot", 10., d, EPS);
		CMLVector3Test.assertEquals("dot", new double[] { 1., 2., 3. },
				xomV123, EPS);
		CMLVector3Test.assertEquals("dot", new double[] { 3., 2., 1. },
				xomV321, EPS);
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLVector3.getAngleMadeWith(CMLVector3)'
	 */
	@Test
	public void testGetAngleMadeWith() {
		Angle a = null;
		a = xomV100.getAngleMadeWith(xomV010);
		Assert.assertNotNull("angle", a);
		Assert.assertEquals("angle", Math.PI / 2., a.getRadian(), EPS);
		CMLVector3Test.assertEquals("angle", new double[] { 1., 0., 0. },
				xomV100, EPS);
		CMLVector3Test.assertEquals("angle", new double[] { 0., 1., 0. },
				xomV010, EPS);
		a = xomV100.getAngleMadeWith(xomV100);
		Assert.assertNotNull("angle", a);
		Assert.assertEquals("angle", 0., a.getRadian(), EPS);
		CMLVector3Test.assertEquals("angle", new double[] { 1., 0., 0. },
				xomV100, EPS);
		CMLVector3Test.assertEquals("angle", new double[] { 0., 1., 0. },
				xomV010, EPS);
		a = xomV321.getAngleMadeWith(xomV123);
		Assert.assertNotNull("angle", a);
		double aa = 2 * Math.asin(Math.sqrt(2.) / Math.sqrt(14.));
		Assert.assertEquals("angle", aa, a.getRadian(), EPS);
		CMLVector3Test.assertEquals("angle", new double[] { 1., 2., 3. },
				xomV123, EPS);
		CMLVector3Test.assertEquals("angle", new double[] { 3., 2., 1. },
				xomV321, EPS);
		a = xomV100.getAngleMadeWith(xomV000);
		Assert.assertNull("angle zero vector", a);
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLVector3.getScalarTripleProduct(CMLVector3,
	 * CMLVector3)'
	 */
	@Test
	public void testGetScalarTripleProduct() {
		double a = Double.NaN;
		a = xomV100.getScalarTripleProduct(xomV010, xomV001);
		Assert.assertEquals("stp", 1, a, EPS);
		CMLVector3Test.assertEquals("stp", new double[] { 1., 0., 0. },
				xomV100, EPS);
		CMLVector3Test.assertEquals("stp", new double[] { 0., 1., 0. },
				xomV010, EPS);

		a = xomV100.getScalarTripleProduct(xomV010, xomV000);
		Assert.assertEquals("stp", 0, a, EPS);
		CMLVector3Test.assertEquals("stp", new double[] { 1., 0., 0. },
				xomV100, EPS);
		CMLVector3Test.assertEquals("stp", new double[] { 0., 1., 0. },
				xomV010, EPS);

		a = xomV100.getScalarTripleProduct(xomV321, xomV123);
		Assert.assertEquals("stp", 4, a, EPS);
		CMLVector3Test.assertEquals("stp", new double[] { 1., 2., 3. },
				xomV123, EPS);
		CMLVector3Test.assertEquals("stp", new double[] { 3., 2., 1. },
				xomV321, EPS);
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLVector3.projectOnto(CMLVector3)'
	 */
	@Test
	public void testProjectOnto() {
		CMLVector3 v = xomV123.projectOnto(xomV100);
		CMLVector3Test.assertEquals("project", new double[] { 1., 0., 0. }, v,
				EPS);
		CMLVector3Test.assertEquals("project", new double[] { 1., 2., 3. },
				xomV123, EPS);

		v = xomV123.projectOnto(xomV010);
		CMLVector3Test.assertEquals("project", new double[] { 0., 2., 0. }, v,
				EPS);
		CMLVector3Test.assertEquals("project", new double[] { 1., 2., 3. },
				xomV123, EPS);

		v = xomV123.projectOnto(xomV001);
		CMLVector3Test.assertEquals("project", new double[] { 0., 0., 3. }, v,
				EPS);
		CMLVector3Test.assertEquals("project", new double[] { 1., 2., 3. },
				xomV123, EPS);

		v = xomV123.projectOnto(xomV000);
		Assert.assertNull("project", v);
		CMLVector3Test.assertEquals("project", new double[] { 1., 2., 3. },
				xomV123, EPS);

		v = xomV000.projectOnto(xomV123);
		Assert.assertNull("project", v);
		CMLVector3Test.assertEquals("project", new double[] { 1., 2., 3. },
				xomV123, EPS);

	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLVector3.isColinearVector(CMLVector3)'
	 */
	@Test
	public void testIsColinearVector() {
		Assert.assertFalse("colinear", xomV123.isColinearVector(xomV100));
		Assert.assertTrue("colinear", xomV100.isColinearVector(xomV100));
		CMLVector3 xomV200 = new CMLVector3(new double[] { 2., 0., 0. });
		Assert.assertTrue("colinear", xomV100.isColinearVector(xomV200));

	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLVector3.getNonColinearVector()'
	 */
	@Test
	public void testGetNonColinearVector() {
		CMLVector3 v = xomV100.getNonColinearVector();
		Assert.assertFalse("noncolinear", v.isColinearVector(xomV100));
		CMLVector3Test.assertEquals("noncolinear", new double[] { 1., 0., 0. },
				xomV100, EPS);
		v = xomV123.getNonColinearVector();
		Assert.assertFalse("noncolinear", v.isColinearVector(xomV123));
		CMLVector3Test.assertEquals("noncolinear", new double[] { 1., 2., 3. },
				xomV123, EPS);
		v = xomV000.getNonColinearVector();
		Assert.assertFalse("noncolinear", v.isZero());
		Assert.assertTrue("noncolinear", xomV000.isZero());

	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLVector3.getPerpendicularVector()'
	 */
	@Test
	public void testGetPerpendicularVector() {
		CMLVector3 v = xomV100.getPerpendicularVector();
		Assert.assertEquals("perpendicular", true, !v.isZero());
		Angle a = v.getAngleMadeWith(xomV100);
		Assert.assertNotNull("angle ", a);
		Assert.assertEquals("perpendicular", Math.PI / 2., a.getRadian(), EPS);
		v = xomV123.getPerpendicularVector();
		Assert.assertEquals("perpendicular", true, !v.isZero());
		a = v.getAngleMadeWith(xomV123);
		Assert.assertNotNull("angle ", a);
		Assert.assertEquals("perpendicular", Math.PI / 2., a.getRadian(), EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLVector3.copy()'
	 */
	@Test
	public void testCopy() {
		CMLVector3 v = new CMLVector3(1., 2., 3.);
		CMLVector3 vv = (CMLVector3) v.copy();
		CMLVector3Test.assertEquals("copy ", new double[] { 1., 2., 3. }, vv,
				EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLVector3.CMLVector3(Vector3)'
	 */
	@Test
	public void testCMLVector3Vector3() {
		CMLVector3 v = new CMLVector3(new Vector3(1., 2., 3.));
		CMLVector3Test.assertEquals("constructor ",
				new double[] { 1., 2., 3. }, v, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLVector3.CMLVector3(double,
	 * double, double)'
	 */
	@Test
	public void testCMLVector3DoubleDoubleDouble() {
		CMLVector3 v = new CMLVector3(1., 2., 3.);
		CMLVector3Test.assertEquals("constructor ",
				new double[] { 1., 2., 3. }, v, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLVector3.getEuclidVector3()'
	 */
	@Test
	public void testGetEuclidVector3() {
		CMLVector3 v = new CMLVector3(1., 2., 3.);
		double[] test = new double[] { 1., 2., 3. };
		Vector3 expected = v.getEuclidVector3();
		Assert.assertNotNull("test should not be null (" + "euclidVector " + EuclidConstants.S_RBRAK, test);
		Assert.assertEquals("must be of length 3", 3, test.length);
		Assert.assertNotNull("expected should not be null (" + "euclidVector " + EuclidConstants.S_RBRAK,
				expected);
		DoubleTestBase.assertEquals("euclidVector ", test, expected.getArray(), EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLVector3.isEqualTo(CMLVector3)'
	 */
	@Test
	public void testIsEqualToCMLVector3() {
		CMLVector3 v = new CMLVector3(1., 2., 3.);
		CMLVector3 vv = new CMLVector3(1., 2., 3.);
		Assert.assertTrue("isEqual ", v.isEqualTo(vv));
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLVector3.isEqualTo(CMLVector3,
	 * double)'
	 */
	@Test
	public void testIsEqualToCMLVector3Double() {
		CMLVector3 v = new CMLVector3(1., 2., 3.);
		CMLVector3 vv = new CMLVector3(1., 2., 3.);
		Assert.assertTrue("isEqual ", v.isEqualTo(vv, EPS));
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLVector3.getString()'
	 */
	@Test
	public void testGetString() {
		CMLVector3 v = new CMLVector3(1., 2., 3.);
		String s = v.getString();
		Assert.assertEquals("getString", "(1.0,2.0,3.0)", s);
	}

	/**
	 * setup.
	 * 
	 * @throws Exception
	 */
	@Before
	public synchronized void setUp() throws Exception {
	
		// create from XOM
		// xomP = new CMLPoint3(); // deliberately disallowed
		// xomPl = new CMLPlane3(); // deliberately disallowed
		// xomL = new CMLLine3(); // deliberately disallowed
		// xomV = new CMLVector3(); // deliberately disallowed
	
		xomP111 = new CMLPoint3(new double[] { 1., 1., 1. });
		xomP100 = new CMLPoint3(new double[] { 1., 0., 0. });
		xomP010 = new CMLPoint3(new double[] { 0., 1., 0. });
		xomP001 = new CMLPoint3(new double[] { 0., 0., 1. });
		xomP123 = new CMLPoint3(new double[] { 1., 2., 3. });
	
		xomPl0100 = new CMLPlane3(new double[] { 0., 1., 0., 0. });
		xomPl1002 = new CMLPlane3(new double[] { 1., 0., 0., 2. });
		xomPl1005 = new CMLPlane3(new double[] { 1., 0., 0., 5. });
		xomPl1115 = new CMLPlane3(new double[] { 1., 1., 1., 5. });
	
		// xomL555111 = new CMLLine3(new double[]{5., 5., 5., 1., 1., 1.});
		xomL220011 = new CMLLine3(new CMLPoint3(0., 1., 1.), new CMLVector3(2.,
				2., 0.));
	
		xomV000 = new CMLVector3(new double[] { 0., 0., 0. });
		xomV100 = new CMLVector3(new double[] { 1., 0., 0. });
		xomV010 = new CMLVector3(new double[] { 0., 1., 0. });
		xomV001 = new CMLVector3(new double[] { 0., 0., 1. });
		xomV111 = new CMLVector3(new double[] { 1., 1., 1. });
		xomV123 = new CMLVector3(new double[] { 1., 2., 3. });
		xomV321 = new CMLVector3(new double[] { 3., 2., 1. });
	
		// create from XML
		xmlP111S = "<point3 " + CMLConstants.CML_XMLNS + ">1. 1. 1.</point3>";
		xmlP100S = "<point3 " + CMLConstants.CML_XMLNS + ">1 0 0</point3>";
		xmlP010S = "<point3 " + CMLConstants.CML_XMLNS + ">0 1.0E+00 0</point3>";
		xmlP001S = "<point3 " + CMLConstants.CML_XMLNS + ">0 0 1</point3>";
		xmlP123S = "<point3 " + CMLConstants.CML_XMLNS + ">1 2 3</point3>";
	
		CMLBuilder builder = new CMLBuilder();
		xmlP111 = (CMLPoint3) builder.build(new StringReader(xmlP111S))
				.getRootElement();
		xmlP123 = (CMLPoint3) builder.build(new StringReader(xmlP123S))
				.getRootElement();
		xmlP100 = (CMLPoint3) builder.build(new StringReader(xmlP100S))
				.getRootElement();
		xmlP010 = (CMLPoint3) builder.build(new StringReader(xmlP010S))
				.getRootElement();
		xmlP001 = (CMLPoint3) builder.build(new StringReader(xmlP001S))
				.getRootElement();
	
	}

	void makeXomT1() {
		xomT1 = new CMLTransform3(new double[] { 0., 1., 0., 0., 0., 0., 1.,
				0., -1., 0., 0., 0., 0., 0., 0., 1. });
	}

}
