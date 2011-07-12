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
