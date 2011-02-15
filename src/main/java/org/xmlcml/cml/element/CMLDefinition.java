package org.xmlcml.cml.element;

/**
 * 
 * @author nwe23
 *
 */
public class CMLDefinition extends AbstractHTMLContainer {
    public final static String TAG = "definition";
    public final static String NS = C_E + TAG;
    
    /**
     * copy constructor. deep copy using XOM copy()
     * 
     * @param old
     *            element to copy
     */
    public CMLDefinition(CMLDefinition old) {
        super((AbstractHTMLContainer) old);
    }
    public CMLDefinition(){
        
    }
    
 
    
}
