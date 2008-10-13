package org.xmlcml.cml.element.lite;


import nu.xom.Attribute;
import nu.xom.Elements;

import org.xmlcml.cml.attribute.DictRefAttribute;
import org.xmlcml.cml.attribute.IdAttribute;
import org.xmlcml.cml.attribute.RefAttribute;
import org.xmlcml.cml.attribute.UnitsAttribute;
import org.xmlcml.cml.base.CMLAttribute;
import org.xmlcml.cml.base.CMLElement;
import org.xmlcml.cml.base.CMLElements;
import org.xmlcml.cml.base.StringArraySTAttribute;
import org.xmlcml.cml.base.StringSTAttribute;

// end of part 1
/** CLASS DOCUMENTATION */
public abstract class AbstractPeakStructure extends CMLElement {
    /** local name*/
    public final static String TAG = "peakStructure";
    /** constructor. */    public AbstractPeakStructure() {
        super("peakStructure");
    }
/** copy constructor.
* deep copy using XOM copy()
* @param old element to copy
*/
    public AbstractPeakStructure(AbstractPeakStructure old) {
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
            _att_dictref = (DictRefAttribute) attributeFactory.getAttribute("dictRef", "peakStructure");
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
            _att_convention = (StringSTAttribute) attributeFactory.getAttribute("convention", "peakStructure");
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
            _att_title = (StringSTAttribute) attributeFactory.getAttribute("title", "peakStructure");
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
            _att_id = (IdAttribute) attributeFactory.getAttribute("id", "peakStructure");
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
            _att_ref = (RefAttribute) attributeFactory.getAttribute("ref", "peakStructure");
            if (_att_ref == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : ref probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new RefAttribute(_att_ref);
        super.addRemove(att, value);
    }
// attribute:   peakMultiplicity

    /** cache */
    StringSTAttribute _att_peakmultiplicity = null;
    /** Multiplicity of a peak.
    * Uses a semi-controlled vocabulary.
    * @return CMLAttribute
    */
    public CMLAttribute getPeakMultiplicityAttribute() {
        return (CMLAttribute) getAttribute("peakMultiplicity");
    }
    /** Multiplicity of a peak.
    * Uses a semi-controlled vocabulary.
    * @return String
    */
    public String getPeakMultiplicity() {
        StringSTAttribute att = (StringSTAttribute) this.getPeakMultiplicityAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** Multiplicity of a peak.
    * Uses a semi-controlled vocabulary.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setPeakMultiplicity(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_peakmultiplicity == null) {
            _att_peakmultiplicity = (StringSTAttribute) attributeFactory.getAttribute("peakMultiplicity", "peakStructure");
            if (_att_peakmultiplicity == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : peakMultiplicity probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_peakmultiplicity);
        super.addRemove(att, value);
    }
// attribute:   type

    /** cache */
    StringSTAttribute _att_type = null;
    /** Type of this structure.
    * Semi-controlled vocabulary such as coupling 
    *                 or splitting.
    * @return CMLAttribute
    */
    public CMLAttribute getTypeAttribute() {
        return (CMLAttribute) getAttribute("type");
    }
    /** Type of this structure.
    * Semi-controlled vocabulary such as coupling 
    *                 or splitting.
    * @return String
    */
    public String getType() {
        StringSTAttribute att = (StringSTAttribute) this.getTypeAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** Type of this structure.
    * Semi-controlled vocabulary such as coupling 
    *                 or splitting.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setType(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_type == null) {
            _att_type = (StringSTAttribute) attributeFactory.getAttribute("type", "peakStructure");
            if (_att_type == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : type probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_type);
        super.addRemove(att, value);
    }
// attribute:   peakShape

    /** cache */
    StringSTAttribute _att_peakshape = null;
    /** Shape of a peak.
    * Semi-controlled vocabulary such as broad or sharp.
    * @return CMLAttribute
    */
    public CMLAttribute getPeakShapeAttribute() {
        return (CMLAttribute) getAttribute("peakShape");
    }
    /** Shape of a peak.
    * Semi-controlled vocabulary such as broad or sharp.
    * @return String
    */
    public String getPeakShape() {
        StringSTAttribute att = (StringSTAttribute) this.getPeakShapeAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** Shape of a peak.
    * Semi-controlled vocabulary such as broad or sharp.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setPeakShape(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_peakshape == null) {
            _att_peakshape = (StringSTAttribute) attributeFactory.getAttribute("peakShape", "peakStructure");
            if (_att_peakshape == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : peakShape probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_peakshape);
        super.addRemove(att, value);
    }
// attribute:   value

    /** cache */
    StringSTAttribute _att_value = null;
    /** Value of a scalar object.
    * The value must be consistent with the dataType of the object.
    * @return CMLAttribute
    */
    public CMLAttribute getCMLValueAttribute() {
        return (CMLAttribute) getAttribute("value");
    }
    /** Value of a scalar object.
    * The value must be consistent with the dataType of the object.
    * @return String
    */
    public String getCMLValue() {
        StringSTAttribute att = (StringSTAttribute) this.getCMLValueAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** Value of a scalar object.
    * The value must be consistent with the dataType of the object.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setCMLValue(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_value == null) {
            _att_value = (StringSTAttribute) attributeFactory.getAttribute("value", "peakStructure");
            if (_att_value == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : value probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_value);
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
            _att_units = (UnitsAttribute) attributeFactory.getAttribute("units", "peakStructure");
            if (_att_units == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : units probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new UnitsAttribute(_att_units);
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
            _att_atomrefs = (StringArraySTAttribute) attributeFactory.getAttribute("atomRefs", "peakStructure");
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
            _att_atomrefs = (StringArraySTAttribute) attributeFactory.getAttribute("atomRefs", "peakStructure");
           if (_att_atomrefs == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : atomRefs probably incompatible attributeGroupName and attributeName ");
            }
        }
        StringArraySTAttribute att = new StringArraySTAttribute(_att_atomrefs);
        super.addAttribute(att);
        att.setCMLValue(value);
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
            _att_bondrefs = (StringArraySTAttribute) attributeFactory.getAttribute("bondRefs", "peakStructure");
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
            _att_bondrefs = (StringArraySTAttribute) attributeFactory.getAttribute("bondRefs", "peakStructure");
           if (_att_bondrefs == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : bondRefs probably incompatible attributeGroupName and attributeName ");
            }
        }
        StringArraySTAttribute att = new StringArraySTAttribute(_att_bondrefs);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// element:   peakStructure

    /** A reference to a list of bonds.
    * Used by electrons, bondSets, etc.
    * @param peakStructure child to add
    */
    public void addPeakStructure(AbstractPeakStructure peakStructure) {
        peakStructure.detach();
        this.appendChild(peakStructure);
    }
    /** A reference to a list of bonds.
    * Used by electrons, bondSets, etc.
    * @return CMLElements<CMLPeakStructure>
    */
    public CMLElements<CMLPeakStructure> getPeakStructureElements() {
        Elements elements = this.getChildElements("peakStructure", CML_NS);
        return new CMLElements<CMLPeakStructure>(elements);
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
        } else if (name.equals("peakMultiplicity")) {
            setPeakMultiplicity(value);
        } else if (name.equals("type")) {
            setType(value);
        } else if (name.equals("peakShape")) {
            setPeakShape(value);
        } else if (name.equals("value")) {
            setCMLValue(value);
        } else if (name.equals("units")) {
            setUnits(value);
        } else if (name.equals("atomRefs")) {
            setAtomRefs(value);
        } else if (name.equals("bondRefs")) {
            setBondRefs(value);
	     } else {
            super.addAttribute(att);
        }
    }
}
