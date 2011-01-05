package org.xmlcml.cml.element;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import nu.xom.Attribute;
import nu.xom.Element;
import nu.xom.Elements;
import nu.xom.Node;
import nu.xom.Nodes;
import nu.xom.Text;

import org.xmlcml.cml.attribute.IdAttribute;
import org.xmlcml.cml.attribute.RefAttribute;
import org.xmlcml.cml.base.CMLConstants;
import org.xmlcml.cml.base.CMLElement;
import org.xmlcml.cml.base.CMLUtil;


/**
 * user-modifiable class supporting arg.
 * There is a lot still being worked out.
 * Too many statics.
 * @author pm286
 */
public class CMLArg extends AbstractArg {

	/** namespaced element name.*/
	public final static String NS = C_E+TAG;

    /** start of expandable argument.
     */
    public final static String START_CHARS = CMLConstants.S_LCURLY+S_DOLLAR;
    /** end of expandable argument.
     */
    public final static String END_CHARS = CMLConstants.S_RCURLY;

    /**
     * constructor.
     */
    public CMLArg() {
    }

    /** create integer argument.
     * adds scalar child.
     * @param name of arg
     * @param i
     */
    public CMLArg(String name, int i) {
        setInteger(i);
        this.setName(name);
    }

    /** create integer argument.
     * adds scalar child.
     * @param name of arg
     * @param s
     */
    public CMLArg(String name, String s) {
        setString(s);
        this.setName(name);
    }
    /**
     * constructor.
     *
     * @param old
     */
    public CMLArg(CMLArg old) {
        super((AbstractArg) old);

    }

    /**
     * copy node .
     *
     * @return Node
     */
    public Node copy() {
        return new CMLArg(this);
    }

    /**
     * create new instance in context of parent, overridable by subclasses.
     *
     * @param parent
     *            parent of element to be constructed (ignored by default)
     * @return CMLArg
     */
    public CMLElement makeElementInContext(Element parent) {
        return new CMLArg();

    }

    /** inserts arg child.
     *
     * @param parent to hold arg
     * @param arg to add
     * @param position to add att
     * @throws RuntimeException null args or bad position or duplicate argName
     */
    public static void addArg(CMLElement parent, CMLArg arg, int position)
        throws RuntimeException {
    	// checks
        Elements args = parent.getChildCMLElements(CMLArg.TAG);
        if (parent == null || arg == null ||
                position < 0) {
            throw new RuntimeException("null args or negative position");
        }
        if (position > args.size()) {
            throw new RuntimeException("position > argCount");
        }
        String argName = arg.getName();
        for (int i = 0; i < args.size(); i++) {
            String name = ((CMLArg)args.get(i)).getName();
            if (name == null || name.trim().equals(S_EMPTY)) {
                throw new RuntimeException("missing name in arg: ");
            }
            if (name.equals(argName)) {
                throw new RuntimeException("duplicate arg: "+argName);
            }
        }
        // OK, insert arg
        parent.insertChild(arg, position);
    }

    /** remove all arg childern from element.
     *
     * @param element to remove args from
     */
    public static void removeArgs(CMLElement element) {
    	if (element != null) {
	        List<Node> args = CMLUtil.getQueryNodes(element, CMLArg.NS, CMLConstants.CML_XPATH);
	        for (Node arg : args) {
	        	arg.detach();
	        }
    	}
    }

    /** substitute arg name by symbol.
     * currently uses _ij_ to represent value of ij.
     * routine recursively descends tree and substitutes all attribute values
     * @param element to edit
     */
    public static void substituteNameByValue(CMLElement element) {
        CMLArg.substituteNameByValue(element, new ArrayList<CMLArg>());
    }

    /** transfers args from one element to another.
     * if an arg of name ijk exists on element and toElem
     * it is copied from fromElem to toElem
     * @param fromElem
     * @param toElem
     * @exception RuntimeException bad args
     */
    public static void transferArgs(CMLElement fromElem, CMLElement toElem)
        throws RuntimeException {
        List<CMLArg> fromList = CMLArg.getArgs(fromElem);
        List<CMLArg> toList = CMLArg.getArgs(toElem);
        for (CMLArg fromArg : fromList) {
            String fromName = fromArg.getName();
            if (fromName == null) {
                throw new RuntimeException("missing name in arg");
            }
            for (CMLArg toArg : toList) {
                String toName = toArg.getName();
                if (toName == null) {
                    throw new RuntimeException("missing name in arg");
                }
                if (fromName.equals(toName)) {
                    CMLArg copyFromArg = (CMLArg) fromArg.copy();
                    int idx = toElem.indexOf(toArg);
                    if (idx < 0) {
                        throw new RuntimeException("BUG idx < 0");
                    }
                    toElem.insertChild(copyFromArg, idx);
                    toArg.detach();
                    break;
                }
            }
        }
    }

