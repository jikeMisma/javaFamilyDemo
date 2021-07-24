package com.mzc.rw;

/**
 * @author MaZhiCheng
 * @date 2021/7/24 - 20:50
 * @motto 腹有诗书气自华
 * @博客地址 https://blog.csdn.net/mzc_love
 */

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ReadWriteLock
 *
 * 独占锁(写锁)  一次只能被一个线程占有
 * 共享锁(读锁)  多个线程可以同时占有
 * 三种情况
 *      读-读：可以共存
 *      读-写：不能从村
 *      写-写：不能共存
 */
public class ReadWriteLockDemo {

    public static void main(String[] args) {
        MyCatch myCatch = new MyCatch();

        //写入
        for (int i = 1; i <= 5 ; i++) {
            final  int temp = i;
            new Thread(() -> {
                myCatch.put(temp+"",temp+"");
            },String.valueOf(i)).start();
        }

        //读取
        for (int i = 1; i <= 5 ; i++) {
            final  int temp = i;
            new Thread(() -> {
                myCatch.get(temp+"");
            },String.valueOf(i)).start();
        }
    }
}

/**
 * 自定义缓存
 */

class MyCatch{

    private volatile Map<String,Object> map = new HashMap<>();
    //读写锁，更加细粒度的控制
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    //存数据，写入的时候只希望同时只有一个线程写
    public void put(String key,Object value){
        readWriteLock.writeLock().lock();

        try {
            System.out.println(Thread.currentThread().getName() + "写入" + key);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "写入OK");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }

    }

    //取操作，读
    public void get(String key){
        readWriteLock.readLock().lock();;
        try {
            System.out.println(Thread.currentThread().getName() + "读取" + key);
            Object o = map.get(key);
            System.out.println(Thread.currentThread().getName() + "读取OK");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }


}
