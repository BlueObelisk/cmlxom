package org.xmlcml.cml.element;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import nu.xom.Element;
import nu.xom.Node;
import nu.xom.ParentNode;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.xmlcml.cml.base.CMLElement;
import org.xmlcml.euclid.Point3;
import org.xmlcml.euclid.Real2;
import org.xmlcml.euclid.Transform2;
import org.xmlcml.euclid.Transform3;
import org.xmlcml.euclid.Vector2;
import org.xmlcml.euclid.Vector3;
import org.xmlcml.molutil.ChemicalElement;
import org.xmlcml.molutil.ChemicalElement.AS;
import org.xmlcml.molutil.ChemicalElement.Type;

/**
 * Class representing the CML atom element
 *
 * @author Peter Murray-Rust, Ramin Ghorashi (2005)
 *
 */
public class CMLAtom extends AbstractAtom {

    final static Logger LOG = Logger.getLogger(CMLAtom.class);
	/** namespaced element name.*/
	public final static String NS = C_E+TAG;
    static {
        LOG.setLevel(Level.WARN);
    };

    List<CMLAtom> ligandAtoms = null;
    List<CMLBond> ligandBonds = null;

    /**
     * Construct a new CMLAtom element without id.
     */
    public CMLAtom() {
        super();
        init();
    }

    void init() {
        ligandAtoms = new ArrayList<CMLAtom>();
        ligandBonds = new ArrayList<CMLBond>();
    }

    /**
     * Construct a new CMLAtom element with immutable id.
     * @param id
     */
    public CMLAtom(String id) {
        super();
        this.setId(id);
    }

    /**
     * copy constructor.
     *
     * @param old
     *            to copy
     */
    public CMLAtom(CMLAtom old) {
        super(old);
        init();
    }

    /**
     * Create new CMLAtom with specified id and ChemicalElement.AS
     * @param id
     * @param chem
     */
    public CMLAtom(String id, AS as) {
        this(id, ChemicalElement.getChemicalElement(as));
    }

    /**
     * Create new CMLAtom with specified id and ChemicalElement.
     * @param id
     * @param chem
     */
    public CMLAtom(String id, ChemicalElement chem) {
        this(id);
        this.setElementType(chem.getSymbol());
    }

    /**
     * copy node .
     *
     * @return Node
     */
    public Node copy() {
        return new CMLAtom(this);

    }

    /**
     * create new instance in context of parent, overridable by subclasses.
     *
     * @param parent
     *            parent of element to be constructed (ignored by default)
     * @return CMLAtom
     * @throws RuntimeException
     */
    public CMLElement makeElementInContext(Element parent)
            throws RuntimeException {
        String error = null;
        CMLAtom atom = null;
        // these rules need revising periodically
        if (parent == null) {
            atom = new CMLAtom();
        } else if (parent instanceof CMLAtomArray) {
            // atomArray parent must be child of Molecule or Formula
            Element grandParent = (Element) parent.getParent();
            if (grandParent == null) {
                error = "Atom needs non-null grandparent";
            } else if (grandParent instanceof CMLMolecule) {
                atom = new CMLAtom();
            } else if (grandParent instanceof CMLFormula) {
                error = "Atom grandparent must be not be formula";
            } else {
                error = "Atom grandparent must be molecule";
            }
        } else {
            atom = new CMLAtom();
            // error = "Atom needs atomArray parent";
        }
        if (error != null) {
            throw new RuntimeException(error);
        }
        return atom;
    }

    /**
     * make sure atomId is present
     *
     * @param parent
     *            element
     */
    public void finishMakingElement(Element parent) {
    	try {
    		check();
    	} catch (RuntimeException e) {
    		LOG.warn(e.getMessage());
    	}
    }

    /**
     * checks the CML compliance of this element
     *
     */
    public void check() {
        String id = this.getId();
        if (id == null) {
            throw new RuntimeException("Atom id must not be null");
        }
        CMLMolecule molecule = getMolecule();
        if (molecule != null) {
            CMLAtom oldAtom = getMolecule().getAtomById(id);
            if (oldAtom != null) {
                if (oldAtom != this) {
                	oldAtom.debug("OLD ATOM");
                    throw new RuntimeException("atom check: duplicate atom id: " + id);
                }
            }
        } else {
            // is this an error?
            // throw new CMLRuntime("Atom has no molecule");
        }
    }

