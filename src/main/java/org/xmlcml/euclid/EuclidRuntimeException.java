/**
 * 
 */
package org.xmlcml.euclid;


/**
 * 
 * <p>
 * runtime exception for Euclid
 * </p>
 * 
 * @author Joe Townsend
 * @version 5.0
 * 
 */
public class EuclidRuntimeException extends RuntimeException implements EuclidConstants {

	/** constructor
	 * 
	 * @param message
	 * @param cause
	 */
    public EuclidRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
     * 
     */
    private static final long serialVersionUID = 3618697517584169017L;

    protected EuclidRuntimeException() {
        super();
    }

    /**
     * creates EuclidRuntime with message.
     * 
     * @param msg
     */
    public EuclidRuntimeException(String msg) {
        super(msg);
    }

    /**
     * creates EuclidRuntime from EuclidException.
     * 
     * @param exception
     */
    public EuclidRuntimeException(EuclidException exception) {
        this(S_EMPTY + exception);
    }
}
