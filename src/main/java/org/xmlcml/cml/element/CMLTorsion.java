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

import org.apache.log4j.Logger;
import org.xmlcml.cml.base.CMLConstants;
import org.xmlcml.cml.base.CMLElement;
import org.xmlcml.cml.base.CMLElements;
import org.xmlcml.euclid.Angle;
import org.xmlcml.euclid.Point3;
import org.xmlcml.euclid.Util;

/**
 * user-modifiable class supporting torsion. * autogenerated from schema use as
 * a shell which can be edited
 *
 */
public class CMLTorsion extends AbstractTorsion {

    final static Logger logger = Logger.getLogger(CMLTorsion.class.getName());

	/** namespaced element name.*/
	public final static String NS = C_E+TAG;

    /**
     * contructor.
     */
    public CMLTorsion() {
    }

    /**
     * contructor.
     *
     * @param old
     */
    public CMLTorsion(CMLTorsion old) {
        super((AbstractTorsion) old);

    }

    /**
     * copy node .
     *
     * @return Node
     */
    public Node copy() {
        return new CMLTorsion(this);

    }

    /**
     * create new instance in context of parent, overridable by subclasses.
     *
     * @param parent
     *            parent of element to be constructed (ignored by default)
     * @return CMLTorsion
     */
    public CMLElement makeElementInContext(Element parent) {
        return new CMLTorsion();

    }

    /**
     * gets atomIds as list.
     *
     * @return the atomIds (null if no atomRefs3)
     */
    public List<String> getAtomIds() {
        List<String> idList = null;
        String[] atomRefs4 = getAtomRefs4();
        if (atomRefs4 != null) {
            idList = new ArrayList<String>();
            for (String s : atomRefs4) {
                idList.add(s);
            }
        }
        return idList;
    }

    /**
     * gets atomRefs4 as list of atoms.
     *
     * uses the value in <torsion> element
     *
     * @param molecule
     * @return the atoms (null if no atomRefs4)
     */
    public List<CMLAtom> getAtoms(CMLMolecule molecule) {
        List<CMLAtom> atomList = null;
        String[] atomRefs4 = this.getAtomRefs4();
        if (atomRefs4 == null || molecule == null) {
            throw new RuntimeException(
                    "torsion must have molecule and atomRefs4 to get atoms");
        } else {
            atomList = new ArrayList<CMLAtom>();
            for (String atomRef : atomRefs4) {
                CMLAtom atom = molecule.getAtomById(atomRef);
                if (atom == null) {
                    throw new RuntimeException("cannot find atom " + atomRef);
                }
                atomList.add(atom);
            }
        }
        return atomList;
    }

    /**
     * gets atomRefs4 as list of atoms.
     *
     * uses the value in <torsion> element
     *
     * @param atomSet
     * @return the atoms (null if no atomRefs4)
     */
    public List<CMLAtom> getAtoms(CMLAtomSet atomSet) {
        List<CMLAtom> atomList = null;
        String[] atomRefs4 = this.getAtomRefs4();
        if (atomRefs4 == null || atomSet == null) {
            throw new RuntimeException(
                    "torsion must have atomSet and atomRefs4 to get atoms");
        } else {
            atomList = new ArrayList<CMLAtom>();
            for (String atomRef : atomRefs4) {
                CMLAtom atom = atomSet.getAtomById(atomRef);
                if (atom == null) {
                    throw new RuntimeException("cannot find atom " + atomRef);
                }
                atomList.add(atom);
            }
        }
        return atomList;
    }

    /**
     * gets value calculated from coordinates.
     *
     * @param molecule
     * @return the torsion (NaN if cannot calculate)
     */
    public double getCalculatedTorsion(CMLMolecule molecule) {
    	List<CMLAtom> atomList = this.getAtoms(molecule);
        return this.getCalculatedTorsion(atomList);
    }

    /**
     * gets value calculated from coordinates.
     *
     * @param atomSet
     * @return the torsion (NaN if cannot calculate)
     */
    public double getCalculatedTorsion(List<CMLAtom> atomList) {
        double calculatedTorsion = Double.NaN;
        if (atomList == null || atomList.size() != 4) {
            throw new RuntimeException("atom list must have 4 elements");
        }
        Point3[] coord = new Point3[4];
        for (int i = 0; i < 4; i++) {
            coord[i] = atomList.get(i).getXYZ3();
            if (coord[i] == null) {
                break;
            }
        }
        try {
            Angle torsion = Point3.getTorsion(coord[0], coord[1], coord[2],
                    coord[3]);
            calculatedTorsion = torsion.getDegrees();
        } catch (Exception e) {
            throw new RuntimeException("ERROR in torsion " + e);
        }
        return calculatedTorsion;
    }

