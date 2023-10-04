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
import org.xmlcml.cml.base.CMLElements;
import org.xmlcml.cml.element.*;

import static org.junit.Assert.*;

public class CMLAtomTypeTest {
    @Test
    public void testCopy() {
        CMLAtomType cml = new CMLAtomType();

        Element cmlCopy = cml.copy();

        assertEquals("Class should be CMLAtomType: ", CMLAtomType.class, cmlCopy.getClass());
    }

    @Test
    public void testMakeElementInContext() {
        CMLAtomType cml = new CMLAtomType();

        CMLElement actual = cml.makeElementInContext(null);

        assertEquals("Class should be CMLAtomType: ", CMLAtomType.class, actual.getClass());
    }

    @Test
    public void testGetNameAttributeWhenNameIsSet() {
        CMLAtomType cml = new CMLAtomType();
        cml.setName("testName");
        CMLAttribute expected = new CMLAttribute("name");
        expected.setCMLValue("testName");

        CMLAttribute actual = cml.getNameAttribute();

        assertEquals("LocalName should be 'name': ", expected.getLocalName(), actual.getLocalName());
        assertEquals("Value should be 'testName': ", expected.getValue(), actual.getValue());
    }

    @Test
    public void testGetNameAttributeWhenNameIsNotSet() {
        CMLAtomType cml = new CMLAtomType();
        CMLAttribute expected = null;

        CMLAttribute actual = cml.getNameAttribute();

        assertEquals("Name attribute should be null: ", expected, actual);
    }

    @Test
    public void testGetNameWhenNameIsSet() {
        CMLAtomType cml = new CMLAtomType();
        cml.setName("testName");
        String expected = "testName";

        String actual = cml.getName();

        assertEquals("Name should be 'testName': ", expected, actual);
    }

    @Test
    public void testGetNameWhenNameIsNotSet() {
        CMLAtomType cml = new CMLAtomType();
        String expected = null;

        String actual = cml.getName();

        assertEquals("Name should be null: ", expected, actual);
    }

    @Test
    public void testGetRefAttributeWhenRefIsSet() {
        CMLAtomType cml = new CMLAtomType();
        cml.setRef("testRef");
        CMLAttribute expected = new CMLAttribute("ref");
        expected.setCMLValue("testRef");

        CMLAttribute actual = cml.getRefAttribute();

        assertEquals("LocalName should be 'ref': ", expected.getLocalName(), actual.getLocalName());
        assertEquals("Value should be 'testRef': ", expected.getValue(), actual.getValue());
    }

    @Test
    public void testGetRefAttributeWhenRefIsNotSet() {
        CMLAtomType cml = new CMLAtomType();
        CMLAttribute expected = null;

        CMLAttribute actual = cml.getRefAttribute();

        assertEquals("Ref attribute should be null: ", expected, actual);
    }

    @Test
    public void testGetRefWhenRefIsSet() {
        CMLAtomType cml = new CMLAtomType();
        cml.setRef("testRef");
        String expected = "testRef";

        String actual = cml.getRef();

        assertEquals("Ref should be 'testRef': ", expected, actual);
    }

    @Test
    public void testGetRefWhenRefIsNotSet() {
        CMLAtomType cml = new CMLAtomType();
        String expected = null;

        String actual = cml.getRef();

        assertEquals("Ref should be null: ", expected, actual);
    }

    @Test
    public void testGetAtomRefAttributeWhenAtomRefIsSet() {
        CMLAtomType cml = new CMLAtomType();
        cml.setAtomRef("testAtomRef");
        CMLAttribute expected = new CMLAttribute("atomRef");
        expected.setCMLValue("testAtomRef");

        CMLAttribute actual = cml.getAtomRefAttribute();

        assertEquals("LocalName should be 'atomRef': ", expected.getLocalName(), actual.getLocalName());
        assertEquals("Value should be 'testAtomRef': ", expected.getValue(), actual.getValue());
    }

