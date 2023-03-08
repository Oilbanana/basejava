package com.anastas.webapp;

import com.anastas.webapp.model.Resume;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainReflection {
    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Resume r = new Resume("randomUuid");
        Method method = r.getClass().getMethod("toString");
        method.setAccessible(true);
        System.out.println(method.invoke(r));
    }
}
