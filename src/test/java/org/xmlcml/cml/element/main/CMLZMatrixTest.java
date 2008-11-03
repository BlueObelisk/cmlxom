package org.xmlcml.cml.element.main;

import static org.xmlcml.cml.base.BaseTest.parseValidString;
import static org.xmlcml.cml.base.CMLConstants.CML_XMLNS;
import static org.xmlcml.cml.element.main.AbstractTestBase.EXPERIMENTAL_RESOURCE;
import static org.xmlcml.euclid.EuclidConstants.S_EMPTY;
import static org.xmlcml.euclid.EuclidConstants.U_S;
import static org.xmlcml.euclid.test.EuclidTestBase.neverThrow;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import junit.framework.Assert;
import nu.xom.Document;
import nu.xom.ParsingException;
import nu.xom.Serializer;
import nu.xom.ValidityException;

import org.junit.Test;
import org.xmlcml.cml.base.CMLBuilder;
import org.xmlcml.cml.element.CMLCml;
import org.xmlcml.cml.element.CMLMolecule;
import org.xmlcml.cml.element.CMLZMatrix;
import org.xmlcml.euclid.Util;

/**
 * test ZMatrix.
 * 
 * @author pm286
 * 
 */
public class CMLZMatrixTest {

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLZMatrix.CMLZMatrix(CMLElement)'
	 * 
	 * @exception Exception
	 */
	@Test
	public void testCMLZMatrixCMLElement() throws Exception {

		String zmatS = S_EMPTY
				+ "<molecule id='polypropylene_oxide' "
				+ CML_XMLNS
				+ ">"
				+ "<atomArray>"
				+ "<atom id='oh1_a1' elementType='O' hydrogenCount='1'/>"
				+ "<atom elementType='C' hydrogenCount='2' id='prop1_a1'/>"
				+ "<atom elementType='C' hydrogenCount='1' id='prop1_a2'/>"
				+ "<atom elementType='C' hydrogenCount='3' id='prop1_a3'/>"
				+ "<atom elementType='O' hydrogenCount='0' id='prop1_a4'/>"
				+ "<atom elementType='C' hydrogenCount='2' id='prop2_a1'/>"
				+ "<atom elementType='C' hydrogenCount='1' id='prop2_a2'/>"
				+ "<atom elementType='C' hydrogenCount='3' id='prop2_a3'/>"
				+ "<atom elementType='O' hydrogenCount='0' id='prop2_a4'/>"
				+ "<atom elementType='C' hydrogenCount='2' id='prop3_a1'/>"
				+ "<atom elementType='C' hydrogenCount='1' id='prop3_a2'/>"
				+ "<atom elementType='C' hydrogenCount='3' id='prop3_a3'/>"
				+ "<atom elementType='O' hydrogenCount='0' id='prop3_a4'/>"
				+ "<atom id='h1_a1' elementType='H'/>"
				+ "</atomArray>"
				+ "<bondArray>"
				+ "<bond order='1' id='prop1_a1_prop1_a2' atomRefs2='prop1_a1 prop1_a2'/>"
				+ "<bond order='1' id='prop1_a2_prop1_a3' atomRefs2='prop1_a2 prop1_a3'/>"
				+ "<bond order='1' id='prop1_a2_prop1_a4' atomRefs2='prop1_a2 prop1_a4'/>"
				+ "<bond order='1' id='prop2_a1_prop2_a2' atomRefs2='prop2_a1 prop2_a2'/>"
				+ "<bond order='1' id='prop2_a2_prop2_a3' atomRefs2='prop2_a2 prop2_a3'/>"
				+ "<bond order='1' id='prop2_a2_prop2_a4' atomRefs2='prop2_a2 prop2_a4'/>"
				+ "<bond order='1' id='prop3_a1_prop3_a2' atomRefs2='prop3_a1 prop3_a2'/>"
				+ "<bond order='1' id='prop3_a2_prop3_a3' atomRefs2='prop3_a2 prop3_a3'/>"
				+ "<bond order='1' id='prop3_a2_prop3_a4' atomRefs2='prop3_a2 prop3_a4'/>"
				+ "<bond atomRefs2='prop1_a4 prop2_a1' id='prop1_r2_prop2_r1' order='1'/>"
				+ "<bond atomRefs2='prop2_a4 prop3_a1' id='prop2_r2_prop3_r1' order='1'/>"
				+ "<bond atomRefs2='oh1_a1 prop1_a1' id='oh1_r1_prop1_r1' order='1'/>"
				+ "<bond atomRefs2='prop3_a4 h1_a1' id='prop3_r2_h1_r1' order='1'/>"
				+ "</bondArray>"
				+ "<length atomRefs2='prop1_a1 prop1_a2'>1.54</length>"
				+ "<length atomRefs2='prop1_a2 prop1_a3'>1.54</length>"
				+ "<angle atomRefs3='prop1_a4 prop1_a2 prop1_a3'>111</angle>"
				+ "<length atomRefs2='prop1_a2 prop1_a4'>1.40</length>"
				+ "<angle atomRefs3='prop1_a1 prop1_a2 prop1_a4'>111</angle>"
				+ "<torsion atomRefs4='prop1_a1 prop1_a4 prop1_a2 prop1_a3'>120</torsion>"
				+ "<length atomRefs2='prop2_a1 prop2_a2'>1.54</length>"
				+ "<length atomRefs2='prop2_a2 prop2_a3'>1.54</length>"
				+ "<angle atomRefs3='prop2_a4 prop2_a2 prop2_a3'>111</angle>"
				+ "<length atomRefs2='prop2_a2 prop2_a4'>1.40</length>"
				+ "<angle atomRefs3='prop2_a1 prop2_a2 prop2_a4'>111</angle>"
				+ "<torsion atomRefs4='prop2_a1 prop2_a4 prop2_a2 prop2_a3'>120</torsion>"
				+ "<length atomRefs2='prop3_a1 prop3_a2'>1.54</length>"
				+ "<length atomRefs2='prop3_a2 prop3_a3'>1.54</length>"
				+ "<angle atomRefs3='prop3_a4 prop3_a2 prop3_a3'>111</angle>"
				+ "<length atomRefs2='prop3_a2 prop3_a4'>1.40</length>"
				+ "<angle atomRefs3='prop3_a1 prop3_a2 prop3_a4'>111</angle>"
				+ "<torsion atomRefs4='prop3_a1 prop3_a4 prop3_a2 prop3_a3'>120</torsion>"
				+ "<angle atomRefs3='prop1_a2 prop1_a4 prop2_a1'>105</angle>"
				+ "<length atomRefs2='prop1_a4 prop2_a1'>1.40</length>"
				+ "<angle atomRefs3='prop1_a4 prop2_a1 prop2_a2'>105</angle>"
				+ "<torsion atomRefs4='prop1_a1 prop1_a2 prop1_a4 prop2_a1'>140</torsion>"
				+ "<torsion atomRefs4='prop1_a2 prop1_a4 prop2_a1 prop2_a2'>140</torsion>"
				+ "<torsion atomRefs4='prop1_a4 prop2_a1 prop2_a2 prop2_a4'>140</torsion>"
				+ "<angle atomRefs3='prop2_a2 prop2_a4 prop3_a1'>105</angle>"
				+ "<length atomRefs2='prop2_a4 prop3_a1'>1.40</length>"
				+ "<angle atomRefs3='prop2_a4 prop3_a1 prop3_a2'>105</angle>"
				+ "<torsion atomRefs4='prop2_a1 prop2_a2 prop2_a4 prop3_a1'>160</torsion>"
				+ "<torsion atomRefs4='prop2_a2 prop2_a4 prop3_a1 prop3_a2'>160</torsion>"
				+ "<torsion atomRefs4='prop2_a4 prop3_a1 prop3_a2 prop3_a4'>160</torsion>"
				+ "<length atomRefs2='oh1_a1 prop1_a1'>1.40</length>"
				+ "<angle atomRefs3='oh1_a1 prop1_a1 prop1_a2'>105</angle>"
				+ "<torsion atomRefs4='oh1_a1 prop1_a1 prop1_a2 prop1_a4'>90</torsion>"
				+ "<length atomRefs2='prop3_a4 h1_a1'>1.10</length>"
				+ "<angle atomRefs3='prop3_a2 prop3_a4 h1_a1'>105</angle>"
				+ "<torsion atomRefs4='prop3_a1 prop3_a2 prop3_a4 h1_a1'>60</torsion>"
				+ "</molecule>" + S_EMPTY;
		CMLMolecule molecule = (CMLMolecule) new CMLBuilder()
				.parseString(zmatS);
		CMLZMatrix zmat = new CMLZMatrix(molecule);
		zmat.addCartesiansTo(molecule);

		// test for bad input
		String zmatBadS = "<cml "
				+ CML_XMLNS
				+ ">"
				+ "<length atomRefs2='prop1_a1 prop1_a2'>1.54</length>"
				+ "<length atomRefs2='prop1_a2 prop1_a3'>1.54</length>"
				+ "<angle atomRefs3='prop1_a1 prop1_a2 prop1_a3'>111</angle>"
				+ "<length atomRefs2='prop1_a2 prop1_a4'>1.40</length>"
				+ "<angle atomRefs3='prop1_a1 prop1_a2 prop1_a4'>111</angle>"
				+ "<torsion atomRefs4='prop1_a1 prop1_a4 prop1_a2 prop1_a3'>120</torsion>"
				+ "<length atomRefs2='prop2_a1 prop2_a2'>1.54</length>"
				+ "<length atomRefs2='prop2_a2 prop2_a3'>1.54</length>"
				+ "</cml>" + S_EMPTY;
		CMLCml cml = (CMLCml) parseValidString(zmatBadS);
		try {
			zmat = new CMLZMatrix(cml);
		} catch (RuntimeException e) {
			Assert
					.assertEquals(
							"test number of components",
							"wrong number of angle elements (2) for length Elements (5) in ZMatrix",
							e.getMessage());
		}

		zmatBadS = "<cml " + CML_XMLNS + ">"
				+ "<length atomRefs2='prop1_a1 prop1_a2'>1.54</length>"
				+ "<length atomRefs2='prop1_a2 prop1_a3'>1.54</length>"
				+ "<angle atomRefs3='prop1_a1 prop1_a2 prop1_a3'>111</angle>"
				+ "<length atomRefs2='prop1_a2 prop1_a4'>1.40</length>"
				+ "<angle atomRefs3='prop1_a1 prop1_a2 prop1_a4'>111</angle>"
				+ "</cml>" + S_EMPTY;
		cml = (CMLCml) parseValidString(zmatBadS);
		try {
			zmat = new CMLZMatrix(cml);
		} catch (RuntimeException e) {
			Assert
					.assertEquals(
							"test number of components",
							"wrong number of torsion elements (0) for length Elements (3) in ZMatrix",
							e.getMessage());
		}

	}

