package org.xmlcml.cml.element.main;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
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
    public void setUp() throws Exception {
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


}
