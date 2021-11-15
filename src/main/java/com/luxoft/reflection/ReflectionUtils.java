package com.luxoft.reflection;

import java.lang.reflect.*;

public class ReflectionUtils {

    static Object create(Class clazz) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {

        superClass(clazz);

        methodWithOutParam(clazz);

        finalFields(clazz);

        notPublic(clazz);

        privateFields(clazz);

        return createdInstance(clazz);

    }

    private static void privateFields(Object object) throws IllegalAccessException {
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            if ((field.getModifiers() & Modifier.FINAL) != Modifier.FINAL) {
                if ((field.getModifiers() & Modifier.PRIVATE) == Modifier.PRIVATE) {
                    field.setAccessible(true);
                    if (field.getType().getSimpleName() == "int") {
                        field.set(object, 0);
                        System.out.println((field));
                    }
                }
            }
        }
    }


    private static void superClass(Class clazz) {

        Class[] interfaces = clazz.getInterfaces();
        System.out.println(clazz.getSuperclass());
        for (Class i : interfaces) {
            System.out.println(i);
        }

    }

    private static void methodWithOutParam(Object object) throws InvocationTargetException, IllegalAccessException {

        Method[] methods = object.getClass().getDeclaredMethods();
        for (Method method : methods) {
            if (method.getParameterCount() == 0) {
//                method.invoke(object);
                System.out.println(method.invoke(object));
            }
        }
    }

    private static void notPublic(Class clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if ((method.getModifiers() & Modifier.PUBLIC) != Modifier.PUBLIC) {
                System.out.println(method);
            }
        }
    }

    public static void finalFields(Object object) {
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            if ((field.getModifiers() & Modifier.FINAL) == Modifier.FINAL) {
                System.out.println((field));
            }
        }
    }

    private static Object createdInstance(Class clazz) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor constructor : constructors) {
            if (constructor.getParameterCount() == 0) {
                return constructor.newInstance();
            }
        }
        throw new IllegalArgumentException("Class doesn't have default constructor");
    }

}


//        Field field1 = clazz.getDeclaredField("isDefaultConstructor");
//        Field field2 = clazz.getDeclaredField("arrayList");
//        System.out.println(field1.getType() == boolean.class);
//        System.out.println(field2.getType() == ArrayList.class);