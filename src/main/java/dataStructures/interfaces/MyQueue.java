package dataStructures.interfaces;

/**
 * Created by bilousyv on 09.11.2016.
 */
public interface MyQueue<E> {

    // Inserts the specified element into this queue if it is possible to do so immediately without violating capacity restrictions, returning true upon success and throwing an IllegalStateException if no space is currently available.
    E element();

    // Retrieves, but does not remove, the head of this queue.
    boolean offer(E e);

    // Inserts the specified element into this queue if it is possible to do so immediately without violating capacity restrictions.
    E peek();

    // Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
    E poll();

    // Retrieves and removes the head of this queue, or returns null if this queue is empty.
    E remove();

    // Retrieves and removes the head of this queue.
    boolean add(E e);
}
