package com.luxoft.reflection;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

public class TestReflection {

    @Test
    public void testAddNewClassObjectBasedDefault() throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Object object = ReflectionUtils.create(TestVO.class);


        assertNotNull(object);
        assertEquals(TestVO.class, object.getClass());
//        TestVO testVO = (TestVO) object;
//        System.out.println(testVO.getClass().getDeclaredMethods().toString());
//        System.out.println(testVO.finalFields(TestVO.class));


//        System.out.println(testVO.getTEST());
//
//        assertTrue(testVO.isDefaultConstructor);
//        assertFalse(testVO.isDefaultConstructorWithInt);
    }
}



//• Метод принимает объект и меняет всего его приватные поля на их нулевые значение (null, 0, false etc)+