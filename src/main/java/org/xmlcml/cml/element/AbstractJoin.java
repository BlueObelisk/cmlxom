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


import nu.xom.Attribute;
import nu.xom.Elements;

import org.xmlcml.cml.attribute.DictRefAttribute;
import org.xmlcml.cml.attribute.IdAttribute;
import org.xmlcml.cml.attribute.RefAttribute;
import org.xmlcml.cml.base.CMLAttribute;
import org.xmlcml.cml.base.CMLConstants;
import org.xmlcml.cml.base.CMLElement;
import org.xmlcml.cml.base.CMLElements;
import org.xmlcml.cml.base.StringArraySTAttribute;
import org.xmlcml.cml.base.StringSTAttribute;

// end of part 1
/** CLASS DOCUMENTATION */
public abstract class AbstractJoin extends CMLElement {
    /** local name*/
    public final static String TAG = "join";
    /** constructor. */    public AbstractJoin() {
        super("join");
    }
/** copy constructor.
* deep copy using XOM copy()
* @param old element to copy
*/
    public AbstractJoin(AbstractJoin old) {
        super((CMLElement) old);
    }
// attribute:   dictRef

    /** cache */
    DictRefAttribute _att_dictref = null;
    /** null
    * @return CMLAttribute
    */
    public CMLAttribute getDictRefAttribute() {
        return (CMLAttribute) getAttribute("dictRef");
    }
    /** null
    * @return String
    */
    public String getDictRef() {
        DictRefAttribute att = (DictRefAttribute) this.getDictRefAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** null
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setDictRef(String value) throws RuntimeException {
        DictRefAttribute att = null;
        if (_att_dictref == null) {
            _att_dictref = (DictRefAttribute) attributeFactory.getAttribute("dictRef", "join");
            if (_att_dictref == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : dictRef probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new DictRefAttribute(_att_dictref);
        super.addRemove(att, value);
    }
// attribute:   convention

    /** cache */
    StringSTAttribute _att_convention = null;
    /** A reference to a convention.
    * There is no controlled vocabulary for conventions, but the author must ensure that the semantics are openly available and that there are mechanisms for implementation. The convention is inherited by all the subelements, 
    * so that a convention for molecule would by default extend to its bond and atom children. This can be overwritten
    *     if necessary by an explicit convention.
    *                     It may be useful to create conventions with namespaces (e.g. iupac:name).
    *     Use of convention will normally require non-STMML semantics, and should be used with
    *     caution. We would expect that conventions prefixed with "ISO" would be useful,
    *     such as ISO8601 for dateTimes.
    *                     There is no default, but the conventions of STMML or the related language (e.g. CML) will be assumed.
    * @return CMLAttribute
    */
    public CMLAttribute getConventionAttribute() {
        return (CMLAttribute) getAttribute("convention");
    }
    /** A reference to a convention.
    * There is no controlled vocabulary for conventions, but the author must ensure that the semantics are openly available and that there are mechanisms for implementation. The convention is inherited by all the subelements, 
    * so that a convention for molecule would by default extend to its bond and atom children. This can be overwritten
    *     if necessary by an explicit convention.
    *                     It may be useful to create conventions with namespaces (e.g. iupac:name).
    *     Use of convention will normally require non-STMML semantics, and should be used with
    *     caution. We would expect that conventions prefixed with "ISO" would be useful,
    *     such as ISO8601 for dateTimes.
    *                     There is no default, but the conventions of STMML or the related language (e.g. CML) will be assumed.
    * @return String
    */
    public String getConvention() {
        StringSTAttribute att = (StringSTAttribute) this.getConventionAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** A reference to a convention.
    * There is no controlled vocabulary for conventions, but the author must ensure that the semantics are openly available and that there are mechanisms for implementation. The convention is inherited by all the subelements, 
    * so that a convention for molecule would by default extend to its bond and atom children. This can be overwritten
    *     if necessary by an explicit convention.
    *                     It may be useful to create conventions with namespaces (e.g. iupac:name).
    *     Use of convention will normally require non-STMML semantics, and should be used with
    *     caution. We would expect that conventions prefixed with "ISO" would be useful,
    *     such as ISO8601 for dateTimes.
    *                     There is no default, but the conventions of STMML or the related language (e.g. CML) will be assumed.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setConvention(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_convention == null) {
            _att_convention = (StringSTAttribute) attributeFactory.getAttribute("convention", "join");
            if (_att_convention == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : convention probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_convention);
        super.addRemove(att, value);
    }
// attribute:   title

    /** cache */
    StringSTAttribute _att_title = null;
    /** A title on an element.
    * No controlled value.
    * @return CMLAttribute
    */
    public CMLAttribute getTitleAttribute() {
        return (CMLAttribute) getAttribute("title");
    }
    /** A title on an element.
    * No controlled value.
    * @return String
    */
    public String getTitle() {
        StringSTAttribute att = (StringSTAttribute) this.getTitleAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** A title on an element.
    * No controlled value.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setTitle(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_title == null) {
            _att_title = (StringSTAttribute) attributeFactory.getAttribute("title", "join");
            if (_att_title == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : title probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_title);
        super.addRemove(att, value);
    }
// attribute:   id

    /** cache */
    IdAttribute _att_id = null;
    /** null
    * @return CMLAttribute
    */
    public CMLAttribute getIdAttribute() {
        return (CMLAttribute) getAttribute("id");
    }
    /** null
    * @return String
    */
    public String getId() {
        IdAttribute att = (IdAttribute) this.getIdAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** null
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setId(String value) throws RuntimeException {
        IdAttribute att = null;
        if (_att_id == null) {
            _att_id = (IdAttribute) attributeFactory.getAttribute("id", "join");
            if (_att_id == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : id probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new IdAttribute(_att_id);
        super.addRemove(att, value);
    }
// attribute:   ref

    /** cache */
    RefAttribute _att_ref = null;
    /** null
    * @return CMLAttribute
    */
    public CMLAttribute getRefAttribute() {
        return (CMLAttribute) getAttribute("ref");
    }
    /** null
    * @return String
    */
    public String getRef() {
        RefAttribute att = (RefAttribute) this.getRefAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** null
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setRef(String value) throws RuntimeException {
        RefAttribute att = null;
        if (_att_ref == null) {
            _att_ref = (RefAttribute) attributeFactory.getAttribute("ref", "join");
            if (_att_ref == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : ref probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new RefAttribute(_att_ref);
        super.addRemove(att, value);
    }
// attribute:   atomRefs2

    /** cache */
    StringArraySTAttribute _att_atomrefs2 = null;
    /** References to two different atoms.
    * Available for any reference to atoms but normally will be the normal reference attribute on the bond element. The order of atoms is preserved and may matter for some conventions (e.g. wedge/hatch or donor bonds.
    * @return CMLAttribute
    */
    public CMLAttribute getAtomRefs2Attribute() {
        return (CMLAttribute) getAttribute("atomRefs2");
    }
    /** References to two different atoms.
    * Available for any reference to atoms but normally will be the normal reference attribute on the bond element. The order of atoms is preserved and may matter for some conventions (e.g. wedge/hatch or donor bonds.
    * @return String[]
    */
    public String[] getAtomRefs2() {
        StringArraySTAttribute att = (StringArraySTAttribute) this.getAtomRefs2Attribute();
        if (att == null) {
            return null;
        }
        return att.getStringArray();
    }
    /** References to two different atoms.
    * Available for any reference to atoms but normally will be the normal reference attribute on the bond element. The order of atoms is preserved and may matter for some conventions (e.g. wedge/hatch or donor bonds.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setAtomRefs2(String value) throws RuntimeException {
        StringArraySTAttribute att = null;
        if (_att_atomrefs2 == null) {
            _att_atomrefs2 = (StringArraySTAttribute) attributeFactory.getAttribute("atomRefs2", "join");
            if (_att_atomrefs2 == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : atomRefs2 probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringArraySTAttribute(_att_atomrefs2);
        super.addRemove(att, value);
    }
    /** References to two different atoms.
    * Available for any reference to atoms but normally will be the normal reference attribute on the bond element. The order of atoms is preserved and may matter for some conventions (e.g. wedge/hatch or donor bonds.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setAtomRefs2(String[] value) throws RuntimeException {
        if (_att_atomrefs2 == null) {
            _att_atomrefs2 = (StringArraySTAttribute) attributeFactory.getAttribute("atomRefs2", "join");
           if (_att_atomrefs2 == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : atomRefs2 probably incompatible attributeGroupName and attributeName ");
            }
        }
        StringArraySTAttribute att = new StringArraySTAttribute(_att_atomrefs2);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// attribute:   moleculeRefs2

    /** cache */
    StringArraySTAttribute _att_moleculerefs2 = null;
    /** References to two different molecules.
    * Available for any reference to molecules but 
    *                 normally will be the normal reference attribute on the join element. 
    *                 The order of molecules is preserved and may matter.
    * @return CMLAttribute
    */
    public CMLAttribute getMoleculeRefs2Attribute() {
        return (CMLAttribute) getAttribute("moleculeRefs2");
    }
    /** References to two different molecules.
    * Available for any reference to molecules but 
    *                 normally will be the normal reference attribute on the join element. 
    *                 The order of molecules is preserved and may matter.
    * @return String[]
    */
    public String[] getMoleculeRefs2() {
        StringArraySTAttribute att = (StringArraySTAttribute) this.getMoleculeRefs2Attribute();
        if (att == null) {
            return null;
        }
        return att.getStringArray();
    }
    /** References to two different molecules.
    * Available for any reference to molecules but 
    *                 normally will be the normal reference attribute on the join element. 
    *                 The order of molecules is preserved and may matter.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setMoleculeRefs2(String value) throws RuntimeException {
        StringArraySTAttribute att = null;
        if (_att_moleculerefs2 == null) {
            _att_moleculerefs2 = (StringArraySTAttribute) attributeFactory.getAttribute("moleculeRefs2", "join");
            if (_att_moleculerefs2 == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : moleculeRefs2 probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringArraySTAttribute(_att_moleculerefs2);
        super.addRemove(att, value);
    }
    /** References to two different molecules.
    * Available for any reference to molecules but 
    *                 normally will be the normal reference attribute on the join element. 
    *                 The order of molecules is preserved and may matter.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setMoleculeRefs2(String[] value) throws RuntimeException {
        if (_att_moleculerefs2 == null) {
            _att_moleculerefs2 = (StringArraySTAttribute) attributeFactory.getAttribute("moleculeRefs2", "join");
           if (_att_moleculerefs2 == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : moleculeRefs2 probably incompatible attributeGroupName and attributeName ");
            }
        }
        StringArraySTAttribute att = new StringArraySTAttribute(_att_moleculerefs2);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// attribute:   order

    /** cache */
    StringSTAttribute _att_order = null;
    /** The order of the bond.
    * There is NO default. This order is for bookkeeping only and is not related to length, QM calculations or other experimental or theoretical calculations.
    * @return CMLAttribute
    */
    public CMLAttribute getOrderAttribute() {
        return (CMLAttribute) getAttribute("order");
    }
    /** The order of the bond.
    * There is NO default. This order is for bookkeeping only and is not related to length, QM calculations or other experimental or theoretical calculations.
    * @return String
    */
    public String getOrder() {
        StringSTAttribute att = (StringSTAttribute) this.getOrderAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** The order of the bond.
    * There is NO default. This order is for bookkeeping only and is not related to length, QM calculations or other experimental or theoretical calculations.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setOrder(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_order == null) {
            _att_order = (StringSTAttribute) attributeFactory.getAttribute("order", "join");
            if (_att_order == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : order probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_order);
        super.addRemove(att, value);
    }
// element:   angle

    /** The order of the bond.
    * There is NO default. This order is for bookkeeping only and is not related to length, QM calculations or other experimental or theoretical calculations.
    * @param angle child to add
    */
    public void addAngle(AbstractAngle angle) {
        angle.detach();
        this.appendChild(angle);
    }
    /** The order of the bond.
    * There is NO default. This order is for bookkeeping only and is not related to length, QM calculations or other experimental or theoretical calculations.
    * @return CMLElements<CMLAngle>
    */
    public CMLElements<CMLAngle> getAngleElements() {
        Elements elements = this.getChildElements("angle", CMLConstants.CML_NS);
        return new CMLElements<CMLAngle>(elements);
    }
// element:   arg

    /** The order of the bond.
    * There is NO default. This order is for bookkeeping only and is not related to length, QM calculations or other experimental or theoretical calculations.
    * @param arg child to add
    */
    public void addArg(AbstractArg arg) {
        arg.detach();
        this.appendChild(arg);
    }
    /** The order of the bond.
    * There is NO default. This order is for bookkeeping only and is not related to length, QM calculations or other experimental or theoretical calculations.
    * @return CMLElements<CMLArg>
    */
    public CMLElements<CMLArg> getArgElements() {
        Elements elements = this.getChildElements("arg", CMLConstants.CML_NS);
        return new CMLElements<CMLArg>(elements);
    }
// element:   label

    /** The order of the bond.
    * There is NO default. This order is for bookkeeping only and is not related to length, QM calculations or other experimental or theoretical calculations.
    * @param label child to add
    */
    public void addLabel(AbstractLabel label) {
        label.detach();
        this.appendChild(label);
    }
    /** The order of the bond.
    * There is NO default. This order is for bookkeeping only and is not related to length, QM calculations or other experimental or theoretical calculations.
    * @return CMLElements<CMLLabel>
    */
    public CMLElements<CMLLabel> getLabelElements() {
        Elements elements = this.getChildElements("label", CMLConstants.CML_NS);
        return new CMLElements<CMLLabel>(elements);
    }
// element:   length

    /** The order of the bond.
    * There is NO default. This order is for bookkeeping only and is not related to length, QM calculations or other experimental or theoretical calculations.
    * @param length child to add
    */
    public void addLength(AbstractLength length) {
        length.detach();
        this.appendChild(length);
    }
    /** The order of the bond.
    * There is NO default. This order is for bookkeeping only and is not related to length, QM calculations or other experimental or theoretical calculations.
    * @return CMLElements<CMLLength>
    */
    public CMLElements<CMLLength> getLengthElements() {
        Elements elements = this.getChildElements("length", CMLConstants.CML_NS);
        return new CMLElements<CMLLength>(elements);
    }
// element:   metadataList

    /** The order of the bond.
    * There is NO default. This order is for bookkeeping only and is not related to length, QM calculations or other experimental or theoretical calculations.
    * @param metadataList child to add
    */
    public void addMetadataList(AbstractMetadataList metadataList) {
        metadataList.detach();
        this.appendChild(metadataList);
    }
    /** The order of the bond.
    * There is NO default. This order is for bookkeeping only and is not related to length, QM calculations or other experimental or theoretical calculations.
    * @return CMLElements<CMLMetadataList>
    */
    public CMLElements<CMLMetadataList> getMetadataListElements() {
        Elements elements = this.getChildElements("metadataList", CMLConstants.CML_NS);
        return new CMLElements<CMLMetadataList>(elements);
    }
// element:   molecule

    /** The order of the bond.
    * There is NO default. This order is for bookkeeping only and is not related to length, QM calculations or other experimental or theoretical calculations.
    * @param molecule child to add
    */
    public void addMolecule(AbstractMolecule molecule) {
        molecule.detach();
        this.appendChild(molecule);
    }
    /** The order of the bond.
    * There is NO default. This order is for bookkeeping only and is not related to length, QM calculations or other experimental or theoretical calculations.
    * @return CMLElements<CMLMolecule>
    */
    public CMLElements<CMLMolecule> getMoleculeElements() {
        Elements elements = this.getChildElements("molecule", CMLConstants.CML_NS);
        return new CMLElements<CMLMolecule>(elements);
    }
// element:   torsion

    /** The order of the bond.
    * There is NO default. This order is for bookkeeping only and is not related to length, QM calculations or other experimental or theoretical calculations.
    * @param torsion child to add
    */
    public void addTorsion(AbstractTorsion torsion) {
        torsion.detach();
        this.appendChild(torsion);
    }
    /** The order of the bond.
    * There is NO default. This order is for bookkeeping only and is not related to length, QM calculations or other experimental or theoretical calculations.
    * @return CMLElements<CMLTorsion>
    */
    public CMLElements<CMLTorsion> getTorsionElements() {
        Elements elements = this.getChildElements("torsion", CMLConstants.CML_NS);
        return new CMLElements<CMLTorsion>(elements);
    }
    /** overrides addAttribute(Attribute)
     * reroutes calls to setFoo()
     * @param att  attribute
    */
    public void addAttribute(Attribute att) {
        String name = att.getLocalName();
        String value = att.getValue();
        if (name == null) {
        } else if (name.equals("dictRef")) {
            setDictRef(value);
        } else if (name.equals("convention")) {
            setConvention(value);
        } else if (name.equals("title")) {
            setTitle(value);
        } else if (name.equals("id")) {
            setId(value);
        } else if (name.equals("ref")) {
            setRef(value);
        } else if (name.equals("atomRefs2")) {
            setAtomRefs2(value);
        } else if (name.equals("moleculeRefs2")) {
            setMoleculeRefs2(value);
        } else if (name.equals("order")) {
            setOrder(value);
	     } else {
            super.addAttribute(att);
        }
    }
}
