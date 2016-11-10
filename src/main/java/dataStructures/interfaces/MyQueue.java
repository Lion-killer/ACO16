package dataStructures.interfaces;

/**
 * Created by bilousyv on 09.11.2016.
 */
public interface MyQueue<E> {

    E element();
    boolean offer(E e);
    E peek();
    E poll();
    E remove();
    boolean add(E e);
}
