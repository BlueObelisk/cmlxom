package org.xmlcml.cml.attribute;

import nu.xom.Attribute;

public class UnitTypeAttribute extends NamespaceRefAttribute{
    /** */
    public final static String NAME = "unitType";

    /**
     * constructor.
     * 
     */
    public UnitTypeAttribute() {
        super(NAME);
    }

    /**
     * constructor.
     * 
     * @param value
     *            QName for units
     */
    public UnitTypeAttribute(String value) {
        super(NAME, value);
    }

    /**
     * constructor.
     * 
     * @param att
     */
    public UnitTypeAttribute(Attribute att) {
        super(att);
    }

}
