package com.wuminghui.test01;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @autor huihui
 * @date 2020/12/11 - 16:34
 */

class User{
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
public class CASDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        System.out.println(atomicInteger.compareAndSet(5,2019)+"\t atomicInteger="+atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5,1024)+"\t atomicInteger="+atomicInteger.get());
        atomicInteger.getAndIncrement();

        System.out.println("****************************");
        User zs = new User("zs", 15);
        User ls = new User("ls", 25);
        AtomicReference<User> userAtomicReference = new AtomicReference<>();
        userAtomicReference.set(zs);
        System.out.println(userAtomicReference.compareAndSet(zs,ls)+"\t"+userAtomicReference.get().toString());
    }
}
