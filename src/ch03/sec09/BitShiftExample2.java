package ch03.sec09;

public class BitShiftExample2 {
    public static void main(String[] args) {
        int value = 772;
        System.out.println(Integer.toBinaryString(772));

        byte byte1 = (byte) (value >>> 24);
        int int1 = byte1 & 255;
        System.out.println("int1 = " + int1);


        byte byte2 = (byte) (value >>> 8);
        int int2 = byte2 & 255;
        System.out.println("int2 = " + int2);
    }
}
