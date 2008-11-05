package org.xmlcml.cml.attribute;

import nu.xom.Attribute;
import nu.xom.Element;

import org.xmlcml.cml.base.CMLElement;
import org.xmlcml.cml.base.StringSTAttribute;

/**
 * user-modifiable class supporting "countExpression". 
 * wraps a countExpression attribute and provides the same
 * functionality as CountExpressionAttribute used to do
 */
//TODO still under development
public class CountExpressionAttributeAdapter extends StringSTAttribute {

//	/** count expression */
//    public final static String NAME = "countExpression";
//    String argName = "null";
//    int start = 0;
//    int end = 0;
//    /**
//     * constructor.
//     * 
//     */
//    public CountExpressionAttribute() {
//        super(NAME);
//    }
//
//    /** constructor.
//     * @param value
//     */
//    public CountExpressionAttribute(String value) {
//        super(NAME);
//        this.setCMLValue(value);
//    }

    /**
     * constructor from element with CountExpressionAttribute
     * 
     * @param att
     * @exception RuntimeException
     */
    public CountExpressionAttributeAdapter(Attribute att) throws RuntimeException {
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
                throw new RuntimeException("Bad range: requires (d,d): "+countEx);
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
