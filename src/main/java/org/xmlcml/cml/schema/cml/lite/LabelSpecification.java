package org.xmlcml.cml.schema.cml.lite;

import org.xmlcml.cml.schema.ElementSpecification;
import org.xmlcml.cml.schema.TypeSpecification;

public class LabelSpecification extends ElementSpecification {

	public final static String LOCAL_NAME = "label";
	public LabelSpecification() {
		super(LOCAL_NAME);
	}

	protected void addAddables() {
	}
	protected void addAttributes() {
		this.addAttributes(new String[]{
		    "id",
		    "dictRef",
		    "convention",
		});
	}
	/**
	  <pattern id="label.checks">
	    <title>label element checks</title>
	    <p><h:p>labels should have convention specified if at all possible</h:p></p>
	    <rule context="cml:label">
	      <assert test="not(@convention)">label should have convention specified if at all possible</assert>
	    </rule>
	  </pattern>
	  */
	@Override
	protected void addAssertions() {
		this.addAssertions(new String[] {
		    "not(@convention)"
		});
	}
	@Override
	protected void addContentModel() {
		this.addContent(TypeSpecification.STRING_TYPE);		
	}
	
	protected void addAllowedChildren() {
	}
}
