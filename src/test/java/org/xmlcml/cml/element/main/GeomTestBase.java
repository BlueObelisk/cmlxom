package org.xmlcml.cml.element.main;

import static org.xmlcml.cml.base.CMLConstants.CML_XMLNS;

import java.io.StringReader;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.xmlcml.cml.base.CMLBuilder;
import org.xmlcml.cml.element.CMLLine3;
import org.xmlcml.cml.element.CMLPlane3;
import org.xmlcml.cml.element.CMLPoint3;
import org.xmlcml.cml.element.CMLTransform3;
import org.xmlcml.cml.element.CMLVector3;

/**
 * provides communal resources for testing. e.g. files and moelcules subclassed
 * by atom- molecule and bond-aware
 */

public abstract class GeomTestBase {

	// created from XOM
	// these have forbidden access
	CMLPoint3 xomP;

	CMLPlane3 xomPl;

	CMLLine3 xomL;

	CMLVector3 xomV;

	CMLPoint3 xomP111;

	CMLPoint3 xomP100;

	CMLPoint3 xomP010;

	CMLPoint3 xomP001;

	CMLPoint3 xomP123;

	CMLPlane3 xomPl0100;

	CMLPlane3 xomPl1002;

	CMLPlane3 xomPl1115;

	CMLPlane3 xomPl1005;

	CMLLine3 xomL555111;

	CMLVector3 xomV000;

	CMLVector3 xomV100;

	CMLVector3 xomV010;

	CMLVector3 xomV001;

	CMLVector3 xomV111;

	CMLVector3 xomV123;

	CMLVector3 xomV321;

	CMLLine3 xomL220011;

	CMLTransform3 xomT1;

	// created from XML
	String xmlP111S;

	String xmlP100S;

	String xmlP010S;

	String xmlP001S;

	String xmlP123S;

	CMLPoint3 xmlP111;

	CMLPoint3 xmlP100;

	CMLPoint3 xmlP010;

	CMLPoint3 xmlP001;

	CMLPoint3 xmlP123;

	final static Logger logger = Logger.getLogger(GeomTestBase.class.getName());

	/**
	 * setup.
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {

		// create from XOM
		// xomP = new CMLPoint3(); // deliberately disallowed
		// xomPl = new CMLPlane3(); // deliberately disallowed
		// xomL = new CMLLine3(); // deliberately disallowed
		// xomV = new CMLVector3(); // deliberately disallowed

		xomP111 = new CMLPoint3(new double[] { 1., 1., 1. });
		xomP100 = new CMLPoint3(new double[] { 1., 0., 0. });
		xomP010 = new CMLPoint3(new double[] { 0., 1., 0. });
		xomP001 = new CMLPoint3(new double[] { 0., 0., 1. });
		xomP123 = new CMLPoint3(new double[] { 1., 2., 3. });

		xomPl0100 = new CMLPlane3(new double[] { 0., 1., 0., 0. });
		xomPl1002 = new CMLPlane3(new double[] { 1., 0., 0., 2. });
		xomPl1005 = new CMLPlane3(new double[] { 1., 0., 0., 5. });
		xomPl1115 = new CMLPlane3(new double[] { 1., 1., 1., 5. });

		// xomL555111 = new CMLLine3(new double[]{5., 5., 5., 1., 1., 1.});
		xomL220011 = new CMLLine3(new CMLPoint3(0., 1., 1.), new CMLVector3(2.,
				2., 0.));

		xomV000 = new CMLVector3(new double[] { 0., 0., 0. });
		xomV100 = new CMLVector3(new double[] { 1., 0., 0. });
		xomV010 = new CMLVector3(new double[] { 0., 1., 0. });
		xomV001 = new CMLVector3(new double[] { 0., 0., 1. });
		xomV111 = new CMLVector3(new double[] { 1., 1., 1. });
		xomV123 = new CMLVector3(new double[] { 1., 2., 3. });
		xomV321 = new CMLVector3(new double[] { 3., 2., 1. });

		// create from XML
		xmlP111S = "<point3 " + CML_XMLNS + ">1. 1. 1.</point3>";
		xmlP100S = "<point3 " + CML_XMLNS + ">1 0 0</point3>";
		xmlP010S = "<point3 " + CML_XMLNS + ">0 1.0E+00 0</point3>";
		xmlP001S = "<point3 " + CML_XMLNS + ">0 0 1</point3>";
		xmlP123S = "<point3 " + CML_XMLNS + ">1 2 3</point3>";

		CMLBuilder builder = new CMLBuilder();
		xmlP111 = (CMLPoint3) builder.build(new StringReader(xmlP111S))
				.getRootElement();
		xmlP123 = (CMLPoint3) builder.build(new StringReader(xmlP123S))
				.getRootElement();
		xmlP100 = (CMLPoint3) builder.build(new StringReader(xmlP100S))
				.getRootElement();
		xmlP010 = (CMLPoint3) builder.build(new StringReader(xmlP010S))
				.getRootElement();
		xmlP001 = (CMLPoint3) builder.build(new StringReader(xmlP001S))
				.getRootElement();

	}

	void makeXomT1() {
		xomT1 = new CMLTransform3(new double[] { 0., 1., 0., 0., 0., 0., 1.,
				0., -1., 0., 0., 0., 0., 0., 0., 1. });
	}

}
