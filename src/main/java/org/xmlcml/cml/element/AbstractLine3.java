/**
 *    Copyright 2011 Peter Murray-Rust et. al.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package org.xmlcml.cml.element;


import nu.xom.Attribute;

import org.xmlcml.cml.attribute.DictRefAttribute;
import org.xmlcml.cml.attribute.IdAttribute;
import org.xmlcml.cml.attribute.UnitsAttribute;
import org.xmlcml.cml.base.CMLAttribute;
import org.xmlcml.cml.base.CMLElement;
import org.xmlcml.cml.base.DoubleArraySTAttribute;
import org.xmlcml.cml.base.StringSTAttribute;

// end of part 1
/** CLASS DOCUMENTATION */
public abstract class AbstractLine3 extends CMLElement {
    /** local name*/
    public final static String TAG = "line3";
    /** constructor. */    public AbstractLine3() {
        super("line3");
    }
/** copy constructor.
* deep copy using XOM copy()
* @param old element to copy
*/
    public AbstractLine3(AbstractLine3 old) {
        super((CMLElement) old);
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
            _att_convention = (StringSTAttribute) attributeFactory.getAttribute("convention", "line3");
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
            _att_dictref = (DictRefAttribute) attributeFactory.getAttribute("dictRef", "line3");
            if (_att_dictref == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : dictRef probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new DictRefAttribute(_att_dictref);
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
            _att_id = (IdAttribute) attributeFactory.getAttribute("id", "line3");
            if (_att_id == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : id probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new IdAttribute(_att_id);
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
            _att_title = (StringSTAttribute) attributeFactory.getAttribute("title", "line3");
            if (_att_title == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : title probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_title);
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
            _att_units = (UnitsAttribute) attributeFactory.getAttribute("units", "line3");
            if (_att_units == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : units probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new UnitsAttribute(_att_units);
        super.addRemove(att, value);
    }
// attribute:   point3

    /** cache */
    DoubleArraySTAttribute _att_point3 = null;
    /** A point in 3 dimensions.
    * can be used for any complex 
    * 					geometrical object, such as line.
    * @return CMLAttribute
    */
    public CMLAttribute getPoint3Attribute() {
        return (CMLAttribute) getAttribute("point3");
    }
    /** A point in 3 dimensions.
    * can be used for any complex 
    * 					geometrical object, such as line.
    * @return double[]
    */
    public double[] getPoint3() {
        DoubleArraySTAttribute att = (DoubleArraySTAttribute) this.getPoint3Attribute();
        if (att == null) {
            return null;
        }
        return att.getDoubleArray();
    }
    /** A point in 3 dimensions.
    * can be used for any complex 
    * 					geometrical object, such as line.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setPoint3(String value) throws RuntimeException {
        DoubleArraySTAttribute att = null;
        if (_att_point3 == null) {
            _att_point3 = (DoubleArraySTAttribute) attributeFactory.getAttribute("point3", "line3");
            if (_att_point3 == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : point3 probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new DoubleArraySTAttribute(_att_point3);
        super.addRemove(att, value);
    }
    /** A point in 3 dimensions.
    * can be used for any complex 
    * 					geometrical object, such as line.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setPoint3(double[] value) throws RuntimeException {
        if (_att_point3 == null) {
            _att_point3 = (DoubleArraySTAttribute) attributeFactory.getAttribute("point3", "line3");
           if (_att_point3 == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : point3 probably incompatible attributeGroupName and attributeName ");
            }
        }
        DoubleArraySTAttribute att = new DoubleArraySTAttribute(_att_point3);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// attribute:   vector3

    /** cache */
    DoubleArraySTAttribute _att_vector3 = null;
    /** A vector in 3 dimensions.
    * can be used for any complex geometrical object,
    *                 such as line.
    * @return CMLAttribute
    */
    public CMLAttribute getVector3Attribute() {
        return (CMLAttribute) getAttribute("vector3");
    }
    /** A vector in 3 dimensions.
    * can be used for any complex geometrical object,
    *                 such as line.
    * @return double[]
    */
    public double[] getVector3() {
        DoubleArraySTAttribute att = (DoubleArraySTAttribute) this.getVector3Attribute();
        if (att == null) {
            return null;
        }
        return att.getDoubleArray();
    }
    /** A vector in 3 dimensions.
    * can be used for any complex geometrical object,
    *                 such as line.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setVector3(String value) throws RuntimeException {
        DoubleArraySTAttribute att = null;
        if (_att_vector3 == null) {
            _att_vector3 = (DoubleArraySTAttribute) attributeFactory.getAttribute("vector3", "line3");
            if (_att_vector3 == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : vector3 probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new DoubleArraySTAttribute(_att_vector3);
        super.addRemove(att, value);
    }
    /** A vector in 3 dimensions.
    * can be used for any complex geometrical object,
    *                 such as line.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setVector3(double[] value) throws RuntimeException {
        if (_att_vector3 == null) {
            _att_vector3 = (DoubleArraySTAttribute) attributeFactory.getAttribute("vector3", "line3");
           if (_att_vector3 == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : vector3 probably incompatible attributeGroupName and attributeName ");
            }
        }
        DoubleArraySTAttribute att = new DoubleArraySTAttribute(_att_vector3);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
    DoubleArraySTAttribute _xmlContent;
    /** An unbounded line in 3-space.
    * Defined by 6 real numbers, conventionally an arbitrary 
    *             point on the line and a vector3. There is no significance to the point 
    *             (i.e. it is not the "end of the line")  and there are an infinite number of 
    *             ways of representing the line. DANGER. Line3 now uses the point3 and vector3 attributes
    *             and the line3Type may be OBSOLETED.
    * @return double[]
    */
    public double[] getXMLContent() {
        String content = this.getValue();
        if (_xmlContent == null) {
            _xmlContent = new DoubleArraySTAttribute("_xmlContent");
        }
        _xmlContent.setCMLValue(content);
        return _xmlContent.getDoubleArray();
    }
    /** An unbounded line in 3-space.
    * Defined by 6 real numbers, conventionally an arbitrary 
    *             point on the line and a vector3. There is no significance to the point 
    *             (i.e. it is not the "end of the line")  and there are an infinite number of 
    *             ways of representing the line. DANGER. Line3 now uses the point3 and vector3 attributes
    *             and the line3Type may be OBSOLETED.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setXMLContent(String value) throws RuntimeException {
        if (_xmlContent == null) {
            _xmlContent = new DoubleArraySTAttribute("_xmlContent");
        }
        _xmlContent.setCMLValue(value);
        String attval = _xmlContent.getValue();
        this.removeChildren();
        this.appendChild(attval);
    }
    /** An unbounded line in 3-space.
    * Defined by 6 real numbers, conventionally an arbitrary 
    *             point on the line and a vector3. There is no significance to the point 
    *             (i.e. it is not the "end of the line")  and there are an infinite number of 
    *             ways of representing the line. DANGER. Line3 now uses the point3 and vector3 attributes
    *             and the line3Type may be OBSOLETED.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setXMLContent(double[] value) throws RuntimeException {
        if (_xmlContent == null) {
            _xmlContent = new DoubleArraySTAttribute("_xmlContent");
        }
        _xmlContent.setCMLValue(value);
        String attval = (String)_xmlContent.getValue();
        this.removeChildren();
        this.appendChild(attval);
    }
    /** overrides addAttribute(Attribute)
     * reroutes calls to setFoo()
     * @param att  attribute
    */
    public void addAttribute(Attribute att) {
        String name = att.getLocalName();
        String value = att.getValue();
        if (name == null) {
        } else if (name.equals("convention")) {
            setConvention(value);
        } else if (name.equals("dictRef")) {
            setDictRef(value);
        } else if (name.equals("id")) {
            setId(value);
        } else if (name.equals("title")) {
            setTitle(value);
        } else if (name.equals("units")) {
            setUnits(value);
        } else if (name.equals("point3")) {
            setPoint3(value);
        } else if (name.equals("vector3")) {
            setVector3(value);
	     } else {
            super.addAttribute(att);
        }
    }
}
