package com.mzc.unsafe;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author MaZhiCheng
 * @date 2021/7/24 - 15:44
 * @motto ����ʫ�����Ի�
 * @���͵�ַ https://blog.csdn.net/mzc_love
 */

/**
 * ͬ���֤:ConcurrentModificationException
 */
public class SetTest {

    public static void main(String[] args) {

        /**
         * ���������
         *      1. Collections.synchronizedSet(new HashSet<>());
         */
//        Set<String> set = new HashSet<>();
//        Set<String> set = Collections.synchronizedSet(new HashSet<>());
        Set<String> set = new CopyOnWriteArraySet<>();
        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 5));
                System.out.println(set);
            },String.valueOf(i)).start();
        }
    }
}
