package org.xmlcml.molutil;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Elements;

import org.apache.log4j.Logger;
import org.xmlcml.cml.base.CMLUtil;

//import jumbo.euclid.RealArray;

/**
 * Supports the elements.
 * 
 * @author (C) P. Murray-Rust, 1996
 * @author (C) S. Adams, 2004
 */
public class ChemicalElement {

    /** type of element.
     * An element may have several types
     * we shall generate a List<Type> for each
     * element
     * More to be added...
     * @author pm286
     *
     */
    public enum Type {
        /** transition metal         */
        TRANSITION_METAL,
        /** pblock top right*/
        PBLOCK,
        /** metal any sort*/
        METAL,
        /** metal any sort*/
        METAL_NOT_SEMI_METAL,
        /** group A (number to be given separately)*/
        GROUP_A,
        /** group B (number to be given separately)*/
        GROUP_B,
        /** row (number to be given separately)*/
        ROW,
        /** lanthanide*/
        LANTHANIDE,
        /** actinide*/
        ACTINIDE,
        /** non-metal*/
        NON_METAL,
        /** semi-metal*/
        SEMI_METAL,
        /** halogen **/
        HALOGEN;
        ;
        private Type() {
        }
    }
    
    /** types of radius.
     */
    public enum RadiusType {
        /** dewisott */
    	ATOMIC,
        /** dewisott */
    	COVALENT,
        /** dewisott */
    	IONIC,
        /** dewisott */
    	VDW;
    	private RadiusType() {
    	}
    }
    
    /** enumeration of element in symbolic form.
     * 
     * @author pm286
     *
     */
    public enum AS {
        /** element symbol*/
        H ("H",   1),
        /** element symbol*/
        He("He",  2),
        /** element symbol*/
        Li("Li",  3),
        /** element symbol*/
        Be("Be",  4),
        /** element symbol*/
        B ("B",   5),
        /** element symbol*/
        C ("C",   6),
        /** element symbol*/
        N ("N",   7),
        /** element symbol*/
        O ("O",   8),
        /** element symbol*/
        F ("F",   9),
        /** element symbol*/
        Ne("Ne", 10),
        /** element symbol*/
        Na("Na", 11),
        /** element symbol*/
        Mg("Mg", 12),
        /** element symbol*/
        Al("Al", 13),
        /** element symbol*/
        Si("Si", 14),
        /** element symbol*/
        P ("P",  15),
        /** element symbol*/
        S ("S",  16),
        /** element symbol*/
        Cl("Cl", 17),
        /** element symbol*/
        Ar("Ar", 18),
        
        
        /** element symbol*/
        Br("Br", 35),
        /** element symbol*/
        I("I", 53),
        /** element symbol*/
        R("R", 119),
        
        ;
        /** element symbol*/
        public String value;
        /** atomic number */
        public int n;
        private AS(String symbol, int n) {
            this.value = symbol;
            this.n = n;
        }
        /** compare element symbols.
         * 
         * @param elSym
         * @return true if not null and equal
         */
        public boolean equals(String elSym) {
            return (elSym != null && elSym.equals(value));
        }
    };
    final static Logger logger = Logger.getLogger(ChemicalElement.class);

    /**
     * maximum number of elements.
     */
    /**
     * atoms count from 1. so max at number is MAXELEM-1
     * 
     */
    public static final int MAXELEM = 150;

    /** XML file containing elemental details. */
    final static String ELEMENT_FILE = "org/xmlcml/molutil/elementdata.xml";

    final static double DEFAULT_ATOMIC_RADIUS = 1.6;

    final static double DEFAULT_COVALENT_RADIUS = 1.4;

    final static double DEFAULT_VDW_RADIUS = 2.0;

    final static double DEFAULT_BONDING_RADIUS_TOLERANCE = 0.2;

    static double bondingRadiusTolerance = DEFAULT_BONDING_RADIUS_TOLERANCE;

