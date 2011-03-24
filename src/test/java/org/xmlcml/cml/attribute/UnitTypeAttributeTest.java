package org.xmlcml.cml.attribute;

import junit.framework.Assert;

import org.junit.Test;
import org.xmlcml.cml.element.CMLEntry;

public class UnitTypeAttributeTest {

    @Test
    public void testConstructer(){
        UnitTypeAttribute att = new UnitTypeAttribute();
        Assert.assertNotNull(att);
    }
    
    @Test
    public void testValueConstructer(){
        UnitTypeAttribute att = new UnitTypeAttribute("test:Test");
        Assert.assertEquals("test:Test", att.getValue());
    }
    
    @Test
    public void testAddToEntry(){
        CMLEntry entry = new CMLEntry();
        entry.setUnitType("test:Test");
        Assert.assertEquals("test:Test", entry.getUnitType());
    }
    
    @Test
    public void testValueChange(){
        CMLEntry entry = new CMLEntry();
        entry.setUnitType("test:Test1");
        entry.setUnitType("test:Test2");
        Assert.assertEquals("test:Test2", entry.getUnitType());
    }
}
