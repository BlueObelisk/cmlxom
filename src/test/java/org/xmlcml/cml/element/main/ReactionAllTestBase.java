package org.xmlcml.cml.element.main;

import static org.xmlcml.euclid.EuclidConstants.S_EMPTY;

import java.io.IOException;
import java.io.StringReader;

import nu.xom.ParsingException;
import nu.xom.ValidityException;

import org.junit.Assert;
import org.junit.Before;
import org.xmlcml.cml.base.CMLBuilder;
import org.xmlcml.cml.base.CMLConstants;
import org.xmlcml.cml.base.CMLElements;
import org.xmlcml.cml.base.CMLXOMTestUtils;
import org.xmlcml.cml.element.CMLProduct;
import org.xmlcml.cml.element.CMLProductList;
import org.xmlcml.cml.element.CMLReactant;
import org.xmlcml.cml.element.CMLReactantList;
import org.xmlcml.cml.element.CMLReaction;
import org.xmlcml.cml.element.CMLSpectator;
import org.xmlcml.cml.element.CMLSpectatorList;

/**
 * test for reaction elements.
 * 
 * @author pmr
 * 
 */
public abstract class ReactionAllTestBase {
	protected CMLReaction xomReact1;
	protected CMLReaction xomReact2;
	protected String xmlReact1S = "<reaction id='r1' " + CMLConstants.CML_XMLNS + ">"
			+ "  <reactantList id='rl1'>" + "    <reactant id='re1'>"
			+ "      <molecule id='rm1'>" + "        <atomArray>"
			+ "          <atom id='a1' elementType='C' hydrogenCount='3'>"
			+ "          </atom>" + "          <atom id='a2' elementType='Cl'>"
			+ "          </atom>" + "        </atomArray>"
			+ "        <bondArray>"
			+ "          <bond atomRefs2='a1 a2' id='r_a1_a2' order='1'/>"
			+ "        </bondArray>" + "      </molecule>" + "    </reactant>"
			+ "    <reactant id='re2'>" + "      <molecule id='rm2'>"
			+ "        <atomArray>"
			+ "          <atom id='a3' elementType='O' hydrogenCount='2'>"
			+ "          </atom>" + "        </atomArray>"
			+ "      </molecule>" + "    </reactant>" + "  </reactantList>"
			+ "  <productList id='pl1'>" + "    <product id='pr1'>"
			+ "      <molecule id='pm1'>" + "        <atomArray>"
			+ "          <atom id='a1' elementType='C' hydrogenCount='3'>"
			+ "          </atom>"
			+ "          <atom id='a2' elementType='O' hydrogenCount='1'>"
			+ "          </atom>" + "        </atomArray>"
			+ "        <bondArray>"
			+ "          <bond atomRefs2='a1 a2' id='p_a1_a2' order='2'/>"
			+ "        </bondArray>" + "      </molecule>" + "    </product>"
			+ "    <product id='pr2'>" + "      <molecule id='pm2'>"
			+ "        <atomArray>"
			+ "          <atom id='a3' elementType='Cl' formalCharge='-1'>"
			+ "          </atom>" + "        </atomArray>"
			+ "      </molecule>" + "    </product>" + "  </productList>"
			+ "  <spectatorList id='sl1'>" + "    <spectator id='sp1'>"
			+ "      <molecule id='sm1'>" + "        <atomArray>"
			+ "          <atom id='a1' elementType='P' hydrogenCount='2'>"
			+ "          </atom>" + "          <atom id='a2' elementType='F'>"
			+ "          </atom>" + "        </atomArray>"
			+ "      </molecule>" + "    </spectator>"
			+ "    <spectator id='sp2'>" + "      <molecule id='sm2'>"
			+ "        <atomArray>"
			+ "          <atom id='a3' elementType='Ar'>" + "          </atom>"
			+ "        </atomArray>" + "      </molecule>" + "    </spectator>"
			+ "  </spectatorList>" + "  <substanceList>" + "    <substance>"
			+ "      <name>boiling chip</name>" + "    </substance>"
			+ "    <substance>" + "      <molecule title='benzene' id='m7'/>"
			+ "    </substance>" + "  </substanceList>" + "  <map>"
			+ "    <link from='a1' to='a1'/>" + "    <link from='a2' to='a3'/>"
			+ "    <link from='a3' to='a2'/>" + "  </map>" + "</reaction>"
			+ S_EMPTY;
	protected CMLReaction xmlReact1;
	protected CMLReaction multiReact1;
	protected CMLElements<CMLReactantList> xmlReactantLists1;
	protected CMLElements<CMLProductList> xmlProductLists1;
	protected CMLElements<CMLSpectatorList> xmlSpectatorLists1;
	// the first and only instances
	protected CMLReactantList xmlReactantList1;
	protected CMLProductList xmlProductList1;
	protected CMLSpectatorList xmlSpectatorList1;
	protected CMLElements<CMLReactant> xmlReactants1;
	protected CMLElements<CMLProduct> xmlProducts1;
	protected CMLElements<CMLSpectator> xmlSpectators1;
	protected String xmlReact2S = "<reaction id='r1' " + CMLConstants.CML_XMLNS + ">"
			+ "  <reactantList id='rl1'>" + "    <reactant id='re1'>"
			+ "      <formula concise='H 1 Cl 1' id='r_f1'/>"
			+ "    </reactant>" + "    <reactant id='re2'>"
			+ "      <formula concise='Na 1 O 1 H 1' id='r_f2'/>"
			+ "    </reactant>" + "  </reactantList>"
			+ "  <productList id='pl1'>" + "    <product id='pr1'>"
			+ "      <formula concise='H 2 O 1' id='p_f1'/>" + "    </product>"
			+ "    <product id='pr2'>"
			+ "      <formula concise='Na 1 Cl 1' id='p_f2'/>"
			+ "    </product>" + "  </productList>"
			+ "  <spectatorList id='sl1'>"
			+ "    <spectator id='sp1' title='phenolphthalein'/>"
			+ "  </spectatorList>" + "</reaction>" + S_EMPTY;
	protected CMLReaction xmlReact2;

