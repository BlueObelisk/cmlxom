package org.xmlcml.cml.base;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nu.xom.Attribute;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Elements;
import nu.xom.IllegalAddException;
import nu.xom.Node;
import nu.xom.Nodes;
import nu.xom.ParentNode;
import nu.xom.Serializer;
import nu.xom.Text;

import org.apache.log4j.Logger;
import org.xmlcml.cml.base.CMLLog.Severity;
import org.xmlcml.cml.element.CMLArray;
import org.xmlcml.euclid.Util;

/**
 * base class for all CML elements
 * can be sorted on id attribute
 * @author Peter Murray-Rust
 * @version 5.0
 * 
 */
public class CMLElement extends Element implements CMLConstants, Comparable<CMLElement>, HasId {

	
    /** hybridisation - from whatever source */
    public enum Hybridization {
        /** constant */
        SP3,
        /** constant */
        SP2,
        /** constant */
        SP,
        /** constant */
        BENT,
        /** constant */
        SQUARE_PLANAR,
        /** constant */
        UNKNOWN;
    }

    /**
     * coordinateType.
     * 
     */
    public enum CoordinateType {
        /**
         * relate all operations to cartesian coordinates (XYZ3)
         */
        CARTESIAN("cartesian"),
        /**
         * relate all operations to fractional coordinates (XYZFract)
         */
        FRACTIONAL("fractional"),
        /**
         * relate all operations to 2D coordinates (XY2)
         */
        TWOD("twod");
        String name;

        private CoordinateType(String name) {
            this.name = name;
        }
    }

    /**
     * controls formal charge default why is this here??
     */
    public enum FormalChargeControl {
        /**
         * returns 0 if formalCharge missing
         * 
         */
        DEFAULT(0),
        /**
         * returns nonsense value if formalCharge missing
         * 
         */
        NO_DEFAULT(Integer.MIN_VALUE);
        int defalt;

        private FormalChargeControl(int def) {
            this.defalt = def;
        }
    }

    final static Logger logger = Logger.getLogger(CMLElement.class);
    final static String ID = "id";

    private Map<String, Object> propertyMap;

    private Map<String, List<CMLElement>> idMap;
    private CMLLog log = null;
    private AbstractTool tool;
    
    protected static CMLNodeFactory nodeFactory = CMLNodeFactory.nodeFactory;
    protected static AttributeFactory attributeFactory = AttributeFactory.attributeFactory;
    
    // this seems to be mandatory
    protected CMLElement() {
        super("untagged_element_beware");
        init();
    }

    /**
     * main constructor.
     * 
     * @param name
     *            tagname
     */
    public CMLElement(String name) {
        super(name, CMLConstants.CML_NS);
        init();
    }
    
    private void init() {
    }

    /** parses a non-subclassed element into CML.
     * Typically used when other software such as 
     * XOM or XSLT create elements through the normal
     * builder.
     * Removes any Document parent
     * Serializes the element and re-parses with CMLBuilder()
     * @param element
     * @return CMLElement (null if root element is not CML)
     */
    public static CMLElement createCMLElement(Element element) {
    	Element newElement = null;
    	try {
    		newElement = new CMLBuilder().parseString(CMLUtil.toXMLString(element));
    	} catch (Exception e) {
    		throw new RuntimeException("BUG", e);
    	}
    	if (!(newElement instanceof CMLElement)) {
    		newElement = null;
    	} else {
    		newElement.detach();
    	}
    	return (CMLElement) newElement;
    }
    /**
     * normally overridden
     * @param id
     */
    public void setId(String id) {
    	this.addAttribute(new Attribute(CMLXSD_ID, id));
    }

    /**
     * normally overridden
     * @return id
     */
    public String getId() {
    	return this.getAttributeValue(CMLXSD_ID);
    }

    /**
     * copy constructor. copies attributes, children and properties using the
     * copyFoo() routines (q.v.)
     * 
     * @param element
     */
    public CMLElement(CMLElement element) {
        this(element.getLocalName());
        copyAttributesFrom(element);
        copyChildrenFrom(element);
        copyNamespaces(element);
        copyProperties(element);
    }

    /**
     * copy node.
     * 
     * @return node
     */
    public Node copy() {
        return new CMLElement(this);
    }

