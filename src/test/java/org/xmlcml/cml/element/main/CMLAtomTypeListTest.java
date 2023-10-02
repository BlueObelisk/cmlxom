package org.xmlcml.cml.element.main;

import nu.xom.Element;
import org.junit.Assert;
import org.junit.Test;
import org.xmlcml.cml.base.CMLElement;
import org.xmlcml.cml.element.CMLAtomTypeList;


public class CMLAtomTypeListTest {

    @Test
    public void testCMLAtomTypeList() {
        CMLAtomTypeList cmlAtomTypeList = new CMLAtomTypeList();
        Assert.assertNotNull("constructor: ", cmlAtomTypeList);
        cmlAtomTypeList.setAttribute("atom", "atomTypeList");
        CMLAtomTypeList cmlAtomTypeList1 = new CMLAtomTypeList(cmlAtomTypeList);
        Assert.assertEquals("class should be CMLAtomTypeList: ", cmlAtomTypeList.getAttributeValue("atom"),
                cmlAtomTypeList1.getAttributeValue("atom"));
    }

    @Test
    public void testCMLAtomTypeListCopy() {
        CMLAtomTypeList cmlAtomTypeList = new CMLAtomTypeList();
        cmlAtomTypeList.setAttribute("atom", "atomTypeList");
        CMLAtomTypeList cmlAtomTypeList1 = new CMLAtomTypeList(cmlAtomTypeList);
        Element copy = cmlAtomTypeList1.copy();
        Assert.assertEquals("class should be CMLAtomTypeList: ", copy.getClass(),
                CMLAtomTypeList.class);
    }

    @Test
    public void testCMLAtomTypeListMakeElementInContext() {
        Element current = new Element("cmLAtomTypeList");

        CMLAtomTypeList factoryElement = new CMLAtomTypeList();
        CMLElement newElement = factoryElement.makeElementInContext(current);
        Assert.assertEquals("class should be CMLAtomTypeList: ", newElement.getClass(),
                CMLAtomTypeList.class);

    }
}
