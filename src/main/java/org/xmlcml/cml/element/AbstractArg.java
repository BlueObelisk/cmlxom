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
public abstract class AbstractArg extends CMLElement {
    /** local name*/
    public final static String TAG = "arg";
    /** constructor. */    public AbstractArg() {
        super("arg");
    }
/** copy constructor.
* deep copy using XOM copy()
* @param old element to copy
*/
    public AbstractArg(AbstractArg old) {
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
            _att_title = (StringSTAttribute) attributeFactory.getAttribute("title", "arg");
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
            _att_id = (IdAttribute) attributeFactory.getAttribute("id", "arg");
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
            _att_convention = (StringSTAttribute) attributeFactory.getAttribute("convention", "arg");
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
            _att_dictref = (DictRefAttribute) attributeFactory.getAttribute("dictRef", "arg");
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
            _att_ref = (RefAttribute) attributeFactory.getAttribute("ref", "arg");
            if (_att_ref == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : ref probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new RefAttribute(_att_ref);
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
            _att_name = (StringSTAttribute) attributeFactory.getAttribute("name", "arg");
            if (_att_name == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : name probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_name);
        super.addRemove(att, value);
    }
// attribute:   dataType

    /** cache */
    StringSTAttribute _att_datatype = null;
    /** The data type of the object.
    * Normally applied to scalar/array 
    *                 objects but may extend to more complex one.
    * @return CMLAttribute
    */
    public CMLAttribute getDataTypeAttribute() {
        return (CMLAttribute) getAttribute("dataType");
    }
    /** The data type of the object.
    * Normally applied to scalar/array 
    *                 objects but may extend to more complex one.
    * @return String
    */
    public String getDataType() {
        StringSTAttribute att = (StringSTAttribute) this.getDataTypeAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** The data type of the object.
    * Normally applied to scalar/array 
    *                 objects but may extend to more complex one.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setDataType(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_datatype == null) {
            _att_datatype = (StringSTAttribute) attributeFactory.getAttribute("dataType", "arg");
            if (_att_datatype == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : dataType probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_datatype);
        super.addRemove(att, value);
    }
// attribute:   substitute

    /** cache */
    StringSTAttribute _att_substitute = null;
    /** A flag on 'arg' to indicate that the value can be substituted.
    * This is still experimental. The value may be an 
    *                 XPath expression, at present
    *                 all attributes (".//@*") are processed. If an attribute contains _ijk_ where the
    *                 name of the arg is 'ijk' this string is replaced by the value of ijk,
    *                 e.g. if arg with name ijk has a value of 2 then 'm_ijk__z3' becomes
    *                 'm2_z3'. substitute="." replaces this element by its value
    * @return CMLAttribute
    */
    public CMLAttribute getSubstituteAttribute() {
        return (CMLAttribute) getAttribute("substitute");
    }
    /** A flag on 'arg' to indicate that the value can be substituted.
    * This is still experimental. The value may be an 
    *                 XPath expression, at present
    *                 all attributes (".//@*") are processed. If an attribute contains _ijk_ where the
    *                 name of the arg is 'ijk' this string is replaced by the value of ijk,
    *                 e.g. if arg with name ijk has a value of 2 then 'm_ijk__z3' becomes
    *                 'm2_z3'. substitute="." replaces this element by its value
    * @return String
    */
    public String getSubstitute() {
        StringSTAttribute att = (StringSTAttribute) this.getSubstituteAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** A flag on 'arg' to indicate that the value can be substituted.
    * This is still experimental. The value may be an 
    *                 XPath expression, at present
    *                 all attributes (".//@*") are processed. If an attribute contains _ijk_ where the
    *                 name of the arg is 'ijk' this string is replaced by the value of ijk,
    *                 e.g. if arg with name ijk has a value of 2 then 'm_ijk__z3' becomes
    *                 'm2_z3'. substitute="." replaces this element by its value
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setSubstitute(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_substitute == null) {
            _att_substitute = (StringSTAttribute) attributeFactory.getAttribute("substitute", "arg");
            if (_att_substitute == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : substitute probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_substitute);
        super.addRemove(att, value);
    }
// attribute:   parameterName

    /** cache */
    StringSTAttribute _att_parametername = null;
    /** parameter name passed to an element.
    * This is still experimental.
    * @return CMLAttribute
    */
    public CMLAttribute getParameterNameAttribute() {
        return (CMLAttribute) getAttribute("parameterName");
    }
    /** parameter name passed to an element.
    * This is still experimental.
    * @return String
    */
    public String getParameterName() {
        StringSTAttribute att = (StringSTAttribute) this.getParameterNameAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** parameter name passed to an element.
    * This is still experimental.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setParameterName(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_parametername == null) {
            _att_parametername = (StringSTAttribute) attributeFactory.getAttribute("parameterName", "arg");
            if (_att_parametername == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : parameterName probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_parametername);
        super.addRemove(att, value);
    }
// attribute:   parentAttribute

    /** cache */
    StringSTAttribute _att_parentattribute = null;
    /** raplaces attribute on parent.
    * This is still experimental. Creates, overwriting
    *                 if necessary, an attribute on parent. Example:
    *                 
    *                 <foo>
    *                   <arg parentAttribute="bar">zubbo</arg>
    *                 
    *                 will create an attribute bar="zubbo" on <foo> 
    *                 
    * @return CMLAttribute
    */
    public CMLAttribute getParentAttributeAttribute() {
        return (CMLAttribute) getAttribute("parentAttribute");
    }
    /** raplaces attribute on parent.
    * This is still experimental. Creates, overwriting
    *                 if necessary, an attribute on parent. Example:
    *                 
    *                 <foo>
    *                   <arg parentAttribute="bar">zubbo</arg>
    *                 
    *                 will create an attribute bar="zubbo" on <foo> 
    *                 
    * @return String
    */
    public String getParentAttribute() {
        StringSTAttribute att = (StringSTAttribute) this.getParentAttributeAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** raplaces attribute on parent.
    * This is still experimental. Creates, overwriting
    *                 if necessary, an attribute on parent. Example:
    *                 
    *                 <foo>
    *                   <arg parentAttribute="bar">zubbo</arg>
    *                 
    *                 will create an attribute bar="zubbo" on <foo> 
    *                 
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setParentAttribute(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_parentattribute == null) {
            _att_parentattribute = (StringSTAttribute) attributeFactory.getAttribute("parentAttribute", "arg");
            if (_att_parentattribute == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : parentAttribute probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_parentattribute);
        super.addRemove(att, value);
    }
// attribute:   delete

    /** cache */
    StringSTAttribute _att_delete = null;
    /** A flag indicated that the element can detach/delete itself.
    * An element containg this attribute may only have a transient existence
    *                 (e.g. a template to create other elements) and this attribute shows that 
    *                 the element can be deleted at the appropriate stage. The time at which this
    *                 is called is application dependent. At present the presence of the attribute
    *                 is sufficient to trigger this; later a controlled vocabulary will be developed.
    * @return CMLAttribute
    */
    public CMLAttribute getDeleteAttribute() {
        return (CMLAttribute) getAttribute("delete");
    }
    /** A flag indicated that the element can detach/delete itself.
    * An element containg this attribute may only have a transient existence
    *                 (e.g. a template to create other elements) and this attribute shows that 
    *                 the element can be deleted at the appropriate stage. The time at which this
    *                 is called is application dependent. At present the presence of the attribute
    *                 is sufficient to trigger this; later a controlled vocabulary will be developed.
    * @return String
    */
    public String getDelete() {
        StringSTAttribute att = (StringSTAttribute) this.getDeleteAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** A flag indicated that the element can detach/delete itself.
    * An element containg this attribute may only have a transient existence
    *                 (e.g. a template to create other elements) and this attribute shows that 
    *                 the element can be deleted at the appropriate stage. The time at which this
    *                 is called is application dependent. At present the presence of the attribute
    *                 is sufficient to trigger this; later a controlled vocabulary will be developed.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setDelete(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_delete == null) {
            _att_delete = (StringSTAttribute) attributeFactory.getAttribute("delete", "arg");
            if (_att_delete == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : delete probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_delete);
        super.addRemove(att, value);
    }
// attribute:   eval

    /** cache */
    StringSTAttribute _att_eval = null;
    /** A flag on 'arg' to indicate that the value can be calculated.
    * This is still experimental.  if eval="_ijk_+3" and
    *                 the value of the ijk was 2, this would change the value of the arg to 5. 
    *                 Only + and - are currently allowed
    * @return CMLAttribute
    */
    public CMLAttribute getEvalAttribute() {
        return (CMLAttribute) getAttribute("eval");
    }
    /** A flag on 'arg' to indicate that the value can be calculated.
    * This is still experimental.  if eval="_ijk_+3" and
    *                 the value of the ijk was 2, this would change the value of the arg to 5. 
    *                 Only + and - are currently allowed
    * @return String
    */
    public String getEval() {
        StringSTAttribute att = (StringSTAttribute) this.getEvalAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** A flag on 'arg' to indicate that the value can be calculated.
    * This is still experimental.  if eval="_ijk_+3" and
    *                 the value of the ijk was 2, this would change the value of the arg to 5. 
    *                 Only + and - are currently allowed
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setEval(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_eval == null) {
            _att_eval = (StringSTAttribute) attributeFactory.getAttribute("eval", "arg");
            if (_att_eval == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : eval probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_eval);
        super.addRemove(att, value);
    }
// element:   atom

    /** A flag on 'arg' to indicate that the value can be calculated.
    * This is still experimental.  if eval="_ijk_+3" and
    *                 the value of the ijk was 2, this would change the value of the arg to 5. 
    *                 Only + and - are currently allowed
    * @param atom child to add
    */
    public void addAtom(AbstractAtom atom) {
        atom.detach();
        this.appendChild(atom);
    }
    /** A flag on 'arg' to indicate that the value can be calculated.
    * This is still experimental.  if eval="_ijk_+3" and
    *                 the value of the ijk was 2, this would change the value of the arg to 5. 
    *                 Only + and - are currently allowed
    * @return CMLElements<CMLAtom>
    */
    public CMLElements<CMLAtom> getAtomElements() {
        Elements elements = this.getChildElements("atom", CMLConstants.CML_NS);
        return new CMLElements<CMLAtom>(elements);
    }
// element:   atomType

    /** A flag on 'arg' to indicate that the value can be calculated.
    * This is still experimental.  if eval="_ijk_+3" and
    *                 the value of the ijk was 2, this would change the value of the arg to 5. 
    *                 Only + and - are currently allowed
    * @param atomType child to add
    */
    public void addAtomType(AbstractAtomType atomType) {
        atomType.detach();
        this.appendChild(atomType);
    }
    /** A flag on 'arg' to indicate that the value can be calculated.
    * This is still experimental.  if eval="_ijk_+3" and
    *                 the value of the ijk was 2, this would change the value of the arg to 5. 
    *                 Only + and - are currently allowed
    * @return CMLElements<CMLAtomType>
    */
    public CMLElements<CMLAtomType> getAtomTypeElements() {
        Elements elements = this.getChildElements("atomType", CMLConstants.CML_NS);
        return new CMLElements<CMLAtomType>(elements);
    }
// element:   scalar

    /** A flag on 'arg' to indicate that the value can be calculated.
    * This is still experimental.  if eval="_ijk_+3" and
    *                 the value of the ijk was 2, this would change the value of the arg to 5. 
    *                 Only + and - are currently allowed
    * @param scalar child to add
    */
    public void addScalar(AbstractScalar scalar) {
        scalar.detach();
        this.appendChild(scalar);
    }
    /** A flag on 'arg' to indicate that the value can be calculated.
    * This is still experimental.  if eval="_ijk_+3" and
    *                 the value of the ijk was 2, this would change the value of the arg to 5. 
    *                 Only + and - are currently allowed
    * @return CMLElements<CMLScalar>
    */
    public CMLElements<CMLScalar> getScalarElements() {
        Elements elements = this.getChildElements("scalar", CMLConstants.CML_NS);
        return new CMLElements<CMLScalar>(elements);
    }
// element:   array

    /** A flag on 'arg' to indicate that the value can be calculated.
    * This is still experimental.  if eval="_ijk_+3" and
    *                 the value of the ijk was 2, this would change the value of the arg to 5. 
    *                 Only + and - are currently allowed
    * @param array child to add
    */
    public void addArray(AbstractArray array) {
        array.detach();
        this.appendChild(array);
    }
    /** A flag on 'arg' to indicate that the value can be calculated.
    * This is still experimental.  if eval="_ijk_+3" and
    *                 the value of the ijk was 2, this would change the value of the arg to 5. 
    *                 Only + and - are currently allowed
    * @return CMLElements<CMLArray>
    */
    public CMLElements<CMLArray> getArrayElements() {
        Elements elements = this.getChildElements("array", CMLConstants.CML_NS);
        return new CMLElements<CMLArray>(elements);
    }
// element:   matrix

    /** A flag on 'arg' to indicate that the value can be calculated.
    * This is still experimental.  if eval="_ijk_+3" and
    *                 the value of the ijk was 2, this would change the value of the arg to 5. 
    *                 Only + and - are currently allowed
    * @param matrix child to add
    */
    public void addMatrix(AbstractMatrix matrix) {
        matrix.detach();
        this.appendChild(matrix);
    }
    /** A flag on 'arg' to indicate that the value can be calculated.
    * This is still experimental.  if eval="_ijk_+3" and
    *                 the value of the ijk was 2, this would change the value of the arg to 5. 
    *                 Only + and - are currently allowed
    * @return CMLElements<CMLMatrix>
    */
    public CMLElements<CMLMatrix> getMatrixElements() {
        Elements elements = this.getChildElements("matrix", CMLConstants.CML_NS);
        return new CMLElements<CMLMatrix>(elements);
    }
// element:   expression

    /** A flag on 'arg' to indicate that the value can be calculated.
    * This is still experimental.  if eval="_ijk_+3" and
    *                 the value of the ijk was 2, this would change the value of the arg to 5. 
    *                 Only + and - are currently allowed
    * @param expression child to add
    */
    public void addExpression(AbstractExpression expression) {
        expression.detach();
        this.appendChild(expression);
    }
    /** A flag on 'arg' to indicate that the value can be calculated.
    * This is still experimental.  if eval="_ijk_+3" and
    *                 the value of the ijk was 2, this would change the value of the arg to 5. 
    *                 Only + and - are currently allowed
    * @return CMLElements<CMLExpression>
    */
    public CMLElements<CMLExpression> getExpressionElements() {
        Elements elements = this.getChildElements("expression", CMLConstants.CML_NS);
        return new CMLElements<CMLExpression>(elements);
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
        } else if (name.equals("name")) {
            setName(value);
        } else if (name.equals("dataType")) {
            setDataType(value);
        } else if (name.equals("substitute")) {
            setSubstitute(value);
        } else if (name.equals("parameterName")) {
            setParameterName(value);
        } else if (name.equals("parentAttribute")) {
            setParentAttribute(value);
        } else if (name.equals("delete")) {
            setDelete(value);
        } else if (name.equals("eval")) {
            setEval(value);
	     } else {
            super.addAttribute(att);
        }
    }
}
