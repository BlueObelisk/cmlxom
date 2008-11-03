package org.xmlcml.cml.element;


import nu.xom.Attribute;
import nu.xom.Elements;

import org.xmlcml.cml.attribute.DictRefAttribute;
import org.xmlcml.cml.attribute.IdAttribute;
import org.xmlcml.cml.attribute.RefAttribute;
import org.xmlcml.cml.base.CMLAttribute;
import org.xmlcml.cml.base.CMLElement;
import org.xmlcml.cml.base.CMLElements;
import org.xmlcml.cml.base.DoubleSTAttribute;
import org.xmlcml.cml.base.StringArraySTAttribute;
import org.xmlcml.cml.base.StringSTAttribute;

// end of part 1
/** CLASS DOCUMENTATION */
public abstract class AbstractPeak extends CMLElement {
    /** local name*/
    public final static String TAG = "peak";
    /** constructor. */    public AbstractPeak() {
        super("peak");
    }
/** copy constructor.
* deep copy using XOM copy()
* @param old element to copy
*/
    public AbstractPeak(AbstractPeak old) {
        super((CMLElement) old);
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
            _att_dictref = (DictRefAttribute) attributeFactory.getAttribute("dictRef", "peak");
            if (_att_dictref == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : dictRef probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new DictRefAttribute(_att_dictref);
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
            _att_convention = (StringSTAttribute) attributeFactory.getAttribute("convention", "peak");
            if (_att_convention == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : convention probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_convention);
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
            _att_title = (StringSTAttribute) attributeFactory.getAttribute("title", "peak");
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
            _att_id = (IdAttribute) attributeFactory.getAttribute("id", "peak");
            if (_att_id == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : id probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new IdAttribute(_att_id);
        super.addRemove(att, value);
    }
// attribute:   ref

    /** cache */
    RefAttribute _att_ref = null;
    /** null
    * @return CMLAttribute
    */
    public CMLAttribute getRefAttribute() {
        return (CMLAttribute) getAttribute("ref");
    }
    /** null
    * @return String
    */
    public String getRef() {
        RefAttribute att = (RefAttribute) this.getRefAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** null
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setRef(String value) throws RuntimeException {
        RefAttribute att = null;
        if (_att_ref == null) {
            _att_ref = (RefAttribute) attributeFactory.getAttribute("ref", "peak");
            if (_att_ref == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : ref probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new RefAttribute(_att_ref);
        super.addRemove(att, value);
    }
// attribute:   peakHeight

    /** cache */
    DoubleSTAttribute _att_peakheight = null;
    /** Height of a peak.
    * For 1-dimensional data 
    *                 (e.g. y vs x) hould use the same units as the appropriate 
    *                 axis (e.g. y).
    * @return CMLAttribute
    */
    public CMLAttribute getPeakHeightAttribute() {
        return (CMLAttribute) getAttribute("peakHeight");
    }
    /** Height of a peak.
    * For 1-dimensional data 
    *                 (e.g. y vs x) hould use the same units as the appropriate 
    *                 axis (e.g. y).
    * @return double
    */
    public double getPeakHeight() {
        DoubleSTAttribute att = (DoubleSTAttribute) this.getPeakHeightAttribute();
        if (att == null) {
            return Double.NaN;
        }
        return att.getDouble();
    }
    /** Height of a peak.
    * For 1-dimensional data 
    *                 (e.g. y vs x) hould use the same units as the appropriate 
    *                 axis (e.g. y).
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setPeakHeight(String value) throws RuntimeException {
        DoubleSTAttribute att = null;
        if (_att_peakheight == null) {
            _att_peakheight = (DoubleSTAttribute) attributeFactory.getAttribute("peakHeight", "peak");
            if (_att_peakheight == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : peakHeight probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new DoubleSTAttribute(_att_peakheight);
        super.addRemove(att, value);
    }
    /** Height of a peak.
    * For 1-dimensional data 
    *                 (e.g. y vs x) hould use the same units as the appropriate 
    *                 axis (e.g. y).
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setPeakHeight(double value) throws RuntimeException {
        if (_att_peakheight == null) {
            _att_peakheight = (DoubleSTAttribute) attributeFactory.getAttribute("peakHeight", "peak");
           if (_att_peakheight == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : peakHeight probably incompatible attributeGroupName and attributeName ");
            }
        }
        DoubleSTAttribute att = new DoubleSTAttribute(_att_peakheight);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// attribute:   peakMultiplicity

    /** cache */
    StringSTAttribute _att_peakmultiplicity = null;
    /** Multiplicity of a peak.
    * Uses a semi-controlled vocabulary.
    * @return CMLAttribute
    */
    public CMLAttribute getPeakMultiplicityAttribute() {
        return (CMLAttribute) getAttribute("peakMultiplicity");
    }
    /** Multiplicity of a peak.
    * Uses a semi-controlled vocabulary.
    * @return String
    */
    public String getPeakMultiplicity() {
        StringSTAttribute att = (StringSTAttribute) this.getPeakMultiplicityAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** Multiplicity of a peak.
    * Uses a semi-controlled vocabulary.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setPeakMultiplicity(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_peakmultiplicity == null) {
            _att_peakmultiplicity = (StringSTAttribute) attributeFactory.getAttribute("peakMultiplicity", "peak");
            if (_att_peakmultiplicity == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : peakMultiplicity probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_peakmultiplicity);
        super.addRemove(att, value);
    }
// attribute:   peakShape

    /** cache */
    StringSTAttribute _att_peakshape = null;
    /** Shape of a peak.
    * Semi-controlled vocabulary such as broad or sharp.
    * @return CMLAttribute
    */
    public CMLAttribute getPeakShapeAttribute() {
        return (CMLAttribute) getAttribute("peakShape");
    }
    /** Shape of a peak.
    * Semi-controlled vocabulary such as broad or sharp.
    * @return String
    */
    public String getPeakShape() {
        StringSTAttribute att = (StringSTAttribute) this.getPeakShapeAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** Shape of a peak.
    * Semi-controlled vocabulary such as broad or sharp.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setPeakShape(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_peakshape == null) {
            _att_peakshape = (StringSTAttribute) attributeFactory.getAttribute("peakShape", "peak");
            if (_att_peakshape == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : peakShape probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_peakshape);
        super.addRemove(att, value);
    }
// attribute:   integral

    /** cache */
    StringSTAttribute _att_integral = null;
    /** Area under a peak.
    * Unfortunately units are usually arbitrary and not related to the x- and y- axis units, and in this case _peakUnits_ should be use.
    * @return CMLAttribute
    */
    public CMLAttribute getIntegralAttribute() {
        return (CMLAttribute) getAttribute("integral");
    }
    /** Area under a peak.
    * Unfortunately units are usually arbitrary and not related to the x- and y- axis units, and in this case _peakUnits_ should be use.
    * @return String
    */
    public String getIntegral() {
        StringSTAttribute att = (StringSTAttribute) this.getIntegralAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** Area under a peak.
    * Unfortunately units are usually arbitrary and not related to the x- and y- axis units, and in this case _peakUnits_ should be use.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setIntegral(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_integral == null) {
            _att_integral = (StringSTAttribute) attributeFactory.getAttribute("integral", "peak");
            if (_att_integral == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : integral probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_integral);
        super.addRemove(att, value);
    }
// attribute:   peakUnits

    /** cache */
    StringSTAttribute _att_peakunits = null;
    /** Units for a peak or peak integral.
    * For 2-dimensional spectra the units represent the observation. For an integral they are usually arbitrary and not related to the x- and y- axis units. Thus NMR spectra may use hydrogen count as the units for the peak area.
    * @return CMLAttribute
    */
    public CMLAttribute getPeakUnitsAttribute() {
        return (CMLAttribute) getAttribute("peakUnits");
    }
    /** Units for a peak or peak integral.
    * For 2-dimensional spectra the units represent the observation. For an integral they are usually arbitrary and not related to the x- and y- axis units. Thus NMR spectra may use hydrogen count as the units for the peak area.
    * @return String
    */
    public String getPeakUnits() {
        StringSTAttribute att = (StringSTAttribute) this.getPeakUnitsAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** Units for a peak or peak integral.
    * For 2-dimensional spectra the units represent the observation. For an integral they are usually arbitrary and not related to the x- and y- axis units. Thus NMR spectra may use hydrogen count as the units for the peak area.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setPeakUnits(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_peakunits == null) {
            _att_peakunits = (StringSTAttribute) attributeFactory.getAttribute("peakUnits", "peak");
            if (_att_peakunits == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : peakUnits probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_peakunits);
        super.addRemove(att, value);
    }
// attribute:   xMin

    /** cache */
    DoubleSTAttribute _att_xmin = null;
    /** Minimum xValue.
    * Annotates x-axis data with a minimum 
    *                 value. This need not be algorithmically deducible from the data 
    *                 and is typically used for the extent of a _peak_ or _peakGroup_. 
    *                 It uses xUnits or the same units as the data. There may or may not 
    *                 be a _xMax_ attribute but if so xMin should be less than or equals 
    *                 to it.
    * @return CMLAttribute
    */
    public CMLAttribute getXMinAttribute() {
        return (CMLAttribute) getAttribute("xMin");
    }
    /** Minimum xValue.
    * Annotates x-axis data with a minimum 
    *                 value. This need not be algorithmically deducible from the data 
    *                 and is typically used for the extent of a _peak_ or _peakGroup_. 
    *                 It uses xUnits or the same units as the data. There may or may not 
    *                 be a _xMax_ attribute but if so xMin should be less than or equals 
    *                 to it.
    * @return double
    */
    public double getXMin() {
        DoubleSTAttribute att = (DoubleSTAttribute) this.getXMinAttribute();
        if (att == null) {
            return Double.NaN;
        }
        return att.getDouble();
    }
    /** Minimum xValue.
    * Annotates x-axis data with a minimum 
    *                 value. This need not be algorithmically deducible from the data 
    *                 and is typically used for the extent of a _peak_ or _peakGroup_. 
    *                 It uses xUnits or the same units as the data. There may or may not 
    *                 be a _xMax_ attribute but if so xMin should be less than or equals 
    *                 to it.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setXMin(String value) throws RuntimeException {
        DoubleSTAttribute att = null;
        if (_att_xmin == null) {
            _att_xmin = (DoubleSTAttribute) attributeFactory.getAttribute("xMin", "peak");
            if (_att_xmin == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : xMin probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new DoubleSTAttribute(_att_xmin);
        super.addRemove(att, value);
    }
    /** Minimum xValue.
    * Annotates x-axis data with a minimum 
    *                 value. This need not be algorithmically deducible from the data 
    *                 and is typically used for the extent of a _peak_ or _peakGroup_. 
    *                 It uses xUnits or the same units as the data. There may or may not 
    *                 be a _xMax_ attribute but if so xMin should be less than or equals 
    *                 to it.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setXMin(double value) throws RuntimeException {
        if (_att_xmin == null) {
            _att_xmin = (DoubleSTAttribute) attributeFactory.getAttribute("xMin", "peak");
           if (_att_xmin == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : xMin probably incompatible attributeGroupName and attributeName ");
            }
        }
        DoubleSTAttribute att = new DoubleSTAttribute(_att_xmin);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// attribute:   xMax

    /** cache */
    DoubleSTAttribute _att_xmax = null;
    /** Maximum xValue.
    * Annotates x-axis data with a maximum 
    *                 value. This need not be algorithmically deducible from the data 
    *                 and is typically used for the extent of a _peak_ or _peakGroup_. 
    *                 It uses xUnits or the same units as the data. There may or may not 
    *                 be a _xMin_ attribute but if so xMax should be greater than or 
    *                 equals to it.
    * @return CMLAttribute
    */
    public CMLAttribute getXMaxAttribute() {
        return (CMLAttribute) getAttribute("xMax");
    }
    /** Maximum xValue.
    * Annotates x-axis data with a maximum 
    *                 value. This need not be algorithmically deducible from the data 
    *                 and is typically used for the extent of a _peak_ or _peakGroup_. 
    *                 It uses xUnits or the same units as the data. There may or may not 
    *                 be a _xMin_ attribute but if so xMax should be greater than or 
    *                 equals to it.
    * @return double
    */
    public double getXMax() {
        DoubleSTAttribute att = (DoubleSTAttribute) this.getXMaxAttribute();
        if (att == null) {
            return Double.NaN;
        }
        return att.getDouble();
    }
    /** Maximum xValue.
    * Annotates x-axis data with a maximum 
    *                 value. This need not be algorithmically deducible from the data 
    *                 and is typically used for the extent of a _peak_ or _peakGroup_. 
    *                 It uses xUnits or the same units as the data. There may or may not 
    *                 be a _xMin_ attribute but if so xMax should be greater than or 
    *                 equals to it.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setXMax(String value) throws RuntimeException {
        DoubleSTAttribute att = null;
        if (_att_xmax == null) {
            _att_xmax = (DoubleSTAttribute) attributeFactory.getAttribute("xMax", "peak");
            if (_att_xmax == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : xMax probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new DoubleSTAttribute(_att_xmax);
        super.addRemove(att, value);
    }
    /** Maximum xValue.
    * Annotates x-axis data with a maximum 
    *                 value. This need not be algorithmically deducible from the data 
    *                 and is typically used for the extent of a _peak_ or _peakGroup_. 
    *                 It uses xUnits or the same units as the data. There may or may not 
    *                 be a _xMin_ attribute but if so xMax should be greater than or 
    *                 equals to it.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setXMax(double value) throws RuntimeException {
        if (_att_xmax == null) {
            _att_xmax = (DoubleSTAttribute) attributeFactory.getAttribute("xMax", "peak");
           if (_att_xmax == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : xMax probably incompatible attributeGroupName and attributeName ");
            }
        }
        DoubleSTAttribute att = new DoubleSTAttribute(_att_xmax);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// attribute:   xValue

    /** cache */
    DoubleSTAttribute _att_xvalue = null;
    /** Value along an x axis.
    * Annotates x-axis data with a value. It 
    *                 is typically used for the location of a _peak_ or _peakGroup_. It 
    *                 uses xUnits or the same units as the data.
    * @return CMLAttribute
    */
    public CMLAttribute getXValueAttribute() {
        return (CMLAttribute) getAttribute("xValue");
    }
    /** Value along an x axis.
    * Annotates x-axis data with a value. It 
    *                 is typically used for the location of a _peak_ or _peakGroup_. It 
    *                 uses xUnits or the same units as the data.
    * @return double
    */
    public double getXValue() {
        DoubleSTAttribute att = (DoubleSTAttribute) this.getXValueAttribute();
        if (att == null) {
            return Double.NaN;
        }
        return att.getDouble();
    }
    /** Value along an x axis.
    * Annotates x-axis data with a value. It 
    *                 is typically used for the location of a _peak_ or _peakGroup_. It 
    *                 uses xUnits or the same units as the data.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setXValue(String value) throws RuntimeException {
        DoubleSTAttribute att = null;
        if (_att_xvalue == null) {
            _att_xvalue = (DoubleSTAttribute) attributeFactory.getAttribute("xValue", "peak");
            if (_att_xvalue == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : xValue probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new DoubleSTAttribute(_att_xvalue);
        super.addRemove(att, value);
    }
    /** Value along an x axis.
    * Annotates x-axis data with a value. It 
    *                 is typically used for the location of a _peak_ or _peakGroup_. It 
    *                 uses xUnits or the same units as the data.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setXValue(double value) throws RuntimeException {
        if (_att_xvalue == null) {
            _att_xvalue = (DoubleSTAttribute) attributeFactory.getAttribute("xValue", "peak");
           if (_att_xvalue == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : xValue probably incompatible attributeGroupName and attributeName ");
            }
        }
        DoubleSTAttribute att = new DoubleSTAttribute(_att_xvalue);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// attribute:   xWidth

    /** cache */
    DoubleSTAttribute _att_xwidth = null;
    /** An unsigned interval along an x axis.
    * It is typically used for the width of 
    *                 a _peak_ or _peakGroup_ but could be used for any range. It uses 
    *                 xUnits or the same units as the data.
    * @return CMLAttribute
    */
    public CMLAttribute getXWidthAttribute() {
        return (CMLAttribute) getAttribute("xWidth");
    }
    /** An unsigned interval along an x axis.
    * It is typically used for the width of 
    *                 a _peak_ or _peakGroup_ but could be used for any range. It uses 
    *                 xUnits or the same units as the data.
    * @return double
    */
    public double getXWidth() {
        DoubleSTAttribute att = (DoubleSTAttribute) this.getXWidthAttribute();
        if (att == null) {
            return Double.NaN;
        }
        return att.getDouble();
    }
    /** An unsigned interval along an x axis.
    * It is typically used for the width of 
    *                 a _peak_ or _peakGroup_ but could be used for any range. It uses 
    *                 xUnits or the same units as the data.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setXWidth(String value) throws RuntimeException {
        DoubleSTAttribute att = null;
        if (_att_xwidth == null) {
            _att_xwidth = (DoubleSTAttribute) attributeFactory.getAttribute("xWidth", "peak");
            if (_att_xwidth == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : xWidth probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new DoubleSTAttribute(_att_xwidth);
        super.addRemove(att, value);
    }
    /** An unsigned interval along an x axis.
    * It is typically used for the width of 
    *                 a _peak_ or _peakGroup_ but could be used for any range. It uses 
    *                 xUnits or the same units as the data.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setXWidth(double value) throws RuntimeException {
        if (_att_xwidth == null) {
            _att_xwidth = (DoubleSTAttribute) attributeFactory.getAttribute("xWidth", "peak");
           if (_att_xwidth == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : xWidth probably incompatible attributeGroupName and attributeName ");
            }
        }
        DoubleSTAttribute att = new DoubleSTAttribute(_att_xwidth);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// attribute:   xUnits

    /** cache */
    StringSTAttribute _att_xunits = null;
    /** Units for x axis.
    * All x-axis data must have unambiguous units. Ideally the data and _xMin_ or _xValue_ should share the same units but different xUnits can be used as long as it is clear..
    * @return CMLAttribute
    */
    public CMLAttribute getXUnitsAttribute() {
        return (CMLAttribute) getAttribute("xUnits");
    }
    /** Units for x axis.
    * All x-axis data must have unambiguous units. Ideally the data and _xMin_ or _xValue_ should share the same units but different xUnits can be used as long as it is clear..
    * @return String
    */
    public String getXUnits() {
        StringSTAttribute att = (StringSTAttribute) this.getXUnitsAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** Units for x axis.
    * All x-axis data must have unambiguous units. Ideally the data and _xMin_ or _xValue_ should share the same units but different xUnits can be used as long as it is clear..
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setXUnits(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_xunits == null) {
            _att_xunits = (StringSTAttribute) attributeFactory.getAttribute("xUnits", "peak");
            if (_att_xunits == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : xUnits probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_xunits);
        super.addRemove(att, value);
    }
// attribute:   yMin

    /** cache */
    DoubleSTAttribute _att_ymin = null;
    /** Minimum yValue.
    * Annotates y-axis data with a minimum 
    *                 value. This need not be algorithmically deducible from the data 
    *                 and is typically used for the extent of a _peak_ or _peakGroup_. 
    *                 It uses yUnits or the same units as the data. There may or may 
    *                 not be a _yMax_ attribute but if so yMin should be less than or 
    *                 equal to it.
    * @return CMLAttribute
    */
    public CMLAttribute getYMinAttribute() {
        return (CMLAttribute) getAttribute("yMin");
    }
    /** Minimum yValue.
    * Annotates y-axis data with a minimum 
    *                 value. This need not be algorithmically deducible from the data 
    *                 and is typically used for the extent of a _peak_ or _peakGroup_. 
    *                 It uses yUnits or the same units as the data. There may or may 
    *                 not be a _yMax_ attribute but if so yMin should be less than or 
    *                 equal to it.
    * @return double
    */
    public double getYMin() {
        DoubleSTAttribute att = (DoubleSTAttribute) this.getYMinAttribute();
        if (att == null) {
            return Double.NaN;
        }
        return att.getDouble();
    }
    /** Minimum yValue.
    * Annotates y-axis data with a minimum 
    *                 value. This need not be algorithmically deducible from the data 
    *                 and is typically used for the extent of a _peak_ or _peakGroup_. 
    *                 It uses yUnits or the same units as the data. There may or may 
    *                 not be a _yMax_ attribute but if so yMin should be less than or 
    *                 equal to it.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setYMin(String value) throws RuntimeException {
        DoubleSTAttribute att = null;
        if (_att_ymin == null) {
            _att_ymin = (DoubleSTAttribute) attributeFactory.getAttribute("yMin", "peak");
            if (_att_ymin == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : yMin probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new DoubleSTAttribute(_att_ymin);
        super.addRemove(att, value);
    }
    /** Minimum yValue.
    * Annotates y-axis data with a minimum 
    *                 value. This need not be algorithmically deducible from the data 
    *                 and is typically used for the extent of a _peak_ or _peakGroup_. 
    *                 It uses yUnits or the same units as the data. There may or may 
    *                 not be a _yMax_ attribute but if so yMin should be less than or 
    *                 equal to it.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setYMin(double value) throws RuntimeException {
        if (_att_ymin == null) {
            _att_ymin = (DoubleSTAttribute) attributeFactory.getAttribute("yMin", "peak");
           if (_att_ymin == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : yMin probably incompatible attributeGroupName and attributeName ");
            }
        }
        DoubleSTAttribute att = new DoubleSTAttribute(_att_ymin);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// attribute:   yMax

    /** cache */
    DoubleSTAttribute _att_ymax = null;
    /** Maximum yValue.
    * Annotates y-axis data with a maximum 
    *                 value. This need not be algorithmically deducible from the data 
    *                 and is typically used for the extent of a _peak_ or _peakGroup_. 
    *                 It uses yUnits or the same units as the data. There may or may not 
    *                 be a _yMin_ attribute but if so yMax should be greater than or 
    *                 equals to it.
    * @return CMLAttribute
    */
    public CMLAttribute getYMaxAttribute() {
        return (CMLAttribute) getAttribute("yMax");
    }
    /** Maximum yValue.
    * Annotates y-axis data with a maximum 
    *                 value. This need not be algorithmically deducible from the data 
    *                 and is typically used for the extent of a _peak_ or _peakGroup_. 
    *                 It uses yUnits or the same units as the data. There may or may not 
    *                 be a _yMin_ attribute but if so yMax should be greater than or 
    *                 equals to it.
    * @return double
    */
    public double getYMax() {
        DoubleSTAttribute att = (DoubleSTAttribute) this.getYMaxAttribute();
        if (att == null) {
            return Double.NaN;
        }
        return att.getDouble();
    }
    /** Maximum yValue.
    * Annotates y-axis data with a maximum 
    *                 value. This need not be algorithmically deducible from the data 
    *                 and is typically used for the extent of a _peak_ or _peakGroup_. 
    *                 It uses yUnits or the same units as the data. There may or may not 
    *                 be a _yMin_ attribute but if so yMax should be greater than or 
    *                 equals to it.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setYMax(String value) throws RuntimeException {
        DoubleSTAttribute att = null;
        if (_att_ymax == null) {
            _att_ymax = (DoubleSTAttribute) attributeFactory.getAttribute("yMax", "peak");
            if (_att_ymax == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : yMax probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new DoubleSTAttribute(_att_ymax);
        super.addRemove(att, value);
    }
    /** Maximum yValue.
    * Annotates y-axis data with a maximum 
    *                 value. This need not be algorithmically deducible from the data 
    *                 and is typically used for the extent of a _peak_ or _peakGroup_. 
    *                 It uses yUnits or the same units as the data. There may or may not 
    *                 be a _yMin_ attribute but if so yMax should be greater than or 
    *                 equals to it.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setYMax(double value) throws RuntimeException {
        if (_att_ymax == null) {
            _att_ymax = (DoubleSTAttribute) attributeFactory.getAttribute("yMax", "peak");
           if (_att_ymax == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : yMax probably incompatible attributeGroupName and attributeName ");
            }
        }
        DoubleSTAttribute att = new DoubleSTAttribute(_att_ymax);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// attribute:   yValue

    /** cache */
    DoubleSTAttribute _att_yvalue = null;
    /** Value along a y axis.
    * Annotates y-axis data with a value. It 
    *                 is typically used for the location of a _peak_ or _peakGroup_. It 
    *                 uses yUnits or the same units as the data.
    * @return CMLAttribute
    */
    public CMLAttribute getYValueAttribute() {
        return (CMLAttribute) getAttribute("yValue");
    }
    /** Value along a y axis.
    * Annotates y-axis data with a value. It 
    *                 is typically used for the location of a _peak_ or _peakGroup_. It 
    *                 uses yUnits or the same units as the data.
    * @return double
    */
    public double getYValue() {
        DoubleSTAttribute att = (DoubleSTAttribute) this.getYValueAttribute();
        if (att == null) {
            return Double.NaN;
        }
        return att.getDouble();
    }
    /** Value along a y axis.
    * Annotates y-axis data with a value. It 
    *                 is typically used for the location of a _peak_ or _peakGroup_. It 
    *                 uses yUnits or the same units as the data.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setYValue(String value) throws RuntimeException {
        DoubleSTAttribute att = null;
        if (_att_yvalue == null) {
            _att_yvalue = (DoubleSTAttribute) attributeFactory.getAttribute("yValue", "peak");
            if (_att_yvalue == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : yValue probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new DoubleSTAttribute(_att_yvalue);
        super.addRemove(att, value);
    }
    /** Value along a y axis.
    * Annotates y-axis data with a value. It 
    *                 is typically used for the location of a _peak_ or _peakGroup_. It 
    *                 uses yUnits or the same units as the data.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setYValue(double value) throws RuntimeException {
        if (_att_yvalue == null) {
            _att_yvalue = (DoubleSTAttribute) attributeFactory.getAttribute("yValue", "peak");
           if (_att_yvalue == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : yValue probably incompatible attributeGroupName and attributeName ");
            }
        }
        DoubleSTAttribute att = new DoubleSTAttribute(_att_yvalue);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// attribute:   yWidth

    /** cache */
    DoubleSTAttribute _att_ywidth = null;
    /** An unsigned interval along a y axis.
    * It is typically used for the width of 
    *                 a _peak_ or _peakGroup_ but could be used for any range. It uses 
    *                 yUnits or the same units as the data.
    * @return CMLAttribute
    */
    public CMLAttribute getYWidthAttribute() {
        return (CMLAttribute) getAttribute("yWidth");
    }
    /** An unsigned interval along a y axis.
    * It is typically used for the width of 
    *                 a _peak_ or _peakGroup_ but could be used for any range. It uses 
    *                 yUnits or the same units as the data.
    * @return double
    */
    public double getYWidth() {
        DoubleSTAttribute att = (DoubleSTAttribute) this.getYWidthAttribute();
        if (att == null) {
            return Double.NaN;
        }
        return att.getDouble();
    }
    /** An unsigned interval along a y axis.
    * It is typically used for the width of 
    *                 a _peak_ or _peakGroup_ but could be used for any range. It uses 
    *                 yUnits or the same units as the data.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setYWidth(String value) throws RuntimeException {
        DoubleSTAttribute att = null;
        if (_att_ywidth == null) {
            _att_ywidth = (DoubleSTAttribute) attributeFactory.getAttribute("yWidth", "peak");
            if (_att_ywidth == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : yWidth probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new DoubleSTAttribute(_att_ywidth);
        super.addRemove(att, value);
    }
    /** An unsigned interval along a y axis.
    * It is typically used for the width of 
    *                 a _peak_ or _peakGroup_ but could be used for any range. It uses 
    *                 yUnits or the same units as the data.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setYWidth(double value) throws RuntimeException {
        if (_att_ywidth == null) {
            _att_ywidth = (DoubleSTAttribute) attributeFactory.getAttribute("yWidth", "peak");
           if (_att_ywidth == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : yWidth probably incompatible attributeGroupName and attributeName ");
            }
        }
        DoubleSTAttribute att = new DoubleSTAttribute(_att_ywidth);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// attribute:   yUnits

    /** cache */
    StringSTAttribute _att_yunits = null;
    /** Units for y axis.
    * All y-axis data must have unambiguous units. Ideally the data and _yMin_ or _yValue_ should share the same units but different yUnits can be used as long as it is clear.
    * @return CMLAttribute
    */
    public CMLAttribute getYUnitsAttribute() {
        return (CMLAttribute) getAttribute("yUnits");
    }
    /** Units for y axis.
    * All y-axis data must have unambiguous units. Ideally the data and _yMin_ or _yValue_ should share the same units but different yUnits can be used as long as it is clear.
    * @return String
    */
    public String getYUnits() {
        StringSTAttribute att = (StringSTAttribute) this.getYUnitsAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** Units for y axis.
    * All y-axis data must have unambiguous units. Ideally the data and _yMin_ or _yValue_ should share the same units but different yUnits can be used as long as it is clear.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setYUnits(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_yunits == null) {
            _att_yunits = (StringSTAttribute) attributeFactory.getAttribute("yUnits", "peak");
            if (_att_yunits == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : yUnits probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_yunits);
        super.addRemove(att, value);
    }
// attribute:   atomRefs

    /** cache */
    StringArraySTAttribute _att_atomrefs = null;
    /** A reference to a list of atoms.
    * Used by bonds, electrons, atomSets, etc.
    * @return CMLAttribute
    */
    public CMLAttribute getAtomRefsAttribute() {
        return (CMLAttribute) getAttribute("atomRefs");
    }
    /** A reference to a list of atoms.
    * Used by bonds, electrons, atomSets, etc.
    * @return String[]
    */
    public String[] getAtomRefs() {
        StringArraySTAttribute att = (StringArraySTAttribute) this.getAtomRefsAttribute();
        if (att == null) {
            return null;
        }
        return att.getStringArray();
    }
    /** A reference to a list of atoms.
    * Used by bonds, electrons, atomSets, etc.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setAtomRefs(String value) throws RuntimeException {
        StringArraySTAttribute att = null;
        if (_att_atomrefs == null) {
            _att_atomrefs = (StringArraySTAttribute) attributeFactory.getAttribute("atomRefs", "peak");
            if (_att_atomrefs == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : atomRefs probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringArraySTAttribute(_att_atomrefs);
        super.addRemove(att, value);
    }
    /** A reference to a list of atoms.
    * Used by bonds, electrons, atomSets, etc.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setAtomRefs(String[] value) throws RuntimeException {
        if (_att_atomrefs == null) {
            _att_atomrefs = (StringArraySTAttribute) attributeFactory.getAttribute("atomRefs", "peak");
           if (_att_atomrefs == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : atomRefs probably incompatible attributeGroupName and attributeName ");
            }
        }
        StringArraySTAttribute att = new StringArraySTAttribute(_att_atomrefs);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// attribute:   bondRefs

    /** cache */
    StringArraySTAttribute _att_bondrefs = null;
    /** A reference to a list of bonds.
    * Used by electrons, bondSets, etc.
    * @return CMLAttribute
    */
    public CMLAttribute getBondRefsAttribute() {
        return (CMLAttribute) getAttribute("bondRefs");
    }
    /** A reference to a list of bonds.
    * Used by electrons, bondSets, etc.
    * @return String[]
    */
    public String[] getBondRefs() {
        StringArraySTAttribute att = (StringArraySTAttribute) this.getBondRefsAttribute();
        if (att == null) {
            return null;
        }
        return att.getStringArray();
    }
    /** A reference to a list of bonds.
    * Used by electrons, bondSets, etc.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setBondRefs(String value) throws RuntimeException {
        StringArraySTAttribute att = null;
        if (_att_bondrefs == null) {
            _att_bondrefs = (StringArraySTAttribute) attributeFactory.getAttribute("bondRefs", "peak");
            if (_att_bondrefs == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : bondRefs probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringArraySTAttribute(_att_bondrefs);
        super.addRemove(att, value);
    }
    /** A reference to a list of bonds.
    * Used by electrons, bondSets, etc.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setBondRefs(String[] value) throws RuntimeException {
        if (_att_bondrefs == null) {
            _att_bondrefs = (StringArraySTAttribute) attributeFactory.getAttribute("bondRefs", "peak");
           if (_att_bondrefs == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : bondRefs probably incompatible attributeGroupName and attributeName ");
            }
        }
        StringArraySTAttribute att = new StringArraySTAttribute(_att_bondrefs);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// attribute:   moleculeRefs

    /** cache */
    StringArraySTAttribute _att_moleculerefs = null;
    /** A reference to one or more molecules.
    * Uses the id attribute as the target identification. 
    *         The order of molecules is preserved. It is not necessarily an error to have repeated 
    *         references to the same molecule
    * @return CMLAttribute
    */
    public CMLAttribute getMoleculeRefsAttribute() {
        return (CMLAttribute) getAttribute("moleculeRefs");
    }
    /** A reference to one or more molecules.
    * Uses the id attribute as the target identification. 
    *         The order of molecules is preserved. It is not necessarily an error to have repeated 
    *         references to the same molecule
    * @return String[]
    */
    public String[] getMoleculeRefs() {
        StringArraySTAttribute att = (StringArraySTAttribute) this.getMoleculeRefsAttribute();
        if (att == null) {
            return null;
        }
        return att.getStringArray();
    }
    /** A reference to one or more molecules.
    * Uses the id attribute as the target identification. 
    *         The order of molecules is preserved. It is not necessarily an error to have repeated 
    *         references to the same molecule
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setMoleculeRefs(String value) throws RuntimeException {
        StringArraySTAttribute att = null;
        if (_att_moleculerefs == null) {
            _att_moleculerefs = (StringArraySTAttribute) attributeFactory.getAttribute("moleculeRefs", "peak");
            if (_att_moleculerefs == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : moleculeRefs probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringArraySTAttribute(_att_moleculerefs);
        super.addRemove(att, value);
    }
    /** A reference to one or more molecules.
    * Uses the id attribute as the target identification. 
    *         The order of molecules is preserved. It is not necessarily an error to have repeated 
    *         references to the same molecule
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setMoleculeRefs(String[] value) throws RuntimeException {
        if (_att_moleculerefs == null) {
            _att_moleculerefs = (StringArraySTAttribute) attributeFactory.getAttribute("moleculeRefs", "peak");
           if (_att_moleculerefs == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : moleculeRefs probably incompatible attributeGroupName and attributeName ");
            }
        }
        StringArraySTAttribute att = new StringArraySTAttribute(_att_moleculerefs);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// element:   atom

    /** A reference to one or more molecules.
    * Uses the id attribute as the target identification. 
    *         The order of molecules is preserved. It is not necessarily an error to have repeated 
    *         references to the same molecule
    * @param atom child to add
    */
    public void addAtom(AbstractAtom atom) {
        atom.detach();
        this.appendChild(atom);
    }
    /** A reference to one or more molecules.
    * Uses the id attribute as the target identification. 
    *         The order of molecules is preserved. It is not necessarily an error to have repeated 
    *         references to the same molecule
    * @return CMLElements<CMLAtom>
    */
    public CMLElements<CMLAtom> getAtomElements() {
        Elements elements = this.getChildElements("atom", CML_NS);
        return new CMLElements<CMLAtom>(elements);
    }
// element:   bond

    /** A reference to one or more molecules.
    * Uses the id attribute as the target identification. 
    *         The order of molecules is preserved. It is not necessarily an error to have repeated 
    *         references to the same molecule
    * @param bond child to add
    */
    public void addBond(AbstractBond bond) {
        bond.detach();
        this.appendChild(bond);
    }
    /** A reference to one or more molecules.
    * Uses the id attribute as the target identification. 
    *         The order of molecules is preserved. It is not necessarily an error to have repeated 
    *         references to the same molecule
    * @return CMLElements<CMLBond>
    */
    public CMLElements<CMLBond> getBondElements() {
        Elements elements = this.getChildElements("bond", CML_NS);
        return new CMLElements<CMLBond>(elements);
    }
// element:   molecule

    /** A reference to one or more molecules.
    * Uses the id attribute as the target identification. 
    *         The order of molecules is preserved. It is not necessarily an error to have repeated 
    *         references to the same molecule
    * @param molecule child to add
    */
    public void addMolecule(AbstractMolecule molecule) {
        molecule.detach();
        this.appendChild(molecule);
    }
    /** A reference to one or more molecules.
    * Uses the id attribute as the target identification. 
    *         The order of molecules is preserved. It is not necessarily an error to have repeated 
    *         references to the same molecule
    * @return CMLElements<CMLMolecule>
    */
    public CMLElements<CMLMolecule> getMoleculeElements() {
        Elements elements = this.getChildElements("molecule", CML_NS);
        return new CMLElements<CMLMolecule>(elements);
    }
// element:   peakStructure

    /** A reference to one or more molecules.
    * Uses the id attribute as the target identification. 
    *         The order of molecules is preserved. It is not necessarily an error to have repeated 
    *         references to the same molecule
    * @param peakStructure child to add
    */
    public void addPeakStructure(AbstractPeakStructure peakStructure) {
        peakStructure.detach();
        this.appendChild(peakStructure);
    }
    /** A reference to one or more molecules.
    * Uses the id attribute as the target identification. 
    *         The order of molecules is preserved. It is not necessarily an error to have repeated 
    *         references to the same molecule
    * @return CMLElements<CMLPeakStructure>
    */
    public CMLElements<CMLPeakStructure> getPeakStructureElements() {
        Elements elements = this.getChildElements("peakStructure", CML_NS);
        return new CMLElements<CMLPeakStructure>(elements);
    }
    /** overrides addAttribute(Attribute)
     * reroutes calls to setFoo()
     * @param att  attribute
    */
    public void addAttribute(Attribute att) {
        String name = att.getLocalName();
        String value = att.getValue();
        if (name == null) {
        } else if (name.equals("dictRef")) {
            setDictRef(value);
        } else if (name.equals("convention")) {
            setConvention(value);
        } else if (name.equals("title")) {
            setTitle(value);
        } else if (name.equals("id")) {
            setId(value);
        } else if (name.equals("ref")) {
            setRef(value);
        } else if (name.equals("peakHeight")) {
            setPeakHeight(value);
        } else if (name.equals("peakMultiplicity")) {
            setPeakMultiplicity(value);
        } else if (name.equals("peakShape")) {
            setPeakShape(value);
        } else if (name.equals("integral")) {
            setIntegral(value);
        } else if (name.equals("peakUnits")) {
            setPeakUnits(value);
        } else if (name.equals("xMin")) {
            setXMin(value);
        } else if (name.equals("xMax")) {
            setXMax(value);
        } else if (name.equals("xValue")) {
            setXValue(value);
        } else if (name.equals("xWidth")) {
            setXWidth(value);
        } else if (name.equals("xUnits")) {
            setXUnits(value);
        } else if (name.equals("yMin")) {
            setYMin(value);
        } else if (name.equals("yMax")) {
            setYMax(value);
        } else if (name.equals("yValue")) {
            setYValue(value);
        } else if (name.equals("yWidth")) {
            setYWidth(value);
        } else if (name.equals("yUnits")) {
            setYUnits(value);
        } else if (name.equals("atomRefs")) {
            setAtomRefs(value);
        } else if (name.equals("bondRefs")) {
            setBondRefs(value);
        } else if (name.equals("moleculeRefs")) {
            setMoleculeRefs(value);
	     } else {
            super.addAttribute(att);
        }
    }
}