    /** Hashtable of elements, indexed by atomicSymbol. */
    static Hashtable<String, ChemicalElement> pTable;

    /** Atomic number to atomicSymbol array. */
    public static ChemicalElement[] periodicTable;

    static {
        pTable = new Hashtable<String, ChemicalElement>();
        periodicTable = new ChemicalElement[MAXELEM];
    };

    protected final int atomicNumber;

    protected final double atomicWeight;

    protected final String atomicSymbol;

    protected int group;

    protected int period;

    protected String electronicGroundState;

    protected int[] isotopeMasses;

    protected double[] isotopeAbundances;

    /** Covalent radius, in angstrom. */
    protected double covalentRadius;

    /** Atomic radius, in angstrom. */
    protected double atomicRadius;

    /** Van der Waals radius, in angstrom. */
    protected double vanderwaalsRadius;

    /** Pauling electronegativity. */
    protected double electronegativity;

    /** Display colour. */
    protected Color color;

    /**
     * constructor.
     * 
     * @param symbol
     * @param atomicNumber
     * @param atomicWeight
     */
    public ChemicalElement(String symbol, int atomicNumber, double atomicWeight) {
        this.atomicSymbol = symbol;
        this.atomicNumber = atomicNumber;
        this.atomicWeight = atomicWeight;

        periodicTable[atomicNumber] = this;
    }

    /**
     * get symbol.
     * 
     * @return symbol
     */
    public String getSymbol() {
        return atomicSymbol;
    }

    /**
     * get atomic number.
     * 
     * @return atomic number
     */
    public int getAtomicNumber() {
        return atomicNumber;
    }

    /**
     * get atomic weight.
     * 
     * @return atomic weight
     */
    public double getAtomicWeight() {
        return atomicWeight;
    }

    /**
     * get group.
     * 
     * @return group
     */
    public int getGroup() {
        return group;
    }

    /**
     * get period.
     * 
     * @return period
     */
    public int getPeriod() {
        return period;
    }

    /**
     * get ground state.
     * 
     * @return ground state
     */
    public String getElectronicGroundState() {
        return electronicGroundState;
    }

    /**
     * @param abundances
     * @param masses
     * @deprecated use setIsotopes.
     */
    public void addIsotope(int[] masses, double[] abundances) {
        setIsotopes(masses, abundances);
    }

    /**
     * set isotopes.
     * 
     * @param masses
     * @param abundances
     */
    public void setIsotopes(int[] masses, double[] abundances) {
        isotopeMasses = masses;
        isotopeAbundances = abundances;
    }

    /**
     * @return array of isotope masses, or null if isotopes not known.
     */
    public int[] getIsotopeMasses() {
        return isotopeMasses;
    }

    /**
     * @return array of isotope abundances, or null if isotopes not known.
     */
    public double[] getIsotopeAbundances() {
        return isotopeAbundances;
    }

    /**
     * get the mass of the most abundant isotope.
     * 
     * @return mass of most abundant isotope, or -1 if not found.
     */
    public int getMainIsotope() {
        double max = -1.0;
        int mainMass = -1;
        for (int i = 0; i < isotopeMasses.length; i++) {
            if (isotopeAbundances[i] > max) {
                max = isotopeAbundances[i];
                mainMass = isotopeMasses[i];
            }
        }
        return mainMass;
    }

    /**
     * set covalent radius.
     * 
     * @param cov
     */
    public void setCovalentRadius(double cov) {
        covalentRadius = cov;
    }

    /**
     * get covalent radius.
     * 
     * @return the radius
     */
    public double getCovalentRadius() {
        return (covalentRadius > 0.1) ? covalentRadius
                : DEFAULT_COVALENT_RADIUS;
    }
    
