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

package org.xmlcml.cml.element;

import java.util.ArrayList;
import java.util.List;

import nu.xom.Element;
import nu.xom.Elements;
import nu.xom.Node;
import nu.xom.Nodes;

import org.xmlcml.cml.base.CMLConstants;
import org.xmlcml.cml.base.CMLElement;
import org.xmlcml.cml.base.CMLElements;
import org.xmlcml.cml.element.CMLCellParameter.Type;
import org.xmlcml.euclid.RealSquareMatrix;
import org.xmlcml.euclid.Transform3;

/**
 * user-modifiable class supporting crystal.
 *
 * @author pmr
 *
 */
public class CMLCrystal extends AbstractCrystal {

	/** namespaced element name.*/
	public final static String NS = C_E+TAG;

   /**
     * crystal systems.
     */
    public enum Bravais {
        /** triclinic */
        TRICLINIC("triclinic"),
        /** monoclinic */
        MONOCLINIC("monoclinic"),
        /** orthorhombic */
        ORTHORHOMBIC("orthorhombic"),
        /** tetragonal */
        TETRAGONAL("tetragonal"),
        /** trigonal */
        TRIGONAL("trigonal"),
        /** hexagonal */
        HEXAGONAL("hexagonal"),
        /** cubic */
        CUBIC("cubic"),
        /** unknown */
        UNKNOWN("unknown");
        String desc;

        private Bravais(String description) {
            this.desc = description;
        }
    }

    /**
     * lattice centering.
     *
     */
    public enum Centering {
        /** primitive */
        P("P", "primitive", new String[] {}),

        /** body-centered */
        I("I", "body-centered", new String[] { "1/2+x, 1/2+y, 1/2+z" }),

        /** rhomohedral */
        R("R", "rhomohedral", new String[] { "1/3+x, 2/3+y, 2/3+z",
                "2/3+x, 1/3+y, 1/3+z" }),

        /** face-centered */
        F("F", "face-centered", new String[] { "x, 1/2+y, 1/2+z",
                "1/2+x, y, 1/2+z", "1/2+x, 1/2+y, z" }),

        /** A-centered */
        A("A", "A-centered", new String[] { "x, 1/2+y, 1/2+z" }),

        /** B-centered */
        B("B", "B-centered", new String[] { "1/2+x, y, 1/2+z" }),

        /** C-centered */
        C("C", "C-centered", new String[] { "1/2+x, 1/2+y, z" }),

        /** unknown */
        UNKNOWN(S_QUERY, "unknown", new String[] {});
        String symbol;

        String desc;

        List<CMLTransform3> translations;

        private Centering(String symbol, String description, String[] operators) {
            this.symbol = symbol;
            this.desc = description;
            this.translations = new ArrayList<CMLTransform3>();
            for (String operator : operators) {
                try {
                    translations.add(new CMLTransform3(operator));
                } catch (Exception e) {
                    throw new RuntimeException("bug " + e);
                }
            }
        }
    }
    /** symbols constants */
    /** a */
    public final static String A = C_A + "a";
    /** b */
    public final static String B = C_A + "b";
    /** c */
    public final static String C = C_A + "c";
    /** a */
    public final static String ALPHA = C_A + "alpha";
    /** b */
    public final static String BETA = C_A + "beta";
    /** c */
    public final static String GAMMA = C_A + "gamma";
    /** convert Z to #operators */
    public final static String Z2OP = C_A + "z2op";
	private static final String[] CELL_DICTREF = {
		"iucr:cell_length_a",
		"iucr:cell_length_b",
		"iucr:cell_length_c",
		"iucr:cell_angle_alpha",
		"iucr:cell_angle_beta",
		"iucr:cell_angle_gamma",
	};
    /**
     * constructor.
     */
    public CMLCrystal() {
    }

    /**
     * constructor.
     *
     * @param old
     */
    public CMLCrystal(CMLCrystal old) {
        super((AbstractCrystal) old);

    }