	/**
	 * setup.
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		xmlReact1 = (CMLReaction)CMLXOMTestUtils.parseValidString(xmlReact1S);
		xmlReactantLists1 = xmlReact1.getReactantListElements();
		xmlProductLists1 = xmlReact1.getProductListElements();
		xmlSpectatorLists1 = xmlReact1.getSpectatorListElements();
		Assert.assertEquals("reactantList size", 1, xmlReactantLists1.size());
		Assert.assertEquals("productList size", 1, xmlProductLists1.size());
		Assert.assertEquals("spectatorList size", 1, xmlSpectatorLists1.size());
		xmlReactantList1 = xmlReactantLists1.get(0);
		xmlProductList1 = xmlProductLists1.get(0);
		xmlSpectatorList1 = xmlSpectatorLists1.get(0);
		xmlReactants1 = xmlReactantList1.getReactantElements();
		xmlProducts1 = xmlProductList1.getProductElements();
		xmlSpectators1 = xmlSpectatorList1.getSpectatorElements();
		Assert.assertEquals("reactants size", 2, xmlReactants1.size());
		Assert.assertEquals("products size", 2, xmlProducts1.size());
		Assert.assertEquals("spectators size", 2, xmlSpectators1.size());
	}

	protected void makeMultiProductReactantLists() {
		String multiReact1S = "<reaction id='r1' " + CMLConstants.CML_XMLNS + ">"
				+ "  <reactantList id='rl1'>" + "    <reactant id='re1'>"
				+ "      <molecule id='m1'>" + "        <atomArray>"
				+ "          <atom id='a1' elementType='C' hydrogenCount='3'>"
				+ "          </atom>"
				+ "          <atom id='a2' elementType='Cl'>"
				+ "          </atom>" + "        </atomArray>"
				+ "        <bondArray>"
				+ "          <bond id='r_a1_a2' atomRefs2='a1 a2' order='1'/>"
				+ "        </bondArray>" + "      </molecule>"
				+ "    </reactant>" + "  </reactantList>"
				+ "  <reactantList id='rl1'>" + "    <reactant id='re2'>"
				+ "      <molecule id='m2'>" + "        <atomArray>"
				+ "          <atom id='a3' elementType='O' hydrogenCount='2'>"
				+ "          </atom>" + "        </atomArray>"
				+ "      </molecule>" + "    </reactant>" + "  </reactantList>"
				+ "  <productList id='pl1'>" + "    <product id='pr1'>"
				+ "      <molecule id='pm1'>" + "        <atomArray>"
				+ "          <atom id='a1' elementType='C' hydrogenCount='3'>"
				+ "          </atom>"
				+ "          <atom id='a2' elementType='O' hydrogenCount='1'>"
				+ "          </atom>" + "        </atomArray>"
				+ "        <bondArray>"
				+ "          <bond id='p_a1_a2' atomRefs2='a1 a2' order='2'/>"
				+ "        </bondArray>" + "      </molecule>"
				+ "    </product>" + "  </productList>"
				+ "  <productList id='pl1'>" + "    <product id='pr2'>"
				+ "      <molecule id='m2'>" + "        <atomArray>"
				+ "          <atom id='a3' elementType='Cl' formalCharge='-1'>"
				+ "          </atom>" + "        </atomArray>"
				+ "      </molecule>" + "    </product>" + "  </productList>"
				+ "  <spectatorList id='sl1'>" + "    <spectator id='sp1'>"
				+ "      <molecule id='sm1'>" + "        <atomArray>"
				+ "          <atom id='a1' elementType='P' hydrogenCount='2'>"
				+ "          </atom>"
				+ "          <atom id='a2' elementType='F'>"
				+ "          </atom>" + "        </atomArray>"
				+ "        <bondArray>"
				+ "          <bond id='s_a1_a2' atomRefs2='a1 a2' order='3'/>"
				+ "        </bondArray>" + "      </molecule>"
				+ "    </spectator>" + "    <spectator id='sp2'>"
				+ "      <molecule id='sm2'>" + "        <atomArray>"
				+ "          <atom id='a3' elementType='Ar'>"
				+ "          </atom>" + "        </atomArray>"
				+ "      </molecule>" + "    </spectator>"
				+ "  </spectatorList>" + "</reaction>" + S_EMPTY;
		try {
			multiReact1 = (CMLReaction) new CMLBuilder().build(
					new StringReader(multiReact1S)).getRootElement();
		} catch (ValidityException e) {
			Assert.fail("should not throw ValidityException " + e);
		} catch (ParsingException e) {
			Assert.fail("should not throw ParsingException " + e);
		} catch (IOException e) {
			Assert.fail("should not throw IOException " + e);
		}
	}

	protected void makeXmlReact2() {
		try {
			xmlReact2 = (CMLReaction) new CMLBuilder().build(
					new StringReader(xmlReact2S)).getRootElement();
		} catch (ValidityException e) {
			Assert.fail("should not throw ValidityException " + e);
		} catch (ParsingException e) {
			Assert.fail("should not throw ParsingException " + e);
		} catch (IOException e) {
			Assert.fail("should not throw IOException " + e);
		}
	}
}
