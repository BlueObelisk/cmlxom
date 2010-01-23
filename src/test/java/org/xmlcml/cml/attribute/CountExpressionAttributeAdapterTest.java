package org.xmlcml.cml.attribute;

import nu.xom.Attribute;

import org.junit.Assert;
import org.junit.Test;
import org.xmlcml.cml.base.CMLXOMTestUtils;
import org.xmlcml.cml.element.CMLFragment;
import org.xmlcml.cml.element.CMLJoin;

public class CountExpressionAttributeAdapterTest {

	@Test
	public void testSetCMLValue() {
		String s =
			"<join countExpression='1' xmlns='http://www.xml-cml.org/schema'/>";
		CMLJoin join = (CMLJoin) CMLXOMTestUtils.parseValidString(s);
		Attribute att = join.getAttribute("countExpression");
		CountExpressionAttributeAdapter ceaa = new CountExpressionAttributeAdapter(att);
		ceaa.setCMLValue("*(5)");
		int ii = ceaa.calculateCountExpression();
		Assert.assertEquals("calculated value", 5, ii);
		
	}


	@Test
	public void testCalculateCountExpression() {
		String s =
			"<join countExpression='range(3,5)' xmlns='http://www.xml-cml.org/schema'/>";
		CMLJoin join = (CMLJoin) CMLXOMTestUtils.parseValidString(s);
		Attribute att = join.getAttribute("countExpression");
		CountExpressionAttributeAdapter ceaa = new CountExpressionAttributeAdapter(att);
		ceaa = new CountExpressionAttributeAdapter(att);
		int ii = ceaa.calculateCountExpression();
		Assert.assertTrue("calculated value", ii < 6 && ii > 2);
	}

	
	@Test
	public void testUsageOnFragment() {
		String s =
			"<fragment countExpression='1' xmlns='http://www.xml-cml.org/schema'/>";
		CMLFragment fragment = (CMLFragment) CMLXOMTestUtils.parseValidString(s);
		Attribute att = fragment.getAttribute("countExpression");
		CountExpressionAttributeAdapter ceaa = new CountExpressionAttributeAdapter(att);
		ceaa.setCMLValue("*(5)");
		int ii = ceaa.calculateCountExpression();
		Assert.assertEquals("calculated value", 5, ii);
	}
	
	
	@Test
	public void testGetRange() {
		String s =
			"<join countExpression='range(4,8)' xmlns='http://www.xml-cml.org/schema'/>";
		CMLJoin join = (CMLJoin) CMLXOMTestUtils.parseValidString(s);
		Attribute att = join.getAttribute("countExpression");
		CountExpressionAttributeAdapter ceaa = new CountExpressionAttributeAdapter(att);
		int [] range = ceaa.getRange();
		Assert.assertEquals(2, range.length);
		Assert.assertEquals(4, range[0]);
		Assert.assertEquals(8, range[1]);
		
		String s2 =
			"<join countExpression='1' xmlns='http://www.xml-cml.org/schema'/>";
		CMLJoin join2 = (CMLJoin) CMLXOMTestUtils.parseValidString(s2);
		Attribute att2 = join2.getAttribute("countExpression");
		CountExpressionAttributeAdapter ceaa2 = new CountExpressionAttributeAdapter(att2);
		range = ceaa2.getRange();
		Assert.assertNull(range);
	}
}
