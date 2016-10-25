package homework.week2;

/**
 * Created by bilousyv on 24.10.2016.
 */
public interface MyList {

    boolean add(Object o);
    void add(int index, Object o);
    void clear();
    boolean contains(Object o);
    Object get(int index);
    int indexOf(Object o);
    boolean isEmpty();
    int lastIndexOf(Object o);
    Object remove(int index);
    boolean remove(Object o);
    Object set(int index, Object o);
    int size();
    Object[] toArray();

}
