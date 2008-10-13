package org.xmlcml.cml.element.main;


import nu.xom.Attribute;

import org.xmlcml.cml.attribute.DictRefAttribute;
import org.xmlcml.cml.attribute.IdAttribute;
import org.xmlcml.cml.base.CMLAttribute;
import org.xmlcml.cml.base.CMLElement;
import org.xmlcml.cml.base.DoubleArraySTAttribute;
import org.xmlcml.cml.base.StringSTAttribute;

// end of part 1
/** CLASS DOCUMENTATION */
public abstract class AbstractRegion extends CMLElement {
    /** local name*/
    public final static String TAG = "region";
    /** constructor. */    public AbstractRegion() {
        super("region");
    }
/** copy constructor.
* deep copy using XOM copy()
* @param old element to copy
*/
    public AbstractRegion(AbstractRegion old) {
        super((CMLElement) old);
    }
// attribute:   sphere3

    /** cache */
    DoubleArraySTAttribute _att_sphere3 = null;
    /** A sphere.
    * Currently describes a region. Any point falling within the sphere or on its surface is within the region.
    * @return CMLAttribute
    */
    public CMLAttribute getSphere3Attribute() {
        return (CMLAttribute) getAttribute("sphere3");
    }
    /** A sphere.
    * Currently describes a region. Any point falling within the sphere or on its surface is within the region.
    * @return double[]
    */
    public double[] getSphere3() {
        DoubleArraySTAttribute att = (DoubleArraySTAttribute) this.getSphere3Attribute();
        if (att == null) {
            return null;
        }
        return att.getDoubleArray();
    }
    /** A sphere.
    * Currently describes a region. Any point falling within the sphere or on its surface is within the region.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setSphere3(String value) throws RuntimeException {
        DoubleArraySTAttribute att = null;
        if (_att_sphere3 == null) {
            _att_sphere3 = (DoubleArraySTAttribute) attributeFactory.getAttribute("sphere3", "region");
            if (_att_sphere3 == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : sphere3 probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new DoubleArraySTAttribute(_att_sphere3);
        super.addRemove(att, value);
    }
    /** A sphere.
    * Currently describes a region. Any point falling within the sphere or on its surface is within the region.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setSphere3(double[] value) throws RuntimeException {
        if (_att_sphere3 == null) {
            _att_sphere3 = (DoubleArraySTAttribute) attributeFactory.getAttribute("sphere3", "region");
           if (_att_sphere3 == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : sphere3 probably incompatible attributeGroupName and attributeName ");
            }
        }
        DoubleArraySTAttribute att = new DoubleArraySTAttribute(_att_sphere3);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// attribute:   box3

    /** cache */
    DoubleArraySTAttribute _att_box3 = null;
    /** A parallelipiped box.
    * By default the box uses isometric Cartesians axes but can also be linked to lattice Vector. Any point falling within the box or on a boundary is within the regio.
    * @return CMLAttribute
    */
    public CMLAttribute getBox3Attribute() {
        return (CMLAttribute) getAttribute("box3");
    }
    /** A parallelipiped box.
    * By default the box uses isometric Cartesians axes but can also be linked to lattice Vector. Any point falling within the box or on a boundary is within the regio.
    * @return double[]
    */
    public double[] getBox3() {
        DoubleArraySTAttribute att = (DoubleArraySTAttribute) this.getBox3Attribute();
        if (att == null) {
            return null;
        }
        return att.getDoubleArray();
    }
    /** A parallelipiped box.
    * By default the box uses isometric Cartesians axes but can also be linked to lattice Vector. Any point falling within the box or on a boundary is within the regio.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setBox3(String value) throws RuntimeException {
        DoubleArraySTAttribute att = null;
        if (_att_box3 == null) {
            _att_box3 = (DoubleArraySTAttribute) attributeFactory.getAttribute("box3", "region");
            if (_att_box3 == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : box3 probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new DoubleArraySTAttribute(_att_box3);
        super.addRemove(att, value);
    }
    /** A parallelipiped box.
    * By default the box uses isometric Cartesians axes but can also be linked to lattice Vector. Any point falling within the box or on a boundary is within the regio.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setBox3(double[] value) throws RuntimeException {
        if (_att_box3 == null) {
            _att_box3 = (DoubleArraySTAttribute) attributeFactory.getAttribute("box3", "region");
           if (_att_box3 == null) {
               throw new RuntimeException("BUG: cannot process attributeGroupName : box3 probably incompatible attributeGroupName and attributeName ");
            }
        }
        DoubleArraySTAttribute att = new DoubleArraySTAttribute(_att_box3);
        super.addAttribute(att);
        att.setCMLValue(value);
    }
// attribute:   atomSetRef

    /** cache */
    StringSTAttribute _att_atomsetref = null;
    /** An atomSet describing the region.
    * Any point falling within atomOffset of any atom in the set lies within the region. This means the region could consist of disjoint fragments.
    * @return CMLAttribute
    */
    public CMLAttribute getAtomSetRefAttribute() {
        return (CMLAttribute) getAttribute("atomSetRef");
    }
    /** An atomSet describing the region.
    * Any point falling within atomOffset of any atom in the set lies within the region. This means the region could consist of disjoint fragments.
    * @return String
    */
    public String getAtomSetRef() {
        StringSTAttribute att = (StringSTAttribute) this.getAtomSetRefAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** An atomSet describing the region.
    * Any point falling within atomOffset of any atom in the set lies within the region. This means the region could consist of disjoint fragments.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setAtomSetRef(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_atomsetref == null) {
            _att_atomsetref = (StringSTAttribute) attributeFactory.getAttribute("atomSetRef", "region");
            if (_att_atomsetref == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : atomSetRef probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_atomsetref);
        super.addRemove(att, value);
    }
// attribute:   regionRefs

    /** cache */
    StringSTAttribute _att_regionrefs = null;
    /** A list of regions creating a union.
    * The union of a series of regions produces a larger region (possibly disjoint). Any point belonging to any of the referenced regions is a member of this region.
    * @return CMLAttribute
    */
    public CMLAttribute getRegionRefsAttribute() {
        return (CMLAttribute) getAttribute("regionRefs");
    }
    /** A list of regions creating a union.
    * The union of a series of regions produces a larger region (possibly disjoint). Any point belonging to any of the referenced regions is a member of this region.
    * @return String
    */
    public String getRegionRefs() {
        StringSTAttribute att = (StringSTAttribute) this.getRegionRefsAttribute();
        if (att == null) {
            return null;
        }
        return att.getString();
    }
    /** A list of regions creating a union.
    * The union of a series of regions produces a larger region (possibly disjoint). Any point belonging to any of the referenced regions is a member of this region.
    * @param value title value
    * @throws RuntimeException attribute wrong value/type
    */
    public void setRegionRefs(String value) throws RuntimeException {
        StringSTAttribute att = null;
        if (_att_regionrefs == null) {
            _att_regionrefs = (StringSTAttribute) attributeFactory.getAttribute("regionRefs", "region");
            if (_att_regionrefs == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : regionRefs probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new StringSTAttribute(_att_regionrefs);
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
            _att_title = (StringSTAttribute) attributeFactory.getAttribute("title", "region");
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
            _att_id = (IdAttribute) attributeFactory.getAttribute("id", "region");
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
            _att_convention = (StringSTAttribute) attributeFactory.getAttribute("convention", "region");
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
            _att_dictref = (DictRefAttribute) attributeFactory.getAttribute("dictRef", "region");
            if (_att_dictref == null) {
                throw new RuntimeException("BUG: cannot process attributeGroupName : dictRef probably incompatible attributeGroupName and attributeName");
            }
        }
        att = new DictRefAttribute(_att_dictref);
        super.addRemove(att, value);
    }
    /** overrides addAttribute(Attribute)
     * reroutes calls to setFoo()
     * @param att  attribute
    */
    public void addAttribute(Attribute att) {
        String name = att.getLocalName();
        String value = att.getValue();
        if (name == null) {
        } else if (name.equals("sphere3")) {
            setSphere3(value);
        } else if (name.equals("box3")) {
            setBox3(value);
        } else if (name.equals("atomSetRef")) {
            setAtomSetRef(value);
        } else if (name.equals("regionRefs")) {
            setRegionRefs(value);
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
