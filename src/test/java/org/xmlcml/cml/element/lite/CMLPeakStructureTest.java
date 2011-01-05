package org.xmlcml.cml.element.lite;

import static org.xmlcml.cml.element.main.AbstractTestBase.SIMPLE_RESOURCE;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import nu.xom.Elements;
import nu.xom.ParsingException;
import nu.xom.ValidityException;

import org.junit.Assert;
import org.junit.Test;
import org.xmlcml.cml.base.CMLBuilder;
import org.xmlcml.cml.base.CMLConstants;
import org.xmlcml.cml.base.CMLElements;
import org.xmlcml.cml.element.CMLAtom;
import org.xmlcml.cml.element.CMLCml;
import org.xmlcml.cml.element.CMLMolecule;
import org.xmlcml.cml.element.CMLPeak;
import org.xmlcml.cml.element.CMLPeakList;
import org.xmlcml.cml.element.CMLPeakStructure;
import org.xmlcml.cml.element.CMLSpectrum;
import org.xmlcml.euclid.Util;

/**
 * test CMLPeakStructure
 * 
 * @author pmr
 * 
 */
public class CMLPeakStructureTest extends PeakSpectrumBase {

	/**
	 * tests access to peaks and peakStructure.
	 * 
	 * <spectrum id="spectrum2" title="test peaks"> <peakList> <peak id="p1"
	 * title="Ha" atomRefs="a1" peakShape="sharp" xUnits="unit:ppm"
	 * xValue="6.0"> <peakStructure type="coupling" peakMultiplicity="doublet11"
	 * value="12" units="unit:hertz" atomRefs="a2"/> </peak> <peak id="p2"
	 * title="Hb" atomRefs="a2" peakShape="sharp" xUnits="unit:ppm"
	 * xValue="7.0"> <peakStructure type="coupling" peakMultiplicity="doublet11"
	 * value="12" units="unit:hertz" atomRefs="a1"/> <peakStructure
	 * type="coupling" peakMultiplicity="triplet121" value="15"
	 * units="unit:hertz" atomRefs="a3 a4"/> </peak> <peak id="p3" title="Hc"
	 * atomRefs="a3 a4" peakShape="sharp" xUnits="unit:ppm" xValue="8.0">
	 * <peakStructure type="coupling" peakMultiplicity="doublet11" value="15"
	 * units="unit:hertz" atomRefs="a2"/> </peak> </peakList> </spectrum>
	 * 
	 * @throws IOException
	 * @throws ParsingException
	 * @throws ValidityException
	 * 
	 */
	@Test
	public void testGetPeaks1() throws IOException, ValidityException,
			ParsingException {
		CMLCml cml = null;
		InputStream in = Util.getInputStreamFromResource(SIMPLE_RESOURCE +CMLConstants.U_S
				+ peakStructureFile1);
		cml = (CMLCml) new CMLBuilder().build(in).getRootElement();
		in.close();
		// cml = (CMLCml) new CMLBuilder().build(new
		// File(peakStructureFile1Schema)).getRootElement();
		Assert.assertNotNull("cml not null: ", cml);
		Elements elements1 = cml.getChildElements();
		Assert.assertEquals("cmlChildren", 2, elements1.size());
		Elements elements = cml.getChildCMLElements(CMLSpectrum.TAG);
		Assert.assertEquals("cmlChild", 1, elements.size());
		CMLSpectrum spectrum = (CMLSpectrum) elements.get(0);
		Assert.assertNotNull("spectrum", spectrum);
		CMLPeakList peakList = spectrum.getPeakListElements().get(0);
		Assert.assertNotNull("peakList", peakList);
		CMLElements<CMLPeak> peaks = peakList.getPeakElements();
		Assert.assertNotNull("peaks", peaks);
		Assert.assertEquals("peak count", 3, peaks.size());
		// check owner spectrum elements
		CMLSpectrum spectrum1 = CMLSpectrum.getSpectrum(peaks.get(0));
		Assert.assertNotNull("spectrum", spectrum1);
		spectrum1 = CMLSpectrum.getSpectrum(peakList);
		Assert.assertNotNull("spectrum", spectrum1);
		CMLMolecule molecule = spectrum.getSiblingMolecule();
		Assert.assertNotNull("molecule", molecule);
		Assert.assertEquals("molecule", "m1", molecule.getId());
	}

