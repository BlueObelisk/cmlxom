package org.xmlcml.cml.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import nu.xom.Element;
import nu.xom.Elements;


/**
 * class to manage child elements in similar manner to XOM Elements. differs
 * from XOM as this is iterable
 * 
 * @author pm286, and ramin
 * 
 * @param <E>
 */
public class CMLElements<E extends Element> implements Iterable<E>, CMLConstants {

    private ArrayList<E> elementsArray;

    private Class<?> type;

    /**
     * create from XOM elements.
     * 
     * @param elements
     */
    public CMLElements(Elements elements) {
        if (elements == null) {
            elementsArray = new ArrayList<E>(0);
        } else {
            elementsArray = new ArrayList<E>(elements.size());

            for (int i = 0; i < elements.size(); i++) {
                if (i == 0) {
                    type = elements.get(0).getClass();
                }
                if (elements.get(i).getClass().equals(type)) {
                    @SuppressWarnings("unchecked")
                    E elem = (E) elements.get(i);
                    elementsArray.add(elem);
                } else {
                    throw new RuntimeException(
                            "Elements list contains elements of different types");
                }
            }
        }
    }

    /**
     * iterator through elements.
     * 
     * @return the iterator
     */
    public Iterator<E> iterator() {
        return new CMLElementsIterator<E>(elementsArray);
    }

    /**
     * returns element by serial number.
     * 
     * @param i
     *            serial
     * @return element or null if i out of range
     */
    public E get(int i) {
        return (E) ((i < 0 || i >= elementsArray.size()) ? (E) null
                : elementsArray.get(i));
    }

    /**
     * size of elements.
     * 
     * @return the size (may be 0)
     */
    public int size() {
        return elementsArray.size();
    }

    /**
     * type of element. should be set at creation. If not, runs through all
     * elements checking type.
     * 
     * @return the class
     */
    public Class<?> getType() {
        if (type.equals(java.lang.Class.class)) {
            int i = 0;
            for (Element element : elementsArray) {
                Class<?> classx = element.getClass();
                if (i == 0) {
                    type = classx;
                } else if (!(type.equals(classx))) {
                    throw new RuntimeException("CMLElements is not homogeneous: "
                            + type + CMLConstants.S_SLASH + classx);
                }
                i++;
            }
        }
        return type;
    }

    /**
     * converts the elements into a List.
     * 
     * @return list (could be of length 0)
     */
    public List<E> getList() {
        return new ArrayList<E>(elementsArray);
    }

	class CMLElementsIterator<T extends Element> implements Iterator<T> {

        int index = 0;

        List<T> list;

        /**
         * iterator.
         * 
         * @param list
         */
        public CMLElementsIterator(List<T> list) {
            this.list = list;
        }

        /**
         * remove. not implemented
         */
        public void remove() {
            throw new UnsupportedOperationException();
        }

        /**
         * next.
         * 
         * @return next element
         */
        public T next() {
            return list.get(index++);
        }

        /**
         * has next.
         * 
         * @return true if more elements
         */
        public boolean hasNext() {
            return (index < list.size());
        }

    }

}
