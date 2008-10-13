package org.xmlcml.cml.element.main;


import nu.xom.Attribute;

import org.xmlcml.cml.attribute.DelimiterAttribute;
import org.xmlcml.cml.attribute.DictRefAttribute;
import org.xmlcml.cml.attribute.IdAttribute;
import org.xmlcml.cml.attribute.UnitsAttribute;
import org.xmlcml.cml.base.CMLAttribute;
import org.xmlcml.cml.base.CMLElement;
import org.xmlcml.cml.base.DoubleArraySTAttribute;
import org.xmlcml.cml.base.IntSTAttribute;
import org.xmlcml.cml.base.StringSTAttribute;

// end of part 1
/** CLASS DOCUMENTATION */
public abstract class AbstractMatrix extends CMLElement {
    /** local name*/
    public final static String TAG = "matrix";
    /** constructor. */    public AbstractMatrix() {
        super("matrix");
    }
/** copy constructor.
* deep copy using XOM copy()
* @param old element to copy
*/
    public AbstractMatrix(AbstractMatrix old) {
        super((CMLElement) old);
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
    /** The data type of the object.
    * Normally applied to scalar/array 
    *                 objects but may extend to more complex one.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setDataType(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_datatype == null) {
            _att_datatype = (StringSTAttribute) attributeFactory.getAttribute("dataType", "matrix");
            if (_att_datatype == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : dataType probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_datatype);
        super.addRemove(att, value);
    }
// attribute:   delimiter

    /** cache */
    DelimiterAttribute _att_delimiter = null;
    /** null
    * @return CMLAttribute
    */
    public CMLAttribute getDelimiterAttribute() {
        return (CMLAttribute) getAttribute("delimiter");
    }
    /** null
    * @return String
    */
    public String getDelimiter() {
        DelimiterAttribute att = (DelimiterAttribute) this.getDelimiterAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** null
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setDelimiter(String value) throws RuntimeException {
        DelimiterAttribute att = null;
        if (_att_delimiter == null) {
            _att_delimiter = (DelimiterAttribute) attributeFactory.getAttribute("delimiter", "matrix");
            if (_att_delimiter == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : delimiter probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new DelimiterAttribute(_att_delimiter);
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
            _att_rows = (IntSTAttribute) attributeFactory.getAttribute("rows", "matrix");
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
            _att_rows = (IntSTAttribute) attributeFactory.getAttribute("rows", "matrix");
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
            _att_columns = (IntSTAttribute) attributeFactory.getAttribute("columns", "matrix");
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
            _att_columns = (IntSTAttribute) attributeFactory.getAttribute("columns", "matrix");
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
            _att_units = (UnitsAttribute) attributeFactory.getAttribute("units", "matrix");
            if (_att_units == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : units probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new UnitsAttribute(_att_units);
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
            _att_title = (StringSTAttribute) attributeFactory.getAttribute("title", "matrix");
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
            _att_id = (IdAttribute) attributeFactory.getAttribute("id", "matrix");
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
            _att_convention = (StringSTAttribute) attributeFactory.getAttribute("convention", "matrix");
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
            _att_dictref = (DictRefAttribute) attributeFactory.getAttribute("dictRef", "matrix");
            if (_att_dictref == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : dictRef probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new DictRefAttribute(_att_dictref);
        super.addRemove(att, value);
    }
// attribute:   matrixType

    /** cache */
    StringSTAttribute _att_matrixtype = null;
    /** Type of matrix.
    * Mainly square, but extensible through the _xsd:union_ mechanis.
    * @return CMLAttribute
    */
    public CMLAttribute getMatrixTypeAttribute() {
        return (CMLAttribute) getAttribute("matrixType");
    }
    /** Type of matrix.
    * Mainly square, but extensible through the _xsd:union_ mechanis.
    * @return String
    */
    public String getMatrixType() {
        StringSTAttribute att = (StringSTAttribute) this.getMatrixTypeAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** Type of matrix.
    * Mainly square, but extensible through the _xsd:union_ mechanis.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setMatrixType(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_matrixtype == null) {
            _att_matrixtype = (StringSTAttribute) attributeFactory.getAttribute("matrixType", "matrix");
            if (_att_matrixtype == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : matrixType probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_matrixtype);
        super.addRemove(att, value);
    }
// attribute:   errorValueArray

    /** cache */
    DoubleArraySTAttribute _att_errorvaluearray = null;
    /** Array of error values.
    * Reports the author's estimate of 
    * 					the error in an array of values. Only meaningful for 
    * 					dataTypes mapping to real number.
    * @return CMLAttribute
    */
    public CMLAttribute getErrorValueArrayAttribute() {
        return (CMLAttribute) getAttribute("errorValueArray");
    }
    /** Array of error values.
    * Reports the author's estimate of 
    * 					the error in an array of values. Only meaningful for 
    * 					dataTypes mapping to real number.
    * @return double[]
    */
    public double[] getErrorValueArray() {
        DoubleArraySTAttribute att = (DoubleArraySTAttribute) this.getErrorValueArrayAttribute();
        if (att == null) {
            return null;
        }
        return att.getDoubleArray();
    }
    /** Array of error values.
    * Reports the author's estimate of 
    * 					the error in an array of values. Only meaningful for 
    * 					dataTypes mapping to real number.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setErrorValueArray(String value) throws RuntimeException {
        DoubleArraySTAttribute att = null;
        if (_att_errorvaluearray == null) {
            _att_errorvaluearray = (DoubleArraySTAttribute) attributeFactory.getAttribute("errorValueArray", "matrix");
            if (_att_errorvaluearray == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : errorValueArray probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new DoubleArraySTAttribute(_att_errorvaluearray);
        super.addRemove(att, value);
    }
    /** Array of error values.
    * Reports the author's estimate of 
    * 					the error in an array of values. Only meaningful for 
    * 					dataTypes mapping to real number.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setErrorValueArray(double[] value) throws RuntimeException {
        if (_att_errorvaluearray == null) {
            _att_errorvaluearray = (DoubleArraySTAttribute) attributeFactory.getAttribute("errorValueArray", "matrix");
           if (_att_errorvaluearray == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : errorValueArray probably incompatible attributeGroupName and attributeName ");
            }
        }
        DoubleArraySTAttribute att = new DoubleArraySTAttribute(_att_errorvaluearray);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// attribute:   errorBasis

    /** cache */
    StringSTAttribute _att_errorbasis = null;
    /** Basis of the error estimate.
    * 
    * @return CMLAttribute
    */
    public CMLAttribute getErrorBasisAttribute() {
        return (CMLAttribute) getAttribute("errorBasis");
    }
    /** Basis of the error estimate.
    * 
    * @return String
    */
    public String getErrorBasis() {
        StringSTAttribute att = (StringSTAttribute) this.getErrorBasisAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** Basis of the error estimate.
    * 
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setErrorBasis(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_errorbasis == null) {
            _att_errorbasis = (StringSTAttribute) attributeFactory.getAttribute("errorBasis", "matrix");
            if (_att_errorbasis == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : errorBasis probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_errorbasis);
        super.addRemove(att, value);
    }
// attribute:   minValueArray

    /** cache */
    DoubleArraySTAttribute _att_minvaluearray = null;
    /** Minimum values for numeric _matrix_ or _array.
    * A whitespace-separated lists of the same length as the array in the parent element.
    * @return CMLAttribute
    */
    public CMLAttribute getMinValueArrayAttribute() {
        return (CMLAttribute) getAttribute("minValueArray");
    }
    /** Minimum values for numeric _matrix_ or _array.
    * A whitespace-separated lists of the same length as the array in the parent element.
    * @return double[]
    */
    public double[] getMinValueArray() {
        DoubleArraySTAttribute att = (DoubleArraySTAttribute) this.getMinValueArrayAttribute();
        if (att == null) {
            return null;
        }
        return att.getDoubleArray();
    }
    /** Minimum values for numeric _matrix_ or _array.
    * A whitespace-separated lists of the same length as the array in the parent element.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setMinValueArray(String value) throws RuntimeException {
        DoubleArraySTAttribute att = null;
        if (_att_minvaluearray == null) {
            _att_minvaluearray = (DoubleArraySTAttribute) attributeFactory.getAttribute("minValueArray", "matrix");
            if (_att_minvaluearray == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : minValueArray probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new DoubleArraySTAttribute(_att_minvaluearray);
        super.addRemove(att, value);
    }
    /** Minimum values for numeric _matrix_ or _array.
    * A whitespace-separated lists of the same length as the array in the parent element.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setMinValueArray(double[] value) throws RuntimeException {
        if (_att_minvaluearray == null) {
            _att_minvaluearray = (DoubleArraySTAttribute) attributeFactory.getAttribute("minValueArray", "matrix");
           if (_att_minvaluearray == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : minValueArray probably incompatible attributeGroupName and attributeName ");
            }
        }
        DoubleArraySTAttribute att = new DoubleArraySTAttribute(_att_minvaluearray);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// attribute:   maxValueArray

    /** cache */
    DoubleArraySTAttribute _att_maxvaluearray = null;
    /** Maximum values for numeric _matrix_ or _array.
    * A whitespace-separated list of the same length as the array in the parent element.
    * @return CMLAttribute
    */
    public CMLAttribute getMaxValueArrayAttribute() {
        return (CMLAttribute) getAttribute("maxValueArray");
    }
    /** Maximum values for numeric _matrix_ or _array.
    * A whitespace-separated list of the same length as the array in the parent element.
    * @return double[]
    */
    public double[] getMaxValueArray() {
        DoubleArraySTAttribute att = (DoubleArraySTAttribute) this.getMaxValueArrayAttribute();
        if (att == null) {
            return null;
        }
        return att.getDoubleArray();
    }
    /** Maximum values for numeric _matrix_ or _array.
    * A whitespace-separated list of the same length as the array in the parent element.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setMaxValueArray(String value) throws RuntimeException {
        DoubleArraySTAttribute att = null;
        if (_att_maxvaluearray == null) {
            _att_maxvaluearray = (DoubleArraySTAttribute) attributeFactory.getAttribute("maxValueArray", "matrix");
            if (_att_maxvaluearray == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : maxValueArray probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new DoubleArraySTAttribute(_att_maxvaluearray);
        super.addRemove(att, value);
    }
    /** Maximum values for numeric _matrix_ or _array.
    * A whitespace-separated list of the same length as the array in the parent element.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setMaxValueArray(double[] value) throws RuntimeException {
        if (_att_maxvaluearray == null) {
            _att_maxvaluearray = (DoubleArraySTAttribute) attributeFactory.getAttribute("maxValueArray", "matrix");
           if (_att_maxvaluearray == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : maxValueArray probably incompatible attributeGroupName and attributeName ");
            }
        }
        DoubleArraySTAttribute att = new DoubleArraySTAttribute(_att_maxvaluearray);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
    StringSTAttribute _xmlContent;
    /** 
    * 
    * @return String
    */
    public String getXMLContent() {
        String content = this.getValue();
        if (_xmlContent == null) {
            _xmlContent = new StringSTAttribute("_xmlContent");
        }
        _xmlContent.setCMLValue(content);
        return _xmlContent.getString();
    }
    /** 
    * 
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setXMLContent(String value) throws RuntimeException {
        if (_xmlContent == null) {
            _xmlContent = new StringSTAttribute("_xmlContent");
        }
        _xmlContent.setCMLValue(value);
        String attval = _xmlContent.getValue();
        this.removeChildren();
        this.appendChild(attval);
    }
    /** overrides addAttribute(Attribute)
     * reroutes calls to setFoo()
     * @param att  attribute
    */
    public void addAttribute(Attribute att) {
        String name = att.getLocalName();
        String value = att.getValue();
        if (name == null) {
        } else if (name.equals("dataType")) {
            setDataType(value);
        } else if (name.equals("delimiter")) {
            setDelimiter(value);
        } else if (name.equals("rows")) {
            setRows(value);
        } else if (name.equals("columns")) {
            setColumns(value);
        } else if (name.equals("units")) {
            setUnits(value);
        } else if (name.equals("title")) {
            setTitle(value);
        } else if (name.equals("id")) {
            setId(value);
        } else if (name.equals("convention")) {
            setConvention(value);
        } else if (name.equals("dictRef")) {
            setDictRef(value);
        } else if (name.equals("matrixType")) {
            setMatrixType(value);
        } else if (name.equals("errorValueArray")) {
            setErrorValueArray(value);
        } else if (name.equals("errorBasis")) {
            setErrorBasis(value);
        } else if (name.equals("minValueArray")) {
            setMinValueArray(value);
        } else if (name.equals("maxValueArray")) {
            setMaxValueArray(value);
	     } else {
            super.addAttribute(att);
        }
    }
}
