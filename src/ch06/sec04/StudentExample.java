package ch06.sec04;

public class StudentExample {
    public static void main(String[] args) {
        Student student = new Student();
        System.out.println("student 변수 Student 객체 참조");

        Student student2 = new Student();
        System.out.println("student2 는 또 다른 Student 객체 참조");
    }
}
