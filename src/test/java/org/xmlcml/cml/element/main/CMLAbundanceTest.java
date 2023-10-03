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

package org.xmlcml.cml.element.main;

import static org.junit.Assert.*;

import org.junit.Test;
import nu.xom.Element;
import org.xmlcml.cml.base.CMLAttribute;
import org.xmlcml.cml.base.CMLElement;
import org.xmlcml.cml.element.CMLAbundance;

public class CMLAbundanceTest {
    @Test
    public void testCopy() {
        CMLAbundance cml = new CMLAbundance();

        Element cmlCopy = cml.copy();

        assertEquals("Class should be CMLAbundance: ", CMLAbundance.class, cmlCopy.getClass());
    }

    @Test
    public void testMakeElementInContext() {
        CMLAbundance c = new CMLAbundance();

        CMLElement actual = c.makeElementInContext(null);

        assertEquals("Class should be CMLAbundance: ", CMLAbundance.class, actual.getClass());
    }

    @Test
    public void testGetTitleAttributeWhenTitleIsSet() {
        CMLAbundance cml = new CMLAbundance();
        cml.setTitle("testTitle");
        CMLAttribute expected = new CMLAttribute("title");
        expected.setCMLValue("testTitle");

        CMLAttribute actual = cml.getTitleAttribute();

        assertEquals("LocalName should be 'title': ", expected.getLocalName(), actual.getLocalName());
        assertEquals("Value should be 'testTitle': ", expected.getValue(), actual.getValue());
    }

    @Test
    public void testGetTitleAttributeWhenTitleIsNotSet() {
        CMLAbundance cml = new CMLAbundance();
        CMLAttribute expected = null;

        CMLAttribute actual = cml.getTitleAttribute();

        assertEquals("Title attribute should be null: ", expected, actual);
    }

    @Test
    public void testGetTitleWhenTitleIsSet() {
        CMLAbundance cml = new CMLAbundance();
        cml.setTitle("testTitle");
        String expected = "testTitle";

        String actual = cml.getTitle();

        assertEquals("Title should be 'testTitle': ", expected, actual);
    }

    @Test
    public void testGetTitleWhenTitleIsNotSet() {
        CMLAbundance cml = new CMLAbundance();
        String expected = null;

        String actual = cml.getTitle();

        assertEquals("Title should be null: ", expected, actual);
    }

    @Test
    public void testGetIdAttributeWhenIdIsSet() {
        CMLAbundance cml = new CMLAbundance();
        cml.setId("testId");
        CMLAttribute expected = new CMLAttribute("id");
        expected.setCMLValue("testId");

        CMLAttribute actual = cml.getIdAttribute();

        assertEquals("LocalName should be 'id': ", expected.getLocalName(), actual.getLocalName());
        assertEquals("Value should be 'testId': ", expected.getValue(), actual.getValue());
    }

    @Test
    public void testGetIdAttributeWhenIdIsNotSet() {
        CMLAbundance cml = new CMLAbundance();
        CMLAttribute expected = null;

        CMLAttribute actual = cml.getIdAttribute();

        assertEquals("Id attribute should be null: ", expected, actual);
    }

    @Test
    public void testGetIdWhenIdIsSet() {
        CMLAbundance cml = new CMLAbundance();
        cml.setId("testId");
        String expected = "testId";

        String actual = cml.getId();

        assertEquals("Id value should be 'testId': ", expected, actual);
    }

    @Test
    public void testGetIdWhenIdIsNotSet() {
        CMLAbundance cml = new CMLAbundance();
        String expected = null;

        String actual = cml.getId();

        assertEquals("Id value should be null: ", expected, actual);
    }

    @Test
    public void testGetConventionAttributeWhenConventionIsSet() {
        CMLAbundance cml = new CMLAbundance();
        cml.setConvention("testConvention");
        CMLAttribute expected = new CMLAttribute("convention");
        expected.setCMLValue("testConvention");

        CMLAttribute actual = cml.getConventionAttribute();

        assertEquals("LocalName should be 'convention': ", expected.getLocalName(), actual.getLocalName());
        assertEquals("Value should be 'testConvention': ", expected.getValue(), actual.getValue());
    }

