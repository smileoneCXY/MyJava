package com.cxy.test;

import com.cxy.dp.EnumSingleton;
import com.cxy.dp.LSingleton;

public class TestSingleon {
    public static void main(String[] args) {
        LSingleton lSingleton = LSingleton.getInstance();
        System.out.println("ls"+lSingleton.hashCode());
        System.out.println("E:  "+ EnumSingleton.INSTANCE.hashCode());
    }

}


