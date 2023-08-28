package ch08.sec08;

public class SmartTelevision implements RemoteControl, Searchable{
    @Override
    public void turnOn() {
        System.out.println("티비를 켠다.");
    }

    @Override
    public void turnOff() {
        System.out.println("티비를 끈다.");
    }

    @Override
    public void search(String url) {
        System.out.println(url + " 을 검색합니다.");
    }
}
