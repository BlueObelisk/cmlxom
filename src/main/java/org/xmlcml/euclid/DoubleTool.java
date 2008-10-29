package org.xmlcml.euclid;

/**
 *
 * <p>
 * Tool providing methods for working with doubles.
 * </p>
 *
 * @author Sam Adams
 *
 */
public class DoubleTool {

    /**
     * tests equality of doubles.
     *
     * @param a
     * @param b
     * @param eps
     *            margin of identity
     * @return true if a == b within eps
     */
    public static boolean equals(double a, double b, double eps) {
        return (Math.abs(a - b) < Math.abs(eps));
    }

    /**
     * tests equality of double arrays. arrays must be of same length
     *
     * @param a
     *            first array
     * @param b
     *            second array
     * @param eps
     *            margin of identity
     * @return array elements equal within eps
     */
    public static boolean equals(double[] a, double[] b, double eps) {
        boolean result = false;
        if (a.length == b.length) {
            result = true;
            for (int i = 0; i < a.length; i++) {
                if (Math.abs(a[i] - b[i]) > Math.abs(eps)) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

}
