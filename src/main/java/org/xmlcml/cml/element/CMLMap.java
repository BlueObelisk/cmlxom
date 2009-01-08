package org.xmlcml.cml.element;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nu.xom.Element;
import nu.xom.Node;

import org.apache.log4j.Logger;
import org.xmlcml.cml.base.CMLConstants;
import org.xmlcml.cml.base.CMLElement;
import org.xmlcml.cml.base.CMLElements;
import org.xmlcml.euclid.Util;

/**
 * user-modifiable class supporting map. these methods support generic links;
 * although the links may be typed, CMLMap itself does not support type-specific
 * methods
 */
public class CMLMap extends org.xmlcml.cml.element.AbstractMap {
	@SuppressWarnings("unused")
	private static Logger LOG = Logger.getLogger(CMLMap.class);


    /** direction of link */
    public enum Direction {

        /** Direction.TO attribute is to be used.         *
         */
        TO("to"),

        /**
         * Direction.FROM attribute is to be used.
         *
         */
        FROM("from"),

        /**
         * both ends of link matter
         *
         */
        BOTH("both"),

        /**
         * either end of link matters
         *
         */
        EITHER("either"),

        /**
         * neither end of link is involved. NEITHER
         * can be used when merging maps to ensure that links are only added
         * when neither the Direction.FROM or Direction.TO ref is represent in
         * *this* map.
         */
        NEITHER("neither");

        /** descriptive string */
        public final String value;

        private Direction(String s) {
            this.value = s;
        }

        /**
         * to string
         *
         * @return string
         */
        public String toString() {
            return value;
        }
    }

    static Logger logger = Logger.getLogger(CMLMap.class.getName());

    protected CMLMolecule molecule;

    // String content
    protected Map<String, String> toFromTable;
    protected Map<String, String> fromToTable;

    // Link content
    protected Map<String, CMLLink> toLinkTable;
    protected Map<String, CMLLink> fromLinkTable;

    /**
     * constructor.
     */
    public CMLMap() {
    }

    /**
     * constructor.
     *
     * @param old
     */
    public CMLMap(CMLMap old) {
        super((AbstractMap) old);
        copyFields(old);
    }

    /**
     * copy node .
     *
     * @return Node
     */
    public Node copy() {
        return new CMLMap(this);

    }

    private void copyFields(CMLMap old) {
        this.molecule = old.molecule;
    }

    /**
     * create new instance in context of parent, overridable by subclasses.
     *
     * @param parent
     *            parent of element to be constructed (ignored by default)
     * @return CMLMap
     */
    public CMLElement makeElementInContext(Element parent) {
        return new CMLMap();
    }

    /**
     * shouldn't be necessary.
     *
     * @param parent
     *            element
     */
    public void finishMakingElement(Element parent) {
        super.finishMakingElement(parent);
        // add links to tables
        makeTables();
        addLinks();
    }

    void addLinks() {
        CMLElements<CMLLink> links = this.getLinkElements();
        for (CMLLink link : links) {
            addLink(link);
        }
    }

    void checkAndCreateTablesAndAddLinks() {
        if (fromToTable == null ||
        		toFromTable == null ||
        		toLinkTable == null ||
        		fromLinkTable == null) {
            makeTables();
            addLinks();
        }
    }

    /**
     * returns the opposite of Direction.TO or Direction.FROM.
     *
     * @param toFrom
     *            Direction.TO or Direction.FROM
     * @return Direction.FROM or Direction.TO or null if other argument
     */
    public static Direction getReverseToFrom(Direction toFrom) {
        Direction d = null;
        if (toFrom.equals(Direction.TO)) {
            d = Direction.FROM;
        } else if (toFrom.equals(Direction.FROM)) {
            d = Direction.TO;
        }
        return d;
    }

    void clearTables() {
        makeTables();
        toFromTable.clear();
        fromToTable.clear();
        toLinkTable.clear();
        fromLinkTable.clear();
    }

    void makeTables() {
        if (toFromTable == null) {
            toFromTable = new HashMap<String, String>();
        }

        if (fromToTable == null) {
            fromToTable = new HashMap<String, String>();
        }

        if (toLinkTable == null) {
            toLinkTable = new HashMap<String, CMLLink>();
        }

        if (fromLinkTable == null) {
            fromLinkTable = new HashMap<String, CMLLink>();
        }
    }

    /** routes append to addLink.
     * 
     * @param link
     * @deprecated use addLink
     */
    public void appendChild(CMLLink link) {
    	this.addLink(link);
    }
    /**
     * add a link. adds links regardless of current links. normally this is not
     * safe so addUniqueLink should be used.
     *
     * @param link
     *            to add
     */
    public void addLink(CMLLink link) {
        if (link != null) {
            addLinkToTable(link);
            super.addLink(link);
        }
    }

