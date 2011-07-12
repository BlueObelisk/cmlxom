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

import org.xmlcml.cml.attribute.DictRefAttribute;
import org.xmlcml.cml.attribute.IdAttribute;
import org.xmlcml.cml.attribute.RefAttribute;
import org.xmlcml.cml.base.CMLAttribute;
import org.xmlcml.cml.base.CMLElement;
import org.xmlcml.cml.base.DoubleSTAttribute;
import org.xmlcml.cml.base.StringArraySTAttribute;
import org.xmlcml.cml.base.StringSTAttribute;

// end of part 1
/** CLASS DOCUMENTATION */
public abstract class AbstractElectron extends CMLElement {
    /** local name*/
    public final static String TAG = "electron";
    /** constructor. */    public AbstractElectron() {
        super("electron");
    }
/** copy constructor.
* deep copy using XOM copy()
* @param old element to copy
*/
    public AbstractElectron(AbstractElectron old) {
        super((CMLElement) old);
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
            _att_title = (StringSTAttribute) attributeFactory.getAttribute("title", "electron");
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
            _att_id = (IdAttribute) attributeFactory.getAttribute("id", "electron");
            if (_att_id == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : id probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new IdAttribute(_att_id);
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
            _att_convention = (StringSTAttribute) attributeFactory.getAttribute("convention", "electron");
            if (_att_convention == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : convention probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_convention);
        super.addRemove(att, value);
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
            _att_dictref = (DictRefAttribute) attributeFactory.getAttribute("dictRef", "electron");
            if (_att_dictref == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : dictRef probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new DictRefAttribute(_att_dictref);
        super.addRemove(att, value);
    }
// attribute:   atomRef

    /** cache */
    StringSTAttribute _att_atomref = null;
    /** A reference to an atom.
    * Used by bond, electron, etc.
    * @return CMLAttribute
    */
    public CMLAttribute getAtomRefAttribute() {
        return (CMLAttribute) getAttribute("atomRef");
    }
    /** A reference to an atom.
    * Used by bond, electron, etc.
    * @return String
    */
    public String getAtomRef() {
        StringSTAttribute att = (StringSTAttribute) this.getAtomRefAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** A reference to an atom.
    * Used by bond, electron, etc.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setAtomRef(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_atomref == null) {
            _att_atomref = (StringSTAttribute) attributeFactory.getAttribute("atomRef", "electron");
            if (_att_atomref == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : atomRef probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_atomref);
        super.addRemove(att, value);
    }
// attribute:   atomRefs

    /** cache */
    StringArraySTAttribute _att_atomrefs = null;
    /** A reference to a list of atoms.
    * Used by bonds, electrons, atomSets, etc.
    * @return CMLAttribute
    */
    public CMLAttribute getAtomRefsAttribute() {
        return (CMLAttribute) getAttribute("atomRefs");
    }
    /** A reference to a list of atoms.
    * Used by bonds, electrons, atomSets, etc.
    * @return String[]
    */
    public String[] getAtomRefs() {
        StringArraySTAttribute att = (StringArraySTAttribute) this.getAtomRefsAttribute();
        if (att == null) {
            return null;
        }
        return att.getStringArray();
    }
    /** A reference to a list of atoms.
    * Used by bonds, electrons, atomSets, etc.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setAtomRefs(String value) throws RuntimeException {
        StringArraySTAttribute att = null;
        if (_att_atomrefs == null) {
            _att_atomrefs = (StringArraySTAttribute) attributeFactory.getAttribute("atomRefs", "electron");
            if (_att_atomrefs == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : atomRefs probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringArraySTAttribute(_att_atomrefs);
        super.addRemove(att, value);
    }
    /** A reference to a list of atoms.
    * Used by bonds, electrons, atomSets, etc.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setAtomRefs(String[] value) throws RuntimeException {
        if (_att_atomrefs == null) {
            _att_atomrefs = (StringArraySTAttribute) attributeFactory.getAttribute("atomRefs", "electron");
           if (_att_atomrefs == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : atomRefs probably incompatible attributeGroupName and attributeName ");
            }
        }
        StringArraySTAttribute att = new StringArraySTAttribute(_att_atomrefs);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// attribute:   bondRef

    /** cache */
    StringSTAttribute _att_bondref = null;
    /** A reference to a bond.
    * used by electron, etc.
    * @return CMLAttribute
    */
    public CMLAttribute getBondRefAttribute() {
        return (CMLAttribute) getAttribute("bondRef");
    }
    /** A reference to a bond.
    * used by electron, etc.
    * @return String
    */
    public String getBondRef() {
        StringSTAttribute att = (StringSTAttribute) this.getBondRefAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** A reference to a bond.
    * used by electron, etc.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setBondRef(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_bondref == null) {
            _att_bondref = (StringSTAttribute) attributeFactory.getAttribute("bondRef", "electron");
            if (_att_bondref == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : bondRef probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_bondref);
        super.addRemove(att, value);
    }
// attribute:   bondRefs

    /** cache */
    StringArraySTAttribute _att_bondrefs = null;
    /** A reference to a list of bonds.
    * Used by electrons, bondSets, etc.
    * @return CMLAttribute
    */
    public CMLAttribute getBondRefsAttribute() {
        return (CMLAttribute) getAttribute("bondRefs");
    }
    /** A reference to a list of bonds.
    * Used by electrons, bondSets, etc.
    * @return String[]
    */
    public String[] getBondRefs() {
        StringArraySTAttribute att = (StringArraySTAttribute) this.getBondRefsAttribute();
        if (att == null) {
            return null;
        }
        return att.getStringArray();
    }
    /** A reference to a list of bonds.
    * Used by electrons, bondSets, etc.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setBondRefs(String value) throws RuntimeException {
        StringArraySTAttribute att = null;
        if (_att_bondrefs == null) {
            _att_bondrefs = (StringArraySTAttribute) attributeFactory.getAttribute("bondRefs", "electron");
            if (_att_bondrefs == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : bondRefs probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringArraySTAttribute(_att_bondrefs);
        super.addRemove(att, value);
    }
    /** A reference to a list of bonds.
    * Used by electrons, bondSets, etc.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setBondRefs(String[] value) throws RuntimeException {
        if (_att_bondrefs == null) {
            _att_bondrefs = (StringArraySTAttribute) attributeFactory.getAttribute("bondRefs", "electron");
           if (_att_bondrefs == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : bondRefs probably incompatible attributeGroupName and attributeName ");
            }
        }
        StringArraySTAttribute att = new StringArraySTAttribute(_att_bondrefs);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// attribute:   count

    /** cache */
    DoubleSTAttribute _att_count = null;
    /** The count of the object.
    * No fixed semantics or default, normally integers. 
    *                 It is presumed that the element can be multiplied by the count value.
    * @return CMLAttribute
    */
    public CMLAttribute getCountAttribute() {
        return (CMLAttribute) getAttribute("count");
    }
    /** The count of the object.
    * No fixed semantics or default, normally integers. 
    *                 It is presumed that the element can be multiplied by the count value.
    * @return double
    */
    public double getCount() {
        DoubleSTAttribute att = (DoubleSTAttribute) this.getCountAttribute();
        if (att == null) {
            return Double.NaN;
        }
        return att.getDouble();
    }
    /** The count of the object.
    * No fixed semantics or default, normally integers. 
    *                 It is presumed that the element can be multiplied by the count value.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setCount(String value) throws RuntimeException {
        DoubleSTAttribute att = null;
        if (_att_count == null) {
            _att_count = (DoubleSTAttribute) attributeFactory.getAttribute("count", "electron");
            if (_att_count == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : count probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new DoubleSTAttribute(_att_count);
        super.addRemove(att, value);
    }
    /** The count of the object.
    * No fixed semantics or default, normally integers. 
    *                 It is presumed that the element can be multiplied by the count value.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setCount(double value) throws RuntimeException {
        if (_att_count == null) {
            _att_count = (DoubleSTAttribute) attributeFactory.getAttribute("count", "electron");
           if (_att_count == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : count probably incompatible attributeGroupName and attributeName ");
            }
        }
        DoubleSTAttribute att = new DoubleSTAttribute(_att_count);
        super.addAttribute(att);
        att.setCMLValue(value);
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
            _att_ref = (RefAttribute) attributeFactory.getAttribute("ref", "electron");
            if (_att_ref == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : ref probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new RefAttribute(_att_ref);
        super.addRemove(att, value);
    }
    /** overrides addAttribute(Attribute)
     * reroutes calls to setFoo()
     * @param att  attribute
    */
    public void addAttribute(Attribute att) {
        String name = att.getLocalName();
        String value = att.getValue();
        if (name == null) {
        } else if (name.equals("title")) {
            setTitle(value);
        } else if (name.equals("id")) {
            setId(value);
        } else if (name.equals("convention")) {
            setConvention(value);
        } else if (name.equals("dictRef")) {
            setDictRef(value);
        } else if (name.equals("atomRef")) {
            setAtomRef(value);
        } else if (name.equals("atomRefs")) {
            setAtomRefs(value);
        } else if (name.equals("bondRef")) {
            setBondRef(value);
        } else if (name.equals("bondRefs")) {
            setBondRefs(value);
        } else if (name.equals("count")) {
            setCount(value);
        } else if (name.equals("ref")) {
            setRef(value);
	     } else {
            super.addAttribute(att);
        }
    }
}
