package org.xmlcml.cml.element;


import nu.xom.Attribute;

import org.xmlcml.cml.attribute.DictRefAttribute;
import org.xmlcml.cml.attribute.IdAttribute;
import org.xmlcml.cml.attribute.UnitsAttribute;
import org.xmlcml.cml.base.BooleanSTAttribute;
import org.xmlcml.cml.base.CMLAttribute;
import org.xmlcml.cml.base.CMLElement;
import org.xmlcml.cml.base.DoubleArraySTAttribute;
import org.xmlcml.cml.base.StringSTAttribute;

// end of part 1
/** CLASS DOCUMENTATION */
public abstract class AbstractLatticeVector extends CMLElement {
    /** local name*/
    public final static String TAG = "latticeVector";
    /** constructor. */    public AbstractLatticeVector() {
        super("latticeVector");
    }
/** copy constructor.
* deep copy using XOM copy()
* @param old element to copy
*/
    public AbstractLatticeVector(AbstractLatticeVector old) {
        super((CMLElement) old);
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
            _att_convention = (StringSTAttribute) attributeFactory.getAttribute("convention", "latticeVector");
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
            _att_dictref = (DictRefAttribute) attributeFactory.getAttribute("dictRef", "latticeVector");
            if (_att_dictref == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : dictRef probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new DictRefAttribute(_att_dictref);
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
            _att_id = (IdAttribute) attributeFactory.getAttribute("id", "latticeVector");
            if (_att_id == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : id probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new IdAttribute(_att_id);
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
            _att_title = (StringSTAttribute) attributeFactory.getAttribute("title", "latticeVector");
            if (_att_title == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : title probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_title);
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
            _att_units = (UnitsAttribute) attributeFactory.getAttribute("units", "latticeVector");
            if (_att_units == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : units probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new UnitsAttribute(_att_units);
        super.addRemove(att, value);
    }
// attribute:   periodic

    /** cache */
    BooleanSTAttribute _att_periodic = null;
    /** Is the axis periodic.
    * Any or all of the axes may be periodic or aperiodic. An example could be a surface where 2 periodic axes (not necessarily orthogonal) are used to describe the coordinates in the surface, perhaps representing lattice vectors of a 3D crystal or 2D layer. The third vector is orthogonal and represents coordinates normal to the surface. In this case only the direction, not the magnitude of the vector is important.
    * @return CMLAttribute
    */
    public CMLAttribute getPeriodicAttribute() {
        return (CMLAttribute) getAttribute("periodic");
    }
    /** Is the axis periodic.
    * Any or all of the axes may be periodic or aperiodic. An example could be a surface where 2 periodic axes (not necessarily orthogonal) are used to describe the coordinates in the surface, perhaps representing lattice vectors of a 3D crystal or 2D layer. The third vector is orthogonal and represents coordinates normal to the surface. In this case only the direction, not the magnitude of the vector is important.
    * @return boolean
    */
    public boolean getPeriodic() {
        BooleanSTAttribute att = (BooleanSTAttribute) this.getPeriodicAttribute();
        if (att == null) {
            throw new RuntimeException("boolean attribute is unset: periodic");
        }
        return att.getBoolean();
    }
    /** Is the axis periodic.
    * Any or all of the axes may be periodic or aperiodic. An example could be a surface where 2 periodic axes (not necessarily orthogonal) are used to describe the coordinates in the surface, perhaps representing lattice vectors of a 3D crystal or 2D layer. The third vector is orthogonal and represents coordinates normal to the surface. In this case only the direction, not the magnitude of the vector is important.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setPeriodic(String value) throws RuntimeException {
        BooleanSTAttribute att = null;
        if (_att_periodic == null) {
            _att_periodic = (BooleanSTAttribute) attributeFactory.getAttribute("periodic", "latticeVector");
            if (_att_periodic == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : periodic probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new BooleanSTAttribute(_att_periodic);
        super.addRemove(att, value);
    }
    /** Is the axis periodic.
    * Any or all of the axes may be periodic or aperiodic. An example could be a surface where 2 periodic axes (not necessarily orthogonal) are used to describe the coordinates in the surface, perhaps representing lattice vectors of a 3D crystal or 2D layer. The third vector is orthogonal and represents coordinates normal to the surface. In this case only the direction, not the magnitude of the vector is important.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setPeriodic(boolean value) throws RuntimeException {
        if (_att_periodic == null) {
            _att_periodic = (BooleanSTAttribute) attributeFactory.getAttribute("periodic", "latticeVector");
           if (_att_periodic == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : periodic probably incompatible attributeGroupName and attributeName ");
            }
        }
        BooleanSTAttribute att = new BooleanSTAttribute(_att_periodic);
        super.addAttribute(att);
        att.setCMLValue(value);
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
        } else if (name.equals("convention")) {
            setConvention(value);
        } else if (name.equals("dictRef")) {
            setDictRef(value);
        } else if (name.equals("id")) {
            setId(value);
        } else if (name.equals("title")) {
            setTitle(value);
        } else if (name.equals("units")) {
            setUnits(value);
        } else if (name.equals("periodic")) {
            setPeriodic(value);
	     } else {
            super.addAttribute(att);
        }
    }
}
