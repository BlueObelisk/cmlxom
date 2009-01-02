package org.xmlcml.euclid;

import org.apache.log4j.Logger;


/**
 * Real2Array is NOT a Vector of Real2s but a container for a 2 * n matrix
 * 
 * with a variety of ways of managing the data including RealArrays for the x
 * and y arrays, and also an array of Real2s The latter is only stored if
 * required, and then is cached.
 * 
 * Note that we also have Real2Vector which acts like a List<Real2>. We may
 * therefore obsolete the Real2Array at some time - it is not used in Jumbo
 * elsewhere although it might be useful for spectra.
 * 
 * NOTE: I think it's used quite a lot in fact...
 * 
 * @author P.Murray-Rust, Copyright 1997
 */
public class Real2Array implements EuclidConstants {
	@SuppressWarnings("unused")
	private static Logger LOG = Logger.getLogger(Real2Array.class);
	
    RealArray xarr;
    RealArray yarr;
    int nelem = 0;
    /**
     * default constructor gives an array of 0 points
     */
    public Real2Array() {
    }
    /**
     * get max and min value of Real2_Array
     * 
     * @return range
     */
    public Real2Range getRange2() {
        Real2Range range = new Real2Range();
        for (int i = 0; i < nelem; i++) {
            Real2 r2 = new Real2(xarr.elementAt(i), yarr.elementAt(i));
            range.add(r2);
        }
        return range;
    }

    /** copy
     * 
     * @param r2a
     */
    public Real2Array(Real2Array r2a) {
    	if (r2a != null && !r2a.equals(this)) {
    		xarr = new RealArray(r2a.getXArray());
    		yarr = new RealArray(r2a.getYArray());
    		this.nelem = r2a.nelem;
    	}
    }
    /**
     * make an Real2_Array from 2 RealVec's; takes a copy
     * 
     * @param x
     * @param y
     * @exception EuclidRuntimeException
     *                x and x must have number of elements
     */
    public Real2Array(RealArray x, RealArray y) throws EuclidRuntimeException {
        if (x.size() != y.size()) {
            throw new EuclidRuntimeException("incompatible array sizes "+x.size()+"/"+y.size());
        }
        nelem = x.size();
        xarr = (RealArray) x.clone();
        yarr = (RealArray) y.clone();
    }

    /**
     * @param r2
     */
    public void add(Real2 r2) {
    	if (nelem == 0 || xarr == null || yarr == null) {
    		xarr = new RealArray();
    		yarr = new RealArray();
    	}
    	xarr.addElement(r2.getX());
    	yarr.addElement(r2.getY());
    	nelem++;
    }
    
    /**
     * @param real2Array
     */
    public void add(Real2Array real2Array) {
    	if (real2Array != null) {
	    	if (nelem == 0 || xarr == null || yarr == null) {
	    		xarr = new RealArray();
	    		yarr = new RealArray();
	    	}
	    	xarr.addArray(real2Array.xarr);
	    	yarr.addArray(real2Array.yarr);
	    	nelem += real2Array.size();
	    }
    }
    
    /**
     * make an Real2_Array from pairs of numbers separated by delimiter
     * 
     * @param s
     * @param delimiter (might be a regex e.g. ",| " (comma or space))
     * @exception EuclidRuntimeException
     *                x and x must have number of elements
     */
    public static Real2Array createFromPairs(String sss, String delimiter) {
    	Real2Array real2Array = null;
    	if (sss != null) {
    		String[] ss = sss.split(delimiter);
    		if (ss.length % 2 == 0) {
            	RealArray realArray = new RealArray(ss);
    	    	real2Array = Real2Array.createFromPairs(realArray);
    		}
    	}
    	return real2Array;
    }
    
    /**
     * make an Real2_Array from pairs of numbers x1,y1 .. x2,y2 .. etc
     * 
     * @param s
     * @param delimiter
     * @exception EuclidRuntimeException
     *                x and x must have number of elements
     */
    public static Real2Array createFromPairs(RealArray ra) {
    	if (ra == null) {
    		throw new RuntimeException("Null RealArray");
    	}
    	if (ra.size() % 2 != 0) {
    		throw new RuntimeException("Must have even number of points");
    	}
    	Real2Array real2Array = new Real2Array();
    	real2Array.xarr = new RealArray();
    	real2Array.yarr = new RealArray();
    	for (int i = 0; i < ra.size(); ) {
    		real2Array.xarr.addElement(ra.elementAt(i++));
    		real2Array.yarr.addElement(ra.elementAt(i++));
    		real2Array.nelem++;
    	}
    	return real2Array;
    }
    
    /**
     * extract X array.
     * 
     * @return array
     */
    public RealArray getXArray() {
        return xarr;
    }
    /**
     * extract Y array.
     * 
     * @return array
     */
    public RealArray getYArray() {
        return yarr;
    }
    /**
     * size of array.
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
    public Real2 elementAt(int elem) {
        return new Real2(xarr.elementAt(elem), yarr.elementAt(elem));
    }
    
    /**
     * get element.
     * 
     * @param elem
     * @return element
     */
    public Real2 get(int elem) {
        return new Real2(xarr.elementAt(elem), yarr.elementAt(elem));
    }
    
    /**
     * get element.
     * 
     * @param elem
     * @return element
     */
    public void setElement(int elem, Real2 r2) {
    	xarr.setElementAt(elem, r2.getX());
    	yarr.setElementAt(elem, r2.getY());
    }
    
    /** delete element.
     * 
     * @param i
     */
    public void deleteElement(int i) {
    	if (i >= 0 && i < nelem) {
	    	xarr.deleteElement(i);
	    	yarr.deleteElement(i);
	    	nelem--;
    	} else {
    		throw new EuclidRuntimeException("Cannt delete element at: "+i);
    	}
    }
    
    public void transformBy(Transform2 t2) {
    	for (int i = 0; i < nelem; i++) {
    		Real2 xy = this.get(i);
    		xy.transformBy(t2);
    		this.setElement(i, xy);
    	}
    }
    
    /** round to decimal places.
     * 
     * @param places
     * @return this
     */
    public Real2Array format(int places) {
    	double[] xarray = xarr.getArray();
    	double[] yarray = yarr.getArray();
    	for (int i = 0; i < nelem; i++) {
    		xarray[i] = Util.format(xarray[i], places);
    		yarray[i] = Util.format(yarray[i], places);
    	}
    	return this;
    }
 	
	/**
     * to space-separated string.
     * 
     * @return string
     */
    public String getStringArray() {
        // don't change this routine!!!
        StringBuffer s = new StringBuffer();
        double[] xarray = (xarr == null) ? null : xarr.getArray();
        double[] yarray = (yarr == null) ? null : yarr.getArray();
        for (int i = 0; i < nelem; i++) {
        	if (i > 0) {
                s.append(S_SPACE);
        	}
            s.append(xarray[i]);
            s.append(S_SPACE);
            s.append(yarray[i]);
        }
        return s.toString();
    }
    
	/**
     * to string.
     * 
     * @return string
     */
    public String toString() {
        // don't change this routine!!!
        StringBuffer s = new StringBuffer();
        double[] xarray = (xarr == null) ? null : xarr.getArray();
        double[] yarray = (yarr == null) ? null : yarr.getArray();
        s.append(S_LBRAK);
        for (int i = 0; i < nelem; i++) {
            s.append(S_LBRAK);
            s.append(xarray[i]);
            s.append(S_COMMA);
            s.append(yarray[i]);
            s.append(S_RBRAK);
        }
        s.append(S_RBRAK);
        return s.toString();
    }
    
}
