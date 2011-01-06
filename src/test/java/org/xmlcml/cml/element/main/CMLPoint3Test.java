package org.xmlcml.cml.element.main;

import static org.xmlcml.euclid.EuclidConstants.EPS;
import static org.xmlcml.euclid.EuclidConstants.S_RBRAK;

import java.io.IOException;
import java.io.StringReader;

import nu.xom.ParsingException;
import nu.xom.ValidityException;

import org.junit.Assert;
import org.junit.Test;
import org.xmlcml.cml.base.CMLBuilder;
import org.xmlcml.cml.base.CMLConstants;
import org.xmlcml.cml.element.CMLLine3;
import org.xmlcml.cml.element.CMLPlane3;
import org.xmlcml.cml.element.CMLPoint3;
import org.xmlcml.cml.element.CMLTransform3;
import org.xmlcml.cml.element.CMLVector3;
import org.xmlcml.euclid.Angle;
import org.xmlcml.euclid.Point3;
import org.xmlcml.euclid.test.DoubleTestBase;

/**
 * test CMLPoint3
 * 
 * @author pmr
 * 
 */
public class CMLPoint3Test extends GeomTestBase {

	CMLBuilder builder = new CMLBuilder();

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
		Assert.assertNotNull("test should not be null (" + msg + S_RBRAK, test);
		Assert.assertNotNull("expected should not be null (" + msg + S_RBRAK,
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
			CMLPoint3 expected, double epsilon) {
		Assert.assertNotNull("test should not be null (" + msg + S_RBRAK, test);
		Assert.assertEquals("must be of length 3", 3, test.length);
		Assert.assertNotNull("expected should not be null (" + msg + S_RBRAK,
				expected);
		DoubleTestBase.assertEquals(msg, test, expected.getXYZ3(), epsilon);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLPoint3 parse'
	 */
	@Test
	public void testParse() {
		String xml1S = "<point3 " + CMLConstants.CML_XMLNS + "/>";
		String xml2S = "<point3 " + CMLConstants.CML_XMLNS + ">1 2</point3>";
		String xml3S = "<point3 " + CMLConstants.CML_XMLNS + ">1 2 x</point3>";
		String xml4S = "<point3 " + CMLConstants.CML_XMLNS + ">1 2 3 4</point3>";
		String xml5S = "<point3 " + CMLConstants.CML_XMLNS + ">1  2  3</point3>";

		try {
			builder.build(new StringReader(xml1S)).getRootElement();
			Assert.fail("should throw content failure");
		} catch (ValidityException e) {
			Assert
					.fail("should not throw validity exception "
							+ e.getMessage());
		} catch (ParsingException e) {
			Assert.assertEquals("parse exception ", "point must not be empty",
					e.getMessage());
		} catch (IOException e) {
			Assert.fail("should not throw IO exception " + e.getMessage());
		} catch (RuntimeException e) {
			Assert.fail("should not throw CMLRuntime exception "
					+ e.getMessage());
		}

		try {
			builder.build(new StringReader(xml2S)).getRootElement();
			Assert.fail("should throw content failure");
		} catch (ValidityException e) {
			Assert
					.fail("should not throw validity exception "
							+ e.getMessage());
		} catch (ParsingException e) {
			Assert.assertEquals("parse exception ",
					"point must have 3 double components", e.getMessage());
		} catch (IOException e) {
			Assert.fail("should not throw IO exception " + e.getMessage());
		} catch (RuntimeException e) {
			Assert.fail("should not throw CMLRuntime exception "
					+ e.getMessage());
		}

		try {
			builder.build(new StringReader(xml3S)).getRootElement();
			Assert.fail("should throw content failure");
		} catch (ValidityException e) {
			Assert
					.fail("should not throw validity exception "
							+ e.getMessage());
		} catch (ParsingException e) {
			Assert.assertTrue(true);
		} catch (IOException e) {
			Assert.fail("should not throw IO exception " + e.getMessage());
		} catch (RuntimeException e) {
			Assert.fail("should not throw CMLRuntime exception "
					+ e.getMessage());
		}

		try {
			builder.build(new StringReader(xml4S)).getRootElement();
			Assert.fail("should throw content failure");
		} catch (ValidityException e) {
			Assert
					.fail("should not throw validity exception "
							+ e.getMessage());
		} catch (ParsingException e) {
			Assert.assertEquals("parse exception ",
					"point must have 3 double components", e.getMessage());
		} catch (IOException e) {
			Assert.fail("should not throw IO exception " + e.getMessage());
		} catch (RuntimeException e) {
			Assert.fail("should not throw CMLRuntime exception "
					+ e.getMessage());
		}

		try {
			builder.build(new StringReader(xml5S)).getRootElement();
		} catch (ValidityException e) {
			Assert
					.fail("should not throw validity exception "
							+ e.getMessage());
		} catch (ParsingException e) {
			Assert.assertEquals("parse exception ",
					"java.lang.NumberFormatException: empty String", e
							.getMessage());
		} catch (IOException e) {
			Assert.fail("should not throw IO exception " + e.getMessage());
		} catch (RuntimeException e) {
			Assert.fail("should not throw CMLRuntime exception "
					+ e.getMessage());
		}
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLPoint3.CMLPoint3(CMLPoint3)'
	 */
	@Test
	public void testCMLPoint3CMLPoint3() {
		CMLPoint3 p = new CMLPoint3(xomP111);
		CMLPoint3Test.assertEquals("copy", new double[] { 1., 1., 1. }, p, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLPoint3.CMLPoint3(double[])'
	 */
	@Test
	public void testCMLPoint3DoubleArray() {
		CMLPoint3 p = new CMLPoint3(new double[] { 1., 2., 3. });
		CMLPoint3Test.assertEquals("copy", new double[] { 1., 2., 3. }, p, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLPoint3.setXYZ3(double[])'
	 */
	@Test
	public void testSetXYZ3() {
		xomP111.setXYZ3(new double[] { 3., 2., 1. });
		CMLPoint3Test.assertEquals("setXYZ3", new double[] { 3., 2., 1. },
				xomP111, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLPoint3.getXYZ3()'
	 */
	@Test
	public void testGetXYZ3() {
		CMLPoint3Test.assertEquals("setXYZ3", new double[] { 1., 1., 1. },
				xomP111, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLPoint3.equals(CMLPoint3)'
	 */
	@Test
	public void testEqualsCMLPoint3() {
		CMLPoint3 pp = new CMLPoint3(xomP111);
		Assert.assertTrue("equals", pp.isEqualTo(xomP111));
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLPoint3.equalsCrystallographically(CMLPoint3)'
	 */
	@Test
	public void testEqualsCrystallographically() {
		CMLPoint3 pp = new CMLPoint3(new double[] { 0., 1., 2. });
		Assert.assertTrue("equals", pp.equalsCrystallographically(xomP111));
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLPoint3.isInvariant(CMLTransform3, boolean)'
	 */
	@Test
	public void testIsInvariant() {
		CMLPoint3 p = new CMLPoint3(new double[] { 1., 0., 3. });
		CMLTransform3 yMirror = new CMLTransform3(new double[] { 1., 0., 0.,
				0., 0., -1., 0., 0., 0., 0., 1., 0., 1., 0., 0., 1. });
		Assert.assertTrue("y mirror", p.isInvariant(yMirror, false));
		CMLTransform3 xMirror = new CMLTransform3(new double[] { -1., 0., 0.,
				0., 0., 1., 0., 0., 0., 0., 1., 0., 1., 0., 0., 1. });
		Assert.assertFalse("x mirror", p.isInvariant(xMirror, false));

	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLPoint3.subtract(CMLPoint3)'
	 */
	@Test
	public void testSubtractCMLPoint3() {
		CMLVector3 v = xomP111.subtract(xomP100);
		CMLVector3Test.assertEquals("subtract", new double[] { 0., 1., 1. }, v,
				EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLPoint3.plus(CMLPoint3)'
	 */
	@Test
	public void testPlusCMLPoint3() {
		CMLPoint3 v = xomP111.plus(xomP100);
		CMLPoint3Test.assertEquals("subtract", new double[] { 2., 1., 1. }, v,
				EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLPoint3.plusEquals(CMLPoint3)'
	 */
	@Test
	public void testPlusEqualsCMLPoint3() {
		xomP111.plusEquals(xomP100);
		CMLPoint3Test.assertEquals("subtract", new double[] { 2., 1., 1. },
				xomP111, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLPoint3.plus(CMLVector3)'
	 */
	@Test
	public void testPlusCMLVector3() {
		CMLPoint3 v = xomP111.plus(xomV111);
		CMLPoint3Test.assertEquals("plus", new double[] { 2., 2., 2. }, v, EPS);
		CMLVector3Test.assertEquals("plus", new double[] { 1., 1., 1. },
				xomV111, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLPoint3.plusEquals(CMLVector3)'
	 */
	@Test
	public void testPlusEqualsCMLVector3() {
		xomP111.plusEquals(xomV123);
		CMLPoint3Test.assertEquals("plusequals", new double[] { 2., 3., 4. },
				xomP111, EPS);
		CMLVector3Test.assertEquals("plusequals", new double[] { 1., 2., 3. },
				xomV123, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLPoint3.subtract(CMLVector3)'
	 */
	@Test
	public void testSubtractCMLVector3() {
		CMLPoint3 v = xomP111.subtract(xomV123);
		CMLPoint3Test.assertEquals("subtract", new double[] { 0., -1., -2. },
				v, EPS);
		CMLVector3Test.assertEquals("subtract", new double[] { 1., 2., 3. },
				xomV123, EPS);
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLPoint3.subtractEquals(CMLPoint3)'
	 */
	@Test
	public void testSubtractEqualsCMLPoint3() {
		xomP111.subtractEquals(this.xomP010);
		CMLPoint3Test.assertEquals("subtractequals",
				new double[] { 1., 0., 1. }, xomP111, EPS);
		CMLPoint3Test.assertEquals("subtractequals",
				new double[] { 0., 1., 0. }, xomP010, EPS);
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLPoint3.subtractEquals(CMLVector3)'
	 */
	@Test
	public void testSubtractEqualsCMLVector3() {
		xomP111.subtractEquals(xomV123);
		CMLPoint3Test.assertEquals("subtractequals", new double[] { 0., -1.,
				-2. }, xomP111, EPS);
		CMLVector3Test.assertEquals("subtractequals",
				new double[] { 1., 2., 3. }, xomV123, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLPoint3.multiplyBy(double)'
	 */
	@Test
	public void testMultiplyBy() {
		CMLPoint3 p = xomP111.multiplyBy(2.0);
		CMLPoint3Test.assertEquals("multiplyBy", new double[] { 1., 1., 1. },
				xomP111, EPS);
		CMLPoint3Test.assertEquals("multiplyBy", new double[] { 2., 2., 2. },
				p, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLPoint3.multiplyEquals(double)'
	 */
	@Test
	public void testMultiplyEquals() {
		xomP111.multiplyEquals(2.0);
		CMLPoint3Test.assertEquals("multiplyEquals",
				new double[] { 2., 2., 2. }, xomP111, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLPoint3.divideBy(double)'
	 */
	@Test
	public void testDivideBy() {
		CMLPoint3 p = xomP111.divideBy(2.0);
		CMLPoint3Test.assertEquals("divideBy", new double[] { 1., 1., 1. },
				xomP111, EPS);
		CMLPoint3Test.assertEquals("divideBy", new double[] { 0.5, 0.5, 0.5 },
				p, EPS);
		p = xomP100.divideBy(0.0);
		CMLPoint3Test.assertEquals("divideBy", new double[] { 1., 1., 1. },
				xomP111, EPS);
		Assert
				.assertTrue("divideBy", Double.isInfinite(p.getXYZ3()[0])
						&& Double.isNaN(p.getXYZ3()[1])
						&& Double.isNaN(p.getXYZ3()[2]));
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLPoint3.elementAt(int)'
	 */
	@Test
	public void testElementAt() {
		Assert.assertEquals("elementAt", 1., xomP123.elementAt(0), EPS);
		Assert.assertEquals("elementAt", 2., xomP123.elementAt(1), EPS);
		Assert.assertEquals("elementAt", 3., xomP123.elementAt(2), EPS);
		try {
			xomP123.elementAt(3);
			Assert.fail("should always throw " + "index out of range");
		} catch (RuntimeException e) {
			Assert
					.assertEquals(
							"element at",
							"org.xmlcml.euclid.EuclidRuntimeException: index (3)out of range: 0/2",
							e.getMessage());
		}
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLPoint3.setElementAt(int,
	 * double)'
	 */
	@Test
	public void testSetElementAt() {
		CMLPoint3Test.assertEquals("setElement", new double[] { 1., 2., 3. },
				xomP123, EPS);
		xomP123.setElementAt(0, 11.);
		xomP123.setElementAt(1, 12.);
		xomP123.setElementAt(2, 13.);
		CMLPoint3Test.assertEquals("setElement",
				new double[] { 11., 12., 13. }, xomP123, EPS);
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLPoint3.transform(CMLTransform3)'
	 */
	@Test
	public void testTransform() {
		makeXomT1();
		CMLPoint3 p = xomP123.transform(xomT1);
		CMLPoint3Test.assertEquals("transform", new double[] { 2., 3., -1. },
				p, EPS);
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLPoint3.getDistanceFromOrigin()'
	 */
	@Test
	public void testGetDistanceFromOrigin() {
		Assert.assertEquals("origin", Math.sqrt(14.), xomP123
				.getDistanceFromOrigin(), EPS);
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLPoint3.getSquaredDistanceFromPoint(CMLPoint3)'
	 */
	@Test
	public void testGetSquaredDistanceFromPoint() {
		Assert.assertEquals("origin", 5., xomP123
				.getSquaredDistanceFromPoint(xomP111), EPS);
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLPoint3.getDistanceFromPoint(CMLPoint3)'
	 */
	@Test
	public void testGetDistanceFromPoint() {
		Assert.assertEquals("point2point", 3., xomP123
				.getDistanceFromPoint(xomP001), EPS);
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLPoint3.distanceFromPlane(CMLPlane3)'
	 */
	@Test
	public void testDistanceFromPlane() {
		Assert.assertEquals("point2plane", -1., xomP123
				.distanceFromPlane(xomPl1002), EPS);
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLPoint3.getClosestPointOnLine(CMLLine3)'
	 */
	@Test
	public void testGetClosestPointOnLine() {
		// FIXME
		// CMLPoint3 pp = xomP123.getClosestPointOnLine(this.xomL220011);
		// Assert.assertEquals("closestpoint", new double[] {8., 9., 1.},
		// pp.getXMLContent(), EPS);
		// double d = pp.distanceFromLine(xomL220011);
		// Assert.assertEquals("closestpoint check", 1.2, d, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLPoint3.isOnLine(CMLLine3)'
	 */
	@Test
	public void testIsOnLine() {
		double[] p = { 0., 0., 0. };
		CMLPoint3 pp = new CMLPoint3(p);
		double[] v = { 2., 0., 0. };
		CMLVector3 vv = new CMLVector3(v);
		CMLLine3 ll = new CMLLine3(pp, vv);
		double d = pp.distanceFromLine(ll);
		Assert.assertTrue("is on line", pp.isOnLine(ll));
		d = d * 2; // to avoid not use warning
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLPoint3.isOnPlane(CMLPlane3)'
	 */
	@Test
	public void testIsOnPlane() {
		double xx = Math.sqrt(1. / 3.);
		CMLPlane3 pl = new CMLPlane3(new double[] { 1., 1., 1., xx });
		Assert.assertTrue("on plane", xomP100.isOnPlane(pl));
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLPoint3.distanceFromLine(CMLLine3)'
	 */
	@Test
	public void testDistanceFromLine() {
		// FIXME
		double[] p = { 0., 0., 0. };
		CMLPoint3 pp = new CMLPoint3(p);
		double[] l = { 2., 0., 0. };
		CMLVector3 vv = new CMLVector3(l);
		CMLLine3 ll = new CMLLine3(pp, vv);
		double d;
		d = pp.distanceFromLine(ll);
		// FIXME must change distanceFrom
		// Assert.assertEquals("distance from line", 0., d, EPS);

		p = new double[] { 1., 2., 3. };
		pp = new CMLPoint3(p);
		l = new double[] { 10., 0., 0. };
		vv = new CMLVector3(l);
		ll = new CMLLine3(pp, vv);
		d = pp.distanceFromLine(ll);
		d += 0.0;
		// FIXME
		// Assert.assertEquals("distance from line", 0., d, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLPoint3.getMidPoint(CMLPoint3)'
	 */
	@Test
	public void testGetMidPoint() {
		CMLPoint3 p = this.xomP001.getMidPoint(this.xomP010);
		CMLPoint3Test.assertEquals("midpoint", new double[] { 0., 0.5, 0.5 },
				p, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLPoint3.getAngle(CMLPoint3,
	 * CMLPoint3)'
	 */
	@Test
	public void testGetAngle() {
		Angle angle = xomP100.getAngle(xomP010, xomP001);
		Assert.assertNotNull("angle", angle);
		Assert.assertEquals("angle", Math.PI / 3., angle.getRadian(), EPS);
		angle = xomP100.getAngle(xomP010, xomP010);
		Assert.assertNull("angle coincident atoms", angle);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLPoint3.getTorsion(CMLPoint3,
	 * CMLPoint3, CMLPoint3)'
	 */
	@Test
	public void testGetTorsion() {
		double a = Double.NaN;
		CMLPoint3 p000 = new CMLPoint3(new double[] { 0., 0., 0. });
		a = xomP100.getTorsion(p000, xomP010, xomP001);
		Assert.assertEquals("angle", -Math.PI / 2., a, EPS);
		try {
			a = xomP100.getTorsion(p000, xomP010, xomP010);
		} catch (Throwable e) {
			Assert.assertEquals("getAngle",
					"cannot normalize zero-length vector", e.getMessage());
		}

	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLPoint3.calculateFromInternalCoordinates(CMLPoi
	 * n t 3 , CMLPoint3, double, double, double)'
	 */
	@Test
	public void testCalculateFromInternalCoordinates() {
		CMLPoint3 p1 = new CMLPoint3(new double[] { -1, 1, 0 });
		CMLPoint3 p2 = new CMLPoint3(new double[] { -1, 0, 0 });
		CMLPoint3 p3 = new CMLPoint3(new double[] { 0, 0, 0 });
		CMLPoint3 p4 = p1.calculateFromInternalCoordinates(p2, p3, 1.0,
				Math.PI * 2 / 3., 1.);
		CMLPoint3Test.assertEquals("internals", new double[] { 0.5,
				Math.sin(Math.PI * 2. / 3.) * Math.cos(1.),
				Math.sin(Math.PI * 2. / 3.) * Math.sin(1.) }, p4, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLPoint3.isOrigin()'
	 */
	@Test
	public void testIsOrigin() {
		CMLPoint3 p000 = new CMLPoint3(new double[] { 0., 0., 0. });
		Assert.assertTrue("origin", p000.isOrigin());
		Assert.assertFalse("origin", xomP100.isOrigin());
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLPoint3.copy()'
	 */
	@Test
	public void testCopy() {
		CMLPoint3 p = new CMLPoint3(1., 2., 3.);
		CMLPoint3 pp = (CMLPoint3) p.copy();
		CMLPoint3Test.assertEquals("copy", p, pp, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLPoint3.CMLPoint3(Point3)'
	 */
	@Test
	public void testCMLPoint3Point3() {
		CMLPoint3 p = new CMLPoint3(new Point3(1., 2., 3.));
		CMLPoint3Test.assertEquals("copy", new double[] { 1., 2., 3. }, p, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLPoint3.CMLPoint3(double,
	 * double, double)'
	 */
	@Test
	public void testCMLPoint3DoubleDoubleDouble() {
		CMLPoint3 p = new CMLPoint3(1., 2., 3.);
		CMLPoint3Test.assertEquals("copy", new double[] { 1., 2., 3. }, p, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLPoint3.getEuclidPoint3()'
	 */
	@Test
	public void testGetEuclidPoint3() {
		CMLPoint3 p = new CMLPoint3(new Point3(1., 2., 3.));
		Point3 pp = p.getEuclidPoint3();
		CMLPoint3Test.assertEquals("copy", pp.getArray(), p, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLPoint3.isEqualTo(CMLPoint3)'
	 */
	@Test
	public void testIsEqualToCMLPoint3() {
		CMLPoint3 p = new CMLPoint3(1., 2., 3.);
		CMLPoint3 pp = (CMLPoint3) p.copy();
		Assert.assertTrue("isEqual", p.isEqualTo(pp));
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLPoint3.isEqualTo(CMLPoint3,
	 * double)'
	 */
	@Test
	public void testIsEqualToCMLPoint3Double() {
		CMLPoint3 p = new CMLPoint3(1., 2., 3.);
		CMLPoint3 pp = (CMLPoint3) p.copy();
		Assert.assertTrue("isEqual", p.isEqualTo(pp, EPS));
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLPoint3.getString()'
	 */
	@Test
	public void testGetString() {
		CMLPoint3 p = new CMLPoint3(1., 2., 3.);
		Assert.assertEquals("string", "(1.0, 2.0, 3.0)", p.getString());
	}

}
