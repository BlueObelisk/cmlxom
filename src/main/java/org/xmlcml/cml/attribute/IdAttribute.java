package org.xmlcml.cml.attribute;

import nu.xom.Attribute;
import nu.xom.Node;

import org.xmlcml.cml.base.StringSTAttribute;

/**
 * user-modifiable class supporting "id". 
 */
public class IdAttribute extends StringSTAttribute {

	/** id */
    public final static String NAME = "id";
    String argName = "null";
    int start = 0;
    int end = 0;
    /**
     * constructor.
     * 
     */
    public IdAttribute() {
        super(NAME);
    }

    /** constructor.
     * @param value
     */
    public IdAttribute(String value) {
        super(NAME);
        this.setCMLValue(value);
    }

    /**
     * constructor from element with IdAttribute
     * 
     * @param att
     * @exception RuntimeException
     */
    public IdAttribute(Attribute att) throws RuntimeException {
        super(att);
    }

    /** copy constructor.
     * @return IdAttribute copy
     */
    public Node copy() {
    	return new IdAttribute(this);
    }
    
    /** set value and process.
     * 
     * @param value
     * @exception RuntimeException bad value
     */
    public void setCMLValue(String value) throws RuntimeException {
        if (value == null) {
            throw new RuntimeException("null IdAttribute value");
        } else if (value.trim().equals(S_EMPTY)) {
            // seems to get called with empty string initially
            // this is a bug
        } else {
            super.setCMLValue(value);
        }
    }
    
}
