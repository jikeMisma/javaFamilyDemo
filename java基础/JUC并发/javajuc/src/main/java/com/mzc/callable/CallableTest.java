package com.mzc.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author MaZhiCheng
 * @date 2021/7/24 - 16:31
 * @motto 腹有诗书气自华
 * @博客地址 https://blog.csdn.net/mzc_love
 */
public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {


        MyThread thread = new MyThread();
        FutureTask futureTask = new FutureTask(thread); //适配类

        new Thread(futureTask,"A").start();//如何启动Callable？
        String str =(String) futureTask.get();//获取Callable的返回结果,这个get方法可能产生阻塞
        System.out.println(str);

    }
}

class MyThread implements Callable<String>{

    @Override
    public String call() throws Exception {
        System.out.println("call()");
        return "2356";
    }
}