    /**
     * callback when constructing from XML. No-op unless overridden in subclass
     * 
     * @param parent
     *            element
     */
    public void finishMakingElement(Element parent) {
    }
    
    protected void addRemove(CMLAttribute att, String value) {
    	if (value == null || value.equals(S_EMPTY)) {
    		this.removeAttribute(att.getLocalName());
    	} else if (att == null) {
    	} else {
    		att.setCMLValue(value);
    		super.addAttribute(att);
    	}
    }

    /**
     * copies attributes. makes subclass if necessary.
     * 
     * @param element to copy from
     */
    public void copyAttributesFrom(Element element) {
        for (int i = 0; i < element.getAttributeCount(); i++) {
            Attribute att = element.getAttribute(i);
            Attribute newAtt = (Attribute) att.copy();
            this.addAttribute(newAtt);
        }
    }

    /** copies children of element make subclasses when required
     * 
     * @param element to copy from
     */
    public void copyChildrenFrom(Element element) {
        for (int i = 0; i < element.getChildCount(); i++) {
            Node childNode = element.getChild(i);
            Node newNode = childNode.copy();
            this.appendChild(newNode);
        }
    }
    
    /** copies children of element make subclasses when required
     * 
     * @param element to copy from
     * @param to
     */
    public static void copyChildrenFromTo(Element element, Element to) {
        for (int i = 0; i < element.getChildCount(); i++) {
            Node childNode = element.getChild(i);
            Node newNode = childNode.copy();
            to.appendChild(newNode);
        }
    }
    
    /** override replaceChild.
     * @param oldNode
     * @param newNode
     */
    public void replaceChild(Node oldNode, Node newNode) {
        int pos = this.indexOf(oldNode);
        if (pos == -1) {
            throw new RuntimeException("Cannot replace non-child");
        }
        newNode.detach();
        this.removeChild(oldNode);
        this.insertChild(newNode, pos);
    }

    /** override insertChild.
     * if newNode has parent detach()es first
     * @param newNode
     * @param pos
     */
    public void insertChild(Node newNode, int pos) {
        newNode.detach();
        super.insertChild(newNode, pos);
    }

    /** re-route detach().
     * to parent.removeChild(this);
     */
    public void detach() {
        ParentNode parent = this.getParent();
        if (parent != null) {
            if (parent instanceof Document) {
                parent.replaceChild(this, new Element("dummy"));
            } else {
                parent.removeChild(this);
            }
        }
    }

    /** override addNamespaceDeclaration(prefix, uri) to make it immutable.
     * if namespacePrefix is not set, set it, else returns no-op
     * without message.
     * @param prefix
     * @param uri
     */
    public void addNamespaceDeclaration(String prefix, String uri) {
        String namespaceURI = this.getNamespaceURI(prefix);
        if (namespaceURI == null) {
            super.addNamespaceDeclaration(prefix, uri);
        }
    }

    /** override removeNamespaceDeclaration(prefix) to forbid it.
     * @deprecated
     * 
     * @param prefix
     */
    public void removeNamespaceDeclaration(String prefix) {
        String namespaceURI = this.getNamespaceURI(prefix);
        if (namespaceURI == null) {
            throw new RuntimeException("Cannot remove namespace prefix");
        }
    }

    /** override setLocalName(localName) to make it immutable.
     * if localname is null sets it, else no-op
     * @param localName
     */
    public void setLocalName(String localName) {
        String lName = this.getLocalName();
        if (lName == null) {
            super.setLocalName(localName);
        }
    }

    /** set attribute.
     * reroutes special cases such as setId() => resetId()
     * @param attName
     * @param attValue
     */
    public void setAttribute(String attName, String attValue) {
        // id is special
        if (ID.equals(attName)) {
            this.resetId(attValue);
        } else {
            this.addAttribute(new Attribute(attName, attValue));
        }
    }
    
//  parent.addAttribute(new Attribute(parentAttribute, attValue));

    /** override setNamespaceURI(String namespaceURI) to make it immutable.
     * if namespaceURI is not set, sets it, else no-op
     * @param namespaceURI
     */
    public void setNamespaceURI(String namespaceURI) {
        String nURI = this.getNamespaceURI();
        if (nURI == null) {
            super.setNamespaceURI(namespaceURI);
        }
    }