    /** set id.
     * this will index the atom if it has a parent.
     * id cannot be reset.
     * @param id
     */
    public void setId(String id) {
    	String id0 = this.getId();
        if (id0 != null) {
        	if(!id0.equals(id)) {
        		throw new RuntimeException("Cannot reindex id");
        	}
        } else {
//        	System.out.println("ATOM SET ID "+id);
	        super.setId(id);
	        ParentNode parent = this.getParent();
	        if (parent != null && parent instanceof CMLAtomArray) {
	            CMLAtomArray atomArray = (CMLAtomArray) parent;
	            if (atomArray != null) {
	                atomArray.indexAtom(this);
	            }
	        }
        }
    }

    /** gets current ligands.
     * updated every time atoms or bonds are added or removed
     * @return list
     */
    public List<CMLAtom> getLigandAtoms() {
        if (ligandAtoms == null) {
            ligandAtoms = new ArrayList<CMLAtom>();
        }
        return ligandAtoms;
    }

    /** gets current bonds to ligands.
     * list is aligned with ligandAtoms
     * updated every time atoms or bonds are added or removed
     * @return list
     */
    public List<CMLBond> getLigandBonds() {
        if (ligandBonds == null) {
            ligandBonds = new ArrayList<CMLBond>();
        }
        return ligandBonds;
    }

    void addLigandBond(CMLBond bond, CMLAtom otherAtom) {
        getLigandAtoms();
        if (ligandAtoms.contains(otherAtom)) {
            throw new RuntimeException("Duplicate ligand: "+otherAtom.getId());
        }
        getLigandBonds();
        if (ligandBonds.contains(bond)) {
            throw new RuntimeException("Duplicate bond: "+bond.getAtomRefs2());
        }
        ligandAtoms.add(otherAtom);
        ligandBonds.add(bond);
    }

    /** deletes ligand info but not bond.
     * therefore not for public use.
     * @param bond
     * @param otherAtom
     */
    void clearLigandInfo(CMLBond bond, CMLAtom otherAtom) {
        if (ligandAtoms != null) {
            if (!ligandAtoms.contains(otherAtom)) {
                throw new RuntimeException("Unknown ligand: "+otherAtom.getString());
            }
            ligandAtoms.remove(otherAtom);
        } else {
            ; // is this an error?
        }
        if (ligandBonds != null) {
            if (!ligandBonds.contains(bond)) {
                throw new RuntimeException("Unknown bond: "+bond.getString());
            }
            ligandBonds.remove(bond);
        } else {
            ; // is this an error?
        }
    }

    /** delete ligand info but not bond.
     * not for public use.
     */
    void clearLigandInfo() {
        int nlig = ligandAtoms.size();
        for (int i = nlig - 1; i >= 0; i--) {
            this.clearLigandInfo(ligandBonds.get(i), ligandAtoms.get(i));
        }
    }

    /**
     * Get owner molecule.
     *
     * @return owner molecule
     */
    public CMLMolecule getMolecule() {
        Node atomArray = this.getParent();
        if (atomArray != null) {
            Node grandParent = atomArray.getParent();
            if (grandParent != null && grandParent instanceof CMLMolecule) {
                return (CMLMolecule) grandParent;
            }
        }
        return null;
    }

    CMLAtomArray getAtomArray() {
        ParentNode parent = this.getParent();
        return (parent == null || !(parent instanceof CMLAtomArray)) ? null :
            (CMLAtomArray) parent;
    }

    /** remove atom.
     * routed to atomArray.removeAtom()
     */
    public void detach() {
        CMLAtomArray atomArray = getAtomArray();
        if (this.getParent() != null && atomArray != null) {
            atomArray.removeAtom(this);
        }
    }

    /** gets all explict hydrogen ligand atoms.
     * ignore hydrogen count
     * @return list of atoms
     */
    public List<CMLAtom> getLigandHydrogenAtoms() {
    	List<CMLAtom> hydrogenAtoms = new ArrayList<CMLAtom>();
    	List<CMLAtom> ligandAtoms = this.getLigandAtoms();
    	for (CMLAtom ligand : ligandAtoms) {
    		if (AS.H.equals(ligand.getElementType())) {
    			hydrogenAtoms.add(ligand);
    		}
    	}
    	return hydrogenAtoms;
    }

