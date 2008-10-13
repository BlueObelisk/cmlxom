package org.xmlcml.cml.element.main;


import nu.xom.Attribute;

import org.xmlcml.cml.attribute.DictRefAttribute;
import org.xmlcml.cml.attribute.IdAttribute;
import org.xmlcml.cml.base.CMLAttribute;
import org.xmlcml.cml.base.CMLElement;
import org.xmlcml.cml.base.DoubleSTAttribute;
import org.xmlcml.cml.base.StringSTAttribute;

// end of part 1
/** CLASS DOCUMENTATION */
public abstract class AbstractParticle extends CMLElement {
    /** local name*/
    public final static String TAG = "particle";
    /** constructor. */    public AbstractParticle() {
        super("particle");
    }
/** copy constructor.
* deep copy using XOM copy()
* @param old element to copy
*/
    public AbstractParticle(AbstractParticle old) {
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
            _att_title = (StringSTAttribute) attributeFactory.getAttribute("title", "particle");
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
            _att_id = (IdAttribute) attributeFactory.getAttribute("id", "particle");
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
            _att_convention = (StringSTAttribute) attributeFactory.getAttribute("convention", "particle");
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
            _att_dictref = (DictRefAttribute) attributeFactory.getAttribute("dictRef", "particle");
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
            _att_type = (StringSTAttribute) attributeFactory.getAttribute("type", "particle");
            if (_att_type == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : type probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_type);
        super.addRemove(att, value);
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
            _att_x3 = (DoubleSTAttribute) attributeFactory.getAttribute("x3", "particle");
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
            _att_x3 = (DoubleSTAttribute) attributeFactory.getAttribute("x3", "particle");
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
            _att_y3 = (DoubleSTAttribute) attributeFactory.getAttribute("y3", "particle");
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
            _att_y3 = (DoubleSTAttribute) attributeFactory.getAttribute("y3", "particle");
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
            _att_z3 = (DoubleSTAttribute) attributeFactory.getAttribute("z3", "particle");
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
            _att_z3 = (DoubleSTAttribute) attributeFactory.getAttribute("z3", "particle");
           if (_att_z3 == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : z3 probably incompatible attributeGroupName and attributeName ");
            }
        }
        DoubleSTAttribute att = new DoubleSTAttribute(_att_z3);
        super.addAttribute(att);
        att.setCMLValue(value);
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
        } else if (name.equals("type")) {
            setType(value);
        } else if (name.equals("x3")) {
            setX3(value);
        } else if (name.equals("y3")) {
            setY3(value);
        } else if (name.equals("z3")) {
            setZ3(value);
	     } else {
            super.addAttribute(att);
        }
    }
}
