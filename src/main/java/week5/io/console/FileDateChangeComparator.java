package week5.io.console;

import java.io.File;
import java.util.Comparator;

/**
 * Created by bilousyv on 22.11.2016.
 */
public class FileDateChangeComparator implements Comparator<File> {
    @Override
    public int compare(File file1, File file2) {
        return (int)(file1.lastModified() - file2.lastModified());
    }
}
