package ch03.sec01;

public class IncreaseDecreaseOperationExample {
    public static void main(String[] args) {
        int x = 1;
        int y = 1;
        int z;

        z = ++x + y;
        System.out.println("z = " + z);
        System.out.println("x = " + x);

        x = 1;
        z = x-- + y;
        System.out.println("z = " + z);
        System.out.println("x = " + x);
    }
}
