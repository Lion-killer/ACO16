package homework.ud;

import java.util.List;

/**
 * Created by bilousyv on 23.11.2016.
 */
public class TestUD {
    public static void main(String[] args) {
        String url = "http://www.ex.ua";
        String downloadPath = "C:\\Users\\bilousyv\\IdeaProjects\\ACO16\\src\\main\\resources\\ud\\";
        UniversalDownloader ud = new UniversalDownloader(url + "/91231438?r=31049,23777");
        List<String> list = ud.getURLs();
        for (int index = 0; index < list.size(); index++) {

        }

        int index = 1;
        for (String ref : list) {
            if (ud.downloadFile(url + ref, downloadPath + "image" + index + ".jpg")) {
                index++;
            }
        }
        System.out.printf("Downloaded %d files", index);
    }
}
