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

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import nu.xom.Attribute;
import nu.xom.Elements;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.xmlcml.cml.base.CMLElement;
import org.xmlcml.cml.base.CMLElements;
import org.xmlcml.cml.element.CMLAtom;
import org.xmlcml.cml.element.CMLAtomArray;

/**
 * test CMLElements
 * 
 * @author pmr
 * 
 */
public class ElementsTest {
	CMLElement cml1;
	Elements elems;
	CMLElements<CMLElement> cmlElems;
	CMLElements<CMLAtom> atoms;

	/**
	 * setup.
	 * 
	 * @throws Exception
	 */
	@Before
	public synchronized void setUp() throws Exception {
		cml1 = new CMLElement("cml1");
		CMLElement cml2 = new CMLElement("cml2");
		cml2.addAttribute(new Attribute("id", "id1"));
		cml1.appendChild(cml2);
		cml2 = new CMLElement("cml2");
		cml2.addAttribute(new Attribute("id", "id2"));
		cml1.appendChild(cml2);
		elems = cml1.getChildElements();
		cmlElems = new CMLElements<CMLElement>(elems);
		CMLAtomArray atomArray = new CMLAtomArray();
		CMLAtom atom = new CMLAtom();
		atom.setId("a1");
		atomArray.appendChild(atom);
		atom = new CMLAtom();
		atom.setId("a2");
		atomArray.appendChild(atom);
		atoms = atomArray.getAtomElements();
	}

	/**
	 * Test method for 'org.xmlcml.cml.base.CMLElements.CMLElements(Elements)'
	 */
	@Test
	public void testCMLElements() {
		CMLElements<CMLElement> cc = new CMLElements<CMLElement>(elems);
		Assert.assertEquals("constructor", 2, cc.size());
	}

	/**
	 * Test method for 'org.xmlcml.cml.base.CMLElements.iterator()'
	 */
	@Test
	public void testIterator() {
		Iterator<CMLElement> it = cmlElems.iterator();
		int i = 0;
		while (it.hasNext()) {
			CMLElement elem = it.next();
			Assert.assertEquals("class", CMLElement.class, elem.getClass());
			Assert.assertEquals("id", "id" + (++i), elem
					.getAttributeValue("id"));
		}
	}

	/**
	 * Test method for 'org.xmlcml.cml.base.CMLElements.get(int)'
	 */
	@Test
	public void testGet() {
		CMLElement elem = (CMLElement) elems.get(0);
		Assert.assertEquals("get", CMLElement.class, elem.getClass());
		Assert.assertEquals("id", "id1", elem.getAttributeValue("id"));
		elem = (CMLElement) elems.get(1);
		Assert.assertEquals("get", CMLElement.class, elem.getClass());
		Assert.assertEquals("id", "id2", elem.getAttributeValue("id"));
		try {
			elem = (CMLElement) elems.get(2);
			Assert.fail("should throw IndexOutOfBoundsException");
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
			Set<String> allowedStrings = new HashSet<String>();
			allowedStrings.add("Index 2 out of bounds for length 2");
			allowedStrings.add("Index: 2, Size: 2");
			Assert.assertTrue("array error", allowedStrings.contains(e.getMessage()));
		}
	}

	/**
	 * Test method for 'org.xmlcml.cml.base.CMLElements.size()'
	 */
	@Test
	public void testSize() {
		Assert.assertEquals("size", 2, elems.size());
	}

	/**
	 * Test method for 'org.xmlcml.cml.base.CMLElements.getType()'
	 */
	@Test
	public void testGetType() {
		Class<?> classx = cmlElems.getType();
		Assert.assertEquals("type", org.xmlcml.cml.base.CMLElement.class,
				classx);
		Assert.assertEquals("class", org.xmlcml.cml.element.CMLAtom.class,
				atoms.get(0).getClass());
		Assert.assertEquals("size", 2, atoms.size());
		classx = atoms.getType();
		Assert.assertEquals("type", org.xmlcml.cml.element.CMLAtom.class,
				classx);
	}

	/**
	 * Test method for 'org.xmlcml.cml.base.CMLElements.getList()'
	 */
	@Test
	public void testGetList() {
		List<CMLAtom> atomList = atoms.getList();
		Assert.assertEquals("list", 2, atomList.size());
	}
	/**
	 * run tests.
	 * 
	 * @return the suite.
	 * 
	 */
}