    /** gets args from element.
     *
     * @param element
     * @return list of args (empty if none)
     */
    private static List<CMLArg> getArgs(CMLElement element) {
        List<CMLArg> argList = new ArrayList<CMLArg>();
        Elements args = element.getChildCMLElements(CMLArg.TAG);
        for (int i = 0; i < args.size(); i++) {
            argList.add((CMLArg) args.get(i));
        }
        return argList;
    }

    /** substitute arg name by symbol.
     * currently uses _ij_ to represent value of ij.
     * routine recursively descends tree and substitutes all attribute values
     * @param element to edit
     * @param oldArgList list of args
     */
    public static void substituteNameByValue(CMLElement element, List<CMLArg> oldArgList) {
        Elements args = element.getChildCMLElements(CMLArg.TAG);
        // create list of active args
        List<CMLArg> newArgList = new ArrayList<CMLArg>();
        // add child args to list
        for (int i = 0; i < args.size(); i++) {
            newArgList.add((CMLArg) args.get(i));
        }
        // add old ones that are not overridden
        for (CMLArg oldArg : oldArgList) {
            boolean overridden = false;
            for (int i = 0; i < args.size(); i++) {
                CMLArg arg = (CMLArg) args.get(i);
                if (oldArg.getName().equals(arg.getName())) {
                    overridden = true;
                    break;
                }
            }
            if (!overridden) {
                newArgList.add(oldArg);
            }
        }
        // self substitute in args (only eval at present)
        for (CMLArg newArg : newArgList) {
            newArg.eval(newArgList);
        }

        // now process the attributes of element
        for (CMLArg newArg : newArgList) {
            if (newArg.getSubstituteAttribute() != null) {
                newArg.substituteAttributes(element);
                if (newArg.getDeleteAttribute() != null) {
                    newArg.detach();
                }
            }
        }
        // proceed to children
        Elements elements = element.getChildElements();
        for (int j = 0; j < elements.size(); j++) {
            Element childElement = elements.get(j);
            if (childElement instanceof CMLElement) {
                CMLElement childCMLElement = (CMLElement) childElement;
                // skip other args of
                if (childCMLElement.getLocalName().equals(CMLArg.TAG)) {
                } else {
                    CMLArg.substituteNameByValue(childCMLElement, newArgList);
                }
            }
        }
    }

    private void substituteAttributes(Element element) {
        // make a copy of attribute lists as we are resetting them
        int attCount = element.getAttributeCount();
        List<Attribute> attList = new ArrayList<Attribute>();
        for (int j = 0; j < attCount; j++) {
            Attribute att = element.getAttribute(j);
            attList.add(att);
        }
        for (Attribute att : attList) {
            this.substituteNameByValue(att);
        }
    }

    void substituteNameByValue(Attribute att) {
        // do not substitute refs
        if (att instanceof RefAttribute) {

        } else {

            String value = att.getValue();
            String value1 = value;
            String newValue = this.getValue().trim();
            if (!newValue.equals(S_EMPTY)) {
                value1 = value1.replaceAll(S_UNDER+this.getName()+S_UNDER, newValue);
                if (!value.equals(value1)) {
                    Element parent = (Element) att.getParent();
                    // remove attribute so as not to triffer reset error
                    parent.removeAttribute(parent.getAttribute(att.getLocalName()));
                    att.setValue(value1);
                    parent.addAttribute(att);
                } else {
                }
            }
        }
    }

    /** get dataType.
     * if null sets value to dataType of child scalar;
     * if scalar is null set to xsd:string
     * @return the dataType
     */
    public String getDataType() {
        String dataType = super.getDataType();
        if (dataType == null) {
            CMLScalar scalar = this.getScalar();
            if (scalar != null) {
                dataType = scalar.getDataType();
            }
        }
        if (dataType == null) {
            dataType = XSD_STRING;
            this.setDataType(XSD_STRING);
        }
        return dataType;
    }

