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

package org.xmlcml.molutil;

import java.util.ArrayList;

import java.util.List;

import org.apache.log4j.Logger;
import org.xmlcml.cml.base.CMLConstants;
import org.xmlcml.euclid.EuclidRuntimeException;
import org.xmlcml.euclid.Point3;
import org.xmlcml.euclid.Vector3;

/**
 * utilities for molecular operations
 *
 * @author pm286
 *
 */
public abstract class Molutils extends java.lang.Object implements CMLConstants {

    final static Logger logger = Logger.getLogger(Molutils.class.getName());

    /**
     * trigonal angle in radians
     */
    public final static double TRIGONAL_ANGLE = 2.0 * Math.acos(1.0 / 2.0);

    /**
     * tetrahedral angle in radians
     */
    public final static double TETRAHEDRAL_ANGLE = 2.0 * Math.acos(1.0 / Math
            .sqrt(3.0));

    /**
     * default geometry
     */
    public final static int DEFAULT = 0;

    /**
     * no specified geometry
     */
    public final static int ANY = 1;

    /**
     * linear
     */
    public final static int LINEAR = 2;

    /**
     * trigonal planar
     */
    public final static int TRIGONAL = 3;

    /**
     * tetrahedral
     */
    public final static int TETRAHEDRAL = 4;

    /**
     * calculates bondlength. uses sum of covalent radii. if covalent radii
     * cannot be found, use bond length of 1.0
     *
     * @param el1
     *            element
     * @param el2
     *            element
     * @return length
     */
    public static double getBondLength(ChemicalElement el1, ChemicalElement el2) {
        double d1 = el1.getCovalentRadius();
        double d2 = el2.getCovalentRadius();
        // in case we have no covalent radii, set to 1.0
        return (d1 < 0.1 || d2 < 0.1) ? 1.0 : d1 + d2;
    }

    /**
     * Calculates substituent points. Calculate substituent points for (0) zero
     * ligands of aPoint. The resultant points are randomly oriented: (i) 1
     * points required; +x,0,0 (ii) 2 points: use +x,0,0 and -x,0,0 (iii) 3
     * points: equilateral triangle in xy plane (iv) 4 points x,x,x, x,-x,-x,
     * -x,x,-x, -x,-x,x where 3x**2 = bond length
     *
     * @param aPoint
     *            to which substituents are added
     * @param geometry
     *            from: ANY, LINEAR, TRIGONAL, TETRAHEDRAL
     * @param length
     *            from aPoint
     *
     * @throws EuclidRuntimeException
     * @return Point3[] ANY => 1, LINEAR => 2, TRIGONAL => 3, TETRAHEDRAL => 4
     */
    public static List<Point3> calculate3DCoordinates0(Point3 aPoint,
            int geometry, double length) throws EuclidRuntimeException {
        if (geometry < ANY || geometry > TETRAHEDRAL) {
            throw new EuclidRuntimeException("Unknown value of geometry: " + geometry);
        }
        List<Point3> points = new ArrayList<Point3>(geometry);
        if (geometry == ANY) {
            points.add(new Point3(aPoint)
                    .plus(new Vector3(length, 0.0, 0.0)));
        } else if (geometry == LINEAR) {
            points.add(new Point3(aPoint)
                    .plus(new Vector3(length, 0.0, 0.0)));
            points.add(new Point3(aPoint)
                    .plus(new Vector3(-length, 0.0, 0.0)));
        } else if (geometry == TRIGONAL) {
            points.add(new Point3(aPoint)
                    .plus(new Vector3(length, 0.0, 0.0)));
            points.add(new Point3(aPoint).plus(new Vector3(-length * 0.5,
                    -length * 0.5 * Math.sqrt(3.0), 0.0f)));
            points.add(new Point3(aPoint).plus(new Vector3(-length * 0.5,
                    length * 0.5 * Math.sqrt(3.0), 0.0f)));
        } else if (geometry == TETRAHEDRAL) {
            double dx = length / Math.sqrt(3.0);
            points.add(new Point3(aPoint).plus(new Vector3(dx, dx, dx)));
            points.add(new Point3(aPoint).plus(new Vector3(dx, -dx, -dx)));
            points.add(new Point3(aPoint).plus(new Vector3(-dx, -dx, dx)));
            points.add(new Point3(aPoint).plus(new Vector3(-dx, dx, -dx)));
        }
        return points;
    }

