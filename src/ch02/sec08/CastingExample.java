package ch02.sec08;

public class CastingExample {
    public static void main(String[] args) {
        int var1 = 1000000;
        byte var2 = (byte) var1;
        System.out.println("var2 = " + var2);

        long var3 = 1234562349872319487L;
        int var4 = (int) var3;
        System.out.println("var4 = " + var4);
    }
}