    private String getFromLink(CMLLink link) {
        return (S_EMPTY.equals(link.getFrom())) ? 
        		Util.concatenate(link.getFromSet(), CMLConstants.S_SPACE) : link.getFrom();
    }

    private String getToLink(CMLLink link) {
        return (S_EMPTY.equals(link.getTo())) ? 
    		Util.concatenate(link.getToSet(), CMLConstants.S_SPACE) : link.getTo();
    }

    /**
     * add a link if consistent with existing ones. checks current to and from
     * attributes and adds if it does not duplicate existing link or is allowed
     * to overwrite. if neither to or from exists then link is added no warning
     * is given if link exists and is overwritten
     *
     * @param link to add
     * @param control
     *            EITHER overwrites any links with same to or same from BOTH
     *            overwrites link with both to and from identical NEITHER adds
     *            link only if to and from are missing in map
     */
    public void addUniqueLink(CMLLink link, Direction control) {
        String toLinkS = getToLink(link);
        String fromLinkS = getFromLink(link);

        if (control.equals(Direction.BOTH)) {
            CMLLink oldLink = getFromToLink(fromLinkS, toLinkS);
            if (oldLink != null) {
                removeLink(oldLink);
            }
            addLink(link);
        } else if (control.equals(Direction.FROM)) {
            throw new RuntimeException("FROM not implemented");
            // CMLLink oldLink = getFromToLink(fromLinkS, toLinkS);
            // if (oldLink != null) {
            // removeLink(oldLink);
            // }
            // addLink(link);
        } else if (control.equals(Direction.TO)) {
            throw new RuntimeException("TO not implemented");
            // CMLLink oldLink = getFromToLink(fromLinkS, toLinkS);
            // if (oldLink != null) {
            // removeLink(oldLink);
            // }
            // addLink(link);
        } else if (control.equals(Direction.EITHER)) {
            CMLLink toLink = getLink(toLinkS, Direction.TO);
            CMLLink fromLink = getLink(fromLinkS, Direction.FROM);
            if (fromLink == null) {
                removeLink(fromLink);
            }
            if (toLink != null) {
                removeLink(fromLink);
            }
            addLink(link);
        } else if (control.equals(Direction.NEITHER)) {
            CMLLink toLink = getLink(toLinkS, Direction.TO);
            CMLLink fromLink = getLink(fromLinkS, Direction.FROM);
            if (toLink != null) {
                // error?
                if (fromLink != null) {
                    // error?
                }
            } else if (fromLink != null) {
                // error?
            } else {
                addLink(link);
            }
        }
    }

    /**
     * add map.
     *
     * do not check duplicate links. results is simple sum of maps (in order)
     * map2 is not affected
     *
     * @param map2
     *            with links to add
     */
    public void addMap(CMLMap map2) {
        for (CMLLink link : map2.getLinkElements()) {
            CMLLink newLink = new CMLLink();
            copyAttributesFromTo(link, newLink);
            this.addLink(newLink);
        }
    }

    /**
     * add a link to table.
     *
     * @param link to add
     */
    void addLinkToTable(CMLLink link) {
        makeTables();
        if (link != null) {
            String toLinkS = getToLink(link);
            String fromLinkS = getFromLink(link);
            fromToTable.put(fromLinkS, toLinkS);
            toFromTable.put(toLinkS, fromLinkS);
            fromLinkTable.put(fromLinkS, link);
            toLinkTable.put(toLinkS, link);
        }
    }

    /**
     * remove a link.
     *
     * @param link
     *            to remove
     */
    public void removeLink(CMLLink link) {
        if (link != null) {
            String to = getToLink(link);
            String from = getFromLink(link);
            toFromTable.remove(to);
            toLinkTable.remove(to);
            fromLinkTable.remove(from);
            fromToTable.remove(from);
            link.detach();
        }
    }

    /**
     * gets array of to attributes. does not do toSet
     *
     * @return the to attributes
     */
    public List<String> getToRefs() {
    	makeTables();
        List<String> toRefs = new ArrayList<String>();
        for (CMLLink link : getLinkElements()) {
        	if (link.getTo() != null) {
        		toRefs.add(link.getTo());
        	}
        }
        return toRefs;
    }

    /**
     * gets array of toSet attributes. does not do to
     *
     * @return the toSet attributes
     */
    public List<String[]> getToSetRefs() {
    	makeTables();
        List<String[]> toSetRefs = new ArrayList<String[]>();
        for (CMLLink link : getLinkElements()) {
            if(link.getToSet() != null) {
            	toSetRefs.add(link.getToSet());
            }
        }
        return toSetRefs;
    }

