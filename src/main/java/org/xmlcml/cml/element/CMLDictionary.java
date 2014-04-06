/**
 *    Copyright 2011 Peter Murray-Rust et. al.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package org.xmlcml.cml.element;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Node;
import nu.xom.ParsingException;
import nu.xom.ValidityException;

import org.apache.log4j.Logger;
import org.xmlcml.cml.base.CMLBuilder;
import org.xmlcml.cml.base.CMLElement;
import org.xmlcml.cml.base.CMLElements;
import org.xmlcml.cml.base.CMLUtil;

/**
 * user-modifiable class supporting dictionary. *
 */
public class CMLDictionary extends AbstractDictionary {
	private final static Logger LOG = Logger.getLogger(CMLDictionary.class);

	/** namespaced element name.*/
	public final static String NS = C_E+TAG;

	protected Map<String, CMLEntry> entryMap = null;

	/**
	 * constructor.
	 */
	public CMLDictionary() {
	}

	/**
	 * constructor.
	 *
	 * @param old
	 */
	public CMLDictionary(CMLDictionary old) {
		super((AbstractDictionary) old);
	}

	/**
	 * copy node .
	 *
	 * @return Node
	 */
	public Node copy() {
		return new CMLDictionary(this);

	}

	/**
	 * create new instance in context of parent, overridable by subclasses.
	 *
	 * @param parent
	 *            parent of element to be constructed (ignored by default)
	 * @return CMLDictionary
	 */
	public CMLElement makeElementInContext(Element parent) {
		return new CMLDictionary();
	}

	/**
	 * index entries by id.
	 *
	 */
	public int indexEntries() {
		if (entryMap == null) {
			entryMap = new HashMap<String, CMLEntry>();
			CMLElements<CMLEntry> entryNodes = this.getEntryElements();
			for (CMLEntry entry : entryNodes) {
				String id = entry.getId();
				if (id != null) {
					entryMap.put(id, entry);
				}
			}
			LOG.trace("Created dictionary with entries: "+entryNodes.size());
		} 
		return entryMap.size();
	}

	/**
	 * creates dictionary from file;
	 * effectively static but requires to be called from a dictionary object
	 * @param file
	 *            file to create from
	 * @return the dictionary or null
	 * @throws IOException
	 * @throws RuntimeException
	 *             if file is not a well-formed dictionary
	 */
	public CMLDictionary createDictionary(File file) throws IOException {
		return createDictionary(file.toURI().toURL());
	}

	public static CMLDictionary createDictionary0(File file) throws IOException {
		return createDictionary(file.toURI().toURL());
	}

	public static CMLDictionary createDictionary(URL url) throws IOException {
		InputStream in = null;
		CMLDictionary dictionary = null;
		// this will fail if dictionary is badly formed
		try {
			in = url.openStream();
			dictionary = createDictionary(in);
		} catch (Exception e) {
			throw new RuntimeException("Cannot create dictionary", e);
		}
		finally {
			try {
				in.close();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
		return dictionary;
	}

	public static CMLDictionary createDictionary(InputStream is) throws IOException {
		CMLDictionary cmlDictionary = null;
		try {
			Element element = new CMLBuilder().build(is).getRootElement();
			cmlDictionary = (CMLDictionary) CMLUtil.getSingleElement(element, ".//self::cml:dictionary", CML_XPATH);
			cmlDictionary.indexEntries();
		} catch (Exception e) {
			throw new RuntimeException("Cannot create dictionary", e);
		}
		return cmlDictionary;
	}

	/**
	 * get Entry by id.
	 *
	 * @deprecated use getCMLEntry()
	 * @param id
	 *            the entryId (null if absent)
	 * @return entry
	 */
	public CMLEntry getGenericEntry(String id) {
		return getCMLEntry(id);
		// throw new CMLRuntime("deprecated, use getCMLEntry()");
	}

	/** get Entry by id.
	 * do not ignore case
	 * @param id the entryId (null if absent)
	 * @return entry
	 */
	public CMLEntry getCMLEntry(String id) {
		int nentries = this.indexEntries();
		return entryMap.get(id);
	}

	/**
	 * add new Entry.
	 *
	 * @param entry
	 *            to add
	 * @throws RuntimeException
	 *             entry already present.
	 */
	public void addEntry(CMLEntry entry) {
		String id = entry.getId();
		if (id == null) {
			throw new RuntimeException("Entry has no id");
		}
		if (getCMLEntry(id) != null) {
			throw new RuntimeException("Entry for " + id + " already present");
		}
		entryMap.put(id, entry);
		this.appendChild(entry);
	}

	/**
	 * add new Entry in order of id
	 *
	 * @param entry to add
	 * @throws RuntimeException
	 *             entry already present.
	 */
	public void addEntryInOrder(CMLEntry entry) {
		String id = entry.getId();
		if (id == null) {
			throw new RuntimeException("Entry has no id");
		}
		if (getCMLEntry(id) == null) {
			entryMap.put(id, entry);
			CMLElements<CMLEntry> entries = this.getEntryElements();
			int idx = entries.size();
			for (CMLEntry entry0 : entries) {
				if (id.compareTo(entry0.getId()) < 0) {
					idx = this.indexOf(entry0);
					break;
				}
			}
			this.insertChild(entry, idx);
		}
	}

	/**
	 * remove Entry. calls removeEntryById()
	 *
	 * @param entry
	 *            to remove, no action if not present
	 *
	 */
	public void removeEntry(CMLEntry entry) {
		String id = entry.getId();
		removeEntryById(id);
	}

	/**
	 * remove Entry by id. the preferred method
	 *
	 * @param id
	 *            of entry to remove, no action if null or not present
	 *
	 */
	public void removeEntryById(String id) {
		if (id != null) {
			CMLEntry entry1 = (CMLEntry) this.getCMLEntry(id);
			if (entry1 != null) {
				entryMap.remove(id);
				entry1.detach();
			}
		}
	}

//	/**
//	 * create dictionaryMap.
//	 *
//	 * @param file
//	 * @param useSubdirectories
//	 * @return dictionaryMap
//	 */
//	public GenericDictionaryMap createDictionaryMap(File file,
//			boolean useSubdirectories) {
//		return null;
//	}

//	/** sort entries.
//	 * also sorts enumerations in each entry
//	 */
//    public void sortEntries() {
//    	TreeSet<CMLEntry> treeSet = new TreeSet<CMLEntry>();
//    	for (CMLEntry entry : this.getEntryElements()) {
//    		treeSet.add(entry);
//    		entry.detach();
//    	}
//    	Iterator<CMLEntry> iterator = treeSet.iterator();
//    	while (iterator.hasNext()) {
//    		CMLEntry entry = (CMLEntry) iterator.next();
//    		this.appendChild(entry);
//    		entry.sortEnumerations();
//    	}
//    }
}
