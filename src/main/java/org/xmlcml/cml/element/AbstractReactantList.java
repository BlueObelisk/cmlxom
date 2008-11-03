package org.xmlcml.cml.element;


import nu.xom.Attribute;
import nu.xom.Elements;

import org.xmlcml.cml.attribute.DictRefAttribute;
import org.xmlcml.cml.attribute.IdAttribute;
import org.xmlcml.cml.attribute.RefAttribute;
import org.xmlcml.cml.base.CMLAttribute;
import org.xmlcml.cml.base.CMLElement;
import org.xmlcml.cml.base.CMLElements;
import org.xmlcml.cml.base.DoubleSTAttribute;
import org.xmlcml.cml.base.StringSTAttribute;

// end of part 1
/** CLASS DOCUMENTATION */
public abstract class AbstractReactantList extends CMLElement {
    /** local name*/
    public final static String TAG = "reactantList";
    /** constructor. */    public AbstractReactantList() {
        super("reactantList");
    }
/** copy constructor.
* deep copy using XOM copy()
* @param old element to copy
*/
    public AbstractReactantList(AbstractReactantList old) {
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
            _att_dictref = (DictRefAttribute) attributeFactory.getAttribute("dictRef", "reactantList");
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
            _att_convention = (StringSTAttribute) attributeFactory.getAttribute("convention", "reactantList");
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
            _att_title = (StringSTAttribute) attributeFactory.getAttribute("title", "reactantList");
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
            _att_id = (IdAttribute) attributeFactory.getAttribute("id", "reactantList");
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
            _att_ref = (RefAttribute) attributeFactory.getAttribute("ref", "reactantList");
            if (_att_ref == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : ref probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new RefAttribute(_att_ref);
        super.addRemove(att, value);
    }
// attribute:   role

    /** cache */
    StringSTAttribute _att_role = null;
    /** Role of the object.
    * How the object functions or its position in the architecture. No controlled vocabulary.
    * @return CMLAttribute
    */
    public CMLAttribute getRoleAttribute() {
        return (CMLAttribute) getAttribute("role");
    }
    /** Role of the object.
    * How the object functions or its position in the architecture. No controlled vocabulary.
    * @return String
    */
    public String getRole() {
        StringSTAttribute att = (StringSTAttribute) this.getRoleAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** Role of the object.
    * How the object functions or its position in the architecture. No controlled vocabulary.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setRole(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_role == null) {
            _att_role = (StringSTAttribute) attributeFactory.getAttribute("role", "reactantList");
            if (_att_role == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : role probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_role);
        super.addRemove(att, value);
    }
// attribute:   count

    /** cache */
    DoubleSTAttribute _att_count = null;
    /** The count of the object.
    * No fixed semantics or default, normally integers. 
    *                 It is presumed that the element can be multiplied by the count value.
    * @return CMLAttribute
    */
    public CMLAttribute getCountAttribute() {
        return (CMLAttribute) getAttribute("count");
    }
    /** The count of the object.
    * No fixed semantics or default, normally integers. 
    *                 It is presumed that the element can be multiplied by the count value.
    * @return double
    */
    public double getCount() {
        DoubleSTAttribute att = (DoubleSTAttribute) this.getCountAttribute();
        if (att == null) {
            return Double.NaN;
        }
        return att.getDouble();
    }
    /** The count of the object.
    * No fixed semantics or default, normally integers. 
    *                 It is presumed that the element can be multiplied by the count value.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setCount(String value) throws RuntimeException {
        DoubleSTAttribute att = null;
        if (_att_count == null) {
            _att_count = (DoubleSTAttribute) attributeFactory.getAttribute("count", "reactantList");
            if (_att_count == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : count probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new DoubleSTAttribute(_att_count);
        super.addRemove(att, value);
    }
    /** The count of the object.
    * No fixed semantics or default, normally integers. 
    *                 It is presumed that the element can be multiplied by the count value.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setCount(double value) throws RuntimeException {
        if (_att_count == null) {
            _att_count = (DoubleSTAttribute) attributeFactory.getAttribute("count", "reactantList");
           if (_att_count == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : count probably incompatible attributeGroupName and attributeName ");
            }
        }
        DoubleSTAttribute att = new DoubleSTAttribute(_att_count);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// element:   metadataList

    /** The count of the object.
    * No fixed semantics or default, normally integers. 
    *                 It is presumed that the element can be multiplied by the count value.
    * @param metadataList child to add
    */
    public void addMetadataList(AbstractMetadataList metadataList) {
        metadataList.detach();
        this.appendChild(metadataList);
    }
    /** The count of the object.
    * No fixed semantics or default, normally integers. 
    *                 It is presumed that the element can be multiplied by the count value.
    * @return CMLElements<CMLMetadataList>
    */
    public CMLElements<CMLMetadataList> getMetadataListElements() {
        Elements elements = this.getChildElements("metadataList", CML_NS);
        return new CMLElements<CMLMetadataList>(elements);
    }
// element:   name

    /** The count of the object.
    * No fixed semantics or default, normally integers. 
    *                 It is presumed that the element can be multiplied by the count value.
    * @param name child to add
    */
    public void addName(AbstractName name) {
        name.detach();
        this.appendChild(name);
    }
    /** The count of the object.
    * No fixed semantics or default, normally integers. 
    *                 It is presumed that the element can be multiplied by the count value.
    * @return CMLElements<CMLName>
    */
    public CMLElements<CMLName> getNameElements() {
        Elements elements = this.getChildElements("name", CML_NS);
        return new CMLElements<CMLName>(elements);
    }
// element:   reactantList

    /** The count of the object.
    * No fixed semantics or default, normally integers. 
    *                 It is presumed that the element can be multiplied by the count value.
    * @param reactantList child to add
    */
    public void addReactantList(AbstractReactantList reactantList) {
        reactantList.detach();
        this.appendChild(reactantList);
    }
    /** The count of the object.
    * No fixed semantics or default, normally integers. 
    *                 It is presumed that the element can be multiplied by the count value.
    * @return CMLElements<CMLReactantList>
    */
    public CMLElements<CMLReactantList> getReactantListElements() {
        Elements elements = this.getChildElements("reactantList", CML_NS);
        return new CMLElements<CMLReactantList>(elements);
    }
// element:   reactant

    /** The count of the object.
    * No fixed semantics or default, normally integers. 
    *                 It is presumed that the element can be multiplied by the count value.
    * @param reactant child to add
    */
    public void addReactant(AbstractReactant reactant) {
        reactant.detach();
        this.appendChild(reactant);
    }
    /** The count of the object.
    * No fixed semantics or default, normally integers. 
    *                 It is presumed that the element can be multiplied by the count value.
    * @return CMLElements<CMLReactant>
    */
    public CMLElements<CMLReactant> getReactantElements() {
        Elements elements = this.getChildElements("reactant", CML_NS);
        return new CMLElements<CMLReactant>(elements);
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
        } else if (name.equals("role")) {
            setRole(value);
        } else if (name.equals("count")) {
            setCount(value);
	     } else {
            super.addAttribute(att);
        }
    }
}
