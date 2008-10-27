package org.xmlcml.cml.schema;

import static org.xmlcml.euclid.EuclidConstants.S_WHITEREGEX;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

public class AttributeSpecification {
	private static Logger LOG = Logger.getLogger(AttributeSpecification.class);
	
	public final static AttributeSpecification ATOMREFS;
	public final static AttributeSpecification ATOMREFS2;
	public final static AttributeSpecification ATOMREFS4;
	public final static AttributeSpecification BONDREFS;
	public final static AttributeSpecification CHIRALITY;
	public final static AttributeSpecification CONCISE;
	public final static AttributeSpecification CONVENTION;
	public final static AttributeSpecification COUNT;
	public final static AttributeSpecification DATATYPE;
	public final static AttributeSpecification DICTREF;
	public final static AttributeSpecification ELEMENTTYPE;
	public final static AttributeSpecification FORMALCHARGE;
	public final static AttributeSpecification ID;
	public final static AttributeSpecification INLINE;
	public final static AttributeSpecification ISOTOPENUMBER;
	public final static AttributeSpecification MAX;
	public final static AttributeSpecification MIN;
	public final static AttributeSpecification NAMESPACE;
	public final static AttributeSpecification ORDER;
	public final static AttributeSpecification PEAKMULTIPLICITY;
	public final static AttributeSpecification PEAKSHAPE;
	public final static AttributeSpecification REF;
	public final static AttributeSpecification SPINMULTIPLICITY;
	public final static AttributeSpecification TERM;
	public final static AttributeSpecification TITLE;
	public final static AttributeSpecification UNITS;
	public final static AttributeSpecification VERSION;
	public final static AttributeSpecification X2;
	public final static AttributeSpecification X3;
	public final static AttributeSpecification XMIN;
	public final static AttributeSpecification XMAX;
	public final static AttributeSpecification XUNITS;
	public final static AttributeSpecification XVALUE;
	public final static AttributeSpecification Y2;
	public final static AttributeSpecification Y3;
	public final static AttributeSpecification YUNITS;
	public final static AttributeSpecification YVALUE;
	public final static AttributeSpecification Z3;
	
	public final static Map<String, AttributeSpecification> ATTRIBUTEMAP = new HashMap<String, AttributeSpecification>();
	
