package org.xmlcml.cml.schema.cml.lite;

import org.xmlcml.cml.schema.ElementSpecification;
import org.xmlcml.cml.schema.TypeSpecification;

public class ScalarSpecification extends ElementSpecification {

	public final static String LOCAL_NAME = "scalar";
	public ScalarSpecification() {
		super(LOCAL_NAME);
	}

	protected void addAddables() {
	}
	protected void addAttributes() {
		this.addAttributes(new String[]{
			    "id",
			    "min",
			    "max",
			    "dataType",
			    "dictRef",
			    "units",
		});
	}
	/**
	  <pattern id="scalar.checks">
	    <title>scalar element checks</title>
	    <p><h:p>Describe what further limitations we have put on the cml element</h:p></p>
	    <rule context="cml:scalar">
	      <assert test="count(@max | @min | text()) >= 1">scalar must have one or more max, min or content</assert>
	    </rule>
	  </pattern>
	 */		
	@Override
	protected void addAssertions() {
		this.addAssertions(new String[] {
			"count(@max | @min | text()) >= 1"
		});
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
		this.addContent(TypeSpecification.STRING_TYPE);		
	}
	
	protected void addAllowedChildren() {
	}
}
