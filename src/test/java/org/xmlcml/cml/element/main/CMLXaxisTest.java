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
import org.xmlcml.cml.element.CMLAxis;
import org.xmlcml.cml.element.CMLXaxis;

public class CMLXaxisTest {

    @Test
    public void testCMLXaxisList() {
        CMLXaxis cmlXaxis = new CMLXaxis();
        Assert.assertNotNull("constructor: ", cmlXaxis);
        cmlXaxis.setAttribute("axis", "Xaxis");
        CMLXaxis cmlXaxis1 = new CMLXaxis(cmlXaxis);
        Assert.assertEquals("CMLXaxis attributeValue should be Xaxis: ", cmlXaxis.getAttributeValue("axis"),
                cmlXaxis1.getAttributeValue("axis"));
    }

    @Test
    public void testCMLXaxisCopy() {
        CMLXaxis cmlXaxis = new CMLXaxis();
        cmlXaxis.setAttribute("axis", "Xaxis");
        CMLXaxis cmlXaxis1 = new CMLXaxis(cmlXaxis);
        Element copy = cmlXaxis1.copy();
        Assert.assertEquals("class should be CMLXaxis: ", copy.getClass(),
                CMLXaxis.class);
    }

    @Test
    public void testCMLXaxisMakeElementInContext() {
        Element current = new Element("cmlXaxis");

        CMLXaxis factoryElement = new CMLXaxis();
        CMLElement newElement = factoryElement.makeElementInContext(current);
        Assert.assertEquals("class should be CMLXaxis: ", newElement.getClass(),
                CMLXaxis.class);

    }

    @Test
    public void testCMLXaxisGetAxisType() {
        CMLXaxis cmlXaxis = new CMLXaxis();
        Assert.assertEquals("AxisType should be X: ", CMLAxis.AxisType.X, cmlXaxis.getAxisType());
    }

}
