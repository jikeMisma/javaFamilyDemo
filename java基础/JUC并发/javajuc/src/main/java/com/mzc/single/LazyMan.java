package com.mzc.single;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: javajuc
 * @Package: com.mzc.single
 * @Description: note
 * @Author: mazc35591
 * @CreateDate: 2021/7/31 22:01
 * @UpdateUser: mazc35591
 * @UpdateDate: 2021/7/31 22:01
 * @UpdateRemark: The modified content
 * 编制部门 EPG 代码质量组
 * 批准日期 2020/04/07
 * 密级：内部
 * @Version: 1.0* @Version: 1.0
 * *
 * Copyright © 2021 Hundsun Technologies Inc. All Rights Reserved* Copyright © 2021 Hundsun Technologies Inc. All Rights Reserved
 **/

/*
    懒汉式
 */
public class LazyMan {

    private LazyMan(){
        System.out.println(Thread.currentThread().getName() + "ok");
    }

    private static volatile LazyMan lazyMan;


    //双重检测锁模式的 懒汉式单例 DCL懒汉式
    public  static LazyMan getInstance(){
        if(lazyMan == null){
            synchronized (LazyMan.class){
                if(lazyMan == null){
                    lazyMan = new LazyMan();//不是一个原子性操作
                    /*
                        1.分配内存空间
                        2.执行构造方法，初始化对象
                        3.将对象指向这个空间
                     */
                }
            }

        }
        return lazyMan;
    }
    //多线程并发
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                lazyMan.getInstance();
            }).start();
        }

    }
}
