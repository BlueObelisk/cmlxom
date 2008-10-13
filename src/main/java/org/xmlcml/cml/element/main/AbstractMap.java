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

// end of part 1
/** CLASS DOCUMENTATION */
public abstract class AbstractMap extends CMLElement {
    /** local name*/
    public final static String TAG = "map";
    /** constructor. */    public AbstractMap() {
        super("map");
    }
/** copy constructor.
* deep copy using XOM copy()
* @param old element to copy
*/
    public AbstractMap(AbstractMap old) {
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
            _att_title = (StringSTAttribute) attributeFactory.getAttribute("title", "map");
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
            _att_id = (IdAttribute) attributeFactory.getAttribute("id", "map");
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
            _att_convention = (StringSTAttribute) attributeFactory.getAttribute("convention", "map");
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
            _att_dictref = (DictRefAttribute) attributeFactory.getAttribute("dictRef", "map");
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
            _att_ref = (RefAttribute) attributeFactory.getAttribute("ref", "map");
            if (_att_ref == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : ref probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new RefAttribute(_att_ref);
        super.addRemove(att, value);
    }
// attribute:   fromType

    /** cache */
    StringSTAttribute _att_fromtype = null;
    /** The type of the base of a link.
    * The local tagname of the referenced element (e.g. 'molecule' or 'peakGroup'). This acts as a partial check on the integrity of the link. Software can assume that the referenced element is of a given tytpe and can create an object supporting that type. 
    * 				This attribute can be attached to the 'map' attribute and requires all contained links to be of this type. This can be overridden by a 'toType' attribute on indivdual links, but it may also be useful to split the map into maps od different link types.
    * 				
    * @return CMLAttribute
    */
    public CMLAttribute getFromTypeAttribute() {
        return (CMLAttribute) getAttribute("fromType");
    }
    /** The type of the base of a link.
    * The local tagname of the referenced element (e.g. 'molecule' or 'peakGroup'). This acts as a partial check on the integrity of the link. Software can assume that the referenced element is of a given tytpe and can create an object supporting that type. 
    * 				This attribute can be attached to the 'map' attribute and requires all contained links to be of this type. This can be overridden by a 'toType' attribute on indivdual links, but it may also be useful to split the map into maps od different link types.
    * 				
    * @return String
    */
    public String getFromType() {
        StringSTAttribute att = (StringSTAttribute) this.getFromTypeAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** The type of the base of a link.
    * The local tagname of the referenced element (e.g. 'molecule' or 'peakGroup'). This acts as a partial check on the integrity of the link. Software can assume that the referenced element is of a given tytpe and can create an object supporting that type. 
    * 				This attribute can be attached to the 'map' attribute and requires all contained links to be of this type. This can be overridden by a 'toType' attribute on indivdual links, but it may also be useful to split the map into maps od different link types.
    * 				
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setFromType(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_fromtype == null) {
            _att_fromtype = (StringSTAttribute) attributeFactory.getAttribute("fromType", "map");
            if (_att_fromtype == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : fromType probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_fromtype);
        super.addRemove(att, value);
    }
// attribute:   toType

    /** cache */
    StringSTAttribute _att_totype = null;
    /** The type of the base of a link.
    * 
    * 				The local tagname of the referenced element (e.g. 'molecule' or 'peakGroup'). This acts as a partial check on the integrity of the link. Software can assume that the referenced element is of a given tytpe and can create an object supporting that type.
    * 				This attribute can be attached to the 'map' attribute and requires all contained links to be of this type. This can be overridden by a 'toType' attribute on indivdual links, but it may also be useful to split the map into maps od different link types.
    * 				
    * @return CMLAttribute
    */
    public CMLAttribute getToTypeAttribute() {
        return (CMLAttribute) getAttribute("toType");
    }
    /** The type of the base of a link.
    * 
    * 				The local tagname of the referenced element (e.g. 'molecule' or 'peakGroup'). This acts as a partial check on the integrity of the link. Software can assume that the referenced element is of a given tytpe and can create an object supporting that type.
    * 				This attribute can be attached to the 'map' attribute and requires all contained links to be of this type. This can be overridden by a 'toType' attribute on indivdual links, but it may also be useful to split the map into maps od different link types.
    * 				
    * @return String
    */
    public String getToType() {
        StringSTAttribute att = (StringSTAttribute) this.getToTypeAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** The type of the base of a link.
    * 
    * 				The local tagname of the referenced element (e.g. 'molecule' or 'peakGroup'). This acts as a partial check on the integrity of the link. Software can assume that the referenced element is of a given tytpe and can create an object supporting that type.
    * 				This attribute can be attached to the 'map' attribute and requires all contained links to be of this type. This can be overridden by a 'toType' attribute on indivdual links, but it may also be useful to split the map into maps od different link types.
    * 				
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setToType(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_totype == null) {
            _att_totype = (StringSTAttribute) attributeFactory.getAttribute("toType", "map");
            if (_att_totype == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : toType probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_totype);
        super.addRemove(att, value);
    }
// attribute:   fromContext

    /** cache */
    StringSTAttribute _att_fromcontext = null;
    /** The context for the 'from' links in a map.
    * A reference to the unique 'id' attribute of an element defining the context for links in a map. This may be required when id attributes may not be unique within a document. The id should either reference an element uniquely or should be taken as the first ancestor (of the map) with such an id.
    * 				This is fairly horrid but may be required when documents are assembled without establishing unique ids (e.g. concatenation of files). As an example a map referencing linked atoms in two molecules might use the containing 'reaction' element as its uniquifying context.
    * 				
    * @return CMLAttribute
    */
    public CMLAttribute getFromContextAttribute() {
        return (CMLAttribute) getAttribute("fromContext");
    }
    /** The context for the 'from' links in a map.
    * A reference to the unique 'id' attribute of an element defining the context for links in a map. This may be required when id attributes may not be unique within a document. The id should either reference an element uniquely or should be taken as the first ancestor (of the map) with such an id.
    * 				This is fairly horrid but may be required when documents are assembled without establishing unique ids (e.g. concatenation of files). As an example a map referencing linked atoms in two molecules might use the containing 'reaction' element as its uniquifying context.
    * 				
    * @return String
    */
    public String getFromContext() {
        StringSTAttribute att = (StringSTAttribute) this.getFromContextAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** The context for the 'from' links in a map.
    * A reference to the unique 'id' attribute of an element defining the context for links in a map. This may be required when id attributes may not be unique within a document. The id should either reference an element uniquely or should be taken as the first ancestor (of the map) with such an id.
    * 				This is fairly horrid but may be required when documents are assembled without establishing unique ids (e.g. concatenation of files). As an example a map referencing linked atoms in two molecules might use the containing 'reaction' element as its uniquifying context.
    * 				
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setFromContext(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_fromcontext == null) {
            _att_fromcontext = (StringSTAttribute) attributeFactory.getAttribute("fromContext", "map");
            if (_att_fromcontext == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : fromContext probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_fromcontext);
        super.addRemove(att, value);
    }
// attribute:   toContext

    /** cache */
    StringSTAttribute _att_tocontext = null;
    /** The context for the 'from' links in a map.
    * A reference to the unique 'id' attribute of an element defining the context for links in a map. This may be required when id attributes may not be unique within a document. The id should either reference an element uniquely or should be taken as the first ancestor (of the map) with such an id.
    * 				This is fairly horrid but may be required when documents are assembled without establishing unique ids (e.g. concatenation of files). As an example a map referencing linked atoms in two molecules might use the containing 'reaction' element as its uniquifying context.
    * 				
    * @return CMLAttribute
    */
    public CMLAttribute getToContextAttribute() {
        return (CMLAttribute) getAttribute("toContext");
    }
    /** The context for the 'from' links in a map.
    * A reference to the unique 'id' attribute of an element defining the context for links in a map. This may be required when id attributes may not be unique within a document. The id should either reference an element uniquely or should be taken as the first ancestor (of the map) with such an id.
    * 				This is fairly horrid but may be required when documents are assembled without establishing unique ids (e.g. concatenation of files). As an example a map referencing linked atoms in two molecules might use the containing 'reaction' element as its uniquifying context.
    * 				
    * @return String
    */
    public String getToContext() {
        StringSTAttribute att = (StringSTAttribute) this.getToContextAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** The context for the 'from' links in a map.
    * A reference to the unique 'id' attribute of an element defining the context for links in a map. This may be required when id attributes may not be unique within a document. The id should either reference an element uniquely or should be taken as the first ancestor (of the map) with such an id.
    * 				This is fairly horrid but may be required when documents are assembled without establishing unique ids (e.g. concatenation of files). As an example a map referencing linked atoms in two molecules might use the containing 'reaction' element as its uniquifying context.
    * 				
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setToContext(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_tocontext == null) {
            _att_tocontext = (StringSTAttribute) attributeFactory.getAttribute("toContext", "map");
            if (_att_tocontext == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : toContext probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_tocontext);
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
            _att_role = (StringSTAttribute) attributeFactory.getAttribute("role", "map");
            if (_att_role == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : role probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_role);
        super.addRemove(att, value);
    }
// element:   link

    /** Role of the object.
    * How the object functions or its position in the architecture. No controlled vocabulary.
    * @param link child to add
    */
    public void addLink(AbstractLink link) {
        link.detach();
        this.appendChild(link);
    }
    /** Role of the object.
    * How the object functions or its position in the architecture. No controlled vocabulary.
    * @return CMLElements<CMLLink>
    */
    public CMLElements<CMLLink> getLinkElements() {
        Elements elements = this.getChildElements("link", CML_NS);
        return new CMLElements<CMLLink>(elements);
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
        } else if (name.equals("fromType")) {
            setFromType(value);
        } else if (name.equals("toType")) {
            setToType(value);
        } else if (name.equals("fromContext")) {
            setFromContext(value);
        } else if (name.equals("toContext")) {
            setToContext(value);
        } else if (name.equals("role")) {
            setRole(value);
	     } else {
            super.addAttribute(att);
        }
    }
}
