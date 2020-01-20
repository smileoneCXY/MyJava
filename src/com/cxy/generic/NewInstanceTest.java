package com.cxy.generic;

import org.junit.Test;

import java.lang.reflect.Constructor;

/**
 * @Author:chenxiaoyi
 * @Date:2019/7/30 20:51
 */
public class NewInstanceTest {


    @Test
    public void test1() throws Exception {

        Class<Person> aClass = Person.class;
        //newInstance() 调用了内部的空参 不私有 构造器
//        Person person = aClass.newInstance();

        Constructor<Person> constructor = aClass.getConstructor(Integer.class, String.class);
        constructor.setAccessible(true);
        Class<Person> aClass1 = constructor.getDeclaringClass();
        Person person1 = aClass1.newInstance();



//        Method[] methods = aClass.getDeclaredMethods();
//        for (Method method : methods) {
//            method.setAccessible(true);
//            String name = method.getName();
//            Type[] types = method.getGenericParameterTypes();
//            System.out.println(name+"  "+ Arrays.toString(types));
//
//        }

    }
}
