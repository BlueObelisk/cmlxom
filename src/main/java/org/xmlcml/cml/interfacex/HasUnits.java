package org.xmlcml.cml.interfacex;



/**
 * attached to elements that can carry units. 
 * examples are scalar, array, matrix
 * 
 * @author pmr
 * 
 */
public interface HasUnits {

    /**
     * sets value on units attribute. example: setUnits("myUnits", "floop");
     * 
     * @param prefix
     * @param idRef
     * @param namespaceURI
     */
    void setUnits(String prefix, String idRef, String namespaceURI);

    /**
     * 
     * @return units as String
     */
    String getUnits();

    // removed in this version
//    /**
//     * converts a real scalar to SI. only affects scalar with units attribute
//     * and dataType='xsd:double' replaces the value with the converted value and
//     * the units with the SI Units
//     * 
//     * @param unitListMap
//     *            map to resolve the units attribute
//     */
//    void convertToSI(NamespaceToUnitListMap unitListMap);

}