package org.xmlcml.cml.command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nu.xom.Element;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import static org.xmlcml.cml.base.CMLConstants.*;

public class ElementNG {
	public static Logger LOG = Logger.getLogger(ElementNG.class);
	static {
		LOG.setLevel(Level.DEBUG);
	}
	
	public final static ElementNG ANY;
	public final static ElementNG ATOM;
	public final static ElementNG ATOMARRAY;
	public final static ElementNG ATOMPARITY;
	public final static ElementNG BOND;
	public final static ElementNG BONDARRAY;
	public final static ElementNG BONDSTEREO;
	public final static ElementNG CML;
	public final static ElementNG DICTIONARY ;
	public final static ElementNG ENTRY;
	public final static ElementNG FORMULA;
	public final static ElementNG LABEL;
	public final static ElementNG MOLECULE;
	public final static ElementNG NAME;
	public final static ElementNG PEAK;
	public final static ElementNG PEAKLIST;
	public final static ElementNG PEAKSTRUCTURE;
	public final static ElementNG PROPERTY;
	public final static ElementNG SCALAR;
	public final static ElementNG SPECTRUM;

	public final static Map<String, ElementNG> ELEMENTMAP;
	static {
		ELEMENTMAP = new HashMap<String, ElementNG>();
		
		//==============================================================
		ANY = new ElementNG("#any");
		ELEMENTMAP.put("#any", ANY);
		
		//==============================================================
		ATOM = new ElementNG("atom");
		ELEMENTMAP.put("atom", ATOM);
		ATOM.addAttributes(new String[]{
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
		ATOM.addAssertions(new String[] {
	      "count(ancestor::cml:molecule[1]//cml:atom[@id = current()/@id]) = 1",
	      "not(@x2) or (@x2 and @y2)",
	      "not(@y2) or (@x2 and @y2)",
	      "not(@x3) or (@x3 and @y3 and @z3)",
	      "not(@y3) or (@x3 and @y3 and @z3)",
	      "not(@z3) or (@x3 and @y3 and @z3)",
		});
/*
  ( label* & 
    name* & 
    atomParity? 
  ) 
 */		
		ATOM.addContentModel(new String[] {
			"count(cml:atomParity) < 2",
			"count(cml:*[" +
			" not(local-name()='label') and" +
			" not(local-name()='name')  and" +
			" not(local-name()='atomParity')" +
			"]) = 0",
		});
		//==============================================================
		ATOMARRAY = new ElementNG("atomArray");
		ELEMENTMAP.put("atomArray", ATOMARRAY);
		ATOMARRAY.addAttributes(new String[]{
		    "id",
		});
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
		ATOMARRAY.addAssertions(new String[] {
			"ancestor::cml:molecule or ancestor::cml:formula",
			".//cml:atom",
		});
/*
  atom +
 */		
		ATOMARRAY.addContentModel(new String[] {
			"count(cml:*[" +
			" not(local-name()='atom')" +
			"]) = 0",
		});
		//==============================================================
		ATOMPARITY = new ElementNG("atomParity");
		ELEMENTMAP.put("atomParity", ATOMPARITY);
		ATOMPARITY.addAttributes(new String[]{
		    "id",
		    "atomRefs4"
		});
		ATOMPARITY.addContent(TypeNG.REALNUMBER_TYPE);		
		//==============================================================
		BOND = new ElementNG("bond");
		ELEMENTMAP.put("bond", BOND);
		BOND.addAttributes(new String[]{
		    "id",
		    "atomRefs2",
		    "order",
		    "title",
		});
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
		BOND.addAssertions(new String[] {
			"index-of(ancestor::cml:molecule[1]//cml:atom/@id, substring-before(@atomRefs2, ' ')) > 0",
			"index-of(ancestor::cml:molecule[1]//cml:atom/@id, substring-after(@atomRefs2, ' ')) > 0",
			"not(substring-before(@atomRefs2, ' ') = substring-after(@atomRefs2, ' '))",
			"count(ancestor::cml:molecule[1]//cml:bond[@id = current()/@id]) = 1",
		});
/*
   ( label* & 
     name* & 
     bondStereo?  
   ) 
 */		
		BOND.addContentModel(new String[] {
			"count(cml:atomParity) < 2",
			"count(cml:*[" +
			" not(local-name()='label') and" +
			" not(local-name()='name')  and" +
			" not(local-name()='bondStereo')" +
			"]) = 0",
		});
		//==============================================================
		BONDARRAY = new ElementNG("bondArray");
		ELEMENTMAP.put("bondArray", BONDARRAY);
		BONDARRAY.addAttributes(new String[]{
		    "id",
		});
/**
  bond+  
 */		
		BONDARRAY.addContentModel(new String[] {
			"count(cml:*[" +
			" not(local-name()='bond')" +
			"]) = 0",
		});
		//==============================================================
		BONDSTEREO = new ElementNG("bondStereo");
		ELEMENTMAP.put("bondStereo", BONDSTEREO);
		BONDSTEREO.addAttributes(new String[]{
		    "id",
		    "atomRefs4",
		    "convention",
		});
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
		BONDSTEREO.addAssertions(new String[] {
			"@convention='cml:wedgehatch' and not(@atomRefs4)",
			"@convention='cml:cistrans' and @atomRefs4",
			"(@convention='cml:wedgehatch' and . = 'W') or (@convention='cml:wedgehatch' and . = 'H')",
			"(@convention='cml:cistrans' and . = 'C') or (@convention='cml:cistrans' and . = 'T')",
		});
		BONDSTEREO.addContent(TypeNG.STRING_TYPE);		
		
		//==============================================================
		CML = new ElementNG("cml");
		ELEMENTMAP.put("cml", CML);
		CML.addAttributes(new String[]{
		    "id",
		    "title",
		    "version",
		    "convention",
		});
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
		CML.addAssertions(new String[] {
	        "@convention or ancestor::cml:cml",
	        "@version or ancestor::cml:cml",
	        "(@convention = 'CMLLite') or ancestor::cml:cml",
		});
/**
  anyElement # we don't allow mixed content in CML but it may be wrapped by html for example
 */		
		CML.addContentModel(new String[] {
			"count(text()) = 0",
		});
		//==============================================================
		DICTIONARY = new ElementNG("dictionary");
		ELEMENTMAP.put("dictionary", DICTIONARY);
		DICTIONARY.addAttributes(new String[]{
		    "id",
		    "title",
		    "namespace",
		    "convention",
		});
/*
  entry +  
 */		
		DICTIONARY.addContentModel(new String[] {
			"count(cml:*[" +
			" not(local-name()='entry')" +
			"]) = 0",
		});
		//==============================================================
		ENTRY = new ElementNG("entry");
		ELEMENTMAP.put("entry", ENTRY);
		ENTRY.addAttributes(new String[]{
		    "id",
		    "dictRef",
		    "dataType",
		    "convention",
		    "title",
		    "term",
		    "convention",
		});
		//==============================================================
		FORMULA = new ElementNG("formula");
		ELEMENTMAP.put("formula", FORMULA);
		FORMULA.addAttributes(new String[]{
		    "id",
		    "title",
		    "convention",
		    "count",
		    "formalCharge",
		    "concise",
		    "inline",
		});
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
/*
  ( empty | 
    atomArray | 
    ( formula, formula + ) 
  )
 */		
		FORMULA.addContentModel(new String[] {
			"(count(text() or *) = 0)  or "+
			"(count(cml:atomArray) = 1) or "+
			"(count(cml:formula) > 1)"
		});
		FORMULA.addAssertions(new String[] {
			"@count or not(ancestor::cml:formula)",
			"not(@count) or (floor(@count) = number(@count))",
		});
		FORMULA.addReports(new String[] {
			"not(@concise)",
		});
		//==============================================================
		LABEL = new ElementNG("label");
		ELEMENTMAP.put("label", LABEL);
		LABEL.addAttributes(new String[]{
		    "id",
		    "dictRef",
		    "convention",
		});	
		/**
		  <pattern id="label.checks">
		    <title>label element checks</title>
		    <p><h:p>labels should have convention specified if at all possible</h:p></p>
		    <rule context="cml:label">
		      <assert test="not(@convention)">label should have convention specified if at all possible</assert>
		    </rule>
		  </pattern>
		  */
		LABEL.addAssertions(new String[] {
		    "not(@convention)"
		});
		LABEL.addContent(TypeNG.STRING_TYPE);		
		//==============================================================
		MOLECULE = new ElementNG("molecule");
		ELEMENTMAP.put("molecule", MOLECULE);
		MOLECULE.addAttributes(new String[]{
		    "id",
		    "title",
		    "count",
		    "formalCharge",
		    "spinMultiplicity",
		    "ref",
		    "chirality",
		    "convention",
		});
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
		MOLECULE.addContentModel(new String[] {
		});
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
		MOLECULE.addAssertions(new String[] {
			"@count or not(ancestor::cml:molecule)",
			"not(@count) or (floor(@count) = number(@count))",
		});
		//==============================================================
		NAME = new ElementNG("name");
		ELEMENTMAP.put("name", NAME);
		NAME.addAttributes(new String[]{
		    "id",
		    "convention",
		});
		NAME.addContent(TypeNG.STRING_TYPE);		
		//==============================================================
		PEAK = new ElementNG("peak");
		ELEMENTMAP.put("peak", PEAK);
		PEAK.addAttributes(new String[]{
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
		PEAK.addAssertions(new String[] {
			"@yValue and count(ancestor::cml:peakList[1]//cml:peak/@yValue) = count(ancestor::cml:peakList[1]//cml:peak)",
			"@xValue or (xMax and xMin)",
			"not(@xMax) or (@xMax and @xMin)",
			"not(@xMin) or (@xMax and @xMin)",
		});
/*
  ( label * & 
    name * & 
    peakStructure *
  )
 */		
		PEAK.addContentModel(new String[] {
			"count(cml:*[" +
			" not(local-name()='label') and" +
			" not(local-name()='name')  and" +
			" not(local-name()='peakStructure')" +
			"]) = 0",
		});
		//==============================================================
		PEAKLIST = new ElementNG("peakList");
		ELEMENTMAP.put("peakList", PEAKLIST);
		PEAKLIST.addAttributes(new String[]{
		    "id",
		    "xUnits",
		    "title",
		    "yUnits",
		});
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
		PEAKLIST.addAssertions(new String[] {
			"count(.//cml:peak) >= 1",
			"count(.//cml:peak[@yValue]) > 0 and @yUnits",
		});
/*
  peak +
 */		
		PEAKLIST.addContentModel(new String[] {
			"count(cml:*[not(local-name() = 'peak')]) = 0 and" +
			"count(cml:peak) > 0)"
		});
		//==============================================================
		PEAKSTRUCTURE = new ElementNG("peakStructure");
		ELEMENTMAP.put("peakStructure", PEAKSTRUCTURE);
		PEAKSTRUCTURE.addAttributes(new String[]{
		    "id",
		    "dictRef",
		    "convention",
			"title",
			"atomRefs",
			"bondRefs",
			"peakShape",
		});
/*
  ( name * &
    label * 
  ) 
 */		
		PEAKSTRUCTURE.addContentModel(new String[] {
			"count(cml:*[" +
			" not(local-name() = 'name') and " +
			" not(local-name() = 'label')" +
			"]) = 0",
		});
		//==============================================================
		PROPERTY = new ElementNG("property");
		ELEMENTMAP.put("property", PROPERTY);
		PROPERTY.addAttributes(new String[]{
		    "id",
		    "dictRef",
		    "title",
		});
/*
  ( name * &
    label * &
    ( scalar ? | 
      property +
    )
  )
 */		  
		
		PROPERTY.addContentModel(new String[] {
			"(" +
			" count(cml:property) > 0 or " +
			" count(cml:scalar) < 2)" +
			" and (count(cml:*[" +
			" not(local-name() = 'cml:property) and" +
			" not(local-name() = 'cml:scalar) and" +
			" not(local-name() = 'cml:label) and" +
			" not(local-name() = 'cml:name)]" +
			") = 0)"
		});
		//==============================================================
		SCALAR = new ElementNG("scalar");
		ELEMENTMAP.put("scalar", SCALAR);
		SCALAR.addAttributes(new String[]{
		    "id",
		    "min",
		    "max",
		    "dataType",
		    "dictRef",
		    "units",
		});
	/**
	  <pattern id="scalar.checks">
	    <title>scalar element checks</title>
	    <p><h:p>Describe what further limitations we have put on the cml element</h:p></p>
	    <rule context="cml:scalar">
	      <assert test="count(@max | @min | text()) >= 1">scalar must have one or more max, min or content</assert>
	    </rule>
	  </pattern>
	 */		
		SCALAR.addAssertions(new String[] {
			"count(@max | @min | text()) >= 1"
		});
		SCALAR.addContent(TypeNG.STRING_TYPE);		
		
		//==============================================================
		SPECTRUM = new ElementNG("spectrum");
		ELEMENTMAP.put("spectrum", SPECTRUM);
		SPECTRUM.addAttributes(new String[]{
			    "id",
			    "dictRef",
			    "title",
			});
/**
  # child elements
  ( peakList & 
    property *
  )
 */		
		SPECTRUM.addContentModel(new String[] {
			" count(cml:peakList) > 0 and " +
			" and (count(cml:*[" +
			" not(local-name() = 'cml:peakList) and" +
			" not(local-name() = 'cml:property)]" +
			") = 0)"
		});
		//==============================================================
		//
		ATOM.addAllowedChildren(new String[]{
			"label",
			"name",
			"atomParity",
		});
		ATOM.addContentModel(new String[] {
			"count(cml:atomParity) < 2"
		});
		//
		ATOMARRAY.addAllowedChildren(new String[]{
			"atom",
		});
		//
		BOND.addAllowedChildren(new String[]{
			"label",
			"name",
			"bondStereo",
		});
		//
		BONDARRAY.addAllowedChildren(new String[]{
			"bond",
		});
		//
		CML.addAllowedChildren(new String[] {
			"#any",
		});
		//
		DICTIONARY.addAllowedChildren(new String[]{
			"entry",
		});
		//
		ENTRY.addAllowedChildren(new String[] {
				"#any",
		});
		//
		FORMULA.addAllowedChildren(new String[]{
			"atomArray",
			"formula",
		});
		//
		MOLECULE.addAllowedChildren(new String[] {
			"atomArray",
			"bondArray",
			"formula",
			"label",
			"molecule",
			"name",
			"property",
			"spectrum",
			"cml",
		});
		//
		PEAK.addAllowedChildren(new String[]{
			"label",
			"name",
			"peakStructure"
		});
		//
		PEAKLIST.addAllowedChildren(new String[]{
			"peak",
		});
		//
		PEAKSTRUCTURE.addAllowedChildren( new String[] {
			"label",
			"name",
		});		
		//
		PROPERTY.addAllowedChildren( new String[] {
			"label",
			"name",
			"scalar",
			"property"
		});		
		//
		SPECTRUM.addAllowedChildren( new String[] {
			"peakList",
			"property"
		});		
		//
		LOG.debug("MAP SIZE: "+ELEMENTMAP.size());
	}
	private List<AttributeNG> allowedAttributeList = 
		new ArrayList<AttributeNG>();
	private List<ElementNG> allowedElementList = 
		new ArrayList<ElementNG>();
	private List<String> assertionList = 
		new ArrayList<String>();
	private List<String> contentModelList = 
		new ArrayList<String>();
	private List<String> reportList = 
		new ArrayList<String>();
	
	private String localName;
	private TypeNG contentType = null;
	
	public ElementNG(String localName) {
		this.localName = localName;
	}
	
	public void addAttributes(String[] stringList) {
		for (String attName : stringList) {
			AttributeNG attribute = AttributeNG.ATTRIBUTEMAP.get(attName);
			if (attribute == null) {
				throw new RuntimeException("unsupported attribute: "+attName);
			}
			if (!allowedAttributeList.contains(attribute)) {
				allowedAttributeList.add(attribute);
			}
		}
	}
	
	public void addContent(TypeNG typeNG) {
		contentType = typeNG;
	}
	
	public void addAllowedChildren(String[] stringList) {
		for (String childName : stringList) {
			ElementNG element = ElementNG.ELEMENTMAP.get(childName);
			if (element == null) {
				throw new RuntimeException("unsupported element: "+childName);
			}
			if (!allowedElementList.contains(element)) {
				allowedElementList.add(element);
			}
		}
	}

	public void addAssertions(String[] stringList) {
		for (String s : stringList) {
			assertionList.add(s);
		}
	}

	public void addContentModel(String[] stringList) {
		for (String s : stringList) {
			contentModelList.add(s);
		}
	}

	public void addReports(String[] stringList) {
		for (String s : stringList) {
			reportList.add(s);
		}
	}

	public List<AttributeNG> getAllowedAttributeList() {
		return allowedAttributeList;
	}

	public List<ElementNG> getAllowedElementList() {
		return allowedElementList;
	}

	public String getLocalName() {
		return localName;
	}

	public TypeNG getContentType() {
		return contentType;
	}
	

	public List<String> getAssertionList() {
		return assertionList;
	}

	public List<String> getContentModelList() {
		return contentModelList;
	}

	public List<String> getReportList() {
		return reportList;
	}
	
}
