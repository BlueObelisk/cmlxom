package org.xmlcml.euclid;

/** line
 * determined by one point (R) and a vector (V)
 * this gives L = R + nV
 * can assume that R and R+V are the two "ends of the line"
 * the semantics of this are application-dependent
 * @author pm286
 *
 */
public class Line2 implements EuclidConstants {

	Real2 from;
	Real2 to;
	Vector2 vector;
	Vector2 unitVector = null;

	// lazy evaluation
	private double slope = Double.NaN;
	private double c = Double.NaN;
	private double xint = Double.NaN;
	
	/**
	 * generates vector
	 * @param from
	 * @param to
	 */
	public Line2(Real2 from, Real2 to) {
		vector = new Vector2(to.subtract(from));
		if (vector.getLength() < Real.EPS) {
			throw new EuclidRuntimeException("Cannot form line from coincident points");
		}
		this.from = new Real2(from);
		this.to = new Real2(to);
		init();
	}
	
	private void init() {
		slope = Double.NaN;
		c = Double.NaN;
		xint = Double.NaN;
	}
	
	/**
	 * generates to
	 * @param from
	 * @param v
	 */
	public Line2(Real2 from, Vector2 v) {
		if (v.getLength() < Real.EPS) {
			throw new EuclidRuntimeException("Cannot form line from coincident points");
		}
		this.from = new Real2(from);
		this.vector = new Vector2(v);
		to = from.plus(v);
	}

	/** get slope.
	 * "m" in y=m*x+c
	 * if x component is zero returns Double.*_INFINITY;
	 * @return slope, Double.POSITIVE_INFINITY or Double.NEGATIVE_INFINITY;
	 */
	public double getSlope() {
		if (Double.isNaN(slope)) {
			try { 
				slope = vector.getY() / vector.getX();
			} catch (ArithmeticException ae) {
				slope = (vector.getY() > 0) ? Double.POSITIVE_INFINITY : Double.NEGATIVE_INFINITY;
			}
		}
		return slope;
	}

	/**
	 * 	 * "c" in y=m*x+c
	 * @return intercept or Double.NaN if slope is infinite
	 */
	public double getYIntercept() {
		if (Double.isNaN(c)) {
			getSlope();
			if (!Double.isNaN(slope) && 
				slope < Double.POSITIVE_INFINITY &&
				slope > Double.NEGATIVE_INFINITY
				) {
				c = from.getY() - from.getX() * slope;
			}
		}
		return c;
	}
	
	/**
	 * "c" in y=m*x+c
	 * @return intercept or Double.NaN if slope is infinite
	 */
	public double getXIntercept() {
		if (Double.isNaN(xint)) {
			getYIntercept();
			if (Double.isNaN(slope) || 
					Double.compare(slope, Double.NEGATIVE_INFINITY) == 0 ||
					Double.compare(slope, Double.POSITIVE_INFINITY) == 0
					) {
				xint = from.getX();
			} else if(Math.abs(slope) > Real.EPS) {
				xint = - c / slope;
			}
		}
		return xint;
	}

	/** get intersection of two lines
	 * see softSurfer algorithm
	 * @param line1
	 * @return null if parallel or antiparallel
	 */
	public Real2 getIntersection(Line2 line1) {
		Real2 inter = null;
		if (this.from.getDistance(line1.from) < Real.EPS) {
			inter = this.from;
		} else {
			double perpv = this.vector.getPerpProduct(line1.vector);
			Vector2 w = new Vector2(this.from.subtract(line1.from));
			double perpw = line1.vector.getPerpProduct(w);
			// this = point + lambda * vector;
			double lambda = perpw / perpv;
			Real2 vv = vector.multiplyBy(lambda);
			inter = this.from.plus(vv); 
		}
		return inter;
	}
	
	/** swaps to and from coordinates.
	 * 
	 */
	public void flipCoordinates() {
		Real2 temp = from;
		from = to;
		to = temp;
	}
	
	/**
	 * get unit vector convenience
	 * @return vector
	 */
	public Vector2 getUnitVector() {
		if (unitVector == null) {
			unitVector = new Vector2(vector.getUnitVector());
		}
		return unitVector;
	}
	/** perpendiculat distance from point to infinite line.
	 * @param point
	 * @return distance
	 */
	public double getDistanceFromPoint(Real2 point) {
		getUnitVector();
//		System.out.println(unitVector);
		Vector2 w = new Vector2(point.subtract(from));
//		System.out.println(w);
		return unitVector.getPerpProduct(w);
	}

	/** perpendiculat distance from point to infinite line.
	 * @param point
	 * @return distance
	 */
	public Real2 getNearestPointOnLine(Real2 point) {
		getUnitVector();
		Vector2 lp = new Vector2(point.subtract(this.from));
//		Vector2 ulp = new Vector2(lp.getUnitVector());
		double lambda = unitVector.dotProduct(lp);
		Real2 vv = unitVector.multiplyBy(lambda);
		return from.plus(vv);
	}
	
	/** convenience method.
	 * gets angle formed between lines using 
	 * Vector2.getAngleMadeWith(Vector2)
	 * @param line
	 * @return angle or null
	 */
	public Angle getAngleMadeWith(Line2 line) {
		Angle angle = null;
		if (line != null) {
			angle = this.getVector().getAngleMadeWith(line.getVector());
		}
		return angle;
	}
	
	/** gets multiplier of point from "from"
	 * finds nearest point (pp) on line (so avoids rounding errors)
	 * then finds pp = from + vector * lambda
	 * if pp is within segment , lambda is 0, 1
	 * @param p
	 * @return lambda
	 */
	public double getLambda(Real2 p) {
		Real2 near = this.getNearestPointOnLine(p);
		Real2 delta = near.subtract(from);
		double lambda = (Math.abs(vector.getX()) > Math.abs(vector.getY())) ?
			delta.getX() / vector.getX() : delta.getY() / vector.getY();
		return lambda;
	}

	/** get mid point
	 * @return mid point
	 */
	public Real2 getMidPoint() {
		Real2 mm = this.from.plus(this.to);
		return mm.multiplyBy(0.5);
	}

	/** get length
	 * @return length
	 */
	public double getLength() {
		return vector.getLength();
	}

	/**
	 * @return the from
	 */
	public Real2 getFrom() {
		return from;
	}

	/**
	 * @return the to
	 */
	public Real2 getTo() {
		return to;
	}

	/** get point at either end.
	 * 
	 * @param i (0/from or 1/to)
	 * @return
	 */
	public Real2 getXY(int i) {
		Real2 xy = null;
		if (i == 0) {
			xy = from;
		} else if (i == 1) {
			xy = to;
		} else {
			throw new EuclidRuntimeException("Bad point in Line2 "+i);
		}
		return xy;
	}

	/** set point at either end.
	 * 
	 * @param i (0/from or 1/to)
	 * @return
	 */
	public void setXY(Real2 xy, int i) {
		if (i == 0) {
			from = new Real2(xy);
		} else if (i == 1) {
			to = new Real2(xy);
		} else {
			throw new EuclidRuntimeException("Bad point in Line2 "+i);
		}
	}

	/**
	 * @return the vector
	 */
	public Vector2 getVector() {
		return vector;
	}
	/**
	 * @return string
	 */
	public String toString() {
		return "line: from("+from+") to("+to+") v("+vector+")";
	}

}
