package com.mzc.unsafe;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author MaZhiCheng
 * @date 2021/7/24 - 15:59
 * @motto ����ʫ�����Ի�
 * @���͵�ַ https://blog.csdn.net/mzc_love
 */

//ConcurrentModificationException
public class MapTest {

    public static void main(String[] args) {
        //map�������е���    ���ǣ������в������
        // Ĭ�ϵȼ���ʲô��     new HashMap<>(0.75,16);
//        Map<String, String> map = new HashMap<>();

        Map<String, String> map = new ConcurrentHashMap<>();
        /**
         * �������
         *      1.
         */

        for (int i = 1; i <= 30; i++) {
             new Thread(() -> {
                 map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0, 5));
                 System.out.println(map);
             },String.valueOf(i)).start();

        }
    }
}
