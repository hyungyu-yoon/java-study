package ch09.sec07.exam02;

public class Home {

    private RemoteControl rc = new RemoteControl() {
        @Override
        public void turnOn() {
            System.out.println("TV를 켠다.");
        }

        @Override
        public void turnOff() {
            System.out.println("TV를 끈다.");
        }
    };

    public void use1() {
        rc.turnOn();
        rc.turnOff();
    }

    public void use2() {
        RemoteControl rc = new RemoteControl() {
            @Override
            public void turnOn() {
                System.out.println("에어켠을 켠다");
            }

            @Override
            public void turnOff() {
                System.out.println("에어컨을 끈다.");
            }
        };

        rc.turnOn();
        rc.turnOff();
    }

    public void use3(RemoteControl rc) {
        rc.turnOn();
        rc.turnOff();
    }

}
