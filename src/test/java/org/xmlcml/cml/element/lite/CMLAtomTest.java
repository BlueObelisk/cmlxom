package org.xmlcml.cml.element.lite;

import static org.xmlcml.euclid.EuclidConstants.S_RBRAK;
import nu.xom.Node;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.xmlcml.cml.attribute.IdAttribute;
import org.xmlcml.cml.base.CMLAttribute;
import org.xmlcml.cml.base.CMLElement.CoordinateType;
import org.xmlcml.cml.base.CMLElement.FormalChargeControl;
import org.xmlcml.cml.element.CMLAtom;
import org.xmlcml.cml.element.CMLBond;
import org.xmlcml.cml.element.CMLMolecule;
import org.xmlcml.cml.element.main.MoleculeAtomBondFixture;
import org.xmlcml.euclid.Angle;
import org.xmlcml.euclid.EC;
import org.xmlcml.euclid.EuclidConstants;
import org.xmlcml.euclid.Point3;
import org.xmlcml.euclid.Real2;
import org.xmlcml.euclid.Transform2;
import org.xmlcml.euclid.Transform3;
import org.xmlcml.euclid.Vector3;
import org.xmlcml.euclid.test.DoubleTestBase;
import org.xmlcml.molutil.ChemicalElement;
import org.xmlcml.molutil.ChemicalElement.AS;

/**
 * test CMLAtom.
 * 
 * @author pmr
 * 
 */
public class CMLAtomTest {
	MoleculeAtomBondFixture fixture;

