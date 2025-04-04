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

package org.xmlcml.cml.element;

import java.util.ArrayList;
import java.util.List;

import nu.xom.Element;

import org.xmlcml.cml.base.CMLElement;
import org.xmlcml.cml.base.CMLElements;

/**
 * A set of 3 cell parameters.
 *
 *
 * Either 3 lengths or 3 angles.
 *
 * user-modifiable class autogenerated from schema if no class exists use as a
 * shell which can be edited the autogeneration software will not overwrite an
 * existing class file
 *
 */
public class CMLCellParameter extends AbstractCellParameter {

	/** namespaced element name.*/
	public final static String NS = C_E+TAG;

    /** type of cellParameter */
    public enum Type {
        /** three lengths */
        LENGTH("length"),
        /** three angles */
        ANGLE("angle");
        /** value for comparison */
        public final String s;

        Type(String s) {
            this.s = s;
        }
    }

    /**
     * dictRef attributes for obsolete cell parameters. do not use these if
     * possible. cellParameter has replaced this
     */
    public final static String[] dictRef = { CMLCrystal.A, CMLCrystal.B, CMLCrystal.C,
            CMLCrystal.ALPHA, CMLCrystal.BETA, CMLCrystal.GAMMA, };

    /**
     * constructor
     */

    public CMLCellParameter() {
    }

    /**
     * copy constructor
     *
     * @param old
     *            CMLCellParameter to copy
     */
    public CMLCellParameter(CMLCellParameter old) {
        super((AbstractCellParameter) old);
    }

    /**
     * copy node .
     *
     * @return Node
     */
    public Element copy() {
        return new CMLCellParameter(this);
    }

    /**
     * create new instance in context of parent, overridable by subclasses.
     *
     * @param parent
     *            parent of element to be constructed (ignored by default)
     * @return CMLCellParameter
     */
    public CMLElement makeElementInContext(Element parent) {
        return new CMLCellParameter();
    }

    /**
     * constructor from 3 CMLScalar of correct type.
     *
     * @param scalar
     * @param type
     */
    public CMLCellParameter(CMLScalar[] scalar, Type type) {
        this();
        if (scalar == null || scalar.length != 3) {
            throw new RuntimeException("bad args to constructor" + scalar);
        }
        double[] values = new double[3];
        String units = null;
        double[] error = new double[3];
        boolean hasError = false;
        for (int i = 0; i < 3; i++) {
            values[i] = scalar[i].getDouble();
            if (units == null) {
                units = scalar[i].getUnits();
            }
            error[i] = Double.NaN;
            if (scalar[i].getErrorValueAttribute() != null) {
                error[i] = scalar[i].getErrorValue();
                hasError = true;
            }
        }
        if (units != null) {
            this.setUnits(units);
        }
        if (hasError) {
            this.setError(error);
        }
        if (type == null) {
            throw new RuntimeException("Null type");
        } else if (type.equals(Type.LENGTH) || type.equals(Type.ANGLE)) {
            this.setType(type.s);
            this.setXMLContent(values);
        }

    }

    /**
     * constructor from 3 CMLScalar of correct type.
     *
     * @param scalar
     * @param type
     */
    public CMLCellParameter(List<CMLScalar> scalar, Type type) {
        this((CMLScalar[]) scalar.toArray(new CMLScalar[0]), type);
    }

    /**
     * extracts cellParameter of given type.
     *
     * @param cellParameters
     *            array of length 2 with lengths and angles (any order). MUST
     *            have both this list is what is normally returned by accessing
     *            the XOM
     * @param type
     *            of parameter
     * @return the cellParameter (or null if not found or corrupt
     *         cellParameters)
     */
    public static CMLCellParameter getCellParameter(
            List<CMLCellParameter> cellParameters, Type type) {
        CMLCellParameter cellParameter = null;
        if (cellParameters != null && cellParameters.size() == 2) {
            CMLCellParameter length = null;
            CMLCellParameter angle = null;
            for (CMLCellParameter cellP : cellParameters) {
                if (Type.LENGTH.s.equals(cellP.getType())) {
                    length = cellP;
                } else if (Type.ANGLE.s.equals(cellP.getType())) {
                    angle = cellP;
                } else if (cellP.getType() == null) {
                    throw new RuntimeException(
                            "cellParameter requires type attribute");
                } else {
                    throw new RuntimeException("unknown type on cellParameter: "
                            + cellP.getType());
                }
            }
            if (length != null && angle != null) {
                cellParameter = (Type.LENGTH.equals(type)) ? length : angle;
            }
        }
        return cellParameter;
    }