    /**
     * Calculate new point(s) X in a B-A system to form B-A-X. Use C as
     * reference for * staggering about the B-A bond the X-A-B-C angle is 2*pi
     *
     * (1a) 1 ligand(B) of refAtom (A) which itself has a ligand (C) (i) 1
     * points required; vector along AB vector (ii) 2 points: 2 vectors in ABC
     * plane, staggered and eclipsed wrt C (iii) 3 points: 1 staggered wrt C,
     * the others +- gauche wrt C If C is null, a random non-colinear C is
     * generated
     *
     * Note: If a pyramidal geometry (e.g. for C-N(-H)-H) is wanted, use
     * TETRAHEDRAL and the user must decide which point(s) to use
     *
     * @param aPoint
     *            to which substituents are added
     * @param bPoint
     *            reference ligand
     * @param cPoint
     *            further ligand of bPoint to generate stagger
     * @param geometry
     *            from: LINEAR, TRIGONAL, TETRAHEDRAL
     * @param length
     *            A-X length
     * @param angle
     *            B-A-X angle in radians
     *
     * @throws EuclidRuntimeException
     * @return Point3d[] nwanted points (or zero if failed)
     */
    public static List<Point3> calculate3DCoordinates1(Point3 aPoint,
            Point3 bPoint, Point3 cPoint, int geometry, double length,
            double angle) throws EuclidRuntimeException {
        if (geometry < LINEAR || geometry > TETRAHEDRAL) {
            throw new EuclidRuntimeException("Unknown value of geometry: " + geometry);
        }
        List<Point3> points = new ArrayList<Point3>(geometry - 1);
        // BA vector
        Vector3 ba = new Vector3(aPoint).subtract(new Vector3(bPoint))
                .normalize();
        if (geometry == LINEAR) {
            Vector3 ax = ba.multiplyBy(length);
            points.add(0, aPoint.plus(ax));
        } else {
            // if no cPoint, generate a random reference
            if (cPoint == null) {
                cPoint = new Point3(ba.getNonColinearVector());
            }
            // CB vector
            Vector3 cb = new Vector3(bPoint).subtract(new Vector3(cPoint))
                    .normalize();
            // if A, B, C colinear, replace C by random point
            if (cb.isColinearVector(ba)) {
                Vector3 cVector = ba.getNonColinearVector();
                cPoint = new Point3(cVector);
                cb = new Vector3(bPoint).subtract(new Vector3(cPoint));
            }
            // cbxba = c x b
            Vector3 cbxba = cb.cross(ba).normalize();
            // create three perp axes ba, cbxba, and ax
            Vector3 ax = ba.cross(cbxba).normalize();
            int nrot = geometry - 1;
            double drot = Math.PI * 2.0 / (double) nrot;
            Point3 temp = new Point3(aPoint);
            double length1 = length * Math.sin(angle);
            for (int i = 0; i < nrot; i++) {
                double rot = (double) i * drot;
                Vector3 vx = new Vector3(ba);
                vx = vx.multiplyBy(-Math.cos(angle) * length);
                Vector3 vy = new Vector3(ax);
                vy = vy.multiplyBy(Math.cos(rot) * length1);
                Vector3 vz = new Vector3(cbxba);
                vz = vz.multiplyBy(Math.sin(rot) * length1);
                points.add(i, temp.subtract(vx).subtract(vy).subtract(vz));
            }
        }
        return points;
    }

