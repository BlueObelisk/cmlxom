package org.xmlcml.cml.element.main;

import static org.xmlcml.cml.base.CMLConstants.CML_XMLNS;
import static org.xmlcml.cml.base.CMLConstants.CML_XPATH;
import static org.xmlcml.cml.element.main.AbstractTestBase.COMPLEX_RESOURCE;
import static org.xmlcml.cml.element.main.AbstractTestBase.SIMPLE_RESOURCE;
import static org.xmlcml.euclid.EuclidConstants.EPS;
import static org.xmlcml.euclid.EuclidConstants.U_S;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.List;

import nu.xom.Document;
import nu.xom.Elements;
import nu.xom.Nodes;
import nu.xom.ParsingException;
import nu.xom.ValidityException;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.xmlcml.cml.base.CMLBuilder;
import org.xmlcml.cml.base.CMLElements;
import org.xmlcml.cml.element.lite.CMLArray;
import org.xmlcml.cml.element.lite.CMLCml;
import org.xmlcml.cml.element.lite.CMLFormula;
import org.xmlcml.cml.element.lite.CMLMolecule;
import org.xmlcml.cml.element.lite.CMLPeak;
import org.xmlcml.cml.element.lite.CMLPeakGroup;
import org.xmlcml.cml.element.lite.CMLPeakList;
import org.xmlcml.cml.element.lite.PeakSpectrumBase;
import org.xmlcml.euclid.Util;

/**
 * test Spectrum.
 * 
 * @author pmr
 * 
 */
public class CMLSpectrumTest extends PeakSpectrumBase {

