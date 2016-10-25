package week2.arrayList;

import homework.week2.MyList;
import org.junit.*;
import org.omg.CORBA.Object;

import java.util.ArrayList;

/**
 * Created by bilousyv on 16.10.2016.
 */
public class MyArrayListTest {

    private MyList myArrayList;

    @Before
    public void init(){
        myArrayList = new MyArrayList();
    }

    @After
    public void tearDown(){
        myArrayList = null;
    }

    @Test
    public void testMyArrayListAdd(){

        boolean actual = myArrayList.add("1");
        boolean expected = true;

        Assert.assertTrue(actual);

    }

    @Test
    public void testMyArrayListAddSize(){

        myArrayList.add("1");
        Assert.assertEquals("Some descriptions", 1, myArrayList.size());

    }

    @Test
    public void testMyArrayListAddTwoElements(){

        myArrayList.add("1");
        myArrayList.add("2");

        Assert.assertEquals("1", myArrayList.get(0));
        Assert.assertEquals("2", myArrayList.get(1));

    }

    @Test
    public void testMyArrayListAddByIndex(){

        myArrayList.add("1");
        myArrayList.add("2");
        myArrayList.add("3");
        myArrayList.add("4");

        myArrayList.add(2, "10");

        Assert.assertEquals(5, myArrayList.size());

        Assert.assertEquals("10", myArrayList.get(2));

        Assert.assertEquals("4", myArrayList.get(4));

    }

    @Test
    public void testDeleteElement() {

        ArrayList<java.lang.Object> testArray = new ArrayList<>(3);
        testArray.add("1");
        testArray.add("2");
        testArray.add("4");

        myArrayList.add("1");
        myArrayList.add("2");
        myArrayList.add("3");
        myArrayList.add("4");

        myArrayList.remove("3");

        Assert.assertArrayEquals(testArray.toArray(), myArrayList.toArray());

    }

    @Test
    public void testLastIndexOf() {

        myArrayList.add("1");
        myArrayList.add("2");
        myArrayList.add("3");
        myArrayList.add("4");
        myArrayList.add("3");

        Assert.assertEquals(4, myArrayList.lastIndexOf("3"));

    }

    @Test
    public void testContains() {

        myArrayList.add("1");
        myArrayList.add("2");
        myArrayList.add("3");
        myArrayList.add("4");
        myArrayList.add("3");

        Assert.assertEquals(true, myArrayList.contains("4"));

    }

    @Test
    public void testIsEmpty() {

        myArrayList.add(1);
        myArrayList.add(2);

        myArrayList.clear();

        Assert.assertTrue(myArrayList.isEmpty());

    }

}
