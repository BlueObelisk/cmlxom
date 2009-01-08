package org.xmlcml.cml.base;

import nu.xom.Attribute;
import nu.xom.Node;

import org.xmlcml.euclid.Util;

/**
 * attribute representing an int value..
 */

public class IntArraySTAttribute extends CMLAttribute {

    /** */
    public final static String JAVA_TYPE = JAVA_INT+JAVA_ARRAY;
    /** */
    public final static String JAVA_GET_METHOD = "getIntArray";
    /** */
    public final static String JAVA_SHORT_CLASS = "IntArraySTAttribute";

    protected int[] ii = null;

    protected int length = -1;

    /**
     * constructor.
     * 
     * @param name
     */
    public IntArraySTAttribute(String name) {
        super(name);
    }

    /**
     * from DOM.
     * 
     * @param att
     */
    public IntArraySTAttribute(Attribute att) {
        this(att.getLocalName());
        this.setCMLValue(att.getValue());
    }

    /**
     * copy constructor
     * 
     * @param att
     */
    public IntArraySTAttribute(IntArraySTAttribute att) {
        super(att);
        if (att.ii != null) {
            this.ii = new int[att.ii.length];
            for (int i = 0; i < ii.length; i++) {
                this.ii[i] = att.ii[i];
            }
        }
        this.length = att.length;
    }
    
    /** copy.
     * uses copy constructor.
     * @return copy 
     */
    public Node copy() {
    	return new IntArraySTAttribute(this);
    }

    /**
     * from DOM.
     * 
     * @param att
     *            to copy, except value
     * @param value
     */
    public IntArraySTAttribute(Attribute att, String value) {
        super(att, value.trim().replace(S_WHITEREGEX, CMLConstants.S_SPACE));
    }

    /**
     * set and check value.
     * 
     * @param ii
     */
    public void setCMLValue(int[] ii) {
        checkValue(ii);
        this.ii = new int[ii.length];
        for (int i = 0; i < ii.length; i++) {
            this.ii[i] = ii[i];
        }
        this.setValue(Util.concatenate(ii, CMLConstants.S_SPACE));
    }

    /**
     * checks value of simpleType. if value does not check
     * against SimpleType uses CMLType.checkvalue() fails if type is String or
     * double or is not a list
     * 
     * @param ii
     *            the int array
     * @throws RuntimeException
     *             wrong type or value fails
     */
    public void checkValue(int[] ii) {
        if (cmlType != null) {
            cmlType.checkValue(ii);
        }
    }

    /**
     * splits string into ints.
     * 
     * @param s the string
     * @param delim delimiter
     * @return array
     */
    public static int[] split(String s, String delim) {
        String sss = s.trim().replace(S_WHITEREGEX, CMLConstants.S_SPACE);
        if (delim == null || delim.trim().equals(S_EMPTY)
                || delim.equals(S_WHITEREGEX)) {
            delim = CMLConstants.S_WHITEREGEX;
            sss = sss.trim();
        }
        String[] ss = sss.split(delim);
        int[] ii = new int[ss.length];
        for (int i = 0; i < ss.length; i++) {
            try {
                ii[i] = Integer.parseInt(ss[i]);
            } catch (NumberFormatException nfe) {
                throw new RuntimeException(S_EMPTY + nfe);
            }
        }
        return ii;
    }

    /**
     * sets value. throws exception if of wrong type or violates restriction
     * 
     * @param s
     *            the value
     * @throws RuntimeException
     */
    public void setCMLValue(String s) {
        int[] ii = split(s.trim(), CMLConstants.S_WHITEREGEX);
        this.setCMLValue(ii);
    }

    /**
     * get array.
     * 
     * @return null if not set
     */
    public Object getCMLValue() {
        return ii;
    }

    /**
     * get array.
     * 
     * @return null if not set
     */
    public int[] getIntArray() {
        return ii;
    }

    /**
     * get java type.
     * 
     * @return java type
     */
    public String getJavaType() {
        return JAVA_TYPE;
    }

    /**
     * get java method.
     * 
     * @return java method
     */
    public String getJavaGetMethod() {
        return JAVA_GET_METHOD;
    }

    /**
     * get java short class name.
     * 
     * @return java short className
     */
    public String getJavaShortClassName() {
        return JAVA_SHORT_CLASS;
    }
};
