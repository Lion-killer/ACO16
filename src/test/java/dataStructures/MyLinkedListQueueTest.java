package dataStructures;

import dataStructures.MyLinkedList;
import dataStructures.interfaces.MyQueueTest;

/**
 * Created by bilousyv on 17.11.2016.
 */
public class MyLinkedListQueueTest extends MyQueueTest {
    @Override
    public void init() {
        queue = new MyLinkedList<>();
    }
}
