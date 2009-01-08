package org.xmlcml.cml.element;


import nu.xom.Attribute;
import nu.xom.Elements;

import org.xmlcml.cml.attribute.DictRefAttribute;
import org.xmlcml.cml.attribute.IdAttribute;
import org.xmlcml.cml.base.CMLAttribute;
import org.xmlcml.cml.base.CMLConstants;
import org.xmlcml.cml.base.CMLElement;
import org.xmlcml.cml.base.CMLElements;
import org.xmlcml.cml.base.DoubleSTAttribute;
import org.xmlcml.cml.base.IntSTAttribute;
import org.xmlcml.cml.base.StringSTAttribute;

// end of part 1
/** CLASS DOCUMENTATION */
public abstract class AbstractFormula extends CMLElement {
    /** local name*/
    public final static String TAG = "formula";
    /** constructor. */    public AbstractFormula() {
        super("formula");
    }
/** copy constructor.
* deep copy using XOM copy()
* @param old element to copy
*/
    public AbstractFormula(AbstractFormula old) {
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
            _att_title = (StringSTAttribute) attributeFactory.getAttribute("title", "formula");
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
            _att_id = (IdAttribute) attributeFactory.getAttribute("id", "formula");
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
            _att_convention = (StringSTAttribute) attributeFactory.getAttribute("convention", "formula");
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
            _att_dictref = (DictRefAttribute) attributeFactory.getAttribute("dictRef", "formula");
            if (_att_dictref == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : dictRef probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new DictRefAttribute(_att_dictref);
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
            _att_count = (DoubleSTAttribute) attributeFactory.getAttribute("count", "formula");
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
            _att_count = (DoubleSTAttribute) attributeFactory.getAttribute("count", "formula");
           if (_att_count == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : count probably incompatible attributeGroupName and attributeName ");
            }
        }
        DoubleSTAttribute att = new DoubleSTAttribute(_att_count);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// attribute:   formalCharge

    /** cache */
    IntSTAttribute _att_formalcharge = null;
    /** The formalCharge on the object.
    * NOT the calculated charge or oxidation state. No formal default, but assumed to be zero if omitted. It may become good practice to include it.
    * @return CMLAttribute
    */
    public CMLAttribute getFormalChargeAttribute() {
        return (CMLAttribute) getAttribute("formalCharge");
    }
    /** The formalCharge on the object.
    * NOT the calculated charge or oxidation state. No formal default, but assumed to be zero if omitted. It may become good practice to include it.
    * @return int
    */
    public int getFormalCharge() {
        IntSTAttribute att = (IntSTAttribute) this.getFormalChargeAttribute();
        if (att == null) {
            throw new RuntimeException("int attribute is unset: formalCharge");
        }
        return att.getInt();
    }
    /** The formalCharge on the object.
    * NOT the calculated charge or oxidation state. No formal default, but assumed to be zero if omitted. It may become good practice to include it.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setFormalCharge(String value) throws RuntimeException {
        IntSTAttribute att = null;
        if (_att_formalcharge == null) {
            _att_formalcharge = (IntSTAttribute) attributeFactory.getAttribute("formalCharge", "formula");
            if (_att_formalcharge == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : formalCharge probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new IntSTAttribute(_att_formalcharge);
        super.addRemove(att, value);
    }
    /** The formalCharge on the object.
    * NOT the calculated charge or oxidation state. No formal default, but assumed to be zero if omitted. It may become good practice to include it.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setFormalCharge(int value) throws RuntimeException {
        if (_att_formalcharge == null) {
            _att_formalcharge = (IntSTAttribute) attributeFactory.getAttribute("formalCharge", "formula");
           if (_att_formalcharge == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : formalCharge probably incompatible attributeGroupName and attributeName ");
            }
        }
        IntSTAttribute att = new IntSTAttribute(_att_formalcharge);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// attribute:   concise

    /** cache */
    StringSTAttribute _att_concise = null;
    /** A concise formula.
    * No description
    * @return CMLAttribute
    */
    public CMLAttribute getConciseAttribute() {
        return (CMLAttribute) getAttribute("concise");
    }
    /** A concise formula.
    * No description
    * @return String
    */
    public String getConcise() {
        StringSTAttribute att = (StringSTAttribute) this.getConciseAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** A concise formula.
    * No description
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setConcise(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_concise == null) {
            _att_concise = (StringSTAttribute) attributeFactory.getAttribute("concise", "formula");
            if (_att_concise == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : concise probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_concise);
        super.addRemove(att, value);
    }
// attribute:   inline

    /** cache */
    StringSTAttribute _att_inline = null;
    /** An inline representation of the object.
    * No description
    * @return CMLAttribute
    */
    public CMLAttribute getInlineAttribute() {
        return (CMLAttribute) getAttribute("inline");
    }
    /** An inline representation of the object.
    * No description
    * @return String
    */
    public String getInline() {
        StringSTAttribute att = (StringSTAttribute) this.getInlineAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** An inline representation of the object.
    * No description
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setInline(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_inline == null) {
            _att_inline = (StringSTAttribute) attributeFactory.getAttribute("inline", "formula");
            if (_att_inline == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : inline probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_inline);
        super.addRemove(att, value);
    }
// element:   formula

    /** An inline representation of the object.
    * No description
    * @param formula child to add
    */
    public void addFormula(AbstractFormula formula) {
        formula.detach();
        this.appendChild(formula);
    }
    /** An inline representation of the object.
    * No description
    * @return CMLElements<CMLFormula>
    */
    public CMLElements<CMLFormula> getFormulaElements() {
        Elements elements = this.getChildElements("formula", CMLConstants.CML_NS);
        return new CMLElements<CMLFormula>(elements);
    }
// element:   atomArray

    /** An inline representation of the object.
    * No description
    * @param atomArray child to add
    */
    public void addAtomArray(AbstractAtomArray atomArray) {
        atomArray.detach();
        this.appendChild(atomArray);
    }
    /** An inline representation of the object.
    * No description
    * @return CMLElements<CMLAtomArray>
    */
    public CMLElements<CMLAtomArray> getAtomArrayElements() {
        Elements elements = this.getChildElements("atomArray", CMLConstants.CML_NS);
        return new CMLElements<CMLAtomArray>(elements);
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
        } else if (name.equals("count")) {
            setCount(value);
        } else if (name.equals("formalCharge")) {
            setFormalCharge(value);
        } else if (name.equals("concise")) {
            setConcise(value);
        } else if (name.equals("inline")) {
            setInline(value);
	     } else {
            super.addAttribute(att);
        }
    }
}
