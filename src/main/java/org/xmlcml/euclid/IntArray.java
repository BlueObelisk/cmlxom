package org.xmlcml.euclid;

import org.apache.log4j.Logger;

/**
 * array of ints
 * 
 * IntArray represents a 1-dimensional vector or array of ints and is basically
 * a wrapper for int[] in Java There are a lot of useful member functions
 * (sorting, ranges, parallel operations The default is an array with zero
 * points All arrays are valid objects. Attempting to create an array with < 0
 * points creates a default array (zero points). Since int[] knows its length
 * (unlike C), there are many cases where int[] can be safely used. However it
 * is not a first-class object and IntArray supplies this feature int[] is
 * referenceable through getArray() note that the length of the internal array
 * may not be a useful guide to the number of elements
 * 
 * @author (C) P. Murray-Rust, 1996
 */
public class IntArray extends ArrayBase {
    final static Logger logger = Logger.getLogger(IntArray.class.getName());
    /**
     * maximum number of elements (for bound checking)
     * 
     * resettable
     */
    private int maxelem = 10000;
    /**
     * actual number of elements
     */
    int nelem;
    /**
     * the array of ints
     */
    int[] array;
    int bufsize = 5;
    /**
     * create default Array. default is an array of zero points
     */
    public IntArray() {
        nelem = 0;
        bufsize = 5;
        array = new int[bufsize];
    }
    /**
     * checks potential size of array. if n < 0, set to 0, otherwise adjust
     * bufsize to be consistent
     * 
     * @param n
     *            size of array
     * @return false if negative
     */
    private boolean checkSize(int n) {
        if (n < 0) {
            n = 0;
            return false;
        } else {
            nelem = n;
            if (nelem > maxelem)
                maxelem = nelem;
            if (bufsize < nelem)
                bufsize = nelem;
            return true;
        }
    }
    // expands buffer if necessary and copies array into it
    private void makeSpace(int newCount) {
        if (newCount > bufsize) {
            while (newCount > bufsize) {
                bufsize *= 2;
            }
            int[] array1 = new int[bufsize];
            System.arraycopy(array, 0, array1, 0, nelem);
            array = array1;
        }
    }
    /**
     * creates n-element array. initialised to 0
     * 
     * @param n
     *            size of array
     */
    public IntArray(int n) {
        this(n, 0);
    }
    /**
     * create n-element array initialised linearly. values are elem1+(i-1)*delta
     * 
     * @param n
     *            size of array
     * @param elem1
     *            starting value
     * @param delta
     *            setpsize
     */
    public IntArray(int n, int elem1, int delta) {
        if (!checkSize(n))
            return;
        array = new int[n];
        bufsize = n;
        int ff = elem1;
        for (int i = 0; i < n; i++) {
            array[i] = ff;
            ff += delta;
        }
    }
    /**
     * create Array initialized to constant value. all elements of the array are
     * set to a given value
     * 
     * @param n
     *            size of array
     * @param elem1
     *            value to set
     */
    public IntArray(int n, int elem1) {
        if (!checkSize(n))
            return;
        array = new int[n];
        bufsize = n;
        for (int i = 0; i < n; i++) {
            array[i] = elem1;
        }
    }
    /**
     * create Array from part of java array. use first n elements of array.
     * 
     * @param n
     *            number of elements to use
     * @param arr
     *            array to read from
     * @throws EuclidRuntimeException
     *             n larger than arraysize
     */
    public IntArray(int n, int[] arr) throws EuclidRuntimeException {
        if (!checkSize(n))
            throw new EuclidRuntimeException("Cannot have negative array length");
        if (n > arr.length) {
            throw new EuclidRuntimeException("Array would overflow");
        }
        array = new int[n];
        bufsize = n;
        System.arraycopy(arr, 0, array, 0, n);
    }
    /**
     * create Array from java array.
     * 
     * @param arr
     *            array to read from
     */
    public IntArray(int[] arr) {
        nelem = arr.length;
        array = new int[nelem];
        bufsize = nelem;
        System.arraycopy(arr, 0, array, 0, nelem);
    }
    /**
     * create from subarray of another Array.
     * 
     * @param m
     *            array to slice
     * @param low
     *            inclusive start index of array
     * @param high
     *            inclusive end index of array
     * @throws EuclidRuntimeException
     *             low > high or negative indices or outside size of m
     */
    public IntArray(IntArray m, int low, int high) throws EuclidRuntimeException {
        if (low < 0 || low > high || high >= m.size()) {
            throw new EuclidRuntimeException("index out of range: " + low + EC.S_SLASH + high);
        }
        nelem = high - low + 1;
        checkSize(nelem);
        array = new int[nelem];
        bufsize = nelem;
        System.arraycopy(m.array, low, array, 0, nelem);
    }
    /**
     * create mixed sliced array. use another IntArray to subscript this one
     * where I(this) = I(ref) subscripted by I(sub); Result has dimension of
     * I(sub). caller is responsible for making sure elements of sub are unique
     * 
     * @param ref
     *            matrix to slice
     * @param sub
     *            subscripts.
     * @throws EuclidRuntimeException
     *             if any of I(sub) lies outside 0...refmax-1
     */
    public IntArray(IntArray ref, IntArray sub) throws EuclidRuntimeException {
        this(sub.size());
        for (int i = 0; i < sub.size(); i++) {
            int j = sub.elementAt(i);
            if (j < 0 || j >= ref.size()) {
                throw new EuclidRuntimeException();
            }
            this.setElementAt(i, ref.elementAt(j));
        }
    }
    /**
     * clone.
     * 
     * @return the clone
     */
    public Object clone() {
        IntArray temp = new IntArray(nelem);
        temp.nelem = nelem;
        temp.maxelem = maxelem;
        System.arraycopy(array, 0, temp.array, 0, nelem);
        temp.bufsize = nelem;
        return (Object) temp;
    }
    /**
     * copy constructor.
     * 
     * @param m
     *            array to copy
     */
    public IntArray(IntArray m) {
        this.shallowCopy(m);
        System.arraycopy(m.array, 0, array, 0, nelem);
    }
    /**
     * Create customized array. create a given 'shape' of array for data
     * filtering An intended use is with IntArray.arrayFilter(). The shapes
     * (before scaling by maxval) are:
     * <UL>
     * <LI>"TRIANGLE"; 1/nn, 2/nn, ... 1 ... 2/nn, 1/nn; nelem is set to 2*nn -
     * 1
     * <LI>"ZIGZAG"; 1/nn, 2/nn, ... 1 ... 1/nn, 0, -1/nn, -2/nn, -1, ...
     * -1/nn,; nelem is set to 4*nn - 1
     * </UL>
     * step is maxval / nn
     * 
     * @param nn
     *            number of elements
     * @param shape
     *            TRIANGLE or ZIGZAG
     * @param maxval
     *            used to compute step
     */
    public IntArray(int nn, String shape, int maxval) {
        if (shape.toUpperCase().equals("TRIANGLE")) {
            nelem = nn * 2 - 1;
            if (!checkSize(nelem))
                return;
            array = new int[nelem];
            int delta = maxval / ((int) nn);
            for (int i = 0; i < nn; i++) {
                array[i] = (i + 1) * delta;
                array[nelem - i - 1] = array[i];
            }
        } else if (shape.toUpperCase().equals("ZIGZAG")) {
            nelem = nn * 4 - 1;
            if (!checkSize(nelem))
                return;
            array = new int[nelem];
            int delta = maxval / ((int) nn);
            for (int i = 0; i < nn; i++) {
                array[i] = (i + 1) * delta;
                array[2 * nn - i - 2] = array[i];
                array[2 * nn + i] = -array[i];
                array[nelem - i - 1] = -array[i];
            }
            array[2 * nn - 1] = 0;
        }
    }
    /**
     * construct from an array of Strings. must represent integers
     * 
     * @param strings values as Strings
     * @exception NumberFormatException
     *                a string could not be interpreted as integer
     */
    public IntArray(String[] strings) throws NumberFormatException {
        this(strings.length);
        for (int i = 0; i < strings.length; i++) {
            array[i] = (Integer.valueOf(strings[i])).intValue();
        }
    }
    /**
     * create from a space-separated string of integers.
     * 
     * @param string
     *            of form "1 3 56 2..."
     * @exception NumberFormatException
     *                a substring could not be interpreted as integer
     */
    public IntArray(String string) throws NumberFormatException {
        this(string.split(S_WHITEREGEX));
    }
    /**
     * contracts internal array to be of same length as number of elements.
     * 
     * should be used if the array will be used elsewhere with a fixed length.
     * 
     */
    public void contractArray() {
        int[] array1 = new int[nelem];
        System.arraycopy(array, 0, array1, 0, nelem);
        array = array1;
    }
    /**
     * shallowCopy
     * 
     * @param m
     */
    public void shallowCopy(IntArray m) {
        nelem = m.nelem;
        bufsize = m.bufsize;
        maxelem = m.maxelem;
        array = m.array;
    }
    /**
     * get element by index.
     * 
     * @param elem
     *            the index
     * @exception ArrayIndexOutOfBoundsException
     *                elem >= size of <TT>this</TT>
     * @return element value
     */
    public int elementAt(int elem) throws ArrayIndexOutOfBoundsException {
        return array[elem];
    }
    /**
     * get actual number of elements.
     * 
     * @return number of elements
     */
    public int size() {
        return nelem;
    }
    /**
     * get java array.
     * 
     * @return the array
     */
    public int[] getArray() {
        if (nelem != array.length) {
            int[] temp = new int[nelem];
            System.arraycopy(array, 0, temp, 0, nelem);
            array = temp;
        }
        return array;
    }
    /**
     * are two arrays equal.
     * 
     * @param f
     *            array to compare
     * @return true if arrays are of same size and elements are equal)
     */
    public boolean equals(IntArray f) {
        boolean equal = false;
        try {
            checkConformable(f);
            equal = true;
            for (int i = 0; i < nelem; i++) {
                if (array[i] != f.array[i]) {
                    equal = false;
                    break;
                }
            }
        } catch (Exception e) {
            equal = false;
        }
        return equal;
    }
    /**
     * clear all elements of array. sets value to 0
     */
    public void clearArray() {
        for (int i = 0; i < size(); i++) {
            array[i] = 0;
        }
    }
    /**
     * get java array in reverse order.
     * 
     * @return array
     */
    public int[] getReverseArray() {
        int count = size();
        int[] temp = new int[count];
        for (int i = 0; i < size(); i++) {
            temp[i] = this.array[--count];
        }
        return temp;
    }
    /**
     * reset the maximum index (for when poking elements) (no other effect)
     */
    /*--
     public void setMaxIndex(int max) {
     maxelem = max;
     }
     --*/
    private void checkConformable(IntArray m) throws EuclidRuntimeException {
        if (nelem != m.nelem) {
            throw new EuclidRuntimeException();
        }
    }
    /**
     * are two arrays equal.
     * 
     * @param f
     *            array to compare
     * @return true if arrays are of same size and this(i) = f(i)
     */
    public boolean isEqualTo(IntArray f) {
        boolean equal = false;
        try {
            checkConformable(f);
            equal = true;
            for (int i = 0; i < nelem; i++) {
                if (array[i] != f.array[i]) {
                    equal = false;
                    break;
                }
            }
        } catch (Exception e) {
            equal = false;
        }
        return equal;
    }
    /**
     * adds arrays. does not modify this
     * 
     * @param f
     *            array to add
     * @exception EuclidRuntimeException
     *                f is different size from <TT>this</TT>
     * @return new array as this + f
     */
    public IntArray plus(IntArray f) throws EuclidRuntimeException {
        checkConformable(f);
        IntArray m = (IntArray) this.clone();
        for (int i = 0; i < nelem; i++) {
            m.array[i] = f.array[i] + array[i];
        }
        return m;
    }
    /**
     * subtracts arrays. does not modify this
     * 
     * @param f
     *            array to substract
     * @exception EuclidRuntimeException
     *                f is different size from <TT>this</TT>
     * @return new array as this - f
     */
    public IntArray subtract(IntArray f) throws EuclidRuntimeException {
        checkConformable(f);
        IntArray m = (IntArray) this.clone();
        for (int i = 0; i < nelem; i++) {
            m.array[i] = array[i] - f.array[i];
        }
        return m;
    }
    /**
     * array subtraction. modifies this -= f
     * 
     * @param f
     *            array to subtract
     * @exception EuclidRuntimeException
     *                f is different size from <TT>this</TT>
     */
    public void subtractEquals(IntArray f) throws EuclidRuntimeException {
        checkConformable(f);
        for (int i = 0; i < nelem; i++) {
            array[i] -= f.array[i];
        }
    }
    /**
     * change the sign of all elements. MODIFIES this
     */
    public void negative() {
        for (int i = 0; i < size(); i++) {
            array[i] = -array[i];
        }
    }
    /**
     * add a scalar to all elements. creates new array; does NOT modify 'this';
     * for subtraction use negative scalar
     * 
     * @param f
     *            to add
     * @return new array
     */
    /*--
     public RealArray addScalar(int f) {
     RealArray m = (RealArray) this.clone();
     for(int i = 0; i < nelem; i++) {
     m.array[i] += f;
     }
     return m;
     }
     --*/
    /**
     * array multiplication by a scalar. creates new array; does NOT modify
     * 'this'
     * 
     * @param f
     *            multiplier
     * @return the new array
     */
    public IntArray multiplyBy(int f) {
        IntArray m = (IntArray) this.clone();
        for (int i = 0; i < nelem; i++) {
            m.array[i] *= f;
        }
        return m;
    }
    /**
     * set element value.
     * 
     * @param elem
     *            index
     * @param f
     *            value
     * @exception ArrayIndexOutOfBoundsException
     *                elem >= size of <TT>this</TT>
     */
    public void setElementAt(int elem, int f)
            throws ArrayIndexOutOfBoundsException {
        array[elem] = f;
    }
    /**
     * get array slice. creates new array; does not modify this
     * 
     * @param start
     *            index inclusive
     * @param end
     *            index inclusive
     * @return new array
     */
    public IntArray getSubArray(int start, int end) {
        int nel = end - start + 1;
        IntArray f = new IntArray(nel, 0);
        System.arraycopy(array, start, f.array, 0, nel);
        return f;
    }
    /**
     * set array slice. copy whole array into the array.
     * 
     * @param start
     *            index in this
     * @param a
     *            array to copy
     * @throws ArrayIndexOutOfBoundsException
     *             start < 0 or start+a.length > this.size()
     */
    public void setElements(int start, int[] a) {
        if (start < 0 || start + a.length > nelem) {
            throw new ArrayIndexOutOfBoundsException();
        }
        System.arraycopy(a, 0, this.array, start, a.length);
    }
    /**
     * is the array filled with zeros.
     * 
     * @return true if this(i) = 0
     */
    public boolean isClear() {
        for (int i = 0; i < nelem; i++) {
            if (array[i] != 0)
                return false;
        }
        return true;
    }
    /**
     * initialise array to given value. this(i) = f
     * 
     * @param f
     *            value to set
     */
    public void setAllElements(int f) {
        Int.initArray(nelem, array, f);
    }
    /**
     * sum all elements.
     * 
     * @return sigma(this(i))
     */
    public int sumAllElements() {
        int sum = 0;
        for (int i = 0; i < nelem; i++) {
            sum += array[i];
        }
        return sum;
    }
    /**
     * sum of all absolute element values.
     * 
     * @return sigma(abs(this(i)))
     */
    public int absSumAllElements() {
        int sum = 0;
        for (int i = 0; i < nelem; i++) {
            sum += Math.abs(array[i]);
        }
        return sum;
    }
    /**
     * inner product. dotProduct(this)
     * 
     * @return sigma(this(i)**2)
     */
    public int innerProduct() {
        int result = Integer.MIN_VALUE;
        try {
            result = this.dotProduct(this);
        } catch (EuclidRuntimeException x) {
            throw new EuclidRuntimeException("bug " + x);
        }
        return result;
    }
    /**
     * dot product of two arrays. sigma(this(i)*(f(i));
     * 
     * @param f
     *            array to multiply
     * @exception EuclidRuntimeException
     *                f is different size from <TT>this</TT>
     * @return dot
     */
    public int dotProduct(IntArray f) throws EuclidRuntimeException {
        checkConformable(f);
        int sum = 0;
        for (int i = 0; i < nelem; i++) {
            sum += array[i] * f.array[i];
        }
        return sum;
    }
    /**
     * cumulative sum of array. create new array as elem[i] = sum(k = 0 to i)
     * f[k] does not modify 'this'
     * 
     * @return each element is cumulative sum to that point
     */
    public IntArray cumulativeSum() {
        IntArray temp = new IntArray(nelem);
        int sum = 0;
        for (int i = 0; i < nelem; i++) {
            sum += array[i];
            temp.array[i] = sum;
        }
        return temp;
    }
    /**
     * apply filter. convolute array with another array. This is 1-D image
     * processing. If <TT>filter</TT> has <= 1 element, return <TT>this</TT>
     * unchanged. <TT>filter</TT> should have an odd number of elements. The
     * filter can be created with a IntArray constructor filter is moved along
     * stepwise
     * </P>
     * 
     * @param filter
     *            to apply normally smaller than this
     * @return filtered array
     */
    public IntArray applyFilter(IntArray filter) {
        if (nelem == 0 || filter == null || filter.nelem <= 1) {
            return this;
        }
        int nfilter = filter.size();
        int midfilter = (nfilter - 1) / 2;
        IntArray temp = new IntArray(nelem);
        int wt = 0;
        int sum = 0;
        for (int j = 0; j < midfilter; j++) {
            // get weight
            wt = 0;
            sum = 0;
            int l = 0;
            for (int k = midfilter - j; k < nfilter; k++) {
                wt += Math.abs(filter.array[k]);
                sum += filter.array[k] * this.array[l++];
            }
            temp.array[j] = sum / wt;
        }
        wt = filter.absSumAllElements();
        for (int j = midfilter; j < nelem - midfilter; j++) {
            sum = 0;
            int l = j - midfilter;
            for (int k = 0; k < nfilter; k++) {
                sum += filter.array[k] * this.array[l++];
            }
            temp.array[j] = sum / wt;
        }
        for (int j = nelem - midfilter; j < nelem; j++) {
            // get weight
            wt = 0;
            sum = 0;
            int l = j - midfilter;
            for (int k = 0; k < midfilter + nelem - j; k++) {
                wt += Math.abs(filter.array[k]);
                sum += filter.array[k] * this.array[l++];
            }
            temp.array[j] = sum / wt;
        }
        return temp;
    }
    /**
     * trims array to lie within limit.
     * 
     * if flag == BELOW values below limit are set to limit. if flag == ABOVE
     * values above limit are set to limit. by repeated use of trim() values can
     * be constrained to lie within or outside a window does not modify this.
     * 
     * @param flag
     *            BELOW or ABOVE
     * @param limit
     *            value to constrain
     * @return new array
     */
    public IntArray trim(Trim flag, int limit) {
        IntArray temp = new IntArray(nelem);
        for (int i = 0; i < nelem; i++) {
            int v = array[i];
            if ((flag == Trim.BELOW && v < limit)
                    || (flag == Trim.ABOVE && v > limit))
                v = limit;
            temp.array[i] = v;
        }
        return temp;
    }
    /**
     * index of largest element.
     * 
     * @throws ArrayIndexOutOfBoundsException
     *             array is zero length
     * @return index
     */
    public int indexOfLargestElement() throws ArrayIndexOutOfBoundsException {
        if (nelem == 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int index = -1;
        int value = Integer.MIN_VALUE;
        for (int i = 0; i < nelem; i++) {
            if (array[i] > value) {
                value = array[i];
                index = i;
            }
        }
        return index;
    }
    /**
     * index of smallest element.
     * 
     * @throws ArrayIndexOutOfBoundsException
     *             array is zero length
     * @return index
     */
    public int indexOfSmallestElement() throws ArrayIndexOutOfBoundsException {
        if (nelem == 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int index = -1;
        int value = Integer.MAX_VALUE;
        for (int i = 0; i < nelem; i++) {
            if (array[i] < value) {
                value = array[i];
                index = i;
            }
        }
        return index;
    }
    /**
     * value of largest element.
     * 
     * @throws ArrayIndexOutOfBoundsException
     *             array is zero length
     * @return value
     */
    public int largestElement() throws ArrayIndexOutOfBoundsException {
        return array[indexOfLargestElement()];
    }
    /**
     * value of largest element. synonym for largestElement();
     * 
     * @throws ArrayIndexOutOfBoundsException
     *             array is zero length
     * @return value
     */
    public int getMax() throws ArrayIndexOutOfBoundsException {
        return array[indexOfLargestElement()];
    }
    /**
     * value of smallest element.
     * 
     * @throws ArrayIndexOutOfBoundsException
     *             array is zero length
     * @return index
     */
    public int smallestElement() throws ArrayIndexOutOfBoundsException {
        return array[indexOfSmallestElement()];
    }
    /**
     * value of smallest element. synonym for smallestElement();
     * 
     * @throws ArrayIndexOutOfBoundsException
     *             array is zero length
     * @return value
     */
    public int getMin() throws ArrayIndexOutOfBoundsException {
        return array[indexOfSmallestElement()];
    }
    /**
     * range of array.
     * 
     * @throws ArrayIndexOutOfBoundsException
     *             array is zero length
     * @return (minValue, maxValue)
     */
    public IntRange getRange() throws ArrayIndexOutOfBoundsException {
        if (nelem == 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        IntRange r = new IntRange();
        for (int i = 0; i < nelem; i++) {
            r.add(array[i]);
        }
        return r;
    }
    /**
     * as above (deprecated)
     */
    /*--
     public RealRange range() {return this.getRange();}
     --*/
    /**
     * delete element and close up. modifies this.
     * 
     * @param elem
     *            to delete
     * @throws ArrayIndexOutOfBoundsException
     *             elem out of range
     */
    public void deleteElement(int elem) throws ArrayIndexOutOfBoundsException {
        if (elem < 0 || elem >= nelem) {
            throw new ArrayIndexOutOfBoundsException();
        }
        nelem--;
        if (bufsize > nelem * 2) {
            bufsize /= 2;
        }
        int[] temp = new int[bufsize];
        System.arraycopy(array, 0, temp, 0, elem);
        System.arraycopy(array, elem + 1, temp, elem, nelem - elem);
        array = temp;
    }
    /**
     * delete elements and close up. modifies this.
     * 
     * @param low
     *            lowest index inclusive
     * @param high
     *            highest index inclusive
     * @throws ArrayIndexOutOfBoundsException
     *             low or high out of range or low > high
     */
    /**
     * delete elements and close up. modifies this.
     * 
     * @param low
     *            lowest index inclusive
     * @param high
     *            highest index inclusive
     * @throws ArrayIndexOutOfBoundsException
     *             low or high out of range or low > high
     */
    public void deleteElements(int low, int high)
            throws ArrayIndexOutOfBoundsException {
        if (low < 0 || low > high || high >= nelem) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int ndeleted = high - low + 1;
        int[] temp = new int[nelem - ndeleted];
        System.arraycopy(array, 0, temp, 0, low);
        System.arraycopy(array, high + 1, temp, low, nelem - low - ndeleted);
        array = temp;
        nelem -= ndeleted;
        bufsize = nelem;
        int[] array = new int[nelem];
        System.arraycopy(temp, 0, array, 0, nelem);
    }
    /**
     * insert element and expand. modifies this.
     * 
     * @param elem
     *            index of element to insert
     * @param f
     *            value of element
     * @throws ArrayIndexOutOfBoundsException
     *             elem out of range
     */
    public void insertElementAt(int elem, int f)
            throws ArrayIndexOutOfBoundsException {
        if (elem < 0 || elem > nelem) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int[] array1 = new int[nelem + 1];
        System.arraycopy(array, 0, array1, 0, elem);
        array1[elem] = f;
        System.arraycopy(array, elem, array1, elem + 1, nelem - elem);
        nelem++;
        array = array1;
    }
    /**
     * insert an array and expand. modifies this.
     * 
     * @param elem
     *            index of element to insert
     * @param f
     *            value of element
     * @throws ArrayIndexOutOfBoundsException
     *             elem out of range
     */
    public void insertArray(int elem, IntArray f)
            throws ArrayIndexOutOfBoundsException {
        int n = f.size();
        if (elem < 0 || elem >= nelem || n < 1) {
            throw new ArrayIndexOutOfBoundsException();
        }
        nelem += n;
        int[] array1 = new int[nelem];
        System.arraycopy(array, 0, array1, 0, elem);
        System.arraycopy(f.getArray(), 0, array1, elem, n);
        System.arraycopy(array, elem, array1, n + elem, nelem - elem - n);
        array = array1;
    }
    /**
     * append element. modifies this.
     * 
     * @param f
     *            element to append
     */
    public void addElement(int f) {
        makeSpace(nelem + 1);
        array[nelem++] = f;
    }
    /**
     * append elements. modifies this.
     * 
     * @param f
     *            elements to append
     */
    public void addArray(IntArray f) {
        makeSpace(nelem + f.nelem);
        System.arraycopy(f.array, 0, array, nelem, f.nelem);
        nelem += f.nelem;
    }
    /**
     * get reordered Array. reorder by index in IntSet new(i) = this(idx(i))
     * does NOT modify array
     * 
     * @param idx
     *            array of indexes
     * @exception EuclidRuntimeException
     *                an element of idx is outside range of <TT>this</TT>
     * @return array
     */
    public IntArray getReorderedArray(IntSet idx) throws EuclidRuntimeException {
        IntArray temp = new IntArray(nelem);
        for (int i = 0; i < nelem; i++) {
            int index = idx.elementAt(i);
            if (index > nelem) {
                throw new EuclidRuntimeException();
            }
            temp.array[i] = array[index];
        }
        return temp;
    }
    /**
     * get elements within a range.
     * 
     * @param r
     *            within which element values must lie
     * @return indexes of conforming elements
     */
    public IntSet inRange(IntRange r) {
        int n = size();
        IntSet temp = new IntSet();
        for (int i = 0; i < n; i++) {
            if (r.isValid() && r.includes(array[i])) {
                temp.addElement(i);
            }
        }
        return temp;
    }
    /**
     * get elements outside a range.
     * 
     * @param r
     *            outside which element values must lie
     * @return indexes of conforming elements
     */
    public IntSet outOfRange(IntRange r) {
        int n = size();
        IntSet temp = new IntSet();
        for (int i = 0; i < n; i++) {
            if (r.isValid() && !r.includes(array[i])) {
                temp.addElement(i);
            }
        }
        return temp;
    }
    /**
     * returns values as strings.
     * 
     * @return string values of elements
     */
    public String[] getStringValues() {
        String[] temp = new String[nelem];
        for (int i = 0; i < nelem; i++) {
            temp[i] = Integer.toString(array[i]);
        }
        return temp;
    }
    /**
     * gets values as string.
     * 
     * @return element values seperated with spaces
     */
    public String toString() {
        // don't change this routine!!!
        StringBuffer s = new StringBuffer();
        s.append(S_LBRAK);
        for (int i = 0; i < nelem; i++) {
            if (i > 0) {
                s.append(S_COMMA);
            }
            s.append(array[i]);
        }
        s.append(S_RBRAK);
        return s.toString();
    }
    /**
     * delete elements. utility routine. delete elements from java routine and
     * close up
     * 
     * @param low
     *            index inclusive
     * @param hi
     *            index inclusive if hi >= float.length hi is reset to
     *            float.length-1.
     */
    static int[] deleteElements(int[] f, int low, int hi) {
        if (hi >= f.length)
            hi = f.length - 1;
        if (low < 0)
            low = 0;
        int ndel = hi - low + 1;
        if (ndel <= 0)
            return f;
        int[] temp = new int[f.length - ndel];
        System.arraycopy(f, 0, temp, 0, low);
        System.arraycopy(f, hi + 1, temp, low, f.length - hi - 1);
        return temp;
    }
    /**
     * copy java array utility routine
     */
    static int[] copy(int[] f) {
        int temp[] = new int[f.length];
        System.arraycopy(f, 0, temp, 0, f.length);
        return temp;
    }
    /**
     * quick sort - modified from p96 - 97 (Hansen - C++ answer book)
     * 
     * Scalar sort refers to sorting IntArray and IntArray (and similar classes)
     * where the objects themeselves are sorted.
     * 
     * Index sort refers to sorting indexes (held as IntSet's) to the object and
     * getting the sorted object(s) with reorderBy(IntSet idx);
     * 
     */
    void xfswap(int[] x, int a, int b) {
        int tmp = x[a];
        x[a] = x[b];
        x[b] = tmp;
    }
    // scalar sort routines (internal)
    static final int CUTOFF = 16;
    private void inssort(int left, int right) {
        int k;
        for (int i = left + 1; i <= right; i++) {
            int v = array[i];
            int j;
            for (j = i, k = j - 1; j > 0 && array[k] > v; j--, k--) {
                array[j] = array[k];
            }
            array[j] = v;
        }
    }
    private int partition(int left, int right) {
        int mid = (left + right) / 2;
        if (array[left] > array[mid])
            xfswap(array, left, mid);
        if (array[left] > array[right])
            xfswap(array, left, right);
        if (array[mid] > array[right])
            xfswap(array, mid, right);
        int j = right - 1;
        xfswap(array, mid, j);
        int i = left;
        int v = array[j];
        do {
            do {
                i++;
            } while (array[i] < v);
            do {
                j--;
            } while (array[j] > v);
            xfswap(array, i, j);
        } while (i < j);
        xfswap(array, j, i);
        xfswap(array, i, right - 1);
        return i;
    }
    private void iqsort(int left, int right) {
        while (right - left > CUTOFF) {
            int i = partition(left, right);
            if (i - left > right - i) {
                iqsort(i + 1, right);
                right = i - 1;
            } else {
                iqsort(left, i - 1);
                left = i + 1;
            }
        }
    }
    /**
     * sorts array into ascending order. MODIFIES this
     */
    public void sortAscending() {
        if (nelem <= 0)
            return;
        iqsort(0, nelem - 1);
        inssort(0, nelem - 1);
    }
    /**
     * sorts array into descending order. MODIFIES this
     */
    public void sortDescending() {
        sortAscending();
        reverse();
    }
    /**
     * puts array into reverse order. MODIFIES this
     */
    public void reverse() {
        int i = 0, j = nelem - 1;
        while (i < j) {
            xfswap(array, i, j);
            i++;
            j--;
        }
    }
    private static final int XXCUTOFF = 16;
    /**
     * get indexes of ascending sorted array. this array NOT MODIFIED
     * 
     * @return indexes idx so that element(idx(0)) is lowest
     */
    public IntSet indexSortAscending() {
        if (nelem <= 0) {
            return new IntSet();
        }
        IntSet idx = new IntSet(nelem);
        IntArray iarray = new IntArray(idx.getElements());
        xxiqsort(iarray, array, 0, nelem - 1);
        xxinssort(iarray, array, 0, nelem - 1);
        try {
            idx = new IntSet(iarray.getArray());
        } catch (Exception e) {
            throw new EuclidRuntimeException(e.toString());
        }
        return idx;
    }
    /**
     * get indexes of descending sorted array. this array NOT MODIFIED
     * 
     * @return indexes idx so that element(idx(0)) is highest
     */
    public IntSet indexSortDescending() {
        IntSet idx;
        idx = indexSortAscending();
        int[] temp = new IntArray(idx.getElements()).getReverseArray();
        try {
            idx = new IntSet(temp);
        } catch (Exception e) {
            throw new EuclidRuntimeException(e.toString());
        }
        return idx;
    }
    private void xxinssort(IntArray iarr, int[] pfl, int left, int right) {
        int j, k;
        for (int i = left + 1; i <= right; i++) {
            int v = iarr.elementAt(i);
            for (j = i, k = j - 1; j > 0 && pfl[iarr.elementAt(k)] > pfl[v]; j--, k--) {
                iarr.setElementAt(j, iarr.elementAt(k));
            }
            iarr.setElementAt(j, v);
        }
    }
    private int xxpartition(IntArray iarr, int[] pfl, int left, int right) {
        int mid = (left + right) / 2;
        if (pfl[iarr.elementAt(left)] > pfl[iarr.elementAt(mid)])
            xxfswap(iarr, left, mid);
        if (pfl[iarr.elementAt(left)] > pfl[iarr.elementAt(right)])
            xxfswap(iarr, left, right);
        if (pfl[iarr.elementAt(mid)] > pfl[iarr.elementAt(right)])
            xxfswap(iarr, mid, right);
        int j = right - 1;
        xxfswap(iarr, mid, j);
        int i = left;
        int v = pfl[iarr.elementAt(j)];
        do {
            do {
                i++;
            } while (pfl[iarr.elementAt(i)] < v);
            do {
                j--;
            } while (pfl[iarr.elementAt(j)] > v);
            xxfswap(iarr, i, j);
        } while (i < j);
        xxfswap(iarr, j, i);
        xxfswap(iarr, i, right - 1);
        return i;
    }
    private void xxiqsort(IntArray iarr, int[] pfl, int left, int right) {
        while (right - left > XXCUTOFF) {
            int i = xxpartition(iarr, pfl, left, right);
            if (i - left > right - i) {
                xxiqsort(iarr, pfl, i + 1, right);
                right = i - 1;
            } else {
                xxiqsort(iarr, pfl, left, i - 1);
                left = i + 1;
            }
        }
    }
    private void xxfswap(IntArray iarr, int a, int b) {
        int t = iarr.elementAt(a);
        iarr.setElementAt(a, iarr.elementAt(b));
        iarr.setElementAt(b, t);
    }
}
