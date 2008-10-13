package org.xmlcml.cml.element.main;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Serializer;
import nu.xom.Text;

import org.junit.Assert;
import org.junit.Test;

/**
 * miscellaneous test stuff
 * 
 * @author pmr
 * 
 */
public class MiscTest {

	/**
	 * test XOM
	 */
	@Test
	public void testXomText() {
		Element a = new Element("a");
		new Document(a);
		Assert.assertEquals("empty element", "<a/>" + (char) 13 + (char) 10,
				output(a));
		Text text = new Text("x");
		a.appendChild(text);
		Assert.assertEquals("non-empty text", "<a>x</a>" + (char) 13
				+ (char) 10, output(a));
		text.setValue("y");
		Assert.assertEquals("non-empty text", "<a>y</a>" + (char) 13
				+ (char) 10, output(a));
		text.setValue("");
		Assert.assertEquals("empty text", "<a/>" + (char) 13 + (char) 10,
				output(a));
		Assert.assertEquals("empty text count", 1, a.getChildCount());
		Assert.assertEquals("empty text value", "", text.getValue());
		text.setValue(null);
		Assert.assertEquals("nullValue text", "<a/>" + (char) 13 + (char) 10,
				output(a));
		Assert.assertEquals("nullValue child count", 1, a.getChildCount());
		// should fail but doesn't
		Assert.assertNotNull("nullValue text", text.getValue());
		// should fail but doesn't
		Assert.assertEquals("empty text child value", "", text.getValue());
		text.setValue("z");
		Assert.assertEquals("empty text child", "<a>z</a>" + (char) 13
				+ (char) 10, output(a));

		a = new Element("a");
		new Document(a);
		Assert.assertEquals("empty element", "<a/>" + (char) 13 + (char) 10,
				output(a));
		String s = null;
		text = new Text(s);
		Assert.assertEquals("nullValue text", "", text.getValue());
		a.appendChild(text);
		Assert.assertEquals("nullValue text", "<a/>" + (char) 13 + (char) 10,
				output(a));
		Assert.assertEquals("nullValue child count", 1, a.getChildCount());
		// should fail but doesn't
		Assert.assertNotNull("nullValue text", text.getValue());
		// should fail but doesn't
		Assert.assertEquals("empty text child value", "", text.getValue());

		try {
			text = new Text((Text) null);
			Assert.fail("should throw NullPointer");
		} catch (NullPointerException npe) {
			;
		}
	}

	private String output(Element a) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		String actual = null;
		try {
			baos = new ByteArrayOutputStream();
			Serializer ser = new MockSerializer(baos);
			ser.write((Document) a.getParent());
			actual = baos.toString();
		} catch (IOException e) {
			throw new RuntimeException("bug " + e);
		}
		return actual;
	}

	/**
	 * run tests.
	 * 
	 * @return the suite.
	 * 
	 */

}

class MockSerializer extends Serializer {
	/**
	 * constructor
	 * 
	 * @param os
	 */
	public MockSerializer(OutputStream os) {
		super(os);
	}

	/**
	 * test
	 * 
	 */
	public void writeXMLDeclaration() {

	}
}
