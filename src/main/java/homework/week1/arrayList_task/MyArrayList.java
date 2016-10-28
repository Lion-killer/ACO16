package homework.week1.arrayList_task;

/**
 * Created by bilousyv on 14.10.2016.
 */
public class MyArrayList {

    private Object[] array;

    public MyArrayList() {

    }

    public MyArrayList(int initialSize) {
        this.array = new Object[initialSize];
    }


    public Object[] get(){
        return this.array;
    }



    public void clear(){
        this.array = new Object[0];
    }

    public boolean contains(Object o){

        for (Object element : array) {
            if (element.equals(o)) return true;
        }

        return false;
    }

    public int size(){
        return array.length;
    }

}
