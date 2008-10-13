package org.xmlcml.cml.element.main;

import org.junit.Test;

/** tests CMLJoin.
 * 
 * @author pm286
 *
 */
public class CMLJoinTest extends AbstractTest {

    /** set up.
     * @exception Exception
     */
    @Test
    public void setUp() throws Exception {
        super.setUp();
    }
    
//    /** Test method for 'org.xmlcml.cml.element.CMLJoin.joinAtomRefs2()'
//     */
//    @Test
//    @Ignore
//    public void testJoinAtomRefs2() {
//        CMLMolecule peo0Mol = null;
//        try {
//            InputStream in = Util.getInputStreamFromResource(
//                    COMPLEX_RESOURCE + U_S +"peo0mid.xml");
//            peo0Mol = (CMLMolecule) new CMLBuilder().build(in).getRootElement();
//            in.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new RuntimeException("EXC"+e);
//        }
//        CMLElements<CMLJoin> joinList = peo0Mol.getJoinElements();
//        Assert.assertEquals("joins ", 4, joinList.size());
////        int i = 0;
////        for (CMLJoin join : joinList) {
////            ++i;
////            System.out.println("==========="+i);
////            boolean takeAtomWithLowestId = true;
////            join.joinByAtomRefs2AndAdjustGeometry(takeAtomWithLowestId);
////            System.out.println("===================="+i);
////        }
//    }
//
//    /** Test method for 'org.xmlcml.cml.element.CMLJoin.joinAtomRefs2()'
//     */
//    @Test
//    public void testJoinAtomRefs21() {
//        CMLMolecule peo1Mol = null;
//        try {
//            InputStream in =Util.getInputStreamFromResource(
//                    EXPERIMENTAL_RESOURCE+U_S+"peo1mid.xml");
//            peo1Mol = (CMLMolecule) new CMLBuilder().build(in).getRootElement();
//            in.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new RuntimeException("EXC",e);
//        }
//        CMLElements<CMLJoin> joinList = peo1Mol.getJoinElements();
//        Assert.assertEquals("joins ", 4, joinList.size());
////        int i = 0;
////        for (CMLJoin join : joinList) {
////            ++i;
////            boolean takeAtomWithLowestId = true;
////            join.joinByAtomRefs2AndAdjustGeometry(takeAtomWithLowestId);
////        }
//    }

}
