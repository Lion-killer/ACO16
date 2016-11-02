package dataStructures;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by bilousyv on 16.10.2016.
 */
public class MyArrayList<T> implements MyList<T> {

    private T[] elementData;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayList() {
        elementData = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int capacity) {
        elementData = (T[]) new Object[capacity];
    }

    public boolean add(T object) {

        if (size == elementData.length)
            ensureCapacity(size + 1);

        elementData[size++] = object;

        return true;
    }

    private void ensureCapacity(int newSize) {

        int newElementDataSize = (int) (newSize * 1.1); // увеличиваем на 10%
        T[] newElementData = (T[]) new Object[newElementDataSize];

        System.arraycopy(elementData, 0, newElementData, 0, newSize - 1);
        elementData = newElementData;
    }

    @Override
    public void add(int index, T o) {

        rangeCheck(index);

        if (size == elementData.length)
            ensureCapacity(size + 1);

        System.arraycopy(elementData, index, elementData, index + 1,
                size - index);
        elementData[index] = o;
        size++;
    }

    private void rangeCheck(int index) {
        if (index > size || index < 0) throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elementData[i] = null;
        }
        size = 0;
    }

    @Override
    public boolean contains(T o) {
        return indexOf(o) != -1;
    }

    public int size() {
        return size;
    }

    @Override
    public T[] toArray() {
        return Arrays.copyOf(elementData, size);
    }

    public T get(int index) {
        rangeCheck(index);
        return elementData[index];
    }

    @Override
    public int indexOf(T o) {

        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null) return i;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elementData[i])) return i;
            }
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int lastIndexOf(T o) {
        if (o == null) {
            for (int index = size - 1; index >= 0; index--)
                if (elementData[index] == null) return index;
        } else {
            for (int index = size - 1; index >= 0; index--)
                if (o.equals(elementData[index])) return index;
        }
        return -1;
    }

    @Override
    public T remove(int index) {

        rangeCheck(index);

        T removedElement = elementData[index];
        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        elementData[--size] = null;
        return removedElement;
    }

    @Override
    public boolean remove(T o) {

        int elementIndex = indexOf(o);

        if (elementIndex > 0) {
            remove(elementIndex);
            return true;
        }

        return false;
    }

    @Override
    public T set(int index, T o) {

        rangeCheck(index);

        T oldValue = elementData[index];

        elementData[index] = o;

        return oldValue;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyArrayListIterator();
    }

    private class MyArrayListIterator implements Iterator<T> {
        private int currentPosition;

        @Override
        public boolean hasNext() {
            return currentPosition < size;
        }

        @Override
        public T next() {
            return get(currentPosition++);
        }
    }
}
