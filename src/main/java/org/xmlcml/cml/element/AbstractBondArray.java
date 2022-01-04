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
import org.xmlcml.cml.base.CMLAttribute;
import org.xmlcml.cml.base.CMLConstants;
import org.xmlcml.cml.base.CMLElement;
import org.xmlcml.cml.base.CMLElements;
import org.xmlcml.cml.base.StringArraySTAttribute;
import org.xmlcml.cml.base.StringSTAttribute;

// end of part 1
/** CLASS DOCUMENTATION */
public abstract class AbstractBondArray extends CMLElement {
    /** local name*/
    public final static String TAG = "bondArray";
    /** constructor. */    public AbstractBondArray() {
        super("bondArray");
    }
/** copy constructor.
* deep copy using XOM copy()
* @param old element to copy
*/
    public AbstractBondArray(AbstractBondArray old) {
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
            _att_title = (StringSTAttribute) attributeFactory.getAttribute("title", "bondArray");
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
            _att_id = (IdAttribute) attributeFactory.getAttribute("id", "bondArray");
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
            _att_convention = (StringSTAttribute) attributeFactory.getAttribute("convention", "bondArray");
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
            _att_dictref = (DictRefAttribute) attributeFactory.getAttribute("dictRef", "bondArray");
            if (_att_dictref == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : dictRef probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new DictRefAttribute(_att_dictref);
        super.addRemove(att, value);
    }
// attribute:   bondID

    /** cache */
    StringArraySTAttribute _att_bondid = null;
    /** The IDs for an array of bond.
    * No description
    * @return CMLAttribute
    */
    public CMLAttribute getBondIDAttribute() {
        return (CMLAttribute) getAttribute("bondID");
    }
    /** The IDs for an array of bond.
    * No description
    * @return String[]
    */
    public String[] getBondID() {
        StringArraySTAttribute att = (StringArraySTAttribute) this.getBondIDAttribute();
        if (att == null) {
            return null;
        }
        return att.getStringArray();
    }
    /** The IDs for an array of bond.
    * No description
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setBondID(String value) throws RuntimeException {
        StringArraySTAttribute att = null;
        if (_att_bondid == null) {
            _att_bondid = (StringArraySTAttribute) attributeFactory.getAttribute("bondID", "bondArray");
            if (_att_bondid == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : bondID probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringArraySTAttribute(_att_bondid);
        super.addRemove(att, value);
    }
    /** The IDs for an array of bond.
    * No description
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setBondID(String[] value) throws RuntimeException {
        if (_att_bondid == null) {
            _att_bondid = (StringArraySTAttribute) attributeFactory.getAttribute("bondID", "bondArray");
           if (_att_bondid == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : bondID probably incompatible attributeGroupName and attributeName ");
            }
        }
        StringArraySTAttribute att = new StringArraySTAttribute(_att_bondid);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// attribute:   atomRef1

    /** cache */
    StringArraySTAttribute _att_atomref1 = null;
    /** The first atoms in each bond.
    * Currently only used in bondArray in CML2 array mode.
    * @return CMLAttribute
    */
    public CMLAttribute getAtomRef1Attribute() {
        return (CMLAttribute) getAttribute("atomRef1");
    }
    /** The first atoms in each bond.
    * Currently only used in bondArray in CML2 array mode.
    * @return String[]
    */
    public String[] getAtomRef1() {
        StringArraySTAttribute att = (StringArraySTAttribute) this.getAtomRef1Attribute();
        if (att == null) {
            return null;
        }
        return att.getStringArray();
    }
    /** The first atoms in each bond.
    * Currently only used in bondArray in CML2 array mode.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setAtomRef1(String value) throws RuntimeException {
        StringArraySTAttribute att = null;
        if (_att_atomref1 == null) {
            _att_atomref1 = (StringArraySTAttribute) attributeFactory.getAttribute("atomRef1", "bondArray");
            if (_att_atomref1 == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : atomRef1 probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringArraySTAttribute(_att_atomref1);
        super.addRemove(att, value);
    }
    /** The first atoms in each bond.
    * Currently only used in bondArray in CML2 array mode.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setAtomRef1(String[] value) throws RuntimeException {
        if (_att_atomref1 == null) {
            _att_atomref1 = (StringArraySTAttribute) attributeFactory.getAttribute("atomRef1", "bondArray");
           if (_att_atomref1 == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : atomRef1 probably incompatible attributeGroupName and attributeName ");
            }
        }
        StringArraySTAttribute att = new StringArraySTAttribute(_att_atomref1);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// attribute:   atomRef2

    /** cache */
    StringArraySTAttribute _att_atomref2 = null;
    /** The second atoms in each bond.
    * No description
    * @return CMLAttribute
    */
    public CMLAttribute getAtomRef2Attribute() {
        return (CMLAttribute) getAttribute("atomRef2");
    }
    /** The second atoms in each bond.
    * No description
    * @return String[]
    */
    public String[] getAtomRef2() {
        StringArraySTAttribute att = (StringArraySTAttribute) this.getAtomRef2Attribute();
        if (att == null) {
            return null;
        }
        return att.getStringArray();
    }
    /** The second atoms in each bond.
    * No description
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setAtomRef2(String value) throws RuntimeException {
        StringArraySTAttribute att = null;
        if (_att_atomref2 == null) {
            _att_atomref2 = (StringArraySTAttribute) attributeFactory.getAttribute("atomRef2", "bondArray");
            if (_att_atomref2 == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : atomRef2 probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringArraySTAttribute(_att_atomref2);
        super.addRemove(att, value);
    }
    /** The second atoms in each bond.
    * No description
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setAtomRef2(String[] value) throws RuntimeException {
        if (_att_atomref2 == null) {
            _att_atomref2 = (StringArraySTAttribute) attributeFactory.getAttribute("atomRef2", "bondArray");
           if (_att_atomref2 == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : atomRef2 probably incompatible attributeGroupName and attributeName ");
            }
        }
        StringArraySTAttribute att = new StringArraySTAttribute(_att_atomref2);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// attribute:   order

    /** cache */
    StringArraySTAttribute _att_order = null;
    /** The order of the bond.
    * There is NO default. This order is for bookkeeping only and is not related to length, QM calculations or other experimental or theoretical calculations.
    * @return CMLAttribute
    */
    public CMLAttribute getOrderAttribute() {
        return (CMLAttribute) getAttribute("order");
    }
    /** The order of the bond.
    * There is NO default. This order is for bookkeeping only and is not related to length, QM calculations or other experimental or theoretical calculations.
    * @return String[]
    */
    public String[] getOrder() {
        StringArraySTAttribute att = (StringArraySTAttribute) this.getOrderAttribute();
        if (att == null) {
            return null;
        }
        return att.getStringArray();
    }
    /** The order of the bond.
    * There is NO default. This order is for bookkeeping only and is not related to length, QM calculations or other experimental or theoretical calculations.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setOrder(String value) throws RuntimeException {
        StringArraySTAttribute att = null;
        if (_att_order == null) {
            _att_order = (StringArraySTAttribute) attributeFactory.getAttribute("order", "bondArray");
            if (_att_order == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : order probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringArraySTAttribute(_att_order);
        super.addRemove(att, value);
    }
    /** The order of the bond.
    * There is NO default. This order is for bookkeeping only and is not related to length, QM calculations or other experimental or theoretical calculations.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setOrder(String[] value) throws RuntimeException {
        if (_att_order == null) {
            _att_order = (StringArraySTAttribute) attributeFactory.getAttribute("order", "bondArray");
           if (_att_order == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : order probably incompatible attributeGroupName and attributeName ");
            }
        }
        StringArraySTAttribute att = new StringArraySTAttribute(_att_order);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// element:   bond

    /** The order of the bond.
    * There is NO default. This order is for bookkeeping only and is not related to length, QM calculations or other experimental or theoretical calculations.
    * @param bond child to add
    */
    public void addBond(AbstractBond bond) {
        bond.detach();
        this.appendChild(bond);
    }
    /** The order of the bond.
    * There is NO default. This order is for bookkeeping only and is not related to length, QM calculations or other experimental or theoretical calculations.
    * @return CMLElements&lt;CMLBond&gt;
    */
    public CMLElements<CMLBond> getBondElements() {
        Elements elements = this.getChildElements("bond", CMLConstants.CML_NS);
        return new CMLElements<CMLBond>(elements);
    }
// element:   array

    /** The order of the bond.
    * There is NO default. This order is for bookkeeping only and is not related to length, QM calculations or other experimental or theoretical calculations.
    * @param array child to add
    */
    public void addArray(AbstractArray array) {
        array.detach();
        this.appendChild(array);
    }
    /** The order of the bond.
    * There is NO default. This order is for bookkeeping only and is not related to length, QM calculations or other experimental or theoretical calculations.
    * @return CMLElements&lt;CMLArray&gt;
    */
    public CMLElements<CMLArray> getArrayElements() {
        Elements elements = this.getChildElements("array", CMLConstants.CML_NS);
        return new CMLElements<CMLArray>(elements);
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
        } else if (name.equals("bondID")) {
            setBondID(value);
        } else if (name.equals("atomRef1")) {
            setAtomRef1(value);
        } else if (name.equals("atomRef2")) {
            setAtomRef2(value);
        } else if (name.equals("order")) {
            setOrder(value);
	     } else {
            super.addAttribute(att);
        }
    }
}
