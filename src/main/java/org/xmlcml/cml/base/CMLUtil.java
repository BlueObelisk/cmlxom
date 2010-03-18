package org.xmlcml.cml.base;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import nu.xom.Attribute;
import nu.xom.Builder;
import nu.xom.Comment;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Elements;
import nu.xom.Node;
import nu.xom.Nodes;
import nu.xom.ParentNode;
import nu.xom.ProcessingInstruction;
import nu.xom.Serializer;
import nu.xom.Text;
import nu.xom.XPathContext;
import nu.xom.canonical.Canonicalizer;

import org.apache.log4j.Logger;
import org.xmlcml.euclid.Util;

/**
 * 
 * <p>
 * static utilities to help manage common constructs.
 * </p>
 * 
 * @author Peter Murray-Rust
 * @version 5.0
 * 
 */
public abstract class CMLUtil implements CMLConstants {
	private static Logger LOG = Logger.getLogger(CMLUtil.class);

	// ========================== utilities ====================== //

	/**
	 * checks that name is QName.
	 * 
	 * @param name
	 *            of XMLName
	 * @throws CMLException
	 *             not colonized
	 */
	public final static void checkPrefixedName(String name) {
		if (name == null || name.indexOf(S_COLON) < 1) {
			throw new RuntimeException("Unprefixed name (" + name + S_RBRAK);
		}
	}

	/**
	 * get prefix from qualified name.
	 * 
	 * @param s
	 * @return prefix (or empty string)
	 */
	public static String getPrefix(String s) {
		int idx = s.indexOf(S_COLON);
		return (idx == -1) ? S_EMPTY : s.substring(0, idx);
	}

	/**
	 * get localName from qualified name.
	 * 
	 * @param s
	 * @return localName (or empty string)
	 */
	public static String getLocalName(String s) {
		String ss = null;
		if (s != null) {
			int idx = s.indexOf(S_COLON);
			ss = (idx == -1) ? s : s.substring(idx + 1);
		}
		return ss;
	}

	/**
	 * convenience method to extract value of exactly one node.
	 * uses element.query(xpath, xPathContext);
	 * @param element
	 * @param xpath 
	 * @param xPathContext defines prefix/namespace used in query
	 * @return value if exactly 1 node (0 or many returns null)
	 */
	public static String getSingleValue(Element element, String xpath, XPathContext xPathContext) {
		String  s = null;
		if (element == null) {
			LOG.warn("Null element");
		} else {
			Nodes nodes = element.query(xpath, xPathContext);
			s = (nodes.size() == 1) ? nodes.get(0).getValue() : null;
		}
		return s;
	}

	/**
	 * convenience method to extract value of the first of one-or-more nodes.
	 * uses element.query(xpath, xPathContext);
	 * @param element
	 * @param xpath 
	 * @param xPathContext defines prefix/namespace used in query
	 * @return value if exactly 1 node (0 or many returns null)
	 */
	public static String getFirstValue(Element element, String xpath, XPathContext xPathContext) {
		String  s = null;
		if (element == null) {
			LOG.warn("Null element");
		} else {
			Nodes nodes = element.query(xpath, xPathContext);
			s = (nodes.size() >= 1) ? nodes.get(0).getValue() : null;
		}
		return s;
	}
	
	/**
	 * convenience method to get exactly one element.
	 * uses element.query(xpath, xPathContext);
	 * @param element
	 * @param xpath 
	 * @param xPathContext defines prefix/namespace used in query
	 * @return value if exactly 1 element (0 or many returns null)
	 */
	public static Element getSingleElement(Element element, String xpath, XPathContext xPathContext) {
		Nodes nodes = element.query(xpath, xPathContext);
		return (nodes.size() == 1) ? (Element) nodes.get(0) : null;
	}
	

	
	/**
	 * convenience routine to get query CMLelements (iterating thorugh get(i) is
	 * fragile if nodes are removed)
	 * if query result is not a CMLElement it is omitted form list, so be careful
	 * 
	 * @param element
	 * @param xpath xpath relative to node
	 * @param context
	 * @return list of CMLelements - empty if none
	 */
	public static List<CMLElement> getCMLElements(Element node, String xpath,
			XPathContext context) {
		List<CMLElement> nodeList = new ArrayList<CMLElement>();
		if (node != null) {
			Nodes nodes = node.query(xpath, context);
			for (int i = 0; i < nodes.size(); i++) {
				if (nodes.get(i) instanceof CMLElement) {
					nodeList.add((CMLElement)nodes.get(i));
				}
			}
		}
		return nodeList;
	}

