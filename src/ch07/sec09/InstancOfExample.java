package ch07.sec09;

public class InstancOfExample {
    public static void personInfo(Person person) {
        System.out.println("name : " + person.name);
        person.walk();

        if (person instanceof Student) {
            Student student = (Student) person;
            student.study();
        }

        if (person instanceof Student student) {
            student.study();
        }
    }

    public static void main(String[] args) {
        Person p1 = new Person("홍길동");
        personInfo(p1);

        System.out.println();

        Student student = new Student("김자바", 10);
        personInfo(student);
    }
}
