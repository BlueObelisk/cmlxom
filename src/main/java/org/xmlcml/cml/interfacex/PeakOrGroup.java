/**
 *    Copyright 2011 Peter Murray-Rust et. al.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

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