    @Test
    public void testGetAtomRefAttributeWhenAtomRefIsNotSet() {
        CMLAtomType cml = new CMLAtomType();
        CMLAttribute expected = null;

        CMLAttribute actual = cml.getAtomRefAttribute();

        assertEquals("AtomRef attribute should be null: ", expected, actual);
    }

    @Test
    public void testGetAtomRefWhenAtomRefIsSet() {
        CMLAtomType cml = new CMLAtomType();
        cml.setAtomRef("testAtomRef");
        String expected = "testAtomRef";

        String actual = cml.getAtomRef();

        assertEquals("AtomRef should be 'testAtomRef': ", expected, actual);
    }

    @Test
    public void testGetAtomRefWhenAtomRefIsNotSet() {
        CMLAtomType cml = new CMLAtomType();
        String expected = null;

        String actual = cml.getAtomRef();

        assertEquals("AtomRef should be null: ", expected, actual);
    }
    
    @Test
    public void testGetTitleAttributeWhenTitleIsSet() {
        CMLAtomType cml = new CMLAtomType();
        cml.setTitle("testTitle");
        CMLAttribute expected = new CMLAttribute("title");
        expected.setCMLValue("testTitle");

        CMLAttribute actual = cml.getTitleAttribute();

        assertEquals("LocalName should be 'title': ", expected.getLocalName(), actual.getLocalName());
        assertEquals("Value should be 'testTitle': ", expected.getValue(), actual.getValue());
    }

    @Test
    public void testGetTitleAttributeWhenTitleIsNotSet() {
        CMLAtomType cml = new CMLAtomType();
        CMLAttribute expected = null;

        CMLAttribute actual = cml.getTitleAttribute();

        assertEquals("Title attribute should be null: ", expected, actual);
    }

    @Test
    public void testGetTitleWhenTitleIsSet() {
        CMLAtomType cml = new CMLAtomType();
        cml.setTitle("testTitle");
        String expected = "testTitle";

        String actual = cml.getTitle();

        assertEquals("Title should be 'testTitle': ", expected, actual);
    }

    @Test
    public void testGetTitleWhenTitleIsNotSet() {
        CMLAtomType cml = new CMLAtomType();
        String expected = null;

        String actual = cml.getTitle();

        assertEquals("Title should be null: ", expected, actual);
    }

    @Test
    public void testGetIdAttributeWhenIdIsSet() {
        CMLAtomType cml = new CMLAtomType();
        cml.setId("testId");
        CMLAttribute expected = new CMLAttribute("id");
        expected.setCMLValue("testId");

        CMLAttribute actual = cml.getIdAttribute();

        assertEquals("LocalName should be 'id': ", expected.getLocalName(), actual.getLocalName());
        assertEquals("Value should be 'testId': ", expected.getValue(), actual.getValue());
    }

    @Test
    public void testGetIdAttributeWhenIdIsNotSet() {
        CMLAtomType cml = new CMLAtomType();
        CMLAttribute expected = null;

        CMLAttribute actual = cml.getIdAttribute();

        assertEquals("Id attribute should be null: ", expected, actual);
    }

    @Test
    public void testGetIdWhenIdIsSet() {
        CMLAtomType cml = new CMLAtomType();
        cml.setId("testId");
        String expected = "testId";

        String actual = cml.getId();

        assertEquals("Id value should be 'testId': ", expected, actual);
    }

    @Test
    public void testGetIdWhenIdIsNotSet() {
        CMLAtomType cml = new CMLAtomType();
        String expected = null;

        String actual = cml.getId();

        assertEquals("Id value should be null: ", expected, actual);
    }

