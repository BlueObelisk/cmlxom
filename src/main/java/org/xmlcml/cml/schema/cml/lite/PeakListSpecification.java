package org.xmlcml.cml.schema.cml.lite;

import org.xmlcml.cml.schema.ElementSpecification;

public class PeakListSpecification extends ElementSpecification {

	public final static String LOCAL_NAME = "peakList";
	public PeakListSpecification() {
		super(LOCAL_NAME);
	}

	protected void addAddables() {
	}
	protected void addAttributes() {
		this.addAttributes(new String[]{
		    "id",
		    "xUnits",
		    "title",
		    "yUnits",
		});
	}
	/**
	  <pattern id="peakList.checks">
	    <title>peakList element checks</title>
	    <rule context="cml:peakList">
	    <p><h:p>peakList must containt at least one peak</h:p></p>
	      <assert test="count(.//cml:peak) >= 1">peakList must contain at least one peak element</assert>
	    <p><h:p>peakList must have yUnits specified if any of the peaks have yValue</h:p></p>
	      <assert test="count(.//cml:peak[@yValue]) > 0 and @yUnits">if peaks have y values then peakList must specify yUnits</assert>
	    </rule>    
	  </pattern>

	 */		
	@Override
	protected void addAssertions() {
		this.addAssertions(new String[] {
				"count(.//cml:peak) >= 1",
				"count(.//cml:peak[@yValue]) > 0 and @yUnits",
		});
	}
	/*
	  peak +
	  */
	@Override
	protected void addContentModel() {
		this.addContentModel(new String[] {
				"count(cml:*[not(local-name() = 'peak')]) = 0 and" +
				"count(cml:peak) > 0)"
		});
	}
	
	protected void addAllowedChildren() {
		this.addAllowedChildren(new String[]{
			"peak",
		});
	}
}
