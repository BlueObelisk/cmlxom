package org.xmlcml.cml.attribute;

import nu.xom.Attribute;
import nu.xom.Element;
import nu.xom.Node;

import org.xmlcml.cml.base.CMLConstants;
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
    
    /**
     * gets local value of dictRef value on element
     * eg dictRef="a:b" returns b
     * @param element
     * @return null id no dictRef ; value if no prefix
     */
    public static String getLocalValue(Element element) {
    	Attribute att = element.getAttribute(NAME);
    	String value = (att == null) ? null : att.getValue();
    	String[] values = (value == null) ? null : value.split(CMLConstants.S_COLON);
    	return (values == null) ? null : values[values.length-1];
    }

}