    /** get various types of radii
     * 
     * @param radiusType
     * @return radius
     */
    public double getRadius(RadiusType radiusType) {
    	double radius = Double.NaN;
    	if (radiusType.equals(RadiusType.ATOMIC)) {
		radius = getAtomicRadius();
    	} else if (radiusType.equals(RadiusType.COVALENT)) {
    		radius = getCovalentRadius();
    	} else if (radiusType.equals(RadiusType.IONIC)) {
//    		radius = getIonicRadius();
    	} else if (radiusType.equals(RadiusType.VDW)) {
    		radius = getVDWRadius();
    	}
    	return radius;
    }
    
    /**
     * @return cov rad
     */
    public double getTypeAdjustedCovalentRadius() {
    	double radius = this.getCovalentRadius();
		if (this.isChemicalElementType(Type.ACTINIDE) ||
				this.isChemicalElementType(Type.LANTHANIDE)) {
			radius = radius * 1.35;
		} else if (this.isChemicalElementType(Type.TRANSITION_METAL)) { 
			radius = radius * 1.25;
		} else if (this.isChemicalElementType(Type.GROUP_B) ||
				this.isChemicalElementType(Type.GROUP_A)){
			radius = radius * 1.2;
		} else {
			radius = radius * 1.15;
		}
		return radius;
    }

    /**
     * set atomic radius.
     * 
     * @param cov
     */
    public void setAtomicRadius(double cov) {
        atomicRadius = cov;
    }

    /**
     * get atomic radius.
     * 
     * @return radius
     */
    public double getAtomicRadius() {
        return (atomicRadius > 0.1) ? atomicRadius : DEFAULT_ATOMIC_RADIUS;
    }

    /**
     * set vdw radius.
     * 
     * @param vdw
     */
    public void setVDWRadius(double vdw) {
        vanderwaalsRadius = vdw;
    }

    /**
     * get vdw radius
     * 
     * @return radius
     */
    public double getVDWRadius() {
        return (vanderwaalsRadius > 0.1) ? vanderwaalsRadius
                : DEFAULT_VDW_RADIUS;
    }

    /**
     * set electronegativity.
     * 
     * @param eneg
     */
    public void setElectronegativity(double eneg) {
        electronegativity = eneg;
    }

    /**
     * get electronegativity.
     * 
     * @return eneg
     */
    public double getElectronegativity() {
        return electronegativity;
    }

    /**
     * set color
     * 
     * @param color
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * get color.
     * 
     * @return color
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * gets color as hex string. includes leading '#' and 6 hex digits
     * 
     * @return the color as a string
     */
    public String getColorString() {
        String red = Integer.toHexString(color.getRed());
        if (red.length() == 1)
            red = "0" + red;
        String green = Integer.toHexString(color.getGreen());
        if (green.length() == 1)
            green = "0" + green;
        String blue = Integer.toHexString(color.getBlue());
        if (blue.length() == 1)
            blue = "0" + blue;
        return "#" + red + green + blue;
    }

    /**
     * valence electrons defined as p-block-like - available for bonding.
     * 
     * @return electron count
     */
    public int getValenceElectrons() {
        if (atomicNumber < 2)
            return atomicNumber;
        // first row
        if (atomicNumber < 10)
            return atomicNumber - 2;
        // second row
        if (atomicNumber < 18)
            return atomicNumber - 10;
        // first row tm
        if (atomicNumber < 28)
            return atomicNumber - 18;
        // third row
        if (atomicNumber < 36)
            return atomicNumber - 28;
        // second row tm
        if (atomicNumber < 46)
            return atomicNumber - 36;
        // fourth row
        if (atomicNumber < 54)
            return atomicNumber - 46;
        // not done
        if (atomicNumber < 78)
            return atomicNumber - 54;
        // up to 86
        // fifth row p block
        if (atomicNumber < 86)
            return atomicNumber - 78;
        return -1;
    }

    /**
     * to string.
     * 
     * @return string
     */

    public String toString() {
        return atomicSymbol + ": " + atomicWeight;
    }

    /** Outputs details of element. */
    public void debug() {
        ChemicalElement.debug(this);
    }

