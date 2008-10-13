package org.xmlcml.cml.base;

/** tags CMLElement as having id.
 * 
 * @author pm286
 *
 */
public interface HasId {
	/**
	 * @param id
	 */
	void setId(String id);
	/**
	 * @return id
	 */
	String getId();
}
