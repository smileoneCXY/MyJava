package com.sxt.dp;
/*
饿汉式单例模式
如果调用这个对象频繁 ，简易使用
 */
public class HSingleton {
    //首先私有的构造方法
    private HSingleton(){}
    //类初始化时，立即加载这个对象(没有延时加载的优势)。加载类时，天然的线程安全的
    private static HSingleton hs = new HSingleton();
    //对外提供获取其这个类实例的方法
    //因为对象已经被生成，外部访问时获得的hs永远时同一个对象 不需要加锁 方法没有同步 效率较高
    public static /*synchronized*/ HSingleton getInstance(){
        return hs;
    }
 }
