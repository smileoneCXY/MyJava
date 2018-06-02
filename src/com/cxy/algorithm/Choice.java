package com.cxy.algorithm;

import java.util.Arrays;

/**
 * 选择排序 1:所有
 */
public class Choice {
    public static void main(String[] args) {
        int[] arr = {2,1,3,2,1,4,5,1,2,3,5,2,1};
        int[] xuanZe = xuanZe(arr);
        System.out.println(Arrays.toString(xuanZe));
    }

    public static int[] xuanZe(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i]>arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
}
