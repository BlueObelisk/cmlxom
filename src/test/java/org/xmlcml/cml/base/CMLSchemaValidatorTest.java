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

package org.xmlcml.cml.base;

import java.io.IOException;
import java.io.StringReader;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author pm286
 *
 */
public class CMLSchemaValidatorTest {

//	/**
//	 * 
//	 * @throws IOException
//	 */
//    @Test
//    @ I gnore // this is a mess anyway
//    public void testCMLSchemaValidatorSuccess() throws IOException {
//        String cml = "<molecule id='m1' xmlns='" + CMLConstants.CML_NS + "' />";
//        try {
//            CMLSchemaValidator.getInstance().validateCML(new StringReader(cml));
//        } catch (CMLException e) {
//            Assert.fail("failed to validate"+e);
//        }
//    }

    /** 
     * @exception IOException
     */
    @Test
    public void testCMLSchemaValidatorFailure() throws IOException {
        String cml = "<molecule id='m1' xmlns='" + CMLConstants.CML_NS + "' foo='bar' />";
        try {
            CMLSchemaValidator.getInstance().validateCML(new StringReader(cml));
            Assert.fail("failed to validate");
        } catch (Exception e) {
            // PASS
        }
    }

}
