package com.cxy.thread;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author:chenxiaoyi
 * @Date:2019/5/5 20:05
 */

class MyData{

    volatile int number = 0;

    AtomicInteger atomicInteger = new AtomicInteger();

    public void numTo60() {
        this.number = 60;
    }

    //增加了volatile修饰 此时验证volatile不保证原子性
    public  void numPlus(){
        this.number++;
    }

    public void atomicePlus(){ this.atomicInteger.getAndIncrement(); }
}

/**
 * 1.验证volatitle的可见性
 *  1.1假如number = 0; number 变量之前根本没有添加volatile 关键字修饰 没有可见性
 *  1.2添加了volatitle可以解决可见性问题
 *
 * 2.验证volatitle不保证原子性
 *  2.1原子性指得是什么? 不可分割 完整性 即某个线程做某个业务时 不可被加塞 不可被分割 必须整体完整
 *  why 不加锁的情况出现 写值覆盖 写丢失 工作内存 -->主内存
 *  解决原子性：
 *      1.加syn
 *      2.使用juc包下的原子类变量
 */
public class Volatitle {



    public static void main(String[] args) {

        MyData myData = new MyData();
        poolAndcountDown(myData);

        newThreadFunc(myData);
        System.out.println(Thread.currentThread().getName()+"\t finally number value: "+myData.number + " atomiceInteger value: "+myData.atomicInteger);

    }

    static ExecutorService threadPool = Executors.newFixedThreadPool(20);
    static CountDownLatch countDownLatch = new CountDownLatch(20);

    private static void poolAndcountDown(MyData myData) {
        for (int i = 0; i < 20; i++) {
            threadPool.submit(() -> {
                for (int j = 0; j < 1000; j++) {
                    myData.numPlus();
                    myData.atomicePlus();
                }
            });
            countDownLatch.countDown();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadPool.shutdown();
    }

    private static void newThreadFunc(MyData myData) {
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    myData.numPlus();
                    myData.atomicePlus();
                }
            },String.valueOf(i)).start();
        }

        //需要等待上面20个线程全部计算完成后 再用main线程取得最终结果值
        while (Thread.activeCount()>2){
            Thread.yield();
        }
    }


    //volatitle保证可见性,及时通知其他线程,主物理内存的值已经被修改
    private static void seeOkByVolatitle() {
        MyData myData = new MyData(); //资源类

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t  come in---");
            try {
                TimeUnit.SECONDS.sleep(3);
                myData.numTo60();
                System.out.println(Thread.currentThread().getName()+"\t  updata number value---:"+myData.number);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"AAA").start();

        //不可见 main线程不可见AAA线程修改的number值
        while (myData.number == 0){
            //main线程循环此处 一直等待number不为0
        }
        System.out.println(Thread.currentThread().getName()+"\t  come in----,main get number value---:"+myData.number);
    }
}


