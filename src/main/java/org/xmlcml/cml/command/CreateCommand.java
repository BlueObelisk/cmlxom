package org.xmlcml.cml.command;

import static org.xmlcml.cml.base.CMLConstants.CML_NS;
import static org.xmlcml.cml.base.CMLConstants.CML_XPATH;

import java.io.StringReader;

import nu.xom.Element;
import nu.xom.Nodes;

import org.xmlcml.cml.base.CMLConstants;
import org.xmlcml.cml.base.CMLNodeFactory;
import org.xmlcml.cml.schema.ElementSpecification;

public class CreateCommand extends JumboCommand {
	
	CreateCommand() {
		
	}
	
	
	public Handle createElement(String elementName) {
		if (elementName == null) {
			throw new RuntimeException("null element name");
		}
		checkElementName(elementName);
		try {
	        Class<?> newClass = CMLNodeFactory.makeClass(CMLConstants.ELEMENT_CLASS_BASE+CMLConstants.S_PERIOD+CMLConstants.LITE, elementName);
			handle.element = (Element) newClass.newInstance();
		} catch (Exception e) {
			throw new RuntimeException("Cannot instantiate: "+elementName);
		}
		return handle;
	}
	
	private void checkElementName(String elementName) {
		handle.elementSpecification = ElementSpecification.ELEMENTMAP.get(elementName);
		if (handle.elementSpecification == null) {
			throw new RuntimeException("unknown element: "+elementName);
		}
	}
	
}
