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
import org.xmlcml.cml.element.CMLAction;

import static org.junit.Assert.*;

public class CMLActionTest {
    @Test
    public void testCopy() {
        CMLAction cml = new CMLAction();

        Element cmlCopy = cml.copy();

        assertEquals("Class should be CMLAction: ", CMLAction.class, cmlCopy.getClass());
    }

    @Test
    public void testMakeElementInContext() {
        CMLAction cml = new CMLAction();

        CMLElement actual = cml.makeElementInContext(null);

        assertEquals("Class should be CMLAction: ", CMLAction.class, actual.getClass());
    }

    @Test
    public void testGetTitleAttributeWhenTitleIsSet() {
        CMLAction cml = new CMLAction();
        cml.setTitle("testTitle");
        CMLAttribute expected = new CMLAttribute("title");
        expected.setCMLValue("testTitle");

        CMLAttribute actual = cml.getTitleAttribute();

        assertEquals("LocalName should be 'title': ", expected.getLocalName(), actual.getLocalName());
        assertEquals("Value should be 'testTitle': ", expected.getValue(), actual.getValue());
    }

    @Test
    public void testGetTitleAttributeWhenTitleIsNotSet() {
        CMLAction cml = new CMLAction();
        CMLAttribute expected = null;

        CMLAttribute actual = cml.getTitleAttribute();

        assertEquals("Title attribute should be null: ", expected, actual);
    }

    @Test
    public void testGetTitleWhenTitleIsSet() {
        CMLAction cml = new CMLAction();
        cml.setTitle("testTitle");
        String expected = "testTitle";

        String actual = cml.getTitle();

        assertEquals("Title should be 'testTitle': ", expected, actual);
    }

    @Test
    public void testGetTitleWhenTitleIsNotSet() {
        CMLAction cml = new CMLAction();
        String expected = null;

        String actual = cml.getTitle();

        assertEquals("Title should be null: ", expected, actual);
    }

    @Test
    public void testGetIdAttributeWhenIdIsSet() {
        CMLAction cml = new CMLAction();
        cml.setId("testId");
        CMLAttribute expected = new CMLAttribute("id");
        expected.setCMLValue("testId");

        CMLAttribute actual = cml.getIdAttribute();

        assertEquals("LocalName should be 'id': ", expected.getLocalName(), actual.getLocalName());
        assertEquals("Value should be 'testId': ", expected.getValue(), actual.getValue());
    }

    @Test
    public void testGetIdAttributeWhenIdIsNotSet() {
        CMLAction cml = new CMLAction();
        CMLAttribute expected = null;

        CMLAttribute actual = cml.getIdAttribute();

        assertEquals("Id attribute should be null: ", expected, actual);
    }

    @Test
    public void testGetIdWhenIdIsSet() {
        CMLAction cml = new CMLAction();
        cml.setId("testId");
        String expected = "testId";

        String actual = cml.getId();

        assertEquals("Id value should be 'testId': ", expected, actual);
    }

    @Test
    public void testGetIdWhenIdIsNotSet() {
        CMLAction cml = new CMLAction();
        String expected = null;

        String actual = cml.getId();

        assertEquals("Id value should be null: ", expected, actual);
    }

    @Test
    public void testGetConventionAttributeWhenConventionIsSet() {
        CMLAction cml = new CMLAction();
        cml.setConvention("testConvention");
        CMLAttribute expected = new CMLAttribute("convention");
        expected.setCMLValue("testConvention");

        CMLAttribute actual = cml.getConventionAttribute();

        assertEquals("LocalName should be 'convention': ", expected.getLocalName(), actual.getLocalName());
        assertEquals("Value should be 'testConvention': ", expected.getValue(), actual.getValue());
    }

    @Test
    public void testGetConventionAttributeWhenConventionIsNotSet() {
        CMLAction cml = new CMLAction();
        CMLAttribute expected = null;

        CMLAttribute actual = cml.getConventionAttribute();

        assertEquals("Convention attribute should be null: ", expected, actual);
    }

