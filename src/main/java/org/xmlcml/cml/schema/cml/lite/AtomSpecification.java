package org.xmlcml.cml.schema.cml.lite;

import org.apache.log4j.Logger;
import org.xmlcml.cml.schema.ElementSpecification;

public class AtomSpecification extends ElementSpecification {
	private static Logger LOG = Logger.getLogger(AtomSpecification.class);
	public final static String LOCAL_NAME = "atom";
	public AtomSpecification() {
		super(LOCAL_NAME);
	}

	protected void addAddables() {
	}
	protected void addAttributes() {
		this.addAttributes(new String[]{
			"elementType",
		    "id",
		    "x2",
		    "y2",
		    "x3",
		    "y3",
		    "z3",
		    "isotopeNumber",
		    "title",
		    "formalCharge",
		});
	}
	
	/**
	  <pattern id="atom.checks">
	    <title>atom element checks</title>
	    <p><h:p>Describe what further limitations we have put on the atom element</h:p></p>
	    <rule context="cml:atom">
	      <p>
	      Check that the id of this atom is unique within the eldest containing molecule
	      The schema validation specifies that each atom must have an id, this check tests
	      the uniqueness
	      </p>
	      <assert test="count(ancestor::cml:molecule[1]//cml:atom[@id = current()/@id]) = 1">the id of a atom must be unique within the eldest containing molecule (duplicate found: <value-of select="@id" />)</assert>
	      <p>
	      If x2 is present the y2 must be present
	      </p>
	      <assert test="not(@x2) or (@x2 and @y2)">if atom has @x2 then it must have @y2</assert>
	      <p>
	      If y2 is present the x2 must be present
	      </p>
	      <assert test="not(@y2) or (@x2 and @y2)">if atom has @y2 then it must have @x2</assert>
	      <p>
	      If x3 is present then y3 and z3 must be present
	      </p>
	      <assert test="not(@x3) or (@x3 and @y3 and @z3)">if atom has @x3 then it must have @y3 and @z3</assert>
	      <p>
	      If y3 is present then x3 and z3 must be present
	      </p>
	      <assert test="not(@y3) or (@x3 and @y3 and @z3)">if atom has @32 then it must have @x3 and @z3</assert>
	      <p>
	      If x3 is present then y3 and z3 must be present
	      </p>
	      <assert test="not(@z3) or (@x3 and @y3 and @z3)">if atom has @z3 then it must have @x3 and @y3</assert>
	    </rule>    
	  </pattern>
	 */		
	@Override
	protected void addAssertions() {
		this.addAssertions(new String[] {
	      "count(ancestor::cml:molecule[1]//cml:atom[@id = ./@id]) = 1",
	      "not(@x2) or (@x2 and @y2)",
	      "not(@y2) or (@x2 and @y2)",
	      "not(@x3) or (@x3 and @y3 and @z3)",
	      "not(@y3) or (@x3 and @y3 and @z3)",
	      "not(@z3) or (@x3 and @y3 and @z3)",
		});
	}
	/*
	  ( label* & 
	    name* & 
	    atomParity? 
	  ) 
	 */		
	@Override
	protected void addContentModel() {
		this.addContentModel(new String[] {
			"count(cml:atomParity) < 2",
			"count(cml:*[" +
			" not(local-name()='label') and" +
			" not(local-name()='name')  and" +
			" not(local-name()='atomParity')" +
			"]) = 0",
		});
	}
	
	protected void addAllowedChildren() {
		this.addAllowedChildren(new String[]{
			"label",
			"name",
			"atomParity",
		});
	}
}