	/**
	 * another test for the constructor.
	 * 
	 */
	@Test
	public void testZMatrixElement2() {
		String moleculeS = S_EMPTY + "<molecule id='branch0' "
				+ "convention='cml:PML-complete' "
				+ "xmlns='http://www.xml-cml.org/schema'>" + "<atomArray>"
				+ "<atom elementType='O' hydrogenCount='1' id='a0'/>"
				+ "<atom elementType='C' hydrogenCount='2' id='a1'/>"
				+ "<atom elementType='C' hydrogenCount='1' id='a2'/>"
				+ "<atom elementType='C' hydrogenCount='0' id='a3'/>"
				+ "<atom elementType='O' hydrogenCount='0' id='a4'/>"
				+ "<atom elementType='O' hydrogenCount='0' id='a5'/>"
				+ "<atom elementType='C' hydrogenCount='3' id='a6'/>"
				+ "<atom elementType='Cl' id='a7'/>" + "</atomArray>"
				+ "<bondArray>"
				+ "<bond order='1' id='a1_a2' atomRefs2='a1 a2'/>"
				+ "<bond order='1' id='a2_a3' atomRefs2='a2 a3'/>"
				+ "<bond order='2' id='a3_a4' atomRefs2='a3 a4'/>"
				+ "<bond order='1' id='a3_a5' atomRefs2='a3 a5'/>"
				+ "<bond atomRefs2='a0 a1' id='g:oh_1_r1_g:r1' order='1'/>"
				+ "<bond atomRefs2='a5 a6' id='g:r3_g:me_3_r1' order='1'/>"
				+ "<bond atomRefs2='a2 a7' id='g:r2_g:cl_4_r1' order='1'/>"
				+ "</bondArray>" + "<length atomRefs2='a3 a5'>1.32</length>"
				+ "<length atomRefs2='a3 a4'>1.25</length>"
				+ "<length atomRefs2='a2 a3'>1.52</length>"
				+ "<length atomRefs2='a1 a2'>1.54</length>"
				+ "<length atomRefs2='a0 a1'>1.4</length>"
				+ "<length atomRefs2='a5 a6'>1.39</length>"
				+ "<length atomRefs2='a2 a7'>1.54</length>"
				+ "<angle atomRefs3='a3 a2 a7'>120</angle>"
				+ "<angle atomRefs3='a3 a5 a6'>120</angle>"
				+ "<angle atomRefs3='a2 a1 a0'>111</angle>"
				+ "<angle atomRefs3='a5 a3 a4'>120</angle>"
				+ "<angle atomRefs3='a2 a3 a5'>120</angle>"
				+ "<angle atomRefs3='a1 a2 a3'>111</angle>"
				+ "<torsion atomRefs4='a2 a5 a3 a4'>120</torsion>"
				+ "<torsion atomRefs4='a1 a3 a2 a7'>120</torsion>"
				+ "<torsion atomRefs4='a2 a3 a5 a6'>180</torsion>"
				+ "<torsion atomRefs4='a1 a2 a3 a5'>-90</torsion>"
				+ "<torsion atomRefs4='a0 a1 a2 a3'>120</torsion>"
				+ "</molecule>";
		CMLMolecule molecule = (CMLMolecule) parseValidString(moleculeS);
		/* CMLZMatrix zMatrix = */new CMLZMatrix(molecule);
	}