    @Test
    public void testGetConventionAttributeWhenConventionIsNotSet() {
        CMLAbundance cml = new CMLAbundance();
        CMLAttribute expected = null;

        CMLAttribute actual = cml.getConventionAttribute();

        assertEquals("Convention attribute should be null: ", expected, actual);
    }

    @Test
    public void testGetConventionWhenConventionIsSet() {
        CMLAbundance cml = new CMLAbundance();
        cml.setConvention("testConvention");
        String expected = "testConvention";

        String actual = cml.getConvention();

        assertEquals("Convention value should be 'testConvention': ", expected, actual);
    }

    @Test
    public void testGetConventionWhenConventionIsNotSet() {
        CMLAbundance cml = new CMLAbundance();
        String expected = null;

        String actual = cml.getConvention();

        assertEquals("Convention value should be null: ", expected, actual);
    }

    @Test
    public void testGetDictRefAttributeWhenDictRefIsSet() {
        CMLAbundance cml = new CMLAbundance();
        cml.setDictRef("test:dictRef");
        CMLAttribute expected = new CMLAttribute("dictRef");
        expected.setCMLValue("test:dictRef");

        CMLAttribute actual = cml.getDictRefAttribute();

        assertEquals("LocalName should be 'dictRef': ", expected.getLocalName(), actual.getLocalName());
        assertEquals("Value should be 'test:dictRef': ", expected.getValue(), actual.getValue());
    }

    @Test
    public void testGetDictRefAttributeWhenDictRefIsNotSet() {
        CMLAbundance cml = new CMLAbundance();
        CMLAttribute expected = null;

        CMLAttribute actual = cml.getDictRefAttribute();

        assertEquals("dictRef attribute should be null: ", expected, actual);
    }

    @Test
    public void testGetDictRefWhenDictRefIsSet() {
        CMLAbundance cml = new CMLAbundance();
        cml.setDictRef("test:dictRef");
        String expected = "test:dictRef";

        String actual = cml.getDictRef();

        assertEquals("dictRef value should be 'test:dictRef': ", expected, actual);
    }

    @Test
    public void testGetDictRefWhenDictRefIsNotSet() {
        CMLAbundance cml = new CMLAbundance();
        String expected = null;

        String actual = cml.getDictRef();

        assertEquals("dictRef value should be null: ", expected, actual);
    }

    @Test
    public void testGetMinAttributeWhenMinIsSet() {
        CMLAbundance cml = new CMLAbundance();
        cml.setMin("0");
        CMLAttribute expected = new CMLAttribute("min");
        expected.setCMLValue("0");

        CMLAttribute actual = cml.getMinAttribute();

        assertEquals("LocalName should be 'min': ", expected.getLocalName(), actual.getLocalName());
        assertEquals("Value should be '0': ", expected.getValue(), actual.getValue());
    }

    @Test
    public void testGetMinAttributeWhenMinIsNotSet() {
        CMLAbundance cml = new CMLAbundance();
        CMLAttribute expected = null;

        CMLAttribute actual = cml.getDictRefAttribute();

        assertEquals("Min attribute should be null: ", expected, actual);
    }

    @Test
    public void testGetMinWhenMinIsSet() {
        CMLAbundance cml = new CMLAbundance();
        cml.setMin("0");
        String expected = "0";

        String actual = cml.getMin();

        assertEquals("Min value should be '0': ", expected, actual);
    }

    @Test
    public void testGetMinWhenMinIsNotSet() {
        CMLAbundance cml = new CMLAbundance();
        String expected = null;

        String actual = cml.getMin();

        assertEquals("min value value should be null: ", expected, actual);
    }

    @Test
    public void testGetMaxAttributeWhenMaxIsSet() {
        CMLAbundance cml = new CMLAbundance();
        cml.setMax("0");
        CMLAttribute expected = new CMLAttribute("max");
        expected.setCMLValue("0");

        CMLAttribute actual = cml.getMaxAttribute();

        assertEquals("LocalName should be 'max': ", expected.getLocalName(), actual.getLocalName());
        assertEquals("Value should be '0': ", expected.getValue(), actual.getValue());
    }

