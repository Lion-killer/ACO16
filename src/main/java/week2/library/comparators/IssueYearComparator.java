package week2.library.comparators;

import week2.library.Issue;

import java.util.Comparator;

/**
 * Created by bilousyv on 20.10.2016.
 */
public class IssueYearComparator implements Comparator <Issue> {

    @Override
    public int compare(Issue o1, Issue o2) {
        return o1.getYear() - o2.getYear();
    }
}
