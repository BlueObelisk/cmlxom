package org.xmlcml.cml.schema.cml.lite;

import org.xmlcml.cml.schema.ElementSpecification;

public class FormulaSpecification extends ElementSpecification {

	public final static String LOCAL_NAME = "formula";
	public FormulaSpecification() {
		super(LOCAL_NAME);
	}

	protected void addAddables() {
		this.addAddables(new String[] {
			"formula"
		});
	}
	protected void addAttributes() {
		this.addAttributes(new String[]{
		    "id",
		    "title",
		    "convention",
		    "count",
		    "formalCharge",
		    "concise",
		    "inline",
		});
	}
	/*
	  <pattern id="formula.checks">
	    <title>formula element checks</title>
	    <p><h:p>Describe what further limitations we have put on the atom element</h:p></p>
	    <rule context="cml:formula">
	      <assert test="@count or not(ancestor::cml:formula)">formula children of formula require a count</assert>
	      <assert test="not(@count) or (floor(@count) = number(@count))">@count must be integer</assert>
	      <report test="not(@concise)">a formula should have @concise if at all possible</report>
	    </rule>    
	  </pattern>
	 */		
	@Override
	protected void addAssertions() {
		this.addAssertions(new String[] {
			"@count or not(ancestor::cml:formula)",
			"not(@count) or (floor(@count) = number(@count))",
		});
		this.addReports(new String[] {
			"not(@concise)",
		});
	}
	/*
	  ( empty | 
	    atomArray | 
	    ( formula, formula + ) 
	  )
	 */		
	@Override
	protected void addContentModel() {
		this.addContentModel(new String[] {
			"count(text()) = 0",
			"count(*) = 0 or " +
			"count(cml:atomArray) = 1 or " +
			"count(cml:formula) > 1",
		});
	}
	
	protected void addAllowedChildren() {
		this.addAllowedChildren(new String[]{
			"atomArray",
			"formula",
		});
	}
}