    /** substitutes and evaluates all eval attributes.
     *
     * @param argList
     */
    public void eval(List<CMLArg> argList) {
        Attribute eval = this.getEvalAttribute();
        if (eval != null) {
            for (CMLArg arg : argList) {
                arg.substituteNameByValue(eval);
            }
            String value = eval.getValue().trim();
            if (this.getDataType().equals(XSD_STRING)) {
            } else {
                value = value.replace(S_PLUS, CMLConstants.S_SPACE+S_PLUS+S_SPACE);
                value = value.replace(S_MINUS, CMLConstants.S_SPACE+S_MINUS+S_SPACE);
                String[] tokens = value.trim().split("\\s+");
                if (tokens.length % 2 != 1) {
                    throw new RuntimeException("bad eval for numeric data: "+value);
                }
                if (this.getDataType().equals(XSD_DOUBLE)) {
                    try {
                        double dd = new Double(tokens[0]).doubleValue();
                        String op = CMLConstants.S_EMPTY;
                        for (int i = 1; i < tokens.length; i+=2) {
                            op = tokens[i];
                            double d = new Double(tokens[i+1]).doubleValue();
                            if (op.equals(S_PLUS)) {
                                dd += d;
                            } else if (op.equals(S_MINUS)) {
                                dd -= d;
                            } else {
                                throw new RuntimeException("Bad operator: ("+op+") in eval: "+value);
                            }
                        }
                        this.setDouble(dd);
                    } catch (NumberFormatException e) {
                        throw new RuntimeException("Bad numeric double eval: "+value);
                    }
                } else if (this.getDataType().equals(XSD_INTEGER)) {
                    try {
                        int jj = Integer.parseInt(tokens[0]);
                        String op = CMLConstants.S_EMPTY;
                        for (int i = 1; i < tokens.length; i+=2) {
                            op = tokens[i];
                            int j = Integer.parseInt(tokens[i+1]);
                            if (op.equals(S_PLUS)) {
                                jj += j;
                            } else if (op.equals(S_MINUS)) {
                                jj -= j;
                            } else {
                                throw new RuntimeException("Bad operator: ("+op+") in eval: "+value);
                            }
                        }
                        this.setInteger(jj);
                    } catch (NumberFormatException e) {
                        throw new RuntimeException("Bad numeric integer eval: "+value);
                    }
                }
            }
        }
        Attribute evalx = this.getEvalAttribute();
        if (evalx != null) {
            evalx.detach();
        }

    }

    /** gets the integer value.
     * requires a child scalar of dataType xsd:integer
     * @return integer value
     * @throws RuntimeException if no integer scalar
     */
    public int getInteger() throws RuntimeException {
        CMLScalar scalar = getScalar();
        if (scalar == null) {
            throw new RuntimeException("no child scalar");
        }
        return scalar.getInt();
    }

    /** sets integer value.
     * creates scalar if necessary
     * @param i
     * @throws RuntimeException
     */
    public void setInteger(int i) throws RuntimeException {
        CMLScalar scalar = (CMLScalar) this.getChildCMLElement(CMLScalar.TAG, 0);
        if (scalar == null) {
            scalar = new CMLScalar(i);
            this.appendChild(scalar);
        } else {
            scalar.setValue(i);
        }
    }

    /** gets the string value.
     * requires a child scalar of dataType xsd:string
     * @return string value
     * @throws RuntimeException if no string scalar
     */
    public String getString() throws RuntimeException {
        String string = null;
        CMLScalar scalar = getScalar();
        if (scalar != null) {
            string = scalar.getXMLContent();
        } else {
            string = this.getValue();
        }
        return string;
    }

    /** sets string value.
     * creates scalar if necessary
     * @param s
     * @throws RuntimeException
     */
    public void setString(String s) throws RuntimeException {
        CMLScalar scalar = (CMLScalar) this.getChildCMLElement(CMLScalar.TAG, 0);
        if (scalar == null) {
            scalar = new CMLScalar(s);
            this.appendChild(scalar);
        } else {
            scalar.setXMLContent(s);
        }
    }

    /** gets the double value.
     * requires a child scalar of dataType xsd:double
     * @return double value
     * @throws RuntimeException if no double scalar
     */
    public double getDouble() throws RuntimeException {
        CMLScalar scalar = getScalar();
        if (scalar == null) {
            throw new RuntimeException("no child scalar");
        }
        return scalar.getDouble();
    }

    /** sets double value.
     * creates scalar if necessary
     * @param d
     * @throws RuntimeException
     */
    public void setDouble(double d) throws RuntimeException {
        CMLScalar scalar = (CMLScalar) this.getChildCMLElement(CMLScalar.TAG, 0);
        if (scalar == null) {
            scalar = new CMLScalar(d);
        } else {
            scalar.setValue(d);
        }
        this.appendChild(scalar);
    }

    /** get the first child scalar if any.
     *
     * @return the scalar
     */
    public CMLScalar getScalar() {
        Elements scalars = this.getChildCMLElements(CMLScalar.TAG);
        return (scalars == null || scalars.size() == 0) ?
            null : (CMLScalar) scalars.get(0);
    }

    /** process all instances of arg in element.
     *
     * @param element
     */
    public static void processArgs(CMLElement element) {
        Nodes parameterNameArgs =
            element.query(CMLArg.NS+"[@parameterName]", CMLConstants.CML_XPATH);
        for (int i = 0; i < parameterNameArgs.size(); i++) {
            CMLArg arg = (CMLArg) parameterNameArgs.get(i);
        }
    }

