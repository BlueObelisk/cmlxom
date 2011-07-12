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

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.xmlcml.cml.element.CMLFragment;
import org.xmlcml.cml.element.CMLJoin;

public class CMLJoinTest {

	CMLFragment parent = new CMLFragment();
	CMLJoin join1 = new CMLJoin();
	CMLFragment childAndPrevious = new CMLFragment();
	CMLJoin join2 = new CMLJoin();
	CMLFragment next = new CMLFragment();
	
	void setup() {
		parent = new CMLFragment();
		join1 = new CMLJoin();
		childAndPrevious = new CMLFragment();
		join2 = new CMLJoin();
		next = new CMLFragment();
		
		join1.setMoleculeRefs2(CMLJoin.PARENT_S + " " + CMLJoin.CHILD_S);
		parent.appendChild(join1);
		join1.appendChild(childAndPrevious);
		join2.setMoleculeRefs2(CMLJoin.PREVIOUS_S + " " + CMLJoin.NEXT_S);
		join1.appendChild(join2);
		join1.appendChild(next);
	}
	
	
	@Test
	public void testGetParentOrPrevious() {
		
		setup();
		assertTrue(join1.getParentOrPrevious() == parent);
		assertTrue(join2.getParentOrPrevious() == childAndPrevious);
		
		join1.setMoleculeRefs2(CMLJoin.PREVIOUS_S + " " + CMLJoin.NEXT_S);
		join2.setMoleculeRefs2("FOO BAR");
		
		assertNull(join1.getParentOrPrevious());
		assertNull(join2.getParentOrPrevious());
	}
	
	
	@Test
	public void testGetChildOrNext() {

		setup();
		assertTrue(join1.getChildOrNext() == childAndPrevious);
		assertTrue(join2.getChildOrNext() == next);
		
		join1.setMoleculeRefs2(CMLJoin.PREVIOUS_S + " " + CMLJoin.NEXT_S);
		join2.setMoleculeRefs2(CMLJoin.PARENT_S + " " + CMLJoin.CHILD_S);
		
		assertNull(join1.getChildOrNext());
		assertNull(join2.getChildOrNext());
		
		join1.setMoleculeRefs2("FOO BAR");
		assertNull(join1.getChildOrNext());
	}
}