	static {
		ATOMREFS = new AttributeSpecification("atomRefs", TypeSpecification.REF_TYPE, -1);
		ATOMREFS2 = new AttributeSpecification("atomRefs2", TypeSpecification.REF_TYPE, 2);
		ATOMREFS4 = new AttributeSpecification("atomRefs4", TypeSpecification.REF_TYPE, 4);
		BONDREFS = new AttributeSpecification("bondRefs", TypeSpecification.REF_TYPE, -1);
		CHIRALITY = new AttributeSpecification("chirality", TypeSpecification.CHIRALITY_TYPE);
		CONCISE = new AttributeSpecification("concise", TypeSpecification.FORMULA_TYPE);
		CONVENTION = new AttributeSpecification("convention", TypeSpecification.REF_TYPE);
		COUNT = new AttributeSpecification("count", TypeSpecification.NONNEGATIVEREAL_TYPE);
		DATATYPE = new AttributeSpecification("dataType", TypeSpecification.DATATYPE_TYPE);
		DICTREF = new AttributeSpecification("dictRef", TypeSpecification.REF_TYPE);
		ELEMENTTYPE = new AttributeSpecification("elementType", TypeSpecification.ELEMENTTYPE_TYPE);
		FORMALCHARGE = new AttributeSpecification("formalCharge", TypeSpecification.INTEGER_TYPE);
		ID = new AttributeSpecification("id", TypeSpecification.REF_TYPE);
		INLINE = new AttributeSpecification("inline", TypeSpecification.STRING_TYPE);
		ISOTOPENUMBER = new AttributeSpecification("isotopeNumber", TypeSpecification.POSITIVEINTEGER_TYPE);
		MAX = new AttributeSpecification("max", TypeSpecification.STRING_TYPE);
		MIN = new AttributeSpecification("min", TypeSpecification.STRING_TYPE);
		NAMESPACE = new AttributeSpecification("namespace", TypeSpecification.NAMESPACE_TYPE);
		ORDER = new AttributeSpecification("order", TypeSpecification.ORDER_TYPE);
		PEAKMULTIPLICITY = new AttributeSpecification("peakMultiplicity", TypeSpecification.STRING_TYPE);
		PEAKSHAPE = new AttributeSpecification("peakShape", TypeSpecification.STRING_TYPE);
		REF = new AttributeSpecification("ref", TypeSpecification.REF_TYPE);
		SPINMULTIPLICITY = new AttributeSpecification("spinMultiplicity", TypeSpecification.POSITIVEINTEGER_TYPE);
		TERM = new AttributeSpecification("term", TypeSpecification.STRING_TYPE);
		TITLE = new AttributeSpecification("title", TypeSpecification.STRING_TYPE);
		UNITS = new AttributeSpecification("units", TypeSpecification.REF_TYPE);
		VERSION = new AttributeSpecification("version", TypeSpecification.STRING_TYPE);
		X2 = new AttributeSpecification("x2", TypeSpecification.REALNUMBER_TYPE);
		X3 = new AttributeSpecification("x3", TypeSpecification.REALNUMBER_TYPE);
		XMAX = new AttributeSpecification("xMax", TypeSpecification.REALNUMBER_TYPE);
		XMIN = new AttributeSpecification("xMin", TypeSpecification.REALNUMBER_TYPE);
		XUNITS = new AttributeSpecification("xUnits", TypeSpecification.QNAME_TYPE);
		XVALUE = new AttributeSpecification("xValue", TypeSpecification.REALNUMBER_TYPE);
		Y2 = new AttributeSpecification("y2", TypeSpecification.REALNUMBER_TYPE);
		Y3 = new AttributeSpecification("y3", TypeSpecification.REALNUMBER_TYPE);
		YUNITS = new AttributeSpecification("yUnits", TypeSpecification.QNAME_TYPE);
		YVALUE = new AttributeSpecification("yValue", TypeSpecification.REALNUMBER_TYPE);
		Z3 = new AttributeSpecification("z3", TypeSpecification.REALNUMBER_TYPE);
		
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
	private TypeSpecification typeSpecification;
	private int length = 0;
	private String name;
	
	private AttributeSpecification(String name, TypeSpecification typeNG) {
		this.typeSpecification = typeNG;
		this.name = name;
		if (ATTRIBUTEMAP.containsKey(name)) {
			throw new RuntimeException("BUG duplicate attName "+name);
		}
		ATTRIBUTEMAP.put(name, this);
	}
	
	public String getName() {
		return name;
	}

	private AttributeSpecification(String name, TypeSpecification typeNG, int length) {
		this(name, typeNG);
		this.length = length;
	}
	
	/** checks whether value is of correct type and content.
	 * 
	 * @param value
	 * @throws RuntimeException if invalid value
	 */
	public void validate(String value) {
		if (length != 0) {
			// does attribute define a list?
			String[] strings = value.trim().split(S_WHITEREGEX);
			// split and check length
			if (length > 0 && strings.length != length) {
				throw new RuntimeException("inconsistent attribute list: ("+strings.length+" != "+length+")");
			}
			// check each string in turn
			for (int i = 0; i < strings.length; i++) {
				String s = strings[i];
				try {
					typeSpecification.validate(s);
				} catch (RuntimeException re) {
					throw new RuntimeException("validation failure on list element ("+i+")", re);
				}
			}
		} else {
			// no list
			typeSpecification.validate(value);
		}
	}

	public TypeSpecification getTypeSpecification() {
		return typeSpecification;
	}

	public int getLength() {
		return length;
	}
	
	public void debug() {
		LOG.debug(name+" ("+typeSpecification+")"+"["+length+"]");
	}
}
