package org.xmlcml.cml.element.main;

import static org.xmlcml.cml.base.BaseTest.parseValidString;
import static org.xmlcml.cml.base.CMLConstants.CML_XMLNS;
import static org.xmlcml.euclid.EuclidConstants.S_EMPTY;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.xmlcml.cml.element.CMLParameter;
import org.xmlcml.cml.element.CMLParameterList;

/**
 * tests parameterList.
 * 
 * @author pm286
 * 
 */
public class CMLParameterListTest {

	String parameterS = S_EMPTY + "<parameterList id='a1' " + CML_XMLNS + ">"
			+ "  <parameter id='a2' name='foo:angle' dictRef='bar:xxx'>"
			+ "    <scalar id='a3'>1.23</scalar>" + "  </parameter>"
			+ "  <parameterList id='a11' " + CML_XMLNS + ">"
			+ "    <parameter id='a21' name='foo:mpt' dictRef='bar:yyy'>"
			+ "      <scalar id='a31'>11.23</scalar>" + "    </parameter>"
			+ "  </parameterList>" + "</parameterList>" + S_EMPTY;

	CMLParameterList parameterList = null;

	/**
	 * setup.
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		parameterList = (CMLParameterList) parseValidString(parameterS);
	}

	/**
	 * Test method for 'org.xmlcml.cml.element.CMLParameterList.copy()'
	 */
	@Test
	public void testCopy() {
		CMLParameterList parameterListX = (CMLParameterList) parameterList
				.copy();
		Assert.assertNotNull("copy not null", parameterListX);
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLParameterList.getParameterDescendants()'
	 */
	@Test
	public void testGetParameterDescendants() {
		List<CMLParameter> paramList = parameterList.getParameterDescendants();
		Assert.assertEquals("param list", 2, paramList.size());
		// note order is variable
		Assert.assertEquals("param 0", "foo:mpt", paramList.get(0).getName());
		Assert.assertEquals("param 1", "foo:angle", paramList.get(1).getName());
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLParameterList.getParameterDescendants(CMLElement
	 * ) '
	 */
	@Test
	public void testGetParameterDescendantsCMLElement() {
		List<CMLParameter> paramList = CMLParameterList
				.getParameterDescendants(parameterList);
		Assert.assertEquals("param list", 2, paramList.size());
		// note order is variable
		Assert.assertEquals("param 0", "foo:mpt", paramList.get(0).getName());
		Assert.assertEquals("param 1", "foo:angle", paramList.get(1).getName());
	}

	/**
	 * Test method for'org.xmlcml.cml.element.CMLParameterList.getParameterDescendantsByDictRef(List<CMLParameter
	 * > , String)'
	 */
	@Test
	public void testGetParameterDescendantsByDictRef() {
		List<CMLParameter> paramList = CMLParameterList
				.getParameterDescendants(parameterList);
		Assert.assertEquals("param list", 2, paramList.size());
		List<CMLParameter> paramListX = CMLParameterList
				.getParameterDescendantsByDictRef(paramList, "bar:xxx");
		Assert.assertEquals("param list", 1, paramListX.size());
		Assert
				.assertEquals("param 0", "foo:angle", paramListX.get(0)
						.getName());
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLParameterList.getParameterDescendantsByName(String
	 * ) '
	 */
	@Test
	public void testGetParameterDescendantsByName() {
		List<CMLParameter> paramListX = parameterList
				.getParameterDescendantsByName("foo:angle");
		Assert.assertEquals("param list", 1, paramListX.size());
		Assert
				.assertEquals("param 0", "foo:angle", paramListX.get(0)
						.getName());
	}

}
