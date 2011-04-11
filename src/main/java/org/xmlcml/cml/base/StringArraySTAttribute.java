package org.xmlcml.cml.base;

import nu.xom.Attribute;
import nu.xom.Node;

import org.xmlcml.euclid.Util;

/**
 * attribute representing an array of Strings.
 */

public class StringArraySTAttribute extends CMLAttribute {

    /** */
    public final static String JAVA_TYPE = JAVA_STRING+JAVA_ARRAY;
    /** */
    public final static String JAVA_GET_METHOD = "getStringArray";
    /** */
    public final static String JAVA_SHORT_CLASS = "StringArraySTAttribute";

    protected String[] ss = null;

    /**
     * constructor.
     * 
     * @param name
     */
    public StringArraySTAttribute(String name) {
        super(name);
    }

    /**
     * from DOM.
     * 
     * @param att
     */
    public StringArraySTAttribute(Attribute att) {
        this(att.getLocalName());
        this.setCMLValue(att.getValue());
    }

    /**
     * copy constructor
     * 
     * @param att
     */
    public StringArraySTAttribute(StringArraySTAttribute att) {
        super(att);
        if (att.ss != null) {
            this.ss = new String[att.ss.length];
            for (int i = 0; i < ss.length; i++) {
                this.ss[i] = att.ss[i];
            }
        }
    }
    /** copy.
     * uses copy constructor.
     * @return copy 
     */
    public Node copy() {
    	return new StringArraySTAttribute(this);
    }


    /**
     * from DOM.
     * 
     * @param att
     *            to copy, except value
     * @param value
     */
    public StringArraySTAttribute(Attribute att, String value) {
        super(att, value.trim().replace(S_WHITEREGEX, CMLConstants.S_SPACE));
    }

    /**
     * sets value. throws exception if of wrong type or violates restriction
     * 
     * @param s
     *            the value
     */
    public void setCMLValue(String s) {
        String[] split = s.trim().split(S_WHITEREGEX);
        this.setCMLValue(split);
    }

    /**
     * set and check value.
     * 
     * @param ss
     */
    public void setCMLValue(String[] ss) {
        checkValue(ss);
        this.ss = ss;
        this.setValue(Util.concatenate(ss, CMLConstants.S_SPACE));
    }

    /**
     * checks value of simpleType. if value does not check
     * against SimpleType uses CMLType.checkvalue() fails if type is int or
     * double or is not a list
     * 
     * @param ss
     *            the String array
     * @throws RuntimeException
     *             wrong type or value fails
     */
    public void checkValue(String[] ss) {
        if (cmlType != null) {
            cmlType.checkValue(ss);
        }
    }

    /**
     * get array.
     * 
     * @return null if not set
     */
    public Object getCMLValue() {
        return ss;
    }

    /**
     * get array.
     * 
     * @return null if not set
     */
    public String[] getStringArray() {
        return ss;
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
