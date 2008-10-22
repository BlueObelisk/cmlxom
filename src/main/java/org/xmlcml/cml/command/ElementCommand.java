package org.xmlcml.cml.command;

import static org.xmlcml.cml.base.CMLConstants.CML_NS;
import static org.xmlcml.cml.base.CMLConstants.CML_XPATH;

import java.io.StringReader;

import nu.xom.Element;
import nu.xom.Nodes;

import org.xmlcml.cml.base.CMLConstants;
import org.xmlcml.cml.base.CMLNodeFactory;

public class ElementCommand extends JumboCommand {
	
	ElementCommand() {
		
	}
	
	public Handle readCML(String s) {
		return readXML(s, null);
	}
	
	public Handle readXML(String s, String xpath) {
		Element xomElement = null;
		try {
			xomElement = CML_BUILDER.build(new StringReader(s)).getRootElement();
			if (xpath != null) {
				Nodes nodes = xomElement.query(xpath, CML_XPATH);
				if (nodes.size() == 0) {
					throw new RuntimeException("expected at least one node from xpath");
				} else {
					xomElement = (Element) xomElement.query(xpath, CML_XPATH).get(0);
				}
			}
		} catch (Exception e) {
			throw new RuntimeException("Cannot parse xml", e);
		}
		checkElementName(xomElement);
		handle.element = xomElement;
		return handle;
	}
	
	private void checkElementName(Element xomElement) {
		String name = xomElement.getLocalName();
		String namespace = xomElement.getNamespaceURI();
		if (CML_NS.equals(namespace)) {
		} else if (ElementNG.ELEMENTMAP.containsKey(name)) {
			throw new RuntimeException("element should have CML namespace: "+name);
		}
		checkElementName(name);
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
		handle.elementNG = ElementNG.ELEMENTMAP.get(elementName);
		if (handle.elementNG == null) {
			throw new RuntimeException("unknown element: "+elementName);
		}
	}
	
	public void unsetAttribute(String name) {
		handle.unsetAttribute(name);
	}
	
	public void unsetAttribute(String name, String namespace) {
		handle.unsetAttribute(name, namespace);
	}
	
	public void setAttribute(String name, String value) {
		handle.setAttribute(name, value);
	}
		
	public void setAttribute(String name, String namespace, String value) {
		handle.setAttribute(name, namespace, value);
	}
	
	public void appendChild(Handle childHandle) {
		this.handle.appendChild(childHandle);
	}
	
	public void detach() {
		handle.element.detach();
	}
}
