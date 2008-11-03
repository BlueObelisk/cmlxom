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
import org.xmlcml.cml.base.IntSTAttribute;
import org.xmlcml.cml.base.StringSTAttribute;

// end of part 1
/** CLASS DOCUMENTATION */
public abstract class AbstractAtom extends CMLElement {
    /** local name*/
    public final static String TAG = "atom";
    /** constructor. */    public AbstractAtom() {
        super("atom");
    }
/** copy constructor.
* deep copy using XOM copy()
* @param old element to copy
*/
    public AbstractAtom(AbstractAtom old) {
        super((CMLElement) old);
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
            _att_id = (IdAttribute) attributeFactory.getAttribute("id", "atom");
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
            _att_convention = (StringSTAttribute) attributeFactory.getAttribute("convention", "atom");
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
            _att_dictref = (DictRefAttribute) attributeFactory.getAttribute("dictRef", "atom");
            if (_att_dictref == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : dictRef probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new DictRefAttribute(_att_dictref);
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
            _att_ref = (RefAttribute) attributeFactory.getAttribute("ref", "atom");
            if (_att_ref == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : ref probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new RefAttribute(_att_ref);
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
            _att_count = (DoubleSTAttribute) attributeFactory.getAttribute("count", "atom");
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
            _att_count = (DoubleSTAttribute) attributeFactory.getAttribute("count", "atom");
           if (_att_count == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : count probably incompatible attributeGroupName and attributeName ");
            }
        }
        DoubleSTAttribute att = new DoubleSTAttribute(_att_count);
        super.addAttribute(att);
        att.setCMLValue(value);
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
            _att_elementtype = (StringSTAttribute) attributeFactory.getAttribute("elementType", "atom");
            if (_att_elementtype == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : elementType probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_elementtype);
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
            _att_formalcharge = (IntSTAttribute) attributeFactory.getAttribute("formalCharge", "atom");
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
            _att_formalcharge = (IntSTAttribute) attributeFactory.getAttribute("formalCharge", "atom");
           if (_att_formalcharge == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : formalCharge probably incompatible attributeGroupName and attributeName ");
            }
        }
        IntSTAttribute att = new IntSTAttribute(_att_formalcharge);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// attribute:   hydrogenCount

    /** cache */
    IntSTAttribute _att_hydrogencount = null;
    /** Number of hydrogens.
    * The total number of hydrogens bonded to the atom or molecule. It is preferable to include hydrogens explicitly, and where this is done their count represents the minimum (and may thus override this attribute). It is dangerous to use this attribute for electron-deficient molecules (e.g. diborane) or hydrogen bonds. There is NO DEFAULT and the absence of this attribute must not be given any meaning.
    * @return CMLAttribute
    */
    public CMLAttribute getHydrogenCountAttribute() {
        return (CMLAttribute) getAttribute("hydrogenCount");
    }
    /** Number of hydrogens.
    * The total number of hydrogens bonded to the atom or molecule. It is preferable to include hydrogens explicitly, and where this is done their count represents the minimum (and may thus override this attribute). It is dangerous to use this attribute for electron-deficient molecules (e.g. diborane) or hydrogen bonds. There is NO DEFAULT and the absence of this attribute must not be given any meaning.
    * @return int
    */
    public int getHydrogenCount() {
        IntSTAttribute att = (IntSTAttribute) this.getHydrogenCountAttribute();
        if (att == null) {
            throw new RuntimeException("int attribute is unset: hydrogenCount");
        }
        return att.getInt();
    }
    /** Number of hydrogens.
    * The total number of hydrogens bonded to the atom or molecule. It is preferable to include hydrogens explicitly, and where this is done their count represents the minimum (and may thus override this attribute). It is dangerous to use this attribute for electron-deficient molecules (e.g. diborane) or hydrogen bonds. There is NO DEFAULT and the absence of this attribute must not be given any meaning.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setHydrogenCount(String value) throws RuntimeException {
        IntSTAttribute att = null;
        if (_att_hydrogencount == null) {
            _att_hydrogencount = (IntSTAttribute) attributeFactory.getAttribute("hydrogenCount", "atom");
            if (_att_hydrogencount == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : hydrogenCount probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new IntSTAttribute(_att_hydrogencount);
        super.addRemove(att, value);
    }
    /** Number of hydrogens.
    * The total number of hydrogens bonded to the atom or molecule. It is preferable to include hydrogens explicitly, and where this is done their count represents the minimum (and may thus override this attribute). It is dangerous to use this attribute for electron-deficient molecules (e.g. diborane) or hydrogen bonds. There is NO DEFAULT and the absence of this attribute must not be given any meaning.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setHydrogenCount(int value) throws RuntimeException {
        if (_att_hydrogencount == null) {
            _att_hydrogencount = (IntSTAttribute) attributeFactory.getAttribute("hydrogenCount", "atom");
           if (_att_hydrogencount == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : hydrogenCount probably incompatible attributeGroupName and attributeName ");
            }
        }
        IntSTAttribute att = new IntSTAttribute(_att_hydrogencount);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// attribute:   isotope

    /** cache */
    DoubleSTAttribute _att_isotope = null;
    /** The isotope for an element.
    * A real number describing the isotope. Probably obsolet.
    * @return CMLAttribute
    */
    public CMLAttribute getIsotopeAttribute() {
        return (CMLAttribute) getAttribute("isotope");
    }
    /** The isotope for an element.
    * A real number describing the isotope. Probably obsolet.
    * @return double
    */
    public double getIsotope() {
        DoubleSTAttribute att = (DoubleSTAttribute) this.getIsotopeAttribute();
        if (att == null) {
            return Double.NaN;
        }
        return att.getDouble();
    }
    /** The isotope for an element.
    * A real number describing the isotope. Probably obsolet.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setIsotope(String value) throws RuntimeException {
        DoubleSTAttribute att = null;
        if (_att_isotope == null) {
            _att_isotope = (DoubleSTAttribute) attributeFactory.getAttribute("isotope", "atom");
            if (_att_isotope == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : isotope probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new DoubleSTAttribute(_att_isotope);
        super.addRemove(att, value);
    }
    /** The isotope for an element.
    * A real number describing the isotope. Probably obsolet.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setIsotope(double value) throws RuntimeException {
        if (_att_isotope == null) {
            _att_isotope = (DoubleSTAttribute) attributeFactory.getAttribute("isotope", "atom");
           if (_att_isotope == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : isotope probably incompatible attributeGroupName and attributeName ");
            }
        }
        DoubleSTAttribute att = new DoubleSTAttribute(_att_isotope);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// attribute:   isotopeNumber

    /** cache */
    IntSTAttribute _att_isotopenumber = null;
    /** The integer number for an isotope.
    * The number representing the isotope. By default it does not point to a fuller description of the isotope (use isotopeRef).
    * @return CMLAttribute
    */
    public CMLAttribute getIsotopeNumberAttribute() {
        return (CMLAttribute) getAttribute("isotopeNumber");
    }
    /** The integer number for an isotope.
    * The number representing the isotope. By default it does not point to a fuller description of the isotope (use isotopeRef).
    * @return int
    */
    public int getIsotopeNumber() {
        IntSTAttribute att = (IntSTAttribute) this.getIsotopeNumberAttribute();
        if (att == null) {
            throw new RuntimeException("int attribute is unset: isotopeNumber");
        }
        return att.getInt();
    }
    /** The integer number for an isotope.
    * The number representing the isotope. By default it does not point to a fuller description of the isotope (use isotopeRef).
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setIsotopeNumber(String value) throws RuntimeException {
        IntSTAttribute att = null;
        if (_att_isotopenumber == null) {
            _att_isotopenumber = (IntSTAttribute) attributeFactory.getAttribute("isotopeNumber", "atom");
            if (_att_isotopenumber == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : isotopeNumber probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new IntSTAttribute(_att_isotopenumber);
        super.addRemove(att, value);
    }
    /** The integer number for an isotope.
    * The number representing the isotope. By default it does not point to a fuller description of the isotope (use isotopeRef).
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setIsotopeNumber(int value) throws RuntimeException {
        if (_att_isotopenumber == null) {
            _att_isotopenumber = (IntSTAttribute) attributeFactory.getAttribute("isotopeNumber", "atom");
           if (_att_isotopenumber == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : isotopeNumber probably incompatible attributeGroupName and attributeName ");
            }
        }
        IntSTAttribute att = new IntSTAttribute(_att_isotopenumber);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// attribute:   isotopeRef

    /** cache */
    StringSTAttribute _att_isotoperef = null;
    /** Reference to a fuller description of the isotope.
    * No description
    * @return CMLAttribute
    */
    public CMLAttribute getIsotopeRefAttribute() {
        return (CMLAttribute) getAttribute("isotopeRef");
    }
    /** Reference to a fuller description of the isotope.
    * No description
    * @return String
    */
    public String getIsotopeRef() {
        StringSTAttribute att = (StringSTAttribute) this.getIsotopeRefAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** Reference to a fuller description of the isotope.
    * No description
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setIsotopeRef(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_isotoperef == null) {
            _att_isotoperef = (StringSTAttribute) attributeFactory.getAttribute("isotopeRef", "atom");
            if (_att_isotoperef == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : isotopeRef probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_isotoperef);
        super.addRemove(att, value);
    }
// attribute:   isotopeListRef

    /** cache */
    StringSTAttribute _att_isotopelistref = null;
    /** Reference to a description of the isotopic composition of an atom.
    * Used when more than one atom shares the same isotopic composition (e.g. when H/D have been scrambled over some or all of the atoms in a molecule..
    * @return CMLAttribute
    */
    public CMLAttribute getIsotopeListRefAttribute() {
        return (CMLAttribute) getAttribute("isotopeListRef");
    }
    /** Reference to a description of the isotopic composition of an atom.
    * Used when more than one atom shares the same isotopic composition (e.g. when H/D have been scrambled over some or all of the atoms in a molecule..
    * @return String
    */
    public String getIsotopeListRef() {
        StringSTAttribute att = (StringSTAttribute) this.getIsotopeListRefAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** Reference to a description of the isotopic composition of an atom.
    * Used when more than one atom shares the same isotopic composition (e.g. when H/D have been scrambled over some or all of the atoms in a molecule..
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setIsotopeListRef(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_isotopelistref == null) {
            _att_isotopelistref = (StringSTAttribute) attributeFactory.getAttribute("isotopeListRef", "atom");
            if (_att_isotopelistref == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : isotopeListRef probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_isotopelistref);
        super.addRemove(att, value);
    }
// attribute:   occupancy

    /** cache */
    DoubleSTAttribute _att_occupancy = null;
    /** Occupancy for an atom.
    * Normally only found in crystallography. Defaults to 1.0. The occupancy is required to calculate the molecular formaula from the atoms.
    * @return CMLAttribute
    */
    public CMLAttribute getOccupancyAttribute() {
        return (CMLAttribute) getAttribute("occupancy");
    }
    /** Occupancy for an atom.
    * Normally only found in crystallography. Defaults to 1.0. The occupancy is required to calculate the molecular formaula from the atoms.
    * @return double
    */
    public double getOccupancy() {
        DoubleSTAttribute att = (DoubleSTAttribute) this.getOccupancyAttribute();
        if (att == null) {
            return Double.NaN;
        }
        return att.getDouble();
    }
    /** Occupancy for an atom.
    * Normally only found in crystallography. Defaults to 1.0. The occupancy is required to calculate the molecular formaula from the atoms.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setOccupancy(String value) throws RuntimeException {
        DoubleSTAttribute att = null;
        if (_att_occupancy == null) {
            _att_occupancy = (DoubleSTAttribute) attributeFactory.getAttribute("occupancy", "atom");
            if (_att_occupancy == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : occupancy probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new DoubleSTAttribute(_att_occupancy);
        super.addRemove(att, value);
    }
    /** Occupancy for an atom.
    * Normally only found in crystallography. Defaults to 1.0. The occupancy is required to calculate the molecular formaula from the atoms.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setOccupancy(double value) throws RuntimeException {
        if (_att_occupancy == null) {
            _att_occupancy = (DoubleSTAttribute) attributeFactory.getAttribute("occupancy", "atom");
           if (_att_occupancy == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : occupancy probably incompatible attributeGroupName and attributeName ");
            }
        }
        DoubleSTAttribute att = new DoubleSTAttribute(_att_occupancy);
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
            _att_spinmultiplicity = (IntSTAttribute) attributeFactory.getAttribute("spinMultiplicity", "atom");
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
            _att_spinmultiplicity = (IntSTAttribute) attributeFactory.getAttribute("spinMultiplicity", "atom");
           if (_att_spinmultiplicity == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : spinMultiplicity probably incompatible attributeGroupName and attributeName ");
            }
        }
        IntSTAttribute att = new IntSTAttribute(_att_spinmultiplicity);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// attribute:   x2

    /** cache */
    DoubleSTAttribute _att_x2 = null;
    /** x2 coordinate for an object.
    * Used for displaying the object in 2 dimensions. Unrelated to the 3-D coordinates for the object. The orientation of the axes matters as it can affect the chirality of object.
    * @return CMLAttribute
    */
    public CMLAttribute getX2Attribute() {
        return (CMLAttribute) getAttribute("x2");
    }
    /** x2 coordinate for an object.
    * Used for displaying the object in 2 dimensions. Unrelated to the 3-D coordinates for the object. The orientation of the axes matters as it can affect the chirality of object.
    * @return double
    */
    public double getX2() {
        DoubleSTAttribute att = (DoubleSTAttribute) this.getX2Attribute();
        if (att == null) {
            return Double.NaN;
        }
        return att.getDouble();
    }
    /** x2 coordinate for an object.
    * Used for displaying the object in 2 dimensions. Unrelated to the 3-D coordinates for the object. The orientation of the axes matters as it can affect the chirality of object.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setX2(String value) throws RuntimeException {
        DoubleSTAttribute att = null;
        if (_att_x2 == null) {
            _att_x2 = (DoubleSTAttribute) attributeFactory.getAttribute("x2", "atom");
            if (_att_x2 == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : x2 probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new DoubleSTAttribute(_att_x2);
        super.addRemove(att, value);
    }
    /** x2 coordinate for an object.
    * Used for displaying the object in 2 dimensions. Unrelated to the 3-D coordinates for the object. The orientation of the axes matters as it can affect the chirality of object.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setX2(double value) throws RuntimeException {
        if (_att_x2 == null) {
            _att_x2 = (DoubleSTAttribute) attributeFactory.getAttribute("x2", "atom");
           if (_att_x2 == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : x2 probably incompatible attributeGroupName and attributeName ");
            }
        }
        DoubleSTAttribute att = new DoubleSTAttribute(_att_x2);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// attribute:   y2

    /** cache */
    DoubleSTAttribute _att_y2 = null;
    /** y2 coordinate for an object.
    * Used for displaying the object in 2 
    *                 dimensions. Unrelated to the 3-D coordinates for the object. The 
    *                 orientation of the axes matters as it can affect the chirality of 
    *                 object.
    * @return CMLAttribute
    */
    public CMLAttribute getY2Attribute() {
        return (CMLAttribute) getAttribute("y2");
    }
    /** y2 coordinate for an object.
    * Used for displaying the object in 2 
    *                 dimensions. Unrelated to the 3-D coordinates for the object. The 
    *                 orientation of the axes matters as it can affect the chirality of 
    *                 object.
    * @return double
    */
    public double getY2() {
        DoubleSTAttribute att = (DoubleSTAttribute) this.getY2Attribute();
        if (att == null) {
            return Double.NaN;
        }
        return att.getDouble();
    }
    /** y2 coordinate for an object.
    * Used for displaying the object in 2 
    *                 dimensions. Unrelated to the 3-D coordinates for the object. The 
    *                 orientation of the axes matters as it can affect the chirality of 
    *                 object.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setY2(String value) throws RuntimeException {
        DoubleSTAttribute att = null;
        if (_att_y2 == null) {
            _att_y2 = (DoubleSTAttribute) attributeFactory.getAttribute("y2", "atom");
            if (_att_y2 == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : y2 probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new DoubleSTAttribute(_att_y2);
        super.addRemove(att, value);
    }
    /** y2 coordinate for an object.
    * Used for displaying the object in 2 
    *                 dimensions. Unrelated to the 3-D coordinates for the object. The 
    *                 orientation of the axes matters as it can affect the chirality of 
    *                 object.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setY2(double value) throws RuntimeException {
        if (_att_y2 == null) {
            _att_y2 = (DoubleSTAttribute) attributeFactory.getAttribute("y2", "atom");
           if (_att_y2 == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : y2 probably incompatible attributeGroupName and attributeName ");
            }
        }
        DoubleSTAttribute att = new DoubleSTAttribute(_att_y2);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// attribute:   x3

    /** cache */
    DoubleSTAttribute _att_x3 = null;
    /** The x coordinate of a 3 dimensional object.
    * The default units are Angstrom. (The provision 
    *                 for other units is weak at present.) Objects are always described 
    *                 with a right-handed coordinate system.
    * @return CMLAttribute
    */
    public CMLAttribute getX3Attribute() {
        return (CMLAttribute) getAttribute("x3");
    }
    /** The x coordinate of a 3 dimensional object.
    * The default units are Angstrom. (The provision 
    *                 for other units is weak at present.) Objects are always described 
    *                 with a right-handed coordinate system.
    * @return double
    */
    public double getX3() {
        DoubleSTAttribute att = (DoubleSTAttribute) this.getX3Attribute();
        if (att == null) {
            return Double.NaN;
        }
        return att.getDouble();
    }
    /** The x coordinate of a 3 dimensional object.
    * The default units are Angstrom. (The provision 
    *                 for other units is weak at present.) Objects are always described 
    *                 with a right-handed coordinate system.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setX3(String value) throws RuntimeException {
        DoubleSTAttribute att = null;
        if (_att_x3 == null) {
            _att_x3 = (DoubleSTAttribute) attributeFactory.getAttribute("x3", "atom");
            if (_att_x3 == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : x3 probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new DoubleSTAttribute(_att_x3);
        super.addRemove(att, value);
    }
    /** The x coordinate of a 3 dimensional object.
    * The default units are Angstrom. (The provision 
    *                 for other units is weak at present.) Objects are always described 
    *                 with a right-handed coordinate system.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setX3(double value) throws RuntimeException {
        if (_att_x3 == null) {
            _att_x3 = (DoubleSTAttribute) attributeFactory.getAttribute("x3", "atom");
           if (_att_x3 == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : x3 probably incompatible attributeGroupName and attributeName ");
            }
        }
        DoubleSTAttribute att = new DoubleSTAttribute(_att_x3);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// attribute:   y3

    /** cache */
    DoubleSTAttribute _att_y3 = null;
    /** The y coordinate of a 3 dimensional object.
    * The default units are Angstrom. (The 
    *                 provision for other units is weak at present.) Objects are always 
    *                 described with a right-handed coordinate system.
    * @return CMLAttribute
    */
    public CMLAttribute getY3Attribute() {
        return (CMLAttribute) getAttribute("y3");
    }
    /** The y coordinate of a 3 dimensional object.
    * The default units are Angstrom. (The 
    *                 provision for other units is weak at present.) Objects are always 
    *                 described with a right-handed coordinate system.
    * @return double
    */
    public double getY3() {
        DoubleSTAttribute att = (DoubleSTAttribute) this.getY3Attribute();
        if (att == null) {
            return Double.NaN;
        }
        return att.getDouble();
    }
    /** The y coordinate of a 3 dimensional object.
    * The default units are Angstrom. (The 
    *                 provision for other units is weak at present.) Objects are always 
    *                 described with a right-handed coordinate system.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setY3(String value) throws RuntimeException {
        DoubleSTAttribute att = null;
        if (_att_y3 == null) {
            _att_y3 = (DoubleSTAttribute) attributeFactory.getAttribute("y3", "atom");
            if (_att_y3 == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : y3 probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new DoubleSTAttribute(_att_y3);
        super.addRemove(att, value);
    }
    /** The y coordinate of a 3 dimensional object.
    * The default units are Angstrom. (The 
    *                 provision for other units is weak at present.) Objects are always 
    *                 described with a right-handed coordinate system.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setY3(double value) throws RuntimeException {
        if (_att_y3 == null) {
            _att_y3 = (DoubleSTAttribute) attributeFactory.getAttribute("y3", "atom");
           if (_att_y3 == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : y3 probably incompatible attributeGroupName and attributeName ");
            }
        }
        DoubleSTAttribute att = new DoubleSTAttribute(_att_y3);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// attribute:   z3

    /** cache */
    DoubleSTAttribute _att_z3 = null;
    /** The z coordinate of a 3 dimensional object.
    * The default units are Angstrom. (The 
    *                 provision for other units is weak at present.) Objects are always 
    *                 described with a right-handed coordinate system.
    * @return CMLAttribute
    */
    public CMLAttribute getZ3Attribute() {
        return (CMLAttribute) getAttribute("z3");
    }
    /** The z coordinate of a 3 dimensional object.
    * The default units are Angstrom. (The 
    *                 provision for other units is weak at present.) Objects are always 
    *                 described with a right-handed coordinate system.
    * @return double
    */
    public double getZ3() {
        DoubleSTAttribute att = (DoubleSTAttribute) this.getZ3Attribute();
        if (att == null) {
            return Double.NaN;
        }
        return att.getDouble();
    }
    /** The z coordinate of a 3 dimensional object.
    * The default units are Angstrom. (The 
    *                 provision for other units is weak at present.) Objects are always 
    *                 described with a right-handed coordinate system.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setZ3(String value) throws RuntimeException {
        DoubleSTAttribute att = null;
        if (_att_z3 == null) {
            _att_z3 = (DoubleSTAttribute) attributeFactory.getAttribute("z3", "atom");
            if (_att_z3 == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : z3 probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new DoubleSTAttribute(_att_z3);
        super.addRemove(att, value);
    }
    /** The z coordinate of a 3 dimensional object.
    * The default units are Angstrom. (The 
    *                 provision for other units is weak at present.) Objects are always 
    *                 described with a right-handed coordinate system.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setZ3(double value) throws RuntimeException {
        if (_att_z3 == null) {
            _att_z3 = (DoubleSTAttribute) attributeFactory.getAttribute("z3", "atom");
           if (_att_z3 == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : z3 probably incompatible attributeGroupName and attributeName ");
            }
        }
        DoubleSTAttribute att = new DoubleSTAttribute(_att_z3);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// attribute:   xFract

    /** cache */
    DoubleSTAttribute _att_xfract = null;
    /** Fractional x coordinate.
    * normally xFract, yFract and zFract should all be present or absent. If present a _crystal_ element should also occur.
    * @return CMLAttribute
    */
    public CMLAttribute getXFractAttribute() {
        return (CMLAttribute) getAttribute("xFract");
    }
    /** Fractional x coordinate.
    * normally xFract, yFract and zFract should all be present or absent. If present a _crystal_ element should also occur.
    * @return double
    */
    public double getXFract() {
        DoubleSTAttribute att = (DoubleSTAttribute) this.getXFractAttribute();
        if (att == null) {
            return Double.NaN;
        }
        return att.getDouble();
    }
    /** Fractional x coordinate.
    * normally xFract, yFract and zFract should all be present or absent. If present a _crystal_ element should also occur.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setXFract(String value) throws RuntimeException {
        DoubleSTAttribute att = null;
        if (_att_xfract == null) {
            _att_xfract = (DoubleSTAttribute) attributeFactory.getAttribute("xFract", "atom");
            if (_att_xfract == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : xFract probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new DoubleSTAttribute(_att_xfract);
        super.addRemove(att, value);
    }
    /** Fractional x coordinate.
    * normally xFract, yFract and zFract should all be present or absent. If present a _crystal_ element should also occur.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setXFract(double value) throws RuntimeException {
        if (_att_xfract == null) {
            _att_xfract = (DoubleSTAttribute) attributeFactory.getAttribute("xFract", "atom");
           if (_att_xfract == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : xFract probably incompatible attributeGroupName and attributeName ");
            }
        }
        DoubleSTAttribute att = new DoubleSTAttribute(_att_xfract);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// attribute:   yFract

    /** cache */
    DoubleSTAttribute _att_yfract = null;
    /** Fractional y coordinate.
    * normally xFract, yFract and zFract 
    *                 should all be present or absent. If present a _crystal_ element 
    *                 should also occur.
    * @return CMLAttribute
    */
    public CMLAttribute getYFractAttribute() {
        return (CMLAttribute) getAttribute("yFract");
    }
    /** Fractional y coordinate.
    * normally xFract, yFract and zFract 
    *                 should all be present or absent. If present a _crystal_ element 
    *                 should also occur.
    * @return double
    */
    public double getYFract() {
        DoubleSTAttribute att = (DoubleSTAttribute) this.getYFractAttribute();
        if (att == null) {
            return Double.NaN;
        }
        return att.getDouble();
    }
    /** Fractional y coordinate.
    * normally xFract, yFract and zFract 
    *                 should all be present or absent. If present a _crystal_ element 
    *                 should also occur.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setYFract(String value) throws RuntimeException {
        DoubleSTAttribute att = null;
        if (_att_yfract == null) {
            _att_yfract = (DoubleSTAttribute) attributeFactory.getAttribute("yFract", "atom");
            if (_att_yfract == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : yFract probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new DoubleSTAttribute(_att_yfract);
        super.addRemove(att, value);
    }
    /** Fractional y coordinate.
    * normally xFract, yFract and zFract 
    *                 should all be present or absent. If present a _crystal_ element 
    *                 should also occur.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setYFract(double value) throws RuntimeException {
        if (_att_yfract == null) {
            _att_yfract = (DoubleSTAttribute) attributeFactory.getAttribute("yFract", "atom");
           if (_att_yfract == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : yFract probably incompatible attributeGroupName and attributeName ");
            }
        }
        DoubleSTAttribute att = new DoubleSTAttribute(_att_yfract);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// attribute:   zFract

    /** cache */
    DoubleSTAttribute _att_zfract = null;
    /** Fractional y coordinate.
    * normally xFract, yFract and zFract 
    *                 should all be present or absent. If present a _crystal_ element 
    *                 should also occur.
    * @return CMLAttribute
    */
    public CMLAttribute getZFractAttribute() {
        return (CMLAttribute) getAttribute("zFract");
    }
    /** Fractional y coordinate.
    * normally xFract, yFract and zFract 
    *                 should all be present or absent. If present a _crystal_ element 
    *                 should also occur.
    * @return double
    */
    public double getZFract() {
        DoubleSTAttribute att = (DoubleSTAttribute) this.getZFractAttribute();
        if (att == null) {
            return Double.NaN;
        }
        return att.getDouble();
    }
    /** Fractional y coordinate.
    * normally xFract, yFract and zFract 
    *                 should all be present or absent. If present a _crystal_ element 
    *                 should also occur.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setZFract(String value) throws RuntimeException {
        DoubleSTAttribute att = null;
        if (_att_zfract == null) {
            _att_zfract = (DoubleSTAttribute) attributeFactory.getAttribute("zFract", "atom");
            if (_att_zfract == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : zFract probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new DoubleSTAttribute(_att_zfract);
        super.addRemove(att, value);
    }
    /** Fractional y coordinate.
    * normally xFract, yFract and zFract 
    *                 should all be present or absent. If present a _crystal_ element 
    *                 should also occur.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setZFract(double value) throws RuntimeException {
        if (_att_zfract == null) {
            _att_zfract = (DoubleSTAttribute) attributeFactory.getAttribute("zFract", "atom");
           if (_att_zfract == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : zFract probably incompatible attributeGroupName and attributeName ");
            }
        }
        DoubleSTAttribute att = new DoubleSTAttribute(_att_zfract);
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
            _att_title = (StringSTAttribute) attributeFactory.getAttribute("title", "atom");
            if (_att_title == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : title probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_title);
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
            _att_role = (StringSTAttribute) attributeFactory.getAttribute("role", "atom");
            if (_att_role == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : role probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_role);
        super.addRemove(att, value);
    }
// attribute:   spaceGroupMultiplicity

    /** cache */
    IntSTAttribute _att_spacegroupmultiplicity = null;
    /** SpaceGroup multiplicity.
    * Normally for an atom. This attribute gives the spaceGroup multiplicity of the molecule and is independent of any atomic information. No default, and it may take any positive integer value 
    *                 (though values are normally between 1 and 192. It represents the number of symmetry operations
    *                 (without cell translations) that transform the atom into itself. 
    *                 Thus an atom on a centre of symmetry can have a spaceGroupMultiplicity of 2.
    *                 The spaceGroupMultiplicity can be deduced from a knowledge of the
    *                 coordinates and the spaceGroup operators and so is formally redundant but this is a
    *                 useful convenience operator. Some crystallographic experiments report this attribute
    *                 as, for example, the IUCr CIF item 'atom_site_symmetry_multiplicity'.
    *                 Distinguish carefully from occupancy which represents incomplete occupation of a 
    *                 site.
    * @return CMLAttribute
    */
    public CMLAttribute getSpaceGroupMultiplicityAttribute() {
        return (CMLAttribute) getAttribute("spaceGroupMultiplicity");
    }
    /** SpaceGroup multiplicity.
    * Normally for an atom. This attribute gives the spaceGroup multiplicity of the molecule and is independent of any atomic information. No default, and it may take any positive integer value 
    *                 (though values are normally between 1 and 192. It represents the number of symmetry operations
    *                 (without cell translations) that transform the atom into itself. 
    *                 Thus an atom on a centre of symmetry can have a spaceGroupMultiplicity of 2.
    *                 The spaceGroupMultiplicity can be deduced from a knowledge of the
    *                 coordinates and the spaceGroup operators and so is formally redundant but this is a
    *                 useful convenience operator. Some crystallographic experiments report this attribute
    *                 as, for example, the IUCr CIF item 'atom_site_symmetry_multiplicity'.
    *                 Distinguish carefully from occupancy which represents incomplete occupation of a 
    *                 site.
    * @return int
    */
    public int getSpaceGroupMultiplicity() {
        IntSTAttribute att = (IntSTAttribute) this.getSpaceGroupMultiplicityAttribute();
        if (att == null) {
            throw new RuntimeException("int attribute is unset: spaceGroupMultiplicity");
        }
        return att.getInt();
    }
    /** SpaceGroup multiplicity.
    * Normally for an atom. This attribute gives the spaceGroup multiplicity of the molecule and is independent of any atomic information. No default, and it may take any positive integer value 
    *                 (though values are normally between 1 and 192. It represents the number of symmetry operations
    *                 (without cell translations) that transform the atom into itself. 
    *                 Thus an atom on a centre of symmetry can have a spaceGroupMultiplicity of 2.
    *                 The spaceGroupMultiplicity can be deduced from a knowledge of the
    *                 coordinates and the spaceGroup operators and so is formally redundant but this is a
    *                 useful convenience operator. Some crystallographic experiments report this attribute
    *                 as, for example, the IUCr CIF item 'atom_site_symmetry_multiplicity'.
    *                 Distinguish carefully from occupancy which represents incomplete occupation of a 
    *                 site.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setSpaceGroupMultiplicity(String value) throws RuntimeException {
        IntSTAttribute att = null;
        if (_att_spacegroupmultiplicity == null) {
            _att_spacegroupmultiplicity = (IntSTAttribute) attributeFactory.getAttribute("spaceGroupMultiplicity", "atom");
            if (_att_spacegroupmultiplicity == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : spaceGroupMultiplicity probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new IntSTAttribute(_att_spacegroupmultiplicity);
        super.addRemove(att, value);
    }
    /** SpaceGroup multiplicity.
    * Normally for an atom. This attribute gives the spaceGroup multiplicity of the molecule and is independent of any atomic information. No default, and it may take any positive integer value 
    *                 (though values are normally between 1 and 192. It represents the number of symmetry operations
    *                 (without cell translations) that transform the atom into itself. 
    *                 Thus an atom on a centre of symmetry can have a spaceGroupMultiplicity of 2.
    *                 The spaceGroupMultiplicity can be deduced from a knowledge of the
    *                 coordinates and the spaceGroup operators and so is formally redundant but this is a
    *                 useful convenience operator. Some crystallographic experiments report this attribute
    *                 as, for example, the IUCr CIF item 'atom_site_symmetry_multiplicity'.
    *                 Distinguish carefully from occupancy which represents incomplete occupation of a 
    *                 site.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setSpaceGroupMultiplicity(int value) throws RuntimeException {
        if (_att_spacegroupmultiplicity == null) {
            _att_spacegroupmultiplicity = (IntSTAttribute) attributeFactory.getAttribute("spaceGroupMultiplicity", "atom");
           if (_att_spacegroupmultiplicity == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : spaceGroupMultiplicity probably incompatible attributeGroupName and attributeName ");
            }
        }
        IntSTAttribute att = new IntSTAttribute(_att_spacegroupmultiplicity);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// attribute:   pointGroupMultiplicity

    /** cache */
    IntSTAttribute _att_pointgroupmultiplicity = null;
    /** SpaceGroup multiplicity.
    * Normally for an atom. This attribute gives the pointGroup multiplicity of the molecule and is independent of any atomic information. No default, and it may take any positive integer value 
    *                 (though values are normally between 1 and 60 (for icosahedral). It represents the number of symmetry operations
    *                 (without any translations) that transform the atom into itself. 
    *                 Thus an atom on a centre of symmetry can have a pointGroupMultiplicity of 2.
    *                 The pointGroupMultiplicity can be deduced from a knowledge of the
    *                 coordinates and the pointGroup operators and so is formally redundant but this is a
    *                 useful convenience operator. 
    *                 Distinguish carefully from occupancy which represents incomplete occupation of a 
    *                 site.
    * @return CMLAttribute
    */
    public CMLAttribute getPointGroupMultiplicityAttribute() {
        return (CMLAttribute) getAttribute("pointGroupMultiplicity");
    }
    /** SpaceGroup multiplicity.
    * Normally for an atom. This attribute gives the pointGroup multiplicity of the molecule and is independent of any atomic information. No default, and it may take any positive integer value 
    *                 (though values are normally between 1 and 60 (for icosahedral). It represents the number of symmetry operations
    *                 (without any translations) that transform the atom into itself. 
    *                 Thus an atom on a centre of symmetry can have a pointGroupMultiplicity of 2.
    *                 The pointGroupMultiplicity can be deduced from a knowledge of the
    *                 coordinates and the pointGroup operators and so is formally redundant but this is a
    *                 useful convenience operator. 
    *                 Distinguish carefully from occupancy which represents incomplete occupation of a 
    *                 site.
    * @return int
    */
    public int getPointGroupMultiplicity() {
        IntSTAttribute att = (IntSTAttribute) this.getPointGroupMultiplicityAttribute();
        if (att == null) {
            throw new RuntimeException("int attribute is unset: pointGroupMultiplicity");
        }
        return att.getInt();
    }
    /** SpaceGroup multiplicity.
    * Normally for an atom. This attribute gives the pointGroup multiplicity of the molecule and is independent of any atomic information. No default, and it may take any positive integer value 
    *                 (though values are normally between 1 and 60 (for icosahedral). It represents the number of symmetry operations
    *                 (without any translations) that transform the atom into itself. 
    *                 Thus an atom on a centre of symmetry can have a pointGroupMultiplicity of 2.
    *                 The pointGroupMultiplicity can be deduced from a knowledge of the
    *                 coordinates and the pointGroup operators and so is formally redundant but this is a
    *                 useful convenience operator. 
    *                 Distinguish carefully from occupancy which represents incomplete occupation of a 
    *                 site.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setPointGroupMultiplicity(String value) throws RuntimeException {
        IntSTAttribute att = null;
        if (_att_pointgroupmultiplicity == null) {
            _att_pointgroupmultiplicity = (IntSTAttribute) attributeFactory.getAttribute("pointGroupMultiplicity", "atom");
            if (_att_pointgroupmultiplicity == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : pointGroupMultiplicity probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new IntSTAttribute(_att_pointgroupmultiplicity);
        super.addRemove(att, value);
    }
    /** SpaceGroup multiplicity.
    * Normally for an atom. This attribute gives the pointGroup multiplicity of the molecule and is independent of any atomic information. No default, and it may take any positive integer value 
    *                 (though values are normally between 1 and 60 (for icosahedral). It represents the number of symmetry operations
    *                 (without any translations) that transform the atom into itself. 
    *                 Thus an atom on a centre of symmetry can have a pointGroupMultiplicity of 2.
    *                 The pointGroupMultiplicity can be deduced from a knowledge of the
    *                 coordinates and the pointGroup operators and so is formally redundant but this is a
    *                 useful convenience operator. 
    *                 Distinguish carefully from occupancy which represents incomplete occupation of a 
    *                 site.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setPointGroupMultiplicity(int value) throws RuntimeException {
        if (_att_pointgroupmultiplicity == null) {
            _att_pointgroupmultiplicity = (IntSTAttribute) attributeFactory.getAttribute("pointGroupMultiplicity", "atom");
           if (_att_pointgroupmultiplicity == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : pointGroupMultiplicity probably incompatible attributeGroupName and attributeName ");
            }
        }
        IntSTAttribute att = new IntSTAttribute(_att_pointgroupmultiplicity);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// element:   name

    /** SpaceGroup multiplicity.
    * Normally for an atom. This attribute gives the pointGroup multiplicity of the molecule and is independent of any atomic information. No default, and it may take any positive integer value 
    *                 (though values are normally between 1 and 60 (for icosahedral). It represents the number of symmetry operations
    *                 (without any translations) that transform the atom into itself. 
    *                 Thus an atom on a centre of symmetry can have a pointGroupMultiplicity of 2.
    *                 The pointGroupMultiplicity can be deduced from a knowledge of the
    *                 coordinates and the pointGroup operators and so is formally redundant but this is a
    *                 useful convenience operator. 
    *                 Distinguish carefully from occupancy which represents incomplete occupation of a 
    *                 site.
    * @param name child to add
    */
    public void addName(AbstractName name) {
        name.detach();
        this.appendChild(name);
    }
    /** SpaceGroup multiplicity.
    * Normally for an atom. This attribute gives the pointGroup multiplicity of the molecule and is independent of any atomic information. No default, and it may take any positive integer value 
    *                 (though values are normally between 1 and 60 (for icosahedral). It represents the number of symmetry operations
    *                 (without any translations) that transform the atom into itself. 
    *                 Thus an atom on a centre of symmetry can have a pointGroupMultiplicity of 2.
    *                 The pointGroupMultiplicity can be deduced from a knowledge of the
    *                 coordinates and the pointGroup operators and so is formally redundant but this is a
    *                 useful convenience operator. 
    *                 Distinguish carefully from occupancy which represents incomplete occupation of a 
    *                 site.
    * @return CMLElements<CMLName>
    */
    public CMLElements<CMLName> getNameElements() {
        Elements elements = this.getChildElements("name", CML_NS);
        return new CMLElements<CMLName>(elements);
    }
// element:   label

    /** SpaceGroup multiplicity.
    * Normally for an atom. This attribute gives the pointGroup multiplicity of the molecule and is independent of any atomic information. No default, and it may take any positive integer value 
    *                 (though values are normally between 1 and 60 (for icosahedral). It represents the number of symmetry operations
    *                 (without any translations) that transform the atom into itself. 
    *                 Thus an atom on a centre of symmetry can have a pointGroupMultiplicity of 2.
    *                 The pointGroupMultiplicity can be deduced from a knowledge of the
    *                 coordinates and the pointGroup operators and so is formally redundant but this is a
    *                 useful convenience operator. 
    *                 Distinguish carefully from occupancy which represents incomplete occupation of a 
    *                 site.
    * @param label child to add
    */
    public void addLabel(AbstractLabel label) {
        label.detach();
        this.appendChild(label);
    }
    /** SpaceGroup multiplicity.
    * Normally for an atom. This attribute gives the pointGroup multiplicity of the molecule and is independent of any atomic information. No default, and it may take any positive integer value 
    *                 (though values are normally between 1 and 60 (for icosahedral). It represents the number of symmetry operations
    *                 (without any translations) that transform the atom into itself. 
    *                 Thus an atom on a centre of symmetry can have a pointGroupMultiplicity of 2.
    *                 The pointGroupMultiplicity can be deduced from a knowledge of the
    *                 coordinates and the pointGroup operators and so is formally redundant but this is a
    *                 useful convenience operator. 
    *                 Distinguish carefully from occupancy which represents incomplete occupation of a 
    *                 site.
    * @return CMLElements<CMLLabel>
    */
    public CMLElements<CMLLabel> getLabelElements() {
        Elements elements = this.getChildElements("label", CML_NS);
        return new CMLElements<CMLLabel>(elements);
    }
// element:   atomType

// element:   array

    /** SpaceGroup multiplicity.
    * Normally for an atom. This attribute gives the pointGroup multiplicity of the molecule and is independent of any atomic information. No default, and it may take any positive integer value 
    *                 (though values are normally between 1 and 60 (for icosahedral). It represents the number of symmetry operations
    *                 (without any translations) that transform the atom into itself. 
    *                 Thus an atom on a centre of symmetry can have a pointGroupMultiplicity of 2.
    *                 The pointGroupMultiplicity can be deduced from a knowledge of the
    *                 coordinates and the pointGroup operators and so is formally redundant but this is a
    *                 useful convenience operator. 
    *                 Distinguish carefully from occupancy which represents incomplete occupation of a 
    *                 site.
    * @param array child to add
    */
    public void addArray(AbstractArray array) {
        array.detach();
        this.appendChild(array);
    }
    /** SpaceGroup multiplicity.
    * Normally for an atom. This attribute gives the pointGroup multiplicity of the molecule and is independent of any atomic information. No default, and it may take any positive integer value 
    *                 (though values are normally between 1 and 60 (for icosahedral). It represents the number of symmetry operations
    *                 (without any translations) that transform the atom into itself. 
    *                 Thus an atom on a centre of symmetry can have a pointGroupMultiplicity of 2.
    *                 The pointGroupMultiplicity can be deduced from a knowledge of the
    *                 coordinates and the pointGroup operators and so is formally redundant but this is a
    *                 useful convenience operator. 
    *                 Distinguish carefully from occupancy which represents incomplete occupation of a 
    *                 site.
    * @return CMLElements<CMLArray>
    */
    public CMLElements<CMLArray> getArrayElements() {
        Elements elements = this.getChildElements("array", CML_NS);
        return new CMLElements<CMLArray>(elements);
    }
// element:   matrix

// element:   scalar

    /** SpaceGroup multiplicity.
    * Normally for an atom. This attribute gives the pointGroup multiplicity of the molecule and is independent of any atomic information. No default, and it may take any positive integer value 
    *                 (though values are normally between 1 and 60 (for icosahedral). It represents the number of symmetry operations
    *                 (without any translations) that transform the atom into itself. 
    *                 Thus an atom on a centre of symmetry can have a pointGroupMultiplicity of 2.
    *                 The pointGroupMultiplicity can be deduced from a knowledge of the
    *                 coordinates and the pointGroup operators and so is formally redundant but this is a
    *                 useful convenience operator. 
    *                 Distinguish carefully from occupancy which represents incomplete occupation of a 
    *                 site.
    * @param scalar child to add
    */
    public void addScalar(AbstractScalar scalar) {
        scalar.detach();
        this.appendChild(scalar);
    }
    /** SpaceGroup multiplicity.
    * Normally for an atom. This attribute gives the pointGroup multiplicity of the molecule and is independent of any atomic information. No default, and it may take any positive integer value 
    *                 (though values are normally between 1 and 60 (for icosahedral). It represents the number of symmetry operations
    *                 (without any translations) that transform the atom into itself. 
    *                 Thus an atom on a centre of symmetry can have a pointGroupMultiplicity of 2.
    *                 The pointGroupMultiplicity can be deduced from a knowledge of the
    *                 coordinates and the pointGroup operators and so is formally redundant but this is a
    *                 useful convenience operator. 
    *                 Distinguish carefully from occupancy which represents incomplete occupation of a 
    *                 site.
    * @return CMLElements<CMLScalar>
    */
    public CMLElements<CMLScalar> getScalarElements() {
        Elements elements = this.getChildElements("scalar", CML_NS);
        return new CMLElements<CMLScalar>(elements);
    }
// element:   atomParity

    /** SpaceGroup multiplicity.
    * Normally for an atom. This attribute gives the pointGroup multiplicity of the molecule and is independent of any atomic information. No default, and it may take any positive integer value 
    *                 (though values are normally between 1 and 60 (for icosahedral). It represents the number of symmetry operations
    *                 (without any translations) that transform the atom into itself. 
    *                 Thus an atom on a centre of symmetry can have a pointGroupMultiplicity of 2.
    *                 The pointGroupMultiplicity can be deduced from a knowledge of the
    *                 coordinates and the pointGroup operators and so is formally redundant but this is a
    *                 useful convenience operator. 
    *                 Distinguish carefully from occupancy which represents incomplete occupation of a 
    *                 site.
    * @param atomParity child to add
    */
    public void addAtomParity(AbstractAtomParity atomParity) {
        atomParity.detach();
        this.appendChild(atomParity);
    }
    /** SpaceGroup multiplicity.
    * Normally for an atom. This attribute gives the pointGroup multiplicity of the molecule and is independent of any atomic information. No default, and it may take any positive integer value 
    *                 (though values are normally between 1 and 60 (for icosahedral). It represents the number of symmetry operations
    *                 (without any translations) that transform the atom into itself. 
    *                 Thus an atom on a centre of symmetry can have a pointGroupMultiplicity of 2.
    *                 The pointGroupMultiplicity can be deduced from a knowledge of the
    *                 coordinates and the pointGroup operators and so is formally redundant but this is a
    *                 useful convenience operator. 
    *                 Distinguish carefully from occupancy which represents incomplete occupation of a 
    *                 site.
    * @return CMLElements<CMLAtomParity>
    */
    public CMLElements<CMLAtomParity> getAtomParityElements() {
        Elements elements = this.getChildElements("atomParity", CML_NS);
        return new CMLElements<CMLAtomParity>(elements);
    }
// element:   electron

    /** overrides addAttribute(Attribute)
     * reroutes calls to setFoo()
     * @param att  attribute
    */
    public void addAttribute(Attribute att) {
        String name = att.getLocalName();
        String value = att.getValue();
        if (name == null) {
        } else if (name.equals("id")) {
            setId(value);
        } else if (name.equals("convention")) {
            setConvention(value);
        } else if (name.equals("dictRef")) {
            setDictRef(value);
        } else if (name.equals("ref")) {
            setRef(value);
        } else if (name.equals("count")) {
            setCount(value);
        } else if (name.equals("elementType")) {
            setElementType(value);
        } else if (name.equals("formalCharge")) {
            setFormalCharge(value);
        } else if (name.equals("hydrogenCount")) {
            setHydrogenCount(value);
        } else if (name.equals("isotope")) {
            setIsotope(value);
        } else if (name.equals("isotopeNumber")) {
            setIsotopeNumber(value);
        } else if (name.equals("isotopeRef")) {
            setIsotopeRef(value);
        } else if (name.equals("isotopeListRef")) {
            setIsotopeListRef(value);
        } else if (name.equals("occupancy")) {
            setOccupancy(value);
        } else if (name.equals("spinMultiplicity")) {
            setSpinMultiplicity(value);
        } else if (name.equals("x2")) {
            setX2(value);
        } else if (name.equals("y2")) {
            setY2(value);
        } else if (name.equals("x3")) {
            setX3(value);
        } else if (name.equals("y3")) {
            setY3(value);
        } else if (name.equals("z3")) {
            setZ3(value);
        } else if (name.equals("xFract")) {
            setXFract(value);
        } else if (name.equals("yFract")) {
            setYFract(value);
        } else if (name.equals("zFract")) {
            setZFract(value);
        } else if (name.equals("title")) {
            setTitle(value);
        } else if (name.equals("role")) {
            setRole(value);
        } else if (name.equals("spaceGroupMultiplicity")) {
            setSpaceGroupMultiplicity(value);
        } else if (name.equals("pointGroupMultiplicity")) {
            setPointGroupMultiplicity(value);
	     } else {
            super.addAttribute(att);
        }
    }
}
