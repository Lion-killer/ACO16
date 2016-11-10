package dataStructures.queueAndDeque;

import dataStructures.MyLinkedList;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

// E element();
// boolean offer(E e);
// E peek();
// E poll();
// E remove();
// boolean add(E e);

public abstract class LinkedListQueueTest {

    MyLinkedList<String> list;

    @Before
    public void init() {
        list = new MyLinkedList<>();
    }

    @Test (expected = NoSuchElementException.class)
    public void test_element_NoSuchElement() {
        MyLinkedList list = new MyLinkedList();
        list.element();
    }

    @Test
    public void testPeek() {

        MyLinkedList list = new MyLinkedList();
        assertEquals("Test null", null, list.peek());

        list.offer("0");
        assertEquals("Test null", "0", list.peek());

    }

    @Test
    public void testPoll() {

        MyLinkedList list = new MyLinkedList();
        assertEquals("Test null", null, list.poll());

        list.offer("0");
        assertEquals("Test null", "0", list.poll());
        assertEquals("Test size", 0, list.size());

    }

    @Test
    public void testOffer() {

        list.offer("0");
        assertEquals("0", list.element());

        list.offer("1");
        assertEquals("0", list.element());
    }

    @Test
    public void testRemove() {

        list.offer("0");
        list.offer("1");

        list.remove();

        assertEquals("1", list.element());

    }

}
