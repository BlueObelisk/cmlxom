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
public abstract class AbstractAtomicBasisFunction extends CMLElement {
    /** local name*/
    public final static String TAG = "atomicBasisFunction";
    /** constructor. */    public AbstractAtomicBasisFunction() {
        super("atomicBasisFunction");
    }
/** copy constructor.
* deep copy using XOM copy()
* @param old element to copy
*/
    public AbstractAtomicBasisFunction(AbstractAtomicBasisFunction old) {
        super((CMLElement) old);
    }
// attribute:   atomRef

    /** cache */
    StringSTAttribute _att_atomref = null;
    /** A reference to an atom.
    * Used by bond, electron, etc.
    * @return CMLAttribute
    */
    public CMLAttribute getAtomRefAttribute() {
        return (CMLAttribute) getAttribute("atomRef");
    }
    /** A reference to an atom.
    * Used by bond, electron, etc.
    * @return String
    */
    public String getAtomRef() {
        StringSTAttribute att = (StringSTAttribute) this.getAtomRefAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** A reference to an atom.
    * Used by bond, electron, etc.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setAtomRef(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_atomref == null) {
            _att_atomref = (StringSTAttribute) attributeFactory.getAttribute("atomRef", "atomicBasisFunction");
            if (_att_atomref == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : atomRef probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_atomref);
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
            _att_title = (StringSTAttribute) attributeFactory.getAttribute("title", "atomicBasisFunction");
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
            _att_id = (IdAttribute) attributeFactory.getAttribute("id", "atomicBasisFunction");
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
            _att_convention = (StringSTAttribute) attributeFactory.getAttribute("convention", "atomicBasisFunction");
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
            _att_dictref = (DictRefAttribute) attributeFactory.getAttribute("dictRef", "atomicBasisFunction");
            if (_att_dictref == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : dictRef probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new DictRefAttribute(_att_dictref);
        super.addRemove(att, value);
    }
// attribute:   n

    /** cache */
    IntSTAttribute _att_n = null;
    /** The principal quantum number.
    * Takes values 1, 2, 3, etc.
    * @return CMLAttribute
    */
    public CMLAttribute getNAttribute() {
        return (CMLAttribute) getAttribute("n");
    }
    /** The principal quantum number.
    * Takes values 1, 2, 3, etc.
    * @return int
    */
    public int getN() {
        IntSTAttribute att = (IntSTAttribute) this.getNAttribute();
        if (att == null) {
            throw new RuntimeException("int attribute is unset: n");
        }
        return att.getInt();
    }
    /** The principal quantum number.
    * Takes values 1, 2, 3, etc.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setN(String value) throws RuntimeException {
        IntSTAttribute att = null;
        if (_att_n == null) {
            _att_n = (IntSTAttribute) attributeFactory.getAttribute("n", "atomicBasisFunction");
            if (_att_n == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : n probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new IntSTAttribute(_att_n);
        super.addRemove(att, value);
    }
    /** The principal quantum number.
    * Takes values 1, 2, 3, etc.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setN(int value) throws RuntimeException {
        if (_att_n == null) {
            _att_n = (IntSTAttribute) attributeFactory.getAttribute("n", "atomicBasisFunction");
           if (_att_n == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : n probably incompatible attributeGroupName and attributeName ");
            }
        }
        IntSTAttribute att = new IntSTAttribute(_att_n);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// attribute:   l

    /** cache */
    IntSTAttribute _att_l = null;
    /** The secondary quantum number.
    * takes values 0, 1, etc.
    * @return CMLAttribute
    */
    public CMLAttribute getLAttribute() {
        return (CMLAttribute) getAttribute("l");
    }
    /** The secondary quantum number.
    * takes values 0, 1, etc.
    * @return int
    */
    public int getL() {
        IntSTAttribute att = (IntSTAttribute) this.getLAttribute();
        if (att == null) {
            throw new RuntimeException("int attribute is unset: l");
        }
        return att.getInt();
    }
    /** The secondary quantum number.
    * takes values 0, 1, etc.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setL(String value) throws RuntimeException {
        IntSTAttribute att = null;
        if (_att_l == null) {
            _att_l = (IntSTAttribute) attributeFactory.getAttribute("l", "atomicBasisFunction");
            if (_att_l == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : l probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new IntSTAttribute(_att_l);
        super.addRemove(att, value);
    }
    /** The secondary quantum number.
    * takes values 0, 1, etc.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setL(int value) throws RuntimeException {
        if (_att_l == null) {
            _att_l = (IntSTAttribute) attributeFactory.getAttribute("l", "atomicBasisFunction");
           if (_att_l == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : l probably incompatible attributeGroupName and attributeName ");
            }
        }
        IntSTAttribute att = new IntSTAttribute(_att_l);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// attribute:   m

    /** cache */
    IntSTAttribute _att_m = null;
    /** The azimuthal quantum number.
    * takes values -1, 0, 1, etc.
    * @return CMLAttribute
    */
    public CMLAttribute getMAttribute() {
        return (CMLAttribute) getAttribute("m");
    }
    /** The azimuthal quantum number.
    * takes values -1, 0, 1, etc.
    * @return int
    */
    public int getM() {
        IntSTAttribute att = (IntSTAttribute) this.getMAttribute();
        if (att == null) {
            throw new RuntimeException("int attribute is unset: m");
        }
        return att.getInt();
    }
    /** The azimuthal quantum number.
    * takes values -1, 0, 1, etc.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setM(String value) throws RuntimeException {
        IntSTAttribute att = null;
        if (_att_m == null) {
            _att_m = (IntSTAttribute) attributeFactory.getAttribute("m", "atomicBasisFunction");
            if (_att_m == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : m probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new IntSTAttribute(_att_m);
        super.addRemove(att, value);
    }
    /** The azimuthal quantum number.
    * takes values -1, 0, 1, etc.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setM(int value) throws RuntimeException {
        if (_att_m == null) {
            _att_m = (IntSTAttribute) attributeFactory.getAttribute("m", "atomicBasisFunction");
           if (_att_m == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : m probably incompatible attributeGroupName and attributeName ");
            }
        }
        IntSTAttribute att = new IntSTAttribute(_att_m);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// attribute:   symbol

    /** cache */
    StringSTAttribute _att_symbol = null;
    /** A symbol.
    * No semantics. However it should contain only 
    *                 ASCII characters and we may have to develop an escaping mechanism.
    *                 Used on _atomicBasisFunction_, _unit_, etc.
    * @return CMLAttribute
    */
    public CMLAttribute getSymbolAttribute() {
        return (CMLAttribute) getAttribute("symbol");
    }
    /** A symbol.
    * No semantics. However it should contain only 
    *                 ASCII characters and we may have to develop an escaping mechanism.
    *                 Used on _atomicBasisFunction_, _unit_, etc.
    * @return String
    */
    public String getSymbol() {
        StringSTAttribute att = (StringSTAttribute) this.getSymbolAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** A symbol.
    * No semantics. However it should contain only 
    *                 ASCII characters and we may have to develop an escaping mechanism.
    *                 Used on _atomicBasisFunction_, _unit_, etc.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setSymbol(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_symbol == null) {
            _att_symbol = (StringSTAttribute) attributeFactory.getAttribute("symbol", "atomicBasisFunction");
            if (_att_symbol == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : symbol probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_symbol);
        super.addRemove(att, value);
    }
// attribute:   lm

    /** cache */
    StringSTAttribute _att_lm = null;
    /** symbolic represention of l amd m.
    * takes avlues of s, p, px, dxy, dx2y2, f, etc.
    * @return CMLAttribute
    */
    public CMLAttribute getLmAttribute() {
        return (CMLAttribute) getAttribute("lm");
    }
    /** symbolic represention of l amd m.
    * takes avlues of s, p, px, dxy, dx2y2, f, etc.
    * @return String
    */
    public String getLm() {
        StringSTAttribute att = (StringSTAttribute) this.getLmAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** symbolic represention of l amd m.
    * takes avlues of s, p, px, dxy, dx2y2, f, etc.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setLm(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_lm == null) {
            _att_lm = (StringSTAttribute) attributeFactory.getAttribute("lm", "atomicBasisFunction");
            if (_att_lm == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : lm probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_lm);
        super.addRemove(att, value);
    }
// element:   gradient

    /** symbolic represention of l amd m.
    * takes avlues of s, p, px, dxy, dx2y2, f, etc.
    * @param gradient child to add
    */
    public void addGradient(AbstractGradient gradient) {
        gradient.detach();
        this.appendChild(gradient);
    }
    /** symbolic represention of l amd m.
    * takes avlues of s, p, px, dxy, dx2y2, f, etc.
    * @return CMLElements&lt;CMLGradient&gt;
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
        } else if (name.equals("atomRef")) {
            setAtomRef(value);
        } else if (name.equals("title")) {
            setTitle(value);
        } else if (name.equals("id")) {
            setId(value);
        } else if (name.equals("convention")) {
            setConvention(value);
        } else if (name.equals("dictRef")) {
            setDictRef(value);
        } else if (name.equals("n")) {
            setN(value);
        } else if (name.equals("l")) {
            setL(value);
        } else if (name.equals("m")) {
            setM(value);
        } else if (name.equals("symbol")) {
            setSymbol(value);
        } else if (name.equals("lm")) {
            setLm(value);
	     } else {
            super.addAttribute(att);
        }
    }
}
