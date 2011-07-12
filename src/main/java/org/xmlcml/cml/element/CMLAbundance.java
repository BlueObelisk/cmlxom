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

package org.xmlcml.cml.element;

import nu.xom.Element;
import nu.xom.Node;

import org.xmlcml.cml.base.CMLElement;

/**
 * The abundance of an isotope.
 *
 *
 * The abundance of an isotope in an isotopeList. Values are expressed in
 * percentages. user-modifiable class autogenerated from schema use as a shell
 * which can be edited
 *
 */
public class CMLAbundance extends AbstractAbundance {

	/** namespaced element name.*/
	public final static String NS = C_E+TAG;

    /**
     * constructor.
     */
    public CMLAbundance() {
    }

    /**
     * constructor.
     *
     * @param old
     */
    public CMLAbundance(CMLAbundance old) {
        super((AbstractAbundance) old);
    }

    /**
     * copy node .
     *
     * @return Node
     */
    public Node copy() {
        return new CMLAbundance(this);
    }

    /**
     * create new instance in context of parent, overridable by subclasses.
     *
     * @param parent
     *            parent of element to be constructed (ignored by default)
     * @return CMLAbundance
     */
    public CMLElement makeElementInContext(Element parent) {
        return new CMLAbundance();
    }

    /* ======AUTOGENERATED FROM SCHEMA; DO NOT EDIT BELOW THIS LINE ====== */
}