    /**
     * extracts cellParameter of given type.
     *
     * @param cellParameters
     *            array of length 2 with lengths and angles (any order). MUST
     *            have both this list is what is normally returned by accessing
     *            the XOM
     * @param type
     *            of parameter
     * @return the cellParameter (or null if not found or corrupt
     *         cellParameters)
     */
    public static CMLCellParameter getCellParameter(
            CMLElements<CMLCellParameter> cellParameters, Type type) {
        List<CMLCellParameter> cellParams = new ArrayList<CMLCellParameter>();
        for (CMLCellParameter cellParam : cellParameters) {
            cellParams.add(cellParam);
        }
        return getCellParameter(cellParams, type);
    }

    /**
     * gets CMLScalar representation from valid cellParameters.
     *
     * @param cellParameterElements
     *            must be exactly one each of length and angle
     * @return the 6 cell parameters in order a,b,c,alpha,beta,gamma
     */
    public static List<CMLScalar> createCMLScalars(
            List<CMLCellParameter> cellParameterElements) {
        List<CMLScalar> cellParams = new ArrayList<CMLScalar>();
        CMLCellParameter length = CMLCellParameter.getCellParameter(
                cellParameterElements, CMLCellParameter.Type.LENGTH);
        CMLCellParameter angle = CMLCellParameter.getCellParameter(
                cellParameterElements, CMLCellParameter.Type.ANGLE);
        if (length != null && angle != null) {
            double[] error = length.getError();
            for (int i = 0; i < 3; i++) {
                cellParams.add(CMLCrystal.createScalar(dictRef[i], length
                        .getXMLContent()[i], length.getUnits(),
                        (error == null) ? Double.NaN : error[i]));
            }
            error = angle.getError();
            for (int i = 3; i < 6; i++) {
                cellParams.add(CMLCrystal.createScalar(dictRef[i], angle
                        .getXMLContent()[i - 3], angle.getUnits(),
                        (error == null) ? Double.NaN : error[i - 3]));
            }
        }
        return cellParams;
    }

    /**
     * gets CMLScalar representation from valid cellParameters.
     *
     * @param cellParameterElements
     *            must be exactly one each of length and angle
     * @return the 6 cell parameters in order a,b,c,alpha,beta,gamma
     */
    public static List<CMLScalar> createCMLScalars(
            CMLElements<CMLCellParameter> cellParameterElements) {
    	if (cellParameterElements.size() != 2) {
    		throw new RuntimeException("must have exactly 2 CellParameterElements");
    	}
    	String type0 = cellParameterElements.get(0).getType();
    	String type1 = cellParameterElements.get(1).getType();
        List<CMLCellParameter> cellParams = new ArrayList<CMLCellParameter>();
        if (Type.LENGTH.toString().equalsIgnoreCase(type0) && Type.ANGLE.toString().equalsIgnoreCase(type1)) {
            cellParams.add(cellParameterElements.get(0));
            cellParams.add(cellParameterElements.get(1));
        } else if (Type.ANGLE.toString().equalsIgnoreCase(type0) && Type.LENGTH.toString().equalsIgnoreCase(type1)) {
            cellParams.add(cellParameterElements.get(1));
            cellParams.add(cellParameterElements.get(0));
        } else {
        	throw new RuntimeException("Bad CellParameters");
        }
        return createCMLScalars(cellParams);
    }
}
