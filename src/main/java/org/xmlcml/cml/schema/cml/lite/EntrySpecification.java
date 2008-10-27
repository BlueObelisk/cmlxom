package org.xmlcml.cml.schema.cml.lite;

import org.xmlcml.cml.schema.ElementSpecification;

public class EntrySpecification extends ElementSpecification {

	public final static String LOCAL_NAME = "entry";
	public EntrySpecification() {
		super(LOCAL_NAME);
	}

	protected void addAddables() {
	}
	protected void addAttributes() {
		this.addAttributes(new String[]{
		    "id",
		    "dictRef",
		    "dataType",
		    "convention",
		    "title",
		    "term",
		    "convention",
		});
	}
	@Override
	protected void addAssertions() {
	}
	@Override
	protected void addContentModel() {
	}
	
	protected void addAllowedChildren() {
	}
}
