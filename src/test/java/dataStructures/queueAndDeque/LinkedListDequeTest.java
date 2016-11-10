package dataStructures.queueAndDeque;

import dataStructures.MyLinkedList;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

//	addFirst(E e)
//  addLast(E e)
//  getFirst()
//  getLast()
//  offerFirst(E e)
//  offerLast(E e)
//  peekFirst()
//  peekLast()
//  pollFirst()
//  pollLast()
//  push(E e)
//  removeFirst()
//  removeLast()

public abstract class LinkedListDequeTest extends LinkedListQueueTest {

    @Test
    public void testAddFirst() {

        MyLinkedList list = new MyLinkedList();
        list.add("1");
        list.add("2");

        list.addFirst("0");

        assertEquals("test first element", "0", list.getFirst());
        assertEquals("test last element", "2", list.getLast());

    }

    @Test (expected = NoSuchElementException.class)
    public void testRemoveFirstLast() {

        list.add("1");
        list.add("2");

        list.removeFirst();
        list.removeLast();

        list.removeFirst();

    }

    @Test
    public void testOfferFirst() {

        list.offerFirst("0");
        list.offerFirst("1");

        assertEquals("1", list.peekFirst());

    }

    @Test
    public void testOfferLast() {

        list.offerLast("0");
        list.offerLast("1");

        assertEquals("1", list.peekLast());

    }

    @Test
    public void testPoolFirstLast() {

        list.push("1");
        list.push("2");

        list.pollFirst();
        list.pollLast();

        assertEquals(null, list.pollFirst());

    }

}
