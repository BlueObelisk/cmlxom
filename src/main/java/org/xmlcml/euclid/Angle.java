package org.xmlcml.euclid;
/**
 * Angle object
 * 
 * Angle represents an angle The reason for the class is to help remember about
 * radian/degree problems, to keep the angle in the right range (0, 2*PI) or
 * (-PI, PI) as required, and to format output.
 * <P>
 * To construct an angle the user must consciously use RADIANS
 * <P>
 * The angle returned is always in RADIANS (except if getDegrees() is used)
 * <P>
 * <BR>
 * If SIGNED is used, the angle is in the range -180 to 180 (-pi to pi) <BR>
 * If UNSIGNED is used, the angle is in the range 0 to 360 (0 to 2*pi) <BR>
 * Default is SIGNED
 * <P>
 * Default value of Angle is 0.0; Constructions of invalid angles should throw
 * exceptions rather than try to make invalid angles.
 * 
 * @author (C) P. Murray-Rust, 1996
 */
public class Angle {
    /** units */
    public enum Units {
        /** */
        DEGREES,
        /** */
        RADIANS;
    }
    /** range */
    public enum Range {
        /**
         * any value.
         */
        UNLIMITED,
        /**
         * 0 to 2*PI.
         */
        UNSIGNED,
        /**
         * -PI to PI.
         */
        SIGNED;
    }
    /**
     * default is UNLIMITED
     */
    Range range = Range.UNLIMITED;
    /**
     * default is RADIANS
     */
    Units type = Units.RADIANS;
    /** */
    public final static double DEGREES_IN_RADIAN = 180.0 / Math.PI;
    /**
     * ALWAYS held as radians internally
     */
    double angle = 0.0;
    /**
     * create default Angle default is (0.0)
     */
    public Angle() {
    }
    /**
     * create an angle IN RADIANS
     * 
     * @param a
     */
    public Angle(double a) {
        angle = a;
    }
    /**
     * construct using degrees or radians
     * 
     * @param a
     * @param units
     */
    public Angle(double a, Units units) {
        angle = (units == Units.RADIANS) ? a : a / DEGREES_IN_RADIAN;
    }
    /**
     * from X and Y components (uses atan2)
     * 
     * @param x
     * @param y
     */
    public Angle(double y, double x) {
        angle = Math.atan2(y, x);
    }
    /**
     * copy constructor
     * 
     * @param a
     */
    public Angle(Angle a) {
        angle = a.angle;
        range = a.range;
        type = a.type;
    }
    /**
     * shallowCopy
     * 
     * @param a
     */
    public void shallowCopy(Angle a) {
        range = a.range;
        type = a.type;
        angle = a.angle;
    }
    /**
     * add two angles
     * 
     * @param a2
     * @return new angle
     */
    public Angle plus(Angle a2) {
        Angle temp = new Angle(angle + a2.angle);
        return temp;
    }
    /**
     * subtract two angles
     * 
     * @param a2
     * @return new angle
     */
    public Angle subtract(Angle a2) {
        Angle temp = new Angle(angle - a2.angle);
        return temp;
    }
    /**
     * multiply an angle by a scalar
     * 
     * @param f
     * @return new angle
     */
    public Angle multiplyBy(double f) {
        Angle temp = new Angle(angle * f);
        return temp;
    }
    /**
     * trigonometric functions
     * 
     * @return cosine of angle
     */
    public double cos() {
        return Math.cos(angle);
    }
    /**
     * sin of angle
     * 
     * @return sine
     */
    public double sin() {
        return Math.sin(angle);
    }
    /**
     * tan.
     * 
     * @return the tan
     */
    public double tan() {
        return Math.tan(angle);
    }
    /**
     * normalise angle. to range 0 -> 2*PI
     * 
     * @param angle
     * @return normalised angle
     */
    public static double normalise(double angle) {
        while (angle > 2 * Math.PI) {
            angle -= 2 * Math.PI;
        }
        while (angle < 0.0) {
            angle += 2 * Math.PI;
        }
        return angle;
    }
    /**
     * relational operators normalise the angles internally before comparison
     */
    /**
     * are two normalised angles equal.
     * 
     * @param a
     * @return boolean
     * 
     */
    public boolean isEqualTo(double a) {
        return Real.isEqual(Angle.normalise(angle), Angle.normalise(a));
    }
    /**
     * is one angle greater than another (after normalisation)
     * 
     * @param a
     * @return greater than
     */
    public boolean greaterThan(double a) {
        return Angle.normalise(angle) > Angle.normalise(a);
    }
    /**
     * is one angle greater than or equal to another (after normalisation)
     * 
     * @param a
     * @return greater than or equals
     */
    public boolean greaterThanOrEquals(double a) {
        return Angle.normalise(angle) >= Angle.normalise(a);
    }
    /**
     * is one angle less than another (after normalisation)
     * 
     * @param a
     * @return <
     */
    public boolean lessThan(double a) {
        return Angle.normalise(angle) < Angle.normalise(a);
    }
    /**
     * is one angle less than or equal to another (after normalisation)
     * 
     * @param a
     * @return <=
     */
    public boolean lessThanOrEquals(double a) {
        return Angle.normalise(angle) <= Angle.normalise(a);
    }
    /**
     * are two angles equal
     * 
     * @param a
     * @return ==
     */
    public boolean isEqualTo(Angle a) {
        return isEqualTo(a.angle);
    }
    /**
     * is one angle greater than another (after normalisation)
     * 
     * @param a
     * @return >
     */
    public boolean greaterThan(Angle a) {
        return greaterThan(a.angle);
    }
    /**
     * is one angle greater than or equal to another (after normalisation)
     * 
     * @param a
     * @return >=
     */
    public boolean greaterThanOrEquals(Angle a) {
        return greaterThanOrEquals(a.angle);
    }
    /**
     * is one angle less than another (after normalisation)
     * 
     * @param a
     * @return <
     */
    public boolean lessThan(Angle a) {
        return lessThan(a.angle);
    }
    /**
     * is one angle less than or equal to another (after normalisation)
     * 
     * @param a
     * @return <=
     */
    public boolean lessThanOrEquals(Angle a) {
        return lessThanOrEquals(a.angle);
    }
    /**
     * get angle in radians
     * 
     * @return anngle
     */
    public double getAngle() {
        return adjust(angle);
    }
    /**
     * get angle in radians
     * 
     * @return angle
     */
    public double getRadian() {
        return adjust(angle);
    }
    /**
     * get angle in degrees
     * 
     * @return angle
     */
    public double getDegrees() {
        return adjust(angle) * DEGREES_IN_RADIAN;
    }
    /**
     * input angle in degrees
     * 
     * @param a
     */
    public void putDegrees(double a) {
        angle = a / DEGREES_IN_RADIAN;
    }
    /**
     * set type of range
     * 
     * @param range
     */
    public void setRange(Range range) {
        this.range = range;
    }
    /**
     * set angle to correct range
     */
    private double adjust(double a) {
        if (range == Range.UNLIMITED)
            return a;
        double temp = normalise(a);
        if (range == Range.UNSIGNED) {
            return temp;
        }
        if (temp > Math.PI) {
            temp -= 2 * Math.PI;
        } else if (temp < -Math.PI) {
            temp += 2 * Math.PI;
        }
        return temp;
    }
    /**
     * to string.
     * 
     * @return string
     */
    public String toString() {
        StringBuffer s = new StringBuffer();
        double temp = adjust(angle);
        if (type == Units.DEGREES) {
            s.append(temp).append(" degrees");
        } else {
            s.append(temp);
        }
        return s.toString();
    }
}
