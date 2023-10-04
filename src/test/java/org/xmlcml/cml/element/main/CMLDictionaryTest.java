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

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.xmlcml.cml.element.CMLDictionary;
import org.xmlcml.cml.element.CMLEntry;

public class CMLDictionaryTest {

    protected CMLDictionary cmlDictionary = null;
    private CMLEntry cmlEntry1 = new CMLEntry("1");
    private CMLEntry cmlEntry2 = new CMLEntry("2");

    @Before
    public void setup() {

        cmlDictionary = new CMLDictionary();
        cmlDictionary.insertChild(cmlEntry1, 0);
        cmlDictionary.insertChild(cmlEntry2, 1);
        int actual = cmlDictionary.indexEntries();
        Assert.assertEquals(2, actual);
    }

    @Test
    public void testRemoveEntryById() {
        cmlDictionary.removeEntryById("1");

        Assert.assertEquals(null, cmlDictionary.getCMLEntry("1"));
        Assert.assertEquals("2", cmlDictionary.getCMLEntry("2").getId());
    }

    @Test
    public void testRemoveEntry() {
        CMLEntry entryToBeRemoved = new CMLEntry("1");

        cmlDictionary.removeEntry(entryToBeRemoved);

        Assert.assertEquals(null, cmlDictionary.getCMLEntry("1"));
        Assert.assertEquals("2", cmlDictionary.getCMLEntry("2").getId());
    }

    @Test
    public void testAddEntry() {
        CMLEntry entryToBeAdded = new CMLEntry("4");

        cmlDictionary.addEntry(entryToBeAdded);

        Assert.assertEquals("4", cmlDictionary.getCMLEntry("4").getId());
    }

    @Test(expected = RuntimeException.class)
    public void testAddEntry_whenIdIsNull() {
        CMLEntry entryToBeAdded = new CMLEntry();

        cmlDictionary.addEntry(entryToBeAdded);
    }

    @Test(expected = RuntimeException.class)
    public void testAddEntry_whenIdIsAlreadyPresent() {
        CMLEntry entryToBeAdded = new CMLEntry("1");

        cmlDictionary.addEntry(entryToBeAdded);
    }

    @Test
    public void testAddEntryInOrder() {
        CMLEntry entryToBeAdded = new CMLEntry("0");

        cmlDictionary.addEntryInOrder(entryToBeAdded);

        Assert.assertEquals("0", cmlDictionary.getCMLEntry("0").getId());
    }

    @Test(expected = RuntimeException.class)
    public void testAddEntryInOrder_whenIdIsNull() {
        CMLEntry entryToBeAdded = new CMLEntry();

        cmlDictionary.addEntryInOrder(entryToBeAdded);
    }

    @Test
    public void testGetGenericEntry() {
        CMLEntry actual = cmlDictionary.getGenericEntry("1");
        Assert.assertEquals(actual,cmlEntry1);
    }
}
