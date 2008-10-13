package org.xmlcml.cml.attribute;

import nu.xom.Attribute;

/**
 * user-modifiable class supporting UnitsAttribute. supports units attribute
 */
public class UnitsAttribute extends NamespaceRefAttribute {

    /** */
    public final static String NAME = "units";

    /**
     * constructor.
     * 
     */
    public UnitsAttribute() {
        super(NAME);
    }

    /**
     * constructor.
     * 
     * @param value
     *            QName for units
     */
    public UnitsAttribute(String value) {
        super(NAME, value);
    }

    /**
     * constructor.
     * 
     * @param att
     */
    public UnitsAttribute(Attribute att) {
        super(att);
    }

}
