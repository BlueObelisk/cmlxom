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

// /*======AUTOGENERATED FROM SCHEMA; DO NOT EDIT BELOW THIS LINE ======*/
package org.xmlcml.cml.element;

import nu.xom.Element;
import org.xmlcml.cml.base.CMLElement;

/**
 * Unmarked content of a table.
 *
 *
 * \n Metadata for rows must be defined in tableHeader. The elements of the\n
 * table are ASCII strings in this content. They can be separated by
 * whitespace\n or by a defined single character delimiter (see array for more
 * information).\n \n
 *
 * user-modifiable class autogenerated from schema if no class exists use as a
 * shell which can be edited the autogeneration software will not overwrite an
 * existing class file
 *
 */
public class CMLTableContent extends AbstractTableContent {

	/** namespaced element name.*/
	public final static String NS = C_E+TAG;

    /**
     * must give simple documentation.
     */

    public CMLTableContent() {
    }

    /**
     * must give simple documentation.
     *
     * @param old
     *            CMLTableContent to copy
     *
     */

    public CMLTableContent(CMLTableContent old) {
        super((AbstractTableContent) old);
    }

    /**
     * copy node .
     *
     * @return Node
     */
    public Element copy() {
        return new CMLTableContent(this);
    }

    /**
     * create new instance in context of parent, overridable by subclasses.
     *
     * @param parent
     *            parent of element to be constructed (ignored by default)
     * @return CMLTableContent
     */
    public CMLElement makeElementInContext(Element parent) {
        return new CMLTableContent();
    }

    /** sets delimiter if non-nul or non-whitespace.
     * if slashDelim is null or whitespace removes the attribute
     * @param delim
     */
    public void setDelimiter(String delim) {
        if (delim == null || S_EMPTY.equals(delim.trim())) {
            this.removeAttribute("delimiter");
        } else {
            super.setDelimiter(delim);
        }
    }

    /**
     * get content as strings. not yet edited for delimiters
     *
     * @return strings
     */
    public String[] getStrings() {
        String content = this.getStringContent().trim();
        String delimiter = (this.getDelimiterAttribute() == null)
            ? S_WHITEREGEX : this.getDelimiter();
        // trim leading and trailing delimiters
        if (content.startsWith(delimiter)) {
            content = content.substring(1);
        }
        if (content.startsWith(delimiter)) {
            content = content.substring(0, content.length()-1);
        }
        return content.split(delimiter);
    }


    StringBuilder sb = null;
    void append(String s, String delimiter) {
        String dd = (delimiter == null ||
                S_EMPTY.equals(delimiter.trim())) ? S_SPACE : delimiter;
        if (sb == null) {
            sb = new StringBuilder();
        } else {
            sb.append(dd);
        }
        sb.append(s);
    }

    void finishAppendingStrings(String delimiter) {
        if (sb != null) {
            if (delimiter != null) {
                sb.append(delimiter);
            }
            this.setXMLContent(sb.toString());
        }
        sb = null;
    }
}