    /**
     * gets array of from attributes. does not do fromSet
     *
     * @return the from attributes
     */
    public List<String> getFromRefs() {
    	makeTables();
        List<String> fromRefs = new ArrayList<String>();
        for (CMLLink link : getLinkElements()) {
        	if (link.getFrom() != null) {
        		fromRefs.add(link.getFrom());
        	}
        }
        return fromRefs;
    }
    
    /**
     * gets array of fromSet attributes. does not do from
     *
     * @return the from attributes
     */
    public List<String[]> getFromSetRefs() {
    	makeTables();
        List<String[]> fromSetRefs = new ArrayList<String[]>();
        for (CMLLink link : getLinkElements()) {
            if(link.getFromSet() != null) {
            	fromSetRefs.add(link.getFromSet());
            }
        }
        return fromSetRefs;
    }


    /**
     * gets mapped fromTo atomId. works with sets
     *
     * @param fromId
     *            in the from attributes
     * @return the atomIds in the to attributes
     */
    public String getToRef(String fromId) {
    	makeTables();
        return (fromToTable == null) ? null : fromToTable.get(fromId);
    }

    /**
     * gets mapped toFrom atomIds. works with sets
     *
     * @param toId
     *            in the to attributes
     * @return the atomId in the from attributes
     */
    public String getFromRef(String toId) {
    	makeTables();
        return (fromToTable == null) ? null : toFromTable.get(toId);
    }

    /**
     * gets mapped fromTo ids.
     *
     * @param fromIds
     *            from attributes
     * @return List of corresponding to attributes (may include nulls if not
     *         found
     */
    public List<String> getToRefs(List<String> fromIds) {
    	makeTables();
        List<String> toRefs = new ArrayList<String>();
        for (String fromId : fromIds) {
            String toRef = getToRef(fromId);
            toRefs.add(toRef);
        }
        return toRefs;
    }

    /**
     * gets mapped fromTo ids.
     *
     * @param toIds
     *            to attributes
     * @return List of corresponding from attributes (may include nulls if not
     *         found
     */
    public List<String> getFromRefs(List<String> toIds) {
    	makeTables();
        List<String> fromRefs = new ArrayList<String>();
        for (String toId : toIds) {
            fromRefs.add(getFromRef(toId));
        }
        return fromRefs;
    }

    /**
     * gets array of to or from attributes. does not work with sets
     *
     * @param toFrom
     *            either Direction.TO or Direction.FROM
     * @return the to or from attributes
     */
    public List<String> getRefs(Direction toFrom) {
    	makeTables();
        List<String> refs = new ArrayList<String>();
        for (CMLLink link : getLinkElements()) {
            refs.add((toFrom.equals(Direction.TO)) ? link.getTo() : link
                    .getFrom());
        }
        return refs;
    }

    /**
     * gets array of mapped to or from attributes. does not work with sets
     *
     * if toFrom is Direction.FROM then the returned string are the
     * Direction.FROM refs corresponding to an array of Direction.TO values
     *
     * @param ids
     *            the ids to be mapped, type determined by toFrom
     * @param toFrom
     *            either Direction.TO or Direction.FROM.
     * @return the mapped attributes
     */
    public List<String> getRefs(List<String> ids, Direction toFrom) {
    	makeTables();
        List<String> ref = new ArrayList<String>();
        for (String id : ids) {
            ref.add((toFrom == Direction.FROM) ? getFromRef(id) : getToRef(id));
        }
        return ref;

    }

    /**
     * gets mapped to or from attribute. works with sets
     *
     * if toFrom is Direction.FROM, returns the from attribute corresponding to
     * the to attribute with value id thus for a map with some link <link
     * from="f" to="t"/> getRef("t", Direction.FROM) returns "f"
     *
     * @param id
     *            the id to be mapped, type determined by toFrom
     * @param toFrom
     *            either Direction.TO or Direction.FROM.
     * @return the mapped attribute or null if not matched
     */
    public String getRef(String id, Direction toFrom) {
    	makeTables();
        checkAndCreateTablesAndAddLinks();
        Map<String, String> table = (toFrom == Direction.FROM) ? fromToTable
                : toFromTable;
        return (table == null || id == null) ? null : table.get(id);
    }

    /**
     * gets link mapped to or from attribute. works with sets
     *
     * if toFrom is Direction.FROM, returns the link corresponding to the to
     * attribute with value id thus for a map with some link <link from="f"
     * to="t"/> getRef("t", Direction.FROM) returns the link
     *
     * @param id
     *            the id to be mapped, type determined by toFrom
     * @param toFrom
     *            either Direction.TO or Direction.FROM.
     * @return the mapped link or null if not matched
     */
    public CMLLink getLink(String id, Direction toFrom) {
    	makeTables();
        checkAndCreateTablesAndAddLinks();
        String ref = getRef(id, toFrom);
        return (CMLLink) ((id == null || ref == null) ? null : ((toFrom
                .equals(Direction.FROM)) ? toLinkTable.get(ref) : fromLinkTable
                .get(ref)));
    }

