package com.cxy.dp;
//静态内部类单例模式

/**
 * 1.线程安全
 * 2.调用效率高
 * 3.懒加载
 */
public class InnerSingleton {

    //用静态内部类包裹外部类的实例对象 在线程加载的时候是天然的线程安全的
    private static class InnerSinlge {
        private static final InnerSingleton instance = new InnerSingleton();
    }
    //只有调用这个方法 才会去加载内部类里的实例对象
    public static InnerSingleton getInstance() {
        return InnerSinlge.instance;//这段代码才会加载静态内部类，是延时加载
    }
    private InnerSingleton() {
    }
}
