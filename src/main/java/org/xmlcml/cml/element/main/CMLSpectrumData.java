package org.xmlcml.cml.element.main;

import nu.xom.Element;
import nu.xom.Node;

import org.xmlcml.cml.base.CMLElement;

/**
 * user-modifiable class supporting spectrumData. * autogenerated from schema
 * use as a shell which can be edited
 *
 */
public class CMLSpectrumData extends AbstractSpectrumData {

	/** namespaced element name.*/
	public final static String NS = C_E+TAG;

    /**
     * contructor.
     */
    public CMLSpectrumData() {
    }

    /**
     * contructor.
     *
     * @param old
     */
    public CMLSpectrumData(CMLSpectrumData old) {
        super((AbstractSpectrumData) old);

    }

    /**
     * copy node .
     *
     * @return Node
     */
    public Node copy() {
        return new CMLSpectrumData(this);

    }

    /**
     * create new instance in context of parent, overridable by subclasses.
     *
     * @param parent
     *            parent of element to be constructed (ignored by default)
     * @return CMLSpectrumData
     */
    public CMLElement makeElementInContext(Element parent) {
        return new CMLSpectrumData();

    }
}
