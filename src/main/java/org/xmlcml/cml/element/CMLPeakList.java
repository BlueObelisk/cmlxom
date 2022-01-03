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

package org.xmlcml.cml.element;

import java.util.ArrayList;
import java.util.List;

import nu.xom.Element;
import nu.xom.Node;
import nu.xom.Nodes;

import org.xmlcml.cml.base.CMLConstants;
import org.xmlcml.cml.base.CMLElement;
import org.xmlcml.cml.interfacex.PeakOrGroup;

/**
 * user-modifiable class supporting peakList. 
 * NO INTERNAL index of peaks (uses XPATH)
 */
public class CMLPeakList extends AbstractPeakList {

	/** type of comparsion */
	public enum Type {
	    /** dewisott */
		XVALUE,
	    /** dewisott */
		YVALUE;
	}
	

	/** namespaced element name.*/
	public final static String NS = C_E+TAG;

    /** argument name to identify id.
     */
    public final static String IDX = "idx";
    
    /**
     * constructor.
     */
    public CMLPeakList() {
    }

    /**
     * constructor.
     *
     * @param old
     */
    public CMLPeakList(CMLPeakList old) {
        super((AbstractPeakList) old);

    }
    
    /**
     * COPY constructor from list of peaks
     * @param peakList
     */
    public CMLPeakList(List<CMLPeak> peakList) {
    	for (CMLPeak peak : peakList) {
    		this.addPeak(peak);
    	}
    }
    
    /**
     * copy node .
     *
     * @return Node
     */
    public Element copy() {
        return new CMLPeakList(this);

    }

    /**
     * create new instance in context of parent, overridable by subclasses.
     *
     * @param parent
     *            parent of element to be constructed (ignored by default)
     * @return CMLPeakList
     */
    public CMLElement makeElementInContext(Element parent) {
        return new CMLPeakList();

    }
    
    /**
     * update Index
     * @param parent element
     */
    public void finishMakingElement(Element parent) {
    }

    /**
     * @return list of peak children (not peakGroups or descendants)
     */
    public List<CMLPeak> getPeakChildren() {
    	Nodes nodes = this.query("./cml:peak", CMLConstants.CML_XPATH);
    	List<CMLPeak> peaks = new ArrayList<CMLPeak>();
    	for (int i = 0; i < nodes.size(); i++) {
    		peaks.add((CMLPeak) nodes.get(i));
    	}
    	return peaks;
    }
    
    /**
     * @return list of peak descendants (not peakGroups)
     */
    public List<CMLPeak> getPeakDescendants() {
    	Nodes nodes = this.query(".//cml:peak", CMLConstants.CML_XPATH);
    	List<CMLPeak> peaks = new ArrayList<CMLPeak>();
    	for (int i = 0; i < nodes.size(); i++) {
    		peaks.add((CMLPeak) nodes.get(i));
    	}
    	return peaks;
    }
    
    /**
     * @return list of peak or peakGroup children (not descendants)
     */
    public List<PeakOrGroup> getPeakOrGroupChildren() {
    	Nodes nodes = this.query("./cml:peak | ./cml:peakGroup", CMLConstants.CML_XPATH);
    	List<PeakOrGroup> peaks = new ArrayList<PeakOrGroup>();
    	for (int i = 0; i < nodes.size(); i++) {
    		peaks.add((PeakOrGroup) nodes.get(i));
    	}
    	return peaks;
    }

}
