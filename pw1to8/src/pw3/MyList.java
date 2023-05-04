package pw3;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyList<T> implements List<T> {

    private static final Lock lock = new ReentrantLock();
    private int size = 0;
    private final int INIT_SIZE = 10;
    private Object[] arr = new Object[INIT_SIZE];
    transient Object[] elementData;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        lock.lock();
        if(size == arr.length-1)
            increase();
        arr[size] = t;
        lock.unlock();
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        lock.lock();
        for (int i = index; i < size; i++)
            arr[i] = arr[i+1];
        arr[size] = null;
        lock.unlock();
        size--;
        if (arr.length > INIT_SIZE && size < arr.length / 2) {
            lock.lock();
            reduce();
            lock.unlock();
        }
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return addAll(this.size, c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public T get(int index) {
        return (T) arr[index];
    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public void add(int index, T t) {
        if(size == arr.length-1) {
            lock.lock();
            increase();
            lock.unlock();
        }
        size++;
        arr[size] = t;
    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return indexOfRange(o, 0, size);
    }

    int indexOfRange(Object o, int start, int end) {
        Object[] es = elementData;
        if (o == null) {
            for (int i = start; i < end; i++) {
                if (es[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = start; i < end; i++) {
                if (o.equals(es[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    private void increase(){
        Object[] arrCopy = new Object[size * 2];
        System.arraycopy(arr, 0, arrCopy, 0, arr.length);
        this.arr = arrCopy;
    }

    private void reduce(){
        Object[] arrCopy = new Object[size / 2];
        System.arraycopy(arr, 0, arrCopy, 0, arr.length);
        this.arr = arrCopy;
    }
}
