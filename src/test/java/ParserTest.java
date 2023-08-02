package test.java;

import main.org.example.Downloader;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {

    @Test
    public void ObjectTest() {
        Downloader downloader = new Downloader();
        String path = "PacketsDirectory";
        String signature0 = "<java.lang.Object: boolean equals(java.lang.Object)>";
        String signature1 = "<java.lang.Object: java.lang.String toString()>";

        String body0 = downloader.find(path, signature0);
        String body1 = downloader.find(path, signature1);

        String real0 = "/**\n" +
                " * Indicates whether some other object is \"equal to\" this one.\n" +
                " * <p>\n" +
                " * The {@code equals} method implements an equivalence relation\n" +
                " * on non-null object references:\n" +
                " * <ul>\n" +
                " * <li>It is <i>reflexive</i>: for any non-null reference value\n" +
                " *     {@code x}, {@code x.equals(x)} should return\n" +
                " *     {@code true}.\n" +
                " * <li>It is <i>symmetric</i>: for any non-null reference values\n" +
                " *     {@code x} and {@code y}, {@code x.equals(y)}\n" +
                " *     should return {@code true} if and only if\n" +
                " *     {@code y.equals(x)} returns {@code true}.\n" +
                " * <li>It is <i>transitive</i>: for any non-null reference values\n" +
                " *     {@code x}, {@code y}, and {@code z}, if\n" +
                " *     {@code x.equals(y)} returns {@code true} and\n" +
                " *     {@code y.equals(z)} returns {@code true}, then\n" +
                " *     {@code x.equals(z)} should return {@code true}.\n" +
                " * <li>It is <i>consistent</i>: for any non-null reference values\n" +
                " *     {@code x} and {@code y}, multiple invocations of\n" +
                " *     {@code x.equals(y)} consistently return {@code true}\n" +
                " *     or consistently return {@code false}, provided no\n" +
                " *     information used in {@code equals} comparisons on the\n" +
                " *     objects is modified.\n" +
                " * <li>For any non-null reference value {@code x},\n" +
                " *     {@code x.equals(null)} should return {@code false}.\n" +
                " * </ul>\n" +
                " * <p>\n" +
                " * The {@code equals} method for class {@code Object} implements\n" +
                " * the most discriminating possible equivalence relation on objects;\n" +
                " * that is, for any non-null reference values {@code x} and\n" +
                " * {@code y}, this method returns {@code true} if and only\n" +
                " * if {@code x} and {@code y} refer to the same object\n" +
                " * ({@code x == y} has the value {@code true}).\n" +
                " * <p>\n" +
                " * Note that it is generally necessary to override the {@code hashCode}\n" +
                " * method whenever this method is overridden, so as to maintain the\n" +
                " * general contract for the {@code hashCode} method, which states\n" +
                " * that equal objects must have equal hash codes.\n" +
                " *\n" +
                " * @param   obj   the reference object with which to compare.\n" +
                " * @return  {@code true} if this object is the same as the obj\n" +
                " *          argument; {@code false} otherwise.\n" +
                " * @see     #hashCode()\n" +
                " * @see     java.util.HashMap\n" +
                " */\n" +
                "public boolean equals(Object obj) {\n" +
                "    return (this == obj);\n" +
                "}";
        String real1 = "/**\n" +
                " * Returns a string representation of the object. In general, the\n" +
                " * {@code toString} method returns a string that\n" +
                " * \"textually represents\" this object. The result should\n" +
                " * be a concise but informative representation that is easy for a\n" +
                " * person to read.\n" +
                " * It is recommended that all subclasses override this method.\n" +
                " * <p>\n" +
                " * The {@code toString} method for class {@code Object}\n" +
                " * returns a string consisting of the name of the class of which the\n" +
                " * object is an instance, the at-sign character `{@code @}', and\n" +
                " * the unsigned hexadecimal representation of the hash code of the\n" +
                " * object. In other words, this method returns a string equal to the\n" +
                " * value of:\n" +
                " * <blockquote>\n" +
                " * <pre>\n" +
                " * getClass().getName() + '@' + Integer.toHexString(hashCode())\n" +
                " * </pre></blockquote>\n" +
                " *\n" +
                " * @return  a string representation of the object.\n" +
                " */\n" +
                "public String toString() {\n" +
                "    return getClass().getName() + \"@\" + Integer.toHexString(hashCode());\n" +
                "}";

        assertEquals(body0, real0);
        assertEquals(body1, real1);
    }

    @Test
    public void Comparator() {
        Downloader downloader = new Downloader();
        String path = "PacketsDirectory";
        String signature0 = "<java.util.Comparator: int compare(java.lang.Object,java.lang.Object)>";

        String body0 = downloader.find(path, signature0);

        String real0 = "/**\n" +
                " * Compares its two arguments for order.  Returns a negative integer,\n" +
                " * zero, or a positive integer as the first argument is less than, equal\n" +
                " * to, or greater than the second.<p>\n" +
                " *\n" +
                " * In the foregoing description, the notation\n" +
                " * <tt>sgn(</tt><i>expression</i><tt>)</tt> designates the mathematical\n" +
                " * <i>signum</i> function, which is defined to return one of <tt>-1</tt>,\n" +
                " * <tt>0</tt>, or <tt>1</tt> according to whether the value of\n" +
                " * <i>expression</i> is negative, zero or positive.<p>\n" +
                " *\n" +
                " * The implementor must ensure that <tt>sgn(compare(x, y)) ==\n" +
                " * -sgn(compare(y, x))</tt> for all <tt>x</tt> and <tt>y</tt>.  (This\n" +
                " * implies that <tt>compare(x, y)</tt> must throw an exception if and only\n" +
                " * if <tt>compare(y, x)</tt> throws an exception.)<p>\n" +
                " *\n" +
                " * The implementor must also ensure that the relation is transitive:\n" +
                " * <tt>((compare(x, y)&gt;0) &amp;&amp; (compare(y, z)&gt;0))</tt> implies\n" +
                " * <tt>compare(x, z)&gt;0</tt>.<p>\n" +
                " *\n" +
                " * Finally, the implementor must ensure that <tt>compare(x, y)==0</tt>\n" +
                " * implies that <tt>sgn(compare(x, z))==sgn(compare(y, z))</tt> for all\n" +
                " * <tt>z</tt>.<p>\n" +
                " *\n" +
                " * It is generally the case, but <i>not</i> strictly required that\n" +
                " * <tt>(compare(x, y)==0) == (x.equals(y))</tt>.  Generally speaking,\n" +
                " * any comparator that violates this condition should clearly indicate\n" +
                " * this fact.  The recommended language is \"Note: this comparator\n" +
                " * imposes orderings that are inconsistent with equals.\"\n" +
                " *\n" +
                " * @param o1 the first object to be compared.\n" +
                " * @param o2 the second object to be compared.\n" +
                " * @return a negative integer, zero, or a positive integer as the\n" +
                " *         first argument is less than, equal to, or greater than the\n" +
                " *         second.\n" +
                " * @throws NullPointerException if an argument is null and this\n" +
                " *         comparator does not permit null arguments\n" +
                " * @throws ClassCastException if the arguments' types prevent them from\n" +
                " *         being compared by this comparator.\n" +
                " */\n" +
                "int compare(T o1, T o2);";

        assertEquals(body0, real0);
    }

    @Test
    public void HashMapTest() {
        Downloader downloader = new Downloader();
        String path = "PacketsDirectory";
        String signature0 = "<java.util.HashMap$TreeNode: java.util.HashMap$TreeNode putTreeVal(java.util.HashMap,java.util.HashMap$Node[],int,java.lang.Object,java.lang.Object)>";
        String signature1 = "<java.util.HashMap: java.util.HashMap$Node newNode(int,java.lang.Object,java.lang.Object,java.util.HashMap$Node)>";
        String signature2 = "<java.util.HashMap: java.lang.Object putVal(int,java.lang.Object,java.lang.Object,boolean,boolean)>";
        String signature3 = "<java.util.HashMap: void readObject(java.io.ObjectInputStream)>";
        String signature4 = "<java.util.HashMap: java.util.HashMap$Node[] resize()>";

        String body0 = downloader.find(path, signature0);
        String body1 = downloader.find(path, signature1);
        String body2 = downloader.find(path, signature2);
        String body3 = downloader.find(path, signature3);
        String body4 = downloader.find(path, signature4);

        String real0 = "/**\n" +
                " * Tree version of putVal.\n" +
                " */\n" +
                "final TreeNode<K, V> putTreeVal(HashMap<K, V> map, Node<K, V>[] tab, int h, K k, V v) {\n" +
                "    Class<?> kc = null;\n" +
                "    boolean searched = false;\n" +
                "    TreeNode<K, V> root = (parent != null) ? root() : this;\n" +
                "    for (TreeNode<K, V> p = root; ; ) {\n" +
                "        int dir, ph;\n" +
                "        K pk;\n" +
                "        if ((ph = p.hash) > h)\n" +
                "            dir = -1;\n" +
                "        else if (ph < h)\n" +
                "            dir = 1;\n" +
                "        else if ((pk = p.key) == k || (k != null && k.equals(pk)))\n" +
                "            return p;\n" +
                "        else if ((kc == null && (kc = comparableClassFor(k)) == null) || (dir = compareComparables(kc, k, pk)) == 0) {\n" +
                "            if (!searched) {\n" +
                "                TreeNode<K, V> q, ch;\n" +
                "                searched = true;\n" +
                "                if (((ch = p.left) != null && (q = ch.find(h, k, kc)) != null) || ((ch = p.right) != null && (q = ch.find(h, k, kc)) != null))\n" +
                "                    return q;\n" +
                "            }\n" +
                "            dir = tieBreakOrder(k, pk);\n" +
                "        }\n" +
                "        TreeNode<K, V> xp = p;\n" +
                "        if ((p = (dir <= 0) ? p.left : p.right) == null) {\n" +
                "            Node<K, V> xpn = xp.next;\n" +
                "            TreeNode<K, V> x = map.newTreeNode(h, k, v, xpn);\n" +
                "            if (dir <= 0)\n" +
                "                xp.left = x;\n" +
                "            else\n" +
                "                xp.right = x;\n" +
                "            xp.next = x;\n" +
                "            x.parent = x.prev = xp;\n" +
                "            if (xpn != null)\n" +
                "                ((TreeNode<K, V>) xpn).prev = x;\n" +
                "            moveRootToFront(tab, balanceInsertion(root, x));\n" +
                "            return null;\n" +
                "        }\n" +
                "    }\n" +
                "}";
        String real1 = "/* ------------------------------------------------------------ */\n" +
                "// LinkedHashMap support\n" +
                "/*\n" +
                "     * The following package-protected methods are designed to be\n" +
                "     * overridden by LinkedHashMap, but not by any other subclass.\n" +
                "     * Nearly all other internal methods are also package-protected\n" +
                "     * but are declared final, so can be used by LinkedHashMap, view\n" +
                "     * classes, and HashSet.\n" +
                "     */\n" +
                "// Create a regular (non-tree) node\n" +
                "Node<K, V> newNode(int hash, K key, V value, Node<K, V> next) {\n" +
                "    return new Node<>(hash, key, value, next);\n" +
                "}";
        String real2 = "/**\n" +
                " * Implements Map.put and related methods.\n" +
                " *\n" +
                " * @param hash hash for key\n" +
                " * @param key the key\n" +
                " * @param value the value to put\n" +
                " * @param onlyIfAbsent if true, don't change existing value\n" +
                " * @param evict if false, the table is in creation mode.\n" +
                " * @return previous value, or null if none\n" +
                " */\n" +
                "final V putVal(int hash, K key, V value, boolean onlyIfAbsent, boolean evict) {\n" +
                "    Node<K, V>[] tab;\n" +
                "    Node<K, V> p;\n" +
                "    int n, i;\n" +
                "    if ((tab = table) == null || (n = tab.length) == 0)\n" +
                "        n = (tab = resize()).length;\n" +
                "    if ((p = tab[i = (n - 1) & hash]) == null)\n" +
                "        tab[i] = newNode(hash, key, value, null);\n" +
                "    else {\n" +
                "        Node<K, V> e;\n" +
                "        K k;\n" +
                "        if (p.hash == hash && ((k = p.key) == key || (key != null && key.equals(k))))\n" +
                "            e = p;\n" +
                "        else if (p instanceof TreeNode)\n" +
                "            e = ((TreeNode<K, V>) p).putTreeVal(this, tab, hash, key, value);\n" +
                "        else {\n" +
                "            for (int binCount = 0; ; ++binCount) {\n" +
                "                if ((e = p.next) == null) {\n" +
                "                    p.next = newNode(hash, key, value, null);\n" +
                "                    if (// -1 for 1st\n" +
                "                    binCount >= TREEIFY_THRESHOLD - 1)\n" +
                "                        treeifyBin(tab, hash);\n" +
                "                    break;\n" +
                "                }\n" +
                "                if (e.hash == hash && ((k = e.key) == key || (key != null && key.equals(k))))\n" +
                "                    break;\n" +
                "                p = e;\n" +
                "            }\n" +
                "        }\n" +
                "        if (e != null) {\n" +
                "            // existing mapping for key\n" +
                "            V oldValue = e.value;\n" +
                "            if (!onlyIfAbsent || oldValue == null)\n" +
                "                e.value = value;\n" +
                "            afterNodeAccess(e);\n" +
                "            return oldValue;\n" +
                "        }\n" +
                "    }\n" +
                "    ++modCount;\n" +
                "    if (++size > threshold)\n" +
                "        resize();\n" +
                "    afterNodeInsertion(evict);\n" +
                "    return null;\n" +
                "}";
        String real3 = "/**\n" +
                " * Reconstitutes this map from a stream (that is, deserializes it).\n" +
                " * @param s the stream\n" +
                " * @throws ClassNotFoundException if the class of a serialized object\n" +
                " *         could not be found\n" +
                " * @throws IOException if an I/O error occurs\n" +
                " */\n" +
                "private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {\n" +
                "    ObjectInputStream.GetField fields = s.readFields();\n" +
                "    // Read loadFactor (ignore threshold)\n" +
                "    float lf = fields.get(\"loadFactor\", 0.75f);\n" +
                "    if (lf <= 0 || Float.isNaN(lf))\n" +
                "        throw new InvalidObjectException(\"Illegal load factor: \" + lf);\n" +
                "    lf = Math.min(Math.max(0.25f, lf), 4.0f);\n" +
                "    HashMap.UnsafeHolder.putLoadFactor(this, lf);\n" +
                "    reinitialize();\n" +
                "    // Read and ignore number of buckets\n" +
                "    s.readInt();\n" +
                "    // Read number of mappings (size)\n" +
                "    int mappings = s.readInt();\n" +
                "    if (mappings < 0) {\n" +
                "        throw new InvalidObjectException(\"Illegal mappings count: \" + mappings);\n" +
                "    } else if (mappings == 0) {\n" +
                "        // use defaults\n" +
                "    } else if (mappings > 0) {\n" +
                "        float fc = (float) mappings / lf + 1.0f;\n" +
                "        int cap = ((fc < DEFAULT_INITIAL_CAPACITY) ? DEFAULT_INITIAL_CAPACITY : (fc >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : tableSizeFor((int) fc));\n" +
                "        float ft = (float) cap * lf;\n" +
                "        threshold = ((cap < MAXIMUM_CAPACITY && ft < MAXIMUM_CAPACITY) ? (int) ft : Integer.MAX_VALUE);\n" +
                "        // Check Map.Entry[].class since it's the nearest public type to\n" +
                "        // what we're actually creating.\n" +
                "        SharedSecrets.getJavaOISAccess().checkArray(s, Map.Entry[].class, cap);\n" +
                "        @SuppressWarnings({ \"rawtypes\", \"unchecked\" })\n" +
                "        Node<K, V>[] tab = (Node<K, V>[]) new Node[cap];\n" +
                "        table = tab;\n" +
                "        // Read the keys and values, and put the mappings in the HashMap\n" +
                "        for (int i = 0; i < mappings; i++) {\n" +
                "            @SuppressWarnings(\"unchecked\")\n" +
                "            K key = (K) s.readObject();\n" +
                "            @SuppressWarnings(\"unchecked\")\n" +
                "            V value = (V) s.readObject();\n" +
                "            putVal(hash(key), key, value, false, false);\n" +
                "        }\n" +
                "    }\n" +
                "}";
        String real4 = "/**\n" +
                " * Initializes or doubles table size.  If null, allocates in\n" +
                " * accord with initial capacity target held in field threshold.\n" +
                " * Otherwise, because we are using power-of-two expansion, the\n" +
                " * elements from each bin must either stay at same index, or move\n" +
                " * with a power of two offset in the new table.\n" +
                " *\n" +
                " * @return the table\n" +
                " */\n" +
                "final Node<K, V>[] resize() {\n" +
                "    Node<K, V>[] oldTab = table;\n" +
                "    int oldCap = (oldTab == null) ? 0 : oldTab.length;\n" +
                "    int oldThr = threshold;\n" +
                "    int newCap, newThr = 0;\n" +
                "    if (oldCap > 0) {\n" +
                "        if (oldCap >= MAXIMUM_CAPACITY) {\n" +
                "            threshold = Integer.MAX_VALUE;\n" +
                "            return oldTab;\n" +
                "        } else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY && oldCap >= DEFAULT_INITIAL_CAPACITY)\n" +
                "            // double threshold\n" +
                "            newThr = oldThr << 1;\n" +
                "    } else if (// initial capacity was placed in threshold\n" +
                "    oldThr > 0)\n" +
                "        newCap = oldThr;\n" +
                "    else {\n" +
                "        // zero initial threshold signifies using defaults\n" +
                "        newCap = DEFAULT_INITIAL_CAPACITY;\n" +
                "        newThr = (int) (DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);\n" +
                "    }\n" +
                "    if (newThr == 0) {\n" +
                "        float ft = (float) newCap * loadFactor;\n" +
                "        newThr = (newCap < MAXIMUM_CAPACITY && ft < (float) MAXIMUM_CAPACITY ? (int) ft : Integer.MAX_VALUE);\n" +
                "    }\n" +
                "    threshold = newThr;\n" +
                "    @SuppressWarnings({ \"rawtypes\", \"unchecked\" })\n" +
                "    Node<K, V>[] newTab = (Node<K, V>[]) new Node[newCap];\n" +
                "    table = newTab;\n" +
                "    if (oldTab != null) {\n" +
                "        for (int j = 0; j < oldCap; ++j) {\n" +
                "            Node<K, V> e;\n" +
                "            if ((e = oldTab[j]) != null) {\n" +
                "                oldTab[j] = null;\n" +
                "                if (e.next == null)\n" +
                "                    newTab[e.hash & (newCap - 1)] = e;\n" +
                "                else if (e instanceof TreeNode)\n" +
                "                    ((TreeNode<K, V>) e).split(this, newTab, j, oldCap);\n" +
                "                else {\n" +
                "                    // preserve order\n" +
                "                    Node<K, V> loHead = null, loTail = null;\n" +
                "                    Node<K, V> hiHead = null, hiTail = null;\n" +
                "                    Node<K, V> next;\n" +
                "                    do {\n" +
                "                        next = e.next;\n" +
                "                        if ((e.hash & oldCap) == 0) {\n" +
                "                            if (loTail == null)\n" +
                "                                loHead = e;\n" +
                "                            else\n" +
                "                                loTail.next = e;\n" +
                "                            loTail = e;\n" +
                "                        } else {\n" +
                "                            if (hiTail == null)\n" +
                "                                hiHead = e;\n" +
                "                            else\n" +
                "                                hiTail.next = e;\n" +
                "                            hiTail = e;\n" +
                "                        }\n" +
                "                    } while ((e = next) != null);\n" +
                "                    if (loTail != null) {\n" +
                "                        loTail.next = null;\n" +
                "                        newTab[j] = loHead;\n" +
                "                    }\n" +
                "                    if (hiTail != null) {\n" +
                "                        hiTail.next = null;\n" +
                "                        newTab[j + oldCap] = hiHead;\n" +
                "                    }\n" +
                "                }\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "    return newTab;\n" +
                "}";



        assertEquals(body0, real0);
        assertEquals(body1, real1);
        assertEquals(body2, real2);
        assertEquals(body3, real3);
        assertEquals(body4, real4);
    }

    @Test
    public void PriorityQueueTest() {
        Downloader downloader = new Downloader();
        String path = "PacketsDirectory";
        String signature0 = "<java.util.PriorityQueue: void readObject(java.io.ObjectInputStream)>";
        String signature1 = "<java.util.PriorityQueue: void heapify()>";
        String signature2 = "<java.util.PriorityQueue: java.lang.Object poll()>";
        String signature3 = "<java.util.PriorityQueue: void siftDown(int,java.lang.Object)>";
        String signature4 = "<java.util.PriorityQueue: void initFromCollection(java.util.Collection)>";

        String body0 = downloader.find(path, signature0);
        String body1 = downloader.find(path, signature1);
        String body2 = downloader.find(path, signature2);
        String body3 = downloader.find(path, signature3);
        String body4 = downloader.find(path, signature4);

        String real0 = "/**\n" +
                " * Reconstitutes the {@code PriorityQueue} instance from a stream\n" +
                " * (that is, deserializes it).\n" +
                " *\n" +
                " * @param s the stream\n" +
                " */\n" +
                "private void readObject(java.io.ObjectInputStream s) throws java.io.IOException, ClassNotFoundException {\n" +
                "    // Read in size, and any hidden stuff\n" +
                "    s.defaultReadObject();\n" +
                "    // Read in (and discard) array length\n" +
                "    s.readInt();\n" +
                "    SharedSecrets.getJavaOISAccess().checkArray(s, Object[].class, size);\n" +
                "    queue = new Object[size];\n" +
                "    // Read in all elements.\n" +
                "    for (int i = 0; i < size; i++) queue[i] = s.readObject();\n" +
                "    // Elements are guaranteed to be in \"proper order\", but the\n" +
                "    // spec has never explained what that might be.\n" +
                "    heapify();\n" +
                "}";
        String real1 = "/**\n" +
                " * Establishes the heap invariant (described above) in the entire tree,\n" +
                " * assuming nothing about the order of the elements prior to the call.\n" +
                " */\n" +
                "@SuppressWarnings(\"unchecked\")\n" +
                "private void heapify() {\n" +
                "    for (int i = (size >>> 1) - 1; i >= 0; i--) siftDown(i, (E) queue[i]);\n" +
                "}";
        String real2 = "@SuppressWarnings(\"unchecked\")\n" +
                "public E poll() {\n" +
                "    if (size == 0)\n" +
                "        return null;\n" +
                "    int s = --size;\n" +
                "    modCount++;\n" +
                "    E result = (E) queue[0];\n" +
                "    E x = (E) queue[s];\n" +
                "    queue[s] = null;\n" +
                "    if (s != 0)\n" +
                "        siftDown(0, x);\n" +
                "    return result;\n" +
                "}";
        String real3 = "/**\n" +
                " * Inserts item x at position k, maintaining heap invariant by\n" +
                " * demoting x down the tree repeatedly until it is less than or\n" +
                " * equal to its children or is a leaf.\n" +
                " *\n" +
                " * @param k the position to fill\n" +
                " * @param x the item to insert\n" +
                " */\n" +
                "private void siftDown(int k, E x) {\n" +
                "    if (comparator != null)\n" +
                "        siftDownUsingComparator(k, x);\n" +
                "    else\n" +
                "        siftDownComparable(k, x);\n" +
                "}";
        String real4 = "/**\n" +
                " * Initializes queue array with elements from the given Collection.\n" +
                " *\n" +
                " * @param c the collection\n" +
                " */\n" +
                "private void initFromCollection(Collection<? extends E> c) {\n" +
                "    initElementsFromCollection(c);\n" +
                "    heapify();\n" +
                "}";

        assertEquals(body0, real0);
        assertEquals(body1, real1);
        assertEquals(body2, real2);
        assertEquals(body3, real3);
        assertEquals(body4, real4);
    }

    @Test
    public void ClojureTest() {
        Downloader downloader = new Downloader();
        String path = "PacketsDirectory";
        String signature0 = "<clojure.lang.LazySeq: clojure.lang.ISeq seq()>";
        String signature1 = "<clojure.core$bean$fn__6906$fn__6907: java.lang.Object invoke()>";
        //constructor test
        String signature2 = "<clojure.core$bean$fn__6906$fn__6907: void <init>(java.lang.Object,java.lang.Object,java.lang.Object)>";

        String body0 = downloader.find(path, signature0);
        String body1 = downloader.find(path, signature1);
        String body2 = downloader.find(path, signature2);

        String real0 = "public final synchronized ISeq seq() {\n" +
                "    this.sval();\n" +
                "    if (this.sv != null) {\n" +
                "        Object ls = this.sv;\n" +
                "        for (this.sv = null; ls instanceof LazySeq; ls = ((LazySeq) ls).sval()) {\n" +
                "        }\n" +
                "        this.s = RT.seq(ls);\n" +
                "    }\n" +
                "    return this.s;\n" +
                "}";
        String real1 = "public Object invoke() {\n" +
                "    Class var10000 = (Class) ((PropertyDescriptor) this.pd).getPropertyType();\n" +
                "    Object var10001 = ((Method) this.method).invoke(this.x, (Object[]) null);\n" +
                "    Object var1 = null;\n" +
                "    return Reflector.prepRet(var10000, var10001);\n" +
                "}";
        String real2 = "public core$bean$fn__6906$fn__6907(Object var1, Object var2, Object var3) {\n" +
                "    this.x = var1;\n" +
                "    this.method = var2;\n" +
                "    this.pd = var3;\n" +
                "}";

        assertEquals(body0, real0);
        assertEquals(body1, real1);
        assertEquals(body2, real2);
    }

    @Test
    public void CustomLambdaTest() {
        Downloader downloader = new Downloader();
        String path = "PacketsDirectory";
        String signature0 = "<org.example.LambdaApp: int lambda$func$6(int)>";

        String body0 = downloader.find(path, signature0);

        assertEquals(body0, "() -> x + y + z");
    }

    @Test
    public void JsonPathTest() {
        Downloader downloader = new Downloader();
        String path = "PacketsDirectory";
        String signature0 = "<com.jayway.jsonpath.internal.filter.ValueNodes$PathNode: com.jayway.jsonpath.internal.filter.ValueNodes$PathNode asExistsCheck(boolean)>";
        String signature1 = "<com.jayway.jsonpath.internal.filter.ValueNodes$PathNode: com.jayway.jsonpath.internal.filter.ValueNode evaluate(com.jayway.jsonpath.Predicate$PredicateContext)>";
        String signature2 = "<com.jayway.jsonpath.internal.filter.ValueNodes$ValueListNode: void <init>(java.util.Collection)>";
        String signature3 = "<com.jayway.jsonpath.internal.function.latebinding.PathLateBindingValue: void <init>(com.jayway.jsonpath.internal.Path,java.lang.Object,com.jayway.jsonpath.Configuration)>";
        String signature4 = "<com.jayway.jsonpath.internal.path.ScanPathToken$FilterPathTokenPredicate: boolean matches(java.lang.Object)>";
        String signature5 = "<com.jayway.jsonpath.spi.mapper.GsonMappingProvider: void <init>(java.util.concurrent.Callable)>";
        String signature6 = "<com.jayway.jsonpath.spi.mapper.GsonMappingProvider: void <init>(com.google.gson.Gson)>";


        String body0 = downloader.find(path, signature0);
        String body1 = downloader.find(path, signature1);
        String body2 = downloader.find(path, signature2);
        String body3 = downloader.find(path, signature3);
        String body4 = downloader.find(path, signature4);
        String body5 = downloader.find(path, signature5);
        String body6 = downloader.find(path, signature6);

        String real0 = "public PathNode asExistsCheck(boolean shouldExist) {\n" +
                "    return new PathNode(path, true, shouldExist);\n" +
                "}";
        String real1 = "public ValueNode evaluate(Predicate.PredicateContext ctx) {\n" +
                "    if (isExistsCheck()) {\n" +
                "        try {\n" +
                "            Configuration c = Configuration.builder().jsonProvider(ctx.configuration().jsonProvider()).options(Option.REQUIRE_PROPERTIES).build();\n" +
                "            Object result = path.evaluate(ctx.item(), ctx.root(), c).getValue(false);\n" +
                "            return result == JsonProvider.UNDEFINED ? FALSE : TRUE;\n" +
                "        } catch (PathNotFoundException e) {\n" +
                "            return FALSE;\n" +
                "        }\n" +
                "    } else {\n" +
                "        try {\n" +
                "            Object res;\n" +
                "            if (ctx instanceof PredicateContextImpl) {\n" +
                "                //This will use cache for document ($) queries\n" +
                "                PredicateContextImpl ctxi = (PredicateContextImpl) ctx;\n" +
                "                res = ctxi.evaluate(path);\n" +
                "            } else {\n" +
                "                Object doc = path.isRootPath() ? ctx.root() : ctx.item();\n" +
                "                res = path.evaluate(doc, ctx.root(), ctx.configuration()).getValue();\n" +
                "            }\n" +
                "            res = ctx.configuration().jsonProvider().unwrap(res);\n" +
                "            if (res instanceof Number)\n" +
                "                return ValueNode.createNumberNode(res.toString());\n" +
                "            else if (res instanceof String)\n" +
                "                return ValueNode.createStringNode(res.toString(), false);\n" +
                "            else if (res instanceof Boolean)\n" +
                "                return ValueNode.createBooleanNode(res.toString());\n" +
                "            else if (//workaround for issue: https://github.com/json-path/JsonPath/issues/613\n" +
                "            res instanceof OffsetDateTime)\n" +
                "                //workaround for issue: https://github.com/json-path/JsonPath/issues/613\n" +
                "                return ValueNode.createOffsetDateTimeNode(res.toString());\n" +
                "            else if (res == null)\n" +
                "                return NULL_NODE;\n" +
                "            else if (ctx.configuration().jsonProvider().isArray(res))\n" +
                "                return ValueNode.createJsonNode(ctx.configuration().mappingProvider().map(res, List.class, ctx.configuration()));\n" +
                "            else if (ctx.configuration().jsonProvider().isMap(res))\n" +
                "                return ValueNode.createJsonNode(ctx.configuration().mappingProvider().map(res, Map.class, ctx.configuration()));\n" +
                "            else\n" +
                "                throw new JsonPathException(\"Could not convert \" + res.getClass().toString() + \":\" + res.toString() + \" to a ValueNode\");\n" +
                "        } catch (PathNotFoundException e) {\n" +
                "            return UNDEFINED;\n" +
                "        }\n" +
                "    }\n" +
                "}";
        String real2 = "public ValueListNode(Collection<?> values) {\n" +
                "    for (Object value : values) {\n" +
                "        nodes.add(toValueNode(value));\n" +
                "    }\n" +
                "}";
        String real3 = "public PathLateBindingValue(final Path path, final Object rootDocument, final Configuration configuration) {\n" +
                "    this.path = path;\n" +
                "    this.rootDocument = rootDocument.toString();\n" +
                "    this.configuration = configuration;\n" +
                "    this.result = path.evaluate(rootDocument, rootDocument, configuration).getValue();\n" +
                "}";
        String real4 = "@Override\n" +
                "public boolean matches(Object model) {\n" +
                "    return predicatePathToken.accept(model, ctx.rootDocument(), ctx.configuration(), ctx);\n" +
                "}";
        String real5 = "public GsonMappingProvider(Callable<Gson> factory) {\n" +
                "    this.factory = factory;\n" +
                "}";
        String real6 = "public GsonMappingProvider(final Gson gson) {\n" +
                "    this(new Callable<Gson>() {\n" +
                "\n" +
                "        @Override\n" +
                "        public Gson call() {\n" +
                "            return gson;\n" +
                "        }\n" +
                "    });\n" +
                "}";

        assertEquals(body0, real0);
        assertEquals(body1, real1);
        assertEquals(body2, real2);
        assertEquals(body3, real3);
        assertEquals(body4, real4);
        assertEquals(body5, real5);
        assertEquals(body6, real6);
    }

    @Test
    public void GsonTest() {
        Downloader downloader = new Downloader();
        String path = "PacketsDirectory";
        String signature0 = "<com.google.gson.internal.bind.TypeAdapters$23: java.lang.Object read(com.google.gson.stream.JsonReader)>";
        String signature1 = "<com.google.gson.internal.bind.TypeAdapters$3: java.lang.Object read(com.google.gson.stream.JsonReader)>";
        String signature2 = "<com.google.gson.internal.bind.TypeAdapters$2: java.lang.Object read(com.google.gson.stream.JsonReader)>";
        String signature3 = "<com.google.gson.internal.bind.TypeAdapters$4: void write(com.google.gson.stream.JsonWriter,java.lang.Object)>";
        String signature4 = "<com.google.gson.internal.bind.TypeAdapters$28: void write(com.google.gson.stream.JsonWriter,java.lang.Object)>";
        String signature5 = "<com.google.gson.internal.bind.TypeAdapters: com.google.gson.TypeAdapterFactory newFactory(java.lang.Class,com.google.gson.TypeAdapter)>";
        String signature6 = "<com.google.gson.Gson: void <init>(com.google.gson.internal.Excluder,com.google.gson.FieldNamingStrategy,java.util.Map,boolean,boolean,boolean,boolean,com.google.gson.FormattingStyle,boolean,boolean,boolean,com.google.gson.LongSerializationPolicy,java.lang.String,int,int,java.util.List,java.util.List,java.util.List,com.google.gson.ToNumberStrategy,com.google.gson.ToNumberStrategy,java.util.List)>";


        String body0 = downloader.find(path, signature0);
        String body1 = downloader.find(path, signature1);
        String body2 = downloader.find(path, signature2);
        String body3 = downloader.find(path, signature3);
        String body4 = downloader.find(path, signature4);
        String body5 = downloader.find(path, signature5);
        String body6 = downloader.find(path, signature6);

        String real0 = "@Override\n" +
                "public InetAddress read(JsonReader in) throws IOException {\n" +
                "    if (in.peek() == JsonToken.NULL) {\n" +
                "        in.nextNull();\n" +
                "        return null;\n" +
                "    }\n" +
                "    // regrettably, this should have included both the host name and the host address\n" +
                "    return InetAddress.getByName(in.nextString());\n" +
                "}";
        String real1 = "@Override\n" +
                "public Boolean read(JsonReader in) throws IOException {\n" +
                "    JsonToken peek = in.peek();\n" +
                "    if (peek == JsonToken.NULL) {\n" +
                "        in.nextNull();\n" +
                "        return null;\n" +
                "    } else if (peek == JsonToken.STRING) {\n" +
                "        // support strings for compatibility with GSON 1.7\n" +
                "        return Boolean.parseBoolean(in.nextString());\n" +
                "    }\n" +
                "    return in.nextBoolean();\n" +
                "}";
        String real2 = "@Override\n" +
                "public BitSet read(JsonReader in) throws IOException {\n" +
                "    BitSet bitset = new BitSet();\n" +
                "    in.beginArray();\n" +
                "    int i = 0;\n" +
                "    JsonToken tokenType = in.peek();\n" +
                "    while (tokenType != JsonToken.END_ARRAY) {\n" +
                "        boolean set;\n" +
                "        switch(tokenType) {\n" +
                "            case NUMBER:\n" +
                "            case STRING:\n" +
                "                int intValue = in.nextInt();\n" +
                "                if (intValue == 0) {\n" +
                "                    set = false;\n" +
                "                } else if (intValue == 1) {\n" +
                "                    set = true;\n" +
                "                } else {\n" +
                "                    throw new JsonSyntaxException(\"Invalid bitset value \" + intValue + \", expected 0 or 1; at path \" + in.getPreviousPath());\n" +
                "                }\n" +
                "                break;\n" +
                "            case BOOLEAN:\n" +
                "                set = in.nextBoolean();\n" +
                "                break;\n" +
                "            default:\n" +
                "                throw new JsonSyntaxException(\"Invalid bitset value type: \" + tokenType + \"; at path \" + in.getPath());\n" +
                "        }\n" +
                "        if (set) {\n" +
                "            bitset.set(i);\n" +
                "        }\n" +
                "        ++i;\n" +
                "        tokenType = in.peek();\n" +
                "    }\n" +
                "    in.endArray();\n" +
                "    return bitset;\n" +
                "}";
        String real3 = "@Override\n" +
                "public void write(JsonWriter out, Boolean value) throws IOException {\n" +
                "    out.value(value == null ? \"null\" : value.toString());\n" +
                "}";
        String real4 = "@Override\n" +
                "public void write(JsonWriter out, JsonElement value) throws IOException {\n" +
                "    if (value == null || value.isJsonNull()) {\n" +
                "        out.nullValue();\n" +
                "    } else if (value.isJsonPrimitive()) {\n" +
                "        JsonPrimitive primitive = value.getAsJsonPrimitive();\n" +
                "        if (primitive.isNumber()) {\n" +
                "            out.value(primitive.getAsNumber());\n" +
                "        } else if (primitive.isBoolean()) {\n" +
                "            out.value(primitive.getAsBoolean());\n" +
                "        } else {\n" +
                "            out.value(primitive.getAsString());\n" +
                "        }\n" +
                "    } else if (value.isJsonArray()) {\n" +
                "        out.beginArray();\n" +
                "        for (JsonElement e : value.getAsJsonArray()) {\n" +
                "            write(out, e);\n" +
                "        }\n" +
                "        out.endArray();\n" +
                "    } else if (value.isJsonObject()) {\n" +
                "        out.beginObject();\n" +
                "        for (Map.Entry<String, JsonElement> e : value.getAsJsonObject().entrySet()) {\n" +
                "            out.name(e.getKey());\n" +
                "            write(out, e.getValue());\n" +
                "        }\n" +
                "        out.endObject();\n" +
                "    } else {\n" +
                "        throw new IllegalArgumentException(\"Couldn't write \" + value.getClass());\n" +
                "    }\n" +
                "}";
        String real5 = "public static <TT> TypeAdapterFactory newFactory(final Class<TT> type, final TypeAdapter<TT> typeAdapter) {\n" +
                "    return new TypeAdapterFactory() {\n" +
                "\n" +
                "        // we use a runtime check to make sure the 'T's equal\n" +
                "        @SuppressWarnings(\"unchecked\")\n" +
                "        @Override\n" +
                "        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {\n" +
                "            return typeToken.getRawType() == type ? (TypeAdapter<T>) typeAdapter : null;\n" +
                "        }\n" +
                "\n" +
                "        @Override\n" +
                "        public String toString() {\n" +
                "            return \"Factory[type=\" + type.getName() + \",adapter=\" + typeAdapter + \"]\";\n" +
                "        }\n" +
                "    };\n" +
                "}";
        String real6 = "Gson(Excluder excluder, FieldNamingStrategy fieldNamingStrategy, Map<Type, InstanceCreator<?>> instanceCreators, boolean serializeNulls, boolean complexMapKeySerialization, boolean generateNonExecutableGson, boolean htmlSafe, FormattingStyle formattingStyle, boolean lenient, boolean serializeSpecialFloatingPointValues, boolean useJdkUnsafe, LongSerializationPolicy longSerializationPolicy, String datePattern, int dateStyle, int timeStyle, List<TypeAdapterFactory> builderFactories, List<TypeAdapterFactory> builderHierarchyFactories, List<TypeAdapterFactory> factoriesToBeAdded, ToNumberStrategy objectToNumberStrategy, ToNumberStrategy numberToNumberStrategy, List<ReflectionAccessFilter> reflectionFilters) {\n" +
                "    this.excluder = excluder;\n" +
                "    this.fieldNamingStrategy = fieldNamingStrategy;\n" +
                "    this.instanceCreators = instanceCreators;\n" +
                "    this.constructorConstructor = new ConstructorConstructor(instanceCreators, useJdkUnsafe, reflectionFilters);\n" +
                "    this.serializeNulls = serializeNulls;\n" +
                "    this.complexMapKeySerialization = complexMapKeySerialization;\n" +
                "    this.generateNonExecutableJson = generateNonExecutableGson;\n" +
                "    this.htmlSafe = htmlSafe;\n" +
                "    this.formattingStyle = formattingStyle;\n" +
                "    this.lenient = lenient;\n" +
                "    this.serializeSpecialFloatingPointValues = serializeSpecialFloatingPointValues;\n" +
                "    this.useJdkUnsafe = useJdkUnsafe;\n" +
                "    this.longSerializationPolicy = longSerializationPolicy;\n" +
                "    this.datePattern = datePattern;\n" +
                "    this.dateStyle = dateStyle;\n" +
                "    this.timeStyle = timeStyle;\n" +
                "    this.builderFactories = builderFactories;\n" +
                "    this.builderHierarchyFactories = builderHierarchyFactories;\n" +
                "    this.objectToNumberStrategy = objectToNumberStrategy;\n" +
                "    this.numberToNumberStrategy = numberToNumberStrategy;\n" +
                "    this.reflectionFilters = reflectionFilters;\n" +
                "    List<TypeAdapterFactory> factories = new ArrayList<>();\n" +
                "    // built-in type adapters that cannot be overridden\n" +
                "    factories.add(TypeAdapters.JSON_ELEMENT_FACTORY);\n" +
                "    factories.add(ObjectTypeAdapter.getFactory(objectToNumberStrategy));\n" +
                "    // the excluder must precede all adapters that handle user-defined types\n" +
                "    factories.add(excluder);\n" +
                "    // users' type adapters\n" +
                "    factories.addAll(factoriesToBeAdded);\n" +
                "    // type adapters for basic platform types\n" +
                "    factories.add(TypeAdapters.STRING_FACTORY);\n" +
                "    factories.add(TypeAdapters.INTEGER_FACTORY);\n" +
                "    factories.add(TypeAdapters.BOOLEAN_FACTORY);\n" +
                "    factories.add(TypeAdapters.BYTE_FACTORY);\n" +
                "    factories.add(TypeAdapters.SHORT_FACTORY);\n" +
                "    TypeAdapter<Number> longAdapter = longAdapter(longSerializationPolicy);\n" +
                "    factories.add(TypeAdapters.newFactory(long.class, Long.class, longAdapter));\n" +
                "    factories.add(TypeAdapters.newFactory(double.class, Double.class, doubleAdapter(serializeSpecialFloatingPointValues)));\n" +
                "    factories.add(TypeAdapters.newFactory(float.class, Float.class, floatAdapter(serializeSpecialFloatingPointValues)));\n" +
                "    factories.add(NumberTypeAdapter.getFactory(numberToNumberStrategy));\n" +
                "    factories.add(TypeAdapters.ATOMIC_INTEGER_FACTORY);\n" +
                "    factories.add(TypeAdapters.ATOMIC_BOOLEAN_FACTORY);\n" +
                "    factories.add(TypeAdapters.newFactory(AtomicLong.class, atomicLongAdapter(longAdapter)));\n" +
                "    factories.add(TypeAdapters.newFactory(AtomicLongArray.class, atomicLongArrayAdapter(longAdapter)));\n" +
                "    factories.add(TypeAdapters.ATOMIC_INTEGER_ARRAY_FACTORY);\n" +
                "    factories.add(TypeAdapters.CHARACTER_FACTORY);\n" +
                "    factories.add(TypeAdapters.STRING_BUILDER_FACTORY);\n" +
                "    factories.add(TypeAdapters.STRING_BUFFER_FACTORY);\n" +
                "    factories.add(TypeAdapters.newFactory(BigDecimal.class, TypeAdapters.BIG_DECIMAL));\n" +
                "    factories.add(TypeAdapters.newFactory(BigInteger.class, TypeAdapters.BIG_INTEGER));\n" +
                "    // Add adapter for LazilyParsedNumber because user can obtain it from Gson and then try to serialize it again\n" +
                "    factories.add(TypeAdapters.newFactory(LazilyParsedNumber.class, TypeAdapters.LAZILY_PARSED_NUMBER));\n" +
                "    factories.add(TypeAdapters.URL_FACTORY);\n" +
                "    factories.add(TypeAdapters.URI_FACTORY);\n" +
                "    factories.add(TypeAdapters.UUID_FACTORY);\n" +
                "    factories.add(TypeAdapters.CURRENCY_FACTORY);\n" +
                "    factories.add(TypeAdapters.LOCALE_FACTORY);\n" +
                "    factories.add(TypeAdapters.INET_ADDRESS_FACTORY);\n" +
                "    factories.add(TypeAdapters.BIT_SET_FACTORY);\n" +
                "    factories.add(DateTypeAdapter.FACTORY);\n" +
                "    factories.add(TypeAdapters.CALENDAR_FACTORY);\n" +
                "    if (SqlTypesSupport.SUPPORTS_SQL_TYPES) {\n" +
                "        factories.add(SqlTypesSupport.TIME_FACTORY);\n" +
                "        factories.add(SqlTypesSupport.DATE_FACTORY);\n" +
                "        factories.add(SqlTypesSupport.TIMESTAMP_FACTORY);\n" +
                "    }\n" +
                "    factories.add(ArrayTypeAdapter.FACTORY);\n" +
                "    factories.add(TypeAdapters.CLASS_FACTORY);\n" +
                "    // type adapters for composite and user-defined types\n" +
                "    factories.add(new CollectionTypeAdapterFactory(constructorConstructor));\n" +
                "    factories.add(new MapTypeAdapterFactory(constructorConstructor, complexMapKeySerialization));\n" +
                "    this.jsonAdapterFactory = new JsonAdapterAnnotationTypeAdapterFactory(constructorConstructor);\n" +
                "    factories.add(jsonAdapterFactory);\n" +
                "    factories.add(TypeAdapters.ENUM_FACTORY);\n" +
                "    factories.add(new ReflectiveTypeAdapterFactory(constructorConstructor, fieldNamingStrategy, excluder, jsonAdapterFactory, reflectionFilters));\n" +
                "    this.factories = Collections.unmodifiableList(factories);\n" +
                "}";

        assertEquals(body0, real0);
        assertEquals(body1, real1);
        assertEquals(body2, real2);
        assertEquals(body3, real3);
        assertEquals(body4, real4);
        assertEquals(body5, real5);
        assertEquals(body6, real6);
    }
}
