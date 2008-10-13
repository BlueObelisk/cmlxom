package org.xmlcml.cml.element.lite;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.xmlcml.cml.element.main.AbstractTest;

/**
 * test bondStereo.
 *
 * @author pm286
 *
 */
public class CMLBondStereoTest extends AbstractTest {

    /**
     * setup.
     *
     * @exception Exception
     */
    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

    /**
     * Test method for
     * 'org.xmlcml.cml.element.CMLBondStereo.matchParity(CMLBondStereo,
     * CMLMolecule)'
     */
    @Test
    public void testMatchParity() {
    	String s = 
    		"<molecule id='m1' " + CML_XMLNS+">" +
    		"  <atomArray>" +
    		"    <atom id='a1' elementType='F'/>" +
    		"    <atom id='a2' elementType='C' hydrogenCount='1'/>" +
    		"    <atom id='a3' elementType='C' hydrogenCount='1'/>" +
    		"    <atom id='a4' elementType='Cl'/>" +
    		"  </atomArray>" +
    		"  <bondArray>" +
    		"    <bond atomRefs2='a1 a2' order='1'/>" +
    		"    <bond atomRefs2='a2 a3' order='2'>" +
    		"      <bondStereo atomRefs4='a1 a2 a3 a4'>C</bondStereo>" +
    		"    </bond>" +
    		"    <bond atomRefs2='a3 a4' order='1'/>" +
    		"  </bondArray>" +
    		"</molecule>";
    	CMLMolecule mol = (CMLMolecule) parseValidString(s);
    	CMLBond b2 = mol.getBondByAtomIds("a2","a3");
    	CMLBondStereo bs = b2.getBondStereo();
    	CMLBondStereo bs1 = new CMLBondStereo();
    	bs1.setAtomRefs4("a1 a2 a3 a4");
    	bs1.setXMLContent("C");
    	Assert.assertEquals("bs parity", 1, bs.matchParity(bs1));
    	// swap atom order
    	bs1.setAtomRefs4("a4 a3 a2 a1");
    	Assert.assertEquals("bs parity", 1, bs.matchParity(bs1));
    	// swap sterochemistry
    	bs1.setXMLContent("T");
    	Assert.assertEquals("bs parity", -1, bs.matchParity(bs1));
    	// garble order
    	bs1.setAtomRefs4("a4 a2 a3 a1");
    	Assert.assertEquals("bs parity", 0, bs.matchParity(bs1));
    }


}
