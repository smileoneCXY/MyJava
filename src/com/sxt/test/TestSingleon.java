package com.sxt.test;

import com.sxt.dp.EnumSingleton;
import com.sxt.dp.LSingleton;

public class TestSingleon {
    public static void main(String[] args) {
        LSingleton lSingleton = LSingleton.getInstance();
        System.out.println("ls"+lSingleton.hashCode());
        System.out.println("E:  "+EnumSingleton.INSTANCE.hashCode());
    }
}
