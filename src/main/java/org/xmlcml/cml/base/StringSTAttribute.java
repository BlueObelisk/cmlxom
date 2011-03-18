package org.xmlcml.cml.base;

import nu.xom.Attribute;
import nu.xom.Node;

/**
 * attribute representing a string value.
 * 
 */

public class StringSTAttribute extends CMLAttribute {

    /** */
    public final static String JAVA_TYPE = JAVA_STRING;
    /** */
    public final static String JAVA_GET_METHOD = "getString";
    /** */
    public final static String JAVA_SHORT_CLASS = "StringSTAttribute";
    protected String s;
    //TODO What is the point of this String?t gets out of sync with the 
    //attribute value if CMLAttribute.setValue() is used resulting in problems!
    
    /**
     * constructor.
     * 
     * @param name
     */
    public StringSTAttribute(String name) {
        super(name);
    }

    /**
     * from DOM.
     * 
     * @param att
     */
    public StringSTAttribute(Attribute att) {
        this(att.getLocalName());
        this.setCMLValue(att.getValue());
    }

    /**
     * copy constructor
     * 
     * @param att
     */
    public StringSTAttribute(StringSTAttribute att) {
        super(att);
        if (att.s != null) {
            this.s = att.s;
        }
    }

    /** copy.
     * uses copy constructor.
     * @return copy
     */
    public Node copy() {
    	return new StringSTAttribute(this);
    }

    /**
     * from DOM.
     * 
     * @param att
     *            to copy, except value
     * @param value
     */
    public StringSTAttribute(Attribute att, String value) {
        super(att, value.trim().replace(S_WHITEREGEX, CMLConstants.S_SPACE));
    }

    /**
     * set and check value.
     * trims by default
     * use setCMLValue(s, trim)
     * @param s
     */
    public void setCMLValue(String s) {
    	this.setCMLValue(s, true);
 	}

    /**
     * set and check value.
     * 
     * @param s
     */
    public void setCMLValue(String s, boolean trim) {
    	if (s == null) {
    		throw new RuntimeException("Cannot set null attribute value");
    	}
    	String ss = s;
    	if (trim) {
    		ss = s.trim();
    	}
		checkValue(ss);
		this.s = ss;
		this.setValue(ss);
	}


    /**
	 * checks value of simpleType. uses CMLType.checkvalue() fails if type is
	 * int or double or is a list
	 * 
	 * @param s
	 *            the value
	 * @throws RuntimeException
	 *             wrong type or value fails
	 */
    public void checkValue(String s) {
        if (cmlType != null) {
            cmlType.checkValue(s);
        }
    }

    /**
     * get value.
     * 
     * @return value
     */
    public String getString() {
        return s;
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
