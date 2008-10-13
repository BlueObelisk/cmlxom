package org.xmlcml.cml.base;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
/**
 * test for attribute.
 * 
 * @author pmr
 * 
 */
public class AttributeTest extends BaseTest {
    CMLAttribute att1;
    /**
     * main.
     * 
     * @param args
     */
    public static void main(String[] args) {
    }
    /**
     * setup.
     * 
     * @Exception Exception
     */
    /**
     * setup.
     * 
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        super.setUp();
        att1 = new CMLAttribute("name", "value");
    }
    /**
     * Test method for 'org.xmlcml.cml.base.CMLAttribute.CMLAttribute(String)'
     */
    @Test
    public void testCMLAttributeString() {
        CMLAttribute string = new CMLAttribute("string");
        Assert.assertEquals("string att", "string", string.getLocalName());
        Assert.assertEquals("string att", "string", string.getQualifiedName());
        Assert.assertEquals("string att", "string", string.getLocalName());
        Assert.assertEquals("string att", S_EMPTY, string.getValue());
        Assert.assertEquals("string att", S_EMPTY, string.getCMLValue());
        Assert.assertEquals("string att", S_EMPTY, string.getNamespaceURI());
        Assert.assertEquals("string att", "String", string.getJavaType());
//        Assert.assertEquals("string att", "setCMLValue", string
//                .getJavaSetMethod());
//        Assert.assertEquals("string att", "getCMLValue", string
//                .getJavaGetMethod());
//        Assert.assertEquals("string att", "CMLAttribute", string
//                .getJavaShortClassName());
        Assert.assertNull("string att", string.getSchemaType());
        Assert.assertNull("string att", string.getSummary());
        Assert.assertNull("string att", string.getDescription());
    }
    /**
     * Test method for 'org.xmlcml.cml.base.CMLAttribute.CMLAttribute(String,
     * String)'
     */
    @Test
    public void testCMLAttributeStringString() {
        CMLAttribute string = new CMLAttribute("string", "a1");
        Assert.assertEquals("string att", "string", string.getLocalName());
        Assert.assertEquals("string att", "string", string.getQualifiedName());
        Assert.assertEquals("string att", "string", string.getLocalName());
        Assert.assertEquals("string att", "a1", string.getValue());
        Assert.assertEquals("string att", "a1", string.getCMLValue());
        Assert.assertEquals("string att", S_EMPTY, string.getNamespaceURI());
        Assert.assertEquals("string att", "String", string.getJavaType());
//        Assert.assertEquals("string att", "setCMLValue", string
//                .getJavaSetMethod());
//        Assert.assertEquals("string att", "getCMLValue", string
//                .getJavaGetMethod());
        Assert.assertEquals("string att", "CMLAttribute", string
                .getJavaShortClassName());
        Assert.assertNull("string att", string.getSchemaType());
        Assert.assertNull("string att", string.getSummary());
        Assert.assertNull("string att", string.getDescription());
    }
    /**
     * Test method for
     * 'org.xmlcml.cml.base.CMLAttribute.CMLAttribute(CMLAttribute)'
     */
    @Test
    public void testCMLAttributeCMLAttribute() {
        CMLAttribute att = new CMLAttribute(att1);
        Assert.assertNotNull("att copy", att);
        Assert.assertEquals("att copy", 0, att1.compareTo(att));
    }
    /**
     * Test method for 'org.xmlcml.cml.base.CMLAttribute.copy()'
     */
    @Test
    public void testCopy() {
        CMLAttribute att = (CMLAttribute) att1.copy();
        Assert.assertNotNull("att copy", att);
        Assert.assertEquals("att copy", 0, att1.compareTo(att));
    }
    /**
     * Test method for 'org.xmlcml.cml.base.CMLAttribute.compareTo(Attribute)'
     */
    @Test
    public void testCompareTo() {
        CMLAttribute att = new CMLAttribute(att1);
        Assert.assertEquals("compare", "name", att.getLocalName());
        Assert.assertEquals("compare", "value", att.getValue());
        Assert.assertEquals("compare", 0, att.compareTo(att1));
    }
    /**
     * Test method for 'org.xmlcml.cml.base.CMLAttribute.setSchemaType(String)'
     */
    @Test
    public void testGetSetSchemaType() {
        // test CMLType
        CMLType st = new CMLType();
        String namex = "formalChargeType";
        st.setName(namex);
        st.setBase("xsd:integer");
        st.setId("st.formalChargeType");
        st.setSummary("The formal charge on an object.");
        st
                .setDescription("Used for electron-bookeeping. This has no relation to its calculated (fractional) charge or oxidation state.");
        Assert.assertNull("schema type", att1.getSchemaType());
        att1.setSchemaType(st);
        CMLType fc = att1.getSchemaType();
        Assert.assertNotNull("schema type fc", fc);
        Assert.assertEquals("schema type fc", "formalChargeType", fc.getName());
        Assert.assertEquals("schema type fc", XSD_INTEGER, fc.getBase());
    }
    /**
     * Test method for 'org.xmlcml.cml.base.CMLAttribute.getCMLValue()'
     */
    @Test
    public void testGetCMLValue() {
    }
    /**
     * Test method for 'org.xmlcml.cml.base.CMLAttribute.setCMLValue(String)'
     */
    @Test
    public void testSetCMLValue() {
    }
    /**
     * Test method for
     * 'org.xmlcml.cml.base.CMLAttribute.createSubclassedAttribute(Attribute,
     * String)'
     */
    @Test
    public void testCreateSubclassedAttribute() {
        // this is used in copy...
    }
    /**
     * Test method for 'org.xmlcml.cml.base.CMLAttribute.getSummary()'
     */
    @Test
    public void testGetSetDocumentation() {
        Assert.assertNull("doc", att1.getSummary());
        Assert.assertNull("doc", att1.getDescription());
        att1.setSummary("the x2 coordinate");
        att1
                .setDescription("x2 is the 2D coordinate in arbitrary units.\n it should always be accompanied by y2");
        // note added period
        Assert
                .assertEquals("doc", "the x2 coordinate" + S_PERIOD, att1
                        .getSummary());
        Assert
                .assertEquals(
                        "doc",
                        "x2 is the 2D coordinate in arbitrary units.\n it should always be accompanied by y2",
                        att1.getDescription());
        att1.setSummary("the y2 coordinate.");
        att1
                .setDescription("y2 is the 2D coordinate in arbitrary units.\n it should always be accompanied by x2");
        // note added period
        Assert.assertEquals("doc", "the y2 coordinate.", att1.getSummary());
        Assert
                .assertEquals(
                        "doc",
                        "y2 is the 2D coordinate in arbitrary units.\n it should always be accompanied by x2",
                        att1.getDescription());
    }
    /**
     * Test method for 'nu.xom.Attribute.getNamespacePrefix()'
     */
    @Test
    public void testGetSetNamespace() {
        Assert.assertEquals("namespace", S_EMPTY, att1.getNamespacePrefix());
        att1.setNamespace("xyz", "http://foo");
        Assert.assertEquals("namespace", "xyz", att1.getNamespacePrefix());
        Assert.assertEquals("namespace", "http://foo", att1.getNamespaceURI());
        att1.setNamespace("xyz", "http://bar");
        Assert.assertEquals("namespace", "xyz", att1.getNamespacePrefix());
        Assert.assertEquals("namespace", "http://bar", att1.getNamespaceURI());
        att1.setNamespace("abc", "http://bar");
        Assert.assertEquals("namespace", "abc", att1.getNamespacePrefix());
        Assert.assertEquals("namespace", "http://bar", att1.getNamespaceURI());
    }
}
