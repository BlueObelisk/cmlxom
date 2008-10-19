package org.xmlcml.cml.command;

import static org.xmlcml.cml.base.CMLConstants.CML_NS;
import static org.xmlcml.euclid.EuclidConstants.S_EMPTY;
import nu.xom.Attribute;
import nu.xom.Element;

public class Handle {
	protected Element element;
	protected ElementNG elementNG;
	
	Handle() {
	}
	
	Handle(Element element) {
		this.element = element;
		ensureElementNG();
	}
	
	public Element getElement() {
		return element;
	}
	
	void ensureElementNG() {
		if (elementNG == null) {
			elementNG = ElementNG.ELEMENTMAP.get(element.getLocalName());
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((element == null) ? 0 : element.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Handle other = (Handle) obj;
		if (element == null) {
			if (other.element != null)
				return false;
		} else if (!element.equals(other.element))
			return false;
		return true;
	}	
	
	public void unsetAttribute(String name) {
		Attribute attribute = this.element.getAttribute(name);
		if (attribute != null) {
			attribute.detach();
		}
	}
	
	public void unsetAttribute(String name, String namespace) {
		Attribute attribute = this.element.getAttribute(name, namespace);
		if (attribute != null) {
			attribute.detach();
		}
	}
	
	public void setAttribute(String name, String value) {
		AttributeNG attribute = AttributeNG.ATTRIBUTEMAP.get(name);
		if (attribute == null) {
			throw new RuntimeException("Unknown attribute name: "+name);
		}
		if (!elementNG.getAllowedAttributeList().contains(attribute)) {
			throw new RuntimeException(attribute.getName()+" attribute not allowed on: "+elementNG.getLocalName());
		}
		attribute.validate(value);
		this.element.addAttribute(new Attribute(name, value));
	}
		
	public void setAttribute(String name, String namespace, String value) {
		if (CML_NS.equals(namespace) || namespace.equals(S_EMPTY)) {
			AttributeNG attribute = AttributeNG.ATTRIBUTEMAP.get(name);
			if (attribute == null) {
				throw new RuntimeException("Unknown attribute name: "+name);
			}
			attribute.validate(value);
			this.element.addAttribute(new Attribute(name, value));
		} else {
			this.element.addAttribute(new Attribute(name, namespace, value));
		}
	}
	
	public void appendChild(Handle childHandle) {
		Element childElement = childHandle.element;
		ElementNG childElementNG = ElementNG.ELEMENTMAP.get(childElement.getLocalName());
		String childName = childElement.getLocalName();
		ElementNG elementNG = ElementNG.ELEMENTMAP.get(this.element.getLocalName());
		if (elementNG != null && 
			(elementNG.getAllowedElementList().contains(childElementNG) ||
			elementNG.getAllowedElementList().contains(ElementNG.ANY))) {
			this.element.appendChild(childElement);
		} else {
			throw new RuntimeException("Cannot add element "+childName+" to "+elementNG.getLocalName());
		}
	}
	
	
}
