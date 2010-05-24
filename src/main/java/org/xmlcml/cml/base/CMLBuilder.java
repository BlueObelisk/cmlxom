package org.xmlcml.cml.base;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;

import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.NodeFactory;
import nu.xom.ParsingException;
import nu.xom.ValidityException;

/**
 * 
 * <p>
 * Class extending the XOM builder, constructs a XOM builder using either the
 * CML node factory as default or a passed node factory.
 * </p>
 * 
 * @author Peter Murray-Rust
 * @version 5.0
 * 
 */
public class CMLBuilder extends Builder implements CMLConstants {

    /**
     * Constructs a XOM builder using the (subclassed) CML node factory
     */
    public CMLBuilder() {
        this(CMLNodeFactory.nodeFactory);
    }
    

    /**
     * Constructs a XOM builder using the (subclassed) CML node factory
     * 
     * @param validate
     *            if true
     */
    public CMLBuilder(boolean validate) {
        this(validate, CMLNodeFactory.nodeFactory);
    }

    /**
     * Constructs a XOM builder using the passed node factory
     * 
     * @param nodeFactory
     *            to construct builder with
     */
    public CMLBuilder(NodeFactory nodeFactory) {
        super(nodeFactory);
    }

    /**
     * Constructs a XOM builder using the passed node factory
     * 
     * @param validate
     *            if true
     * @param nodeFactory
     *            to construct builder with
     */
    public CMLBuilder(boolean validate, NodeFactory nodeFactory) {
        super(validate, nodeFactory);
    }

    /**
     * convenience method to parse XML string.
     * 
     * @param xmlString to parse
     * @return the root element or null
     * @throws ValidityException
     * @throws ParsingException
     * @throws IOException
     */

    public Element parseString(String xmlString) {
    	Document doc = null;
        try {
			doc = this.build(new StringReader(xmlString));
		} catch (IOException e) {
			throw new RuntimeException("BUG ", e);
		} catch (Exception e) {
			throw new RuntimeException("cannot parse: ", e);
		}
        return (doc == null) ? null : doc.getRootElement();
    }

    /** make sure a document has CMLNamespace if possible.
     * if document has CML namespace, returns it.
     * if document does not, converts to String and reparses it.
     * horrid hack, but that's because some people don't use namespaces.
     * @param doc
     * @return document
     */
    public static Document ensureCML(Document doc) {
    	Element root = doc.getRootElement();
		String nameURI = root.getNamespaceURI();
    	if (!CMLConstants.CML_NS.equals(nameURI)) {
    		
    		try {
	    		System.err.println("No CML namespace; munging one in");
	    		ByteArrayOutputStream ss = new ByteArrayOutputStream();
	    		CMLUtil.debug(root, ss, 0);
	    		ss.close(); 
	    		String s = ss.toString();
	    		// find first line after any declaration
	    		int idx = s.indexOf(">\n");
	    		if (s.startsWith("<?")) {
	    			idx = s.indexOf(">\n", idx);
	    		}
	    		// add namespace
	    		String sss = s.substring(0, idx) + S_SPACE+CMLConstants.CML_XMLNS +s.substring(idx);
	    		Element newRoot = new CMLBuilder().parseString(sss);
	    		doc = newRoot.getDocument();
    		} catch (Exception e) {
    			throw new RuntimeException("BUG "+e);
    		}
    	}
    	return doc;
    }
    
    /**
     * messy hack to parse document which omit CML namespace
     * @param is
     * @return doc
     * @throws IOException
     * @throws ParsingException
     */
    public Document buildEnsureCML(InputStream is) 
        throws IOException, ParsingException {
    	Document doc = super.build(is);
    	return ensureCML(doc);
    }
    
    /**
     * messy hack to parse document which omits CML namespace
     * @param reader
     * @return doc
     * @throws IOException
     * @throws ParsingException
     */
    public Document buildEnsureCML(Reader reader) 
        throws IOException, ParsingException {
    	Document doc = super.build(reader);
    	return ensureCML(doc);
    }


    // this would trap the problem silently. Is it a good idea?
    
//    public Document build(Reader reader) throws ParsingException, IOException{
//    	Document doc = super.build(reader);
//    	return ensureCML(doc);
//    }
    /**
     * Utility method that allows for convenient conversion of
     * <a href="http://www.cafeconleche.org/XOM/apidocs/index.html">XOM</a> elements to
     * CML elements if necessary.
     * always makes a copy
     *
     * @param xml a valid CMLElement
     * @return the {@link CMLElement}
     */
    public static CMLElement ensureCML(Element xml) {
 	   if (xml == null) {
 		   throw new RuntimeException("null cml");
 	   }
        if (xml instanceof CMLElement) {
            return (CMLElement) xml.copy();
        } else {
            Document doc = new Document((Element) xml.copy());
            try {
                Document doc2 = new CMLBuilder().build(doc.toXML(), doc.getBaseURI());
                CMLElement cmlElement = (CMLElement) doc2.getRootElement();
                return cmlElement;
            } catch (Exception e) {
                CMLUtil.debug(xml, "NON-XML");
                throw new RuntimeException(e);
            }
       }
    }


}
