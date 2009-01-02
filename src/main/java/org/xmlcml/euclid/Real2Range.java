package org.xmlcml.euclid;
import org.xmlcml.euclid.Axis.Axis2;
/**
 * 2-D double limits Contains two RealRanges. Can therefore be used to describe
 * 2-dimensional limits (for example axes of graphs, rectangles in graphics,
 * limits of a molecule, etc.)
 * <P>
 * Default is two default/invalid RealRange components. Adding points will
 * create valid ranges.
 * 
 * @author (C) P. Murray-Rust, 1996
 */
public class Real2Range implements EuclidConstants {
    /**
     * X-range
     */
    RealRange xrange;
    /**
     * Y-range
     */
    RealRange yrange;
    /**
     * constructor.
     */
    public Real2Range() {
    }
    /**
     * initialise with min and max values;
     * 
     * @param xr
     * @param yr
     */
    public Real2Range(RealRange xr, RealRange yr) {
        if (xr.isValid() && yr.isValid()) {
            xrange = xr;
            yrange = yr;
        }
    }
    
    public Real2Range(Real2 r2a, Real2 r2b) {
    	double x0 = r2a.getX();
    	double x1 = r2b.getX();
    	xrange = new RealRange(Math.min(x0, x1), Math.max(x0, x1));
    	double y0 = r2a.getY();
    	double y1 = r2b.getY();
    	yrange = new RealRange(Math.min(y0, y1), Math.max(y0, y1));
    }
    
    /**
     * copy constructor
     * 
     * @param r
     */
    public Real2Range(Real2Range r) {
        if (r.isValid()) {
            xrange = new RealRange(r.xrange);
            yrange = new RealRange(r.yrange);
        }
    }
    /**
     * a Real2Range is valid if both its constituent ranges are
     * 
     * @return valid
     */
    public boolean isValid() {
        return (xrange != null && yrange != null && xrange.isValid() && yrange
                .isValid());
    }
    /**
     * is equals to.
     * 
     * @param r2
     * @return tru if equal
     */
    public boolean isEqualTo(Real2Range r2) {
        if (isValid() && r2 != null && r2.isValid()) {
            return (xrange.isEqualTo(r2.xrange) && yrange.isEqualTo(r2.yrange));
        } else {
            return false;
        }
    }
    /**
     * merge two ranges and take the maximum extents
     * 
     * @param r2
     * @return range
     */
    public Real2Range plus(Real2Range r2) {
        if (!isValid()) {
            if (r2 == null || !r2.isValid()) {
                return new Real2Range();
            } else {
                return new Real2Range(r2);
            }
        }
        if (r2 == null || !r2.isValid()) {
            return new Real2Range(this);
        }
        return new Real2Range(xrange.plus(r2.xrange), yrange.plus(r2.yrange));
    }
    /**
     * intersect two ranges and take the range common to both; return invalid
     * range if no overlap or either is null/invalid
     * 
     * @param r2
     * @return range
     * 
     */
    public Real2Range intersectionWith(Real2Range r2) {
        if (!isValid() || r2 == null || !r2.isValid()) {
            return new Real2Range();
        }
        RealRange xr = this.getXRange().intersectionWith(r2.getXRange());
        RealRange yr = this.getYRange().intersectionWith(r2.getYRange());
        return (xr == null || yr == null) ? null : new Real2Range(xr, yr);
    }
    
    /**
     * get xrange
     * 
     * @return range
     */
    public RealRange getXRange() {
        return xrange;
    }
    /**
     * get yrange
     * 
     * @return range
     */
    public RealRange getYRange() {
        return yrange;
    }
    
    /**
     * get yrange
     * 
     * @return range
     */
    public Real2 getCentroid() {
        return new Real2(xrange.getMidPoint(), yrange.getMidPoint());
    }
    
    /** gets lower left and upper right.
     * @return minx,miny ... maxx, maxy
     */
    public Real2[] getCorners() {
    	Real2[] rr = new Real2[2];
    	rr[0] = new Real2(xrange.getMin(), yrange.getMin());
    	rr[1] = new Real2(xrange.getMax(), yrange.getMax());
    	return rr;
    }
    
    /**
     * is an Real2 within a Real2Range
     * 
     * @param p
     * @return includes
     */
    public boolean includes(Real2 p) {
        if (!isValid()) {
            return false;
        }
        return (xrange.includes(p.getX()) && yrange.includes(p.getY()));
    }
    /**
     * is one Real2Range completely within another
     * 
     * @param r
     * @return includes
     */
    public boolean includes(Real2Range r) {
        if (!isValid() || r == null || !r.isValid()) {
            return false;
        }
        RealRange xr = r.getXRange();
        RealRange yr = r.getYRange();
        return (xrange.includes(xr) && yrange.includes(yr));
    }
    /**
     * add a Real2 to a range
     * 
     * @param p
     */
    public void add(Real2 p) {
        if (p == null)
            return;
        if (xrange == null)
            xrange = new RealRange();
        if (yrange == null)
            yrange = new RealRange();
        xrange.add(p.getX());
        yrange.add(p.getY());
    }
    /**
     * merge range for given axis.
     * 
     * @param ax
     *            axis
     * @param range
     */
    public void add(Axis2 ax, RealRange range) {
        if (range == null)
            return;
        if (ax.equals(Axis2.X)) {
            if (xrange == null) {
                xrange = new RealRange();
            }
            xrange = xrange.plus(range);
        }
        if (ax.equals(Axis2.Y)) {
            if (yrange == null) {
                yrange = new RealRange();
            }
            yrange = yrange.plus(range);
        }
    }

    /** gets minimum X and Y translations required to move point into range
     * uses RealRange.distanceOutside() - see this
     * @param p 
     * @return null if p == null or has bad coordinates; Real2(0,0) if in or on range, else translations to touch range
     */
    public Real2 distanceOutside(Real2 p) {
    	Real2 r2 = null;
    	if (p != null) {
	    	double dx = xrange.distanceOutside(p.getX());
	    	double dy = yrange.distanceOutside(p.getY());
	    	if (!Double.isNaN(dx) && !Double.isNaN(dy)) {
	    		r2 = new Real2(dx, dy);
	    	}
    	}
    	return r2;
    }

    /**
     * to string.
     * 
     * @return string
     */
    public String toString() {
        String xx = (xrange == null) ? "NULL" : xrange.toString();
        String yy = (yrange == null) ? "NULL" : yrange.toString();
        return S_LBRAK + xx + S_COMMA + yy + S_RBRAK;
    }
}
