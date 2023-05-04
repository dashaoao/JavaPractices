package pw3;

import java.util.*;

public class MySet<T> implements Set<T> {

    private final Set<T> hash = new HashSet<T>();

    @Override
    public synchronized int size() {
        return hash.size();
    }

    @Override
    public synchronized boolean isEmpty() {
        return hash.isEmpty();
    }

    @Override
    public synchronized boolean contains(Object o) {
        return hash.contains(o);
    }

    @Override
    public synchronized boolean add(T t) {
        return hash.add(t);
    }

    @Override
    public synchronized boolean remove(Object o) {
        return hash.remove(o);
    }

    @Override
    public synchronized boolean addAll(Collection c) {
        return false;
    }

    @Override
    public synchronized void clear() {
        hash.clear();
    }

    @Override
    public synchronized boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public Iterator iterator() {
        return hash.iterator();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }
}
