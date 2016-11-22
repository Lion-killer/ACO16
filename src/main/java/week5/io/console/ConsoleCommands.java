package week5.io.console;

import utils.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

/**
 * Created by bilousyv on 17.11.2016.
 */
public class ConsoleCommands {

    private File file;
    private final static String treeSymbol = "└── ";

    public ConsoleCommands(String initialPath) {
        file = new File(initialPath);
    }

    public String pwd(){
        return file.getPath();
    }

    public void ls(String[] words) throws MyErrorInExpression {

        File[] files = file.listFiles();

        if (words.length == 1) {
            for (File file1 : files) {
                if (file1.getName().charAt(0) != '.') {
                    System.out.println(file1.getName());
                }
            }
        } else if (words.length == 2){
            String parameters = words[1];
            if (parameters.startsWith("-alt")){
                ArrayList<File> list = new ArrayList<>(Arrays.asList(files));
                list.sort(new FileDateChangeComparator());
                Calendar c = Calendar.getInstance();
                for (File file1 : list) {
                    c.setTimeInMillis(file1.lastModified());
                    System.out.printf("%10d %10tD %20s \n", file1.length(), c, file1.getName());
                }
            } else {
                throw new MyErrorInExpression("Incorrect parameter");
            }
        } else {
            throw new MyErrorInExpression();
        }
    }

    public void cd(String[] words) throws MyErrorInExpression {

        if (words.length != 2) throw new MyErrorInExpression();

        String parameter = words[1];

        if (parameter.startsWith("..")){
            file = new File(file.getParent());
        } else {
            file = new File(file.getPath() + File.separator + parameter + File.separator);
        }

    }

    public void mkdir(String[] words) throws MyErrorInExpression {
        if (words.length != 2) throw new MyErrorInExpression();

        String parameter = words[1];

        file = new File(file.getPath() + File.separator + parameter + File.separator);
        file.mkdirs();
    }

    public void touch(String[] words) throws MyErrorInExpression, IOException {

        if (words.length != 2) throw new MyErrorInExpression();

        String parameter = words[1];

        file = new File(file.getPath() + File.separator + parameter);
        if (file.createNewFile()){
            file = new File(file.getParent());
        } else {
            throw new IOException("File already exists");
        }
    }

    public void cp(String[] words) throws MyErrorInExpression {

        if (words.length != 3) throw new MyErrorInExpression();

        String filename1 = words[1];
        String filename2 = words[2];

        FileUtils.copy(file.getPath() + File.separator + filename1, file.getPath() + File.separator + filename2);

    }

    public void mv(String[] words) throws MyErrorInExpression, IOException {
        if (words.length != 3) throw new MyErrorInExpression();

        String filename1 = words[1];
        String filename2 = words[2];

        file = new File(file.getPath() + File.separator + filename1);
        File fileDest = new File(file.getPath() + File.separator + filename2);
        if (file.renameTo(fileDest)) {
            file = new File(file.getParent());
        } else {
            throw new IOException("Error renaming file");
        }
    }

    public void rm(String[] words) throws MyErrorInExpression, IOException {

        if (words.length != 2) throw new MyErrorInExpression();
        String parameter = words[1];
        File fileToRemove = new File(file.getPath() + File.separator + parameter);
        if (!fileToRemove.delete()){
            throw new IOException("Error deleting file");
        }
    }

    public void tree() {
        tree(file.getPath(), 0);
    }

    public void tree(String path, int level) {

        File current = new File(path);
        if (!current.isDirectory()) return;

        File[] files = current.listFiles();
        for (File fl : files) {
            System.out.println(spaces(level * 4) + treeSymbol + fl.getName());
            tree(fl.getPath(), level + 1);
        }

    }

    private static String spaces(int count) {
        if (count > 0)
            return String.format("%" + count + "s", " ");
        else
            return "";
    }
}
