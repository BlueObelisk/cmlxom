package org.xmlcml.cml.schema.cml.lite;

import org.xmlcml.cml.schema.ElementSpecification;

public class AtomArraySpecification extends ElementSpecification {

	public final static String LOCAL_NAME = "atomArray";
	public AtomArraySpecification() {
		super(LOCAL_NAME);
	}

	protected void addAddables() {
	}
	protected void addAttributes() {
		this.addAttributes(new String[]{
			    "id",
		});
	}
/**
  <pattern id="atomArray.checks">
    <title>atomArray element checks</title>
    <p>
    <h:p>
      <h:div class="question">
        atomArray must be in either molecule or formula but could be enclosed in a cml element (perhaps for some bizarre grouping)
      </h:div>
    </h:p>
    </p>
    <rule context="cml:atomArray">
      <assert test="ancestor::cml:molecule or ancestor::cml:formula">atomArray must be found in either a molecule or a formula</assert>
      <h:p>an atomArray must contain atoms</h:p>
      <assert test=".//cml:atom">an atomArray must contain atoms</assert>
    </rule>    
  </pattern>
 */		
	@Override
	protected void addAssertions() {
		this.addAssertions(new String[] {
				"ancestor::cml:molecule or ancestor::cml:formula",
				".//cml:atom",
		});
	}
	/*
	  atom +
	 */		
	@Override
	protected void addContentModel() {
		this.addContentModel(new String[] {
			"count(cml:*[" +
			" not(local-name()='atom')" +
			"]) = 0",
		});
	}
	
	protected void addAllowedChildren() {
		this.addAllowedChildren(new String[]{
			"atom",
		});
	}
}