	/**
	 * converts an Elements to a java array. we might convert code to use
	 * Elements through later so this would be unneeded
	 * 
	 * @param elements
	 * @param obj
	 *            type of array (e.g. "new CMLAtom[0]"
	 * @return the java array 0f objects
	 */
	public final static Object[] toArray(Elements elements, Object[] obj) {
		List<Element> list = new ArrayList<Element>();
		for (int i = 0; i < elements.size(); i++) {
			list.add(elements.get(i));
		}
		return list.toArray(obj);
	}

	/**
	 * debug an element. outputs XML to sysout indent = 2
	 * 
	 * @param el
	 *            the element
	 * @deprecated use debug(el, message) instead
	 */
	public static void debug(Element el) {
		try {
			debug(el, System.out, 2);
		} catch (IOException e) {
			throw new RuntimeException("BUG " + e);
		}
	}

	/**
	 * debug an element. outputs XML to syserr
	 * 
	 * @param el
	 *            the element
	 */
	public static void debugToErr(Element el) {
		try {
			debug(el, System.err, 2);
		} catch (IOException e) {
			throw new RuntimeException("BUG " + e);
		}
	}

	/**
	 * debug an element.
	 * 
	 * @param el
	 *            the element
	 * @param os
	 *            output stream
	 * @param indent
	 *            indentation
	 * @throws IOException
	 */
	public static void debug(Element el, String message) {
		Util.println(">>>>" + message + ">>>>");
		CMLUtil.debug(el);
		Util.println("<<<<" + message + "<<<<");
	}

	/**
	 * debug an element.
	 * 
	 * @param el
	 *            the element
	 * @param os
	 *            output stream
	 * @param indent
	 *            indentation
	 * @throws IOException
	 */
	public static void debug(Element el, OutputStream os, int indent)
			throws IOException {
		Document document;
		if (el != null) {
			Node parent = el.getParent();
			if (parent instanceof Document) {
				document = (Document) parent;
			} else {
				Element copyElem = new Element(el);
				document = new Document(copyElem);
			}
			Serializer serializer = new Serializer(os, "UTF-8");
			if (indent >= 0) {
				serializer.setIndent(indent);
			}
			serializer.write(document);
		}
	}

