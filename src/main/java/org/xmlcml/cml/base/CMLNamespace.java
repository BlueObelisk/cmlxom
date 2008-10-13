package org.xmlcml.cml.base;


/** manages CML namespaces.
 * NOTE: NOT subclassed from nu.xom.Namespace (this is final)
 * 
 * @author Peter Murray-Rust
 * @version 5.0
 * 
 */
public class CMLNamespace implements CMLConstants {

	private String prefix;
	private String namespaceURI;
	
	/** constructor.
	 * 
	 * @param prefix
	 * @param namespaceURI
	 */
    public CMLNamespace(String prefix, String namespaceURI) {
    	this.prefix = prefix;
    	this.namespaceURI = namespaceURI;
    }

    /** make namespace from prefix and element which holds namespaces.
     * iterates up ancestry namespace prefixes until finds match
     * @param prefix
     * @param element
     * @return namespace
     */
    public static CMLNamespace createNamespace(String prefix, CMLElement element) {
    	String namespaceURI = element.getNamespaceURIForPrefix(prefix);
    	CMLNamespace namespace = null;
    	if (namespaceURI != null) {
    		namespace = new CMLNamespace(prefix, namespaceURI);
    	}
    	return namespace;
    }

    /** get namespaceURI.
     * 
     * @return the URI 
     */
    public String getNamespaceURI() {
        return namespaceURI;
    }

    /** get prefix.
     * 
     * @return the prefix
     */
    public String getPrefix() {
        return prefix;
    }

	/**
     * guess CML namespace. if correct namespace, returns it. if obsolete
     * returns correct namespace.
     * 
     * @param namespace
     * @return correct namespace or leave unchanged;
     */
    public static String guessNamespace(String namespace) {
        String namesp = namespace;
        if (CML_NS.equals(namespace)) {
            namesp = namespace;
        } else if (namespace != null) {
            for (String n : CMLConstants.OLD_NAMESPACES) {
                if (n.equals(namespace)) {
                    namesp = CML_NS;
                    break;
                }
            }
        }
        return namesp;
    }
}
