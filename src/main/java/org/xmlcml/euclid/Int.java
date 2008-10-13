package org.xmlcml.euclid;

import org.apache.log4j.Logger;

/**
 * Int supports various utilities for integers Use Integer where you want a
 * first-class Java object
 * 
 * @author (C) P. Murray-Rust, 1996
 */
public abstract class Int implements EuclidConstants {
    final static Logger logger = Logger.getLogger(Int.class);
    /**
     * set an array to zero
     * 
     * @param nelem
     * @param arr
     */
    public static void zeroArray(int nelem, int[] arr) {
        for (int i = 0; i < nelem; i++) {
            arr[i] = 0;
        }
    }
    /**
     * set an array to given value
     * 
     * @param nelem
     * @param arr
     * @param f
     */
    public static void initArray(int nelem, int[] arr, int f) {
        for (int i = 0; i < nelem; i++) {
            arr[i] = f;
        }
    }
    /**
     * print a int[]
     * 
     * @param a
     * 
     */
    public static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            logger.info(a[i] + S_SPACE);
        }
        logger.info("");
    }
}
