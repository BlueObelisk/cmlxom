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
import org.xmlcml.cml.element.CMLCml;
import org.xmlcml.cml.element.CMLPeak;
import org.xmlcml.cml.element.CMLPeakList;
import org.xmlcml.cml.element.CMLSpectrum;
import org.xmlcml.euclid.Util;

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
		InputStream in = Util.getInputStreamFromResource(SIMPLE_RESOURCE +CMLConstants.U_S
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
		InputStream in = Util.getInputStreamFromResource(SIMPLE_RESOURCE +CMLConstants.U_S
				+ testfile2);
		cml = (CMLCml) new CMLBuilder().build(in).getRootElement();
		in.close();
		List<CMLPeak> peaks = CMLSpectrum.getDescendantPeaks(cml);
		Assert.assertNotNull("peaks ", peaks);
		Assert.assertEquals("peak count ", 4, peaks.size());
	}


}
