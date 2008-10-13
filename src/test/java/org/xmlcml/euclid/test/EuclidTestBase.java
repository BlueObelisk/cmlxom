package org.xmlcml.euclid.test;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.xmlcml.euclid.EuclidConstants;
import org.xmlcml.euclid.EuclidRuntimeException;

/**
 * 
 * <p>
 * superclass for manage common methods for unit tests
 * </p>
 * 
 * @author Peter Murray-Rust
 * @version 5.0
 * 
 */
public class EuclidTestBase implements EuclidConstants {

    private static Set<Class<?>> classSet = new HashSet<Class<?>>();
    /** setup.
     * prints names of class being tested.
     * @exception Exception
     */
    @Before
    public void setUp() throws Exception {
        Class<?> classx = this.getClass();
        if (!classSet.contains(classx)) {
            System.out.println("======="+classx.getName()+"======");
            classSet.add(classx);
        }
    }

    /**
     * used by Assert.assert routines. copied from Assert
     * 
     * @param message
     *            prepends if not null
     * @param expected
     * @param actual
     * @return message
     */
    protected static String getAssertFormat(String message, Object expected,
            Object actual) {
        String formatted = "";
        if (message != null) {
            formatted = message + S_SPACE;
        }
        return formatted + "expected:<" + expected + "> but was:<" + actual
                + ">";
    }

    protected static void neverFail(Exception e) {
        Assert.fail("should never throw " + e);
    }

    protected static void alwaysFail(String message) {
        Assert.fail("should always throw " + message);
    }

    protected static void neverThrow(Exception e) {
        throw new EuclidRuntimeException("should never throw " + e);
    }

}
