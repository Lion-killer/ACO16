package dataStructures.interfaces;

import dataStructures.MyLinkedList;
import dataStructures.interfaces.MyQueue;
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

public abstract class MyQueueTest {

    protected MyQueue<String> queue;

    @Before
    public abstract void init();

    @Test (expected = NoSuchElementException.class)
    public void test_element_NoSuchElement() {
        MyLinkedList list = new MyLinkedList();
        list.element();
    }

    @Test
    public void testPeek() {

        assertEquals("Test null", null, queue.peek());

        queue.offer("0");
        assertEquals("Test null", "0", queue.peek());

    }

    @Test
    public void testPoll() {

        assertEquals("Test null", null, queue.poll());

        queue.offer("0");
        assertEquals("Test null", "0", queue.poll());

    }

    @Test
    public void testOffer() {

        queue.offer("0");
        assertEquals("0", queue.element());

        queue.offer("1");
        assertEquals("0", queue.element());
    }

    @Test
    public void testRemove() {

        queue.offer("0");
        queue.offer("1");

        queue.remove();

        assertEquals("1", queue.element());

    }

}
