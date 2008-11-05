package org.xmlcml.cml.attribute;

import nu.xom.Attribute;

import org.junit.Assert;
import org.junit.Test;
import org.xmlcml.cml.base.TstBase;
import org.xmlcml.cml.element.CMLFragment;
import org.xmlcml.cml.element.CMLJoin;

public class CountExpressionAttributeAdapterTest {

	@Test
	public void testSetCMLValue() {
		String s =
			"<join countExpression='1' xmlns='http://www.xml-cml.org/schema'/>";
		CMLJoin join = (CMLJoin) TstBase.parseValidString(s);
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
		CMLJoin join = (CMLJoin) TstBase.parseValidString(s);
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
		CMLFragment fragment = (CMLFragment) TstBase.parseValidString(s);
		Attribute att = fragment.getAttribute("countExpression");
		CountExpressionAttributeAdapter ceaa = new CountExpressionAttributeAdapter(att);
		ceaa.setCMLValue("*(5)");
		int ii = ceaa.calculateCountExpression();
		Assert.assertEquals("calculated value", 5, ii);
	}
}
