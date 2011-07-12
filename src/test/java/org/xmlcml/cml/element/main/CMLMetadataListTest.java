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
import org.xmlcml.cml.base.CMLXOMTestUtils;
import org.xmlcml.cml.element.CMLMetadata;
import org.xmlcml.cml.element.CMLMetadataList;
import org.xmlcml.cml.element.CMLMolecule;

/**
 * tests metadataList.
 * 
 * @author pmr
 * 
 */
public class CMLMetadataListTest {
	String moleculeS = "<molecule " + CMLConstants.CML_XMLNS
			+ "  xmlns:foo='http://www.foo.org'" + "  >"
			+ "  <metadataList id='ml1'>" + "    <metadataList id='ml2'>"
			+ "      <metadata id='m1' name='foo:foo1' content='bar1'/>"
			+ "      <metadata id='m2' name='foo:foo2' content='bar2'/>"
			+ "    </metadataList>"
			+ "    <metadata id='m3' name='foo:foo1' content='bar31'/>"
			+ "  </metadataList>" + "  <metadataList id='ml3'>"
			+ "    <metadata id='m4' name='foo:foo4' content='bar4'/>"
			+ "    <metadata id='m5' name='foo:foo1' content='bar51'/>"
			+ "  </metadataList>"
			+ "  <metadata id='m6' name='foo:foo6' content='bar6'/>"
			+ "</molecule>" + CMLConstants.S_EMPTY;
	CMLMolecule molecule;
	CMLMetadataList metadataList0;
	CMLMetadataList metadataList1;

	/**
	 * setup.
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		molecule = (CMLMolecule)CMLXOMTestUtils.parseValidString(moleculeS);
		metadataList0 = (CMLMetadataList) molecule
				.getFirstCMLChild(CMLMetadataList.TAG);
		metadataList1 = (CMLMetadataList) molecule.getChildCMLElements(
				CMLMetadataList.TAG).get(1);
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLMetadataList.CMLMetadataList()'.
	 */
	@Test
	public void testCMLMetadataList() {
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLMetadataList.CMLMetadataList(CMLMetadataList)'
	 */
	@Test
	public void testCMLMetadataListCMLMetadataList() {
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLMetadataList.getMetadataDescendants()'
	 */
	@Test
	public void testGetMetadataDescendants() {
		List<CMLMetadata> metadatas = CMLMetadataList
				.getMetadataDescendants(molecule);
		Assert.assertEquals("metadata descendants", 6, metadatas.size());
		Assert.assertEquals("metadata descendant 1", "foo:foo1", metadatas.get(
				0).getName());
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLMetadataList.getMetadataDescendants(CMLElement
	 * ) '
	 */
	@Test
	public void testGetMetadataDescendantsCMLElement() {
		List<CMLMetadata> metadatas = metadataList0.getMetadataDescendants();
		Assert.assertEquals("metadata descendants", 3, metadatas.size());
		Assert.assertEquals("metadata descendant 2", "foo:foo2", metadatas.get(
				1).getName());
	}

	// /**
	// * Test method for
	// *
	// 'org.xmlcml.cml.element.CMLMetadataList.getMetadataDescendantsByNameListString'
	// */
	// @Test
	// public void testGetMetadataDescendantsByNameListString() {
	// }

	// /**
	// * Test method for
	// *
	// 'org.xmlcml.cml.element.CMLMetadataList.getMetadataDescendantsByName(String)'
	// */
	// @Test
	// public void testGetMetadataDescendantsByNameString() {
	// List<ICMLMetadata> metadatas = metadataList0
	// .getMetadataDescendantsByName("foo:foo1");
	// Assert.assertEquals("metadata descendants", 2, metadatas.size());
	// Assert.assertEquals("metadata descendant 2", "bar31", metadatas.get(1)
	// .getContent());
	// }
}
