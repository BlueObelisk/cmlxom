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
import org.xmlcml.cml.base.CMLElement;

/** A container for one or more molecules.
*
*
* moleculeList can contain several molecules.
* These may be related in many ways and there is/are controlled
* semantics. However it should not be used for a molecule
* consisting of descendant molecules for which molecule
* should be used.
* A moleculeList can contain nested moleculeLists.
*
* user-modifiable class autogenerated from schema if no class exists
* use as a shell which can be edited
* the autogeneration software will not overwrite an existing class file

*/
public class CMLMoleculeList extends AbstractMoleculeList {

	/** namespaced element name.*/
	public final static String NS = C_E+TAG;

    /** argument name to identify id.
     */
    public final static String IDX = "idx";

    /** constructor.
    *
    */
    public CMLMoleculeList() {
    }

    
    /** must give simple documentation.
    *
    * @param old CMLMoleculeList to copy
    */
    public CMLMoleculeList(CMLMoleculeList old) {
        super((org.xmlcml.cml.element.AbstractMoleculeList) old);
    }

    /** copy node .
    *
    * @return Node
    */
    public Element copy() {
        return new CMLMoleculeList(this);
    }
    /** create new instance in context of parent, overridable by subclasses.
    *
    * @param parent parent of element to be constructed (ignored by default)
    * @return CMLMoleculeList
    */
    public CMLElement makeElementInContext(Element parent) {
        return new CMLMoleculeList();
    }

}