    /** override setNamespacePrefix(String namespacePrefix) to make it immutable.
     * if namespacePrefix is not set, sets it, else no-op
     * @param namespacePrefix
     */
    public void setNamespacePrefix(String namespacePrefix) {
        String nPrefix = this.getNamespacePrefix();
        if (nPrefix == null) {
            super.setNamespacePrefix(nPrefix);
        }
    }
    
    /** replace current element by its child nodes.
     * does not work for root node
     *
     */
    public void replaceByChildren() {
        Node parent = this.getParent();
        if (parent == null) {
        } else if (!(parent instanceof Element)) {
        } else {
            Element parentElement = (Element) parent;
            int idx = parentElement.indexOf(this);
            List<Node> nodeList = new ArrayList<Node>();
            for (int i = 0; i < this.getChildCount(); i++) {
                nodeList.add(this.getChild(i));
            }
            for (int i = 0; i < nodeList.size(); i++) {
                Node node = nodeList.get(i);
                node.detach();
                parentElement.insertChild(node, idx + i);
            }
        }
        this.detach();
    }
    /**
     * copies namespaces.
     * 
     * @param element
     *            to copy from
     */
    public void copyNamespaces(CMLElement element) {
        int n = element.getNamespaceDeclarationCount();
        for (int i = 0; i < n; i++) {
            String namespacePrefix = element.getNamespacePrefix(i);
            String namespaceURI = element
                    .getNamespaceURIForPrefix(namespacePrefix);
            this.addNamespaceDeclaration(namespacePrefix, namespaceURI);
        }
    }

    /**
     * copies properties. deep copy of map but NOT values
     * 
     * @param element
     *            to copy from
     */
    public void copyProperties(CMLElement element) {
        if (element.propertyMap != null) {
            propertyMap = new HashMap<String, Object>();
            for (String key : element.propertyMap.keySet()) {
                Object object = element.propertyMap.get(key);
                propertyMap.put(key, object);
            }
        }
    }

    /**
     * get XOM default canonical string.
     * 
     * @return the string
     */
    public String getCanonicalString() {
        return CMLUtil.getCanonicalString(this);
    }

    /**
     * compares elements for identity. sorting order based on canonical strings
     * 
     * @param elem
     *            to compare
     * @return 0 if content is identical else -1 or 1
     */
    public int compareTo(CMLElement elem) {
        String thisS = CMLUtil.getCanonicalString(this);
        String elemS = CMLUtil.getCanonicalString(elem);
        int i = thisS.compareTo(elemS);
        return (i == 0) ? 0 : ((i < 0) ? -1 : 1);
    }


    // ========================== utilities ====================== //

    /**
     * throws Exception.
     * 
     * @param name
     *            of attribute
     * @throws CMLException
     *             standard message
     */
    protected void unknownAttributeName(String name) {
        throw new RuntimeException("Unknown CML attribute " + name + " on "
                + this.getLocalName());
    }

    protected String getCMLAttributeValue(String name) {
        CMLAttribute a = (CMLAttribute) this.getAttribute(name);
        return (a == null) ? null : (String) a.getCMLValue();
    }

    protected CMLElement getOrCreateChild(String name) throws RuntimeException {
        CMLElement element = (CMLElement) this.getFirstChildElement(name,
                CMLConstants.CML_NS);
        if (element == null) {
            try {
                element = (CMLElement) Class.forName(
                        ELEMENT_CLASS_BASE+".CML" + name.substring(0, 1)
                                + name.substring(1)).newInstance();
            } catch (Exception e) {
                throw new RuntimeException("" + e);
            }
        }
        return element;
    }

    /** ensures queries which may have cml namespace prefix have XPath context
     * @param query
     * @return nodes
     */
    public Nodes cmlQuery(String query) {
    	return super.query(query, CMLConstants.CML_XPATH);
    }

    /**
     * <p>
     * Detaches all children from this node. 
     * </p>
     * 
     * @return a list of all the children removed in the order they
     *     appeared in the element
     */
    public Nodes removeChildren() {
        
        int length = this.getChildCount();
        Nodes result = new Nodes();
        for (int i = 0; i < length; i++) {
            Node child = getChild(0);
            this.removeChild(child);
            result.append(child);
        }   
        return result;
        
    }
    
