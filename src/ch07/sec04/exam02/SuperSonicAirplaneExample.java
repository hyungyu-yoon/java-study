package ch07.sec04.exam02;

public class SuperSonicAirplaneExample {
    public static void main(String[] args) {
        SuperSonicAirPlane superSonicAirPlane = new SuperSonicAirPlane();
        superSonicAirPlane.takeOff();
        superSonicAirPlane.fly();
        superSonicAirPlane.flyMode = SuperSonicAirPlane.SUPERSONIC;
        superSonicAirPlane.fly();
        superSonicAirPlane.flyMode = SuperSonicAirPlane.NORMAL;
        superSonicAirPlane.fly();
        superSonicAirPlane.land();
    }
}
