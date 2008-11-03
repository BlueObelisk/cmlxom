/**
 * 
 */
package org.xmlcml.cml.element.main;

import org.junit.Before;
import org.junit.Test;
import org.xmlcml.cml.element.CMLTableContent;
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
