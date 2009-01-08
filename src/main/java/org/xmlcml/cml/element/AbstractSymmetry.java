package org.xmlcml.cml.element;


import nu.xom.Attribute;
import nu.xom.Elements;

import org.xmlcml.cml.attribute.DictRefAttribute;
import org.xmlcml.cml.attribute.IdAttribute;
import org.xmlcml.cml.base.CMLAttribute;
import org.xmlcml.cml.base.CMLConstants;
import org.xmlcml.cml.base.CMLElement;
import org.xmlcml.cml.base.CMLElements;
import org.xmlcml.cml.base.IntSTAttribute;
import org.xmlcml.cml.base.StringSTAttribute;

// end of part 1
/** CLASS DOCUMENTATION */
public abstract class AbstractSymmetry extends CMLElement {
    /** local name*/
    public final static String TAG = "symmetry";
    /** constructor. */    public AbstractSymmetry() {
        super("symmetry");
    }
/** copy constructor.
* deep copy using XOM copy()
* @param old element to copy
*/
    public AbstractSymmetry(AbstractSymmetry old) {
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
            _att_dictref = (DictRefAttribute) attributeFactory.getAttribute("dictRef", "symmetry");
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
            _att_convention = (StringSTAttribute) attributeFactory.getAttribute("convention", "symmetry");
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
            _att_title = (StringSTAttribute) attributeFactory.getAttribute("title", "symmetry");
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
            _att_id = (IdAttribute) attributeFactory.getAttribute("id", "symmetry");
            if (_att_id == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : id probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new IdAttribute(_att_id);
        super.addRemove(att, value);
    }
// attribute:   pointGroup

    /** cache */
    StringSTAttribute _att_pointgroup = null;
    /** A point group.
    * No fixed semantics, though Schoenflies is recommended over Hermann-Mauguin. We may provide a controlled-extensible list in the future.
    * @return CMLAttribute
    */
    public CMLAttribute getPointGroupAttribute() {
        return (CMLAttribute) getAttribute("pointGroup");
    }
    /** A point group.
    * No fixed semantics, though Schoenflies is recommended over Hermann-Mauguin. We may provide a controlled-extensible list in the future.
    * @return String
    */
    public String getPointGroup() {
        StringSTAttribute att = (StringSTAttribute) this.getPointGroupAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** A point group.
    * No fixed semantics, though Schoenflies is recommended over Hermann-Mauguin. We may provide a controlled-extensible list in the future.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setPointGroup(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_pointgroup == null) {
            _att_pointgroup = (StringSTAttribute) attributeFactory.getAttribute("pointGroup", "symmetry");
            if (_att_pointgroup == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : pointGroup probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_pointgroup);
        super.addRemove(att, value);
    }
// attribute:   spaceGroup

    /** cache */
    StringSTAttribute _att_spacegroup = null;
    /** A space group.
    * No fixed semantics, though Hermann-Mauguin or Hall is recommended over Schoenflies. We may provide a controlled-extensible list in the future.
    * @return CMLAttribute
    */
    public CMLAttribute getSpaceGroupAttribute() {
        return (CMLAttribute) getAttribute("spaceGroup");
    }
    /** A space group.
    * No fixed semantics, though Hermann-Mauguin or Hall is recommended over Schoenflies. We may provide a controlled-extensible list in the future.
    * @return String
    */
    public String getSpaceGroup() {
        StringSTAttribute att = (StringSTAttribute) this.getSpaceGroupAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** A space group.
    * No fixed semantics, though Hermann-Mauguin or Hall is recommended over Schoenflies. We may provide a controlled-extensible list in the future.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setSpaceGroup(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_spacegroup == null) {
            _att_spacegroup = (StringSTAttribute) attributeFactory.getAttribute("spaceGroup", "symmetry");
            if (_att_spacegroup == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : spaceGroup probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_spacegroup);
        super.addRemove(att, value);
    }
// attribute:   irreducibleRepresentation

    /** cache */
    StringSTAttribute _att_irreduciblerepresentation = null;
    /** A symmetry species.
    * No fixed semantics, though we may provide a controlled-extensible list in the future.
    * @return CMLAttribute
    */
    public CMLAttribute getIrreducibleRepresentationAttribute() {
        return (CMLAttribute) getAttribute("irreducibleRepresentation");
    }
    /** A symmetry species.
    * No fixed semantics, though we may provide a controlled-extensible list in the future.
    * @return String
    */
    public String getIrreducibleRepresentation() {
        StringSTAttribute att = (StringSTAttribute) this.getIrreducibleRepresentationAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** A symmetry species.
    * No fixed semantics, though we may provide a controlled-extensible list in the future.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setIrreducibleRepresentation(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_irreduciblerepresentation == null) {
            _att_irreduciblerepresentation = (StringSTAttribute) attributeFactory.getAttribute("irreducibleRepresentation", "symmetry");
            if (_att_irreduciblerepresentation == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : irreducibleRepresentation probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_irreduciblerepresentation);
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
            _att_number = (IntSTAttribute) attributeFactory.getAttribute("number", "symmetry");
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
            _att_number = (IntSTAttribute) attributeFactory.getAttribute("number", "symmetry");
           if (_att_number == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : number probably incompatible attributeGroupName and attributeName ");
            }
        }
        IntSTAttribute att = new IntSTAttribute(_att_number);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// element:   matrix

    /** A number determined by context.
    * Used for isotope number in isotope, and rotational symmetry number in symmetry for calculation of entropy, etc.
    * @param matrix child to add
    */
    public void addMatrix(AbstractMatrix matrix) {
        matrix.detach();
        this.appendChild(matrix);
    }
    /** A number determined by context.
    * Used for isotope number in isotope, and rotational symmetry number in symmetry for calculation of entropy, etc.
    * @return CMLElements<CMLMatrix>
    */
    public CMLElements<CMLMatrix> getMatrixElements() {
        Elements elements = this.getChildElements("matrix", CMLConstants.CML_NS);
        return new CMLElements<CMLMatrix>(elements);
    }
// element:   transform3

    /** A number determined by context.
    * Used for isotope number in isotope, and rotational symmetry number in symmetry for calculation of entropy, etc.
    * @param transform3 child to add
    */
    public void addTransform3(AbstractTransform3 transform3) {
        transform3.detach();
        this.appendChild(transform3);
    }
    /** A number determined by context.
    * Used for isotope number in isotope, and rotational symmetry number in symmetry for calculation of entropy, etc.
    * @return CMLElements<CMLTransform3>
    */
    public CMLElements<CMLTransform3> getTransform3Elements() {
        Elements elements = this.getChildElements("transform3", CMLConstants.CML_NS);
        return new CMLElements<CMLTransform3>(elements);
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
        } else if (name.equals("pointGroup")) {
            setPointGroup(value);
        } else if (name.equals("spaceGroup")) {
            setSpaceGroup(value);
        } else if (name.equals("irreducibleRepresentation")) {
            setIrreducibleRepresentation(value);
        } else if (name.equals("number")) {
            setNumber(value);
	     } else {
            super.addAttribute(att);
        }
    }
}
