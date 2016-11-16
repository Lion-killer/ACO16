package dataStructures.interfaces;

import dataStructures.MyLinkedList;
import dataStructures.interfaces.MyDeque;
import org.junit.Before;
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

public abstract class MyDequeTest {

    protected MyDeque<String> deque;

    @Before
    public abstract void init();

    @Test
    public void testAddFirst() {

        deque.add("1");
        deque.add("2");

        deque.addFirst("0");

        assertEquals("test first element", "0", deque.getFirst());
        assertEquals("test last element", "2", deque.getLast());

    }

    @Test (expected = NoSuchElementException.class)
    public void testRemoveFirstLast() {

        deque.add("1");
        deque.add("2");

        deque.removeFirst();
        deque.removeLast();

        deque.removeFirst();

    }

    @Test
    public void testOfferFirst() {

        deque.offerFirst("0");
        deque.offerFirst("1");

        assertEquals("1", deque.peekFirst());

    }

    @Test
    public void testOfferLast() {

        deque.offerLast("0");
        deque.offerLast("1");

        assertEquals("1", deque.peekLast());

    }

    @Test
    public void testPoolFirstLast() {

        deque.push("1");
        deque.push("2");

        deque.pollFirst();
        deque.pollLast();

        assertEquals(null, deque.pollFirst());

    }

}