	/**
	 * convenience method to get resource from XMLFile. the resource is packaged
	 * with the classes for distribution. typical filename is
	 * org/xmlcml/molutil/elementdata.xml for file elementdata.xml in class
	 * hierarchy org.xmlcml.molutil
	 * 
	 * @param filename
	 *            relative to current class hierarchy.
	 * @return document for resource
	 * @throws IOException
	 */
	public static Document getXMLResource(String filename) throws IOException {
		Document document = null;
		InputStream in = null;
		try {
			in = Util.getInputStreamFromResource(filename);
			document = (Document) new Builder().build(in);
		} catch (IOException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("" + e + " in " + filename);
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return document;
	}

	/**
	 * convenience routine to get child nodes (iterating through getChild(i) is
	 * fragile if children are removed)
	 * 
	 * @param el
	 *            may be null
	 * @return list of children (immutable) - empty if none
	 */
	public static List<Node> getChildNodes(Element el) {
		List<Node> childs = new ArrayList<Node>();
		if (el != null) {
			for (int i = 0; i < el.getChildCount(); i++) {
				childs.add(el.getChild(i));
			}
		}
		return childs;
	}

	/**
	 * parses XML string into element. convenience method to avoid trapping
	 * exceptions when string is known to be valid
	 * 
	 * @param xmlString
	 * @return root element
	 * @throws RuntimeException
	 */
	public static Element parseXML(String xmlString) throws RuntimeException {
		Element root = null;
		try {
			Document doc = new Builder().build(new StringReader(xmlString));
			root = doc.getRootElement();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return root;
	}

	/**
	 * parses CML string into element. convenience method to avoid trapping
	 * exceptions when string is known to be valid
	 * 
	 * @param cmlString
	 * @return root element
	 * @throws RuntimeException
	 */
	public static CMLElement parseCML(String cmlString) throws RuntimeException {
		CMLElement root = null;
		try {
			Document doc = new CMLBuilder().build(new StringReader(cmlString));
			root = (CMLElement) doc.getRootElement();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return root;
	}

	/**
	 * convenience routine to get query nodes (iterating thorugh get(i) is
	 * fragile if nodes are removed)
	 * 
	 * @param node
	 *            (can be null)
	 * @param xpath
	 *            xpath relative to node
	 * @param context
	 * @return list of nodes (immutable) - empty if none
	 */
	public static List<Node> getQueryNodes(Node node, String xpath,
			XPathContext context) {
		List<Node> nodeList = new ArrayList<Node>();
		if (node != null) {
			Nodes nodes = node.query(xpath, context);
			for (int i = 0; i < nodes.size(); i++) {
				nodeList.add(nodes.get(i));
			}
		}
		return nodeList;
	}

	/**
	 * convenience routine to get query nodes (iterating through get(i) is
	 * fragile if nodes are removed)
	 * 
	 * @param node
	 * @param xpath
	 * @return list of nodes (immutable) - empty if none or null node
	 */
	public static List<Node> getQueryNodes(Node node, String xpath) {
		List<Node> nodeList = new ArrayList<Node>();
		if (node != null) {
			Nodes nodes = node.query(xpath);
			for (int i = 0; i < nodes.size(); i++) {
				nodeList.add(nodes.get(i));
			}
		}
		return nodeList;
	}

	/**
	 * get next sibling.
	 * 
	 * @author Eliotte Rusty Harold
	 * @param current
	 *            may be null
	 * @return following sibling or null
	 */
	public static Node getFollowingSibling(Node current) {
		Node node = null;
		if (current != null) {
			ParentNode parent = current.getParent();
			if (parent != null) {
				int index = parent.indexOf(current);
				if (index + 1 < parent.getChildCount()) {
					node = parent.getChild(index + 1);
				}
			}
		}
		return node;
	}

	/**
	 * get previous sibling.
	 * 
	 * @param current
	 * @return previous sibling
	 */
	public static Node getPrecedingSibling(Node current) {
		Node node = null;
		if (current != null) {
			ParentNode parent = current.getParent();
			if (parent != null) {
				int index = parent.indexOf(current);
				if (index > 0) {
					node = parent.getChild(index - 1);
				}
			}
		}
		return node;
	}

	/**
	 * gets last text descendant of element. this might be referenced from the
	 * following-sibling and will therefore be the immediately preceding chunk
	 * of text in document order if the node is a text node returns itself
	 * 
	 * @param node
	 * @return Text node or null
	 */
	public static Text getLastTextDescendant(Node node) {
		List<Node> l = CMLUtil.getQueryNodes(node, ".//text() | self::text()");
		return (l.size() == 0) ? null : (Text) l.get(l.size() - 1);
	}

	/**
	 * gets first text descendant of element. this might be referenced from the
	 * preceding-sibling and will therefore be the immediately following chunk
	 * of text in document order if the node is a text node returns itself
	 * 
	 * @param node
	 * @return Text node or null
	 */
	public static Text getFirstTextDescendant(Node node) {
		List<Node> l = CMLUtil.getQueryNodes(node, ".//text() | self::text()");
		return (l.size() == 0) ? null : (Text) l.get(0);
	}

	/**
	 * transfers children of 'from' to 'to'.
	 * 
	 * @param from
	 *            (will be left with no children)
	 * @param to
	 *            (will gain 'from' children appended after any existing
	 *            children
	 */
	public static void transferChildren(Element from, Element to) {
		int nc = from.getChildCount();
		int tc = to.getChildCount();
		for (int i = nc - 1; i >= 0; i--) {
			Node child = from.getChild(i);
			child.detach();
			to.insertChild(child, tc);
		}
	}

	/**
	 * copies atributes of 'from' to 'to'
	 * @param element
	 */
	public static void copyAttributes(Element from, Element to) {
		int natt = from.getAttributeCount();
        for (int i = 0; i < natt; i++) {
            Attribute newAtt = new Attribute(from.getAttribute(i));
            to.addAttribute(newAtt);
        }
	}

	/**
	 * get XOM default canonical string.
	 * 
	 * @param node
	 * @return the string
	 */
	public static String getCanonicalString(Node node) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		Canonicalizer canon = new Canonicalizer(baos);
		try {
			canon.write(node);
		} catch (IOException e) {
			throw new RuntimeException("should never throw " + e);
		}
		return baos.toString();
	}

	/**
	 * remeoves all whitespace-only text nodes.
	 * 
	 * @param element
	 *            to strip whitespace from
	 */
	public static void removeWhitespaceNodes(Element element) {
		int nChild = element.getChildCount();
		List<Node> nodeList = new ArrayList<Node>();
		for (int i = 0; i < nChild; i++) {
			Node node = element.getChild(i);
			if (node instanceof Text) {
				if (node.getValue().trim().length() == 0) {
					nodeList.add(node);
				}
			} else if (node instanceof Element) {
				Element childElement = (Element) node;
				removeWhitespaceNodes(childElement);
			} else {
			}
		}
		for (Node node : nodeList) {
			node.detach();
		}
	}

	/**
	 * sets text content of element. Does not support mixed content.
	 * 
	 * @param element
	 * @param s
	 * @throws RuntimeException
	 *             if element already has element content
	 */
	public static void setXMLContent(Element element, String s) {
		List<Node> elements = CMLUtil.getQueryNodes(element, S_STAR);
		if (elements.size() > 0) {
			throw new RuntimeException(
					"Cannot set text with element children");
		}
		Text text = CMLUtil.getFirstTextDescendant(element);
		if (text == null) {
			text = new Text(s);
			element.appendChild(text);
		} else {
			text.setValue(s);
		}
	}

	/**
	 * sets text content of element. Does not support mixed content.
	 * 
	 * @param element
	 * @return text value
	 * @throws RuntimeException
	 *             if element already has element content
	 */
	public static String getXMLContent(Element element) {
		List<Node> elements = CMLUtil.getQueryNodes(element, S_STAR);
		if (elements.size() > 0) {
			throw new RuntimeException(
					"Cannot get text with element children");
		}
		return element.getValue();
	}

	public static String toXMLString(Element element) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			CMLUtil.debug(element, baos, 0);
		} catch (IOException e) {
		}
		return new String(baos.toByteArray());
	}
	
