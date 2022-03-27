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

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import nu.xom.Attribute;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Elements;
import nu.xom.Node;
import nu.xom.Nodes;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.xmlcml.cml.attribute.IdAttribute;
import org.xmlcml.cml.base.CMLConstants;
import org.xmlcml.cml.base.CMLElement;
import org.xmlcml.cml.base.CMLElements;
import org.xmlcml.cml.base.CMLUtil;
import org.xmlcml.euclid.Real2;
import org.xmlcml.euclid.Real2Vector;

/**
 * Class representing the CML molecule element, this class can be used to
 * retrieve and manipulate the CMLAtom and CMLBond elements that belong to this
 * molecule as well as perform simple calculations such as...
 *
 * @author Peter Murray-Rust, Ramin Ghorashi (2005)
 *
 */
public class CMLMolecule 
    extends AbstractMolecule /*implements Indexable*/ {
	

	/** namespaced element name.*/
	public final static String NS = C_E+TAG;

	/** control of hydrogen */
	public enum HydrogenControl {
		// this probably needs more looking at
		/** expand hydrogens always and add to existing H. */
		ADD_TO_EXPLICIT_HYDROGENS,
		/** add number of explicit H to current hydrogenCount. */
		ADD_TO_HYDROGEN_COUNT,
		/** expand hydrogens only if no explicit hydrogens. */
		NO_EXPLICIT_HYDROGENS,
		/** replace hydrogenCount by number of explicit H. */
		REPLACE_HYDROGEN_COUNT,
		/** use explict H in formula. */
		USE_EXPLICIT_HYDROGENS,
		/** use hydrogenCount in formula. */
		USE_HYDROGEN_COUNT;
	}

	/** 2-D coordinates. */
	public final static int COORD2 = 2;

	/** 3-D coordinates. */
	public final static int COORD3 = 3;

	/** 2-d coordinates. */
	public final static String D2 = "2D";

	/** 3-d coordinates. */
	public final static String D3 = "3D";

//	/** default single or LH R group.
//	*/
//	public final static String R1 = "defr1";

//	/** RH R group.
//	*/
//	public final static String R2 = "defr2";

	final static Logger logger;

	// / @cond DOXYGEN_STATIC_BLOCK_WORKAROUND
	static {
		logger = Logger.getLogger(CMLMolecule.class);
		logger.setLevel(Level.INFO);
	}

	// ancillary elements or helpers

    /** gets the first ancestor molecule
     * 
     * @return null if none
     */
	public static CMLMolecule getAncestorMolecule(CMLElement element) {
    	try {
    		return (CMLMolecule)(element.query("ancestor::cml:molecule", CML_XPATH)).get(0);
    	} catch (Exception e) {
    		 return null;
    	}
	}


	/**
	 * get corresponding molecule
	 *
	 * uses parent molecule or grandparent // should be using XPath
	 *
	 * @param elem
	 * @return the molecule (null if none)
	 * @deprecated use getAncetsorMolecule
	 */
	public static CMLMolecule getMoleculeAncestor(CMLElement elem) {
		CMLMolecule mol = null;
		Node parent = elem;
		while (true) {
			parent = parent.getParent();
			if (parent == null || parent instanceof Document) {
				break;
			}
			if (parent instanceof CMLMolecule) {
				mol = (CMLMolecule) parent;
				break;
			}
		}
		return mol;
	}

	/**
	 * create new instance in context of parent, overridable by subclasses.
	 *
	 * @param parent
	 *            parent of element to be constructed (ignored by default)
	 * @return CMLBond
	 */
	public CMLElement makeElementInContext(Element parent) {
		return new CMLMolecule();
	}

	/** map holding ids of all child molecules idexed by id.
	 */
	Map<String, List<CMLAtom>> childMoleculeAtomMap = null;

	/** map with child molecules indexed by atom.
	 */
	Map<CMLAtom, CMLMolecule> atomChildMoleculeMap = null;

	// =========================== main constructors ========================

	/**
	 * normal constructor.
	 *
	 */
	public CMLMolecule() {
		super();
		init();
	}

	/** recommended creator.
	 * @param id
	 * @return empty molecule.
	 */
	public static CMLMolecule createMoleculeWithId(String id) {
		CMLMolecule molecule = new CMLMolecule();
		molecule.setId(id);
		return molecule;
	}

	/**
	 * copy constructor.
	 * PMR I don't trust this...
	 * @param old
	 *            molcule to copy
	 */
	public CMLMolecule(CMLMolecule old) {
		super((AbstractMolecule) old);
		init();
		CMLAtomArray atomArray = this.getAtomArray();
		if (atomArray != null) {
			atomArray.indexAtoms();
		}
		CMLBondArray bondArray = this.getBondArray();
		if (bondArray != null) {
			bondArray.indexBonds();
		}
	}

	/**
	 * The checking included in previous versions of Jumbo has now been removed. This
	 * method is retained for backward compatibility only, and the value of the boolean does
	 * not affect the execution of the code. 
	 * @author dmj30
	 * @param atom
	 * @throws RuntimeException
	 *             null, non-uniqueID, etc.
	 */
	@Deprecated
	public void addAtom(CMLAtom atom, boolean check) throws RuntimeException {
			addAtom(atom);
	}
		
	/** add atom.
	 *
	 * only if in same molecule. If already added returns with no-op
	 * cannot add to child molecule. However if 'this' is a child of
	 * a CMLMolecule throws Exception
	 * @param atom
	 * @throws RuntimeException
	 *             null, non-uniqueID, etc.
	 */
	public void addAtom(CMLAtom atom) throws RuntimeException {
		if (atom != null) {
			//ParentNode parent = this.getParent();
			//if (parent instanceof CMLMolecule) {
			//    throw new RuntimeException("Cannot add atom to child molecule");
			//}
			CMLAtomArray atomArray = getOrCreateAtomArray();
			// should it be atom array that tests this?
			String id = atom.getId();
			if (id == null) {
				throw new RuntimeException("Null atom ID");
			}
			CMLAtom oldAtom = atomArray.getAtomById(id);
			if (oldAtom == null) {
				atomArray.addAtom(atom);
			}
		} else {
			throw new RuntimeException("Cannot add null atom");
		}
	}

	/** delete atom.
	 * recurse through descendants and remove first instance of
	 * atom (there should only be one)
	 * @param atom
	 * @return atom deleted
	 */
	public CMLAtom deleteAtom(CMLAtom atom) {
		CMLAtom deletedAtom = null;
		if (isMoleculeContainer()) {
			getAtomChildMoleculeMap();
			CMLMolecule molecule = atomChildMoleculeMap.get(atom);
			if (molecule != null) {
				molecule.deleteAtom(atom);
				deletedAtom = atom;
				atomChildMoleculeMap.remove(atom);
			}
		} else {
			CMLAtomArray atomArray = getAtomArray();
			if (atomArray != null) {
				deletedAtom = atomArray.removeAtom(atom);
			}
		}
		removeAtomFromChildMoleculeAtomMap(atom);
		return deletedAtom;
	}

	private void removeAtomFromChildMoleculeAtomMap(CMLAtom atom) {
		getChildMoleculeAtomMap();
		String id = atom.getId();
		List<CMLAtom> atomList = childMoleculeAtomMap.get(id);
		if (atomList != null && atomList.size() > 1) {
			atomList.remove(atom);
		} else {
			childMoleculeAtomMap.remove(id);
		}
	}

	/** get the atomChildMoleculeMap.
	 * if null, populate it with atoms from child molecules.
	 *
	 */
	private void getAtomChildMoleculeMap() {
		if (atomChildMoleculeMap == null) {
			atomChildMoleculeMap = new HashMap<CMLAtom, CMLMolecule>();
			CMLElements<CMLMolecule> moleculeList = this.getMoleculeElements();
			for (CMLMolecule molecule : moleculeList) {
				List<CMLAtom> atomList = molecule.getAtoms();
				for (CMLAtom atom : atomList) {
					atomChildMoleculeMap.put(atom, molecule);
				}
			}
		}
	}

	/** add atomArray.
	 * forbidden. must use addAtom()
	 * @deprecated
	 * @param atomArray
	 * @param pos
	 * @throws RuntimeException
	 */
	@Deprecated
	public void insertAtomArray(CMLAtomArray atomArray, int pos) {
		throw new RuntimeException("append/insert atomArray forbidden");
	}

	/** remove atomArray.
	 * also removes bondArray
	 *
	 */
	public void removeAtomArray() {
		CMLElements<CMLAtomArray> atomArrays= this.getAtomArrayElements();
		CMLAtomArray atomArray =
			(atomArrays.size() == 0) ? null : atomArrays.get(0);
		if (atomArray != null) {
			super.removeChild(atomArray);
			this.removeBondArray();
		}
	}

	/** add bondArray.
	 * forbidden. must use addBond()
	 * @deprecated
	 * @param bondArray
	 * @param pos
	 * @throws RuntimeException
	 */
	public void insertBondArray(CMLBondArray bondArray, int pos) {
		throw new RuntimeException("append/insert bondArray forbidden");
	}

	/** remove bondArray.
	 *
	 */
	public void removeBondArray() {
		CMLElements<CMLBondArray> bondArrays= this.getBondArrayElements();
		CMLBondArray bondArray =
			(bondArrays.size() == 0) ? null : bondArrays.get(0);
		if (bondArray != null) {
			super.removeChild(bondArray);
		}
	}

	/**
	 * The checking included in previous versions of Jumbo has now been removed. This
	 * method is retained for backward compatibility only, and the value of the boolean does
	 * not affect the execution of the code. 
	 * @author dmj30
	 * @param bond
	 * @throws RuntimeException
	 *             null, non-uniqueID, etc.
	 */
	@Deprecated
	public void addBond(CMLBond bond, boolean check) throws RuntimeException {
		addBond(bond);
	}
	
	/**
	 * add bond.
	 * checks for duplicates ; should be changed to use atoms
	 * only if in same molecule. If already added returns with no-op
	 *
	 * @param bond
	 * @throws RuntimeException
	 *             null, non-uniqueID, etc.
	 */
	public void addBond(CMLBond bond) throws RuntimeException {
		CMLBondArray bondArray = getOrCreateBondArray();

		// should it be bond array that tests this?
		String id = bond.getId();
		if (id == null) {
			String[] atomRefs2 = bond.getAtomRefs2();
//			throw new Runtime("Null bond ID");
			id = atomRefs2[0]+S_UNDER+atomRefs2[1];
			bond.setId(id);
		} else {
			CMLBond oldBond = getBondById(id);
			if (oldBond != null) {
				if (oldBond != bond) {
					throw new RuntimeException("Bond id not unique: " + id);
				}
				return;
			}
		}
		bondArray.addBond(bond);
	}

	/** delete bond.
	 * recurse through descendants and remove first instance of
	 * bond (there should only be one)
	 *
	 * @param bond
	 * @return bond deleted
	 */
	public CMLBond deleteBond(CMLBond bond) {
		CMLBond deletedBond = null;
		if (isMoleculeContainer()) {
			for (CMLMolecule mol : this.getMoleculeElements()) {
				deletedBond = mol.deleteBond(bond);
				if (deletedBond != null) {
					break;
				}
			}
		} else {
			CMLBondArray bondArray = getBondArray();
			if (bondArray != null) {
				deletedBond = bondArray.removeBond(bond);
			}
		}
		return deletedBond;
	}

	/** delete bond.
	 * convenience method. Finds bond and if not null uses deleteBond
	 *
	 * @param atom1
	 * @param atom2
	 * @return bond deleted of null
	 */
	public CMLBond deleteBond(CMLAtom atom1, CMLAtom atom2) {
		CMLBond deletedBond = this.getBond(atom1, atom2);
		if (deletedBond != null) {
			deleteBond(deletedBond);
		}
		return deletedBond;
	}


	/**
	 * append a molecule to this one if current molecule has no children,
	 * creates a new parent molecule and adds itself as a child.
	 * in this case strips all attributes except ID.
	 * if children already present adds as sibling
	 * children
	 *
	 * @param newMol
	 *            the CMLMolecule to append
	 * @exception RuntimeException
	 *                if the DOM operation failed
	 */
	public void appendMolecule(CMLMolecule newMol) {
		Node parent = newMol.getParent();
		if (parent != null && parent instanceof Document) {
			Element dummy = new Element("m_dummy");
			((Document)parent).replaceChild(newMol, dummy);
		}
		newMol.detach();
		if (this.getMoleculeCount() == 0) {
			CMLMolecule thisMol = new CMLMolecule(this);
			for (int i = 0; i < this.getAttributeCount(); i++) {
				Attribute att = this.getAttribute(i);
				if (!att.getLocalName().equals(IdAttribute.NAME)) {
					this.removeAttribute(this.getAttribute(i));
				}
			}
			this.removeChildren();
			this.appendChild(thisMol);
		}
		this.appendChild(newMol);
	}

	/** delete molecule child.
	 * if the result is a single molecule child does NOT
	 * normalize the result.
	 * @param molecule
	 */
	public void deleteMolecule(CMLMolecule molecule) {
		int nChildMolecule = getMoleculeCount();
		if (nChildMolecule == 0) {
			throw new RuntimeException("molecule has no children to delete");
		} else {
			int idx = this.indexOf(molecule);
			if (idx == -1) {
				throw new RuntimeException("Molecule is not a child of this Molecule");
			}
			if (nChildMolecule == 1) {
				throw new RuntimeException("Cannot have single child molecule");
			} else if (nChildMolecule == 2) {
				molecule.detach();
				// do not normalize at this stage
			} else {
				molecule.detach();
			}
			removeAtomsFromAtomMap(molecule.getAtoms());
		}
	}

	private void removeAtomsFromAtomMap(List<CMLAtom> atomList) {
		getChildMoleculeAtomMap();
		for (CMLAtom atom : atomList) {
			childMoleculeAtomMap.remove(atom);
		}
	}

	/** normalize molecule has a single molecule child.
	 * transfers children single child molecule to this
	 * and removes childMolecule.
	 * Thus
	 * {@code
	 * <molecule id="m1">
	 *   <molecule id="m2">
	 *     <atomArray id="a1 a2"/>
	 *   </molecule>
	 * </molecule>
	 * becomes
	 *   <molecule id="m1">
	 *     <atomArray id="a1 a2"/>
	 *   </molecule>
	 * }
	 * atom indexing should be reset
	 */
	public void normalizeSingleMoleculeChild() {
		if (this.getMoleculeCount() == 1) {
			CMLMolecule childMolecule = (CMLMolecule)
			this.getChildCMLElements(CMLMolecule.TAG).get(0);
			CMLUtil.transferChildren(childMolecule, this);
			childMolecule.detach();
		}
	}

	/** reroutes appendChild() for molecule.
	 * calls addMolecule(molecule)
	 * @param molecule
	 */
	public void appendChild(CMLMolecule molecule) {
		this.addMolecule(molecule);
	}

	/** reroutes removeChild() for molecule.
	 * calls deleteMolecule(molecule)
	 * @param molecule
	 */
	public void removeChild(CMLMolecule molecule) {
		this.deleteMolecule(molecule);
	}

	/** reroutes appendChild() for atom.
	 * calls addAtom(atom)
	 * @param atom
	 */
	public void appendChild(CMLAtom atom) {
		this.addAtom(atom);
	}

	/** reroutes removeChild() for atom.
	 * calls deleteAtom(atom)
	 * @param atom
	 */
	public void removeChild(CMLAtom atom) {
		this.deleteAtom(atom);
	}

	/** reroutes appendChild() for bond.
	 * calls addBond(bond)
	 * @param bond
	 */
	public void appendChild(CMLBond bond) {
		this.addBond(bond);
	}

	/** reroutes removeChild() for bond.
	 * calls deleteBond(bond)
	 * @param bond
	 */
	public void removeChild(CMLBond bond) {
		this.deleteBond(bond);
	}

	/**
	 * Appends a string to the ids for the molecule, atoms and bonds. It also
	 * updates the bond refs to point to the amended atom ids.
	 *
	 * @param s
	 *            The string to be appended to all of the ids
	 */
	public void appendToIds(final String s) {
		String id = this.getId();

		if ((id != null) && (id.length() > 0)) {
			this.setId(id + s);
		} else {
			this.setId("m" + s);
		}

		for (CMLAtom atom : getAtoms()) {
			id = atom.getId();
			if ((id != null) && (id.length() > 0)) {
				atom.resetId(id + s);
			}
		}

		for (CMLBond bond : getBonds()) {
			id = bond.getId();
			if ((id != null) && (id.length() > 0)) {
				bond.setId(id + s);
			}

			String[] refs = bond.getAtomRefs2();

			if (refs != null) {
				for (int j = refs.length - 1; j >= 0; --j) {
					refs[j] += s;
				}
			}

			bond.setAtomRefs2(refs);
		}
	}

	/**
	 * calculate formal charge from charges on atoms in the molecule
	 * @return charge
	 */
	public int calculateFormalCharge() {
		int formalCharge = 0;
		for (CMLAtom atom : this.getAtoms()) {
			formalCharge += atom.getFormalCharge();
		}
		return formalCharge;
	}


	/**
	 * copy node .
	 *
	 * @return Node
	 */
	public Element copy() {
		CMLMolecule newMolecule = new CMLMolecule(this);
		// newMolecule.moleculesManager = new MoleculeMolecules(this);
		// newMolecule.moleculesManager.update();
		return newMolecule;
	}

	/**
	 * will process repeat attribute.
	 *
	 * @param parent
	 *            element
	 */
	public void finishMakingElement(Element parent) {
		super.finishMakingElement(parent);
		// not necessary as done already
//		indexAtoms();
		// this also updates the ligands
//		indexBonds();
//		updateLigands();
//		RepeatAttribute.process(this);
	}

	void indexAtoms() {
		if (isMoleculeContainer()) {
			for (CMLMolecule mol : this.getMoleculeElements()) {
				mol.indexAtoms();
			}
		} else {
			CMLAtomArray atomArray = this.getOrCreateAtomArray();
			if (atomArray != null) {
				atomArray.indexAtoms();
			}
		}
	}

	void indexBonds() {
		if (isMoleculeContainer()) {
			for (CMLMolecule mol : this.getMoleculeElements()) {
				// these should be indexed as children finish first
				mol.indexBonds();
			}
		} else {
			CMLBondArray bondArray = this.getOrCreateBondArray();
			bondArray.indexBonds();
		}
	}

	void updateLigands() {
		if (isMoleculeContainer()) {
			for (CMLMolecule mol : this.getMoleculeElements()) {
				mol.updateLigands();
			}
		} else {
			CMLBondArray bondArray = this.getBondArray();
			if (bondArray != null) {
				bondArray.updateLigands();
			}
		}
	}

	/**
	 * Convenience method for accessing i'th CMLAtom. FRAGILE. Used to iterate
	 * through the atoms of this molecule; however the list is subject to change
	 * and could cause unexpected results.
	 *
	 * Use getAtoms to return a typed list of all the atoms in this molecule.
	 *
	 * @param i
	 *            the index of the atoms to access
	 * @return the bond, or null if index is out of bounds.
	 *
	 */
	public CMLAtom getAtom(int i) {
		List<CMLAtom> atoms = this.getAtoms();
		return (i < 0 || i >= atoms.size()) ? null : atoms.get(i);
	}

	/**
	 * gets atomArray child.
	 *
	 * @return null if does not exist
	 */
	public CMLAtomArray getAtomArray() {
		return (CMLAtomArray) this.getFirstCMLChild("atomArray");
	}

	/** gets atomMap.
	 * if molecule has single AtomArray child returns its map
	 * if molecule has submolecules returns null;
	 * @return null if
	 */
	public Map<String, CMLAtom> getAtomMap() {
		Map<String, CMLAtom> map = null;
		if (this.isMoleculeContainer()) {
		} else {
			CMLAtomArray atomArray = this.getAtomArray();
			map = (atomArray == null) ? null : atomArray.getAtomMap();
		}
		return map;
	}

	/** gets bondMap.
	 * if molecule has single BondArray child returns its map
	 * if molecule has submolecules returns null;
	 * @return null if
	 */
	public Map<String, CMLBond> getBondMap() {
		Map<String, CMLBond> map = null;
		if (this.isMoleculeContainer()) {
		} else {
			CMLBondArray bondArray = this.getBondArray();
			map = (bondArray == null) ? null : bondArray.getBondMap();
		}
		return map;
	}

	/** gets bondIdMap.
	 * if molecule has single BondArray child returns its map
	 * if molecule has submolecules returns null;
	 * @return null if
	 */
	public Map<String, CMLBond> getBondIdMap() {
		Map<String, CMLBond> map = null;
		if (this.isMoleculeContainer()) {
		} else {
			CMLBondArray bondArray = this.getBondArray();
			map = (bondArray == null) ? null : bondArray.getBondIdMap();
		}
		return map;
	}

	/**
	 * gets atom by id.
	 *
	 * @param id
	 * @return the atom or null
	 */
	public CMLAtom getAtomById(String id) {
		CMLAtom atom = null;
		if (id != null) {
			CMLAtomArray atomArray = getAtomArray();
			// use atomArray first in case there are child molecules
			if (atomArray != null) {
				// crude check for update index
				if (atomArray.atomMap.size() !=
					atomArray.getAtomElements().size()) {
					atomArray.indexAtoms();
				}
				atom = atomArray.getAtomById(id);
			} else if (getMoleculeCount() > 0) {
				getChildMoleculeAtomMap();
				List<CMLAtom> atomList = childMoleculeAtomMap.get(id);
				if (atomList != null && atomList.size() == 1) {
					atom = atomList.get(0);
				}
			}
		}
		return atom;
	}

	/**
	 * gets atom by id.
	 *
	 * @param id
	 * @return the atom or null
	 */
	public CMLAtom getAtomByIdXX(String id) {
		CMLAtom atom = null;
		if (getMoleculeCount() > 0) {
			getChildMoleculeAtomMap();
			List<CMLAtom> atomList = childMoleculeAtomMap.get(id);
			if (atomList != null && atomList.size() == 1) {
				atom = atomList.get(0);
			}
		} else {
			CMLAtomArray atomArray = getAtomArray();
			if (atomArray != null) {
				atom = atomArray.getAtomById(id);
			}
		}
		return atom;
	}

	/**
	 * gets atoms by id.
	 * only works on child molecules (as ids should be unique)
	 * @param id
	 * @return the atomList (may be null, should not be empty)
	 */
	public List<CMLAtom> getAtomsById(String id) {
		getChildMoleculeAtomMap();
		return childMoleculeAtomMap.get(id);
	}
	
	/** get list of child molecules.
	 * 
	 * @param mol
	 * @return list (empty if none)
	 */
	public static List<CMLMolecule> getChildMoleculeList(CMLMolecule mol) {
		List<CMLMolecule> moleculeList = new ArrayList<CMLMolecule>();
		Elements mols = mol.getChildElements("molecule", CMLConstants.CML_NS);
		for (int i = 0; i < mols.size(); i++) {
			moleculeList.add((CMLMolecule) mols.get(i));
		}
		return moleculeList;
	}

	private Map<String, List<CMLAtom>> getChildMoleculeAtomMap() {
		if (childMoleculeAtomMap == null) {
			childMoleculeAtomMap = new HashMap<String, List<CMLAtom>>();
			if (this.isMoleculeContainer()) {
				CMLElements<CMLMolecule> molList = this.getMoleculeElements();
				for (CMLMolecule molecule : molList) {
					molecule.indexAtomIds(childMoleculeAtomMap);
				}
			} else {
				this.indexAtomIds(childMoleculeAtomMap);
			}
		}
		return childMoleculeAtomMap;
	}

	private void indexAtomIds(Map<String, List<CMLAtom>> childMoleculeAtomMap) {
		List<CMLAtom> atomList = this.getAtoms();
		for (CMLAtom atom : atomList) {
			String id = atom.getId();
			List<CMLAtom> aList = childMoleculeAtomMap.get(id);
			if (aList == null) {
				aList = new ArrayList<CMLAtom>();
				childMoleculeAtomMap.put(id, aList);
			}
			aList.add(atom);
		}
	}

	/**
	 * does the CMLMolecule contain atoms that are too close together?
	 *
	 * @return boolean
	 */
	public boolean hasCloseContacts() {
		if (this.getCloseContacts().size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 *
	 * @return map where each entry corresponds to 2 atoms involved in a close contact.
	 */
	public Map<CMLAtom, CMLAtom> getCloseContacts() {
		Map<CMLAtom, CMLAtom> contactMap = new HashMap<CMLAtom, CMLAtom>();
		for (CMLAtom atom : this.getAtoms()) {
			for (CMLAtom ligand : atom.getLigandAtoms()) {
				if (!contactMap.containsKey(ligand)) {
					double valenceDist = atom.getChemicalElement().getCovalentRadius()+ligand.getChemicalElement().getCovalentRadius();
					double dist = atom.getDistanceTo(ligand);
					if ((valenceDist/2) > dist) {
						contactMap.put(atom, ligand);
					}
				}
			}
		}
		return contactMap;
	}

	/**
	 * gets bond by id
	 *
	 * @param id
	 * @return the bond or null
	 */
	public CMLBond getBondById(String id) {
		CMLBondArray bondArray = getBondArray();
		return (bondArray == null) ? null : bondArray.getBondById(id);
	}

	/**
	 * get bond for atom ids
	 *
	 * @param id1
	 * @param id2
	 * @return bond or null
	 */
	public CMLBond getBondByAtomIds(String id1, String id2) {
		CMLAtom atom1 = this.getAtomById(id1);
		CMLAtom atom2 = this.getAtomById(id2);
		return this.getBond(atom1, atom2);
	}

	/**
	 * gets atoms by id. can be used to resolve attributes such as atomRefs2,
	 * atomRefs, etc.
	 *
	 * @param ids
	 *            (if null returns zero length list)
	 * @return list of atoms (zero length if none or if has child molecules)
	 */
	public List<CMLAtom> getAtomListByIds(String[] ids) {
		List<CMLAtom> atomList = new ArrayList<CMLAtom>();
		if (!this.isMoleculeContainer()) {
			if (ids != null) {
				for (String id : ids) {
					CMLAtom atom = this.getAtomById(id);
					if (atom != null) {
						atomList.add(atom);
					}
				}
			}
		}
		return atomList;
	}

	/**
	 * gets atom by its label attribute.
	 *
	 * if there are duplicate labels, behaviour is undefined
	 *
	 * @param label
	 *            (attribute for atom) should be unique
	 * @return the atom or null if not found
	 */
	public CMLAtom getAtomByLabel(String label) {
		CMLAtom atom1 = null;
		if (label != null) {
			for (CMLAtom atom : this.getAtoms()) {
				for (CMLLabel label1 : atom.getLabelElements()) {
					if (label.equals(label1.getCMLValue())) {
						atom1 = atom;
						break;
					}
				}
				if (atom1 != null) {
					break;
				}
			}
		}
		return atom1;
	}

	/**
	 * Gets atom count.
	 *
	 * @return int the atom count
	 */
	public int getAtomCount() {
		return getAtoms().size();
	}

	/**
	 * get atoms.
	 *
	 * @return the atoms (none returns emptyList)
	 */
	public List<CMLAtom> getAtoms() {
		List<CMLAtom> atomList = new ArrayList<CMLAtom>();
		for (CMLMolecule molecule : this.getDescendantsOrMolecule()) {
			CMLAtomArray atomArray = molecule.getAtomArray();
			if (atomArray != null) {
				atomList.addAll(atomArray.getAtoms());
			}
		}
		/*
        if (isMoleculeContainer()) {
            atomList = new ArrayList<CMLAtom>();
            for (CMLMolecule mol : this.getMoleculeElements()) {
                atomList.addAll(mol.getAtoms());
            }
        } else {
            CMLAtomArray atomArray = this.getAtomArray();
            if (atomArray != null) {
                atomList = atomArray.getAtoms();
            }
        }
		 */
		// else return a blank list
		return atomList;
	}


	/**
	 * get bond connecting 2 atoms.
	 *
	 * @param a1
	 *            first atom
	 * @param a2
	 *            second atom
	 * @return bond or null if not found
	 */
	public CMLBond getBond(CMLAtom a1, CMLAtom a2) {
		String atomHash = CMLBond.atomHash(a1, a2);
		if (atomHash != null) {
			for (CMLBond bond : getBonds()) {
				String bondHash = CMLBond.atomHash(bond);
				if (bondHash.equals(atomHash)) {
					return bond;
				}
			}
		}
		return null;
	}

	/**
	 * gets bondArray child.
	 *
	 * @return null if does not exist
	 */
	public CMLBondArray getBondArray() {
		return (CMLBondArray) this.getFirstCMLChild(CMLBondArray.TAG);
	}

	/**
	 * Gets the number of bonds in this molecule
	 *
	 * @return int the Bond count
	 */
	public int getBondCount() {
		List<CMLBond> bonds = getBonds();
		return bonds.size();
	}

	/**
	 * gets a typed list containing all the bonds in this molecule
	 *
	 * @return a typed list
	 */
	public List<CMLBond> getBonds() {
		List<CMLBond> bondList = new ArrayList<CMLBond>();
		for (CMLMolecule molecule : this.getDescendantsOrMolecule()) {
			CMLBondArray bondArray = molecule.getBondArray();
			if (bondArray != null) {
				bondList.addAll(bondArray.getBonds());
			}
		}
		return bondList;
	}

	/**
	 * Calculate formalCharge from atomCharges.
	 *
	 * @param control
	 * @return calculated formal charge
	 * @throws RuntimeException
	 *             if control=NO_DEFAULT and som atoms have no formalCharge
	 */
	public int getCalculatedFormalCharge(FormalChargeControl control)
	throws RuntimeException {
		int charge = 0;
		for (CMLAtom atom : getAtoms()) {
			charge += atom.getFormalCharge(control);
		}
		return charge;
	}

	/**
	 * calculate 2D centroid.
	 *
	 * @return centroid of 2D coords or null
	 */
	public Real2 calculateCentroid2D() {
		Real2Vector p2Vector = getCoordinates2D();
		return p2Vector.getCentroid();
	}

	/**
	 * identify double bonds.
	 *
	 * @return the bonds (zero length if none)
	 */
	public List<CMLBond> getDoubleBonds() {
		setNormalizedBondOrders();
		List<CMLBond> dbVector = new ArrayList<CMLBond>();
		for (CMLBond bond : getBonds()) {
			String order = bond.getOrder();
			if (CMLBond.isDouble(order)) {
				dbVector.add(bond);
			}
		}
		return dbVector;
	}

//	/**
//	* gets nearest ancestor molecule element.
//	*
//	* @param element
//	*            descendant of molecule
//	* @return the owner molecule or null if not found
//	*/
//	public static CMLMolecule getMolecule(CMLElement element) {
//	CMLMolecule molecule = null;
//	Node node = element;
//	while (true) {
//	ParentNode parent = node.getParent();
//	if (parent == null) {
//	break;
//	} else if (parent instanceof CMLMolecule) {
//	molecule = (CMLMolecule) parent;
//	}
//	node = parent;
//	}
//	return molecule;
//	}

	/**
	 * get count of daughter molecules. further descendants are not counted.
	 *
	 * @return the count ; 0 if no molecule children
	 */
	public int getMoleculeCount() {
		return getMoleculeElements().size();
	}

//	/** get variable in repeat attribute.
//	*
//	* @return the name of the variable or null
//	*/
//	public String getRepeatName() {
//	return this.getRepeatStrings()[0];
//	}

//	/** get the starting index.
//	*
//	* @return the start
//	*/
//	public int getRepeatStart() {
//	int start = -1;
//	String startS = this.getRepeatStrings()[1];
//	try {
//	start = Integer.parseInt(startS);
//	} catch (NumberFormatException e) {
//	throw new RuntimeException("Bad start value: "+startS);
//	}
//	return start;
//	}

//	/** get end of repeat (inclusive).
//	*
//	* @return the index
//	*/
//	public int getRepeatEnd() {
//	int end = -1;
//	String endS = this.getRepeatStrings()[2];
//	try {
//	end = Integer.parseInt(endS);
//	} catch (NumberFormatException e) {
//	throw new RuntimeException("Bad end value: "+endS);
//	}
//	return end;
//	}

//	String[] getRepeatStrings() {
//	String repeat = this.getRepeat();
//	if (repeat == null) {
//	throw new RuntimeException("null repeat attribute");
//	}
//	String[] strings = repeat.trim().split("\\s+");
//	if (strings.length != 3) {
//	throw new RuntimeException("repeat must have 3 components");
//	}
//	return strings;
//	}

	/** get molecule or its descendants. i.e. the actual molecules rather than
	 * the container
	 *
	 * @return list of molecules
	 */
	public List<CMLMolecule> getDescendantsOrMolecule() {
		List<CMLMolecule> moleculeList = new ArrayList<CMLMolecule>();
		CMLElements<CMLMolecule> moleculeElements = this.getMoleculeElements();
		if (moleculeElements.size() == 0) {
			moleculeList.add(this);
		} else {
			for (CMLMolecule molecule : moleculeElements) {
				moleculeList.add(molecule);
			}
		}
		return moleculeList;
	}

	/** gets the childAtomArray.
	 * if not present adds and empty atomArray child to this
	 * use carefully
	 * @return the atomArray
	 */
	public CMLAtomArray getOrCreateAtomArray() {
		CMLAtomArray atomArray = this.getAtomArray();
		if (atomArray == null) {
			atomArray = new CMLAtomArray();
			this.addAtomArray(atomArray);
		}
		return atomArray;
	}

	/** gets the childBondArray.
	 * if not present adds and empty bondArray child to this
	 * use carefully
	 * @return the bondArray
	 */
	public CMLBondArray getOrCreateBondArray() {
		CMLBondArray bondArray = this.getBondArray();
		if (bondArray == null) {
			bondArray = new CMLBondArray();
			this.addBondArray(bondArray);
		}
		return bondArray;
	}

	/**
	 * gets vector of 2D coordinates.
	 *
	 * all atoms must have coordinates
	 *
	 * @return the vector (empty if missing 2D coordinates)
	 */
	public Real2Vector getCoordinates2D() {
		Real2Vector p2Vector = new Real2Vector();
		boolean ok = true;
		for (CMLAtom atom : getAtoms()) {
			Real2 p = atom.getXY2();
			if (p != null) {
				p2Vector.add(p);
			}
		}
		if (!ok) {
			p2Vector = new Real2Vector();
		}
		return p2Vector;
	}

	/**
	 * Convenience method for determing if molecule has coordinates of a given
	 * type. if hasSubMolecules returns true if any submolecules fit
	 *
	 * @param type of coordinates
	 * @param omitHydrogen akip hydrogens without coordinates
	 * @return has coords
	 */
	public boolean hasCoordinates(CoordinateType type, boolean omitHydrogen) {
		boolean has = true;
		for (CMLAtom atom : getAtoms()) {
			if (omitHydrogen && "H".equals(atom.getElementType())) {
				continue;
			}
			has = atom.hasCoordinates(type);
			if (!has)
				break;
		}
		return has;
	}

	/**
	 * Convenience method for determing if molecule has coordinates of a given
	 * type. if hasSubMolecules returns true if any submolecules fit
	 *
	 * @param type of coordinates
	 * @return has coords
	 */
	public boolean hasCoordinates(CoordinateType type) {
		boolean has = true;
		for (CMLAtom atom : getAtoms()) {
			has = atom.hasCoordinates(type);
			if (!has)
				break;
		}
		return has;
	}

	void init() {
//		logger.log(Level.INFO, ">>>>>>>>>>>NEW MOLECULE");
	}

	/**
	 * determines if this molecule contains child molecules
	 *
	 * @return true is this molecule is a container, false otherwise
	 */
	public boolean isMoleculeContainer() {
		return (this.getMoleculeElements().size() > 0);
	}

	// ====================== functionality =====================

	/**
	 * scale the coordinates.
	 *
	 * this should normally only be done for display purposes so only COORD2 is
	 * supported
	 *
	 * @param scale
	 *            the scalefactor
	 */
	public void multiply2DCoordsBy(double scale) {
		for (CMLAtom atom : getAtoms()) {
			Real2 xy = atom.getXY2();
			if (xy == null) {
				continue;
			}
			xy.x *= scale;
			xy.y *= scale;
			atom.setXY2(xy);
		}
	}


	/**
	 * rename AtomIDs in molecule and update atomRefs.
	 *
	 * AtomIDs in atoms, and atomRefs are consistently changed.
	 *
	 * @param oldIds
	 *            vector of original IDs
	 * @param newIds
	 *            vector of new IDs
	 *
	 * @throws RuntimeException
	 *             IDs do not correspond, or have duplicates
	 */
	public void renameAtomIDs(List<String> oldIds, List<String> newIds) {
		Map<String, String> mapTable = new HashMap<String, String>();
		Map<String, String> newTable = new HashMap<String, String>();
		List<CMLAtom> atoms = this.getAtoms();
		if (oldIds.size() != atoms.size() || newIds.size() != atoms.size()) {
			throw new RuntimeException("Lists (" + oldIds.size() + CMLConstants.S_SLASH
					+ newIds.size() + ") must be same length as atomCount ("
					+ atoms.size() + CMLConstants.S_RBRAK);
		}
		for (int i = 0; i < atoms.size(); i++) {
			String oldId = oldIds.get(i);
			if (this.getAtomById(oldId) == null) {
				throw new RuntimeException("Unknown atom id: " + oldId);
			}
			String newId = newIds.get(i);
			if (newTable.containsKey(newId)) {
				throw new RuntimeException("Duplicate new id: " + newId);
			} else {
				newTable.put(newId, CMLConstants.S_EMPTY);
			}
			mapTable.put(oldId, newId);
		}
		for (CMLAtom atom : atoms) {
			String oldId = atom.getId();
			atom.resetId(mapTable.get(oldId));
		}
		indexAtoms();
		for (CMLBond bond : getBonds()) {
			String[] atomRefs2 = bond.getAtomRefs2();
			String ar0 = mapTable.get(atomRefs2[0]);
			String ar1 = mapTable.get(atomRefs2[1]);
			bond.setAtomRefs2(ar0, ar1);
			bond.setId(bond.createId());
		}
		indexBonds();
	}

	/**
	 * Round the atomCoords to within a multiple of epsilon currently always
	 * rounds down (e.g. 3.9996 with epsilon = 0.001 =&gt; 3.999, not 4)
	 *
	 * @param epsilon
	 * @param coordinateType
	 */
	public void roundCoords(double epsilon, CoordinateType coordinateType) {
		CMLElements<CMLMolecule> molecules = this.getMoleculeElements();
		if (molecules.size() > 0) {
			for (CMLMolecule molecule : molecules) {
				molecule.roundCoords(epsilon, coordinateType);
			}
		} else {
			for (CMLAtom atom : getAtoms()) {
				atom.roundCoords(epsilon, coordinateType);
			}
		}
	}

	/**
	 * Sets all bond orders to given value.
	 *
	 * @param order
	 *            must not be null
	 */
	public void setBondOrders(String order) {
		if (order != null) {
			for (CMLBond bond : getBonds()) {
				bond.setOrder(order);
			}
		}
	}

	/**
	 * Sets all existing bond orders to normaliaed values.
	 * In practice this only happens when the XML version is parsed.
	 * getOrder and setOrder normalize by default. So this routine
	 * should only be required immediately after parsing
	 * values (S-&gt;1, D-&gt;2, T-&gt;3)
	 *
	 *IMPORTANT NOTE; we have changed this 2009 to be the reverse.
	 * 1-&gt;S, 2-&gt;D 3-&gt;T
	 */
	public void setNormalizedBondOrders() {
		List<CMLBond> bonds = this.getBonds();
		for (CMLBond bond : bonds) {
			try {
				String order = bond.getOrder();
				if (order != null) {
					// synonyms
					if (CMLBond.isSingle(order)) {
						order = CMLBond.SINGLE_S;
					} else if (CMLBond.isDouble(order)) {
						order = CMLBond.DOUBLE_D;
					} else if (CMLBond.isTriple(order)) {
						order = CMLBond.TRIPLE_T;
					}
					bond.setOrder(order);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("BUG " + e);
			}
		}
	}

	/**
	 * translate molecule in 2D.
	 *
	 * @param delta2
	 *            add to all 2D coordinates
	 */
	public void translate2D(Real2 delta2) {
		for (CMLAtom atom : getAtoms()) {
			if (atom.hasCoordinates(CoordinateType.TWOD)) {
				atom.setX2(atom.getX2() + delta2.x);
				atom.setY2(atom.getY2() + delta2.y);
			}
		}
	}

	/**
	 * unlabel all atoms in molecule.
	 *
	 * this cannot be reversed. It is mainly for adding labelled fragments to
	 * build up a molecule
	 *
	 */
	public void unlabelAllAtoms() {
		for (CMLAtom atom : getAtoms()) {
			for (CMLLabel label : atom.getLabelElements()) {
				label.detach();
			}
		}
	}

	public void normalizeFormulas() {
		CMLFormula formula = new CMLFormula(this);
		String concise = formula.getConcise();
		Nodes formulaElements = this.query("./cml:formula", CML_XPATH);
		for (int i = 0; i < formulaElements.size(); i++) {
			CMLFormula formulaElement = (CMLFormula) formulaElements.get(i);
			String conciseString = formulaElement.getConcise();
			if (conciseString == null) {
				formulaElement.setConcise(concise);
			} else if (conciseString.equals(concise)) {
				// no need to update
			} else {
				throw new RuntimeException("incompatible concise formulae; was "+
						conciseString+"; now "+concise);
			}
			// remove any spurious atomArrays
			Nodes atomArrays = formulaElement.query("./cml:atomArray", CML_XPATH);
			for (int j = 0; j < atomArrays.size(); j++) {
				atomArrays.get(j).detach();
			}
		}
	}
	
	public CMLFormula getFirstConciseFormula() {
		Nodes nodes = this.query("./*[local-name()='"+CMLFormula.TAG+"' and @concise]");
		return (nodes.size() > 0) ? (CMLFormula) nodes.get(0) : null;
	}
	
	public String getFirstConciseFormulaString() {
		CMLFormula formula = this.getFirstConciseFormula();
		return (formula == null) ? null : formula.getConcise();
	}

	public void addName(String nameString) {
		CMLName name = new CMLName();
		name.setXMLContent(nameString);
		this.addName(name);
	}

	/**
	 *	Calculates the hydrogen count of a molecule. Includes hydrogenCount
	 *  attribute and does not double count bridging hydrogens. 
	 */
	public int calculateHydrogenCount() {
		/* beware bridging hydrogens - simply returning the sum of the atom
		 * hydrogen counts may not work!
		 */
		int totalImplicitHydrogenCount = 0;
		Set <CMLAtom> uniqueHydrogens = new HashSet<CMLAtom>();
		
		for (CMLAtom atom : getAtoms()) {
			int hydrogenCount = atom.getHydrogenCount();
			List <CMLAtom> explicitHydrogens = atom.getLigandHydrogenAtoms();
			int implicitHydrogenCount = hydrogenCount - explicitHydrogens.size();
			if (implicitHydrogenCount > 0) {
				totalImplicitHydrogenCount += implicitHydrogenCount;
			}
			uniqueHydrogens.addAll(explicitHydrogens);
		}
		return totalImplicitHydrogenCount + uniqueHydrogens.size();
	}

	/** makes a new list composed of the molecules in the list
	 * 
	 * @param elements
	 * @return
	 */
	public static List<CMLMolecule> extractMolecules(List<Element> elements) {
		List<CMLMolecule> moleculeList = new ArrayList<CMLMolecule>();
		for (Element element : elements) {
			if (element instanceof CMLMolecule) {
				moleculeList.add((CMLMolecule) element);
			}
		}
		return moleculeList;
	}
	
}
