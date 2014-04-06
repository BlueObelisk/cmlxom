package org.xmlcml.cml.element;

public interface CMLAxis {

	enum AxisType {
		X,
		Y,
		Z
	}
	void setMultiplierToData(double m);
	void setConstantToData(double c);
	AxisType getAxisType();
	void addArray(AbstractArray array);
}