	/**
	 * read CML element. convenience method
	 * 
	 * @param filename
	 * @return element
	 */
	public static CMLElement readElementFromResource(String filename) {
		CMLElement element = null;
		try {
			InputStream in = Util.getInputStreamFromResource(filename);
			element = (CMLElement) new CMLBuilder().build(in).getRootElement();
			in.close();
		} catch (Exception e) {
			throw new RuntimeException("parse/read exception in " + filename
					+ "; " + e);
		}
		return element;
	}

	/**
	 * bug report.
	 * 
	 * @param message
	 */
	public static void BUG(String message) {
		Util.BUG(message);
	}

	/**
	 * returns all prefixes in attributes in descendants. currently accesses all
	 * elements
	 * 
	 * @param element
	 * @param attName
	 *            attribute name (e.g. ref, dictRef)
	 * @return prefixes
	 */
	public static List<String> getPrefixes(Element element, String attName) {
		List<String> prefixList = new ArrayList<String>();
		List<Node> refs = CMLUtil.getQueryNodes(element, ".//@" + attName,
				CML_XPATH);
		for (Node node : refs) {
			Attribute attribute = (Attribute) node;
			String value = attribute.getValue();
			String prefix = CMLUtil.getPrefix(value);
			if (!prefixList.contains(prefix)) {
				prefixList.add(prefix);
			}
		}
		return prefixList;
	}

	/**
	 * get namespace for list of prefixes.
	 * 
	 * @param element
	 *            in which namespaces are in scope
	 * @param prefixes
	 * @return list of namespaces
	 * @exception RuntimeException
	 *                if any prefix does not map to a namespace
	 */
	public static List<CMLNamespace> getNamespaces(Element element,
			List<String> prefixes) {
		List<CMLNamespace> namespaceList = new ArrayList<CMLNamespace>();
		for (String prefix : prefixes) {
			String namespaceURI = element.getNamespaceURI(prefix);
			if (namespaceURI == null) {
				throw new RuntimeException("Missing namespace :" + prefix
						+ ":");
			}
			CMLNamespace namespace = new CMLNamespace(prefix, namespaceURI);
			namespaceList.add(namespace);
		}
		return namespaceList;
	}