    /**
     * copy node .
     *
     * @return Node
     */
    public Node copy() {
        return new CMLCrystal(this);

    }

    /**
     * create new instance in context of parent, overridable by subclasses.
     *
     * @param parent
     *            parent of element to be constructed (ignored by default)
     * @return CMLCrystal
     */
    public CMLElement makeElementInContext(Element parent) {
        return new CMLCrystal();

    }

    /**
     * constructor from lattice.
     *
     * @param lattice
     *            (contains 3 lattice vectors)
     */
    public CMLCrystal(CMLLattice lattice) {
        this(lattice.getCellParameters());
    }

    /**
     * constructor from lengths and angles. units are angstrom and degrees must
     * be ordered a,b,c,alpha, beta, gamma
     *
     * @param params
     *            3 length and 3 angles
     * @exception RuntimeException
     *                params of wrong length
     */
    public CMLCrystal(double[] params) throws RuntimeException {
        this(createScalars(params, null));
    }

    /**
     * constructor from lengths and angles. units are angstrom and degrees must
     * be ordered a,b,c,alpha, beta, gamma
     *
     * @param scalars
     *            3 length and 3 angles
     * @exception RuntimeException
     *                parans or wrong length
     */
    public CMLCrystal(CMLScalar[] scalars) {
        this();
        if (scalars == null || scalars.length != 6) {
            throw new RuntimeException("scalar must be of length 6");
        }
        for (CMLScalar scalar : scalars) {
            this.appendChild(scalar);
        }
    }

    /** get the crystallographic orthogonalization matrix as a transform
     *
     * @see #getOrthogonalizationMatrix()
     * @return the orthogonalization matrix as a transform
     */

    public Transform3 getOrthogonalizationTransform() {
        Transform3 t = null;
        try {
            t = new Transform3(this.getOrthogonalizationMatrix());
        } catch (Exception e) {
        	e.printStackTrace();
            throw new RuntimeException("BUG "+e);
        }
        return t;
    }
    /** get the crystallographic orthogonalization matrix.
     *
     * see Rollett "Computing Methods in Crystallography" Pergamon 1965 p.23 the
     * matrix has zeros above the diagonal: a*sin(beta)*sin(gamma*) 0.0 0.0
     * -a*sin(beta)*cos(gamma*) b*sin(alpha) 0.0 a*cos(beta) b*cos(alpha) c
     *
     * @return the orthogonalization matrix
     * @throws CMLException
     */

    public RealSquareMatrix getOrthogonalizationMatrix() {
        double[] param = getCellParameterValues();
        RealSquareMatrix orthMat = new RealSquareMatrix(3);

        // Rollett "Computing Methods in Crystallography" Pergamon 1965 p.23
        double dtor = Math.PI / 180.0;

        double sina = Math.sin(dtor * param[3]);
        double cosa = Math.cos(dtor * param[3]);
        double sinb = Math.sin(dtor * param[4]);
        double cosb = Math.cos(dtor * param[4]);
        double cosg = Math.cos(dtor * param[5]);
        double cosgstar = (cosa * cosb - cosg) / (sina * sinb);
        double singstar = Math.sqrt(1.0 - cosgstar * cosgstar);
        double[][] flmat = orthMat.getMatrix();
        flmat[0][0] = param[0] * sinb * singstar;
        flmat[0][1] = 0.0;
        flmat[0][2] = 0.0;
        flmat[1][0] = -1.0 * param[0] * sinb * cosgstar;
        flmat[1][1] = param[1] * sina;
        flmat[1][2] = 0.0;
        flmat[2][0] = param[0] * cosb;
        flmat[2][1] = param[1] * cosa;
        flmat[2][2] = param[2];
        return orthMat;
    }

