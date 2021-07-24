package com.mzc.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author MaZhiCheng
 * @date 2021/7/24 - 16:31
 * @motto ����ʫ�����Ի�
 * @���͵�ַ https://blog.csdn.net/mzc_love
 */
public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {


        MyThread thread = new MyThread();
        FutureTask futureTask = new FutureTask(thread); //������

        new Thread(futureTask,"A").start();//�������Callable��
        String str =(String) futureTask.get();//��ȡCallable�ķ��ؽ��,���get�������ܲ�������
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
