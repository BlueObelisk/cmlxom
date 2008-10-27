package org.xmlcml.cml.schema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.xmlcml.cml.schema.cml.lite.AnySpecification;
import org.xmlcml.cml.schema.cml.lite.AtomArraySpecification;
import org.xmlcml.cml.schema.cml.lite.AtomParitySpecification;
import org.xmlcml.cml.schema.cml.lite.AtomSpecification;
import org.xmlcml.cml.schema.cml.lite.BondArraySpecification;
import org.xmlcml.cml.schema.cml.lite.BondSpecification;
import org.xmlcml.cml.schema.cml.lite.BondStereoSpecification;
import org.xmlcml.cml.schema.cml.lite.CmlSpecification;
import org.xmlcml.cml.schema.cml.lite.DictionarySpecification;
import org.xmlcml.cml.schema.cml.lite.EntrySpecification;
import org.xmlcml.cml.schema.cml.lite.FormulaSpecification;
import org.xmlcml.cml.schema.cml.lite.LabelSpecification;
import org.xmlcml.cml.schema.cml.lite.MoleculeSpecification;
import org.xmlcml.cml.schema.cml.lite.NameSpecification;
import org.xmlcml.cml.schema.cml.lite.PeakListSpecification;
import org.xmlcml.cml.schema.cml.lite.PeakSpecification;
import org.xmlcml.cml.schema.cml.lite.PeakStructureSpecification;
import org.xmlcml.cml.schema.cml.lite.PropertySpecification;
import org.xmlcml.cml.schema.cml.lite.ScalarSpecification;
import org.xmlcml.cml.schema.cml.lite.SpectrumSpecification;

public abstract class ElementSpecification {
	public static Logger LOG = Logger.getLogger(ElementSpecification.class);
	static {
		LOG.setLevel(Level.DEBUG);
	}
	
	public final static ElementSpecification ANY;
	public final static ElementSpecification ATOM;
	public final static ElementSpecification ATOMARRAY;
	public final static ElementSpecification ATOMPARITY;
	public final static ElementSpecification BOND;
	public final static ElementSpecification BONDARRAY;
	public final static ElementSpecification BONDSTEREO;
	public final static ElementSpecification CML;
	public final static ElementSpecification DICTIONARY ;
	public final static ElementSpecification ENTRY;
	public final static ElementSpecification FORMULA;
	public final static ElementSpecification LABEL;
	public final static ElementSpecification MOLECULE;
	public final static ElementSpecification NAME;
	public final static ElementSpecification PEAK;
	public final static ElementSpecification PEAKLIST;
	public final static ElementSpecification PEAKSTRUCTURE;
	public final static ElementSpecification PROPERTY;
	public final static ElementSpecification SCALAR;
	public final static ElementSpecification SPECTRUM;

	public final static Map<String, ElementSpecification> ELEMENTMAP;
	static {
		ELEMENTMAP = new HashMap<String, ElementSpecification>();
		
		//==============================================================
		ANY = new AnySpecification();
		ATOM = new AtomSpecification();
		ATOMARRAY = new AtomArraySpecification();
		ATOMPARITY = new AtomParitySpecification();
		BOND = new BondSpecification();
		BONDARRAY = new BondArraySpecification();
		BONDSTEREO = new BondStereoSpecification();
		CML = new CmlSpecification();
		DICTIONARY = new DictionarySpecification();
		ENTRY = new EntrySpecification();
		FORMULA = new FormulaSpecification();
		LABEL = new LabelSpecification();
		MOLECULE = new MoleculeSpecification();
		NAME = new NameSpecification();
		PEAK = new PeakSpecification();
		PEAKLIST = new PeakListSpecification();
		PEAKSTRUCTURE = new PeakStructureSpecification();
		PROPERTY = new PropertySpecification();
		SCALAR = new ScalarSpecification();
		SPECTRUM = new SpectrumSpecification();
		//==============================================================
		if (LOG.getLevel().isGreaterOrEqual(Level.DEBUG)) {
			debugAll();
		}
	}
	
	public static void debugAll() {
		LOG.debug("MAP SIZE: "+ELEMENTMAP.size());
		for (String name : ELEMENTMAP.keySet()) {
			ElementSpecification spec = ELEMENTMAP.get(name);
			spec.debug();
		}
	}
	
	private List<AttributeSpecification> allowedAttributeList = 
		new ArrayList<AttributeSpecification>();
	// elements which can be added (not appended)
	private List<String> addableList = 
		new ArrayList<String>();
	// convenience technically deducible from contentModel
	private List<String> allowedChildrenList = 
		new ArrayList<String>();
	private List<String> assertionList = 
		new ArrayList<String>();
	private List<String> contentModelList = 
		new ArrayList<String>();
	private List<String> reportList = 
		new ArrayList<String>();
	
	private String localName;
	private TypeSpecification contentType = null;
	
	public ElementSpecification(String localName) {
		this.localName = localName;
		init();
	}
	
	private void init() {
		addElementAndConstraints();
	}
	
	public void addAttributes(String[] stringList) {
		for (String attName : stringList) {
			AttributeSpecification attribute = AttributeSpecification.ATTRIBUTEMAP.get(attName);
			if (attribute == null) {
				throw new RuntimeException("unsupported attribute: "+attName);
			}
			if (!allowedAttributeList.contains(attribute)) {
				allowedAttributeList.add(attribute);
			}
		}
	}
	
	public void addContent(TypeSpecification typeNG) {
		contentType = typeNG;
	}
	
	public void addAllowedChildren(String[] stringList) {
		for (String childName : stringList) {
			if (!allowedChildrenList.contains(childName)) {
				allowedChildrenList.add(childName);
			}
		}
	}

	public void addAddables(String[] stringList) {
		for (String s : stringList) {
			addableList.add(s);
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

	public List<AttributeSpecification> getAllowedAttributeList() {
		return allowedAttributeList;
	}

	public List<String> getAllowedElementList() {
		return allowedChildrenList;
	}

	public String getLocalName() {
		return localName;
	}

	public TypeSpecification getContentType() {
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

	/**
	 * @throws RuntimeException
	 */
	protected void addToElementMap() throws RuntimeException {
		if (ELEMENTMAP.containsKey(getLocalName())) {
			throw new RuntimeException("BUG - duplicate elementSpecification: "+getLocalName());
		}
		ELEMENTMAP.put(getLocalName(), this);
	}
	
	protected abstract void addAddables();
	protected abstract void addAllowedChildren();
	protected abstract void addAttributes();
	protected abstract void addAssertions();
	protected abstract void addContentModel();

	/**
	 * @throws RuntimeException
	 */
	protected void addElementAndConstraints() throws RuntimeException {
		addToElementMap();
		addAddables();
		addAttributes();
		addAssertions();
		addContentModel();
		addAllowedChildren();
	}
	
	public void debug() {
		System.out.println();
		LOG.debug(localName);
		for (String addName : addableList) {
			LOG.debug("^^^ "+addName);
		}
		for (AttributeSpecification attSpec : allowedAttributeList) {
			attSpec.debug();
		}
		for (String childName : allowedChildrenList) {
			LOG.debug(">>> "+childName);
		}
	}
}
