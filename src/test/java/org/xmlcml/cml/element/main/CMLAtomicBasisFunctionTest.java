package org.xmlcml.cml.element.main;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.xmlcml.cml.element.CMLAtom;
import org.xmlcml.cml.element.CMLAtomicBasisFunction;
import org.xmlcml.cml.element.CMLBasisSet.Basis;
import org.xmlcml.molutil.ChemicalElement.AS;

/** test CMLAtomicBasisFunction */
public class CMLAtomicBasisFunctionTest {

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLAtomicBasisFunction.CMLAtomicBasisFunction(int
	 * , int, int, String, String, String)'
	 */
	@Test
	public void testCMLAtomicBasisFunctionIntIntIntStringStringString() {
		int l = 2;
		int m = 1;
		int n = 2;
		String lm = "xx";
		String symbol = "px";
		String atomRef = "a1";
		CMLAtomicBasisFunction abf = new CMLAtomicBasisFunction(l, m, n, lm,
				symbol, atomRef);
		Assert.assertEquals("l", 2, abf.getL());
		Assert.assertEquals("m", 1, abf.getM());
		Assert.assertEquals("n", 2, abf.getN());
		Assert.assertEquals("lm", "xx", abf.getLm());
		Assert.assertEquals("symbol", "px", abf.getSymbol());
		Assert.assertEquals("atomRef", "a1", abf.getAtomRef());
	}

	/**
	 * Test method for
	 * 'org.xmlcml.cml.element.CMLAtomicBasisFunction.getABFList(CMLAtom,
	 * Basis)'
	 */
	@Test
	public void testGetABFList() {
		CMLAtom atom = new CMLAtom();
		atom.setId("a1");
		atom.setElementType(AS.H.value);
		List<CMLAtomicBasisFunction> abfList = CMLAtomicBasisFunction
				.getABFList(atom, Basis.MINIMAL);
		Assert.assertEquals(AS.H.value, 1, abfList.size());
		Assert.assertEquals("H1", "1s(s)(null)", abfList.get(0).getString());
		atom.setElementType(AS.C.value);
		abfList = CMLAtomicBasisFunction.getABFList(atom, Basis.MINIMAL);
		Assert.assertEquals(AS.C.value, 4, abfList.size());
		Assert.assertEquals("C1", "2s(s)(null)", abfList.get(0).getString());
		Assert.assertEquals("C2", "2px(px)(null)", abfList.get(1).getString());
		Assert.assertEquals("C3", "2py(py)(null)", abfList.get(2).getString());
		Assert.assertEquals("C4", "2pz(pz)(null)", abfList.get(3).getString());
		atom.setElementType("Q");
		abfList = CMLAtomicBasisFunction.getABFList(atom, Basis.MINIMAL);
		Assert.assertEquals("Q", 0, abfList.size());
	}

	/**
	 * run tests.
	 * 
	 * @return the suite.
	 * 
	 */
}
