package ch18.sec11;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileExample {
    public static void main(String[] args) throws IOException {
        File dir = new File("/Users/yoon/git/java-study/src/ch18/sec11");
        File file1 = new File("/Users/yoon/git/java-study/src/ch18/sec11/file1.txt");
        File file2 = new File("/Users/yoon/git/java-study/src/ch18/sec11/file2.txt");
        File file3 = new File("/Users/yoon/git/java-study/src/ch18/sec11/file3.txt");

        if (!dir.exists()) {
            dir.mkdirs();
        }
        if (!file1.exists()) {
            file1.createNewFile();
        }
        if (!file2.exists()) {
            file2.createNewFile();
        }
        if (!file3.exists()) {
            file3.createNewFile();
        }

        File temp = new File("/Users/yoon/git/java-study/src/ch18/sec11");
        File[] contents = temp.listFiles();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH:mm");
        for (File content : contents) {
            System.out.printf("%-25s", sdf.format(new Date(content.lastModified())));
            if (content.isDirectory()) {
                System.out.printf("%-10s%-20s", "<DIR>", content.getName());
            } else {
                System.out.printf("%-10s%-20s", content.length(), content.getName());
            }
            System.out.println();
        }
    }
}
