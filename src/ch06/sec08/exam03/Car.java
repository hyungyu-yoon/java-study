package ch06.sec08.exam03;

public class Car {

    int gas;

    void setGas(int gas) {
        this.gas = gas;
    }

    boolean isLeftGas() {
        if (gas == 0) {
            System.out.println("gas가 없음");
            return false;
        }

        System.out.println("gas가 있음");
        return true;
    }

    void run() {

        while (true) {
            if (gas > 0) {
                System.out.println("달린다. gas: " + gas);
                gas--;
            } else {
                System.out.println("멈춘다. gas: " + gas);
                return;
            }
        }
    }
}
