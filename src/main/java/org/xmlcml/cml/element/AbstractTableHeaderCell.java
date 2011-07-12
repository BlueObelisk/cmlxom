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
import org.xmlcml.cml.attribute.NamespaceRefAttribute;
import org.xmlcml.cml.attribute.UnitsAttribute;
import org.xmlcml.cml.base.CMLAttribute;
import org.xmlcml.cml.base.CMLElement;
import org.xmlcml.cml.base.DoubleSTAttribute;
import org.xmlcml.cml.base.StringSTAttribute;

// end of part 1
/** CLASS DOCUMENTATION */
public abstract class AbstractTableHeaderCell extends CMLElement {
    /** local name*/
    public final static String TAG = "tableHeaderCell";
    /** constructor. */    public AbstractTableHeaderCell() {
        super("tableHeaderCell");
    }
/** copy constructor.
* deep copy using XOM copy()
* @param old element to copy
*/
    public AbstractTableHeaderCell(AbstractTableHeaderCell old) {
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
            _att_title = (StringSTAttribute) attributeFactory.getAttribute("title", "tableHeaderCell");
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
            _att_id = (IdAttribute) attributeFactory.getAttribute("id", "tableHeaderCell");
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
            _att_convention = (StringSTAttribute) attributeFactory.getAttribute("convention", "tableHeaderCell");
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
            _att_dictref = (DictRefAttribute) attributeFactory.getAttribute("dictRef", "tableHeaderCell");
            if (_att_dictref == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : dictRef probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new DictRefAttribute(_att_dictref);
        super.addRemove(att, value);
    }
// attribute:   dataType

    /** cache */
    StringSTAttribute _att_datatype = null;
    /** The data type of the object.
    * Normally applied to scalar/array 
    *                 objects but may extend to more complex one.
    * @return CMLAttribute
    */
    public CMLAttribute getDataTypeAttribute() {
        return (CMLAttribute) getAttribute("dataType");
    }
    /** The data type of the object.
    * Normally applied to scalar/array 
    *                 objects but may extend to more complex one.
    * @return String
    */
    public String getDataType() {
        StringSTAttribute att = (StringSTAttribute) this.getDataTypeAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** The data type of the object.
    * Normally applied to scalar/array 
    *                 objects but may extend to more complex one.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setDataType(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_datatype == null) {
            _att_datatype = (StringSTAttribute) attributeFactory.getAttribute("dataType", "tableHeaderCell");
            if (_att_datatype == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : dataType probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_datatype);
        super.addRemove(att, value);
    }
// attribute:   units

    /** cache */
    UnitsAttribute _att_units = null;
    /** null
    * @return CMLAttribute
    */
    public CMLAttribute getUnitsAttribute() {
        return (CMLAttribute) getAttribute("units");
    }
    /** null
    * @return String
    */
    public String getUnits() {
        UnitsAttribute att = (UnitsAttribute) this.getUnitsAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** null
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setUnits(String value) throws RuntimeException {
        UnitsAttribute att = null;
        if (_att_units == null) {
            _att_units = (UnitsAttribute) attributeFactory.getAttribute("units", "tableHeaderCell");
            if (_att_units == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : units probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new UnitsAttribute(_att_units);
        super.addRemove(att, value);
    }
// attribute:   constantToSI

    /** cache */
    DoubleSTAttribute _att_constanttosi = null;
    /** Additive constant to generate SI equivalent.
    * The amount to add to a quantity in non-SI units to convert its representation to SI Units. This is applied *after* multiplierToSI. It is necessarily zero for SI units.
    * @return CMLAttribute
    */
    public CMLAttribute getConstantToSIAttribute() {
        return (CMLAttribute) getAttribute("constantToSI");
    }
    /** Additive constant to generate SI equivalent.
    * The amount to add to a quantity in non-SI units to convert its representation to SI Units. This is applied *after* multiplierToSI. It is necessarily zero for SI units.
    * @return double
    */
    public double getConstantToSI() {
        DoubleSTAttribute att = (DoubleSTAttribute) this.getConstantToSIAttribute();
        if (att == null) {
            return Double.NaN;
        }
        return att.getDouble();
    }
    /** Additive constant to generate SI equivalent.
    * The amount to add to a quantity in non-SI units to convert its representation to SI Units. This is applied *after* multiplierToSI. It is necessarily zero for SI units.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setConstantToSI(String value) throws RuntimeException {
        DoubleSTAttribute att = null;
        if (_att_constanttosi == null) {
            _att_constanttosi = (DoubleSTAttribute) attributeFactory.getAttribute("constantToSI", "tableHeaderCell");
            if (_att_constanttosi == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : constantToSI probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new DoubleSTAttribute(_att_constanttosi);
        super.addRemove(att, value);
    }
    /** Additive constant to generate SI equivalent.
    * The amount to add to a quantity in non-SI units to convert its representation to SI Units. This is applied *after* multiplierToSI. It is necessarily zero for SI units.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setConstantToSI(double value) throws RuntimeException {
        if (_att_constanttosi == null) {
            _att_constanttosi = (DoubleSTAttribute) attributeFactory.getAttribute("constantToSI", "tableHeaderCell");
           if (_att_constanttosi == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : constantToSI probably incompatible attributeGroupName and attributeName ");
            }
        }
        DoubleSTAttribute att = new DoubleSTAttribute(_att_constanttosi);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// attribute:   multiplierToSI

    /** cache */
    DoubleSTAttribute _att_multipliertosi = null;
    /** Multiplier to generate SI equivalent.
    * The factor by which the non-SI unit should be multiplied to convert a quantity to its representation in SI Units. This is applied *before* _constantToSI_. Necessarily unity for SI unit.
    * @return CMLAttribute
    */
    public CMLAttribute getMultiplierToSIAttribute() {
        return (CMLAttribute) getAttribute("multiplierToSI");
    }
    /** Multiplier to generate SI equivalent.
    * The factor by which the non-SI unit should be multiplied to convert a quantity to its representation in SI Units. This is applied *before* _constantToSI_. Necessarily unity for SI unit.
    * @return double
    */
    public double getMultiplierToSI() {
        DoubleSTAttribute att = (DoubleSTAttribute) this.getMultiplierToSIAttribute();
        if (att == null) {
            return Double.NaN;
        }
        return att.getDouble();
    }
    /** Multiplier to generate SI equivalent.
    * The factor by which the non-SI unit should be multiplied to convert a quantity to its representation in SI Units. This is applied *before* _constantToSI_. Necessarily unity for SI unit.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setMultiplierToSI(String value) throws RuntimeException {
        DoubleSTAttribute att = null;
        if (_att_multipliertosi == null) {
            _att_multipliertosi = (DoubleSTAttribute) attributeFactory.getAttribute("multiplierToSI", "tableHeaderCell");
            if (_att_multipliertosi == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : multiplierToSI probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new DoubleSTAttribute(_att_multipliertosi);
        super.addRemove(att, value);
    }
    /** Multiplier to generate SI equivalent.
    * The factor by which the non-SI unit should be multiplied to convert a quantity to its representation in SI Units. This is applied *before* _constantToSI_. Necessarily unity for SI unit.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setMultiplierToSI(double value) throws RuntimeException {
        if (_att_multipliertosi == null) {
            _att_multipliertosi = (DoubleSTAttribute) attributeFactory.getAttribute("multiplierToSI", "tableHeaderCell");
           if (_att_multipliertosi == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : multiplierToSI probably incompatible attributeGroupName and attributeName ");
            }
        }
        DoubleSTAttribute att = new DoubleSTAttribute(_att_multipliertosi);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// attribute:   unitType

    /** cache */
    NamespaceRefAttribute _att_unittype = null;
    /** null
    * @return CMLAttribute
    */
    public CMLAttribute getUnitTypeAttribute() {
        return (CMLAttribute) getAttribute("unitType");
    }
    /** null
    * @return String
    */
    public String getUnitType() {
        NamespaceRefAttribute att = (NamespaceRefAttribute) this.getUnitTypeAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** null
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setUnitType(String value) throws RuntimeException {
        NamespaceRefAttribute att = null;
        if (_att_unittype == null) {
            _att_unittype = (NamespaceRefAttribute) attributeFactory.getAttribute("unitType", "tableHeaderCell");
            if (_att_unittype == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : unitType probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new NamespaceRefAttribute(_att_unittype);
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
        } else if (name.equals("dataType")) {
            setDataType(value);
        } else if (name.equals("units")) {
            setUnits(value);
        } else if (name.equals("constantToSI")) {
            setConstantToSI(value);
        } else if (name.equals("multiplierToSI")) {
            setMultiplierToSI(value);
        } else if (name.equals("unitType")) {
            setUnitType(value);
	     } else {
            super.addAttribute(att);
        }
    }
}
