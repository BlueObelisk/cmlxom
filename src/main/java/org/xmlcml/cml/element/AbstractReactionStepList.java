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
public abstract class AbstractReactionStepList extends CMLElement {
    /** local name*/
    public final static String TAG = "reactionStepList";
    /** constructor. */    public AbstractReactionStepList() {
        super("reactionStepList");
    }
/** copy constructor.
* deep copy using XOM copy()
* @param old element to copy
*/
    public AbstractReactionStepList(AbstractReactionStepList old) {
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
            _att_dictref = (DictRefAttribute) attributeFactory.getAttribute("dictRef", "reactionStepList");
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
            _att_convention = (StringSTAttribute) attributeFactory.getAttribute("convention", "reactionStepList");
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
            _att_title = (StringSTAttribute) attributeFactory.getAttribute("title", "reactionStepList");
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
            _att_id = (IdAttribute) attributeFactory.getAttribute("id", "reactionStepList");
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
            _att_ref = (RefAttribute) attributeFactory.getAttribute("ref", "reactionStepList");
            if (_att_ref == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : ref probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new RefAttribute(_att_ref);
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
            _att_type = (StringSTAttribute) attributeFactory.getAttribute("type", "reactionStepList");
            if (_att_type == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : type probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_type);
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
            _att_format = (StringSTAttribute) attributeFactory.getAttribute("format", "reactionStepList");
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
        Elements elements = this.getChildElements("metadataList", CMLConstants.CML_NS);
        return new CMLElements<CMLMetadataList>(elements);
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
        Elements elements = this.getChildElements("name", CMLConstants.CML_NS);
        return new CMLElements<CMLName>(elements);
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
        Elements elements = this.getChildElements("label", CMLConstants.CML_NS);
        return new CMLElements<CMLLabel>(elements);
    }
// element:   reactionStep

    /** Format of the reaction component.
    * Indicates how the components of reactionScheme, reactionStepList, etc. should be processed. No controlled vocabulary. One example is format="cmlSnap" asserts that the processor can assume that the reactants and products can be rendered using the CMLSnap design. Note that the reaction can be interpreted without reference to the format, which is primarily a processing instruction.
    * @param reactionStep child to add
    */
    public void addReactionStep(AbstractReactionStep reactionStep) {
        reactionStep.detach();
        this.appendChild(reactionStep);
    }
    /** Format of the reaction component.
    * Indicates how the components of reactionScheme, reactionStepList, etc. should be processed. No controlled vocabulary. One example is format="cmlSnap" asserts that the processor can assume that the reactants and products can be rendered using the CMLSnap design. Note that the reaction can be interpreted without reference to the format, which is primarily a processing instruction.
    * @return CMLElements<CMLReactionStep>
    */
    public CMLElements<CMLReactionStep> getReactionStepElements() {
        Elements elements = this.getChildElements("reactionStep", CMLConstants.CML_NS);
        return new CMLElements<CMLReactionStep>(elements);
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
        } else if (name.equals("type")) {
            setType(value);
        } else if (name.equals("format")) {
            setFormat(value);
	     } else {
            super.addAttribute(att);
        }
    }
}
