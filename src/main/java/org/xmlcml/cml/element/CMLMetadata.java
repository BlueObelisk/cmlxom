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
import nu.xom.Element;
import nu.xom.Node;

import org.xmlcml.cml.base.CMLAttribute;
import org.xmlcml.cml.base.CMLElement;

/**
 * user-modifiable class supporting metadata. * autogenerated from schema use as
 * a shell which can be edited
 *
 */
public class CMLMetadata extends AbstractMetadata {

	/** namespaced element name.*/
	public final static String NS = C_E+AbstractMetadata.TAG;

    /**
     * constructor.
     */
    public CMLMetadata() {
    }

    /**
     * constructor.
     *
     * @param old
     */
    public CMLMetadata(CMLMetadata old) {
        super((AbstractMetadata) old);

    }

    /**
     * copy node .
     *
     * @return Node
     */
    public Node copy() {
        return new CMLMetadata(this);

    }

    /**
     * create new instance in context of parent, overridable by subclasses.
     *
     * @param parent
     *            parent of element to be constructed (ignored by default)
     * @return ICMLMetadata
     */
    public CMLElement makeElementInContext(Element parent) {
        return new CMLMetadata();

    }

    /**
     * Override metadata type. no-op
     *
     * @deprecated
     * @return null
     */
    public CMLAttribute getMetadataTypeAttribute() {
        return null;
    }

    /**
     * Override metadata type. no-op
     *
     * @deprecated
     * @return null
     */
    public String getMetadataType() {
        return null;
    }

    /**
     * Override metadata type. no-op
     *
     * @deprecated
     * @param value
     *            do not use
     * @throws RuntimeException
     */
    public void setMetadataType(String value) throws RuntimeException {
    }

    /**
     * replace setMetadataType. this is because attributeGroup name and
     * attribute name are not the same
     *
     * @param value
     */
    /*--
     public void setName(String value) {
     if (_att_metadataType == null) {
     _att_metadataType = new StringSTAttribute((StringSTAttribute)CMLAttributeList.getAttribute("metadataType"));
     super.addAttribute(_att_metadataType);
     }
     ((StringSTAttribute)_att_metadataType).setCMLValue(value);
     }
     --*/

    /**
     * replace getMetadataType. this is because attributeGroup name and
     * attribute name are not the same
     *
     * @param name
     */
    /*--
     public String getName() {
     if (_att_metadataType == null) {
     _att_metadataType = (CMLAttribute) getAttribute("metadataType");
     }
     if (_att_metadataType == null) {
     return null;
     }
     return ((StringSTAttribute)_att_metadataType).getString();
     //    	return getAttributeValue("name");
     }
     --*/

    /**
     * override name and metadataType attributes. this is because attributeGroup
     * and attribute have different names
     *
     * @param att
     */
    public void addAttribute(Attribute att) {
        super.addAttribute(att);
        String name = att.getLocalName();
        String value = att.getValue();
        if (name.equals("metadataType")) {
            super.removeAttribute(att);
            setName(value);
        }
    }

}
