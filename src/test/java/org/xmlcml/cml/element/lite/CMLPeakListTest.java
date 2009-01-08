package org.xmlcml.cml.element.lite;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.xmlcml.cml.base.TstBase;
import org.xmlcml.cml.element.CMLMap;
import org.xmlcml.cml.element.CMLMolecule;
import org.xmlcml.cml.element.CMLPeak;
import org.xmlcml.cml.element.CMLPeakList;

/**
 * @author pm286
 */
public class CMLPeakListTest {

	CMLPeakList peakList;
	CMLPeakList peakAndGroupList;
	String peakAndGroupListS = "<peakList xmlns='http://www.xml-cml.org/schema'>"
			+ "  <peak id='p1'/>"
			+ "  <peakGroup id='p2p3'>"
			+ "    <peak id='p2'/>"
			+ "    <peak id='p3'/>"
			+ "  </peakGroup>"
			+ "  <peak id='p4'/>" + "</peakList>";
	String moleculeS = "<molecule xmlns='http://www.xml-cml.org/schema'>"
			+ "  <atomArray>" + "    <atom id='a1' elementType='C'/>"
			+ "    <atom id='a2' elementType='O'/>"
			+ "    <atom id='a3' elementType='Cl'/>"
			+ "    <atom id='a4' elementType='Cl'/>" + "  </atomArray>"
			+ "  <bondArray>" + "    <bond atomRefs2='a1 a2' order='2'/>"
			+ "    <bond atomRefs2='a1 a3' order='1'/>"
			+ "    <bond atomRefs2='a1 a4' order='1'/>" + "  </bondArray>"
			+ "</molecule>";
	CMLMolecule molecule;
	CMLPeakList toluenePeakList;
	CMLMolecule toluene;
	CMLMap tolueneMap;

	/** 
	 */
	@Before
	public void setup() {
		if (peakList == null) {
			peakList = new CMLPeakList();
			CMLPeak peak = new CMLPeak();
			peak.setXValue(3.0);
			peak.setYValue(10.0);
			peak.setId("p1");
			peakList.addPeak(peak);
			peak = new CMLPeak();
			peak.setXValue(1.0);
			peak.setYValue(7.0);
			peak.setId("p2");
			peakList.addPeak(peak);
			peak = new CMLPeak();
			peak.setXValue(2.0);
			peak.setYValue(5.0);
			peak.setId("p3");
			peakList.addPeak(peak);
			peak = new CMLPeak();
			peak.setXValue(2.0);
			peak.setYValue(3.0);
			peak.setId("p4");
			peakList.addPeak(peak);
		}
		if (peakAndGroupList == null) {
			peakAndGroupList = (CMLPeakList)TstBase.parseValidString(peakAndGroupListS);
		}
		if (molecule == null) {
			molecule = (CMLMolecule)TstBase.parseValidString(moleculeS);
		}
	}

