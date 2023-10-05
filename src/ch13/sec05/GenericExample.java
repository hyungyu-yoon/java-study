package ch13.sec05;

public class GenericExample {
    public static void main(String[] args) {
        Course.registerCourse1(new Applicant<>(new Person()));
        Course.registerCourse1(new Applicant<>(new Worker()));
        Course.registerCourse1(new Applicant<>(new Student()));
        Course.registerCourse1(new Applicant<>(new HighStudent()));
        Course.registerCourse1(new Applicant<>(new MiddleStudent()));
        System.out.println();


        // 학생만 신청 가능
//        Course.registerCourse2(new Applicant<Person>(new Person()));
//        Course.registerCourse2(new Applicant<>(new Worker()));
        Course.registerCourse2(new Applicant<>(new Student()));
        Course.registerCourse2(new Applicant<>(new HighStudent()));
        Course.registerCourse2(new Applicant<>(new MiddleStudent()));
        System.out.println();


        // 직장인 및 일반인만 신청가능
        Course.registerCourse3(new Applicant<>(new Person()));
        Course.registerCourse3(new Applicant<>(new Worker()));
        Course.registerCourse3(new Applicant<>(new Student()));
//        Course.registerCourse3(new Applicant<HighStudent>(new HighStudent()));
//        Course.registerCourse3(new Applicant<MiddleStudent>(new MiddleStudent()));
    }
}
