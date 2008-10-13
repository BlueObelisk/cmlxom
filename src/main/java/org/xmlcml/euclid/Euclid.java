/**
 * 
 */
package org.xmlcml.euclid;

/**
 * These routines have evolved over >10 years and have now settled down to
 * primitive dataTypes to support CML. In general a CML data element (scalar,
 * array, matrix) * (double, int, String) will have a euclid primitive unless it
 * is already provided by Java or not useful. Almost all double types are
 * supported but some int and String types (e.g. IntSquareMatrix, StringArray,
 * etc.) are missing. The emphasis is on algebrra and geometry.
 * 
 * In some CML routines (e.g. atom.geXYZ() a Point3 is returned, but in others
 * the wrapped type (e.g. CMLArray) is used. Please let us know if this design
 * works satisfactorily.
 * 
 * @author pmr 2005
 * 
 */
public @interface Euclid {

}
