package org.xmlcml.cml.schema.cml.lite;

import org.xmlcml.cml.schema.ElementSpecification;

public class PeakStructureSpecification extends ElementSpecification {

	public final static String LOCAL_NAME = "peakStructure";
	public PeakStructureSpecification() {
		super(LOCAL_NAME);
	}

	protected void addAddables() {
	}
	protected void addAttributes() {
		this.addAttributes(new String[]{
			    "id",
			    "dictRef",
			    "convention",
				"title",
				"atomRefs",
				"bondRefs",
				"peakShape",
		});
	}
	@Override
	protected void addAssertions() {
	}
	/*
	  ( name * &
	    label * 
	  ) 
	 */		
	@Override
	protected void addContentModel() {
		this.addContentModel(new String[] {
			"count(cml:*[" +
			" not(local-name() = 'name') and " +
			" not(local-name() = 'label')" +
			"]) = 0",
		});
	}
	
	protected void addAllowedChildren() {
		this.addAllowedChildren(new String[]{
			"label",
			"name",
		});
	}
}
