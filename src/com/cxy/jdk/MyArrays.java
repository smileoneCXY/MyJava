package com.cxy.jdk;

import java.util.Arrays;
import java.util.List;

/**
 * @Author:chenxiaoyi
 * @Date:2020/6/11 14:46
 */
public class MyArrays {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3);
        /*UnsupportedOperationException  asList 返回的ArrayList 是 Arrays内部定义的 */
        list.add(4);

        /** 接收泛型 基本类型则作为了一个整体 */
        int[] i = {1,2};
        List<int[]> ints = Arrays.asList(i);
        System.out.println(ints.size()); //1

        Integer[] in = {1,2,3};
        List<Integer> list1 = Arrays.asList(in);
        System.out.println(list1.size()); //3

    }

}
