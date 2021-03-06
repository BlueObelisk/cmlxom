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

import org.xmlcml.cml.base.CMLAttribute;
import org.xmlcml.cml.base.CMLElement;
import org.xmlcml.cml.base.StringSTAttribute;

// end of part 1
/** CLASS DOCUMENTATION */
public abstract class AbstractRelatedEntry extends CMLElement {
    /** local name*/
    public final static String TAG = "relatedEntry";
    /** constructor. */    public AbstractRelatedEntry() {
        super("relatedEntry");
    }
/** copy constructor.
* deep copy using XOM copy()
* @param old element to copy
*/
    public AbstractRelatedEntry(AbstractRelatedEntry old) {
        super((CMLElement) old);
    }
// attribute:   type

    /** cache */
    StringSTAttribute _att_type = null;
    /** Type of relatedEntry.
    * Type represents a the type of relationship in a relatedEntry element.
    * @return CMLAttribute
    */
    public CMLAttribute getTypeAttribute() {
        return (CMLAttribute) getAttribute("type");
    }
    /** Type of relatedEntry.
    * Type represents a the type of relationship in a relatedEntry element.
    * @return String
    */
    public String getType() {
        StringSTAttribute att = (StringSTAttribute) this.getTypeAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** Type of relatedEntry.
    * Type represents a the type of relationship in a relatedEntry element.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setType(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_type == null) {
            _att_type = (StringSTAttribute) attributeFactory.getAttribute("type", "relatedEntry");
            if (_att_type == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : type probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_type);
        super.addRemove(att, value);
    }
// attribute:   href

    /** cache */
    StringSTAttribute _att_href = null;
    /** address of a resource.
    * Links to another element in the same or other file. For dictionary/@dictRef requires the prefix and the physical URI 
    *             address to be contained within the same file. We can anticipate that
    *             better mechanisms will arise - perhaps through XMLCatalogs.
    *             At least it works at present.
    * @return CMLAttribute
    */
    public CMLAttribute getHrefAttribute() {
        return (CMLAttribute) getAttribute("href");
    }
    /** address of a resource.
    * Links to another element in the same or other file. For dictionary/@dictRef requires the prefix and the physical URI 
    *             address to be contained within the same file. We can anticipate that
    *             better mechanisms will arise - perhaps through XMLCatalogs.
    *             At least it works at present.
    * @return String
    */
    public String getHref() {
        StringSTAttribute att = (StringSTAttribute) this.getHrefAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** address of a resource.
    * Links to another element in the same or other file. For dictionary/@dictRef requires the prefix and the physical URI 
    *             address to be contained within the same file. We can anticipate that
    *             better mechanisms will arise - perhaps through XMLCatalogs.
    *             At least it works at present.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setHref(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_href == null) {
            _att_href = (StringSTAttribute) attributeFactory.getAttribute("href", "relatedEntry");
            if (_att_href == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : href probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_href);
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
        } else if (name.equals("type")) {
            setType(value);
        } else if (name.equals("href")) {
            setHref(value);
	     } else {
            super.addAttribute(att);
        }
    }
}