    @Test
    public void testGetConventionWhenConventionIsSet() {
        CMLAction cml = new CMLAction();
        cml.setConvention("testConvention");
        String expected = "testConvention";

        String actual = cml.getConvention();

        assertEquals("Convention value should be 'testConvention': ", expected, actual);
    }

    @Test
    public void testGetConventionWhenConventionIsNotSet() {
        CMLAction cml = new CMLAction();
        String expected = null;

        String actual = cml.getConvention();

        assertEquals("Convention value should be null: ", expected, actual);
    }

    @Test
    public void testGetDictRefAttributeWhenDictRefIsSet() {
        CMLAction cml = new CMLAction();
        cml.setDictRef("test:dictRef");
        CMLAttribute expected = new CMLAttribute("dictRef");
        expected.setCMLValue("test:dictRef");

        CMLAttribute actual = cml.getDictRefAttribute();

        assertEquals("LocalName should be 'dictRef': ", expected.getLocalName(), actual.getLocalName());
        assertEquals("Value should be 'test:dictRef': ", expected.getValue(), actual.getValue());
    }

    @Test
    public void testGetDictRefAttributeWhenDictRefIsNotSet() {
        CMLAction cml = new CMLAction();
        CMLAttribute expected = null;

        CMLAttribute actual = cml.getDictRefAttribute();

        assertEquals("dictRef attribute should be null: ", expected, actual);
    }

    @Test
    public void testGetDictRefWhenDictRefIsSet() {
        CMLAction cml = new CMLAction();
        cml.setDictRef("test:dictRef");
        String expected = "test:dictRef";

        String actual = cml.getDictRef();

        assertEquals("dictRef value should be 'test:dictRef': ", expected, actual);
    }

    @Test
    public void testGetDictRefWhenDictRefIsNotSet() {
        CMLAction cml = new CMLAction();
        String expected = null;

        String actual = cml.getDictRef();

        assertEquals("dictRef value should be null: ", expected, actual);
    }

    @Test
    public void testGetUnitsAttributeWhenUnitsIsSet() {
        CMLAction cml = new CMLAction();
        cml.setUnits("units:ang");
        CMLAttribute expected = new CMLAttribute("units");
        expected.setCMLValue("units:ang");

        CMLAttribute actual = cml.getUnitsAttribute();

        assertEquals("LocalName should be 'units': ", expected.getLocalName(), actual.getLocalName());
        assertEquals("Value should be 'units:ang': ", expected.getValue(), actual.getValue());
    }

    @Test
    public void testGetUnitsAttributeWhenUnitsIsNotSet() {
        CMLAction cml = new CMLAction();
        CMLAttribute expected = null;

        CMLAttribute actual = cml.getDictRefAttribute();

        assertEquals("Units attribute should be null: ", expected, actual);
    }

    @Test
    public void testGetUnitsWhenUnitsIsSet() {
        CMLAction cml = new CMLAction();
        cml.setUnits("units:ang");
        String expected = "units:ang";

        String actual = cml.getUnits();

        assertEquals("Units value should be 'units:ang': ", expected, actual);
    }

    @Test
    public void testGetUnitsWhenUnitsIsNotSet() {
        CMLAction cml = new CMLAction();
        String expected = null;

        String actual = cml.getUnits();

        assertEquals("units value value should be null: ", expected, actual);
    }

    @Test
    public void testGetStartAttributeWhenStartIsSet() {
        CMLAction cml = new CMLAction();
        cml.setStart("xsd:double");
        CMLAttribute expected = new CMLAttribute("start");
        expected.setCMLValue("xsd:double");

        CMLAttribute actual = cml.getStartAttribute();

        assertEquals("LocalName should be 'start': ", expected.getLocalName(), actual.getLocalName());
        assertEquals("Value should be 'xsd:double': ", expected.getValue(), actual.getValue());
    }

