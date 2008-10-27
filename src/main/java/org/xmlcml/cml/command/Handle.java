package org.xmlcml.cml.command;

import static org.xmlcml.cml.base.CMLConstants.CML_NS;
import static org.xmlcml.euclid.EuclidConstants.S_EMPTY;

import org.xmlcml.cml.schema.AttributeSpecification;
import org.xmlcml.cml.schema.ElementSpecification;
import org.xmlcml.cml.schema.cml.lite.AnySpecification;

import nu.xom.Attribute;
import nu.xom.Element;

/**
 * Handle behaves like a CMLElement but is not subclassed
 * This is an experiment to allow description of a command languge
 * without JUMBO/CML/subclassing
 * @author pm286
 *
 */
public class Handle {
	protected Element element;
	protected ElementSpecification elementSpecification;
	
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
		if (elementSpecification == null) {
			elementSpecification = ElementSpecification.ELEMENTMAP.get(element.getLocalName());
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
		AttributeSpecification attribute = AttributeSpecification.ATTRIBUTEMAP.get(name);
		if (attribute == null) {
			throw new RuntimeException("Unknown attribute name: "+name);
		}
		if (!elementSpecification.getAllowedAttributeList().contains(attribute)) {
			throw new RuntimeException(attribute.getName()+" attribute not allowed on: "+elementSpecification.getLocalName());
		}
		attribute.validate(value);
		this.element.addAttribute(new Attribute(name, value));
	}
		
	public void setAttribute(String name, String namespace, String value) {
		if (CML_NS.equals(namespace) || namespace.equals(S_EMPTY)) {
			AttributeSpecification attribute = AttributeSpecification.ATTRIBUTEMAP.get(name);
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
		ElementSpecification childElementNG = ElementSpecification.ELEMENTMAP.get(childElement.getLocalName());
		String childName = childElement.getLocalName();
		ElementSpecification elementNG = ElementSpecification.ELEMENTMAP.get(this.element.getLocalName());
		if (!elementNG.getAllowedElementList().contains(childName) &&
			!elementNG.getAllowedElementList().contains(AnySpecification.LOCAL_NAME)) {
				throw new RuntimeException("Cannot add element "+childName+" to "+elementNG.getLocalName());
		}
// FIXME
//		if (elementNG != null && 
//			(elementNG.getAllowedElementList().contains(childElementNG) ||
//			elementNG.getAllowedElementList().contains(ElementSpecification.ANY))) {
			this.element.appendChild(childElement);
//		} else {
//			System.out.println("ALLOWED"+elementNG.getAllowedElementList().size());
//			for (ElementSpecification spec : elementNG.getAllowedElementList()) {
//				System.out.println(spec);
//			}
//			throw new RuntimeException("Cannot add element "+childName+" to "+elementNG.getLocalName());
//		}
	}
	
	
}