    @Test
    public void testGetMaxAttributeWhenMaxIsNotSet() {
        CMLAbundance cml = new CMLAbundance();
        CMLAttribute expected = null;

        CMLAttribute actual = cml.getDictRefAttribute();

        assertEquals("Max attribute should be null: ", expected, actual);
    }

    @Test
    public void testGetMaxWhenMaxIsSet() {
        CMLAbundance cml = new CMLAbundance();
        cml.setMax("0");
        String expected = "0";

        String actual = cml.getMax();

        assertEquals("Max value should be '0': ", expected, actual);
    }

    @Test
    public void testGetMaxWhenMaxIsNotSet() {
        CMLAbundance cml = new CMLAbundance();
        String expected = null;

        String actual = cml.getMax();

        assertEquals("max value value should be null: ", expected, actual);
    }

    @Test
    public void testGetUnitsAttributeWhenUnitsIsSet() {
        CMLAbundance cml = new CMLAbundance();
        cml.setUnits("units:ang");
        CMLAttribute expected = new CMLAttribute("units");
        expected.setCMLValue("units:ang");

        CMLAttribute actual = cml.getUnitsAttribute();

        assertEquals("LocalName should be 'units': ", expected.getLocalName(), actual.getLocalName());
        assertEquals("Value should be 'units:ang': ", expected.getValue(), actual.getValue());
    }

    @Test
    public void testGetUnitsAttributeWhenUnitsIsNotSet() {
        CMLAbundance cml = new CMLAbundance();
        CMLAttribute expected = null;

        CMLAttribute actual = cml.getDictRefAttribute();

        assertEquals("Units attribute should be null: ", expected, actual);
    }

    @Test
    public void testGetUnitsWhenUnitsIsSet() {
        CMLAbundance cml = new CMLAbundance();
         cml.setUnits("units:ang");
        String expected = "units:ang";

        String actual = cml.getUnits();

        assertEquals("Units value should be 'units:ang': ", expected, actual);
    }

    @Test
    public void testGetUnitsWhenUnitsIsNotSet() {
        CMLAbundance cml = new CMLAbundance();
        String expected = null;

        String actual = cml.getUnits();

        assertEquals("units value value should be null: ", expected, actual);
    }

    @Test
    public void testGetXmlContentWhenXmlContentIsSetAsString() {
        CMLAbundance cml = new CMLAbundance();
        cml.setXMLContent("1");
        Double expected = 1d;

        Double actual = cml.getXMLContent();

        assertEquals("XmlContent value should be '1': ", expected, actual);
    }

    @Test
    public void testGetXmlContentWhenXmlContentIsSetAsDouble() {
        CMLAbundance cml = new CMLAbundance();
        cml.setXMLContent(1d);
        Double expected = 1d;

        Double actual = cml.getXMLContent();

        assertEquals("XmlContent value should be '1': ", expected, actual);
    }

    @Test
    public void testGetXmlContentWhenXmlContentIsNotSet() {
        CMLAbundance cml = new CMLAbundance();
        try {
            cml.getXMLContent();
        }
        catch (Exception exception) {
            assertEquals("Should throw null pointer exception: ",
                    java.lang.NullPointerException.class, exception.getClass());
        }
    }

    @Test
    public void testSetAttribute() {
        CMLAbundance cml = new CMLAbundance();
        cml.setAttribute("title", "testTitle");
        cml.setAttribute("id", "testId");
        cml.setAttribute("convention", "testConvention");
        cml.setAttribute("dictRef", "test:dictRef");
        cml.setAttribute("min", "0");
        cml.setAttribute("max", "1");
        cml.setAttribute("units", "units:ang");

        assertEquals("Title should be 'testTitle': ", "testTitle", cml.getTitle());
        assertEquals("Id should be 'testId': ", "testId", cml.getId());
        assertEquals("Convention should be 'testConvention': ", "testConvention", cml.getConvention());
        assertEquals("DictRef should be 'test:dictRef': ", "test:dictRef", cml.getDictRef());
        assertEquals("Min should be '0': ", "0", cml.getMin());
        assertEquals("Max should be '1': ", "1", cml.getMax());
        assertEquals("Units should be 'units:ang': ", "units:ang", cml.getUnits());
    }

}
