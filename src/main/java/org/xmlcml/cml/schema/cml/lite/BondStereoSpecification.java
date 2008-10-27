package org.xmlcml.cml.schema.cml.lite;

import org.xmlcml.cml.schema.ElementSpecification;
import org.xmlcml.cml.schema.TypeSpecification;

public class BondStereoSpecification extends ElementSpecification {

	public final static String LOCAL_NAME = "bondStereo";
	public BondStereoSpecification() {
		super(LOCAL_NAME);
	}

	protected void addAddables() {
	}
	protected void addAttributes() {
		this.addAttributes(new String[]{
		    "id",
		    "atomRefs4",
		    "convention",
		});
	}
	/**
	  <pattern id="bondStereo.checks">
	    <title>bondStereo element checks</title>
	    <p><h:p>Describe what further limitations we have put on the bondStereo element</h:p></p>
	    <rule context="cml:bondStereo">
	      <h:p>
	        CMLLite only supports wedge/hatch and cis/trans bonds but CML allows 
	        for any convention to be used <h:div class='question'>can we have a flag?</h:div>        
	      </h:p>
	      <report test="not(@convention='cml:wedgehatch') or not(@convention='cml:cistrans')">only cml:wedgehatch and cml:cistrans bondStereo are currently supported</report>
	      <assert test="@convention='cml:wedgehatch' and not(@atomRefs4)">atomRefs4 should not be present for wedge/hatch bondStereo</assert>
	      <assert test="@convention='cml:cistrans' and @atomRefs4">atomRefs4 are required for cis/trans bondStereo (to define what is cis or trans to what)</assert>
	      <h:p>
	        If the convention is cml:wedgehatch then the content should be either W or H
	        <h:div class="question">should we normalise space ??</h:div>
	      </h:p>
	      <assert test="(@convention='cml:wedgehatch' and . = 'W') or (@convention='cml:wedgehatch' and . = 'H')">
	        if the convention is cml:wedgehatch then the content should be either W or H
	      </assert>
	      <h:p>
	        If the convention is cml:cistrans then the content should be either C or T
	        <h:div class="question">should we normalise space ??</h:div>
	      </h:p>
	      <assert test="(@convention='cml:cistrans' and . = 'C') or (@convention='cml:cistrans' and . = 'T')">
	        if the convention is cml:cistrans then the content should be either C or T
	      </assert>
	    </rule>
	  </pattern>
	 */		
	@Override
	protected void addAssertions() {
		this.addAssertions(new String[] {
			"@convention='cml:wedgehatch' and not(@atomRefs4)",
			"@convention='cml:cistrans' and @atomRefs4",
			"(@convention='cml:wedgehatch' and . = 'W') or (@convention='cml:wedgehatch' and . = 'H')",
			"(@convention='cml:cistrans' and . = 'C') or (@convention='cml:cistrans' and . = 'T')",
		});
	}
	@Override
	protected void addContentModel() {
		this.addContent(TypeSpecification.STRING_TYPE);		
	}
	
	protected void addAllowedChildren() {
	}
}
