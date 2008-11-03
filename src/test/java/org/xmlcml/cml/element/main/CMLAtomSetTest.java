package org.xmlcml.cml.element.main;

import static org.xmlcml.euclid.EuclidConstants.EPS;
import static org.xmlcml.euclid.EuclidConstants.S_EMPTY;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.xmlcml.cml.base.CMLElement.CoordinateType;
import org.xmlcml.cml.element.CMLAtom;
import org.xmlcml.cml.element.CMLAtomSet;
import org.xmlcml.cml.element.CMLFormula;
import org.xmlcml.cml.element.CMLLink;
import org.xmlcml.cml.element.CMLMap;
import org.xmlcml.cml.element.CMLMolecule;
import org.xmlcml.cml.element.CMLTransform3;
import org.xmlcml.cml.element.CMLMap.Direction;
import org.xmlcml.euclid.Angle;
import org.xmlcml.euclid.Point3;
import org.xmlcml.euclid.Point3Vector;
import org.xmlcml.euclid.Real2;
import org.xmlcml.euclid.Real2Vector;
import org.xmlcml.euclid.RealMatrix;
import org.xmlcml.euclid.Transform2;
import org.xmlcml.euclid.Vector3;
import org.xmlcml.euclid.test.Point3Test;
import org.xmlcml.euclid.test.Real2Test;
import org.xmlcml.euclid.test.Real2VectorTest;
import org.xmlcml.euclid.test.RealMatrixTest;
import org.xmlcml.molutil.ChemicalElement.AS;

/**
 * test CMLAtomSet
 * 
 * @author pmr
 * 
 */
public class CMLAtomSetTest {
	MoleculeAtomBondFixture fixture = new MoleculeAtomBondFixture();
	CMLAtomSet atomSet1 = null;

	CMLAtomSet atomSet2 = null;

	/**
	 * constructor.
	 */
	public CMLAtomSetTest() {
		super();
	}

