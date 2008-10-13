package org.xmlcml.cml.interfacex;



/**
 * interface for CMLScalar
 */
public interface HasScalar extends HasDataType {

    /**
     * gets value of element;
     * 
     * @return data
     */
    String getString();

    /**
     * gets value of element;
     * 
     * @return integer value
     */
    int getInt();

    /**
     * gets value of element;
     * 
     * @return double value
     */
    double getDouble();

}
