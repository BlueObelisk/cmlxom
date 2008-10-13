package org.xmlcml.cml.element.lite;


import nu.xom.Attribute;
import nu.xom.Elements;

import org.xmlcml.cml.attribute.DictRefAttribute;
import org.xmlcml.cml.attribute.IdAttribute;
import org.xmlcml.cml.attribute.RefAttribute;
import org.xmlcml.cml.base.CMLAttribute;
import org.xmlcml.cml.base.CMLElement;
import org.xmlcml.cml.base.CMLElements;
import org.xmlcml.cml.base.DoubleArraySTAttribute;
import org.xmlcml.cml.base.IntArraySTAttribute;
import org.xmlcml.cml.base.StringArraySTAttribute;
import org.xmlcml.cml.base.StringSTAttribute;

// end of part 1
/** CLASS DOCUMENTATION */
public abstract class AbstractAtomArray extends CMLElement {
    /** local name*/
    public final static String TAG = "atomArray";
    /** constructor. */    public AbstractAtomArray() {
        super("atomArray");
    }
/** copy constructor.
* deep copy using XOM copy()
* @param old element to copy
*/
    public AbstractAtomArray(AbstractAtomArray old) {
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
            _att_title = (StringSTAttribute) attributeFactory.getAttribute("title", "atomArray");
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
            _att_id = (IdAttribute) attributeFactory.getAttribute("id", "atomArray");
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
            _att_convention = (StringSTAttribute) attributeFactory.getAttribute("convention", "atomArray");
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
            _att_dictref = (DictRefAttribute) attributeFactory.getAttribute("dictRef", "atomArray");
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
            _att_ref = (RefAttribute) attributeFactory.getAttribute("ref", "atomArray");
            if (_att_ref == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : ref probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new RefAttribute(_att_ref);
        super.addRemove(att, value);
    }
// attribute:   elementType

    /** cache */
    StringArraySTAttribute _att_elementtype = null;
    /** The identity of a chemical element.
    * Normally mandatory on _atom_, _isotope_, etc.
    * @return CMLAttribute
    */
    public CMLAttribute getElementTypeAttribute() {
        return (CMLAttribute) getAttribute("elementType");
    }
    /** The identity of a chemical element.
    * Normally mandatory on _atom_, _isotope_, etc.
    * @return String[]
    */
    public String[] getElementType() {
        StringArraySTAttribute att = (StringArraySTAttribute) this.getElementTypeAttribute();
        if (att == null) {
            return null;
        }
        return att.getStringArray();
    }
    /** The identity of a chemical element.
    * Normally mandatory on _atom_, _isotope_, etc.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setElementType(String value) throws RuntimeException {
        StringArraySTAttribute att = null;
        if (_att_elementtype == null) {
            _att_elementtype = (StringArraySTAttribute) attributeFactory.getAttribute("elementType", "atomArray");
            if (_att_elementtype == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : elementType probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringArraySTAttribute(_att_elementtype);
        super.addRemove(att, value);
    }
    /** The identity of a chemical element.
    * Normally mandatory on _atom_, _isotope_, etc.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setElementType(String[] value) throws RuntimeException {
        if (_att_elementtype == null) {
            _att_elementtype = (StringArraySTAttribute) attributeFactory.getAttribute("elementType", "atomArray");
           if (_att_elementtype == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : elementType probably incompatible attributeGroupName and attributeName ");
            }
        }
        StringArraySTAttribute att = new StringArraySTAttribute(_att_elementtype);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// attribute:   count

    /** cache */
    DoubleArraySTAttribute _att_count = null;
    /** Array of object counts.
    * No fixed semantics or default, normally integral. It is presumed that the element can be multiplied by the count value.
    * @return CMLAttribute
    */
    public CMLAttribute getCountAttribute() {
        return (CMLAttribute) getAttribute("count");
    }
    /** Array of object counts.
    * No fixed semantics or default, normally integral. It is presumed that the element can be multiplied by the count value.
    * @return double[]
    */
    public double[] getCount() {
        DoubleArraySTAttribute att = (DoubleArraySTAttribute) this.getCountAttribute();
        if (att == null) {
            return null;
        }
        return att.getDoubleArray();
    }
    /** Array of object counts.
    * No fixed semantics or default, normally integral. It is presumed that the element can be multiplied by the count value.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setCount(String value) throws RuntimeException {
        DoubleArraySTAttribute att = null;
        if (_att_count == null) {
            _att_count = (DoubleArraySTAttribute) attributeFactory.getAttribute("count", "atomArray");
            if (_att_count == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : count probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new DoubleArraySTAttribute(_att_count);
        super.addRemove(att, value);
    }
    /** Array of object counts.
    * No fixed semantics or default, normally integral. It is presumed that the element can be multiplied by the count value.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setCount(double[] value) throws RuntimeException {
        if (_att_count == null) {
            _att_count = (DoubleArraySTAttribute) attributeFactory.getAttribute("count", "atomArray");
           if (_att_count == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : count probably incompatible attributeGroupName and attributeName ");
            }
        }
        DoubleArraySTAttribute att = new DoubleArraySTAttribute(_att_count);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// attribute:   formalCharge

    /** cache */
    IntArraySTAttribute _att_formalcharge = null;
    /** An array of formalCharges.
    * Used in CML2 Array mode. NOT the calculated charge or oxidation state. No formal defaults, but assumed to be zero if omitted. It may become good practice to include it.
    * @return CMLAttribute
    */
    public CMLAttribute getFormalChargeAttribute() {
        return (CMLAttribute) getAttribute("formalCharge");
    }
    /** An array of formalCharges.
    * Used in CML2 Array mode. NOT the calculated charge or oxidation state. No formal defaults, but assumed to be zero if omitted. It may become good practice to include it.
    * @return int[]
    */
    public int[] getFormalCharge() {
        IntArraySTAttribute att = (IntArraySTAttribute) this.getFormalChargeAttribute();
        if (att == null) {
            return null;
        }
        return att.getIntArray();
    }
    /** An array of formalCharges.
    * Used in CML2 Array mode. NOT the calculated charge or oxidation state. No formal defaults, but assumed to be zero if omitted. It may become good practice to include it.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setFormalCharge(String value) throws RuntimeException {
        IntArraySTAttribute att = null;
        if (_att_formalcharge == null) {
            _att_formalcharge = (IntArraySTAttribute) attributeFactory.getAttribute("formalCharge", "atomArray");
            if (_att_formalcharge == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : formalCharge probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new IntArraySTAttribute(_att_formalcharge);
        super.addRemove(att, value);
    }
    /** An array of formalCharges.
    * Used in CML2 Array mode. NOT the calculated charge or oxidation state. No formal defaults, but assumed to be zero if omitted. It may become good practice to include it.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setFormalCharge(int[] value) throws RuntimeException {
        if (_att_formalcharge == null) {
            _att_formalcharge = (IntArraySTAttribute) attributeFactory.getAttribute("formalCharge", "atomArray");
           if (_att_formalcharge == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : formalCharge probably incompatible attributeGroupName and attributeName ");
            }
        }
        IntArraySTAttribute att = new IntArraySTAttribute(_att_formalcharge);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// attribute:   hydrogenCount

    /** cache */
    IntArraySTAttribute _att_hydrogencount = null;
    /** Array of hydrogenCounts.
    * Normally used in CML2 array mode. The total number of hydrogens bonded to the atom or molecule. It is preferable to include hydrogens explicitly, and where this is done their count represents the minimum (and may thus override this attribute). It is dangerous to use this attribute for electron-deficient molecules (e.g. diborane) or hydrogen bonds. There is NO DEFAULT and the absence of this attribute must not be given any meaning.
    * @return CMLAttribute
    */
    public CMLAttribute getHydrogenCountAttribute() {
        return (CMLAttribute) getAttribute("hydrogenCount");
    }
    /** Array of hydrogenCounts.
    * Normally used in CML2 array mode. The total number of hydrogens bonded to the atom or molecule. It is preferable to include hydrogens explicitly, and where this is done their count represents the minimum (and may thus override this attribute). It is dangerous to use this attribute for electron-deficient molecules (e.g. diborane) or hydrogen bonds. There is NO DEFAULT and the absence of this attribute must not be given any meaning.
    * @return int[]
    */
    public int[] getHydrogenCount() {
        IntArraySTAttribute att = (IntArraySTAttribute) this.getHydrogenCountAttribute();
        if (att == null) {
            return null;
        }
        return att.getIntArray();
    }
    /** Array of hydrogenCounts.
    * Normally used in CML2 array mode. The total number of hydrogens bonded to the atom or molecule. It is preferable to include hydrogens explicitly, and where this is done their count represents the minimum (and may thus override this attribute). It is dangerous to use this attribute for electron-deficient molecules (e.g. diborane) or hydrogen bonds. There is NO DEFAULT and the absence of this attribute must not be given any meaning.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setHydrogenCount(String value) throws RuntimeException {
        IntArraySTAttribute att = null;
        if (_att_hydrogencount == null) {
            _att_hydrogencount = (IntArraySTAttribute) attributeFactory.getAttribute("hydrogenCount", "atomArray");
            if (_att_hydrogencount == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : hydrogenCount probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new IntArraySTAttribute(_att_hydrogencount);
        super.addRemove(att, value);
    }
    /** Array of hydrogenCounts.
    * Normally used in CML2 array mode. The total number of hydrogens bonded to the atom or molecule. It is preferable to include hydrogens explicitly, and where this is done their count represents the minimum (and may thus override this attribute). It is dangerous to use this attribute for electron-deficient molecules (e.g. diborane) or hydrogen bonds. There is NO DEFAULT and the absence of this attribute must not be given any meaning.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setHydrogenCount(int[] value) throws RuntimeException {
        if (_att_hydrogencount == null) {
            _att_hydrogencount = (IntArraySTAttribute) attributeFactory.getAttribute("hydrogenCount", "atomArray");
           if (_att_hydrogencount == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : hydrogenCount probably incompatible attributeGroupName and attributeName ");
            }
        }
        IntArraySTAttribute att = new IntArraySTAttribute(_att_hydrogencount);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// attribute:   occupancy

    /** cache */
    DoubleArraySTAttribute _att_occupancy = null;
    /** Array of occupancies.
    * Normally only found in crystallography. Defaults to 1.0. The occupancy is required to calculate the molecular formula from the atoms.
    * @return CMLAttribute
    */
    public CMLAttribute getOccupancyAttribute() {
        return (CMLAttribute) getAttribute("occupancy");
    }
    /** Array of occupancies.
    * Normally only found in crystallography. Defaults to 1.0. The occupancy is required to calculate the molecular formula from the atoms.
    * @return double[]
    */
    public double[] getOccupancy() {
        DoubleArraySTAttribute att = (DoubleArraySTAttribute) this.getOccupancyAttribute();
        if (att == null) {
            return null;
        }
        return att.getDoubleArray();
    }
    /** Array of occupancies.
    * Normally only found in crystallography. Defaults to 1.0. The occupancy is required to calculate the molecular formula from the atoms.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setOccupancy(String value) throws RuntimeException {
        DoubleArraySTAttribute att = null;
        if (_att_occupancy == null) {
            _att_occupancy = (DoubleArraySTAttribute) attributeFactory.getAttribute("occupancy", "atomArray");
            if (_att_occupancy == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : occupancy probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new DoubleArraySTAttribute(_att_occupancy);
        super.addRemove(att, value);
    }
    /** Array of occupancies.
    * Normally only found in crystallography. Defaults to 1.0. The occupancy is required to calculate the molecular formula from the atoms.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setOccupancy(double[] value) throws RuntimeException {
        if (_att_occupancy == null) {
            _att_occupancy = (DoubleArraySTAttribute) attributeFactory.getAttribute("occupancy", "atomArray");
           if (_att_occupancy == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : occupancy probably incompatible attributeGroupName and attributeName ");
            }
        }
        DoubleArraySTAttribute att = new DoubleArraySTAttribute(_att_occupancy);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// attribute:   x2

    /** cache */
    DoubleArraySTAttribute _att_x2 = null;
    /** array of x2 coordinate.
    * Normally used in CML2 array mode. Used for displaying the object in 2 dimensions. Unrelated to the 3-D coordinates for the object. The orientation of the axes matters as it can affect the chirality of object.
    * @return CMLAttribute
    */
    public CMLAttribute getX2Attribute() {
        return (CMLAttribute) getAttribute("x2");
    }
    /** array of x2 coordinate.
    * Normally used in CML2 array mode. Used for displaying the object in 2 dimensions. Unrelated to the 3-D coordinates for the object. The orientation of the axes matters as it can affect the chirality of object.
    * @return double[]
    */
    public double[] getX2() {
        DoubleArraySTAttribute att = (DoubleArraySTAttribute) this.getX2Attribute();
        if (att == null) {
            return null;
        }
        return att.getDoubleArray();
    }
    /** array of x2 coordinate.
    * Normally used in CML2 array mode. Used for displaying the object in 2 dimensions. Unrelated to the 3-D coordinates for the object. The orientation of the axes matters as it can affect the chirality of object.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setX2(String value) throws RuntimeException {
        DoubleArraySTAttribute att = null;
        if (_att_x2 == null) {
            _att_x2 = (DoubleArraySTAttribute) attributeFactory.getAttribute("x2", "atomArray");
            if (_att_x2 == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : x2 probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new DoubleArraySTAttribute(_att_x2);
        super.addRemove(att, value);
    }
    /** array of x2 coordinate.
    * Normally used in CML2 array mode. Used for displaying the object in 2 dimensions. Unrelated to the 3-D coordinates for the object. The orientation of the axes matters as it can affect the chirality of object.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setX2(double[] value) throws RuntimeException {
        if (_att_x2 == null) {
            _att_x2 = (DoubleArraySTAttribute) attributeFactory.getAttribute("x2", "atomArray");
           if (_att_x2 == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : x2 probably incompatible attributeGroupName and attributeName ");
            }
        }
        DoubleArraySTAttribute att = new DoubleArraySTAttribute(_att_x2);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// attribute:   y2

    /** cache */
    DoubleArraySTAttribute _att_y2 = null;
    /** array of y2 coordinate.
    * Normally used in CML2 array mode. Used for displaying the object in 2 dimensions. Unrelated to the 3-D coordinates for the object. The orientation of the axes matters as it can affect the chirality of object.
    * @return CMLAttribute
    */
    public CMLAttribute getY2Attribute() {
        return (CMLAttribute) getAttribute("y2");
    }
    /** array of y2 coordinate.
    * Normally used in CML2 array mode. Used for displaying the object in 2 dimensions. Unrelated to the 3-D coordinates for the object. The orientation of the axes matters as it can affect the chirality of object.
    * @return double[]
    */
    public double[] getY2() {
        DoubleArraySTAttribute att = (DoubleArraySTAttribute) this.getY2Attribute();
        if (att == null) {
            return null;
        }
        return att.getDoubleArray();
    }
    /** array of y2 coordinate.
    * Normally used in CML2 array mode. Used for displaying the object in 2 dimensions. Unrelated to the 3-D coordinates for the object. The orientation of the axes matters as it can affect the chirality of object.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setY2(String value) throws RuntimeException {
        DoubleArraySTAttribute att = null;
        if (_att_y2 == null) {
            _att_y2 = (DoubleArraySTAttribute) attributeFactory.getAttribute("y2", "atomArray");
            if (_att_y2 == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : y2 probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new DoubleArraySTAttribute(_att_y2);
        super.addRemove(att, value);
    }
    /** array of y2 coordinate.
    * Normally used in CML2 array mode. Used for displaying the object in 2 dimensions. Unrelated to the 3-D coordinates for the object. The orientation of the axes matters as it can affect the chirality of object.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setY2(double[] value) throws RuntimeException {
        if (_att_y2 == null) {
            _att_y2 = (DoubleArraySTAttribute) attributeFactory.getAttribute("y2", "atomArray");
           if (_att_y2 == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : y2 probably incompatible attributeGroupName and attributeName ");
            }
        }
        DoubleArraySTAttribute att = new DoubleArraySTAttribute(_att_y2);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// attribute:   x3

    /** cache */
    DoubleArraySTAttribute _att_x3 = null;
    /** An array of x3 coordinate.
    * No description
    * @return CMLAttribute
    */
    public CMLAttribute getX3Attribute() {
        return (CMLAttribute) getAttribute("x3");
    }
    /** An array of x3 coordinate.
    * No description
    * @return double[]
    */
    public double[] getX3() {
        DoubleArraySTAttribute att = (DoubleArraySTAttribute) this.getX3Attribute();
        if (att == null) {
            return null;
        }
        return att.getDoubleArray();
    }
    /** An array of x3 coordinate.
    * No description
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setX3(String value) throws RuntimeException {
        DoubleArraySTAttribute att = null;
        if (_att_x3 == null) {
            _att_x3 = (DoubleArraySTAttribute) attributeFactory.getAttribute("x3", "atomArray");
            if (_att_x3 == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : x3 probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new DoubleArraySTAttribute(_att_x3);
        super.addRemove(att, value);
    }
    /** An array of x3 coordinate.
    * No description
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setX3(double[] value) throws RuntimeException {
        if (_att_x3 == null) {
            _att_x3 = (DoubleArraySTAttribute) attributeFactory.getAttribute("x3", "atomArray");
           if (_att_x3 == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : x3 probably incompatible attributeGroupName and attributeName ");
            }
        }
        DoubleArraySTAttribute att = new DoubleArraySTAttribute(_att_x3);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// attribute:   y3

    /** cache */
    DoubleArraySTAttribute _att_y3 = null;
    /** An array of y3 coordinate.
    * No description
    * @return CMLAttribute
    */
    public CMLAttribute getY3Attribute() {
        return (CMLAttribute) getAttribute("y3");
    }
    /** An array of y3 coordinate.
    * No description
    * @return double[]
    */
    public double[] getY3() {
        DoubleArraySTAttribute att = (DoubleArraySTAttribute) this.getY3Attribute();
        if (att == null) {
            return null;
        }
        return att.getDoubleArray();
    }
    /** An array of y3 coordinate.
    * No description
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setY3(String value) throws RuntimeException {
        DoubleArraySTAttribute att = null;
        if (_att_y3 == null) {
            _att_y3 = (DoubleArraySTAttribute) attributeFactory.getAttribute("y3", "atomArray");
            if (_att_y3 == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : y3 probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new DoubleArraySTAttribute(_att_y3);
        super.addRemove(att, value);
    }
    /** An array of y3 coordinate.
    * No description
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setY3(double[] value) throws RuntimeException {
        if (_att_y3 == null) {
            _att_y3 = (DoubleArraySTAttribute) attributeFactory.getAttribute("y3", "atomArray");
           if (_att_y3 == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : y3 probably incompatible attributeGroupName and attributeName ");
            }
        }
        DoubleArraySTAttribute att = new DoubleArraySTAttribute(_att_y3);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// attribute:   z3

    /** cache */
    DoubleArraySTAttribute _att_z3 = null;
    /** An array of z3 coordinate.
    * No description
    * @return CMLAttribute
    */
    public CMLAttribute getZ3Attribute() {
        return (CMLAttribute) getAttribute("z3");
    }
    /** An array of z3 coordinate.
    * No description
    * @return double[]
    */
    public double[] getZ3() {
        DoubleArraySTAttribute att = (DoubleArraySTAttribute) this.getZ3Attribute();
        if (att == null) {
            return null;
        }
        return att.getDoubleArray();
    }
    /** An array of z3 coordinate.
    * No description
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setZ3(String value) throws RuntimeException {
        DoubleArraySTAttribute att = null;
        if (_att_z3 == null) {
            _att_z3 = (DoubleArraySTAttribute) attributeFactory.getAttribute("z3", "atomArray");
            if (_att_z3 == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : z3 probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new DoubleArraySTAttribute(_att_z3);
        super.addRemove(att, value);
    }
    /** An array of z3 coordinate.
    * No description
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setZ3(double[] value) throws RuntimeException {
        if (_att_z3 == null) {
            _att_z3 = (DoubleArraySTAttribute) attributeFactory.getAttribute("z3", "atomArray");
           if (_att_z3 == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : z3 probably incompatible attributeGroupName and attributeName ");
            }
        }
        DoubleArraySTAttribute att = new DoubleArraySTAttribute(_att_z3);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// attribute:   xFract

    /** cache */
    DoubleArraySTAttribute _att_xfract = null;
    /** Array of fractional x coordinate.
    * normally xFract, yFract and zFract should all be present or absent. If present a _crystal_ element should also occur.
    * @return CMLAttribute
    */
    public CMLAttribute getXFractAttribute() {
        return (CMLAttribute) getAttribute("xFract");
    }
    /** Array of fractional x coordinate.
    * normally xFract, yFract and zFract should all be present or absent. If present a _crystal_ element should also occur.
    * @return double[]
    */
    public double[] getXFract() {
        DoubleArraySTAttribute att = (DoubleArraySTAttribute) this.getXFractAttribute();
        if (att == null) {
            return null;
        }
        return att.getDoubleArray();
    }
    /** Array of fractional x coordinate.
    * normally xFract, yFract and zFract should all be present or absent. If present a _crystal_ element should also occur.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setXFract(String value) throws RuntimeException {
        DoubleArraySTAttribute att = null;
        if (_att_xfract == null) {
            _att_xfract = (DoubleArraySTAttribute) attributeFactory.getAttribute("xFract", "atomArray");
            if (_att_xfract == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : xFract probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new DoubleArraySTAttribute(_att_xfract);
        super.addRemove(att, value);
    }
    /** Array of fractional x coordinate.
    * normally xFract, yFract and zFract should all be present or absent. If present a _crystal_ element should also occur.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setXFract(double[] value) throws RuntimeException {
        if (_att_xfract == null) {
            _att_xfract = (DoubleArraySTAttribute) attributeFactory.getAttribute("xFract", "atomArray");
           if (_att_xfract == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : xFract probably incompatible attributeGroupName and attributeName ");
            }
        }
        DoubleArraySTAttribute att = new DoubleArraySTAttribute(_att_xfract);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// attribute:   yFract

    /** cache */
    DoubleArraySTAttribute _att_yfract = null;
    /** Array of fractional y coordinate.
    * normally xFract, yFract and zFract should all be present or absent. If present a _crystal_ element should also occur.
    * @return CMLAttribute
    */
    public CMLAttribute getYFractAttribute() {
        return (CMLAttribute) getAttribute("yFract");
    }
    /** Array of fractional y coordinate.
    * normally xFract, yFract and zFract should all be present or absent. If present a _crystal_ element should also occur.
    * @return double[]
    */
    public double[] getYFract() {
        DoubleArraySTAttribute att = (DoubleArraySTAttribute) this.getYFractAttribute();
        if (att == null) {
            return null;
        }
        return att.getDoubleArray();
    }
    /** Array of fractional y coordinate.
    * normally xFract, yFract and zFract should all be present or absent. If present a _crystal_ element should also occur.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setYFract(String value) throws RuntimeException {
        DoubleArraySTAttribute att = null;
        if (_att_yfract == null) {
            _att_yfract = (DoubleArraySTAttribute) attributeFactory.getAttribute("yFract", "atomArray");
            if (_att_yfract == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : yFract probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new DoubleArraySTAttribute(_att_yfract);
        super.addRemove(att, value);
    }
    /** Array of fractional y coordinate.
    * normally xFract, yFract and zFract should all be present or absent. If present a _crystal_ element should also occur.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setYFract(double[] value) throws RuntimeException {
        if (_att_yfract == null) {
            _att_yfract = (DoubleArraySTAttribute) attributeFactory.getAttribute("yFract", "atomArray");
           if (_att_yfract == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : yFract probably incompatible attributeGroupName and attributeName ");
            }
        }
        DoubleArraySTAttribute att = new DoubleArraySTAttribute(_att_yfract);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// attribute:   zFract

    /** cache */
    DoubleArraySTAttribute _att_zfract = null;
    /** Array of fractional z coordinate.
    * normally xFract, yFract and zFract should all be present or absent. If present a _crystal_ element should also occur.
    * @return CMLAttribute
    */
    public CMLAttribute getZFractAttribute() {
        return (CMLAttribute) getAttribute("zFract");
    }
    /** Array of fractional z coordinate.
    * normally xFract, yFract and zFract should all be present or absent. If present a _crystal_ element should also occur.
    * @return double[]
    */
    public double[] getZFract() {
        DoubleArraySTAttribute att = (DoubleArraySTAttribute) this.getZFractAttribute();
        if (att == null) {
            return null;
        }
        return att.getDoubleArray();
    }
    /** Array of fractional z coordinate.
    * normally xFract, yFract and zFract should all be present or absent. If present a _crystal_ element should also occur.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setZFract(String value) throws RuntimeException {
        DoubleArraySTAttribute att = null;
        if (_att_zfract == null) {
            _att_zfract = (DoubleArraySTAttribute) attributeFactory.getAttribute("zFract", "atomArray");
            if (_att_zfract == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : zFract probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new DoubleArraySTAttribute(_att_zfract);
        super.addRemove(att, value);
    }
    /** Array of fractional z coordinate.
    * normally xFract, yFract and zFract should all be present or absent. If present a _crystal_ element should also occur.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setZFract(double[] value) throws RuntimeException {
        if (_att_zfract == null) {
            _att_zfract = (DoubleArraySTAttribute) attributeFactory.getAttribute("zFract", "atomArray");
           if (_att_zfract == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : zFract probably incompatible attributeGroupName and attributeName ");
            }
        }
        DoubleArraySTAttribute att = new DoubleArraySTAttribute(_att_zfract);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// attribute:   atomID

    /** cache */
    StringArraySTAttribute _att_atomid = null;
    /** An array of atom IDs.
    * Normally an attribute of an array-based element.
    * @return CMLAttribute
    */
    public CMLAttribute getAtomIDAttribute() {
        return (CMLAttribute) getAttribute("atomID");
    }
    /** An array of atom IDs.
    * Normally an attribute of an array-based element.
    * @return String[]
    */
    public String[] getAtomID() {
        StringArraySTAttribute att = (StringArraySTAttribute) this.getAtomIDAttribute();
        if (att == null) {
            return null;
        }
        return att.getStringArray();
    }
    /** An array of atom IDs.
    * Normally an attribute of an array-based element.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setAtomID(String value) throws RuntimeException {
        StringArraySTAttribute att = null;
        if (_att_atomid == null) {
            _att_atomid = (StringArraySTAttribute) attributeFactory.getAttribute("atomID", "atomArray");
            if (_att_atomid == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : atomID probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringArraySTAttribute(_att_atomid);
        super.addRemove(att, value);
    }
    /** An array of atom IDs.
    * Normally an attribute of an array-based element.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setAtomID(String[] value) throws RuntimeException {
        if (_att_atomid == null) {
            _att_atomid = (StringArraySTAttribute) attributeFactory.getAttribute("atomID", "atomArray");
           if (_att_atomid == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : atomID probably incompatible attributeGroupName and attributeName ");
            }
        }
        StringArraySTAttribute att = new StringArraySTAttribute(_att_atomid);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// element:   atom

    /** An array of atom IDs.
    * Normally an attribute of an array-based element.
    * @param atom child to add
    */
    public void addAtom(AbstractAtom atom) {
        atom.detach();
        this.appendChild(atom);
    }
    /** An array of atom IDs.
    * Normally an attribute of an array-based element.
    * @return CMLElements<CMLAtom>
    */
    public CMLElements<CMLAtom> getAtomElements() {
        Elements elements = this.getChildElements("atom", CML_NS);
        return new CMLElements<CMLAtom>(elements);
    }
// element:   array

    /** An array of atom IDs.
    * Normally an attribute of an array-based element.
    * @param array child to add
    */
    public void addArray(AbstractArray array) {
        array.detach();
        this.appendChild(array);
    }
    /** An array of atom IDs.
    * Normally an attribute of an array-based element.
    * @return CMLElements<CMLArray>
    */
    public CMLElements<CMLArray> getArrayElements() {
        Elements elements = this.getChildElements("array", CML_NS);
        return new CMLElements<CMLArray>(elements);
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
        } else if (name.equals("ref")) {
            setRef(value);
        } else if (name.equals("elementType")) {
            setElementType(value);
        } else if (name.equals("count")) {
            setCount(value);
        } else if (name.equals("formalCharge")) {
            setFormalCharge(value);
        } else if (name.equals("hydrogenCount")) {
            setHydrogenCount(value);
        } else if (name.equals("occupancy")) {
            setOccupancy(value);
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
        } else if (name.equals("atomID")) {
            setAtomID(value);
	     } else {
            super.addAttribute(att);
        }
    }
}