    /**
	 * is element a transition metal. FIXME - I haven't checked values
     * @param type
	 *            GROUP_A, GROUP_B or ROW
     * @param value
	 *            or row or group
	 *
	 * @return true if is TM
	 */
	public boolean isChemicalElementType(
			Type type, int value) {
		int atNum = this.getAtomicNumber();
		// String symbol = chemicalElement.getSymbol();
		boolean isType = false;
		if (type.equals(Type.ROW)) {
			isType = value == 1 && atNum >= 3 && atNum <= 10 || value == 2
			&& atNum >= 11 && atNum <= 18 || value == 3 && atNum >= 19
			&& atNum <= 36 || value == 4 && atNum >= 37 && atNum <= 54
			|| value == 5 && atNum >= 55 && atNum <= 86 || value == 6
			&& atNum >= 87;
		} else if (type.equals(Type.GROUP_A)) {
			if (value == 1 || value == 2) {
				isType = atNum == 2 + value || atNum == 10 + value
				|| atNum == 18 + value || atNum == 36 + value
				|| atNum == 54 + value;
			} else if (value >= 3 && value <= 8) {
				isType = atNum == 2 + value || atNum == 10 + value
				|| atNum == 28 + value || atNum == 46 + value
				|| atNum == 78 + value;
			}
		} else if (type.equals(Type.GROUP_B)) {
			if (value >= 1 || value <= 10) {
				isType = atNum == 18 + value || atNum == 36 + value
				|| atNum == 56 + value;
			}
		} else {
			throw new RuntimeException("Bad type for " + type + ": " + value);
		}
		return isType;
	}

	/**
	 * is element of given type.
	 * @param type
	 *            TRANSITION METAL, LANTHANIDE, ACTINIDE, METAL,
	 *            NON_METAL, PBLOCK, GROUP_A, GROUP_B
	 *
	 * @return true if of type
	 */
	public boolean isChemicalElementType(
			Type type) {
		int atNum = this.getAtomicNumber();
		// String symbol = chemicalElement.getSymbol();
		boolean isType = false;
		if (type.equals(Type.TRANSITION_METAL)) {
			isType = (atNum > 20 && atNum <= 30) ||
			(atNum > 38 && atNum <= 48) ||
			(atNum > 56 && atNum <= 80);
		} else if (type.equals(Type.LANTHANIDE)) {
			isType = (atNum >= 58 && atNum <= 71);
		} else if (type.equals(Type.ACTINIDE)) {
			isType = atNum >= 90 && atNum <= 103;
		} else if (type.equals(Type.METAL)) {
			isType = isChemicalElementType(Type.TRANSITION_METAL) ||
			isChemicalElementType(Type.LANTHANIDE) ||
			isChemicalElementType(Type.ACTINIDE) ||
			isChemicalElementType(Type.GROUP_A) ||
			isChemicalElementType(Type.GROUP_B) ||
			// include metalloids on left of step
			(atNum == 13) ||
			(atNum >= 31 && atNum <= 32) ||
			(atNum >= 49 && atNum <= 51) ||
			(atNum >= 81 && atNum <=84);
		} else if (type.equals(Type.METAL_NOT_SEMI_METAL)) {
			isType = isChemicalElementType(Type.TRANSITION_METAL) ||
			isChemicalElementType(Type.LANTHANIDE) ||
			isChemicalElementType(Type.ACTINIDE) ||
			isChemicalElementType(Type.GROUP_A) ||
			isChemicalElementType(Type.GROUP_B);
		} else if (type.equals(Type.NON_METAL)) {
			isType = atNum >=5 && atNum <= 10 ||
			atNum >=14 && atNum <= 18 ||
			atNum >=33 && atNum <= 36 ||
			atNum >=52 && atNum <= 54 ||
			atNum >=85 && atNum <= 86;
		} else if (type.equals(Type.PBLOCK)) {
			isType = atNum >= 5 && atNum <= 10 || // B, C, N, O, F,Ne
			atNum >= 14 && atNum <= 18 || // Si, P, S,Cl,Ar
			atNum >= 32 && atNum <= 36 || // Ge,As,Se,Br,Kr
			atNum >= 53 && atNum <= 54 // I,Xe
			;
		} else if (type.equals(Type.GROUP_A)) {
			isType = atNum == 3 || atNum == 11 || atNum == 19 ||
			atNum == 37 || atNum == 55 || atNum ==87;
		} else if (type.equals(Type.GROUP_B)) {
			isType = atNum == 4 || atNum == 12 || atNum == 20 ||
			atNum == 38 || atNum == 56 || atNum ==88;
		} else if (type.equals(Type.SEMI_METAL)) {
			isType = atNum == 13 || atNum == 31 || atNum == 32 ||
			atNum >= 49 && atNum <= 51 ||
			atNum >= 81 && atNum <= 84
			;
		} else if (type.equals(Type.HALOGEN)) {
			isType = atNum == 9 || atNum == 17 || atNum == 35 ||
			atNum == 53 || atNum == 85;
			;
		} else {
			throw new RuntimeException("Bad type for " + type);
		}
		return isType;
	}

