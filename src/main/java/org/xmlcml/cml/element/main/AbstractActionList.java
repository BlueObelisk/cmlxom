package org.xmlcml.cml.element.main;


import nu.xom.Attribute;

import org.xmlcml.cml.attribute.DictRefAttribute;
import org.xmlcml.cml.attribute.IdAttribute;
import org.xmlcml.cml.attribute.UnitsAttribute;
import org.xmlcml.cml.base.CMLAttribute;
import org.xmlcml.cml.base.CMLElement;
import org.xmlcml.cml.base.DoubleSTAttribute;
import org.xmlcml.cml.base.StringSTAttribute;

// end of part 1
/** CLASS DOCUMENTATION */
public abstract class AbstractActionList extends CMLElement {
    /** local name*/
    public final static String TAG = "actionList";
    /** constructor. */    public AbstractActionList() {
        super("actionList");
    }
/** copy constructor.
* deep copy using XOM copy()
* @param old element to copy
*/
    public AbstractActionList(AbstractActionList old) {
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
            _att_title = (StringSTAttribute) attributeFactory.getAttribute("title", "actionList");
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
            _att_id = (IdAttribute) attributeFactory.getAttribute("id", "actionList");
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
            _att_convention = (StringSTAttribute) attributeFactory.getAttribute("convention", "actionList");
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
            _att_dictref = (DictRefAttribute) attributeFactory.getAttribute("dictRef", "actionList");
            if (_att_dictref == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : dictRef probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new DictRefAttribute(_att_dictref);
        super.addRemove(att, value);
    }
// attribute:   start

    /** cache */
    StringSTAttribute _att_start = null;
    /** The start value.
    * The start value in any allowable 
    *                 XSD representation 
    * @return CMLAttribute
    */
    public CMLAttribute getStartAttribute() {
        return (CMLAttribute) getAttribute("start");
    }
    /** The start value.
    * The start value in any allowable 
    *                 XSD representation 
    * @return String
    */
    public String getStart() {
        StringSTAttribute att = (StringSTAttribute) this.getStartAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** The start value.
    * The start value in any allowable 
    *                 XSD representation 
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setStart(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_start == null) {
            _att_start = (StringSTAttribute) attributeFactory.getAttribute("start", "actionList");
            if (_att_start == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : start probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_start);
        super.addRemove(att, value);
    }
// attribute:   startCondition

    /** cache */
    StringSTAttribute _att_startcondition = null;
    /** The start condition.
    * This can describe the condition(s) that has to be met before an action can begin, such as in a recipe. Semantics are unexplored but could be used to control robotic operations.
    * @return CMLAttribute
    */
    public CMLAttribute getStartConditionAttribute() {
        return (CMLAttribute) getAttribute("startCondition");
    }
    /** The start condition.
    * This can describe the condition(s) that has to be met before an action can begin, such as in a recipe. Semantics are unexplored but could be used to control robotic operations.
    * @return String
    */
    public String getStartCondition() {
        StringSTAttribute att = (StringSTAttribute) this.getStartConditionAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** The start condition.
    * This can describe the condition(s) that has to be met before an action can begin, such as in a recipe. Semantics are unexplored but could be used to control robotic operations.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setStartCondition(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_startcondition == null) {
            _att_startcondition = (StringSTAttribute) attributeFactory.getAttribute("startCondition", "actionList");
            if (_att_startcondition == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : startCondition probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_startcondition);
        super.addRemove(att, value);
    }
// attribute:   duration

    /** cache */
    StringSTAttribute _att_duration = null;
    /** The duration of the action.
    * Semantics undefined.
    * @return CMLAttribute
    */
    public CMLAttribute getDurationAttribute() {
        return (CMLAttribute) getAttribute("duration");
    }
    /** The duration of the action.
    * Semantics undefined.
    * @return String
    */
    public String getDuration() {
        StringSTAttribute att = (StringSTAttribute) this.getDurationAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** The duration of the action.
    * Semantics undefined.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setDuration(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_duration == null) {
            _att_duration = (StringSTAttribute) attributeFactory.getAttribute("duration", "actionList");
            if (_att_duration == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : duration probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_duration);
        super.addRemove(att, value);
    }
// attribute:   end

    /** cache */
    StringSTAttribute _att_end = null;
    /** The end value.
    * The end value in any allowable XSD representation 
    *                 of data.
    * @return CMLAttribute
    */
    public CMLAttribute getEndAttribute() {
        return (CMLAttribute) getAttribute("end");
    }
    /** The end value.
    * The end value in any allowable XSD representation 
    *                 of data.
    * @return String
    */
    public String getEnd() {
        StringSTAttribute att = (StringSTAttribute) this.getEndAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** The end value.
    * The end value in any allowable XSD representation 
    *                 of data.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setEnd(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_end == null) {
            _att_end = (StringSTAttribute) attributeFactory.getAttribute("end", "actionList");
            if (_att_end == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : end probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_end);
        super.addRemove(att, value);
    }
// attribute:   endCondition

    /** cache */
    StringSTAttribute _att_endcondition = null;
    /** The end condition.
    * 
    *                     At present a human-readable string describing some condition when the
    *           ac tion should end. As XML develops it may be possible to add machine-processable
    *           semantics in this field.
    * @return CMLAttribute
    */
    public CMLAttribute getEndConditionAttribute() {
        return (CMLAttribute) getAttribute("endCondition");
    }
    /** The end condition.
    * 
    *                     At present a human-readable string describing some condition when the
    *           ac tion should end. As XML develops it may be possible to add machine-processable
    *           semantics in this field.
    * @return String
    */
    public String getEndCondition() {
        StringSTAttribute att = (StringSTAttribute) this.getEndConditionAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** The end condition.
    * 
    *                     At present a human-readable string describing some condition when the
    *           ac tion should end. As XML develops it may be possible to add machine-processable
    *           semantics in this field.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setEndCondition(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_endcondition == null) {
            _att_endcondition = (StringSTAttribute) attributeFactory.getAttribute("endCondition", "actionList");
            if (_att_endcondition == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : endCondition probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_endcondition);
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
            _att_units = (UnitsAttribute) attributeFactory.getAttribute("units", "actionList");
            if (_att_units == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : units probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new UnitsAttribute(_att_units);
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
            _att_count = (DoubleSTAttribute) attributeFactory.getAttribute("count", "actionList");
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
            _att_count = (DoubleSTAttribute) attributeFactory.getAttribute("count", "actionList");
           if (_att_count == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : count probably incompatible attributeGroupName and attributeName ");
            }
        }
        DoubleSTAttribute att = new DoubleSTAttribute(_att_count);
        super.addAttribute(att);
        att.setCMLValue(value);
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
            _att_type = (StringSTAttribute) attributeFactory.getAttribute("type", "actionList");
            if (_att_type == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : type probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_type);
        super.addRemove(att, value);
    }
// attribute:   order

    /** cache */
    StringSTAttribute _att_order = null;
    /** Describes whether child elements are sequential or parallel.
    * There is no default.
    * @return CMLAttribute
    */
    public CMLAttribute getOrderAttribute() {
        return (CMLAttribute) getAttribute("order");
    }
    /** Describes whether child elements are sequential or parallel.
    * There is no default.
    * @return String
    */
    public String getOrder() {
        StringSTAttribute att = (StringSTAttribute) this.getOrderAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** Describes whether child elements are sequential or parallel.
    * There is no default.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setOrder(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_order == null) {
            _att_order = (StringSTAttribute) attributeFactory.getAttribute("order", "actionList");
            if (_att_order == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : order probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_order);
        super.addRemove(att, value);
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
        } else if (name.equals("start")) {
            setStart(value);
        } else if (name.equals("startCondition")) {
            setStartCondition(value);
        } else if (name.equals("duration")) {
            setDuration(value);
        } else if (name.equals("end")) {
            setEnd(value);
        } else if (name.equals("endCondition")) {
            setEndCondition(value);
        } else if (name.equals("units")) {
            setUnits(value);
        } else if (name.equals("count")) {
            setCount(value);
        } else if (name.equals("type")) {
            setType(value);
        } else if (name.equals("order")) {
            setOrder(value);
	     } else {
            super.addAttribute(att);
        }
    }
}