    /**
     * remove attribute.
     * 
     * @param attName
     */
    public void removeAttribute(String attName) {
        Attribute att = this.getAttribute(attName);
        if (att != null) {
            this.removeAttribute(att);
        }
    }

    /**
     * copy attributes from one CMLElement to another. overwrites existing
     * atts
     * 
     * @param from
     *            element to copy from
     * @param to
     *            element to copy to
     */

    public static void copyAttributesFromTo(Element from, Element to) {
        for (int i = 0; i < from.getAttributeCount(); i++) {
            Attribute att = from.getAttribute(i);
            Attribute newAtt = (att instanceof CMLAttribute) ? new CMLAttribute(
                    (CMLAttribute) att)
                    : new Attribute(att);
            to.addAttribute(newAtt);
        }
    }
    
    /** it attribute exists detach it.
     * @param element
     * @param attName
     */
    public static void deleteAttribute(Element element, String attName) {
    	Attribute att = element.getAttribute(attName);
    	if (att != null) {
    		att.detach();
    	}
    }

    /** debug for element. makes copy if not document root writes to sysout
     * @param message
     */
    public void debug(String message) {
        Util.println("<<<<<<"+message+"<<<<<<");
        debug();
        Util.println(">>>>>>"+message+">>>>>>");
    }

    /** debug for element. makes copy if not document root writes to sysout
     */
    public void debug() {
        try {
            debug(System.out, 2);
        } catch (IOException e) {
            Util.BUG(e);
        }
    }

    /** debug for element. makes copy if not docuemnt root writes to sysout
     * @param indent
     */
    public void debug(int indent) {
        try {
            debug(System.out, indent);
        } catch (IOException e) {
            Util.BUG(e);
        }
    }

    /** debug.
     * 
     * @param os
     * @param indent
     * @throws IOException
     */
    public void debug(OutputStream os, int indent) throws IOException {
        Document document;
        Node parent = this.getParent();
        if (parent instanceof Document) {
            document = (Document) parent;
        } else {
            CMLElement copyElem = new CMLElement(this);
            document = new Document(copyElem);
        }
        Serializer serializer = new Serializer(os);
        serializer.setIndent(indent);
//        if (indent == 0) {
//            serializer.setLineSeparator("\r\n");
//        }
        serializer.write(document);
    }

    /**
     * set a property on the object.
     * 
     * currently developed as a way of holding information during computation,
     * rather than adding to permanent data structure
     * 
     * @param property
     *            name, best enumerated in subclassed Tool (e.g.
     *            AtomToo.MORGAN_COUNT).
     * @param value
     *            the value to set. If null removes the property
     */
    public void setProperty(String property, Object value) {
        if (property != null) {
            if (propertyMap == null) {
                propertyMap = new HashMap<String, Object>();
            }
            if (value == null) {
                propertyMap.remove(property);
            } else {
                propertyMap.put(property, value);
            }
        }
    }

    /**
     * get a property on the object.
     * 
     * currently developed as a way of holding information during computation,
     * rather than adding to permanent data structure
     * 
     * @param property
     *            name, best enumerated in subclassed Tool (e.g.
     *            AtomToo.MORGAN_COUNT)
     * @return value or null if not set
     */
    public Object getProperty(String property) {
        return (property == null || propertyMap == null) ? null : propertyMap
                .get(property);
    }

    /**
     * get list of property names.
     * 
     * @return list of names (zero lengtn if none)
     */
    public List<String> getPropertyNames() {
        List<String> list = new ArrayList<String>();
        if (propertyMap != null) {
            for (String key : propertyMap.keySet()) {
                list.add(key);
            }
        }
        return list;
    }