    /**
     * set cell lengths and angles.
     *
     * NO DEFAULT VALUES.
     *
     * @param a
     *            the a cell length (ANGSTROM)
     * @param b
     *            the b cell length (ANGSTROM)
     * @param c
     *            the c cell length (ANGSTROM)
     * @param alpha
     *            the alpha cell angle (DEGREES)
     * @param beta
     *            the beta cell angle (DEGREES)
     * @param gamma
     *            the gamma cell angle (DEGREES)
     *
     * @throws CMLException
     *             corrupted number of cell parameters
     */
    public void setCellParameters(double a, double b, double c, double alpha,
            double beta, double gamma) {
        double temp[] = new double[6];
        temp[0] = a;
        temp[1] = b;
        temp[2] = c;
        temp[3] = alpha;
        temp[4] = beta;
        temp[5] = gamma;
        setCellParameters(temp, null);
    }

    /**
     * set cell lengths and angles. omits error
     *
     * @param params
     *            (length 6: 3 lengths ANGSTROM and three angles DEGREES - IN
     *            ORDER)
     *
     * @throws CMLException
     *             corrupted number of cell parameters
     */
    public void setCellParameters(double params[]) {
        setCellParameters(params, null);
    }

    /**
     * set cell lengths and angles.
     *
     * NO DEFAULT VALUES.
     *
     * @param params
     *            (length 6: 3 lengths ANGSTROM and three angles DEGREES - IN
     *            ORDER)
     * @param error
     *            if not null errors in lengths and angles in same units
     *
     * @throws CMLException
     *             corrupted number of cell parameters
     */
    public void setCellParameters(double params[], double error[])
            {
        if (params == null || params.length != 6) {
            throw new RuntimeException("Must have 6 cell parameters");
        }
        Elements cellParamVector = this.getChildCMLElements("scalar");
        if (cellParamVector.size() == 0) {
            for (int i = 0; i < 6; i++) {
                CMLScalar cellParam = CMLCrystal.createScalar(
                        CRYSTAL_DICT_REFS[i], params[i], CRYSTAL_DICT_UNITS[i],
                        Double.NaN);
                this.addScalar(cellParam);
            }
        } else if (cellParamVector.size() == 6) {
            for (int i = 0; i < 6; i++) {
                CMLScalar cellParam = (CMLScalar) cellParamVector.get(i);
                cellParam.setValue(params[i]);
                if (error != null) {
                    cellParam.setErrorValue(error[i]);
                }
                cellParam.setDictRef(CRYSTAL_DICT_REFS[i]);
            }
        } else {
            throw new RuntimeException(
                    "Corrupted cell parameters: must be exactly 6 (found: "
                            + cellParamVector.size() + S_RBRAK);
        }
    }

    /**
     * get cell lengths and angles as list of CMLScalars. if cellParameters are
     * used, take values from them but do not update XOM
     *
     * @deprecated - use CMLCellParameters instead // but this works now
     * @throws RuntimeException
     *             corrupted number of cell parameters
     * @return CMLScalar[] the parameters in order (null if not set)
     */
    public List<CMLScalar> getCellScalars() throws RuntimeException {
        List<CMLScalar> cellScalars = new ArrayList<CMLScalar>();
//        Nodes cellScalarNodes = this.query("cml:scalar[starts-with(@dictRef, 'iucr:_cell')]", CMLConstants.CML_XPATH);
        Nodes cellScalarNodes = this.query("cml:scalar[@dictRef]", CMLConstants.CML_XPATH);
        int cellScalarCount = cellScalarNodes.size();
        if (cellScalarCount != 6) {
        	throw new RuntimeException("Bad number of cell scalars: "+cellScalarCount);
        }
        CMLElements<CMLCellParameter> cellParameterElements = this.getCellParameterElements();
        if (cellParameterElements != null && cellParameterElements.size() == 2) {
            cellScalars = CMLCellParameter.createCMLScalars(cellParameterElements);
        } else if (cellScalarNodes != null && cellScalarNodes.size() == 6) {
        	cellScalars = sortCellScalars(cellScalarNodes);
        } else if (cellScalarNodes != null && cellParameterElements == null) {
        } else {
        	this.debug("CELLPAR");
            throw new RuntimeException("Bad number of cell parameter children: "
                    + cellScalarNodes.size());
        }
        return cellScalars;
    }

