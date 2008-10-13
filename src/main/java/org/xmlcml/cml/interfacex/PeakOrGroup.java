package org.xmlcml.cml.interfacex;

/**
 * tags a CMLPeak or a CMLPeakGroup (normally as potential children
 * of CMLPeakList
 */
public interface PeakOrGroup {

	// these are all from attributes
	/**
	 * @return xvalue
	 */
	double getXValue();
	
	/**
	 * @return xmin
	 */
	double getXMin();
	
	/**
	 * @return xmax
	 */
	double getXMax();
	
	/**
	 * @return xwidth
	 */
	double getXWidth();
	
	/**
	 * @return xunits
	 */
	String getXUnits();
	
	/**
	 * @return yalue
	 */
	double getYValue();
	
	/**
	 * @return ymin
	 */
	double getYMin();
	
	/**
	 * @return ymax
	 */
	double getYMax();
	
	/**
	 * @return ywidth
	 */
	double getYWidth();
	
	/**
	 * @return yunits
	 */
	String getYUnits();
	
	/**
	 * @return atomrefs
	 */
	String[] getAtomRefs();
	
	/**
	 * @return bondrefs
	 */
	String[] getBondRefs();
	
	/**
	 * @return id
	 */
	String getId();
	
	/**
	 * @return integral
	 */
	String getIntegral();
	
	/**
	 * @return height
	 */
	double getPeakHeight();
	
	/**
	 * @return multiplicity
	 */
	String getPeakMultiplicity();
	
	/**
	 * @return shape
	 */
	String getPeakShape();
	
	/**
	 * @return units
	 */
	String getPeakUnits();
}
