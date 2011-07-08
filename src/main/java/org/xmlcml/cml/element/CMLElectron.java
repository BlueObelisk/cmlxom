package org.xmlcml.cml.element;

import nu.xom.Element;
import nu.xom.Node;

import org.xmlcml.cml.base.CMLElement;

/**
 * user-modifiable class supporting electron. * autogenerated from schema use as
 * a shell which can be edited
 *
 */
public class CMLElectron extends AbstractElectron {

	/** namespaced element name.*/
	public final static String NS = C_E+TAG;

    /** pi electron. */
    public final static String PI = C_A+"piElectron";

    /**
     * constructor.
     */
    public CMLElectron() {
    }

    /**
     * constructor.
     *
     * @param old
     */
    public CMLElectron(CMLElectron old) {
        super((AbstractElectron) old);

    }

    /**
     * copy node .
     *
     * @return Node
     */
    public Node copy() {
        return new CMLElectron(this);

    }

    /**
     * create new instance in context of parent, overridable by subclasses.
     *
     * @param parent
     *            parent of element to be constructed (ignored by default)
     * @return CMLElectron
     */
    public CMLElement makeElementInContext(Element parent) {
        return new CMLElectron();

    }
    
    /** simple count of electrons in bond
     * 
     * @param order
     * @return 2 for S, 3 for A, 4 for D etc.
     */
    public static int getElectronCount(String order) {
        int ec = 0;
        if (order == null) {
        } else if (CMLBond.isSingle(order)) {
            ec = 2;
        } else if (order.equals(CMLBond.AROMATIC)) {
            ec = 3;
        } else if (CMLBond.isDouble(order)) {
            ec = 4;
        } else if (CMLBond.isTriple(order)) {
            ec = 6;
        }
        return ec;
    }

}