    @Test
    public void testGetStartAttributeWhenStartIsNotSet() {
        CMLAction cml = new CMLAction();
        CMLAttribute expected = null;

        CMLAttribute actual = cml.getStartAttribute();

        assertEquals("Start attribute should be null: ", expected, actual);
    }

    @Test
    public void testGetStartWhenStartIsSet() {
        CMLAction cml = new CMLAction();
        cml.setStart("xsd:double");
        String expected = "xsd:double";

        String actual = cml.getStart();

        assertEquals("Start value should be 'xsd:double': ", expected, actual);
    }

    @Test
    public void testGetStartWhenStartIsNotSet() {
        CMLAction cml = new CMLAction();
        String expected = null;

        String actual = cml.getStart();

        assertEquals("Start value value should be null: ", expected, actual);
    }

    @Test
    public void testGetStartConditionAttributeWhenStartConditionIsSet() {
        CMLAction cml = new CMLAction();
        cml.setStartCondition("test");
        CMLAttribute expected = new CMLAttribute("startCondition");
        expected.setCMLValue("test");

        CMLAttribute actual = cml.getStartConditionAttribute();

        assertEquals("LocalName should be 'startCondition': ", expected.getLocalName(), actual.getLocalName());
        assertEquals("Value should be 'test': ", expected.getValue(), actual.getValue());
    }

    @Test
    public void testGetStartConditionAttributeWhenStartConditionIsNotSet() {
        CMLAction cml = new CMLAction();
        CMLAttribute expected = null;

        CMLAttribute actual = cml.getStartConditionAttribute();

        assertEquals("Start condition attribute should be null: ", expected, actual);
    }

    @Test
    public void testGetStartConditionWhenStartConditionIsSet() {
        CMLAction cml = new CMLAction();
        cml.setStartCondition("test");
        String expected = "test";

        String actual = cml.getStartCondition();

        assertEquals("Start condition value should be 'test': ", expected, actual);
    }

    @Test
    public void testGetStartConditionWhenStartConditionIsNotSet() {
        CMLAction cml = new CMLAction();
        String expected = null;

        String actual = cml.getStartCondition();

        assertEquals("Start condition value should be null: ", expected, actual);
    }

    @Test
    public void testGetEndAttributeWhenEndIsSet() {
        CMLAction cml = new CMLAction();
        cml.setEnd("xsd:double");
        CMLAttribute expected = new CMLAttribute("end");
        expected.setCMLValue("xsd:double");

        CMLAttribute actual = cml.getEndAttribute();

        assertEquals("LocalName should be 'end': ", expected.getLocalName(), actual.getLocalName());
        assertEquals("Value should be 'xsd:double': ", expected.getValue(), actual.getValue());
    }

    @Test
    public void testGetEndAttributeWhenEndIsNotSet() {
        CMLAction cml = new CMLAction();
        CMLAttribute expected = null;

        CMLAttribute actual = cml.getEndAttribute();

        assertEquals("End attribute should be null: ", expected, actual);
    }

    @Test
    public void testGetEndWhenEndIsSet() {
        CMLAction cml = new CMLAction();
        cml.setEnd("xsd:double");
        String expected = "xsd:double";

        String actual = cml.getEnd();

        assertEquals("End value should be 'xsd:double': ", expected, actual);
    }

    @Test
    public void testGetEndWhenEndIsNotSet() {
        CMLAction cml = new CMLAction();
        String expected = null;

        String actual = cml.getEnd();

        assertEquals("End value value should be null: ", expected, actual);
    }

    @Test
    public void testGetEndConditionAttributeWhenEndConditionIsSet() {
        CMLAction cml = new CMLAction();
        cml.setEndCondition("test");
        CMLAttribute expected = new CMLAttribute("endCondition");
        expected.setCMLValue("test");

        CMLAttribute actual = cml.getEndConditionAttribute();

        assertEquals("LocalName should be 'endCondition': ", expected.getLocalName(), actual.getLocalName());
        assertEquals("Value should be 'test': ", expected.getValue(), actual.getValue());
    }

