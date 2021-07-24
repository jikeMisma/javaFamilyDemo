package com.mzc.rw;

/**
 * @author MaZhiCheng
 * @date 2021/7/24 - 20:50
 * @motto ����ʫ�����Ի�
 * @���͵�ַ https://blog.csdn.net/mzc_love
 */

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ReadWriteLock
 *
 * ��ռ��(д��)  һ��ֻ�ܱ�һ���߳�ռ��
 * ������(����)  ����߳̿���ͬʱռ��
 * �������
 *      ��-�������Թ���
 *      ��-д�����ܴӴ�
 *      д-д�����ܹ���
 */
public class ReadWriteLockDemo {

    public static void main(String[] args) {
        MyCatch myCatch = new MyCatch();

        //д��
        for (int i = 1; i <= 5 ; i++) {
            final  int temp = i;
            new Thread(() -> {
                myCatch.put(temp+"",temp+"");
            },String.valueOf(i)).start();
        }

        //��ȡ
        for (int i = 1; i <= 5 ; i++) {
            final  int temp = i;
            new Thread(() -> {
                myCatch.get(temp+"");
            },String.valueOf(i)).start();
        }
    }
}

/**
 * �Զ��建��
 */

class MyCatch{

    private volatile Map<String,Object> map = new HashMap<>();
    //��д��������ϸ���ȵĿ���
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    //�����ݣ�д���ʱ��ֻϣ��ͬʱֻ��һ���߳�д
    public void put(String key,Object value){
        readWriteLock.writeLock().lock();

        try {
            System.out.println(Thread.currentThread().getName() + "д��" + key);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "д��OK");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }

    }

    //ȡ��������
    public void get(String key){
        readWriteLock.readLock().lock();;
        try {
            System.out.println(Thread.currentThread().getName() + "��ȡ" + key);
            Object o = map.get(key);
            System.out.println(Thread.currentThread().getName() + "��ȡOK");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }


}
