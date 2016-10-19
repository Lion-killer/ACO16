package week2.library;

import java.util.ArrayList;

/**
 * Created by bilousyv on 16.10.2016.
 */
public class Reader {

    private String name;
    private boolean inBlackList;
    private int leftCountOfIssues = 3;

    public Reader(String name) {
        this.name = name;
        this.inBlackList = false;
    }

    public String getName() {
        return name;
    }

     @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reader reader = (Reader) o;

        return name != null ? name.equals(reader.name) : reader.name == null;

    }

    @Override
    public String toString() {
        return "name = '" + name + "'";
    }

    public int getLeftCountOfIssues() {
        return leftCountOfIssues;
    }

    public void setLeftCountOfIssues(int leftCountOfIssues) {
        this.leftCountOfIssues = leftCountOfIssues;
    }

    public boolean isInBlackList() {
        return inBlackList;
    }

    public void toBlackList() {
        this.inBlackList = true;
    }
}
