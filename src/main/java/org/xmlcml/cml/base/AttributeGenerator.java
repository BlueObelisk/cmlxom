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

import org.xmlcml.cml.base.AbstractGenerator;
import org.xmlcml.cml.base.AttributeFactory;
import org.xmlcml.cml.base.CMLAttribute;
import org.xmlcml.cml.base.CMLType;
import org.xmlcml.cml.base.CMLUtil;
import org.xmlcml.cml.base.SchemaManager;
import org.xmlcml.euclid.Util;

/**
 * @author pm286
 *
 */
public class AttributeGenerator extends AbstractGenerator {

	private Map<String, CMLAttribute> attributeGroupMap;
	
	/**
	 * @param schemaManager 
	 * 
	 */
	public AttributeGenerator(SchemaManager schemaManager) {
		this.schemaManager = schemaManager;
		init();
	}
	
	private void init() {
		attributeGroupMap = new HashMap<String, CMLAttribute>();
		nameList = new ArrayList<String>();
	}
	
	/** read and assemble.
	 * 
	 * @param indir input directory
	 * @throws Exception
	 */
	public void readAssembleAndIndexSchema(String indir) throws Exception {
		schema = this.readAndAssembleSchemaComponents(indir);
		this.indexSchema();
	}

	/** index the schema.
	 */
	public void indexSchema() {
		List<Node> attributeGroups = CMLUtil.getQueryNodes(schema, "./"+XSD_ATTRIBUTE_GROUP, XPATH_XSD);
		for (Node node : attributeGroups) {
			Element attributeGroupElement = (Element) node;
			String attributeGroupName = attributeGroupElement.getAttributeValue("name");
			if (attributeGroupName == null) {
				System.err.println("No name attribute on attribute");
			} else {
				CMLAttribute attribute = createAttribute(attributeGroupName);
				attributeGroupMap.put(attributeGroupName, attribute);
				nameList.add(attributeGroupName);
			}
		}
	}
	
	/** create attribute given group name.
	 * 
	 * @param attributeGroupName
	 * @return attribute
	 */
	public CMLAttribute createAttribute(String attributeGroupName) {
//		 <xsd:attributeGroup id="attGp.abbreviation" name="abbreviation" 
//			 xmlns:xsd="http://www.w3.org/2001/XMLSchema">
//		  <xsd:attribute id="att.abbreviation" name="abbreviation" type="xsd:string">
//		  ...
//		  </xsd:attribute>
//		 </xsd:attributeGroup>

		CMLAttribute attribute = null;
		// find attributeGroup Element
		List<Node> attributeGroups = CMLUtil.getQueryNodes(schema, 
				"./"+XSD_ATTRIBUTE_GROUP+"[@name='"+attributeGroupName+"']", XPATH_XSD);
		if (attributeGroups.size() != 1) {
			throw new RuntimeException("Cannot find unique attributeGroup: "+attributeGroupName);
		}
		Element attributeGroup = (Element) attributeGroups.get(0);
		// get child Attribute Element
		List<Node> attributes = CMLUtil.getQueryNodes(attributeGroup,
				"./"+XSD_ATTRIBUTE, XPATH_XSD);
		if (attributes.size() != 1) {
			throw new RuntimeException("Cannot find unique attribute: "+attributeGroupName);
		}
		Element attributeElement = (Element) attributes.get(0);
		String attributeName = attributeElement.getAttributeValue("name");
		if (!attributeName.equals(attributeGroupName)) {
//			Util.sysout("NOTE: attributeGroup name != attribute ("+attributeGroupName+
//					" != "+attributeName+")");
		}
		String typeS = attributeElement.getAttributeValue("type");
		if (typeS == null) {
			throw new RuntimeException("No type given for attribute "+attributeGroupName);
		}
		Map<String, CMLType> typeMap = schemaManager.getTypeGenerator().getMap();
		CMLType type = typeMap.get(typeS);
		if (type == null) {
			for (String sss : typeMap.keySet()) {
				Util.println(sss);
			}
			throw new RuntimeException("Cannot find CMLType for "+typeS);
		}
		attribute = AttributeFactory.createCMLAttribute(attributeName, type);
		
		List<Node> summarys = CMLUtil.getQueryNodes(attributeElement, ".//*[@class='summary']");
		String summary = (summarys.size() == 0) ? "No summary" : summarys.get(0).getValue();
		attribute.setSummary(summary);
		
		List<Node> descriptions = CMLUtil.getQueryNodes(attributeElement, ".//*[@class='description']");
		String description = (descriptions.size() == 0) ? "No description" : descriptions.get(0).getValue();
		attribute.setDescription(description);
		
		return attribute;
	}
	
	void printAttributes() {
		for (String name : nameList) {
			Util.println(name);
		}
	}

	/**
	 * @return the attributeGroupMap
	 */
	public Map<String, CMLAttribute> getAttributeGroupMap() {
		return attributeGroupMap;
	}

	/**
	 * @param attributeGroupMap the attributeGroupMap to set
	 */
	public void setAttributeGroupMap(Map<String, CMLAttribute> attributeGroupMap) {
		this.attributeGroupMap = attributeGroupMap;
	}

}
