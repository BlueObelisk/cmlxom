package org.xmlcml.cml.element;


import nu.xom.Attribute;

import org.xmlcml.cml.attribute.DictRefAttribute;
import org.xmlcml.cml.attribute.IdAttribute;
import org.xmlcml.cml.base.CMLAttribute;
import org.xmlcml.cml.base.CMLElement;
import org.xmlcml.cml.base.DoubleArraySTAttribute;
import org.xmlcml.cml.base.DoubleSTAttribute;
import org.xmlcml.cml.base.StringSTAttribute;

// end of part 1
/** CLASS DOCUMENTATION */
public abstract class AbstractKpoint extends CMLElement {
    /** local name*/
    public final static String TAG = "kpoint";
    /** constructor. */    public AbstractKpoint() {
        super("kpoint");
    }
/** copy constructor.
* deep copy using XOM copy()
* @param old element to copy
*/
    public AbstractKpoint(AbstractKpoint old) {
        super((CMLElement) old);
    }
// attribute:   weight

    /** cache */
    DoubleSTAttribute _att_weight = null;
    /** Weight of the element.
    * Currently the weight of the kPoint, derived from the symmetry such as the inverse of the multiplicity in real space. Thus a point at 0,0,0 in monoclinic space might be 0.25. The lowest value possible is probably 1/48.0 (in m3m).
    * @return CMLAttribute
    */
    public CMLAttribute getWeightAttribute() {
        return (CMLAttribute) getAttribute("weight");
    }
    /** Weight of the element.
    * Currently the weight of the kPoint, derived from the symmetry such as the inverse of the multiplicity in real space. Thus a point at 0,0,0 in monoclinic space might be 0.25. The lowest value possible is probably 1/48.0 (in m3m).
    * @return double
    */
    public double getWeight() {
        DoubleSTAttribute att = (DoubleSTAttribute) this.getWeightAttribute();
        if (att == null) {
            return Double.NaN;
        }
        return att.getDouble();
    }
    /** Weight of the element.
    * Currently the weight of the kPoint, derived from the symmetry such as the inverse of the multiplicity in real space. Thus a point at 0,0,0 in monoclinic space might be 0.25. The lowest value possible is probably 1/48.0 (in m3m).
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setWeight(String value) throws RuntimeException {
        DoubleSTAttribute att = null;
        if (_att_weight == null) {
            _att_weight = (DoubleSTAttribute) attributeFactory.getAttribute("weight", "kpoint");
            if (_att_weight == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : weight probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new DoubleSTAttribute(_att_weight);
        super.addRemove(att, value);
    }
    /** Weight of the element.
    * Currently the weight of the kPoint, derived from the symmetry such as the inverse of the multiplicity in real space. Thus a point at 0,0,0 in monoclinic space might be 0.25. The lowest value possible is probably 1/48.0 (in m3m).
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setWeight(double value) throws RuntimeException {
        if (_att_weight == null) {
            _att_weight = (DoubleSTAttribute) attributeFactory.getAttribute("weight", "kpoint");
           if (_att_weight == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : weight probably incompatible attributeGroupName and attributeName ");
            }
        }
        DoubleSTAttribute att = new DoubleSTAttribute(_att_weight);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// attribute:   label

    /** cache */
    StringSTAttribute _att_label = null;
    /** A label.
    * The semantics of label are not defined in the schema but are normally commonly used  standard or semi-standard text strings. This attribute has the the same semantics as the more common _label_ element.
    * @return CMLAttribute
    */
    public CMLAttribute getLabelAttribute() {
        return (CMLAttribute) getAttribute("label");
    }
    /** A label.
    * The semantics of label are not defined in the schema but are normally commonly used  standard or semi-standard text strings. This attribute has the the same semantics as the more common _label_ element.
    * @return String
    */
    public String getLabel() {
        StringSTAttribute att = (StringSTAttribute) this.getLabelAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** A label.
    * The semantics of label are not defined in the schema but are normally commonly used  standard or semi-standard text strings. This attribute has the the same semantics as the more common _label_ element.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setLabel(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_label == null) {
            _att_label = (StringSTAttribute) attributeFactory.getAttribute("label", "kpoint");
            if (_att_label == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : label probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_label);
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
            _att_title = (StringSTAttribute) attributeFactory.getAttribute("title", "kpoint");
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
            _att_id = (IdAttribute) attributeFactory.getAttribute("id", "kpoint");
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
            _att_convention = (StringSTAttribute) attributeFactory.getAttribute("convention", "kpoint");
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
            _att_dictref = (DictRefAttribute) attributeFactory.getAttribute("dictRef", "kpoint");
            if (_att_dictref == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : dictRef probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new DictRefAttribute(_att_dictref);
        super.addRemove(att, value);
    }
    DoubleArraySTAttribute _xmlContent;
    /** A vector in 3-space.
    * No constraints on magnitude (i.e. could be zero.
    * @return double[]
    */
    public double[] getXMLContent() {
        String content = this.getValue();
        if (_xmlContent == null) {
            _xmlContent = new DoubleArraySTAttribute("_xmlContent");
        }
        _xmlContent.setCMLValue(content);
        return _xmlContent.getDoubleArray();
    }
    /** A vector in 3-space.
    * No constraints on magnitude (i.e. could be zero.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setXMLContent(String value) throws RuntimeException {
        if (_xmlContent == null) {
            _xmlContent = new DoubleArraySTAttribute("_xmlContent");
        }
        _xmlContent.setCMLValue(value);
        String attval = _xmlContent.getValue();
        this.removeChildren();
        this.appendChild(attval);
    }
    /** A vector in 3-space.
    * No constraints on magnitude (i.e. could be zero.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setXMLContent(double[] value) throws RuntimeException {
        if (_xmlContent == null) {
            _xmlContent = new DoubleArraySTAttribute("_xmlContent");
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
        } else if (name.equals("weight")) {
            setWeight(value);
        } else if (name.equals("label")) {
            setLabel(value);
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
