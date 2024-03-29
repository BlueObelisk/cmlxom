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
import nu.xom.ParentNode;

import org.xmlcml.cml.base.CMLElement;
import org.xmlcml.cml.base.CMLElements;

/**
 * user-modifiable class supporting spectrum. * autogenerated from schema use as
 * a shell which can be edited
 *
 */
public class CMLSpectrum extends AbstractSpectrum {

	public enum SpectrumType {
		/*
		 * JCAMP has
		   public final static int UNKNOWN = 0;
		    public final static int INFRARED = 2 << 0;
		    public final static int IR = 2 << 0;
		    public final static int RAMAN = 2 << 1;
		    public final static int ULTRAVIOLET = 2 << 2;
		    public final static int UV = 2 << 2;
		    public final static int FLUORESCENCE = 2 << 3;
		    public final static int NMR = 2 << 4;
		    public final static int MASS = 2 << 5;
		    public final static int MS = 2 << 5;
		    public final static int CHROMATOGRAM = 2 << 16;
		    public final static int GC = 2 << 17 | CHROMATOGRAM;
		    public final static int LC = 2 << 18 | CHROMATOGRAM;
		    public final static int FID = 2 << 23;
		    public final static int SPEC2D = 2 << 24;
		    public final static int NMRFID = NMR | FID;
		    public final static int NMR2D = NMR | SPEC2D;
		    public final static int FLUORESCENCE2D = FLUORESCENCE | SPEC2D;
		    public final static int GCMS = MS | GC;
		    public final static int LCMS = MS | LC;
*/
		UNKNOWN,
		IR,
		RAMAN,
		UV,
		FLUORESCENCE,
		NMR,
		MASS,
		CHROMATOGRAM,
		UNSUPPORTED
	}
	
	/** namespaced element name.*/
	public final static String NS = C_E+TAG;

    /**
     * contructor.
     */
    public CMLSpectrum() {
    }

    /**
     * contructor.
     *
     * @param old
     */
    public CMLSpectrum(CMLSpectrum old) {
        super((AbstractSpectrum) old);

    }

    /**
     * copy node .
     *
     * @return Node
     */
    public Element copy() {
        return new CMLSpectrum(this);

    }

    /**
     * create new instance in context of parent, overridable by subclasses.
     *
     * @param parent
     *            parent of element to be constructed (ignored by default)
     * @return CMLSpectrum
     */
    public CMLElement makeElementInContext(Element parent) {
        return new CMLSpectrum();

    }

    /**
     * gets molecule context for spectrum. In simple documents we assume that
     * molecules will occur as siblings of spectrum elements. There may be
     * several spectrums but only one molecule is allowed.
     *
     * @return the sibling molecule or null.
     * @throws RuntimeException
     *             if there are duplicate sibling molecules
     */
    public CMLMolecule getSiblingMolecule() {
        CMLMolecule molecule = null;
        ParentNode parent = this.getParent();
        if (parent != null) {
            for (int i = 0; i < parent.getChildCount(); i++) {
                Node node = parent.getChild(i);
                if (node instanceof CMLMolecule) {
                    if (molecule != null) {
                        throw new RuntimeException("duplicate sibling molecules");
                    }
                    molecule = (CMLMolecule) node;
                }
            }
        }
        return molecule;
    }

    /**
     * gets nearest ancestor spectrum element.
     *
     * @param element
     *            descendant of spectrum
     * @return the owner spectrum or null if not found
     */
    public static CMLSpectrum getSpectrum(CMLElement element) {
        CMLSpectrum spectrum = null;
        Node node = element;
        while (true) {
            ParentNode parent = node.getParent();
            if (parent == null) {
                break;
            } else if (parent instanceof CMLSpectrum) {
                spectrum = (CMLSpectrum) parent;
            }
            node = parent;
        }
        return spectrum;
    }

    /**
     * returns aunt molecule of ancestor spectrum.
     *
     * @param element
     *            to find aunt of.
     * @return the molecule or null if not found
     */
    public static CMLMolecule getAuntMolecule(CMLElement element) {
        CMLMolecule molecule = null;
        CMLSpectrum spectrum = CMLSpectrum.getSpectrum(element);
        if (spectrum != null) {
            molecule = spectrum.getSiblingMolecule();
        }
        return molecule;
    }

    /**
     * gets all peaks in this spectrum which couple to an atom
     *
     * @param atom
     *            the atom the peaks should couple to
     * @return list of atom (zero length if none found)
     */
    public List<CMLPeak> getCouplingsTo(CMLAtom atom) {
        List<CMLPeak> peaksFound = new ArrayList<CMLPeak>();
        CMLMolecule molecule = atom.getMolecule();
        CMLElements<CMLPeakList> peakLists = getPeakListElements();
        for (CMLPeakList peakList : peakLists) {
            CMLElements<CMLPeak> peaks = peakList.getPeakElements();
            for (CMLPeak peak : peaks) {
                CMLElements<CMLPeakStructure> peakStructures = peak
                        .getPeakStructureElements();
                for (CMLPeakStructure peakStructure : peakStructures) {
                    List<CMLAtom> atoms = molecule.getAtomListByIds(peakStructure
                            .getAtomRefs());
                    if (atoms.contains(atom))
                        peaksFound.add(peak);
                }
            }
        }
        return peaksFound;
    }

    /**
     * gets all descendant peaks. these can be in PeakList, PeakGroup or nested
     * PeakGroup
     *
     * @param element
     *            which owns the descendants (normally a Spectrum, PeakList or
     *            PeakGroup
     * @return list of peaks (zero length if null)
     */
    public static List<CMLPeak> getDescendantPeaks(CMLElement element) {
        List<CMLPeak> peakList = new ArrayList<CMLPeak>();
        getDescendantPeaks(element, peakList);
        return peakList;
    }

    private static void getDescendantPeaks(CMLElement element,
            List<CMLPeak> peakList) {
        if (element != null && element instanceof CMLElement) {
            for (CMLElement child : element.getChildCMLElements()) {
                if (child instanceof CMLPeak) {
                    peakList.add((CMLPeak) child);
                } else {
                    getDescendantPeaks(child, peakList);
                }
            }
        }
    }

}
