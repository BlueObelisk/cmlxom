package org.xmlcml.cml.schema.cml.lite;

import org.xmlcml.cml.schema.ElementSpecification;

public class MoleculeSpecification extends ElementSpecification {

	public final static String LOCAL_NAME = "molecule";
	public MoleculeSpecification() {
		super(LOCAL_NAME);
	}

	protected void addAddables() {
		this.addAddables(new String[] {
			"atom",
			"bond",
			"molecule"
		});
	}
	protected void addAttributes() {
		this.addAttributes(new String[]{
		    "id",
		    "title",
		    "count",
		    "formalCharge",
		    "spinMultiplicity",
		    "ref",
		    "chirality",
		    "convention",
		});
	}
	/*
	  <pattern id="molecule.checks">
	    <title>molecule element checks</title>
	    <p><h:p><div class="question">how unique should the ids of molecule be?</div></h:p></p>
	    <rule context="cml:molecule">
	      <assert test="@count or not(ancestor::cml:molecule)">molecule children of molecule require a count</assert>
	      <assert test="not(@count) or (floor(@count) = number(@count))">@count must be integer</assert>
	    </rule>    
	  </pattern>
	 */		
	@Override
	protected void addAssertions() {
		this.addAssertions(new String[] {
			"@count or not(ancestor::cml:molecule)",
			"not(@count) or (floor(@count) = number(@count))",
		});
	}
	/**
  ( atomArray ? & 
    bondArray ? & 
    formula ? & 
    label * & 
    molecule * & 
    name * & 
    property * & 
    spectrum * &
    cml*
  )
	*/		
	@Override
	protected void addContentModel() {
		this.addContentModel(new String[] {
				"count(*[not(" +
				"local-name() = 'atomArray' or " +
				"local-name() = 'bondArray' or " +
				"local-name() = 'formula' or " +
				"local-name() = 'label' or " +
				"local-name() = 'molecule' or " +
				"local-name() = 'name' or " +
				"local-name() = 'property' or " +
				"local-name() = 'spectrum' or " +
				"local-name() = 'cml'" +
				") = 0]",
				"count(atomArray) < 2",
				"count(bondArray) < 2",
				"count(formula) < 2",
		});
	}

	protected void addAllowedChildren() {
		this.addAllowedChildren(new String[]{
			"atomArray",
			"bondArray",
			"formula",
			"label",
			"molecule",
			"name",
			"property",
			"spectrum",
			"cml"
		});
	}
}
