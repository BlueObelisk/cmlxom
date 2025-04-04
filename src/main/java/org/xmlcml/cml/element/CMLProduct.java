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

import java.util.ArrayList;
import java.util.List;

import nu.xom.Element;
import nu.xom.Elements;
import org.xmlcml.cml.base.CMLElement;

/**
 * user-modifiable class supporting product. * autogenerated from schema use as
 * a shell which can be edited
 *
 */
public class CMLProduct extends AbstractProduct implements ReactionComponent {

	
	// TODO
	/** namespaced element name.*/
	public final static String NS = C_E+TAG;

    /**
     * constructor.
     */
    public CMLProduct() {
    }

    /**
     * constructor.
     *
     * @param old
     */
    public CMLProduct(CMLProduct old) {
        super((AbstractProduct) old);

    }

    /**
     * copy node .
     *
     * @return Node
     */
    public Element copy() {
        return new CMLProduct(this);

    }

    /**
     * create new instance in context of parent, overridable by subclasses.
     *
     * @param parent
     *            parent of element to be constructed (ignored by default)
     * @return CMLProduct
     */
    public CMLElement makeElementInContext(Element parent) {
        return new CMLProduct();

    }

    /**
     * get molecule.
     *
     * @return molecule
     */
    public CMLMolecule getMolecule() {
        return CMLProduct.getMoleculeX(this);
    }

    static CMLMolecule getMoleculeX(CMLElement element) {
        CMLMolecule molecule = null;
        Elements moleculeChildElements = element
                .getChildCMLElements(CMLMolecule.TAG);
        if (moleculeChildElements.size() == 1) {
            molecule = (CMLMolecule) moleculeChildElements.get(0);
        }
        return molecule;
    }

    /**
     * get all descendant atoms.
     *
     * @return list of descendant atoms
     */
    public List<CMLAtom> getAtoms() {
        return CMLReaction.getAtoms(this);
    }

    /**
     * get all descendant bonds.
     *
     * @return list of descendant bonds
     */
    public List<CMLBond> getBonds() {
        return CMLReaction.getBonds(this);
    }

//    /**
//     * get all descendant formulas.
//     *
//     * @return list of descendant formulas
//     */
//    public List<CMLFormula> getFormulas() {
//        return CMLReaction.getFormulas(this);
//    }

//    /**
//     * get all descendant molecules.
//     *
//     * @return list of descendant molecules
//     */
//    public List<CMLMolecule> getMolecules() {
//        return CMLReaction.getMolecules(this);
//    }

    /**
     * gets descendant reactionComponents. only for interface compatibility
     *
     * @return always empty list
     */
    public List<ReactionComponent> getReactionComponentDescendants() {
        return new ArrayList<ReactionComponent>();
    }

    /**
     * gets child reactionComponents. only for interface compatibility
     *
     * @return always empty list
     */
    public List<ReactionComponent> getReactionComponentChildren() {
        return new ArrayList<ReactionComponent>();
    }

    /**
     * get formula. if has single child Formula use that. else create from child
     * Molecule
     *
     * @return null if cannot create formula
     */
    public CMLFormula getOrCreateFormula() {
        return CMLReactant.getOrCreateFormula(this);
    }

    /**
     * @return all formula objects
     */
	public List<CMLFormula> getFormulas() {
        return CMLReaction.getFormulas(this);
	}

	/**
	 * @return all molecules
	 */
	public List<CMLMolecule> getMolecules() {
        return CMLReaction.getMolecules(this);
	}

}
