package org.xmlcml.euclid;

import org.apache.log4j.Logger;

/**
 * 2-D transformation matrix class
 * 
 * Transform2 represents a transformation matrix for 2-D objects. Its actual
 * form may be implementation-dependent, but we have started with 3x3 matrices.
 * The following transformations will be supported as the class is developed:
 * 
 * 
 * 
 * TRFORM2_NULL no transformation allowed <BR>
 * ROT_ORIG rotation about the origin <BR>
 * ROT_TRANS rotation and translation <BR>
 * ROT_TRANS_SCALE rotation, translation and single scale factor <BR>
 * ROT_TRANS_AXIAL_SCALE rotation, translation + 3 axial scale factors <BR>
 * ROT_TRANS_SCALE_PERSP rotation, translation, scale, perspective <BR>
 * TRFORM3_ANY any matrix at all - user beware!
 * <P>
 * 
 * The basic stuff is all there - the user will do best to look at examples.
 * 
 * 
 * NOTE; this has been hacked in a hurry from Transform3. Many of the internal
 * routines are grossly overcomplicated. I'll clean it up some time.
 * 
 * @author (C) P. Murray-Rust, 1996
 * @author PMR 20 August 2003
 */
public class Transform2 extends RealSquareMatrix {
    final static Logger logger = Logger.getLogger(Transform2.class.getName());
    /** type */
    public enum Type {
        /** */
        NULL(1, "none"),
        /** */
        ROT_ORIG(2, "rotation about origin"),
        /** */
        ROT_TRANS(3, "rotation translation"),
        /** */
        ROT_TRANS_SCALE(4, "rotation translation scale"),
        /** */
        ROT_TRANS_AXIAL_SCALE(5, "rotation translation axial scale"),
        /** */
        ROT_TRANS_SCALE_PERSP(6, "perspective"),
        /** */
        ANY(7, "any");
        /** integer value */
        public int i;
        /** String value */
        public String s;
        private Type(int i, String s) {
            this.i = i;
            this.s = s;
        }
    };
    /**
     * Transform2 inherits all public or protected members of RealSquareMatrix
     * and its ancestors
     */
    Type trnsfrm;
    /**
     * default is a unit matrix
     */
    public Transform2() {
        super(3);
        for (int i = 0; i < 3; i++) {
            flmat[i][i] = 1.0;
        }
        trnsfrm = Type.ANY;
    }
    /**
     * This gives a default unit matrix of type t (default ROT_ORIG)
     * 
     * @param t
     *            Description of the Parameter
     */
    public Transform2(Type t) {
        this();
        trnsfrm = t;
    }
    /** identity matrix with translation component
     * 
     * @param v amount to translate by
     */
    public Transform2(Vector2 v) {
        this();
        trnsfrm = Type.ROT_TRANS;
        flmat[0][2] = v.x;
        flmat[1][2] = v.y;
    }
    /** clockwise rotation about z- axis
     * 
     * @param zrot radians clockwise rotation
     */
    public Transform2(Angle zrot) {
        this();
        double cosx = zrot.cos();
        double sinx = zrot.sin();
        this.flmat[0][0] = cosx;
        this.flmat[0][1] = sinx;
        this.flmat[1][0] = -sinx;
        this.flmat[1][1] = cosx;
        this.flmat[2][2] = 1.0;
        this.trnsfrm = Type.ROT_ORIG;
    }
    /**
     * from rotation about a point, given a matrix NOT CHECKED
     * 
     * @param t
     *            Description of the Parameter
     * @param p
     *            Description of the Parameter
     */
    public Transform2(Transform2 t, Real2 p) {
        super(3);
        // translation = -M*r + r
        flmat[0][2] = -t.flmat[0][0] * p.x - t.flmat[0][1] * p.y + p.x;
        flmat[1][2] = -t.flmat[1][0] * p.x - t.flmat[1][1] * p.y + p.y;
        this.flmat[0][0] = t.flmat[0][0];
        this.flmat[0][1] = t.flmat[0][1];
        this.flmat[1][0] = t.flmat[1][0];
        this.flmat[1][1] = t.flmat[1][1];
        trnsfrm = Type.ROT_TRANS;
    }
    /**
     * rotation of one vector onto another
     * 
     * @param v1
     *            Description of the Parameter
     * @param v2
     *            Description of the Parameter
     * @exception EuclidRuntimeException
     *                <TT>v1</TT> or <TT>v2</TT> is zero length
     */
    public Transform2(Vector2 v1, Vector2 v2) throws EuclidRuntimeException {
        super(3);
        Angle a = v1.getAngleMadeWith(v2);
        Transform2 temp = new Transform2(a);
        this.flmat = temp.flmat;
        this.trnsfrm = temp.trnsfrm;
    }
    /**
     * from 2 vector components - NOT checked for validity
     * 
     * @param v1
     *            Description of the Parameter
     * @param v2
     *            Description of the Parameter
     */
    public Transform2(Real2 v1, Real2 v2) {
        super(3);
        for (int i = 0; i < 2; i++) {
            flmat[0][0] = v1.x;
            flmat[1][0] = v2.x;
            flmat[0][1] = v1.y;
            flmat[1][1] = v2.y;
            flmat[2][i] = 0.0;
            flmat[i][2] = 0.0;
        }
        flmat[2][2] = 1.0;
        trnsfrm = Type.ROT_ORIG;
    }
    /**
     * construct from an array. Formed by feeding in an existing array. to a
     * cols*cols matrix array is of type m00, m01, m02, m10 ...
     * 
     * @param array
     *            to create the Transform from
     * @exception EuclidRuntimeException
     *                array must have 9 elements
     */
    public Transform2(double[] array) throws EuclidRuntimeException {
        super(3, array);
        trnsfrm = calculateMatrixType();
    }
    /**
     * copy constructors - assumed to be an OK matrix.
     * 
     * @param m
     *            the transform to copy
     */
    public Transform2(Transform2 m) {
        super(m);
        trnsfrm = m.trnsfrm;
    }
    /**
     * from a 2x2 or 3x3 matrix
     * 
     * @param m
     *            Description of the Parameter
     * @exception EuclidRuntimeException
     *                <TT>m</TT> must be 2*2 or 3*3
     */
    public Transform2(RealSquareMatrix m) throws EuclidRuntimeException {
        this();
        // 2x2 matrix. convert to 3x3
        if (m.getCols() == 2) {
            // convert to 3x3
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    flmat[i][j] = m.flmat[i][j];
                }
            }
        } else if (m.getCols() != 3) {
            throw new EuclidRuntimeException("bad size for transform "+m.getCols());
        } else {
            this.flmat = m.flmat;
        }
        this.trnsfrm = calculateMatrixType();
    }
    /**
     * from a 2x2 rotation matrix and a translation vector
     * 
     * @param m
     *            Description of the Parameter
     * @param v
     *            Description of the Parameter
     * @exception EuclidRuntimeException
     *                <TT>m</TT> must be 2*2
     */
    public Transform2(RealSquareMatrix m, Vector2 v) throws EuclidRuntimeException {
        this(m);
        // 2x2 matrix. convert to 3x3
        if (m.getCols() == 2) {
            // convert to 3x3
            flmat[0][2] = v.x;
            flmat[1][2] = v.y;
        } else {
            throw new EuclidRuntimeException("must have 2*2 rotation matrix");
        }
    }
    /**
     * clone
     * 
     * @param m
     *            Description of the Parameter
     * @return Description of the Return Value
     */
    public Transform2 clone(Transform2 m) {
        // delete existing matrix in this
        Transform2 temp = new Transform2((RealSquareMatrix) m);
        temp.trnsfrm = m.trnsfrm;
        return temp;
    }
    
    /**
     * Carries out graphics transform
     *
     * transforms between rectangular coordinates.
     *  Example:
     * <pre>
     * Real2 inputDim = new Real2(2.7, 20000);
     * Real2 outputDim = new Real2(-300, 300);
     * </pre>
     *
     *@param  in                       Description of the Parameter
     *@param  out                      Description of the Parameter
     *@param  keepAspectRatio          Description of the Parameter
     *@exception  ArithmeticException  Description of the Exception
     *@throws  zero-sized              dimensions
     */
    public Transform2(Window2 in, Window2 out, boolean keepAspectRatio)
             throws ArithmeticException {
        this(in.origin, in.dim, out.origin, out.dim, keepAspectRatio);
    }


    /**
     *  graphics transform (transforms between rectangular coordinates
     *  ("windows") originIn maps onto originOut and dimensionIn (width, height)
     *  onto dimensionOut. If keepAspectRatio id true, scales will be isotropic.
     *  Note that ranges can be inverted by using negative coordinates in
     *  dimensions. Example:<pre>
     *Real2 inputDim = new Real2(2.7, 20000);
     *Real2 outputDim = new Real2(-300, 300);
     *</pre>
     *
     *@param  originIn                 Description of the Parameter
     *@param  dimensionIn              Description of the Parameter
     *@param  originOut                Description of the Parameter
     *@param  dimensionOut             Description of the Parameter
     *@param  keepAspectRatio          Description of the Parameter
     *@exception  ArithmeticException  Description of the Exception
     *@throws  zero-sized              dimensions
     */
    public Transform2(Real2 originIn, Real2 dimensionIn,
            Real2 originOut, Real2 dimensionOut, boolean keepAspectRatio) throws ArithmeticException {
        this();
        double scaleX;
        double scaleY;
        scaleX = dimensionOut.getX() / dimensionIn.getX();
        scaleY = dimensionOut.getY() / dimensionIn.getY();
        if (keepAspectRatio) {
            if (Math.abs(scaleX) < Math.abs(scaleY)) {
                scaleY = scaleX * (scaleY / Math.abs(scaleY));
            }
            if (Math.abs(scaleY) < Math.abs(scaleX)) {
                scaleX = scaleY * (scaleX / Math.abs(scaleX));
            }
        }
        flmat[0][0] = scaleX;
        flmat[1][1] = scaleY;
        flmat[0][2] = originOut.getX() - scaleX * originIn.getX();
        flmat[1][2] = originOut.getY() - scaleY * originIn.getY();
    }
    /**
     * seem to require this one
     * 
     * @param m
     *            Description of the Parameter
     * @return Description of the Return Value
     */
    Transform2 clone(RealSquareMatrix m) {
        Transform2 temp = new Transform2(m);
        temp.trnsfrm = calculateMatrixType();
        return temp;
    }
    /**
     * Description of the Method
     * 
     * @param m
     *            Description of the Parameter
     * @return Description of the Return Value
     */
    public boolean isEqualTo(Transform2 m) {
        return super.isEqualTo((RealSquareMatrix) m) && trnsfrm == m.trnsfrm;
    }
    
    /** rotate about a point.
     * 
     * @param angle
     * @param point
     * @return tramsformation
     */
    public static Transform2 getRotationAboutPoint(Angle angle, Real2 point) {
    	Transform2 t3 = new Transform2(new Vector2(point));
    	Transform2 t2 = new Transform2(angle);
    	Transform2 t1 = new Transform2(new Vector2(point.multiplyBy(-1.0)));
    	return t3.concatenate(t2).concatenate(t1);
    }

    /**
     * apply scales to each axis
     * @param scaleX
     * @param scaleY
     * @return transform
     */
    public static Transform2 applyScales(double scaleX, double scaleY) {
    	return new Transform2(
    		new double[] {
				scaleX, 0.0, 0.0,
				0.0, scaleY, 0.0,
				0.0, 0.0, 1.0
		});
    }
    
    /**
     * apply scale to each axis
     * @param scale
     * @return transform
     */
    public static Transform2 applyScale(double scale) {
    	return Transform2.applyScales(scale, scale);
    }
    
    /**
     * concatenate
     * 
     * @param m2 postmultiplies this
     * @return Description of the Return Value
     */
    public Transform2 concatenate(Transform2 m2) {
        RealSquareMatrix temp = new RealSquareMatrix(((RealSquareMatrix) this)
                    .multiply((RealSquareMatrix) m2));
        // maximum value is matrix of greatest generality (horrible)
        Transform2 temp1 = new Transform2(temp);
        temp1.trnsfrm = (trnsfrm.i > m2.trnsfrm.i) ? trnsfrm : m2.trnsfrm;
        return temp1;
    }
    /**
     * set transformation type may attempt to orthonomalise if type includes a
     * rotation
     * 
     * @param option
     *            The new transformationType value
     * @return Description of the Return Value
     */
    public int setTransformationType(Type option) {
        RealSquareMatrix s3 = new RealSquareMatrix();
        if (option == Type.ROT_ORIG) {
            s3 = new RealSquareMatrix(this.extractSubMatrixData(0, 1, 0, 1));
            s3.orthonormalize();
            this.replaceSubMatrixData(0, 0, s3);
        } else if (option == Type.ROT_TRANS) {
            s3 = new RealSquareMatrix(this.extractSubMatrixData(0, 1, 0, 1));
            s3.orthonormalize();
            this.replaceSubMatrixData(0, 0, s3);
        } else if (option == Type.ROT_TRANS_SCALE) {
            s3 = new RealSquareMatrix(this.extractSubMatrixData(0, 1, 0, 1));
            double[] scale = s3.euclideanColumnLengths().getArray();
            double scale3 = Math.exp(Math.log(scale[0] * scale[1]) / 2.0);
            s3.orthonormalize();
            RealArray sc1 = new RealArray(3, scale3);
            RealSquareMatrix s = RealSquareMatrix.diagonal(sc1);
            s3 = s.multiply(s3);
            replaceSubMatrixData(0, 0, s3);
        } else if (option == Type.ROT_TRANS_SCALE_PERSP) {
        } else if (option == Type.ROT_TRANS_AXIAL_SCALE) {
            s3 = new RealSquareMatrix(this.extractSubMatrixData(0, 1, 0, 1));
            RealArray scale = s3.euclideanColumnLengths();
            s3.orthonormalize();
            RealSquareMatrix s = RealSquareMatrix.diagonal(scale);
            s3 = s.multiply(s3);
            replaceSubMatrixData(0, 0, s3);
        } else if (option == Type.ANY) {
        } else if (option == Type.NULL) {
        } else {
            return 1;
        }
        trnsfrm = option;
        return 0;
    }
    /**
     * get transformation type
     * 
     * @return The transformationType value
     */
    public Type getTransformationType() {
        return trnsfrm;
    }
    /**
     * get new matrix type
     * 
     * @return Description of the Return Value
     */
    public Type calculateMatrixType() {
        RealSquareMatrix s3 = new RealSquareMatrix(extractSubMatrixData(0, 1, 0, 1));
        RealArray c3 = extractColumnData(2);
        if (c3 != null) {
            if (Real.isZero(c3.elementAt(0), Real.getEpsilon()) &&
            		Real.isZero(c3.elementAt(1), Real.getEpsilon())) {
                return Type.NULL;
            }
        }
        {
            if (s3.isUnit()) {
                return Type.NULL;
            }
            // unit matrix
            if (s3.isUnitary()) {
                return Type.ROT_ORIG;
            }
            // unitary matrix
        }
        if (s3.isUnitary()) {
            return Type.ROT_TRANS;
        }
        // rot + trans; no scale
        if (s3.isOrthogonal()) {
            double[] scale = s3.euclideanColumnLengths().getArray();
            if (Real.isEqual(scale[0], scale[1])) {
                return Type.ROT_TRANS_SCALE;
            }
            return Type.ROT_TRANS_AXIAL_SCALE;
        }
        return Type.ANY;
    }
    /**
     * interpret current matrix as rotation about axis NOT YET CHECKED; only
     * worsk for orthornormal matrices
     * 
     * @return The angleOfRotation value
     */
    public Angle getAngleOfRotation() {
        return new Angle(Math.atan2(flmat[0][1], flmat[0][0]));
    }
    /**
     * get Transformation to mirror ('flip') across an axis NOT YET CHECKED
     * 
     * @param r
     *            Description of the Parameter
     * @return Description of the Return Value
     * @exception EuclidRuntimeException
     *                <TT>r</TT> is zero length
     */
    public static Transform2 flipAboutVector(Real2 r) throws EuclidRuntimeException {
        r = r.getUnitVector();
        double cost = r.x;
        double sint = r.y;
        Transform2 temp = new Transform2();
        temp.flmat[0][0] = cost * cost - sint * sint;
        temp.flmat[1][1] = -temp.flmat[0][0];
        temp.flmat[0][1] = temp.flmat[1][0] = 2 * cost * sint;
        return temp;
    }
    /**
     * get translation component only
     * 
     * @return The translation value
     */
    public Real2 getTranslation() {
        return new Real2(flmat[0][2], flmat[1][2]);
    }
    /**
     * get scales (as a 2-element RealArray)
     * 
     * @return The scales value
     */
    RealArray getScales() {
        RealArray scales;
        RealSquareMatrix s3 = new RealSquareMatrix(extractSubMatrixData(0, 1, 0, 1));
        scales = s3.euclideanColumnLengths();
        return scales;
    }
    /**
     * get Unitary matrix (that is eliminate scales and translation)
     * 
     * @return The rotationMatrix value
     */
    public RealSquareMatrix getRotationMatrix() {
        RealSquareMatrix s;
        RealSquareMatrix s3 = new RealSquareMatrix(extractSubMatrixData(0, 1, 0, 1));
        s3.normaliseByColumns();
        s = s3;
        return s;
    }
    
	/**
	 * transform describing the rotation and stretching of a line.
	 * used in bondTool.getTranformToRotateAndStretchBond(movingAtom, targetPoint);
	 * 
		Transform2 t = this.getTranformToRotateAndStretchLine(movingAtom, targetPoint) {
	 * @param pivotPoint
	 * @param movingPoint
	 * @param targetPoint point to translate movingAtom to
	 * @return
	 */
	public static Transform2 getTransformToRotateAndStretchLine(Real2 pivotPoint, Real2 movingPoint, Real2 targetPoint) {
		Vector2 pivotVector = new Vector2(movingPoint.subtract(pivotPoint));
		Vector2 targetVector = new Vector2(targetPoint.subtract(pivotPoint));
		Angle angle = pivotVector.getAngleMadeWith(targetVector);
		Transform2 rotate = new Transform2(angle);
		Transform2 rotateAboutOtherPoint = new Transform2(rotate, pivotPoint);
		Vector2 deltaVector = new Vector2(targetVector.subtract(pivotVector));
		Vector2 stretchVector = deltaVector.projectOnto(pivotVector);
		Transform2 stretch = new Transform2(stretchVector);
		Transform2 finalTransform = rotateAboutOtherPoint.concatenate(stretch);
		return finalTransform;
	}
	
    /**
     * Description of the Method
     * 
     * @return Description of the Return Value
     */
    public String toString() {
        String s = S_LBRAK;
        for (int i = 0; i < this.flmat.length; i++) {
            for (int j = 0; j < this.flmat[i].length; j++) {
                s += flmat[i][j];
                s += S_COMMA;
            }
            if (i < flmat.length - 1) {
                s += S_NEWLINE;
            }
        }
        s += S_RBRAK;
        return s;
    }
}