    @Test
    public void testGetConventionAttributeWhenConventionIsSet() {
        CMLAtomType cml = new CMLAtomType();
        cml.setConvention("testConvention");
        CMLAttribute expected = new CMLAttribute("convention");
        expected.setCMLValue("testConvention");

        CMLAttribute actual = cml.getConventionAttribute();

        assertEquals("LocalName should be 'convention': ", expected.getLocalName(), actual.getLocalName());
        assertEquals("Value should be 'testConvention': ", expected.getValue(), actual.getValue());
    }

    @Test
    public void testGetConventionAttributeWhenConventionIsNotSet() {
        CMLAtomType cml = new CMLAtomType();
        CMLAttribute expected = null;

        CMLAttribute actual = cml.getConventionAttribute();

        assertEquals("Convention attribute should be null: ", expected, actual);
    }

    @Test
    public void testGetConventionWhenConventionIsSet() {
        CMLAtomType cml = new CMLAtomType();
        cml.setConvention("testConvention");
        String expected = "testConvention";

        String actual = cml.getConvention();

        assertEquals("Convention value should be 'testConvention': ", expected, actual);
    }

    @Test
    public void testGetConventionWhenConventionIsNotSet() {
        CMLAtomType cml = new CMLAtomType();
        String expected = null;

        String actual = cml.getConvention();

        assertEquals("Convention value should be null: ", expected, actual);
    }

    @Test
    public void testGetDictRefAttributeWhenDictRefIsSet() {
        CMLAtomType cml = new CMLAtomType();
        cml.setDictRef("test:dictRef");
        CMLAttribute expected = new CMLAttribute("dictRef");
        expected.setCMLValue("test:dictRef");

        CMLAttribute actual = cml.getDictRefAttribute();

        assertEquals("LocalName should be 'dictRef': ", expected.getLocalName(), actual.getLocalName());
        assertEquals("Value should be 'test:dictRef': ", expected.getValue(), actual.getValue());
    }

    @Test
    public void testGetDictRefAttributeWhenDictRefIsNotSet() {
        CMLAtomType cml = new CMLAtomType();
        CMLAttribute expected = null;

        CMLAttribute actual = cml.getDictRefAttribute();

        assertEquals("dictRef attribute should be null: ", expected, actual);
    }

    @Test
    public void testGetDictRefWhenDictRefIsSet() {
        CMLAtomType cml = new CMLAtomType();
        cml.setDictRef("test:dictRef");
        String expected = "test:dictRef";

        String actual = cml.getDictRef();

        assertEquals("dictRef value should be 'test:dictRef': ", expected, actual);
    }

    @Test
    public void testGetDictRefWhenDictRefIsNotSet() {
        CMLAtomType cml = new CMLAtomType();
        String expected = null;

        String actual = cml.getDictRef();

        assertEquals("dictRef value should be null: ", expected, actual);
    }

    @Test
    public void testAddMolecule() {
        CMLAtomType cml = new CMLAtomType();
        cml.addMolecule(new CMLMolecule());
        CMLElements<CMLMolecule> actual = cml.getMoleculeElements();

        assertEquals("Molecules list size should be 1: ", 1, actual.size());
    }

    @Test
    public void testGetMoleculeElementsWhenNoMoleculesAdded() {
        CMLAtomType cml = new CMLAtomType();
        CMLElements<CMLMolecule> actual = cml.getMoleculeElements();

        assertEquals("Molecules list size should be 0: ", 0, actual.size());
    }

    @Test
    public void testAddAtom() {
        CMLAtomType cml = new CMLAtomType();
        cml.addAtom(new CMLAtom());
        CMLElements<CMLAtom> actual = cml.getAtomElements();

        assertEquals("Atom list size should be 1: ", 1, actual.size());
    }

    @Test
    public void testGetAtomElementsWhenNoAtomsAdded() {
        CMLAtomType cml = new CMLAtomType();
        CMLElements<CMLAtom> actual = cml.getAtomElements();

        assertEquals("Atom list size should be 0: ", 0, actual.size());
    }

