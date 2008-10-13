package org.xmlcml.euclid;
/**
 * replaces all Exceptions in jumbo.euclid with a single Exception. The old
 * Exceptions were too numerous and confused signatures
 * 
 * @author (C) P. Murray-Rust, 1996
 */
public class EuclidException extends Exception {
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 3617576011412288051L;
    /**
     * constructor.
     */
    public EuclidException() {
        super();
    }
    /**
     * constructor.
     * 
     * @param s
     */
    public EuclidException(String s) {
        super(s);
    }
}
