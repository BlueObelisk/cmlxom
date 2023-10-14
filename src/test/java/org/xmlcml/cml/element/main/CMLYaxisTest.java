/*    Copyright 2023 Gowri Shankar K
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
package org.xmlcml.cml.element.main;

import nu.xom.Element;
import org.junit.Assert;
import org.junit.Test;
import org.xmlcml.cml.base.CMLElement;
import org.xmlcml.cml.element.CMLAxis;
import org.xmlcml.cml.element.CMLYaxis;
public class CMLYaxisTest {

    @Test
    public void testCMLYaxisList() {
        CMLYaxis cmlYaxis = new CMLYaxis();
        Assert.assertNotNull("constructor: ", cmlYaxis);
        cmlYaxis.setAttribute("axis", "Yaxis");
        CMLYaxis cmlYaxis1 = new CMLYaxis(cmlYaxis);
        Assert.assertEquals("CMLYaxis attributeValue should be Yaxis: ", cmlYaxis.getAttributeValue("axis"),
                cmlYaxis1.getAttributeValue("axis"));
    }

    @Test
    public void testCMLYaxisCopy() {
        CMLYaxis cmlYaxis = new CMLYaxis();
        cmlYaxis.setAttribute("axis", "Yaxis");
        CMLYaxis cmlYaxis1 = new CMLYaxis(cmlYaxis);
        Element copy = cmlYaxis1.copy();
        Assert.assertEquals("class should be CMLYaxis: ", copy.getClass(),
                CMLYaxis.class);
    }

    @Test
    public void testCMLYaxisMakeElementInContext() {
        Element current = new Element("cmlYaxis");

        CMLYaxis factoryElement = new CMLYaxis();
        CMLElement newElement = factoryElement.makeElementInContext(current);
        Assert.assertEquals("class should be CMLYaxis: ", newElement.getClass(),
                CMLYaxis.class);

    }

    @Test
    public void testCMLYaxisGetAxisType() {
        CMLYaxis cmlYaxis = new CMLYaxis();
        Assert.assertEquals("AxisType should be Y: ", CMLAxis.AxisType.Y, cmlYaxis.getAxisType());
        Assert.assertNotEquals("AxisType should not be Z: ", CMLAxis.AxisType.Z, cmlYaxis.getAxisType());
    }

}