    /** if atom has one or more hydrogen atoms deletes one.
     * mainly for managing count for aromatics.
     * @return atom deleted or null
     */
    public CMLAtom deleteAnyLigandHydrogenAtom() {
    	CMLAtom ligand = null;
        List<CMLAtom> hydrogens = getLigandHydrogenAtoms();
        if (hydrogens.size() > 0) {
        	CMLMolecule molecule = this.getMolecule();
        	ligand = hydrogens.get(0);
        	CMLBond bond = molecule.getBond(this, ligand);
        	molecule.deleteBond(bond);
        	molecule.deleteAtom(ligand);
        }
        return ligand;
    }

    /**
     * Returns the number of valence electrons this atom has based on its
     * chemical element
     *
     * @return number of valence electrons
     */
    public int getValenceElectrons() {
        ChemicalElement chemicalElement = this.getChemicalElement();
        if (chemicalElement != null) {
            return chemicalElement.getValenceElectrons();
        }
        return 0;
    }

    /**
     * gets Real2 for x2 y2.
     *
     * @return the point; null if x2, etc. are unset
     */
    public Real2 getXY2() {
        if (hasCoordinates(CoordinateType.TWOD)) {
            return new Real2(this.getX2(), this.getY2());
        }
        return null;
    }

    /**
     * sets Real2 for x2 y2.
     *
     * @param point
     */
    public void setXY2(Real2 point) {
        this.setX2(point.getX());
        this.setY2(point.getY());
    }

    /**
     * gets Point3 for x3, y3, z3.
     *
     * @see #getPoint3(CoordinateType)
     * @return the point; null if x3, etc. are unset
     */
    public Point3 getXYZ3() {
        if (hasCoordinates(CoordinateType.CARTESIAN)) {
            return new Point3(this.getX3(), this.getY3(), this.getZ3());
        }
        return null;
    }

    /**
     * gets Point3 for cartesians or fractionals.
     *
     * @see #getXYZ3()
     * @see #getXYZFract()
     * @param type
     *            selects cartesians or fractionals
     * @return the point; null if x3 or xFract, etc. are unset
     */
    public Point3 getPoint3(CoordinateType type) {
        Point3 point = null;
        if (type.equals(CoordinateType.CARTESIAN)) {
            point = getXYZ3();
        } else if (type.equals(CoordinateType.FRACTIONAL)) {
            point = getXYZFract();
        }
        return point;
    }

    /**
     * sets Point3 for x3 y3 z3.
     *
     * @param point
     */
    public void setXYZ3(Point3 point) {
        this.setX3(point.getArray()[0]);
        this.setY3(point.getArray()[1]);
        this.setZ3(point.getArray()[2]);
    }

    /**
     * sets Point3 for cartesians or fractionals.
     *
     * @param point
     *            to set
     * @param type
     *            selects cartesians or fractionals
     * @return the point; null if x3 or xFract, etc. are unset
     */
    public Point3 setPoint3(Point3 point, CoordinateType type) {
        if (type.equals(CoordinateType.CARTESIAN)) {
            setXYZ3(point);
        } else if (type.equals(CoordinateType.FRACTIONAL)) {
            setXYZFract(point);
        }
        return point;
    }

    /**
     * unsets Point3 for cartesians or fractionals or 2D. remove appropraite
     * attributes
     *
     * @param type
     *            selects cartesians or fractionals
     */
    public void unsetPoint(CoordinateType type) {
        if (type.equals(CoordinateType.CARTESIAN)) {
            unsetXYZ3();
        } else if (type.equals(CoordinateType.FRACTIONAL)) {
            unsetXYZFract();
        } else if (type.equals(CoordinateType.TWOD)) {
            unsetXY2();
        }
    }

    /**
     * unsets x3 y3 z3.
     */
    public void unsetXYZ3() {
        this.removeAttribute("x3");
        this.removeAttribute("y3");
        this.removeAttribute("z3");
    }

