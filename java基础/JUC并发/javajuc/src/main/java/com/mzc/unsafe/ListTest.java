package com.mzc.unsafe;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author MaZhiCheng
 * @date 2021/7/24 - 10:56
 * @motto ����ʫ�����Ի�
 * @���͵�ַ https://blog.csdn.net/mzc_love
 */

//java.util.ConcurrentModificationException,�����޸��쳣
public class ListTest {

    public static void main(String[] args) {
        //������ArrayList�ǲ���ȫ��
        /**
         * �������
         *      1. List<String> list = new Vector<>();
         *      2. List<String> list = Collections.synchronizedList(new ArrayList<>());
         *      3. List<String> list = new CopyOnWriteArrayList<>();
         */
        //CopyOnWriteArrayList:д��ʱ���ƣ� COW  �����������������һ���Ż�����
        //����̵߳��õ�ʱ��list��ȡʱ�̶��ģ�д��(����)
        //��д���ʱ����⸲�������������
        //��д����
        //CopyOnWriteArrayList �� Vector NB �����:COW��Դ��Add������û��ʹ��syn�ؼ���
        List<String> list = new CopyOnWriteArrayList<>();

        for (int i = 1; i <= 10; i++) {
           new Thread(() -> {
               list.add(UUID.randomUUID().toString().substring(0, 5));
               System.out.println(list);
           },String.valueOf(i)).start();
        }
    }
}