	/**
	 * returns a list of list of integers. Supply it with an integer of the list
	 * size and it will return all possible combinations of all groupings of the
	 * integers up to the integer you supply
	 * 
	 * thus supplying 3 would return: -- blank entry-- 1 2 3 1 2 1 3 2 3 1 2 3
	 * 
	 * @param max
	 * @return list of all possible integer combinations going from 0 to max.
	 */
	public static List<List<Integer>> generateCombinationList(int max) {
		List<List<Integer>> combinationList = new ArrayList<List<Integer>>();
		int count = (int) Math.pow(2.0, max);
		for (int i = 2; i <= count; i++) {
			int thisCount = i;
			List<Integer> intSet = new ArrayList<Integer>(max);
			for (int j = max; j >= 0; j--) {
				int minus = (int) Math.pow(2.0, j);
				int test = thisCount;
				if (test - minus > 0) {
					thisCount -= minus;
					intSet.add(j);
				}
			}
			combinationList.add(intSet);
		}
		// add entry with no values
		combinationList.add(new ArrayList<Integer>(0));

		return combinationList;
	}

	/**
	 * make id from string. convert to lowercase and replace space by underscore
	 * 
	 * @param s
	 * @return new id (null if s is null)
	 */
	public static String makeId(String s) {
		String id = null;
		if (s != null) {
			id = s.toLowerCase();
			id = id.replace(S_SPACE, S_UNDER);
		}
		return id;
	}

	/**
	 * create local CML class name. e.g. CMLFooBar from fooBar
	 * 
	 * @param name
	 * @return name
	 */
	public static String makeCMLName(String name) {
		return "CML" + capitalize(name);
	}

	/**
	 * create local Abstract class name. e.g. AbstractFooBar from fooBar
	 * 
	 * @param name
	 * @return name
	 */
	public static String makeAbstractName(String name) {
		return "Abstract" + capitalize(name);
	}

	/**
	 * capitalize name e.g. FooBar from fooBar
	 * 
	 * @param name
	 * @return name
	 */
	public static String capitalize(String name) {
		return name.substring(0, 1).toUpperCase() + name.substring(1);
	}

	/**
	 * Parses double, taking account of lexical forms of special cases allowed
	 * by the XSD spec: INF, -INF and NaN.
	 * 
	 * @param value
	 * @return
	 * @throws ParseException
	 */
	public static double parseFlexibleDouble(String value)
			throws ParseException {
		//LOG.debug("Parsing "+ value);
		if (value != null) {
			// 0, -0, INF, -INF and NaN : Special cases from the XSD spec.
			if ("INF".equals(value)) {
				return Double.POSITIVE_INFINITY;
			} else if ("-INF".equals(value)) {
				return Double.NEGATIVE_INFINITY;
			} else if ("NaN".equals(value)) {
				return Double.NaN;
			} else {
				try {
					return Double.valueOf(value);
				} catch (NumberFormatException e) {
					throw new ParseException(e.toString(), 0);
				}
			}
		} else {
			throw new IllegalArgumentException("Null double string not allowed");
		}
	}
	
	/**
	 * tests 2 XML objects for equality using recursive descent.
	 * includes namespace testing
	 * 
	 * @param refString xml serialization of first Element
	 * @param testNode second Element
	 * @param stripWhite if true remove w/s nodes
	 * @return message of where elements differ (null if identical)
	 */
	public static String equalsCanonically(String refNodeXML, Element testElement,
			boolean stripWhite) {
		Element refElement = null;
		try {
			refElement = new Builder().build(new StringReader(refNodeXML)).getRootElement();
		} catch (Exception e) {
			throw new RuntimeException("Parsing failed: "+refNodeXML);
		}
		String message = equalsCanonically(refElement, testElement, stripWhite, "/");
		LOG.trace("EQCAN "+message);
		return message;
	}
	
