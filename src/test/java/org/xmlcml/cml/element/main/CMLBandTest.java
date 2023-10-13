/**
 *    Copyright 2023 Gowri Shankar K
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
import org.xmlcml.cml.element.CMLBand;

public class CMLBandTest {

    @Test
    public void testCMLBand() {
        CMLBand cmlBand = new CMLBand();
        Assert.assertNotNull("constructor: ", cmlBand);
        cmlBand.setAttribute("band", "bandValue");
        CMLBand cmlBand1 = new CMLBand(cmlBand);
        Assert.assertEquals("CMLBand attributeValue should be bandValue: ", cmlBand.getAttributeValue("band"),
                cmlBand1.getAttributeValue("band"));
    }

    @Test
    public void testCMLBandCopy() {
        CMLBand cmlBand = new CMLBand();
        cmlBand.setAttribute("band", "BandValue");
        CMLBand cmlBand1 = new CMLBand(cmlBand);
        Element copy = cmlBand1.copy();
        Assert.assertEquals("class should be CMLBand: ", copy.getClass(),
                CMLBand.class);
    }

    @Test
    public void testCMLBandMakeElementInContext() {
        Element current = new Element("cmlYaxis");

        CMLBand factoryElement = new CMLBand();
        CMLElement newElement = factoryElement.makeElementInContext(current);
        Assert.assertEquals("class should be CMLBand: ", newElement.getClass(),
                CMLBand.class);

    }

}
