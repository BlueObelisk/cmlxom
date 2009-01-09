package org.xmlcml.euclid.test;

import org.junit.Assert;
import org.xmlcml.cml.base.CMLConstants;
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
public final class EuclidTestBase {

	/**
	 * used by Assert routines. copied from Assert
	 * 
	 * @param message
	 *            prepends if not null
	 * @param expected
	 * @param actual
	 * @return message
	 */
	public static String getAssertFormat(String message, Object expected,
			Object actual) {
		String formatted = "";
		if (message != null) {
			formatted = message + CMLConstants.S_SPACE;
		}
		return formatted + "expected:<" + expected + "> but was:<" + actual
				+ ">";
	}

	public static void neverFail(Exception e) {
		Assert.fail("should never throw " + e);
	}

	public static void alwaysFail(String message) {
		Assert.fail("should always throw " + message);
	}

	public static void neverThrow(Exception e) {
		throw new EuclidRuntimeException("should never throw " + e);
	}

}
