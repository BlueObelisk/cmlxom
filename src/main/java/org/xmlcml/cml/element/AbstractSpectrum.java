package org.xmlcml.cml.element;


import nu.xom.Attribute;
import nu.xom.Elements;

import org.xmlcml.cml.attribute.DictRefAttribute;
import org.xmlcml.cml.attribute.IdAttribute;
import org.xmlcml.cml.attribute.RefAttribute;
import org.xmlcml.cml.base.CMLAttribute;
import org.xmlcml.cml.base.CMLConstants;
import org.xmlcml.cml.base.CMLElement;
import org.xmlcml.cml.base.CMLElements;
import org.xmlcml.cml.base.StringSTAttribute;

// end of part 1
/** CLASS DOCUMENTATION */
public abstract class AbstractSpectrum extends CMLElement {
    /** local name*/
    public final static String TAG = "spectrum";
    /** constructor. */    public AbstractSpectrum() {
        super("spectrum");
    }
/** copy constructor.
* deep copy using XOM copy()
* @param old element to copy
*/
    public AbstractSpectrum(AbstractSpectrum old) {
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
            _att_dictref = (DictRefAttribute) attributeFactory.getAttribute("dictRef", "spectrum");
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
            _att_convention = (StringSTAttribute) attributeFactory.getAttribute("convention", "spectrum");
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
            _att_title = (StringSTAttribute) attributeFactory.getAttribute("title", "spectrum");
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
            _att_id = (IdAttribute) attributeFactory.getAttribute("id", "spectrum");
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
            _att_ref = (RefAttribute) attributeFactory.getAttribute("ref", "spectrum");
            if (_att_ref == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : ref probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new RefAttribute(_att_ref);
        super.addRemove(att, value);
    }
// attribute:   moleculeRef

    /** cache */
    StringSTAttribute _att_moleculeref = null;
    /** A reference to a molecule.
    * Used by spectrum, etc.
    * @return CMLAttribute
    */
    public CMLAttribute getMoleculeRefAttribute() {
        return (CMLAttribute) getAttribute("moleculeRef");
    }
    /** A reference to a molecule.
    * Used by spectrum, etc.
    * @return String
    */
    public String getMoleculeRef() {
        StringSTAttribute att = (StringSTAttribute) this.getMoleculeRefAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** A reference to a molecule.
    * Used by spectrum, etc.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setMoleculeRef(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_moleculeref == null) {
            _att_moleculeref = (StringSTAttribute) attributeFactory.getAttribute("moleculeRef", "spectrum");
            if (_att_moleculeref == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : moleculeRef probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_moleculeref);
        super.addRemove(att, value);
    }
// attribute:   type

    /** cache */
    StringSTAttribute _att_type = null;
    /** The type of the spectrum.
    * No description
    * @return CMLAttribute
    */
    public CMLAttribute getTypeAttribute() {
        return (CMLAttribute) getAttribute("type");
    }
    /** The type of the spectrum.
    * No description
    * @return String
    */
    public String getType() {
        StringSTAttribute att = (StringSTAttribute) this.getTypeAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** The type of the spectrum.
    * No description
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setType(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_type == null) {
            _att_type = (StringSTAttribute) attributeFactory.getAttribute("type", "spectrum");
            if (_att_type == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : type probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_type);
        super.addRemove(att, value);
    }
// attribute:   format

    /** cache */
    StringSTAttribute _att_format = null;
    /** Format of a spectrum.
    * The data structure of the spectrum. (Not the format of the data). This describes how the data structure is to be interpreted.
    * @return CMLAttribute
    */
    public CMLAttribute getFormatAttribute() {
        return (CMLAttribute) getAttribute("format");
    }
    /** Format of a spectrum.
    * The data structure of the spectrum. (Not the format of the data). This describes how the data structure is to be interpreted.
    * @return String
    */
    public String getFormat() {
        StringSTAttribute att = (StringSTAttribute) this.getFormatAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** Format of a spectrum.
    * The data structure of the spectrum. (Not the format of the data). This describes how the data structure is to be interpreted.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setFormat(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_format == null) {
            _att_format = (StringSTAttribute) attributeFactory.getAttribute("format", "spectrum");
            if (_att_format == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : format probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_format);
        super.addRemove(att, value);
    }
// attribute:   measurement

    /** cache */
    StringSTAttribute _att_measurement = null;
    /** Type of spectral measurement.
    * The nature of the measured data. This is not an exhaustive list and should only be used if it affects the storage or immediate processing.
    * @return CMLAttribute
    */
    public CMLAttribute getMeasurementAttribute() {
        return (CMLAttribute) getAttribute("measurement");
    }
    /** Type of spectral measurement.
    * The nature of the measured data. This is not an exhaustive list and should only be used if it affects the storage or immediate processing.
    * @return String
    */
    public String getMeasurement() {
        StringSTAttribute att = (StringSTAttribute) this.getMeasurementAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** Type of spectral measurement.
    * The nature of the measured data. This is not an exhaustive list and should only be used if it affects the storage or immediate processing.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setMeasurement(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_measurement == null) {
            _att_measurement = (StringSTAttribute) attributeFactory.getAttribute("measurement", "spectrum");
            if (_att_measurement == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : measurement probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_measurement);
        super.addRemove(att, value);
    }
// attribute:   ft

    /** cache */
    StringSTAttribute _att_ft = null;
    /** Domain of an FT spectrum.
    * Indicates whether a spectrum is raw FID or has been transforme.
    * @return CMLAttribute
    */
    public CMLAttribute getFtAttribute() {
        return (CMLAttribute) getAttribute("ft");
    }
    /** Domain of an FT spectrum.
    * Indicates whether a spectrum is raw FID or has been transforme.
    * @return String
    */
    public String getFt() {
        StringSTAttribute att = (StringSTAttribute) this.getFtAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** Domain of an FT spectrum.
    * Indicates whether a spectrum is raw FID or has been transforme.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setFt(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_ft == null) {
            _att_ft = (StringSTAttribute) attributeFactory.getAttribute("ft", "spectrum");
            if (_att_ft == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : ft probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_ft);
        super.addRemove(att, value);
    }
// attribute:   state

    /** cache */
    StringSTAttribute _att_state = null;
    /** The physical state of the substance.
    * No fixed semantics or default.
    * @return CMLAttribute
    */
    public CMLAttribute getStateAttribute() {
        return (CMLAttribute) getAttribute("state");
    }
    /** The physical state of the substance.
    * No fixed semantics or default.
    * @return String
    */
    public String getState() {
        StringSTAttribute att = (StringSTAttribute) this.getStateAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** The physical state of the substance.
    * No fixed semantics or default.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setState(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_state == null) {
            _att_state = (StringSTAttribute) attributeFactory.getAttribute("state", "spectrum");
            if (_att_state == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : state probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_state);
        super.addRemove(att, value);
    }
// element:   metadataList

    /** The physical state of the substance.
    * No fixed semantics or default.
    * @param metadataList child to add
    */
    public void addMetadataList(AbstractMetadataList metadataList) {
        metadataList.detach();
        this.appendChild(metadataList);
    }
    /** The physical state of the substance.
    * No fixed semantics or default.
    * @return CMLElements<CMLMetadataList>
    */
    public CMLElements<CMLMetadataList> getMetadataListElements() {
        Elements elements = this.getChildElements("metadataList", CMLConstants.CML_NS);
        return new CMLElements<CMLMetadataList>(elements);
    }
// element:   sample

    /** The physical state of the substance.
    * No fixed semantics or default.
    * @param sample child to add
    */
    public void addSample(AbstractSample sample) {
        sample.detach();
        this.appendChild(sample);
    }
    /** The physical state of the substance.
    * No fixed semantics or default.
    * @return CMLElements<CMLSample>
    */
    public CMLElements<CMLSample> getSampleElements() {
        Elements elements = this.getChildElements("sample", CMLConstants.CML_NS);
        return new CMLElements<CMLSample>(elements);
    }
// element:   parameterList

    /** The physical state of the substance.
    * No fixed semantics or default.
    * @param parameterList child to add
    */
    public void addParameterList(AbstractParameterList parameterList) {
        parameterList.detach();
        this.appendChild(parameterList);
    }
    /** The physical state of the substance.
    * No fixed semantics or default.
    * @return CMLElements<CMLParameterList>
    */
    public CMLElements<CMLParameterList> getParameterListElements() {
        Elements elements = this.getChildElements("parameterList", CMLConstants.CML_NS);
        return new CMLElements<CMLParameterList>(elements);
    }
// element:   substanceList

    /** The physical state of the substance.
    * No fixed semantics or default.
    * @param substanceList child to add
    */
    public void addSubstanceList(AbstractSubstanceList substanceList) {
        substanceList.detach();
        this.appendChild(substanceList);
    }
    /** The physical state of the substance.
    * No fixed semantics or default.
    * @return CMLElements<CMLSubstanceList>
    */
    public CMLElements<CMLSubstanceList> getSubstanceListElements() {
        Elements elements = this.getChildElements("substanceList", CMLConstants.CML_NS);
        return new CMLElements<CMLSubstanceList>(elements);
    }
// element:   conditionList

    /** The physical state of the substance.
    * No fixed semantics or default.
    * @param conditionList child to add
    */
    public void addConditionList(AbstractConditionList conditionList) {
        conditionList.detach();
        this.appendChild(conditionList);
    }
    /** The physical state of the substance.
    * No fixed semantics or default.
    * @return CMLElements<CMLConditionList>
    */
    public CMLElements<CMLConditionList> getConditionListElements() {
        Elements elements = this.getChildElements("conditionList", CMLConstants.CML_NS);
        return new CMLElements<CMLConditionList>(elements);
    }
// element:   spectrumData

    /** The physical state of the substance.
    * No fixed semantics or default.
    * @param spectrumData child to add
    */
    public void addSpectrumData(AbstractSpectrumData spectrumData) {
        spectrumData.detach();
        this.appendChild(spectrumData);
    }
    /** The physical state of the substance.
    * No fixed semantics or default.
    * @return CMLElements<CMLSpectrumData>
    */
    public CMLElements<CMLSpectrumData> getSpectrumDataElements() {
        Elements elements = this.getChildElements("spectrumData", CMLConstants.CML_NS);
        return new CMLElements<CMLSpectrumData>(elements);
    }
// element:   peakList

    /** The physical state of the substance.
    * No fixed semantics or default.
    * @param peakList child to add
    */
    public void addPeakList(AbstractPeakList peakList) {
        peakList.detach();
        this.appendChild(peakList);
    }
    /** The physical state of the substance.
    * No fixed semantics or default.
    * @return CMLElements<CMLPeakList>
    */
    public CMLElements<CMLPeakList> getPeakListElements() {
        Elements elements = this.getChildElements("peakList", CMLConstants.CML_NS);
        return new CMLElements<CMLPeakList>(elements);
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
        } else if (name.equals("moleculeRef")) {
            setMoleculeRef(value);
        } else if (name.equals("type")) {
            setType(value);
        } else if (name.equals("format")) {
            setFormat(value);
        } else if (name.equals("measurement")) {
            setMeasurement(value);
        } else if (name.equals("ft")) {
            setFt(value);
        } else if (name.equals("state")) {
            setState(value);
	     } else {
            super.addAttribute(att);
        }
    }
}
