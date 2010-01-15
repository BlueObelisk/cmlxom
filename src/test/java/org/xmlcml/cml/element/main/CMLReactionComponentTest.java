package org.xmlcml.cml.element.main;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.xmlcml.cml.element.CMLAtom;
import org.xmlcml.cml.element.CMLBond;
import org.xmlcml.cml.element.CMLFormula;
import org.xmlcml.cml.element.CMLMolecule;
import org.xmlcml.cml.element.CMLProduct;
import org.xmlcml.cml.element.CMLReactant;

/**
 * test ReactionComponent.
 *
 * @author pmr
 *
 */
public class CMLReactionComponentTest extends ReactionAllTestBase {

    /**
     * setup.
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

    /**
     * Test method for 'org.xmlcml.cml.element.ReactionComponent.getMolecules()'
     */
    @Test
    public void testGetMolecules() {
        List<CMLMolecule> moleculeList = xmlReact1.getMolecules();
        Assert.assertEquals("get molecules size", 7, moleculeList.size());
        Assert.assertEquals("get molecules 1 ", "rm1", moleculeList.get(0)
                .getId());
        Assert.assertEquals("get molecules 2 ", "rm2", moleculeList.get(1)
                .getId());
        Assert.assertEquals("get molecules 3 ", "pm1", moleculeList.get(2)
                .getId());
        Assert.assertEquals("get molecules 4 ", "pm2", moleculeList.get(3)
                .getId());
        Assert.assertEquals("get molecules 5 ", "sm1", moleculeList.get(4)
                .getId());
        Assert.assertEquals("get molecules 6 ", "sm2", moleculeList.get(5)
                .getId());

        moleculeList = xmlReactantList1.getMolecules();
        Assert.assertEquals("get molecules size", 2, moleculeList.size());
        Assert.assertEquals("get reactants 1 ", "rm1", moleculeList.get(0)
                .getId());
        Assert.assertEquals("get reactants 1 ", "rm2", moleculeList.get(1)
                .getId());

        moleculeList = xmlProductList1.getMolecules();
        Assert.assertEquals("get molecules size", 2, moleculeList.size());
        Assert.assertEquals("get products 1 ", "pm1", moleculeList.get(0)
                .getId());
        Assert.assertEquals("get products 1 ", "pm2", moleculeList.get(1)
                .getId());

        moleculeList = xmlSpectatorList1.getMolecules();
        Assert.assertEquals("get molecules size", 2, moleculeList.size());
        Assert.assertEquals("get spectators 1 ", "sm1", moleculeList.get(0)
                .getId());
        Assert.assertEquals("get spectators 1 ", "sm2", moleculeList.get(1)
                .getId());

        moleculeList = xmlReactants1.get(0).getMolecules();
        Assert.assertEquals("get molecules size", 1, moleculeList.size());
        Assert.assertEquals("get reactant 1 ", "rm1", moleculeList.get(0)
                .getId());

        moleculeList = xmlProducts1.get(0).getMolecules();
        Assert.assertEquals("get molecules size", 1, moleculeList.size());
        Assert.assertEquals("get product 1 ", "pm1", moleculeList.get(0)
                .getId());

        moleculeList = xmlSpectators1.get(0).getMolecules();
        Assert.assertEquals("get molecules size", 1, moleculeList.size());
        Assert.assertEquals("get spectator 1 ", "sm1", moleculeList.get(0)
                .getId());
    }

    /**
     * Test method for 'org.xmlcml.cml.element.ReactionComponent.getAtoms()'
     */
    @Test
    public void testGetAtoms() {
        List<CMLAtom> atomList = xmlReact1.getAtoms();
        Assert.assertEquals("get atoms size", 9, atomList.size());
        Assert.assertEquals("get atoms 1 ", "a1", atomList.get(0).getId());
        Assert.assertEquals("get atoms 2 ", "a2", atomList.get(1).getId());
        Assert.assertEquals("get atoms 3 ", "a3", atomList.get(2).getId());
        Assert.assertEquals("get atoms 4 ", "a1", atomList.get(3).getId());
        Assert.assertEquals("get atoms 5 ", "a2", atomList.get(4).getId());
        Assert.assertEquals("get atoms 6 ", "a3", atomList.get(5).getId());
        Assert.assertEquals("get atoms 7 ", "a1", atomList.get(6).getId());
        Assert.assertEquals("get atoms 8 ", "a2", atomList.get(7).getId());
        Assert.assertEquals("get atoms 9 ", "a3", atomList.get(8).getId());

        atomList = xmlReactantList1.getAtoms();
        Assert.assertEquals("get atoms size", 3, atomList.size());
        Assert.assertEquals("get reactants 1 ", "a1", atomList.get(0).getId());
        Assert.assertEquals("get reactants 2 ", "a2", atomList.get(1).getId());
        Assert.assertEquals("get reactants 3 ", "a3", atomList.get(2).getId());

        atomList = xmlProductList1.getAtoms();
        Assert.assertEquals("get atoms size", 3, atomList.size());
        Assert.assertEquals("get products 1 ", "a1", atomList.get(0).getId());
        Assert.assertEquals("get products 2 ", "a2", atomList.get(1).getId());
        Assert.assertEquals("get products 3 ", "a3", atomList.get(2).getId());

        atomList = xmlSpectatorList1.getAtoms();
        Assert.assertEquals("get atoms size", 3, atomList.size());
        Assert.assertEquals("get spectators 1 ", "a1", atomList.get(0).getId());
        Assert.assertEquals("get spectators 2 ", "a2", atomList.get(1).getId());
        Assert.assertEquals("get spectators 3 ", "a3", atomList.get(2).getId());

        atomList = xmlReactants1.get(0).getAtoms();
        Assert.assertEquals("get atoms size", 2, atomList.size());
        Assert.assertEquals("get reactant 1 ", "a1", atomList.get(0).getId());
        Assert.assertEquals("get reactant 2 ", "a2", atomList.get(1).getId());

        atomList = xmlProducts1.get(0).getAtoms();
        Assert.assertEquals("get atoms size", 2, atomList.size());
        Assert.assertEquals("get product 1 ", "a1", atomList.get(0).getId());
        Assert.assertEquals("get product 2 ", "a2", atomList.get(1).getId());

        atomList = xmlSpectators1.get(0).getAtoms();
        Assert.assertEquals("get atoms size", 2, atomList.size());
        Assert.assertEquals("get spectator 1 ", "a1", atomList.get(0).getId());
        Assert.assertEquals("get spectator 2 ", "a2", atomList.get(1).getId());
    }

