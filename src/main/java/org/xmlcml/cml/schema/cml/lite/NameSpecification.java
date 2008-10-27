package org.xmlcml.cml.schema.cml.lite;

import org.xmlcml.cml.schema.ElementSpecification;
import org.xmlcml.cml.schema.TypeSpecification;

public class NameSpecification extends ElementSpecification {

	public final static String LOCAL_NAME = "name";
	public NameSpecification() {
		super(LOCAL_NAME);
	}

	protected void addAddables() {
	}
	protected void addAttributes() {
		this.addAttributes(new String[]{
			    "id",
			    "convention",
		});
	}
	@Override
	protected void addAssertions() {
	}
	@Override
	protected void addContentModel() {
		this.addContent(TypeSpecification.STRING_TYPE);		
	}
	
	protected void addAllowedChildren() {
	}
}
