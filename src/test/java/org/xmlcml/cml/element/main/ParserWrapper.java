/**
 *    Copyright 2011 Peter Murray-Rust et. al.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package org.xmlcml.cml.element.main;

import nu.xom.Document;
import nu.xom.Text;

import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;

/**
 * Encapsulates a DOM parser.
 * 
 * @version $Id: ParserWrapper.java 213 2007-01-02 19:06:36Z petermr $
 */
public interface ParserWrapper {

    //
    // ParserWrapper methods
    //

    /**
     * Parses the specified URI and returns the document.
     * 
     * @param uri
     * @return document
     * @throws Exception
     */

    public Document parse(String uri) throws Exception;

    /**
     * Set the state of a feature.
     * 
     * Set the state of any feature in a SAX2 parser. The parser might not
     * recognize the feature, and if it does recognize it, it might not be able
     * to fulfill the request.
     * 
     * @param featureId
     *            The unique identifier (URI) of the feature.
     * @param state
     *            The requested state of the feature (true or false).
     * 
     * @exception org.xml.sax.SAXNotRecognizedException
     *                If the requested feature is not known.
     * @exception org.xml.sax.SAXNotSupportedException
     *                If the requested feature is known, but the requested state
     *                is not supported.
     * @exception org.xml.sax.SAXNotRecognizedException
     *                If there is any other problem fulfilling the request.
     */
    public void setFeature(String featureId, boolean state)
            throws SAXNotRecognizedException, SAXNotSupportedException;

    /**
     * Returns the document information.
     * 
     * @return info
     */
    public DocumentInfo getDocumentInfo();

    //
    // Interfaces
    //

    /**
     * This interface is here to query information about the document
     * implementation returned by the <code>ParserWrapper#parse</code> method.
     * 
     * @author Andy Clark, IBM
     */
    public interface DocumentInfo {

        //
        // DocumentInfo methods
        //

        /**
         * Returns true if the specified text node is ignorable whitespace.
         * 
         * @param text
         * @return ignorable
         * 
         */
        public boolean isIgnorableWhitespace(Text text);

    } // interface DocumentInfo

} // interface ParserWrapper
