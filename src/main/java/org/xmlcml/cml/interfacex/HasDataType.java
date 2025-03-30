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

package org.xmlcml.cml.interfacex;

/**
 * attached to elements that can carry dataType. 
 * examples are scalar, array, matrix
 * 
 * @author pmr
 * 
 */
public interface HasDataType extends HasDictRef {

    /**
     * Sets value on dataType attribute. example: <code>setDataType("xsd:double");</code>
     * 
     * @param type type of data
     */
    void setDataType(String type);

    /**
     * Gets value on dataType attribute. example: <code>setDataType("xsd:double");</code>
     * 
     * @return type type of data
     */
    String getDataType();

    /**
     * Gets value of element/
     * 
     * @return data returns the XML as a String
     */
    String getXMLContent();

    /**
     * Sets value of element.
     * 
     * @param content sets the XML content
     */
    void setXMLContent(String content);

}