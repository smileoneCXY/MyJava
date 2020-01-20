package com.cxy.java8.functional;

/**
 * @Author:chenxiaoyi
 * @Date:2020/1/20 9:57
 */
public interface PersonFactory<P extends Person> {

    P create(String name,Integer age);
}
