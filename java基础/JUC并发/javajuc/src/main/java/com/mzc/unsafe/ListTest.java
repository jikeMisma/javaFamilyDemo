package com.mzc.unsafe;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author MaZhiCheng
 * @date 2021/7/24 - 10:56
 * @motto 腹有诗书气自华
 * @博客地址 https://blog.csdn.net/mzc_love
 */

//java.util.ConcurrentModificationException,并发修改异常
public class ListTest {

    public static void main(String[] args) {
        //并发下ArrayList是不安全的
        /**
         * 解决方案
         *      1. List<String> list = new Vector<>();
         *      2. List<String> list = Collections.synchronizedList(new ArrayList<>());
         *      3. List<String> list = new CopyOnWriteArrayList<>();
         */
        //CopyOnWriteArrayList:写入时复制， COW  计算机程序设计领域的一张优化策略
        //多个线程调用的时候，list读取时固定的，写入(覆盖)
        //在写入的时候避免覆盖造成数据问题
        //读写分离
        //CopyOnWriteArrayList 比 Vector NB 在哪里？:COW在源码Add方法中没有使用syn关键字
        List<String> list = new CopyOnWriteArrayList<>();

        for (int i = 1; i <= 10; i++) {
           new Thread(() -> {
               list.add(UUID.randomUUID().toString().substring(0, 5));
               System.out.println(list);
           },String.valueOf(i)).start();
        }
    }
}
