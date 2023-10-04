/**
 *    Copyright 2023 Sivasuriyan
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
import org.junit.Before;
import org.junit.Test;
import org.xmlcml.cml.base.CMLElement;
import org.xmlcml.cml.element.CMLGradient;
import org.xmlcml.cml.element.CMLIsotope;

import static org.junit.Assert.*;

public class CMLIsotopeTest {

    CMLIsotope cmlIsotope;
    @Before
    public void setUp() {
        cmlIsotope = new CMLIsotope();
    }

    @Test
    public void testCMLIsotopeCopy() {
        Element copyElement = cmlIsotope.copy();
        Assert.assertEquals(copyElement.getClass(), CMLIsotope.class);
    }

    @Test
    public void testMakeElementInContext() {
        Element element = new CMLIsotope();
        CMLElement actual = cmlIsotope.makeElementInContext(element);
        Assert.assertEquals(CMLIsotope.class, actual.getClass());
    }

    @Test
    public void testCMLIsotope() {
        CMLIsotope cmlIsotopOld = new CMLIsotope();
        CMLIsotope cmlIsotope = new CMLIsotope(cmlIsotopOld);
        Assert.assertEquals(cmlIsotope.getClass(), CMLIsotope.class);
    }
}