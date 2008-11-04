package org.xmlcml.cml.base;

import static org.xmlcml.cml.base.TstBase.BASE_RESOURCE;
import static org.xmlcml.euclid.EuclidConstants.U_S;
import static org.xmlcml.euclid.test.EuclidTestBase.neverFail;
import static org.xmlcml.euclid.test.EuclidTestBase.neverThrow;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;

import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.ParsingException;
import nu.xom.ValidityException;

import org.junit.Assert;
import org.junit.Test;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xmlcml.euclid.Util;

/**
 * fundamental parsing (not necessarily involved derived classses.
 * 
 * @author pmr
 * 
 */
public class ElementTest {
	final static String noSchema = "noSchema.xml";

	final static String cml0 = "cml0.xml";

	/**
	 * parse withoout validation.
	 * 
	 * @exception Exception
	 *                problem
	 * 
	 */
	@Test
	public void testParseNoValidate0() throws Exception {
		xomNoValidate(cml0);
		xomNoValidate(noSchema);
	}

	private void xomNoValidate(String file) throws IOException,
			ValidityException, ParsingException {
		Document doc = null;
		Util.output("  === xom Parse, no validation: " + file + " ====");
		InputStream in = null;

		in = Util.getInputStreamFromResource(BASE_RESOURCE + U_S + file);
		doc = new Builder().build(in);
		Assert.assertNotNull("document ", doc);
	}

	/**
	 * test using xerces on XOM.
	 * 
	 * @exception Exception
	 */
	@Test
	public void testParseXomXercesValidate() throws Exception {
		xomXercesValidate(cml0);
		// xomXercesValidate(noSchema);
	}

	private void xomXercesValidate(String file) throws SAXException,
			IOException, ValidityException, ParsingException {
		Util.output("  === xom+Xerces validation: " + file + " ====");
		Document doc = null;
		InputStream in = null;
		XMLReader xerces = XMLReaderFactory
				.createXMLReader("org.apache.xerces.parsers.SAXParser");
		xerces.setFeature("http://apache.org/xml/features/validation/schema",
				true);
		Builder builder = new Builder(xerces, /* true */false);
		in = Util.getInputStreamFromResource(BASE_RESOURCE + U_S + file);
		doc = builder.build(in);
		Assert.assertNotNull("document ", doc);
	}

	/*
	 * -- A sample DOM counter. This sample program illustrates how to traverse
	 * a DOM tree in order to get information about the document. The output of
	 * this program shows the time and count of elements, attributes, ignorable
	 * whitespaces, and characters appearing in the document. Three times are
	 * shown: the parse time, the first traversal of the document, and the
	 * second traversal of the tree. This class is useful as a "poor-man's"
	 * performance tester to compare the speed and accuracy of various DOM
	 * parsers. However, it is important to note that the first parse time of a
	 * parser will include both VM class load time and parser initialization
	 * that would not be present in subsequent parses with the same file. Note:
	 * The results produced by this program should never be accepted as true
	 * performance measurements. usage java dom.Counter (options) uri ... Option
	 * Description -p name Select parser wrapper by name. -x number Select
	 * number of repetitions. -n | -N Turn on/off namespace processing. -vector
	 * | -V Turn on/off validation. -s | -S Turn on/off Schema validation
	 * support. NOTE: Not supported by all parsers. -f | -F Turn on/off Schema
	 * full checking. NOTE: Requires use of -s and not supported by all parsers.
	 * -va | -VA Turn on/off validation of schema annotations. NOTE: Requires
	 * use of -s and not supported by all parsers. -dv | -DV Turn on/off dynamic
	 * validation. NOTE: Not supported by all parsers. -xi | -XI Turn on/off
	 * XInclude processing. NOTE: Not supported by all parsers. -xb | -XB Turn
	 * on/off base URI fixup during XInclude processing. NOTE: Requires use of
	 * -xi and not supported by all parsers. -xl | -XL Turn on/off language
	 * fixup during XInclude processing. NOTE: Requires use of -xi and not
	 * supported by all parsers. -h Display help screen.
	 */
	/*
	 * private void xercesValidate(String file) {
	 * Util.output("  === xerces validation: " + file + " ===="); String[] args
	 * = null; try { // args = new String[]{"-vector", "-s", new //
	 * URL("file://"+file).toString()}; args = new String[] { "-vector", "-s",
	 * file }; } catch (Exception e) { neverFail(e); } dom.Counter.main(args); }
	 */
	/**
	 * validate with xerces.
	 */
	/*
	 * @Test public void testXercesValidateXML() { xercesValidate(cml0); // this
	 * throws an error as it has no schema // xercesValidate(noSchema); }
	 */
	/**
	 * parse without schema.
	 */
	@Test
	public void testParseXomNoSchema1() {
		Util.output("  === xom Parse, no schema, no validation: " + noSchema
				+ " ====");
		InputStream in = null;
		Document doc = null;
		try {
			in = Util
					.getInputStreamFromResource(BASE_RESOURCE + U_S + noSchema);
			doc = new Builder().build(in);
			Assert.assertNotNull("document", doc);
		} catch (ValidityException e) {
			neverFail(e);
		} catch (FileNotFoundException e) {
			neverFail(e);
		} catch (ParsingException e) {
			neverFail(e);
		} catch (IOException e) {
			neverFail(e);
		}
	}

	/**
	 * test namespace scope. This is a know difficulty and this explores the XOM
	 * approach.
	 * 
	 */
	@Test
	public void testNamespaceScope() {
		String s = "<a xmlns:ns='http://foo'><b foo='ns:bar'/></a>";
		Document doc = null;
		try {
			doc = new Builder().build(new StringReader(s));
		} catch (Exception e) {
		}
		Element a = doc.getRootElement();
		Element b = a.getFirstChildElement("b");
		int nsCount = b.getNamespaceDeclarationCount();
		for (int i = 0; i < nsCount; i++) {
			// Util.output("NSPREFIX"+i+"
			// ["+b.getNamespacePrefix(i)+S_RSQUARE);
			// Util.output("NSURI"+i+"
			// ["+b.getNamespaceURI(b.getNamespacePrefix(i))+S_RSQUARE);
		}
		// Util.output("NS: "+b.getNamespaceURI("ns"));
	}

	/**
	 * test removeWhitespaceNodes(Element element).
	 */
	@Test
	public void testRemoveWhitespaceNodesElement() {
		String element0S = "" + "<foo>" + "  <bar>"
				+ "    <plugh>  <br/>  </plugh>" + "  </bar>" + "</foo>" + "";
		Element element0 = null;
		try {
			element0 = new CMLBuilder().parseString(element0S);
		} catch (Exception e) {
			e.printStackTrace();
			neverThrow(e);
		}
		String element1S = "<foo><bar><plugh><br/></plugh></bar></foo>";
		Element element1 = null;
		try {
			element1 = new CMLBuilder().parseString(element1S);
		} catch (Exception e) {
			neverThrow(e);
		}
		TstBase.assertNotEqualsCanonically("before whitespace", element0,
				element1);
		CMLUtil.removeWhitespaceNodes(element0);
		TstBase.assertEqualsCanonically("before whitespace ", element0,
				element1);
	}

}
