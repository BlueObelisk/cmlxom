package org.xmlcml.cml.element.lite;


import nu.xom.Attribute;

import org.xmlcml.cml.attribute.DictRefAttribute;
import org.xmlcml.cml.attribute.IdAttribute;
import org.xmlcml.cml.base.CMLAttribute;
import org.xmlcml.cml.base.CMLElement;
import org.xmlcml.cml.base.StringSTAttribute;

// end of part 1
/** CLASS DOCUMENTATION */
public abstract class AbstractCml extends CMLElement {
    /** local name*/
    public final static String TAG = "cml";
    /** constructor. */    public AbstractCml() {
        super("cml");
    }
/** copy constructor.
* deep copy using XOM copy()
* @param old element to copy
*/
    public AbstractCml(AbstractCml old) {
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
            _att_title = (StringSTAttribute) attributeFactory.getAttribute("title", "cml");
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
            _att_id = (IdAttribute) attributeFactory.getAttribute("id", "cml");
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
            _att_convention = (StringSTAttribute) attributeFactory.getAttribute("convention", "cml");
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
            _att_dictref = (DictRefAttribute) attributeFactory.getAttribute("dictRef", "cml");
            if (_att_dictref == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : dictRef probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new DictRefAttribute(_att_dictref);
        super.addRemove(att, value);
    }
// attribute:   fileId

    /** cache */
    StringSTAttribute _att_fileid = null;
    /** Information identifying the name of a file or other resource.
    * This allows an element (such as cml) to carry limited
    *                 information about provenance such as the name of the document used to provide the
    *                 content. It is not a complete solution but can help to protect a document becoming
    *                 separated from its external metadata. It is restricted to the basic XML character set
    *                 (printable ANSI) and whitespace (which should anyway be discouraged) is normalized to
    *                 single space (attribute values cannot carry newlines). 
    *                 Quotation marks and other horrors (as used in some OS)
    *                 should be avoided. 
    * @return CMLAttribute
    */
    public CMLAttribute getFileIdAttribute() {
        return (CMLAttribute) getAttribute("fileId");
    }
    /** Information identifying the name of a file or other resource.
    * This allows an element (such as cml) to carry limited
    *                 information about provenance such as the name of the document used to provide the
    *                 content. It is not a complete solution but can help to protect a document becoming
    *                 separated from its external metadata. It is restricted to the basic XML character set
    *                 (printable ANSI) and whitespace (which should anyway be discouraged) is normalized to
    *                 single space (attribute values cannot carry newlines). 
    *                 Quotation marks and other horrors (as used in some OS)
    *                 should be avoided. 
    * @return String
    */
    public String getFileId() {
        StringSTAttribute att = (StringSTAttribute) this.getFileIdAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** Information identifying the name of a file or other resource.
    * This allows an element (such as cml) to carry limited
    *                 information about provenance such as the name of the document used to provide the
    *                 content. It is not a complete solution but can help to protect a document becoming
    *                 separated from its external metadata. It is restricted to the basic XML character set
    *                 (printable ANSI) and whitespace (which should anyway be discouraged) is normalized to
    *                 single space (attribute values cannot carry newlines). 
    *                 Quotation marks and other horrors (as used in some OS)
    *                 should be avoided. 
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setFileId(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_fileid == null) {
            _att_fileid = (StringSTAttribute) attributeFactory.getAttribute("fileId", "cml");
            if (_att_fileid == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : fileId probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_fileid);
        super.addRemove(att, value);
    }
// attribute:   version

    /** cache */
    StringSTAttribute _att_version = null;
    /** The version of the element.
    * No description
    * @return CMLAttribute
    */
    public CMLAttribute getVersionAttribute() {
        return (CMLAttribute) getAttribute("version");
    }
    /** The version of the element.
    * No description
    * @return String
    */
    public String getVersion() {
        StringSTAttribute att = (StringSTAttribute) this.getVersionAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** The version of the element.
    * No description
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setVersion(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_version == null) {
            _att_version = (StringSTAttribute) attributeFactory.getAttribute("version", "cml");
            if (_att_version == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : version probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_version);
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
        } else if (name.equals("fileId")) {
            setFileId(value);
        } else if (name.equals("version")) {
            setVersion(value);
	     } else {
            super.addAttribute(att);
        }
    }
}
