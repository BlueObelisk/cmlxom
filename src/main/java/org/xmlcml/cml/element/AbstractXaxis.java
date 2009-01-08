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
import org.xmlcml.cml.base.DoubleSTAttribute;
import org.xmlcml.cml.base.StringSTAttribute;

// end of part 1
/** CLASS DOCUMENTATION */
public abstract class AbstractXaxis extends CMLElement {
    /** local name*/
    public final static String TAG = "xaxis";
    /** constructor. */    public AbstractXaxis() {
        super("xaxis");
    }
/** copy constructor.
* deep copy using XOM copy()
* @param old element to copy
*/
    public AbstractXaxis(AbstractXaxis old) {
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
            _att_dictref = (DictRefAttribute) attributeFactory.getAttribute("dictRef", "xaxis");
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
            _att_convention = (StringSTAttribute) attributeFactory.getAttribute("convention", "xaxis");
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
            _att_title = (StringSTAttribute) attributeFactory.getAttribute("title", "xaxis");
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
            _att_id = (IdAttribute) attributeFactory.getAttribute("id", "xaxis");
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
            _att_ref = (RefAttribute) attributeFactory.getAttribute("ref", "xaxis");
            if (_att_ref == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : ref probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new RefAttribute(_att_ref);
        super.addRemove(att, value);
    }
// attribute:   multiplierToData

    /** cache */
    DoubleSTAttribute _att_multipliertodata = null;
    /** The scale by which to multiply raw data or a unit.
    * The scale is applied *before* adding any constant.
    *                 The attribute may be found on a data item (scalar, array, matrix, etc.) or 
    *                 a user-defined unit.
    * @return CMLAttribute
    */
    public CMLAttribute getMultiplierToDataAttribute() {
        return (CMLAttribute) getAttribute("multiplierToData");
    }
    /** The scale by which to multiply raw data or a unit.
    * The scale is applied *before* adding any constant.
    *                 The attribute may be found on a data item (scalar, array, matrix, etc.) or 
    *                 a user-defined unit.
    * @return double
    */
    public double getMultiplierToData() {
        DoubleSTAttribute att = (DoubleSTAttribute) this.getMultiplierToDataAttribute();
        if (att == null) {
            return Double.NaN;
        }
        return att.getDouble();
    }
    /** The scale by which to multiply raw data or a unit.
    * The scale is applied *before* adding any constant.
    *                 The attribute may be found on a data item (scalar, array, matrix, etc.) or 
    *                 a user-defined unit.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setMultiplierToData(String value) throws RuntimeException {
        DoubleSTAttribute att = null;
        if (_att_multipliertodata == null) {
            _att_multipliertodata = (DoubleSTAttribute) attributeFactory.getAttribute("multiplierToData", "xaxis");
            if (_att_multipliertodata == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : multiplierToData probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new DoubleSTAttribute(_att_multipliertodata);
        super.addRemove(att, value);
    }
    /** The scale by which to multiply raw data or a unit.
    * The scale is applied *before* adding any constant.
    *                 The attribute may be found on a data item (scalar, array, matrix, etc.) or 
    *                 a user-defined unit.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setMultiplierToData(double value) throws RuntimeException {
        if (_att_multipliertodata == null) {
            _att_multipliertodata = (DoubleSTAttribute) attributeFactory.getAttribute("multiplierToData", "xaxis");
           if (_att_multipliertodata == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : multiplierToData probably incompatible attributeGroupName and attributeName ");
            }
        }
        DoubleSTAttribute att = new DoubleSTAttribute(_att_multipliertodata);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// attribute:   constantToData

    /** cache */
    DoubleSTAttribute _att_constanttodata = null;
    /** The constant to add to the raw data.
    *  add *after* applying any multiplier.
    * @return CMLAttribute
    */
    public CMLAttribute getConstantToDataAttribute() {
        return (CMLAttribute) getAttribute("constantToData");
    }
    /** The constant to add to the raw data.
    *  add *after* applying any multiplier.
    * @return double
    */
    public double getConstantToData() {
        DoubleSTAttribute att = (DoubleSTAttribute) this.getConstantToDataAttribute();
        if (att == null) {
            return Double.NaN;
        }
        return att.getDouble();
    }
    /** The constant to add to the raw data.
    *  add *after* applying any multiplier.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setConstantToData(String value) throws RuntimeException {
        DoubleSTAttribute att = null;
        if (_att_constanttodata == null) {
            _att_constanttodata = (DoubleSTAttribute) attributeFactory.getAttribute("constantToData", "xaxis");
            if (_att_constanttodata == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : constantToData probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new DoubleSTAttribute(_att_constanttodata);
        super.addRemove(att, value);
    }
    /** The constant to add to the raw data.
    *  add *after* applying any multiplier.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setConstantToData(double value) throws RuntimeException {
        if (_att_constanttodata == null) {
            _att_constanttodata = (DoubleSTAttribute) attributeFactory.getAttribute("constantToData", "xaxis");
           if (_att_constanttodata == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : constantToData probably incompatible attributeGroupName and attributeName ");
            }
        }
        DoubleSTAttribute att = new DoubleSTAttribute(_att_constanttodata);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// element:   array

    /** The constant to add to the raw data.
    *  add *after* applying any multiplier.
    * @param array child to add
    */
    public void addArray(AbstractArray array) {
        array.detach();
        this.appendChild(array);
    }
    /** The constant to add to the raw data.
    *  add *after* applying any multiplier.
    * @return CMLElements<CMLArray>
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
        } else if (name.equals("multiplierToData")) {
            setMultiplierToData(value);
        } else if (name.equals("constantToData")) {
            setConstantToData(value);
	     } else {
            super.addAttribute(att);
        }
    }
}
