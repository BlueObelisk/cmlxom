/**
 *    Copyright 2023 Sakshi Jain
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
import org.junit.Test;
import org.xmlcml.cml.base.CMLAttribute;
import org.xmlcml.cml.base.CMLElement;
import org.xmlcml.cml.element.CMLActionList;

import static org.junit.Assert.*;

public class CMLActionListTest {
    @Test
    public void testCopy() {
        CMLActionList cml = new CMLActionList();

        Element cmlCopy = cml.copy();

        assertEquals("Class should be CMLActionList: ", CMLActionList.class, cmlCopy.getClass());
    }

    @Test
    public void testMakeElementInContext() {
        CMLActionList cml = new CMLActionList();

        CMLElement actual = cml.makeElementInContext(null);

        assertEquals("Class should be CMLActionList: ", CMLActionList.class, actual.getClass());
    }

    @Test
    public void testGetTitleAttributeWhenTitleIsSet() {
        CMLActionList cml = new CMLActionList();
        cml.setTitle("testTitle");
        CMLAttribute expected = new CMLAttribute("title");
        expected.setCMLValue("testTitle");

        CMLAttribute actual = cml.getTitleAttribute();

        assertEquals("LocalName should be 'title': ", expected.getLocalName(), actual.getLocalName());
        assertEquals("Value should be 'testTitle': ", expected.getValue(), actual.getValue());
    }

    @Test
    public void testGetTitleAttributeWhenTitleIsNotSet() {
        CMLActionList cml = new CMLActionList();
        CMLAttribute expected = null;

        CMLAttribute actual = cml.getTitleAttribute();

        assertEquals("Title attribute should be null: ", expected, actual);
    }

    @Test
    public void testGetTitleWhenTitleIsSet() {
        CMLActionList cml = new CMLActionList();
        cml.setTitle("testTitle");
        String expected = "testTitle";

        String actual = cml.getTitle();

        assertEquals("Title should be 'testTitle': ", expected, actual);
    }

    @Test
    public void testGetTitleWhenTitleIsNotSet() {
        CMLActionList cml = new CMLActionList();
        String expected = null;

        String actual = cml.getTitle();

        assertEquals("Title should be null: ", expected, actual);
    }

    @Test
    public void testGetIdAttributeWhenIdIsSet() {
        CMLActionList cml = new CMLActionList();
        cml.setId("testId");
        CMLAttribute expected = new CMLAttribute("id");
        expected.setCMLValue("testId");

        CMLAttribute actual = cml.getIdAttribute();

        assertEquals("LocalName should be 'id': ", expected.getLocalName(), actual.getLocalName());
        assertEquals("Value should be 'testId': ", expected.getValue(), actual.getValue());
    }

    @Test
    public void testGetIdAttributeWhenIdIsNotSet() {
        CMLActionList cml = new CMLActionList();
        CMLAttribute expected = null;

        CMLAttribute actual = cml.getIdAttribute();

        assertEquals("Id attribute should be null: ", expected, actual);
    }

    @Test
    public void testGetIdWhenIdIsSet() {
        CMLActionList cml = new CMLActionList();
        cml.setId("testId");
        String expected = "testId";

        String actual = cml.getId();

        assertEquals("Id value should be 'testId': ", expected, actual);
    }

    @Test
    public void testGetIdWhenIdIsNotSet() {
        CMLActionList cml = new CMLActionList();
        String expected = null;

        String actual = cml.getId();

        assertEquals("Id value should be null: ", expected, actual);
    }

    @Test
    public void testGetConventionAttributeWhenConventionIsSet() {
        CMLActionList cml = new CMLActionList();
        cml.setConvention("testConvention");
        CMLAttribute expected = new CMLAttribute("convention");
        expected.setCMLValue("testConvention");

        CMLAttribute actual = cml.getConventionAttribute();

        assertEquals("LocalName should be 'convention': ", expected.getLocalName(), actual.getLocalName());
        assertEquals("Value should be 'testConvention': ", expected.getValue(), actual.getValue());
    }

    @Test
    public void testGetConventionAttributeWhenConventionIsNotSet() {
        CMLActionList cml = new CMLActionList();
        CMLAttribute expected = null;

        CMLAttribute actual = cml.getConventionAttribute();

        assertEquals("Convention attribute should be null: ", expected, actual);
    }

    @Test
    public void testGetConventionWhenConventionIsSet() {
        CMLActionList cml = new CMLActionList();
        cml.setConvention("testConvention");
        String expected = "testConvention";

        String actual = cml.getConvention();

        assertEquals("Convention value should be 'testConvention': ", expected, actual);
    }

    @Test
    public void testGetConventionWhenConventionIsNotSet() {
        CMLActionList cml = new CMLActionList();
        String expected = null;

        String actual = cml.getConvention();

        assertEquals("Convention value should be null: ", expected, actual);
    }

    @Test
    public void testGetDictRefAttributeWhenDictRefIsSet() {
        CMLActionList cml = new CMLActionList();
        cml.setDictRef("test:dictRef");
        CMLAttribute expected = new CMLAttribute("dictRef");
        expected.setCMLValue("test:dictRef");

        CMLAttribute actual = cml.getDictRefAttribute();

        assertEquals("LocalName should be 'dictRef': ", expected.getLocalName(), actual.getLocalName());
        assertEquals("Value should be 'test:dictRef': ", expected.getValue(), actual.getValue());
    }

    @Test
    public void testGetDictRefAttributeWhenDictRefIsNotSet() {
        CMLActionList cml = new CMLActionList();
        CMLAttribute expected = null;

        CMLAttribute actual = cml.getDictRefAttribute();

        assertEquals("dictRef attribute should be null: ", expected, actual);
    }

    @Test
    public void testGetDictRefWhenDictRefIsSet() {
        CMLActionList cml = new CMLActionList();
        cml.setDictRef("test:dictRef");
        String expected = "test:dictRef";

        String actual = cml.getDictRef();

        assertEquals("dictRef value should be 'test:dictRef': ", expected, actual);
    }

    @Test
    public void testGetDictRefWhenDictRefIsNotSet() {
        CMLActionList cml = new CMLActionList();
        String expected = null;

        String actual = cml.getDictRef();

        assertEquals("dictRef value should be null: ", expected, actual);
    }

    @Test
    public void testGetUnitsAttributeWhenUnitsIsSet() {
        CMLActionList cml = new CMLActionList();
        cml.setUnits("units:ang");
        CMLAttribute expected = new CMLAttribute("units");
        expected.setCMLValue("units:ang");

        CMLAttribute actual = cml.getUnitsAttribute();

        assertEquals("LocalName should be 'units': ", expected.getLocalName(), actual.getLocalName());
        assertEquals("Value should be 'units:ang': ", expected.getValue(), actual.getValue());
    }

    @Test
    public void testGetUnitsAttributeWhenUnitsIsNotSet() {
        CMLActionList cml = new CMLActionList();
        CMLAttribute expected = null;

        CMLAttribute actual = cml.getDictRefAttribute();

        assertEquals("Units attribute should be null: ", expected, actual);
    }

    @Test
    public void testGetUnitsWhenUnitsIsSet() {
        CMLActionList cml = new CMLActionList();
        cml.setUnits("units:ang");
        String expected = "units:ang";

        String actual = cml.getUnits();

        assertEquals("Units value should be 'units:ang': ", expected, actual);
    }

    @Test
    public void testGetUnitsWhenUnitsIsNotSet() {
        CMLActionList cml = new CMLActionList();
        String expected = null;

        String actual = cml.getUnits();

        assertEquals("units value value should be null: ", expected, actual);
    }

    @Test
    public void testGetStartAttributeWhenStartIsSet() {
        CMLActionList cml = new CMLActionList();
        cml.setStart("xsd:double");
        CMLAttribute expected = new CMLAttribute("start");
        expected.setCMLValue("xsd:double");

        CMLAttribute actual = cml.getStartAttribute();

        assertEquals("LocalName should be 'start': ", expected.getLocalName(), actual.getLocalName());
        assertEquals("Value should be 'xsd:double': ", expected.getValue(), actual.getValue());
    }

    @Test
    public void testGetStartAttributeWhenStartIsNotSet() {
        CMLActionList cml = new CMLActionList();
        CMLAttribute expected = null;

        CMLAttribute actual = cml.getStartAttribute();

        assertEquals("Start attribute should be null: ", expected, actual);
    }

    @Test
    public void testGetStartWhenStartIsSet() {
        CMLActionList cml = new CMLActionList();
        cml.setStart("xsd:double");
        String expected = "xsd:double";

        String actual = cml.getStart();

        assertEquals("Start value should be 'xsd:double': ", expected, actual);
    }

    @Test
    public void testGetStartWhenStartIsNotSet() {
        CMLActionList cml = new CMLActionList();
        String expected = null;

        String actual = cml.getStart();

        assertEquals("Start value value should be null: ", expected, actual);
    }

    @Test
    public void testGetStartConditionAttributeWhenStartConditionIsSet() {
        CMLActionList cml = new CMLActionList();
        cml.setStartCondition("test");
        CMLAttribute expected = new CMLAttribute("startCondition");
        expected.setCMLValue("test");

        CMLAttribute actual = cml.getStartConditionAttribute();

        assertEquals("LocalName should be 'startCondition': ", expected.getLocalName(), actual.getLocalName());
        assertEquals("Value should be 'test': ", expected.getValue(), actual.getValue());
    }

    @Test
    public void testGetStartConditionAttributeWhenStartConditionIsNotSet() {
        CMLActionList cml = new CMLActionList();
        CMLAttribute expected = null;

        CMLAttribute actual = cml.getStartConditionAttribute();

        assertEquals("Start condition attribute should be null: ", expected, actual);
    }

    @Test
    public void testGetStartConditionWhenStartConditionIsSet() {
        CMLActionList cml = new CMLActionList();
        cml.setStartCondition("test");
        String expected = "test";

        String actual = cml.getStartCondition();

        assertEquals("Start condition value should be 'test': ", expected, actual);
    }

    @Test
    public void testGetStartConditionWhenStartConditionIsNotSet() {
        CMLActionList cml = new CMLActionList();
        String expected = null;

        String actual = cml.getStartCondition();

        assertEquals("Start condition value should be null: ", expected, actual);
    }

    @Test
    public void testGetEndAttributeWhenEndIsSet() {
        CMLActionList cml = new CMLActionList();
        cml.setEnd("xsd:double");
        CMLAttribute expected = new CMLAttribute("end");
        expected.setCMLValue("xsd:double");

        CMLAttribute actual = cml.getEndAttribute();

        assertEquals("LocalName should be 'end': ", expected.getLocalName(), actual.getLocalName());
        assertEquals("Value should be 'xsd:double': ", expected.getValue(), actual.getValue());
    }

    @Test
    public void testGetEndAttributeWhenEndIsNotSet() {
        CMLActionList cml = new CMLActionList();
        CMLAttribute expected = null;

        CMLAttribute actual = cml.getEndAttribute();

        assertEquals("End attribute should be null: ", expected, actual);
    }

    @Test
    public void testGetEndWhenEndIsSet() {
        CMLActionList cml = new CMLActionList();
        cml.setEnd("xsd:double");
        String expected = "xsd:double";

        String actual = cml.getEnd();

        assertEquals("End value should be 'xsd:double': ", expected, actual);
    }

    @Test
    public void testGetEndWhenEndIsNotSet() {
        CMLActionList cml = new CMLActionList();
        String expected = null;

        String actual = cml.getEnd();

        assertEquals("End value value should be null: ", expected, actual);
    }

    @Test
    public void testGetEndConditionAttributeWhenEndConditionIsSet() {
        CMLActionList cml = new CMLActionList();
        cml.setEndCondition("test");
        CMLAttribute expected = new CMLAttribute("endCondition");
        expected.setCMLValue("test");

        CMLAttribute actual = cml.getEndConditionAttribute();

        assertEquals("LocalName should be 'endCondition': ", expected.getLocalName(), actual.getLocalName());
        assertEquals("Value should be 'test': ", expected.getValue(), actual.getValue());
    }

    @Test
    public void testGetEndConditionAttributeWhenEndConditionIsNotSet() {
        CMLActionList cml = new CMLActionList();
        CMLAttribute expected = null;

        CMLAttribute actual = cml.getEndConditionAttribute();

        assertEquals("End condition attribute should be null: ", expected, actual);
    }

    @Test
    public void testGetEndConditionWhenEndConditionIsSet() {
        CMLActionList cml = new CMLActionList();
        cml.setEndCondition("test");
        String expected = "test";

        String actual = cml.getEndCondition();

        assertEquals("End condition value should be 'test': ", expected, actual);
    }

    @Test
    public void testGetEndConditionWhenEndConditionIsNotSet() {
        CMLActionList cml = new CMLActionList();
        String expected = null;

        String actual = cml.getEndCondition();

        assertEquals("End condition value should be null: ", expected, actual);
    }

    @Test
    public void testGetDurationAttributeWhenDurationIsSet() {
        CMLActionList cml = new CMLActionList();
        cml.setDuration("testDuration");
        CMLAttribute expected = new CMLAttribute("duration");
        expected.setCMLValue("testDuration");

        CMLAttribute actual = cml.getDurationAttribute();

        assertEquals("LocalName should be 'duration': ", expected.getLocalName(), actual.getLocalName());
        assertEquals("Value should be 'testDuration': ", expected.getValue(), actual.getValue());
    }

    @Test
    public void testGetDurationAttributeWhenDurationIsNotSet() {
        CMLActionList cml = new CMLActionList();
        CMLAttribute expected = null;

        CMLAttribute actual = cml.getDurationAttribute();

        assertEquals("Duration attribute should be null: ", expected, actual);
    }

    @Test
    public void testGetDurationWhenDurationIsSet() {
        CMLActionList cml = new CMLActionList();
        cml.setDuration("testDuration");
        String expected = "testDuration";

        String actual = cml.getDuration();

        assertEquals("Duration value should be 'testDuration': ", expected, actual);
    }

    @Test
    public void testGetDurationWhenDurationIsNotSet() {
        CMLActionList cml = new CMLActionList();
        String expected = null;

        String actual = cml.getDuration();

        assertEquals("Duration value should be null: ", expected, actual);
    }

    @Test
    public void testGetTypeAttributeWhenTypeIsSet() {
        CMLActionList cml = new CMLActionList();
        cml.setType("testType");
        CMLAttribute expected = new CMLAttribute("type");
        expected.setCMLValue("testType");

        CMLAttribute actual = cml.getTypeAttribute();

        assertEquals("LocalName should be 'type': ", expected.getLocalName(), actual.getLocalName());
        assertEquals("Value should be 'testType': ", expected.getValue(), actual.getValue());
    }

    @Test
    public void testGetTypeAttributeWhenTypeIsNotSet() {
        CMLActionList cml = new CMLActionList();
        CMLAttribute expected = null;

        CMLAttribute actual = cml.getTypeAttribute();

        assertEquals("Type attribute should be null: ", expected, actual);
    }

    @Test
    public void testGetTypeWhenTypeIsSet() {
        CMLActionList cml = new CMLActionList();
        cml.setType("testType");
        String expected = "testType";

        String actual = cml.getType();

        assertEquals("Type value should be 'testType': ", expected, actual);
    }

    @Test
    public void testGetTypeWhenTypeIsNotSet() {
        CMLActionList cml = new CMLActionList();
        String expected = null;

        String actual = cml.getType();

        assertEquals("Type value should be null: ", expected, actual);
    }

    @Test
    public void testGetOrderAttributeWhenOrderIsSet() {
        CMLActionList cml = new CMLActionList();
        cml.setOrder("parallel");
        CMLAttribute expected = new CMLAttribute("order");
        expected.setCMLValue("parallel");

        CMLAttribute actual = cml.getOrderAttribute();

        assertEquals("LocalName should be 'order': ", expected.getLocalName(), actual.getLocalName());
        assertEquals("Value should be 'parallel': ", expected.getValue(), actual.getValue());
    }

    @Test
    public void testGetOrderAttributeWhenOrderIsNotSet() {
        CMLActionList cml = new CMLActionList();
        CMLAttribute expected = null;

        CMLAttribute actual = cml.getOrderAttribute();

        assertEquals("Order attribute should be null: ", expected, actual);
    }

    @Test
    public void testGetOrderWhenOrderIsSet() {
        CMLActionList cml = new CMLActionList();
        cml.setOrder("parallel");
        String expected = "parallel";

        String actual = cml.getOrder();

        assertEquals("Order value should be 'parallel': ", expected, actual);
    }

    @Test
    public void testGetOrderWhenOrderIsNotSet() {
        CMLActionList cml = new CMLActionList();
        String expected = null;

        String actual = cml.getOrder();

        assertEquals("Order value should be null: ", expected, actual);
    }

    @Test
    public void testGetCountAttributeWhenCountIsSet() {
        CMLActionList cml = new CMLActionList();
        cml.setCount("1.0");
        CMLAttribute expected = new CMLAttribute("count");
        expected.setCMLValue("1.0");

        CMLAttribute actual = cml.getCountAttribute();

        assertEquals("LocalName should be 'count': ", expected.getLocalName(), actual.getLocalName());
        assertEquals("Value should be '1.0': ", expected.getValue(), actual.getValue());
    }

    @Test
    public void testGetCountAttributeWhenCountIsNotSet() {
        CMLActionList cml = new CMLActionList();
        CMLAttribute expected = null;

        CMLAttribute actual = cml.getCountAttribute();

        assertEquals("Count attribute should be null: ", expected, actual);
    }

    @Test
    public void testGetCountWhenCountIsSetAsString() {
        CMLActionList cml = new CMLActionList();
        cml.setCount("1.0");
        Double expected = 1D;

        Double actual = cml.getCount();

        assertEquals("Count value should be '1': ", expected, actual);
    }

    @Test
    public void testGetCountWhenCountIsSetAsDouble() {
        CMLActionList cml = new CMLActionList();
        cml.setCount(1D);
        Double expected = 1D;

        Double actual = cml.getCount();

        assertEquals("Count value should be '1': ", expected, actual);
    }

    @Test
    public void testSetAttribute() {
        CMLActionList cml = new CMLActionList();
        cml.setAttribute("title", "testTitle");
        cml.setAttribute("id", "testId");
        cml.setAttribute("convention", "testConvention");
        cml.setAttribute("dictRef", "test:dictRef");
        cml.setAttribute("units", "units:ang");
        cml.setAttribute("start", "xsd:double");
        cml.setAttribute("startCondition", "test");
        cml.setAttribute("duration", "testDuration");
        cml.setAttribute("end", "xsd:double");
        cml.setAttribute("endCondition", "test");
        cml.setAttribute("type", "testType");
        cml.setAttribute("order", "parallel");
        cml.setAttribute("count", "1.0");

        assertEquals("Title should be 'testTitle': ", "testTitle", cml.getTitle());
        assertEquals("Id should be 'testId': ", "testId", cml.getId());
        assertEquals("Convention should be 'testConvention': ", "testConvention", cml.getConvention());
        assertEquals("DictRef should be 'test:dictRef': ", "test:dictRef", cml.getDictRef());
        assertEquals("Units should be 'units:ang': ", "units:ang", cml.getUnits());
        assertEquals("Start value should be 'xsd:double': ", "xsd:double", cml.getStart());
        assertEquals("Start condition value should be 'test': ", "test", cml.getStartCondition());
        assertEquals("Duration value should be 'testDuration': ", "testDuration", cml.getDuration());
        assertEquals("End value should be 'xsd:double': ", "xsd:double", cml.getEnd());
        assertEquals("End condition value should be 'test': ", "test", cml.getEndCondition());
        assertEquals("Type condition value should be 'testType': ", "testType", cml.getType());
        assertEquals("Order condition value should be 'parallel': ", "parallel", cml.getOrder());
        assertEquals("Count condition value should be '1.0': ", "1.0", String.valueOf(cml.getCount()));
    }
}