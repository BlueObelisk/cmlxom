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

import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.xmlcml.cml.element.CMLAmount;
import org.xmlcml.cml.element.CMLAtom;
import org.xmlcml.cml.element.CMLBond;
import org.xmlcml.cml.element.CMLSpectator;

/**
 * tests spectator.
 *
 * @author pm286
 *
 */
public class CMLSpectatorTest extends ReactionAllTestBase {

    CMLSpectator spectator = null;
    /**
     * setup.
     *
     * @throws Exception
     */
    @Before
    public synchronized void setUp() throws Exception {
        super.setUp();
        spectator = xmlSpectatorList1.getSpectatorElements().get(0);
    }

    /**
     * Test method for 'org.xmlcml.cml.element.CMLSpectator.getAtoms()'
     */
    @Test
    public void testGetAtoms() {
        List<CMLAtom> atoms = spectator.getAtoms();
        Assert.assertEquals("atoms", 2, atoms.size());

    }

    /**
     * Test method for 'org.xmlcml.cml.element.CMLSpectator.getBonds()'
     */
    @Test
    public void testGetBonds() {
        List<CMLBond> bonds = spectator.getBonds();
        Assert.assertEquals("bonds", 0, bonds.size());
    }

    
    @Test
    public void testAddAndGetAmounts() {
    	CMLSpectator spectator = new CMLSpectator();
    	Assert.assertEquals(0, spectator.getAmountElements().size());
    	
    	CMLAmount amount1 = new CMLAmount();
    	spectator.addAmount(amount1);
    	Assert.assertEquals(1, spectator.getAmountElements().size());
    	Iterator<CMLAmount> iterator1 = spectator.getAmountElements().iterator();
    	Assert.assertTrue(iterator1.next() == amount1);
    	
    	CMLAmount amount2 = new CMLAmount();
    	spectator.addAmount(amount2);
    	Assert.assertEquals(2, spectator.getAmountElements().size());
    	Iterator<CMLAmount> iterator2 = spectator.getAmountElements().iterator();
    	Assert.assertTrue(iterator2.next() == amount1);
    	Assert.assertTrue(iterator2.next() == amount2);
    }
    
}
