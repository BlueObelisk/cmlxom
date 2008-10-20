package org.xmlcml.cml.command;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jaxen.NamedAccessNavigator;

public class TypeNG {
	
	public final static TypeNG CHIRALITY_TYPE;
	public final static TypeNG DATATYPE_TYPE;
	public final static TypeNG ELEMENTTYPE_TYPE;
	public final static TypeNG FORMULA_TYPE;
	public final static TypeNG INTEGER_TYPE;
	public final static TypeNG NAMESPACE_TYPE;
	public final static TypeNG NONNEGATIVEREAL_TYPE;
	public final static TypeNG ORDER_TYPE;
	public final static TypeNG POSITIVEINTEGER_TYPE;
	public final static TypeNG REALNUMBER_TYPE;
	public final static TypeNG QNAME_TYPE;
	public final static TypeNG REF_TYPE;
	public final static TypeNG STRING_TYPE;
	;
	static {
		CHIRALITY_TYPE = new TypeNG(String.class);
		CHIRALITY_TYPE.setPattern("enantiomer|racemate|unknown|other");
		DATATYPE_TYPE = new TypeNG(String.class);
		DATATYPE_TYPE.setPattern("xsd:double|xsd:integer|xsd:string");
		ELEMENTTYPE_TYPE = new TypeNG(String.class);
		ELEMENTTYPE_TYPE.setPattern("Ac|Al|Ag|Am|Ar|As|At|Au|B|Ba|Bh|Bi|Be|Bk|Br|C|Ca|Cd|Ce|Cf|Cl|Cm|Co|Cr|Cs|Cu|Db|Dy|Er|Es|Eu|F|Fe|Fm|Fr|Ga|Gd|Ge|H|He|Hf|Hg|Ho|Hs|I|In|Ir|K|Kr|La|Li|Lr|Lu|Md|Mg|Mn|Mo|Mt|N|Na|Nb|Nd|Ne|Ni|No|Np|O|Os|P|Pa|Pb|Pd|Pm|Po|Pr|Pt|Pu|Ra|Rb|Re|Rf|Rh|Rn|Ru|S|Sb|Sc|Se|Sg|Si|Sm|Sn|Sr|Ta|Tb|Tc|Te|Th|Ti|Tl|Tm|U|Uun|Uuu|Uub|Uut|Uuq|Uup|Uuh|Uus|Uuo|V|W|Xe|Y|Yb|Zn|Zr|Du|R");
		FORMULA_TYPE = new TypeNG(String.class);
		FORMULA_TYPE.setPattern("\\s*([A-Z][a-z]?\\s+(([0-9]+(\\.[0-9]*)?)|(\\.[0-9]*))?\\s*)+(\\s+[\\-|+]?[0-9]+)?\\s*");
		INTEGER_TYPE = new TypeNG(Integer.class);
		NAMESPACE_TYPE = new TypeNG(String.class);
		NAMESPACE_TYPE.setPattern("http\\://[A-Za-z][A-Za-z0-9_\\.\\-]*(/[A-Za-z0-9_\\.\\-]+)+");
		NONNEGATIVEREAL_TYPE = new TypeNG(Double.class);
		NONNEGATIVEREAL_TYPE.setMinInclusive(new Double(0.0));
		ORDER_TYPE = new TypeNG(String.class);
		ORDER_TYPE.setPattern("hbond|S|D|T|A|U|P");
		POSITIVEINTEGER_TYPE = new TypeNG(Integer.class);
		POSITIVEINTEGER_TYPE.setMinInclusive(new Integer(1));
		REALNUMBER_TYPE = new TypeNG(Double.class);
		REALNUMBER_TYPE.setPattern("[+\\-]?\\d+(\\.\\d*)?([dDeE][+\\-]?\\d+)?");
		QNAME_TYPE = new TypeNG(String.class);
		QNAME_TYPE.setPattern("[A-Za-z_][A-Za-z0-9_\\-]*:[A-Za-z_][A-Za-z0-9_\\-]*");
		REF_TYPE = new TypeNG(String.class);
		REF_TYPE.setPattern("([A-Za-z_][A-Za-z0-9_\\-]*:)?[A-Za-z_][A-Za-z0-9_\\-]*");
		STRING_TYPE = new TypeNG(String.class);
		
	}
	private Pattern pattern;
	private Class clazz;
	private Integer minInclusiveInteger;
	private Double minInclusiveDouble;
	
	public TypeNG(Class clazz) {
		this.clazz = clazz;
	}
	
	public void setPattern(String patternString) {
		pattern = Pattern.compile(patternString);
	}
	
	public void setMinInclusive(Double d) {
		minInclusiveDouble = d;
	}
	
	public void setMinInclusive(Integer i) {
		minInclusiveInteger = i;
	}
	
	public void validate(String value) {
		if (clazz.equals(Integer.class)) {
			Integer integer = 0;
			try {
				integer = new Integer(value);
			} catch (NumberFormatException nfe) {
				throw new RuntimeException("Bad integer: "+value);
			}
			if (minInclusiveInteger != null && 
					minInclusiveInteger.intValue() > integer.intValue()) {
				throw new RuntimeException("integer outside range ("+integer.intValue() + 
						" < "+minInclusiveInteger.intValue());
			}
		} else if (clazz.equals(Double.class)) {
			Double dubble = 0.0;
			try {
				dubble = new Double(value);
			} catch (NumberFormatException nfe) {
				throw new RuntimeException("Bad double: "+value);
			}
			if (minInclusiveDouble != null && 
					minInclusiveDouble.doubleValue() > dubble.doubleValue()) {
				throw new RuntimeException("double outside range ("+dubble.doubleValue() + 
						" < "+minInclusiveDouble.doubleValue());
			}
		} else if (pattern != null) {
			Matcher matcher = pattern.matcher(value);
			if (!matcher.matches()) {
				throw new RuntimeException("value ("+value+") does not match pattern "+pattern);
			}
		}
	}
}
