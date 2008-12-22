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

import org.apache.log4j.Logger;


/**
 * @author pm286
 *
 */
public class TypeGenerator extends AbstractGenerator {
	private static Logger LOG = Logger.getLogger(TypeGenerator.class);

	Map<String, CMLType> map;
	/**
	 * @param schemaManager 
	 * 
	 */
	public TypeGenerator(SchemaManager schemaManager) {
		this.schemaManager= schemaManager;
		init();
	}
	
	private void init() {
		map = new HashMap<String, CMLType>();
		nameList = new ArrayList<String>();
	}

	/** make full CMLTypes for xsd:string, etc. */
	
	void addXSDTypes() {
		CMLType type = new CMLType();
		type.setName(XSD_STRING);
		type.setJavaType(XSD_STRING);
		map.put(XSD_STRING, type);
		
		type = new CMLType();
		type.setName(XSD_QNAME);
		type.setJavaType(XSD_STRING);
		type.setPattern(PATTERN_QNAME);
		map.put(XSD_QNAME, type);
		
		type = new CMLType();
		type.setName(XSD_ANYURI);
		type.setJavaType(XSD_STRING);
		type.setPattern(PATTERN_ANYURI);
		map.put(XSD_ANYURI, type);
		
		type = new CMLType();
		type.setName(XSD_DOUBLE);
		type.setJavaType(XSD_DOUBLE);
		map.put(XSD_DOUBLE, type);
		
		type = new CMLType();
		type.setName(XSD_FLOAT);
		type.setJavaType(XSD_DOUBLE);
		map.put(XSD_FLOAT, type);
		
		type = new CMLType();
		type.setName(XSD_INTEGER);
		type.setJavaType(XSD_INTEGER);
		map.put(XSD_INTEGER, type);
		
		type = new CMLType();
		type.setName(XSD_NONNEGATIVEINTEGER);
		type.setJavaType(XSD_INTEGER);
		type.setMinInclusive((int)0);
		map.put(XSD_NONNEGATIVEINTEGER, type);
		
		type = new CMLType();
		type.setName(XSD_POSITIVEINTEGER);
		type.setJavaType(XSD_INTEGER);
		type.setMinInclusive((int)1);
		map.put(XSD_POSITIVEINTEGER, type);

		type = new CMLType();
		type.setName(XSD_BOOLEAN);
		type.setJavaType(XSD_BOOLEAN);
		map.put(XSD_BOOLEAN, type);
		
		type = new CMLType();
		type.setName(XSD_POSITIVEINTEGER);
		type.setJavaType(XSD_INTEGER);
		type.setMinInclusive(1);
		map.put(XSD_POSITIVEINTEGER, type);
		
	}
	
	private boolean processJavaTypes() {
		boolean change = false;
		for (String name : nameList) {
			CMLType type = map.get(name);
			String javaType = type.getJavaType();
			if (javaType == null) {
				String base = type.getBase();
				if (base != null) {
					CMLType baseType = map.get(base);
					if (baseType == null) {
						throw new RuntimeException("cannot find base type: "+base);
					}
					String baseJavaType = baseType.getJavaType();
					if (baseJavaType == null) {
//						LOG.debug("base type "+base+" has null javaType");
						continue;
					}
					type.setJavaType(baseJavaType);
					change = true;
				}
			}
		}
		return change;
	}

	private boolean checkJavaTypes() {
		boolean ok = true;
		for (String name : nameList) {
			CMLType type = map.get(name);
			String javaType = type.getJavaType();
			String base = type.getBase();
			if (javaType == null && base != null) {
				ok = false;
				System.err.println("no javaType for "+base);
			}
		}
		return ok;
	}
	
	/**
	 * @return the map
	 */
	public Map<String, CMLType> getMap() {
		return map;
	}

	/**
	 * @param map the map to set
	 */
	public void setMap(Map<String, CMLType> map) {
		this.map = map;
	}

	/** read and assemble.
	 * 
	 * @param indir
	 * @throws Exception
	 */
	public void readAssembleAndIndexSchema(String indir) throws Exception {
		this.readAndAssembleSchemaComponents(indir);
		this.indexSchema();
	}

	/** index schema.
	 */
	public void indexSchema() {
		List<Node> simpleTypes = CMLUtil.getQueryNodes(schema, "./"+XSD_SIMPLE_TYPE, XPATH_XSD);
		// supertypes may not all be in place, so iterate until all are found
		addXSDTypes();
		for (Node node : simpleTypes) {
			Element simpleTypeElement = (Element) node;
			String name = simpleTypeElement.getAttributeValue("name");
			if (name == null) {
				System.err.println("No name attribute on simpleType");
				CMLUtil.debug(simpleTypeElement, "TYPEGEN");
			} else {
				try {
					CMLType type = new CMLType(simpleTypeElement);
					map.put(name, type);
					nameList.add(name);
				} catch (Exception e) {
					LOG.error("Cannot create "+name+"..."+e);
				}
			}
		}

		boolean change = true;
		while (change) {
			change = processJavaTypes();
			if (!change) {
				break;
			}
		}
		if (!checkJavaTypes()) {
			throw new RuntimeException("unresolved javaTypes");
		}
		
		for (String name : nameList) {
			CMLType type = map.get(name);
			type.createMinMaxAndEnumerations();
		}
	}
}