	/**
     * get the element corresponding to a (case-insensitive) atomicSymbol; else
     * returns null.
     * 
     * @param symbol case insensitive
     * @return element or null if not found
     */
    public static ChemicalElement getChemicalElementIgnoreCase(String symbol) {
        symbol = symbol.toUpperCase();
        return pTable.get(symbol);
    }

    /** get the element corresponding to a CASE-SENSITIVE atomicSymbol.
     * 
     * @param symbol
     * @return element or null if not found
     */
    public static ChemicalElement getChemicalElement(String symbol) {
        return pTable.get(symbol);
    }

    /** get the element corresponding to a Type.
     * not all elements are present
     * @param symbol
     * @return element or null if not found
     */
    public static ChemicalElement getChemicalElement(AS as) {
        return pTable.get(as.value);
    }

    
    /** gets chemical element corresponding to first 2 or 1 chars.
     * looks at first two character to see if they are a double-char
     * element (case-sensitive) else looks ate first char
     * length of string can be found with getSymbol().length()
     * @param s string to analyze (NOT trimmed)
     * @return element or null if not found
     */
    public static ChemicalElement grabChemicalElement(String s) {
        ChemicalElement element = null;
        if (s == null || s.length() == 0) {
            //
        } else if (s.length() == 1) {
            element = ChemicalElement.getChemicalElement(s);
        } else {
            String ss = s.substring(0,2);
            element = ChemicalElement.getChemicalElement(ss);
            if (element == null) {
                element = ChemicalElement.getChemicalElement(s.substring(0,1));
            }
        }
        return element;
    }

    /**
     * get the element corresponding to atomic number; else returns null.
     * 
     * @param atomicNumber
     * @return element
     */
    public static ChemicalElement getElement(int atomicNumber) {
        if (atomicNumber < 1 || atomicNumber >= MAXELEM) {
            return null;
        }
        return periodicTable[atomicNumber];
    }

