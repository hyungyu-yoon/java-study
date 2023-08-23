package ch07.sec11;

public class SealedExample {
    public static void main(String[] args) {
        Person p = new Person();
        Employee employee = new Employee();
        Manager manager = new Manager();
        Director director = new Director();

        p.work();
        employee.work();
        manager.work();
        director.work();
    }
}
