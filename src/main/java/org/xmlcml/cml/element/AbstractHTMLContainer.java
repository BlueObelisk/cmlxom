package org.xmlcml.cml.element;

import java.util.ArrayList;
import java.util.List;

import nu.xom.Element;
import nu.xom.Nodes;
import nu.xom.XPathContext;

import org.xmlcml.cml.base.CMLConstants;
import org.xmlcml.cml.base.CMLElement;

public class AbstractHTMLContainer extends CMLElement {

    public XPathContext xhtml = new XPathContext("xhtml", CMLConstants.XHTML_NS);

    public AbstractHTMLContainer(AbstractHTMLContainer old) {
        super(old);
    }

    public AbstractHTMLContainer() {

    }

    /**
     * Convenience method to wrap a plain string in an XHTML P element.
     * 
     * @param text
     *            to wrap
     */
    public void addPlainText(String text) {
        Element p = new Element("xhtml:p", CMLConstants.XHTML_NS);
        p.addNamespaceDeclaration("xhtml", CMLConstants.XHTML_NS);
        p.appendChild(text);
        this.appendChild(p);
    }

    /**
     * 
     * @return An ArrayList containing all the XHTML namespaced elements which
     *         are children of this node.
     */
    public List<Element> getXHTMLElementList() {
        List<Element> childList = new ArrayList<Element>();
        Nodes nodes = this.query("//xhtml:*", xhtml);
        for (int x = 0; x < nodes.size(); x++) {
            Element node = (Element) nodes.get(x);
            childList.add(node);
        }
        return childList;
    }

    /**
     * 
     * @return A string containing all the text contained in children XHTML
     *         elements. Content from different elements are separated by a
     *         newline.
     */
    public String getFlatText() {
        StringBuilder builder = new StringBuilder();
        List<Element> list = this.getXHTMLElementList();
        for (int x = 0; x < list.size(); x++) {
            Element elem = list.get(x);
            builder.append(elem.getValue());
            if (x != list.size() - 1) {
                builder.append('\n');
            }
        }
        return builder.toString();
    }
/**
 * Calls detach() on all XHTML children of this element.
 */
    public void removeXHTMLChildren() {
        List<Element> list = this.getXHTMLElementList();
        for (Element elem : list) {
            elem.detach();
        }
    }

}
