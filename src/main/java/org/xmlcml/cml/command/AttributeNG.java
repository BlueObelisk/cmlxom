package org.xmlcml.cml.command;

import java.util.HashMap;
import java.util.Map;
import static org.xmlcml.cml.base.CMLConstants.S_WHITEREGEX;

public class AttributeNG {

	public final static AttributeNG ATOMREFS;
	public final static AttributeNG ATOMREFS2;
	public final static AttributeNG ATOMREFS4;
	public final static AttributeNG BONDREFS;
	public final static AttributeNG CHIRALITY;
	public final static AttributeNG CONCISE;
	public final static AttributeNG CONVENTION;
	public final static AttributeNG COUNT;
	public final static AttributeNG DATATYPE;
	public final static AttributeNG DICTREF;
	public final static AttributeNG ELEMENTTYPE;
	public final static AttributeNG FORMALCHARGE;
	public final static AttributeNG ID;
	public final static AttributeNG INLINE;
	public final static AttributeNG ISOTOPENUMBER;
	public final static AttributeNG MAX;
	public final static AttributeNG MIN;
	public final static AttributeNG NAMESPACE;
	public final static AttributeNG ORDER;
	public final static AttributeNG PEAKMULTIPLICITY;
	public final static AttributeNG PEAKSHAPE;
	public final static AttributeNG REF;
	public final static AttributeNG SPINMULTIPLICITY;
	public final static AttributeNG TERM;
	public final static AttributeNG TITLE;
	public final static AttributeNG UNITS;
	public final static AttributeNG VERSION;
	public final static AttributeNG X2;
	public final static AttributeNG X3;
	public final static AttributeNG XMIN;
	public final static AttributeNG XMAX;
	public final static AttributeNG XUNITS;
	public final static AttributeNG XVALUE;
	public final static AttributeNG Y2;
	public final static AttributeNG Y3;
	public final static AttributeNG YUNITS;
	public final static AttributeNG YVALUE;
	public final static AttributeNG Z3;
	
	public final static Map<String, AttributeNG> ATTRIBUTEMAP = new HashMap<String, AttributeNG>();
	
