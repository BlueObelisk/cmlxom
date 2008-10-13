package org.xmlcml.euclid.test;

import static org.xmlcml.euclid.EuclidConstants.S_RBRAK;
import static org.xmlcml.euclid.EuclidConstants.S_SLASH;

import org.junit.Assert;
import org.junit.Test;
import org.xmlcml.euclid.Int;

/**
 * test Int.
 * 
 * @author pmr
 * 
 */
public class IntTest {

	/**
	 * tests equality of int arrays. arrays must be of same length
	 * 
	 * @param a
	 *            first array
	 * @param b
	 *            second array
	 * @return array elements equal
	 */
	static boolean equals(int[] a, int[] b) {
		boolean result = false;
		if (a.length == b.length) {
			result = true;
			for (int i = 0; i < a.length; i++) {
				if (a[i] != b[i]) {
					result = false;
					break;
				}
			}
		}
		return result;
	}

	/**
	 * Assert.asserts equality of int arrays.
	 * 
	 * checks for non-null, then equality of length, then individual elements
	 * 
	 * @param message
	 * @param a
	 *            expected array
	 * @param b
	 *            actual array
	 */
	public static void assertEquals(String message, int[] a, int[] b) {
		String s = testEquals(a, b);
		if (s != null) {
			Assert.fail(message + "; " + s);
		}
	}

	/**
	 * Assert.asserts non equality of double arrays.
	 * 
	 * checks for non-null, then equality of length, then individual elements
	 * 
	 * @param message
	 * @param a
	 *            expected array
	 * @param b
	 *            actual array
	 */
	public static void assertNotEquals(String message, int[] a, int[] b) {
		String s = testEquals(a, b);
		if (s == null) {
			Assert.fail(message + "; arrays are equal");
		}
	}

	/**
	 * compare integer arrays.
	 * 
	 * @param a
	 * @param b
	 * @return message or null
	 */
	public static String testEquals(int[] a, int[] b) {
		String s = null;
		if (a == null) {
			s = "a is null";
		} else if (b == null) {
			s = "b is null";
		} else if (a.length != b.length) {
			s = "unequal arrays: " + a.length + S_SLASH + b.length;
		} else {
			for (int i = 0; i < a.length; i++) {
				if (a[i] != b[i]) {
					s = "unequal element (" + i + "), " + a[i] + " != " + b[i];
					break;
				}
			}
		}
		return s;
	}

	/**
	 * compare arrays.
	 * 
	 * @param a
	 * @param b
	 * @return message or null if equal
	 */
	static String testEquals(int[][] a, int[][] b) {
		String s = null;
		if (a == null) {
			s = "a is null";
		} else if (b == null) {
			s = "b is null";
		} else if (a.length != b.length) {
			s = "unequal arrays: " + a.length + S_SLASH + b.length;
		} else {
			for (int i = 0; i < a.length; i++) {
				if (a[i].length != b[i].length) {
					s = "row (" + i + ") has unequal lengths: " + a[i].length
							+ S_SLASH + b[i].length;
					break;
				}
				for (int j = 0; j < a[i].length; j++) {
					if (a[i][j] != b[i][j]) {
						s = "unequal element at (" + i + ", " + j + "), ("
								+ a[i][j] + " != " + b[i][j] + S_RBRAK;
						break;
					}
				}
			}
		}
		return s;
	}

	/**
	 * Test method for 'org.xmlcml.euclid.Int.zeroArray(int, int[])'
	 */
	@Test
	public void testZeroArray() {
		int[] ii = new int[5];
		Int.zeroArray(5, ii);
		IntTest.assertEquals("int[] ", new int[] { 0, 0, 0, 0, 0 }, ii);
	}

	/**
	 * Test method for 'org.xmlcml.euclid.Int.initArray(int, int[], int)'
	 */
	@Test
	public void testInitArray() {
		int[] ii = new int[5];
		Int.initArray(5, ii, 3);
		IntTest.assertEquals("int[] ", new int[] { 3, 3, 3, 3, 3 }, ii);
	}

}
