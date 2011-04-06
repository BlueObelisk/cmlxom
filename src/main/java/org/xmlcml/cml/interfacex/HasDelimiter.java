package org.xmlcml.cml.interfacex;

import nu.xom.Attribute;


/**
 * interface for CMLArray or CMLMatrix
 */
public interface HasDelimiter {

	/**
	 * 
	 * @return delimiter string
	 */
    String getDelimiter();
    
    /**
     * sets delimiter (should be a single printable character or single space (char)32
     * @param delim
     */
    void setDelimiter(String delim);

    /** removes any attribute of the form
     * delimiter=" " or delimiter=""
     */
    void removeWhitespaceDelimiterAttribute();

	Attribute getDelimiterAttribute();
}
