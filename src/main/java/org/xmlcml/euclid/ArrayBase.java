package org.xmlcml.euclid;

import org.apache.log4j.Logger;

/**
 * super class of array methods
 * 
 * @author (C) P. Murray-Rust, 1996
 */
public abstract class ArrayBase implements EuclidConstants {
    final static Logger logger = Logger.getLogger(ArrayBase.class.getName());
    /** */
    public enum Trim {
        /** */
        ABOVE(1),
        /** */
        BELOW(2);
        /** */
        public int trim;
        private Trim(int t) {
            this.trim = t;
        }
    }
}
