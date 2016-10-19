package week2.library;

/**
 * Created by bilousyv on 16.10.2016.
 */
public class IssueDictionary extends Issue {
    private String language;

    public IssueDictionary() {
    }

    public IssueDictionary(String title, String language, int year, String author, String genre) {
        super(title, year, author, genre);
        this.language = language;
    }

    @Override
    public String toString() {
        return super.toString() + " (" + language + ")";
    }
}