	/**
	 * Test method for reading a CMLSpectrum from file. uses first example
	 * 
	 * @throws Exception
	 */
	@Test
	public void testReadCMLSpectrum1() throws Exception {
		CMLSpectrum spectrum = readSpectrum(1);
		Assert.assertNotNull("spectrum1: ", spectrum);
		/*
		 * -- <sample> <molecule> <formula concise="C 4 H 10 O 1"/> <name
		 * convention="cas:regno">78-92-2</name> </molecule> </sample> -
		 */
		CMLElements<CMLSample> samples = spectrum.getSampleElements();
		Assert.assertEquals("sample children", 1, samples.size());
		CMLElements<CMLMolecule> molecules = samples.get(0)
				.getMoleculeElements();
		Assert.assertEquals("molecule children", 1, molecules.size());
		CMLElements<CMLFormula> formulas = molecules.get(0)
				.getFormulaElements();
		Assert.assertEquals("formula children", 1, formulas.size());
		Assert.assertEquals("concise formula", "C 4 H 10 O 1", formulas.get(0)
				.getConcise());
		/*
		 * -- <spectrumData> <xaxis> <array units="cmlsp:cm-1"
		 * dataType="xsd:double"> 450 454 458 462 466 470 474 478 482 486 490
		 * 494 498 502 506 510 ... 1282 1286 1290 1294 1298 1302 1306 1310 1314
		 * 1318 1322 1326 1330 1334 1338 1342 </array> </xaxis> <yaxis
		 * multiplierToData="0.000109021"> <array units="cmlsp:absorbance"
		 * dataType="xsd:double"> 331 179 99 148 146 150 187 165 249 206 189 224
		 * 253 230 267 236 167 137 96 109 ... 1758 1867 1968 2018 2005 1960 1969
		 * 2010 2063 2100 2175 2254 2344 2467 2557 3 1 15 1 1 17 10 9 1 7 35 2
		 * 19</array> </yaxis> </spectrumData> --
		 */
		CMLElements<CMLSpectrumData> spectrumDatas = spectrum
				.getSpectrumDataElements();
		Assert.assertEquals("spectrumData children", 1, spectrumDatas.size());
		CMLElements<CMLXaxis> xaxiss = spectrumDatas.get(0).getXaxisElements();
		Assert.assertEquals("xaxiss children", 1, xaxiss.size());
		CMLElements<CMLArray> xarray = xaxiss.get(0).getArrayElements();
		Assert.assertEquals("xarray children", 1, xarray.size());
		double[] xarrayValues = null;
		xarrayValues = xarray.get(0).getDoubles();
		Assert.assertNotNull("xvalues...", xarrayValues);
		Assert.assertNotNull("xvalues", xarrayValues);
		Assert.assertEquals("xvalues", 224, xarrayValues.length);
		Assert.assertEquals("xvalue 0", 450, xarrayValues[0], EPS);
		Assert.assertEquals("xvalue 223", 1342, xarrayValues[223], EPS);

		CMLElements<CMLYaxis> yaxiss = spectrumDatas.get(0).getYaxisElements();
		Assert.assertEquals("yaxiss children", 1, yaxiss.size());
		CMLElements<CMLArray> yarray = yaxiss.get(0).getArrayElements();
		Assert.assertEquals("yarray children", 1, yarray.size());
		Assert.assertEquals("yunits", "cmlsp:absorbance", yarray.get(0)
				.getUnits());
		double[] yarrayValues = yarray.get(0).getDoubles();
		Assert.assertNotNull("yvalues...", xarrayValues);
		Assert.assertNotNull("yvalues", yarrayValues);
		Assert.assertEquals("yvalues", 224, yarrayValues.length);
		Assert.assertEquals("yvalue 0", 331, yarrayValues[0], EPS);
		Assert.assertEquals("yvalue 223", 0, yarrayValues[223], EPS);
		/*
		 * -- <peakList> <peakGroup id="pg1" xMax="3040" xMin="2800"> <peak
		 * id="ch1" title="CH-stretch-1" peakMultiplicity="singlet"
		 * peakShape="sharp" xUnits="cmlsp:cm-1" xValue="2974"
		 * yUnits="cmlsp:absorbance" yValue="1.0921"/> <peak id="ch2"
		 * title="CH-stretch-2" peakShape="shoulder" xUnits="cmlsp:cm-1"
		 * xValue="2938" yUnits="cmlsp:absorbance" yValue="0.653"/> <peak
		 * id="ch3" title="CH-stretch-3" xUnits="cmlsp:cm-1" xValue="2890"
		 * yUnits="cmlsp:absorbance" yValue="0.470"/> </peakGroup> <peak
		 * id="oh1" title="CH-stretch???" peakShape="broad" xUnits="cmlsp:cm-1"
		 * xValue="3657" yUnits="cmlsp:absorbance" yValue="0.1092"/> </peakList>
		 * --
		 */
		CMLElements<CMLPeakList> peakLists = spectrum.getPeakListElements();
		Assert.assertEquals("peakList children", 1, peakLists.size());
		CMLElements<CMLPeakGroup> peakGroups = peakLists.get(0)
				.getPeakGroupElements();
		Assert.assertEquals("peakGroup children", 1, peakGroups.size());
		CMLElements<CMLPeak> peaks = peakGroups.get(0).getPeakElements();
		Assert.assertEquals("peakGroup children", 3, peaks.size());
		CMLPeak peak0 = peaks.get(0);
		Assert.assertEquals("peak0 title", "CH-stretch-1", peak0.getTitle());
		Assert.assertEquals("peak0 multiplicity", "singlet", peak0
				.getPeakMultiplicity());
		Assert.assertEquals("peak0 shape", "sharp", peak0.getPeakShape());
		Assert.assertEquals("peak0 xunits", "cmlsp:cm-1", peak0.getXUnits());
		Assert.assertEquals("peak0 xvalue", 2974.0, peak0.getXValue(), EPS);
		Assert.assertEquals("peak0 xunits", "cmlsp:absorbance", peak0
				.getYUnits());
		Assert.assertEquals("peak0 xvalue", 1.0921, peak0.getYValue(), EPS);
		CMLPeak peak1 = peaks.get(1);
		Assert.assertEquals("peak1 title", "CH-stretch-2", peak1.getTitle());
		Assert.assertNull("peak1 multiplicity", peak1.getPeakMultiplicity());
		Assert.assertEquals("peak1 shape", "shoulder", peak1.getPeakShape());
		Assert.assertEquals("peak1 xunits", "cmlsp:cm-1", peak1.getXUnits());
		Assert.assertEquals("peak1 xvalue", 2938.0, peak1.getXValue(), EPS);
		Assert.assertEquals("peak1 xunits", "cmlsp:absorbance", peak1
				.getYUnits());
		Assert.assertEquals("peak1 xvalue", 0.653, peak1.getYValue(), EPS);
		CMLPeak peak2 = peaks.get(2);
		Assert.assertEquals("peak2 title", "CH-stretch-3", peak2.getTitle());
		Assert.assertNull("peak2 multiplicity", peak2.getPeakMultiplicity());
		Assert.assertNull("peak2 shape", peak2.getPeakShape());
		Assert.assertEquals("peak2 xunits", "cmlsp:cm-1", peak2.getXUnits());
		Assert.assertEquals("peak2 xvalue", 2890.0, peak2.getXValue(), EPS);
		Assert.assertEquals("peak2 xunits", "cmlsp:absorbance", peak2
				.getYUnits());
		Assert.assertEquals("peak2 xvalue", 0.470, peak2.getYValue(), EPS);

		CMLElements<CMLPeak> peakohs = peakLists.get(0).getPeakElements();
		Assert.assertEquals("peakList peak children", 1, peakohs.size());
		CMLPeak peakoh = peakohs.get(0);
		Assert.assertEquals("peakoh title", "CH-stretch???", peakoh.getTitle());
		Assert.assertNull("peakoh multiplicity", peakoh.getPeakMultiplicity());
		Assert.assertEquals("peakoh shape", "broad", peakoh.getPeakShape());
		Assert.assertEquals("peakoh xunits", "cmlsp:cm-1", peakoh.getXUnits());
		Assert.assertEquals("peakoh xvalue", 3657.0, peakoh.getXValue(), EPS);
		Assert.assertEquals("peakoh xunits", "cmlsp:absorbance", peakoh
				.getYUnits());
		Assert.assertEquals("peakoh xvalue", 0.1092, peakoh.getYValue(), EPS);

	}

