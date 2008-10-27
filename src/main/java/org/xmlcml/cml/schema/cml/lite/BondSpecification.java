package org.xmlcml.cml.schema.cml.lite;

import org.xmlcml.cml.schema.ElementSpecification;

public class BondSpecification extends ElementSpecification {

	public final static String LOCAL_NAME = "bond";
	public BondSpecification() {
		super(LOCAL_NAME);
	}

	protected void addAddables() {
	}
	protected void addAttributes() {
		this.addAttributes(new String[]{
			    "id",
			    "atomRefs2",
			    "order",
			    "title",
		});
	}
	/**
	  <pattern id="bond.checks">
	    <title>bond element checks</title>
	    <p><h:p>Describe what further limitations we have put on the atom element</h:p></p>
	    <rule context="cml:bond">
	      <p>
	        Check that the first atom in the atomRefs2 attribute exists within the same molecule        
	      </p>
	      <assert test="index-of(ancestor::cml:molecule[1]//cml:atom/@id, substring-before(@atomRefs2, ' ')) > 0">the atoms in the atomRefs2 must be within the eldest containing molecule (found <value-of select="substring-before(@atomRefs2, ' ')" />)</assert>
	      <p>
	        Check that the second atom in the atomRefs2 attribute exists within the same molecule        
	      </p>
	      <assert test="index-of(ancestor::cml:molecule[1]//cml:atom/@id, substring-after(@atomRefs2, ' ')) > 0">the atoms in the atomRefs2 must be within the eldest containing molecule (found <value-of select="substring-after(@atomRefs2, ' ')" />)</assert>
	      <p>
	        Check that the first atom and second atom in atomRefs2 are not the same
	      </p>
	      <assert test="not(substring-before(@atomRefs2, ' ') = substring-after(@atomRefs2, ' '))">a bond must be between different atoms</assert>
	      <p>
	      Check that the id of this bond is unique within the eldest containing molecule
	      The schema validation specifies that each bond must have an id, this check tests
	      the uniqueness
	      </p>
	      <assert test="count(ancestor::cml:molecule[1]//cml:bond[@id = current()/@id]) = 1">the id of a bond must be unique within the eldest containing molecule (duplicate found: <value-of select="@id" />)</assert>
	    </rule>    
	  </pattern>
	 */		
	@Override
	protected void addAssertions() {
		this.addAssertions(new String[] {
				"index-of(ancestor::cml:molecule[1]//cml:atom/@id, substring-before(@atomRefs2, ' ')) > 0",
				"index-of(ancestor::cml:molecule[1]//cml:atom/@id, substring-after(@atomRefs2, ' ')) > 0",
				"not(substring-before(@atomRefs2, ' ') = substring-after(@atomRefs2, ' '))",
				"count(ancestor::cml:molecule[1]//cml:bond[@id = current()/@id]) = 1",
		});
	}
	/*
	   ( label* & 
	     name* & 
	     bondStereo?  
	   ) 
	 */		
	@Override
	protected void addContentModel() {
		this.addContentModel(new String[] {
			"count(cml:atomParity) < 2",
			"count(cml:*[" +
			" not(local-name()='label') and" +
			" not(local-name()='name')  and" +
			" not(local-name()='bondStereo')" +
			"]) = 0",
		});
	}
	
	protected void addAllowedChildren() {
		this.addAllowedChildren(new String[]{
			"label",
			"name",
			"bondStereo",
		});
	}
}
