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
import org.xmlcml.cml.attribute.UnitsAttribute;
import org.xmlcml.cml.base.CMLAttribute;
import org.xmlcml.cml.base.CMLElement;
import org.xmlcml.cml.base.DoubleSTAttribute;
import org.xmlcml.cml.base.StringArraySTAttribute;
import org.xmlcml.cml.base.StringSTAttribute;

// end of part 1
/** CLASS DOCUMENTATION */
public abstract class AbstractTorsion extends CMLElement {
    /** local name*/
    public final static String TAG = "torsion";
    /** constructor. */    public AbstractTorsion() {
        super("torsion");
    }
/** copy constructor.
* deep copy using XOM copy()
* @param old element to copy
*/
    public AbstractTorsion(AbstractTorsion old) {
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
            _att_title = (StringSTAttribute) attributeFactory.getAttribute("title", "torsion");
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
            _att_id = (IdAttribute) attributeFactory.getAttribute("id", "torsion");
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
            _att_convention = (StringSTAttribute) attributeFactory.getAttribute("convention", "torsion");
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
            _att_dictref = (DictRefAttribute) attributeFactory.getAttribute("dictRef", "torsion");
            if (_att_dictref == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : dictRef probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new DictRefAttribute(_att_dictref);
        super.addRemove(att, value);
    }
// attribute:   atomRefs4

    /** cache */
    StringArraySTAttribute _att_atomrefs4 = null;
    /** A list of 4 references to atoms.
    * Typically used for defining torsions and atomParities, 
    *         but could also be used to define a four-centre bond.
    * @return CMLAttribute
    */
    public CMLAttribute getAtomRefs4Attribute() {
        return (CMLAttribute) getAttribute("atomRefs4");
    }
    /** A list of 4 references to atoms.
    * Typically used for defining torsions and atomParities, 
    *         but could also be used to define a four-centre bond.
    * @return String[]
    */
    public String[] getAtomRefs4() {
        StringArraySTAttribute att = (StringArraySTAttribute) this.getAtomRefs4Attribute();
        if (att == null) {
            return null;
        }
        return att.getStringArray();
    }
    /** A list of 4 references to atoms.
    * Typically used for defining torsions and atomParities, 
    *         but could also be used to define a four-centre bond.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setAtomRefs4(String value) throws RuntimeException {
        StringArraySTAttribute att = null;
        if (_att_atomrefs4 == null) {
            _att_atomrefs4 = (StringArraySTAttribute) attributeFactory.getAttribute("atomRefs4", "torsion");
            if (_att_atomrefs4 == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : atomRefs4 probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringArraySTAttribute(_att_atomrefs4);
        super.addRemove(att, value);
    }
    /** A list of 4 references to atoms.
    * Typically used for defining torsions and atomParities, 
    *         but could also be used to define a four-centre bond.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setAtomRefs4(String[] value) throws RuntimeException {
        if (_att_atomrefs4 == null) {
            _att_atomrefs4 = (StringArraySTAttribute) attributeFactory.getAttribute("atomRefs4", "torsion");
           if (_att_atomrefs4 == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : atomRefs4 probably incompatible attributeGroupName and attributeName ");
            }
        }
        StringArraySTAttribute att = new StringArraySTAttribute(_att_atomrefs4);
        super.addAttribute(att);
        att.setCMLValue(value);
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
            _att_units = (UnitsAttribute) attributeFactory.getAttribute("units", "torsion");
            if (_att_units == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : units probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new UnitsAttribute(_att_units);
        super.addRemove(att, value);
    }
// attribute:   errorValue

    /** cache */
    DoubleSTAttribute _att_errorvalue = null;
    /** Value of the error.
    * Reports the author's estimate of the error in a scalar value. Only meaningful for dataTypes mapping to real number.
    * @return CMLAttribute
    */
    public CMLAttribute getErrorValueAttribute() {
        return (CMLAttribute) getAttribute("errorValue");
    }
    /** Value of the error.
    * Reports the author's estimate of the error in a scalar value. Only meaningful for dataTypes mapping to real number.
    * @return double
    */
    public double getErrorValue() {
        DoubleSTAttribute att = (DoubleSTAttribute) this.getErrorValueAttribute();
        if (att == null) {
            return Double.NaN;
        }
        return att.getDouble();
    }
    /** Value of the error.
    * Reports the author's estimate of the error in a scalar value. Only meaningful for dataTypes mapping to real number.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setErrorValue(String value) throws RuntimeException {
        DoubleSTAttribute att = null;
        if (_att_errorvalue == null) {
            _att_errorvalue = (DoubleSTAttribute) attributeFactory.getAttribute("errorValue", "torsion");
            if (_att_errorvalue == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : errorValue probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new DoubleSTAttribute(_att_errorvalue);
        super.addRemove(att, value);
    }
    /** Value of the error.
    * Reports the author's estimate of the error in a scalar value. Only meaningful for dataTypes mapping to real number.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setErrorValue(double value) throws RuntimeException {
        if (_att_errorvalue == null) {
            _att_errorvalue = (DoubleSTAttribute) attributeFactory.getAttribute("errorValue", "torsion");
           if (_att_errorvalue == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : errorValue probably incompatible attributeGroupName and attributeName ");
            }
        }
        DoubleSTAttribute att = new DoubleSTAttribute(_att_errorvalue);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// attribute:   errorBasis

    /** cache */
    StringSTAttribute _att_errorbasis = null;
    /** Basis of the error estimate.
    * 
    * @return CMLAttribute
    */
    public CMLAttribute getErrorBasisAttribute() {
        return (CMLAttribute) getAttribute("errorBasis");
    }
    /** Basis of the error estimate.
    * 
    * @return String
    */
    public String getErrorBasis() {
        StringSTAttribute att = (StringSTAttribute) this.getErrorBasisAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** Basis of the error estimate.
    * 
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setErrorBasis(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_errorbasis == null) {
            _att_errorbasis = (StringSTAttribute) attributeFactory.getAttribute("errorBasis", "torsion");
            if (_att_errorbasis == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : errorBasis probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_errorbasis);
        super.addRemove(att, value);
    }
// attribute:   min

    /** cache */
    StringSTAttribute _att_min = null;
    /** The minimum value allowed for an element or attribute.
    * 
    * @return CMLAttribute
    */
    public CMLAttribute getMinAttribute() {
        return (CMLAttribute) getAttribute("min");
    }
    /** The minimum value allowed for an element or attribute.
    * 
    * @return String
    */
    public String getMin() {
        StringSTAttribute att = (StringSTAttribute) this.getMinAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** The minimum value allowed for an element or attribute.
    * 
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setMin(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_min == null) {
            _att_min = (StringSTAttribute) attributeFactory.getAttribute("min", "torsion");
            if (_att_min == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : min probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_min);
        super.addRemove(att, value);
    }
// attribute:   max

    /** cache */
    StringSTAttribute _att_max = null;
    /** Maximum value allowed for an element or attribute.
    * 
    * @return CMLAttribute
    */
    public CMLAttribute getMaxAttribute() {
        return (CMLAttribute) getAttribute("max");
    }
    /** Maximum value allowed for an element or attribute.
    * 
    * @return String
    */
    public String getMax() {
        StringSTAttribute att = (StringSTAttribute) this.getMaxAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** Maximum value allowed for an element or attribute.
    * 
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setMax(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_max == null) {
            _att_max = (StringSTAttribute) attributeFactory.getAttribute("max", "torsion");
            if (_att_max == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : max probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_max);
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
            _att_ref = (RefAttribute) attributeFactory.getAttribute("ref", "torsion");
            if (_att_ref == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : ref probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new RefAttribute(_att_ref);
        super.addRemove(att, value);
    }
    DoubleSTAttribute _xmlContent;
    /** The type of a torsion angle.
    * @return double
    */
    public double getXMLContent() {
        String content = this.getValue();
        if (_xmlContent == null) {
            _xmlContent = new DoubleSTAttribute("_xmlContent");
        }
        _xmlContent.setCMLValue(content);
        return _xmlContent.getDouble();
    }
    /** The type of a torsion angle.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setXMLContent(String value) throws RuntimeException {
        if (_xmlContent == null) {
            _xmlContent = new DoubleSTAttribute("_xmlContent");
        }
        _xmlContent.setCMLValue(value);
        String attval = _xmlContent.getValue();
        this.removeChildren();
        this.appendChild(attval);
    }
    /** The type of a torsion angle.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setXMLContent(double value) throws RuntimeException {
        if (_xmlContent == null) {
            _xmlContent = new DoubleSTAttribute("_xmlContent");
        }
        _xmlContent.setCMLValue(value);
        String attval = (String)_xmlContent.getValue();
        this.removeChildren();
        this.appendChild(attval);
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
        } else if (name.equals("atomRefs4")) {
            setAtomRefs4(value);
        } else if (name.equals("units")) {
            setUnits(value);
        } else if (name.equals("errorValue")) {
            setErrorValue(value);
        } else if (name.equals("errorBasis")) {
            setErrorBasis(value);
        } else if (name.equals("min")) {
            setMin(value);
        } else if (name.equals("max")) {
            setMax(value);
        } else if (name.equals("ref")) {
            setRef(value);
	     } else {
            super.addAttribute(att);
        }
    }
}
