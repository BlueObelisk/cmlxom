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

import nu.xom.Element;
import org.xmlcml.cml.base.CMLElement;
import org.xmlcml.cml.interfacex.PeakOrGroup;

/**
 * user-modifiable class supporting peak. * autogenerated from schema use as a
 * shell which can be edited
 *
 */
public class CMLPeak extends AbstractPeak implements PeakOrGroup {

	/** namespaced element name.*/
	public final static String NS = C_E+TAG;

    /**
     * constructor.
     */
    public CMLPeak() {
    }

    /**
     * constructor.
     *
     * @param old
     */
    public CMLPeak(CMLPeak old) {
        super((AbstractPeak) old);

    }

    /**
     * copy node .
     *
     * @return Node
     */
    public Element copy() {
        return new CMLPeak(this);

    }

    /**
     * create new instance in context of parent, overridable by subclasses.
     *
     * @param parent
     *            parent of element to be constructed (ignored by default)
     * @return CMLPeak
     */
    public CMLElement makeElementInContext(Element parent) {
        return new CMLPeak();

    }
//    OBSOLETE?
//	/** ensure integrity between list and children.
//	 * @return CMLPeakList.class
//	 */
//	public Class getIndexableListClass() {
//		return CMLPeakList.class;
//	}

}
