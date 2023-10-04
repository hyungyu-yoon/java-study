package ch12.sec11.exam02;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionExample {
    public static void main(String[] args) throws NoSuchMethodException {
        Class<Car> clazz = Car.class;

        for (Constructor<?> declaredConstructor : clazz.getDeclaredConstructors()) {
            System.out.println(declaredConstructor.getName());
        }

        for (Field declaredField : clazz.getDeclaredFields()) {
            System.out.println(declaredField.getType().getName() + " " + declaredField.getName());
        }

        for (Method declaredMethod : clazz.getDeclaredMethods()) {
            System.out.println(declaredMethod.getName());
        }
    }
}
