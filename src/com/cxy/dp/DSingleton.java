package com.cxy.dp;
/*
双重检查锁单例模式
会有点小问题不建议使用
 */
public class DSingleton {
    //首先私有的构造方法
    private DSingleton(){}

    private static DSingleton hs=null;

    public static /*synchronized*/ DSingleton getInstance(){
        if(null==hs){
            DSingleton ds;
            synchronized (DSingleton.class){
                ds = hs;
                if(null==ds){
                    synchronized (DSingleton.class){
                        ds = new DSingleton();
                    }
                }
            }
            hs = ds;
        }
        return hs;
    }
}
