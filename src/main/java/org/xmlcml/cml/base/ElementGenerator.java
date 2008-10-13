/**
 * 
 */
package org.xmlcml.cml.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nu.xom.Element;
import nu.xom.Node;


/**
 * @author pm286
 *
 */
public class ElementGenerator extends AbstractGenerator {

	private Map<String, CMLElementType> elementTypeMap;
	/**
	 * @param schemaManager 
	 */
	public ElementGenerator(SchemaManager schemaManager) {
		this.schemaManager= schemaManager;
		init();
	}

	private void init() {
		elementTypeMap = new HashMap<String, CMLElementType>();
		nameList = new ArrayList<String>();
	}

	/** read assemble.
	 * 
	 * @param indir
	 * @throws Exception
	 */
	public void readAssembleAndIndexElementSchema(String indir) throws Exception {
		this.readAndAssembleSchemaComponents(indir);
		this.indexSchema();
	}

	/** index schema.
	 */
	public void indexSchema() {
		List<Node> xsdElements = CMLUtil.getQueryNodes(schema, "./"+XSD_ELEMENT, XPATH_XSD);
		// iterate through all elements
		for (Node node : xsdElements) {
			Element xsdElement = (Element) node;
			String name = xsdElement.getAttributeValue("name");
			CMLElementType elementType = null;
			if (name == null) {
				System.err.println("No name element on element");
			} else {
				elementType = new CMLElementType(xsdElement);
				elementTypeMap.put(name, elementType);
				nameList.add(name);
			}
			Map<String, CMLAttribute> attributeGroupMap = schemaManager.getAttributeGenerator().getAttributeGroupMap();
			elementType.processAttributes(attributeGroupMap);
			Map<String, CMLType> typeMap = schemaManager.getTypeGenerator().getMap();
			elementType.processSimpleContent(typeMap);
		}
		// re-iterate through elements (why??)
		for (String name : nameList) {
			CMLElementType elementType = elementTypeMap.get(name);
			elementType.processComplexContent(elementTypeMap);
		}
	}
	
	void printElements() {
		for (String name : nameList) {
			CMLElementType elementType = elementTypeMap.get(name);
			System.out.println("========================================");
			System.out.println(name);
			System.out.println("========================================");
			System.out.println(elementType.toString());
		}
	}

	/**
	 * @return the elementTypeMap
	 */
	public Map<String, CMLElementType> getElementTypeMap() {
		return elementTypeMap;
	}

	/**
	 * @param elementTypeMap the elementTypeMap to set
	 */
	public void setElementTypeMap(Map<String, CMLElementType> elementTypeMap) {
		this.elementTypeMap = elementTypeMap;
	}

	/**
	 * @return the nameList
	 */
	public List<String> getNameList() {
		return nameList;
	}

	/**
	 * @param nameList the nameList to set
	 */
	public void setNameList(List<String> nameList) {
		this.nameList = nameList;
	}
}
