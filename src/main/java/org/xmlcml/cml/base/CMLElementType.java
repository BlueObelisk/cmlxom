package org.xmlcml.cml.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import nu.xom.Element;
import nu.xom.Node;

/**
 * @author pm286
 *
 */
public class CMLElementType implements CMLConstants {

	private Element complexType;
	private Element simpleType;
	private Element extension;
	private List<CMLAttribute> attributeList;
	private List<String> attributeGroupNameList;
	private List<CMLElementType> elementTypeList;
	private Element xsdElement;
	private String name;
	private CMLType simpleContentType;
	
    /** constructor.
     * @param xsdElement
     */
	public CMLElementType(Element xsdElement) {
		init();
		this.xsdElement = xsdElement;
		this.name = xsdElement.getAttributeValue("name");
		processContentTypes();
	}
	
	private void processContentTypes() {
		List<Node> complexTypes = CMLUtil.getQueryNodes(xsdElement, 
				"./"+XSD_COMPLEX_TYPE, XPATH_XSD);
		if (complexTypes.size() == 1) {
			complexType = (Element) complexTypes.get(0);
		}
		if (complexType == null) {
			throw new RuntimeException("No complexType for: "+name);
		}
		List<Node> simpleTypes = CMLUtil.getQueryNodes(complexType, 
				"./"+XSD_SIMPLE_CONTENT, XPATH_XSD);
		if (simpleTypes.size() == 1) {
			simpleType = (Element) simpleTypes.get(0);
		}
	}

	void init() {
		attributeList = new ArrayList<CMLAttribute>();
		attributeGroupNameList = new ArrayList<String>();
		elementTypeList = new ArrayList<CMLElementType>();
	}
	
	/** process attributes.
	 * 
	 * @param attributeGroupMap
	 */
	public void processAttributes(Map<String, CMLAttribute> attributeGroupMap) {
		Element contentType = complexType;
		// attributes may be in simpleContent
		if (simpleType != null) {
			List<Node> extensions = CMLUtil.getQueryNodes(
			    simpleType, "./"+XSD_EXTENSION, XPATH_XSD);
			if (extensions.size() == 0) {
				throw new RuntimeException("Expected extension children for simpleContent for "+name);
			}
			extension = (Element) extensions.get(0);
			contentType = extension;
		}
		List<Node> attributes = CMLUtil.getQueryNodes(
			    contentType, "./"+XSD_ATTRIBUTE, XPATH_XSD);
		if (attributes.size() != 0) {
			throw new RuntimeException("Use attributeGroups instead of attributes for "+name);
		}
		List<Node> attributeGroups = CMLUtil.getQueryNodes(
			    contentType, "./"+XSD_ATTRIBUTE_GROUP, XPATH_XSD);
		if (attributeGroups.size() == 0) {
			throw new RuntimeException("NOTE: no attributeGroups for "+name);
		}
	    for (Node node : attributeGroups) {
	    	Element attributeGroup = (Element) node;
	    	String attributeGroupRef = attributeGroup.getAttributeValue("ref");
	    	CMLAttribute attribute = attributeGroupMap.get(attributeGroupRef);
	    	if (attribute == null) {
	    		throw new RuntimeException("cannot find attributeGroup: "+attributeGroupRef);
	    	}
	    	attributeList.add(attribute);
	    	attributeGroupNameList.add(attributeGroupRef);
	    }
	}
	
	/** process complexContent.
	 * @param elementTypeMap
	 */
	public void processComplexContent(Map<String, CMLElementType> elementTypeMap) {
		if (simpleType == null) {
			List<Node> elements = CMLUtil.getQueryNodes(complexType,
					".//"+XSD_ELEMENT+"[@ref]", XPATH_XSD);
			if (elements.size() == 0) {
//				LOG.debug("NOTE: no element children for "+name);
			}
			for (Node node : elements) {
				Element xsdElement = (Element) node;
				String ref = xsdElement.getAttributeValue("ref");
				if (ref == null) {
					throw new RuntimeException("No ref attribute for child element in "+name);
				}
				CMLElementType elementType = elementTypeMap.get(ref);
				if (elementType == null) {
					throw new RuntimeException("No element known for "+ref);
				}
				elementTypeList.add(elementType);
			}
		}
	}
	
	/** process simpleContent.
	 * 
	 * @param typeMap
	 */
	public void processSimpleContent(Map<String, CMLType> typeMap) {
		if (extension != null) {
			String base = extension.getAttributeValue("base");
			if (base == null) {
				throw new RuntimeException("No base given for extension in "+name);
			}
			simpleContentType = typeMap.get(base);
			if (simpleContentType == null) {
				throw new RuntimeException("No type found for: "+base);
			}
		}
	}
	
	/**
	 * @return the attributeList
	 */
	public List<CMLAttribute> getAttributeList() {
		return attributeList;
	}

	/**
	 * @param attributeList the attributeList to set
	 */
	public void setAttributeList(List<CMLAttribute> attributeList) {
		this.attributeList = attributeList;
	}

	/**
	 * @return the attributeGroupNameList
	 */
	public List<String> getAttributeGroupNameList() {
		return attributeGroupNameList;
	}

	/**
	 * @param attributeGroupNameList the attributeGroupNameList to set
	 */
	public void setAttributeGroupNameList(List<String> attributeGroupNameList) {
		this.attributeGroupNameList = attributeGroupNameList;
	}

	/**
	 * @return the complexType
	 */
	public Element getComplexType() {
		return complexType;
	}

	/**
	 * @param complexType the complexType to set
	 */
	public void setComplexType(Element complexType) {
		this.complexType = complexType;
	}

	/**
	 * @return the simpleType
	 */
	public Element getSimpleType() {
		return simpleType;
	}

	/**
	 * @param simpleType the simpleType to set
	 */
	public void setSimpleType(Element simpleType) {
		this.simpleType = simpleType;
	}

	/**
	 * @return the elementTypeList
	 */
	public List<CMLElementType> getElementTypeList() {
		return elementTypeList;
	}

	/**
	 * @param elementTypeList the elementTypeList to set
	 */
	public void setElementTypeList(List<CMLElementType> elementTypeList) {
		this.elementTypeList = elementTypeList;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the xsdElement
	 */
	public Element getXsdElement() {
		return xsdElement;
	}

	/**
	 * @param xsdElement the xsdElement to set
	 */
	public void setXsdElement(Element xsdElement) {
		this.xsdElement = xsdElement;
	}

	/**
	 * @return the simpleContentType
	 */
	public CMLType getSimpleContentType() {
		return simpleContentType;
	}

	/**
	 * @param simpleContentType the simpleContentType to set
	 */
	public void setSimpleContentType(CMLType simpleContentType) {
		this.simpleContentType = simpleContentType;
	}

	/**
	 * @return the extension
	 */
	public Element getExtension() {
		return extension;
	}

	/**
	 * @param extension the extension to set
	 */
	public void setExtension(Element extension) {
		this.extension = extension;
	}

	/** to string.
	 * @return string
	 */
	public String toString() {
		String s = "";
		if (simpleContentType != null) {
			s += simpleContentType.listDataType()+"\n";
		} else {
			for (CMLElementType elementType : elementTypeList) {
				s += " + "+elementType.getName()+"\n";
			}
		}
		int i = 0;
		for (CMLAttribute attribute : attributeList) {
			s += "  "+attribute.getLocalName();
			if (++i % 6 == 0) {
				s += "\n";
			}
		}
		s += "\n";
		return s;
	}

}
