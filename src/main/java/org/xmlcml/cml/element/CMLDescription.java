package org.xmlcml.cml.element;

import nu.xom.Element;
import nu.xom.Node;

import org.xmlcml.cml.base.CMLElement;


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
        super(TAG);
    }
    
    /**
     * copy node .
     *
     * @return Node
     */
    public Node copy() {
        return new CMLDescription(this);

    }

    /**
     * create new instance in context of parent, overridable by subclasses.
     *
     * @param parent
     *            parent of element to be constructed (ignored by default)
     * @return CMLDescription
     */
    public CMLElement makeElementInContext(Element parent) {
        return new CMLDescription();

    }
}
