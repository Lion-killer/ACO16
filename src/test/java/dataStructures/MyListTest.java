package dataStructures;

import dataStructures.MyList;
import dataStructures.MyLinkedList;
import org.junit.*;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by bilousyv on 16.10.2016.
 */
public abstract class MyListTest {

    public MyList<String> myList;

    @Before
    public abstract void init();

    @After
    public void tearDown(){
        myList.clear();
        myList = null;
    }

    @Test
    public void testMyArrayListAdd(){

        boolean actual = myList.add("1");

        Assert.assertTrue(actual);

    }

    @Test
    public void testMyArrayListAddSize(){

        myList.add("1");
        Assert.assertEquals(1, myList.size());

    }

    @Test
    public void testMyArrayListAddTwoElements(){

        myList.add("1");
        myList.add("2");

        Assert.assertEquals("1", myList.get(0));
        Assert.assertEquals("2", myList.get(1));

    }

    @Test
    public void testMyArrayListAddByIndex(){

        myList.add(0, "1");
        myList.add("2");
        myList.add("3");
        myList.add("4");

        myList.add(2, "10");
        myList.add(5, "9");

        Assert.assertEquals(6, myList.size());

        Assert.assertEquals("10", myList.get(2));

        Assert.assertEquals("4", myList.get(4));

    }

    @Test
    public void testRemoveElement() {

        myList.add("1");
        myList.add("2");
        myList.add("3");
        myList.add("4");
        Assert.assertTrue("Remove first", myList.remove("1"));
        Assert.assertTrue("Remove last", myList.remove("4"));

        myList.clear();

        ArrayList<Object> testArray = new ArrayList<>(3);
        testArray.add("1");
        testArray.add("2");
        testArray.add("4");

        myList.add("1");
        myList.add("2");
        myList.add("3");
        myList.add("4");

        myList.remove("3");

        Assert.assertArrayEquals(testArray.toArray(), myList.toArray());

    }

    @Test
    public void testRemoveElementByIndex() {

        myList.add("1");
        myList.add("2");
        myList.add("3");
        myList.add("4");
        Assert.assertEquals("Remove first", "1", myList.remove(0));
        Assert.assertEquals("Remove last", "4", myList.remove(2));

    }

    @Test
    public void testRemoveMissingElement() {

        myList.add("1");
        myList.add("2");
        myList.add("3");

        Assert.assertFalse(myList.remove("4"));
    }

    @Test
    public void testLastIndexOf() {

        myList.add("1");
        myList.add("2");
        myList.add("3");
        myList.add("4");
        myList.add("3");

        Assert.assertEquals("Test not null", 4, myList.lastIndexOf("3"));

        myList.add(1, null);
        myList.add(null);

        Assert.assertEquals("Test null", 6, myList.lastIndexOf(null));
    }

    @Test
    public void testContains() {

        myList.add("1");
        myList.add("2");
        myList.add("3");
        myList.add("4");
        myList.add("3");
        myList.add("5");
        myList.add("6");
        myList.add("7");
        myList.add("8");
        myList.add("9");

        Assert.assertEquals("Test not null", true, myList.contains("4"));

        myList.add(null);
        Assert.assertEquals("Test null", true, myList.contains(null));

    }

    @Test
    public void testIsEmpty() {

        myList.add("1");
        myList.add("2");

        myList.clear();

        Assert.assertTrue(myList.isEmpty());

    }

    @Test
    public void testIndexOf(){

        myList.add("1");
        myList.add("2");
        myList.add("3");
        myList.add("4");
        myList.add("3");

        Assert.assertEquals("Test not null", 3, myList.indexOf("4"));


        myList.add(null);
        Assert.assertEquals("Test null", 5, myList.indexOf(null));

    }

    @Test
    public void testSetMethod() {

        myList.add("1");
        myList.add("2");
        myList.set(0, "10");

        Assert.assertEquals("10", myList.get(0));

    }

    @Test
    public void testIterator() {

        myList.add("1");
        myList.add("2");
        myList.add("3");
        myList.add("4");
        myList.add("3");

        Iterator iterator = myList.iterator();

        for (int i = 0; i < myList.size(); i++) {
            Assert.assertSame(myList.get(i), iterator.next());
        }
    }

    @Test
    public void testIteratorEmpty() {
        Iterator iterator = myList.iterator();
        Assert.assertFalse(iterator.hasNext());
    }

}
