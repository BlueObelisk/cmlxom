package org.xmlcml.cml.element.main;

import static org.xmlcml.euclid.EC.EPS;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.xmlcml.cml.base.CMLConstants;
import org.xmlcml.cml.base.CMLElements;
import org.xmlcml.cml.element.CMLCrystal;
import org.xmlcml.cml.element.CMLMatrix;
import org.xmlcml.cml.element.CMLSymmetry;
import org.xmlcml.cml.element.CMLTransform3;
import org.xmlcml.euclid.Point3;

/**
 * tests CMLSymmetry.
 * 
 * @author pmr
 * 
 */
public class CMLSymmetryTest {
	// space group (Pbca) but not finite group
	static String[] pbca = { "x, y, z", "-x+1/2, -y, z+1/2",
			"x+1/2, -y+1/2, -z", "-x, y+1/2, -z+1/2", "-x, -y, -z",
			"x-1/2, y, -z-1/2", "-x-1/2, y-1/2, z", "x, -y-1/2, z-1/2", };
	// finite group (mmm = d2h)
	static String[] pmmm = { "x, y, z", "-x, -y, z", "x, -y, -z", "-x, y, -z",
			"-x, -y, -z", "x, y, -z", "-x, y, z", "x, -y, z", };
	// incomplete group (only 7 elements)
	static String[] oper3 = { "x, y, z", "-x, -y, z", "x, -y, -z", "-x, y, -z",
			"-x, -y, -z", "x, y, -z", "-x, y, z", };
	// space group without glides and screws (P222 with prigin = 1/4, 1/4, 1/4)
	static String[] p212121 = { "x, y, z", "-x, 1/2+y, 1/2-z",
			"1/2-x, -y, 1/2+z", "1/2+x, 1/2-y, -z", };
	static String[] p21c = { "x, y, z", "-x, y+1/2, -z+1/2",
			"x, -y+1/2, z+1/2", "-x, -y, -z", };
	static String[] p2m = { "x, y, z", "-x, y, -z", "x, -y, z", "-x, -y, -z", };
	static String[] abm2 = { "x, y, z", "-x, -y, z", "x, 1/2-y, z",
			"-x, 1/2+y, z", "x, 1/2+y, 1/2+z", "-x, 1/2-y, 1/2+z",
			"x, -y, 1/2+z", "-x, y, 1/2+z", };
	static String[] p21212 = { "x, y, z", "-x, -y, z", "1/2+x, 1/2-y, -z",
			"1/2-x, 1/2+y, -z", };
	static String[] p1 = { "x, y, z", };
	static String[] p21 = { "x, y, z", "x, 1/2+y, z", };
	static String[] ibar42d = { "x, y, z", "y, -x, -z", "-x, -y, z",
			"-y, x, -z", "x, -y+1/2, -z+1/4", "-y+1/2, -x, z+3/4",
			"-x, y+1/2, -z+1/4", "y+1/2, x, z+3/4", "x+1/2, y+1/2, z+1/2",
			"y+1/2, -x+1/2, -z+1/2", "-x+1/2, -y+1/2, z+1/2",
			"-y+1/2, x+1/2, -z+1/2", "x+1/2, -y, -z+3/4", "-y, -x+1/2, z+1/4",
			"-x+1/2, y, -z+3/4", "y, x+1/2, z+1/4" };
	static String[] c2c = { "x, y, z", "-x, y, -z+1/2", "x+1/2, y+1/2, z",
			"-x+1/2, y+1/2, -z+1/2", "-x, -y, -z", "x, -y, z-1/2",
			"-x+1/2, -y+1/2, -z", "x+1/2, -y+1/2, z-1/2" };
	static String[] rbar3 = { "x, y, z", "-y, x-y, z", "-x+y, -x, z",
			"x+2/3, y+1/3, z+1/3", "-y+2/3, x-y+1/3, z+1/3",
			"-x+y+2/3, -x+1/3, z+1/3", "x+1/3, y+2/3, z+2/3",
			"-y+1/3, x-y+2/3, z+2/3", "-x+y+1/3, -x+2/3, z+2/3", "-x, -y, -z",
			"y, -x+y, -z", "x-y, x, -z", "-x+2/3, -y+1/3, -z+1/3",
			"y+2/3, -x+y+1/3, -z+1/3", "x-y+2/3, x+1/3, -z+1/3",
			"-x+1/3, -y+2/3, -z+2/3", "y+1/3, -x+y+2/3, -z+2/3",
			"x-y+1/3, x+2/3, -z+2/3" };
	static String[] abar22a = { "x, y, z", "x+1/2, -y, -z", "x+1/2, -y, z",
			"x, y, -z", "x, y+1/2, z+1/2", "x+1/2, -y+1/2, -z+1/2",
			"x+1/2, -y+1/2, z+1/2", "x, y+1/2, -z+1/2" };
	static String[] fdd2 = { "x, y, z", "-x, -y, z", "-x+1/4, y+1/4, z+1/4",
			"x+1/4, -y+1/4, z+1/4", "x, y+1/2, z+1/2", "-x, -y+1/2, z+1/2",
			"-x+1/4, y+3/4, z+3/4", "x+1/4, -y+3/4, z+3/4", "x+1/2, y, z+1/2",
			"-x+1/2, -y, z+1/2", "-x+3/4, y+1/4, z+3/4",
			"x+3/4, -y+1/4, z+3/4", "x+1/2, y+1/2, z", "-x+1/2, -y+1/2, z",
			"-x+3/4, y+3/4, z+1/4", "x+3/4, -y+3/4, z+1/4" };
	CMLMatrix[] matrix1 = null;
	CMLTransform3[] transform31 = null;

