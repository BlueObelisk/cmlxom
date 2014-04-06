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
import nu.xom.Elements;

import org.xmlcml.cml.attribute.DictRefAttribute;
import org.xmlcml.cml.attribute.IdAttribute;
import org.xmlcml.cml.attribute.RefAttribute;
import org.xmlcml.cml.base.CMLAttribute;
import org.xmlcml.cml.base.CMLConstants;
import org.xmlcml.cml.base.CMLElement;
import org.xmlcml.cml.base.CMLElements;
import org.xmlcml.cml.base.StringSTAttribute;

// end of part 1
/** CLASS DOCUMENTATION */
public abstract class AbstractParameter extends CMLElement {
    /** local name*/
    public final static String TAG = "parameter";
    /** constructor. */    public AbstractParameter() {
        super("parameter");
    }
/** copy constructor.
* deep copy using XOM copy()
* @param old element to copy
*/
    public AbstractParameter(AbstractParameter old) {
        super((CMLElement) old);
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
            _att_ref = (RefAttribute) attributeFactory.getAttribute("ref", "parameter");
            if (_att_ref == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : ref probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new RefAttribute(_att_ref);
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
            _att_title = (StringSTAttribute) attributeFactory.getAttribute("title", "parameter");
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
            _att_id = (IdAttribute) attributeFactory.getAttribute("id", "parameter");
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
            _att_convention = (StringSTAttribute) attributeFactory.getAttribute("convention", "parameter");
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
            _att_dictref = (DictRefAttribute) attributeFactory.getAttribute("dictRef", "parameter");
            if (_att_dictref == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : dictRef probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new DictRefAttribute(_att_dictref);
        super.addRemove(att, value);
    }
// attribute:   value

    /** cache */
    StringSTAttribute _att_value = null;
    /** Value of a scalar object.
    * The value must be consistent with the dataType of the object.
    * @return CMLAttribute
    */
    public CMLAttribute getCMLValueAttribute() {
        return (CMLAttribute) getAttribute("value");
    }
    /** Value of a scalar object.
    * The value must be consistent with the dataType of the object.
    * @return String
    */
    public String getCMLValue() {
        StringSTAttribute att = (StringSTAttribute) this.getCMLValueAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** Value of a scalar object.
    * The value must be consistent with the dataType of the object.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setCMLValue(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_value == null) {
            _att_value = (StringSTAttribute) attributeFactory.getAttribute("value", "parameter");
            if (_att_value == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : value probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_value);
        super.addRemove(att, value);
    }
// attribute:   constraint

    /** cache */
    StringSTAttribute _att_constraint = null;
    /** Constraint on a parameter.
    * Semantics not yet finalised. We anticipate "fixed", 
    *                 "none" and symbolic relationships to other parameters.
    * @return CMLAttribute
    */
    public CMLAttribute getConstraintAttribute() {
        return (CMLAttribute) getAttribute("constraint");
    }
    /** Constraint on a parameter.
    * Semantics not yet finalised. We anticipate "fixed", 
    *                 "none" and symbolic relationships to other parameters.
    * @return String
    */
    public String getConstraint() {
        StringSTAttribute att = (StringSTAttribute) this.getConstraintAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** Constraint on a parameter.
    * Semantics not yet finalised. We anticipate "fixed", 
    *                 "none" and symbolic relationships to other parameters.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setConstraint(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_constraint == null) {
            _att_constraint = (StringSTAttribute) attributeFactory.getAttribute("constraint", "parameter");
            if (_att_constraint == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : constraint probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_constraint);
        super.addRemove(att, value);
    }
// attribute:   name

    /** cache */
    StringSTAttribute _att_name = null;
    /** Name of the object.
    * A string by which the object is known. Often a required attribute. The may or may not be a semi-controlled vocabulary.
    * @return CMLAttribute
    */
    public CMLAttribute getNameAttribute() {
        return (CMLAttribute) getAttribute("name");
    }
    /** Name of the object.
    * A string by which the object is known. Often a required attribute. The may or may not be a semi-controlled vocabulary.
    * @return String
    */
    public String getName() {
        StringSTAttribute att = (StringSTAttribute) this.getNameAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** Name of the object.
    * A string by which the object is known. Often a required attribute. The may or may not be a semi-controlled vocabulary.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setName(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_name == null) {
            _att_name = (StringSTAttribute) attributeFactory.getAttribute("name", "parameter");
            if (_att_name == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : name probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_name);
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
            _att_role = (StringSTAttribute) attributeFactory.getAttribute("role", "parameter");
            if (_att_role == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : role probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_role);
        super.addRemove(att, value);
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
// element:   matrix

    /** Role of the object.
    * How the object functions or its position in the architecture. No controlled vocabulary.
    * @param matrix child to add
    */
    public void addMatrix(AbstractMatrix matrix) {
        matrix.detach();
        this.appendChild(matrix);
    }
    /** Role of the object.
    * How the object functions or its position in the architecture. No controlled vocabulary.
    * @return CMLElements<CMLMatrix>
    */
    public CMLElements<CMLMatrix> getMatrixElements() {
        Elements elements = this.getChildElements("matrix", CMLConstants.CML_NS);
        return new CMLElements<CMLMatrix>(elements);
    }
// element:   property

    /** Role of the object.
    * How the object functions or its position in the architecture. No controlled vocabulary.
    * @param property child to add
    */
    public void addProperty(AbstractProperty property) {
        property.detach();
        this.appendChild(property);
    }
    /** Role of the object.
    * How the object functions or its position in the architecture. No controlled vocabulary.
    * @return CMLElements<CMLProperty>
    */
    public CMLElements<CMLProperty> getPropertyElements() {
        Elements elements = this.getChildElements("property", CMLConstants.CML_NS);
        return new CMLElements<CMLProperty>(elements);
    }
// element:   expression

    /** Role of the object.
    * How the object functions or its position in the architecture. No controlled vocabulary.
    * @param expression child to add
    */
    public void addExpression(AbstractExpression expression) {
        expression.detach();
        this.appendChild(expression);
    }
    /** Role of the object.
    * How the object functions or its position in the architecture. No controlled vocabulary.
    * @return CMLElements<CMLExpression>
    */
    public CMLElements<CMLExpression> getExpressionElements() {
        Elements elements = this.getChildElements("expression", CMLConstants.CML_NS);
        return new CMLElements<CMLExpression>(elements);
    }
// element:   gradient

    /** Role of the object.
    * How the object functions or its position in the architecture. No controlled vocabulary.
    * @param gradient child to add
    */
    public void addGradient(AbstractGradient gradient) {
        gradient.detach();
        this.appendChild(gradient);
    }
    /** Role of the object.
    * How the object functions or its position in the architecture. No controlled vocabulary.
    * @return CMLElements<CMLGradient>
    */
    public CMLElements<CMLGradient> getGradientElements() {
        Elements elements = this.getChildElements("gradient", CMLConstants.CML_NS);
        return new CMLElements<CMLGradient>(elements);
    }
    /** overrides addAttribute(Attribute)
     * reroutes calls to setFoo()
     * @param att  attribute
    */
    public void addAttribute(Attribute att) {
        String name = att.getLocalName();
        String value = att.getValue();
        if (name == null) {
        } else if (name.equals("ref")) {
            setRef(value);
        } else if (name.equals("title")) {
            setTitle(value);
        } else if (name.equals("id")) {
            setId(value);
        } else if (name.equals("convention")) {
            setConvention(value);
        } else if (name.equals("dictRef")) {
            setDictRef(value);
        } else if (name.equals("value")) {
            setCMLValue(value);
        } else if (name.equals("constraint")) {
            setConstraint(value);
        } else if (name.equals("name")) {
            setName(value);
        } else if (name.equals("role")) {
            setRole(value);
	     } else {
            super.addAttribute(att);
        }
    }
}
