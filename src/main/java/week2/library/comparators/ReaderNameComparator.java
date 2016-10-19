package week2.library.comparators;

import week2.library.Issue;
import week2.library.Reader;

import java.util.Comparator;

/**
 * Created by bilousyv on 20.10.2016.
 */
public class ReaderNameComparator implements Comparator <Reader> {

    @Override
    public int compare(Reader o1, Reader o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