	/**
	 * setup.
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		matrix1 = new CMLMatrix[] {
				new CMLMatrix(3, 4, new double[] { 1, 0, 0, 0.0, 0, 1, 0, 0.0,
						0, 0, 1, 0.0 }),
				new CMLMatrix(3, 4, new double[] { -1, 0, 0, 0.5, 0, -1, 0,
						0.0, 0, 0, 1, 0.5 }),
				new CMLMatrix(3, 4, new double[] { 1, 0, 0, 0.5, 0, -1, 0, 0.5,
						0, 0, -1, 0.0 }),
				new CMLMatrix(3, 4, new double[] { -1, 0, 0, 0.0, 0, 1, 0, 0.5,
						0, 0, -1, 0.5 }),
				new CMLMatrix(3, 4, new double[] { -1, 0, 0, 0.0, 0, -1, 0,
						0.0, 0, 0, -1, 0.0 }),
				new CMLMatrix(3, 4, new double[] { 1, 0, 0, -0.5, 0, 1, 0, 0.0,
						0, 0, -1, -0.5 }),
				new CMLMatrix(3, 4, new double[] { -1, 0, 0, -0.5, 0, 1, 0,
						-0.5, 0, 0, 1, 0.0 }),
				new CMLMatrix(3, 4, new double[] { 1, 0, 0, 0.0, 0, -1, 0,
						-0.5, 0, 0, 1, -0.5 }) };
		transform31 = new CMLTransform3[] {
				new CMLTransform3(new double[] { 1, 0, 0, 0.0, 0, 1, 0, 0.0, 0,
						0, 1, 0.0, 0, 0, 0, 1 }),
				new CMLTransform3(new double[] { -1, 0, 0, 0.5, 0, -1, 0, 0.0,
						0, 0, 1, 0.5, 0, 0, 0, 1 }),
				new CMLTransform3(new double[] { 1, 0, 0, 0.5, 0, -1, 0, 0.5,
						0, 0, -1, 0.0, 0, 0, 0, 1 }),
				new CMLTransform3(new double[] { -1, 0, 0, 0.0, 0, 1, 0, 0.5,
						0, 0, -1, 0.5, 0, 0, 0, 1 }),
				new CMLTransform3(new double[] { -1, 0, 0, 0.0, 0, -1, 0, 0.0,
						0, 0, -1, 0.0, 0, 0, 0, 1 }),
				new CMLTransform3(new double[] { 1, 0, 0, -0.5, 0, 1, 0, 0.0,
						0, 0, -1, -0.5, 0, 0, 0, 1 }),
				new CMLTransform3(new double[] { -1, 0, 0, -0.5, 0, 1, 0, -0.5,
						0, 0, 1, 0.0, 0, 0, 0, 1 }),
				new CMLTransform3(new double[] { 1, 0, 0, 0.0, 0, -1, 0, -0.5,
						0, 0, 1, -0.5, 0, 0, 0, 1 }), };
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLSymmetry.CMLSymmetry(String[])'
	 */
	@Test
	public void testCMLSymmetryStringArray() {
		Assert.assertEquals("opercount", 8, pbca.length);
		CMLSymmetry symmetry = new CMLSymmetry(pbca);
		CMLElements<CMLMatrix> matrices = symmetry.getMatrixElements();
		Assert.assertEquals("matrixcount", 0, matrices.size());
		CMLElements<CMLTransform3> transform3s = symmetry
				.getTransform3Elements();
		Assert.assertEquals("transformcount", 8, transform3s.size());
		int i = 0;
		for (CMLTransform3 transform3 : transform3s) {
			CMLTransform3Test.assertEquals("symmetry element transform3 " + i,
					transform31[i++], transform3, CMLConstants.EPS);
		}
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLSymmetry.isGroup()'
	 */
	@Test
	public void testIsGroup() {
		CMLSymmetry symmetry = new CMLSymmetry(pbca);
		Assert.assertEquals("group", false, symmetry.isGroup());
		symmetry = new CMLSymmetry(pmmm);
		Assert.assertEquals("group", true, symmetry.isGroup());
		symmetry = new CMLSymmetry(oper3);
		Assert.assertEquals("group", false, symmetry.isGroup());
		symmetry = new CMLSymmetry(p212121);
		Assert.assertEquals("group", false, symmetry.isGroup());
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLSymmetry.isSpaceGroup()'
	 */
	@Test
	public void testIsSpaceGroup() {
		CMLSymmetry symmetry = new CMLSymmetry(pbca);
		// Assert.assertEquals("group", true, symmetry.isSpaceGroup());
		symmetry = new CMLSymmetry(p212121);
		Assert.assertEquals("group", true, symmetry.isSpaceGroup());
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLSymmetry.multiplyCMLSymmetry
	 * sym)
	 */
	@Test
	public void testCMLSymmetrymultiplyCMLSymmetry() {
		CMLSymmetry sym1 = new CMLSymmetry(new String[] { "x, y, z",
				"-x, -y, -z" });
		CMLSymmetry sym1Copy = new CMLSymmetry(sym1);
		Assert.assertTrue("convolute", sym1Copy.isEqualTo(sym1, EPS));
		CMLSymmetry mmmGenerators = new CMLSymmetry(new String[] { "x, y, z",
				"-x, y, z", "x, -y, z", "x, y, -z", });
		CMLSymmetry mmm = new CMLSymmetry(new String[] { "x, y, z", "-x, y, z",
				"x, -y, z", "x, y, -z", "-x, -y, -z", "x, -y, -z", "-x, y, -z",
				"-x, -y, z", });
		CMLSymmetry sym2Copy = new CMLSymmetry(mmmGenerators);
		Assert.assertTrue("convolute", sym2Copy.isEqualTo(mmmGenerators, EPS));
		// this generates a complete group
		CMLSymmetry sym = sym1.convolute(mmmGenerators);
		// make sure no corruption
		Assert.assertTrue("convolute", sym2Copy.isEqualTo(mmmGenerators, EPS));
		Assert.assertTrue("convolute", sym1Copy.isEqualTo(sym1, EPS));
		Assert.assertEquals("convolute", 8, sym.getTransform3Elements().size());
		Assert.assertTrue("convolute", sym.isEqualTo(mmm, EPS));
		sym = sym1.convolute(sym1);
		Assert.assertEquals("convolute", 2, sym.getTransform3Elements().size());
		sym = mmmGenerators.convolute(mmmGenerators);
		// this does not generate a complete group (-x, -y, -z is missing)
		Assert.assertEquals("convolute", 7, sym.getTransform3Elements().size());
		CMLSymmetry sym4 = new CMLSymmetry(new String[] { "x, y, z",
				"-x, y, z", "x, -y, z", "x, y, -z", "-x, -y, z", "-x, y, -z",
				"x, -y, -z", });
		Assert.assertTrue("convolute", sym.isEqualTo(sym4, EPS));
	}

	/** test. */
	@Test
	public void testGetNonTranslations() {
		CMLSymmetry fullGroup = null;
		CMLSymmetry nonTranslationSubGroup = null;
		CMLElements<CMLTransform3> subGroupElements = null;
		fullGroup = new CMLSymmetry(p212121);
		Assert.assertTrue("is group", fullGroup.isSpaceGroup());
		nonTranslationSubGroup = fullGroup.getNonTranslations();
		subGroupElements = nonTranslationSubGroup.getTransform3Elements();
		Assert.assertEquals("group elements", 0, subGroupElements.size());
		fullGroup = new CMLSymmetry(p21c);
		Assert.assertTrue("is group", fullGroup.isSpaceGroup());
		nonTranslationSubGroup = fullGroup.getNonTranslations();
		Assert.assertFalse("is group", nonTranslationSubGroup.isSpaceGroup());
		subGroupElements = nonTranslationSubGroup.getTransform3Elements();
		Assert.assertEquals("group elements", 1, subGroupElements.size());
		fullGroup = new CMLSymmetry(pbca);
		Assert.assertTrue("is group", fullGroup.isSpaceGroup());
		nonTranslationSubGroup = fullGroup.getNonTranslations();
		Assert.assertFalse("is group", nonTranslationSubGroup.isSpaceGroup());
		subGroupElements = nonTranslationSubGroup.getTransform3Elements();
		Assert.assertEquals("group elements", 1, subGroupElements.size());
		fullGroup = new CMLSymmetry(abm2);
		Assert.assertTrue("is group", fullGroup.isSpaceGroup());
		nonTranslationSubGroup = fullGroup.getNonTranslations();
		Assert.assertFalse("is not space group", nonTranslationSubGroup
				.isSpaceGroup());
		subGroupElements = nonTranslationSubGroup.getTransform3Elements();
		Assert.assertEquals("group elements", 2, subGroupElements.size());
	}

	/** test. */
	@Test
	public void testGetPureTranslations() {
		CMLSymmetry fullGroup = new CMLSymmetry(p212121);
		List<CMLTransform3> operators = fullGroup.getPureTranslations();
		Assert.assertEquals("translations", 0, operators.size());
		fullGroup = new CMLSymmetry(ibar42d);
		operators = fullGroup.getPureTranslations();
		Assert.assertEquals("translations", 1, operators.size());
		CMLVector3Test.assertEquals("centering",
				new double[] { 0.5, 0.5, 0.5 }, operators.get(0)
						.getTranslation(), EPS);
		CMLCrystal.Centering centering = fullGroup.getCentering();
		Assert.assertTrue("centering type", CMLCrystal.Centering.I
				.equals(centering));
		fullGroup = new CMLSymmetry(c2c);
		operators = fullGroup.getPureTranslations();
		Assert.assertEquals("translations", 1, operators.size());
		CMLVector3Test.assertEquals("centering", new double[] { 0.5, 0.5, 0 },
				operators.get(0).getTranslation(), EPS);
		centering = fullGroup.getCentering();
		Assert.assertTrue("centering type", CMLCrystal.Centering.C
				.equals(centering));
		fullGroup = new CMLSymmetry(rbar3);
		operators = fullGroup.getPureTranslations();
		Assert.assertEquals("translations", 2, operators.size());
		CMLVector3Test.assertEquals("centering", new double[] { 2. / 3.,
				1. / 3., 1. / 3. }, operators.get(0).getTranslation(), EPS);
		CMLVector3Test.assertEquals("centering", new double[] { 1. / 3.,
				2. / 3., 2. / 3. }, operators.get(1).getTranslation(), EPS);
		centering = fullGroup.getCentering();
		Assert.assertTrue("centering type", CMLCrystal.Centering.R
				.equals(centering));
		fullGroup = new CMLSymmetry(abar22a);
		operators = fullGroup.getPureTranslations();
		Assert.assertEquals("translations", 1, operators.size());
		CMLVector3Test.assertEquals("centering", new double[] { 0, 0.5, 0.5 },
				operators.get(0).getTranslation(), EPS);
		centering = fullGroup.getCentering();
		Assert.assertTrue("centering type", CMLCrystal.Centering.A
				.equals(centering));
		fullGroup = new CMLSymmetry(fdd2);
		operators = fullGroup.getPureTranslations();
		Assert.assertEquals("translations", 3, operators.size());
		CMLVector3Test.assertEquals("centering", new double[] { 0, 0.5, 0.5 },
				operators.get(0).getTranslation(), EPS);
		CMLVector3Test.assertEquals("centering", new double[] { 0.5, 0, 0.5 },
				operators.get(1).getTranslation(), EPS);
		CMLVector3Test.assertEquals("centering", new double[] { 0.5, 0.5, 0 },
				operators.get(2).getTranslation(), EPS);
		centering = fullGroup.getCentering();
		Assert.assertTrue("centering type", CMLCrystal.Centering.F
				.equals(centering));
	}

	/** test. */
	@Test
	public void testGetPointGroupMultiplicity() {
		double eps = 0.0000001;
		CMLSymmetry group = null;
		Point3 p000 = new Point3(new double[] { 0., 0., 0. });
		Point3 p123 = new Point3(new double[] { 0.1, 0.2, 0.3 });
		Point3 p300 = new Point3(new double[] { 0.3, 0.0, 0.0 });
		Point3 p304 = new Point3(new double[] { 0.3, 0.0, 0.4 });
		Point3 p555 = new Point3(new double[] { 0.5, 0.5, 0.5 });
		int multiplicity = 0;
		group = new CMLSymmetry(pmmm);
		Assert.assertTrue("is group", group.isSpaceGroup());
		multiplicity = group.getPointGroupMultiplicity(p000, eps);
		Assert.assertEquals("multiplicity ", 8, multiplicity);
		multiplicity = group.getPointGroupMultiplicity(p123, eps);
		Assert.assertEquals("multiplicity ", 1, multiplicity);
		multiplicity = group.getPointGroupMultiplicity(p300, eps);
		Assert.assertEquals("multiplicity ", 4, multiplicity);
		multiplicity = group.getPointGroupMultiplicity(p304, eps);
		Assert.assertEquals("multiplicity ", 2, multiplicity);
		multiplicity = group.getPointGroupMultiplicity(p555, eps);
		Assert.assertEquals("multiplicity ", 1, multiplicity);
		multiplicity = group.getSpaceGroupMultiplicity(p555);
		Assert.assertEquals("multiplicity ", 8, multiplicity);
		group = new CMLSymmetry(p212121);
		Assert.assertTrue("is group", group.isSpaceGroup());
		multiplicity = group.getPointGroupMultiplicity(p000, eps);
		Assert.assertEquals("multiplicity ", 1, multiplicity);
	}

	/** test. */
	@Test
	public void testGetSpaceGroupMultiplicity() {
		/*
		 * -- - <symmetry> <transform3> 1.0 0.0 0.0 0.0 0.0 1.0 0.0 0.0 0.0 0.0
		 * 1.0 0.0 0.0 0.0 0.0 1.0</transform3> <transform3> -1.0 0.0 0.0 0.0
		 * 0.0 -1.0 0.0 0.0 0.0 0.0 1.0 0.0 0.0 0.0 0.0 1.0</transform3>
		 * <transform3> 1.0 0.0 0.0 0.5 0.0 -1.0 0.0 0.5 0.0 0.0 -1.0 0.0 0.0
		 * 0.0 0.0 1.0</transform3> <transform3> -1.0 0.0 0.0 0.5 0.0 1.0 0.0
		 * 0.5 0.0 0.0 -1.0 0.0 0.0 0.0 0.0 1.0</transform3> </symmetry> - <atom
		 * id="a1" elementType="O" xFract="0.5" yFract="1.0" zFract="0.8011"
		 * x3="7.52975" y3="17.1977" z3="8.689131150000003"> </atom> - <atom
		 * id="a2" elementType="O" xFract="0.33569" yFract="0.98239"
		 * zFract="0.88892" x3="5.055323555" y3="16.894848503000002"
		 * z3="9.641670780000004"> </atom> --
		 */
		CMLSymmetry group = null;
		Point3 p1 = new Point3(new double[] { 0.0, 0.5, 0.8011 });
		Point3 p1a = new Point3(new double[] { 1.0, 0.5, 0.8011 });
		Point3 p1b = new Point3(new double[] { 0.0, -0.5, 0.8011 });
		Point3 p2 = new Point3(new double[] { 0.33569, 0.98239, 0.88892 });
		Point3 p3a = new Point3(new double[] { 0.5, 1.0, 0.8011 });
		Point3 p3b = new Point3(new double[] { -0.5, 1.0, 0.8011 });
		int multiplicity = 0;
		group = new CMLSymmetry(p21212);
		Assert.assertTrue("is group", group.isSpaceGroup());
		multiplicity = group.getSpaceGroupMultiplicity(p1);
		Assert.assertEquals("multiplicity ", 2, multiplicity);
		multiplicity = group.getSpaceGroupMultiplicity(p1a);
		Assert.assertEquals("multiplicity ", 2, multiplicity);
		multiplicity = group.getSpaceGroupMultiplicity(p1b);
		Assert.assertEquals("multiplicity ", 2, multiplicity);
		multiplicity = group.getSpaceGroupMultiplicity(p2);
		Assert.assertEquals("multiplicity ", 1, multiplicity);
		multiplicity = group.getSpaceGroupMultiplicity(p3a);
		Assert.assertEquals("multiplicity ", 2, multiplicity);
		multiplicity = group.getSpaceGroupMultiplicity(p3b);
		Assert.assertEquals("multiplicity ", 2, multiplicity);

		// Ni 0.0000 0.0000 0.5000 0.02783(15) Uani d SU 1 . . Ni
		// 'x, y, z'
		// 'x+1/2, -y+1/2, z+1/2'
		// '-x, -y, -z'
		// '-x-1/2, y-1/2, -z-1/2'
		Point3 point = new Point3(0.0000, 0.0000, 0.5000);
		CMLSymmetry symmetry = new CMLSymmetry(new String[] { "x, y, z",
				"x+1/2, -y+1/2, z+1/2", "-x, -y, -z", "-x-1/2, y-1/2, -z-1/2" });
		int mult = symmetry.getSpaceGroupMultiplicity(point);
		Assert.assertEquals("Multiplicity ", 2, mult);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLSymmetry.copy()'
	 */
	@Test
	public void testCopy() {
		CMLSymmetry symmetry = new CMLSymmetry(pbca);
		CMLSymmetry symmetry1 = (CMLSymmetry) symmetry.copy();
		Assert.assertEquals("copy", symmetry.getMatrixElements().size(),
				symmetry1.getMatrixElements().size());
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLSymmetry.CMLSymmetry(List<CMLTransform3>)'
	 */
	@Test
	public void testCMLSymmetryListOfCMLTransform3() {
		List<CMLTransform3> list = new ArrayList<CMLTransform3>();
		list.add(new CMLTransform3("x, y, z"));
		list.add(new CMLTransform3("-x, 1/2+y, -z"));
		CMLSymmetry symmetry = new CMLSymmetry(list);
		Assert.assertEquals("symmetry", 2, symmetry.getTransform3Elements()
				.size());
		CMLTransform3 tr = symmetry.getTransform3Elements().get(1);
		CMLTransform3Test.assertEquals("symmetry 2", new double[] { -1.0, 0.0,
				0.0, 0.0, 0.0, 1.0, 0.0, 0.5, 0.0, 0.0, -1.0, 0.0, 0.0, 0.0,
				0.0, 1.0 }, tr, EPS);
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLSymmetry.createFromXYZStrings(List<String>)'
	 */
	@Test
	public void testCreateFromXYZStrings() {
		List<String> list = new ArrayList<String>();
		list.add("x, y, z");
		list.add("-x, 1/2+y, -z");
		CMLSymmetry symmetry = CMLSymmetry.createFromXYZStrings(list);
		Assert.assertEquals("symmetry", 2, symmetry.getTransform3Elements()
				.size());
		CMLTransform3 tr = symmetry.getTransform3Elements().get(1);
		CMLTransform3Test.assertEquals("symmetry 2", new double[] { -1.0, 0.0,
				0.0, 0.0, 0.0, 1.0, 0.0, 0.5, 0.0, 0.0, -1.0, 0.0, 0.0, 0.0,
				0.0, 1.0 }, tr, EPS);
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLSymmetry.convolute(CMLSymmetry)'
	 */
	@Test
	@Ignore("doesn't yet work")
	@SuppressWarnings("unused")
	public void testConvolute() {
		List<String> list = new ArrayList<String>();
		list.add("x, y, z");
		list.add("-x, 1/2+y, -z");
		CMLSymmetry symmetry1 = CMLSymmetry.createFromXYZStrings(list);
		list = new ArrayList<String>();
		list.add("-x, -y, -z");
		@SuppressWarnings("unused")
		CMLSymmetry symmetry2 = CMLSymmetry.createFromXYZStrings(list);
		CMLSymmetry symmetry3 = symmetry1.convolute(symmetry2);
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLSymmetry.isEqualTo(CMLSymmetry, double)'
	 */
	@Test
	public void testIsEqualTo() {
		List<String> list = new ArrayList<String>();
		list.add("x, y, z");
		list.add("-x, 1/2+y, -z");
		CMLSymmetry symmetry1 = CMLSymmetry.createFromXYZStrings(list);
		list = new ArrayList<String>();
		list.add("x, y, z");
		list.add("-x, 1/2+y, -z");
		CMLSymmetry symmetry2 = CMLSymmetry.createFromXYZStrings(list);
		Assert.assertTrue("is equal", symmetry1.isEqualTo(symmetry2, EPS));
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLSymmetry.normalizeCrystallographically()'
	 */
	@Test
	public void testNormalizeCrystallographically() {
		List<String> list = new ArrayList<String>();
		list.add("x, y, 2+z");
		list.add("1-x, 1/2+y, 3-z");
		CMLSymmetry symmetry1 = CMLSymmetry.createFromXYZStrings(list);

		list = new ArrayList<String>();
		list.add("x, y, z");
		list.add("-x, 1/2+y, -z");
		CMLSymmetry symmetry2 = CMLSymmetry.createFromXYZStrings(list);
		Assert.assertFalse("is equal", symmetry1.isEqualTo(symmetry2, EPS));
		symmetry1.normalizeCrystallographically();

		Assert.assertTrue("is equal", symmetry1.isEqualTo(symmetry2, EPS));
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLSymmetry.getCentering()'
	 */
	@Test
	public void testGetCentering() {
		List<String> list = new ArrayList<String>();
		list.add("x, y, z");
		list.add("-x, +y, -z");
		list.add("1/2+x, 1/2+y, z");
		list.add("1/2-x, 1/2+y, -z");
		CMLSymmetry symmetry1 = CMLSymmetry.createFromXYZStrings(list);
		CMLCrystal.Centering center = symmetry1.getCentering();
		Assert.assertEquals("center", CMLCrystal.Centering.C, center);
	}
}
