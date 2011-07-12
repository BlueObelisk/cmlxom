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
 * user-modifiable class supporting potentialList. * autogenerated from schema
 * use as a shell which can be edited
 *
 */
public class CMLPotentialList extends AbstractPotentialList {

	/** namespaced element name.*/
	public final static String NS = C_E+TAG;

    /**
     * constructor.
     */
    public CMLPotentialList() {
    }

    /**
     * constructor.
     *
     * @param old
     */
    public CMLPotentialList(CMLPotentialList old) {
        super((AbstractPotentialList) old);

    }

    /**
     * copy node .
     *
     * @return Node
     */
    public Node copy() {
        return new CMLPotentialList(this);

    }

    /**
     * create new instance in context of parent, overridable by subclasses.
     *
     * @param parent
     *            parent of element to be constructed (ignored by default)
     * @return CMLPotentialList
     */
    public CMLElement makeElementInContext(Element parent) {
        return new CMLPotentialList();

    }
}