    /** substitute parameter value through element.
     *
     * @param element to edit
     * @param name of arg (must occur as arg in element)
     * @param value of arg
     */
    public static void substituteParameterName(
            CMLElement element, String name, String value) {
        String id = element.getAttributeValue(IdAttribute.NAME);
        CMLArg parameterArg = null;
        Nodes nameArgs =
            element.query(CMLArg.NS+"[@parameterName='"+name+"']", CMLConstants.CML_XPATH);
        if (nameArgs.size() == 0) {
        	element.debug("ARG NOT FOUND");
            throw new RuntimeException("arg not found: "+name+S_SLASH+id);
        } else if (nameArgs.size() > 1) {
            throw new RuntimeException("duplicate args: "+name+S_SLASH+id);
        } else {
            parameterArg = (CMLArg) nameArgs.get(0);
        }
        // replace {$xyz}
        String orig = START_CHARS+name+END_CHARS;
        Nodes nodes = element.query(".//@* | .//text()");
        for (int i = 0; i < nodes.size(); i++) {
            Node node = nodes.get(i);
            String val = node.getValue();
            if (val.indexOf(orig) != -1) {
                val = val.replace(orig, value);
                if (node instanceof Attribute) {
                    ((Attribute)node).setValue(val);
                } else if (node instanceof Text) {
                    ((Text)node).setValue(val);
                } else {
                    throw new RuntimeException("BUG "+node.getClass());
                }
            }
        }
        // remove arg
        parameterArg.detach();
    }

    /** process all arg/@parentAttribute in element.
     *
     * @param element to edit
     */
    public static void substituteParentAttributes(CMLElement element) {
        Nodes parentAttributeArgs =
            element.query(".//"+CMLArg.NS+"[@parentAttribute]", CMLConstants.CML_XPATH);
        for (int i = 0; i < parentAttributeArgs.size(); i++) {
            CMLArg parentAttributeArg = (CMLArg) parentAttributeArgs.get(i);
            String parentAttribute = parentAttributeArg.getParentAttribute();
            String attValue = parentAttributeArg.getString();
            Element parent = (Element) parentAttributeArg.getParent();
            ((CMLElement)parent).setAttribute(parentAttribute, attValue);
//            parent.addAttribute(new Attribute(parentAttribute, attValue));
            parentAttributeArg.detach();
        }
    }

    /** process all arg/@substitute in element.
     *
     * @param element to edit
     */
    public static void substituteTextContent(CMLElement element) {
        Nodes textContentArgs =
            element.query(".//"+CMLArg.NS+"[@substitute[.='.']]", CMLConstants.CML_XPATH);
        for (int i = 0; i < textContentArgs.size(); i++) {
            CMLArg textContentArg = (CMLArg) textContentArgs.get(i);
            String value = textContentArg.getValue();
            if (value.startsWith(START_CHARS) && value.endsWith(END_CHARS)) {
                // unsubstituted arg
            } else {
                Element parent = (Element) textContentArg.getParent();
                parent.appendChild(new Text(value));
            }
            textContentArg.detach();
        }
    }

    /** apply arg to element.
     * if this/@parentAttribute[.='foo'], add foo attribute with
     * value of arg
     * @param element
     */
    public void processArg(CMLElement element) {
        if (this.getParentAttribute() != null) {
            String parentAttribute = this.getParentAttribute();
            String value = this.getString();
            Element parent = (Element) this.getParent();
            parent.addAttribute(new Attribute(parentAttribute, value));
            this.detach();
        }
    }

    /** add arguments to descendant elements.
     * descendants mut have @ref.
     *
     * @param current context for search
     * @param localName of element to search for
     */
    public static void addIdxArgsWithSerialNumber(CMLElement current, String localName) {
        Nodes nodes = current.query(".//"+C_E+localName+"[@ref]", CMLConstants.CML_XPATH);
        Set<String> idSet = new HashSet<String>();
        for (int i = 0; i < nodes.size(); i++) {
            CMLElement element = (CMLElement) nodes.get(i);
            String serial = CMLConstants.S_EMPTY+(i+1);
            String id = element.getAttributeValue(IdAttribute.NAME);
            if (id == null) {
                id = CMLConstants.S_EMPTY+serial;
            } else {
                id += CMLConstants.S_UNDER+serial;
                if (idSet.contains(id)) {
                    throw new RuntimeException("Non-unique element id: "+id);
                }
            }
            element.addAttribute(new Attribute(IdAttribute.NAME, id));
            idSet.add(id);
            CMLArg arg = new CMLArg("idx", serial);
            element.appendChild(arg);
        }
    }
}
