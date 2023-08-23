package ch07.sec02;

public class SmartPhoneExample {
    public static void main(String[] args) {
        SmartPhone smartPhone = new SmartPhone("갤럭시", "은색");

        System.out.println("모델: " + smartPhone.model);
        System.out.println("색상: " + smartPhone.color);

        System.out.println("와이파이 상태: " + smartPhone.wifi);

        smartPhone.bell();
        smartPhone.sendVoice("여보세요.");
        smartPhone.receiveVoices("안녕하세요. 저는 홍길동 인데요.");
        smartPhone.sendVoice("반갑습니다.");
        smartPhone.hangUp();

        smartPhone.setWifi(true);
        smartPhone.internet();
    }
}
