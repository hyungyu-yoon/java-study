package ch08.sec06;

public class RemoteControlExample {
    public static void main(String[] args) {
        RemoteControl rc = new Television();

        rc.turnOn();
        rc.setVolume(1123);

        rc.setMute(true);
        rc.setMute(false);

        rc = new Audio();
        rc.turnOn();
        rc.setVolume(5);

        rc.setMute(true);
        rc.setMute(false);

        RemoteControl.changeBattery();
    }
}