	/**
	 * Test method for reading a CMLSpectrum from file.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testReadCMLSpectrum3() throws Exception {
		CMLSpectrum spectrum = readSpectrum(3);
		Assert.assertNotNull("spectrum3: ", spectrum);

		/*
		 * -- <spectrum id="sp03" type="massSpectrum"> <metadataList> <metadata
		 * name="dc:origin">D.HENNEBERG, MAX-PLANCK INSTITUTE, MULHEIM, WEST
		 * GERMANY</metadata> <metadata name="dc:owner">NIST Mass Spectrometry
		 * Data Center</metadata> </metadataList> <sample> <molecule> <name
		 * convention="cas:regno">109-99-9</name> <formula
		 * concise="C 4 H 8 O 1"/> </molecule> </sample> <spectrumData> <xaxis>
		 * <array dataType="xsd:double" units="unit:mz">24 25 26 27 29 30 31 33
		 * 34 35 37 38 39 40 41 42 43 44 45 46 49 50 51 53 54 55 68 69 70 71 72
		 * 73 </array> </xaxis> <yaxis multiplierToData="1.0"> <array
		 * dataType="xsd:double" units="cmls:relativeAbundance">4 30 171 1545
		 * 792 21 258 5 26 10 105 165 1182 906 4060 9999 1586 325 100 3 7 11 19
		 * 27 10 6 7 20 107 2557 2868 147 </array> </yaxis> </spectrumData>
		 * </spectrum> --
		 */
		List<CMLMetadata> metadatas = CMLMetadataList
				.getMetadataDescendants(spectrum);
		Assert.assertEquals("metadataLists", 2, metadatas.size());
		CMLMetadata metadata1 = metadatas.get(0);
		Assert.assertEquals("origin",
				"D.HENNEBERG, MAX-PLANCK INSTITUTE, MULHEIM, WEST GERMANY",
				metadata1.getXMLContent());
		CMLMetadata metadata2 = metadatas.get(1);
		Assert.assertEquals("owner", "NIST Mass Spectrometry Data Center",
				metadata2.getXMLContent());

