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

//    /**
//     * Test method for 'org.xmlcml.cml.element.CMLSpectator.getFormula()'
//     */
//    @Test
//    public void testGetFormula() {
//        CMLFormula formula = spectator.getFormula();
//        String ss = S_EMPTY +
//                "<formula formalCharge=\'0\' concise=\'F 1 P 1\' xmlns=\'http://www.xml-cml.org/schema\'>" +
//                "  <atomArray elementType=\'F P\' count=\'1.0 1.0\'/>" +
//                "</formula>";
//        CMLFormula expected = (CMLFormula) parseValidString(ss);
//        assertEqualsCanonically("form",expected, formula, true);
//    }

    /**
     * Test method for
     * 'org.xmlcml.cml.element.CMLSpectator.mergeChildMolecules()'
     */
    @Test
    @Ignore
    public void testMergeChildMolecules() {

    }

    /**
     * Test method for
     * 'org.xmlcml.cml.element.CMLSpectator.moveLabelledReactantsProducts(Elements,
     * String)'
     */
    @Test
    @Ignore
    public void testMoveLabelledReactantsProducts() {

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

    /**
     * Test method for 'org.xmlcml.cml.element.CMLSpectator.getFormulas()'
     */
    @Test
    @Ignore
    public void testGetFormulas() {

    }

    /**
     * Test method for 'org.xmlcml.cml.element.CMLSpectator.getMolecules()'
     */
    @Test
    @Ignore
    public void testGetMolecules() {

    }

    /**
     * Test method for
     * 'org.xmlcml.cml.element.CMLSpectator.getReactionComponentDescendants()'
     */
    @Test
    @Ignore
    public void testGetReactionComponentDescendants() {

    }

    /**
     * Test method for
     * 'org.xmlcml.cml.element.CMLSpectator.getReactionComponentChildren()'
     */
    @Test
    @Ignore
    public void testGetReactionComponentChildren() {

    }


}