    private List<CMLScalar> sortCellScalars(Nodes cellScalarNodes) {
    	List<CMLScalar> cellScalarList = new ArrayList<CMLScalar>(6);
        for (int i = 0; i < 6; i++) {
        	cellScalarList.add((CMLScalar)null);
        }
        for (int i = 0; i < 6; i++) {
        	CMLScalar scalar = (CMLScalar)cellScalarNodes.get(i);
        	String dictRef = scalar.getDictRef().toLowerCase();
        	int j = getCellParameterIndex(dictRef);
        	if (j == -1) {
        		throw new RuntimeException("Cannot interpret cell parameter: "+dictRef);
        	} else if (cellScalarList.get(j) != null) {
        		throw new RuntimeException("duplicate value for "+dictRef);
        	}
        	cellScalarList.set(j, scalar);
        }
        return cellScalarList;
	}

	private int getCellParameterIndex(String dictRef) {
		for (int i = 0; i < 6; i++) {
			if (dictRef.equals(CELL_DICTREF[i])) {
				return i;
			}
		}
		return -1;
	}

	/**
     * get cell lengths and angles as CMLCellParameters. if XOM has
     * cellParameter children copy them else create from CMLScalar else return
     * empty list
     *
     * @throws RuntimeException
     *             corrupted number of cell parameters
     * @return the parameters in order (null if not set)
     */
    public List<CMLCellParameter> createCellParameterElements()
            throws RuntimeException {
        CMLElements<CMLScalar> cellScalarElements = this.getScalarElements();
        CMLElements<CMLCellParameter> cellParameterElements = this
                .getCellParameterElements();

        List<CMLCellParameter> cellParameterList = new ArrayList<CMLCellParameter>();
        if (cellParameterElements != null && cellParameterElements.size() == 2) {
            CMLCellParameter length = CMLCellParameter.getCellParameter(
                    cellParameterElements, CMLCellParameter.Type.LENGTH);
            CMLCellParameter angle = CMLCellParameter.getCellParameter(
                    cellParameterElements, CMLCellParameter.Type.ANGLE);
            if (length != null && angle != null) {
                cellParameterList.add(length);
                cellParameterList.add(angle);
            }
        } else if (cellScalarElements != null && cellScalarElements.size() == 6) {
            List<CMLScalar> lengthParams = new ArrayList<CMLScalar>();
            for (int i = 0; i < 3; i++) {
                lengthParams.add(new CMLScalar((CMLScalar) cellScalarElements
                        .get(i)));
            }
            List<CMLScalar> angleParams = new ArrayList<CMLScalar>();
            for (int i = 3; i < 6; i++) {
                angleParams.add(new CMLScalar((CMLScalar) cellScalarElements
                        .get(i)));
            }
            cellParameterList.add(new CMLCellParameter(lengthParams,
                    Type.LENGTH));
            cellParameterList
                    .add(new CMLCellParameter(angleParams, Type.ANGLE));
        } else if (cellScalarElements.size() > 0) {
            throw new RuntimeException("Bad number of cell parameter children: "
                    + cellScalarElements.size());
            // this is really horrible - must change
        } else {
            throw new RuntimeException("no cell params");
        }
        return cellParameterList;
    }

    /**
     * get cell lengths and angles as array of doubles.
     *
     * Values ARE IN ANGSTROM and DEGREES.
     *
     * @throws CMLException
     *             corrupted number of cell parameters
     * @return double[] the parameters in order (null if not set)
     */
    public double[] getCellParameterValues() {
        List<CMLScalar> paramElements = getCellScalars();

        double[] temp = new double[6];
        if (paramElements == null) {
            return null;
        }
        for (int i = 0; i < 6; i++) {
            temp[i] = (new Double(paramElements.get(i).getXMLContent()))
                    .doubleValue();
        }
        return temp;
    }

