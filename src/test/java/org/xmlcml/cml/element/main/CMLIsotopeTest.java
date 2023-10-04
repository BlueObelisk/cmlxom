package org.xmlcml.cml.element.main;

import nu.xom.Element;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.xmlcml.cml.base.CMLElement;
import org.xmlcml.cml.element.CMLGradient;
import org.xmlcml.cml.element.CMLIsotope;

import static org.junit.Assert.*;

public class CMLIsotopeTest {

    CMLIsotope cmlIsotope;
    @Before
    public void setUp() {
        cmlIsotope = new CMLIsotope();
    }

    @Test
    public void testCMLIsotopeCopy() {
        Element copyElement = cmlIsotope.copy();
        Assert.assertEquals(copyElement.getClass(), CMLIsotope.class);
    }

    @Test
    public void testMakeElementInContext() {
        Element element = new CMLIsotope();
        CMLElement actual = cmlIsotope.makeElementInContext(element);
        Assert.assertEquals(CMLIsotope.class, actual.getClass());
    }

    @Test
    public void testCMLIsotope() {
        CMLIsotope cmlIsotopOld = new CMLIsotope();
        CMLIsotope cmlIsotope = new CMLIsotope(cmlIsotopOld);
        Assert.assertEquals(cmlIsotope.getClass(), CMLIsotope.class);
    }
}