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

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.xmlcml.cml.element.CMLDictionary;
import org.xmlcml.cml.element.CMLEntry;

public class CMLDictionaryTest {

    private CMLEntry cmlEntry1 = new CMLEntry("1");
    private CMLEntry cmlEntry2 = new CMLEntry("2");

    @Test
    public void testRemoveEntryById() {
        CMLDictionary cmlDictionary = new CMLDictionary();
        cmlDictionary.insertChild(cmlEntry1, 0);
        cmlDictionary.insertChild(cmlEntry2, 1);

        cmlDictionary.removeEntryById("1");

        Assert.assertEquals(null, cmlDictionary.getCMLEntry("1"));
        Assert.assertEquals("2", cmlDictionary.getCMLEntry("2").getId());
    }

    @Test
    public void testRemoveEntry() {
        CMLDictionary cmlDictionary = new CMLDictionary();
        cmlDictionary.insertChild(cmlEntry1, 0);
        cmlDictionary.insertChild(cmlEntry2, 1);
        CMLEntry entryToBeRemoved = cmlEntry1;

        cmlDictionary.removeEntry(entryToBeRemoved);

        Assert.assertEquals(null, cmlDictionary.getCMLEntry("1"));
        Assert.assertEquals("2", cmlDictionary.getCMLEntry("2").getId());
    }

    @Test
    public void testAddEntry() {
        CMLDictionary cmlDictionary = new CMLDictionary();
        cmlDictionary.insertChild(cmlEntry1, 0);
        CMLEntry entryToBeAdded = new CMLEntry("4");

        cmlDictionary.addEntry(entryToBeAdded);

        Assert.assertEquals("4", cmlDictionary.getCMLEntry("4").getId());
    }

    @Test(expected = RuntimeException.class)
    public void testAddEntry_whenIdIsNull() {
        CMLDictionary cmlDictionary = new CMLDictionary();
        CMLEntry entryToBeAdded = new CMLEntry();

        cmlDictionary.addEntry(entryToBeAdded);
    }

    @Test(expected = RuntimeException.class)
    public void testAddEntry_whenIdIsAlreadyPresent() {
        CMLDictionary cmlDictionary = new CMLDictionary();
        cmlDictionary.insertChild(cmlEntry1, 0);
        cmlDictionary.insertChild(cmlEntry2, 1);
        CMLEntry entryToBeAdded = cmlEntry1;

        cmlDictionary.addEntry(entryToBeAdded);
    }

    @Test
    public void testAddEntryInOrder() {
        CMLDictionary cmlDictionary = new CMLDictionary();
        cmlDictionary.insertChild(cmlEntry1, 0);
        cmlDictionary.insertChild(cmlEntry2, 1);
        CMLEntry entryToBeAdded = new CMLEntry("0");

        cmlDictionary.addEntryInOrder(entryToBeAdded);

        Assert.assertEquals("0", cmlDictionary.getCMLEntry("0").getId());
    }

    @Test(expected = RuntimeException.class)
    public void testAddEntryInOrder_whenIdIsNull() {
        CMLDictionary cmlDictionary = new CMLDictionary();
        CMLEntry entryToBeAdded = new CMLEntry();

        cmlDictionary.addEntryInOrder(entryToBeAdded);
    }

    @Test
    public void testGetGenericEntry() {
        CMLDictionary cmlDictionary = new CMLDictionary();
        cmlDictionary.insertChild(cmlEntry1, 0);
        cmlDictionary.insertChild(cmlEntry2, 1);

        CMLEntry actual = cmlDictionary.getGenericEntry("1");

        Assert.assertEquals(actual,cmlEntry1);
    }
}
