package com.cxy.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 * 读写锁
 * 写锁   写入时 保证原子性 一致性
 *
 * 读锁不限制
 * @Author:chenxiaoyi
 * @Date:2019/7/25 21:56
 */
class MyCaChe{

    private volatile Map<String,Object> map = new HashMap<>();

    private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    //写入操作

    void put(String key, Object value){
        rwLock.writeLock().lock();
        System.out.println(Thread.currentThread().getName()  +"正在写入");
        try {TimeUnit.MICROSECONDS.sleep(200); } catch (InterruptedException e) {e.printStackTrace();}
        map.put(key, value);
        System.out.println(Thread.currentThread().getName()+" 写入完成:"+key);
        rwLock.writeLock().unlock();

    }

    void get(String key){
        rwLock.readLock().lock();
        System.out.println(Thread.currentThread().getName()  +"正在读取");
        try {TimeUnit.MICROSECONDS.sleep(200); } catch (InterruptedException e) {e.printStackTrace();}
        Object result = map.get(key);
        System.out.println(Thread.currentThread().getName()+" 读取完成:"+result);
        rwLock.readLock().unlock();
    }



}

public class ReadWriteLock {
    public static void main(String[] args) {
        MyCaChe myCaChe = new MyCaChe();

        for (int i = 0; i < 5; i++) {
            final int temp = i;
            new Thread(()->{
                myCaChe.put(temp +"", temp +"-");
            },i+"").start();
        }

        for (int i = 0; i < 5; i++) {
            final int temp = i;
            new Thread(()->{
                myCaChe.get(temp +"");
            },i+"").start();
        }

    }
}