    /**
     * adds symmetry operator
     *
     * @param so
     *            The SymmetryOp to add
     */
    /*--
     public void addSymmetryOperator(SymmetryOp so)  {
     if (symOps == null) {
     symOps = new ArrayList ();
     }
     symOps.add (so);
     }
     --*/

    /**
     * returns an array of the SymmetryOps describing the symmetry operators or
     * null if there are no symmetry operators
     */
    /*--
     public List<SymmetryOp> getSymmetryOperators() {
     //LOG.debug ("nu sym ops " + symOps.size ());
     if ((symOps != null) && (symOps.size () != 0)) {
     List<SymmetryOp> ops = new ArrayList<SymmetryOp>();

     return (symOps(ops));
     } else {
     return null;
     }
     }

     --*/

    /**
     * get lattice containing latticeVectors. requires cell parameters to be
     * set.
     *
     * @return the lattice.
     */
    public CMLLattice getLattice() {
        RealSquareMatrix matrix = this.getOrthogonalizationMatrix();
        double[][] flmat = matrix.getMatrix();
        CMLLattice lattice = new CMLLattice();
        double[] v = new double[3];
        v[0] = flmat[0][0];
        v[1] = flmat[1][0];
        v[2] = flmat[2][0];
        CMLLatticeVector aVector = new CMLLatticeVector(v);
        lattice.addLatticeVector(aVector);
        v[0] = flmat[0][1];
        v[1] = flmat[1][1];
        v[2] = flmat[2][1];
        CMLLatticeVector bVector = new CMLLatticeVector(v);
        lattice.addLatticeVector(bVector);
        v[0] = flmat[0][2];
        v[1] = flmat[1][2];
        v[2] = flmat[2][2];
        CMLLatticeVector cVector = new CMLLatticeVector(v);
        lattice.addLatticeVector(cVector);
        return lattice;
    }

    /**
     * get cell volume. use current cell parameters. V=
     * abc(1-cos^2alpha-cos^2beta-cos^2gamma + 2cos alpha cos beta cos
     * gamma)^(1/2)
     *
     * @return volume
     */
    public double getCellVolume() {
        double[] param = this.getCellParameterValues();
        double dtor = Math.PI / 180.0;

        double cosa = Math.cos(dtor * param[3]);
        double cosb = Math.cos(dtor * param[4]);
        double cosg = Math.cos(dtor * param[5]);

        double vol = param[0]
                * param[1]
                * param[2]
                * Math.sqrt(1 - cosa * cosa - cosb * cosb - cosg * cosg + 2
                        * cosa * cosb * cosg);
        return vol;
    }

    /**
     * get cell volume. use scalar triple product of current lattice vectors V =
     * aVect * bVect . cVect
     *
     * @return volume
     */
    public double getCellVolume1() {
        CMLLattice lattice = this.getLattice();
        CMLVector3 a = lattice.getLatticeVectorElements().get(0)
                .getCMLVector3();
        CMLVector3 b = lattice.getLatticeVectorElements().get(1)
                .getCMLVector3();
        CMLVector3 c = lattice.getLatticeVectorElements().get(2)
                .getCMLVector3();
        return a.getScalarTripleProduct(b, c);
    }

    /**
     * get cell volume. use determinant of orthogonalization matrix V =
     * det(orthMat)
     *
     * @return volume
     */
    public double getCellVolume2() {
        RealSquareMatrix orthMat = this.getOrthogonalizationMatrix();
        return orthMat.determinant();
    }

    /**
     * gets volume of reciprocal cell. scaling factor is 1.0 (i.e.
     * wavelength-independent)
     *
     * @return volume
     */
    public double getReciprocalCellVolume() {
        return 1. / this.getCellVolume();
    }

    /**
     * get reciprocal cell scaling factor is 1.0 (i.e. wavelength-independent)
     *
     * @return the cell.
     */
    public CMLCrystal getReciprocalCell() {
        CMLLattice reciprocalLattice = this.getReciprocalLattice();
        CMLCrystal crystal = new CMLCrystal(reciprocalLattice);
        return crystal;
    }

