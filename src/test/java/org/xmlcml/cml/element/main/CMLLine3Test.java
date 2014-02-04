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
import org.xmlcml.euclid.Line3;
import org.xmlcml.euclid.Point3;
import org.xmlcml.euclid.Vector3;
import org.xmlcml.euclid.test.DoubleTestBase;

/**
 * tset CMLLine3
 * 
 * @author pmr
 * 
 */
public class CMLLine3Test extends GeomTestBase {

	CMLPoint3 pp = null;

	CMLVector3 vv = null;

	CMLLine3 ll = null;

	double s14 = Math.sqrt(14.);

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
	private static void assertEquals(String msg, CMLLine3 test,
			CMLLine3 expected, double epsilon) {
		Assert.assertNotNull("test should not be null (" + msg + CMLConstants.S_RBRAK, test);
		Assert.assertNotNull("expected should not be null (" + msg + CMLConstants.S_RBRAK,
				expected);
		Assert.assertTrue(test.getEuclidLine3().isEqualTo(expected.getEuclidLine3()));
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
	private static void assertEquals(String msg, CMLPoint3 testPoint,
			CMLVector3 testVector, CMLLine3 expected, double epsilon) {
		Assert.assertNotNull("testVector should not be null (" + msg + CMLConstants.S_RBRAK,
				testVector);
		Assert.assertNotNull("testPoint should not be null (" + msg + CMLConstants.S_RBRAK,
				testPoint);
		Assert.assertNotNull("expected should not be null (" + msg + CMLConstants.S_RBRAK,
				expected);
		Vector3 test = testVector.getEuclidVector3();
		Vector3 expected1 = new Vector3(expected.getVector3());
		Assert.assertNotNull("test should not be null (" + msg + EuclidConstants.S_RBRAK, test);
		Assert.assertNotNull("expected should not be null (" + msg + EuclidConstants.S_RBRAK,
				expected1);
		DoubleTestBase.assertEquals(msg, test.getArray(), expected1.getArray(),
				epsilon);
		
		Assert.assertTrue(testPoint.getEuclidPoint3().isEqualTo(new Point3(expected.getPoint3())));
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLLine3.CMLLine3()'
	 */
	@Test
	public void testCMLLine3() {
		CMLLine3 l = (CMLLine3) ll.copy();
		CMLLine3Test.assertEquals("copy constructor", l, ll, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLLine3 parse()'
	 */
	@Test
	public void testParse() {
		String s = "<line3 point3='4. 5. 6.' vector3='1. 2. 3.'" + CMLConstants.S_SPACE
				+ CMLConstants.CML_XMLNS + ">1. 2. 3. 4. 5. 6. </line3>";
		CMLLine3 l = null;
		try {
			l = (CMLLine3) new CMLBuilder().build(new StringReader(s))
					.getRootElement();
		} catch (Exception e) {
			Assert.fail("should not throw exception" + e.getMessage());
		}
		CMLLine3Test.assertEquals("parse", new CMLPoint3(4., 5., 6.),
				new CMLVector3(1., 2., 3.), l, EPS);

	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLLine3.CMLLine3(CMLLine3)'
	 */
	@Test
	public void testCMLLine3CMLLine3() {
		CMLLine3 l = new CMLLine3(xomL220011);
		CMLLine3Test.assertEquals("copy", l, xomL220011, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLLine3.CMLLine3(CMLPoint3,
	 * CMLVector3)'
	 */
	@Test
	public void testCMLLine3CMLPoint3CMLVector3() {
		double x = 1. / Math.sqrt(14.);
		double[] v = new double[] { 1., 2., 3. };
		double[] p = new double[] { 4., 5., 6. };
		CMLLine3 l = new CMLLine3(new CMLPoint3(p), new CMLVector3(v));
		CMLLine3Test.assertEquals("line", new CMLPoint3(p), new CMLVector3(x,
				2 * x, 3 * x), l, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLLine3.CMLLine3(CMLPoint3,
	 * CMLPoint3)'
	 */
	@Test
	public void testCMLLine3CMLPoint3CMLPoint3() {
		double[] d1 = new double[] { 1., 2., 3. };
		double[] d2 = new double[] { 4., 5., 6. };
		CMLPoint3 p1 = new CMLPoint3(d1);
		CMLPoint3 p2 = new CMLPoint3(d2);
		CMLLine3 l = new CMLLine3(p1, p2);
		CMLLine3Test.assertEquals("line", new CMLPoint3(d1), new CMLVector3(
				-3., -3., -3.), l, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLLine3.equals(CMLLine3)'
	 */
	@Test
	public void testEqualsCMLLine3() {
		CMLLine3 l = new CMLLine3(pp, vv);
		Assert.assertTrue("equals", l.isEqualTo(ll));
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLLine3.subtract()'
	 */
	@Test
	public void testSubtract() {
		CMLLine3 l2 = ll.subtract();
		CMLLine3Test.assertEquals("subtract", new CMLPoint3(6., 5., 4.),
				new CMLVector3(-1., -2., -3.).normalize(), l2, EPS);
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLLine3.transform(CMLTransform3)'
	 */
	@Test
	public void testTransform() {
		CMLVector3 v = new CMLVector3(new double[] { 1., 1., 1. });
		CMLTransform3 t = new CMLTransform3(v, Math.PI * 2. / 3.);
		CMLTransform3Test.assertEquals("transform", new double[] { 0, 0, 1, 0,
				1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1 }, t, EPS);
		CMLLine3 l1 = ll.transform(t);
		CMLLine3Test.assertEquals("l1", new CMLPoint3(4., 6., 5.),
				new CMLVector3(3. / s14, 1. / s14, 2. / s14), l1, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLLine3.isParallelTo(CMLLine3)'
	 */
	@Test
	public void testIsParallelTo() {
		CMLLine3 l2 = new CMLLine3(ll);
		Assert.assertTrue("parallel", ll.isParallelTo(l2));
		CMLLine3 l3 = new CMLLine3(pp, new CMLVector3(1.1, 2.1, 3.1));
		Assert.assertFalse("parallel", ll.isParallelTo(l3));
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLLine3.containsPoint(CMLPoint3)'
	 */
	@Test
	public void testContainsPoint() {
		CMLPoint3 p = new CMLPoint3(new double[] { 6, 5, 4 });
		Assert.assertTrue("contains", ll.containsPoint(p));
		p = new CMLPoint3(new double[] { 4, 5, 6 });
		Assert.assertFalse("contains", ll.containsPoint(p));
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLLine3.getClosestPointTo(CMLPoint3)'
	 */
	@Test
	public void testGetClosestPointTo() {
		CMLPoint3 p0 = new CMLPoint3(0., 0., 0.);
		CMLPoint3 p = ll.getClosestPointTo(p0);
		double d = p0.getDistanceFromPoint(p);
		Assert.assertEquals("line distance", 4.58257569495584, d, 0.0001);
		// show result is perpendicular
		CMLVector3 v = p.subtract(p0);
		CMLVector3 vv = new CMLVector3(ll.getVector3());
		Angle a = v.getAngleMadeWith(vv);
		Assert.assertNotNull("angle ", a);
		Assert.assertEquals("angle closest", Math.PI / 2., a.getRadian(), EPS);

	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLLine3.getDistanceFromPoint(CMLPoint3)'
	 */
	@Test
	public void testGetDistanceFromPoint() {
		CMLPoint3 p = new CMLPoint3(1., 1., 1.);
		CMLLine3 l = new CMLLine3(new CMLPoint3(4., 5., 6.), new CMLVector3(1.,
				2., 3.));
		double d = l.getDistanceFromPoint(p);
		Assert.assertEquals("distance", 1.3093073414159544, d, EPS);
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLLine3.getIntersectionWith(CMLPlane3)'
	 */
	@Test
	public void testGetIntersectionWith() {
		CMLPlane3 pl = new CMLPlane3(new CMLVector3(1., 2., 3.), 4.);
		CMLLine3 l = new CMLLine3(new CMLPoint3(4., 5., 6.), new CMLVector3(1.,
				2., 3.));
		CMLPoint3 pp = l.getIntersectionWith(pl);
		CMLPoint3Test.assertEquals("intersection", new double[] {
				2.7833306819354116, 2.5666613638708236, 2.349992045806235 },
				pp, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLLine3.copy()'
	 */
	@Test
	public void testCopy() {
		CMLLine3 l = (CMLLine3) ll.copy();
		CMLVector3 vv = new CMLVector3(1., 2., 3.);
		CMLLine3Test.assertEquals("copy point", new CMLPoint3(6., 5., 4.), vv
				.normalize(), l, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLLine3.CMLLine3(Line3)'
	 */
	@Test
	public void testCMLLine3Line3() {
		Line3 lll = new Line3(new Point3(1., 2., 3.), new Vector3(4., 5., 6.));
		CMLLine3 l = new CMLLine3(lll);
		CMLLine3Test.assertEquals("construct point", new CMLPoint3(1., 2., 3.),
				new CMLVector3(4., 5., 6.).normalize(), l, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLLine3.getEuclidLine3()'
	 */
	@Test
	public void testGetEuclidLine3() {
		Line3 l = ll.getEuclidLine3();
		Line3 expected=new Line3(new Point3(6., 5., 4.), new Vector3(1., 2., 3.).normalize());
		Assert.assertTrue(l.isEqualTo(expected));
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLLine3.setVector3(CMLVector3)'
	 */
	@Test
	public void testSetVector3CMLVector3() {
		double s = Math.sqrt(14.);
		DoubleTestBase.assertEquals("set vector", new double[] { 1. / s,
				2. / s, 3. / s }, ll.getVector3(), EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLLine3.isEqualTo(CMLLine3)'
	 */
	@Test
	public void testIsEqualTo() {

	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLLine3.isAntiparallelTo(CMLLine3)'
	 */
	@Test
	public void testIsAntiparallelTo() {

	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLLine3.getString()'
	 */
	@Test
	public void testGetString() {

	}

	/**
	 * setup.
	 * 
	 * @throws Exception
	 */
	@Before
	public synchronized void setUp() throws Exception {
	
		vv = new CMLVector3(1., 2., 3.);
		pp = new CMLPoint3(6., 5., 4.);
		ll = new CMLLine3(pp, vv);
		
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
