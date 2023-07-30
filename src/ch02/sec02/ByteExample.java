package ch02.sec02;

public class ByteExample {
    public static void main(String[] args) {
        byte var1 = -128;
        byte var2 = -30;
        byte var3 = 0;
        byte var4 = 127;
//        byte var5 = 128; // 컴파일 에러 java: incompatible types: possible lossy conversion from int to byte

        System.out.println(var1);
        System.out.println(var2);
        System.out.println(var3);
        System.out.println(var4);
//        System.out.println(var5);
    }
}
