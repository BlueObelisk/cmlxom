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

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.xmlcml.cml.base.CMLConstants;
import org.xmlcml.cml.base.CMLElement;
import org.xmlcml.euclid.Util;

/**
 * superclass of all CMLTests. creates CMLBuilder for subclasses. little other
 * functionality but may be required later for setUp(), etc.
 * 
 * @author pm286
 * 
 */

public final class AbstractTestBase {

	/** root of tests. */
	public final static String TEST_RESOURCE = "org/xmlcml/cml/element";

	/** root of examples. */
	public final static String EXAMPLES_RESOURCE = TEST_RESOURCE + CMLConstants.S_SLASH
			+ "examples";

	/** root of complex examples. */
	public final static String COMPLEX_RESOURCE = EXAMPLES_RESOURCE + CMLConstants.S_SLASH
			+ "complex";

	/** root of experimental examples. */
	public final static String EXPERIMENTAL_RESOURCE = EXAMPLES_RESOURCE
			+ CMLConstants.S_SLASH + "experimental";

	/** root of xsd examples. */
	public final static String SIMPLE_RESOURCE = EXAMPLES_RESOURCE + CMLConstants.S_SLASH
			+ "xsd";

	/** root of dictionary examples. */
	public final static String DICT_RESOURCE = EXAMPLES_RESOURCE + CMLConstants.S_SLASH
			+ "dict";

	/** root of unit examples. */
	public final static String UNIT_RESOURCE = EXAMPLES_RESOURCE + CMLConstants.S_SLASH
			+ "units";

	/** root of tool tests. */
	public final static String TOOL_TEST_RESOURCE = "org/xmlcml/cml/tools";

	/** root of tool test examples. */
	public final static String TOOL_EXAMPLES_RESOURCE = TOOL_TEST_RESOURCE
			+ CMLConstants.S_SLASH + "examples";

	/** root of tool test molecules. */
	public final static String TOOL_MOLECULES_RESOURCE = TOOL_EXAMPLES_RESOURCE
			+ CMLConstants.S_SLASH + "molecules";

	/** index in each directory. */
	public final static String INDEX = "index.xml";

	static String TEST_INDEX = TEST_RESOURCE + CMLConstants.S_SLASH + INDEX;

	/** final string in dictionary namespaces */
	public final static String CML_DICT = "cml";

	/** alternative namespace for cml dictionary :-( */
	public final static String CML_DICT_DICT = CML_DICT + "Dict";

	/** cml comp dictionary */
	public final static String CML_COMP_DICT = "cmlComp";

	/**
	 * error.
	 * 
	 * @param s
	 */
	public static void severeError(String s) {
		Util.println("***** SEVERE ERROR: " + s);
	}

	/**
	 * tests writing HTML.
	 * 
	 * @param element
	 * @param htmlFile
	 * @throws IOException
	 */
	void writeHTML(CMLElement element, String htmlFile) throws IOException {
		File f = new File(htmlFile);
		if (!f.exists()) {
			File dir = f.getParentFile();
			if (!dir.exists()) {
				if (!dir.mkdirs()) {
					throw new RuntimeException("Problem: cannot create " + dir);
				}
			}
			if (!f.createNewFile()) {
				throw new RuntimeException("Problem: cannot create " + f);
			}
		}
		FileWriter fw = new FileWriter(f);
		element.writeHTML(fw);
		fw.close();
	}
}