    /**
     * gets link from to and from attributes. does not work with sets
     *
     * @param from value of the from attribute
     * @param to  value of the to attribute
     * @return the link corresponding to these or null if not exists
     */
    public CMLLink getFromToLink(String from, String to) {
    	makeTables();
        CMLLink link = getLink(to, Direction.TO);
        if (link != null) {
            link = (link.getFrom().equals(from)) ? link : null;
        }
        return link;
    }

    /**
     * merges a map with this. The links in the second map can be added with
     * varying strategies (control) NEITHER. Only add link if neither from or to
     * is present in this map BOTH. Add (and therefore replace) link if both to
     * and from exist in a single link EITHER. Adds link. if either to or from
     * is present removes old link existing links
     *
     * @param addMap
     *            map to add. Not altered (links are copied)
     * @param control
     *            EITHER, BOTH, NEITHER
     */
    public void mergeMap(CMLMap addMap, Direction control) {
        if (addMap != null) {
            for (CMLLink link : addMap.getLinkElements()) {
                this.addUniqueLink(new CMLLink(link), control);
            }
        }
    }

    /**
     * set the Direction.FROM context for all links.
     *
     * @param context
     *            to set
     */
    public void setLinkFromContext(String context) {
        for (CMLLink link : getLinkElements()) {
            link.setFromContext(context);
        }
    }

    /**
     * set the Direction.TO context for all links.
     *
     * @param context
     *            to set
     */
    public void setLinkToContext(String context) {
        for (CMLLink link : getLinkElements()) {
            link.setToContext(context);
        }
    }

    /**
     * set the Direction.FROM type for all child links. only works on current
     * list (i,e, if more links are added it should be repeated
     *
     * @param type
     *            to set
     */
    public void setLinkFromType(String type) {
        for (CMLLink link : getLinkElements()) {
            link.setFromType(type);
        }
    }

    /**
     * set the Direction.TO type for all links. only works on current list (i,e,
     * if more links are added it should be repeated
     *
     * @param type
     *            to set
     */
    public void setLinkToType(String type) {
        for (CMLLink link : getLinkElements()) {
            link.setToType(type);
        }
    }

    /**
     * extract all links involving particular elements. requires the link to
     * have fromType='foo' and toType='foo' and toSet and fromSet attributes
     * does not yet process them
     *
     * @param tag
     * @return all links containing sets of atoms.
     */
    public List<CMLLink> getElementLinks(String tag) {
        List<CMLLink> linkList = new ArrayList<CMLLink>();
        for (CMLLink link : getLinkElements()) {
            String toType = CMLMap.getType(link, Direction.TO);
            String fromType = CMLMap.getType(link, Direction.FROM);
            if (tag.equals(toType) && tag.equals(fromType)) {
                String toSet = Util.concatenate(link.getToSet(), CMLConstants.S_SPACE);
                String fromSet = Util.concatenate(link.getFromSet(), CMLConstants.S_SPACE);
                if (toSet != null && !S_EMPTY.equals(toSet.trim())
                        && fromSet != null && !S_EMPTY.equals(fromSet.trim())) {
                    linkList.add(link);
                }
            }
        }
        return linkList;
    }

    /**
     * gets type of link. // FIXME - create LinkTool use toType or fromType on
     * link, else use toType/fromType on parent CMLMap. probably needs to be
     * recast for LinkTool when written
     *
     * @param link
     * @param toFrom
     *            Direction.TO or Direction.FROM
     * @return the to/from type or null
     */
    public static String getType(CMLLink link, Direction toFrom) {
        String type = (toFrom.equals(Direction.TO)) ? link.getToType() : link
                .getFromType();
        if (type == null || type.trim().equals(S_EMPTY)) {
            Node parent = link.getParent();
            if (parent != null && parent instanceof CMLMap) {
                CMLMap map = (CMLMap) parent;
                type = (toFrom.equals(Direction.TO)) ? map.getToType() : map
                        .getFromType();
            }
        }
        return type;

    }

    /**
     * annote each link with context and type. (often better done in parent map)
     *
     * @param fromType
     * @param fromContext
     * @param toType
     * @param toContext
     */
    public void annotateLinks(String fromType, String fromContext,
            String toType, String toContext) {
        this.setLinkToContext(toContext);
        this.setLinkFromContext(fromContext);
        this.setLinkToType(toType);
        this.setLinkFromType(fromType);
    }
}