	private void makeToluene() {

		// deliberately misordered
		String tolueneS = "  <molecule id='toluene' xmlns='http://www.xml-cml.org/schema'>"
				+ "    <atomArray>"
				+ "      <atom id='a7' elementType='C'/>"
				+ "      <atom id='a7_h1' elementType='H'/>"
				+ "      <atom id='a7_h2' elementType='H'/>"
				+ "      <atom id='a7_h3' elementType='H'/>"
				+ "      <atom id='a1' elementType='C'/>"
				+ "      <atom id='a2' elementType='C'/>"
				+ "      <atom id='a2_h1' elementType='H'/>"
				+ "      <atom id='a3' elementType='C'/>"
				+ "      <atom id='a3_h1' elementType='H'/>"
				+ "      <atom id='a4' elementType='C'/>"
				+ "      <atom id='a4_h1' elementType='H'/>"
				+ "      <atom id='a6' elementType='C'/>"
				+ "      <atom id='a6_h1' elementType='H'/>"
				+ "      <atom id='a5' elementType='C'/>"
				+ "      <atom id='a5_h1' elementType='H'/>"
				+ "    </atomArray>"
				+ "    <bondArray>"
				+ "      <bond id='a7_a7_h1' atomRefs2='a7 a7_h1'/>"
				+ "      <bond id='a7_a7_h2' atomRefs2='a7 a7_h2'/>"
				+ "      <bond id='a7_a7_h3' atomRefs2='a7 a7_h3'/>"
				+ "      <bond id='a7_a1' atomRefs2='a7 a1'/>"
				+ "      <bond id='a1_a2' atomRefs2='a1 a2'/>"
				+ "      <bond id='a2_a2_h1' atomRefs2='a2 a2_h1'/>"
				+ "      <bond id='a2_a3' atomRefs2='a2 a3'/>"
				+ "      <bond id='a3_a3_h1' atomRefs2='a3 a3_h1'/>"
				+ "      <bond id='a3_a4' atomRefs2='a3 a4'/>"
				+ "      <bond id='a4_a4_h1' atomRefs2='a4 a4_h1'/>"
				+ "      <bond id='a4_a5' atomRefs2='a4 a5'/>"
				+ "      <bond id='a5_a5_h1' atomRefs2='a5 a5_h1'/>"
				+ "      <bond id='a5_a6' atomRefs2='a5 a6'/>"
				+ "      <bond id='a6_a7_h1' atomRefs2='a6 a7_h1'/>"
				+ "      <bond id='a1_a6' atomRefs2='a1 a6'/>"
				+ "    </bondArray>" + "  </molecule>";
		toluene = (CMLMolecule)TstBase.parseValidString(tolueneS);

		// delieberately unordered - numbers meaningless
		String toluenePeakListS = "<peakList xmlns='http://www.xml-cml.org/schema'>"
				+ "  <peak id='ph2' xValue='2.1'/>"
				+ "  <peak id='ph3' xValue='3.1'/>"
				+ "  <peak id='ph4' xValue='4.1'/>"
				+ "  <peak id='ph5' xValue='3.2'/>"
				+ "  <peak id='ph6' xValue='2.2'/>"
				+ "  <peak id='ph73' xValue='7.3'/>"
				+ "  <peak id='ph72' xValue='7.2'/>"
				+ "  <peak id='ph71' xValue='7.1'/>"
				+

				"  <peak id='pc1' xValue='61.1'/>"
				+ "  <peak id='pc2' xValue='62.1'/>"
				+ "  <peak id='pc3' xValue='63.1'/>"
				+ "  <peak id='pc4' xValue='64.1'/>"
				+ "  <peak id='pc5' xValue='63.2'/>"
				+ "  <peak id='pc6' xValue='62.2'/>" + "</peakList>";

		toluenePeakList = (CMLPeakList)TstBase.parseValidString(toluenePeakListS);

		@SuppressWarnings("unused")
		String tolueneMapS = "<map xmlns='http://www.xml-cml.org/schema'>"
				+ "  <link from='a1' to='pc1'/>"
				+ "  <link from='a2' to='pc2'/>"
				+ "  <link from='a3' to='pc3'/>"
				+ "  <link from='a4' to='pc4'/>"
				+ "  <link from='a5' to='pc5'/>"
				+ "  <link from='a6' to='pc6'/>" + ""
				+ "  <link from='a1_h1' to='ph71'/>"
				+ "  <link from='a1_h2' to='ph72'/>"
				+ "  <link from='a1_h3' to='ph73'/>"
				+ "  <link from='a2_h1' to='ph2'/>"
				+ "  <link from='a3_h1' to='ph3'/>"
				+ "  <link from='a4_h1' to='ph4'/>"
				+ "  <link from='a5_h1' to='ph5'/>"
				+ "  <link from='a6_h1' to='ph6'/>" + "</map>";
		// tolueneMap = (CMLMap)TstBase.parseValidString(tolueneMapS);
	}

	/**
	 */
	@Test
	public final void testGetPeaks() {
		List<CMLPeak> peaks = peakList.getPeakChildren();
		Assert.assertEquals("indexables", "p2", ((CMLPeak) peaks.get(1))
				.getId());
	}

	/**
	 */
	@Test
	public void testRemoveAtomsByElementType() {
		makeToluene();
		// CMLAtomSet tolueneAtomSet = toluene.getAtomSet();
		// CMLAtomSet tolueneCarbonSet =
		// tolueneAtomSet.getAtomSetByElementType(AS.C.value);
		// CMLAtomSet tolueneHydrogenSet =
		// tolueneAtomSet.getAtomSetByElementType(AS.H.value);
		// toluenePeakList.addAtomRefs(tolueneMap, true);

		toluene = null;
	}

	/** 
	 */
	@Test
	public final void testGetPeakChildren() {
		List<CMLPeak> peaks = peakList.getPeakChildren();
		Assert.assertEquals("peaks", 4, peaks.size());
		peaks = peakAndGroupList.getPeakChildren();
		Assert.assertEquals("peaks", 2, peaks.size());
	}

}
