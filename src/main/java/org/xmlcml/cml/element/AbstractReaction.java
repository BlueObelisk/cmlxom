package org.xmlcml.cml.element;


import nu.xom.Attribute;
import nu.xom.Elements;

import org.xmlcml.cml.attribute.DictRefAttribute;
import org.xmlcml.cml.attribute.IdAttribute;
import org.xmlcml.cml.attribute.RefAttribute;
import org.xmlcml.cml.base.CMLAttribute;
import org.xmlcml.cml.base.CMLElement;
import org.xmlcml.cml.base.CMLElements;
import org.xmlcml.cml.base.DoubleSTAttribute;
import org.xmlcml.cml.base.StringSTAttribute;

// end of part 1
/** CLASS DOCUMENTATION */
public abstract class AbstractReaction extends CMLElement {
    /** local name*/
    public final static String TAG = "reaction";
    /** constructor. */    public AbstractReaction() {
        super("reaction");
    }
/** copy constructor.
* deep copy using XOM copy()
* @param old element to copy
*/
    public AbstractReaction(AbstractReaction old) {
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
            _att_dictref = (DictRefAttribute) attributeFactory.getAttribute("dictRef", "reaction");
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
            _att_convention = (StringSTAttribute) attributeFactory.getAttribute("convention", "reaction");
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
            _att_title = (StringSTAttribute) attributeFactory.getAttribute("title", "reaction");
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
            _att_id = (IdAttribute) attributeFactory.getAttribute("id", "reaction");
            if (_att_id == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : id probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new IdAttribute(_att_id);
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
            _att_format = (StringSTAttribute) attributeFactory.getAttribute("format", "reaction");
            if (_att_format == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : format probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_format);
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
            _att_ref = (RefAttribute) attributeFactory.getAttribute("ref", "reaction");
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
            _att_role = (StringSTAttribute) attributeFactory.getAttribute("role", "reaction");
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
            _att_type = (StringSTAttribute) attributeFactory.getAttribute("type", "reaction");
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
            _att_state = (StringSTAttribute) attributeFactory.getAttribute("state", "reaction");
            if (_att_state == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : state probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_state);
        super.addRemove(att, value);
    }
// attribute:   atomMap

    /** cache */
    StringSTAttribute _att_atommap = null;
    /** A reference to a map providing mappings between atoms.
    * The map will normally be contained within the same document and referenced by its ID. It will contain a list of links with from and to attributes linking atoms. The topology of the linking is defined by the application - it could be overlay of molecular fragments, reactant/product mapping, etc. The reserved phrase "USE_IDS" assume that the sets of atoms are of equal size and have 1:1 mapping between each id. This is another way of saying that the atoms mapped by a given ID are "the same atom". 
    * @return CMLAttribute
    */
    public CMLAttribute getAtomMapAttribute() {
        return (CMLAttribute) getAttribute("atomMap");
    }
    /** A reference to a map providing mappings between atoms.
    * The map will normally be contained within the same document and referenced by its ID. It will contain a list of links with from and to attributes linking atoms. The topology of the linking is defined by the application - it could be overlay of molecular fragments, reactant/product mapping, etc. The reserved phrase "USE_IDS" assume that the sets of atoms are of equal size and have 1:1 mapping between each id. This is another way of saying that the atoms mapped by a given ID are "the same atom". 
    * @return String
    */
    public String getAtomMap() {
        StringSTAttribute att = (StringSTAttribute) this.getAtomMapAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** A reference to a map providing mappings between atoms.
    * The map will normally be contained within the same document and referenced by its ID. It will contain a list of links with from and to attributes linking atoms. The topology of the linking is defined by the application - it could be overlay of molecular fragments, reactant/product mapping, etc. The reserved phrase "USE_IDS" assume that the sets of atoms are of equal size and have 1:1 mapping between each id. This is another way of saying that the atoms mapped by a given ID are "the same atom". 
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setAtomMap(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_atommap == null) {
            _att_atommap = (StringSTAttribute) attributeFactory.getAttribute("atomMap", "reaction");
            if (_att_atommap == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : atomMap probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_atommap);
        super.addRemove(att, value);
    }
// attribute:   electronMap

    /** cache */
    StringSTAttribute _att_electronmap = null;
    /** A reference to a map providing mappings between electrons.
    * The map will normally be contained within the same document and referenced by its ID. It will contain a list of links with from and to attributes linking electrons. The topology of the linking is defined by the application - it could be reactant/product mapping, etc. The reserved phrase "USE_IDS" assume that the sets of electrons are of equal size and have 1:1 mapping between each id. This is another way of saying that the electrons mapped by a given ID are "the same electron". 
    * @return CMLAttribute
    */
    public CMLAttribute getElectronMapAttribute() {
        return (CMLAttribute) getAttribute("electronMap");
    }
    /** A reference to a map providing mappings between electrons.
    * The map will normally be contained within the same document and referenced by its ID. It will contain a list of links with from and to attributes linking electrons. The topology of the linking is defined by the application - it could be reactant/product mapping, etc. The reserved phrase "USE_IDS" assume that the sets of electrons are of equal size and have 1:1 mapping between each id. This is another way of saying that the electrons mapped by a given ID are "the same electron". 
    * @return String
    */
    public String getElectronMap() {
        StringSTAttribute att = (StringSTAttribute) this.getElectronMapAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** A reference to a map providing mappings between electrons.
    * The map will normally be contained within the same document and referenced by its ID. It will contain a list of links with from and to attributes linking electrons. The topology of the linking is defined by the application - it could be reactant/product mapping, etc. The reserved phrase "USE_IDS" assume that the sets of electrons are of equal size and have 1:1 mapping between each id. This is another way of saying that the electrons mapped by a given ID are "the same electron". 
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setElectronMap(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_electronmap == null) {
            _att_electronmap = (StringSTAttribute) attributeFactory.getAttribute("electronMap", "reaction");
            if (_att_electronmap == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : electronMap probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_electronmap);
        super.addRemove(att, value);
    }
// attribute:   bondMap

    /** cache */
    StringSTAttribute _att_bondmap = null;
    /** A reference to a map providing mappings between bonds.
    * The map will normally be contained within the same document and referenced by its ID. It will contain a list of links with from and to attributes linking bonds. The topology of the linking is defined by the application - it could be overlay of molecular fragments, reactant/product mapping, etc. The reserved phrase "USE_IDS" assume that the sets of bonds are of equal size and have 1:1 mapping between each id. This is another way of saying that the bonds mapped by a given ID are "the same bond". 
    * @return CMLAttribute
    */
    public CMLAttribute getBondMapAttribute() {
        return (CMLAttribute) getAttribute("bondMap");
    }
    /** A reference to a map providing mappings between bonds.
    * The map will normally be contained within the same document and referenced by its ID. It will contain a list of links with from and to attributes linking bonds. The topology of the linking is defined by the application - it could be overlay of molecular fragments, reactant/product mapping, etc. The reserved phrase "USE_IDS" assume that the sets of bonds are of equal size and have 1:1 mapping between each id. This is another way of saying that the bonds mapped by a given ID are "the same bond". 
    * @return String
    */
    public String getBondMap() {
        StringSTAttribute att = (StringSTAttribute) this.getBondMapAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** A reference to a map providing mappings between bonds.
    * The map will normally be contained within the same document and referenced by its ID. It will contain a list of links with from and to attributes linking bonds. The topology of the linking is defined by the application - it could be overlay of molecular fragments, reactant/product mapping, etc. The reserved phrase "USE_IDS" assume that the sets of bonds are of equal size and have 1:1 mapping between each id. This is another way of saying that the bonds mapped by a given ID are "the same bond". 
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setBondMap(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_bondmap == null) {
            _att_bondmap = (StringSTAttribute) attributeFactory.getAttribute("bondMap", "reaction");
            if (_att_bondmap == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : bondMap probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_bondmap);
        super.addRemove(att, value);
    }
// attribute:   yield

    /** cache */
    DoubleSTAttribute _att_yield = null;
    /** Yield of a reaction or reactionStep.
    * Yields can be given on either element. They should lie in the range 0 to 1 inclusive (i.e. percentages will need to be converted). Software may use yield to calculate amounts of substances created during a reaction or series of reactions.
    * @return CMLAttribute
    */
    public CMLAttribute getYieldAttribute() {
        return (CMLAttribute) getAttribute("yield");
    }
    /** Yield of a reaction or reactionStep.
    * Yields can be given on either element. They should lie in the range 0 to 1 inclusive (i.e. percentages will need to be converted). Software may use yield to calculate amounts of substances created during a reaction or series of reactions.
    * @return double
    */
    public double getYield() {
        DoubleSTAttribute att = (DoubleSTAttribute) this.getYieldAttribute();
        if (att == null) {
            return Double.NaN;
        }
        return att.getDouble();
    }
    /** Yield of a reaction or reactionStep.
    * Yields can be given on either element. They should lie in the range 0 to 1 inclusive (i.e. percentages will need to be converted). Software may use yield to calculate amounts of substances created during a reaction or series of reactions.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setYield(String value) throws RuntimeException {
        DoubleSTAttribute att = null;
        if (_att_yield == null) {
            _att_yield = (DoubleSTAttribute) attributeFactory.getAttribute("yield", "reaction");
            if (_att_yield == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : yield probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new DoubleSTAttribute(_att_yield);
        super.addRemove(att, value);
    }
    /** Yield of a reaction or reactionStep.
    * Yields can be given on either element. They should lie in the range 0 to 1 inclusive (i.e. percentages will need to be converted). Software may use yield to calculate amounts of substances created during a reaction or series of reactions.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setYield(double value) throws RuntimeException {
        if (_att_yield == null) {
            _att_yield = (DoubleSTAttribute) attributeFactory.getAttribute("yield", "reaction");
           if (_att_yield == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : yield probably incompatible attributeGroupName and attributeName ");
            }
        }
        DoubleSTAttribute att = new DoubleSTAttribute(_att_yield);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// element:   metadataList

    /** Yield of a reaction or reactionStep.
    * Yields can be given on either element. They should lie in the range 0 to 1 inclusive (i.e. percentages will need to be converted). Software may use yield to calculate amounts of substances created during a reaction or series of reactions.
    * @param metadataList child to add
    */
    public void addMetadataList(AbstractMetadataList metadataList) {
        metadataList.detach();
        this.appendChild(metadataList);
    }
    /** Yield of a reaction or reactionStep.
    * Yields can be given on either element. They should lie in the range 0 to 1 inclusive (i.e. percentages will need to be converted). Software may use yield to calculate amounts of substances created during a reaction or series of reactions.
    * @return CMLElements<CMLMetadataList>
    */
    public CMLElements<CMLMetadataList> getMetadataListElements() {
        Elements elements = this.getChildElements("metadataList", CML_NS);
        return new CMLElements<CMLMetadataList>(elements);
    }
// element:   label

    /** Yield of a reaction or reactionStep.
    * Yields can be given on either element. They should lie in the range 0 to 1 inclusive (i.e. percentages will need to be converted). Software may use yield to calculate amounts of substances created during a reaction or series of reactions.
    * @param label child to add
    */
    public void addLabel(AbstractLabel label) {
        label.detach();
        this.appendChild(label);
    }
    /** Yield of a reaction or reactionStep.
    * Yields can be given on either element. They should lie in the range 0 to 1 inclusive (i.e. percentages will need to be converted). Software may use yield to calculate amounts of substances created during a reaction or series of reactions.
    * @return CMLElements<CMLLabel>
    */
    public CMLElements<CMLLabel> getLabelElements() {
        Elements elements = this.getChildElements("label", CML_NS);
        return new CMLElements<CMLLabel>(elements);
    }
// element:   name

    /** Yield of a reaction or reactionStep.
    * Yields can be given on either element. They should lie in the range 0 to 1 inclusive (i.e. percentages will need to be converted). Software may use yield to calculate amounts of substances created during a reaction or series of reactions.
    * @param name child to add
    */
    public void addName(AbstractName name) {
        name.detach();
        this.appendChild(name);
    }
    /** Yield of a reaction or reactionStep.
    * Yields can be given on either element. They should lie in the range 0 to 1 inclusive (i.e. percentages will need to be converted). Software may use yield to calculate amounts of substances created during a reaction or series of reactions.
    * @return CMLElements<CMLName>
    */
    public CMLElements<CMLName> getNameElements() {
        Elements elements = this.getChildElements("name", CML_NS);
        return new CMLElements<CMLName>(elements);
    }
// element:   identifier

    /** Yield of a reaction or reactionStep.
    * Yields can be given on either element. They should lie in the range 0 to 1 inclusive (i.e. percentages will need to be converted). Software may use yield to calculate amounts of substances created during a reaction or series of reactions.
    * @param identifier child to add
    */
    public void addIdentifier(AbstractIdentifier identifier) {
        identifier.detach();
        this.appendChild(identifier);
    }
    /** Yield of a reaction or reactionStep.
    * Yields can be given on either element. They should lie in the range 0 to 1 inclusive (i.e. percentages will need to be converted). Software may use yield to calculate amounts of substances created during a reaction or series of reactions.
    * @return CMLElements<CMLIdentifier>
    */
    public CMLElements<CMLIdentifier> getIdentifierElements() {
        Elements elements = this.getChildElements("identifier", CML_NS);
        return new CMLElements<CMLIdentifier>(elements);
    }
// element:   reactiveCentre

    /** Yield of a reaction or reactionStep.
    * Yields can be given on either element. They should lie in the range 0 to 1 inclusive (i.e. percentages will need to be converted). Software may use yield to calculate amounts of substances created during a reaction or series of reactions.
    * @param reactiveCentre child to add
    */
    public void addReactiveCentre(AbstractReactiveCentre reactiveCentre) {
        reactiveCentre.detach();
        this.appendChild(reactiveCentre);
    }
    /** Yield of a reaction or reactionStep.
    * Yields can be given on either element. They should lie in the range 0 to 1 inclusive (i.e. percentages will need to be converted). Software may use yield to calculate amounts of substances created during a reaction or series of reactions.
    * @return CMLElements<CMLReactiveCentre>
    */
    public CMLElements<CMLReactiveCentre> getReactiveCentreElements() {
        Elements elements = this.getChildElements("reactiveCentre", CML_NS);
        return new CMLElements<CMLReactiveCentre>(elements);
    }
// element:   mechanism

    /** Yield of a reaction or reactionStep.
    * Yields can be given on either element. They should lie in the range 0 to 1 inclusive (i.e. percentages will need to be converted). Software may use yield to calculate amounts of substances created during a reaction or series of reactions.
    * @param mechanism child to add
    */
    public void addMechanism(AbstractMechanism mechanism) {
        mechanism.detach();
        this.appendChild(mechanism);
    }
    /** Yield of a reaction or reactionStep.
    * Yields can be given on either element. They should lie in the range 0 to 1 inclusive (i.e. percentages will need to be converted). Software may use yield to calculate amounts of substances created during a reaction or series of reactions.
    * @return CMLElements<CMLMechanism>
    */
    public CMLElements<CMLMechanism> getMechanismElements() {
        Elements elements = this.getChildElements("mechanism", CML_NS);
        return new CMLElements<CMLMechanism>(elements);
    }
// element:   reactantList

    /** Yield of a reaction or reactionStep.
    * Yields can be given on either element. They should lie in the range 0 to 1 inclusive (i.e. percentages will need to be converted). Software may use yield to calculate amounts of substances created during a reaction or series of reactions.
    * @param reactantList child to add
    */
    public void addReactantList(AbstractReactantList reactantList) {
        reactantList.detach();
        this.appendChild(reactantList);
    }
    /** Yield of a reaction or reactionStep.
    * Yields can be given on either element. They should lie in the range 0 to 1 inclusive (i.e. percentages will need to be converted). Software may use yield to calculate amounts of substances created during a reaction or series of reactions.
    * @return CMLElements<CMLReactantList>
    */
    public CMLElements<CMLReactantList> getReactantListElements() {
        Elements elements = this.getChildElements("reactantList", CML_NS);
        return new CMLElements<CMLReactantList>(elements);
    }
// element:   spectatorList

    /** Yield of a reaction or reactionStep.
    * Yields can be given on either element. They should lie in the range 0 to 1 inclusive (i.e. percentages will need to be converted). Software may use yield to calculate amounts of substances created during a reaction or series of reactions.
    * @param spectatorList child to add
    */
    public void addSpectatorList(AbstractSpectatorList spectatorList) {
        spectatorList.detach();
        this.appendChild(spectatorList);
    }
    /** Yield of a reaction or reactionStep.
    * Yields can be given on either element. They should lie in the range 0 to 1 inclusive (i.e. percentages will need to be converted). Software may use yield to calculate amounts of substances created during a reaction or series of reactions.
    * @return CMLElements<CMLSpectatorList>
    */
    public CMLElements<CMLSpectatorList> getSpectatorListElements() {
        Elements elements = this.getChildElements("spectatorList", CML_NS);
        return new CMLElements<CMLSpectatorList>(elements);
    }
// element:   substanceList

    /** Yield of a reaction or reactionStep.
    * Yields can be given on either element. They should lie in the range 0 to 1 inclusive (i.e. percentages will need to be converted). Software may use yield to calculate amounts of substances created during a reaction or series of reactions.
    * @param substanceList child to add
    */
    public void addSubstanceList(AbstractSubstanceList substanceList) {
        substanceList.detach();
        this.appendChild(substanceList);
    }
    /** Yield of a reaction or reactionStep.
    * Yields can be given on either element. They should lie in the range 0 to 1 inclusive (i.e. percentages will need to be converted). Software may use yield to calculate amounts of substances created during a reaction or series of reactions.
    * @return CMLElements<CMLSubstanceList>
    */
    public CMLElements<CMLSubstanceList> getSubstanceListElements() {
        Elements elements = this.getChildElements("substanceList", CML_NS);
        return new CMLElements<CMLSubstanceList>(elements);
    }
// element:   conditionList

    /** Yield of a reaction or reactionStep.
    * Yields can be given on either element. They should lie in the range 0 to 1 inclusive (i.e. percentages will need to be converted). Software may use yield to calculate amounts of substances created during a reaction or series of reactions.
    * @param conditionList child to add
    */
    public void addConditionList(AbstractConditionList conditionList) {
        conditionList.detach();
        this.appendChild(conditionList);
    }
    /** Yield of a reaction or reactionStep.
    * Yields can be given on either element. They should lie in the range 0 to 1 inclusive (i.e. percentages will need to be converted). Software may use yield to calculate amounts of substances created during a reaction or series of reactions.
    * @return CMLElements<CMLConditionList>
    */
    public CMLElements<CMLConditionList> getConditionListElements() {
        Elements elements = this.getChildElements("conditionList", CML_NS);
        return new CMLElements<CMLConditionList>(elements);
    }
// element:   transitionState

    /** Yield of a reaction or reactionStep.
    * Yields can be given on either element. They should lie in the range 0 to 1 inclusive (i.e. percentages will need to be converted). Software may use yield to calculate amounts of substances created during a reaction or series of reactions.
    * @param transitionState child to add
    */
    public void addTransitionState(AbstractTransitionState transitionState) {
        transitionState.detach();
        this.appendChild(transitionState);
    }
    /** Yield of a reaction or reactionStep.
    * Yields can be given on either element. They should lie in the range 0 to 1 inclusive (i.e. percentages will need to be converted). Software may use yield to calculate amounts of substances created during a reaction or series of reactions.
    * @return CMLElements<CMLTransitionState>
    */
    public CMLElements<CMLTransitionState> getTransitionStateElements() {
        Elements elements = this.getChildElements("transitionState", CML_NS);
        return new CMLElements<CMLTransitionState>(elements);
    }
// element:   productList

    /** Yield of a reaction or reactionStep.
    * Yields can be given on either element. They should lie in the range 0 to 1 inclusive (i.e. percentages will need to be converted). Software may use yield to calculate amounts of substances created during a reaction or series of reactions.
    * @param productList child to add
    */
    public void addProductList(AbstractProductList productList) {
        productList.detach();
        this.appendChild(productList);
    }
    /** Yield of a reaction or reactionStep.
    * Yields can be given on either element. They should lie in the range 0 to 1 inclusive (i.e. percentages will need to be converted). Software may use yield to calculate amounts of substances created during a reaction or series of reactions.
    * @return CMLElements<CMLProductList>
    */
    public CMLElements<CMLProductList> getProductListElements() {
        Elements elements = this.getChildElements("productList", CML_NS);
        return new CMLElements<CMLProductList>(elements);
    }
// element:   propertyList

    /** Yield of a reaction or reactionStep.
    * Yields can be given on either element. They should lie in the range 0 to 1 inclusive (i.e. percentages will need to be converted). Software may use yield to calculate amounts of substances created during a reaction or series of reactions.
    * @param propertyList child to add
    */
    public void addPropertyList(AbstractPropertyList propertyList) {
        propertyList.detach();
        this.appendChild(propertyList);
    }
    /** Yield of a reaction or reactionStep.
    * Yields can be given on either element. They should lie in the range 0 to 1 inclusive (i.e. percentages will need to be converted). Software may use yield to calculate amounts of substances created during a reaction or series of reactions.
    * @return CMLElements<CMLPropertyList>
    */
    public CMLElements<CMLPropertyList> getPropertyListElements() {
        Elements elements = this.getChildElements("propertyList", CML_NS);
        return new CMLElements<CMLPropertyList>(elements);
    }
// element:   map

    /** Yield of a reaction or reactionStep.
    * Yields can be given on either element. They should lie in the range 0 to 1 inclusive (i.e. percentages will need to be converted). Software may use yield to calculate amounts of substances created during a reaction or series of reactions.
    * @param map child to add
    */
    public void addMap(AbstractMap map) {
        map.detach();
        this.appendChild(map);
    }
    /** Yield of a reaction or reactionStep.
    * Yields can be given on either element. They should lie in the range 0 to 1 inclusive (i.e. percentages will need to be converted). Software may use yield to calculate amounts of substances created during a reaction or series of reactions.
    * @return CMLElements<CMLMap>
    */
    public CMLElements<CMLMap> getMapElements() {
        Elements elements = this.getChildElements("map", CML_NS);
        return new CMLElements<CMLMap>(elements);
    }
// element:   object

    /** Yield of a reaction or reactionStep.
    * Yields can be given on either element. They should lie in the range 0 to 1 inclusive (i.e. percentages will need to be converted). Software may use yield to calculate amounts of substances created during a reaction or series of reactions.
    * @param object child to add
    */
    public void addObject(AbstractObject object) {
        object.detach();
        this.appendChild(object);
    }
    /** Yield of a reaction or reactionStep.
    * Yields can be given on either element. They should lie in the range 0 to 1 inclusive (i.e. percentages will need to be converted). Software may use yield to calculate amounts of substances created during a reaction or series of reactions.
    * @return CMLElements<CMLObject>
    */
    public CMLElements<CMLObject> getObjectElements() {
        Elements elements = this.getChildElements("object", CML_NS);
        return new CMLElements<CMLObject>(elements);
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
        } else if (name.equals("format")) {
            setFormat(value);
        } else if (name.equals("ref")) {
            setRef(value);
        } else if (name.equals("role")) {
            setRole(value);
        } else if (name.equals("type")) {
            setType(value);
        } else if (name.equals("state")) {
            setState(value);
        } else if (name.equals("atomMap")) {
            setAtomMap(value);
        } else if (name.equals("electronMap")) {
            setElectronMap(value);
        } else if (name.equals("bondMap")) {
            setBondMap(value);
        } else if (name.equals("yield")) {
            setYield(value);
	     } else {
            super.addAttribute(att);
        }
    }
}
