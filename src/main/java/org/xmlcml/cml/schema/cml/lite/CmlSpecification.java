package org.xmlcml.cml.schema.cml.lite;

import org.xmlcml.cml.schema.ElementSpecification;

public class CmlSpecification extends ElementSpecification {

	public final static String LOCAL_NAME = "cml";
	public CmlSpecification() {
		super(LOCAL_NAME);
	}

	protected void addAddables() {
	}
	protected void addAttributes() {
		this.addAttributes(new String[]{
		    "id",
		    "title",
		    "version",
		    "convention",
		});
	}
	/**
	  <pattern id="cml.checks">
	    <title>CML element checks</title>
	    <p><h:p>Describe what further limitations we have put on the cml element</h:p></p>
	    <rule context="cml:cml">
	      <assert test="@convention or ancestor::cml:cml">the eldest cml element must have @convention</assert>
	      <assert test="@version or ancestor::cml:cml">the eldest cml element must have @version</assert>
	      <p>
	      This schematron is designed to validate CMLLite, therefore if the convention is not CMLLite we should be worried - however,
	      it is possible that we want to validate more than just CMLLite (many of the restrictions placed on ordering etc make it 
	      easier to use this form of CML rather than the more general form) maybe we can introduce a flag to turn on CMLLite validation
	      or looser validation
	      </p>
	      <assert test="(@convention = 'CMLLite') or ancestor::cml:cml">'CMLLite' expected as @convention on the eldest cml element</assert>
	    </rule>
	  </pattern>
	 */	
	@Override
	protected void addAssertions() {
		this.addAssertions(new String[] {
		        "@convention or ancestor::cml:cml",
		        "@version or ancestor::cml:cml",
		        "(@convention = 'CMLLite') or ancestor::cml:cml",
		});
	}
	/**
	  anyElement # we don't allow mixed content in CML but it may be wrapped by html for example
	 */		
	@Override
	protected void addContentModel() {
		this.addContentModel(new String[] {
			"count(text()) = 0",
		});
	}
	protected void addAllowedChildren() {
		this.addAllowedChildren(new String[]{
			"#any",
		});
	}
}