    @Test
    public void testGetEndConditionAttributeWhenEndConditionIsNotSet() {
        CMLAction cml = new CMLAction();
        CMLAttribute expected = null;

        CMLAttribute actual = cml.getEndConditionAttribute();

        assertEquals("End condition attribute should be null: ", expected, actual);
    }

    @Test
    public void testGetEndConditionWhenEndConditionIsSet() {
        CMLAction cml = new CMLAction();
        cml.setEndCondition("test");
        String expected = "test";

        String actual = cml.getEndCondition();

        assertEquals("End condition value should be 'test': ", expected, actual);
    }

    @Test
    public void testGetEndConditionWhenEndConditionIsNotSet() {
        CMLAction cml = new CMLAction();
        String expected = null;

        String actual = cml.getEndCondition();

        assertEquals("End condition value should be null: ", expected, actual);
    }

    @Test
    public void testGetDurationAttributeWhenDurationIsSet() {
        CMLAction cml = new CMLAction();
        cml.setDuration("testDuration");
        CMLAttribute expected = new CMLAttribute("duration");
        expected.setCMLValue("testDuration");

        CMLAttribute actual = cml.getDurationAttribute();

        assertEquals("LocalName should be 'duration': ", expected.getLocalName(), actual.getLocalName());
        assertEquals("Value should be 'testDuration': ", expected.getValue(), actual.getValue());
    }

    @Test
    public void testGetDurationAttributeWhenDurationIsNotSet() {
        CMLAction cml = new CMLAction();
        CMLAttribute expected = null;

        CMLAttribute actual = cml.getDurationAttribute();

        assertEquals("Duration attribute should be null: ", expected, actual);
    }

    @Test
    public void testGetDurationWhenDurationIsSet() {
        CMLAction cml = new CMLAction();
        cml.setDuration("testDuration");
        String expected = "testDuration";

        String actual = cml.getDuration();

        assertEquals("Duration value should be 'testDuration': ", expected, actual);
    }

    @Test
    public void testGetDurationWhenDurationIsNotSet() {
        CMLAction cml = new CMLAction();
        String expected = null;

        String actual = cml.getDuration();

        assertEquals("Duration value should be null: ", expected, actual);
    }

    @Test
    public void testGetTypeAttributeWhenTypeIsSet() {
        CMLAction cml = new CMLAction();
        cml.setType("testType");
        CMLAttribute expected = new CMLAttribute("type");
        expected.setCMLValue("testType");

        CMLAttribute actual = cml.getTypeAttribute();

        assertEquals("LocalName should be 'type': ", expected.getLocalName(), actual.getLocalName());
        assertEquals("Value should be 'testType': ", expected.getValue(), actual.getValue());
    }

    @Test
    public void testGetTypeAttributeWhenTypeIsNotSet() {
        CMLAction cml = new CMLAction();
        CMLAttribute expected = null;

        CMLAttribute actual = cml.getTypeAttribute();

        assertEquals("Type attribute should be null: ", expected, actual);
    }

    @Test
    public void testGetTypeWhenTypeIsSet() {
        CMLAction cml = new CMLAction();
        cml.setType("testType");
        String expected = "testType";

        String actual = cml.getType();

        assertEquals("Type value should be 'testType': ", expected, actual);
    }

    @Test
    public void testGetTypeWhenTypeIsNotSet() {
        CMLAction cml = new CMLAction();
        String expected = null;

        String actual = cml.getType();

        assertEquals("Type value should be null: ", expected, actual);
    }

    @Test
    public void testGetOrderAttributeWhenOrderIsSet() {
        CMLAction cml = new CMLAction();
        cml.setOrder("parallel");
        CMLAttribute expected = new CMLAttribute("order");
        expected.setCMLValue("parallel");

        CMLAttribute actual = cml.getOrderAttribute();

        assertEquals("LocalName should be 'order': ", expected.getLocalName(), actual.getLocalName());
        assertEquals("Value should be 'parallel': ", expected.getValue(), actual.getValue());
    }