    @Test
    public void testAddLabel() {
        CMLAtomType cml = new CMLAtomType();
        cml.addLabel(new CMLLabel());
        CMLElements<CMLLabel> actual = cml.getLabelElements();

        assertEquals("Label list size should be 1: ", 1, actual.size());
    }

    @Test
    public void testGetLabelElementsWhenNoLabelsAdded() {
        CMLAtomType cml = new CMLAtomType();
        CMLElements<CMLLabel> actual = cml.getLabelElements();

        assertEquals("Label list size should be 0: ", 0, actual.size());
    }

    @Test
    public void testAddScalar() {
        CMLAtomType cml = new CMLAtomType();
        cml.addScalar(new CMLScalar());
        CMLElements<CMLScalar> actual = cml.getScalarElements();

        assertEquals("Scalars list size should be 1: ", 1, actual.size());
    }

    @Test
    public void testGetScalarElementsWhenNoScalarsAdded() {
        CMLAtomType cml = new CMLAtomType();
        CMLElements<CMLScalar> actual = cml.getScalarElements();

        assertEquals("Scalars list size should be 0: ", 0, actual.size());
    }

    @Test
    public void testAddArray() {
        CMLAtomType cml = new CMLAtomType();
        cml.addArray(new CMLArray());
        CMLElements<CMLArray> actual = cml.getArrayElements();

        assertEquals("Arrays list size should be 1: ", 1, actual.size());
    }

    @Test
    public void testGetArrayElementsWhenNoArraysAdded() {
        CMLAtomType cml = new CMLAtomType();
        CMLElements<CMLArray> actual = cml.getArrayElements();

        assertEquals("Arrays list size should be 0: ", 0, actual.size());
    }

    @Test
    public void testAddMatrix() {
        CMLAtomType cml = new CMLAtomType();
        cml.addMatrix(new CMLMatrix());
        CMLElements<CMLMatrix> actual = cml.getMatrixElements();

        assertEquals("Matrix list size should be 1: ", 1, actual.size());
    }

    @Test
    public void testGetMatrixElementsWhenNoMatrixAdded() {
        CMLAtomType cml = new CMLAtomType();
        CMLElements<CMLMatrix> actual = cml.getMatrixElements();

        assertEquals("Matrix list size should be 0: ", 0, actual.size());
    }

    @Test
    public void testAddProperty() {
        CMLAtomType cml = new CMLAtomType();
        cml.addProperty(new CMLProperty());
        CMLElements<CMLProperty> actual = cml.getPropertyElements();

        assertEquals("Property list size should be 1: ", 1, actual.size());
    }

    @Test
    public void testGetPropertyElementsWhenNoPropertyAdded() {
        CMLAtomType cml = new CMLAtomType();
        CMLElements<CMLProperty> actual = cml.getPropertyElements();

        assertEquals("Property list size should be 0: ", 0, actual.size());
    }

    @Test
    public void testSetAttribute() {
        CMLAtomType cml = new CMLAtomType();
        cml.setAttribute("name", "testName");
        cml.setAttribute("title", "testTitle");
        cml.setAttribute("id", "testId");
        cml.setAttribute("convention", "testConvention");
        cml.setAttribute("dictRef", "test:dictRef");
        cml.setAttribute("ref", "testRef");
        cml.setAttribute("atomRef", "testAtomRef");

        assertEquals("Name should be 'testName': ", "testName", cml.getName());
        assertEquals("Title should be 'testTitle': ", "testTitle", cml.getTitle());
        assertEquals("Id should be 'testId': ", "testId", cml.getId());
        assertEquals("Convention should be 'testConvention': ", "testConvention", cml.getConvention());
        assertEquals("DictRef should be 'test:dictRef': ", "test:dictRef", cml.getDictRef());
        assertEquals("Ref condition value should be 'testRef': ", "testRef", cml.getRef());
        assertEquals("AtomRef condition value should be 'testAtomRef': ", "testAtomRef", cml.getAtomRef());
    }
}