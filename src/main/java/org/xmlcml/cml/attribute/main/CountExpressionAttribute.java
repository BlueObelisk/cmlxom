package org.xmlcml.cml.attribute.main;

import nu.xom.Attribute;
import nu.xom.Element;
import nu.xom.Node;

import org.xmlcml.cml.base.CMLElement;
import org.xmlcml.cml.base.StringSTAttribute;

/**
 * user-modifiable class supporting "countExpression". 
 */
public class CountExpressionAttribute extends StringSTAttribute {

	/** count expression */
    public final static String NAME = "countExpression";
    String argName = "null";
    int start = 0;
    int end = 0;
    /**
     * constructor.
     * 
     */
    public CountExpressionAttribute() {
        super(NAME);
    }

    /** constructor.
     * @param value
     */
    public CountExpressionAttribute(String value) {
        super(NAME);
        this.setCMLValue(value);
    }

    /**
     * constructor from element with CountExpressionAttribute
     * 
     * @param att
     * @exception RuntimeException
     */
    public CountExpressionAttribute(Attribute att) throws RuntimeException {
        super(att);
    }
    
    /** set value and process.
     * 
     * @param value
     * @exception RuntimeException bad value
     */
    public void setCMLValue(String value) throws RuntimeException {
        if (value == null) {
            throw new RuntimeException("null CountExpressionAttribute value");
        } else if (value.trim().equals(S_EMPTY)) {
            // seems to get called with empty string initially
            // this is a bug
        } else {
            super.setCMLValue(value);
        }
    }
    
    /** clone element with a repeat attribute.
     * clones the element and appends to original element
     * @param element to process
     * @throws RuntimeException null element or bad attribute
     */
    public static void generateAndInsertClones(CMLElement element) throws RuntimeException {
        if (element == null) {
            throw new RuntimeException("Cannot process null element");
        }
        Element parent = (Element) element.getParent();
        if (parent == null) {
            throw new RuntimeException("Cannot process CountExpressionAttribute without parent");
        }
        CountExpressionAttribute cea = (CountExpressionAttribute) 
            element.getAttribute(CountExpressionAttribute.NAME);
        int idx = parent.indexOf(element); 
        int count = cea.calculateCountExpression();
        for (int i = 1; i < count; i++) {
            Element newElement = (Element) element.copy();
            parent.insertChild(newElement, idx+1);
        }
    }

    /** clone content of element with CountExpression and append.
     * clones the element content and appends to original element content
     * @param element to process
     * @throws RuntimeException null element or bad attribute
     */
    public static void cloneContentAndAppend(CMLElement element) throws RuntimeException {
        if (element == null) {
            throw new RuntimeException("Cannot process null element");
        }
        Element parent = (Element) element.getParent();
        if (parent == null) {
            throw new RuntimeException("Cannot process CountExpressionAttribute without parent");
        }
        CountExpressionAttribute cea = (CountExpressionAttribute) 
            element.getAttribute(CountExpressionAttribute.NAME);
        int count = cea.calculateCountExpression();
        int nChild = element.getChildCount();
        for (int i = 1; i < count; i++) {
            for (int j = 0; j < nChild; j++) {
                Node newChild = element.getChild(j).copy();
                element.appendChild(newChild);
            }
        }
    }

    /** expands countExpression into an integer.
     * if simple integer *(5) return that
     * if gaussian(n,m) computes a random value from the distrib (NYI)
     * if range(n,m) computes a random value in the range
     * if countExpression missing returns 1
     * @return the count
     */
    public int calculateCountExpression() {
        int count = 1;
        String countEx = this.getValue();
        if (countEx != null) {
//            Element parent = (Element)this.getParent();
//            if (parent != null) {
//                parent.removeAttribute(parent.getAttribute(CountExpressionAttribute.NAME));
//            }
            if (countEx.startsWith("gaussian")) {
                countEx = countEx.substring("gaussian".length());
                int[] counts = parseCount(countEx);
                if (counts.length != 2 || counts[0] <= 3 || counts[1] < 1 || 
                        counts[0] / counts[1] < 3) {
                    throw new RuntimeException("Bad gaussian: "+countEx);
                }
                throw new RuntimeException("gaussian NYI");
            } else if (countEx.startsWith("range")) {
                countEx = countEx.substring("range".length());
                int[] counts = parseCount(countEx);
                if (counts.length != 2 || counts[0] <= 0 || counts[0] >= counts[1]) {
                    throw new RuntimeException("Bad range: "+countEx);
                }
                double mid2 = (counts[1] + counts[0])/2.;
                double delta2 = (counts[1] - counts[0])/2.;
                double dd = mid2 + delta2 * (0.5 - Math.random());
                count = (int) Math.round(dd);
            } else if (countEx.startsWith(S_STAR)) {
                countEx = countEx.substring(S_STAR.length());
                int[] counts = parseCount(countEx);
                if (counts.length != 1) {
                    throw new RuntimeException("Bad range: "+countEx);
                }
                count = counts[0];
            } else {
                throw new RuntimeException("Bad count expression: "+countEx);
            }
        }
        return count;
    }
    
    private int[] parseCount(String countEx) {
        if (!countEx.startsWith(S_LBRAK) ||
                !countEx.endsWith(S_RBRAK)) {
                throw new RuntimeException("Bad range: requires (...): "+countEx);
        }
        countEx = countEx.substring(1, countEx.length()-1).trim();
        String[] countStrings = countEx.split(S_COMMA);
        int[] counts = new int[countStrings.length];
        for (int i = 0; i < countStrings.length; i++) {
            try {
                counts[i] = Integer.parseInt(countStrings[i]);
            } catch (NumberFormatException e) {
                throw new RuntimeException("Bad integer in countExpression :"+countStrings[i]);
            }
        }
        return counts;
    }

}
