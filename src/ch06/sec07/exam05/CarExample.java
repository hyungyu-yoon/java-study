package ch06.sec07.exam05;

public class CarExample {
    public static void main(String[] args) {
        Car car1 = new Car();

        Car car2 = new Car("자가용");

        Car car3 = new Car("자가용", "빨강");

        Car car4 = new Car("택시", "검정", 200);

        System.out.println(car1);
        System.out.println(car2);
        System.out.println(car3);
        System.out.println(car4);
    }
}