	/**
	 * test
	 * 
	 * @throws IOException
	 * @throws ParsingException
	 * @throws ValidityException
	 */
	@Test
	public void testGetPeaks2() throws IOException, ValidityException,
			ParsingException {
		CMLCml cml = null;
		InputStream in = Util.getInputStreamFromResource(SIMPLE_RESOURCE +CMLConstants.U_S
				+ peakStructureFile2);
		cml = (CMLCml) new CMLBuilder().build(in).getRootElement();
		Assert.assertNotNull("cml not null: ", cml);
		Elements elements1 = cml.getChildElements();
		Assert.assertEquals("cmlChildren", 2, elements1.size());
		Elements elements = cml.getChildCMLElements(CMLSpectrum.TAG);
		Assert.assertEquals("cmlChild", 1, elements.size());
		CMLSpectrum spectrum = (CMLSpectrum) elements.get(0);
		Assert.assertNotNull("spectrum", spectrum);
		CMLPeakList peakList = spectrum.getPeakListElements().get(0);
		Assert.assertNotNull("peakList", peakList);
		CMLElements<CMLPeak> peaks = peakList.getPeakElements();
		Assert.assertNotNull("peaks", peaks);
		Assert.assertEquals("peak count", 1, peaks.size());
		CMLElements<CMLPeakStructure> peakStructureAs = peaks.get(0)
				.getPeakStructureElements();
		Assert.assertNotNull("peaks", peakStructureAs);
		Assert.assertEquals("peakStructure count", 2, peakStructureAs.size());
		CMLElements<CMLPeakStructure> peakStructureAB1s = peakStructureAs
				.get(0).getPeakStructureElements();
		Assert.assertNotNull("grandchild peakStructures not null",
				peakStructureAB1s);
		Assert.assertEquals("grandchild peakStructures count", 2,
				peakStructureAB1s.size());
		Assert.assertEquals("grandchild peakStructure 1 id", "ps11",
				peakStructureAB1s.get(0).getId());
		CMLElements<CMLPeakStructure> peakStructureAB2s = peakStructureAs
				.get(1).getPeakStructureElements();
		Assert.assertNotNull("grandchild peakStructures not null",
				peakStructureAB2s);
		Assert.assertEquals("grandchild peakStructures count", 2,
				peakStructureAB2s.size());
		Assert.assertEquals("grandchild peakStructure 1 id", "ps22",
				peakStructureAB2s.get(1).getId());

		// check owner spectrum elements
		CMLSpectrum spectrum1 = CMLSpectrum.getSpectrum(peaks.get(0));
		Assert.assertNotNull("spectrum", spectrum1);
		spectrum1 = CMLSpectrum.getSpectrum(peakStructureAB1s.get(0));
		Assert.assertNotNull("spectrum", spectrum1);
		spectrum1 = CMLSpectrum.getSpectrum(peakList);
		Assert.assertNotNull("spectrum", spectrum1);
		CMLMolecule molecule = spectrum.getSiblingMolecule();
		Assert.assertNotNull("molecule", molecule);
		Assert.assertEquals("molecule", "m1", molecule.getId());
	}

