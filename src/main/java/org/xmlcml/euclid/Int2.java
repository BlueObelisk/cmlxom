package org.xmlcml.euclid;
import java.util.Arrays;
/**
 * A pair of integers with no other assumptions Contains two ints.
 * 
 * The default value is 0, 0.
 * 
 * @author (C) P. Murray-Rust, 1996
 */
public class Int2 implements EuclidConstants {
    /** the first integer value */
    int x;
    /** the second integer value */
    int y;
    /**
     * constructor.
     */
    public Int2() {
        x = 0;
        y = 0;
    }
    /**
     * constructor.
     * 
     * @param x
     * @param y
     */
    public Int2(int x, int y) {
        this.x = x;
        this.y = y;
    }
    /**
     * copy constructor
     * 
     * @param r
     */
    public Int2(Int2 r) {
        this.x = r.x;
        this.y = r.y;
    }
    /**
     * swaps the x and y values
     */
    public void swap() {
        int t = x;
        x = y;
        y = t;
    }
    /**
     * sorts x and y so that x <= y
     */
    public void sortAscending() {
        if (x > y)
            this.swap();
    }
    /**
     * sorts x and y so that x >= y
     */
    public void sortDescending() {
        if (x < y)
            this.swap();
    }
    /**
     * set to 0, 0
     */
    public void clear() {
        x = y = 0;
    }
    /**
     * set x.
     * 
     * @param xx
     */
    public void setX(int xx) {
        x = xx;
    }
    /**
     * set y.
     * 
     * @param yy
     */
    public void setY(int yy) {
        y = yy;
    }
    /**
     * is equal to.
     * 
     * @param r
     * @return true if equal
     */
    public boolean isEqualTo(Int2 r) {
        return (x == r.x && y == r.y);
    }
    /**
     * add two points to give vector sum
     * 
     * @param r2
     * @return new point
     */
    public Int2 plus(Int2 r2) {
        return new Int2(x + r2.x, y + r2.y);
    }
    /**
     * subtract two points to give vector difference
     * 
     * @param r2
     * @return point
     */
    public Int2 subtract(Int2 r2) {
        return new Int2(x - r2.x, y - r2.y);
    }
    /**
     * multiply both components by minus one MODIFIES 'this'
     */
    public void negative() {
        this.x = -this.x;
        this.y = -this.y;
    }
    /**
     * multiply a point by a scalar
     * 
     * @param f
     * @return point
     */
    public Int2 multiplyBy(int f) {
        return new Int2(x * f, y * f);
    }
    /**
     * get X value
     * 
     * @return value
     */
    public int getX() {
        return x;
    }
    /**
     * get Y value
     * 
     * @return value
     */
    public int getY() {
        return y;
    }
    /**
     * get either value; counts from ZERO
     * 
     * @param elem
     * @return element
     * @throws EuclidRuntimeException
     */
    public int elementAt(int elem) throws EuclidRuntimeException {
        if (elem == 0) {
            return x;
        } else if (elem == 1) {
            return y;
        }
        throw new EuclidRuntimeException("bad index " + elem);
    }
    /**
     * point midway between 'this' and 'p'
     * 
     * @param p
     * @return midpoint
     */
    public Int2 getMidPoint(Int2 p) {
        return new Int2((this.x + p.x) / 2, (this.y + p.y) / 2);
    }
    /**
     * get dot product
     * 
     * @param r
     * @return dot
     */
    public int dotProduct(Int2 r) {
        return (this.x * r.x + this.y * r.y);
    }
    /**
     * to string.
     * 
     * @return string
     */
    public String toString() {
        return EC.S_LBRAK + x + EC.S_COMMA + y + EC.S_RBRAK;
    }
}
/**
 * Int2Array is NOT a Vector of Int2s, but a container for a 2-D array with a
 * variety of ways of managing the data including IntArrays for the x and y
 * arrays, and also an array of Int2s The latter is only stored if required, and
 * then is cached.
 */
class Int2Array {
    // store in both ways... (wasteful but convenient)
    IntArray xarr;
    IntArray yarr;
    Int2[] xy;
    int nelem = 0;
    private boolean expanded = false;
    /**
     * default constructor gives an array of 0 points
     */
    public Int2Array() {
    }
    /**
     * get max and min value of Int2_Array
     * 
     * @return range
     */
    public Int2Range getRange2() {
        Int2Range temp = new Int2Range();
        expand();
        for (int i = 0; i < nelem; i++) {
            temp.add(elementAt(i));
        }
        return temp;
    }
    /**
     * make an Int2Array from 2 IntArrays. copies each.
     * 
     * @param x
     * @param y
     * @exception EuclidRuntimeException unequal sized arrays
     */
    public Int2Array(IntArray x, IntArray y) throws EuclidRuntimeException {
        if (x.size() != y.size()) {
            throw new EuclidRuntimeException("arrays of different sizes");
        }
        nelem = x.size();
        xarr = (IntArray) x.clone();
        yarr = (IntArray) y.clone();
        expanded = false;
    }
    private void expand() {
        if (expanded)
            return;
        expanded = true;
        xy = new Int2[nelem];
        try {
            for (int i = 0; i < nelem; i++) {
                xy[i] = new Int2(xarr.elementAt(i), yarr.elementAt(i));
            }
        } catch (Exception e) {
            Util.BUG(e);
        }
    }
    /**
     * size of array
     * 
     * @return size
     */
    public int size() {
        return nelem;
    }
    /**
     * get element.
     * 
     * @param elem
     * @return element
     */
    public Int2 elementAt(int elem) {
        expand();
        return xy[elem];
    }
    /** hash code.
     * @return hash code
     */
    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + ((xarr == null) ? 0 : xarr.hashCode());
        result = PRIME * result + Arrays.hashCode(xy);
        result = PRIME * result + ((yarr == null) ? 0 : yarr.hashCode());
        return result;
    }
    /** equals.
     * @param obj
     * @return equality
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Int2Array other = (Int2Array) obj;
        if (xarr == null) {
            if (other.xarr != null)
                return false;
        } else if (!xarr.equals(other.xarr))
            return false;
        if (!Arrays.equals(xy, other.xy))
            return false;
        if (yarr == null) {
            if (other.yarr != null)
                return false;
        } else if (!yarr.equals(other.yarr))
            return false;
        return true;
    }
    
}