    /**
     * unsets xFract yFract zFract.
     */
    public void unsetXYZFract() {
        this.removeAttribute("xFract");
        this.removeAttribute("yFract");
        this.removeAttribute("zFract");
    }

    /**
     * unsets x2 y2
     */
    public void unsetXY2() {
        this.removeAttribute("x2");
        this.removeAttribute("y2");
    }

    /**
     * transform 3D coordinates. does NOT alter fractional or 2D coordinates
     *
     * @param transform
     *            the transformation
     */
    public void transformCartesians(Transform3 transform) {
        Point3 point = this.getXYZ3();
        point = point.transform(transform);
        this.setXYZ3(point);
    }

    /**
     * gets Point3 for xFract, yFract, zFract.
     *
     * @return the point; null if xFract, etc. are unset
     */
    public Point3 getXYZFract() {
        if (hasCoordinates(CoordinateType.FRACTIONAL)) {
            return new Point3(this.getXFract(), this.getYFract(), this
                    .getZFract());
        }
        return null;
    }

    /**
     * sets Point3 for x3 y3 z3.
     *
     * @param point
     */
    public void setXYZFract(Point3 point) {
        this.setXFract(point.getArray()[0]);
        this.setYFract(point.getArray()[1]);
        this.setZFract(point.getArray()[2]);
    }

    /**
     * transform 3D fractional coordinates. modifies this does not modify x3,
     * y3, z3 (may need to re-generate cartesians)
     *
     * @param transform
     *            the transformation
     */
    public void transformFractionals(Transform3 transform) {
        Point3 point = this.getXYZFract();
        point = point.transform(transform);
        this.setXYZFract(point);
    }

    /**
     * The formalCharge on the atom. this attribute is often omitted; if so
     * getFormalCharge() will throw CMLRuntime. this routine allows the caller
     * to decide whether an omission default to 0.
     *
     * @param control
     * @return int
     */
    public int getFormalCharge(FormalChargeControl control) {
        int fc = 0;
        try {
            fc = getFormalCharge();
        } catch (RuntimeException e) {
            if (FormalChargeControl.NO_DEFAULT.equals(control)) {
                throw e;
            }
        }
        return fc;
    }

    /**
     * Gets the fractional coordinate for this atom
     *
     * @return the fractional coordinate or null if it has not been set
     */
    public Point3 getFractCoord() {
        if (this.getXFractAttribute() != null
                && this.getYFractAttribute() != null
                && this.getZFractAttribute() != null) {
            return new Point3(this.getXFract(), this.getYFract(), this
                    .getZFract());
        } else {
            return null;
        }
    }

    /**
     * gets chemical element corresponding to elementType.
     *
     * @return the chemical element (or null)
     */
    public ChemicalElement getChemicalElement() {
        return ChemicalElement.getChemicalElement(this.getElementType());
    }

    /** convenience method to determine whether atom is of given elementType;
     * 
     * @param element
     * @return true if element of same type as getElementType()
     */
    public boolean hasElement(String elementType) {
    	return elementType != null && elementType.equals(this.getElementType());
    }

    /**
     * gets atomicNumber corresponding to elementType.
     *
     * @return atomic number (0 if not found)
     */
    public int getAtomicNumber() {
        ChemicalElement chemicalElement = getChemicalElement();
        return (chemicalElement == null) ? 0 : chemicalElement
                .getAtomicNumber();
    }

