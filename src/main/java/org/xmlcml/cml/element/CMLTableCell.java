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
import org.xmlcml.cml.base.CMLConstants;
import org.xmlcml.cml.base.CMLElement;
import org.xmlcml.cml.base.CMLUtil;

/** A cell in a row of a table.
*
*
* tableCell \nis a data container of the table. Normally it contains\n simpleType, but may also contain a single child element. \nIt should NOT directly contain multiple children of any sort.
*
* user-modifiable class autogenerated from schema if no class exists
* use as a shell which can be edited
* the autogeneration software will not overwrite an existing class file

*/
public class CMLTableCell extends org.xmlcml.cml.element.AbstractTableCell {

    /** must give simple documentation.
    *

    */

    public CMLTableCell() {
    }
    /** must give simple documentation.
    *
    * @param old CMLTableCell to copy

    */

    public CMLTableCell(CMLTableCell old) {
        super((org.xmlcml.cml.element.AbstractTableCell) old);
    }

    /** constructor.
     *
     * @param s string content
     */
    public CMLTableCell(String s) {
        this();
        CMLUtil.setXMLContent(this, s);
    }

    /** constructor.
     *
     * @param d double content
     */
    public CMLTableCell(double d) {
        this();
        CMLUtil.setXMLContent(this, CMLConstants.S_EMPTY+d);
    }

    /** constructor.
     *
     * @param i int content
     */
    public CMLTableCell(int i) {
        this();
        CMLUtil.setXMLContent(this, CMLConstants.S_EMPTY+i);
    }

    /** constructor.
     *
     * @param element content
     */
    public CMLTableCell(Element element) {
        this();
        this.appendChild(element);
    }

    /** copy node .
    *
    * @return Node
    */
    public Element copy() {
        return new CMLTableCell(this);
    }
    /** create new instance in context of parent, overridable by subclasses.
    *
    * @param parent parent of element to be constructed (ignored by default)
    * @return CMLTableCell
    */
    public CMLElement makeElementInContext(Element parent) {
        return new CMLTableCell();
    }

    /** gets double.
     * does not check dataType at present.
     * @return double
     */
    public double getDouble() {
        double d = Double.NaN;
        try {
            d = Double.valueOf(this.getValue()).doubleValue();
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
        return d;
    }

    /** gets integer.
     * does not check dataType at present.
     * @return integer
     */
    public double getInt() {
        int i = -Integer.MAX_VALUE;
        try {
            i =Integer.parseInt(this.getValue());
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
        return i;
    }
    /**
     * write cell to HTML table.
     *
     * @param w
     *            writer
     * @throws IOException
     */
    public void writeHTML(Writer w) throws IOException {
        w.write("<td>");
        String s = this.getStringContent();
        w.write((s == null) ? CMLConstants.S_EMPTY : s);
        w.write("</td>");
    }

    /** append value of cell to array.
     * checks dataType.
     * @param dataType
     * @param array
     */
    public void appendValueTo(String dataType, CMLArray array) {
        if (array == null) {
            throw new RuntimeException("cannot add null array");
        }
        if (XSD_DOUBLE.equals(dataType)) {
            if (!XSD_DOUBLE.equals(array.getDataType())) {
                throw new RuntimeException("Inconsistent dataTypes: "
                        +dataType+S_SPACE+array.getDataType());
            }
            array.append(this.getDouble());
        } else if (XSD_INTEGER.equals(dataType)) {
            if (!XSD_INTEGER.equals(array.getDataType())) {
                throw new RuntimeException("Inconsistent dataTypes: "
                        +dataType+S_SPACE+array.getDataType());
            }
            array.append(this.getInt());
        } else {
            array.append(this.getValue());
        }
    }
}
