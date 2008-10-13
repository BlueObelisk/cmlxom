package org.xmlcml.cml.interfacex;

/**
 * attached to elements that can carry dataType. 
 * examples are scalar, array, matrix
 * 
 * @author pmr
 * 
 */
public interface HasDataType extends HasDictRef {

    /**
     * sets value on dataType attribute. example: setDataType("xsd:double");
     * 
     * @param type
     */
    void setDataType(String type);

    /**
     * gets value on dataType attribute. example: setDataType("xsd:double");
     * 
     * @return type
     */
    String getDataType();

    /**
     * gets value of element;
     * 
     * @return data
     */
    String getXMLContent();

}