    /** generates periodic table. 
     * Element sysmbols are CASE-SENSITIVE
     * */
    // / @cond DOXYGEN_STATIC_BLOCK_WORKAROUND
    static {
        ChemicalElement el;

        // Reads elemental data from ELEMENT_FILE
        // ClassLoader l = ClassLoader.getSystemClassLoader();
        Document document = null;
        try {
            document = CMLUtil.getXMLResource(ELEMENT_FILE);
        } catch (IOException e1) {
            throw new RuntimeException("BUG: cannot read PT resource file: "+
                ELEMENT_FILE);
        }

        document = null;
        try {
            document = CMLUtil.getXMLResource(ELEMENT_FILE);
        } catch (IOException e1) {
            throw new RuntimeException("BUG: cannot read PT resource file: "+
                ELEMENT_FILE);
        }

        Elements elements = ((Element) document.getRootElement())
                .getChildElements("element");
        for (int i = 0; i < elements.size(); i++) {
            Element element = (Element) elements.get(i);

            String symbol = element.getAttributeValue("id");
            // logger.info("Adding element: " + atomicSymbol);
            int atNum = Integer.parseInt(element
                    .getAttributeValue("atomicnumber"));
            double atWeight = getWeight(element, "webelements");

            el = new ChemicalElement(symbol, atNum, atWeight);
//            pTable.put(el.atomicSymbol.toUpperCase(), el);
            pTable.put(el.atomicSymbol, el);

            String sGroup = element.getAttributeValue("group");
            if (sGroup != null) {
                el.group = Integer.parseInt(sGroup);
            } else {
                el.group = 0;
            }

            String sPeriod = element.getAttributeValue("period");
            if (sPeriod != null) {
                el.period = Integer.parseInt(sPeriod);
            } else {
                el.period = 0;
            }

            double d = getRadius(element, "webelements", "covalent", "empirical");
            el.setCovalentRadius(d);
            d = getRadius(element, "webelements", "atomic", "empirical");
            el.setAtomicRadius(d);
            d = getRadius(element, "webelements", "vanderwaals", null);
            el.setVDWRadius(d);

            el.setElectronegativity(getElectronegativity(element,
                    "webelements", "pauling"));

            el.electronicGroundState = getElectronicState(element,
                    "webelements", "groundstate");

            Elements nodelist = element.getChildElements("isotopes");
            int[] ii = {};
            double[] aa = {};

            if (nodelist.size() > 0) {
                Element node = (Element) nodelist.get(0);
                Elements isotopes = node.getChildElements("isotope");

                if (isotopes.size() > 0) {
                    ii = new int[isotopes.size()];
                    aa = new double[isotopes.size()];

                    for (int j = 0; j < isotopes.size(); j++) {
                        Element isotope = (Element) isotopes.get(j);
                        try {
                            ii[j] = Integer.parseInt(isotope
                                    .getAttributeValue("mass"));
                            aa[j] = Double.parseDouble(isotope
                                    .getAttributeValue("abundance"));
                        } catch (NullPointerException e) {
                            ;
                        }
                    }
                }
            }
            el.addIsotope(ii, aa);

            nodelist = element.getChildElements("rgb");
            if (nodelist.size() > 0) {
                Element node = (Element) nodelist.get(0);

                float red = Float.parseFloat(node.getAttributeValue("red"));
                float green = Float.parseFloat(node.getAttributeValue("green"));
                float blue = Float.parseFloat(node.getAttributeValue("blue"));

                el.setColor(new Color(red, green, blue));
            }
        }
    }

    // / @endcond

    private static double getWeight(Element element, String source) {
        Elements weights = element.getChildElements("mass");
        for (int i = 0; i < weights.size(); i++) {
            Element weight = (Element) weights.get(i);
            if (source != null
                    && source.equals(weight.getAttributeValue("source"))) {
                return Double.parseDouble(weight.getValue());
            }
        }
        return 0;
    }

    private static double getRadius(Element element, String source,
            String type, String context) {
        Elements radiiList = element.getChildElements("radii");
        for (int i = 0; i < radiiList.size(); i++) {
            Element radii = (Element) radiiList.get(i);
            if (source != null
                    && !source.equals(radii.getAttributeValue("source"))) {
                continue;
            }

            Elements radiusList = radii.getChildElements("radius");
            for (int j = 0; j < radiusList.size(); j++) {
                Element radius = (Element) radiusList.get(j);
                if (type != null
                    && type.equals(radius.getAttributeValue("type"))
                    && (context == null ||
                    context.equals(radius.getAttributeValue("context")))) {
                    double rad = Double.parseDouble(radius.getValue());
                    if (radius.getAttributeValue("unit").equals("pm")) {
                        rad /= 100.0;
                    }
                    return rad;
                }
            }
        }
        return 0;
    }

