package week2.library;

import java.util.Comparator;

/**
 * Created by bilousyv on 16.10.2016.
 */
public class Issue {

    private String title;
    private int year;
    private String author;
    private String genre;
    private Reader reader;
    private Comparator<Issue> comparator;

    public Issue() {
    }

    public Issue(String title, int year, String author, String genre) {
        this.title = title;
        this.year = year;
        this.author = author;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

     public String getAuthor() {
        return author;
    }

     public String getGenre() {
        return genre;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public void setComparator(Comparator<Issue> comparator) {
        this.comparator = comparator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Issue issue = (Issue) o;

        if (year != issue.year) return false;
        if (title != null ? !title.equals(issue.title) : issue.title != null) return false;
        return genre != null ? genre.equals(issue.genre) : issue.genre == null;

    }

    @Override
    public String toString() {
        return this.title;
    }
}