    @Test
    public void testGetOrderAttributeWhenOrderIsNotSet() {
        CMLAction cml = new CMLAction();
        CMLAttribute expected = null;

        CMLAttribute actual = cml.getOrderAttribute();

        assertEquals("Order attribute should be null: ", expected, actual);
    }

    @Test
    public void testGetOrderWhenOrderIsSet() {
        CMLAction cml = new CMLAction();
        cml.setOrder("parallel");
        String expected = "parallel";

        String actual = cml.getOrder();

        assertEquals("Order value should be 'parallel': ", expected, actual);
    }

    @Test
    public void testGetOrderWhenOrderIsNotSet() {
        CMLAction cml = new CMLAction();
        String expected = null;

        String actual = cml.getOrder();

        assertEquals("Order value should be null: ", expected, actual);
    }

    @Test
    public void testGetCountAttributeWhenCountIsSet() {
        CMLAction cml = new CMLAction();
        cml.setCount("1.0");
        CMLAttribute expected = new CMLAttribute("count");
        expected.setCMLValue("1.0");

        CMLAttribute actual = cml.getCountAttribute();

        assertEquals("LocalName should be 'count': ", expected.getLocalName(), actual.getLocalName());
        assertEquals("Value should be '1.0': ", expected.getValue(), actual.getValue());
    }

    @Test
    public void testGetCountAttributeWhenCountIsNotSet() {
        CMLAction cml = new CMLAction();
        CMLAttribute expected = null;

        CMLAttribute actual = cml.getCountAttribute();

        assertEquals("Count attribute should be null: ", expected, actual);
    }

    @Test
    public void testGetCountWhenCountIsSetAsString() {
        CMLAction cml = new CMLAction();
        cml.setCount("1.0");
        Double expected = 1D;

        Double actual = cml.getCount();

        assertEquals("Count value should be '1': ", expected, actual);
    }

    @Test
    public void testGetCountWhenCountIsSetAsDouble() {
        CMLAction cml = new CMLAction();
        cml.setCount(1D);
        Double expected = 1D;

        Double actual = cml.getCount();

        assertEquals("Count value should be '1': ", expected, actual);
    }

    @Test
    public void testGetRefAttributeWhenRefIsSet() {
        CMLAction cml = new CMLAction();
        cml.setRef("testRef");
        CMLAttribute expected = new CMLAttribute("ref");
        expected.setCMLValue("testRef");

        CMLAttribute actual = cml.getRefAttribute();

        assertEquals("LocalName should be 'ref': ", expected.getLocalName(), actual.getLocalName());
        assertEquals("Value should be 'testRef': ", expected.getValue(), actual.getValue());
    }

    @Test
    public void testGetRefAttributeWhenRefIsNotSet() {
        CMLAction cml = new CMLAction();
        CMLAttribute expected = null;

        CMLAttribute actual = cml.getRefAttribute();

        assertEquals("Ref attribute should be null: ", expected, actual);
    }

    @Test
    public void testGetRefWhenRefIsSet() {
        CMLAction cml = new CMLAction();
        cml.setRef("testRef");
        String expected = "testRef";

        String actual = cml.getRef();

        assertEquals("Ref should be 'testRef': ", expected, actual);
    }

    @Test
    public void testGetRefWhenRefIsNotSet() {
        CMLAction cml = new CMLAction();
        String expected = null;

        String actual = cml.getRef();

        assertEquals("Ref should be null: ", expected, actual);
    }

    @Test
    public void testSetAttribute() {
        CMLAction cml = new CMLAction();
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
        cml.setAttribute("ref", "testRef");

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
        assertEquals("Ref condition value should be 'testRef': ", "testRef", cml.getRef());
    }
}