	@SuppressWarnings("unused")
	private void testExample(String infileS, String outfileS)
			throws IOException, ValidityException, ParsingException {
		Document doc = null;
		CMLMolecule mol = null;
		InputStream in = Util.getInputStreamFromResource(EXPERIMENTAL_RESOURCE
				+ U_S + infileS);
		doc = new CMLBuilder().build(in);
		in.close();
		mol = (CMLMolecule) doc.getRootElement();
		CMLZMatrix zmat = new CMLZMatrix(mol);
		/*
		 * -- add random torsions for fun Elements torsionList =
		 * zmat.getChildCMLElements(CMLTorsion.TAG); for (int i = 0; i <
		 * torsionList.size(); i++) { CMLTorsion torsion = (CMLTorsion)
		 * torsionList.get(i); double tangle = torsion.getXMLContent(); tangle
		 * += 30 Math.random(); torsion.setXMLContent(tangle); } --
		 */
		zmat.addCartesiansTo(mol);

		File outfile = new File(outfileS);
		Serializer serializer = null;
		try {
			serializer = new Serializer(new FileOutputStream(outfile));
		} catch (FileNotFoundException e) {
			neverThrow(e);
		}
		try {
			serializer.write(doc);
		} catch (IOException e) {
			neverThrow(e);
		}
	}

}
