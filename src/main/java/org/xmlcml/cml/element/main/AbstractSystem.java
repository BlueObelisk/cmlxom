package org.xmlcml.cml.element.main;


import nu.xom.Attribute;

import org.xmlcml.cml.attribute.DictRefAttribute;
import org.xmlcml.cml.attribute.IdAttribute;
import org.xmlcml.cml.base.CMLAttribute;
import org.xmlcml.cml.base.CMLElement;
import org.xmlcml.cml.base.IntSTAttribute;
import org.xmlcml.cml.base.StringSTAttribute;

// end of part 1
/** CLASS DOCUMENTATION */
public abstract class AbstractSystem extends CMLElement {
    /** local name*/
    public final static String TAG = "system";
    /** constructor. */    public AbstractSystem() {
        super("system");
    }
/** copy constructor.
* deep copy using XOM copy()
* @param old element to copy
*/
    public AbstractSystem(AbstractSystem old) {
        super((CMLElement) old);
    }
// attribute:   dimensionality

    /** cache */
    IntSTAttribute _att_dimensionality = null;
    /** Dimensionality of a coordinate system.
    * Note that this means that coordinates of higher dimensionality 
    *                 are ignored or an error is flagged. Thus z3 and dimensionality='2' are incompatible. 
    *                 At present higher dimensionalities than 3 (cf. Wondratschek) are not supported. 
    *                 The labelling of the axes id not controlled. ?? should we have an explicit 
    *                 attribute for labelling convention?.
    * @return CMLAttribute
    */
    public CMLAttribute getDimensionalityAttribute() {
        return (CMLAttribute) getAttribute("dimensionality");
    }
    /** Dimensionality of a coordinate system.
    * Note that this means that coordinates of higher dimensionality 
    *                 are ignored or an error is flagged. Thus z3 and dimensionality='2' are incompatible. 
    *                 At present higher dimensionalities than 3 (cf. Wondratschek) are not supported. 
    *                 The labelling of the axes id not controlled. ?? should we have an explicit 
    *                 attribute for labelling convention?.
    * @return int
    */
    public int getDimensionality() {
        IntSTAttribute att = (IntSTAttribute) this.getDimensionalityAttribute();
        if (att == null) {
            throw new RuntimeException("int attribute is unset: dimensionality");
        }
        return att.getInt();
    }
    /** Dimensionality of a coordinate system.
    * Note that this means that coordinates of higher dimensionality 
    *                 are ignored or an error is flagged. Thus z3 and dimensionality='2' are incompatible. 
    *                 At present higher dimensionalities than 3 (cf. Wondratschek) are not supported. 
    *                 The labelling of the axes id not controlled. ?? should we have an explicit 
    *                 attribute for labelling convention?.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setDimensionality(String value) throws RuntimeException {
        IntSTAttribute att = null;
        if (_att_dimensionality == null) {
            _att_dimensionality = (IntSTAttribute) attributeFactory.getAttribute("dimensionality", "system");
            if (_att_dimensionality == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : dimensionality probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new IntSTAttribute(_att_dimensionality);
        super.addRemove(att, value);
    }
    /** Dimensionality of a coordinate system.
    * Note that this means that coordinates of higher dimensionality 
    *                 are ignored or an error is flagged. Thus z3 and dimensionality='2' are incompatible. 
    *                 At present higher dimensionalities than 3 (cf. Wondratschek) are not supported. 
    *                 The labelling of the axes id not controlled. ?? should we have an explicit 
    *                 attribute for labelling convention?.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setDimensionality(int value) throws RuntimeException {
        if (_att_dimensionality == null) {
            _att_dimensionality = (IntSTAttribute) attributeFactory.getAttribute("dimensionality", "system");
           if (_att_dimensionality == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : dimensionality probably incompatible attributeGroupName and attributeName ");
            }
        }
        IntSTAttribute att = new IntSTAttribute(_att_dimensionality);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// attribute:   periodicity

    /** cache */
    IntSTAttribute _att_periodicity = null;
    /** Periodicity of the system.
    * No description
    * @return CMLAttribute
    */
    public CMLAttribute getPeriodicityAttribute() {
        return (CMLAttribute) getAttribute("periodicity");
    }
    /** Periodicity of the system.
    * No description
    * @return int
    */
    public int getPeriodicity() {
        IntSTAttribute att = (IntSTAttribute) this.getPeriodicityAttribute();
        if (att == null) {
            throw new RuntimeException("int attribute is unset: periodicity");
        }
        return att.getInt();
    }
    /** Periodicity of the system.
    * No description
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setPeriodicity(String value) throws RuntimeException {
        IntSTAttribute att = null;
        if (_att_periodicity == null) {
            _att_periodicity = (IntSTAttribute) attributeFactory.getAttribute("periodicity", "system");
            if (_att_periodicity == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : periodicity probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new IntSTAttribute(_att_periodicity);
        super.addRemove(att, value);
    }
    /** Periodicity of the system.
    * No description
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setPeriodicity(int value) throws RuntimeException {
        if (_att_periodicity == null) {
            _att_periodicity = (IntSTAttribute) attributeFactory.getAttribute("periodicity", "system");
           if (_att_periodicity == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : periodicity probably incompatible attributeGroupName and attributeName ");
            }
        }
        IntSTAttribute att = new IntSTAttribute(_att_periodicity);
        super.addAttribute(att);
        att.setCMLValue(value);
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
            _att_title = (StringSTAttribute) attributeFactory.getAttribute("title", "system");
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
            _att_id = (IdAttribute) attributeFactory.getAttribute("id", "system");
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
            _att_convention = (StringSTAttribute) attributeFactory.getAttribute("convention", "system");
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
            _att_dictref = (DictRefAttribute) attributeFactory.getAttribute("dictRef", "system");
            if (_att_dictref == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : dictRef probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new DictRefAttribute(_att_dictref);
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
        } else if (name.equals("dimensionality")) {
            setDimensionality(value);
        } else if (name.equals("periodicity")) {
            setPeriodicity(value);
        } else if (name.equals("title")) {
            setTitle(value);
        } else if (name.equals("id")) {
            setId(value);
        } else if (name.equals("convention")) {
            setConvention(value);
        } else if (name.equals("dictRef")) {
            setDictRef(value);
	     } else {
            super.addAttribute(att);
        }
    }
}