	/**
	 * setup.
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		atomSet1 = new CMLAtomSet(fixture.xmlMolecule, new String[] { "a1",
				"a2", "a3" });
		atomSet2 = new CMLAtomSet(fixture.xmlMolecule, new String[] { "a2",
				"a3", "a4", "a5" });
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLAtomSet.CMLAtomSet()'
	 */
	@Test
	public void testCMLAtomSet() {
		CMLAtomSet xomAtomSet = new CMLAtomSet();
		Assert.assertNotNull("atom set creation", xomAtomSet);
		Assert.assertEquals("atom set size", 0, xomAtomSet.size());
		Assert.assertEquals("atom set ", new String[] { S_EMPTY }, xomAtomSet
				.getXMLContent());

	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLAtomSet.CMLAtomSet(CMLAtomSet)'
	 */
	@Test
	public void testCMLAtomSetCMLAtomSet() {
		CMLAtomSet xomAtomSet0 = new CMLAtomSet(fixture.xomMolecule,
				new String[] { "a1", "a3" });
		CMLAtomSet xomAtomSet = new CMLAtomSet(xomAtomSet0);
		Assert.assertNotNull("atom set creation", xomAtomSet);
		Assert.assertEquals("atom set size", 2, xomAtomSet.size());
		Assert.assertEquals("atom set ", new String[] { "a1", "a3" },
				xomAtomSet.getXMLContent());
		CMLAtom atom30 = xomAtomSet0.getAtomById("a3");
		CMLAtom atom3 = xomAtomSet.getAtomById("a3");
		Assert.assertSame("indexes are copied", atom30, atom3);
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLAtomSet.CMLAtomSet(CMLMolecule, String[])'
	 */
	@Test
	public void testCMLAtomSetCMLMoleculeStringArray() {
		final CMLAtomSet xomAtomSet = new CMLAtomSet(fixture.xomMolecule,
				new String[] { "a1", "a3" });
		Assert.assertNotNull("atom set creation", xomAtomSet);
		Assert.assertEquals("atom set size", 2, xomAtomSet.size());
		Assert.assertEquals("atom set ", new String[] { "a1", "a3" },
				xomAtomSet.getXMLContent());
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLAtomSet.CMLAtomSet(CMLMolecule)'
	 */
	@Test
	public void testCMLAtomSetCMLMolecule() {
		final CMLAtomSet xomAtomSet = new CMLAtomSet(fixture.xomMolecule);
		Assert.assertNotNull("atom set creation", xomAtomSet);
		Assert.assertEquals("atom set size", 5, xomAtomSet.size());
		Assert.assertEquals("atom set ", new String[] { "a1", "a2", "a3", "a4",
				"a5" }, xomAtomSet.getXMLContent());
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLAtomSet.CMLAtomSet(CMLAtom[])'
	 */
	@Test
	public void testCMLAtomSetCMLAtomArray() {
		final CMLAtomSet atomSet = new CMLAtomSet(fixture.xomAtom);
		Assert.assertEquals("atom set size", 5, atomSet.size());
		Assert.assertEquals("atom set value", new String[] { "a1", "a2", "a3",
				"a4", "a5" }, atomSet.getXMLContent());
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLAtomSet.addAtoms(CMLAtom[])'
	 */
	@Test
	@Deprecated
	public void testAddAtoms() {
		CMLAtomSet atomSet1 = new CMLAtomSet(new CMLAtom[] {
				fixture.xomAtom[0], fixture.xomAtom[2] });
		Assert.assertEquals("atom set size", 2, atomSet1.size());
		Assert.assertEquals("atom set value", new String[] { "a1", "a3" },
				atomSet1.getXMLContent());
		atomSet1.addAtoms(new CMLAtom[] { fixture.xomAtom[1],
				fixture.xomAtom[3] });
		Assert.assertEquals("atom set size", 4, atomSet1.size());
		Assert.assertEquals("atom set value", new String[] { "a1", "a3", "a2",
				"a4" }, atomSet1.getXMLContent());
		// includes duplicate atom
		atomSet1.addAtoms(new CMLAtom[] { fixture.xomAtom[3],
				fixture.xomAtom[4] });
		Assert.assertEquals("atom set size", 5, atomSet1.size());
		Assert.assertEquals("atom set value", new String[] { "a1", "a3", "a2",
				"a4", "a5" }, atomSet1.getXMLContent());
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLAtomSet.addAtom(CMLAtom)'
	 */
	@Test
	public void testAddAtom() {
		CMLAtomSet atomSet1 = new CMLAtomSet(new CMLAtom[] {
				fixture.xomAtom[0], fixture.xomAtom[2] });
		Assert.assertEquals("atom set size", 2, atomSet1.size());
		Assert.assertEquals("atom set value", new String[] { "a1", "a3" },
				atomSet1.getXMLContent());
		atomSet1.addAtom(fixture.xomAtom[1]);
		Assert.assertNotNull("atom set molecule", atomSet1.getMolecule());
		Assert.assertEquals("atom set molecule", fixture.xomAtom[0]
				.getMolecule(), atomSet1.getMolecule());
		Assert.assertEquals("atom set size", 3, atomSet1.size());
		Assert.assertEquals("atom set value",
				new String[] { "a1", "a3", "a2" }, atomSet1.getXMLContent());
		// includes duplicate atom
		atomSet1.addAtom(fixture.xomAtom[1]);
		Assert.assertEquals("atom set size", 3, atomSet1.size());
		Assert.assertEquals("atom set value",
				new String[] { "a1", "a3", "a2" }, atomSet1.getXMLContent());
		atomSet1.addAtom(fixture.xomAtom[4]);
		Assert.assertEquals("atom set size", 4, atomSet1.size());
		Assert.assertEquals("atom set value", new String[] { "a1", "a3", "a2",
				"a5" }, atomSet1.getXMLContent());

	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLAtomSet.addAtomSet(CMLAtomSet)'
	 */

	@Test
	public void testAddAtomSet() {
		final CMLAtomSet atomSet1 = new CMLAtomSet(new CMLAtom[] {
				fixture.xomAtom[0], fixture.xomAtom[2] });
		Assert.assertEquals("atom set size", 2, atomSet1.size());
		Assert.assertEquals("atom set value", new String[] { "a1", "a3" },
				atomSet1.getXMLContent());
		CMLAtomSet atomSet2 = new CMLAtomSet(new CMLAtom[] {
				fixture.xomAtom[1], fixture.xomAtom[3] });
		Assert.assertEquals("atom set size", 2, atomSet1.size());
		Assert.assertEquals("atom set value", new String[] { "a1", "a3" },
				atomSet1.getXMLContent());
		atomSet1.addAtomSet(atomSet2);
		Assert.assertEquals("atom set size", 4, atomSet1.size());
		Assert.assertEquals("atom set value", new String[] { "a1", "a3", "a2",
				"a4" }, atomSet1.getXMLContent());
		// includes duplicate atomSet
		atomSet1.addAtomSet(atomSet2);
		Assert.assertEquals("atom set size", 4, atomSet1.size());
		Assert.assertEquals("atom set value", new String[] { "a1", "a3", "a2",
				"a4" }, atomSet1.getXMLContent());

	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLAtomSet.getAtoms()'
	 */
	@Test
	public void testGetAtoms() {
		CMLAtomSet atomSet1 = new CMLAtomSet(new CMLAtom[] {
				fixture.xomAtom[0], fixture.xomAtom[2] });
		Assert.assertEquals("atom set size", 2, atomSet1.size());
		Assert.assertEquals("atom set value", new String[] { "a1", "a3" },
				atomSet1.getXMLContent());
		List<CMLAtom> atoms = atomSet1.getAtoms();
		Assert.assertEquals("atoms size", 2, atoms.size());
		Assert.assertEquals("atom", fixture.xomAtom[0], (CMLAtom) atoms.get(0));
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLAtomSet.size()'
	 */
	@Test
	public void testSize() {
		CMLAtomSet atomSet1 = new CMLAtomSet(new CMLAtom[] {
				fixture.xomAtom[0], fixture.xomAtom[2] });
		Assert.assertEquals("atom set size", 2, atomSet1.size());
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLAtomSet.getAtomIDs()'
	 */
	@Test
	public void testGetAtomIDs() {
		CMLAtomSet atomSet1 = new CMLAtomSet(new CMLAtom[] {
				fixture.xomAtom[0], fixture.xomAtom[2] });
		Assert.assertEquals("atom ids", new String[] { "a1", "a3" }, atomSet1
				.getAtomIDs());
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLAtomSet.getAtomSetById(String[])'
	 */
	@Test
	public void testGetAtomSetById() {
		CMLAtomSet atomSet1 = new CMLAtomSet(fixture.xomAtom);
		List<String> atoms = new ArrayList<String>();
		atoms.add("a2");
		atoms.add("a4");
		CMLAtomSet atomSet2 = atomSet1.getAtomSetById(atoms);
		Assert.assertEquals("atom set by id", 2, atomSet2.size());
		Assert.assertEquals("atom set by id", fixture.xomAtom[3].getId(),
				((CMLAtom) atomSet2.getAtoms().get(1)).getId());
		Assert.assertEquals("atom set by id", fixture.xomAtom[3],
				(CMLAtom) atomSet2.getAtoms().get(1));
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLAtomSet.getAtomSetByElementType(String)'
	 */
	@Test
	public void testGetAtomSetByElementType() {
		CMLAtomSet atomSet1 = new CMLAtomSet(fixture.xomAtom);
		CMLAtomSet atomSet2 = atomSet1.getAtomSetByElementType(AS.N.value);
		Assert.assertEquals("atom set by element", 1, atomSet2.size());
		Assert.assertEquals("atom set by element", "a2", ((CMLAtom) atomSet2
				.getAtom(0)).getId());
		CMLAtomSet atomSet3 = atomSet1.getAtomSetByElementType(AS.B.value);
		Assert.assertEquals("atom set by element", 1, atomSet3.size());
		Assert.assertEquals("atom set by element", "a5", ((CMLAtom) atomSet3
				.getAtom(0)).getId());

	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLAtomSet.getAtomById(String)'
	 */
	@Test
	public void testGetAtomById() {
		CMLAtomSet atomSet1 = new CMLAtomSet(fixture.xomAtom);
		CMLAtom atom = atomSet1.getAtomById("a2");
		Assert.assertEquals("atom by id", fixture.xomAtom[1], atom);
		atom = atomSet1.getAtomById("a5");
		Assert.assertEquals("atom by id", fixture.xomAtom[4], atom);
		atom = atomSet1.getAtomById("a99");
		Assert.assertNull("atom by id", atom);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLAtomSet.contains(CMLAtom)'
	 */
	@Test
	public void testContains() {
		CMLAtomSet atomSet = new CMLAtomSet(fixture.xomAtom);
		boolean contains = atomSet.contains(fixture.xomAtom[1]);
		Assert.assertTrue("atom contains", contains);
		contains = atomSet.contains(fixture.xmlAtom[1]);
		Assert.assertFalse("atom contains", contains);

	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLAtomSet.removeAtom(CMLAtom)'
	 */
	@Test
	public void testRemoveAtom() {
		CMLAtomSet atomSet = new CMLAtomSet(fixture.xomAtom);
		atomSet.removeAtom(fixture.xomAtom[1]);
		Assert.assertEquals("atom contains", 4, atomSet.size());
		Assert.assertEquals("atom contains", new String[] { "a1", "a3", "a4",
				"a5" }, atomSet.getAtomIDs());
		// delete non-existent
		try {
			atomSet.removeAtom(fixture.xomAtom[1]);
			Assert.fail("Should throw CMLRuntime");
		} catch (RuntimeException e) {
			Assert.assertEquals("atom contains",
					"atom not in set:a2:a1/a3/a4/a5", e.getMessage());
		}
		atomSet.removeAtom(fixture.xomAtom[3]);
		Assert.assertEquals("atom contains", 3, atomSet.size());
		Assert.assertEquals("atom contains", new String[] { "a1", "a3", "a5" },
				atomSet.getAtomIDs());
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLAtomSet.removeAtomById(String)'
	 */
	@Test
	public void testRemoveAtomById() {
		CMLAtomSet atomSet = new CMLAtomSet(fixture.xomAtom);
		atomSet.removeAtomById("a2");
		Assert.assertEquals("atom contains", 4, atomSet.size());
		Assert.assertEquals("atom contains", new String[] { "a1", "a3", "a4",
				"a5" }, atomSet.getAtomIDs());
		// delete non-existent; is no-op
		atomSet.removeAtomById("a10");
		Assert.assertEquals("atom contains", 4, atomSet.size());
		Assert.assertEquals("atom contains", new String[] { "a1", "a3", "a4",
				"a5" }, atomSet.getAtomIDs());
		atomSet.removeAtomById("a4");
		Assert.assertEquals("atom contains", 3, atomSet.size());
		Assert.assertEquals("atom contains", new String[] { "a1", "a3", "a5" },
				atomSet.getAtomIDs());

	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLAtomSet.removeAtomSet(CMLAtomSet)'
	 */
	@Test
	public void testRemoveAtomSet() {
		CMLAtomSet atomSet1 = new CMLAtomSet(new CMLAtom[] {
				fixture.xomAtom[0], fixture.xomAtom[2] });
		Assert.assertEquals("atom set size", 2, atomSet1.size());
		Assert.assertEquals("atom set value", new String[] { "a1", "a3" },
				atomSet1.getXMLContent());
		CMLAtomSet atomSet2 = new CMLAtomSet(new CMLAtom[] {
				fixture.xomAtom[0], fixture.xomAtom[3] });
		Assert.assertEquals("atom set size", 2, atomSet2.size());
		Assert.assertEquals("atom set value", new String[] { "a1", "a4" },
				atomSet2.getXMLContent());
		atomSet1.removeAtomSet(atomSet2);
		Assert.assertEquals("atom set size", 1, atomSet1.size());
		Assert.assertEquals("atom set value", new String[] { "a3" }, atomSet1
				.getXMLContent());
		// atomSet2 unaltered?
		Assert.assertEquals("atom set size", 2, atomSet2.size());
		Assert.assertEquals("atom set value", new String[] { "a1", "a4" },
				atomSet2.getXMLContent());
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLAtomSet.getVector3D()'
	 */
	@Test
	public void testGetVector3D() {
		CMLAtomSet atomSet = new CMLAtomSet(fixture.xomAtom);
		Point3 point3 = ((CMLAtom) atomSet.getAtom(1)).getXYZ3();
		Assert.assertNotNull("point 3d", point3);
		double x = ((CMLAtom) atomSet.getAtom(1)).getX3();
		Assert.assertEquals("point 3d x", 1.0, x);
		Assert.assertEquals("point 3d x", 1.0, point3.getArray()[0]);
		double y = ((CMLAtom) atomSet.getAtom(1)).getY3();
		Assert.assertEquals("point 3d y", 2.0, y);
		Assert.assertEquals("point 3d y", 2.0, point3.getArray()[1]);
		double z = ((CMLAtom) atomSet.getAtom(1)).getZ3();
		Assert.assertEquals("point 3d z", 3.0, z);
		Assert.assertEquals("point 3d z", 3.0, point3.getArray()[2]);
		Point3Vector p3 = atomSet.getCoordinates3(CoordinateType.CARTESIAN);

		Assert.assertNotNull("vector 3d", p3);
		Assert.assertEquals("vector 3d", 5, p3.size());
		point3 = (Point3) p3.get(1);
		Assert.assertNotNull("vector 3d", point3);
		Assert.assertEquals("point 3d z", 3.0, point3.getArray()[2]);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLAtomSet.translate3D(Vector3)'
	 */
	@Test
	public void testTranslate3D() {
		CMLAtomSet atomSet = new CMLAtomSet(fixture.xomAtom);
		Vector3 v3 = new Vector3(10., 20., 30.);
		atomSet.translate3D(v3);
		Point3 p = ((CMLAtom) atomSet.getAtom(1)).getXYZ3();
		Assert.assertNotNull("vector 3d", p);
		Assert.assertEquals("point 3d x", 11.0, p.getArray()[0]);
		Assert.assertEquals("point 3d y", 22.0, p.getArray()[1]);
		Assert.assertEquals("point 3d z", 33.0, p.getArray()[2]);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLAtomSet.getCentroid3D()'
	 */
	@Test
	public void testGetCentroid3D() {
		CMLAtomSet atomSet = new CMLAtomSet(fixture.xomAtom);
		Point3 p3 = atomSet.getCentroid3(CoordinateType.CARTESIAN);
		Assert.assertNotNull("vector 3d", p3);
		Assert.assertEquals("point 3d x", 2.0, p3.getArray()[0]);
		Assert.assertEquals("point 3d y", 3.0, p3.getArray()[1]);
		Assert.assertEquals("point 3d z", 4.0, p3.getArray()[2]);

	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLAtomSet.getMolecule()'
	 */
	@Test
	public void testGetMolecule() {
		CMLAtomSet atomSet = new CMLAtomSet(fixture.xomAtom);
		CMLMolecule molecule = atomSet.getMolecule();
		Assert.assertNotNull("get molecule", molecule);
		Assert.assertEquals("molecule ", fixture.xomMolecule, molecule);

	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLAtomSet.transform(Transform2)'
	 */
	@Test
	public void testTransform() {
		List<Real2> coords = new CMLAtomSet(fixture.xmlMolecule).getVector2D();
		Real2Vector r2v = new Real2Vector(coords);
		Real2VectorTest.assertEquals("r2v", new double[] { 0.0, 0.0, 1.0, 1.0,
				1.0, -1.0, -1.0, -1.0, -1.0, 1.0 }, r2v, EPS);
		Transform2 t = new Transform2(new Angle(Math.PI / 2.));
		atomSet1.transform(t);
		coords = new CMLAtomSet(fixture.xmlMolecule).getVector2D();
		r2v = new Real2Vector(coords);
		Real2VectorTest.assertEquals("r2v", new double[] { 0.0, 0.0, 1.0, -1.0,
				-1.0, -1.0,
				// notice these are mot transformed
				-1.0, -1.0, -1.0, 1.0 }, r2v, EPS);
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLAtomSet.excludeElementTypes(String[])'
	 */
	@Test
	public void testExcludeElementTypes() {
		CMLAtomSet atomSet = new CMLAtomSet(fixture.xomAtom);
		Assert.assertEquals("exclude", fixture.xomMolecule, atomSet
				.getMolecule());
		CMLAtomSet atomSet1 = atomSet.excludeElementTypes(new String[] {
				AS.N.value, AS.S.value });
		Assert.assertEquals("exclude", fixture.xomMolecule, atomSet1
				.getMolecule());
		Assert.assertEquals("excludeElementTypes", 3, atomSet1.size());
		Assert.assertEquals("excludeElementTypes", new String[] { "a1", "a3",
				"a5" }, atomSet1.getAtomIDs());
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLAtomSet.compareTo(CMLAtomSet)'
	 */
	@Test
	public void testCompareToCMLAtomSet() {
		Assert.assertEquals("compare", 0, atomSet1.compareTo(atomSet1));
		Assert.assertEquals("compare", -1, atomSet1.compareTo(atomSet2));
		Assert.assertEquals("compare", 1, atomSet2.compareTo(atomSet1));
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLAtomSet.includeElementTypes(String[])'
	 */
	@Test
	public void testIncludeElementTypes() {
		CMLAtomSet atomSet = new CMLAtomSet(fixture.xomAtom);
		Assert.assertEquals("exclude", fixture.xomMolecule, atomSet
				.getMolecule());
		CMLAtomSet atomSet1 = atomSet.includeElementTypes(new String[] {
				AS.N.value, AS.S.value });
		Assert.assertEquals("exclude", fixture.xomMolecule, atomSet1
				.getMolecule());
		Assert.assertEquals("excludeElementTypes", 2, atomSet1.size());
		Assert.assertEquals("excludeElementTypes", new String[] { "a2", "a4" },
				atomSet1.getAtomIDs());
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLAtomSet.getCalculatedFormula(String)'
	 */
	@Test
	public void testGetCalculatedFormula() {
		CMLAtomSet atomSet = new CMLAtomSet(fixture.xomAtom);
		CMLFormula formula = null;
		try {
			formula = atomSet
					.getCalculatedFormula(CMLMolecule.HydrogenControl.USE_HYDROGEN_COUNT);
			Assert.assertEquals("formula", "C 1 H 4 B 1 N 1 O 1 S 1", formula
					.getConcise());
		} catch (RuntimeException e) {
			Assert.fail("KNOWN BUG WITH FORMULA " + e);
		}
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLAtomSet.getCalculatedFormalCharge()'
	 */
	@Test
	public void testGetCalculatedFormalCharge() {
		CMLAtomSet atomSet = new CMLAtomSet(fixture.xomAtom);
		int ch = atomSet.getCalculatedFormalCharge();
		Assert.assertEquals("formula", 0, ch);
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLAtomSet.intersection(CMLAtomSet)'
	 */
	@Test
	public void testIntersection() {
		CMLAtomSet atomSet1 = new CMLAtomSet(new CMLAtom[] {
				fixture.xomAtom[0], fixture.xomAtom[1], fixture.xomAtom[2] });
		Assert.assertEquals("atom set size", 3, atomSet1.size());
		Assert.assertEquals("atom set value",
				new String[] { "a1", "a2", "a3" }, atomSet1.getXMLContent());
		CMLAtomSet atomSet2 = new CMLAtomSet(new CMLAtom[] {
				fixture.xomAtom[1], fixture.xomAtom[2], fixture.xomAtom[3] });
		Assert.assertEquals("atom set size", 3, atomSet1.size());
		Assert.assertEquals("atom set value",
				new String[] { "a2", "a3", "a4" }, atomSet2.getXMLContent());
		CMLAtomSet atomSet3 = atomSet1.intersection(atomSet2);
		Assert.assertEquals("atom set size", 2, atomSet3.size());
		Assert.assertEquals("atom set value", new String[] { "a2", "a3" },
				atomSet3.getXMLContent());

	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLAtomSet.compliment(CMLAtomSet)'
	 */
	@Test
	public void testComplement() {
		CMLAtomSet atomSet1 = new CMLAtomSet(new CMLAtom[] {
				fixture.xomAtom[0], fixture.xomAtom[1], fixture.xomAtom[2] });
		Assert.assertEquals("atom set size", 3, atomSet1.size());
		Assert.assertEquals("atom set value",
				new String[] { "a1", "a2", "a3" }, atomSet1.getXMLContent());
		CMLAtomSet atomSet2 = new CMLAtomSet(new CMLAtom[] {
				fixture.xomAtom[1], fixture.xomAtom[2], fixture.xomAtom[3] });
		Assert.assertEquals("atom set size", 3, atomSet1.size());
		Assert.assertEquals("atom set value",
				new String[] { "a2", "a3", "a4" }, atomSet2.getXMLContent());
		CMLAtomSet atomSet3 = atomSet1.complement(atomSet2);
		Assert.assertEquals("atom set size", 1, atomSet3.size());
		Assert.assertEquals("atom set value", new String[] { "a1" }, atomSet3
				.getXMLContent());

	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLAtomSet.compliment(CMLAtomSet)'
	 */
	@Test
	public void testHasContentEqualTo() {
		CMLAtomSet atomSet1 = new CMLAtomSet(new CMLAtom[] {
				fixture.xomAtom[0], fixture.xomAtom[1], fixture.xomAtom[2] });
		CMLAtomSet atomSet2 = new CMLAtomSet(new CMLAtom[] {
				fixture.xomAtom[1], fixture.xomAtom[2], fixture.xomAtom[0] });
		Assert.assertTrue("atom set equal", atomSet1
				.hasContentEqualTo(atomSet2));
		atomSet2 = new CMLAtomSet(new CMLAtom[] { fixture.xomAtom[1],
				fixture.xomAtom[1] });
		Assert.assertFalse("atom set not equal", atomSet1
				.hasContentEqualTo(atomSet2));
		atomSet2 = null;
		Assert.assertFalse("atom set not equal", atomSet1
				.hasContentEqualTo(atomSet2));
		atomSet1 = new CMLAtomSet();
		atomSet2 = new CMLAtomSet();
		Assert.assertTrue("atom set equal", atomSet1
				.hasContentEqualTo(atomSet2));
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLAtomSet.union(CMLAtomSet)'
	 */
	@Test
	public void testUnion() {
		CMLAtomSet atomSet1 = new CMLAtomSet(new CMLAtom[] {
				fixture.xomAtom[0], fixture.xomAtom[1], fixture.xomAtom[2] });
		Assert.assertEquals("atom set size", 3, atomSet1.size());
		Assert.assertEquals("atom set value",
				new String[] { "a1", "a2", "a3" }, atomSet1.getXMLContent());
		CMLAtomSet atomSet2 = new CMLAtomSet(new CMLAtom[] {
				fixture.xomAtom[1], fixture.xomAtom[2], fixture.xomAtom[3] });
		Assert.assertEquals("atom set size", 3, atomSet1.size());
		Assert.assertEquals("atom set value",
				new String[] { "a2", "a3", "a4" }, atomSet2.getXMLContent());
		CMLAtomSet atomSet3 = atomSet1.union(atomSet2);
		Assert.assertEquals("atom set size", 4, atomSet3.size());
		Assert.assertEquals("atom set value", new String[] { "a1", "a2", "a3",
				"a4" }, atomSet3.getXMLContent());

	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLAtomSet.symmetricDifference(CMLAtomSet)'
	 */
	@Test
	public void testSymmetricDifference() {
		CMLAtomSet atomSet = atomSet1.symmetricDifference(atomSet2);
		Assert.assertEquals("symmetric", new String[] { "a1", "a4", "a5" },
				atomSet.getXMLContent());
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLAtomSet.intersectionByAtomId(CMLAtomSet)'
	 */
	@Test
	public void testIntersectionByAtomId() {
		String[] atoms = atomSet1.intersectionByAtomId(atomSet2);
		Assert.assertEquals("symmetric", new String[] { "a2", "a3" }, atoms);
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLAtomSet.complimentByAtomId(CMLAtomSet)'
	 */
	@Test
	public void testComplimentByAtomId() {
		String[] atoms = atomSet1.complementByAtomId(atomSet2);
		Assert.assertEquals("compliment", new String[] { "a1" }, atoms);
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLAtomSet.unionByAtomId(CMLAtomSet)'
	 */
	@Test
	public void testUnionByAtomId() {
		String[] atoms = atomSet1.unionByAtomId(atomSet2);
		Assert.assertEquals("union", new String[] { "a1", "a2", "a3", "a4",
				"a5" }, atoms);
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLAtomSet.symmetricDifferenceByAtomId(CMLAtomSet
	 * ) '
	 */
	@Test
	public void testSymmetricDifferenceByAtomId() {
		String[] atoms = atomSet1.symmetricDifferenceByAtomId(atomSet2);
		Assert.assertEquals("symmetricDifferenceByAtomId", new String[] { "a1",
				"a4", "a5" }, atoms);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLAtomSet.getVector2D()'
	 */
	@Test
	public void testGetVector2D() {
		List<Real2> coords = atomSet1.getVector2D();
		Assert.assertEquals("coords", 3, coords.size());
		Assert.assertEquals("coords", 0.0, coords.get(0).getX(), EPS);
		Assert.assertEquals("coords", 0.0, coords.get(0).getY(), EPS);
		Assert.assertEquals("coords", 1.0, coords.get(1).getX(), EPS);
		Assert.assertEquals("coords", 1.0, coords.get(1).getY(), EPS);
		Assert.assertEquals("coords", 1.0, coords.get(2).getX(), EPS);
		Assert.assertEquals("coords", -1.0, coords.get(2).getY(), EPS);
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLAtomSet.setVector2D(Real2Vector)'
	 */
	@Test
	public void testSetVector2D() {
		Real2Vector v = new Real2Vector(new CMLAtomSet(fixture.xmlMolecule)
				.getVector2D());
		Real2VectorTest.assertEquals("r2v", new double[] { 0.0, 0.0, 1.0, 1.0,
				1.0, -1.0, -1.0, -1.0, -1.0, 1.0 }, v, EPS);
		List<Real2> v1 = new ArrayList<Real2>();
		v1.add(new Real2(4., 5.));
		v1.add(new Real2(6., 7.));
		v1.add(new Real2(8., 9.));
		atomSet1.setVector2D(v1);
		v = new Real2Vector(new CMLAtomSet(fixture.xmlMolecule).getVector2D());
		Real2VectorTest.assertEquals("r2v", new double[] { 4.0, 5.0, 6.0, 7.0,
				8.0, 9.0, -1.0, -1.0, -1.0, 1.0 }, v, EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLAtomSet.translate2D(Real2)'
	 */
	@Test
	public void testTranslate2D() {
		atomSet1.translate2D(new Real2(10., 20.));
		CMLAtomSet atomSet = new CMLAtomSet(fixture.xmlMolecule);
		List<Real2> coords = atomSet.getVector2D();
		Assert.assertEquals("coords", 5, coords.size());
		Assert.assertEquals("coords", 10.0, coords.get(0).getX(), EPS);
		Assert.assertEquals("coords", 20.0, coords.get(0).getY(), EPS);
		Assert.assertEquals("coords", 11.0, coords.get(1).getX(), EPS);
		Assert.assertEquals("coords", 21.0, coords.get(1).getY(), EPS);
		Assert.assertEquals("coords", 11.0, coords.get(2).getX(), EPS);
		Assert.assertEquals("coords", 19.0, coords.get(2).getY(), EPS);
		Assert.assertEquals("coords", -1.0, coords.get(3).getX(), EPS);
		Assert.assertEquals("coords", -1.0, coords.get(3).getY(), EPS);
		Assert.assertEquals("coords", -1.0, coords.get(4).getX(), EPS);
		Assert.assertEquals("coords", 1.0, coords.get(4).getY(), EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLAtomSet.getCentroid2D()'
	 */
	@Test
	public void testGetCentroid2D() {
		Real2 centroid = atomSet1.getCentroid2D();
		Assert.assertEquals("centroid", 2. / 3., centroid.getX());
		Assert.assertEquals("centroid", 0.0, centroid.getY());
		CMLAtomSet atomSet = new CMLAtomSet(fixture.xmlMolecule);
		centroid = atomSet.getCentroid2D();
		Assert.assertEquals("centroid", 0.0, centroid.getX());
		Assert.assertEquals("centroid", 0.0, centroid.getY());
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLAtomSet.transform(Transform3)'
	 */
	@Test
	public void testTransformTransform3() {
		CMLAtom atom0 = new CMLAtom();
		atom0.setXYZ3(new Point3(1.0, 2.0, 3.0));
		atom0.setXYZFract(new Point3(0.1, 0.2, 0.3));
		CMLTransform3 tr = new CMLTransform3(new double[] { 1, 0, 0, 0, 0, -1,
				0, 0, 0, 0, -1, 0, 0, 0, 0, 1 });
		CMLAtom atom = new CMLAtom(atom0);
		atom.transformCartesians(tr.getEuclidTransform3());
		Point3Test.assertEquals("transform", new double[] { 1, -2, -3 }, atom
				.getXYZ3(), EPS);
		// check no corruption
		Point3Test.assertEquals("transform", new double[] { 0.1, 0.2, 0.3 },
				atom.getXYZFract(), EPS);
		tr = new CMLTransform3(new double[] { 10, 0, 0, 0, 0, 20, 0, 0, 0, 0,
				30, 0, 0, 0, 0, 1 });
		atom = new CMLAtom(atom0);
		atom.transformCartesians(tr.getEuclidTransform3());
		Point3Test.assertEquals("transform", new double[] { 10, 40, 90 }, atom
				.getXYZ3(), EPS);
		tr = new CMLTransform3(new double[] { 0, 0, -1, 0, -1, 0, 0, 0, 0, -1,
				0, 0, 0, 0, 0, 1 });
		atom = new CMLAtom(atom0);
		atom.transformCartesians(tr.getEuclidTransform3());
		Point3Test.assertEquals("transform", new double[] { -3, -1, -2 }, atom
				.getXYZ3(), EPS);
		tr = new CMLTransform3(new double[] { 0, 0, 1, 0, -1, 0, 0, 0, 0, -1,
				0, 0, 0, 0, 0, 1 });
		atom = new CMLAtom(atom0);
		atom.transformCartesians(tr.getEuclidTransform3());
		Point3Test.assertEquals("transform", new double[] { 3, -1, -2 }, atom
				.getXYZ3(), EPS);
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLAtomSet.transformFractionalCoordinates(Transfo
	 * r m 3 ) '
	 */
	@Test
	public void testTransformFractionalCoordinatesTransform3() {
		CMLAtom atom0 = new CMLAtom();
		atom0.setXYZ3(new Point3(1.0, 2.0, 3.0));
		atom0.setXYZFract(new Point3(0.1, 0.2, 0.3));
		CMLTransform3 tr = new CMLTransform3(new double[] { 1, 0, 0, 0, 0, -1,
				0, 0, 0, 0, -1, 0, 0, 0, 0, 1 });
		CMLAtom atom = new CMLAtom(atom0);
		atom.transformFractionals(tr.getEuclidTransform3());
		// check no corruption
		Point3Test.assertEquals("transform", new double[] { 1, 2, 3 }, atom
				.getXYZ3(), EPS);
		Point3Test.assertEquals("transform", new double[] { 0.1, -0.2, -0.3 },
				atom.getXYZFract(), EPS);
		tr = new CMLTransform3(new double[] { 1, 0, 0, 0.5, 0, -1, 0, 0.5, 0,
				0, -1, 0.25, 0, 0, 0, 1 });
		atom = new CMLAtom(atom0);
		atom.transformFractionals(tr.getEuclidTransform3());
		Point3Test.assertEquals("transform", new double[] { 0.6, 0.3, -0.05 },
				atom.getXYZFract(), EPS);
		tr = new CMLTransform3(new double[] { 1, 1, 0, 0.5, -1, 0, 0, 0.5, 0,
				0, 1, 0.25, 0, 0, 0, 1 });
		atom = new CMLAtom(atom0);
		atom.transformFractionals(tr.getEuclidTransform3());
		Point3Test.assertEquals("transform", new double[] { 0.8, 0.4, 0.55 },
				atom.getXYZFract(), EPS);
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLAtomSet.overlap2DCentroids(CMLAtomSet)'
	 */
	@Test
	public void testOverlap2DCentroids() {
		CMLMolecule mol1 = new CMLMolecule(fixture.xmlMolecule);
		CMLAtomSet as1 = new CMLAtomSet(mol1);
		Real2 delta = atomSet1.overlap2DCentroids(as1);
		Real2Test.assertEquals("overlap centroid", new double[] { 2. / 3, 0 },
				delta, EPS);
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLAtomSet.getDistanceMatrix(CMLAtomSet)'
	 */
	@Test
	public void testGetDistanceMatrix() {
		double s2 = Math.sqrt(2.);
		RealMatrix rm = atomSet1.getDistanceMatrix(atomSet2);
		RealMatrixTest.assertEquals("distance matrix", 3, 4, new double[] { s2,
				s2, s2, s2, 0.0, 2.0, 2 * s2, 2.0, 2.0, 0.0, 2.0, 2 * s2 }, rm,
				EPS);
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLAtomSet.setChemicalElements(String)'
	 */
	@Test
	public void testSetChemicalElements() {
		atomSet1.setChemicalElements(AS.P.value);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLAtomSet.labelAtoms(String)'
	 */
	@Test
	public void testLabelAtoms() {
		// this labels all atoms in atomSet1 in xmlMolecule with child label
		atomSet1.labelAtoms("atomLabel");
		CMLMolecule xmlMolecule = fixture.xmlMolecule;
		Assert.assertEquals("label", 1, xmlMolecule.getAtomById("a1")
				.getLabelElements().size());
		Assert.assertEquals("label", 1, xmlMolecule.getAtomById("a2")
				.getLabelElements().size());
		Assert.assertEquals("label", 1, xmlMolecule.getAtomById("a3")
				.getLabelElements().size());
		Assert.assertEquals("label", 0, xmlMolecule.getAtomById("a4")
				.getLabelElements().size());
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLAtomSet.getMap(CMLAtomSet)'
	 */
	@Test
	public void testGetMap() {
		CMLAtomSet as1 = new CMLAtomSet(fixture.xmlMolecule, new String[] {
				"a1", "a2", "a3", "a4" });
		CMLAtomSet as2 = new CMLAtomSet(fixture.xmlMolecule, new String[] {
				"a5", "a3", "a2", "a1" });
		CMLMap m = as1.getMap(as2);
		Assert
				.assertEquals("map", 4, m.getChildCMLElements(CMLLink.TAG)
						.size());
		CMLLink l1 = (CMLLink) m.getChildCMLElement(CMLLink.TAG, 0);
		Assert.assertEquals("link from", "a1", l1.getFrom());
		Assert.assertEquals("link from", "a5", l1.getTo());
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLAtomSet.splitByElements()'
	 */
	@Test
	public void testSplitByElements() {
		Map<String, CMLAtomSet> map = atomSet2.splitByElements();
		Assert.assertEquals("map", 4, map.size());
		Assert
				.assertEquals("map", "a3", map.get(AS.S.value)
						.getStringContent());
		Assert
				.assertEquals("map", "a4", map.get(AS.O.value)
						.getStringContent());
		Assert
				.assertEquals("map", "a5", map.get(AS.F.value)
						.getStringContent());
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLAtomSet.CMLAtomSet(List<CMLAtom>)'
	 */
	@Test
	public final void testCMLAtomSetListOfCMLAtom() {
		List<CMLAtom> atomList = new ArrayList<CMLAtom>();
		atomList.add(fixture.xmlMolecule.getAtom(0));
		atomList.add(fixture.xmlMolecule.getAtom(1));
		CMLAtomSet atomSet = CMLAtomSet.createFromAtoms(atomList);
		Assert.assertEquals("atom set constructor",
				new String[] { "a1", "a2" }, atomSet.getXMLContent());
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLAtomSet.CMLAtomSet(Set<CMLAtom>)'
	 */
	@Test
	public final void testCMLAtomSetSetOfCMLAtom() {
		Set<CMLAtom> atomSet = new HashSet<CMLAtom>();
		atomSet.add(fixture.xmlMolecule.getAtom(0));
		atomSet.add(fixture.xmlMolecule.getAtom(1));
		CMLAtomSet atomSet1 = new CMLAtomSet(atomSet);
		Assert
				.assertNotNull("atom set constructor", atomSet1
						.getAtomById("a1"));
		Assert.assertNull("atom set constructor", atomSet1.getAtomById("a3"));
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLAtomSet.addAtoms(CMLAtom[])'
	 */
	@Test
	@Deprecated
	public final void testAddAtomsCMLAtomArray() {
		CMLAtomSet atomSet = new CMLAtomSet();
		CMLAtom[] atoms = new CMLAtom[2];
		atoms[0] = fixture.xmlMolecule.getAtom(0);
		atoms[1] = fixture.xmlMolecule.getAtom(1);
		atomSet.addAtoms(atoms);
		Assert.assertNotNull("atom set constructor", atomSet.getAtomById("a1"));
		Assert.assertNull("atom set constructor", atomSet.getAtomById("a3"));
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLAtomSet.addAtoms(List<CMLAtom>)'
	 */
	@Test
	public final void testAddAtomsListOfCMLAtom() {
		CMLAtomSet atomSet = new CMLAtomSet();
		List<CMLAtom> atomList = new ArrayList<CMLAtom>();
		atomList.add(fixture.xmlMolecule.getAtom(0));
		atomList.add(fixture.xmlMolecule.getAtom(1));
		atomSet.addAtoms(atomList);
		Assert.assertNotNull("atom set constructor", atomSet.getAtomById("a1"));
		Assert.assertNull("atom set constructor", atomSet.getAtomById("a3"));
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLAtomSet.getCoordinates3(CoordinateType)'
	 */
	@Test
	public final void testGetCoordinates3() {
		Point3Vector p3v = atomSet1.getCoordinates3(CoordinateType.CARTESIAN);
		Assert.assertEquals("point3vector", 3, p3v.size());
		Point3Test.assertEquals("point3vector", new double[] { 0.0, 0.0, 0.0 },
				p3v.get(0), EPS);
		Point3Test.assertEquals("point3vector", new double[] { 1.0, 1.0, 1.0 },
				p3v.get(1), EPS);
		Point3Test.assertEquals("point3vector",
				new double[] { 1.0, -1.0, -1.0 }, p3v.get(2), EPS);

		p3v = atomSet1.getCoordinates3(CoordinateType.FRACTIONAL);
		Assert.assertNull("point3vector", p3v);

	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLAtomSet.getCentroid3(CoordinateType)'
	 */
	@Test
	public final void testGetCentroid3() {
		Point3 cent = atomSet1.getCentroid3(CoordinateType.CARTESIAN);
		Point3Test.assertEquals("centroid", new double[] { 2. / 3., 0.0, 0.0 },
				cent, EPS);
		cent = atomSet1.getCentroid3(CoordinateType.FRACTIONAL);
		Assert.assertNull("centroid", cent);

	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLAtomSet.transform(Transform2)'
	 */
	@Test
	public final void testTransformTransform2() {
		List<Real2> r2v = atomSet1.getVector2D();
		Assert.assertEquals("real2vector", 3, r2v.size());
		Real2Test.assertEquals("real2vector", new double[] { 0.0, 0.0 }, r2v
				.get(0), EPS);
		Real2Test.assertEquals("real2vector", new double[] { 1.0, 1.0 }, r2v
				.get(1), EPS);
		Real2Test.assertEquals("real2vector", new double[] { 1.0, -1.0 }, r2v
				.get(2), EPS);

		Angle zrot = new Angle(Math.PI / 2.);
		Transform2 t = new Transform2(zrot);
		atomSet1.transform(t);

		r2v = atomSet1.getVector2D();
		Assert.assertEquals("real2vector", 3, r2v.size());
		Real2Test.assertEquals("real2vector", new double[] { 0.0, 0.0 }, r2v
				.get(0), EPS);
		Real2Test.assertEquals("real2vector", new double[] { 1.0, -1.0 }, r2v
				.get(1), EPS);
		Real2Test.assertEquals("real2vector", new double[] { -1.0, -1.0 }, r2v
				.get(2), EPS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLAtomSet.getMappedAtom(CMLMap,
	 * CMLAtom, Direction)'
	 */
	@Test
	public final void testGetMappedAtom() {
		CMLMap map = new CMLMap();
		CMLLink link = new CMLLink();
		// from a1 to a3
		link.setFrom("a1");
		link.setTo("a3");
		map.addLink(link);
		// from a2 to a1
		link = new CMLLink();
		link.setFrom("a2");
		link.setTo("a1");
		map.addLink(link);

		// a1
		CMLAtom atom0 = atomSet1.getAtom(0);
		Assert.assertEquals("check atom", "a1", atom0.getId());
		// a2
		CMLAtom atom1 = atomSet1.getAtom(1);
		Assert.assertEquals("check atom", "a2", atom1.getId());

		// to a1
		Direction toFrom = Direction.TO;
		CMLAtom atom = atomSet1.getMappedAtom(map, atom0, toFrom);
		Assert.assertNotNull("mapped atom not null", atom);
		Assert.assertEquals("linked atom", "a2", atom.getId());

		// from a1
		toFrom = Direction.FROM;
		atom = atomSet1.getMappedAtom(map, atom0, toFrom);
		Assert.assertNotNull("mapped atom not null", atom);
		Assert.assertEquals("linked atom", "a3", atom.getId());

		// to a2
		toFrom = Direction.TO;
		atom = atomSet1.getMappedAtom(map, atom1, toFrom);
		Assert.assertNull("mapped atom null", atom);

		// to a2
		toFrom = Direction.FROM;
		atom = atomSet1.getMappedAtom(map, atom1, toFrom);
		Assert.assertNotNull("mapped atom not null", atom);
		Assert.assertEquals("linked atom", "a1", atom.getId());

	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLAtomSet.getMappedAtomSet(CMLMap, CMLAtomSet,
	 * Direction)'
	 */
	@Test
	public final void testGetMappedAtomSet() {
		CMLMap map = new CMLMap();
		CMLLink link = new CMLLink();
		// from a1 to a3
		link.setFrom("a1");
		link.setTo("a3");
		map.addLink(link);
		// from a2 to a1
		link = new CMLLink();
		link.setFrom("a2");
		link.setTo("a1");
		map.addLink(link);

		// to atomSet1 (a1, a2)
		Direction toFrom = Direction.TO;
		CMLAtomSet atomSet = atomSet1.getMappedAtomSet(map, atomSet1, toFrom);
		Assert.assertNotNull("mapped atomSet not null", atomSet);
		Assert.assertEquals("linked atomSet", new String[] { "a2", "a1" },
				atomSet.getXMLContent());

		// from atomSet1 (a1, a2)
		toFrom = Direction.FROM;
		atomSet = atomSet1.getMappedAtomSet(map, atomSet1, toFrom);
		Assert.assertNotNull("mapped atomSet not null", atomSet);
		Assert.assertEquals("linked atomSet", new String[] { "a3", "a1" },
				atomSet.getXMLContent());

	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLAtomSet.removeAtoms(CMLMap,
	 * CMLAtomSet)'
	 */
	@Test
	public final void testRemoveAtomsCMLMapCMLAtomSet() {
		CMLMap map = new CMLMap();
		CMLLink link = new CMLLink();
		// from a1 to a3
		link.setFrom("a1");
		link.setTo("a3");
		map.addLink(link);
		// from a2 to a1
		link = new CMLLink();
		link.setFrom("a2");
		link.setTo("a1");
		map.addLink(link);

		Assert.assertEquals("before remove", new String[] { "a2", "a3", "a4",
				"a5" }, atomSet2.getXMLContent());
		atomSet2.removeAtoms(map, atomSet1);
		Assert.assertEquals("after remove", new String[] { "a3", "a4", "a5" },
				atomSet2.getXMLContent());
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLAtomSet.removeAtoms(CMLMap,
	 * Direction)'
	 */
	@Test
	public final void testRemoveAtomsCMLMapDirection() {
		CMLMap map = new CMLMap();
		CMLLink link = new CMLLink();
		// from a1 to a3
		link.setFrom("a1");
		link.setTo("a3");
		map.addLink(link);
		// from a2 to a1
		link = new CMLLink();
		link.setFrom("a2");
		link.setTo("a1");
		map.addLink(link);
		Assert.assertEquals("before remove", new String[] { "a1", "a2", "a3" },
				atomSet1.getXMLContent());
		atomSet1.removeAtoms(map, atomSet2);
		Assert.assertEquals("before remove", new String[] { "a3" }, atomSet1
				.getXMLContent());
	}

}