	/**
	 * test
	 * 
	 * @throws IOException
	 * @throws ParsingException
	 * @throws ValidityException
	 */
	@Test
	public void testAtomRefs() throws IOException, ValidityException,
			ParsingException {
		CMLCml cml = null;
		CMLSpectrum spectrum = null;
		CMLMolecule molecule = null;
		InputStream in = Util.getInputStreamFromResource(SIMPLE_RESOURCE +CMLConstants.U_S
				+ peakStructureFile1);
		cml = (CMLCml) new CMLBuilder().build(in).getRootElement();
		spectrum = (CMLSpectrum) cml.getChildCMLElements(CMLSpectrum.TAG)
				.get(0);
		Assert.assertNotNull("spectrum", spectrum);
		molecule = spectrum.getSiblingMolecule();
		Assert.assertNotNull("molecule", molecule);
		CMLPeakList peakList = spectrum.getPeakListElements().get(0);
		Assert.assertNotNull("peakList", peakList);
		CMLElements<CMLPeak> peaks = peakList.getPeakElements();
		/*
		 * -- <peak id="p1" title="Ha" atomRefs="a1" peakShape="sharp"
		 * xUnits="unit:ppm" xValue="6.0"> <peakStructure type="coupling"
		 * peakMultiplicity="doublet11" value="12" units="unit:hertz"
		 * atomRefs="a2"/> </peak> --
		 */
		CMLPeak peak1 = peaks.get(0);
		List<CMLAtom> atoms1 = molecule.getAtomListByIds(peak1.getAtomRefs());
		Assert.assertEquals("atoms in peak 1", 1, atoms1.size());
		CMLAtom atom1 = atoms1.get(0);
		Assert.assertEquals("atom peak1", "Ha", atom1.getLabelElements().get(0)
				.getCMLValue());
		CMLElements<CMLPeakStructure> peakStructures = peak1
				.getPeakStructureElements();
		Assert.assertEquals("peak structures in peak 1", 1, peakStructures
				.size());
		CMLPeakStructure peakStructure11 = peakStructures.get(0);
		Assert.assertEquals("peak1 coupling1 type", "coupling", peakStructure11
				.getType());
		Assert.assertEquals("peak1 coupling1 multiplicity", "nmr:doublet11",
				peakStructure11.getPeakMultiplicity());
		Assert.assertEquals("peak1 coupling1 value", "12", peakStructure11
				.getCMLValue());
		List<CMLAtom> atoms11 = molecule.getAtomListByIds(peakStructure11
				.getAtomRefs());
		Assert.assertEquals("atoms in peak structure 11", 1, atoms11.size());
		CMLAtom atomPeak1Coupling1 = atoms11.get(0);
		Assert.assertEquals("atom peak1 coupling1", "Hb", atomPeak1Coupling1
				.getLabelElements().get(0).getCMLValue());
		/*
		 * <peak id="p2" title="Hb" atomRefs="a2" peakShape="sharp"
		 * xUnits="unit:ppm" xValue="7.0"> <peakStructure type="coupling"
		 * peakMultiplicity="doublet11" value="12" units="unit:hertz"
		 * atomRefs="a1"/> <peakStructure type="coupling"
		 * peakMultiplicity="triplet121" value="15" units="unit:hertz"
		 * atomRefs="a3 a4"/> </peak>
		 */
		CMLPeak peak2 = peaks.get(1);
		List<CMLAtom> atoms2 = molecule.getAtomListByIds(peak2.getAtomRefs());
		Assert.assertEquals("atoms in peak 2", 1, atoms2.size());
		CMLAtom atom2 = atoms2.get(0);
		Assert.assertEquals("atom peak2", "Hb", atom2.getLabelElements().get(0)
				.getCMLValue());
		CMLElements<CMLPeakStructure> peakStructures2 = peak2
				.getPeakStructureElements();
		Assert.assertEquals("peak structures in peak 2", 2, peakStructures2
				.size());
		CMLPeakStructure peakStructure21 = peakStructures2.get(0);
		Assert.assertEquals("peak2 coupling1 type", "coupling", peakStructure21
				.getType());
		Assert.assertEquals("peak2 coupling1 multiplicity", "nmr:doublet11",
				peakStructure21.getPeakMultiplicity());
		Assert.assertEquals("peak2 coupling1 value", "12", peakStructure21
				.getCMLValue());
		List<CMLAtom> atoms21 = molecule.getAtomListByIds(peakStructure21
				.getAtomRefs());
		Assert.assertEquals("atoms in peak structure 21", 1, atoms21.size());
		CMLAtom atomPeak2Coupling1 = atoms21.get(0);
		Assert.assertEquals("atom peak2 coupling1", "Ha", atomPeak2Coupling1
				.getLabelElements().get(0).getCMLValue());
		CMLPeakStructure peakStructure22 = peakStructures2.get(1);
		Assert.assertEquals("peak2 coupling2 type", "coupling", peakStructure22
				.getType());
		Assert.assertEquals("peak2 coupling2 multiplicity", "nmr:triplet121",
				peakStructure22.getPeakMultiplicity());
		Assert.assertEquals("peak2 coupling2 value", "15", peakStructure22
				.getCMLValue());
		List<CMLAtom> atoms22 = molecule.getAtomListByIds(peakStructure22
				.getAtomRefs());
		Assert.assertEquals("atoms in peak structure 22", 2, atoms22.size());
		CMLAtom atom1Peak2Coupling2 = atoms22.get(0);
		Assert.assertEquals("atom1 peak2 coupling2", "Hc1", atom1Peak2Coupling2
				.getLabelElements().get(0).getCMLValue());
		CMLAtom atom2Peak2Coupling2 = atoms22.get(1);
		Assert.assertEquals("atom2 peak2 coupling2", "Hc2", atom2Peak2Coupling2
				.getLabelElements().get(0).getCMLValue());
		/*
		 * <peak id="p3" title="Hc" atomRefs="a3 a4" peakShape="sharp"
		 * xUnits="unit:ppm" xValue="8.0"> <peakStructure type="coupling"
		 * peakMultiplicity="doublet11" value="15" units="unit:hertz"
		 * atomRefs="a2"/> </peak>
		 */
		CMLPeak peak3 = peaks.get(2);
		List<CMLAtom> atoms3 = molecule.getAtomListByIds(peak3.getAtomRefs());
		Assert.assertEquals("atoms in peak 3", 2, atoms3.size());
		CMLAtom atom31 = atoms3.get(0);
		Assert.assertEquals("atom1 peak3", "Hc1", atom31.getLabelElements()
				.get(0).getCMLValue());
		CMLAtom atom32 = atoms3.get(1);
		Assert.assertEquals("atom2 peak3", "Hc2", atom32.getLabelElements()
				.get(0).getCMLValue());
		CMLElements<CMLPeakStructure> peakStructures3 = peak3
				.getPeakStructureElements();
		Assert.assertEquals("peak structures in peak 3", 1, peakStructures3
				.size());
		CMLPeakStructure peakStructure31 = peakStructures3.get(0);
		Assert.assertEquals("peak3 coupling1 type", "coupling", peakStructure31
				.getType());
		Assert.assertEquals("peak3 coupling1 multiplicity", "nmr:doublet11",
				peakStructure31.getPeakMultiplicity());
		Assert.assertEquals("peak3 coupling1 value", "15", peakStructure31
				.getCMLValue());
		List<CMLAtom> atoms31 = molecule.getAtomListByIds(peakStructure31
				.getAtomRefs());
		Assert.assertEquals("atoms in peak structure 31", 1, atoms31.size());
		CMLAtom atomPeak3Coupling1 = atoms31.get(0);
		Assert.assertEquals("atom peak3 coupling1", "Hb", atomPeak3Coupling1
				.getLabelElements().get(0).getCMLValue());
	}

	/**
	 * tests public boolean hasValidNestedPeakStructure()
	 * 
	 * @throws IOException
	 * @throws ParsingException
	 * @throws ValidityException
	 */
	@Test
	public void testHasValidNestedPeakStructure() throws IOException,
			ValidityException, ParsingException {
		CMLCml cml = null;
		InputStream in = Util.getInputStreamFromResource(SIMPLE_RESOURCE +CMLConstants.U_S
				+ peakStructureFile2);
		cml = (CMLCml) new CMLBuilder().build(in).getRootElement();
		in.close();
		CMLPeak peak1 = CMLSpectrum.getDescendantPeaks(cml).get(0);
		CMLPeakStructure ps = peak1.getPeakStructureElements().get(0);
		Assert.assertTrue("has valid nesting ", ps
				.hasValidNestedPeakStructure());
	}


}
