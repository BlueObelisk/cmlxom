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

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nu.xom.Element;
import nu.xom.Node;
import nu.xom.Nodes;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.xmlcml.cml.base.CMLConstants;
import org.xmlcml.cml.base.CMLElement;
import org.xmlcml.cml.base.CMLElements;
import org.xmlcml.euclid.Angle;
import org.xmlcml.euclid.Point3;
import org.xmlcml.euclid.Util;

/**
 * user-modifiable class supporting angle.
 */
public class CMLAngle extends AbstractAngle {

    private static Logger LOG = Logger.getLogger(CMLAngle.class);
    static {
    	LOG.setLevel(Level.DEBUG);
    }

	/** namespaced element name.*/
	public final static String NS = C_E+TAG;

    /**
     * constructor.
     */
    public CMLAngle() {
    }

    /**
     * constructor.
     *
     * @param old
     */
    public CMLAngle(CMLAngle old) {
        super((AbstractAngle) old);

    }

    /**
     * copy node .
     *
     * @return Node
     */
    public Node copy() {
        return new CMLAngle(this);

    }

    /**
     * create new instance in context of parent, overridable by subclasses.
     *
     * @param parent
     *            parent of element to be constructed (ignored by default)
     * @return CMLAngle
     */
    public CMLElement makeElementInContext(Element parent) {
        return new CMLAngle();

    }

    /**
     * gets atomIds as list.
     *
     * @return the atomIds (null if no atomRefs3)
     */
    public List<String> getAtomIds() {
        List<String> idList = null;
        String[] atomRefs3 = getAtomRefs3();
        if (atomRefs3 != null) {
            idList = new ArrayList<String>();
            for (String s : atomRefs3) {
                idList.add(s);
            }
        }
        return idList;
    }

    /**
     * gets atoms as array of atoms.
     *
     * @param molecule
     * @return the atoms (null if no atomRefs3)
     */
    public List<CMLAtom> getAtoms(CMLMolecule molecule) {
    	List<CMLAtom> atomList = new ArrayList<CMLAtom>();
    	for (String atomRef : getAtomRefs3()) {
    		CMLAtom atom = molecule.getAtomById(atomRef);
    		if (atom == null) {
    			throw new RuntimeException("cannot find atom: "+atomRef);
    		}
    		if (atomList.contains(atom)) {
    			throw new RuntimeException("duplicate atom in angle: "+atomRef);
    		}
    		atomList.add(atom);
    	}
    	return atomList;
    }

    /**
     * gets value calculated from coordinates. requires atomRefs3 ro be set and
     * valid. then gets the angle between atomRefs3 0-1-2
     *
     * @param molecule
     *            owning molecule (all atoms must be in this)
     * @return the angle in degrees (NaN if cannot calculate)
     */
    public double getCalculatedAngle(CMLMolecule molecule) {
    	List<CMLAtom> atomList = this.getAtoms(molecule);
        return this.getCalculatedAngle(atomList);
    }

    /**
     * Finds ancestral molecule and then uses getCalculatedAngle(CMLMolecule)
     *
     * @return the angle in degrees (null if cannot calculate)
     */
    public Double getCalculatedAngle() {
    	Double angle = null;
    	CMLMolecule molecule = null;
    	try {
    		molecule = CMLMolecule.getAncestorMolecule(this);
    		angle = (molecule == null) ? null : getCalculatedAngle(molecule);
    	} catch (Exception e) {
    		// return null
    	}
    	return angle;
    }

    /**
     * gets value calculated from coordinates. requires atomRefs3 ro be set and
     * valid. then gets the angle between atomRefs3 0-1-2
     *
     * @param atomSet
     * @return the angle in degrees (NaN if cannot calculate)
     */
    public double getCalculatedAngle(List<CMLAtom> atomList) {
        double calculatedAngle = Double.NaN;
        if (atomList != null) {
        	if (atomList.size() != 3) {
        		throw new RuntimeException("angle requires 3 atoms");
        	}
            Point3[] coord = new Point3[3];
            int i = 0;
            for (CMLAtom atom : atomList) {
                coord[i] = atom.getXYZ3();
                if (coord[i++] == null) {
                    break;
                }
            }
            try {
                Angle angle = Point3.getAngle(coord[0], coord[1], coord[2]);
                if (angle != null) {
                    calculatedAngle = angle.getDegrees();
                }
            } catch (Exception e) {
                throw new RuntimeException("Bug: " + e);
            }
        }
        return calculatedAngle;
    }

