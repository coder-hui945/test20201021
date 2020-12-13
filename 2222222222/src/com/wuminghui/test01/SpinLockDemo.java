package com.wuminghui.test01;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @autor huihui
 * @date 2020/12/13 - 10:19
 * 手写自旋锁。。。手写自旋锁
 * 自旋锁的好处：循环比较获取到成功为止，没有类似wait的阻塞。但是如果循环过多，资源开销可能会较大。
 * 通过CAS完成自旋锁。
 */
public class SpinLockDemo {

    //原子引用线程
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void myLock() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.currentThread().getName()+"\t come in ...");
        while (!atomicReference.compareAndSet(null,thread)){

        }
    }

    public void myUnLock() {
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread,null);
        System.out.println(thread.currentThread().getName()+"\t invoked myLock()...");
    }

    public static void main(String[] args) {

        SpinLockDemo spinLockDemo = new SpinLockDemo();
        new Thread(()->{
            spinLockDemo.myLock();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLockDemo.myUnLock();
        },"AAA").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{
            spinLockDemo.myLock();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLockDemo.myUnLock();
        },"BBB").start();
    }
}
