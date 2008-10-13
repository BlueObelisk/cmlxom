package org.xmlcml.cml.element.lite;


import nu.xom.Attribute;

import org.xmlcml.cml.attribute.DictRefAttribute;
import org.xmlcml.cml.attribute.IdAttribute;
import org.xmlcml.cml.base.CMLAttribute;
import org.xmlcml.cml.base.CMLElement;
import org.xmlcml.cml.base.StringSTAttribute;

// end of part 1
/** CLASS DOCUMENTATION */
public abstract class AbstractLabel extends CMLElement {
    /** local name*/
    public final static String TAG = "label";
    /** constructor. */    public AbstractLabel() {
        super("label");
    }
/** copy constructor.
* deep copy using XOM copy()
* @param old element to copy
*/
    public AbstractLabel(AbstractLabel old) {
        super((CMLElement) old);
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
            _att_id = (IdAttribute) attributeFactory.getAttribute("id", "label");
            if (_att_id == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : id probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new IdAttribute(_att_id);
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
            _att_dictref = (DictRefAttribute) attributeFactory.getAttribute("dictRef", "label");
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
            _att_value = (StringSTAttribute) attributeFactory.getAttribute("value", "label");
            if (_att_value == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : value probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_value);
        super.addRemove(att, value);
    }
// attribute:   objectClass

    /** cache */
    StringSTAttribute _att_objectclass = null;
    /** The class of an object.
    * The type of this information. This is not controlled, but examples might include:
    *                     
    *                         label
    *                         summary
    *                         note
    *                         usage
    *                         qualifier
    *                     
    *             It might be used to control display or XSL filtering.
    * @return CMLAttribute
    */
    public CMLAttribute getObjectClassAttribute() {
        return (CMLAttribute) getAttribute("objectClass");
    }
    /** The class of an object.
    * The type of this information. This is not controlled, but examples might include:
    *                     
    *                         label
    *                         summary
    *                         note
    *                         usage
    *                         qualifier
    *                     
    *             It might be used to control display or XSL filtering.
    * @return String
    */
    public String getObjectClass() {
        StringSTAttribute att = (StringSTAttribute) this.getObjectClassAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** The class of an object.
    * The type of this information. This is not controlled, but examples might include:
    *                     
    *                         label
    *                         summary
    *                         note
    *                         usage
    *                         qualifier
    *                     
    *             It might be used to control display or XSL filtering.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setObjectClass(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_objectclass == null) {
            _att_objectclass = (StringSTAttribute) attributeFactory.getAttribute("objectClass", "label");
            if (_att_objectclass == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : objectClass probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_objectclass);
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
        } else if (name.equals("id")) {
            setId(value);
        } else if (name.equals("dictRef")) {
            setDictRef(value);
        } else if (name.equals("value")) {
            setCMLValue(value);
        } else if (name.equals("objectClass")) {
            setObjectClass(value);
	     } else {
            super.addAttribute(att);
        }
    }
}
