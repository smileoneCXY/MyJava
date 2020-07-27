package com.cxy.test;

public class TestSingleon {

    public static void main(String[] args) {
        MyLock myLock = new MyLock();
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                myLock.lock();
                System.out.println(Thread.currentThread().getName() + "获取锁");
//                try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
                System.out.println(Thread.currentThread().getName() + "释放");
                myLock.unLock();
            },"i"+i).start();

        }

    }

}

class MyLock{

    volatile int status = 0;

    void lock(){
        while (!compareAndSet(0,1)){
//            System.out.println(Thread.currentThread().getName());
        }

    }

    private boolean compareAndSet(int i, int i1) {
        if(status == i){
            status = i1;
            return true;
        }
        return  false;
    }

    void unLock(){
        status = 0;
    }

}

