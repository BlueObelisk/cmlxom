package org.xmlcml.cml.element.main;

import org.junit.Assert;
import org.xmlcml.cml.base.CMLBuilder;
import org.xmlcml.cml.base.CMLConstants;
import org.xmlcml.cml.base.CMLElement;

/**
 * miscellaneous test stuff
 * 
 * @author pmr
 * 
 */
public class Standalone implements CMLConstants {

    /**
     * main
     * 
     * @param args
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out
                    .println("usage: org.xmlcml.cml.element.Standalone <number>");
        } else if (args[0].trim().equals("1")) {
            Test1();
        } else {
            System.err.println("Unknown test: " + args[0]);
        }
    }

    /**
     * test.
     */
    public static void Test1() {
        String localResourceString = "" + "<cml:molecule"
                + " xmlns:cml='"+CML_NS+"'" +
                // " xsi:schemaLocation='"+CML_NS+S_SPACE+
                // "../../schema.xsd'" +
                // " xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'"+
                "	>" + "	<cml:atomArray atomID='a1 a2 a3 a4' "
                + "      elementType='C C O O' formalCharge='0 0 0 0' />"
                + "   <cml:bondArray atomRef1='a1 a2 a2' atomRef2='a2 a3 a4'"
                + "      order='1 2 1' />" + "</cml:molecule>" + "";

        CMLBuilder builder = new CMLBuilder();
        // builder.setParsed(false);
        CMLElement cmlElement = null;
        try {
            cmlElement = (CMLElement) builder.parseString(localResourceString);
        } catch (Exception e) {
            e.printStackTrace();
            // return false;
        }
        Assert.assertNotNull(cmlElement);
    }

}
