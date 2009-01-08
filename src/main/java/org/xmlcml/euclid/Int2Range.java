package org.xmlcml.euclid;


/**
 * 
 * 2-D int limits
 * 
 * Contains two IntRanges. Can therefore be used to describe 2-dimensional
 * limits (for example axes of graphs, rectangles in graphics, limits of a
 * molecule, etc.)
 * <P>
 * Default is two default/invalid IntRange components. Adding points will create
 * valid ranges.
 * 
 * @author (C) P. Murray-Rust, 1996
 */
public class Int2Range implements EuclidConstants {
    /**
     * X-range
     */
    IntRange xrange;
    /**
     * Y-range
     */
    IntRange yrange;
    /**
     * creates zero range.
     * 
     * 
     */
    public Int2Range() {
        xrange = new IntRange();
        yrange = new IntRange();
    }
    /**
     * initialise with min and max values;
     * 
     * @param xr
     * @param yr
     */
    public Int2Range(IntRange xr, IntRange yr) {
        if (xr.isValid() && yr.isValid()) {
            xrange = xr;
            yrange = yr;
        }
    }
    /**
     * copy constructor
     * 
     * @param r
     */
    public Int2Range(Int2Range r) {
        if (r.isValid()) {
            xrange = new IntRange(r.xrange);
            yrange = new IntRange(r.yrange);
        }
    }
    /**
     * a Int2Range is valid if both its constituent ranges are
     * 
     * @return valid
     */
    public boolean isValid() {
        return (xrange != null && yrange != null && xrange.isValid() && yrange
                .isValid());
    }
    /**
     * is equal to.
     * 
     * @param r2
     * @return true if equal
     */
    public boolean isEqualTo(Int2Range r2) {
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
    public Int2Range plus(Int2Range r2) {
        if (!isValid()) {
            if (r2 == null || !r2.isValid()) {
                return new Int2Range();
            } else {
                return new Int2Range(r2);
            }
        }
        if (r2 == null || !r2.isValid()) {
            return new Int2Range(this);
        }
        return new Int2Range(xrange.plus(r2.xrange), yrange.plus(r2.yrange));
    }
    /**
     * intersect two ranges and take the range common to both; return invalid
     * range if no overlap or either is null/invalid
     * 
     * @param r2
     * @return range
     * 
     */
    public Int2Range intersectionWith(Int2Range r2) {
        if (!isValid() || r2 == null || !r2.isValid()) {
            return new Int2Range();
        }
        IntRange xr = this.getXRange().intersectionWith(r2.getXRange());
        IntRange yr = this.getYRange().intersectionWith(r2.getYRange());
        return new Int2Range(xr, yr);
    }
    /**
     * get xrange
     * 
     * @return range
     */
    public IntRange getXRange() {
        return xrange;
    }
    /**
     * get yrange
     * 
     * @return range
     */
    public IntRange getYRange() {
        return yrange;
    }
    /**
     * is an Int2 within a Int2Range
     * 
     * @param p
     * @return includes
     */
    public boolean includes(Int2 p) {
        if (!isValid()) {
            return false;
        }
        return (xrange.includes(p.getX()) && yrange.includes(p.getY()));
    }
    /**
     * is one Int2Range completely within another
     * 
     * @param r
     * @return includes
     */
    public boolean includes(Int2Range r) {
        if (!isValid() || r == null || !r.isValid()) {
            return false;
        }
        IntRange xr = r.getXRange();
        IntRange yr = r.getYRange();
        return (xrange.includes(xr) && yrange.includes(yr));
    }
    /**
     * add a Int2 to a range
     * 
     * @param p
     */
    public void add(Int2 p) {
        xrange.add(p.getX());
        yrange.add(p.getY());
    }
    /**
     * to string.
     * 
     * @return string
     */
    public String toString() {
        return EC.S_LBRAK + xrange.toString() + EC.S_COMMA + yrange.toString() + EC.S_RBRAK;
    }
}