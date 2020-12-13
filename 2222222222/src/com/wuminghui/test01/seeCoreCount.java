package com.wuminghui.test01;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @autor huihui
 * @date 2020/12/13 - 15:59
 */
public class seeCoreCount {
    public static void main(String[] args) {
        //获取可用线程数
        System.out.println(Runtime.getRuntime().availableProcessors());
        Executors.newFixedThreadPool(9);
    }
}
