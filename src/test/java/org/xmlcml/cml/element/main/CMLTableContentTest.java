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

/**
 * 
 */
package org.xmlcml.cml.element.main;

import org.junit.Before;
import org.junit.Test;
import org.xmlcml.euclid.test.StringTestBase;

/**
 * @author pm286
 *
 */
public class CMLTableContentTest extends AbstractTableBase {

    /** set up.
     */
    @Before
    public void makeContent() {
    }
    /**
     * Test method for {@link org.xmlcml.cml.element.CMLTableContent#getStrings()}.
     */
    @Test
    public final void testGetStrings() {
        String[] ss = tableContent.getStrings();
        StringTestBase.assertEquals("strings", 
                new String[]{"1", "a", "2", "b", "3", "c"}, ss);
    }


}