    /**
     * get convenience serial number for common elements. only used by Molutils
     * and valency tools do not use outside JUMBO. This should be reengineered
     * to manage valency at some stage
     *
     * @param elemType
     * @return number
     */
    public static int getCommonElementSerialNumber(String elemType) {
        final String[] elems = { AS.H.value, AS.C.value, AS.N.value, AS.O.value, AS.F.value, AS.Si.value, AS.P.value, AS.S.value, AS.Cl.value,
                AS.Br.value, AS.I.value };
        for (int i = 0; i < elems.length; i++) {
            if (elems[i].equals(elemType)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * gets cross product for 3 atoms in 3D.
     *
     * gets cross products of this->at1 X this->at2
     *
     * @param atom1
     *            first atom
     * @param atom2
     *            second atom
     *
     * @return the cross product (null if parameters are null; zero if atoms are
     *         coincident or colinear)
     */
    // should this really be a public function?
    public Vector3 get3DCrossProduct(CMLAtom atom1, CMLAtom atom2) {
        Vector3 cross = null;
        Vector3 v1 = this.getVector3(atom1);
        Vector3 v2 = this.getVector3(atom2);
        cross = v1.cross(v2);
        return cross;
    }

    /**
     * gets cross product for 3 atoms in 2D.
     *
     * gets cross products of this->at1 X this->at2 the result is a 3D vector
     * perpendicular to xy2 plane
     *
     * @param atom1
     *            first atom
     * @param atom2
     *            second atom
     *
     * @return the cross product (null if parameters are null; zero if atoms are
     *         coincident or colinear)
     */
    // should this really be a public function?
    public Vector3 get2DCrossProduct(CMLAtom atom1, CMLAtom atom2) {
        Vector3 cross = null;
        if (atom1 != null && atom2 != null) {
            Point3 p0 = get2DPoint3();
            Point3 p1 = atom1.get2DPoint3();
            Point3 p2 = atom2.get2DPoint3();
            if (p1 != null && p2 != null) {
                Vector3 v1 = p1.subtract(p0);
                Vector3 v2 = p2.subtract(p0);
                cross = v1.cross(v2);
            }
        }
        return cross;
    }

    /**
     * gets 2D coordinates as a 3D point.
     *
     * adds a z coordinate of 0.0. Result is not stored
     *
     * @return the point (null if no 2D coordinates)
     */
    public Point3 get2DPoint3() {
        Point3 point = null;
        if (hasCoordinates(CoordinateType.TWOD)) {
            point = new Point3(this.getX2(), this.getY2(), 0.0);
        }
        return point;
    }

    /**
     * gets vector from this atom to another.
     *
     * gets vector this->at1 (i.e. at1 minus this)
     *
     * @param atom1
     *            other atom
     *
     * @return the vector (null if atoms are null or have no coordinates)
     */
    public Vector3 getVector3(CMLAtom atom1) {
        Vector3 v = null;
        if (atom1 != null) {
            Point3 p0 = this.getXYZ3();
            Point3 p1 = atom1.getXYZ3();
            if (p1 != null && p0 != null) {
                v = p1.subtract(p0);
            }
        }
        return v;
    }

    /**
     * gets vector from this atom to another.
     *
     * gets vector this->at1 (i.e. at1 minus this)
     *
     * @param atom1
     *            other atom
     *
     * @return the vector (null if atoms are null or have no coordinates)
     */
    public Real2 getVector2(CMLAtom atom1) {
        Real2 v = null;
        if (atom1 != null) {
            Real2 p0 = this.getXY2();
            Real2 p1 = atom1.getXY2();
            if (p1 != null && p0 != null) {
                v = p1.subtract(p0);
            }
        }
        return v;
    }

    /**
     * increase x2 and y2 coordinates.
     *
     * if x2 or y2 is unset, no action (to avoid a default of zero)
     *
     * @param dx
     *            amount to add
     * @param dy
     *            amount to add
     */
    public void increaseXY2(double dx, double dy) {
        if (hasCoordinates(CoordinateType.TWOD)) {
            this.setX2(this.getX2() + dx);
            this.setY2(this.getY2() + dy);
        }
    }

    /**
     * transforms 2D coordinates of atom.
     *
     * if x2 or y2 is unset take no action
     *
     * @param t2
     *            transformation
     */
    public void transform(Transform2 t2) {
        if (hasCoordinates(CoordinateType.TWOD)) {
            Real2 xy = new Real2(this.getX2(), this.getY2());
            xy.transformBy(t2);
            this.setX2(xy.getX());
            this.setY2(xy.getY());
        }
    }

    /**
     * increase x3, y3 and z3 coordinates.
     *
     * if x3, y3 or z3 is unset, no action
     *
     * @param dx
     *            amount to add
     * @param dy
     *            amount to add
     * @param dz
     *            amount to add
     */
    public void increaseXYZ3(double dx, double dy, double dz) {
        if (hasCoordinates(CoordinateType.CARTESIAN)) {
            this.setX3(this.getX3() + dx);
            this.setY3(this.getY3() + dy);
            this.setZ3(this.getZ3() + dz);
        }
    }

    /**
     * increase x3, y3 and z3 coordinates.
     *
     * if x3, y3 or z3 is unset, no action
     *
     * @param dx
     *            amount to add
     * @param dy
     *            amount to add
     * @param dz
     *            amount to add
     */
    public void increaseXYZFract(double dx, double dy, double dz) {
        if (hasCoordinates(CoordinateType.CARTESIAN)) {
            this.setXFract(this.getXFract() + dx);
            this.setYFract(this.getYFract() + dy);
            this.setZFract(this.getZFract() + dz);
        }
    }

    /**
     * get distance between atoms.
     *
     * @param atom2 the other atom
     *
     * @return distance (throws Exception if atom(s) lack coordinates)
     */
    public double getDistanceTo(CMLAtom atom2) {
        Vector3 vector = getVector3(atom2);
        if (vector != null) {
            return getVector3(atom2).getLength();
        } else {
        	throw new RuntimeException("cannot calculate distance");
        }
    }

    /**
     * get 2D distance between atoms.
     * @param atom2 the other atom
     * @return distance (Double.NaN if atom(s) lack coordinates)
     */
    public double getDistance2(CMLAtom atom2) {
    	Real2 xy0 = this.getXY2();
    	Real2 xy1 = atom2.getXY2();
    	double distance2 = Double.NaN;
    	if (xy0 != null && xy1 != null) {
    		distance2 = xy0.getDistance(xy1);
    	}
    	return distance2;
    }

    /**
     * get squared distance between atoms.
     *
     * @param atom2 the other atom
     *
     * @return squared distance (NaN if atom(s) lack coordinates)
     */
    public double getSquaredDistanceTo(CMLAtom atom2) {
    	double dist2 = Double.NaN;
    	Point3 p = this.getPoint3(CoordinateType.CARTESIAN);
    	Point3 p2 = atom2.getPoint3(CoordinateType.CARTESIAN);
        if (p != null || p2 != null) {
        	dist2 = p.getSquaredDistanceFromPoint(p2);
        }
        return dist2;
    }

    /**are two atoms within sum of radii.
     * 
     * @param atom2
     * @param radiusType
     * @return true if atoms are within sum
     */
    public boolean isWithinRadiusSum (
    	CMLAtom atom2, ChemicalElement.RadiusType radiusType) {
    	boolean within = false;
    	ChemicalElement elem = this.getChemicalElement();
    	ChemicalElement elem2 = atom2.getChemicalElement();
    	if (elem != null && elem2 != null) {
        	double radsum = 
        		elem.getRadius(radiusType) + 
        	    elem2.getRadius(radiusType);
        	double radsum2 = radsum * radsum;
        	within = (radsum2 > this.getSquaredDistanceTo(atom2));
    	}
    	return within;
    }
    
    /**
     * Rounds the coords that are within epsilon of 0 to 0. works coordinates
     * (XY2, XYZ3, XYZFract) according to coordinateType
     *
     * @param epsilon
     *            (must not be 0)
     * @param coordinateType
     */
    public void roundCoords(double epsilon, CoordinateType coordinateType) {
        epsilon = (epsilon == 0.0) ? 1.0E-50 : epsilon;
        final double factor = 1.0 / epsilon;

        // 2D
        int i;
        if (CoordinateType.TWOD.equals(coordinateType)
                && this.hasCoordinates(CoordinateType.TWOD)) {
            i = (int) (this.getX2() * factor);
            this.setX2(((double) i) * epsilon);
            i = (int) (this.getY2() * factor);
            this.setY2(((double) i) * epsilon);
        }

        // 3D
        if (CoordinateType.CARTESIAN.equals(coordinateType)
                && this.hasCoordinates(CoordinateType.CARTESIAN)) {
            i = (int) (this.getX3() * factor);
            this.setX3(((double) i) * epsilon);
            i = (int) (this.getY3() * factor);
            this.setY3(((double) i) * epsilon);
            i = (int) (this.getZ3() * factor);
            this.setZ3(((double) i) * epsilon);
        }

        // Fractionals
        if (CoordinateType.FRACTIONAL.equals(coordinateType)
                && this.hasCoordinates(CoordinateType.FRACTIONAL)) {
            i = (int) (this.getXFract() * factor);
            this.setXFract(((double) i) * epsilon);
            i = (int) (this.getYFract() * factor);
            this.setYFract(((double) i) * epsilon);
            i = (int) (this.getZFract() * factor);
            this.setZFract(((double) i) * epsilon);
        }
    }

    /**
     * Determines whether or not this atom has coordinates of a given type
     *
     * @param type
     *            of coordinate
     * @return true if all coordinates or a given type are set, false otherwise
     */
    public boolean hasCoordinates(CoordinateType type) {
        boolean has = false;
        if (CoordinateType.TWOD.equals(type)) {
            has = (this.getX2Attribute() != null && this.getY2Attribute() != null);
        } else if (CoordinateType.CARTESIAN.equals(type)) {
            has = (this.getX3Attribute() != null
                    && this.getY3Attribute() != null && this.getZ3Attribute() != null);
        } else if (CoordinateType.FRACTIONAL.equals(type)) {
            has = (this.getXFractAttribute() != null
                    && this.getYFractAttribute() != null && this
                    .getZFractAttribute() != null);
        }
        return has;
    }

    /**
     * simple atom comparison based on atomic mass (not recursive).
     *
     * @param otherAtom
     * @return int the comparison
     */
    public int compareByAtomicNumber(CMLAtom otherAtom) {
        int thisAtnum = getAtomicNumber();
        int otherAtnum = otherAtom.getAtomicNumber();
        int comp = 0;
        if (thisAtnum < otherAtnum) {
            comp = -1;
        } else if (thisAtnum > otherAtnum) {
            comp = 1;
        }
        return comp;
    }

    /**
     * gets count of hydrogens. combines value of hydrogenCount attribute with
     * the actual ligands of type hydrogen.
     * DANGEROUS since result may not be normalized
     * @return hydrogenCount();
     */
    public int getHydrogenCount() {
        int hc = 0;
        if (super.getHydrogenCountAttribute() == null) {
            List<CMLAtom> ligands = this.getLigandAtoms();
            for (CMLAtom ligand : ligands) {
                if (AS.H.equals(ligand.getElementType())) {
                    hc++;
                }
            }
        } else {
            hc = super.getHydrogenCount();
        }
        return hc;
    }

    /** gets formal charge.
     *
     * if attribute is missing, returns 0
     * If you don't like this behaviour, test for null getFormalChargeAttribute()
     * and create your own behaviour
     * @return count on attribute or 0
     */
    public int getFormalCharge() {
        int fc = 0;
        if (super.getFormalChargeAttribute() != null) {
            fc = super.getFormalCharge();
        }
        return fc;
    }

    /** get list of atoms filtered by elements.
     *
     * @param atomList list of atoms
     * @param elementSet elements in filter
     * @return atoms with elements in filter
     */
    public static List<CMLAtom> filter(List<CMLAtom> atomList, Set<ChemicalElement> elementSet) {
        List<CMLAtom> newAtomList = new ArrayList<CMLAtom>();
        for (CMLAtom atom : atomList) {
            ChemicalElement element = atom.getChemicalElement();
            if (element != null && elementSet.contains(element)) {
                newAtomList.add(atom);
            }
        }
        return newAtomList;
    }

    /** rename atom and all bonds it occurs in.
     *
     * @param newId
     */
    public void renameId(String newId) {
        String oldId = this.getId();
        List<CMLBond> bondList = this.getLigandBonds();
        for (CMLBond ligandBond : bondList) {
            ligandBond.renameAtomRef(oldId, newId);
        }
        // must delay this to the end to keep indexes OK
        this.resetId(newId);
    }

    /** replace element in atomRefs array.
     * used for swapping first and last atoms in either atomRefs2, atomRefs3 or atomRefs4
     * @param atomRefs array with atom ids
     * @param atom
     * @param rGroup
     * @param last
     * @return true if swapped
     */
    public static boolean replaceAtomRefs(String[] atomRefs, CMLAtom atom, CMLAtom rGroup, int last) {
        boolean change = false;
        if (atomRefs[0].equals(rGroup.getId())) {
            atomRefs[0] = atom.getId();
            change = true;
        } else if (atomRefs[last].equals(rGroup.getId())) {
            atomRefs[last] = atom.getId();
            change = true;
        }
        return change;
    }


    /** to string.
     * @return atom id and element type at present
     */
    public String getString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id='"+this.getId()+"'");
        sb.append(" elementType='"+this.getElementType()+"'");
        return sb.toString();
    }

	/**
	 * is atom of given type.
	 *
	 * @param typeList
	 * @return true if of type
	 */
	public boolean atomIsCompatible(List<Type> typeList) {
		boolean isCompatible = false;
		ChemicalElement chemicalElement = ChemicalElement
		.getChemicalElement(this.getElementType());
		for (Type type : typeList) {
			if (type != null && chemicalElement.isChemicalElementType(type)) {
				isCompatible = true;
			}
		}
		return isCompatible;
	}

	/**
	 * gets list of ligands in 2D diagram in clockwise order.
	 *
	 * starting atom is arbitrary (makes smallest clockwise angle with xAxis).
	 * The 4 atoms can be compared to atomRefs4 given by author or other methods
	 * to see if they are of the same or alternative parity.
	 *
	 * use compareAtomRefs4(CMLAtom[] a, CMLAtom[] b) for comparison
	 *
	 * @param atom4
	 *            the original list of 4 atoms
	 * @return ligands sorted into clockwise order
	 * @throws RuntimeException
	 */
	public CMLAtom[] getClockwiseLigands(CMLAtom[] atom4)
	throws RuntimeException {
		Vector2 vx = new Vector2(1.0, 0.0);
		Real2 thisxy = getXY2();
		double[] angle = new double[4];
		Vector2 v = null;
		for (int i = 0; i < 4; i++) {
			try {
				v = new Vector2(atom4[i].getXY2().subtract(thisxy));
				// Angle class appears to be broken, hence the degrees
				angle[i] = vx.getAngleMadeWith(v).getDegrees();
			} catch (NullPointerException npe) {
				throw new RuntimeException(
						"Cannot compute clockwise ligands");
			}
			if (angle[i] < 0) {
				angle[i] += 360.;
			}
			if (angle[i] > 360.) {
				angle[i] -= 360.;
			}
		}
		// get atom4Refs sorted in cyclic order
		CMLAtom[] cyclicAtom4 = new CMLAtom[4];
		for (int i = 0; i < 4; i++) {
			double minAngle = Double.MAX_VALUE;
			int low = -1;
			for (int j = 0; j < 4; j++) {
				if (angle[j] >= 0 && angle[j] < minAngle) {
					low = j;
					minAngle = angle[j];
				}
			}

			if (low != -1) {
				cyclicAtom4[i] = atom4[low];
				angle[low] = -100.;
			} else {
				throw new RuntimeException(
						"Couldn't get AtomRefs4 sorted in cyclic order");
			}
		}
		// all 4 angles must be less than PI
		// the ligands in clockwise order
		for (int i = 0; i < 4; i++) {
			CMLAtom cyclicAtomNext = cyclicAtom4[(i < 3) ? i + 1 : 0];
			Real2 cyclicXy = cyclicAtom4[i].getXY2();
			Real2 cyclicXyNext = cyclicAtomNext.getXY2();
			v = new Vector2(cyclicXy.subtract(thisxy));
			Vector2 vNext = new Vector2(cyclicXyNext.subtract(thisxy));
			double ang = v.getAngleMadeWith(vNext).getDegrees();
			if (ang < 0) {
				ang += 360.;
			}
			if (ang > 360.) {
				ang -= 360.;
			}
			if (ang > 180.) {
				throw new RuntimeException("All 4 ligands on same side "
						+ getId());
			}
		}
		return cyclicAtom4;
	}
	
	/** is this atom clode to another.
	 * 
	 * @param atom
	 * @return true if close
	 */
	public boolean hasCloseContact(CMLAtom atom) {
		double valenceDist = this.getChemicalElement().getCovalentRadius()+atom.getChemicalElement().getVDWRadius();
		double dist = this.getDistanceTo(atom);
		if ((valenceDist/2) > dist) {
			return true;
		} else {
			return false;
		}
	}

	public static void debugAtom(String msg, CMLAtom atom) {
		if (atom == null) {
			System.out.println(msg+"...");
		} else {
			System.out.println(msg+"..."+atom.getId());
		}
	}
}