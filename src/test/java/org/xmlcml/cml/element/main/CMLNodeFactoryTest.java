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

import static org.xmlcml.cml.base.CMLConstants.CML1;
import nu.xom.Element;

import org.junit.Assert;
import org.junit.Test;
import org.xmlcml.cml.base.CMLBuilder;
import org.xmlcml.cml.base.CMLConstants;
import org.xmlcml.cml.base.CMLElement;
import org.xmlcml.cml.base.CMLXOMTestUtils;
import org.xmlcml.euclid.EuclidRuntimeException;

/**
 * test OldNodeFactory.
 * 
 * @author pmr
 * 
 */
public class CMLNodeFactoryTest {

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.OldNodeFactory.startMakingElement(String,
	 * String)' * DOES NOT TEST THIS ROUTINE!!!!!!!
	 */
	@Test
	public void testStartMakingElementStringString() {
		String s1 = "<cml " + CMLConstants.CML_XMLNS + "/>";
		CMLElement cmlElement = (CMLElement)CMLXOMTestUtils.parseValidString(s1);
		String namespace = cmlElement.getNamespaceURI();
		Assert.assertEquals("ok namespace", CMLConstants.CML_NS, namespace);

		// guess namespace
		s1 = "<cml xmlns='" + CML1 + "'/>";
		try {
			cmlElement = (CMLElement) new CMLBuilder().parseString(s1);
		} catch (Exception e) {
			throw new EuclidRuntimeException("should never throw " + e);
		}
		Assert.assertTrue("is CMLElement", CMLElement.class
				.isAssignableFrom(cmlElement.getClass()));
		namespace = cmlElement.getNamespaceURI();
		Assert.assertEquals("old namespace -> new", CMLConstants.CML_NS, namespace);

		Element element = null;
		// cannot guess namespace
		s1 = "<cml xmlns='http://foo'/>";
		try {
			element = (Element) new CMLBuilder().parseString(s1);
		} catch (Exception e) {
			throw new EuclidRuntimeException("should never throw " + e);
		}
		Assert.assertFalse("is CMLElement", CMLElement.class
				.isAssignableFrom(element.getClass()));
		namespace = element.getNamespaceURI();
		Assert.assertEquals("other namespace", "http://foo", namespace);
	}

}
