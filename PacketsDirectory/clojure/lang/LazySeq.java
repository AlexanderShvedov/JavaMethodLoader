//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package clojure.lang;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public final class LazySeq extends Obj implements ISeq, Sequential, List, IPending, IHashEq {
    private IFn fn;
    private Object sv;
    private ISeq s;

    public LazySeq(IFn fn) {
        this.fn = fn;
    }

    private LazySeq(IPersistentMap meta, ISeq s) {
        super(meta);
        this.fn = null;
        this.s = s;
    }

    public Obj withMeta(IPersistentMap meta) {
        return new LazySeq(meta, this.seq());
    }

    final synchronized Object sval() {
        if (this.fn != null) {
            this.sv = this.fn.invoke();
            this.fn = null;
        }

        return this.sv != null ? this.sv : this.s;
    }

    public final synchronized ISeq seq() {
        this.sval();
        if (this.sv != null) {
            Object ls = this.sv;

            for(this.sv = null; ls instanceof LazySeq; ls = ((LazySeq)ls).sval()) {
            }

            this.s = RT.seq(ls);
        }

        return this.s;
    }

    public int count() {
        int c = 0;

        for(ISeq s = this.seq(); s != null; s = s.next()) {
            ++c;
        }

        return c;
    }

    public Object first() {
        this.seq();
        return this.s == null ? null : this.s.first();
    }

    public ISeq next() {
        this.seq();
        return this.s == null ? null : this.s.next();
    }

    public ISeq more() {
        this.seq();
        return (ISeq)(this.s == null ? PersistentList.EMPTY : this.s.more());
    }

    public ISeq cons(Object o) {
        return RT.cons(o, this.seq());
    }

    public IPersistentCollection empty() {
        return PersistentList.EMPTY;
    }

    public boolean equiv(Object o) {
        ISeq s = this.seq();
        if (s != null) {
            return s.equiv(o);
        } else {
            return (o instanceof Sequential || o instanceof List) && RT.seq(o) == null;
        }
    }

    public int hashCode() {
        ISeq s = this.seq();
        return s == null ? 1 : Util.hash(s);
    }

    public int hasheq() {
        return Murmur3.hashOrdered(this);
    }

    public boolean equals(Object o) {
        ISeq s = this.seq();
        if (s != null) {
            return s.equals(o);
        } else {
            return (o instanceof Sequential || o instanceof List) && RT.seq(o) == null;
        }
    }

    public Object[] toArray() {
        return RT.seqToArray(this.seq());
    }

    public boolean add(Object o) {
        throw new UnsupportedOperationException();
    }

    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection c) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        throw new UnsupportedOperationException();
    }

    public boolean retainAll(Collection c) {
        throw new UnsupportedOperationException();
    }

    public boolean removeAll(Collection c) {
        throw new UnsupportedOperationException();
    }

    public boolean containsAll(Collection c) {
        Iterator i$ = c.iterator();

        Object o;
        do {
            if (!i$.hasNext()) {
                return true;
            }

            o = i$.next();
        } while(this.contains(o));

        return false;
    }

    public Object[] toArray(Object[] a) {
        return RT.seqToPassedArray(this.seq(), a);
    }

    public int size() {
        return this.count();
    }

    public boolean isEmpty() {
        return this.seq() == null;
    }

    public boolean contains(Object o) {
        for(ISeq s = this.seq(); s != null; s = s.next()) {
            if (Util.equiv(s.first(), o)) {
                return true;
            }
        }

        return false;
    }

    public Iterator iterator() {
        return new SeqIterator(this);
    }

    private List reify() {
        return new ArrayList(this);
    }

    public List subList(int fromIndex, int toIndex) {
        return this.reify().subList(fromIndex, toIndex);
    }

    public Object set(int index, Object element) {
        throw new UnsupportedOperationException();
    }

    public Object remove(int index) {
        throw new UnsupportedOperationException();
    }

    public int indexOf(Object o) {
        ISeq s = this.seq();

        for(int i = 0; s != null; ++i) {
            if (Util.equiv(s.first(), o)) {
                return i;
            }

            s = s.next();
        }

        return -1;
    }

    public int lastIndexOf(Object o) {
        return this.reify().lastIndexOf(o);
    }

    public ListIterator listIterator() {
        return this.reify().listIterator();
    }

    public ListIterator listIterator(int index) {
        return this.reify().listIterator(index);
    }

    public Object get(int index) {
        return RT.nth(this, index);
    }

    public void add(int index, Object element) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(int index, Collection c) {
        throw new UnsupportedOperationException();
    }

    public synchronized boolean isRealized() {
        return this.fn == null;
    }
}