    /**
     * convenience method to get CMLElement children. avoid having to specify
     * namespaces.
     * 
     * @return the CMLElement children
     */
    public List<CMLElement> getChildCMLElements() {
        List<CMLElement> elementList = new ArrayList<CMLElement>();
        Elements elements = this.getChildElements();
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i) instanceof CMLElement) {
                elementList.add((CMLElement) elements.get(i));
            }
        }
        return elementList;
    }

    /**
     * convenience method to get Element children. avoid having to specify
     * namespaces.
     * 
     * @param name
     *            local CML name
     * @return the children of that type
     */
    public Elements getChildCMLElements(String name) {
        return getChildElements(name, CMLConstants.CML_NS);
    }

    /**
     * convenince method to get first Element child. avoid having to specify
     * namespaces.
     * 
     * @param name
     *            local CML name
     * @return the first child of that type or null
     */
    public Element getFirstCMLChild(String name) {
        return getFirstChildElement(name, CMLConstants.CML_NS);
    }

    /**
     * convenince method to get serial Element child. avoid having to specify
     * namespaces.
     * 
     * @param name
     *            local CML name
     * @param i
     *            serial number of child
     * @return the i'th child of that type or null
     */
    public Element getChildCMLElement(String name, int i) {
        Elements childElements = getChildCMLElements(name);
        return (i < 0 || i >= childElements.size()) ? null : childElements
                .get(i);
    }

    /**
     * convenience method to get Element child count. avoid having to specify
     * namespaces.
     * 
     * @param name
     *            local CML name
     * @return the count of that type or null
     */
    public int getCMLChildCount(String name) {
        Elements childElements = getChildCMLElements(name);
        return childElements.size();
    }

    /**
     * gets attributeGroupName for attributeName. only used in code generation.
     * Only used by subclasses
     * 
     * @param attributeName
     * @return null unless subclassed
     */
    public String getAttributeGroupName(String attributeName) {
        return null;
    }

    /**
     * descendant elements by id. normally only one, but id is not required to
     * be unique
     * 
     * @param id
     * @return elements
     */
    public List<CMLElement> getDescendantCMLElementsById(String id) {
        List<CMLElement> elementList = new ArrayList<CMLElement>();
        if (id != null) {
            List<CMLElement> childElements = this.getChildCMLElements();
            for (CMLElement e : childElements) {
                if (id.equals(e.getAttribute(ID))) {
                    elementList.add(e);
                }
            }
        }
        return elementList;
    }

    /**
     * get all CMLElements fitting query.
     * ignores non-ceml elements
     * @param cmlQueryString
     * @return list of CMLelements
     */
    public List<CMLElement> getElements(String cmlQueryString) {
        Nodes nodes = this.query(cmlQueryString, CMLConstants.CML_XPATH);
        List<CMLElement> cmlElements = new ArrayList<CMLElement>();
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i) instanceof CMLElement) {
                cmlElements.add((CMLElement) nodes.get(i));
            }
        }
        return cmlElements;
    }

    /**
     * get all descendants with local name.
     * @deprecated use query 
     * @param elementName to search for (null accepts all)
     * @param nested if true allows children of elementName (e.g.
     *            molecule/molecule)
     * @return list of elements
     */
    public List<CMLElement> getDescendants(String elementName,
            boolean nested) {
        return getDescendants(elementName, null, nested);
    }
    
    /**
     * get all descendants with local name.
     * @deprecated use query 
     * @param elementName
     *            to search for (null accepts all)
     * @param attributeName
     *            to search for (null accepts all)
     * @param nested
     *            if true allows children of elementName (e.g.
     *            molecule/molecule)
     * @return list of elements
     */
    public List<CMLElement> getDescendants(String elementName,
            String attributeName, boolean nested) {
        List<CMLElement> elementList = new ArrayList<CMLElement>();
        boolean found = false;
        if (elementName == null || this.getLocalName().equals(elementName)) {
            if (attributeName == null
                    || this.getAttributeValue(attributeName) != null) {
                elementList.add(this);
                found = true;
            }
        }
        // recurse if not found or nested
        if (!found || nested) {
            List<CMLElement> childElements = this.getChildCMLElements();
            for (CMLElement e : childElements) {
                List<CMLElement> descendants = e.getDescendants(elementName,
                        attributeName, nested);
                elementList.addAll(descendants);
            }
        }
        return elementList;
    }

    /**
     * get all descendants.
     * 
     * @return list of elements
     */
    public List<CMLElement> getDescendants() {
        List<CMLElement> elementList = new ArrayList<CMLElement>();
        elementList.add(this);
        List<CMLElement> childElements = this.getChildCMLElements();
        for (CMLElement e : childElements) {
            List<CMLElement> descendants = e.getDescendants();
            elementList.addAll(descendants);
        }
        return elementList;
    }

    /**
     * gets String content. only valid when there is a single Text child. not
     * checked against the schema, so use with care
     * 
     * @return the XML text content or null
     */
    public String getStringContent() {
        Node child = (this.getChildCount() == 0) ? null : this.getChild(0);
        String s = (child == null || !(child instanceof Text)) ? null : child
                .getValue();
        return s;
    }

    /**
     * sets String content. very FRAGILE. not checked against the schema, so use with care. It
     * is almost always better to use the accessors generated from the schema
     * 
     * @param value
     *            the XML text content
     */
    public void setStringContent(String value) {
        Text newText = new Text(value);
        if (this.getChildCount() == 0) {
            this.appendChild(newText);
        } else {
            Node child = this.getChild(0);
            if (child instanceof Text) {
                this.replaceChild(child, newText);
            }
        }
    }

    /**
     * get namespace.
     * 
     * @param prefix
     * @return namespace
     */
    public String getNamespaceURIForPrefix(String prefix) {
        String namespace = null;
        Element current = this;
        while (true) {
            namespace = current.getNamespaceURI(prefix);
            if (namespace != null) {
                break;
            }
            Node parent = current.getParent();
            if (parent == null || parent instanceof Document) {
                break;
            }
            current = (Element) parent;
        }
        return namespace;
    }

    /** get prefix for declared namespace. since namespaces may be declared on
     * ancestors, recurse up tree till namespace found
     * 
     * @param namespaceURI
     * @return prefix
     */
    public String getPrefixForNamespace(String namespaceURI) {
        String prefix = null;
        int nCount = this.getNamespaceDeclarationCount();
        for (int i = 0; i < nCount; i++) {
            String px = this.getNamespacePrefix(i);
            if (namespaceURI.equals(this.getNamespaceURI(px))) {
                prefix = px;
                break;
            }
        }
        if (prefix == null) {
            Node parent = this.getParent();
            if (parent != null && parent instanceof CMLElement) {
                prefix = ((CMLElement) parent)
                        .getPrefixForNamespace(namespaceURI);
            }
        }
        return prefix;
    }

    /** gets top CMLElement ancestor.
     * 
     * @return top ancestor (or this if no CMLElement parent)
     */
    public CMLElement getOldestCMLAncestor() {
        CMLElement current = this;
        while (true) {
            Node parent = current.getParent();
            if (parent == null || !(parent instanceof CMLElement)) {
                break;
            }
            current = (CMLElement) parent;
        }
        return current;
    }
    
    /** gets element(s) which have given id.
     * fragile as it indexes the object once and if the 
     * XOM is modified will be out of sync and needs refreshing
     * @param id (not necessarily unique
     * @param refresh the idMap
     * @return list of ids (never null, nay be 0)
     */
    public List<CMLElement> getElementsById(String id, boolean refresh) {
        if (idMap == null || refresh) {
            idMap = new HashMap<String, List<CMLElement>>();
            addIds(this);
        }
        List<CMLElement> elemList = idMap.get(id);
        if (elemList == null) {
            elemList = new ArrayList<CMLElement>();
        }
        return elemList;
    }
    
    void addIds(CMLElement elem) {
        String id = elem.getAttributeValue(ID);
        if (id != null) {
            List<CMLElement> idList = idMap.get(id);
            if (idList == null) {
                idList = new ArrayList<CMLElement>();
                idMap.put(id, idList);
            }
            if (!idList.contains(elem)) {
                idList.add(elem);
            }
        }
        List<CMLElement> childList = elem.getChildCMLElements();
        for (CMLElement child : childList) {
            addIds(child);
        }
    }
    /**
     * gets an Xpointer-like string describing the context of the element.
     * 
     * @deprecated NYI
     * @return nothing
     */
    public String getAncestry() {
        String s = "";
        return s;
    }

    /**
     * write as HTML. many elements will override this method.
     * 
     * @param w
     *            writer
     * @throws IOException
     */
    public void writeHTML(Writer w) throws IOException {
        w.write("<span class='" + this.getLocalName() + "'>");
        w.write(this.getLocalName());
        w.write("</span>");
    }

    /** convenience method to serialize the element.
     * 
     * @param os
     * @param indent to indent lines by (non-zero may muck up whitespace)
     * @throws IOException
     */
    public void serialize(OutputStream os, int indent) throws IOException {
        Document doc = new Document((CMLElement)this.copy());
        Serializer serializer = new Serializer(os);
        serializer.write(doc);
    }

    /** set a CMLLog.
     * the molecule can then write to this when required with
     * element.addToLog().
     * This is completely separate from log4j which I don't think can do
     * what I want. Maybe it's just me
     * @param log (null switches off logging)
     */
    public void setLog(CMLLog log) {
        this.log = log;
    }

    /** add exception to log.
     * if log is unset, slient no action
     * @param t
     * @param message
     */
    public void addToLog(Throwable t, String message) {
        if (log != null) {
            log.add(t, message);
        }
    }
    
    /** convenience method to add cmlx:foo attributes.
     * 
     * @param attName WITHOUT prefix
     * @param attValue if null removes any old attributes
     */
    public void setCMLXAttribute(String attName, String attValue) {
    	if (attValue == null) {
    		Attribute attribute = this.getAttribute(attName, CMLX_NS);
    		if (attribute != null) {
    			this.removeAttribute(attribute);
    		}
    	} else {
    		addCMLXAttribute(this, attName, attValue);
    	}
    }

    /**
     * creates a prefixed CMLX attribute (cmlx:foo="bar") on element in CMLX namespace
     * @param element
     * @param attName UNPREFIXED
     * @param attValue
     */
	public static void addCMLXAttribute(Element element, String attName, String attValue) {
		Attribute attribute = makeCMLXAttribute(attName, attValue);
		element.addAttribute(attribute);
		element.addNamespaceDeclaration(CMLConstants.CMLX_PREFIX, CMLX_NS);
	}
    
    /** convenience method to create new cmlx:foo attribute.
     * 
     * @param attName WITHOUT prefix and colon
     * @param value if null undefined
     * @return
     */
	public static Attribute makeCMLXAttribute(String attName, String value) {
		return new Attribute(CMLX_PREFIX+S_COLON+attName, CMLX_NS, value);
	}

	   /** convenience method to get value of cmlx:foo attribute.
     * 
     * @param attName WITHOUT prefix
     */
    public String getCMLXAttribute(String attName) {
    	String value = null;
    	Attribute attribute = this.getAttribute(attName, CMLX_NS);
    	if (attribute != null) {
    		value = attribute.getValue();
     	}
    	return value;
    }


    /**
     * <p>
     * Appends a node to the children of this node.
     * </p>
     * 
     * @param child node to append to this node
     * 
     * @throws IllegalAddException if this node cannot have children 
     *     of this type
     * @throws NullPointerException if <code>child</code> is null
     * 
     */
    public void appendChild(Node child) {
//        if (child instanceof CMLArray) {
//        	CMLUtil.debug((Element)child, "CHILLLL000");
//        }
        child.detach();
        int childCount = this.getChildCount();
        insertChild(child, childCount);
//        if (child instanceof CMLArray) {
//        	CMLUtil.debug((Element)child, "CHILLLL111");
//        }
    }

    /** add severity to log.
     * if log is unset, slient no action
     * @param severity
     * @param message
     */
    public void addToLog(Severity severity, String message) {
        if (log != null) {
            log.add(severity, message);
        }
    }

    /** allows id to be reset.
     * many elements forbid resetting id...
     * this is a fragile workaround.
     * do not use unless you know what you are doing
     * @param id
     */
    public void resetId(String id) {
        this.removeAttribute(ID);
        this.addAttribute(new Attribute(ID, id));
    }

    /**
     * create new instance in context of parent, overridable by subclasses.
     * 
     * @param parent of element to be constructed (ignored by default)
     * @return CMLElement
     */
    public CMLElement makeElementInContext(Element parent) {
    	return new CMLElement();
    }

	/**
	 * @return the propertyMap
	 */
	public Map<String, Object> getPropertyMap() {
		return propertyMap;
	}

	/**
	 * @param propertyMap the propertyMap to set
	 */
	public void setPropertyMap(Map<String, Object> propertyMap) {
		this.propertyMap = propertyMap;
	}

	/**
	 * @return the log
	 */
	public CMLLog getLog() {
		return log;
	}

	/**
	 * @return the tool
	 */
	public AbstractTool getTool() {
		return tool;
	}

	/**
	 * @param tool the tool to set
	 */
	public void setTool(AbstractTool tool) {
		this.tool = tool;
	}

}
