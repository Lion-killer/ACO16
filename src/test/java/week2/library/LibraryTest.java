package week2.library;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import week2.library.comparators.IssueAuthorComparator;
import week2.library.comparators.IssueNameComparator;
import week2.library.comparators.IssueYearComparator;
import week2.library.comparators.ReaderNameComparator;

/**
 * Created by bilousyv on 19.10.2016.
 */
public class LibraryTest {

    private Library library;

    @Before
    public void init() {

        library = new Library("National library");

        library.addIssue(new IssueDictionary("Reference", "English", 2010, "Ivanov", "Education"));
        library.addIssue(new IssueDictionary("Phrasebook", "Italian", 1995, "Barbarossa", "Education"));
        library.addIssue(new IssueJournal("Cosmopolitan", 1997, 5, "Cosmopolitan", "Entertainment"));
        library.addIssue(new IssueJournal("Forbes", 2012, 11, "Forbes", "Entertainment"));

        library.addReader(new Reader("Ivan"));
        library.addReader(new Reader("Anna"));
        library.addReader(new Reader("Vasya"));
        library.addReader(new Reader("Katya"));

    }

    @Test
    public void testAddReader() {

        library.addReader(new Reader("Michael"));
        String expected = "[name = 'Ivan', name = 'Anna', name = 'Vasya', name = 'Katya', name = 'Michael']";
        Assert.assertEquals(expected, library.getReaders().toString());

    }

    @Test
    public void testDelReader() {

        library.delReader(new Reader("Vasya"));

        Assert.assertEquals("[name = 'Ivan', name = 'Anna', name = 'Katya']", library.getReaders().toString());
    }

    @Test
    public void testSortReaders() {

        library.sortReaders(new ReaderNameComparator());

        Assert.assertEquals("[name = 'Anna', name = 'Ivan', name = 'Katya', name = 'Vasya']", library.getReaders().toString());
    }

    @Test
    public void testGetReadersInBL(){

        library.addReaderToBlackList(new Reader("Anna"));
        library.addReaderToBlackList(new Reader("Katya"));

        Assert.assertEquals("[name = 'Anna', name = 'Katya']", library.getReadersInBL().toString());

    }

    @Test
    public void testAddIssue() {
        library.addIssue(new IssueJournal("Maxim", 2012, 11, "Maxim", "Entertainment"));
        Assert.assertEquals("[Reference (English), Phrasebook (Italian), Cosmopolitan (5/1997), Forbes (11/2012), Maxim (11/2012)]", library.getIssues().toString());
    }

    @Test
    public void testDelIssue() {

        library.delIssue(new IssueDictionary("Phrasebook", "Italian", 1995, "Barbarossa", "Education"));

        Assert.assertEquals("[Reference (English), Cosmopolitan (5/1997), Forbes (11/2012)]", library.getIssues().toString());

    }

  @Test
    public void testSortIssues() {

        library.sortIssues(new IssueNameComparator());
        Assert.assertEquals("Sort by name", "[Cosmopolitan (5/1997), Forbes (11/2012), Phrasebook (Italian), Reference (English)]", library.getIssues().toString());

        library.sortIssues(new IssueAuthorComparator());
        Assert.assertEquals("Sort by author", "[Phrasebook (Italian), Cosmopolitan (5/1997), Forbes (11/2012), Reference (English)]", library.getIssues().toString());

        library.sortIssues(new IssueYearComparator());
        Assert.assertEquals("Sort by year", "[Phrasebook (Italian), Cosmopolitan (5/1997), Reference (English), Forbes (11/2012)]", library.getIssues().toString());

    }

    @Test
    public void testGetIssues() {

        Assert.assertEquals("[Reference (English), Phrasebook (Italian)]", library.getIssues(new IssueDictionary()).toString());

    }

    @Test
    public void testGetIssuesByAuthor() {

         Assert.assertEquals("[Phrasebook (Italian)]", library.getIssuesByAuthor("Barbarossa").toString());

    }

    @Test
    public void testGetIssuesByName() {

        Assert.assertEquals("[Reference (English)]", library.getIssuesByName("Reference").toString());

    }

    @Test
    public void testGetIssuesByYear() {

         Assert.assertEquals("[Reference (English)]", library.getIssuesByYear(2010).toString());

    }

    public void testGetGivenIssues(){

        library.giveIssue(new IssueJournal("Cosmopolitan", 1997, 5, "Cosmopolitan", "Entertainment"), new Reader("Ivan"));
        Assert.assertEquals("", library.getGivenIssues().toString());

    }

    public void testGetGivenIssuesByReader(){

        library.giveIssue(new IssueDictionary("Reference", "English", 2010, "Ivanov", "Education"), new Reader("Ivan"));
        library.giveIssue(new IssueJournal("Cosmopolitan", 1997, 5, "Cosmopolitan", "Entertainment"), new Reader("Anna"));

        Assert.assertEquals("", library.getGivenIssues(new Reader("Anna")).toString());

    }


}
