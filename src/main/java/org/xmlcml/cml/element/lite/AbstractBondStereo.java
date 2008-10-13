package org.xmlcml.cml.element.lite;


import nu.xom.Attribute;

import org.xmlcml.cml.attribute.DictRefAttribute;
import org.xmlcml.cml.attribute.IdAttribute;
import org.xmlcml.cml.base.CMLAttribute;
import org.xmlcml.cml.base.CMLElement;
import org.xmlcml.cml.base.StringArraySTAttribute;
import org.xmlcml.cml.base.StringSTAttribute;

// end of part 1
/** CLASS DOCUMENTATION */
public abstract class AbstractBondStereo extends CMLElement {
    /** local name*/
    public final static String TAG = "bondStereo";
    /** constructor. */    public AbstractBondStereo() {
        super("bondStereo");
    }
/** copy constructor.
* deep copy using XOM copy()
* @param old element to copy
*/
    public AbstractBondStereo(AbstractBondStereo old) {
        super((CMLElement) old);
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
            _att_atomrefs4 = (StringArraySTAttribute) attributeFactory.getAttribute("atomRefs4", "bondStereo");
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
            _att_atomrefs4 = (StringArraySTAttribute) attributeFactory.getAttribute("atomRefs4", "bondStereo");
           if (_att_atomrefs4 == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : atomRefs4 probably incompatible attributeGroupName and attributeName ");
            }
        }
        StringArraySTAttribute att = new StringArraySTAttribute(_att_atomrefs4);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// attribute:   atomRefArray

    /** cache */
    StringArraySTAttribute _att_atomrefarray = null;
    /** An array of references to atoms.
    * Typical use would be to atoms defining a plane.
    * @return CMLAttribute
    */
    public CMLAttribute getAtomRefArrayAttribute() {
        return (CMLAttribute) getAttribute("atomRefArray");
    }
    /** An array of references to atoms.
    * Typical use would be to atoms defining a plane.
    * @return String[]
    */
    public String[] getAtomRefArray() {
        StringArraySTAttribute att = (StringArraySTAttribute) this.getAtomRefArrayAttribute();
        if (att == null) {
            return null;
        }
        return att.getStringArray();
    }
    /** An array of references to atoms.
    * Typical use would be to atoms defining a plane.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setAtomRefArray(String value) throws RuntimeException {
        StringArraySTAttribute att = null;
        if (_att_atomrefarray == null) {
            _att_atomrefarray = (StringArraySTAttribute) attributeFactory.getAttribute("atomRefArray", "bondStereo");
            if (_att_atomrefarray == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : atomRefArray probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringArraySTAttribute(_att_atomrefarray);
        super.addRemove(att, value);
    }
    /** An array of references to atoms.
    * Typical use would be to atoms defining a plane.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setAtomRefArray(String[] value) throws RuntimeException {
        if (_att_atomrefarray == null) {
            _att_atomrefarray = (StringArraySTAttribute) attributeFactory.getAttribute("atomRefArray", "bondStereo");
           if (_att_atomrefarray == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : atomRefArray probably incompatible attributeGroupName and attributeName ");
            }
        }
        StringArraySTAttribute att = new StringArraySTAttribute(_att_atomrefarray);
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
            _att_title = (StringSTAttribute) attributeFactory.getAttribute("title", "bondStereo");
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
            _att_id = (IdAttribute) attributeFactory.getAttribute("id", "bondStereo");
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
            _att_convention = (StringSTAttribute) attributeFactory.getAttribute("convention", "bondStereo");
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
            _att_dictref = (DictRefAttribute) attributeFactory.getAttribute("dictRef", "bondStereo");
            if (_att_dictref == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : dictRef probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new DictRefAttribute(_att_dictref);
        super.addRemove(att, value);
    }
// attribute:   conventionValue

    /** cache */
    StringSTAttribute _att_conventionvalue = null;
    /** The value of an element with a _convention_.
    * When convention is used this attribute must be present and element content must be empty.
    * @return CMLAttribute
    */
    public CMLAttribute getConventionValueAttribute() {
        return (CMLAttribute) getAttribute("conventionValue");
    }
    /** The value of an element with a _convention_.
    * When convention is used this attribute must be present and element content must be empty.
    * @return String
    */
    public String getConventionValue() {
        StringSTAttribute att = (StringSTAttribute) this.getConventionValueAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** The value of an element with a _convention_.
    * When convention is used this attribute must be present and element content must be empty.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setConventionValue(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_conventionvalue == null) {
            _att_conventionvalue = (StringSTAttribute) attributeFactory.getAttribute("conventionValue", "bondStereo");
            if (_att_conventionvalue == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : conventionValue probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_conventionvalue);
        super.addRemove(att, value);
    }
    StringSTAttribute _xmlContent;
    /** Bond stereochemistry as a string.
    * This is purely conventional. There is no default value. 
    *       The emptyString attribute can be used to indicate a bond of 
    *       unknown or unspecified type. The interpretation of this is outside
    *       the scope of CML-based algorithms. It may be accompanied by a convention
    *       attribute  which links to a dictionary.
    * @return String
    */
    public String getXMLContent() {
        String content = this.getValue();
        if (_xmlContent == null) {
            _xmlContent = new StringSTAttribute("_xmlContent");
        }
        _xmlContent.setCMLValue(content);
        return _xmlContent.getString();
    }
    /** Bond stereochemistry as a string.
    * This is purely conventional. There is no default value. 
    *       The emptyString attribute can be used to indicate a bond of 
    *       unknown or unspecified type. The interpretation of this is outside
    *       the scope of CML-based algorithms. It may be accompanied by a convention
    *       attribute  which links to a dictionary.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setXMLContent(String value) throws RuntimeException {
        if (_xmlContent == null) {
            _xmlContent = new StringSTAttribute("_xmlContent");
        }
        _xmlContent.setCMLValue(value);
        String attval = _xmlContent.getValue();
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
        } else if (name.equals("atomRefs4")) {
            setAtomRefs4(value);
        } else if (name.equals("atomRefArray")) {
            setAtomRefArray(value);
        } else if (name.equals("title")) {
            setTitle(value);
        } else if (name.equals("id")) {
            setId(value);
        } else if (name.equals("convention")) {
            setConvention(value);
        } else if (name.equals("dictRef")) {
            setDictRef(value);
        } else if (name.equals("conventionValue")) {
            setConventionValue(value);
	     } else {
            super.addAttribute(att);
        }
    }
}
