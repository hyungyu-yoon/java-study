package ch07.sec03.exam02;

public class Phone {
    public String model;
    public String color;

    public Phone(String model, String color) {
        System.out.println("Phone() 생성자 실행");
        this.model = model;
        this.color = color;
    }
}