	/**
	 * tests 2 XML objects for equality using recursive descent.
	 * includes namespace testing
	 * 
	 * @param refNode first node
	 * @param testNode second node
	 * @param stripWhite if true remove w/s nodes
	 * @return message of where elements differ (null if identical)
	 */
	public static String equalsCanonically(Element refElement, Element testElement,
			boolean stripWhite) {
		return equalsCanonically(refElement, testElement, stripWhite, "./");
	}
	/**
	 * tests 2 XML objects for equality using recursive descent.
	 * includes namespace testing
	 * 
	 * @param refElement first node
	 * @param testElement second node
	 * @param stripWhite if true remove w/s nodes
	 * @return message of where elements differ (null if identical)
	 */
	public static String equalsCanonically(Element refElement, Element testElement,
			boolean stripWhite, String xpath) {
		String message = null;
		// check if they are different objects
		if (refElement != testElement) {
			if (stripWhite) {
				refElement = new Element(refElement);
				removeWhitespaceNodes(refElement);
				testElement = new Element(testElement);
				removeWhitespaceNodes(testElement);
			}
			xpath = xpath+"*[local-name()='"+refElement.getLocalName()+"']/";
			message = equalsCanonically(refElement, testElement, xpath);
		}
		return message;
	}

	private static String equalsCanonically(Element refElement, Element testElement, String xpath) {
		String message;
		message = CMLUtil.compareNamespacesCanonically(refElement, testElement, xpath);
		if (message != null) {
			return message;
		}
		String refName = refElement.getLocalName();
		String testName = testElement.getLocalName();
		if (message == null && !refName.equals(testName)) {
			message = "element names differ at "+xpath+": "+refName+" != "+testName;
		}
		String refNamespace = refElement.getNamespaceURI();
		String testNamespace = testElement.getNamespaceURI();
		if (message == null && !refNamespace.equals(testNamespace)) {
			message = "element namespaces differ at "+xpath+": "+refNamespace+" != "+testNamespace;
		}
		if (message == null) {
			message = CMLUtil.compareAttributesCanonically(refElement, testElement, xpath);
		}
		if (message == null) {
			message = CMLUtil.compareChildNodesCanonically(refElement, testElement, xpath);
		}
		return message;
	}
	
