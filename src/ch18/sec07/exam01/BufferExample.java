package ch18.sec07.exam01;

import java.io.*;

public class BufferExample {
    public static void main(String[] args) throws IOException {
        String originalFilePath1 = BufferExample.class.getResource("kurly.jpeg").getPath();
        String targetFilePath1 = "/Users/yoon/git/java-study/src/ch18/sec07/exam01/targetFile1.jpeg";

        FileInputStream fis = new FileInputStream(originalFilePath1);
        FileOutputStream fos = new FileOutputStream(targetFilePath1);


        String originalFilePath2 = BufferExample.class.getResource("kurly.jpeg").getPath();
        String targetFilePath2 = "/Users/yoon/git/java-study/src/ch18/sec07/exam01/targetFile2.jpeg";

        FileInputStream fis2 = new FileInputStream(originalFilePath2);
        FileOutputStream fos2 = new FileOutputStream(targetFilePath2);
        BufferedInputStream bis = new BufferedInputStream(fis2);
        BufferedOutputStream bos = new BufferedOutputStream(fos2);

        long nonBufferTime = copy(fis, fos);
        System.out.println("버퍼 미사용 \t: " + nonBufferTime + " ns");
        long bufferTime = copy(bis, bos);
        System.out.println("버퍼 사용 \t: " + bufferTime + " ns");

        fis.close();
        fos.close();
        bis.close();
        bos.close();
    }

    private static long copy(InputStream is, OutputStream os) throws IOException {
        long start = System.nanoTime();

        while (true) {
            int data = is.read();
            if (data == -1) break;
            ;
            os.write(data);
        }
        os.flush();
        long end = System.nanoTime();
        return end - start;
    }
}
