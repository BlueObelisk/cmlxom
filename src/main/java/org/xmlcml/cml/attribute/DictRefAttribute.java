package org.xmlcml.cml.attribute;

import nu.xom.Attribute;
import nu.xom.Node;

import org.xmlcml.cml.base.CMLElement;

/**
 * user-modifiable class supporting DictRefAttribute. supports dictRef attribute
 */
public class DictRefAttribute extends NamespaceRefAttribute {

    /** */
    public final static String NAME = "dictRef";

    /**
     * constructor.
     * 
     */
    public DictRefAttribute() {
        super(NAME);
    }

//    /**
//     * constructor.
//     * 
//     * @param name
//     * @param value
//     */
//    public DictRefAttribute(String name, String value) {
//        super(NAME, value);
//    }

    /**
     * constructor.
     * 
     * @param att
     */
    public DictRefAttribute(Attribute att) {
        super(att);
    }

    /**
     * gets dictRef attribute from element or its parent. elements which might
     * carry dictRef such as scalar may be contained within a parent such as
     * property. In this case the dictRef may be found on the parent. This
     * routine returns whichever is not null
     * 
     * @param el
     *            the element
     * @return the attribute
     */
    public static DictRefAttribute getDictRefFromElementOrParent(CMLElement el) {
        DictRefAttribute dictRefAttribute = 
            (DictRefAttribute) el.getAttribute(NAME);
        if (dictRefAttribute == null) {
            Node parent = el.getParent();
            if (parent instanceof CMLElement) {
                CMLElement parentElement = (CMLElement) parent;
                dictRefAttribute = (DictRefAttribute) 
                    parentElement.getAttribute(NAME);
            }
        }
        return dictRefAttribute;
    }


}
