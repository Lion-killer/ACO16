package homework.ud;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by bilousyv on 23.11.2016.
 */
public class UniversalDownloader {

    private String url;
    private List<String> urls = new LinkedList<>();
    private final static String START_TEXT = "<a href='";
    private final static String END_TEXT = "' rel='nofollow'>загрузить</a>";

    UniversalDownloader(String url) {
        this.url = url;
    }

    List<String> getURLs() {

        List<String> list = new LinkedList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new URL(url).openStream()))) {
            String line, ref;
            while ((line = br.readLine()) != null) {
                ref = getMiddleOfText(line, START_TEXT, END_TEXT);
                if (ref != null) {
                    list.add(ref);
                }
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    boolean downloadFile(String srcURL, String destPath) {

        try (BufferedInputStream is = new BufferedInputStream(new URL(srcURL).openStream());
             BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(destPath))) {

            int readBytes;
            int buff = 1024;
            byte[] bytes = new byte[buff];
            while ((readBytes = is.read(bytes)) != -1) {
                os.write(bytes, 0, readBytes);
            }

            return true;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;

    }

    private static String getMiddleOfText(String text, String startText, String endText) {
        if (text.contains(startText) && text.contains(endText)) {
            int beginIndex = text.indexOf(startText) + startText.length();
            int endIndex = text.lastIndexOf(endText);
            return text.substring(beginIndex, endIndex);
        }
        return null;
    }
}
