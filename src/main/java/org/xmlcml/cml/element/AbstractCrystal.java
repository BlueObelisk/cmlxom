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
import org.xmlcml.cml.base.CMLAttribute;
import org.xmlcml.cml.base.CMLConstants;
import org.xmlcml.cml.base.CMLElement;
import org.xmlcml.cml.base.CMLElements;
import org.xmlcml.cml.base.IntSTAttribute;
import org.xmlcml.cml.base.StringSTAttribute;

// end of part 1
/** CLASS DOCUMENTATION */
public abstract class AbstractCrystal extends CMLElement {
    /** local name*/
    public final static String TAG = "crystal";
    /** constructor. */    public AbstractCrystal() {
        super("crystal");
    }
/** copy constructor.
* deep copy using XOM copy()
* @param old element to copy
*/
    public AbstractCrystal(AbstractCrystal old) {
        super((CMLElement) old);
    }
// attribute:   z

    /** cache */
    IntSTAttribute _att_z = null;
    /** The number of molecules per cell.
    * Molecules are defined as the _molecule_ which directly contains the _crystal_ element.
    * @return CMLAttribute
    */
    public CMLAttribute getZAttribute() {
        return (CMLAttribute) getAttribute("z");
    }
    /** The number of molecules per cell.
    * Molecules are defined as the _molecule_ which directly contains the _crystal_ element.
    * @return int
    */
    public int getZ() {
        IntSTAttribute att = (IntSTAttribute) this.getZAttribute();
        if (att == null) {
            throw new RuntimeException("int attribute is unset: z");
        }
        return att.getInt();
    }
    /** The number of molecules per cell.
    * Molecules are defined as the _molecule_ which directly contains the _crystal_ element.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setZ(String value) throws RuntimeException {
        IntSTAttribute att = null;
        if (_att_z == null) {
            _att_z = (IntSTAttribute) attributeFactory.getAttribute("z", "crystal");
            if (_att_z == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : z probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new IntSTAttribute(_att_z);
        super.addRemove(att, value);
    }
    /** The number of molecules per cell.
    * Molecules are defined as the _molecule_ which directly contains the _crystal_ element.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setZ(int value) throws RuntimeException {
        if (_att_z == null) {
            _att_z = (IntSTAttribute) attributeFactory.getAttribute("z", "crystal");
           if (_att_z == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : z probably incompatible attributeGroupName and attributeName ");
            }
        }
        IntSTAttribute att = new IntSTAttribute(_att_z);
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
            _att_title = (StringSTAttribute) attributeFactory.getAttribute("title", "crystal");
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
            _att_id = (IdAttribute) attributeFactory.getAttribute("id", "crystal");
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
            _att_convention = (StringSTAttribute) attributeFactory.getAttribute("convention", "crystal");
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
            _att_dictref = (DictRefAttribute) attributeFactory.getAttribute("dictRef", "crystal");
            if (_att_dictref == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : dictRef probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new DictRefAttribute(_att_dictref);
        super.addRemove(att, value);
    }
// element:   scalar

    /** null
    * @param scalar child to add
    */
    public void addScalar(AbstractScalar scalar) {
        scalar.detach();
        this.appendChild(scalar);
    }
    /** null
    * @return CMLElements&lt;CMLScalar&gt;
    */
    public CMLElements<CMLScalar> getScalarElements() {
        Elements elements = this.getChildElements("scalar", CMLConstants.CML_NS);
        return new CMLElements<CMLScalar>(elements);
    }
// element:   cellParameter

    /** null
    * @param cellParameter child to add
    */
    public void addCellParameter(AbstractCellParameter cellParameter) {
        cellParameter.detach();
        this.appendChild(cellParameter);
    }
    /** null
    * @return CMLElements&lt;CMLCellParameter&gt;
    */
    public CMLElements<CMLCellParameter> getCellParameterElements() {
        Elements elements = this.getChildElements("cellParameter", CMLConstants.CML_NS);
        return new CMLElements<CMLCellParameter>(elements);
    }
// element:   symmetry

    /** null
    * @param symmetry child to add
    */
    public void addSymmetry(AbstractSymmetry symmetry) {
        symmetry.detach();
        this.appendChild(symmetry);
    }
    /** null
    * @return CMLElements&lt;CMLSymmetry&gt;
    */
    public CMLElements<CMLSymmetry> getSymmetryElements() {
        Elements elements = this.getChildElements("symmetry", CMLConstants.CML_NS);
        return new CMLElements<CMLSymmetry>(elements);
    }
    /** overrides addAttribute(Attribute)
     * reroutes calls to setFoo()
     * @param att  attribute
    */
    public void addAttribute(Attribute att) {
        String name = att.getLocalName();
        String value = att.getValue();
        if (name == null) {
        } else if (name.equals("z")) {
            setZ(value);
        } else if (name.equals("title")) {
            setTitle(value);
        } else if (name.equals("id")) {
            setId(value);
        } else if (name.equals("convention")) {
            setConvention(value);
        } else if (name.equals("dictRef")) {
            setDictRef(value);
	     } else {
            super.addAttribute(att);
        }
    }
}
