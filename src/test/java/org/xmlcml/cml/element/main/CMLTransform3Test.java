package org.xmlcml.cml.element.main;

import static org.xmlcml.euclid.EC.EPS;
import static org.xmlcml.euclid.EC.S_RBRAK;
import static org.xmlcml.euclid.test.EuclidTestBase.neverThrow;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import nu.xom.ParsingException;
import nu.xom.ValidityException;

import org.junit.Assert;
import org.junit.Test;
import org.xmlcml.cml.base.CMLBuilder;
import org.xmlcml.cml.base.CMLConstants;
import org.xmlcml.cml.element.CMLLine3;
import org.xmlcml.cml.element.CMLMatrix;
import org.xmlcml.cml.element.CMLPoint3;
import org.xmlcml.cml.element.CMLTransform3;
import org.xmlcml.cml.element.CMLVector3;
import org.xmlcml.euclid.Point3;
import org.xmlcml.euclid.Transform3;
import org.xmlcml.euclid.Transform3.Type;
import org.xmlcml.euclid.test.DoubleTestBase;
import org.xmlcml.euclid.test.Point3Test;
import org.xmlcml.euclid.test.Transform3Test;

/**
 * test CMLTransform3.
 * 
 * @author pmr
 * 
 */
public class CMLTransform3Test extends GeomTestBase {

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
		Assert.assertNotNull("test should not be null (" + msg + S_RBRAK, test);
		Assert.assertNotNull("expected should not be null (" + msg + S_RBRAK,
				expected);
		Transform3Test.assertEquals(msg, test.getEuclidTransform3(), expected
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
		Assert.assertNotNull("test should not be null (" + msg + S_RBRAK, test);
		Assert.assertEquals("must be of length 16", 16, test.length);
		Assert.assertNotNull("expected should not be null (" + msg + S_RBRAK,
				expected);
		Transform3Test.assertEquals(msg, test, expected.getEuclidTransform3(),
				epsilon);
	}

