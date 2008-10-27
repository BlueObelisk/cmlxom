package org.xmlcml.cml.schema.cml.lite;

import org.xmlcml.cml.schema.ElementSpecification;

public class BondArraySpecification extends ElementSpecification {

	public final static String LOCAL_NAME = "bondArray";
	public BondArraySpecification() {
		super(LOCAL_NAME);
	}

	protected void addAddables() {
	}
	protected void addAttributes() {
		this.addAttributes(new String[]{
			    "id",
		});
	}
	@Override
	protected void addAssertions() {
	}
	/**
	  bond+  
	 */		
	@Override
	protected void addContentModel() {
		this.addContentModel(new String[] {
			"count(cml:*[" +
			" not(local-name()='bond')" +
			"]) = 0",
		});
	}
	protected void addAllowedChildren() {
		this.addAllowedChildren(new String[]{
			"bond",
		});
	}
}
