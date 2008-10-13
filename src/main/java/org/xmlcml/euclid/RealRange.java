package org.xmlcml.euclid;


/**
 * maximum and minimum values
 * 
 * Contains two doubles representing the minimum and maximum of an allowed or
 * observed range.
 * <P>
 * Default is range with low > high; this can be regarded as the uninitialised
 * state. If points are added to a default RealRange it becomes initialised.
 * 
 * @author (C) P. Murray-Rust, 1996
 */
public class RealRange implements EuclidConstants {
    /**
     * maximum of range
     */
    protected double maxval;
    /**
     * minimum of range
     */
    protected double minval;
    /**
     * creates invalid range from POSITIVE_INFINITY to NEGATIVE_INFINITY
     */
    public RealRange() {
        minval = Double.POSITIVE_INFINITY;
        maxval = Double.NEGATIVE_INFINITY;
    }
    /**
     * initialise with min and max values; if minv > maxv create inValid
     * RealRange
     * 
     * @param minv
     * @param maxv
     */
    public RealRange(double minv, double maxv) {
        setRange(minv, maxv);
    }
    
    /**
     * initialise with min and max values; if minv > maxv create inValid
     * RealRange
     * 
     * @param minv
     * @param maxv
     * @param normalize swap params if min > max
     */
    public RealRange(double minv, double maxv, boolean normalize) {
    	if (minv > maxv) {
    		double temp = minv;
    		minv = maxv;
    		maxv = temp;
    	}
        setRange(minv, maxv);
    }
    /** sets range.
     * overwrites any previous info
     * @param minv
     * @param maxv
     */
    public void setRange(double minv, double maxv) {
        maxval = maxv;
        minval = minv;
        if (minval > maxval) {
            minval = Double.POSITIVE_INFINITY;
            maxval = Double.NEGATIVE_INFINITY;
        }
    }
    /**
     * copy constructor
     * 
     * @param r
     */
    public RealRange(RealRange r) {
        minval = r.minval;
        maxval = r.maxval;
    }
    /**
     * from an IntRange
     * 
     * @param ir
     */
    public RealRange(IntRange ir) {
        minval = (double) ir.minval;
        maxval = (double) ir.maxval;
    }
    /**
     * a Range is only valid if its maxval is not less than its minval; this
     * tests for uninitialised ranges
     * 
     * @return valid
     */
    public boolean isValid() {
        return (minval <= maxval);
    }
    /**
     * invalid ranges return false
     * 
     * @param r
     * @return equal
     */
    public boolean isEqualTo(RealRange r) {
        return (r != null && Real.isEqual(minval, r.minval)
                && Real.isEqual(maxval, r.maxval) && minval <= maxval);
    }
    /**
     * combine two ranges if both valid; takes greatest limits of both, else
     * returns InValid
     * 
     * @param r2
     * @return range
     */
    public RealRange plus(RealRange r2) {
        if (!this.isValid()) {
            if (r2 == null || !r2.isValid()) {
                return new RealRange();
            }
            return new RealRange(r2);
        }
        RealRange temp = new RealRange();
        temp = new RealRange(Math.min(minval, r2.minval), Math.max(maxval,
                r2.maxval));
        return temp;
    }
    /**
     * intersect two ranges and take the range common to both;
     * return null if no overlap
     * 
     * @param r2
     * @return range
     */
    public RealRange intersectionWith(RealRange r2) {
    	RealRange inter = null;
        if (isValid() && r2 != null && r2.isValid()) {
	        double minv = Math.max(minval, r2.minval);
	        double maxv = Math.min(maxval, r2.maxval);
	        if (minv <= maxv) {
	        	inter = new RealRange(minv, maxv);
	        }
        }
        return inter;
    }
    /**
     * get minimum value (POSITIVE_INFINITY if inValid)
     * 
     * @return min
     */
    public double getMin() {
        return minval;
    }
    
    /**
     * get maximum value (NEGATIVE_INFINITY if inValid)
     * 
     * @return max
     */
    public double getMax() {
        return maxval;
    }
    
    /**
     * get centroid value (NEGATIVE_INFINITY if inValid)
     * 
     * @return centroid
     */
    public double getMidPoint() {
        return (minval + maxval) * 0.5;
    }
    
    /**
     * get range (NaN if invalid)
     * 
     * @return range
     */
    public double getRange() {
        if (!isValid())
            return Double.NaN;
        return maxval - minval;
    }
    /**
     * does one range include another
     * 
     * @param r2
     * @return includes
     */
    public boolean includes(RealRange r2) {
        return (r2 != null && r2.isValid() && this.includes(r2.getMin()) && this
                .includes(r2.getMax()));
    }
    /**
     * is a double within a RealRange
     * 
     * If inValid, return false
     * 
     * @param f
     * @return includes
     */
    public boolean includes(double f) {
        return f >= minval && f <= maxval;
    }
    /**
     * synonym for includes()
     * 
     * @param f
     * @return includes
     */
    public boolean contains(double f) {
        return includes(f);
    }
    /**
     * add a value to a range
     * 
     * @param x
     */
    public void add(double x) {
        maxval = Math.max(maxval, x);
        minval = Math.min(minval, x);
    }
    /** return a number uniformaly distributed within the range.
     * 
     * @return number.
     */
    public double getRandomVariate() {
        double range = maxval - minval;
        return minval + Math.random() * range;
    }

    /** get scale to convert this range to same extent as other.
     * 
     * @param range to scale to
     * @return scale or Double.NaN
     */
    public double getScaleTo(RealRange range) {
    	double scale = Double.NaN;
    	
    	return scale;
    }
    
    /**
     * if min > max swap them
     */
    public void normalize() {
		if (minval > maxval) {
			double temp = minval;
			minval = maxval;
			maxval = temp;
		}
    }
    /**
     * to string. format: "NULL" or S_LBRAK+minval+S_COMMA+maxval+S_RBRAK;
     * 
     * @return string
     */
    public String toString() {
        return (minval > maxval) ? "NULL" : S_LBRAK + minval + S_COMMA + maxval + S_RBRAK;
    }
}
