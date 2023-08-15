package ch06.sec08.exam03;


public class CarExample {
    public static void main(String[] args) {
        Car car = new Car();

        car.setGas(10);
        if(car.isLeftGas()) {
            System.out.println("출발");
            car.run();
        }

        System.out.println("gas 주입 필요!");
    }
}
