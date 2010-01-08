package org.xmlcml.cml.element;


import nu.xom.Attribute;
import nu.xom.Elements;

import org.xmlcml.cml.attribute.DictRefAttribute;
import org.xmlcml.cml.attribute.IdAttribute;
import org.xmlcml.cml.attribute.RefAttribute;
import org.xmlcml.cml.base.BooleanSTAttribute;
import org.xmlcml.cml.base.CMLAttribute;
import org.xmlcml.cml.base.CMLConstants;
import org.xmlcml.cml.base.CMLElement;
import org.xmlcml.cml.base.CMLElements;
import org.xmlcml.cml.base.DoubleSTAttribute;
import org.xmlcml.cml.base.IntSTAttribute;
import org.xmlcml.cml.base.StringSTAttribute;

// end of part 1
/** CLASS DOCUMENTATION */
public abstract class AbstractMolecule extends CMLElement {
    /** local name*/
    public final static String TAG = "molecule";
    /** constructor. */    public AbstractMolecule() {
        super("molecule");
    }
/** copy constructor.
* deep copy using XOM copy()
* @param old element to copy
*/
    public AbstractMolecule(AbstractMolecule old) {
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
            _att_dictref = (DictRefAttribute) attributeFactory.getAttribute("dictRef", "molecule");
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
            _att_convention = (StringSTAttribute) attributeFactory.getAttribute("convention", "molecule");
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
            _att_title = (StringSTAttribute) attributeFactory.getAttribute("title", "molecule");
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
            _att_id = (IdAttribute) attributeFactory.getAttribute("id", "molecule");
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
            _att_ref = (RefAttribute) attributeFactory.getAttribute("ref", "molecule");
            if (_att_ref == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : ref probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new RefAttribute(_att_ref);
        super.addRemove(att, value);
    }
// attribute:   idgen

    /** cache */
    StringSTAttribute _att_idgen = null;
    /** Allows a referring element to generate a unique id.
    * idgen can hold a unique identifier which is copied into the id
    *                 attribute of the referenced element. This avoids multiple copies of the referenced 
    *                 object with duplicate ids. EXPERIMENTAL
    *                 
    * @return CMLAttribute
    */
    public CMLAttribute getIdgenAttribute() {
        return (CMLAttribute) getAttribute("idgen");
    }
    /** Allows a referring element to generate a unique id.
    * idgen can hold a unique identifier which is copied into the id
    *                 attribute of the referenced element. This avoids multiple copies of the referenced 
    *                 object with duplicate ids. EXPERIMENTAL
    *                 
    * @return String
    */
    public String getIdgen() {
        StringSTAttribute att = (StringSTAttribute) this.getIdgenAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** Allows a referring element to generate a unique id.
    * idgen can hold a unique identifier which is copied into the id
    *                 attribute of the referenced element. This avoids multiple copies of the referenced 
    *                 object with duplicate ids. EXPERIMENTAL
    *                 
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setIdgen(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_idgen == null) {
            _att_idgen = (StringSTAttribute) attributeFactory.getAttribute("idgen", "molecule");
            if (_att_idgen == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : idgen probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_idgen);
        super.addRemove(att, value);
    }
// attribute:   process

    /** cache */
    StringSTAttribute _att_process = null;
    /** Keyword signifying how object is to be processed.
    * Semantics depend on the parent element
    * @return CMLAttribute
    */
    public CMLAttribute getProcessAttribute() {
        return (CMLAttribute) getAttribute("process");
    }
    /** Keyword signifying how object is to be processed.
    * Semantics depend on the parent element
    * @return String
    */
    public String getProcess() {
        StringSTAttribute att = (StringSTAttribute) this.getProcessAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** Keyword signifying how object is to be processed.
    * Semantics depend on the parent element
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setProcess(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_process == null) {
            _att_process = (StringSTAttribute) attributeFactory.getAttribute("process", "molecule");
            if (_att_process == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : process probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_process);
        super.addRemove(att, value);
    }
// attribute:   formula

    /** cache */
    StringSTAttribute _att_formula = null;
    /** Simple chemical formula.
    * No description
    * @return CMLAttribute
    */
    public CMLAttribute getFormulaAttribute() {
        return (CMLAttribute) getAttribute("formula");
    }
    /** Simple chemical formula.
    * No description
    * @return String
    */
    public String getFormula() {
        StringSTAttribute att = (StringSTAttribute) this.getFormulaAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** Simple chemical formula.
    * No description
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setFormula(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_formula == null) {
            _att_formula = (StringSTAttribute) attributeFactory.getAttribute("formula", "molecule");
            if (_att_formula == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : formula probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_formula);
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
            _att_count = (DoubleSTAttribute) attributeFactory.getAttribute("count", "molecule");
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
            _att_count = (DoubleSTAttribute) attributeFactory.getAttribute("count", "molecule");
           if (_att_count == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : count probably incompatible attributeGroupName and attributeName ");
            }
        }
        DoubleSTAttribute att = new DoubleSTAttribute(_att_count);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// attribute:   chirality

    /** cache */
    StringSTAttribute _att_chirality = null;
    /** The chirality of a system or molecule.
    * This is being actively investigated by a IUPAC committee (2002) so the convention is likely to change. No formal default.
    * @return CMLAttribute
    */
    public CMLAttribute getChiralityAttribute() {
        return (CMLAttribute) getAttribute("chirality");
    }
    /** The chirality of a system or molecule.
    * This is being actively investigated by a IUPAC committee (2002) so the convention is likely to change. No formal default.
    * @return String
    */
    public String getChirality() {
        StringSTAttribute att = (StringSTAttribute) this.getChiralityAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** The chirality of a system or molecule.
    * This is being actively investigated by a IUPAC committee (2002) so the convention is likely to change. No formal default.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setChirality(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_chirality == null) {
            _att_chirality = (StringSTAttribute) attributeFactory.getAttribute("chirality", "molecule");
            if (_att_chirality == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : chirality probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_chirality);
        super.addRemove(att, value);
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
            _att_formalcharge = (IntSTAttribute) attributeFactory.getAttribute("formalCharge", "molecule");
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
            _att_formalcharge = (IntSTAttribute) attributeFactory.getAttribute("formalCharge", "molecule");
           if (_att_formalcharge == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : formalCharge probably incompatible attributeGroupName and attributeName ");
            }
        }
        IntSTAttribute att = new IntSTAttribute(_att_formalcharge);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// attribute:   spinMultiplicity

    /** cache */
    IntSTAttribute _att_spinmultiplicity = null;
    /** Spin multiplicity.
    * Normally for a molecule. This attribute gives the spin multiplicity of the molecule and is independent of any atomic information. No default, and it may take any positive integer value (though values are normally between 1 and 5.
    * @return CMLAttribute
    */
    public CMLAttribute getSpinMultiplicityAttribute() {
        return (CMLAttribute) getAttribute("spinMultiplicity");
    }
    /** Spin multiplicity.
    * Normally for a molecule. This attribute gives the spin multiplicity of the molecule and is independent of any atomic information. No default, and it may take any positive integer value (though values are normally between 1 and 5.
    * @return int
    */
    public int getSpinMultiplicity() {
        IntSTAttribute att = (IntSTAttribute) this.getSpinMultiplicityAttribute();
        if (att == null) {
            throw new RuntimeException("int attribute is unset: spinMultiplicity");
        }
        return att.getInt();
    }
    /** Spin multiplicity.
    * Normally for a molecule. This attribute gives the spin multiplicity of the molecule and is independent of any atomic information. No default, and it may take any positive integer value (though values are normally between 1 and 5.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setSpinMultiplicity(String value) throws RuntimeException {
        IntSTAttribute att = null;
        if (_att_spinmultiplicity == null) {
            _att_spinmultiplicity = (IntSTAttribute) attributeFactory.getAttribute("spinMultiplicity", "molecule");
            if (_att_spinmultiplicity == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : spinMultiplicity probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new IntSTAttribute(_att_spinmultiplicity);
        super.addRemove(att, value);
    }
    /** Spin multiplicity.
    * Normally for a molecule. This attribute gives the spin multiplicity of the molecule and is independent of any atomic information. No default, and it may take any positive integer value (though values are normally between 1 and 5.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setSpinMultiplicity(int value) throws RuntimeException {
        if (_att_spinmultiplicity == null) {
            _att_spinmultiplicity = (IntSTAttribute) attributeFactory.getAttribute("spinMultiplicity", "molecule");
           if (_att_spinmultiplicity == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : spinMultiplicity probably incompatible attributeGroupName and attributeName ");
            }
        }
        IntSTAttribute att = new IntSTAttribute(_att_spinmultiplicity);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// attribute:   symmetryOriented

    /** cache */
    BooleanSTAttribute _att_symmetryoriented = null;
    /** Is the molecule oriented to the symmetry.
    * No formal default, but a molecule is assumed to be oriented according to any _symmetry_ children. This is required for crystallographic data, but some systems for isolated molecules allow specification of arbitrary Cartesian or internal coordinates, which must be fitted or refined to a prescribed symmetry. In this case the attribute value is false.
    * @return CMLAttribute
    */
    public CMLAttribute getSymmetryOrientedAttribute() {
        return (CMLAttribute) getAttribute("symmetryOriented");
    }
    /** Is the molecule oriented to the symmetry.
    * No formal default, but a molecule is assumed to be oriented according to any _symmetry_ children. This is required for crystallographic data, but some systems for isolated molecules allow specification of arbitrary Cartesian or internal coordinates, which must be fitted or refined to a prescribed symmetry. In this case the attribute value is false.
    * @return boolean
    */
    public boolean getSymmetryOriented() {
        BooleanSTAttribute att = (BooleanSTAttribute) this.getSymmetryOrientedAttribute();
        if (att == null) {
            throw new RuntimeException("boolean attribute is unset: symmetryOriented");
        }
        return att.getBoolean();
    }
    /** Is the molecule oriented to the symmetry.
    * No formal default, but a molecule is assumed to be oriented according to any _symmetry_ children. This is required for crystallographic data, but some systems for isolated molecules allow specification of arbitrary Cartesian or internal coordinates, which must be fitted or refined to a prescribed symmetry. In this case the attribute value is false.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setSymmetryOriented(String value) throws RuntimeException {
        BooleanSTAttribute att = null;
        if (_att_symmetryoriented == null) {
            _att_symmetryoriented = (BooleanSTAttribute) attributeFactory.getAttribute("symmetryOriented", "molecule");
            if (_att_symmetryoriented == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : symmetryOriented probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new BooleanSTAttribute(_att_symmetryoriented);
        super.addRemove(att, value);
    }
    /** Is the molecule oriented to the symmetry.
    * No formal default, but a molecule is assumed to be oriented according to any _symmetry_ children. This is required for crystallographic data, but some systems for isolated molecules allow specification of arbitrary Cartesian or internal coordinates, which must be fitted or refined to a prescribed symmetry. In this case the attribute value is false.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setSymmetryOriented(boolean value) throws RuntimeException {
        if (_att_symmetryoriented == null) {
            _att_symmetryoriented = (BooleanSTAttribute) attributeFactory.getAttribute("symmetryOriented", "molecule");
           if (_att_symmetryoriented == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : symmetryOriented probably incompatible attributeGroupName and attributeName ");
            }
        }
        BooleanSTAttribute att = new BooleanSTAttribute(_att_symmetryoriented);
        super.addAttribute(att);
        att.setCMLValue(value);
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
            _att_role = (StringSTAttribute) attributeFactory.getAttribute("role", "molecule");
            if (_att_role == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : role probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_role);
        super.addRemove(att, value);
    }
// element:   angle

// element:   array

    /** Role of the object.
    * How the object functions or its position in the architecture. No controlled vocabulary.
    * @param array child to add
    */
    public void addArray(AbstractArray array) {
        array.detach();
        this.appendChild(array);
    }
    /** Role of the object.
    * How the object functions or its position in the architecture. No controlled vocabulary.
    * @return CMLElements<CMLArray>
    */
    public CMLElements<CMLArray> getArrayElements() {
        Elements elements = this.getChildElements("array", CMLConstants.CML_NS);
        return new CMLElements<CMLArray>(elements);
    }
// element:   atomArray

    /** Role of the object.
    * How the object functions or its position in the architecture. No controlled vocabulary.
    * @param atomArray child to add
    */
    public void addAtomArray(AbstractAtomArray atomArray) {
        atomArray.detach();
        this.appendChild(atomArray);
    }
    /** Role of the object.
    * How the object functions or its position in the architecture. No controlled vocabulary.
    * @return CMLElements<CMLAtomArray>
    */
    public CMLElements<CMLAtomArray> getAtomArrayElements() {
        Elements elements = this.getChildElements("atomArray", CMLConstants.CML_NS);
        return new CMLElements<CMLAtomArray>(elements);
    }
// element:   bondArray

    /** Role of the object.
    * How the object functions or its position in the architecture. No controlled vocabulary.
    * @param bondArray child to add
    */
    public void addBondArray(AbstractBondArray bondArray) {
        bondArray.detach();
        this.appendChild(bondArray);
    }
    /** Role of the object.
    * How the object functions or its position in the architecture. No controlled vocabulary.
    * @return CMLElements<CMLBondArray>
    */
    public CMLElements<CMLBondArray> getBondArrayElements() {
        Elements elements = this.getChildElements("bondArray", CMLConstants.CML_NS);
        return new CMLElements<CMLBondArray>(elements);
    }
// element:   formula

    /** Role of the object.
    * How the object functions or its position in the architecture. No controlled vocabulary.
    * @param formula child to add
    */
    public void addFormula(AbstractFormula formula) {
        formula.detach();
        this.appendChild(formula);
    }
    /** Role of the object.
    * How the object functions or its position in the architecture. No controlled vocabulary.
    * @return CMLElements<CMLFormula>
    */
    public CMLElements<CMLFormula> getFormulaElements() {
        Elements elements = this.getChildElements("formula", CMLConstants.CML_NS);
        return new CMLElements<CMLFormula>(elements);
    }
    
    /**Returns the value of the first formula element with a convention.
     * if an inline exists returns that value in preference.
     * Returns null if no formula of that convention exists
     * @param convention The Convention to look for.
     * @return The value of the formula inline or text if no inline exists.
     * @author nwe23
     */
    public String getFormulaWithConvention(String convention){
    	if(convention==null){
    		throw new IllegalArgumentException("Called with "+convention);
    	}
    	CMLElements<CMLFormula> forms=this.getFormulaElements();
    	for(CMLFormula form:forms){
    		if(convention.equals(form.getConvention())){
    			String value=form.getInline();
    			if(value!=null){
    				return value;
    			}
    			value = form.getValue();
    			return value;
    		}
    			
    	}
    	return null;
    	
    }
    
// element:   label

    /** Role of the object.
    * How the object functions or its position in the architecture. No controlled vocabulary.
    * @param label child to add
    */
    public void addLabel(AbstractLabel label) {
        label.detach();
        this.appendChild(label);
    }
    /** Role of the object.
    * How the object functions or its position in the architecture. No controlled vocabulary.
    * @return CMLElements<CMLLabel>
    */
    public CMLElements<CMLLabel> getLabelElements() {
        Elements elements = this.getChildElements("label", CMLConstants.CML_NS);
        return new CMLElements<CMLLabel>(elements);
    }
// element:   molecule

    /** Role of the object.
    * How the object functions or its position in the architecture. No controlled vocabulary.
    * @param molecule child to add
    */
    public void addMolecule(AbstractMolecule molecule) {
        molecule.detach();
        this.appendChild(molecule);
    }
    /** Role of the object.
    * How the object functions or its position in the architecture. No controlled vocabulary.
    * @return CMLElements<CMLMolecule>
    */
    public CMLElements<CMLMolecule> getMoleculeElements() {
        Elements elements = this.getChildElements("molecule", CMLConstants.CML_NS);
        return new CMLElements<CMLMolecule>(elements);
    }
// element:   name

    /** Role of the object.
    * How the object functions or its position in the architecture. No controlled vocabulary.
    * @param name child to add
    */
    public void addName(AbstractName name) {
        name.detach();
        this.appendChild(name);
    }
    /** Role of the object.
    * How the object functions or its position in the architecture. No controlled vocabulary.
    * @return CMLElements<CMLName>
    */
    public CMLElements<CMLName> getNameElements() {
        Elements elements = this.getChildElements("name", CMLConstants.CML_NS);
        return new CMLElements<CMLName>(elements);
    }
// element:   propertyList

    /** Role of the object.
    * How the object functions or its position in the architecture. No controlled vocabulary.
    * @param propertyList child to add
    */
    public void addPropertyList(AbstractPropertyList propertyList) {
        propertyList.detach();
        this.appendChild(propertyList);
    }
    /** Role of the object.
    * How the object functions or its position in the architecture. No controlled vocabulary.
    * @return CMLElements<CMLPropertyList>
    */
    public CMLElements<CMLPropertyList> getPropertyListElements() {
        Elements elements = this.getChildElements("propertyList", CMLConstants.CML_NS);
        return new CMLElements<CMLPropertyList>(elements);
    }
// element:   scalar

    /** Role of the object.
    * How the object functions or its position in the architecture. No controlled vocabulary.
    * @param scalar child to add
    */
    public void addScalar(AbstractScalar scalar) {
        scalar.detach();
        this.appendChild(scalar);
    }
    /** Role of the object.
    * How the object functions or its position in the architecture. No controlled vocabulary.
    * @return CMLElements<CMLScalar>
    */
    public CMLElements<CMLScalar> getScalarElements() {
        Elements elements = this.getChildElements("scalar", CMLConstants.CML_NS);
        return new CMLElements<CMLScalar>(elements);
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
        } else if (name.equals("idgen")) {
            setIdgen(value);
        } else if (name.equals("process")) {
            setProcess(value);
        } else if (name.equals("formula")) {
            setFormula(value);
        } else if (name.equals("count")) {
            setCount(value);
        } else if (name.equals("chirality")) {
            setChirality(value);
        } else if (name.equals("formalCharge")) {
            setFormalCharge(value);
        } else if (name.equals("spinMultiplicity")) {
            setSpinMultiplicity(value);
        } else if (name.equals("symmetryOriented")) {
            setSymmetryOriented(value);
        } else if (name.equals("role")) {
            setRole(value);
	     } else {
            super.addAttribute(att);
        }
    }
}
