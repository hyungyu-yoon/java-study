package ch08.sec10.exam2;

public class CastingExample {
    public static void main(String[] args) {
        Vehicle vehicle = new Bus();

        vehicle.run();
//        vehicle.checkFare();  // 불가

        Bus bus = (Bus) vehicle;
        bus.run();
        bus.checkFare();
    }
}
