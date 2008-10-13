package org.xmlcml.cml.element.main;


import nu.xom.Attribute;
import nu.xom.Elements;

import org.xmlcml.cml.attribute.DictRefAttribute;
import org.xmlcml.cml.attribute.IdAttribute;
import org.xmlcml.cml.attribute.UnitsAttribute;
import org.xmlcml.cml.base.CMLAttribute;
import org.xmlcml.cml.base.CMLElement;
import org.xmlcml.cml.base.CMLElements;
import org.xmlcml.cml.base.StringSTAttribute;
import org.xmlcml.cml.element.lite.AbstractArray;
import org.xmlcml.cml.element.lite.CMLArray;

// end of part 1
/** CLASS DOCUMENTATION */
public abstract class AbstractEigen extends CMLElement {
    /** local name*/
    public final static String TAG = "eigen";
    /** constructor. */    public AbstractEigen() {
        super("eigen");
    }
/** copy constructor.
* deep copy using XOM copy()
* @param old element to copy
*/
    public AbstractEigen(AbstractEigen old) {
        super((CMLElement) old);
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
            _att_units = (UnitsAttribute) attributeFactory.getAttribute("units", "eigen");
            if (_att_units == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : units probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new UnitsAttribute(_att_units);
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
            _att_title = (StringSTAttribute) attributeFactory.getAttribute("title", "eigen");
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
            _att_id = (IdAttribute) attributeFactory.getAttribute("id", "eigen");
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
            _att_convention = (StringSTAttribute) attributeFactory.getAttribute("convention", "eigen");
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
            _att_dictref = (DictRefAttribute) attributeFactory.getAttribute("dictRef", "eigen");
            if (_att_dictref == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : dictRef probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new DictRefAttribute(_att_dictref);
        super.addRemove(att, value);
    }
// attribute:   type

    /** cache */
    StringSTAttribute _att_type = null;
    /** Type of the object.
    * A qualifier which may affect the semantics of the object.
    * @return CMLAttribute
    */
    public CMLAttribute getTypeAttribute() {
        return (CMLAttribute) getAttribute("type");
    }
    /** Type of the object.
    * A qualifier which may affect the semantics of the object.
    * @return String
    */
    public String getType() {
        StringSTAttribute att = (StringSTAttribute) this.getTypeAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** Type of the object.
    * A qualifier which may affect the semantics of the object.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setType(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_type == null) {
            _att_type = (StringSTAttribute) attributeFactory.getAttribute("type", "eigen");
            if (_att_type == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : type probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_type);
        super.addRemove(att, value);
    }
// attribute:   orientation

    /** cache */
    StringSTAttribute _att_orientation = null;
    /** The orientation of the eigenvector matrix.
    * Describes whether the vectors are columns or 
    * 				rows. No default, so effectively mandatory unless you want to make implementers
    * 				guess and break applications.
    * @return CMLAttribute
    */
    public CMLAttribute getOrientationAttribute() {
        return (CMLAttribute) getAttribute("orientation");
    }
    /** The orientation of the eigenvector matrix.
    * Describes whether the vectors are columns or 
    * 				rows. No default, so effectively mandatory unless you want to make implementers
    * 				guess and break applications.
    * @return String
    */
    public String getOrientation() {
        StringSTAttribute att = (StringSTAttribute) this.getOrientationAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** The orientation of the eigenvector matrix.
    * Describes whether the vectors are columns or 
    * 				rows. No default, so effectively mandatory unless you want to make implementers
    * 				guess and break applications.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setOrientation(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_orientation == null) {
            _att_orientation = (StringSTAttribute) attributeFactory.getAttribute("orientation", "eigen");
            if (_att_orientation == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : orientation probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_orientation);
        super.addRemove(att, value);
    }
// element:   array

    /** The orientation of the eigenvector matrix.
    * Describes whether the vectors are columns or 
    * 				rows. No default, so effectively mandatory unless you want to make implementers
    * 				guess and break applications.
    * @param array child to add
    */
    public void addArray(AbstractArray array) {
        array.detach();
        this.appendChild(array);
    }
    /** The orientation of the eigenvector matrix.
    * Describes whether the vectors are columns or 
    * 				rows. No default, so effectively mandatory unless you want to make implementers
    * 				guess and break applications.
    * @return CMLElements<CMLArray>
    */
    public CMLElements<CMLArray> getArrayElements() {
        Elements elements = this.getChildElements("array", CML_NS);
        return new CMLElements<CMLArray>(elements);
    }
// element:   matrix

    /** The orientation of the eigenvector matrix.
    * Describes whether the vectors are columns or 
    * 				rows. No default, so effectively mandatory unless you want to make implementers
    * 				guess and break applications.
    * @param matrix child to add
    */
    public void addMatrix(AbstractMatrix matrix) {
        matrix.detach();
        this.appendChild(matrix);
    }
    /** The orientation of the eigenvector matrix.
    * Describes whether the vectors are columns or 
    * 				rows. No default, so effectively mandatory unless you want to make implementers
    * 				guess and break applications.
    * @return CMLElements<CMLMatrix>
    */
    public CMLElements<CMLMatrix> getMatrixElements() {
        Elements elements = this.getChildElements("matrix", CML_NS);
        return new CMLElements<CMLMatrix>(elements);
    }
    /** overrides addAttribute(Attribute)
     * reroutes calls to setFoo()
     * @param att  attribute
    */
    public void addAttribute(Attribute att) {
        String name = att.getLocalName();
        String value = att.getValue();
        if (name == null) {
        } else if (name.equals("units")) {
            setUnits(value);
        } else if (name.equals("title")) {
            setTitle(value);
        } else if (name.equals("id")) {
            setId(value);
        } else if (name.equals("convention")) {
            setConvention(value);
        } else if (name.equals("dictRef")) {
            setDictRef(value);
        } else if (name.equals("type")) {
            setType(value);
        } else if (name.equals("orientation")) {
            setOrientation(value);
	     } else {
            super.addAttribute(att);
        }
    }
}
