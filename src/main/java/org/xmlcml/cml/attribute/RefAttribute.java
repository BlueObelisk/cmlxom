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

package org.xmlcml.cml.attribute;

import java.util.List;

import nu.xom.Attribute;

import org.xmlcml.cml.base.CMLElement;
import org.xmlcml.cml.base.StringSTAttribute;

/**
 * user-modifiable class supporting "ref", a pointer
 * to a CML object. default is to clone the object and then process it.
 * For that reason the referenced species should be pre-declared.
 */
public class RefAttribute extends StringSTAttribute {

	/** ref */
    public final static String NAME = "ref";
    /**
     * constructor.
     * 
     */
    public RefAttribute() {
        super(NAME);
    }

    /** constructor.
     * @param value
     */
    public RefAttribute(String value) {
        super(NAME);
        this.setCMLValue(value);
    }

    /**
     * constructor.
     * 
     * @param att
     * @exception RuntimeException
     */
    public RefAttribute(Attribute att) throws RuntimeException {
        super(att);
    }
    
    /** set value and process.
     * 
     * @param value
     * @exception RuntimeException bad value
     */
    public void setCMLValue(String value) throws RuntimeException {
        if (value == null) {
            throw new RuntimeException("null ref attribute value");
        } else if (value.trim().equals(S_EMPTY)) {
            // seems to get called with empty string initially
            // this is a bug
        } else {
            super.setCMLValue(value);
        }
    }
    
    /** processes ref attribute on element.
     * 
     * @param element to process
     */
    public static void process(CMLElement element) {
        RefAttribute ref = (RefAttribute) element.getAttribute(RefAttribute.NAME);
        if (ref != null) {
            RefAttribute.process(element, ref);
        }
        List<CMLElement> childElems = element.getChildCMLElements();
        for (CMLElement child : childElems) {
            RefAttribute.process(child);
        }
    }

    /** process element with a ref attribute.
     * if the reference can be resolved copies the object and
     * replaces 'this' with the copy.
     * @param element to process
     * @param ref attribute
     * @throws RuntimeException null element or bad reference
     */
    public static void process(CMLElement element, RefAttribute ref) throws RuntimeException {
        if (element == null) {
            throw new RuntimeException("Cannot process null ref attribute");
        }
        CMLElement oldest = element.getOldestCMLAncestor();
        if (oldest == element) {
            throw new RuntimeException("Cannot reference elements from oldest ancestor");
        }
        String id = ref.getValue();
        List<CMLElement> elemList = oldest.getElementsById(id, true);
        if (elemList.size() == 0) {
            throw new RuntimeException("Cannot find element: "+id);
        }
        if (elemList.size() > 1) {
            throw new RuntimeException("Too many elements ("+elemList.size()+") with id: "+id);
        }
        CMLElement elemRef = elemList.get(0);
        CMLElement newElem = (CMLElement) elemRef.copy();
        // FIXME - use RefAttribute
        String idgen = element.getAttributeValue("idgen");
        if (idgen != null) {
            newElem.addAttribute(new Attribute("id", idgen));
        } else {
        }
        // substitute all args
        // transfer any args from referring element
//        CMLArg.transferArgs(element, newElem);
//        CMLArg.substituteNameByValue(newElem);
//        LOG.debug("%%%%%%%%%%%%%%%%%%%%");
//        LOG.debug("%%%%%%%%%%%%%%%%%%%%");
        CMLElement parent = (CMLElement) element.getParent();
        int idx = parent.indexOf(element);
        parent.insertChild(newElem, idx);
//        element.detach();
    }
}
