package org.xmlcml.cml.schema.cml.lite;

import org.xmlcml.cml.schema.ElementSpecification;

public class AnySpecification extends ElementSpecification {

	public final static String LOCAL_NAME = "#any";
	public AnySpecification() {
		super(LOCAL_NAME);
	}

	protected void addAddables() {
	}
	protected void addAttributes() {
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
