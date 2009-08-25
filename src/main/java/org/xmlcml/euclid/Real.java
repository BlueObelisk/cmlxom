package org.xmlcml.euclid;

import java.util.regex.Pattern;

import org.apache.log4j.Logger;

/**
 * Real supports various utilities for real numbers Use Double where you want a
 * first-class Java object
 * 
 * @author (C) P. Murray-Rust, 1996
 */
public abstract class Real implements EuclidConstants {
    final static Logger logger = Logger.getLogger(Real.class.getName());
    /** standard for equality of numbers */
    static double epsx = 0.0000000001;
    /**
     * get current version of epsilon.
     * 
     * @return maximum difference between numbers
     */
    public static double getEpsilon() {
        return epsx;
    }
    /**
     * set current version of epsilon.
     * 
     * @param epsilon
     *            will be used in any implicit comparison until reset
     * 
     */
    public static void setEpsilon(double epsilon) {
        epsx = epsilon;
    }

    /** truncate to given number of decimals.
     * forms nint(d * 10^ndec)/10^ndec
     * @param d to truncate
     * @param ndec
     * @return
     */
    public static double normalize(double d, int ndec) {
    	int dd = 1;
    	for (int i = 0; i < ndec; i++) {
    		dd *= 10;
    	}
    	return ((double) Math.round(d * (double)dd)) / (double) dd;
    }
    /**
     * are two numbers equal within epsx.
     * 
     * @param a
     *            number
     * @param b
     *            number
     * @return true if a equals b within epsilon
     * 
     */
    public static boolean isEqual(double a, double b) {
        return Math.abs(a - b) < epsx;
    }
    
    /**
     * is a number zero within epsx
     * 
     * @param a
     *            number
     * @return true if a is zero within epsilon
     * 
     * @deprecated use epsilon method
     */
    public static boolean isZero(double a) {
        return Real.isZero(a, epsx);
    }
    
    /**
     * are all members of an array equal within epsilon.
     * 
     * @param n
     *            length of array
     * @param a
     *            first array
     * @param b
     *            first array
     * @param epsilon
     *            difference
     * @return true is all arrays are of equals lengths and members are equal
     *         within epsilon
     * 
     * @deprecated omit n
     */
    public static boolean isEqual(int n, double[] a, double[] b, double epsilon) {
        if (a.length != b.length) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            if (!Real.isEqual(a[i], b[i], epsilon))
                return false;
        }
        return true;
    }
    
    /**
     * are all members of an array equal within epsilon.
     * 
     * @param a first array
     * @param b first array
     * @param epsilon difference
     * @return true is all arrays are of equals lengths and members are equal
     *         within epsilon
     * 
     */
    public static boolean isEqual(double[] a, double[] b, double epsilon) {
        if (a == null || b == null || a.length != b.length) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            if (!Real.isEqual(a[i], b[i], epsilon))
                return false;
        }
        return true;
    }
    /**
     * are all members of an array equal within epsx
     * 
     * @param n length of array
     * @param a first array
     * @param b first array
     * @return true is all arrays are of equals lengths and members are equal
     *         within epsilon
     * @deprecated use epsilon method
     */
    public static boolean isEqual(int n, double[] a, double b[]) {
        return isEqual(n, a, b, epsx);
    }
    /**
     * are two numbers equal within epsilon
     * 
     * @param a
     *            number
     * @param b
     *            number
     * @param epsilon
     *            difference
     * @return true if a equals b within epsilon
     */
    public static boolean isEqual(double a, double b, double epsilon) {
        return Math.abs(a - b) < epsilon;
    }
    /**
     * is a number zero within epsilon
     * 
     * @param a
     *            number
     * 
     * @param epsilon
     *            difference
     * 
     * @return true if a is zero within epsilon
     * 
     */

    /**
     * parses a string to a double.
     * deals with FORTRAN extensions (exponent E can be D or G)
     * still only parses to double
     * @return Double.NaN or throws exception
     */
    public static final String SCIENTIFIC_PARSE = "[+-]?\\d*(\\.?\\d+)?([EeDdGgHh][+-]?\\d+)?";
    public static final Pattern SCIENTIFIC_PATTERN = Pattern.compile(SCIENTIFIC_PARSE);
    public static double parseDouble(String s) {
    	double d = Double.NaN;
    	if (s != null) {
    		s = s.trim();
	    	try {
	    		d = Double.parseDouble(s);
	    	} catch (NumberFormatException e) {
	    		if (SCIENTIFIC_PATTERN.matcher(s).matches()) {
	    			s = s.replaceFirst("[DdGgHh]", "E");
	    			try {
	    				d = Double.parseDouble(s);
	    			} catch (NumberFormatException ee) {
		    			throw new RuntimeException("cannot parse number as double after converting DdGgHh to E: ", e);
	    			}
	    		} else {
	    			throw new RuntimeException("cannot parse number as double: ", e);
	    		}
	    	}
    	}
    	return d;
    }
    
    public static boolean isZero(double a, double epsilon) {
        return Math.abs(a) < epsilon;
    }
    /**
     * is a less than epsx less than b
     * 
     * @param a
     *            number
     * 
     * @param b
     *            number
     * 
     * @return true if a < b within epsx
     * 
     */
    public static boolean isLessThan(double a, double b) {
        return ((b - a) > epsx);
    }
    /**
     * is a more than epsx greater than b
     * 
     * @param a
     *            number
     * 
     * @param b
     *            number
     * 
     * @return true if a > b within epsx
     * 
     */
    public static boolean isGreaterThan(double a, double b) {
        return ((a - b) > epsx);
    }
    /**
     * set an array to zero
     * 
     * @param nelem
     *            length of array
     * 
     * @param arr
     *            array
     * 
     */
    public static void zeroArray(int nelem, double[] arr) {
        for (int i = 0; i < nelem; i++) {
            arr[i] = 0.0;
        }
    }
    /**
     * set an array to given value
     * 
     * @param nelem
     *            length of array
     * 
     * @param arr
     *            array
     * 
     * @param f
     *            the value
     * 
     */
    public static void initArray(int nelem, double[] arr, double f) {
        for (int i = 0; i < nelem; i++) {
            arr[i] = f;
        }
    }
    /**
     * print a double[]
     * 
     * @param a
     *            array
     * 
     */
    public static void printArray(double[] a) {
        for (int i = 0; i < a.length; i++) {
            logger.info(a[i] + S_SPACE);
        }
        logger.info("");
    }
    
}
