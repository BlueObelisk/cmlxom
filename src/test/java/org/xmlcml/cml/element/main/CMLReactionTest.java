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

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.xmlcml.cml.base.CMLConstants;
import org.xmlcml.cml.base.CMLElements;
import org.xmlcml.cml.base.CMLXOMTestUtils;
import org.xmlcml.cml.element.CMLAtom;
import org.xmlcml.cml.element.CMLBond;
import org.xmlcml.cml.element.CMLFormula;
import org.xmlcml.cml.element.CMLMolecule;
import org.xmlcml.cml.element.CMLProduct;
import org.xmlcml.cml.element.CMLProductList;
import org.xmlcml.cml.element.CMLReactant;
import org.xmlcml.cml.element.CMLReactantList;
import org.xmlcml.cml.element.CMLReaction;
import org.xmlcml.cml.element.CMLSpectator;
import org.xmlcml.cml.element.CMLSpectatorList;
import org.xmlcml.cml.element.CMLSubstance;
import org.xmlcml.cml.element.CMLSubstanceList;
import org.xmlcml.cml.element.CMLReaction.Component;

/**
 * test CMLReaction.
 * 
 * @author pmr
 * 
 */
public class CMLReactionTest extends ReactionAllTestBase {
	/**
	 * setup.
	 * 
	 * @throws Exception
	 */
	@Before
	public synchronized void setUp() throws Exception {
		super.setUp();
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLReaction.copy()'
	 */
	@Test
	public void testCopy() {
		CMLReaction reaction = (CMLReaction) xmlReact1.copy();
		CMLReactantList rl = reaction.getReactantList();
		Assert.assertNotNull("reactantList", rl);
		CMLElements<CMLReactant> reactants = rl.getReactantElements();
		Assert.assertEquals("reactants", 2, reactants.size());
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLReaction.CMLReaction(CMLReaction)'
	 */
	@Test
	public void testCMLReactionCMLReaction() {
		CMLReaction reaction = new CMLReaction(xmlReact1);
		CMLReactantList rl = reaction.getReactantList();
		Assert.assertNotNull("reactantList", rl);
		CMLElements<CMLReactant> reactants = rl.getReactantElements();
		Assert.assertEquals("reactants", 2, reactants.size());
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLReaction.getId(String)'
	 */
	@Test
	public void testGetIdString() {
		String id = xmlReact1.getId(Component.REACTANT.name);
		Assert.assertEquals("reaction id", "r1.reactant", id);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLReaction.mergeProductLists()'
	 */
	@Test
	public void testMergeProductLists() {
		makeMultiProductReactantLists();
		Assert.assertEquals("reactant lists", 2, multiReact1
				.getReactantListElements().size());
		Assert.assertEquals("product lists", 2, multiReact1
				.getProductListElements().size());
		multiReact1.mergeProductLists();
		Assert.assertEquals("reactant lists", 2, multiReact1
				.getReactantListElements().size());
		Assert.assertEquals("product lists", 1, multiReact1
				.getProductListElements().size());
		multiReact1.mergeReactantLists();
		Assert.assertEquals("reactant lists", 1, multiReact1
				.getReactantListElements().size());
		Assert.assertEquals("product lists", 1, multiReact1
				.getProductListElements().size());
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLReaction.getReactantList()'
	 */
	@Test
	public void testGetReactantList() {
		CMLReactantList rl = xmlReact1.getReactantList();
		Assert.assertNotNull("reactantList", rl);
		CMLElements<CMLReactant> reactants = rl.getReactantElements();
		Assert.assertEquals("reactants", 2, reactants.size());
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLReaction.getProductList()'
	 */
	@Test
	public void testGetProductList() {
		CMLProductList pl = xmlReact1.getProductList();
		Assert.assertNotNull("productList", pl);
		CMLElements<CMLProduct> products = pl.getProductElements();
		Assert.assertEquals("products", 2, products.size());
	}

	@Test
	public void testGetSpectatorList() {
		CMLSpectatorList sl = xmlReact1.getSpectatorList();
		Assert.assertNotNull("spectatorList", sl);
		CMLElements<CMLSpectator> spectators = sl.getSpectatorElements();
		Assert.assertEquals("spectators", 2, spectators.size());
	}
	
	/**
	 * Test method for 'org.xmlcml.cml.element.CMLReaction.getFilename()'
	 */
	@Test
	public void testGetFilename() {
		String filename = xmlReact1.getFilename();
		Assert.assertEquals("filename", "r1", filename);
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLReaction.getSpectatorMolecules(int)'
	 */
	@Test
	public void testGetSpectatorMolecules() {
		List<CMLMolecule> spects = xmlReact1.getSpectatorMolecules(0);
		Assert.assertEquals("getSpectatorMolecules ", 2, spects.size());
		Assert.assertEquals("getSpectatorMolecules 0", "sm1", spects.get(0)
				.getId());
		Assert.assertEquals("getSpectatorMolecules 1", "sm2", spects.get(1)
				.getId());
		Assert.assertEquals("getSpectatorMolecules 0", 2, spects.get(0)
				.getAtoms().size());
		Assert.assertEquals("getSpectatorMolecules 1", 1, spects.get(1)
				.getAtoms().size());
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLReaction.removeOrphanSubstances()'
	 */
	@Test
	public void testRemoveOrphanSubstances() {
		CMLElements<CMLSubstanceList> substanceLists = xmlReact1
				.getSubstanceListElements();
		CMLElements<CMLSubstance> substances = substanceLists.get(0)
				.getSubstanceElements();
		Assert.assertEquals("substances ", 2, substances.size());
		xmlReact1.removeOrphanSubstances();
		substances = substanceLists.get(0).getSubstanceElements();
		Assert.assertEquals("substances ", 1, substances.size());
		Assert.assertEquals("substance 1", "benzene", substances.get(0)
				.getMoleculeElements().get(0).getTitle());
	}

	/**
	 * get all descendant atoms.
	 */
	@Test
	public void testGetAtoms() {
		List<CMLAtom> atoms = xmlReact1.getAtoms();
		Assert.assertEquals("atoms", 9, atoms.size());
		Assert.assertEquals("atoms 1", "a1", atoms.get(0).getId());
		Assert.assertEquals("atoms 2", "a2", atoms.get(1).getId());
		Assert.assertEquals("atoms 3", "a3", atoms.get(2).getId());
		Assert.assertEquals("atoms 4", "a1", atoms.get(3).getId());
		Assert.assertEquals("atoms 5", "a2", atoms.get(4).getId());
		Assert.assertEquals("atoms 6", "a3", atoms.get(5).getId());
		Assert.assertEquals("atoms 7", "a1", atoms.get(6).getId());
		Assert.assertEquals("atoms 8", "a2", atoms.get(7).getId());
		Assert.assertEquals("atoms 9", "a3", atoms.get(8).getId());
	}

	/**
	 * get all descendant bonds.
	 */
	@Test
	public void testGetBonds() {
		List<CMLBond> bonds = xmlReact1.getBonds();
		Assert.assertEquals("bonds", 2, bonds.size());
		Assert.assertEquals("bonds 1", "r_a1_a2", bonds.get(0).getId());
		Assert.assertEquals("bonds 2", "p_a1_a2", bonds.get(1).getId());
	}

	/**
	 * get all descendant formulas.
	 */
	@Test
	public void testGetFormulas() {
		makeXmlReact2();
		List<CMLFormula> formulas = xmlReact2.getFormulas();
		Assert.assertEquals("formulas", 4, formulas.size());
		Assert.assertEquals("formulas 1", "r_f1", formulas.get(0).getId());
		Assert.assertEquals("formulas 2", "r_f2", formulas.get(1).getId());
		Assert.assertEquals("formulas 3", "p_f1", formulas.get(2).getId());
		Assert.assertEquals("formulas 4", "p_f2", formulas.get(3).getId());
	}

	/**
	 * get all descendant molecules.
	 */
	@Test
	public void testGetMolecules() {
		List<CMLMolecule> molecules = xmlReact1.getMolecules();
		Assert.assertEquals("molecules", 7, molecules.size());
		Assert.assertEquals("molecules 1", "rm1", molecules.get(0).getId());
		Assert.assertEquals("molecules 2", "rm2", molecules.get(1).getId());
		Assert.assertEquals("molecules 3", "pm1", molecules.get(2).getId());
		Assert.assertEquals("molecules 4", "pm2", molecules.get(3).getId());
		Assert.assertEquals("molecules 5", "sm1", molecules.get(4).getId());
		Assert.assertEquals("molecules 6", "sm2", molecules.get(5).getId());
	}

	/**
	 * gets list of descendant reactants. convenience class
	 */
	@Test
	public void testGetDescendantReactants() {
		List<CMLReactant> reactants = xmlReact1.getDescendantReactants();
		Assert.assertEquals("reactants", 2, reactants.size());
		Assert.assertEquals("reactants 1", "re1", reactants.get(0).getId());
		Assert.assertEquals("reactants 2", "re2", reactants.get(1).getId());
	}

	/**
	 * gets list of descendant products. convenience class
	 */
	@Test
	public void testGetDescendantProducts() {
		List<CMLProduct> products = xmlReact1.getDescendantProducts();
		Assert.assertEquals("products", 2, products.size());
		Assert.assertEquals("products 1", "pr1", products.get(0).getId());
		Assert.assertEquals("products 2", "pr2", products.get(1).getId());
	}

	/**
	 * gets list of descendant spectators. convenience class
	 */
	@Test
	public void testGetDescendantSpectators() {
		List<CMLSpectator> spectators = xmlReact1.getDescendantSpectators();
		Assert.assertEquals("spectators", 2, spectators.size());
		Assert.assertEquals("spectators 1", "sp1", spectators.get(0).getId());
		Assert.assertEquals("spectators 2", "sp2", spectators.get(1).getId());
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLReaction.mergeReactantLists()'
	 */
	@Test
	public void testMergeReactantLists() {
		String reactionS = "" + "<reaction id='r1' " + CMLConstants.CML_XMLNS + ">"
				+ "  <reactantList id='rl1'>" + "    <reactant id='re1'>"
				+ "      <molecule id='rm1'>" + "        <atomArray>"
				+ "          <atom id='a1' elementType='C' hydrogenCount='3'>"
				+ "          </atom>"
				+ "          <atom id='a2' elementType='Cl'>"
				+ "          </atom>" + "        </atomArray>"
				+ "        <bondArray>"
				+ "          <bond atomRefs2='a1 a2' id='r_a1_a2' order='1'/>"
				+ "        </bondArray>" + "      </molecule>"
				+ "		</reactant>" + "    <reactant id='re2'>"
				+ "      <molecule id='rm2'>" + "        <atomArray>"
				+ "          <atom id='a3' elementType='O' hydrogenCount='2'>"
				+ "          </atom>" + "        </atomArray>"
				+ "      </molecule>" + "    </reactant>" + "  </reactantList>"
				+ "  <reactantList id='rl1a'>" + "    <reactant id='re1a'>"
				+ "      <molecule id='rm1a'>" + "        <atomArray>"
				+ "          <atom id='a1' elementType='C' hydrogenCount='3'>"
				+ "          </atom>"
				+ "          <atom id='a2' elementType='Cl'>"
				+ "          </atom>" + "        </atomArray>"
				+ "        <bondArray>"
				+ "          <bond atomRefs2='a1 a2' id='r_a1_a2' order='1'/>"
				+ "        </bondArray>" + "      </molecule>"
				+ "		</reactant>" + "    <reactant id='re2a'>"
				+ "      <molecule id='rm2a'>" + "        <atomArray>"
				+ "          <atom id='a3' elementType='O' hydrogenCount='2'>"
				+ "          </atom>" + "        </atomArray>"
				+ "      </molecule>" + "    </reactant>" + "  </reactantList>"
				+ "</reaction>";

		CMLReaction reaction = (CMLReaction)CMLXOMTestUtils.parseValidString(reactionS);
		Assert.assertEquals("before merge", 2, reaction
				.getReactantListElements().size());
		reaction.mergeReactantLists();
		Assert.assertEquals("after merge", 1, reaction
				.getReactantListElements().size());
		CMLReactantList reactantList = reaction.getReactantListElements()
				.get(0);
		Assert.assertEquals("after merge", 4, reactantList
				.getReactantElements().size());
		Assert.assertEquals("after merge", "re1", reactantList
				.getReactantElements().get(0).getId());
		Assert.assertEquals("after merge", "re2", reactantList
				.getReactantElements().get(1).getId());
		Assert.assertEquals("after merge", "re1a", reactantList
				.getReactantElements().get(2).getId());
		Assert.assertEquals("after merge", "re2a", reactantList
				.getReactantElements().get(3).getId());
	}

	@Test
	public void testAddReactant(){
		CMLReaction reaction = new CMLReaction();
		Assert.assertEquals(null, reaction.getReactantList());
		CMLReactant reactant = new CMLReactant();
		reaction.addReactant(reactant);
		Assert.assertEquals(reactant, reaction.getReactantList().getReactantElements().get(0));
	}
	@Test
	public void testAddProduct(){
		CMLReaction reaction = new CMLReaction();
		Assert.assertEquals(null, reaction.getProductList());
		CMLProduct product = new CMLProduct();
		reaction.addProduct(product);
		Assert.assertEquals(product, reaction.getProductList().getProductElements().get(0));
	}
	
	@Test
	public void testMergeSpectatorLists() {
		CMLReaction reaction = new CMLReaction();
		CMLSpectatorList list1 = new CMLSpectatorList();
		CMLSpectatorList list2 = new CMLSpectatorList();
		
		list1.addSpectator(new CMLSpectator());
		list2.addSpectator(new CMLSpectator());
		list2.addSpectator(new CMLSpectator());
		reaction.addSpectatorList(list1);
		reaction.addSpectatorList(list2);
		Assert.assertEquals(2, reaction.getSpectatorListElements().size());
		Assert.assertEquals(1, list1.getChildCount());
		Assert.assertEquals(2, list2.getChildCount());
		
		reaction.mergeSpectatorLists();
		Assert.assertEquals(1, reaction.getSpectatorListElements().size());
		Assert.assertEquals(3, list1.getChildCount());
		Assert.assertEquals(0, list2.getChildCount());
		Assert.assertTrue(list1.getParent() == reaction);
		Assert.assertFalse(list2.getParent() == reaction);
	}
}
