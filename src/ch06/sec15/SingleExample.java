package ch06.sec15;

public class SingleExample {
    public static void main(String[] args) {
        Single instance1 = Single.getInstance();
        Single instance2 = Single.getInstance();

        System.out.println(instance1 == instance2);
        System.out.println(instance1.equals(instance2));
    }
}
