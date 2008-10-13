/**
 * 
 */
package org.xmlcml.cml.base;

import nu.xom.Document;


/**
 * @author pm286
 *
 */
public class SchemaManager implements CMLConstants {

	/** aggregated types*/
	public static final String TYPES_XSD = "org/xmlcml/cml/base/types.xsd";
	/** aggregated elements*/
	public static final String ELEMENTS_XSD = "org/xmlcml/cml/base/elements.xsd";
	/** aggregated attributes*/
	public static final String ATTRIBUTEGROUPS_XSD = "org/xmlcml/cml/base/attributes.xsd";
	

	private AttributeGenerator attributeGenerator;
	private ElementGenerator elementGenerator;
	private TypeGenerator typeGenerator;
	private String outdir;

	/** constructor.
	 */
	public SchemaManager() {
		attributeGenerator = new AttributeGenerator(this);
		elementGenerator = new ElementGenerator(this);
		typeGenerator = new TypeGenerator(this);
//		readAndCreateIndexes();
	}
	
	/** read and create indexes.
	 */
	public void readAndCreateIndexesFromSchemaFiles() {
		try {
			Document typeSchemaDoc = CMLUtil.getXMLResource(TYPES_XSD);
			typeGenerator.setSchema(typeSchemaDoc.getRootElement());
			typeGenerator.addXSDTypes();
			typeGenerator.indexSchema();

			Document attributeSchemaDoc = CMLUtil.getXMLResource(ATTRIBUTEGROUPS_XSD);
			attributeGenerator.setSchema(attributeSchemaDoc.getRootElement());
			attributeGenerator.indexSchema(); 
			
			Document elementSchemaDoc = CMLUtil.getXMLResource(ELEMENTS_XSD);
			elementGenerator.setSchema(elementSchemaDoc.getRootElement());
			elementGenerator.indexSchema();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Cannot index schemas: "+e);
		}
	}

	/**
	 * @return the attributeGenerator
	 */
	public AttributeGenerator getAttributeGenerator() {
		return attributeGenerator;
	}

	/**
	 * @param attributeGenerator the attributeGenerator to set
	 */
	public void setAttributeGenerator(AttributeGenerator attributeGenerator) {
		this.attributeGenerator = attributeGenerator;
	}

	/**
	 * @return the elementGenerator
	 */
	public ElementGenerator getElementGenerator() {
		return elementGenerator;
	}

	/**
	 * @param elementGenerator the elementGenerator to set
	 */
	public void setElementGenerator(ElementGenerator elementGenerator) {
		this.elementGenerator = elementGenerator;
	}

	/**
	 * @return the typeGenerator
	 */
	public TypeGenerator getTypeGenerator() {
		return typeGenerator;
	}

	/**
	 * @param typeGenerator the typeGenerator to set
	 */
	public void setTypeGenerator(TypeGenerator typeGenerator) {
		this.typeGenerator = typeGenerator;
	}

	/**
	 * @return the outdir
	 */
	public String getOutdir() {
		return outdir;
	}

	/**
	 * @param outdir the outdir to set
	 */
	public void setOutdir(String outdir) {
		this.outdir = outdir;
	}

}
