package week2.arrayList;

import homework.week2.MyList;
import homework.week3.MyLinkedList;
import org.junit.*;

import java.util.ArrayList;

/**
 * Created by bilousyv on 16.10.2016.
 */
public class MyListTest {

    private MyList myList;

    @Before
    public void init(){
        myList = new MyLinkedList();
    }

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

        myList.add("1");
        myList.add("2");
        myList.add("3");
        myList.add("4");

        myList.add(2, "10");

        Assert.assertEquals(5, myList.size());

        Assert.assertEquals("10", myList.get(2));

        Assert.assertEquals("4", myList.get(4));

    }

    @Test
    public void testDeleteElement() {

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

        Assert.assertEquals("Test not null", true, myList.contains("4"));


        myList.add(null);
        Assert.assertEquals("Test null", true, myList.contains(null));

    }

    @Test
    public void testIsEmpty() {

        myList.add(1);
        myList.add(2);

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

}
