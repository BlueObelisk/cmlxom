package org.xmlcml.cml.element;


import nu.xom.Attribute;

import org.xmlcml.cml.attribute.IdAttribute;
import org.xmlcml.cml.attribute.UnitsAttribute;
import org.xmlcml.cml.base.CMLAttribute;
import org.xmlcml.cml.base.CMLElement;
import org.xmlcml.cml.base.DoubleSTAttribute;
import org.xmlcml.cml.base.IntSTAttribute;
import org.xmlcml.cml.base.StringSTAttribute;

// end of part 1
/** CLASS DOCUMENTATION */
public abstract class AbstractEntry extends CMLElement {
    /** local name*/
    public final static String TAG = "entry";
    /** constructor. */    public AbstractEntry() {
        super("entry");
    }
/** copy constructor.
* deep copy using XOM copy()
* @param old element to copy
*/
    public AbstractEntry(AbstractEntry old) {
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
            _att_title = (StringSTAttribute) attributeFactory.getAttribute("title", "entry");
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
            _att_id = (IdAttribute) attributeFactory.getAttribute("id", "entry");
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
            _att_convention = (StringSTAttribute) attributeFactory.getAttribute("convention", "entry");
            if (_att_convention == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : convention probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_convention);
        super.addRemove(att, value);
    }
// attribute:   dataType

