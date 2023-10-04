package ch12.sec11.exam03;

public class GetResourceExample {
    public static void main(String[] args) {
        Class clazz = Car.class;

        String path1 = clazz.getResource("photo1.jpg").getPath();
        String path2 = clazz.getResource("images/photo2.jpg").getPath();

        System.out.println(path1);
        System.out.println(path2);
    }
}
