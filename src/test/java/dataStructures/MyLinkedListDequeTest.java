package dataStructures;

import dataStructures.interfaces.MyDequeTest;

/**
 * Created by bilousyv on 17.11.2016.
 */
public class MyLinkedListDequeTest extends MyDequeTest {
    @Override
    public void init() {
        deque = new MyLinkedList<>();
    }
}
