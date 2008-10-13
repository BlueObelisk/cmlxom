package org.xmlcml.cml.element.main;


import nu.xom.Attribute;
import nu.xom.Elements;

import org.xmlcml.cml.attribute.DictRefAttribute;
import org.xmlcml.cml.attribute.IdAttribute;
import org.xmlcml.cml.attribute.RefAttribute;
import org.xmlcml.cml.base.CMLAttribute;
import org.xmlcml.cml.base.CMLElement;
import org.xmlcml.cml.base.CMLElements;
import org.xmlcml.cml.base.StringSTAttribute;
import org.xmlcml.cml.element.lite.AbstractLabel;
import org.xmlcml.cml.element.lite.AbstractName;
import org.xmlcml.cml.element.lite.CMLLabel;
import org.xmlcml.cml.element.lite.CMLName;

// end of part 1
/** CLASS DOCUMENTATION */
public abstract class AbstractReactionScheme extends CMLElement {
    /** local name*/
    public final static String TAG = "reactionScheme";
    /** constructor. */    public AbstractReactionScheme() {
        super("reactionScheme");
    }
/** copy constructor.
* deep copy using XOM copy()
* @param old element to copy
*/
    public AbstractReactionScheme(AbstractReactionScheme old) {
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
            _att_dictref = (DictRefAttribute) attributeFactory.getAttribute("dictRef", "reactionScheme");
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
            _att_convention = (StringSTAttribute) attributeFactory.getAttribute("convention", "reactionScheme");
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
            _att_title = (StringSTAttribute) attributeFactory.getAttribute("title", "reactionScheme");
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
            _att_id = (IdAttribute) attributeFactory.getAttribute("id", "reactionScheme");
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
            _att_ref = (RefAttribute) attributeFactory.getAttribute("ref", "reactionScheme");
            if (_att_ref == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : ref probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new RefAttribute(_att_ref);
        super.addRemove(att, value);
    }
// attribute:   role

    /** cache */
    StringSTAttribute _att_role = null;
    /** Role of the reaction.
    * No description
    * @return CMLAttribute
    */
    public CMLAttribute getRoleAttribute() {
        return (CMLAttribute) getAttribute("role");
    }
    /** Role of the reaction.
    * No description
    * @return String
    */
    public String getRole() {
        StringSTAttribute att = (StringSTAttribute) this.getRoleAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** Role of the reaction.
    * No description
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setRole(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_role == null) {
            _att_role = (StringSTAttribute) attributeFactory.getAttribute("role", "reactionScheme");
            if (_att_role == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : role probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_role);
        super.addRemove(att, value);
    }
// attribute:   type

    /** cache */
    StringSTAttribute _att_type = null;
    /** Type of the reaction.
    * No description
    * @return CMLAttribute
    */
    public CMLAttribute getTypeAttribute() {
        return (CMLAttribute) getAttribute("type");
    }
    /** Type of the reaction.
    * No description
    * @return String
    */
    public String getType() {
        StringSTAttribute att = (StringSTAttribute) this.getTypeAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** Type of the reaction.
    * No description
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setType(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_type == null) {
            _att_type = (StringSTAttribute) attributeFactory.getAttribute("type", "reactionScheme");
            if (_att_type == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : type probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_type);
        super.addRemove(att, value);
    }
// attribute:   state

    /** cache */
    StringSTAttribute _att_state = null;
    /** The physical state of the substance.
    * No fixed semantics or default.
    * @return CMLAttribute
    */
    public CMLAttribute getStateAttribute() {
        return (CMLAttribute) getAttribute("state");
    }
    /** The physical state of the substance.
    * No fixed semantics or default.
    * @return String
    */
    public String getState() {
        StringSTAttribute att = (StringSTAttribute) this.getStateAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** The physical state of the substance.
    * No fixed semantics or default.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setState(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_state == null) {
            _att_state = (StringSTAttribute) attributeFactory.getAttribute("state", "reactionScheme");
            if (_att_state == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : state probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_state);
        super.addRemove(att, value);
    }
// attribute:   format

    /** cache */
    StringSTAttribute _att_format = null;
    /** Format of the reaction component.
    * Indicates how the components of reactionScheme, reactionStepList, etc. should be processed. No controlled vocabulary. One example is format="cmlSnap" asserts that the processor can assume that the reactants and products can be rendered using the CMLSnap design. Note that the reaction can be interpreted without reference to the format, which is primarily a processing instruction.
    * @return CMLAttribute
    */
    public CMLAttribute getFormatAttribute() {
        return (CMLAttribute) getAttribute("format");
    }
    /** Format of the reaction component.
    * Indicates how the components of reactionScheme, reactionStepList, etc. should be processed. No controlled vocabulary. One example is format="cmlSnap" asserts that the processor can assume that the reactants and products can be rendered using the CMLSnap design. Note that the reaction can be interpreted without reference to the format, which is primarily a processing instruction.
    * @return String
    */
    public String getFormat() {
        StringSTAttribute att = (StringSTAttribute) this.getFormatAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** Format of the reaction component.
    * Indicates how the components of reactionScheme, reactionStepList, etc. should be processed. No controlled vocabulary. One example is format="cmlSnap" asserts that the processor can assume that the reactants and products can be rendered using the CMLSnap design. Note that the reaction can be interpreted without reference to the format, which is primarily a processing instruction.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setFormat(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_format == null) {
            _att_format = (StringSTAttribute) attributeFactory.getAttribute("format", "reactionScheme");
            if (_att_format == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : format probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_format);
        super.addRemove(att, value);
    }
// element:   metadataList

    /** Format of the reaction component.
    * Indicates how the components of reactionScheme, reactionStepList, etc. should be processed. No controlled vocabulary. One example is format="cmlSnap" asserts that the processor can assume that the reactants and products can be rendered using the CMLSnap design. Note that the reaction can be interpreted without reference to the format, which is primarily a processing instruction.
    * @param metadataList child to add
    */
    public void addMetadataList(AbstractMetadataList metadataList) {
        metadataList.detach();
        this.appendChild(metadataList);
    }
    /** Format of the reaction component.
    * Indicates how the components of reactionScheme, reactionStepList, etc. should be processed. No controlled vocabulary. One example is format="cmlSnap" asserts that the processor can assume that the reactants and products can be rendered using the CMLSnap design. Note that the reaction can be interpreted without reference to the format, which is primarily a processing instruction.
    * @return CMLElements<CMLMetadataList>
    */
    public CMLElements<CMLMetadataList> getMetadataListElements() {
        Elements elements = this.getChildElements("metadataList", CML_NS);
        return new CMLElements<CMLMetadataList>(elements);
    }
// element:   label

    /** Format of the reaction component.
    * Indicates how the components of reactionScheme, reactionStepList, etc. should be processed. No controlled vocabulary. One example is format="cmlSnap" asserts that the processor can assume that the reactants and products can be rendered using the CMLSnap design. Note that the reaction can be interpreted without reference to the format, which is primarily a processing instruction.
    * @param label child to add
    */
    public void addLabel(AbstractLabel label) {
        label.detach();
        this.appendChild(label);
    }
    /** Format of the reaction component.
    * Indicates how the components of reactionScheme, reactionStepList, etc. should be processed. No controlled vocabulary. One example is format="cmlSnap" asserts that the processor can assume that the reactants and products can be rendered using the CMLSnap design. Note that the reaction can be interpreted without reference to the format, which is primarily a processing instruction.
    * @return CMLElements<CMLLabel>
    */
    public CMLElements<CMLLabel> getLabelElements() {
        Elements elements = this.getChildElements("label", CML_NS);
        return new CMLElements<CMLLabel>(elements);
    }
// element:   name

    /** Format of the reaction component.
    * Indicates how the components of reactionScheme, reactionStepList, etc. should be processed. No controlled vocabulary. One example is format="cmlSnap" asserts that the processor can assume that the reactants and products can be rendered using the CMLSnap design. Note that the reaction can be interpreted without reference to the format, which is primarily a processing instruction.
    * @param name child to add
    */
    public void addName(AbstractName name) {
        name.detach();
        this.appendChild(name);
    }
    /** Format of the reaction component.
    * Indicates how the components of reactionScheme, reactionStepList, etc. should be processed. No controlled vocabulary. One example is format="cmlSnap" asserts that the processor can assume that the reactants and products can be rendered using the CMLSnap design. Note that the reaction can be interpreted without reference to the format, which is primarily a processing instruction.
    * @return CMLElements<CMLName>
    */
    public CMLElements<CMLName> getNameElements() {
        Elements elements = this.getChildElements("name", CML_NS);
        return new CMLElements<CMLName>(elements);
    }
// element:   identifier

    /** Format of the reaction component.
    * Indicates how the components of reactionScheme, reactionStepList, etc. should be processed. No controlled vocabulary. One example is format="cmlSnap" asserts that the processor can assume that the reactants and products can be rendered using the CMLSnap design. Note that the reaction can be interpreted without reference to the format, which is primarily a processing instruction.
    * @param identifier child to add
    */
    public void addIdentifier(AbstractIdentifier identifier) {
        identifier.detach();
        this.appendChild(identifier);
    }
    /** Format of the reaction component.
    * Indicates how the components of reactionScheme, reactionStepList, etc. should be processed. No controlled vocabulary. One example is format="cmlSnap" asserts that the processor can assume that the reactants and products can be rendered using the CMLSnap design. Note that the reaction can be interpreted without reference to the format, which is primarily a processing instruction.
    * @return CMLElements<CMLIdentifier>
    */
    public CMLElements<CMLIdentifier> getIdentifierElements() {
        Elements elements = this.getChildElements("identifier", CML_NS);
        return new CMLElements<CMLIdentifier>(elements);
    }
// element:   reaction

    /** Format of the reaction component.
    * Indicates how the components of reactionScheme, reactionStepList, etc. should be processed. No controlled vocabulary. One example is format="cmlSnap" asserts that the processor can assume that the reactants and products can be rendered using the CMLSnap design. Note that the reaction can be interpreted without reference to the format, which is primarily a processing instruction.
    * @param reaction child to add
    */
    public void addReaction(AbstractReaction reaction) {
        reaction.detach();
        this.appendChild(reaction);
    }
    /** Format of the reaction component.
    * Indicates how the components of reactionScheme, reactionStepList, etc. should be processed. No controlled vocabulary. One example is format="cmlSnap" asserts that the processor can assume that the reactants and products can be rendered using the CMLSnap design. Note that the reaction can be interpreted without reference to the format, which is primarily a processing instruction.
    * @return CMLElements<CMLReaction>
    */
    public CMLElements<CMLReaction> getReactionElements() {
        Elements elements = this.getChildElements("reaction", CML_NS);
        return new CMLElements<CMLReaction>(elements);
    }
// element:   reactionStepList

    /** Format of the reaction component.
    * Indicates how the components of reactionScheme, reactionStepList, etc. should be processed. No controlled vocabulary. One example is format="cmlSnap" asserts that the processor can assume that the reactants and products can be rendered using the CMLSnap design. Note that the reaction can be interpreted without reference to the format, which is primarily a processing instruction.
    * @param reactionStepList child to add
    */
    public void addReactionStepList(AbstractReactionStepList reactionStepList) {
        reactionStepList.detach();
        this.appendChild(reactionStepList);
    }
    /** Format of the reaction component.
    * Indicates how the components of reactionScheme, reactionStepList, etc. should be processed. No controlled vocabulary. One example is format="cmlSnap" asserts that the processor can assume that the reactants and products can be rendered using the CMLSnap design. Note that the reaction can be interpreted without reference to the format, which is primarily a processing instruction.
    * @return CMLElements<CMLReactionStepList>
    */
    public CMLElements<CMLReactionStepList> getReactionStepListElements() {
        Elements elements = this.getChildElements("reactionStepList", CML_NS);
        return new CMLElements<CMLReactionStepList>(elements);
    }
// element:   reactionScheme

    /** Format of the reaction component.
    * Indicates how the components of reactionScheme, reactionStepList, etc. should be processed. No controlled vocabulary. One example is format="cmlSnap" asserts that the processor can assume that the reactants and products can be rendered using the CMLSnap design. Note that the reaction can be interpreted without reference to the format, which is primarily a processing instruction.
    * @param reactionScheme child to add
    */
    public void addReactionScheme(AbstractReactionScheme reactionScheme) {
        reactionScheme.detach();
        this.appendChild(reactionScheme);
    }
    /** Format of the reaction component.
    * Indicates how the components of reactionScheme, reactionStepList, etc. should be processed. No controlled vocabulary. One example is format="cmlSnap" asserts that the processor can assume that the reactants and products can be rendered using the CMLSnap design. Note that the reaction can be interpreted without reference to the format, which is primarily a processing instruction.
    * @return CMLElements<CMLReactionScheme>
    */
    public CMLElements<CMLReactionScheme> getReactionSchemeElements() {
        Elements elements = this.getChildElements("reactionScheme", CML_NS);
        return new CMLElements<CMLReactionScheme>(elements);
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
        } else if (name.equals("role")) {
            setRole(value);
        } else if (name.equals("type")) {
            setType(value);
        } else if (name.equals("state")) {
            setState(value);
        } else if (name.equals("format")) {
            setFormat(value);
	     } else {
            super.addAttribute(att);
        }
    }
}
