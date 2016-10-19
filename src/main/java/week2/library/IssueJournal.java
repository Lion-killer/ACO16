package week2.library;

/**
 * Created by bilousyv on 16.10.2016.
 */
public class IssueJournal extends Issue {
    private int month;

    public IssueJournal() {
    }

    public IssueJournal(String title, int year, int month, String author, String genre) {
        super(title, year, author, genre);
        this.month = month;
    }

    @Override
    public String toString() {
        return super.toString() + " (" + month + "/" + getYear() + ")";
    }
}