		CMLElements<CMLSpectrumData> spectrumDatas = spectrum
				.getSpectrumDataElements();
		Assert.assertEquals("spectrumData children", 1, spectrumDatas.size());
		CMLElements<CMLXaxis> xaxiss = spectrumDatas.get(0).getXaxisElements();
		Assert.assertEquals("xaxiss children", 1, xaxiss.size());
		CMLElements<CMLArray> xarray = xaxiss.get(0).getArrayElements();
		Assert.assertEquals("xarray children", 1, xarray.size());
		Assert.assertEquals("xunits", "unit:mz", xarray.get(0).getUnits());
		double[] xarrayValues = xarray.get(0).getDoubles();
		Assert.assertNotNull("xvalues...", xarrayValues);
		Assert.assertNotNull("xvalues", xarrayValues);
		Assert.assertEquals("xvalues", 32, xarrayValues.length);
		Assert.assertEquals("xvalue 0", 24, xarrayValues[0], EPS);
		Assert.assertEquals("xvalue last", 73, xarrayValues[31], EPS);

		CMLElements<CMLYaxis> yaxiss = spectrumDatas.get(0).getYaxisElements();
		Assert.assertEquals("yaxiss children", 1, yaxiss.size());
		CMLElements<CMLArray> yarray = yaxiss.get(0).getArrayElements();
		Assert.assertEquals("yarray children", 1, yarray.size());
		Assert.assertEquals("yunits", "cmls:relativeAbundance", yarray.get(0)
				.getUnits());
		double[] yarrayValues = yarray.get(0).getDoubles();
		Assert.assertNotNull("yvalues...", xarrayValues);
		Assert.assertNotNull("yvalues", yarrayValues);
		Assert.assertEquals("yvalues", 32, yarrayValues.length);
		Assert.assertEquals("yvalue 0", 4, yarrayValues[0], EPS);
		Assert.assertEquals("yvalue last", 147, yarrayValues[31], EPS);
		CMLElements<CMLPeakList> peakLists = spectrum.getPeakListElements();
		Assert.assertEquals("peakList children", 0, peakLists.size());

	}

	/**
	 * Test method for reading a CMLSpectrum from file. uses Tobias Helmus
	 * example from NMRShiftDB
	 * 
	 * @throws IOException
	 * @throws ParsingException
	 * @throws ValidityException
	 */
	@Test
	public void testReadCMLSpectrum5() throws IOException, ValidityException,
			ParsingException {
		CMLCml cml = null;
		InputStream in = Util.getInputStreamFromResource(SIMPLE_RESOURCE + U_S
				+ testfile5);
		cml = (CMLCml) new CMLBuilder().build(in).getRootElement();
		in.close();
		Assert.assertNotNull("read cml file ", cml);

		Elements spectrumLists = cml.getChildCMLElements(CMLSpectrumList.TAG);

		Assert.assertEquals("spectrumList children", 1, spectrumLists.size());
		CMLSpectrumList spectrumList = (CMLSpectrumList) spectrumLists.get(0);
		CMLElements<CMLSpectrum> spectrums = spectrumList.getSpectrumElements();
		Assert.assertEquals("spectrumList children", 1, spectrumLists.size());
		CMLSpectrum spectrum = spectrums.get(0);
		/*
		 * -- <spectrumData> <xaxis> <array dataType="xsd:double" delimiter="|"
		 * size="4096" units="ppm">9.983196146941719|9.980751037924213| ...
		 * -0.027080170724973485|-0.02952527974247765| </array> </xaxis> <yaxis>
		 * <array dataType="xsd:double" delimiter="|" size="4096"
		 * units="%">-0.004036283417140468|-0.004343061239674385| ...
		 * -0.003940121065448903|-0.004554220000639289| </array> </yaxis>
		 * </spectrumData> --
		 */
		CMLElements<CMLSpectrumData> spectrumDatas = spectrum
				.getSpectrumDataElements();
		Assert.assertEquals("spectrumData children", 1, spectrumDatas.size());
		CMLElements<CMLXaxis> xaxiss = spectrumDatas.get(0).getXaxisElements();
		Assert.assertEquals("xaxiss children", 1, xaxiss.size());
		CMLElements<CMLArray> xarray = xaxiss.get(0).getArrayElements();
		Assert.assertEquals("xarray children", 1, xarray.size());
		double[] xarrayValues = xarray.get(0).getDoubles();
		Assert.assertNotNull("xvalues", xarrayValues);
		Assert.assertEquals("xvalues", 4096, xarrayValues.length);
		Assert
				.assertEquals("xvalue 0", 9.983196146941719, xarrayValues[0],
						EPS);
		Assert.assertEquals("xvalue last", -0.02952527974247765,
				xarrayValues[4095], EPS);

		CMLElements<CMLYaxis> yaxiss = spectrumDatas.get(0).getYaxisElements();
		Assert.assertEquals("yaxiss children", 1, yaxiss.size());
		CMLElements<CMLArray> yarray = yaxiss.get(0).getArrayElements();
		Assert.assertEquals("yarray children", 1, yarray.size());
		Assert.assertEquals("yunits", "unit:percent", yarray.get(0).getUnits());
		double[] yarrayValues = yarray.get(0).getDoubles();
		Assert.assertNotNull("yvalues...", xarrayValues);
		Assert.assertNotNull("yvalues", yarrayValues);
		Assert.assertEquals("yvalues", 4096, yarrayValues.length);
		Assert.assertEquals("yvalue 0", -0.004036283417140468, yarrayValues[0],
				EPS);
		Assert.assertEquals("yvalue last", -0.004554220000639289,
				yarrayValues[4095], EPS);
		/*
		 * -- <peakList> <peak id="p0" xUnits="ppm" xValue="1.6111428710035778"
		 * yUnits="%" yValue="11.475286136623545"> </peak> <peak id="p1"
		 * xUnits="ppm" xValue="3.8753138212134832" yUnits="%"
		 * yValue="79.04079021244083"> </peak> <peak id="p2" xUnits="ppm"
		 * xValue="4.897369390530698" yUnits="%" yValue="41.595181148451374">
		 * </peak> <peak id="p3" xUnits="ppm" xValue="7.256899592423311"
		 * yUnits="%" yValue="3.12841519811053"> </peak> </peakList> --
		 */
		CMLElements<CMLPeakList> peakLists = spectrum.getPeakListElements();
		Assert.assertEquals("peakList children", 1, peakLists.size());
		CMLElements<CMLPeakGroup> peakGroups = peakLists.get(0)
				.getPeakGroupElements();
		Assert.assertEquals("peakGroup children", 0, peakGroups.size());
		CMLElements<CMLPeak> peaks = peakLists.get(0).getPeakElements();
		Assert.assertEquals("peakGroup children", 4, peaks.size());
		CMLPeak peak0 = peaks.get(0);
		Assert.assertNull("peak0 title", peak0.getTitle());
		Assert.assertNull("peak0 multiplicity", peak0.getPeakMultiplicity());
		Assert.assertNull("peak0 shape", peak0.getPeakShape());
		Assert.assertEquals("peak0 xunits", "unit:ppm", peak0.getXUnits());
		Assert.assertEquals("peak0 xvalue", 1.6111428710035778, peak0
				.getXValue(), EPS);
		Assert.assertEquals("peak0 xunits", "unit:percent", peak0.getYUnits());
		Assert.assertEquals("peak0 xvalue", 11.475286136623545, peak0
				.getYValue(), EPS);
		CMLPeak peak1 = peaks.get(1);
		Assert.assertNull("peak1 title", peak1.getTitle());
		Assert.assertNull("peak1 multiplicity", peak1.getPeakMultiplicity());
		Assert.assertNull("peak1 shape", peak1.getPeakShape());
		Assert.assertEquals("peak1 xunits", "unit:ppm", peak1.getXUnits());
		Assert.assertEquals("peak1 xvalue", 3.8753138212134832, peak1
				.getXValue(), EPS);
		Assert.assertEquals("peak1 xunits", "unit:percent", peak1.getYUnits());
		Assert.assertEquals("peak1 xvalue", 79.04079021244083, peak1
				.getYValue(), EPS);
		CMLPeak peak2 = peaks.get(2);
		Assert.assertNull("peak2 title", peak2.getTitle());
		Assert.assertNull("peak2 multiplicity", peak2.getPeakMultiplicity());
		Assert.assertNull("peak2 shape", peak2.getPeakShape());
		Assert.assertEquals("peak2 xunits", "unit:ppm", peak2.getXUnits());
		Assert.assertEquals("peak2 xvalue", 4.897369390530698, peak2
				.getXValue(), EPS);
		Assert.assertEquals("peak2 xunits", "unit:percent", peak2.getYUnits());
		Assert.assertEquals("peak2 xvalue", 41.595181148451374, peak2
				.getYValue(), EPS);
		CMLPeak peak3 = peaks.get(3);
		Assert.assertNull("peak3 title", peak3.getTitle());
		Assert.assertNull("peak3 multiplicity", peak3.getPeakMultiplicity());
		Assert.assertNull("peak3 shape", peak3.getPeakShape());
		Assert.assertEquals("peak3 xunits", "unit:ppm", peak3.getXUnits());
		Assert.assertEquals("peak3 xvalue", 7.256899592423311, peak3
				.getXValue(), EPS);
		Assert.assertEquals("peak3 xunits", "unit:percent", peak3.getYUnits());
		Assert.assertEquals("peak3 xvalue", 3.12841519811053,
				peak3.getYValue(), EPS);
	}

	/** test. */
	@Test
	public void testGetSiblingMolecule() {
		CMLCml cml = null;
		try {
			cml = (CMLCml) new CMLBuilder().build(
					new StringReader("<cml " + CML_XMLNS + ">"
							+ "  <molecule id='m1'>" + "  </molecule>"
							+ "  <spectrum id='s1'>" + "  </spectrum>"
							+ "</cml>")).getRootElement();
		} catch (Exception e) {
			Assert.fail("should not throw " + e);
		}
		Assert.assertNotNull("cml ", cml);
		CMLSpectrum spectrum = (CMLSpectrum) cml.getChildCMLElements(
				CMLSpectrum.TAG).get(0);
		Assert.assertNotNull("spectrum ", spectrum);
		Assert.assertEquals("spectrum id", "s1", spectrum.getId());
		CMLMolecule molecule = spectrum.getSiblingMolecule();
		Assert.assertNotNull("molecule ", molecule);
		Assert.assertEquals("molecule id", "m1", molecule.getId());
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLSpectrum.getSpectrum(CMLElement)'
	 */
	@Test
	@Ignore
	public void testGetSpectrum() {
		// TODO Auto-generated method stub

	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLSpectrum.getAuntMolecule(CMLElement)'
	 */
	@Test
	@Ignore
	public void testGetAuntMolecule() {
		// TODO Auto-generated method stub

	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLSpectrum.getDescendantPeaks(CMLElement)'
	 */
	@Test
	@Ignore
	public void testGetDescendantPeaks() {
		// TODO Auto-generated method stub

	}

	/**
	 * test compound document.
	 * 
	 * @throws IOException
	 * @throws ParsingException
	 * @throws ValidityException
	 */
	@Test
	public void testFindSpectraInDocument() throws IOException,
			ValidityException, ParsingException {
		Document document = null;
		InputStream in = Util.getInputStreamFromResource(COMPLEX_RESOURCE + U_S
				+ testCompoundFile1);
		document = new CMLBuilder().build(in);
		in.close();
		Nodes cmlNodes = document.query("//" + CMLCml.NS, CML_XPATH);
		Assert.assertEquals("spectra count", cmlNodes.size(), 1);
		CMLCml cml = (CMLCml) cmlNodes.get(0);
		Nodes spectrumNodes = cml.cmlQuery("//" + CMLSpectrum.NS);
		Assert.assertEquals("spectra count", spectrumNodes.size(), 1);
		CMLSpectrum spectrum = (CMLSpectrum) spectrumNodes.get(0);
		Nodes spectrumDataNodes = spectrum.cmlQuery(CMLSpectrumData.NS);
		Assert.assertEquals("spectrumData count", spectrumDataNodes.size(), 1);
		// CMLSpectrumData spectrumData = (CMLSpectrumData)
		// spectrumDataNodes.get(0);
		Nodes parameterListNodes = spectrum.cmlQuery(CMLParameterList.NS);
		Assert
				.assertEquals("parameterList count", parameterListNodes.size(),
						1);
		// CMLParameterList parameterList = (CMLParameterList)
		// parameterListNodes.get(0);
	}

}
