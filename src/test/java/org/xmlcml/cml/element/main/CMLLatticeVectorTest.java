package org.xmlcml.cml.element.main;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.xmlcml.cml.base.CMLBuilder;
import org.xmlcml.euclid.test.DoubleTestBase;

/**
 * test latticeVector.
 * 
 * @author pm286
 * 
 */
public class CMLLatticeVectorTest extends AbstractTest {

    String latticeVector1S = "<latticeVector " + CML_XMLNS
            + ">1. 2. 3.</latticeVector>";

    CMLLatticeVector latticeVector1 = null;

    /**
     * setUp.
     * 
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        super.setUp();
        latticeVector1 = (CMLLatticeVector) new CMLBuilder()
                .parseString(latticeVector1S);
    }

    /**
     * equality test. true if both args not null and equal within epsilon
     * 
     * @param msg
     *            message
     * @param test
     * @param expected
     * @param epsilon
     */
    public static void assertEquals(String msg, CMLLatticeVector test,
            CMLLatticeVector expected, double epsilon) {
        Assert.assertNotNull("test should not be null (" + msg + S_RBRAK, test);
        Assert.assertNotNull("expected should not be null (" + msg + S_RBRAK,
                expected);
        DoubleTestBase.assertEquals(msg, test.getXMLContent(), expected
                .getXMLContent(), epsilon);
    }

    /**
     * equality test. true if both args not null and equal within epsilon
     * 
     * @param msg
     *            message
     * @param test
     *            array must be of length 3
     * @param expected
     * @param epsilon
     */
    public static void assertEquals(String msg, double[] test,
            CMLLatticeVector expected, double epsilon) {
        Assert.assertNotNull("test should not be null (" + msg + S_RBRAK, test);
        Assert.assertEquals("must be of length 3", 3, test.length);
        Assert.assertNotNull("expected should not be null (" + msg + S_RBRAK,
                expected);
        DoubleTestBase.assertEquals(msg, test, expected.getXMLContent(), epsilon);
    }

    /**
     * Test method for 'org.xmlcml.cml.element.CMLLatticeVector.copy()'
     */
    @Test
    public void testCopy() {
        CMLLatticeVector latticeVector = (CMLLatticeVector) latticeVector1.copy();
        CMLLatticeVectorTest.assertEquals("copy", new double[] { 1., 2., 3. },
                latticeVector, EPS);
    }

    /**
     * Test method for
     * 'org.xmlcml.cml.element.CMLLatticeVector.CMLLatticeVector(double[])'
     */
    @Test
    public void testCMLLatticeVectorDoubleArray() {
        CMLLatticeVector latticeVector = new CMLLatticeVector(new double[] {
                1., 2., 3 });
        CMLLatticeVectorTest.assertEquals("doubleArray constructor",
                new double[] { 1., 2., 3. }, latticeVector, EPS);
    }

    /**
     * Test method for
     * 'org.xmlcml.cml.element.CMLLatticeVector.CMLLatticeVector(CMLVector3)'
     */
    @Test
    public void testCMLLatticeVectorCMLVector3() {
        CMLVector3 v = new CMLVector3(1., 2., 3);
        CMLLatticeVector latticeVector = new CMLLatticeVector(v);
        CMLLatticeVectorTest.assertEquals("vector3 constructor", new double[] {
                1., 2., 3. }, latticeVector, EPS);
    }

    /**
     * Test method for 'org.xmlcml.cml.element.CMLLatticeVector.getCMLVector3()'
     */
    @Test
    public void testGetCMLVector3() {
        CMLLatticeVector latticeVector = new CMLLatticeVector(new double[] {
                1., 2., 3 });
        CMLVector3 v = latticeVector.getCMLVector3();
        CMLVector3Test.assertEquals("get vector3", new double[] { 1., 2., 3. },
                v, EPS);
    }

}
