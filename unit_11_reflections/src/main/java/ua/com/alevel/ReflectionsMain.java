package ua.com.alevel;
//import org.example.EmailValidator;
//import org.example.ReflectionsTest;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionsMain {
    public static void main(String[] args) {
        System.out.println("ReflectionsMain.main");
//        ua.com.alevel.Person person1 = new ua.com.alevel.Person();
//        ua.com.alevel.person.Person person2 = new ua.com.alevel.person.Person();
        Person person = new Person();
        System.out.println("person = " + person);

        Class<?> personClass = person.getClass();
        Field[] declaredFields = personClass.getDeclaredFields();
//        for (Field declaredField : declaredFields) {
//            if (declaredField.getType().isAssignableFrom(String.class)) {
//                if (declaredField.getName().equals("email")) {
//                    try {
//                        declaredField.setAccessible(true);
//                        String email = (String) declaredField.get(personClass);
//                    } catch (IllegalAccessException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }

        Method[] declaredMethods = personClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            if (declaredMethod.getName().equals("run")) {
                System.out.println("declaredMethod = " + declaredMethod);
                declaredMethod.setAccessible(true);
                try {
                    declaredMethod.invoke(personClass);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("person = " + person);

//        EmailValidator.validate(person.getClass());
    }
}
