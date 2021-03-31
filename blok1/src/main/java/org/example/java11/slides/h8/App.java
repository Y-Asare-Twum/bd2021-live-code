package org.example.java11.slides.h8;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;

public class App {

    public static void main(String[] args) {
        new App().start();
    }

    private void start() {
        Iban someIban = Iban.of("NL89", "RABO0", "315044462");
        System.out.println(someIban);

        String name1 = Iban.class.getName();
        String name = someIban.getClass().getName();
        System.out.println(name1);
        System.out.println(name);

        Class<? extends Iban> classOfSomeIban = someIban.getClass();
        showFieldsOf(classOfSomeIban);
        showMethodsOf(classOfSomeIban);

        Iban someIban2 = Iban.of("NL89", "RABO0", "415044462");
        Iban someIban3 = Iban.of("NL89", "RABO0", "215044462");
        Iban someIban4 = Iban.of("NL89", "RABO0", "015044462");

        List<Iban> ibanList = Arrays.asList(someIban, someIban2, someIban3, someIban4);
        Collections.sort(ibanList);
        System.out.println(ibanList.toString());

        Comparator<Iban> ibanComparator = (iban, otherIban) -> (iban.bankcode).compareTo(otherIban.bankcode);
        Collections.sort(ibanList, ibanComparator);
        ibanList.sort(comparing(Iban::getBankcode)); // functional style code
        System.out.println(ibanList.toString());
    }

    private void showFieldsOf(Class<? extends Iban> clazz) {
        Field[] fieldsOfSomeIban = clazz.getFields();
        System.out.printf("%s's fields: ---------------- %n", clazz.getSimpleName());
        for (Field field : fieldsOfSomeIban) {
            System.out.println(Modifier.toString(field.getModifiers()) + " " + field.getType().getSimpleName() + " " + field.getName());
        }
    }

    private void showMethodsOf(Class<? extends Iban> clazz) {
        System.out.printf("%s's methods: --------------- %n", clazz.getSimpleName());
        for (Method declaredMethod : clazz.getDeclaredMethods()) {
            System.out.println(declaredMethod);

            if (declaredMethod.isAnnotationPresent(Override.class)) { // will not work: Override is not retained in runtime
                System.out.printf("%s is overriden! %n", declaredMethod.getName());
            }

            // Class<?> superclass = clazz.getSuperclass();
            //
            // outerLoop:
            // while (superclass != null) {
            //     for (Method superMethod : superclass.getDeclaredMethods()) {
            //         if (isOverridden(declaredMethod, superMethod)) {
            //             System.out.printf("\t this method overrides %s from class %s! \n", declaredMethod.getName(), superclass.getSimpleName());
            //             break outerLoop;
            //         }
            //     }
            //     superclass = superclass.getSuperclass();
            // }
        }
    }

    private boolean isOverridden(Method declaredMethod, Method superMethod) {
        // method name
        if (!superMethod.getName().equals(declaredMethod.getName())) {
            return false;
        }

        var declaredMethodParameterTypes = declaredMethod.getParameterTypes();
        var superMethodParameterTypes = superMethod.getParameterTypes();

        // number of parameters
        if (superMethodParameterTypes.length != declaredMethodParameterTypes.length) {
            return false;
        }

        // types of parameters
        for (int i = 0; i < superMethodParameterTypes.length; i++) {
            if (!superMethodParameterTypes[i].equals(declaredMethodParameterTypes[i])) {
                return false;
            }
        }
        return true;
    }
}
