package ch13.sec04;

public class GenericExample {
    public static <T extends Number> boolean compare(T t1, T t2) {
        System.out.println(t1.getClass().getSimpleName() + ", " + t2.getClass().getSimpleName() );
        double v1 = t1.doubleValue();
        double v2 = t2.doubleValue();
        return (v1 == v2);
    }

    public static void main(String[] args) {
        boolean compare = compare(10, 20);
        System.out.println(compare);

        System.out.println();

        boolean compare1 = compare(4.5, 4.5);
        System.out.println(compare1);
    }
}
