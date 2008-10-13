package org.xmlcml.cml.element.main;


import nu.xom.Attribute;
import nu.xom.Elements;

import org.xmlcml.cml.attribute.DictRefAttribute;
import org.xmlcml.cml.attribute.IdAttribute;
import org.xmlcml.cml.attribute.RefAttribute;
import org.xmlcml.cml.base.CMLAttribute;
import org.xmlcml.cml.base.CMLElement;
import org.xmlcml.cml.base.CMLElements;
import org.xmlcml.cml.base.IntSTAttribute;
import org.xmlcml.cml.base.StringSTAttribute;

// end of part 1
/** CLASS DOCUMENTATION */
public abstract class AbstractIsotope extends CMLElement {
    /** local name*/
    public final static String TAG = "isotope";
    /** constructor. */    public AbstractIsotope() {
        super("isotope");
    }
/** copy constructor.
* deep copy using XOM copy()
* @param old element to copy
*/
    public AbstractIsotope(AbstractIsotope old) {
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
            _att_title = (StringSTAttribute) attributeFactory.getAttribute("title", "isotope");
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
            _att_id = (IdAttribute) attributeFactory.getAttribute("id", "isotope");
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
            _att_convention = (StringSTAttribute) attributeFactory.getAttribute("convention", "isotope");
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
            _att_dictref = (DictRefAttribute) attributeFactory.getAttribute("dictRef", "isotope");
            if (_att_dictref == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : dictRef probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new DictRefAttribute(_att_dictref);
        super.addRemove(att, value);
    }
// attribute:   number

    /** cache */
    IntSTAttribute _att_number = null;
    /** A number determined by context.
    * Used for isotope number in isotope, and rotational symmetry number in symmetry for calculation of entropy, etc.
    * @return CMLAttribute
    */
    public CMLAttribute getNumberAttribute() {
        return (CMLAttribute) getAttribute("number");
    }
    /** A number determined by context.
    * Used for isotope number in isotope, and rotational symmetry number in symmetry for calculation of entropy, etc.
    * @return int
    */
    public int getNumber() {
        IntSTAttribute att = (IntSTAttribute) this.getNumberAttribute();
        if (att == null) {
            throw new RuntimeException("int attribute is unset: number");
        }
        return att.getInt();
    }
    /** A number determined by context.
    * Used for isotope number in isotope, and rotational symmetry number in symmetry for calculation of entropy, etc.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setNumber(String value) throws RuntimeException {
        IntSTAttribute att = null;
        if (_att_number == null) {
            _att_number = (IntSTAttribute) attributeFactory.getAttribute("number", "isotope");
            if (_att_number == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : number probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new IntSTAttribute(_att_number);
        super.addRemove(att, value);
    }
    /** A number determined by context.
    * Used for isotope number in isotope, and rotational symmetry number in symmetry for calculation of entropy, etc.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setNumber(int value) throws RuntimeException {
        if (_att_number == null) {
            _att_number = (IntSTAttribute) attributeFactory.getAttribute("number", "isotope");
           if (_att_number == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : number probably incompatible attributeGroupName and attributeName ");
            }
        }
        IntSTAttribute att = new IntSTAttribute(_att_number);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// attribute:   spin

    /** cache */
    StringSTAttribute _att_spin = null;
    /** The spin of a system.
    * Supports fractional values. Currently the spin of a nucleus. The normal fraction representing the spin of the isotope.
    * @return CMLAttribute
    */
    public CMLAttribute getSpinAttribute() {
        return (CMLAttribute) getAttribute("spin");
    }
    /** The spin of a system.
    * Supports fractional values. Currently the spin of a nucleus. The normal fraction representing the spin of the isotope.
    * @return String
    */
    public String getSpin() {
        StringSTAttribute att = (StringSTAttribute) this.getSpinAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** The spin of a system.
    * Supports fractional values. Currently the spin of a nucleus. The normal fraction representing the spin of the isotope.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setSpin(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_spin == null) {
            _att_spin = (StringSTAttribute) attributeFactory.getAttribute("spin", "isotope");
            if (_att_spin == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : spin probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_spin);
        super.addRemove(att, value);
    }
// attribute:   elementType

    /** cache */
    StringSTAttribute _att_elementtype = null;
    /** The identity of a chemical element.
    * Normally mandatory on _atom_, _isotope_, etc.
    * @return CMLAttribute
    */
    public CMLAttribute getElementTypeAttribute() {
        return (CMLAttribute) getAttribute("elementType");
    }
    /** The identity of a chemical element.
    * Normally mandatory on _atom_, _isotope_, etc.
    * @return String
    */
    public String getElementType() {
        StringSTAttribute att = (StringSTAttribute) this.getElementTypeAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** The identity of a chemical element.
    * Normally mandatory on _atom_, _isotope_, etc.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setElementType(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_elementtype == null) {
            _att_elementtype = (StringSTAttribute) attributeFactory.getAttribute("elementType", "isotope");
            if (_att_elementtype == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : elementType probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_elementtype);
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
            _att_ref = (RefAttribute) attributeFactory.getAttribute("ref", "isotope");
            if (_att_ref == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : ref probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new RefAttribute(_att_ref);
        super.addRemove(att, value);
    }
// element:   abundance

    /** null
    * @param abundance child to add
    */
    public void addAbundance(AbstractAbundance abundance) {
        abundance.detach();
        this.appendChild(abundance);
    }
    /** null
    * @return CMLElements<CMLAbundance>
    */
    public CMLElements<CMLAbundance> getAbundanceElements() {
        Elements elements = this.getChildElements("abundance", CML_NS);
        return new CMLElements<CMLAbundance>(elements);
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
        } else if (name.equals("number")) {
            setNumber(value);
        } else if (name.equals("spin")) {
            setSpin(value);
        } else if (name.equals("elementType")) {
            setElementType(value);
        } else if (name.equals("ref")) {
            setRef(value);
	     } else {
            super.addAttribute(att);
        }
    }
}
