package org.xmlcml.cml.schema.cml.lite;

import org.xmlcml.cml.schema.ElementSpecification;

public class SpectrumSpecification extends ElementSpecification {

	public final static String LOCAL_NAME = "spectrum";
	public SpectrumSpecification() {
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
	/**
	# child elements
	( peakList & 
	property *
	)
	*/		
	@Override
	protected void addContentModel() {
		this.addContentModel(new String[] {
			" count(cml:peakList) > 0 and " +
			" and (count(cml:*[" +
			" not(local-name() = 'cml:peakList) and" +
			" not(local-name() = 'cml:property)]" +
			") = 0)"
		});
	}
	protected void addAllowedChildren() {
		this.addAllowedChildren(new String[]{
			"property",
			"peakList",
		});
	}
}
