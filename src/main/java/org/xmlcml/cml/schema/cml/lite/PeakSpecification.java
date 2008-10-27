package org.xmlcml.cml.schema.cml.lite;

import org.xmlcml.cml.schema.ElementSpecification;

public class PeakSpecification extends ElementSpecification {

	public final static String LOCAL_NAME = "peak";
	public PeakSpecification() {
		super(LOCAL_NAME);
	}

	protected void addAddables() {
	}
	protected void addAttributes() {
		this.addAttributes(new String[]{
				  "id",  
				  "title",
				  "atomRefs", 
				  "bondRefs",
				  "yValue",
				  "xValue",
				  "xMax", 
				  "xMin",
				  "peakMultiplicity",
		});
	}
	/*
	  <pattern id="peak.checks">
	    <title>peak element checks</title>
	    <p><h:p></h:p></p>
	    <rule context="cml:peak">
	      <p>
	        if peak has yValue then all peaks in this peakList should have yValue
	      </p>
	      <assert test="@yValue and count(ancestor::cml:peakList[1]//cml:peak/@yValue) = count(ancestor::cml:peakList[1]//cml:peak)">if peak has yValue then all peaks should have yValue</assert>
	      <p>
	        <h:p>
	        A peak must have xMax if xMin is specified and visa versa, it must also always have a value 
	        - whether this is specified using xMax and xMin just by xValue.
	        </h:p>
	      </p>    
	      <assert test="@xValue or (xMax and xMin)">the peak must have xValue and/or (xMax and xMin)</assert>
	      <assert test="not(@xMax) or (@xMax and @xMin)">peak must not have an isolated xMax attribute</assert>
	      <assert test="not(@xMin) or (@xMax and @xMin)">peak must not have an isolated xMin attribute</assert> 
	    </rule>    
	  </pattern>
	 */		
	@Override
	protected void addAssertions() {
		this.addAssertions(new String[] {
			"@yValue and count(ancestor::cml:peakList[1]//cml:peak/@yValue) = count(ancestor::cml:peakList[1]//cml:peak)",
			"@xValue or (xMax and xMin)",
			"not(@xMax) or (@xMax and @xMin)",
			"not(@xMin) or (@xMax and @xMin)",
		});
	}
	/*
	  ( label * & 
	    name * & 
	    peakStructure *
	  )
	  */
	@Override
	protected void addContentModel() {
		this.addContentModel(new String[] {
			"count(cml:*[" +
			" not(local-name()='label') and" +
			" not(local-name()='name')  and" +
			" not(local-name()='peakStructure')" +
			"]) = 0",
		});
	}

	protected void addAllowedChildren() {
		this.addAllowedChildren(new String[]{
			"label",
			"name",
			"peakStructure",
		});
	}

}
