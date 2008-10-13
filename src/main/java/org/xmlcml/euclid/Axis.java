package org.xmlcml.euclid;

/**
 * enums to represent 2- or 3-D axes
 * 
 * @author (C) P. Murray-Rust, 2005
 */

public class Axis {

    /** enum for x y z axes */
    public enum Axis2 {

        /**
         * x axis. value is 0 for indexing arrays.
         */
        X("x", 0),
        /**
         * y axis. value is 1 for indexing arrays.
         */
        Y("y", 1);

        /** string value */
        public final String axis;

        /** integer value */
        public final int value;

        /**
         * constructor.
         * 
         * @param axis
         *            label for the axis
         * @param value
         *            serial number (starts at 0)
         */

        private Axis2(String axis, int value) {
            this.axis = axis;
            this.value = value;
        }
    }

    /** 3d axes */
    public enum Axis3 {

        /**
         * x axis. value is 0 for indexing arrays.
         */
        X("x", 0),
        /**
         * y axis. value is 1 for indexing arrays.
         */
        Y("y", 1),
        /**
         * z axis. value is 2 for indexing arrays.
         */
        Z("z", 2);

        /** string value */
        public final String axis;

        /** int value */
        public final int value;

        /**
         * constructor.
         * 
         * @param axis
         *            label for the axis
         * @param value
         *            serial number (starts at 0)
         */
        private Axis3(String axis, int value) {
            this.axis = axis;
            this.value = value;
        }
    }
}
