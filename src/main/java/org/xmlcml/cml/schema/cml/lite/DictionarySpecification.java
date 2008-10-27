package org.xmlcml.cml.schema.cml.lite;

import org.xmlcml.cml.schema.ElementSpecification;

public class DictionarySpecification extends ElementSpecification {

	public final static String LOCAL_NAME = "dictionary";
	public DictionarySpecification() {
		super(LOCAL_NAME);
	}

	protected void addAddables() {
	}
	protected void addAttributes() {
		this.addAttributes(new String[]{
			    "id",
			    "title",
			    "namespace",
			    "convention",
		});
	}
	@Override
	protected void addAssertions() {
	}
	/*
	  entry +  
	 */		
	@Override
	protected void addContentModel() {
		this.addContentModel(new String[] {
			"count(cml:*[" +
			" not(local-name()='entry')" +
			"]) = 0",
		});
	}
	
	protected void addAllowedChildren() {
		this.addAllowedChildren(new String[]{
			"entry",
		});
	}
}