    /**
     * Calculate new point(s) X in a B-A-C system. It forms form a B-A(-C)-X
     * system.
     *
     * (2) 2 ligands(B, C) of refAtom A (i) 1 points required; vector in ABC
     * plane bisecting AB, AC. If ABC is linear, no points (ii) 2 points: 2
     * points X1, X2, X1-A-X2 = angle about 2i vector
     *
     * Note: If a pyramidal geometry (e.g. for C-N(-C)-H) is wanted, use
     * TETRAHEDRAL
     *
     * @param aPoint
     *            to which substituents are added
     * @param bPoint
     *            first ligand of A
     * @param cPoint
     *            second ligand of A
     * @param geometry
     *            from: TRIGONAL, TETRAHEDRAL
     * @param length
     *            A-X length
     * @param angle
     *            B-A-X angle
     *
     * @throws EuclidRuntimeException
     * @return Point3d[] nwanted points (or zero if failed)
     */
    public static List<Point3> calculate3DCoordinates2(Point3 aPoint,
            Point3 bPoint, Point3 cPoint, int geometry, double length,
            double angle) throws EuclidRuntimeException {
        if (geometry < TRIGONAL || geometry > TETRAHEDRAL) {
            throw new EuclidRuntimeException("Unknown value of geometry: " + geometry);
        }
        List<Point3> points = new ArrayList<Point3>(geometry - 2);
        double ang2 = angle / 2.0;

        Vector3 ba = new Vector3(aPoint).subtract(new Vector3(bPoint));
        Vector3 ca = new Vector3(aPoint).subtract(new Vector3(cPoint));
        Vector3 baxca = ba.cross(ca);
        if (ba.isColinearVector(ca)) {
        } else if (geometry == TRIGONAL) {
            Vector3 ax = new Vector3(ba).plus(ca).normalize()
                    .multiplyBy(length);
            points.add(0, new Point3(aPoint).plus(ax));
        } else if (geometry == TETRAHEDRAL) {
            baxca = baxca.normalize().multiplyBy(Math.sin(ang2) * length);
            Vector3 ax = new Vector3(ba).plus(ca).normalize().multiplyBy(
                    Math.cos(ang2) * length);
            Point3 temp = new Point3(aPoint).subtract(ax);
            points.add(0, temp.plus(baxca));
            points.add(1, temp.subtract(baxca));
        }
        return points;
    }

    /**
     * Calculate new point X in a B-A(-D)-C system. It forms a B-A(-D)(-C)-X
     * system.
     *
     * (3) 3 ligands(B, C, D) of refAtom A (i) 1 points required; if A, B, C, D
     * coplanar, no points. else vector is resultant of BA, CA, DA
     *
     * @param aPoint
     *            to which substituents are added
     * @param bPoint
     *            first ligand of A
     * @param cPoint
     *            second ligand of A
     * @param dPoint
     *            third ligand of A
     * @param length
     *            A-X length
     *
     * @return required point (or null if failed (coplanar))
     */
    public static Point3 calculate3DCoordinates3(Point3 aPoint, Point3 bPoint,
            Point3 cPoint, Point3 dPoint, double length) {
        Vector3 v1 = new Vector3(aPoint).subtract(new Vector3(bPoint));
        Vector3 v2 = new Vector3(aPoint).subtract(new Vector3(cPoint));
        Vector3 v3 = new Vector3(aPoint).subtract(new Vector3(dPoint));
        // FIXME Vector3 vector = new Vector3(bPoint).plus(new
        // Vector3(cPoint)).plus(new Vector3(dPoint));
        Vector3 v = new Vector3(v1).plus(new Vector3(v2)).plus(new Vector3(v3));
        if (v.getLength() < 0.00001) {
            return null;
        }
        v = v.normalize().multiplyBy(length);
        Point3 point = new Point3(aPoint).plus(v);
        return point;
    }

