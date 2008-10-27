package org.xmlcml.cml.schema.cml.lite;

import org.apache.log4j.Logger;
import org.xmlcml.cml.schema.ElementSpecification;
import org.xmlcml.cml.schema.TypeSpecification;

public class AtomParitySpecification extends ElementSpecification {
	private static Logger LOG = Logger.getLogger(AtomParitySpecification.class);

	public final static String LOCAL_NAME = "atomParity";
	public AtomParitySpecification() {
		super(LOCAL_NAME);
	}

	protected void addAddables() {
	}
	protected void addAttributes() {
		this.addAttributes(new String[]{
			    "id",
			    "atomRefs4"
		});
	}
	@Override
	protected void addAssertions() {
	}
	/*
	  real
	 */		
	@Override
	protected void addContentModel() {
		this.addContent(TypeSpecification.REALNUMBER_TYPE);		
	}
	
	protected void addAllowedChildren() {
	}
}
