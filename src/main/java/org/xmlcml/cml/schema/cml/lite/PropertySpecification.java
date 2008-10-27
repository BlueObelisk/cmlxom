package org.xmlcml.cml.schema.cml.lite;

import org.xmlcml.cml.schema.ElementSpecification;

public class PropertySpecification extends ElementSpecification {

	public final static String LOCAL_NAME = "property";
	public PropertySpecification() {
		super(LOCAL_NAME);
	}

	protected void addAddables() {
	}
	protected void addAttributes() {
		this.addAttributes(new String[]{
			    "id",
			    "dictRef",
			    "title",
		});
	}
	@Override
	protected void addAssertions() {
	}
	/*
	  ( name * &
	    label * &
	    ( scalar ? | 
	      property +
	    )
	  )
	 */		  
	@Override
	protected void addContentModel() {
		this.addContentModel(new String[] {
				"(" +
				" count(cml:property) > 0 or " +
				" count(cml:scalar) < 2)" +
				" and (count(cml:*[" +
				" not(local-name() = 'cml:property) and" +
				" not(local-name() = 'cml:scalar) and" +
				" not(local-name() = 'cml:label) and" +
				" not(local-name() = 'cml:name)]" +
				") = 0)"
		});
	}

	protected void addAllowedChildren() {
		this.addAllowedChildren(new String[]{
			"label",
			"name",
			"scalar",
			"property"
		});
	}
}
