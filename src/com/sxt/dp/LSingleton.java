package com.sxt.dp;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/*
懒汉式单例模式
资源利用率高 但是每次调用getInstace方法都需要同步 并发效率较低
如果创建一个对象的代价较大，简易在调用时再创建
 */
public class LSingleton {

    private LSingleton(){}
    //类初始化时，声明这个了的实例
    private static LSingleton hs;
    //对外提供获取其这个类实例的方法
    //延迟加载 懒加载，只有被调用的时候才创建对象
    public static synchronized LSingleton getInstance(){
        if(null==hs){
            hs = new LSingleton();
        }
        return hs;
    }

    public static void main(String[] args) {
        while (true){
        int i = ThreadLocalRandom.current().nextInt(90)+10;
            Random random  = new Random();
            int i1 = random.nextInt(90) + 10;
            System.out.println(i1);
        }
    }
}
