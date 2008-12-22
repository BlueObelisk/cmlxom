package org.xmlcml.cml.attribute;

import nu.xom.Attribute;
import nu.xom.Element;

import org.xmlcml.cml.base.CMLElement;
import org.xmlcml.cml.base.StringSTAttribute;
import org.xmlcml.cml.interfacex.HasUnits;

/**
 * abstract class supporting attributes with namespaceRef values.
 */
public /*abstract*/ class NamespaceRefAttribute extends StringSTAttribute {

    /** regex for validating prefixes */
    public final static String PREFIX_REGEX = "[A-Za-z][A-Za-z0-9\\.\\-\\_]*";

    /**
     * constructor.
     * 
     * @param name
     */
    public NamespaceRefAttribute(String name) {
        super(name);
        init(name);
    }

    public NamespaceRefAttribute(String name, String value) {
        this(name);
        this.setCMLValue(value);
    }

    public NamespaceRefAttribute(Attribute att) {
        this(att.getLocalName());
        this.setCMLValue(att.getValue());
    }

    void init(String name) {
//        SpecialAttribute.updateCMLAttributeList(name, name, this);
    }

    /**
     * interlude to check for QName value.
     * 
     * @param value
     */
    public void setCMLValue(String value) {
        super.setCMLValue(value);
        if (this.getValue().equals(S_EMPTY)) {
            // empty string is created in new attribute
        } else if (this.getPrefix() == null) {
            throw new RuntimeException("attribute value [" + this.getValue()
                    + "] for " + this.getLocalName() + " must be QName");
        }
    }

    /**
     * get parent element.
     * 
     * @return parent
     */
    public Element getElement() {
        return (Element) this.getParent();
    }

    /**
     * gets namespace prefix.
     * 
     * @return null if attribute has no value or no prefix
     */
    public String getPrefix() {
        return getPrefix(this.getValue());
    }

    /** gets prefix from a valid namespaceRef string.
     * 
     * @param value to examine
     * @return prefix (null if absent)
     */
    public static String getPrefix(String value) {
        String prefix = null;
        if (value != null) {
            int idx = value.indexOf(S_COLON);
            if (idx != -1) {
                prefix = value.substring(0, idx);
            }
        }
        return prefix;
    }
    
    

    /**
     * get namespaceURI for this attribute;
     * 
     * @return the namespace
     */
    public String getNamespaceURIString() {
        Element element = this.getElement();
        String prefix = this.getPrefix();
        String namespaceURI = (prefix == null) ? null : element
                .getNamespaceURI(prefix);
        return namespaceURI;
    }

    /**
     * gets idRef. portion of value following the colon
     * 
     * @return null if attribute has no value or no prefix
     */
    public String getIdRef() {
        String idRef = null;
        String value = this.getValue();
        if (value != null) {
            int idx = value.indexOf(S_COLON);
            idRef = value.substring(idx + 1);
        }
        return idRef;
    }

    static int count = 0;

//    /**
//     * checks resolvability of namespaceRef attributes.
//     * 
//     * @param element to search under
//     * @param attributeName in descendant elements (null == wildcard)
//     * @param dictionaryMap
//     * @return list of errors
//     */
//    public List<String> check(CMLElement element,
//            String attributeName, GenericDictionaryMap dictionaryMap) {
//        List<String> errorList = new ArrayList<String>();
//        List<CMLElement> elems = element.getElements(".//"+C_E+C_STAR+"/@"+attributeName);
//        for (CMLElement elem : elems) {
//            NamespaceRefAttribute namespaceRefAttribute = (NamespaceRefAttribute) elem
//                    .getAttribute(attributeName);
//            if (namespaceRefAttribute == null) {
//                errorList.add("NULL " + attributeName + ": " + S_LSQUARE
//                        + elem.toXML() + S_RSQUARE);
//            } else {
//                GenericEntry entry = dictionaryMap
//                        .getEntry(namespaceRefAttribute);
//                if (entry == null) {
//                    if (count++ == 100) {
//                        errorList.add("==== too many errors ===");
//                    } else if (count < 100) {
//                        errorList.add(attributeName + " NOT FOUND "
//                                + namespaceRefAttribute + S_LSQUARE + elem.toXML()
//                                + S_RSQUARE);
//                    }
//                } else {
//                    // Util.sysout("FOUND "+dictRefAttribute);
//                }
//            }
//        }
//        return errorList;
//    }
//
//    /**
//     * checks a file for valid attributes. checks that all namespaceRef
//     * attributes in a file resolve.
//     * 
//     * @param file
//     *            to check
//     * @param dictionaryMap
//     * @return list of errors (empty if none)
//     */
//    public List<String> checkAttribute(File file,
//            GenericDictionaryMap dictionaryMap) {
//        List<String> errorList = new ArrayList<String>();
////        CMLElement element = null;
//        Element rootElement = null;
//        try {
////            rootElement = new Builder().build(file).getRootElement();
//            rootElement = new CMLBuilder().build(file).getRootElement();
//        } catch (ClassCastException e) {
//            System.err.println("Class cast in file: ("+rootElement+S_RBRAK+file);
//            e.printStackTrace();
//        } catch (Exception e) {
//            System.err.println("Error in file: "+file);
//            e.printStackTrace();
//            errorList.add("should not throw " + e);
//        }
//        if (errorList.size() == 0) {
//            errorList = this.checkAttribute(rootElement, dictionaryMap);
//        }
//        return errorList;
//    }
//
//    /**
//     * subclassed to provide class-specific checking.
//     * 
//     * @param element
//     * @param dictionaryMap
//     * @return list of Errors
//     */
//    public abstract List<String> checkAttribute(/*CML*/Element element,
//            GenericDictionaryMap dictionaryMap);
//
//    /**
//     * gets dictionary associated with this attribute. applicable to attributes
//     * pointing to dictionaries such as dictRef, units, unitType, parentSI
//     * 
//     * @param dictionaryMap
//     *            map of namespace to dictionaries
//     * @return dictionary
//     */
//    public GenericDictionary getDictionary(GenericDictionaryMap dictionaryMap) {
//        GenericDictionary dictionary = null;
//        String namespace = this.getNamespaceURIString();
//        if (namespace != null) {
//            dictionary = dictionaryMap.get(namespace);
//        }
//        return dictionary;
//    }

//    /**
//     * gets entry associated with this attribute. applicable to attributes
//     * pointing to dictionaries+id such as dictRef, units, unitType, parentSI
//     * 
//     * @param dictionaryMap
//     *            map of namespace to dictionaries
//     * @return entry or null if not found
//     */
//    public GenericEntry getEntry(GenericDictionaryMap dictionaryMap) {
//        if (dictionaryMap == null) {
//            new Exception().printStackTrace();
//            throw new RuntimeException("Null dictionaryMap");
//        }
//        GenericDictionary dictionary = null;
//        String namespace = this.getNamespaceURIString();
//        if (namespace != null) {
//            dictionary = dictionaryMap.get(namespace);
//        } else {
//            throw new RuntimeException("Unknown namespace for " + this.getValue());
//        }
//        GenericEntry entry = null;
//        String idRef = this.getIdRef();
//        if (dictionary != null && idRef != null) {
//            if (dictionary instanceof CMLUnitList) {
//            }
//            entry = dictionary.getGenericEntry(this.getIdRef());
//        }
//        return entry;
//    }

    /** create valid prefixed value.
     * 
     * @param prefix
     * @param value
     * @return prefixed value
     */
    public static String createValue(String prefix, String value) {
        if (prefix == null) {
            throw new RuntimeException("null prefix");
        }
        if (value == null) {
            throw new RuntimeException("null value");
        }
        if (prefix.trim().equals("")) {
            throw new RuntimeException("cannot have empty prefix");
        }
        if (value.trim().equals("")) {
            throw new RuntimeException("cannot have empty value");
        }
        if (!prefix.matches(PREFIX_REGEX)) {
            throw new RuntimeException("Prefix [" + prefix + "] incompatible with "
                    + PREFIX_REGEX);
        }
        return prefix + S_COLON + value;
    }

    /** return the local name after the colon.
     * if prefix is missing return whole string
     * @param name to examine
     * @return localName 
     */
    public static String getLocalName(String name) {
        String localName = null;
        if (name != null) {
            int idx = name.indexOf(S_COLON);
            localName = name.substring(idx+1);
        }
        return localName;
    }

    /** set units on CML Element.
     * 
     * @param hasUnits to set units on
     * @param prefix unit dictionary prefix
     * @param id unit id
     * @param namespaceURI unit dictionary namespace
     */
    public static void setUnits(HasUnits hasUnits, String prefix, String id, String namespaceURI) {
        CMLElement element = (CMLElement) hasUnits;
        String currentNamespace = element.getNamespaceURIForPrefix(prefix);
        if (currentNamespace != null) {
            if (!currentNamespace.equals(namespaceURI)) {
                throw new RuntimeException("Cannot reset units namespace for "+prefix+" from " +
                    ""+currentNamespace+" to "+namespaceURI);
            }
        } else {
            element.addNamespaceDeclaration(prefix, namespaceURI);
        }
        Attribute units = element.getAttribute("units");
        if (units != null) {
            element.removeAttribute(units);
        }
        UnitsAttribute unitAttribute = new UnitsAttribute(
                NamespaceRefAttribute.createValue(prefix, id));
        element.addAttribute(unitAttribute);
    }
}
