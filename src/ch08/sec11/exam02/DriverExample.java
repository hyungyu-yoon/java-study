package ch08.sec11.exam02;

import ch08.sec12.Bus;
import ch08.sec12.Taxi;

public class DriverExample {
    public static void main(String[] args) {
        Driver driver = new Driver();

        Bus bus = new Bus();
        driver.drive(bus);

        Taxi taxi = new Taxi();
        driver.drive(taxi);
    }
}
