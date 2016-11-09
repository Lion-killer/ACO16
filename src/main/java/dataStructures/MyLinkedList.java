package dataStructures;

import dataStructures.interfaces.MyDeque;
import dataStructures.interfaces.MyList;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by bilousyv on 28.10.2016.
 */
public class MyLinkedList<T> implements MyList<T>, MyDeque<T> {

    private int size;
    private Node<T> head;
    private Node<T> tail;

    public MyLinkedList() {
    }

    @Override
    public T element() {
        return getFirst();
    }

    @Override
    public boolean offer(T t) {
        return add(t);
    }

    @Override
    public T peek() {
        final Node<T> f = head;
        return (f == null) ? null : f.value;
    }

    @Override
    public T poll() {
        final Node<T> f = head;
        return (f == null) ? null : unlinkFirst(f);
    }

    @Override
    public T remove() {
        return removeFirst();
    }

    @Override
    public boolean add(T o) {

        if(tail == null){
            head = tail = new Node<>(o);
            size++;
            return true;
        }

        Node<T> newNode = new Node<>(o);
        tail.setNext(newNode);
        newNode.setPrevious(tail);

        tail = newNode;
        size++;

        return true;
    }

    @Override
    public void add(int index, T o) {

        if(index < 0 || index > size) throw new IndexOutOfBoundsException();

        if(tail == null){
            head = tail = new Node<>(o);
        } else if (index == 0) {
            Node<T> newNode = new Node<>(head, null, o);
            head.setPrevious(newNode);
            head = newNode;
        } else if (index == size) {
            Node<T> newNode = new Node<>(tail, o);
            tail.setNext(newNode);
            tail = newNode;
        } else {
            Node<T> iterator = getNodeByIndex(index);
            Node<T> newNode = new Node<>(iterator, iterator.getPrevious(), o);
            iterator.getPrevious().setNext(newNode);
            iterator.setPrevious(newNode);
        }

        size++;
    }

