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

import java.io.IOException;
import java.io.Writer;

import nu.xom.Element;
import org.xmlcml.cml.base.CMLElement;
import org.xmlcml.cml.base.CMLElements;
import org.xmlcml.cml.base.CMLUtil;

/**
 * Explicit row of a table.
 *
 *
 * \n Metadata for rows must be defined in tableHeader.\n
 *
 * user-modifiable class autogenerated from schema if no class exists use as a
 * shell which can be edited the autogeneration software will not overwrite an
 * existing class file
 *
 */
public class CMLTableRow extends AbstractTableRow {

	/** namespaced element name.*/
	public final static String NS = C_E+TAG;

    /**
     * must give simple documentation.
     *
     *
     */

    public CMLTableRow() {
    }

    /**
     * must give simple documentation.
     *
     * @param old
     *            CMLTableRow to copy
     *
     */

    public CMLTableRow(CMLTableRow old) {
        super((AbstractTableRow) old);
    }

    /**
     * copy node .
     *
     * @return Node
     */
    public Element copy() {
        return new CMLTableRow(this);
    }

    /**
     * create new instance in context of parent, overridable by subclasses.
     *
     * @param parent
     *            parent of element to be constructed (ignored by default)
     * @return CMLTableRow
     */
    public CMLElement makeElementInContext(Element parent) {
        return new CMLTableRow();
    }

    /**
     * write row to HTML table.
     *
     * @param w
     *            writer
     * @throws IOException
     */
    public void writeHTML(Writer w) throws IOException {
        w.write("\n<tr>");
        CMLElements<CMLTableCell> tableCells = this.getTableCellElements();
        for (CMLTableCell tableCell : tableCells) {
            tableCell.writeHTML(w);
        }
        w.write("</tr>");
    }

    /** delimited string.
     * if delimiter is space (generic whitespace) interposes single
     * spaces. If content strings already have whitespace throws
     * exception. If delimiter is not whitspace adds delimiter at
     * inside row but not at ends
     * @param delimiter
     * @return delimited string
     */
    public String getDelimitedString(String delimiter) {
        String delim = (delimiter == null || S_EMPTY.equals(delimiter)) ?
                S_SPACE : delimiter;
        boolean trim = S_SPACE.equals(delim);
        StringBuilder sb = new StringBuilder();
        CMLElements<CMLTableCell> tableCells = this.getTableCellElements();
        int count = 0;
        int last = tableCells.size();
        for (CMLTableCell tableCell : tableCells) {
            String s = CMLUtil.getXMLContent(tableCell);
            if (trim) {
                s.trim();
            }
            sb.append(s);
            if (count++ < last-1) {
                sb.append(delim);
            }
        }
        return sb.toString();
    }

}
