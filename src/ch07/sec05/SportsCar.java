package ch07.sec05;

public class SportsCar extends Car {

    @Override
    public void speedUp() {
        speed += 10;
    }

//    @Override  // final 재정의 불가
//    public void stop() {
//        System.out.println("스포츠카 멈춤");
//        speed = 0;
//    }
}