    @Override
    public void clear() {
        Node<T> iterator = head;
        for (int i = 0; i < size; i++) {
            iterator.setValue(null);
            iterator = iterator.getNext();
        }
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public boolean contains(T o) {
        return indexOf(o) != -1;
    }

    @Override
    public T get(int index) {
        checkIndex(index);

        Node<T> iterator = getNodeByIndex(index);

        return iterator.getValue();
    }

    private Node<T> getNodeByIndex(int index) {
        Node<T> iterator = head;

        for (int i = 1; i <= index; i++) {
            iterator = iterator.getNext();
        }
        return iterator;
    }

    private Node<T> getNodeByValue(T o) {
        Node<T> iterator = head;

        for (int i = 1; i <= size; i++) {
            if (compare(o, iterator.getValue())) return iterator;
            iterator = iterator.getNext();
        }
        return null;
    }

    @Override
    public int indexOf(T o) {

        Node<T> iterator = head;
        for (int i = 0; i < size; i++) {

            if (compare(o, iterator.getValue())) return i;

            iterator = iterator.getNext();
        }
        return -1;
    }

    private boolean compare(T o1, T o2) {
        if (o1 == null) {
            if (o2 == null) return true;
        } else {
            if (o1.equals(o2)) return true;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int lastIndexOf(T o) {
        Node<T> iterator = tail;
        for (int i = size - 1; i > 0; i--) {

            if (compare(o, iterator.getValue())) return i;

            iterator = iterator.getPrevious();
        }
        return -1;
    }

    @Override
    public T remove(int index) {

        checkIndex(index);

        Node<T> removedNode;

        if (head == tail){
            removedNode = head;
            clear();
        } else if (index == 0){
            removedNode = head;
            head = head.getNext();
        } else if (index == size - 1){
            removedNode = tail;
            tail = tail.getPrevious();
        } else {
            removedNode = getNodeByIndex(index);
            Node<T> previousNode = removedNode.getPrevious();
            Node<T> nextNode = removedNode.getNext();
            previousNode.setNext(nextNode);
            nextNode.setPrevious(previousNode);
        }

        size--;

        return removedNode.getValue();
    }

    @Override
    public boolean remove(T o) {

        Node<T> removedNode = getNodeByValue(o);

        if (removedNode == null) return false;

        if (head == tail) {
            clear();
        } else if (removedNode == head) {
            head = removedNode.getNext();
        } else if (removedNode == tail) {
            tail = removedNode.getPrevious();
        } else {
            Node<T> previousNode = removedNode.getPrevious();
            Node<T> nextNode = removedNode.getNext();
            previousNode.setNext(nextNode);
            nextNode.setPrevious(previousNode);
        }

        size--;

        return true;
    }

    @Override
    public T set(int index, T o) {
        Node<T> iterator = head;
        for (int i = 0; i < size; i++) {
            if (i == index){
                T oldValue = iterator.getValue();
                iterator.setValue(o);
                return oldValue;
            }
            iterator = iterator.getNext();
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T[] toArray() {
        Node<T> iterator = head;
        T[] array = (T[]) new Object[size];
        for (int i = 0; i < size; i++) {
            array[i] = iterator.getValue();
            iterator = iterator.getNext();
        }
        return array;
    }

    private void checkIndex(int index) {
        if(index < 0 || index >= size) throw new IndexOutOfBoundsException();
    }

    @Override
    public Iterator<T> iterator() {
        return new MyLinkedListIterator();
    }

    @Override
    public void addFirst(T t) {
        Node<T> f = head;
        Node<T> newNode = new Node<>(f, null, t);
        head = newNode;
        if (f == null)
            tail = newNode;
        else
            f.previous = newNode;
        size++;
    }

    @Override
    public void addLast(T t) {
        Node<T> l = tail;
        Node<T> newNode = new Node<>(null, l, t);
        tail = newNode;
        if (l == null)
            head = newNode;
        else
            l.next = newNode;
        size++;
    }

    @Override
    public T getFirst() {
        Node<T> f = head;
        if (f == null)
            throw new NoSuchElementException();
        return f.value;
    }

    @Override
    public T getLast() {
        Node<T> f = tail;
        if (f == null)
            throw new NoSuchElementException();
        return f.value;
    }

    @Override
    public boolean offerFirst(T t) {
        addFirst(t);
        return true;
    }

    @Override
    public boolean offerLast(T t) {
        addLast(t);
        return true;
    }

    @Override
    public T peekFirst() {
        final Node<T> f = head;
        return (f == null) ? null : f.value;
    }

    @Override
    public T peekLast() {
        final Node<T> l = tail;
        return (l == null) ? null : l.value;
    }

    @Override
    public T pollFirst() {
        final Node<T> f = head;
        return (f == null) ? null : unlinkFirst(f);
    }

    @Override
    public T pollLast() {
        final Node<T> l = tail;
        return (l == null) ? null : unlinkLast(l);
    }

    @Override
    public void push(T t) {
        addFirst(t);
    }

    @Override
    public T removeFirst() {
        final Node<T> f = head;
        if (f == null)
            throw new NoSuchElementException();
        return unlinkFirst(f);
    }

    @Override
    public T removeLast() {
        final Node<T> l = tail;
        if (l == null)
            throw new NoSuchElementException();
        return unlinkLast(l);
    }

    private T unlinkFirst(Node<T> f) {
        T element = f.value;
        Node<T> next = f.next;
        f.value = null;
        f.next = null;
        head = next;
        if (next == null)
            tail = null;
        else
            next.previous = null;
        size--;
        return element;
    }

     private T unlinkLast(Node<T> l) {
        final T element = l.value;
        final Node<T> prev = l.previous;
        l.value = null;
        l.previous = null;
        tail = prev;
        if (prev == null)
            head = null;
        else
            prev.next = null;
        size--;
        return element;
    }

    private static class Node<T> {
        Node<T> next;
        Node<T> previous;
        T value;

        public Node(Node<T> next, Node<T> previous, T value) {
            this.next = next;
            this.previous = previous;
            this.value = value;
        }

        public Node(T value) {
            this.value = value;
        }

        public Node(Node<T> previous, T value) {
            this.previous = previous;
            this.value = value;
        }

        public Node() {

        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public Node<T> getPrevious() {
            return previous;
        }

        public void setPrevious(Node<T> previous) {
            this.previous = previous;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }
    }

    private class MyLinkedListIterator implements Iterator<T> {
        private Node<T> iterator;

        public MyLinkedListIterator() {
            this.iterator = new Node<>();
            this.iterator.next = head;
        }

        @Override
        public boolean hasNext() {
            return iterator.next != null;
        }

        @Override
        public T next() {
            iterator = iterator.next;
            return iterator.value;
        }
    }
}
