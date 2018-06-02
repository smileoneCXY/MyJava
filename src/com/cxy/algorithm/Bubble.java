package com.cxy.algorithm;

import java.util.Arrays;

/**
 * 冒泡排序 相邻比较
 */
public class Bubble {
    public static void main(String[] args) {
        int[] arr = {1,23,1,23,2,2,2,3,3,4,5,56,6,6,7,8,12,12,2,3};
        int[] maoPao = maoPao(arr);
        System.out.println(Arrays.toString(maoPao));
    }
    
    public static int[] maoPao(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }
}
