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
import nu.xom.Elements;

import org.xmlcml.cml.attribute.DictRefAttribute;
import org.xmlcml.cml.attribute.IdAttribute;
import org.xmlcml.cml.attribute.UnitsAttribute;
import org.xmlcml.cml.base.CMLAttribute;
import org.xmlcml.cml.base.CMLConstants;
import org.xmlcml.cml.base.CMLElement;
import org.xmlcml.cml.base.CMLElements;
import org.xmlcml.cml.base.IntSTAttribute;
import org.xmlcml.cml.base.StringSTAttribute;

// end of part 1
/** CLASS DOCUMENTATION */
public abstract class AbstractTable extends CMLElement {
    /** local name*/
    public final static String TAG = "table";
    /** constructor. */    public AbstractTable() {
        super("table");
    }
/** copy constructor.
* deep copy using XOM copy()
* @param old element to copy
*/
    public AbstractTable(AbstractTable old) {
        super((CMLElement) old);
    }
// attribute:   rows

    /** cache */
    IntSTAttribute _att_rows = null;
    /** Number of rows.
    * No description
    * @return CMLAttribute
    */
    public CMLAttribute getRowsAttribute() {
        return (CMLAttribute) getAttribute("rows");
    }
    /** Number of rows.
    * No description
    * @return int
    */
    public int getRows() {
        IntSTAttribute att = (IntSTAttribute) this.getRowsAttribute();
        if (att == null) {
            throw new RuntimeException("int attribute is unset: rows");
        }
        return att.getInt();
    }
    /** Number of rows.
    * No description
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setRows(String value) throws RuntimeException {
        IntSTAttribute att = null;
        if (_att_rows == null) {
            _att_rows = (IntSTAttribute) attributeFactory.getAttribute("rows", "table");
            if (_att_rows == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : rows probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new IntSTAttribute(_att_rows);
        super.addRemove(att, value);
    }
    /** Number of rows.
    * No description
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setRows(int value) throws RuntimeException {
        if (_att_rows == null) {
            _att_rows = (IntSTAttribute) attributeFactory.getAttribute("rows", "table");
           if (_att_rows == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : rows probably incompatible attributeGroupName and attributeName ");
            }
        }
        IntSTAttribute att = new IntSTAttribute(_att_rows);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// attribute:   columns

    /** cache */
    IntSTAttribute _att_columns = null;
    /** Number of columns.
    * No description
    * @return CMLAttribute
    */
    public CMLAttribute getColumnsAttribute() {
        return (CMLAttribute) getAttribute("columns");
    }
    /** Number of columns.
    * No description
    * @return int
    */
    public int getColumns() {
        IntSTAttribute att = (IntSTAttribute) this.getColumnsAttribute();
        if (att == null) {
            throw new RuntimeException("int attribute is unset: columns");
        }
        return att.getInt();
    }
    /** Number of columns.
    * No description
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setColumns(String value) throws RuntimeException {
        IntSTAttribute att = null;
        if (_att_columns == null) {
            _att_columns = (IntSTAttribute) attributeFactory.getAttribute("columns", "table");
            if (_att_columns == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : columns probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new IntSTAttribute(_att_columns);
        super.addRemove(att, value);
    }
    /** Number of columns.
    * No description
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setColumns(int value) throws RuntimeException {
        if (_att_columns == null) {
            _att_columns = (IntSTAttribute) attributeFactory.getAttribute("columns", "table");
           if (_att_columns == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : columns probably incompatible attributeGroupName and attributeName ");
            }
        }
        IntSTAttribute att = new IntSTAttribute(_att_columns);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// attribute:   units

    /** cache */
    UnitsAttribute _att_units = null;
    /** null
    * @return CMLAttribute
    */
    public CMLAttribute getUnitsAttribute() {
        return (CMLAttribute) getAttribute("units");
    }
    /** null
    * @return String
    */
    public String getUnits() {
        UnitsAttribute att = (UnitsAttribute) this.getUnitsAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** null
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setUnits(String value) throws RuntimeException {
        UnitsAttribute att = null;
        if (_att_units == null) {
            _att_units = (UnitsAttribute) attributeFactory.getAttribute("units", "table");
            if (_att_units == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : units probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new UnitsAttribute(_att_units);
        super.addRemove(att, value);
    }
// attribute:   tableType

    /** cache */
    StringSTAttribute _att_tabletype = null;
    /** type of table.
    * controls content
    * @return CMLAttribute
    */
    public CMLAttribute getTableTypeAttribute() {
        return (CMLAttribute) getAttribute("tableType");
    }
    /** type of table.
    * controls content
    * @return String
    */
    public String getTableType() {
        StringSTAttribute att = (StringSTAttribute) this.getTableTypeAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** type of table.
    * controls content
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setTableType(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_tabletype == null) {
            _att_tabletype = (StringSTAttribute) attributeFactory.getAttribute("tableType", "table");
            if (_att_tabletype == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : tableType probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_tabletype);
        super.addRemove(att, value);
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
            _att_title = (StringSTAttribute) attributeFactory.getAttribute("title", "table");
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
            _att_id = (IdAttribute) attributeFactory.getAttribute("id", "table");
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
            _att_convention = (StringSTAttribute) attributeFactory.getAttribute("convention", "table");
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
            _att_dictref = (DictRefAttribute) attributeFactory.getAttribute("dictRef", "table");
            if (_att_dictref == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : dictRef probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new DictRefAttribute(_att_dictref);
        super.addRemove(att, value);
    }
// element:   arrayList

    /** null
    * @param arrayList child to add
    */
    public void addArrayList(AbstractArrayList arrayList) {
        arrayList.detach();
        this.appendChild(arrayList);
    }
    /** null
    * @return CMLElements&lt;CMLArrayList&gt;
    */
    public CMLElements<CMLArrayList> getArrayListElements() {
        Elements elements = this.getChildElements("arrayList", CMLConstants.CML_NS);
        return new CMLElements<CMLArrayList>(elements);
    }
// element:   tableHeader

    /** null
    * @param tableHeader child to add
    */
    public void addTableHeader(AbstractTableHeader tableHeader) {
        tableHeader.detach();
        this.appendChild(tableHeader);
    }
    /** null
    * @return CMLElements&lt;CMLTableHeader&gt;
    */
    public CMLElements<CMLTableHeader> getTableHeaderElements() {
        Elements elements = this.getChildElements("tableHeader", CMLConstants.CML_NS);
        return new CMLElements<CMLTableHeader>(elements);
    }
// element:   tableRowList

    /** null
    * @param tableRowList child to add
    */
    public void addTableRowList(AbstractTableRowList tableRowList) {
        tableRowList.detach();
        this.appendChild(tableRowList);
    }
    /** null
    * @return CMLElements&lt;CMLTableRowList&gt;
    */
    public CMLElements<CMLTableRowList> getTableRowListElements() {
        Elements elements = this.getChildElements("tableRowList", CMLConstants.CML_NS);
        return new CMLElements<CMLTableRowList>(elements);
    }
// element:   tableContent

    /** null
    * @param tableContent child to add
    */
    public void addTableContent(AbstractTableContent tableContent) {
        tableContent.detach();
        this.appendChild(tableContent);
    }
    /** null
    * @return CMLElements&lt;CMLTableContent&gt;
    */
    public CMLElements<CMLTableContent> getTableContentElements() {
        Elements elements = this.getChildElements("tableContent", CMLConstants.CML_NS);
        return new CMLElements<CMLTableContent>(elements);
    }
    /** overrides addAttribute(Attribute)
     * reroutes calls to setFoo()
     * @param att  attribute
    */
    public void addAttribute(Attribute att) {
        String name = att.getLocalName();
        String value = att.getValue();
        if (name == null) {
        } else if (name.equals("rows")) {
            setRows(value);
        } else if (name.equals("columns")) {
            setColumns(value);
        } else if (name.equals("units")) {
            setUnits(value);
        } else if (name.equals("tableType")) {
            setTableType(value);
        } else if (name.equals("title")) {
            setTitle(value);
        } else if (name.equals("id")) {
            setId(value);
        } else if (name.equals("convention")) {
            setConvention(value);
        } else if (name.equals("dictRef")) {
            setDictRef(value);
	     } else {
            super.addAttribute(att);
        }
    }
}
