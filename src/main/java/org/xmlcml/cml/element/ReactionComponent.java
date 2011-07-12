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

import java.util.List;

import org.xmlcml.cml.base.CMLConstants;

/**
 * tags CMLReactant, CMLProduct, CMLReactantList, CMLProductList CMLSpectator as
 * a reaction component. Main current purpose is so that the same operation
 * (e.g. getAtoms()) can be carried out for any of these
 */
public interface ReactionComponent extends CMLConstants {

    /** type of component.*/
    public enum Type {
        /** product.*/
        PRODUCT,
        /** reactant.*/
        REACTANT,
        ;
    }
    /**
     * gets descendant molecules.
     * 
     * @return empty if no molecules
     */
    public List<CMLMolecule> getMolecules();

    /**
     * gets descendant atoms.
     * 
     * @return empty if no atoms
     */
    public List<CMLAtom> getAtoms();

    /**
     * gets descendant bonds.
     * 
     * @return empty if no bonds
     */
    public List<CMLBond> getBonds();

    /**
     * gets descendant formulae.
     * 
     * @return empty if no formulae
     */
    public List<CMLFormula> getFormulas();

//    /**
//     * gets descendant reactionComponents. note that this will return all
//     * containers as well as contained. thus calling this on: <reaction>
//     * <reactantList> <reactant/> </reactantList> </reaction> will return 2
//     * components, reactantList, followed by reactant.
//     * 
//     * @return empty if no components (some components such as CMLProduct will
//     *         always return this)
//     */
//    public List<ReactionComponent> getReactionComponentDescendants();
//
//    /**
//     * gets child reactionComponents. note that this will return containers but
//     * not their contents. thus calling this on: <reaction> <reactantList>
//     * <reactant/> </reactantList> </reaction> will return 1 components,
//     * reactantList.
//     * 
//     * @return empty if no components (some components such as CMLProduct will
//     *         always return this)
//     */
//    public List<ReactionComponent> getReactionComponentChildren();
//
}