	/**
	 * setup.
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		fixture = new MoleculeAtomBondFixture();

		/*
		 * -- String chiralMol = "<?xml version='1.0' encoding='UTF-8'?>\r\n"+
		 * <molecule title='' xmlns='+CML_NS+"'>\r\n <atomArray>\r\n <atom
		 * id='c1' x2='1.3125' y2='-0.8417' elementType='C'/>\r\n <atom id='c2'
		 * x2='2.027' y2='-0.4292' elementType='C'/>\r\n <atom id='c3'
		 * x2='2.7414' y2='-0.8417' elementType='C'/>\r\n <atom id='c4'
		 * x2='3.4559' y2='-0.4292' elementType='C'/>\r\n <atom id='c5'
		 * x2='4.1704' y2='-0.8417' elementType='C'/>\r\n <atom id='cl6'
		 * x2='4.8849' y2='-0.4292' elementType='Cl'/>\r\n <atom id='cl5'
		 * x2='4.1704' y2='-1.6667' elementType='Cl'/>\r\n <atom id='cl1'
		 * x2='0.598' y2='-0.4292' elementType='Cl'/>\r\n <atom id='cl2'
		 * x2='1.3125' y2='-1.6667' elementType='Cl'/>\r\n <atom id='cl3'
		 * x2='2.027' y2='0.3958' elementType='Cl'/>\r\n <atom id='cl4'
		 * x2='3.4559' y2='0.3958' elementType='Cl'/>\r\n <atom id='br1'
		 * x2='2.7414' y2='-1.6667' elementType='Br'/>\r\n </atomArray>\r\n
		 * <bondArray>\r\n <bond atomRefs2='c1 c2' id='b1' order='1'/>\r\n <bond
		 * atomRefs2='c5 cl5' id='b2' order='1'/>\r\n <bond atomRefs2='c3 c4'
		 * id='b3' order='1'/>\r\n <bond atomRefs2='c1 cl1' id='b4'
		 * order='1'/>\r\n <bond atomRefs2='c1 cl2' id='b5' order='1'/>\r\n
		 * <bond atomRefs2='c4 c5' id='b6' order='1'/>\r\n <bond atomRefs2='c2
		 * cl3' id='b7' order='1'>\r\n <bondStereo>H</bondStereo>\r\n
		 * </bond>\r\n <bond atomRefs2='c2 c3' id='b8' order='1'/>\r\n <bond
		 * atomRefs2='c4 cl4' id='b9' order='1'>\r\n
		 * <bondStereo>H</bondStereo>\r\n </bond>\r\n <bond atomRefs2='c5 cl6'
		 * id='b10' order='1'/>\r\n <bond atomRefs2='c3 br1' id='b11'
		 * order='1'/>\r\n </bondArray>\r\n</molecule>\r\n";
		 * 
		 * try { Document chrialDoc = builder.build(new
		 * StringReader(chiralMol)); chrialMolecule = (CMLMolecule)
		 * chrialDoc.getRootElement(); } catch (IOException e) {
		 * Assert.fail("Should not throw IOException"); } catch
		 * (ParsingException e) { e.printStackTrace();
		 * Assert.fail("Should not throw ParsingException"); }
		 * 
		 * String simpleExplicitChiralMolS =
		 * "<?xml version='1.0' encoding='UTF-8'?>\r\n<molecule title='' xmlns='"
		 * +CML_NS+
		 * "'>\r\n  <atomArray>\r\n    <atom id='a1' x2='-1.9919' y2='1.2851' elementType='C'/>\r\n    <atom id='a2' x2='-1.9919' y2='2.1351' elementType='O'/>\r\n    <atom id='a3' x2='-2.7281' y2='0.8601' elementType='H'/>\r\n    <atom id='a4' x2='-1.2558' y2='0.8601' elementType='Br'/>\r\n    <atom id='a5' x2='-1.9919' y2='0.4351' elementType='Cl'/>\r\n  </atomArray>\r\n  <bondArray>\r\n    <bond atomRefs2='a1 a2' id='b1' order='1'/>\r\n    <bond atomRefs2='a1 a3' id='b2' order='1'>\r\n      <bondStereo>W</bondStereo>\r\n    </bond>\r\n    <bond atomRefs2='a1 a4' id='b3' order='1'/>\r\n    <bond atomRefs2='a1 a5' id='b4' order='1'/>\r\n  </bondArray>\r\n</molecule>\r\n"
		 * ; String simpleExplicitChiralMolR =
		 * "<?xml version='1.0' encoding='UTF-8'?>\r\n<molecule title='' xmlns='"
		 * +CML_NS+
		 * "'>\r\n  <atomArray>\r\n    <atom id='a1' x2='-1.9919' y2='1.2851' elementType='C'/>\r\n    <atom id='a2' x2='-1.9919' y2='2.1351' elementType='O'/>\r\n    <atom id='a3' x2='-2.7281' y2='0.8601' elementType='H'/>\r\n    <atom id='a4' x2='-1.2558' y2='0.8601' elementType='Br'/>\r\n    <atom id='a5' x2='-1.9919' y2='0.4351' elementType='Cl'/>\r\n  </atomArray>\r\n  <bondArray>\r\n    <bond atomRefs2='a1 a2' id='b1' order='1'/>\r\n    <bond atomRefs2='a1 a3' id='b2' order='1'>\r\n      <bondStereo>H</bondStereo>\r\n    </bond>\r\n    <bond atomRefs2='a1 a4' id='b3' order='1'/>\r\n    <bond atomRefs2='a1 a5' id='b4' order='1'/>\r\n  </bondArray>\r\n</molecule>\r\n"
		 * ;
		 * 
		 * try { Document chrialDoc = builder.build(new
		 * StringReader(simpleExplicitChiralMolS));
		 * simpleExplicitChiralMoleculeS = (CMLMolecule)
		 * chrialDoc.getRootElement(); } catch (IOException e) {
		 * Assert.fail("Should not throw IOException"); } catch
		 * (ParsingException e) { e.printStackTrace();
		 * Assert.fail("Should not throw ParsingException"); }
		 * 
		 * try { Document chrialDoc = builder.build(new
		 * StringReader(simpleExplicitChiralMolR));
		 * simpleExplicitChiralMoleculeR = (CMLMolecule)
		 * chrialDoc.getRootElement(); } catch (IOException e) {
		 * Assert.fail("Should not throw IOException"); } catch
		 * (ParsingException e) { e.printStackTrace();
		 * Assert.fail("Should not throw ParsingException"); } --
		 */
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLAtom.copy()'
	 */
	@Test
	public void testCopy() {
		Node copy = fixture.xmlAtom[0].copy();
		// XML-BASIC
		Assert.assertEquals("class should be CMLAtom: ", copy.getClass(),
				CMLAtom.class);
		CMLAtom copyAtom = (CMLAtom) copy;
		// XML-BASIC
		Assert.assertEquals("atom is identical", copyAtom
				.compareTo(fixture.xmlAtom[0]), 0);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLAtom.CMLAtom()'
	 */
	@Test
	public void testCMLAtom() {
		CMLAtom atom = new CMLAtom();
		// XML-BASIC
		Assert.assertNotNull("constructor ", atom);
		Assert.assertNull("no id attribute", atom.getIdAttribute());
		Assert.assertEquals("no children", atom.getChildCount(), 0);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLAtom.CMLAtom(CMLAtom)'
	 */
	@Test
	public void testCMLAtomCMLAtom() {
		// copy constructor
		// XML-BASIC
		CMLAtom xatom = fixture.xomAtom[0];
		CMLAtom atom = new CMLAtom(xatom);
		Assert.assertNotNull("constructor ", atom);

		CMLAttribute idAtt = atom.getIdAttribute();
		// XML-BASIC
		Assert.assertTrue("id class is subclass of CMLAttribute",
				CMLAttribute.class.isAssignableFrom(idAtt.getClass()));
		// XML-BASIC
		Assert.assertEquals("id class is StringSTAttribute", IdAttribute.class,
				idAtt.getClass());
		// XML-BASIC
		Assert.assertEquals("id value", atom.getId(), xatom.getId());
		// XML-BASIC
		Assert.assertEquals("atom is identical", 0, atom.compareTo(xatom));

	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLAtom.getMolecule()'
	 */
	@Test
	public void testGetMolecule() {
		// xml
		CMLMolecule molecule = fixture.xmlAtom[0].getMolecule();
		// XML-BASIC
		Assert.assertNotNull("molecule should not be null", molecule);
		// XML-BASIC
		Assert.assertEquals("get molecule", fixture.xmlMolecule, molecule);
		// dom
		molecule = fixture.xomAtom[0].getMolecule();
		// XML-BASIC
		Assert.assertNotNull("molecule should not be null", molecule);
		// XML-BASIC
		Assert.assertEquals("get molecule", fixture.xomMolecule, molecule);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLAtom.getValenceElectrons()'
	 */
	@Test
	public void testGetValenceElectrons() {
		String el = fixture.xmlAtom[0].getElementType();
		// XML-BASIC
		Assert.assertEquals("element type", AS.N.value, el);
		// DSL
		int ve = fixture.xmlAtom[0].getValenceElectrons();
		Assert.assertEquals("valence electrons", 5, ve);
		el = fixture.xmlAtom[1].getElementType();
		// XML-BASIC
		Assert.assertEquals("element type", AS.C.value, el);
		ve = fixture.xmlAtom[1].getValenceElectrons();
		// DSL
		Assert.assertEquals("valence electrons", 4, ve);
		el = fixture.xmlAtom[2].getElementType();
		// XML-BASIC
		Assert.assertEquals("element type", AS.S.value, el);
		ve = fixture.xmlAtom[2].getValenceElectrons();
		// DSL
		Assert.assertEquals("valence electrons", 6, ve);

	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLAtom.getXY2()'
	 */
	@Test
	public void testGetXY2() {
		// xml
		Real2 xy2 = fixture.xmlAtom[1].getXY2();
		// CML
		Assert.assertNotNull("xy2 is not null", xy2);
		// CML
		Assert.assertEquals("x coord", xy2.getX(), 1.0, EC.EPS);
		// CML
		Assert.assertEquals("y coord", xy2.getY(), 1.0, EC.EPS);
		// xom
		xy2 = fixture.xmlAtom[0].getXY2();
		// CML
		Assert.assertNotNull("xy2 is not null", xy2);
		// CML
		Assert.assertEquals("x coord", xy2.getX(), .0, EC.EPS);
		// CML
		Assert.assertEquals("y coord", xy2.getY(), .0, EC.EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLAtom.setXY2(Real2)'
	 */
	@Test
	public void testSetXY2() {
		Real2 r2 = new Real2(7., 3.);
		// 
		// CML
		fixture.xmlAtom[1].setXY2(r2);
		Assert.assertEquals("x2 coord", 7., fixture.xmlAtom[1].getX2(), EC.EPS);
		Assert.assertEquals("y2 coord", 3., fixture.xmlAtom[1].getY2(), EC.EPS);

	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLAtom.getXYZ3()'
	 */
	@Test
	public void testGetXYZ3() {
		// CML
		Point3 p3 = fixture.xmlAtom[1].getXYZ3();
		double[] test = new double[] { 1., 1., 1., };
		Assert.assertNotNull("test should not be null (" + "3D coord" + S_RBRAK, test);
		Assert.assertEquals("must be of length 3", 3, test.length);
		Assert.assertNotNull("ref should not be null (" + "3D coord" + S_RBRAK,
				p3);
		DoubleTestBase.assertEquals("3D coord", test, p3.getArray(), EC.EPS);

	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLAtom.setXYZ3(Point3)'
	 */
	@Test
	public void testSetXYZ3() {
		// CML
		Point3 p3 = new Point3(7., 3., 5.);
		fixture.xmlAtom[1].setXYZ3(p3);
		Point3 p3a = fixture.xmlAtom[1].getXYZ3();
		double[] test = new double[] { 7., 3., 5., };
		Assert.assertNotNull("test should not be null (" + "set 3D coord" + S_RBRAK, test);
		Assert.assertEquals("must be of length 3", 3, test.length);
		Assert.assertNotNull("ref should not be null (" + "set 3D coord" + S_RBRAK,
				p3a);
		DoubleTestBase.assertEquals("set 3D coord", test, p3a.getArray(), EC.EPS);
		Assert.assertEquals("x3 coord", 7., fixture.xmlAtom[1].getX3(), EC.EPS);
		Assert.assertEquals("y3 coord", 3., fixture.xmlAtom[1].getY3(), EC.EPS);
		Assert.assertEquals("z3 coord", 5., fixture.xmlAtom[1].getZ3(), EC.EPS);

	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLAtom.unsetXY2()'
	 */
	@Test
	public void testUnsetXY2() {
		// CML
		CMLAtom atom = new CMLAtom();
		atom.setXYZ3(new Point3(1.1, 2.2, 3.3));
		Assert.assertFalse("has not xy2", atom
				.hasCoordinates(CoordinateType.TWOD));
		Assert.assertTrue("has xyz3", atom
				.hasCoordinates(CoordinateType.CARTESIAN));
		// CML
		atom.unsetXYZ3();
		Assert.assertFalse("has not xy2", atom
				.hasCoordinates(CoordinateType.TWOD));
		Assert.assertFalse("has not xyz3", atom
				.hasCoordinates(CoordinateType.CARTESIAN));
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLAtom.unsetXYZFract()'
	 */
	@Test
	public void testUnsetXYZFract() {
		// CML
		CMLAtom atom = new CMLAtom();
		atom.setXYZFract(new Point3(0.1, 0.2, 0.3));
		Assert.assertFalse("has not xy2", atom
				.hasCoordinates(CoordinateType.TWOD));
		Assert.assertTrue("has xyzFract", atom
				.hasCoordinates(CoordinateType.FRACTIONAL));
		atom.unsetXYZFract();
		Assert.assertFalse("has not xy2", atom
				.hasCoordinates(CoordinateType.TWOD));
		Assert.assertFalse("has not xyzFract", atom
				.hasCoordinates(CoordinateType.FRACTIONAL));
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLAtom.unsetXYZ2()'
	 */
	@Test
	public void testUnsetXYZ3() {
		// CML
		CMLAtom atom = new CMLAtom();
		atom.setXY2(new Real2(1.1, 2.2));
		Assert.assertTrue("has xy2", atom.hasCoordinates(CoordinateType.TWOD));
		Assert.assertFalse("has not xyz3", atom
				.hasCoordinates(CoordinateType.CARTESIAN));
		atom.unsetXY2();
		Assert.assertFalse("has not xy2", atom
				.hasCoordinates(CoordinateType.TWOD));
		Assert.assertFalse("has not xyz3", atom
				.hasCoordinates(CoordinateType.CARTESIAN));
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLAtom.getFractCoord()'
	 */
	@Test
	public void testGetFractCoord() {
		// CML
		Point3 p3 = fixture.xmlAtom[0].getFractCoord();
		Assert.assertNotNull("non null fract coord", p3);
		double[] test = new double[] { 0.1, 0.2, 0.3, };
		Assert.assertNotNull("test should not be null (" + "3D coord" + S_RBRAK, test);
		Assert.assertEquals("must be of length 3", 3, test.length);
		Assert.assertNotNull("ref should not be null (" + "3D coord" + S_RBRAK,
				p3);
		DoubleTestBase.assertEquals("3D coord", test, p3.getArray(), EC.EPS);
		p3 = fixture.xmlAtom[1].getFractCoord();
		Assert.assertNull("null fract coord", p3);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLAtom.getChemicalElement()'
	 */
	@Test
	public void testGetChemicalElement() {
		// DSL
		ChemicalElement el = fixture.xmlAtom[0].getChemicalElement();
		Assert.assertEquals("element", el, ChemicalElement
				.getChemicalElement(AS.N.value));
		el = fixture.xmlAtom[1].getChemicalElement();
		Assert.assertEquals("element", el, ChemicalElement
				.getChemicalElement(AS.C.value));
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLAtom.getAtomicNumber()'
	 */
	@Test
	public void testGetAtomicNumber() {
		// DSL
		int atNum = fixture.xmlAtom[0].getAtomicNumber();
		Assert.assertEquals("atomic number", atNum, 7);
		atNum = fixture.xmlAtom[1].getAtomicNumber();
		Assert.assertEquals("atomic number", atNum, 6);

	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLAtom.compareTo(CMLAtom)'
	 */
	@Test
	public void testCompareToCMLAtom() {
		// XML-BASIC-TEST??
		int comp = fixture.xmlAtom[0].compareTo(fixture.xmlAtom[0]);
		Assert.assertEquals("same atom comparison", comp, 0);
		comp = fixture.xmlAtom[0].compareTo(fixture.xmlAtom[1]);
		Assert.assertFalse("different atom comparison", comp == 0);

	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLAtom.get3DCrossProduct(CMLAtom, CMLAtom)'
	 */
	@Test
	public void testGet3DCrossProduct() {
		// DSL
		Vector3 cross3d = fixture.xmlAtom[0].get3DCrossProduct(
				fixture.xmlAtom[1], fixture.xmlAtom[2]);
		double[] test = new double[] { 0., 2., -2. };
		Assert.assertNotNull("test should not be null (" + "cross3d" + EuclidConstants.S_RBRAK, test);
		Assert.assertEquals("must be of length 3", 3, test.length);
		Assert.assertNotNull("expected should not be null (" + "cross3d" + EuclidConstants.S_RBRAK,
				cross3d);
		DoubleTestBase.assertEquals("cross3d", test, cross3d.getArray(), EC.EPS);
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLAtom.get2DCrossProduct(CMLAtom, CMLAtom)'
	 */
	@Test
	public void testGet2DCrossProduct() {
		// DSL
		Vector3 cross2d = fixture.xmlAtom[0].get2DCrossProduct(
				fixture.xmlAtom[1], fixture.xmlAtom[2]);
		double[] test = new double[] { 0., 0., -2. };
		Assert.assertNotNull("test should not be null (" + "cross2d" + EuclidConstants.S_RBRAK, test);
		Assert.assertEquals("must be of length 3", 3, test.length);
		Assert.assertNotNull("expected should not be null (" + "cross2d" + EuclidConstants.S_RBRAK,
				cross2d);
		DoubleTestBase.assertEquals("cross2d", test, cross2d.getArray(), EC.EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLAtom.get2DPoint3()'
	 */
	@Test
	public void testGet2DPoint3() {
		// DSL
		Point3 point3 = fixture.xmlAtom[1].get2DPoint3();
		double[] test = new double[] { 1., 1., 0. };
		Assert.assertNotNull("test should not be null (" + "point23" + S_RBRAK, test);
		Assert.assertEquals("must be of length 3", 3, test.length);
		Assert.assertNotNull("ref should not be null (" + "point23" + S_RBRAK,
				point3);
		DoubleTestBase.assertEquals("point23", test, point3.getArray(), EC.EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLAtom.getVector3(CMLAtom)'
	 */
	@Test
	public void testGetVector3() {
		// DSL
		Vector3 v3 = fixture.xmlAtom[0].getVector3(fixture.xmlAtom[1]);
		double[] test = new double[] { 1., 1., 1. };
		Assert.assertNotNull("test should not be null (" + "atom0 atom1" + EuclidConstants.S_RBRAK, test);
		Assert.assertEquals("must be of length 3", 3, test.length);
		Assert.assertNotNull("expected should not be null (" + "atom0 atom1" + EuclidConstants.S_RBRAK,
				v3);
		DoubleTestBase.assertEquals("atom0 atom1", test, v3.getArray(), EC.EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLAtom.getMoleculeAncestor()'
	 */
	@Test
	public void testGetMoleculeAncestor() {
		// DSL
		CMLMolecule molecule = CMLMolecule
				.getMoleculeAncestor(fixture.xmlAtom[0]);
		Assert.assertSame("molecule ancestor", fixture.xmlMolecule, molecule);

	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLAtom.setAtomId(String)'
	 */
	@Test
	public void testResetAtomId() {
		// CML
		CMLAtom atom = fixture.xmlAtom[0];
		String id = atom.getId();
		Assert.assertEquals("atom id ", "a1", id);
		atom.resetId("newId");
		id = atom.getId();
		Assert.assertEquals("atom id ", "newId", id);

	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLAtom.increaseXY2(double,
	 * double)'
	 */
	@Test
	public void testIncreaseXY2() {
		// DSL
		CMLAtom atom = fixture.xmlAtom[2];
		Real2 xy2 = atom.getXY2();
		Assert.assertNotNull("xy2 ", xy2);
		Assert.assertEquals("xy2.x before ", 1.0, xy2.getX(), EC.EPS);
		Assert.assertEquals("xy2.y before ", -1.0, xy2.getY(), EC.EPS);
		atom.setXY2(new Real2(1.2, 3.4));
		xy2 = atom.getXY2();
		Assert.assertNotNull("xy2 not null", xy2);
		Assert.assertEquals("xy2.x after ", 1.2, xy2.getX(), EC.EPS);
		Assert.assertEquals("xy2.y after ", 3.4, xy2.getY(), EC.EPS);
		atom.increaseXY2(2., 3.);
		xy2 = atom.getXY2();
		Assert.assertNotNull("xy2 not null", xy2);
		Assert.assertEquals("xy2.x after translate", 3.2, xy2.getX(), EC.EPS);
		Assert.assertEquals("xy2.y after translate", 6.4, xy2.getY(), EC.EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLAtom.transform(Transform2)'
	 */
	@Test
	public void testTransformTransform2() {
		// DSL
		CMLAtom atom = fixture.xmlAtom[2];
		atom.setXY2(new Real2(1., 2.));
		Transform2 t2 = new Transform2(new Angle(Math.PI / 2.));
		atom.transform(t2);
		Real2 xy2 = atom.getXY2();
		Assert.assertNotNull("xy2 not null", xy2);
		Assert.assertEquals("xy2.x after ", 2., xy2.getX(), EC.EPS);
		Assert.assertEquals("xy2.y after ", -1., xy2.getY(), EC.EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLAtom.increaseXYZ3(double,
	 * double, double)'
	 */
	@Test
	public void testIncreaseXYZ3() {
		// DSL
		CMLAtom atom = fixture.xmlAtom[2];
		Point3 p3 = atom.getXYZ3();
		Assert.assertNotNull("p3 ", p3);
		double[] test = new double[] { 1.0, -1., -1. };
		Assert.assertNotNull("test should not be null (" + "p3 before " + S_RBRAK, test);
		Assert.assertEquals("must be of length 3", 3, test.length);
		Assert.assertNotNull("ref should not be null (" + "p3 before " + S_RBRAK,
				p3);
		DoubleTestBase.assertEquals("p3 before ", test, p3.getArray(), EC.EPS);
		atom.setXYZ3(new Point3(1.2, 3.4, 5.6));
		p3 = atom.getXYZ3();
		Assert.assertNotNull("p3 not null", p3);
		double[] test1 = new double[] { 1.2, 3.4, 5.6 };
		Assert.assertNotNull("test should not be null (" + "p3 after " + S_RBRAK, test1);
		Assert.assertEquals("must be of length 3", 3, test1.length);
		Assert.assertNotNull("ref should not be null (" + "p3 after " + S_RBRAK,
				p3);
		DoubleTestBase.assertEquals("p3 after ", test1, p3.getArray(), EC.EPS);
		atom.increaseXYZ3(2., 3., 4.);
		p3 = atom.getXYZ3();
		Assert.assertNotNull("p3 not null", p3);
		double[] test2 = new double[] { 3.2, 6.4,
				9.6 };
		Assert.assertNotNull("test should not be null (" + "p3 after translate" + S_RBRAK, test2);
		Assert.assertEquals("must be of length 3", 3, test2.length);
		Assert.assertNotNull("ref should not be null (" + "p3 after translate" + S_RBRAK,
				p3);
		DoubleTestBase.assertEquals("p3 after translate", test2, p3.getArray(), EC.EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLAtom.increaseXYZFract(double,
	 * double, double)'
	 */
	@Test
	public void testIncreaseXYZFract() {
		// DSL
		CMLAtom atom = fixture.xmlAtom[2];
		Point3 p3 = atom.getXYZFract();
		Assert.assertNull("p3 ", p3);
		atom.setXYZFract(new Point3(.12, .34, .56));
		p3 = atom.getXYZFract();
		Assert.assertNotNull("p3 not null", p3);
		double[] test = new double[] { .12, .34, .56 };
		Assert.assertNotNull("test should not be null (" + "p3 after " + S_RBRAK, test);
		Assert.assertEquals("must be of length 3", 3, test.length);
		Assert.assertNotNull("ref should not be null (" + "p3 after " + S_RBRAK,
				p3);
		DoubleTestBase.assertEquals("p3 after ", test, p3.getArray(), EC.EPS);
		atom.increaseXYZFract(.2, .3, .4);
		p3 = atom.getXYZFract();
		Assert.assertNotNull("p3 not null", p3);
		double[] test1 = new double[] { .32, .64,
				.96 };
		Assert.assertNotNull("test should not be null (" + "p3 after translate" + S_RBRAK, test1);
		Assert.assertEquals("must be of length 3", 3, test1.length);
		Assert.assertNotNull("ref should not be null (" + "p3 after translate" + S_RBRAK,
				p3);
		DoubleTestBase.assertEquals("p3 after translate", test1, p3.getArray(), EC.EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLAtom.getHydrogenCount()'
	 */
	@Test
	public final void testGetHydrogenCount() {
		CMLAtom atom = new CMLAtom();
		// XML-BASIC
		int nh = atom.getHydrogenCount();
		Assert.assertEquals("empty atom", 0, nh);
		atom.setHydrogenCount(3);
		nh = atom.getHydrogenCount();
		Assert.assertEquals("atom with H", 3, nh);

		// CML
		CMLMolecule molecule = new CMLMolecule();
		CMLAtom atom1 = new CMLAtom("a1", ChemicalElement
				.getChemicalElement(AS.O.value));
		molecule.addAtom(atom1);
		CMLAtom atom2 = new CMLAtom("a1_h1", ChemicalElement
				.getChemicalElement(AS.H.value));
		molecule.addAtom(atom2);
		molecule.addBond(new CMLBond(atom1, atom2));
		CMLAtom atom3 = new CMLAtom("a1_h2", ChemicalElement
				.getChemicalElement(AS.H.value));
		molecule.addAtom(atom3);
		molecule.addBond(new CMLBond(atom1, atom3));

		nh = atom1.getHydrogenCount();
		Assert.assertEquals("h2o", 2, nh);
	}
	
	@Test
	public void testGetHydrogenCountMixedHydrogens() {
		CMLMolecule molecule = new CMLMolecule();
		CMLAtom atom1 = new CMLAtom("a1", ChemicalElement
				.getChemicalElement(AS.C.value));
		molecule.addAtom(atom1);
		atom1.setHydrogenCount(4);
		Assert.assertEquals(4, atom1.getHydrogenCount());
		
		CMLAtom atom2 = new CMLAtom("a1_h1", ChemicalElement
				.getChemicalElement(AS.H.value));
		molecule.addAtom(atom2);
		molecule.addBond(new CMLBond(atom1, atom2));
		Assert.assertEquals(4, atom1.getHydrogenCount());
		
		CMLAtom atom3 = new CMLAtom("a1_h2", ChemicalElement
				.getChemicalElement(AS.H.value));
		molecule.addAtom(atom3);
		molecule.addBond(new CMLBond(atom1, atom3));
		Assert.assertEquals(4, atom1.getHydrogenCount());
		
		CMLAtom atom4 = new CMLAtom("a1_h3", ChemicalElement
				.getChemicalElement(AS.H.value));
		molecule.addAtom(atom4);
		molecule.addBond(new CMLBond(atom1, atom4));
		Assert.assertEquals(4, atom1.getHydrogenCount());
		
		CMLAtom atom5 = new CMLAtom("a1_h4", ChemicalElement
				.getChemicalElement(AS.H.value));
		molecule.addAtom(atom5);
		molecule.addBond(new CMLBond(atom1, atom5));
		Assert.assertEquals(4, atom1.getHydrogenCount());
		
		atom1.setHydrogenCount(2);
		//hydrogenCount is overridden by additional explicit hydrogens
		Assert.assertEquals(4, atom1.getHydrogenCount());
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLAtom.getPoint3(CoordinateType)' also tests set
	 */
	@Test
	public final void testGetPoint3() {
		// CML
		Point3 p = fixture.xomAtom[0].getPoint3(CoordinateType.CARTESIAN);
		double[] test = new double[] { 0.0, 1.0, 2.0 };
		Assert.assertNotNull("test should not be null (" + "getPoint3" + S_RBRAK, test);
		Assert.assertEquals("must be of length 3", 3, test.length);
		Assert.assertNotNull("ref should not be null (" + "getPoint3" + S_RBRAK,
				p);
		DoubleTestBase.assertEquals("getPoint3", test, p.getArray(), EC.EPS);

		// test set
		fixture.xomAtom[0].setPoint3(new Point3(1.1, 1.2, 1.3),
				CoordinateType.CARTESIAN);
		p = fixture.xomAtom[0].getPoint3(CoordinateType.CARTESIAN);
		double[] test1 = new double[] { 1.1, 1.2, 1.3 };
		Assert.assertNotNull("test should not be null (" + "getPoint3" + S_RBRAK, test1);
		Assert.assertEquals("must be of length 3", 3, test1.length);
		Assert.assertNotNull("ref should not be null (" + "getPoint3" + S_RBRAK,
				p);
		DoubleTestBase.assertEquals("getPoint3", test1, p.getArray(), EC.EPS);

		// fractional originally missing
		p = fixture.xomAtom[0].getPoint3(CoordinateType.FRACTIONAL);
		Assert.assertNull("get fract", p);

		// set it
		fixture.xomAtom[0].setPoint3(new Point3(0.1, 0.2, 0.3),
				CoordinateType.FRACTIONAL);
		p = fixture.xomAtom[0].getPoint3(CoordinateType.FRACTIONAL);
		Assert.assertNotNull("get fract", p);
		double[] test2 = new double[] { 0.1, 0.2, 0.3 };
		Assert.assertNotNull("test should not be null (" + "getPoint3" + S_RBRAK, test2);
		Assert.assertEquals("must be of length 3", 3, test2.length);
		Assert.assertNotNull("ref should not be null (" + "getPoint3" + S_RBRAK,
				p);
		DoubleTestBase.assertEquals("getPoint3", test2, p.getArray(), EC.EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLAtom.transform(Transform3)'
	 */
	@Test
	public final void testTransformXYZTransform3() {
		// DSL
		Transform3 t = new Transform3("y, -x, y+z");
		fixture.xomAtom[0].setPoint3(new Point3(1.1, 1.2, 1.3),
				CoordinateType.CARTESIAN);
		Point3 p = fixture.xomAtom[0].getPoint3(CoordinateType.CARTESIAN);
		double[] test = new double[] { 1.1, 1.2, 1.3 };
		Assert.assertNotNull("test should not be null (" + "getPoint3" + S_RBRAK, test);
		Assert.assertEquals("must be of length 3", 3, test.length);
		Assert.assertNotNull("ref should not be null (" + "getPoint3" + S_RBRAK,
				p);
		DoubleTestBase.assertEquals("getPoint3", test, p.getArray(), EC.EPS);
		fixture.xomAtom[0].transformCartesians(t);
		p = fixture.xomAtom[0].getPoint3(CoordinateType.CARTESIAN);
		double[] test1 = new double[] { 1.2, -1.1, 2.5 };
		Assert.assertNotNull("test should not be null (" + "getPoint3" + S_RBRAK, test1);
		Assert.assertEquals("must be of length 3", 3, test1.length);
		Assert.assertNotNull("ref should not be null (" + "getPoint3" + S_RBRAK,
				p);
		DoubleTestBase.assertEquals("getPoint3", test1, p.getArray(), EC.EPS);

	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLAtom.getXYZFract()'
	 */
	@Test
	public final void testGetSetXYZFract() {
		// DSL
		// fractional originally missing
		Point3 p = fixture.xomAtom[0].getPoint3(CoordinateType.FRACTIONAL);
		Assert.assertNull("get fract", p);

		// set it
		fixture.xomAtom[0].setXYZFract(new Point3(0.1, 0.2, 0.3));
		p = fixture.xomAtom[0].getXYZFract();
		Assert.assertNotNull("get fract", p);
		double[] test = new double[] { 0.1, 0.2, 0.3 };
		Assert.assertNotNull("test should not be null (" + "getPoint3" + S_RBRAK, test);
		Assert.assertEquals("must be of length 3", 3, test.length);
		Assert.assertNotNull("ref should not be null (" + "getPoint3" + S_RBRAK,
				p);
		DoubleTestBase.assertEquals("getPoint3", test, p.getArray(), EC.EPS);
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLAtom.transformFractionalCoordinates(Transform3
	 * ) '
	 */
	@Test
	public final void testTransformFractionalCoordinatesTransform3() {
		// DSL
		Transform3 t = new Transform3("y, 1/2-x, y+z");
		fixture.xomAtom[0].setPoint3(new Point3(0.1, 0.2, 0.3),
				CoordinateType.FRACTIONAL);
		Point3 p = fixture.xomAtom[0].getPoint3(CoordinateType.FRACTIONAL);
		double[] test = new double[] { 0.1, 0.2, 0.3 };
		Assert.assertNotNull("test should not be null (" + "getPoint3" + S_RBRAK, test);
		Assert.assertEquals("must be of length 3", 3, test.length);
		Assert.assertNotNull("ref should not be null (" + "getPoint3" + S_RBRAK,
				p);
		DoubleTestBase.assertEquals("getPoint3", test, p.getArray(), EC.EPS);
		fixture.xomAtom[0].transformFractionals(t);
		p = fixture.xomAtom[0].getPoint3(CoordinateType.FRACTIONAL);
		double[] test1 = new double[] { 0.2, 0.4, 0.5 };
		Assert.assertNotNull("test should not be null (" + "getPoint3" + S_RBRAK, test1);
		Assert.assertEquals("must be of length 3", 3, test1.length);
		Assert.assertNotNull("ref should not be null (" + "getPoint3" + S_RBRAK,
				p);
		DoubleTestBase.assertEquals("getPoint3", test1, p.getArray(), EC.EPS);
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLAtom.getFormalCharge(FormalChargeControl)'
	 */
	@Test
	public final void testGetFormalChargeFormalChargeControl() {
		// DSL
		// charge is not set on this atom, so NO_DEFAULT throws error
		int fc = fixture.xomAtom[0]
				.getFormalCharge(FormalChargeControl.DEFAULT);
		Assert.assertEquals("formal charge", 0, fc);
		String err = "BUG: (unset attribute: formalCharge)should never throw";
		try {
			fc = fixture.xomAtom[0]
					.getFormalCharge(FormalChargeControl.NO_DEFAULT);
		} catch (RuntimeException e) {
			Assert.assertEquals("no default", err, e.getMessage());
		}

		// charge is set on this atom, so no default
		fc = fixture.xmlAtom[0].getFormalCharge(FormalChargeControl.DEFAULT);
		Assert.assertEquals("formal charge", 1, fc);
		err = "org.xmlcml.cml.base.CMLRuntime: unset attribute: formalCharge";
		fc = fixture.xmlAtom[0].getFormalCharge(FormalChargeControl.NO_DEFAULT);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLAtom.getElemNumb(String)'
	 */
	@Test
	public final void testCommonElementSerialNumber() {
		// DSL
		int en = CMLAtom.getCommonElementSerialNumber(AS.Si.value);
		Assert.assertEquals("common serial", 5, en);
		en = CMLAtom.getCommonElementSerialNumber("Pt");
		Assert.assertEquals("common serial", -1, en);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLAtom.getDistanceTo(CMLAtom)'
	 */
	@Test
	public final void testGetDistanceTo() {
		// DSL
		double d = fixture.xomAtom[0].getDistanceTo(fixture.xomAtom[1]);
		Assert.assertEquals("distance", Math.sqrt(3.), d, EC.EPS);
		d = fixture.xomAtom[0].getDistanceTo(fixture.xomAtom[0]);
		Assert.assertEquals("distance", 0.0, d, EC.EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLAtom.getDistanceTo(CMLAtom)'
	 */
	@Test
	public final void testIsWithinRadiusSum() {
		// DSL
		CMLAtom atom0 = new CMLAtom("a0");
		atom0.setElementType(AS.C.value);
		CMLAtom atom1 = new CMLAtom("a1");
		atom1.setElementType(AS.O.value);
		boolean b = atom0.isWithinRadiusSum(atom1,
				ChemicalElement.RadiusType.VDW);
		Assert.assertFalse("sum", b);
		atom0.setPoint3(new Point3(0., 0., 0.), CoordinateType.CARTESIAN);
		atom1.setPoint3(new Point3(2., 0., 0.), CoordinateType.CARTESIAN);
		b = atom0.isWithinRadiusSum(atom1, ChemicalElement.RadiusType.VDW);
		Assert.assertTrue("sum", b);
		atom1.setPoint3(new Point3(4., 0., 0.), CoordinateType.CARTESIAN);
		b = atom0.isWithinRadiusSum(atom1, ChemicalElement.RadiusType.VDW);
		Assert.assertFalse("sum", b);

	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLAtom.roundCoords(double)'
	 */
	@Test
	public final void testRoundCoords() {
		// DSL
		CMLAtom atom = new CMLAtom();
		atom.setPoint3(new Point3(0.1009, 0.2021, -0.3011),
				CoordinateType.FRACTIONAL);
		Point3 p = atom.getPoint3(CoordinateType.FRACTIONAL);
		double[] test = new double[] { 0.1009, 0.2021,
				-0.3011 };
		Assert.assertNotNull("test should not be null (" + "getPoint3" + S_RBRAK, test);
		Assert.assertEquals("must be of length 3", 3, test.length);
		Assert.assertNotNull("ref should not be null (" + "getPoint3" + S_RBRAK,
				p);
		DoubleTestBase.assertEquals("getPoint3", test, p.getArray(), EC.EPS);
		atom
				.setPoint3(new Point3(1.001, 2.22, -3.13),
						CoordinateType.CARTESIAN);
		p = atom.getPoint3(CoordinateType.CARTESIAN);
		double[] test1 = new double[] { 1.001, 2.22, -3.13 };
		Assert.assertNotNull("test should not be null (" + "getPoint3" + S_RBRAK, test1);
		Assert.assertEquals("must be of length 3", 3, test1.length);
		Assert.assertNotNull("ref should not be null (" + "getPoint3" + S_RBRAK,
				p);
		DoubleTestBase.assertEquals("getPoint3", test1, p.getArray(), EC.EPS);

		double epsilon = 0.001;
		atom.roundCoords(epsilon, CoordinateType.FRACTIONAL);
		p = atom.getPoint3(CoordinateType.FRACTIONAL);
		double[] test2 = new double[] { 0.100, 0.202,
				-0.301 };
		Assert.assertNotNull("test should not be null (" + "getPoint3" + S_RBRAK, test2);
		Assert.assertEquals("must be of length 3", 3, test2.length);
		Assert.assertNotNull("ref should not be null (" + "getPoint3" + S_RBRAK,
				p);
		DoubleTestBase.assertEquals("getPoint3", test2, p.getArray(), EC.EPS);
		p = atom.getPoint3(CoordinateType.CARTESIAN);
		double[] test3 = new double[] { 1.001, 2.22, -3.13 };
		Assert.assertNotNull("test should not be null (" + "getPoint3" + S_RBRAK, test3);
		Assert.assertEquals("must be of length 3", 3, test3.length);
		Assert.assertNotNull("ref should not be null (" + "getPoint3" + S_RBRAK,
				p);
		DoubleTestBase.assertEquals("getPoint3", test3, p.getArray(), EC.EPS);
		epsilon = 0.1;
		atom.roundCoords(epsilon, CoordinateType.CARTESIAN);
		p = atom.getPoint3(CoordinateType.CARTESIAN);
		double[] test4 = new double[] { 1.0, 2.2, -3.1 };
		Assert.assertNotNull("test should not be null (" + "getPoint3" + S_RBRAK, test4);
		Assert.assertEquals("must be of length 3", 3, test4.length);
		Assert.assertNotNull("ref should not be null (" + "getPoint3" + S_RBRAK,
				p);
		DoubleTestBase.assertEquals("getPoint3", test4, p.getArray(), EC.EPS);
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLAtom.hasCoordinates(CoordinateType)'
	 */
	@Test
	public final void testHasCoordinates() {
		// DSL
		CMLAtom atom = new CMLAtom();
		Assert.assertFalse(atom.hasCoordinates(CoordinateType.CARTESIAN));
		Assert.assertFalse(atom.hasCoordinates(CoordinateType.FRACTIONAL));
		Assert.assertFalse(atom.hasCoordinates(CoordinateType.TWOD));

		atom.setPoint3(new Point3(0.1009, 0.2021, -0.3011),
				CoordinateType.FRACTIONAL);
		Assert.assertFalse(atom.hasCoordinates(CoordinateType.CARTESIAN));
		Assert.assertTrue(atom.hasCoordinates(CoordinateType.FRACTIONAL));
		Assert.assertFalse(atom.hasCoordinates(CoordinateType.TWOD));

		atom.setPoint3(new Point3(1.1009, 1.2021, -3.3011),
				CoordinateType.CARTESIAN);
		Assert.assertTrue(atom.hasCoordinates(CoordinateType.CARTESIAN));
		Assert.assertTrue(atom.hasCoordinates(CoordinateType.FRACTIONAL));
		Assert.assertFalse(atom.hasCoordinates(CoordinateType.TWOD));

		atom.setXY2(new Real2(11, 22));
		Assert.assertTrue(atom.hasCoordinates(CoordinateType.CARTESIAN));
		Assert.assertTrue(atom.hasCoordinates(CoordinateType.FRACTIONAL));
		Assert.assertTrue(atom.hasCoordinates(CoordinateType.TWOD));

		atom.removeAttribute("x2");
		atom.removeAttribute("y2");
		Assert.assertTrue("remove x2y2", atom
				.hasCoordinates(CoordinateType.CARTESIAN));
		Assert.assertTrue("remove x2y2", atom
				.hasCoordinates(CoordinateType.FRACTIONAL));
		Assert.assertFalse("remove x2y2", atom
				.hasCoordinates(CoordinateType.TWOD));
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLAtom.compareByAtomicNumber(CMLAtom)'
	 */
	@Test
	public final void testCompareByAtomicNumber() {
		// DSL
		CMLAtom atom1 = new CMLAtom();
		atom1.setElementType(AS.C.value);
		CMLAtom atom2 = new CMLAtom();
		atom2.setElementType(AS.N.value);
		Assert.assertEquals("compare", -1, atom1.compareByAtomicNumber(atom2));
		Assert.assertEquals("compare", 1, atom2.compareByAtomicNumber(atom1));
		Assert.assertEquals("compare", 0, atom2.compareByAtomicNumber(atom2));
	}

}
