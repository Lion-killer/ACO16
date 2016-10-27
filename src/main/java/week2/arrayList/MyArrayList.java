package week2.arrayList;

import homework.week2.MyList;

import java.util.Arrays;

/**
 * Created by bilousyv on 16.10.2016.
 */
public class MyArrayList implements MyList {

    private Object[] elementData;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayList() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int capacity) {
        elementData = new Object[capacity];
    }

    public boolean add(Object object) {

        if (size == elementData.length)
            ensureCapacity(size + 1);

        elementData[size++] = object;

        return true;
    }

    private void ensureCapacity(int newSize) {

        int newElementDataSize = (int) (newSize * 1.1); // увеличиваем на 10%

        System.arraycopy(elementData, 0, elementData, 0, newElementDataSize);
    }

    @Override
    public void add(int index, Object o) {

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
    public boolean contains(Object o) {

        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null) return true;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elementData[i])) return true;
            }
        }

        return false;
    }

    public int size() {
        return size;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elementData, size);
    }

    public Object get(int index) {
        rangeCheck(index);
        return elementData[index];
    }

    @Override
    public int indexOf(Object o) {

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
    public int lastIndexOf(Object o) {
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
    public Object remove(int index) {

        rangeCheck(index);

        Object removedElement = elementData[index];
        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        elementData[--size] = null;
        return removedElement;
    }

    @Override
    public boolean remove(Object o) {

        int elementIndex = indexOf(o);

        if (elementIndex > 0) {
            remove(elementIndex);
            return true;
        }

        return false;
    }

    @Override
    public Object set(int index, Object o) {

        rangeCheck(index);

        Object oldValue = elementData[index];

        elementData[index] = o;

        return oldValue;
    }
}
