package org.xmlcml.cml.command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class ElementNG {
	private static Logger LOG = Logger.getLogger(ElementNG.class);
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
		
		ANY = new ElementNG("#any");
		ELEMENTMAP.put("#any", ANY);
		
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
		//
		ATOMARRAY = new ElementNG("atomArray");
		ELEMENTMAP.put("atomArray", ATOMARRAY);
		ATOMARRAY.addAttributes(new String[]{
		    "id",
		});
		//
		ATOMPARITY = new ElementNG("atomParity");
		ELEMENTMAP.put("atomParity", ATOMPARITY);
		ATOMPARITY.addAttributes(new String[]{
		    "id",
		    "atomRefs4"
		});
		ATOMPARITY.addContent(TypeNG.REALNUMBER_TYPE);		
		//
		BOND = new ElementNG("bond");
		ELEMENTMAP.put("bond", BOND);
		BOND.addAttributes(new String[]{
		    "id",
		    "atomRefs2",
		    "order",
		    "title",
		});
		//
		BONDARRAY = new ElementNG("bondArray");
		ELEMENTMAP.put("bondArray", BONDARRAY);
		BONDARRAY.addAttributes(new String[]{
		    "id",
		});
		//
		BONDSTEREO = new ElementNG("bondStereo");
		ELEMENTMAP.put("bondStereo", BONDSTEREO);
		BONDSTEREO.addAttributes(new String[]{
		    "id",
		    "atomRefs4",
		    "convention",
		});
		BONDSTEREO.addContent(TypeNG.STRING_TYPE);		
		//
		CML = new ElementNG("cml");
		ELEMENTMAP.put("cml", CML);
		CML.addAttributes(new String[]{
		    "id",
		    "title",
		    "version",
		    "convention",
		});

		//
		DICTIONARY = new ElementNG("dictionary");
		ELEMENTMAP.put("dictionary", DICTIONARY);
		DICTIONARY.addAttributes(new String[]{
		    "id",
		    "title",
		    "namespace",
		    "convention",
		});
		//
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
		//
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
		//
		LABEL = new ElementNG("label");
		ELEMENTMAP.put("label", LABEL);
		LABEL.addAttributes(new String[]{
		    "id",
		    "dictRef",
		    "convention",
		});
		LABEL.addContent(TypeNG.STRING_TYPE);		
		//
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
		//
		NAME = new ElementNG("name");
		ELEMENTMAP.put("name", NAME);
		NAME.addAttributes(new String[]{
		    "id",
		    "convention",
		});
		NAME.addContent(TypeNG.STRING_TYPE);		
		//
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
		//
		PEAKLIST = new ElementNG("peakList");
		ELEMENTMAP.put("peakList", PEAKLIST);
		PEAKLIST.addAttributes(new String[]{
		    "id",
		    "xUnits",
		    "title",
		    "yUnits",
		});
		//
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
		//
		PROPERTY = new ElementNG("property");
		ELEMENTMAP.put("property", PROPERTY);
		PROPERTY.addAttributes(new String[]{
		    "id",
		    "dictRef",
		    "title",
		});
		  
		//
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
		SCALAR.addContent(TypeNG.STRING_TYPE);		
		//
		SPECTRUM = new ElementNG("spectrum");
		ELEMENTMAP.put("spectrum", SPECTRUM);
		SPECTRUM.addAttributes(new String[]{
			    "id",
			    "dictRef",
			    "title",
			});
		//
		//
		ATOM.addAllowedChildren(new String[]{
			"label",
			"name",
			"atomParity",
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
	
}
