package week2.library;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by bilousyv on 16.10.2016.
 */
public class Library {

    private String name;
    private ArrayList <Reader> readers;
    private ArrayList <Issue> issues;

    public Library(String name) {
        this.name = name;
        this.readers = new ArrayList<>();
        this.issues = new ArrayList<>();
    }

    public boolean addReader(Reader reader){
        return readers.add(reader);
    }

    public boolean addIssue(Issue issue){
        return issues.add(issue);
    }

    public boolean delReader(Reader reader){
        return readers.remove(reader);
    }

    public boolean delIssue(Issue issue){
        return issues.remove(issue);
    }

    public void sortReaders(Comparator<Reader> comparator){
        readers.sort(comparator);
    }

    public void sortIssues(Comparator<Issue> comparator){
        issues.sort(comparator);
    }

    public ArrayList <Reader> getReaders(){
        return readers;
    }

    public boolean addReaderToBlackList(Reader reader){
        int index = readers.indexOf(reader);
        if (index == -1) return false;
        readers.get(index).toBlackList();
        return true;
    }

    public ArrayList <Reader> getReadersInBL(){
        ArrayList <Reader> result = new ArrayList<>();
        for (Reader reader : readers) {
            if (reader.isInBlackList()){
                result.add(reader);
            }
        }
        return result;
    }

    public ArrayList<Issue> getIssues(){
        return issues;
    }

    public ArrayList <Issue> getIssues(Issue issueType){
        ArrayList<Issue> result = new ArrayList<>();
        for (Issue issue : issues) {
            if (issue.getClass() == issueType.getClass()){
                result.add(issue);
            }
        }
        return result;
    }

    public ArrayList<Issue> getIssuesByAuthor(String author){
        ArrayList<Issue> result = new ArrayList<>();
        for (Issue issue : issues) {
            if (author.equals(issue.getAuthor())){
                result.add(issue);
            }
        }
        return result;
    }

    public ArrayList<Issue> getIssuesByName(String name){
        ArrayList<Issue> result = new ArrayList<>();
        for (Issue issue : issues) {
            if (name.equals(issue.getTitle())){
                result.add(issue);
            }
        }
        return result;
    }

    public ArrayList<Issue> getIssuesByYear(int year){
        ArrayList<Issue> result = new ArrayList<>();
        for (Issue issue : issues) {
            if (year == issue.getYear()){
                result.add(issue);
            }
        }
        return result;
    }

    public ArrayList<Issue> getGivenIssues(){
        ArrayList<Issue> result = new ArrayList<>();
        for (Issue issue : issues) {
            if (issue.getReader() != null){
                result.add(issue);
            }
        }
        return result;
    }

    public ArrayList<Issue> getGivenIssues(Reader reader){
        ArrayList<Issue> result = new ArrayList<>();
        for (Issue issue : issues) {
            if (reader.equals(issue.getReader())){
                result.add(issue);
            }
        }
        return result;
    }

    public boolean giveIssue(Issue issue, Reader reader){

        if (issue.getReader() == null || reader.isInBlackList() || reader.getLeftCountOfIssues() == 0) {
            return false;
        }
        else {
            issue.setReader(reader);
            reader.setLeftCountOfIssues(reader.getLeftCountOfIssues() - 1);
            return true;
        }
    }

}
