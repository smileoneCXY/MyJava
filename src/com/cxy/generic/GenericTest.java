package com.cxy.generic;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author:chenxiaoyi
 * @Date:2019/7/29 12:03
 */
public class GenericTest<E> {

    public static  <T> List<T> ArrayToList(T[] array){
        return new ArrayList<>(Arrays.asList(array));

    }

//    获取Class的实例方式

    @Test
    public void test1() throws ClassNotFoundException {
        //1.调用运行时类的属性:.class
        Class<Person> clz1 = Person.class;
        System.out.println(clz1.getName());

        //2.通过运行时类的对象,调用getClass()
        Person person = new Person();
        Class<? extends Person> clz2 = person.getClass();
        System.out.println(clz2.getName());

        //3.调用class的静态方法forName("com.xxx.xxx")
        Class<?> clz3 = Class.forName("com.cxy.generic.Person");
        System.out.println(clz3.getName());

        //4.通过类加载器加载classLoader
        ClassLoader classLoader = this.getClass().getClassLoader();
        Class<?> clz4 = classLoader.loadClass("com.cxy.generic.Person");
        System.out.println(clz1 == clz2 ? clz3:clz4);


    }

    @Test
    public void test2(){
        ClassLoader classLoader = String.class.getClassLoader();
        System.out.println(classLoader);
    }


    @Test
    public void testList(){
        Integer[] ints = {1, 2, 3, 4, 7};
        List<Integer> list = GenericTest.ArrayToList(ints);
        System.out.println(list);

    }


}
