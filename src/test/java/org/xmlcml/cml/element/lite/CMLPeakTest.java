package org.xmlcml.cml.element.lite;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import nu.xom.Elements;
import nu.xom.ParsingException;
import nu.xom.ValidityException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.xmlcml.cml.base.CMLBuilder;
import org.xmlcml.cml.base.CMLElements;
import org.xmlcml.cml.element.main.CMLSpectrum;
import org.xmlcml.euclid.Util;
import static org.xmlcml.cml.base.CMLConstants.*;
import static org.xmlcml.cml.base.BaseTest.*;
import static org.xmlcml.euclid.EuclidConstants.*;
import static org.xmlcml.cml.element.main.AbstractTest.*;

/**
 * test CMLPeak
 * 
 * @author pmr
 * 
 */
public class CMLPeakTest extends PeakSpectrumBase {

	/**
	 * get peaks.
	 * 
	 * @throws IOException
	 * @throws ParsingException
	 * @throws ValidityException
	 */
	@Test
	public void testGetPeaks() throws IOException, ValidityException,
			ParsingException {
		CMLCml cml = null;
		InputStream in = Util.getInputStreamFromResource(SIMPLE_RESOURCE + U_S
				+ testfile2);
		cml = (CMLCml) new CMLBuilder().build(in).getRootElement();
		in.close();
		Assert.assertNotNull("cml should not be null " + testfile2, cml);
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
		// check owner spectrum elements
		CMLSpectrum spectrum1 = CMLSpectrum.getSpectrum(peaks.get(0));
		Assert.assertNotNull("spectrum", spectrum1);
		spectrum1 = CMLSpectrum.getSpectrum(peakList);
		Assert.assertNotNull("spectrum", spectrum1);

	}

	/**
	 * tests
	 * 
	 * getDescendantPeaks(CMLElement element)
	 * 
	 * @throws IOException
	 * @throws ParsingException
	 * @throws ValidityException
	 */
	@Test
	public void testGetDescendantPeaks() throws IOException, ValidityException,
			ParsingException {
		CMLCml cml = null;
		InputStream in = Util.getInputStreamFromResource(SIMPLE_RESOURCE + U_S
				+ testfile2);
		cml = (CMLCml) new CMLBuilder().build(in).getRootElement();
		in.close();
		List<CMLPeak> peaks = CMLSpectrum.getDescendantPeaks(cml);
		Assert.assertNotNull("peaks ", peaks);
		Assert.assertEquals("peak count ", 4, peaks.size());
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLPeak.getDerefencedAtoms()'
	 */
	@Ignore
	@Test
	public void testGetDerefencedAtoms() {
		// TODO Auto-generated method stub

	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLPeak.getCouplingsFrom(CMLMolecule)'
	 */
	@Ignore
	@Test
	public void testGetCouplingsFromCMLMolecule() {
		// TODO Auto-generated method stub

	}

}