    /**
     * tests the calculation of ligand coordinates
     */
    public static void testCalculate3DCoordinates() {

        logger.info("\nadd ligand coordinates...\n");
        final Point3 pZero = new Point3(10., 10., 10.);
        final Point3 pOne = new Point3(8., 10., 10.);
        final Point3 pStaggered = new Point3(8., 8., 10.);
        final Point3 pTwoa = new Point3(9., 9., 10.);
        final Point3 pTwob = new Point3(9., 11., 10.);
        final Point3 pThreea = new Point3(9., 9., 11.);
        final Point3 pThreeb = new Point3(9., 11., 9.);
        final Point3 pThreec = new Point3(11., 9., 9.);
        double length = 1.5;
        double angle = TETRAHEDRAL_ANGLE;
        double angles[] = { TETRAHEDRAL_ANGLE, TRIGONAL_ANGLE,
                TETRAHEDRAL_ANGLE, };

        logger.info("\n\nadd ligands to atom with no ligands");
        logger.info("add ligands to: " + pZero + "; length: " + length
                + "; angle: " + angle);
        for (int geometry = ANY; geometry <= TETRAHEDRAL; geometry++) {
            logger.info("\nType of geometry: " + geometry + CMLConstants.S_COLON);
            try {
                List<Point3> ligands = calculate3DCoordinates0(pZero, geometry,
                        length);
                for (int i = 0; i < ligands.size(); i++) {
                    logger.info("...ligand:" + ligands.get(i));
                }
            } catch (EuclidRuntimeException e) {
                logger.info("Exception: " + e);
            }
        }

        logger.info("\n\nadd ligands to atom with one ligand");
        logger.info("add ligands to: " + pZero + "; length: " + length
                + "; angle: " + angle);
        logger.info("reference atom: " + pOne);
        for (int geometry = LINEAR; geometry <= TETRAHEDRAL; geometry++) {
            logger.info("\nType of geometry: " + geometry + CMLConstants.S_COLON);
            List<Point3> ligands = calculate3DCoordinates1(pZero, pOne,
                    pStaggered, geometry, length, angles[geometry - 2]);
            for (int i = 0; i < ligands.size(); i++) {
                logger.info("...ligand:" + ligands.get(i));
            }
            for (int i = 0; i < ligands.size(); i++) {
                logger.info("distance: ref-" + i + " = "
                        + ligands.get(i).getDistanceFromPoint(pZero));
            }
            for (int i = 0; i < ligands.size(); i++) {
                for (int j = i + 1; j < ligands.size(); j++) {
                    logger.info("angle: "
                            + i
                            + "-ref-"
                            + j
                            + " = "
                            + Point3.getAngle(ligands.get(i), pZero,
                                    ligands.get(j)));
                }
                logger.info("angle: lig-ref-refa = "
                        + Point3.getAngle(ligands.get(i), pZero, pOne));
            }
            for (int i = 0; i < ligands.size(); i++) {
                logger.info("torsion: "
                        + i
                        + "-ref-ref1-ref2 = "
                        + Point3.getTorsion(ligands.get(i), pZero, pOne,
                                pStaggered));
            }
        }

        logger.info("\n\nadd ligands to atom with two ligands");
        logger.info("add ligands to: " + pZero + "; length: " + length
                + "; angle: " + angle);
        logger.info("reference atoms: " + pTwoa + CMLConstants.S_SLASH + pTwob);
        for (int geometry = TRIGONAL; geometry <= TETRAHEDRAL; geometry++) {
            logger.info("\nType of geometry: " + geometry + CMLConstants.S_COLON);
            List<Point3> ligands = calculate3DCoordinates2(pZero, pTwoa,
                    pTwob, geometry, length, angles[geometry - 2]);
            for (int i = 0; i < ligands.size(); i++) {
                logger.info("...ligand:" + ligands.get(i));
            }
            for (int i = 0; i < ligands.size(); i++) {
                logger.info("distance: ref-" + i + " = "
                        + ligands.get(i).getDistanceFromPoint(pZero));
            }
            for (int i = 0; i < ligands.size(); i++) {
                for (int j = i + 1; j < ligands.size(); j++) {
                    logger.info("angle: "
                            + i
                            + "-ref-"
                            + j
                            + " = "
                            + Point3.getAngle(ligands.get(i), pZero,
                                    ligands.get(j)));
                }
                logger.info("angle: lig-ref-refa = "
                        + Point3.getAngle(ligands.get(i), pZero, pTwoa));
                logger.info("angle: lig-ref-refb = "
                        + Point3.getAngle(ligands.get(i), pZero, pTwob));
            }
        }

        logger.info("\n\nadd ligand to atom with three ligands");
        logger.info("reference atoms: " + pThreea + CMLConstants.S_SLASH + pThreeb + CMLConstants.S_SLASH
                + pThreec);
        Point3 ligand = calculate3DCoordinates3(pZero, pThreea, pThreeb,
                pThreec, length);
        logger.info("Ligand: " + ligand);
        logger
                .info("distance: ref-lig = "
                        + ligand.getDistanceFromPoint(pZero));
        logger.info("angle: lig-ref-refa = "
                + Point3.getAngle(ligand, pZero, pThreea));
        logger.info("angle: lig-ref-refb = "
                + Point3.getAngle(ligand, pZero, pThreeb));
        logger.info("angle: lig-ref-refc = "
                + Point3.getAngle(ligand, pZero, pThreec));
    }

    /**
     * main.
     *
     * @param args
     */
    public static void main(String[] args) {
        logger.info("Runs tests...");
        testCalculate3DCoordinates();
    }

}
