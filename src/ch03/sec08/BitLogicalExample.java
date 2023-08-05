package ch03.sec08;

public class BitLogicalExample {
    public static void main(String[] args) {
        System.out.println("45 & 25 = " + (45 & 25));
        System.out.println("45 | 25 = " + (45 | 25));
        System.out.println("45 ^ 25 = " + (45 ^ 25));
        System.out.println("~45 = " + ~45);


        byte receiveData = -120;

        int unsignedInt1 = receiveData & 255;
        System.out.println("unsignedInt1 = " + unsignedInt1);

        System.out.println(Byte.toUnsignedInt(receiveData));

        int test = 136;

        byte btest = (byte) test;
        System.out.println(btest);
    }
}