    public static String getCommonLeadingString(String s1, String s2) {
        int l = Math.min(s1.length(), s2.length());
        int i;
        for (i = 0; i < l; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                break;
            }
        }
        return s1.substring(0, i);
    }
	/** compare namespaces on two elements
	 * 
	 * @param refNode
	 * @param testNode
	 * @param xpath current ancestry of refNode
	 * @return
	 */
	public static String compareNamespacesCanonically(Element refNode, Element testNode, String xpath) {
		String message = null;
		List<String> refNamespaceURIList = getNamespaceURIList(refNode);
		List<String> testNamespaceURIList = getNamespaceURIList(testNode);
		if (refNamespaceURIList.size() != testNamespaceURIList.size()) {
				message = "unequal namespace count;" +
				" ref "+refNamespaceURIList.size()+";" +
				" testCount "+testNamespaceURIList.size();
		} else {
			for (String refNamespaceURI : refNamespaceURIList) {
				if (!testNamespaceURIList.contains(refNamespaceURI)) {
					message = "Cannot find "+refNamespaceURI+
					" in test namespaces ";
					break;
				}
			}
		}
		return message;
	}

	/**
	 * @param node
	 * @param count
	 */
	private static List<String> getNamespaceURIList(Element node) {
		List<String> namespaceURIList = new ArrayList<String>();
		for (int i = 0; i < node.getNamespaceDeclarationCount(); i++) {
			String prefix = node.getNamespacePrefix(i);
			String refNamespaceURI = node.getNamespaceURI(prefix);
			namespaceURIList.add(refNamespaceURI);
		}
		return namespaceURIList;
	}
	
	/** compare attributes on two elements.
	 * includes normalizing attribute values
	 * 
	 * @param refNode
	 * @param testNode
	 * @param xpath current ancestry of refNode
	 * @return
	 */
	public static String compareAttributesCanonically(Element refNode, Element testNode, String xpath) {
		String message = null;
		int refCount = refNode.getAttributeCount();
		int testCount = testNode.getAttributeCount();
		if (refCount != testCount) {
			message = "unequal attribute count at "+xpath+" ("+refCount+" != "+testCount+")";
		}
		if (message == null) {
			for (int i = 0; i < refCount; i++) {
				Attribute attribute = refNode.getAttribute(i);
				String name = attribute.getLocalName();
				String namespace = attribute.getNamespaceURI();
				String value = attribute.getValue();
				Attribute testAttribute = (namespace == null) ?
					testNode.getAttribute(name) :
					testNode.getAttribute(name, namespace);
				if (testAttribute == null) {
					message = "no attribute in test ("+xpath+") for "+CMLUtil.printName(name, namespace);
					break;
				}
				String refValue = CMLUtil.normalizeSpace(value);
				String testValue = CMLUtil.normalizeSpace(testAttribute.getValue());
				if (!refValue.equals(testValue)) {
					message = "normalized attribute values for ("+xpath+"@"+CMLUtil.printName(name, namespace)+") "+refValue+" != "+testValue;
					break;
				}
			}
		}
		LOG.trace("ATT MS "+message);
		return message;
	}
	
	private static String printName(String name, String namespace) {
		return name+((namespace == null || namespace.equals(S_EMPTY)) ? "" : "["+namespace+"]");
	}
	
	private static String normalizeSpace(String value) {
		return value.replaceAll(S_WHITEREGEX, S_SPACE).trim();
	}
	
	/** compare child nodes recursively
	 * 
	 * @param refNode
	 * @param testNode
	 * @param xpath current ancestry of refNode
	 * @return
	 */
	public static String compareChildNodesCanonically(Element refNode, Element testNode, String xpath) {
		String message = null;
		int refCount = refNode.getChildCount();
		int testCount = testNode.getChildCount();
		if (refCount != testCount) {
			message = "unequal child node count at "+xpath+" ("+refCount+" != "+testCount+")";
		}
		if (message == null) {
			for (int i = 0; i < refCount; i++) {
				String xpathChild = xpath+"node()[position()="+(i+1)+"]";
				Node refChildNode = refNode.getChild(i);
				Node testChildNode = testNode.getChild(i);
				Class<?> refClass = refChildNode.getClass();
				Class<?> testClass = testChildNode.getClass();
				if (!refClass.equals(testClass)) {
					message = "child node classes differ at "+xpathChild+" "+refClass+"/"+testClass;
					break;
				} else if (refChildNode instanceof Element) {
					message = CMLUtil.equalsCanonically((Element) refChildNode, (Element) testChildNode,
						xpathChild);
				} else {
					message = CMLUtil.compareNonElementNodesCanonically(refNode, testNode, xpath);
					if (message != null) {
						break;
					}
				}
			}
		}
		return message;
	}
	
	
	/** compare non-element nodes.
	 * not yet tuned for normalizing adjacent CDATA and other horrors
	 * @param refNode
	 * @param testNode
	 * @param xpath current ancestry of refNode
	 * @return
	 */
	public static String compareNonElementNodesCanonically(Node refNode, Node testNode, String xpath) {
		String message = null;
		String refValue = refNode.getValue();
		String testValue = testNode.getValue();
		if (refNode instanceof Comment) {
			if (!refValue.equals(testValue)) {
				message = "comments at ("+xpath+") differ: "+refValue+" != "+testValue;
			}
		} else if (refNode instanceof Text) {
			if (!refValue.equals(testValue)) {
				message = "text contents at ("+xpath+") differ: ["+refValue+"] != ["+testValue+"]";
			}
		} else if (refNode instanceof ProcessingInstruction) {
			String refTarget = ((ProcessingInstruction) refNode).getTarget();
			String testTarget = ((ProcessingInstruction) testNode).getTarget();
			if (!refTarget.equals(testTarget)) {
				message = "PI targets at ("+xpath+") differ: "+refTarget+" != "+testTarget;
			}
		} else {
			LOG.warn("Unknown XML element in comparison");
		}
		return message;
	}

	/**
	 * some formatted XML introduces spurious WS after text strings
	 * @param element
	 */
	public static void stripTrailingWhitespaceinTexts(Element element) {
		Nodes texts = element.query("//text()");
		for (int i = 0; i < texts.size(); i++) {
			Text text = (Text) texts.get(i);
			String value = text.getValue();
			value = Util.rightTrim(value);
			text.setValue(value);
		}
	}
}