    /** cache */
    StringSTAttribute _att_datatype = null;
    /** The data type of the object.
    * Normally applied to scalar/array
    *                 objects but may extend to more complex one.
    * @return CMLAttribute
    */
    public CMLAttribute getDataTypeAttribute() {
        return (CMLAttribute) getAttribute("dataType");
    }
    /** The data type of the object.
    * Normally applied to scalar/array
    *                 objects but may extend to more complex one.
    * @return String
    */
    public String getDataType() {
        StringSTAttribute att = (StringSTAttribute) this.getDataTypeAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /**
     * The data storage of the CMLElement created by the entry or entryTool.
     * @return CMLAttribute
     */
    public Attribute getDataStorageAttribute() {
        return getAttribute("dataStorage");
    }

    /**
     * The data storage of the CMLElement created by the entry or entryTool.
     * @return String
     */
    public String getDataStorage() {
        String att = this.getDataStorageAttribute().getValue();
        if (att == null) {
            return null;
        }
        return att;
    }
    /** The data type of the object.
    * Normally applied to scalar/array 
    *                 objects but may extend to more complex one.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setDataType(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_datatype == null) {
            _att_datatype = (StringSTAttribute) attributeFactory.getAttribute("dataType", "entry");
            if (_att_datatype == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : dataType probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_datatype);
        super.addRemove(att, value);
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
            _att_rows = (IntSTAttribute) attributeFactory.getAttribute("rows", "entry");
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
            _att_rows = (IntSTAttribute) attributeFactory.getAttribute("rows", "entry");
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
            _att_columns = (IntSTAttribute) attributeFactory.getAttribute("columns", "entry");
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
            _att_columns = (IntSTAttribute) attributeFactory.getAttribute("columns", "entry");
           if (_att_columns == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : columns probably incompatible attributeGroupName and attributeName ");
            }
        }
        IntSTAttribute att = new IntSTAttribute(_att_columns);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// attribute:   unitType

//    /** cache */
//    UnitTypeAttribute _att_unittype = null;
//    /** null
//    * @return CMLAttribute
//    */
//    public CMLAttribute getUnitTypeAttribute() {
//        return (CMLAttribute) getAttribute("unitType");
//    }
//    /** null
//    * @return String
//    */
//    public String getUnitType() {
//        UnitTypeAttribute att = (UnitTypeAttribute) this.getUnitTypeAttribute();
//        if (att == null) {
//            return null;
//        }
//        return att.getString();
//    }
//    /** null
//    * @param value title value
//    * @throws RuntimeException attribute wrong value/type
//    */
//    public void setUnitType(String value) throws RuntimeException {
//        UnitTypeAttribute att = null;
//        if (_att_unittype == null) {
//            _att_unittype = (UnitTypeAttribute) attributeFactory.getAttribute("unitType", "entry");
//            if (_att_unittype == null) {
//                throw new RuntimeException("BUG: cannot process attributeGroupName : unitType probably incompatible attributeGroupName and attributeName");
//            }
//        }
//        att = new UnitTypeAttribute(_att_unittype);
//        super.addRemove(att, value);
//    }
// attribute:   minExclusive

    /** cache */
    DoubleSTAttribute _att_minexclusive = null;
    /** minimum exclusive value.
    * by analogy with xsd:schema.
    * @return CMLAttribute
    */
    public CMLAttribute getMinExclusiveAttribute() {
        return (CMLAttribute) getAttribute("minExclusive");
    }
    /** minimum exclusive value.
    * by analogy with xsd:schema.
    * @return double
    */
    public double getMinExclusive() {
        DoubleSTAttribute att = (DoubleSTAttribute) this.getMinExclusiveAttribute();
        if (att == null) {
            return Double.NaN;
        }
        return att.getDouble();
    }
    /** minimum exclusive value.
    * by analogy with xsd:schema.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setMinExclusive(String value) throws RuntimeException {
        DoubleSTAttribute att = null;
        if (_att_minexclusive == null) {
            _att_minexclusive = (DoubleSTAttribute) attributeFactory.getAttribute("minExclusive", "entry");
            if (_att_minexclusive == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : minExclusive probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new DoubleSTAttribute(_att_minexclusive);
        super.addRemove(att, value);
    }
    /** minimum exclusive value.
    * by analogy with xsd:schema.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setMinExclusive(double value) throws RuntimeException {
        if (_att_minexclusive == null) {
            _att_minexclusive = (DoubleSTAttribute) attributeFactory.getAttribute("minExclusive", "entry");
           if (_att_minexclusive == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : minExclusive probably incompatible attributeGroupName and attributeName ");
            }
        }
        DoubleSTAttribute att = new DoubleSTAttribute(_att_minexclusive);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// attribute:   minInclusive

    /** cache */
    DoubleSTAttribute _att_mininclusive = null;
    /** minimum inclusive value.
    * by analogy with xsd:schema.
    * @return CMLAttribute
    */
    public CMLAttribute getMinInclusiveAttribute() {
        return (CMLAttribute) getAttribute("minInclusive");
    }
    /** minimum inclusive value.
    * by analogy with xsd:schema.
    * @return double
    */
    public double getMinInclusive() {
        DoubleSTAttribute att = (DoubleSTAttribute) this.getMinInclusiveAttribute();
        if (att == null) {
            return Double.NaN;
        }
        return att.getDouble();
    }
    /** minimum inclusive value.
    * by analogy with xsd:schema.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setMinInclusive(String value) throws RuntimeException {
        DoubleSTAttribute att = null;
        if (_att_mininclusive == null) {
            _att_mininclusive = (DoubleSTAttribute) attributeFactory.getAttribute("minInclusive", "entry");
            if (_att_mininclusive == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : minInclusive probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new DoubleSTAttribute(_att_mininclusive);
        super.addRemove(att, value);
    }
    /** minimum inclusive value.
    * by analogy with xsd:schema.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setMinInclusive(double value) throws RuntimeException {
        if (_att_mininclusive == null) {
            _att_mininclusive = (DoubleSTAttribute) attributeFactory.getAttribute("minInclusive", "entry");
           if (_att_mininclusive == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : minInclusive probably incompatible attributeGroupName and attributeName ");
            }
        }
        DoubleSTAttribute att = new DoubleSTAttribute(_att_mininclusive);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// attribute:   maxExclusive

    /** cache */
    DoubleSTAttribute _att_maxexclusive = null;
    /** maximum exclusive value.
    * by analogy with xsd:schema.
    * @return CMLAttribute
    */
    public CMLAttribute getMaxExclusiveAttribute() {
        return (CMLAttribute) getAttribute("maxExclusive");
    }
    /** maximum exclusive value.
    * by analogy with xsd:schema.
    * @return double
    */
    public double getMaxExclusive() {
        DoubleSTAttribute att = (DoubleSTAttribute) this.getMaxExclusiveAttribute();
        if (att == null) {
            return Double.NaN;
        }
        return att.getDouble();
    }
    /** maximum exclusive value.
    * by analogy with xsd:schema.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setMaxExclusive(String value) throws RuntimeException {
        DoubleSTAttribute att = null;
        if (_att_maxexclusive == null) {
            _att_maxexclusive = (DoubleSTAttribute) attributeFactory.getAttribute("maxExclusive", "entry");
            if (_att_maxexclusive == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : maxExclusive probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new DoubleSTAttribute(_att_maxexclusive);
        super.addRemove(att, value);
    }
    /** maximum exclusive value.
    * by analogy with xsd:schema.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setMaxExclusive(double value) throws RuntimeException {
        if (_att_maxexclusive == null) {
            _att_maxexclusive = (DoubleSTAttribute) attributeFactory.getAttribute("maxExclusive", "entry");
           if (_att_maxexclusive == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : maxExclusive probably incompatible attributeGroupName and attributeName ");
            }
        }
        DoubleSTAttribute att = new DoubleSTAttribute(_att_maxexclusive);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// attribute:   maxInclusive

    /** cache */
    DoubleSTAttribute _att_maxinclusive = null;
    /** minimum inclusive value.
    * by analogy with xsd:schem.
    * @return CMLAttribute
    */
    public CMLAttribute getMaxInclusiveAttribute() {
        return (CMLAttribute) getAttribute("maxInclusive");
    }
    /** minimum inclusive value.
    * by analogy with xsd:schem.
    * @return double
    */
    public double getMaxInclusive() {
        DoubleSTAttribute att = (DoubleSTAttribute) this.getMaxInclusiveAttribute();
        if (att == null) {
            return Double.NaN;
        }
        return att.getDouble();
    }
    /** minimum inclusive value.
    * by analogy with xsd:schem.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setMaxInclusive(String value) throws RuntimeException {
        DoubleSTAttribute att = null;
        if (_att_maxinclusive == null) {
            _att_maxinclusive = (DoubleSTAttribute) attributeFactory.getAttribute("maxInclusive", "entry");
            if (_att_maxinclusive == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : maxInclusive probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new DoubleSTAttribute(_att_maxinclusive);
        super.addRemove(att, value);
    }
    /** minimum inclusive value.
    * by analogy with xsd:schem.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setMaxInclusive(double value) throws RuntimeException {
        if (_att_maxinclusive == null) {
            _att_maxinclusive = (DoubleSTAttribute) attributeFactory.getAttribute("maxInclusive", "entry");
           if (_att_maxinclusive == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : maxInclusive probably incompatible attributeGroupName and attributeName ");
            }
        }
        DoubleSTAttribute att = new DoubleSTAttribute(_att_maxinclusive);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// attribute:   totalDigits

    /** cache */
    IntSTAttribute _att_totaldigits = null;
    /** total digits in a scalar.
    * based on xsd:schema.
    * @return CMLAttribute
    */
    public CMLAttribute getTotalDigitsAttribute() {
        return (CMLAttribute) getAttribute("totalDigits");
    }
    /** total digits in a scalar.
    * based on xsd:schema.
    * @return int
    */
    public int getTotalDigits() {
        IntSTAttribute att = (IntSTAttribute) this.getTotalDigitsAttribute();
        if (att == null) {
            throw new RuntimeException("int attribute is unset: totalDigits");
        }
        return att.getInt();
    }
    /** total digits in a scalar.
    * based on xsd:schema.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setTotalDigits(String value) throws RuntimeException {
        IntSTAttribute att = null;
        if (_att_totaldigits == null) {
            _att_totaldigits = (IntSTAttribute) attributeFactory.getAttribute("totalDigits", "entry");
            if (_att_totaldigits == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : totalDigits probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new IntSTAttribute(_att_totaldigits);
        super.addRemove(att, value);
    }
    /** total digits in a scalar.
    * based on xsd:schema.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setTotalDigits(int value) throws RuntimeException {
        if (_att_totaldigits == null) {
            _att_totaldigits = (IntSTAttribute) attributeFactory.getAttribute("totalDigits", "entry");
           if (_att_totaldigits == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : totalDigits probably incompatible attributeGroupName and attributeName ");
            }
        }
        IntSTAttribute att = new IntSTAttribute(_att_totaldigits);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// attribute:   fractionDigits

    /** cache */
    IntSTAttribute _att_fractiondigits = null;
    /** Number of digits after the point.
    * This is used in dictionaries to define precision. However it might be replaced by xsd:facet.
    * @return CMLAttribute
    */
    public CMLAttribute getFractionDigitsAttribute() {
        return (CMLAttribute) getAttribute("fractionDigits");
    }
    /** Number of digits after the point.
    * This is used in dictionaries to define precision. However it might be replaced by xsd:facet.
    * @return int
    */
    public int getFractionDigits() {
        IntSTAttribute att = (IntSTAttribute) this.getFractionDigitsAttribute();
        if (att == null) {
            throw new RuntimeException("int attribute is unset: fractionDigits");
        }
        return att.getInt();
    }
    /** Number of digits after the point.
    * This is used in dictionaries to define precision. However it might be replaced by xsd:facet.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setFractionDigits(String value) throws RuntimeException {
        IntSTAttribute att = null;
        if (_att_fractiondigits == null) {
            _att_fractiondigits = (IntSTAttribute) attributeFactory.getAttribute("fractionDigits", "entry");
            if (_att_fractiondigits == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : fractionDigits probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new IntSTAttribute(_att_fractiondigits);
        super.addRemove(att, value);
    }
    /** Number of digits after the point.
    * This is used in dictionaries to define precision. However it might be replaced by xsd:facet.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setFractionDigits(int value) throws RuntimeException {
        if (_att_fractiondigits == null) {
            _att_fractiondigits = (IntSTAttribute) attributeFactory.getAttribute("fractionDigits", "entry");
           if (_att_fractiondigits == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : fractionDigits probably incompatible attributeGroupName and attributeName ");
            }
        }
        IntSTAttribute att = new IntSTAttribute(_att_fractiondigits);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// attribute:   length

    /** cache */
    IntSTAttribute _att_length = null;
    /** Length of an array or .
    * Probably will be replaced with xsd:schema tool.
    *                 
    * @return CMLAttribute
    */
    public CMLAttribute getLengthAttribute() {
        return (CMLAttribute) getAttribute("length");
    }
    /** Length of an array or .
    * Probably will be replaced with xsd:schema tool.
    *                 
    * @return int
    */
    public int getLength() {
        IntSTAttribute att = (IntSTAttribute) this.getLengthAttribute();
        if (att == null) {
            throw new RuntimeException("int attribute is unset: length");
        }
        return att.getInt();
    }
    /** Length of an array or .
    * Probably will be replaced with xsd:schema tool.
    *                 
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setLength(String value) throws RuntimeException {
        IntSTAttribute att = null;
        if (_att_length == null) {
            _att_length = (IntSTAttribute) attributeFactory.getAttribute("length", "entry");
            if (_att_length == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : length probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new IntSTAttribute(_att_length);
        super.addRemove(att, value);
    }
    /** Length of an array or .
    * Probably will be replaced with xsd:schema tool.
    *                 
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setLength(int value) throws RuntimeException {
        if (_att_length == null) {
            _att_length = (IntSTAttribute) attributeFactory.getAttribute("length", "entry");
           if (_att_length == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : length probably incompatible attributeGroupName and attributeName ");
            }
        }
        IntSTAttribute att = new IntSTAttribute(_att_length);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// attribute:   minLength

    /** cache */
    IntSTAttribute _att_minlength = null;
    /** minimum length of a scalar.
    * by analogy with xsd:schema.
    * @return CMLAttribute
    */
    public CMLAttribute getMinLengthAttribute() {
        return (CMLAttribute) getAttribute("minLength");
    }
    /** minimum length of a scalar.
    * by analogy with xsd:schema.
    * @return int
    */
    public int getMinLength() {
        IntSTAttribute att = (IntSTAttribute) this.getMinLengthAttribute();
        if (att == null) {
            throw new RuntimeException("int attribute is unset: minLength");
        }
        return att.getInt();
    }
    /** minimum length of a scalar.
    * by analogy with xsd:schema.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setMinLength(String value) throws RuntimeException {
        IntSTAttribute att = null;
        if (_att_minlength == null) {
            _att_minlength = (IntSTAttribute) attributeFactory.getAttribute("minLength", "entry");
            if (_att_minlength == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : minLength probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new IntSTAttribute(_att_minlength);
        super.addRemove(att, value);
    }
    /** minimum length of a scalar.
    * by analogy with xsd:schema.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setMinLength(int value) throws RuntimeException {
        if (_att_minlength == null) {
            _att_minlength = (IntSTAttribute) attributeFactory.getAttribute("minLength", "entry");
           if (_att_minlength == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : minLength probably incompatible attributeGroupName and attributeName ");
            }
        }
        IntSTAttribute att = new IntSTAttribute(_att_minlength);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// attribute:   maxLength

    /** cache */
    IntSTAttribute _att_maxlength = null;
    /** maximum length of a scalar.
    * by analogy with xsd:schem.
    * @return CMLAttribute
    */
    public CMLAttribute getMaxLengthAttribute() {
        return (CMLAttribute) getAttribute("maxLength");
    }
    /** maximum length of a scalar.
    * by analogy with xsd:schem.
    * @return int
    */
    public int getMaxLength() {
        IntSTAttribute att = (IntSTAttribute) this.getMaxLengthAttribute();
        if (att == null) {
            throw new RuntimeException("int attribute is unset: maxLength");
        }
        return att.getInt();
    }
    /** maximum length of a scalar.
    * by analogy with xsd:schem.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setMaxLength(String value) throws RuntimeException {
        IntSTAttribute att = null;
        if (_att_maxlength == null) {
            _att_maxlength = (IntSTAttribute) attributeFactory.getAttribute("maxLength", "entry");
            if (_att_maxlength == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : maxLength probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new IntSTAttribute(_att_maxlength);
        super.addRemove(att, value);
    }
    /** maximum length of a scalar.
    * by analogy with xsd:schem.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setMaxLength(int value) throws RuntimeException {
        if (_att_maxlength == null) {
            _att_maxlength = (IntSTAttribute) attributeFactory.getAttribute("maxLength", "entry");
           if (_att_maxlength == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : maxLength probably incompatible attributeGroupName and attributeName ");
            }
        }
        IntSTAttribute att = new IntSTAttribute(_att_maxlength);
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
            _att_units = (UnitsAttribute) attributeFactory.getAttribute("units", "entry");
            if (_att_units == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : units probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new UnitsAttribute(_att_units);
        super.addRemove(att, value);
    }
// attribute:   whiteSpace

    /** cache */
    StringSTAttribute _att_whitespace = null;
    /** Whitespace.
    * Attached to entry. This may be obsolete.
    * @return CMLAttribute
    */
    public CMLAttribute getWhiteSpaceAttribute() {
        return (CMLAttribute) getAttribute("whiteSpace");
    }
    /** Whitespace.
    * Attached to entry. This may be obsolete.
    * @return String
    */
    public String getWhiteSpace() {
        StringSTAttribute att = (StringSTAttribute) this.getWhiteSpaceAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** Whitespace.
    * Attached to entry. This may be obsolete.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setWhiteSpace(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_whitespace == null) {
            _att_whitespace = (StringSTAttribute) attributeFactory.getAttribute("whiteSpace", "entry");
            if (_att_whitespace == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : whiteSpace probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_whitespace);
        super.addRemove(att, value);
    }
// attribute:   pattern

    /** cache */
    StringSTAttribute _att_pattern = null;
    /** Pattern constraint.
    * Based on xsd:schema.
    * @return CMLAttribute
    */
    public CMLAttribute getPatternAttribute() {
        return (CMLAttribute) getAttribute("pattern");
    }
    /** Pattern constraint.
    * Based on xsd:schema.
    * @return String
    */
    public String getPattern() {
        StringSTAttribute att = (StringSTAttribute) this.getPatternAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** Pattern constraint.
    * Based on xsd:schema.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setPattern(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_pattern == null) {
            _att_pattern = (StringSTAttribute) attributeFactory.getAttribute("pattern", "entry");
            if (_att_pattern == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : pattern probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_pattern);
        super.addRemove(att, value);
    }
// attribute:   term

    /** cache */
    StringSTAttribute _att_term = null;
    /** A term in a dictionary.
    * The term should be a noun or nounal phrase, with a separate definition and further description.
    * @return CMLAttribute
    */
    public CMLAttribute getTermAttribute() {
        return (CMLAttribute) getAttribute("term");
    }
    /** A term in a dictionary.
    * The term should be a noun or nounal phrase, with a separate definition and further description.
    * @return String
    */
    public String getTerm() {
        StringSTAttribute att = (StringSTAttribute) this.getTermAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** A term in a dictionary.
    * The term should be a noun or nounal phrase, with a separate definition and further description.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setTerm(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_term == null) {
            _att_term = (StringSTAttribute) attributeFactory.getAttribute("term", "entry");
            if (_att_term == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : term probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_term);
        super.addRemove(att, value);
    }
//// element:   metadataList
//
//    /** A term in a dictionary.
//    * The term should be a noun or nounal phrase, with a separate definition and further description.
//    * @param metadataList child to add
//    */
//    public void addMetadataList(AbstractMetadataList metadataList) {
//        metadataList.detach();
//        this.appendChild(metadataList);
//    }
//    /** A term in a dictionary.
//    * The term should be a noun or nounal phrase, with a separate definition and further description.
//    * @return CMLElements<CMLMetadataList>
//    */
//    public CMLElements<CMLMetadataList> getMetadataListElements() {
//        Elements elements = this.getChildElements("metadataList", CMLConstants.CML_NS);
//        return new CMLElements<CMLMetadataList>(elements);
//    }
//// element:   annotation
//
//    /** A term in a dictionary.
//    * The term should be a noun or nounal phrase, with a separate definition and further description.
//    * @param annotation child to add
//    */
//    public void addAnnotation(AbstractAnnotation annotation) {
//        annotation.detach();
//        this.appendChild(annotation);
//    }
//    /** A term in a dictionary.
//    * The term should be a noun or nounal phrase, with a separate definition and further description.
//    * @return CMLElements<CMLAnnotation>
//    */
//    public CMLElements<CMLAnnotation> getAnnotationElements() {
//        Elements elements = this.getChildElements("annotation", CMLConstants.CML_NS);
//        return new CMLElements<CMLAnnotation>(elements);
//    }
//// element:   definition
//
//    /** A term in a dictionary.
//    * The term should be a noun or nounal phrase, with a separate definition and further description.
//    * @param definition child to add
//    */
//    public void addDefinition(AbstractDefinition definition) {
//        definition.detach();
//        this.appendChild(definition);
//    }
//    /** A term in a dictionary.
//    * The term should be a noun or nounal phrase, with a separate definition and further description.
//    * @return CMLElements<CMLDefinition>
//    */
//    public CMLElements<CMLDefinition> getDefinitionElements() {
//        Elements elements = this.getChildElements("definition", CMLConstants.CML_NS);
//        return new CMLElements<CMLDefinition>(elements);
//    }
//// element:   description
//
//    /** A term in a dictionary.
//    * The term should be a noun or nounal phrase, with a separate definition and further description.
//    * @param description child to add
//    */
//    public void addDescription(AbstractDescription description) {
//        description.detach();
//        this.appendChild(description);
//    }
//    /** A term in a dictionary.
//    * The term should be a noun or nounal phrase, with a separate definition and further description.
//    * @return CMLElements<CMLDescription>
//    */
//    public CMLElements<CMLDescription> getDescriptionElements() {
//        Elements elements = this.getChildElements("description", CMLConstants.CML_NS);
//        return new CMLElements<CMLDescription>(elements);
//    }
//// element:   enumeration
//
//    /** A term in a dictionary.
//    * The term should be a noun or nounal phrase, with a separate definition and further description.
//    * @param enumeration child to add
//    */
//    public void addEnumeration(AbstractEnumeration enumeration) {
//        enumeration.detach();
//        this.appendChild(enumeration);
//    }
//    /** A term in a dictionary.
//    * The term should be a noun or nounal phrase, with a separate definition and further description.
//    * @return CMLElements<CMLEnumeration>
//    */
//    public CMLElements<CMLEnumeration> getEnumerationElements() {
//        Elements elements = this.getChildElements("enumeration", CMLConstants.CML_NS);
//        return new CMLElements<CMLEnumeration>(elements);
//    }
//// element:   unitType
//
//    /** A term in a dictionary.
//    * The term should be a noun or nounal phrase, with a separate definition and further description.
//    * @param unitType child to add
//    */
//    public void addUnitType(AbstractUnitType unitType) {
//        unitType.detach();
//        this.appendChild(unitType);
//    }
//    /** A term in a dictionary.
//    * The term should be a noun or nounal phrase, with a separate definition and further description.
//    * @return CMLElements<CMLUnitType>
//    */
//    public CMLElements<CMLUnitType> getUnitTypeElements() {
//        Elements elements = this.getChildElements("unitType", CMLConstants.CML_NS);
//        return new CMLElements<CMLUnitType>(elements);
//    }
//// element:   alternative
//
//    /** A term in a dictionary.
//    * The term should be a noun or nounal phrase, with a separate definition and further description.
//    * @param alternative child to add
//    */
//    public void addAlternative(AbstractAlternative alternative) {
//        alternative.detach();
//        this.appendChild(alternative);
//    }
//    /** A term in a dictionary.
//    * The term should be a noun or nounal phrase, with a separate definition and further description.
//    * @return CMLElements<CMLAlternative>
//    */
//    public CMLElements<CMLAlternative> getAlternativeElements() {
//        Elements elements = this.getChildElements("alternative", CMLConstants.CML_NS);
//        return new CMLElements<CMLAlternative>(elements);
//    }
//// element:   relatedEntry
//
//    /** A term in a dictionary.
//    * The term should be a noun or nounal phrase, with a separate definition and further description.
//    * @param relatedEntry child to add
//    */
//    public void addRelatedEntry(AbstractRelatedEntry relatedEntry) {
//        relatedEntry.detach();
//        this.appendChild(relatedEntry);
//    }
//    /** A term in a dictionary.
//    * The term should be a noun or nounal phrase, with a separate definition and further description.
//    * @return CMLElements<CMLRelatedEntry>
//    */
//    public CMLElements<CMLRelatedEntry> getRelatedEntryElements() {
//        Elements elements = this.getChildElements("relatedEntry", CMLConstants.CML_NS);
//        return new CMLElements<CMLRelatedEntry>(elements);
//    }
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
        } else if (name.equals("dataType")) {
            setDataType(value);
        } else if (name.equals("rows")) {
            setRows(value);
        } else if (name.equals("columns")) {
            setColumns(value);
//        } else if (name.equals("unitType")) {
//            setUnitType(value);
        } else if (name.equals("minExclusive")) {
            setMinExclusive(value);
        } else if (name.equals("minInclusive")) {
            setMinInclusive(value);
        } else if (name.equals("maxExclusive")) {
            setMaxExclusive(value);
        } else if (name.equals("maxInclusive")) {
            setMaxInclusive(value);
        } else if (name.equals("totalDigits")) {
            setTotalDigits(value);
        } else if (name.equals("fractionDigits")) {
            setFractionDigits(value);
        } else if (name.equals("length")) {
            setLength(value);
        } else if (name.equals("minLength")) {
            setMinLength(value);
        } else if (name.equals("maxLength")) {
            setMaxLength(value);
        } else if (name.equals("units")) {
            setUnits(value);
        } else if (name.equals("whiteSpace")) {
            setWhiteSpace(value);
        } else if (name.equals("pattern")) {
            setPattern(value);
        } else if (name.equals("term")) {
            setTerm(value);
        } else {
            try {
                super.addAttribute(att);
            } catch (Exception e) {
                throw new RuntimeException("Bad attribute: " + att.getQualifiedName() + "/" + att.getValue());
            }
        }
    }
}