	static {
		ATOMREFS = new AttributeNG("atomRefs", TypeNG.REF_TYPE, -1);
		ATOMREFS2 = new AttributeNG("atomRefs2", TypeNG.REF_TYPE, 2);
		ATOMREFS4 = new AttributeNG("atomRefs4", TypeNG.REF_TYPE, 4);
		BONDREFS = new AttributeNG("bondRefs", TypeNG.REF_TYPE, -1);
		CHIRALITY = new AttributeNG("chirality", TypeNG.CHIRALITY_TYPE);
		CONCISE = new AttributeNG("concise", TypeNG.FORMULA_TYPE);
		CONVENTION = new AttributeNG("convention", TypeNG.REF_TYPE);
		COUNT = new AttributeNG("count", TypeNG.NONNEGATIVEREAL_TYPE);
		DATATYPE = new AttributeNG("dataType", TypeNG.DATATYPE_TYPE);
		DICTREF = new AttributeNG("dictRef", TypeNG.REF_TYPE);
		ELEMENTTYPE = new AttributeNG("elementType", TypeNG.ELEMENTTYPE_TYPE);
		FORMALCHARGE = new AttributeNG("formalCharge", TypeNG.INTEGER_TYPE);
		ID = new AttributeNG("id", TypeNG.REF_TYPE);
		INLINE = new AttributeNG("inline", TypeNG.STRING_TYPE);
		ISOTOPENUMBER = new AttributeNG("isotopeNumber", TypeNG.POSITIVEINTEGER_TYPE);
		MAX = new AttributeNG("max", TypeNG.STRING_TYPE);
		MIN = new AttributeNG("min", TypeNG.STRING_TYPE);
		NAMESPACE = new AttributeNG("namespace", TypeNG.NAMESPACE_TYPE);
		ORDER = new AttributeNG("order", TypeNG.ORDER_TYPE);
		PEAKMULTIPLICITY = new AttributeNG("peakMultiplicity", TypeNG.STRING_TYPE);
		PEAKSHAPE = new AttributeNG("peakShape", TypeNG.STRING_TYPE);
		REF = new AttributeNG("ref", TypeNG.REF_TYPE);
		SPINMULTIPLICITY = new AttributeNG("spinMultiplicity", TypeNG.POSITIVEINTEGER_TYPE);
		TERM = new AttributeNG("term", TypeNG.STRING_TYPE);
		TITLE = new AttributeNG("title", TypeNG.STRING_TYPE);
		UNITS = new AttributeNG("units", TypeNG.REF_TYPE);
		VERSION = new AttributeNG("version", TypeNG.STRING_TYPE);
		X2 = new AttributeNG("x2", TypeNG.REALNUMBER_TYPE);
		X3 = new AttributeNG("x3", TypeNG.REALNUMBER_TYPE);
		XMAX = new AttributeNG("xMax", TypeNG.REALNUMBER_TYPE);
		XMIN = new AttributeNG("xMin", TypeNG.REALNUMBER_TYPE);
		XUNITS = new AttributeNG("xUnits", TypeNG.QNAME_TYPE);
		XVALUE = new AttributeNG("xValue", TypeNG.REALNUMBER_TYPE);
		Y2 = new AttributeNG("y2", TypeNG.REALNUMBER_TYPE);
		Y3 = new AttributeNG("y3", TypeNG.REALNUMBER_TYPE);
		YUNITS = new AttributeNG("yUnits", TypeNG.QNAME_TYPE);
		YVALUE = new AttributeNG("yValue", TypeNG.REALNUMBER_TYPE);
		Z3 = new AttributeNG("z3", TypeNG.REALNUMBER_TYPE);
		
	};
	/*
// Do we need this?
\namespace = attribute \namespace { xsd:string { pattern='http://[A-Za-z][A-Za-z0-9_\.\-]*(/[A-Za-z0-9_\.\-]+)+' } }
z3 = attribute z3 { realNumberWithExponent } 
actualDataType = attribute dataType { "xsd:string" |  "xsd:float" |
 				"xsd:double" | "xsd:decimal" | "xsd:anyURI" |
 				"xsd:QName" | "xsd:normalizedString" |
 				"xsd:token" | "xsd:Name" | "xsd:NCName" |
 				"xsd:integer" |
 				"xsd:nonPositiveInteger" | "xsd:negativeInteger" | "xsd:long" |
 				"xsd:int" | "xsd:short" | "xsd:byte" | "xsd:nonNegativeInteger" |
 				"xsd:unsignedLong" | "xsd:unsignedInt" | "xsd:unsignedShort" |
 				"xsd:unsignedByte" | "xsd:positiveInteger" }
*/
	private TypeNG typeNG;
	private int length = 0;
	private String name;
	
	private AttributeNG(String name, TypeNG typeNG) {
		this.typeNG = typeNG;
		this.name = name;
		if (ATTRIBUTEMAP.containsKey(name)) {
			throw new RuntimeException("BUG duplicate attName "+name);
		}
		ATTRIBUTEMAP.put(name, this);
	}
	
	public String getName() {
		return name;
	}

	private AttributeNG(String name, TypeNG typeNG, int length) {
		this(name, typeNG);
		this.length = length;
	}
	
	public void validate(String value) {
		if (length != 0) {
			String[] strings = value.trim().split(S_WHITEREGEX);
			if (length > 0 && strings.length != length) {
				throw new RuntimeException("inconsistent attribute list: ("+strings.length+" != "+length+")");
			}
			for (int i = 0; i < strings.length; i++) {
				String s = strings[i];
				try {
					typeNG.validate(s);
				} catch (RuntimeException re) {
					throw new RuntimeException("validation failure on list element ("+i+")", re);
				}
			}
		} else {
			typeNG.validate(value);
		}
	}
}