    private static double getElectronegativity(Element element, String source,
            String type) {
        Elements enegList = element.getChildElements("electronegativity");
        for (int i = 0; i < enegList.size(); i++) {
            Element eneg = (Element) enegList.get(i);
            if (source != null
                    && source.equals(eneg.getAttributeValue("source"))
                    && type != null
                    && type.equals(eneg.getAttributeValue("type"))) {
                return Double.parseDouble(eneg.getValue());
            }
        }

        return 0;
    }

    private static String getElectronicState(Element element, String source,
            String type) {
        Elements eStates = element.getChildElements("electronicconfiguration");
        for (int i = 0; i < eStates.size(); i++) {
            Element estate = (Element) eStates.get(i);
            if (source != null
                    && source.equals(estate.getAttributeValue("source"))
                    && type != null
                    && type.equals(estate.getAttributeValue("type"))) {
                return estate.getValue();
            }
        }

        return "";
    }

    /**
     * Outputs details of element.
     * 
     * @param el
     *            Element to output
     */
    public static void debug(ChemicalElement el) {

        logger.info("ChemicalElement:");
        logger.info(" > AS: " + el.getSymbol());
        logger.info(" > Atomic number: " + el.getAtomicNumber());
        logger.info(" > Group: " + el.getGroup());
        logger.info(" > Period: " + el.getPeriod());
        logger.info(" > Atomic weight: " + el.getAtomicWeight());
        logger.info(" > Main isotope: " + el.getMainIsotope());
        logger.info(" > Valence electrons: " + el.getValenceElectrons());
        logger.info(" > Ground state config: " + el.getElectronicGroundState());
        logger.info(" > Electronegativity: " + el.getElectronegativity());
        logger.info(" > Atomic radius: " + el.getAtomicRadius());
        logger.info(" > Covalent radius: " + el.getCovalentRadius());
        logger.info(" > Van-der-Waal's radius: " + el.getVDWRadius());
        logger.info(" > Isotopes:");
        int[] isoMass = el.getIsotopeMasses();
        double[] isoAbun = el.getIsotopeAbundances();
        for (int i = 0; i < isoMass.length; i++) {
            logger.info(" >     " + isoMass[i] + " (" + isoAbun[i] + "%)");
        }
        logger.info(" > Color: " + el.getColor().toString());
        logger.info("----------------------------------------");
    }

    /**
     * gets default tolerance from sum of covalent radii.
     * 
     * @return the tolerance (default 0.2)
     */
    public static double getBondingRadiusTolerance() {
        return bondingRadiusTolerance;
    }

    /**
     * sets boding radius tolerance.
     * 
     * @param tol
     */
    public static void setBondingRadiusTolerance(double tol) {
        bondingRadiusTolerance = (tol > 0.0) ? tol : bondingRadiusTolerance;
    }

    /** get set of elements defined by symbols.
     * silently skips any strings which are not elements or
     * duplicates
     * @param symbols list of symbols
     * @return set of elements
     */
    public static Set<ChemicalElement> getElementSet(String[] symbols) {
        List<String> symbolList = new ArrayList<String>();
        for (String symbol : symbols) {
            symbolList.add(symbol);
        }
        return getElementSet(symbolList);
    }
    
    /** get set of elements defined by symbols.
     * silently skips any strings which are not elements or
     * duplicates
     * @param symbolList list of symbols
     * @return set of elements
     */
    public static Set<ChemicalElement> getElementSet(List<String> symbolList) {
        Set<ChemicalElement> set = new HashSet<ChemicalElement>();
        for (String symbol : symbolList) {
            ChemicalElement element = ChemicalElement.getChemicalElement(symbol);
            if (element != null) {
                set.add(element);
            }
        }
        return set;
    }
}    