    /**
     * hash for atoms.
     *
     * @param atomId1
     * @param atomId2
     * @param atomId3
     * @param atomId4
     * @return hash
     */
    public static String atomHash(String atomId1, String atomId2,
            String atomId3, String atomId4) {
        if (atomId1 == null || atomId2 == null || atomId3 == null
                || atomId4 == null) {
            return null;
        }
        if (atomId1.compareTo(atomId4) < 0) {
            String temp = atomId4;
            atomId4 = atomId1;
            atomId1 = temp;
            temp = atomId3;
            atomId3 = atomId2;
            atomId2 = temp;
        }
        return atomId1 + CMLBond.HASH_SYMB + atomId2 + CMLBond.HASH_SYMB + atomId3
                + CMLBond.HASH_SYMB + atomId4;
    }

    /** translates elements to list.
     * @param torsionElements
     * @return the list of lengths
     */
    public static List<CMLTorsion> getList(CMLElements<CMLTorsion> torsionElements) {
        List<CMLTorsion> torsionList = new ArrayList<CMLTorsion>();
        for (CMLTorsion torsion : torsionElements) {
            torsionList.add(torsion);
        }
        return torsionList;
    }

    /**
     * torsions indexed by atom hash.
     *
     * @param torsions
     * @return map
     */
    public static Map<String, CMLTorsion> getIndexedTorsions(List<CMLTorsion> torsions) {
        Map<String, CMLTorsion> torsionTable = new HashMap<String, CMLTorsion>();
        for (CMLTorsion torsion : torsions) {
            String[] id = torsion.getAtomRefs4();
            String key = atomHash(id[0], id[1], id[2], id[3]);
            torsionTable.put(key, torsion);
        }
        return torsionTable;
    }

    /** set atomRefs4 attribute.
     *
     * @param rGroup0
     * @param atom0
     * @param atom1
     * @param rGroup1
     */
    public void setAtomRefs4(
        CMLAtom rGroup0, CMLAtom atom0, CMLAtom atom1, CMLAtom rGroup1) {
        this.setAtomRefs4(
            new String[]{
                    rGroup0.getId(),atom0.getId(),
                    atom1.getId(),rGroup1.getId(),
            });
    }

    /** writes torsions to an XHTML table.
     * columns are atom1.label atom2.label atom3.label atom4.label torsion in deg
     * @param w writer to output
     * @param torsionList
     * @param molecule
     * @throws IOException
     */
    public static void outputHTML(
        Writer w, List<CMLTorsion> torsionList,
        CMLMolecule molecule) throws IOException {
        if (torsionList.size() > 0) {
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
            w.write("atom4 (id)");
            w.write("</th>");
            w.write("<th>");
            w.write("torsion");
            w.write("</th>");
            w.write("</tr>\n");
            for (CMLTorsion torsion : torsionList) {
                List<CMLAtom> atoms = torsion.getAtoms(molecule);
                w.write("<tr>");
                for (int i = 0; i < 4; i++) {
                    w.write("<td>");
                    CMLAtom atom = atoms.get(i);
                    Nodes labelNodes = atom.query(
                        CMLScalar.NS+"[@dictRef='iucr:_atom_site_label']", CMLConstants.CML_XPATH);
                    String label = ((CMLScalar) labelNodes.get(0)).getXMLContent()+" ("+atom.getId()+S_RBRAK;
                    w.write( (label == null) ? atom.getId() : label);
                    w.write("</td>");
                }
                String s = "UNSET";
                try {
                    s = CMLConstants.S_EMPTY+torsion.getXMLContent();
                } catch (RuntimeException e) {
                    //
                }
                w.write("<td>"+s.substring(0, Math.min(6, s.length()))+"</td>");
                w.write("</tr>\n");
            }
            w.write("</table>\n");
        }
    }

    /** string representation.
     *
     * @return string
     */
    public String getString() {
        String s = CMLConstants.S_EMPTY;
        String[] aa = this.getAtomRefs4();
        if (aa != null) {
            s += Util.concatenate(aa, CMLConstants.S_MINUS);
        }
        // torsion might be unset
        String ss = "UNSET";
        try {
            double dd = this.getXMLContent();
            ss += dd;
        } catch (RuntimeException e) {
            //
        }
        s += ": "+ss;
        return s;
    }
}
