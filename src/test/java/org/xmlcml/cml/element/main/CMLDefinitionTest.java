package org.xmlcml.cml.element.main;

import java.util.List;

import junit.framework.Assert;

import nu.xom.Element;

import org.junit.Test;
import org.xmlcml.cml.base.CMLElement;
import org.xmlcml.cml.element.CMLDefinition;

public class CMLDefinitionTest {
    @Test
    public void testCMLDefinition() {
        CMLDefinition def = new CMLDefinition();
        Assert.assertNotNull(def);
    }
    @Test
    public void testAddString(){
        CMLDefinition def = new CMLDefinition();
        def.addPlainText("Test!");
        Assert.assertEquals(1, def.getChildCount());
        Assert.assertEquals("Test!", def.getChild(0).getValue());
        Assert.assertEquals(1, def.getXHTMLElementList().size());
        String name=def.getXHTMLElementList().get(0).getLocalName();
        Assert.assertEquals("p", name);
    }
    
    @Test
    public void testCopyConstructor(){
        CMLDefinition def = new CMLDefinition();
        def.addPlainText("This is a test.");
        def.addPlainText("Has this worked?");
        CMLDefinition newDef = new CMLDefinition(def);
        Assert.assertEquals(2, newDef.getChildCount());
        Assert.assertEquals("Has this worked?", newDef.getChild(1).getValue());
    }
    @Test
    public void testGetXHTML(){
        CMLDefinition def = new CMLDefinition();
        def.addPlainText("This is a test.");
        def.addPlainText("Has this worked?");
        CMLElement cml = new CMLElement("cml");
        def.appendChild(cml);
        List<Element> list=def.getXHTMLElementList();
        Assert.assertEquals(2, list.size());
        Assert.assertEquals("This is a test.", list.get(0).getValue());
    }
    @Test
    public void testRemoveXHTML(){
        CMLDefinition def = new CMLDefinition();
        def.addPlainText("This is a test.");
        def.addPlainText("Has this worked?");
        def.removeXHTMLChildren();
        Assert.assertEquals(0, def.getXHTMLElementList().size());
    }
    @Test
    public void testFlatternText(){
        CMLDefinition def = new CMLDefinition();
        def.addPlainText("This is a test.");
        def.addPlainText("Has this worked?");
        String text=def.getFlatText();
        Assert.assertEquals(15, text.indexOf('\n'));
        Assert.assertEquals(-1,text.substring(16).indexOf('\n'));
    }
}
