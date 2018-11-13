import com.oracle.tools.packager.IOUtils;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        String str = "hell00000000";
        str = repeat(str, 10000000);
        File fileToWrite = new File("writed");
        File fileToRead = new File("readed");
        long startTimestamp, endTimestamp;
        try {
            fileToWrite.createNewFile();
            startTimestamp = System.currentTimeMillis();
            FileOutputStream outputStream = new FileOutputStream(fileToWrite);
            outputStream.write(str.getBytes());
            outputStream.close();
            endTimestamp = System.currentTimeMillis();
            System.out.println(String.format("Writing without filters: %d ms", (endTimestamp - startTimestamp)));
            fileToWrite.delete();
            fileToWrite.createNewFile();
            startTimestamp = System.currentTimeMillis();
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileToWrite));
            bufferedOutputStream.write(str.getBytes());
            bufferedOutputStream.close();
            StringBuffer sb = new StringBuffer();
            endTimestamp = System.currentTimeMillis();
            System.out.println(String.format("Writing with filters: %d ms", (endTimestamp - startTimestamp)));

            FileInputStream inputStream = new FileInputStream(fileToRead);
            byte[] data = inputStream.readAllBytes();
            inputStream.close();

            endTimestamp = System.currentTimeMillis();
            System.out.println(String.format("Reading without filters: %d ms", (endTimestamp - startTimestamp)));

            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(fileToRead));
            data = bufferedInputStream.readAllBytes();
            bufferedInputStream.close();
            endTimestamp = System.currentTimeMillis();

            System.out.println(String.format("Reading with filters: %d ms", (endTimestamp - startTimestamp)));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            fileToWrite.delete();
        }
    }

    public static String repeat(String str, int times) {
        StringBuilder sb = new StringBuilder(str.length() * times);
        for (int i = 0; i < times; i++)
            sb.append(str);
        return sb.toString();
    }
}