    /**
     * get reciprocal lattice scaling factor is 1.0 (i.e.
     * wavelength-independent)
     *
     * @return the lattice
     */
    public CMLLattice getReciprocalLattice() {
        CMLLattice lattice = this.getLattice();
        CMLVector3 a = lattice.getLatticeVectorElements().get(0)
                .getCMLVector3();
        CMLVector3 b = lattice.getLatticeVectorElements().get(1)
                .getCMLVector3();
        CMLVector3 c = lattice.getLatticeVectorElements().get(2)
                .getCMLVector3();
        double recipvol = 1. / a.getScalarTripleProduct(b, c);
        CMLVector3 astar = b.getCrossProduct(c).multiplyBy(recipvol);
        CMLLatticeVector astarVect = new CMLLatticeVector(astar);
        CMLVector3 bstar = c.getCrossProduct(a).multiplyBy(recipvol);
        CMLLatticeVector bstarVect = new CMLLatticeVector(bstar);
        CMLVector3 cstar = a.getCrossProduct(b).multiplyBy(recipvol);
        CMLLatticeVector cstarVect = new CMLLatticeVector(cstar);
        return new CMLLattice(astarVect, bstarVect, cstarVect);
    }

    private static CMLScalar[] createScalars(double[] params, double[] error)
            throws RuntimeException {
        if (params == null || params.length != 6) {
            throw new RuntimeException("params must be of length 6");
        }
        CMLScalar[] scalar = new CMLScalar[6];
        for (int i = 0; i < 6; i++) {
            double err = (error == null) ? Double.NaN : error[i];
            scalar[i] = createScalar(CRYSTAL_DICT_REFS[i], params[i],
                    CRYSTAL_DICT_UNITS[i], err);
        }
        return scalar;
    }

    /**
     * create a cell parameter scalar from its values. omits error
     *
     * @param dictRef
     * @param param
     * @param unitRef
     * @return the scalar
     */
    public static CMLScalar createScalar(String dictRef, double param,
            String unitRef) {
        return createScalar(dictRef, param, unitRef, Double.NaN);
    }

    /**
     * create a cell parameter scalar from its values.
     *
     * @param dictRef
     * @param param
     * @param unitRef
     * @param error
     *            neglect if Double.NaN
     * @return the scalar
     */
    public static CMLScalar createScalar(String dictRef, double param,
            String unitRef, double error) {
        CMLScalar scalar = new CMLScalar(param);
        scalar.setDictRef(dictRef);
        if (unitRef != null) {
            scalar.setUnits(unitRef);
        }
        if (!Double.isNaN(error)) {
            scalar.setErrorValue(error);
        }
        return scalar;
    }

    /**
     * gets primitive cell. finds Centering; if not UNKNOWN or P applies it
     *
     * @return new lattice
     */
    public CMLLattice getPrimitiveLattice() {
        CMLElements<CMLSymmetry> symmetry = this.getSymmetryElements();
        Centering centering = (symmetry.size() == 0) ? Centering.P : symmetry
                .get(0).getCentering();
        return this.getPrimitiveLattice(centering);
    }

