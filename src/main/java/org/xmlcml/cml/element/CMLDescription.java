package org.xmlcml.cml.element;


/**
 * 
 * @author nwe23
 *
 */

public class CMLDescription extends AbstractHTMLContainer {
    public final static String TAG = "description";
    public final static String NS = C_E + TAG;

    /**
     * copy constructor. deep copy using XOM copy()
     * 
     * @param old
     *            element to copy
     */
    public CMLDescription(CMLDescription old) {
        super((AbstractHTMLContainer) old);
    }
    public CMLDescription(){
        
    }
    
}
