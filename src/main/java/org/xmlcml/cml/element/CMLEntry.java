package org.xmlcml.cml.element;

import nu.xom.Element;
import nu.xom.Node;

import org.xmlcml.cml.base.CMLElement;

/**
 * The enumerations are managed by the IndexableByIdList mechanism
 */
public class CMLEntry extends AbstractEntry {

	/** namespaced element name.*/
	public final static String NS = C_E+TAG;

//    private IndexableByIdListManager indexableListManager;
    /**
     * constructor.
     */
    public CMLEntry() {
//    	ensureManager();
    }

//    private void ensureManager() {
//    	if (this.indexableListManager == null) {
//    		this.indexableListManager = new IndexableByIdListManager(this);
//    	}
//    }
//
//    /** get listManager
//     * @return list manager
//     */
//    public IndexableByIdListManager getIndexableListManager() {
//    	ensureManager();
//    	return indexableListManager;
//    }

    /**
     * constructor.
     *
     * @param old
     */
    public CMLEntry(CMLEntry old) {
        super((AbstractEntry) old);

    }

    /**
     * normal constructor.
     *
     * @param id of entry (should be unique within dictionary);
     */
    public CMLEntry(String id) {
        this();
        this.setId(id);
    }

    /**
     * copy node .
     *
     * @return Node
     */
    public Node copy() {
        return new CMLEntry(this);

    }

    /**
     * create new instance in context of parent, overridable by subclasses.
     *
     * @param parent of element to be constructed (ignored by default)
     * @return CMLEntry
     */
    public CMLElement makeElementInContext(Element parent) {
        return new CMLEntry();

    }

//    /** get list of enumerations.
//     * @return list
//     */
//    public List<Indexable> getIndexables() {
//    	ensureManager();
//    	return indexableListManager.getIndexables();
//    }
//
//    /** add enumeration.
//     * @param indexable to add
//     */
//    public void addIndexable(Indexable indexable) {
//    	ensureManager();
//    	indexableListManager.add(indexable);
//    }
//
//    /** insert molecule.
//     * @param indexable to add
//     * @param position
//     */
//    public void insertIndexable(Indexable indexable, int position) {
//    	ensureManager();
//    	indexableListManager.insert(indexable, position);
//    }
//
//    /** insert enumeration in order.
//     * @param indexable to add
//     */
//    public void insertIndexableInOrder(Indexable indexable) {
//    	ensureManager();
//    	indexableListManager.insertInOrderOfId(indexable);
//    }
//
//    /** remove enumeration.
//     * @param indexable to remove
//     */
//    public void removeIndexable(Indexable indexable) {
//    	ensureManager();
//    	indexableListManager.remove(indexable);
//    }
//
//    /** get enumeration by id (from interface)
//     * @param id
//     * @return enumeration or null
//     */
//    public Indexable getIndexableById(String id) {
//    	ensureManager();
//    	return indexableListManager.getById(id);
//    }
//
//    /** get index
//     * @return enumeration or null
//     */
//    public Map<String, Indexable> getIndex() {
//    	ensureManager();
//    	return indexableListManager.getIndex();
//    }
//
//    /** class of children.
//     * @return CMLEnumeration.class
//     */
//    public Class<?> getIndexableClass() {
//    	return CMLEnumeration.class;
//    }
//
//    /** name of child element.
//     * @return CMLEnumeration.TAG
//     */
//    public String getIndexableLocalName() {
//    	return CMLEnumeration.TAG;
//    }
//
//    /** update the index.
//     */
//    public void updateIndex() {
//    	ensureManager();
//    	this.indexableListManager.indexList();
//    }
//
//	/** sort enumerations in each entry
//	 */
//    public void sortEnumerations() {
//    	TreeSet<CMLEnumeration> treeSet = new TreeSet<CMLEnumeration>();
//    	for (CMLEnumeration enumeration : this.getEnumerationElements()) {
//    		treeSet.add(enumeration);
//    		enumeration.detach();
//    	}
//    	Iterator<CMLEnumeration> iterator = treeSet.iterator();
//    	while (iterator.hasNext()) {
//    		CMLEnumeration enumeration = (CMLEnumeration) iterator.next();
//    		this.appendChild(enumeration);
//    	}
//    }
//
    /** set term if not already set.
     * if entry already has different term, throw exception
     * @param term 
     */
    public void checkAndSetTerm(String term) {
    	if (term != null) {
			String thisTerm = this.getTerm();
			// make new entry?
			if (thisTerm != null && !thisTerm.equals(term)) {
				throw new RuntimeException("current term ["+this.getId()+"] ("+thisTerm+") different from ("+term+")");
			}
			this.setTerm(term);
		}
    }
}