	private CMLBuilder builder = new CMLBuilder();

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLTransform3.CMLTransform3(CMLTransform3)'
	 */
	@Test
	public void testCMLTransform3CMLTransform3() {
		double[] d = new double[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,
				14, 15, 16 };
		CMLTransform3 t = new CMLTransform3(d);
		CMLTransform3 tt = new CMLTransform3(t);
		CMLTransform3Test.assertEquals("copy", d, tt, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLTransform3 parse'
	 */
	@Test
	public void testParse() {
		CMLTransform3 t = null;
		String s = "<transform3 " + CMLConstants.CML_XMLNS
				+ ">1 0 0 0 0 1 0 0 0 0 1 0 0 0 0 1</transform3>";
		try {
			t = (CMLTransform3) builder.build(new StringReader(s))
					.getRootElement();
			CMLTransform3Test
					.assertEquals("unit", CMLTransform3.UNIT44, t, EPS);
		} catch (ValidityException e) {
			Assert
					.fail("should not throw validity exception "
							+ e.getMessage());
		} catch (ParsingException e) {
			Assert.fail("should not throw parsing exception " + e.getMessage());
		} catch (IOException e) {
			Assert.fail("should not throw IO exception " + e.getMessage());
		}

		s = "<transform3 " + CMLConstants.CML_XMLNS
				+ ">1 0 0 0 0 1 0 0 0 0 1 0 0 0 1</transform3>";
		try {
			t = (CMLTransform3) builder.build(new StringReader(s))
					.getRootElement();
			Assert.fail("should not throw parsing exception");
		} catch (ValidityException e) {
			Assert.fail("should not throw validity " + e.getMessage());
		} catch (ParsingException e) {
			Assert.assertEquals("should throw parsing exception",
					"line must have 16 double components", e.getMessage());
		} catch (IOException e) {
			Assert.fail("should not throw IO " + e.getMessage());
		}

		s = "<transform3 " + CMLConstants.CML_XMLNS
				+ ">1 0 X 0 0 0 1 0 0 0 0 1 0 0 0 1</transform3>";
		try {
			t = (CMLTransform3) builder.build(new StringReader(s))
					.getRootElement();
			Assert.fail("should not throw parsing exception");
		} catch (ValidityException e) {
			Assert.fail("should not throw validity " + e.getMessage());
		} catch (ParsingException e) {
			Assert.assertTrue(true);
		} catch (IOException e) {
			Assert.fail("should not throw IO " + e.getMessage());
		}
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLTransform3.CMLTransform3(double[])'
	 */
	@Test
	public void testCMLTransform3DoubleArray() {
		double[] d = new double[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,
				14, 15, 16 };
		CMLTransform3 t = new CMLTransform3(d);
		CMLTransform3Test.assertEquals("copy", d, t, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLTransform3.CMLTransform3(int)'
	 */
	@Test
	public void testCMLTransform3Int() {
		/*
		 * -- NULL(1, "none"), ROT_ORIG(2, "rotation about origin"),
		 * ROT_TRANS(3, "rotation translation"), ROT_TRANS_SCALE(4,
		 * "rotation translation scale"), ROT_TRANS_AXIAL_SCALE(5,
		 * "rotation translation axial scale"), ROT_TRANS_SCALE_PERSP(6,
		 * "perspective"), ANY(7, "any"); --
		 */
		// this is probablyy not required
		CMLTransform3 t = new CMLTransform3(Type.NULL);
		CMLTransform3Test.assertEquals("type", CMLTransform3.UNIT44, t, EPS);
		t = new CMLTransform3(Type.ROT_ORIG);
		CMLTransform3Test.assertEquals("type", CMLTransform3.UNIT44, t, EPS);
		t = new CMLTransform3(Type.ROT_TRANS);
		CMLTransform3Test.assertEquals("type", CMLTransform3.UNIT44, t, EPS);
		t = new CMLTransform3(Type.ROT_TRANS_SCALE);
		CMLTransform3Test.assertEquals("type", CMLTransform3.UNIT44, t, EPS);
		t = new CMLTransform3(Type.ROT_TRANS_AXIAL_SCALE);
		CMLTransform3Test.assertEquals("type", CMLTransform3.UNIT44, t, EPS);
		t = new CMLTransform3(Type.ROT_TRANS_SCALE_PERSP);
		CMLTransform3Test.assertEquals("type", CMLTransform3.UNIT44, t, EPS);

	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLTransform3.CMLTransform3(CMLVector3)'
	 */
	@Test
	public void testCMLTransform3CMLVector3() {
		// Vector is translation
		CMLVector3 v = new CMLVector3(new double[] { 5, 6, 7 });
		CMLTransform3 t = new CMLTransform3(v);
		CMLTransform3Test.assertEquals("type", new double[] { 1, 0, 0, 5, 0, 1,
				0, 6, 0, 0, 1, 7, 0, 0, 0, 1 }, t, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLTransform3.CMLTransform3(int,
	 * double)'
	 */
	@Test
	public void testCMLTransform3IntDouble() {
		// rottaion about axes
		CMLTransform3 t = new CMLTransform3(1, Math.PI);
		CMLTransform3Test.assertEquals("type", new double[] { 1, 0, 0, 0, 0,
				-1, 0, 0, 0, 0, -1, 0, 0, 0, 0, 1 }, t, EPS);
		t = new CMLTransform3(1, Math.PI / 2);
		CMLTransform3Test.assertEquals("type", new double[] { 1, 0, 0, 0, 0, 0,
				1, 0, 0, -1, 0, 0, 0, 0, 0, 1 }, t, EPS);
		t = new CMLTransform3(2, Math.PI);
		CMLTransform3Test.assertEquals("type", new double[] { -1, 0, 0, 0, 0,
				1, 0, 0, 0, 0, -1, 0, 0, 0, 0, 1 }, t, EPS);
		t = new CMLTransform3(2, Math.PI / 2);
		CMLTransform3Test.assertEquals("type", new double[] { 0, 0, -1, 0, 0,
				1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1 }, t, EPS);
		t = new CMLTransform3(3, Math.PI);
		CMLTransform3Test.assertEquals("type", new double[] { -1, 0, 0, 0, 0,
				-1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1 }, t, EPS);
		t = new CMLTransform3(3, Math.PI / 2);
		CMLTransform3Test.assertEquals("type", new double[] { 0, 1, 0, 0, -1,
				0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1 }, t, EPS);
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLTransform3.CMLTransform3(double, double,
	 * double)'
	 */
	@Test
	public void testCMLTransform3DoubleDoubleDouble() {
		// rotation about axes
		CMLTransform3 t = new CMLTransform3(Math.PI, 0, 0);
		CMLTransform3Test.assertEquals("type", new double[] { 1, 0, 0, 0, 0,
				-1, 0, 0, 0, 0, -1, 0, 0, 0, 0, 1 }, t, EPS);

		// rotation about axes
		t = new CMLTransform3(Math.PI / 2, Math.PI / 2, 0);
		CMLTransform3Test.assertEquals("type", new double[] { 0, 1, 0, 0, 0, 0,
				1, 0, 1, 0, 0, 0, 0, 0, 0, 1 }, t, EPS);

		t = new CMLTransform3(0., 0., 0.);
		CMLTransform3Test.assertEquals("type", new double[] { 1, 0, 0, 0, 0, 1,
				0, 0, 0, 0, 1, 0, 0, 0, 0, 1 }, t, 10 * EPS);

		t = new CMLTransform3(0., 0., 0.);
		CMLTransform3Test.assertEquals("type", new double[] { 1, 0, 0, 0, 0, 1,
				0, 0, 0, 0, 1, 0, 0, 0, 0, 1 }, t, EPS);

		t = new CMLTransform3(Math.PI * 2, Math.PI * 2, Math.PI * 2);
		CMLTransform3Test.assertEquals("type", new double[] { 1, 0, 0, 0, 0, 1,
				0, 0, 0, 0, 1, 0, 0, 0, 0, 1 }, t, EPS);

	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLTransform3.CMLTransform3(CMLTransform3,
	 * CMLPoint3)'
	 */
	@Test
	public void testCMLTransform3CMLTransform3CMLPoint3() {
		CMLTransform3 t = new CMLTransform3("x, -y, -z");
		CMLPoint3 p = new CMLPoint3(1., 2., 3);
		CMLTransform3 tt = new CMLTransform3(t, p);
		CMLTransform3Test.assertEquals("transform", new double[] { 1.0, 0.0,
				0.0, 0.0, 0.0, -1.0, 0.0, 4.0, 0.0, 0.0, -1.0, 6.0, 0.0, 0.0,
				0.0, 1.0 }, tt, EPS);
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLTransform3.CMLTransform3(CMLVector3, double)'
	 */
	@Test
	public void testCMLTransform3CMLVector3Double() {
		double c = Math.cos(Math.PI / 3);
		double s = Math.sin(Math.PI / 3);

		// rotation about vector and angle
		CMLVector3 v = new CMLVector3(new double[] { 1., 1., 1. });
		CMLTransform3 t = new CMLTransform3(v, Math.PI * 2. / 3.);
		CMLTransform3Test.assertEquals("type", new double[] { 0, 0, 1, 0, 1, 0,
				0, 0, 0, 1, 0, 0, 0, 0, 0, 1 }, t, EPS);

		v = new CMLVector3(new double[] { 1., 1., 1. });
		t = new CMLTransform3(v, -Math.PI * 2. / 3.);
		CMLTransform3Test.assertEquals("type", new double[] { 0, 1, 0, 0, 0, 0,
				1, 0, 1, 0, 0, 0, 0, 0, 0, 1 }, t, EPS);

		v = new CMLVector3(new double[] { 1., 0., 0. });

		t = new CMLTransform3(v, Math.PI / 3.);
		CMLTransform3Test.assertEquals("type", new double[] { 1, 0, 0, 0, 0, c,
				-s, 0, 0, s, c, 0, 0, 0, 0, 1 }, t, EPS);
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLTransform3.CMLTransform3(CMLLine3, double)'
	 */
	@Test
	public void testCMLTransform3CMLLine3Double() {
		CMLLine3 l = new CMLLine3(new CMLPoint3(4., 5., 6.), new CMLVector3(1.,
				2., 3.));
		CMLTransform3 t = new CMLTransform3(l, Math.PI / 3.);
		CMLTransform3Test.assertEquals("transform", new double[] {
				0.5357142857142858, -0.6229365034008422, 0.5700529070291328,
				1.5515079319722704, 0.765793646257985, 0.642857142857143,
				-0.01716931065742361, -1.174444435373113, -0.3557671927434186,
				0.4457407392288521, 0.8214285714285715, 0.2657936462579853,
				0.0, 0.0, 0.0, 1.0 }, t, EPS);
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLTransform3.CMLTransform3(CMLVector3,
	 * CMLVector3)'
	 */
	@Test
	public void testCMLTransform3CMLVector3CMLVector3() {
		// rotate one vector onto another
		CMLTransform3 t = new CMLTransform3(new CMLVector3(1., 0., 0.),
				new CMLVector3(0., 1., 0.));
		CMLTransform3Test.assertEquals("transform", new double[] { 0., -1.0,
				0., 0., 1.0, 0.0, 0.0, 0., 0., 0., 1., 0., 0., 0., 0., 1.0 },
				t, EPS);
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLTransform3.CMLTransform3(CMLVector3,
	 * CMLVector3, CMLVector3)'
	 */
	@Test
	public void testCMLTransform3CMLVector3CMLVector3CMLVector3() {
		CMLVector3 v1, v2, v3;
		CMLTransform3 t;

		v1 = new CMLVector3(new double[] { 1., 2., 3. });
		v2 = new CMLVector3(new double[] { 4., 5., 6. });
		v3 = new CMLVector3(new double[] { 7., 8., 9. });
		t = new CMLTransform3(v1, v2, v3);
		CMLTransform3Test.assertEquals("type", new double[] { 1, 2, 3, 0, 4, 5,
				6, 0, 7, 8, 9, 0, 0, 0, 0, 1 }, t, EPS);

	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLTransform3.CMLTransform3(String)'
	 */
	@Test
	public void testCMLTransform3String() {
		CMLTransform3 t = null;
		String s;

		s = "x, y, z";
		try {
			t = new CMLTransform3(s);
		} catch (Exception e) {
			neverThrow(e);
		}
		CMLTransform3Test.assertEquals("type", new double[] { 1, 0, 0, 0, 0, 1,
				0, 0, 0, 0, 1, 0, 0, 0, 0, 1 }, t, EPS);

		s = "x, -y, -z";
		try {
			t = new CMLTransform3(s);
		} catch (Exception e) {
			neverThrow(e);
		}
		CMLTransform3Test.assertEquals("type", new double[] { 1, 0, 0, 0, 0,
				-1, 0, 0, 0, 0, -1, 0, 0, 0, 0, 1 }, t, EPS);

		s = "1/2+x, 1/2-y, 1/4-z";
		try {
			t = new CMLTransform3(s);
		} catch (Exception e) {
			neverThrow(e);
		}
		CMLTransform3Test.assertEquals("type", new double[] { 1, 0, 0, 0.5, 0,
				-1, 0, 0.5, 0, 0, -1, 0.25, 0, 0, 0, 1 }, t, EPS);

		s = "x+y, x-y, -z";
		try {
			t = new CMLTransform3(s);
		} catch (Exception e) {
			neverThrow(e);
		}
		CMLTransform3Test.assertEquals("type", new double[] { 1, 1, 0, 0, 1,
				-1, 0, 0, 0, 0, -1, 0, 0, 0, 0, 1 }, t, EPS);

		s = "y, -x, 7/12-z";
		try {
			t = new CMLTransform3(s);
		} catch (Exception e) {
			neverThrow(e);
		}
		CMLTransform3Test.assertEquals("type", new double[] { 0, 1, 0, 0, -1,
				0, 0, 0, 0, 0, -1, 7. / 12., 0, 0, 0, 1 }, t, EPS);
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLTransform3.equals(CMLTransform3)'
	 */
	@Test
	public void testEqualsCMLTransform3() {
		double[] d = new double[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,
				14, 15, 16 };
		CMLTransform3 t = new CMLTransform3(d);
		CMLTransform3Test.assertEquals("equals", d, t, EPS);
		CMLTransform3 t1 = new CMLTransform3(d);
		CMLTransform3Test.assertEquals("equals", t, t1, EPS);

	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLTransform3.concatenate(CMLTransform3)'
	 */
	@Test
	public void testConcatenate() {
		CMLTransform3 /* t, */t1, t2, t12;
		// rotation about axes
		t1 = new CMLTransform3(Math.PI / 2, 0, 0);
		CMLTransform3Test.assertEquals("type", new double[] { 1, 0, 0, 0, 0, 0,
				1, 0, 0, -1, 0, 0, 0, 0, 0, 1 }, t1, EPS);

		t2 = new CMLTransform3(0, Math.PI / 2, 0);
		CMLTransform3Test.assertEquals("type", new double[] { 0, 0, -1, 0, 0,
				1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1 }, t2, EPS);

		t12 = t1.concatenate(t2);
		CMLTransform3Test.assertEquals("type", new double[] { 0, 0, -1, 0, 1,
				0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 1 }, t12, EPS);

		t12 = t2.concatenate(t1);
		CMLTransform3Test.assertEquals("type", new double[] { 0, 1, 0, 0, 0, 0,
				1, 0, 1, 0, 0, 0, 0, 0, 0, 1 }, t12, EPS);

		// test translation components
		t1 = new CMLTransform3(new double[] { 1, 0, 0, 1, 0, 1, 0, 2, 0, 0, 1,
				3, 0, 0, 0, 1 });
		CMLTransform3Test.assertEquals("translate", new double[] { 1, 0, 0, 1,
				0, 1, 0, 2, 0, 0, 1, 3, 0, 0, 0, 1 }, t1, EPS);

		t2 = new CMLTransform3(new double[] { 1, 0, 0, 4, 0, 1, 0, 5, 0, 0, 1,
				6, 0, 0, 0, 1 });
		CMLTransform3Test.assertEquals("translate", new double[] { 1, 0, 0, 4,
				0, 1, 0, 5, 0, 0, 1, 6, 0, 0, 0, 1 }, t2, EPS);

		t12 = t1.concatenate(t2);
		CMLTransform3Test.assertEquals("type", new double[] { 1, 0, 0, 5, 0, 1,
				0, 7, 0, 0, 1, 9, 0, 0, 0, 1 }, t12, EPS);

	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLTransform3.getAxisAndAngle()'
	 */
	@Test
	public void testGetAxisAndAngle() {
		// rotation about vector and angle
		CMLVector3 v = new CMLVector3(new double[] { 1., 1., 1. });
		CMLTransform3 t = new CMLTransform3(v, Math.PI * 2. / 3.);
		CMLTransform3Test.assertEquals("type", new double[] { 0, 0, 1, 0, 1, 0,
				0, 0, 0, 1, 0, 0, 0, 0, 0, 1 }, t, EPS);

		double[] aa = t.getAxisAndAngle();
		double x = Math.sqrt(1. / 3.);
		DoubleTestBase.assertEquals("axis and angle", new double[] { x, x, x,
				Math.PI * 2. / 3. }, aa, EPS);

		v = new CMLVector3(new double[] { 1., 2., 3. });
		t = new CMLTransform3(v, 1.234);
		aa = t.getAxisAndAngle();
		double xx = 1. / Math.sqrt(14.);
		DoubleTestBase.assertEquals("axis and angle", new double[] { xx,
				2 * xx, 3 * xx, 1.234 }, aa, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLTransform3.getTranslation()'
	 */
	@Test
	public void testGetTranslation() {
		double[] d = new double[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 0,
				0, 0, 1 };
		CMLTransform3 t = new CMLTransform3(d);
		CMLVector3 tr = t.getTranslation();
		CMLVector3Test.assertEquals("equals", new double[] { 4, 8, 12 }, tr,
				EPS);

	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLTransform3.getCentreOfRotation()'
	 */
	@Test
	public void testGetCentreOfRotation() {

		String s;
		CMLTransform3 t = null;

		s = "-x+1/2, -y+1/2, z";
		t = new CMLTransform3(s);
		CMLTransform3Test.assertEquals("type", new double[] { -1, 0, 0, 0.5, 0,
				-1, 0, 0.5, 0, 0, 1, 0, 0, 0, 0, 1 }, t, EPS);
		CMLPoint3 p = t.getCentreOfRotation();
		// values not checked
		CMLPoint3Test.assertEquals("centre", new double[] { 0.5, 0.5, 0.0 }, p,
				EPS);

	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLTransform3.getScales()'
	 */
	@Test
	public void testGetScales() {
		double[] d = new double[] { 10, 0, 0, 4, 0, 20, 0, 8, 0, 0, 30, 12, 0,
				0, 0, 1 };
		CMLTransform3 t = new CMLTransform3(d);
		double[] sc = t.getScales();
		DoubleTestBase.assertEquals("equals", new double[] { 10, 20, 30 }, sc,
				EPS);

	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLTransform3.getMatrix()'
	 */
	@Test
	public void testGetMatrix() {
		double[] d = new double[] { 10, 0, 0, 4, 0, 20, 0, 8, 0, 0, 30, 12, 0,
				0, 0, 1 };
		CMLTransform3 t = new CMLTransform3(d);
		CMLMatrix matrix = t.getMatrix();
		Assert.assertEquals("matrix", 3, matrix.getRows());
		Assert.assertEquals("matrix", 4, matrix.getColumns());
		CMLMatrixTest.assertEquals("matrix", 3, 4, new double[] { 10, 0, 0, 4,
				0, 20, 0, 8, 0, 0, 30, 12 }, matrix, EPS);
	}

	/**
	 * tests CMLTransform3.normalizeCrystallographically()
	 * 
	 */

	@Test
	public void testNormalizeCrystallographically() {
		CMLTransform3 t = new CMLTransform3(new double[] { 1, 0, 0, 0.0, 0, 1,
				0, -0.25, 1, 0, 1, 1.0, 0, 0, 0, 1, });
		t.normalizeCrystallographically();
		CMLTransform3Test.assertEquals("normalize crystallographically",
				new double[] { 1, 0, 0, 0.0, 0, 1, 0, 0.75, 1, 0, 1, 0.0, 0, 0,
						0, 1, }, t, EPS);
	}

	/**
	 * tests CMLTransform3.indexOf(List<CMLTransform3> trList, CMLTransform3 tr,
	 * double eps)
	 * 
	 */
	@Test
	public void testIndexOfListCMLTransform3CMLTransform3double() {
		List<CMLTransform3> trList = new ArrayList<CMLTransform3>();
		CMLTransform3 tr1 = new CMLTransform3(new double[] { 1, 0, 0, 0, 0, 1,
				0, 1, 0, 0, 1, -1, 0, 0, 0, 1 });
		trList.add(tr1);
		CMLTransform3 tr2 = new CMLTransform3(new double[] { 0, 0, 1, 0, 0, 1,
				0, -1, 1, 0, 0, 1, 0, 0, 0, 1 });
		trList.add(tr2);
		CMLTransform3 tr3 = new CMLTransform3(new double[] { 0, 1, 1, 0.5, 1,
				0, 0, -1, 0, 0, 1, 1, 0, 0, 0, 1 });
		int idx = CMLTransform3.indexOf(trList, tr1, EPS);
		Assert.assertEquals("indexOf", 0, idx);
		idx = CMLTransform3.indexOf(trList, tr2, EPS);
		Assert.assertEquals("indexOf", 1, idx);
		idx = CMLTransform3.indexOf(trList, tr3, EPS);
		Assert.assertEquals("indexOf", -1, idx);
		trList.add(tr3);
		idx = CMLTransform3.indexOf(trList, tr3, EPS);
		Assert.assertEquals("indexOf", 2, idx);
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLTransform3.getEuclidTransform3()'
	 */
	@Test
	public void testGetEuclidTransform3() {
		CMLTransform3 t = null;
		try {
			t = new CMLTransform3("x, -y, 1/2+z");
		} catch (Exception e) {
			neverThrow(e);
		}
		Transform3 tt = t.getEuclidTransform3();
		Transform3Test.assertEquals("get euclid", new double[] { 1., 0., 0.,
				0., 0., -1., 0., 0., 0., 0., 1., 0.5, 0., 0., 0., 1., }, tt,
				EPS);
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLTransform3.setMatrix(double[])'
	 */
	@Test
	public void testSetMatrix() {
		CMLTransform3 t = null;
		try {
			t = new CMLTransform3(CMLTransform3.UNIT44);
			t.setMatrix(new double[] { 1., 0., 0., 0., 0., -1., 0., 0., 0., 0.,
					1., 0.5, 0., 0., 0., 1., });
		} catch (Exception e) {
			neverThrow(e);
		}
		Transform3 tt = t.getEuclidTransform3();
		Transform3Test.assertEquals("get euclid", new double[] { 1., 0., 0.,
				0., 0., -1., 0., 0., 0., 0., 1., 0.5, 0., 0., 0., 1., }, tt,
				EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLTransform3.getMatrixAsArray()'
	 */
	@Test
	public void testGetMatrixAsArray() {
		CMLTransform3 t = null;
		try {
			t = new CMLTransform3(CMLTransform3.UNIT44);
			t.setMatrix(new double[] { 1., 0., 0., 0., 0., -1., 0., 0., 0., 0.,
					1., 0.5, 0., 0., 0., 1., });
		} catch (Exception e) {
			neverThrow(e);
		}
		CMLTransform3Test
				.assertEquals("get euclid", new double[] { 1., 0., 0., 0., 0.,
						-1., 0., 0., 0., 0., 1., 0.5, 0., 0., 0., 1., }, t, EPS);
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLTransform3.isEqualTo(CMLTransform3)'
	 */
	@Test
	public void testIsEqualToCMLTransform3() {
		CMLTransform3 t0 = null;
		CMLTransform3 t1 = null;
		try {
			t0 = new CMLTransform3(CMLTransform3.UNIT44);
			t1 = new CMLTransform3(CMLTransform3.UNIT44);
			t0.setMatrix(new double[] { 1., 0., 0., 0., 0., -1., 0., 0., 0.,
					0., 1., 0.5, 0., 0., 0., 1., });
		} catch (Exception e) {
			neverThrow(e);
		}
		Assert.assertFalse("equals", t0.isEqualTo(t1));
		try {
			t1.setMatrix(new double[] { 1., 0., 0., 0., 0., -1., 0., 0., 0.,
					0., 1., 0.5, 0., 0., 0., 1., });
		} catch (Exception e) {
			neverThrow(e);
		}
		Assert.assertTrue("equals", t0.isEqualTo(t1));
		try {
			t1.setMatrix(new double[] { 1., 0., 0., 0.0001, 0., -1., 0., 0.,
					0., 0., 1., 0.5, 0., 0., 0., 1., });
		} catch (Exception e) {
			neverThrow(e);
		}
		Assert.assertFalse("equals", t0.isEqualTo(t1));
		Assert.assertTrue("equals", t0.isEqualTo(t1, 0.001));
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLTransform3.hasNonZeroTranslationComponent()'
	 */
	@Test
	public void testHasNonZeroTranslationComponent() {
		CMLTransform3 t = null;
		try {
			t = new CMLTransform3("x, -y, 1/2+z");
		} catch (Exception e) {
			neverThrow(e);
		}
		Assert.assertTrue("non-zero translation", t
				.hasNonZeroTranslationComponent());
		try {
			t = new CMLTransform3("x, 1/2-y, 1/2+z");
		} catch (Exception e) {
			neverThrow(e);
		}
		Assert.assertTrue("non-zero translation", t
				.hasNonZeroTranslationComponent());
		try {
			t = new CMLTransform3("x, y, z");
		} catch (Exception e) {
			neverThrow(e);
		}
		Assert.assertFalse("non-zero translation", t
				.hasNonZeroTranslationComponent());
		try {
			t = new CMLTransform3("x, -y, z");
		} catch (Exception e) {
			neverThrow(e);
		}
		Assert.assertFalse("non-zero translation", t
				.hasNonZeroTranslationComponent());
		try {
			t = new CMLTransform3("x, -y, 1/2-z");
		} catch (Exception e) {
			neverThrow(e);
		}
		Assert.assertFalse("non-zero translation", t
				.hasNonZeroTranslationComponent());
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLTransform3.isPureTranslation()'
	 */
	@Test
	public void testIsPureTranslation() {
		CMLTransform3 t = null;
		try {
			t = new CMLTransform3("1/2+x, y, z");
		} catch (Exception e) {
			neverThrow(e);
		}
		Assert.assertTrue("pure translation", t.isPureTranslation());
		try {
			t = new CMLTransform3("1/2+x, 1/2+y, z");
		} catch (Exception e) {
			neverThrow(e);
		}
		Assert.assertTrue("pure translation", t.isPureTranslation());
		try {
			t = new CMLTransform3("1/2+x, 1/2+y, 1/2+z");
		} catch (Exception e) {
			neverThrow(e);
		}
		Assert.assertTrue("pure translation", t.isPureTranslation());
		try {
			t = new CMLTransform3("x, y, z");
		} catch (Exception e) {
			neverThrow(e);
		}
		Assert.assertFalse("pure translation", t.isPureTranslation());
		try {
			t = new CMLTransform3("1/2+x, 1/2+y, 1/2-z");
		} catch (Exception e) {
			neverThrow(e);
		}
		Assert.assertFalse("pure translation", t.isPureTranslation());
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLTransform3.isUnit()'
	 */
	@Test
	public void testIsUnit() {
		CMLTransform3 t = null;
		try {
			t = new CMLTransform3("x, y, z");
		} catch (Exception e) {
			neverThrow(e);
		}
		Assert.assertTrue("is unit", t.isUnit());
		try {
			t = new CMLTransform3("x, y, -z");
		} catch (Exception e) {
			neverThrow(e);
		}
		Assert.assertFalse("is unit", t.isUnit());
		try {
			t = new CMLTransform3("1/2+x, y, z");
		} catch (Exception e) {
			neverThrow(e);
		}
		Assert.assertFalse("is unit", t.isUnit());
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLTransform3.getRow(int)'
	 */
	@Test
	public void testGetRow() {
		CMLTransform3 t = null;
		try {
			t = new CMLTransform3("1/2+x-y, 1/4+y-z, -x");
		} catch (Exception e) {
			neverThrow(e);
		}
		double[] r = t.getRow(0);
		DoubleTestBase.assertEquals("row 0", new double[] { 1., -1., 0., 0.5 },
				r, EPS);
		r = t.getRow(1);
		DoubleTestBase.assertEquals("row 1",
				new double[] { 0., 1., -1., 0.25 }, r, EPS);
		r = t.getRow(2);
		DoubleTestBase.assertEquals("row 2", new double[] { -1., 0., 0., 0. },
				r, EPS);
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLTransform3.indexOf(List<CMLTransform3>,
	 * CMLTransform3, double)'
	 */
	@Test
	public void testIndexOfListOfCMLTransform3CMLTransform3Double() {
		List<CMLTransform3> tList = new ArrayList<CMLTransform3>();
		try {
			tList.add(new CMLTransform3("1/2+x-y, 1/4+y-z, -x"));
			tList.add(new CMLTransform3("x, y, z"));
			tList.add(new CMLTransform3("x, -y, 1/2+z"));
		} catch (Exception e) {
			neverThrow(e);
		}
		try {
			Assert.assertEquals("index ", 1, CMLTransform3.indexOf(tList,
					new CMLTransform3("x, y, z"), EPS));
			Assert.assertEquals("index ", 0, CMLTransform3.indexOf(tList,
					new CMLTransform3("1/2+x-y, 1/4+y-z, -x"), EPS));
			Assert.assertEquals("index ", -1, CMLTransform3.indexOf(tList,
					new CMLTransform3("1/2+x, 1/4+y-z, -x"), EPS));
		} catch (Exception e) {
			neverThrow(e);
		}
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLTransform3.transform(Point3)'
	 */
	@Test
	public void testTransform() {
		CMLTransform3 t = null;
		try {
			t = new CMLTransform3("-x, 1/2+y, 1/4+z");
		} catch (Exception e) {
			neverThrow(e);
		}
		Point3 p = t.transform(new Point3(0.1, 0.2, 0.3));
		Point3Test.assertEquals("transform", new double[] { -0.1, 0.7, 0.55 },
				p, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLTransform3.copy()'
	 */
	@Test
	public void testCopy() {
		CMLTransform3 t = new CMLTransform3("x, y-x, 1/2+z");
		CMLTransform3 tt = (CMLTransform3) t.copy();
		Assert.assertNotNull("copy not null", tt);
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLTransform3.isEqualTo(CMLTransform3, double)'
	 */
	@Test
	public void testIsEqualToCMLTransform3Double() {
		CMLTransform3 t = new CMLTransform3("x, y-x, 1/2+z");
		CMLTransform3 tt = (CMLTransform3) t.copy();
		Assert.assertTrue("isEquals", t.isEqualTo(tt, EPS));
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLTransform3.getString()'
	 */
	@Test
	public void testGetString() {
		CMLTransform3 t = new CMLTransform3("x, y-x, 1/2+z");
		String s = t.getString();
		String ss = "{4,4}\n" + "(1.0,0.0,0.0,0.0)\n" + "(-1.0,1.0,0.0,0.0)\n"
				+ "(0.0,0.0,1.0,0.5)\n" + "(0.0,0.0,0.0,1.0)";
		Assert.assertEquals("string", ss, s);
	}

}