    /**
     * Test method for 'org.xmlcml.cml.element.ReactionComponent.getBonds()'
     */
    @Test
    public void testGetBonds() {
        List<CMLBond> bondList = xmlReact1.getBonds();
        Assert.assertEquals("get bonds size", 2, bondList.size());
        Assert.assertEquals("get bonds 1 ", "r_a1_a2", bondList.get(0).getId());
        Assert.assertEquals("get bonds 2 ", "p_a1_a2", bondList.get(1).getId());

        bondList = xmlReactantList1.getBonds();
        Assert.assertEquals("get bonds size", 1, bondList.size());
        Assert.assertEquals("get reactants 1 ", "r_a1_a2", bondList.get(0)
                .getId());

        bondList = xmlProductList1.getBonds();
        Assert.assertEquals("get bonds size", 1, bondList.size());
        Assert.assertEquals("get products 1 ", "p_a1_a2", bondList.get(0)
                .getId());

        bondList = xmlSpectatorList1.getBonds();
        Assert.assertEquals("get bonds size", 0, bondList.size());

        bondList = xmlReactants1.get(0).getBonds();
        Assert.assertEquals("get bonds size", 1, bondList.size());
        Assert.assertEquals("get reactant 1 ", "r_a1_a2", bondList.get(0)
                .getId());

        bondList = xmlProducts1.get(0).getBonds();
        Assert.assertEquals("get bonds size", 1, bondList.size());
        Assert.assertEquals("get product 1 ", "p_a1_a2", bondList.get(0)
                .getId());

        bondList = xmlSpectators1.get(0).getBonds();
        Assert.assertEquals("get bonds size", 0, bondList.size());
    }

