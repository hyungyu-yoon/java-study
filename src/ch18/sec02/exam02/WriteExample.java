package ch18.sec02.exam02;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteExample {
    public static void main(String[] args) {
        try {
            OutputStream os = new FileOutputStream("/Users/yoon/git/java-study/src/ch18/sec02/exam02/test.db");

            byte[] a = {10, 20, 30,1,2,3,4,5,6,6,7,8,9};

            os.write(a);

            os.flush();
            os.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
