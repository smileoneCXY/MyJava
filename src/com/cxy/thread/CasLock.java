package com.cxy.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁
 * @Author:chenxiaoyi
 * @Date:2019/7/25 21:00
 */

class MyLock{

     private AtomicReference<Thread> atomicReference = new AtomicReference<>();


      void lock(){
         Thread thread = Thread.currentThread();
         System.out.println(thread.getName()+" lock   ");
         while (!atomicReference.compareAndSet(null,thread)){
             System.out.println("lock 比较失败后一直循环");
         }
     }

      void unLock(){
         Thread thread = Thread.currentThread();
         atomicReference.compareAndSet(thread,null);
         System.out.println(thread.getName()+"unLock ");
     }

}

public class CasLock {

    public static void main(String[] args) {
        MyLock myLock = new MyLock();

        new Thread(()->{
            myLock.lock();
            try {TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) {e.printStackTrace();}
            myLock.unLock();
        },"A").start();

        try {TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) {e.printStackTrace();}

        new Thread(()->{
            myLock.lock();
            try {TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) {e.printStackTrace();}
            myLock.unLock();
        },"B").start();

    }

}