    /**
     * gets primitive cell.
     *
     * @param centering
     * @return new lattice
     */
    public CMLLattice getPrimitiveLattice(CMLCrystal.Centering centering) {
        CMLLattice lattice = this.getLattice();
        CMLLatticeVector[] latticeVectors = new CMLLatticeVector[3];
        if (centering.equals(Centering.P)
                || centering.equals(Centering.UNKNOWN)) {
            // copy current latticeVectors
            int i = 0;
            for (CMLLatticeVector lv : lattice.getLatticeVectorElements()) {
                latticeVectors[i++] = new CMLLatticeVector(lv);
            }
        } else if (centering.equals(Centering.A)) {
            latticeVectors[0] = new CMLLatticeVector(lattice.getCMLVector3(0));
            CMLVector3 bPlusC = lattice.getCMLVector3(1).plus(
                    lattice.getCMLVector3(2));
            latticeVectors[1] = new CMLLatticeVector(bPlusC.multiplyBy(0.5));
            CMLVector3 bMinusC = lattice.getCMLVector3(1).subtract(
                    lattice.getCMLVector3(2));
            latticeVectors[2] = new CMLLatticeVector(bMinusC.multiplyBy(0.5));
        } else if (centering.equals(Centering.B)) {
            CMLVector3 aPlusC = lattice.getCMLVector3(0).plus(
                    lattice.getCMLVector3(2));
            latticeVectors[0] = new CMLLatticeVector(aPlusC.multiplyBy(0.5));
            CMLVector3 aMinusC = lattice.getCMLVector3(0).subtract(
                    lattice.getCMLVector3(2));
            latticeVectors[1] = new CMLLatticeVector(lattice.getCMLVector3(1));
            latticeVectors[2] = new CMLLatticeVector(aMinusC.multiplyBy(0.5));
        } else if (centering.equals(Centering.C)) {
            CMLVector3 aPlusB = lattice.getCMLVector3(0).plus(
                    lattice.getCMLVector3(1));
            latticeVectors[0] = new CMLLatticeVector(aPlusB.multiplyBy(0.5));
            CMLVector3 aMinusB = lattice.getCMLVector3(0).subtract(
                    lattice.getCMLVector3(1));
            latticeVectors[1] = new CMLLatticeVector(aMinusB.multiplyBy(0.5));
            latticeVectors[2] = new CMLLatticeVector(lattice.getCMLVector3(2));
        } else if (centering.equals(Centering.I)) {
            latticeVectors[0] = new CMLLatticeVector(lattice.getCMLVector3(0));
            CMLVector3 aPlusBplusC = lattice.getCMLVector3(0).plus(
                    lattice.getCMLVector3(1)).plus(lattice.getCMLVector3(2));
            latticeVectors[1] = new CMLLatticeVector(aPlusBplusC
                    .multiplyBy(0.5));
            CMLVector3 aPlusBminusC = lattice.getCMLVector3(0).plus(
                    lattice.getCMLVector3(1))
                    .subtract(lattice.getCMLVector3(2));
            latticeVectors[2] = new CMLLatticeVector(aPlusBminusC
                    .multiplyBy(0.5));
        } else if (centering.equals(Centering.F)) {
            CMLVector3 bPlusC = lattice.getCMLVector3(1).plus(
                    lattice.getCMLVector3(2));
            latticeVectors[0] = new CMLLatticeVector(bPlusC.multiplyBy(0.5));
            CMLVector3 cPlusA = lattice.getCMLVector3(2).plus(
                    lattice.getCMLVector3(0));
            latticeVectors[1] = new CMLLatticeVector(cPlusA.multiplyBy(0.5));
            CMLVector3 aPlusB = lattice.getCMLVector3(0).plus(
                    lattice.getCMLVector3(1));
            latticeVectors[2] = new CMLLatticeVector(aPlusB.multiplyBy(0.5));
        } else if (centering.equals(Centering.R)) {
            throw new RuntimeException("R not implemented");
        }
        CMLLattice primitiveLattice = new CMLLattice(latticeVectors);
        return primitiveLattice;
    }

    /** convenience method to get a single crystal descendant of an element.
     *
     * @param element to search under
     * @return the <crystal>
     * @throws RuntimeException if 0 or >1 nodes
     */
    public static CMLCrystal getContainedCrystal(CMLElement element) throws RuntimeException {
        Nodes crystalNodes = element.query(".//"+CMLCrystal.NS, CMLConstants.CML_XPATH);
        if (crystalNodes.size() == 0) {
            throw new RuntimeException("NO <crystal> FOUND");
        } else if (crystalNodes.size() > 1) {
            throw new RuntimeException("TOO MANY <crystal> FOUND "+crystalNodes.size());
        }
        return (CMLCrystal) crystalNodes.get(0);
    }


}