    /** create key from atomRefs3 attribute and atomHash
     *
     * @return the hash null if no atomRefs3
     */
    public String atomHash() {
        String[] a = this.getAtomRefs3();
        return (a == null) ? null : atomHash(a[0], a[1], a[2]);
    }

    /**
     * create key from three atoms. a1-a2-a3 and a3-a2-a1 are equivalent
     *
     * @param atomId1
     * @param atomId2
     * @param atomId3
     * @return the hash
     */
    public static String atomHash(final String atomId1, final String atomId2,
            final String atomId3) {
        String result = null;
        if (!(atomId1 == null || atomId2 == null || atomId3 == null)) {
            String a1 = atomId1;
            String a3 = atomId3;
            if (atomId1.compareTo(atomId3) > 0) {
                a3 = atomId1;
                a1 = atomId3;
            } else if (atomId1.compareTo(atomId3) < 0) {
                a1 = atomId1;
                a3 = atomId3;
            }
            result = a1 + CMLBond.HASH_SYMB + atomId2 + CMLBond.HASH_SYMB + a3;
        }
        return result;
    }

    /** translates elements to list.
     * @param angleElements
     * @return the list of angles
     * @deprecated try to use List<CMLAngle>
     */
    public static List<CMLAngle> getList(CMLElements<CMLAngle> angleElements) {
        List<CMLAngle> angleList = new ArrayList<CMLAngle>();
        for (CMLAngle angle : angleElements) {
            angleList.add(angle);
        }
        return angleList;
    }

    /**
     * gets a Map of angles indexed by atoms. the map has the keys of atomHashs
     * for the angles
     *
     * @param angleList
     *            list of the angles
     * @return the indexed table (keyed on atomHash)
     */
    public static Map<String, CMLAngle> getIndexedAngles(List<CMLAngle> angleList) {
        Map<String, CMLAngle> angleTable = new HashMap<String, CMLAngle>();
        for (CMLAngle angle : angleList) {
            String[] id = angle.getAtomRefs3();
            String key = atomHash(id[0], id[1], id[2]);
            angleTable.put(key, angle);
        }
        return angleTable;
    }

    /** set atomRefs3 attribute.
     *
     * @param atom0
     * @param atom1
     * @param atom2
     */
    public void setAtomRefs3(
            CMLAtom atom0, CMLAtom atom1, CMLAtom atom2) {
            this.setAtomRefs3(
                new String[]{
                    atom0.getId(),
                    atom1.getId(),
                    atom2.getId()
                });
    }

    /** writes angles to an XHTML table.
     * columns are atom1.label atom2.label atom3.label angle in deg
     * @param w writer to output
     * @param angleList
     * @param molecule
     * @throws IOException
     */
    public static void outputHTML(
        Writer w, List<CMLAngle> angleList,
        CMLMolecule molecule) throws IOException {
        if (angleList.size() > 0) {
            w.write("<table border='1'>\n");
            w.write("<tr>");
            w.write("<th>");
            w.write("atom1 (id)");
            w.write("</th>");
            w.write("<th>");
            w.write("atom2 (id)");
            w.write("</th>");
            w.write("<th>");
            w.write("atom3 (id)");
            w.write("</th>");
            w.write("<th>");
            w.write("angle");
            w.write("</th>");
            w.write("</tr>\n");
            for (CMLAngle angle : angleList) {
                List<CMLAtom> atoms = angle.getAtoms(molecule);
                w.write("<tr>");
                for (int i = 0; i < 3; i++) {
                    w.write("<td>");
                    CMLAtom atom = atoms.get(i);
                    Nodes labelNodes = atom.query(
                        CMLScalar.NS+"[@dictRef='iucr:_atom_site_label']", CMLConstants.CML_XPATH);
                    String label = ((CMLScalar) labelNodes.get(0)).getXMLContent()+" ("+atom.getId()+S_RBRAK;
                    w.write( (label == null) ? atom.getId() : label);
                    w.write("</td>");
                }
                String s = ""+angle.getXMLContent();
                w.write("<td>"+s.substring(0, Math.min(6, s.length()))+"</td>");
                w.write("</tr>\n");
            }
            w.write("</table>\n");
        }
    }

    /** get string.
     *
     * @return the string
     */
    public String getString() {
        String s = S_EMPTY;
        String[] a = getAtomRefs3();
        if (a != null) {
            s += Util.concatenate(a, S_MINUS);
        }
        s += S_SPACE;
        s += this.getXMLContent();
        return s;
    }
}
