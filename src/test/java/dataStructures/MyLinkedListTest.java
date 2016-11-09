package dataStructures;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.NoSuchElementException;


/**
 * Created by bilousyv on 31.10.2016.
 */
public class MyLinkedListTest extends MyListTest {
    @Override
    public void init() {
        myList = new MyLinkedList<>();
    }

    @Test (expected = NoSuchElementException.class)
    public void testNoSuchElement() {
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
    public void testAddFirst() {

        MyLinkedList list = new MyLinkedList();
        list.add("1");
        list.add("2");

        list.addFirst("0");

        assertEquals("0", list.getFirst());

    }

    @Test (expected = NoSuchElementException.class)
    public void testRemoveFirstLast() {

        MyLinkedList list = new MyLinkedList();
        list.add("1");
        list.add("2");

        list.removeFirst();
        list.removeLast();

        list.removeFirst();

    }
}
