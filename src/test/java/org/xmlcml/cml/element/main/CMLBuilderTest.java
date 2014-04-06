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

import static org.xmlcml.cml.element.main.AbstractTestBase.COMPLEX_RESOURCE;

import java.io.InputStream;

import junit.framework.Assert;
import nu.xom.NodeFactory;

import org.junit.Test;
import org.xmlcml.cml.base.CMLBuilder;
import org.xmlcml.cml.base.CMLConstants;
import org.xmlcml.euclid.EuclidRuntimeException;
import org.xmlcml.euclid.Util;

/**
 * test CMLBuilder routines.
 * 
 * @author pm286
 * 
 */
public class CMLBuilderTest {

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLBuilder.CMLBuilder(boolean,
	 * NodeFactory)'
	 */
	@Test
	public void testCMLBuilderBooleanNodeFactory() {
		// fails because default CMLBuilder uses OldNodeFactory
		// to validate element names
		String s = CMLConstants.S_EMPTY + "<cml " + CMLConstants.CML_XMLNS + ">" + "<inchi/>" + "</cml>";
		try {
			new CMLBuilder().parseString(s);
			Assert.fail("should throw: Unknown CML element: inchi");
		} catch (Exception e) {
			// OK
		}

		// succeeds with ordinary NodeFactory
		// to validate element names
		CMLBuilder builder = new CMLBuilder(new NodeFactory());
		try {
			builder.parseString(s);
		} catch (Exception e) {
			throw new EuclidRuntimeException("should never throw " + e);
		}

//		// fails because XOM validation requires a DOCTYPE
//		boolean validate = true;
//		builder = new CMLBuilder(validate, new NodeFactory());
//		try {
//			builder.parseString(s);
//			Assert.fail("should throw: Unknown CML element: inchi");
//		} catch (Exception e) {
//			Assert
//					.assertEquals(
//							"OldNodeFactory validation",
//							"Document root element \"cml\", must match DOCTYPE root \"null\".",
//							e.getMessage());
//		}

//		// fails through OldNodeFactory validation
//		validate = true;
//		builder = new CMLBuilder(validate, CMLNodeFactory.nodeFactory);
//		try {
//			builder.parseString(s);
//			Assert.fail("should throw: Unknown CML element: inchi");
//		} catch (Exception e) {
//			// OK
//		}
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLBuilder.parseString(String)'
	 */
	@Test
	public void testParseString() {
		// parse, validation by OldNodeFactory
		String s = CMLConstants.S_EMPTY + "<cml " + CMLConstants.CML_XMLNS + ">" + "</cml>";
		CMLBuilder builder = new CMLBuilder();
		try {
			builder.parseString(s);
		} catch (Exception e) {
			throw new EuclidRuntimeException("should never throw " + e);
		}

		// parse, validation by OldNodeFactory
		s = CMLConstants.S_EMPTY + "<cml " + CMLConstants.CML_XMLNS + ">" + "<inchi/>" + "</cml>";
		builder = new CMLBuilder();
		try {
			builder.parseString(s);
		} catch (Exception e) {
			// OK
		}

//		// parse against DOCTYPE (tests XOM DTD validation)
//		s = "<!DOCTYPE cml [" + "<!ELEMENT cml ANY>"
//				+ "<!ATTLIST cml xmlns CDATA #REQUIRED>" + "]>" + "<cml "
//				+ CMLConstants.CML_XMLNS + ">" + "<inchi/>" + "</cml>";
//		boolean validate = true;
//		builder = new CMLBuilder(validate, new NodeFactory());
//		try {
//			builder.parseString(s);
//			Assert
//					.fail("Should throw: Element type \"inchi\" must be declared.");
//		} catch (Exception e) {
//			Assert.assertEquals("missing element in doctype",
//					"Element type \"inchi\" must be declared.", e.getMessage());
//		}
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLBuilder.build(File)'
	 */
	@Test
	public void testBuildFile() {
		CMLBuilder builder = new CMLBuilder();
		InputStream in = null;
		try {
			in = Util.getInputStreamFromResource(COMPLEX_RESOURCE +CMLConstants.U_S
					+ "castep2.xml");
			builder.build(in);
			in.close();
		} catch (Exception e) {
			throw new EuclidRuntimeException("should never throw " + e);
		}

		// fails because XOM can only validate against a DOCTYPE
		// and this file has a schema
		boolean validate = true;
		builder = new CMLBuilder(validate);
		try {
			in = Util.getInputStreamFromResource(COMPLEX_RESOURCE +CMLConstants.U_S
					+ "castep2.xml");
			builder.build(in);
			in.close();
		} catch (Exception e) {
			Assert
					.assertEquals(
							"OldNodeFactory validation",
							"Document root element \"cml\", must match DOCTYPE root \"null\".",
							e.getMessage());
		}
	}

}