    /**
     * Test method for 'org.xmlcml.cml.element.ReactionComponent.getFormulas()'
     */
    @Test
    public void testGetFormulas() {
        makeXmlReact2();
        List<CMLFormula> formulaList = xmlReact2.getFormulas();
        Assert.assertEquals("get formulas size", 4, formulaList.size());
        Assert.assertEquals("get formulas 1 ", "r_f1", formulaList.get(0)
                .getId());
        Assert.assertEquals("get formulas 2 ", "r_f2", formulaList.get(1)
                .getId());
        Assert.assertEquals("get formulas 3 ", "p_f1", formulaList.get(2)
                .getId());
        Assert.assertEquals("get formulas 4 ", "p_f2", formulaList.get(3)
                .getId());
        Assert.assertEquals("concise formulas 1 ", "H 1 Cl 1", formulaList.get(
                0).getConcise());
        Assert.assertEquals("concise formulas 2 ", "H 1 Na 1 O 1", formulaList
                .get(1).getConcise());
        Assert.assertEquals("concise formulas 3 ", "H 2 O 1", formulaList
                .get(2).getConcise());
        Assert.assertEquals("concise formulas 4 ", "Cl 1 Na 1", formulaList
                .get(3).getConcise());

        List<CMLReactant> reactantList = xmlReact2.getDescendantReactants();
        Assert.assertEquals("reactant count ", 2, reactantList.size());
        List<CMLFormula> reactantFormulaList1 = reactantList.get(0)
                .getFormulas();
        Assert.assertEquals("reactant 1 formula count ", 1,
                reactantFormulaList1.size());
        Assert.assertEquals("concise formulas 1 ", "H 1 Cl 1",
                reactantFormulaList1.get(0).getConcise());
        List<CMLFormula> reactantFormulaList2 = reactantList.get(1)
                .getFormulas();
        Assert.assertEquals("reactant 2 formula count ", 1,
                reactantFormulaList2.size());
        Assert.assertEquals("concise formulas 2 ", "H 1 Na 1 O 1",
                reactantFormulaList2.get(0).getConcise());

        List<CMLProduct> productList = xmlReact2.getDescendantProducts();
        Assert.assertEquals("product count ", 2, productList.size());
        List<CMLFormula> productFormulaList1 = productList.get(0).getFormulas();
        Assert.assertEquals("product 1 formula count ", 1, productFormulaList1
                .size());
        Assert.assertEquals("concise formulas 1 ", "H 2 O 1",
                productFormulaList1.get(0).getConcise());
        List<CMLFormula> productFormulaList2 = productList.get(1).getFormulas();
        Assert.assertEquals("product 2 formula count ", 1, productFormulaList2
                .size());
        Assert.assertEquals("concise formulas 1 ", "Cl 1 Na 1",
                productFormulaList2.get(0).getConcise());
    }

//    /**
//     * Test method for
//     * 'org.xmlcml.cml.element.ReactionComponent.getReactionComponentDescendants()'
//     */
//    @Test
//    public void testGetReactionComponentDescendants() {
//        List<ReactionComponent> componentList = xmlReact1
//                .getReactionComponentDescendants();
//        Assert.assertEquals("descendants", 9, componentList.size());
//        // reactantList
//        Assert.assertEquals("descendant 1", "rl1", ((CMLElement) componentList
//                .get(0)).getAttributeValue(IdAttribute.NAME));
//        // reactants
//        Assert.assertEquals("descendant 2", "re1", ((CMLElement) componentList
//                .get(1)).getAttributeValue(IdAttribute.NAME));
//        Assert.assertEquals("descendant 3", "re2", ((CMLElement) componentList
//                .get(2)).getAttributeValue(IdAttribute.NAME));
//        // productList
//        Assert.assertEquals("descendant 4", "pl1", ((CMLElement) componentList
//                .get(3)).getAttributeValue(IdAttribute.NAME));
//        // products
//        Assert.assertEquals("descendant 5", "pr1", ((CMLElement) componentList
//                .get(4)).getAttributeValue(IdAttribute.NAME));
//        Assert.assertEquals("descendant 6", "pr2", ((CMLElement) componentList
//                .get(5)).getAttributeValue(IdAttribute.NAME));
//        // spectatorList
//        Assert.assertEquals("descendant 7", "sl1", ((CMLElement) componentList
//                .get(6)).getAttributeValue(IdAttribute.NAME));
//        // spectators
//        Assert.assertEquals("descendant 8", "sp1", ((CMLElement) componentList
//                .get(7)).getAttributeValue(IdAttribute.NAME));
//        Assert.assertEquals("descendant 9", "sp2", ((CMLElement) componentList
//                .get(8)).getAttributeValue(IdAttribute.NAME));
//    }

//    /**
//     * Test method for
//     * 'org.xmlcml.cml.element.ReactionComponent.getReactionComponentChildren()'
//     */
//    @Test
//    public void testGetReactionComponentChildren() {
//        List<ReactionComponent> componentList = xmlReact1
//                .getReactionComponentChildren();
//        Assert.assertEquals("children", 3, componentList.size());
//        // reactantList
//        Assert.assertEquals("child 1", "rl1", ((CMLElement) componentList
//                .get(0)).getAttributeValue(IdAttribute.NAME));
//        // productList
//        Assert.assertEquals("child 2", "pl1", ((CMLElement) componentList
//                .get(1)).getAttributeValue(IdAttribute.NAME));
//        // spectatorList
//        Assert.assertEquals("child 3", "sl1", ((CMLElement) componentList
//                .get(2)).getAttributeValue(IdAttribute.NAME));
//
//        componentList = xmlReact1.getReactantListElements().get(0)
//                .getReactionComponentChildren();
//        Assert.assertEquals("reactants", 2, componentList.size());
//        Assert.assertEquals("reactant 1", "re1", ((CMLElement) componentList
//                .get(0)).getAttributeValue(IdAttribute.NAME));
//        Assert.assertEquals("reactant 2", "re2", ((CMLElement) componentList
//                .get(1)).getAttributeValue(IdAttribute.NAME));
//
//        componentList = xmlReact1.getProductListElements().get(0)
//                .getReactionComponentChildren();
//        Assert.assertEquals("products", 2, componentList.size());
//        Assert.assertEquals("product 1", "pr1", ((CMLElement) componentList
//                .get(0)).getAttributeValue(IdAttribute.NAME));
//        Assert.assertEquals("product 2", "pr2", ((CMLElement) componentList
//                .get(1)).getAttributeValue(IdAttribute.NAME));
//
//        componentList = xmlReact1.getSpectatorListElements().get(0)
//                .getReactionComponentChildren();
//        Assert.assertEquals("spectators", 2, componentList.size());
//        Assert.assertEquals("spectator 1", "sp1", ((CMLElement) componentList
//                .get(0)).getAttributeValue(IdAttribute.NAME));
//        Assert.assertEquals("spectator 2", "sp2", ((CMLElement) componentList
//                .get(1)).getAttributeValue(IdAttribute.NAME));
//
//    }

    /**
     * run tests.
     *
     * @return the suite.
     *
     */
 }
