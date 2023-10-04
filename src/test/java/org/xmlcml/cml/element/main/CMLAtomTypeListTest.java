/**
 *    Copyright 2011 Peter Murray-Rust et. al.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

/**
 *
 */

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
        Assert.assertEquals("CMLAtomTypeList attributeValue should be atomTypeList: ", cmlAtomTypeList.getAttributeValue("atom"),
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
