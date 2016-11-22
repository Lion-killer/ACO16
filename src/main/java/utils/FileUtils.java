package utils;

import java.io.*;

/**
 * Created by bilousyv on 12.11.2016.
 */
public class FileUtils {
    public static void copy(String filePathSrc, String filePathDest) throws DifferentTypesException {

        if (!getExtension(filePathSrc).equals(getExtension(filePathDest))){
            throw new DifferentTypesException();
        }

        try (InputStream is = new BufferedInputStream(
                new FileInputStream(filePathSrc));
             OutputStream os = new BufferedOutputStream(
                     new FileOutputStream(filePathDest))) {

            int readBytes;
            byte[] bytes = new byte[1024];
            while ((readBytes = is.read(bytes)) != -1) {
                os.write(bytes, 0, readBytes);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static String getExtension(String fileName){
        return fileName.substring(fileName.lastIndexOf("."));
    }

}
