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
 * The enumerations are managed by the IndexableByIdList mechanism
 */
public class CMLEntry extends AbstractEntry {

	/** namespaced element name.*/
	public final static String NS = C_E+TAG;

    /**
     * constructor.
     */
    public CMLEntry() {
    }

    /**
     * constructor.
     *
     * @param old
     */
    public CMLEntry(CMLEntry old) {
        super((AbstractEntry) old);

    }

    /**
     * normal constructor.
     *
     * @param id of entry (should be unique within dictionary);
     */
    public CMLEntry(String id) {
        this();
        this.setId(id);
    }

    /**
     * copy node .
     *
     * @return Node
     */
    public Node copy() {
        return new CMLEntry(this);

    }

    /**
     * create new instance in context of parent, overridable by subclasses.
     *
     * @param parent of element to be constructed (ignored by default)
     * @return CMLEntry
     */
    public CMLElement makeElementInContext(Element parent) {
        return new CMLEntry();
    }

    /** set term if not already set.
     * if entry already has different term, throw exception
     * @param term 
     */
    public void checkAndSetTerm(String term) {
    	if (term != null) {
			String thisTerm = this.getTerm();
			// make new entry?
			if (thisTerm != null && !thisTerm.equals(term)) {
				throw new RuntimeException("current term ["+this.getId()+"] ("+thisTerm+") different from ("+term+")");
			}
			this.setTerm(term);
		}
    }
}
