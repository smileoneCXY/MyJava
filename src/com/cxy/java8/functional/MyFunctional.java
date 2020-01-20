package com.cxy.java8.functional;

/**
 * @Author:chenxiaoyi
 * @Date:2020/1/20 9:20
 */
@FunctionalInterface
public interface MyFunctional<F,T> {

    T conver(F f);

    default String defaultFunc(){
        return "123";
    }

}
