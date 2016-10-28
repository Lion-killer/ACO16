package homework.week3;

import homework.week2.MyList;

/**
 * Created by bilousyv on 28.10.2016.
 */
public class MyLinkedList implements MyList {

    private int size;
    private Node head;
    private Node tail;

    public MyLinkedList() {
    }

    @Override
    public boolean add(Object o) {

        if(tail == null){
            head = tail = new Node(o);
            size++;
            return true;
        }

        Node newNode = new Node(o);
        tail.setNext(newNode);
        newNode.setPrevious(tail);

        tail = newNode;
        size++;

        return true;
    }

    @Override
    public void add(int index, Object o) {

        checkIndex(index);

        Node iterator = getNodeByIndex(index);

        Node newNode = new Node(iterator, iterator.getPrevious(), o);
        iterator.getPrevious().setNext(newNode);
        iterator.setPrevious(newNode);

        size++;
    }

    @Override
    public void clear() {
        Node iterator = head;
        for (int i = 0; i < size; i++) {
            iterator.setValue(null);
            iterator = iterator.getNext();
        }
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public boolean contains(Object o) {

        Node iterator = head;
        while (iterator != null){
            if (compare(iterator.getValue(), o))
                return true;
            else
                iterator = iterator.getNext();
        }
        return false;
    }

    @Override
    public Object get(int index) {
        checkIndex(index);

        Node iterator = getNodeByIndex(index);

        return iterator.getValue();
    }

    private Node getNodeByIndex(int index) {
        Node iterator = head;

        for (int i = 1; i <= index; i++) {
            iterator = iterator.getNext();
        }
        return iterator;
    }

    private Node getNodeByValue(Object o) {
        Node iterator = head;

        for (int i = 1; i <= size; i++) {
            if (compare(o, iterator.getValue())) return iterator;
            iterator = iterator.getNext();
        }
        return null;
    }


    @Override
    public int indexOf(Object o) {

        Node iterator = head;
        for (int i = 0; i < size; i++) {

            if (compare(o, iterator.getValue())) return i;

            iterator = iterator.getNext();
        }
        return -1;
    }

    private boolean compare(Object o1, Object o2) {
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
    public int lastIndexOf(Object o) {
        Node iterator = tail;
        for (int i = size - 1; i > 0; i--) {

            if (compare(o, iterator.getValue())) return i;

            iterator = iterator.getPrevious();
        }
        return -1;
    }

    @Override
    public Object remove(int index) {

        checkIndex(index);

        Node removedNode = getNodeByIndex(index);
        Node previousNode = removedNode.getPrevious();
        Node nextNode = removedNode.getNext();

        previousNode.setNext(nextNode);
        nextNode.setPrevious(previousNode);

        size--;

        return removedNode.getValue();
    }

    @Override
    public boolean remove(Object o) {

        Node removedNode = getNodeByValue(o);
        Node previousNode = removedNode.getPrevious();
        Node nextNode = removedNode.getNext();

        previousNode.setNext(nextNode);
        nextNode.setPrevious(previousNode);

        size--;

        return true;
    }

    @Override
    public Object set(int index, Object o) {
        Node iterator = head;
        for (int i = 0; i < size; i++) {
            if (i == index){
                Object oldValue = iterator.getValue();
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
    public Object[] toArray() {
        Node iterator = head;
        Object[] array = new Object[size];
        for (int i = 0; i < size; i++) {
            array[i] = iterator.getValue();
            iterator = iterator.getNext();
        }
        return array;
    }

    private void checkIndex(int index) {
//        if(index < 0 || index >= size) throw new IndexOutOfBoundsException();
        if(index < 0 || index >= size) System.exit(-5);
    }

    private class Node {
        private Node next;
        private Node previous;
        private Object value;

        public Node(Node next, Node previous, Object value) {
            this.next = next;
            this.previous = previous;
            this.value = value;
        }

        public Node(Object value) {
            this.value = value;
        }

        public Node(Node previous, Object value) {
            this.previous = previous;
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrevious() {
            return previous;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }
    }


}
