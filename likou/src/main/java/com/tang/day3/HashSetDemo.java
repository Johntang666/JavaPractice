package com.tang.day3;

import java.util.HashSet;
import java.util.Set;

public class HashSetDemo {
    private static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) {
        // 创建并启动多个线程
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new HashSetOperation());
            thread.start();
        }
    }

    static class HashSetOperation implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                // 向集合中添加元素
                set.add(i);
                // 从集合中移除元素
                set.remove(i - 1);
            }
            // 打印集合的内容
            System.out.println(set);
        }
    }
}